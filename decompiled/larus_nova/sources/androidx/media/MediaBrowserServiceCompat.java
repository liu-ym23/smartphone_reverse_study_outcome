package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }

        public BrowserRoot(String r100, Bundle r101) {
            if (r100 == null) goto L7;
            this.mRootId = r100;
            this.mExtras = r101;
            return;
        L7:
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }
    }

    public class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;
        final /* synthetic */ MediaBrowserServiceCompat this$0;
        public final int uid;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mHandler.post(new AnonymousClass1(this));
        }

        public ConnectionRecord(MediaBrowserServiceCompat r100, String r101, int r102, int r103, Bundle r104, ServiceCallbacks r105) {
            this.this$0 = r100;
            this.subscriptions = new HashMap();
            this.pkg = r101;
            this.pid = r102;
            this.uid = r103;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(r101, r102, r103);
            this.rootHints = r104;
            this.callbacks = r105;
        }
    }

    public interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r100, String r101, Bundle r102);

        void notifyChildrenChanged(String r100, Bundle r101);

        IBinder onBind(Intent r100);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token r100);
    }

    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList;
        Object mServiceObj;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger != null) goto L5;
            return null;
        L5:
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L13;
            if (r100.rootHints != null) goto L11;
            return null;
        L11:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L13:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L7;
            return r100.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r100 = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
            this.mServiceObj = r100;
            MediaBrowserServiceCompatApi21.onCreate(r100);
        }

        public MediaBrowserServiceImplApi21(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
            this.mRootExtrasList = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r100) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, r100);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r100) {
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r100));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String r100, Bundle r101) {
            notifyChildrenChangedForFramework(r100, r101);
            notifyChildrenChangedForCompat(r100, r101);
        }

        public void notifyChildrenChangedForCompat(final String r100, final Bundle r101) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r100, r101));
        }

        public void notifyChildrenChangedForFramework(String r100, Bundle r101) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, r100);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(final String r100, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> r101) {
            Result<List<MediaBrowserCompat.MediaItem>> r102 = new AnonymousClass2(this, r100, r101);
            this.this$0.onLoadChildren(r100, r102);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r100, String r101, Bundle r102) {
            notifyChildrenChangedForCompat(r100, r101, r102);
        }

        public void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo r100, final String r101, final Bundle r102) {
            this.this$0.mHandler.post(new AnonymousClass4(this, r100, r101, r102));
        }

        public void notifyChildrenChangedForCompatOnHandler(ConnectionRecord r100, String r101, Bundle r102) {
            List<Pair<IBinder, Bundle>> r103 = r100.subscriptions.get(r101);
            if (r103 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r104 = r103.iterator();
        L6:
            if (r104.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r105 = r104.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r102, r105.second) == false) goto L6;
            this.this$0.performLoadChildren(r101, r100, r105.second, r102);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String r110, int r111, Bundle r112) {
            if (r112 != null) goto L5;
        L14:
            Bundle r100 = null;
        L15:
            MediaBrowserServiceCompat r101 = this.this$0;
            r101.mCurConnection = new ConnectionRecord(r101, r110, -1, r111, r112, null);
            BrowserRoot r113 = this.this$0.onGetRoot(r110, r111, r112);
            this.this$0.mCurConnection = null;
            if (r113 != null) goto L18;
            return null;
        L18:
            if (r100 != null) goto L21;
            r100 = r113.getExtras();
        L24:
            return new MediaBrowserServiceCompatApi21.BrowserRoot(r113.getRootId(), r100);
        L21:
            if (r113.getExtras() == null) goto L24;
            r100.putAll(r113.getExtras());
            goto L24
        L5:
            if (r112.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) goto L14;
            r112.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            this.mMessenger = new Messenger(this.this$0.mHandler);
            r100 = new Bundle();
            r100.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(r100, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            MediaSessionCompat.Token r102 = this.this$0.mSession;
            if (r102 == null) goto L13;
            IMediaSession r103 = r102.getExtraBinder();
            if (r103 != null) goto L11;
            IBinder r104 = null;
        L12:
            BundleCompat.putBinder(r100, MediaBrowserProtocol.EXTRA_SESSION_BINDER, r104);
            goto L15
        L11:
            r104 = r103.asBinder();
            goto L12
        L13:
            this.mRootExtrasList.add(r100);
            goto L15
        }
    }

    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r100 = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
            this.mServiceObj = r100;
            MediaBrowserServiceCompatApi21.onCreate(r100);
        }

        public MediaBrowserServiceImplApi23(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
            super(r100);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(final String r100, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r101) {
            Result<MediaBrowserCompat.MediaItem> r102 = new AnonymousClass1(this, r100, r101);
            this.this$0.onLoadItem(r100, r102);
        }
    }

    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L10;
            if (r100.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r100 = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
            this.mServiceObj = r100;
            MediaBrowserServiceCompatApi21.onCreate(r100);
        }

        public MediaBrowserServiceImplApi26(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
            super(r100);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        public void notifyChildrenChangedForFramework(String r100, Bundle r101) {
            if (r101 == null) goto L4;
            MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, r100, r101);
            return;
        L4:
            super.notifyChildrenChangedForFramework(r100, r101);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(final String r100, final MediaBrowserServiceCompatApi26.ResultWrapper r101, Bundle r102) {
            Result<List<MediaBrowserCompat.MediaItem>> r103 = new AnonymousClass1(this, r100, r101);
            this.this$0.onLoadChildren(r100, r103, r102);
        }
    }

    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L7;
            return r100.browserInfo;
        L7:
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }

        public MediaBrowserServiceImplApi28(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
            super(r100);
        }
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L10;
            if (r100.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r100 = this.this$0.mCurConnection;
            if (r100 == null) goto L7;
            return r100.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(this.this$0.mHandler);
        }

        public MediaBrowserServiceImplBase(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r100) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(r100.getAction()) == true) goto L5;
            return null;
        L5:
            return this.mMessenger.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r100) {
            this.this$0.mHandler.post(new AnonymousClass1(this, r100));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final String r100, final Bundle r101) {
            this.this$0.mHandler.post(new AnonymousClass2(this, r100, r101));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final MediaSessionManager.RemoteUserInfo r100, final String r101, final Bundle r102) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r100, r101, r102));
        }

        public void notifyChildrenChangedOnHandler(ConnectionRecord r100, String r101, Bundle r102) {
            List<Pair<IBinder, Bundle>> r103 = r100.subscriptions.get(r101);
            if (r103 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r104 = r103.iterator();
        L6:
            if (r104.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r105 = r104.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r102, r105.second) == false) goto L6;
            this.this$0.performLoadChildren(r101, r100, r105.second, r102);
            goto L6
        L16:
            return;
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        public void onResultSent(T r100) {
        }

        public void detach() {
            if (this.mDetachCalled == true) goto L15;
            if (this.mSendResultCalled == true) goto L13;
            if (this.mSendErrorCalled == true) goto L11;
            this.mDetachCalled = true;
            return;
        L11:
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
        L13:
            throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
        L15:
            throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
        }

        public boolean isDone() {
            if (this.mDetachCalled == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mSendResultCalled == true) goto L10;
            if (this.mSendErrorCalled == true) goto L10;
            return false;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public Result(Object r100) {
            this.mDebug = r100;
        }

        private void checkExtraFields(Bundle r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS) == false) goto L13;
            float r101 = r100.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
            if (r101 < (-1.0E-5f)) goto L12;
            if (r101 > 1.00001f) goto L12;
            return;
        L12:
            throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
        }

        public void onErrorSent(Bundle r100) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        public void onProgressUpdateSent(Bundle r100) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        public void sendError(Bundle r100) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendErrorCalled = true;
            onErrorSent(r100);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendProgressUpdate(Bundle r100) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            checkExtraFields(r100);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(r100);
            return;
        L9:
            throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendResult(T r100) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendResultCalled = true;
            onResultSent(r100);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void setFlags(int r100) {
            this.mFlags = r100;
        }
    }

    public class ServiceBinderImpl {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceBinderImpl(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
        }

        public void disconnect(final ServiceCallbacks r100) {
            this.this$0.mHandler.postOrRun(new AnonymousClass2(this, r100));
        }

        public void unregisterCallbacks(final ServiceCallbacks r100) {
            this.this$0.mHandler.postOrRun(new AnonymousClass7(this, r100));
        }

        public void getMediaItem(final String r100, final ResultReceiver r101, final ServiceCallbacks r102) {
            if (TextUtils.isEmpty(r100) == true) goto L8;
            if (r101 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass5(this, r102, r100, r101));
            return;
        L9:
            return;
        }

        public void removeSubscription(final String r100, final IBinder r101, final ServiceCallbacks r102) {
            this.this$0.mHandler.postOrRun(new AnonymousClass4(this, r102, r100, r101));
        }

        public void addSubscription(final String r100, final IBinder r110, final Bundle r111, final ServiceCallbacks r112) {
            this.this$0.mHandler.postOrRun(new AnonymousClass3(this, r112, r100, r110, r111));
        }

        public void search(final String r100, final Bundle r110, final ResultReceiver r111, final ServiceCallbacks r112) {
            if (TextUtils.isEmpty(r100) == true) goto L8;
            if (r111 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass8(this, r112, r100, r110, r111));
            return;
        L9:
            return;
        }

        public void sendCustomAction(final String r100, final Bundle r110, final ResultReceiver r111, final ServiceCallbacks r112) {
            if (TextUtils.isEmpty(r100) == true) goto L8;
            if (r111 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass9(this, r112, r100, r110, r111));
            return;
        L9:
            return;
        }

        public void connect(final String r110, final int r111, final int r112, final Bundle r113, final ServiceCallbacks r114) {
            if (this.this$0.isValidPackage(r110, r112) == false) goto L7;
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r114, r110, r111, r112, r113));
            return;
        L7:
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + r112 + " package=" + r110);
        }

        public void registerCallbacks(final ServiceCallbacks r110, final String r111, final int r112, final int r113, final Bundle r114) {
            this.this$0.mHandler.postOrRun(new AnonymousClass6(this, r110, r111, r112, r113, r114));
        }
    }

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String r100, MediaSessionCompat.Token r101, Bundle r102) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String r100, List<MediaBrowserCompat.MediaItem> r101, Bundle r102, Bundle r103) throws RemoteException;
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public ServiceCallbacksCompat(Messenger r100) {
            this.mCallbacks = r100;
        }

        private void sendRequest(int r100, Bundle r101) throws RemoteException {
            Message r102 = Message.obtain();
            r102.what = r100;
            r102.arg1 = 2;
            r102.setData(r101);
            this.mCallbacks.send(r102);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String r100, MediaSessionCompat.Token r101, Bundle r102) throws RemoteException {
            if (r102 != null) goto L4;
            r102 = new Bundle();
        L4:
            r102.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle r103 = new Bundle();
            r103.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r100);
            r103.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, r101);
            r103.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, r102);
            sendRequest(1, r103);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String r100, List<MediaBrowserCompat.MediaItem> r101, Bundle r102, Bundle r103) throws RemoteException {
            Bundle r104 = new Bundle();
            r104.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r100);
            r104.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r102);
            r104.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, r103);
            if (r101 != null) goto L5;
        L9:
            sendRequest(3, r104);
            return;
        L5:
            if ((r101 instanceof ArrayList) == false) goto L7;
            ArrayList<? extends Parcelable> r105 = (ArrayList) r101;
        L8:
            r104.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, r105);
            goto L9
        L7:
            r105 = new ArrayList(r101);
            goto L8
        }
    }

    public final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceHandler(MediaBrowserServiceCompat r100) {
            this.this$0 = r100;
            this.mServiceBinderImpl = new ServiceBinderImpl(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r110) {
            Bundle r100 = r110.getData();
            switch(r110.what) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L5;
                default: goto L4;
            };
        L4:
            r110.toString();
            return;
        L5:
            Bundle r101 = r100.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
            MediaSessionCompat.ensureClassLoader(r101);
            this.mServiceBinderImpl.sendCustomAction(r100.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), r101, (ResultReceiver) r100.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r110.replyTo));
            return;
        L6:
            Bundle r102 = r100.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
            MediaSessionCompat.ensureClassLoader(r102);
            this.mServiceBinderImpl.search(r100.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), r102, (ResultReceiver) r100.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r110.replyTo));
            return;
        L7:
            this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(r110.replyTo));
            return;
        L8:
            Bundle r103 = r100.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.ensureClassLoader(r103);
            this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(r110.replyTo), r100.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r100.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r100.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r103);
            return;
        L9:
            this.mServiceBinderImpl.getMediaItem(r100.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) r100.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r110.replyTo));
            return;
        L10:
            this.mServiceBinderImpl.removeSubscription(r100.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r100, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(r110.replyTo));
            return;
        L11:
            Bundle r104 = r100.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
            MediaSessionCompat.ensureClassLoader(r104);
            this.mServiceBinderImpl.addSubscription(r100.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r100, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), r104, new ServiceCallbacksCompat(r110.replyTo));
            return;
        L12:
            this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(r110.replyTo));
            return;
        L13:
            Bundle r105 = r100.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.ensureClassLoader(r105);
            this.mServiceBinderImpl.connect(r100.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r100.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r100.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r105, new ServiceCallbacksCompat(r110.replyTo));
        }

        public void postOrRun(Runnable r100) {
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(getLooper())) goto L5;
            r100.run();
            return;
        L5:
            post(r100);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r100, long r101) {
            Bundle r102 = r100.getData();
            r102.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            r102.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            r102.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(r100, r101);
        }
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r100, PrintWriter r101, String[] r102) {
    }

    public abstract BrowserRoot onGetRoot(String r100, int r101, Bundle r102);

    public abstract void onLoadChildren(String r100, Result<List<MediaBrowserCompat.MediaItem>> r101);

    public void onSubscribe(String r100, Bundle r101) {
    }

    public void onUnsubscribe(String r100) {
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 28) goto L6;
        this.mImpl = new MediaBrowserServiceImplApi28(this);
    L12:
        this.mImpl.onCreate();
        return;
    L6:
        if (r100 < 26) goto L9;
        this.mImpl = new MediaBrowserServiceImplApi26(this);
        goto L12
    L9:
        if (r100 < 23) goto L11;
        this.mImpl = new MediaBrowserServiceImplApi23(this);
        goto L12
    L11:
        this.mImpl = new MediaBrowserServiceImplApi21(this);
        goto L12
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public void attachToBaseContext(Context r100) {
        attachBaseContext(r100);
    }

    public void notifyChildrenChanged(String r100) {
        if (r100 == null) goto L6;
        this.mImpl.notifyChildrenChanged(r100, null);
        return;
    L6:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.mImpl.onBind(r100);
    }

    public void setSessionToken(MediaSessionCompat.Token r100) {
        if (r100 == null) goto L10;
        if (this.mSession != null) goto L8;
        this.mSession = r100;
        this.mImpl.setSessionToken(r100);
        return;
    L8:
        throw new IllegalStateException("The session token has already been set.");
    L10:
        throw new IllegalArgumentException("Session token may not be null.");
    }

    public List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> r100, Bundle r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r101.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int r103 = r101.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (r102 != (-1)) goto L9;
        if (r103 != (-1)) goto L9;
        return r100;
    L9:
        int r104 = r103 * r102;
        int r105 = r104 + r103;
        if (r102 < 0) goto L22;
        if (r103 < 1) goto L22;
        if (r104 >= r100.size()) goto L22;
        if (r105 <= r100.size()) goto L20;
        r105 = r100.size();
    L20:
        return r100.subList(r104, r105);
    L22:
        return Collections.emptyList();
    }

    public boolean isValidPackage(String r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String[] r102 = getPackageManager().getPackagesForUid(r101);
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        if (r102[r104].equals(r100) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void notifyChildrenChanged(String r100, Bundle r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L7;
        this.mImpl.notifyChildrenChanged(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L9:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void onLoadItem(String r100, Result<MediaBrowserCompat.MediaItem> r101) {
        r101.setFlags(2);
        r101.sendResult(null);
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r100, String r101, Bundle r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.mImpl.notifyChildrenChanged(r100, r101, r102);
        return;
    L8:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L10:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    L12:
        throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    }

    public void onCustomAction(String r100, Bundle r101, Result<Bundle> r102) {
        r102.sendError(null);
    }

    public void onLoadChildren(String r100, Result<List<MediaBrowserCompat.MediaItem>> r101, Bundle r102) {
        r101.setFlags(1);
        onLoadChildren(r100, r101);
    }

    public void onSearch(String r100, Bundle r101, Result<List<MediaBrowserCompat.MediaItem>> r102) {
        r102.setFlags(4);
        r102.sendResult(null);
    }

    public void performLoadItem(final String r100, ConnectionRecord r101, final ResultReceiver r102) {
        Result<MediaBrowserCompat.MediaItem> r103 = new AnonymousClass2(this, r100, r102);
        this.mCurConnection = r101;
        onLoadItem(r100, r103);
        this.mCurConnection = null;
        if (r103.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + r100);
    }

    public boolean removeSubscription(String r100, ConnectionRecord r101, IBinder r102) {
        boolean r103 = true;
        boolean r104 = false;
        if (r102 == null) goto L5;
        List<Pair<IBinder, Bundle>> r105 = r101.subscriptions.get(r100);     // Catch: Throwable -> L23
        if (r105 == null) goto L21;
        Iterator<Pair<IBinder, Bundle>> r106 = r105.iterator();     // Catch: Throwable -> L23
    L14:
        if (r106.hasNext() == false) goto L19;
        if (r102 != r106.next().first) goto L14;
        r106.remove();     // Catch: Throwable -> L23
        r104 = true;
        goto L14
    L19:
        if (r105.size() != 0) goto L21;
        r101.subscriptions.remove(r100);     // Catch: Throwable -> L23
    L21:
        this.mCurConnection = r101;
        onUnsubscribe(r100);
        this.mCurConnection = null;
        return r104;
    L5:
        if (r101.subscriptions.remove(r100) != null) goto L8;
        r103 = false;
    L8:
        this.mCurConnection = r101;
        onUnsubscribe(r100);
        this.mCurConnection = null;
        return r103;
    L23:
        th = move-exception;
        this.mCurConnection = r101;
        onUnsubscribe(r100);
        this.mCurConnection = null;
        throw th;
    }

    public void addSubscription(String r100, ConnectionRecord r101, IBinder r102, Bundle r103) {
        List<Pair<IBinder, Bundle>> r104 = r101.subscriptions.get(r100);
        if (r104 != null) goto L5;
        r104 = new ArrayList();
    L5:
        Iterator<Pair<IBinder, Bundle>> r105 = r104.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        Pair<IBinder, Bundle> r106 = r105.next();
        if (r102 != r106.first) goto L7;
        if (MediaBrowserCompatUtils.areSameOptions(r103, r106.second) == false) goto L7;
        return;
    L13:
        r104.add(new Pair(r102, r103));
        r101.subscriptions.put(r100, r104);
        performLoadChildren(r100, r101, r103, null);
        this.mCurConnection = r101;
        onSubscribe(r100, r103);
        this.mCurConnection = null;
    }

    public void performCustomAction(final String r100, Bundle r101, ConnectionRecord r102, final ResultReceiver r103) {
        Result<Bundle> r104 = new AnonymousClass4(this, r100, r103);
        this.mCurConnection = r102;
        onCustomAction(r100, r101, r104);
        this.mCurConnection = null;
        if (r104.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r100 + " extras=" + r101);
    }

    public void performLoadChildren(final String r100, final ConnectionRecord r110, final Bundle r111, final Bundle r112) {
        Result<List<MediaBrowserCompat.MediaItem>> r101 = new AnonymousClass1(this, r100, r110, r100, r111, r112);
        this.mCurConnection = r110;
        if (r111 != null) goto L5;
        onLoadChildren(r100, r101);
    L6:
        this.mCurConnection = null;
        if (r101.isDone() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + r110.pkg + " id=" + r100);
    L5:
        onLoadChildren(r100, r101, r111);
        goto L6
    }

    public void performSearch(final String r100, Bundle r101, ConnectionRecord r102, final ResultReceiver r103) {
        Result<List<MediaBrowserCompat.MediaItem>> r104 = new AnonymousClass3(this, r100, r103);
        this.mCurConnection = r102;
        onSearch(r100, r101, r104);
        this.mCurConnection = null;
        if (r104.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + r100);
    }
}
