package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
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
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = false;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl r100) {
            this.mCallbackImplRef = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r110) {
            WeakReference<Messenger> r100 = this.mCallbacksMessengerRef;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.get() != null) goto L7;
            return;
        L7:
            if (this.mCallbackImplRef.get() == null) goto L33;
            Bundle r101 = r110.getData();
            MediaSessionCompat.ensureClassLoader(r101);
            MediaBrowserServiceCallbackImpl r102 = this.mCallbackImplRef.get();
            Messenger r103 = this.mCallbacksMessengerRef.get();
            int r104 = r110.what;     // Catch: BadParcelableException -> L22
            if (r104 != 1) goto L14;
            Bundle r105 = r101.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r105);     // Catch: BadParcelableException -> L22
            r102.onServiceConnected(r103, r101.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) r101.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), r105);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r104 != 2) goto L16;
            r102.onConnectionFailed(r103);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r104 == 3) goto L18;
            r110.toString();     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r106 = r101.getBundle(MediaBrowserProtocol.DATA_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r106);     // Catch: BadParcelableException -> L22
            Bundle r107 = r101.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r107);     // Catch: BadParcelableException -> L22
            r102.onLoadChildren(r103, r101.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), r101.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), r106, r107);     // Catch: BadParcelableException -> L22
        L23:
            if (r110.what != 1) goto L32;
            r102.onConnectionFailed(r103);
            return;
        L32:
            return;
        }

        public void setCallbacksMessenger(Messenger r100) {
            this.mCallbacksMessengerRef = new WeakReference(r100);
        }
    }

    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            final /* synthetic */ ConnectionCallback this$0;

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal r100 = this.this$0.mConnectionCallbackInternal;
                if (r100 == null) goto L5;
                r100.onConnected();
            L5:
                this.this$0.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal r100 = this.this$0.mConnectionCallbackInternal;
                if (r100 == null) goto L5;
                r100.onConnectionFailed();
            L5:
                this.this$0.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal r100 = this.this$0.mConnectionCallbackInternal;
                if (r100 == null) goto L5;
                r100.onConnectionSuspended();
            L5:
                this.this$0.onConnectionSuspended();
            }

            public StubApi21(ConnectionCallback r100) {
                this.this$0 = r100;
            }
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public ConnectionCallback() {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this));
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal r100) {
            this.mConnectionCallbackInternal = r100;
        }
    }

    public static abstract class CustomActionCallback {
        public CustomActionCallback() {
        }

        public void onError(String r100, Bundle r101, Bundle r102) {
        }

        public void onProgressUpdate(String r100, Bundle r101, Bundle r102) {
        }

        public void onResult(String r100, Bundle r101, Bundle r102) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r100, Bundle r101) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.ensureClassLoader(r101);
            if (r100 == (-1)) goto L13;
            if (r100 != 0) goto L9;
            this.mCallback.onResult(this.mAction, this.mExtras, r101);
            return;
        L9:
            if (r100 == 1) goto L11;
            Objects.toString(this.mExtras);
            Objects.toString(r101);
            return;
        L11:
            this.mCallback.onProgressUpdate(this.mAction, this.mExtras, r101);
            return;
        L13:
            this.mCallback.onError(this.mAction, this.mExtras, r101);
        }

        public CustomActionResultReceiver(String r100, Bundle r101, CustomActionCallback r102, Handler r103) {
            super(r103);
            this.mAction = r100;
            this.mExtras = r101;
            this.mCallback = r102;
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        public class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            final /* synthetic */ ItemCallback this$0;

            public StubApi23(ItemCallback r100) {
                this.this$0 = r100;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(String r100) {
                this.this$0.onError(r100);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(Parcel r100) {
                if (r100 != null) goto L4;
                this.this$0.onItemLoaded(null);
                return;
            L4:
                r100.setDataPosition(0);
                MediaItem r101 = MediaItem.CREATOR.createFromParcel(r100);
                r100.recycle();
                this.this$0.onItemLoaded(r101);
            }
        }

        public void onError(String r100) {
        }

        public void onItemLoaded(MediaItem r100) {
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(this));
            return;
        L5:
            this.mItemCallbackObj = null;
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            if (r100 != 0) goto L16;
            if (r101 == null) goto L16;
            if (r101.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L16;
            Parcelable r102 = r101.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r102 != null) goto L11;
        L14:
            this.mCallback.onItemLoaded((MediaItem) r102);
            return;
        L11:
            if ((r102 instanceof MediaItem) == true) goto L14;
            this.mCallback.onError(this.mMediaId);
            return;
        L16:
            this.mCallback.onError(this.mMediaId);
        }

        public ItemReceiver(String r100, ItemCallback r101, Handler r102) {
            super(r102);
            this.mMediaId = r100;
            this.mCallback = r101;
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String r100, ItemCallback r101);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String r100, Bundle r101, SearchCallback r102);

        void sendCustomAction(String r100, Bundle r101, CustomActionCallback r102);

        void subscribe(String r100, Bundle r101, SubscriptionCallback r102);

        void unsubscribe(String r100, SubscriptionCallback r101);
    }

    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        private final ArrayMap<String, Subscription> mSubscriptions;

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r100) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r100, String r101, MediaSessionCompat.Token r102, Bundle r103) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            ServiceBinderWrapper r100 = this.mServiceBinderWrapper;
            if (r100 == null) goto L7;
            Messenger r101 = this.mCallbacksMessenger;
            if (r101 == null) goto L7;
            r100.unregisterCallbackMessenger(r101);     // Catch: RemoteException -> L9
        L7:
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken != null) goto L6;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
        L6:
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Bundle r100 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (r100 != null) goto L5;
            return;
        L5:
            this.mServiceVersion = r100.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder r101 = BundleCompat.getBinder(r100, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (r101 == null) goto L11;
            this.mServiceBinderWrapper = new ServiceBinderWrapper(r101, this.mRootHints);
            this.mCallbacksMessenger = new Messenger(this.mHandler);
            this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);     // Catch: RemoteException -> L10
        L11:
            IMediaSession r102 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r100, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (r102 == null) goto L17;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), r102);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String r100, final ItemCallback r101) {
            if (TextUtils.isEmpty(r100) == true) goto L21;
            if (r101 == null) goto L19;
            if (MediaBrowserCompatApi21.isConnected(this.mBrowserObj) == true) goto L10;
            this.mHandler.post(new AnonymousClass1(this, r101, r100));
            return;
        L10:
            if (this.mServiceBinderWrapper != null) goto L13;
            this.mHandler.post(new AnonymousClass2(this, r101, r100));
            return;
        L13:
            ItemReceiver r102 = new ItemReceiver(r100, r101, this.mHandler);
            this.mServiceBinderWrapper.getMediaItem(r100, r102, this.mCallbacksMessenger);     // Catch: RemoteException -> L16
            return;
        L16:
            this.mHandler.post(new AnonymousClass3(this, r101, r100));
            return;
        L19:
            throw new IllegalArgumentException("cb is null");
        L21:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r100, SubscriptionCallback r101) {
            Subscription r102 = this.mSubscriptions.get(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            ServiceBinderWrapper r103 = this.mServiceBinderWrapper;
            if (r103 != null) goto L32;
            if (r101 != null) goto L9;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r100);
        L28:
            if (r102.isEmpty() == true) goto L30;
            if (r101 == null) goto L30;
            return;
        L30:
            this.mSubscriptions.remove(r100);
            return;
        L9:
            List<SubscriptionCallback> r104 = r102.getCallbacks();
            List<Bundle> r105 = r102.getOptionsList();
            int r106 = r104.size() - 1;
        L10:
            if (r106 < 0) goto L16;
            if (ListProtector.get(r104, r106) != r101) goto L14;
            ListProtector.remove(r104, r106);
            ListProtector.remove(r105, r106);
        L14:
            r106 = r106 - 1;
            goto L10
        L16:
            if (r104.size() != 0) goto L28;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r100);
            goto L28
        L32:
            if (r101 != null) goto L20;
            r103.removeSubscription(r100, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            goto L28
        L20:
            List<SubscriptionCallback> r107 = r102.getCallbacks();     // Catch: RemoteException -> L26
            List<Bundle> r108 = r102.getOptionsList();     // Catch: RemoteException -> L26
            int r109 = r107.size() - 1;     // Catch: RemoteException -> L26
        L21:
            if (r109 < 0) goto L28;
            if (ListProtector.get(r107, r109) != r101) goto L25;
            this.mServiceBinderWrapper.removeSubscription(r100, r101.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            ListProtector.remove(r107, r109);     // Catch: RemoteException -> L26
            ListProtector.remove(r108, r109);     // Catch: RemoteException -> L26
        L25:
            r109 = r109 - 1;
            goto L21
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String r100, final Bundle r101, final SearchCallback r102) {
            if (isConnected() == false) goto L14;
            if (this.mServiceBinderWrapper != null) goto L8;
            this.mHandler.post(new AnonymousClass4(this, r102, r100, r101));
            return;
        L8:
            SearchResultReceiver r103 = new SearchResultReceiver(r100, r101, r102, this.mHandler);
            this.mServiceBinderWrapper.search(r100, r101, r103, this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            this.mHandler.post(new AnonymousClass5(this, r102, r100, r101));
            return;
        L14:
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String r100, final Bundle r101, final CustomActionCallback r102) {
            if (isConnected() == false) goto L16;
            if (this.mServiceBinderWrapper != null) goto L17;
            if (r102 == null) goto L17;
            this.mHandler.post(new AnonymousClass6(this, r102, r100, r101));
        L17:
            this.mServiceBinderWrapper.sendCustomAction(r100, r101, new CustomActionResultReceiver(r100, r101, r102, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            Objects.toString(r101);
            if (r102 == null) goto L19;
            this.mHandler.post(new AnonymousClass7(this, r102, r100, r101));
            return;
        L19:
            return;
        L16:
            throw new IllegalStateException("Cannot send a custom action (" + r100 + ") with extras " + r101 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r100, Bundle r101, SubscriptionCallback r102) {
            Subscription r103 = this.mSubscriptions.get(r100);
            if (r103 != null) goto L5;
            r103 = new Subscription();
            this.mSubscriptions.put(r100, r103);
        L5:
            r102.setSubscription(r103);
            if (r101 != null) goto L8;
            Bundle r104 = null;
        L9:
            r103.putCallback(r104, r102);
            ServiceBinderWrapper r105 = this.mServiceBinderWrapper;
            if (r105 != null) goto L16;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r100, r102.mSubscriptionCallbackObj);
            return;
        L16:
            r105.addSubscription(r100, r102.mToken, r104, this.mCallbacksMessenger);     // Catch: RemoteException -> L14
            return;
        L15:
            return;
        L8:
            r104 = new Bundle(r101);
            goto L9
        }

        public MediaBrowserImplApi21(Context r100, ComponentName r101, ConnectionCallback r102, Bundle r103) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = r100;
            if (r103 == null) goto L5;
            Bundle r104 = new Bundle(r103);
        L6:
            this.mRootHints = r104;
            r104.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            r102.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(r100, r101, r102.mConnectionCallbackObj, r104);
            return;
        L5:
            r104 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r100, String r101, List r102, Bundle r103, Bundle r104) {
            if (this.mCallbacksMessenger == r100) goto L5;
            return;
        L5:
            Subscription r105 = this.mSubscriptions.get(r101);
            if (r105 == null) goto L8;
            SubscriptionCallback r106 = r105.getCallback(r103);
            if (r106 != null) goto L14;
            return;
        L14:
            if (r103 != null) goto L18;
            if (r102 != null) goto L17;
            r106.onError(r101);
            return;
        L17:
            this.mNotifyChildrenChangedOptions = r104;
            r106.onChildrenLoaded(r101, r102);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L18:
            if (r102 != null) goto L20;
            r106.onError(r101, r103);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r104;
            r106.onChildrenLoaded(r101, r102, r103);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L8:
            if (MediaBrowserCompat.DEBUG == true) goto L10;
            return;
        }
    }

    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String r100, ItemCallback r101) {
            if (this.mServiceBinderWrapper != null) goto L5;
            MediaBrowserCompatApi23.getItem(this.mBrowserObj, r100, r101.mItemCallbackObj);
            return;
        L5:
            super.getItem(r100, r101);
        }

        public MediaBrowserImplApi23(Context r100, ComponentName r101, ConnectionCallback r102, Bundle r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r100, SubscriptionCallback r101) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r101 != null) goto L10;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r100);
            return;
        L10:
            MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, r100, r101.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.unsubscribe(r100, r101);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r100, Bundle r101, SubscriptionCallback r102) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r101 != null) goto L10;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r100, r102.mSubscriptionCallbackObj);
            return;
        L10:
            MediaBrowserCompatApi26.subscribe(this.mBrowserObj, r100, r101, r102.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.subscribe(r100, r101, r102);
        }

        public MediaBrowserImplApi26(Context r100, ComponentName r101, ConnectionCallback r102, Bundle r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final ArrayMap<String, Subscription> mSubscriptions;

        public class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            public MediaServiceConnection(MediaBrowserImplBase r100) {
                this.this$0 = r100;
            }

            private void postOrRun(Runnable r100) {
                if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.this$0.mHandler.getLooper())) goto L5;
                r100.run();
                return;
            L5:
                this.this$0.mHandler.post(r100);
            }

            public boolean isCurrent(String r100) {
                MediaBrowserImplBase r101 = this.this$0;
                if (r101.mServiceConnection != this) goto L9;
                int r102 = r101.mState;
                if (r102 == 0) goto L9;
                if (r102 == 1) goto L9;
                return true;
            L9:
                int r103 = r101.mState;
                if (r103 == 0) goto L15;
                if (r103 == 1) goto L16;
                Objects.toString(r101.mServiceComponent);
                Objects.toString(this.this$0.mServiceConnection);
                toString();
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r100) {
                postOrRun(new AnonymousClass2(this, r100));
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r100, final IBinder r101) {
                postOrRun(new AnonymousClass1(this, r100, r101));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new AnonymousClass2(this));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int r100 = this.mState;
            if (r100 != 0) goto L5;
        L9:
            this.mState = 2;
            this.mHandler.post(new AnonymousClass1(this));
            return;
        L5:
            if (r100 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
        }

        public void dump() {
            Objects.toString(this.mServiceComponent);
            Objects.toString(this.mCallback);
            Objects.toString(this.mRootHints);
            getStateLabel(this.mState);
            Objects.toString(this.mServiceConnection);
            Objects.toString(this.mServiceBinderWrapper);
            Objects.toString(this.mCallbacksMessenger);
            Objects.toString(this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection r100 = this.mServiceConnection;
            if (r100 == null) goto L5;
            this.mContext.unbindService(r100);
        L5:
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            if (this.mState != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            if (isConnected() == false) goto L7;
            return this.mExtras;
        L7:
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            if (isConnected() == false) goto L7;
            return this.mRootId;
        L7:
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            if (isConnected() == false) goto L7;
            return this.mServiceComponent;
        L7:
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected() == false) goto L7;
            return this.mMediaSessionToken;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        private static String getStateLabel(int r100) {
            if (r100 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r100 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r100 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r100 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r100 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r100;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r100) {
            Objects.toString(this.mServiceComponent);
            if (isCurrent(r100, "onConnectFailed") == true) goto L5;
            return;
        L5:
            int r101 = this.mState;
            if (r101 == 2) goto L9;
            getStateLabel(r101);
            return;
        L9:
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        private boolean isCurrent(Messenger r100, String r101) {
            if (this.mCallbacksMessenger != r100) goto L9;
            int r102 = this.mState;
            if (r102 == 0) goto L9;
            if (r102 == 1) goto L9;
            return true;
        L9:
            int r103 = this.mState;
            if (r103 == 0) goto L15;
            if (r103 == 1) goto L16;
            Objects.toString(this.mServiceComponent);
            Objects.toString(this.mCallbacksMessenger);
            toString();
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String r100, final ItemCallback r101) {
            if (TextUtils.isEmpty(r100) == true) goto L17;
            if (r101 == null) goto L15;
            if (isConnected() == true) goto L9;
            this.mHandler.post(new AnonymousClass3(this, r101, r100));
            return;
        L9:
            ItemReceiver r102 = new ItemReceiver(r100, r101, this.mHandler);
            this.mServiceBinderWrapper.getMediaItem(r100, r102, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            this.mHandler.post(new AnonymousClass4(this, r101, r100));
            return;
        L15:
            throw new IllegalArgumentException("cb is null");
        L17:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r100, SubscriptionCallback r101) {
            Subscription r102 = this.mSubscriptions.get(r100);
            if (r102 != null) goto L24;
            return;
        L24:
            if (r101 == null) goto L7;
            List<SubscriptionCallback> r103 = r102.getCallbacks();     // Catch: RemoteException -> L18
            List<Bundle> r104 = r102.getOptionsList();     // Catch: RemoteException -> L18
            int r105 = r103.size() - 1;     // Catch: RemoteException -> L18
        L10:
            if (r105 < 0) goto L20;
            if (ListProtector.get(r103, r105) != r101) goto L17;
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.removeSubscription(r100, r101.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L16:
            ListProtector.remove(r103, r105);     // Catch: RemoteException -> L18
            ListProtector.remove(r104, r105);     // Catch: RemoteException -> L18
        L17:
            r105 = r105 - 1;
            goto L10
        L7:
            if (isConnected() == false) goto L20;
            this.mServiceBinderWrapper.removeSubscription(r100, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L20:
            if (r102.isEmpty() == true) goto L22;
            if (r101 == null) goto L22;
            return;
        L22:
            this.mSubscriptions.remove(r100);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String r100, final Bundle r101, final SearchCallback r102) {
            if (isConnected() == false) goto L10;
            this.mServiceBinderWrapper.search(r100, r101, new SearchResultReceiver(r100, r101, r102, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            this.mHandler.post(new AnonymousClass5(this, r102, r100, r101));
            return;
        L10:
            throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String r100, final Bundle r101, final CustomActionCallback r102) {
            if (isConnected() == false) goto L12;
            this.mServiceBinderWrapper.sendCustomAction(r100, r101, new CustomActionResultReceiver(r100, r101, r102, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            Objects.toString(r101);
            if (r102 == null) goto L15;
            this.mHandler.post(new AnonymousClass6(this, r102, r100, r101));
            return;
        L15:
            return;
        L12:
            throw new IllegalStateException("Cannot send a custom action (" + r100 + ") with extras " + r101 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r100, Bundle r101, SubscriptionCallback r102) {
            Subscription r103 = this.mSubscriptions.get(r100);
            if (r103 != null) goto L5;
            r103 = new Subscription();
            this.mSubscriptions.put(r100, r103);
        L5:
            if (r101 != null) goto L7;
            Bundle r104 = null;
        L8:
            r103.putCallback(r104, r102);
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.addSubscription(r100, r102.mToken, r104, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L13:
            return;
        L16:
            return;
        L7:
            r104 = new Bundle(r101);
            goto L8
        }

        public MediaBrowserImplBase(Context r100, ComponentName r101, ConnectionCallback r102, Bundle r103) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if (r100 == null) goto L17;
            if (r101 == null) goto L15;
            if (r102 == null) goto L13;
            this.mContext = r100;
            this.mServiceComponent = r101;
            this.mCallback = r102;
            if (r103 != null) goto L9;
            Bundle r104 = null;
        L10:
            this.mRootHints = r104;
            return;
        L9:
            r104 = new Bundle(r103);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r100, String r101, MediaSessionCompat.Token r102, Bundle r103) {
            if (isCurrent(r100, "onConnect") == true) goto L5;
            return;
        L5:
            int r104 = this.mState;
            if (r104 == 2) goto L9;
            getStateLabel(r104);
            return;
        L9:
            this.mRootId = r101;
            this.mMediaSessionToken = r102;
            this.mExtras = r103;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG == false) goto L12;
            dump();
        L12:
            this.mCallback.onConnected();
            Iterator<Map.Entry<String, Subscription>> r105 = this.mSubscriptions.entrySet().iterator();     // Catch: RemoteException -> L22
        L15:
            if (r105.hasNext() == false) goto L27;
            Map.Entry<String, Subscription> r106 = r105.next();     // Catch: RemoteException -> L22
            String r107 = r106.getKey();     // Catch: RemoteException -> L22
            Subscription r108 = r106.getValue();     // Catch: RemoteException -> L22
            List<SubscriptionCallback> r109 = r108.getCallbacks();     // Catch: RemoteException -> L22
            List<Bundle> r110 = r108.getOptionsList();     // Catch: RemoteException -> L22
            int r111 = 0;
        L18:
            if (r111 >= r109.size()) goto L15;
            this.mServiceBinderWrapper.addSubscription(r107, ((SubscriptionCallback) ListProtector.get(r109, r111)).mToken, (Bundle) ListProtector.get(r110, r111), this.mCallbacksMessenger);     // Catch: RemoteException -> L22
            r111 = r111 + 1;
            goto L18
        L27:
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r100, String r101, List r102, Bundle r103, Bundle r104) {
            if (isCurrent(r100, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r105 = MediaBrowserCompat.DEBUG;
            if (r105 == false) goto L8;
            Objects.toString(this.mServiceComponent);
        L8:
            Subscription r106 = this.mSubscriptions.get(r101);
            if (r106 != null) goto L13;
            if (r105 == true) goto L12;
            return;
        L12:
            return;
        L13:
            SubscriptionCallback r107 = r106.getCallback(r103);
            if (r107 != null) goto L16;
            return;
        L16:
            if (r103 != null) goto L20;
            if (r102 != null) goto L19;
            r107.onError(r101);
            return;
        L19:
            this.mNotifyChildrenChangedOptions = r104;
            r107.onChildrenLoaded(r101, r102);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L20:
            if (r102 != null) goto L22;
            r107.onError(r101, r103);
            return;
        L22:
            this.mNotifyChildrenChangedOptions = r104;
            r107.onChildrenLoaded(r101, r102, r103);
            this.mNotifyChildrenChangedOptions = null;
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger r100);

        void onLoadChildren(Messenger r100, String r101, List r102, Bundle r103, Bundle r104);

        void onServiceConnected(Messenger r100, String r101, MediaSessionCompat.Token r102, Bundle r103);
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPlayable() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public MediaItem(Parcel r100) {
            this.mFlags = r100.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r100);
        }

        public static MediaItem fromMediaItem(Object r100) {
            if (r100 == null) goto L5;
            int r101 = MediaBrowserCompatApi21.MediaItem.getFlags(r100);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(r100)), r101);
        L5:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r100) {
            if (r100 == null) goto L8;
            ArrayList r101 = new ArrayList(r100.size());
            Iterator<?> r102 = r100.iterator();
        L5:
            if (r102.hasNext() == false) goto L7;
            r101.add(fromMediaItem(r102.next()));
            goto L5
        L7:
            return r101;
        L8:
            return null;
        }

        public MediaItem(MediaDescriptionCompat r100, int r101) {
            if (r100 == null) goto L11;
            if (TextUtils.isEmpty(r100.getMediaId()) == true) goto L9;
            this.mFlags = r101;
            this.mDescription = r100;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r100, r101);
        }
    }

    public static abstract class SearchCallback {
        public SearchCallback() {
        }

        public void onError(String r100, Bundle r101) {
        }

        public void onSearchResult(String r100, Bundle r101, List<MediaItem> r102) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            if (r100 != 0) goto L16;
            if (r101 == null) goto L16;
            if (r101.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L16;
            Parcelable[] r102 = r101.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (r102 == null) goto L13;
            ArrayList r103 = new ArrayList();
            int r104 = r102.length;
            int r105 = 0;
        L11:
            if (r105 >= r104) goto L14;
            r103.add((MediaItem) r102[r105]);
            r105 = r105 + 1;
        L14:
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, r103);
            return;
        L13:
            r103 = null;
        L16:
            this.mCallback.onError(this.mQuery, this.mExtras);
        }

        public SearchResultReceiver(String r100, Bundle r101, SearchCallback r102, Handler r103) {
            super(r103);
            this.mQuery = r100;
            this.mExtras = r101;
            this.mCallback = r102;
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public void disconnect(Messenger r100) throws RemoteException {
            sendRequest(2, null, r100);
        }

        public void unregisterCallbackMessenger(Messenger r100) throws RemoteException {
            sendRequest(7, null, r100);
        }

        public ServiceBinderWrapper(IBinder r100, Bundle r101) {
            this.mMessenger = new Messenger(r100);
            this.mRootHints = r101;
        }

        public void connect(Context r100, Messenger r101) throws RemoteException {
            Bundle r102 = new Bundle();
            r102.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r100.getPackageName());
            r102.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, r102, r101);
        }

        public void registerCallbackMessenger(Context r100, Messenger r101) throws RemoteException {
            Bundle r102 = new Bundle();
            r102.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r100.getPackageName());
            r102.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, r102, r101);
        }

        private void sendRequest(int r100, Bundle r101, Messenger r102) throws RemoteException {
            Message r103 = Message.obtain();
            r103.what = r100;
            r103.arg1 = 1;
            r103.setData(r101);
            r103.replyTo = r102;
            this.mMessenger.send(r103);
        }

        public void getMediaItem(String r100, ResultReceiver r101, Messenger r102) throws RemoteException {
            Bundle r103 = new Bundle();
            r103.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r100);
            r103.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r101);
            sendRequest(5, r103, r102);
        }

        public void removeSubscription(String r100, IBinder r101, Messenger r102) throws RemoteException {
            Bundle r103 = new Bundle();
            r103.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r100);
            BundleCompat.putBinder(r103, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r101);
            sendRequest(4, r103, r102);
        }

        public void addSubscription(String r100, IBinder r101, Bundle r102, Messenger r103) throws RemoteException {
            Bundle r104 = new Bundle();
            r104.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r100);
            BundleCompat.putBinder(r104, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r101);
            r104.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r102);
            sendRequest(3, r104, r103);
        }

        public void search(String r100, Bundle r101, ResultReceiver r102, Messenger r103) throws RemoteException {
            Bundle r104 = new Bundle();
            r104.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, r100);
            r104.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, r101);
            r104.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r102);
            sendRequest(8, r104, r103);
        }

        public void sendCustomAction(String r100, Bundle r101, ResultReceiver r102, Messenger r103) throws RemoteException {
            Bundle r104 = new Bundle();
            r104.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, r100);
            r104.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, r101);
            r104.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r102);
            sendRequest(9, r104, r103);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks;
        private final List<Bundle> mOptionsList;

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public Subscription() {
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public SubscriptionCallback getCallback(Bundle r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions((Bundle) ListProtector.get(this.mOptionsList, r101), r100) == true) goto L8;
            r101 = r101 + 1;
            goto L4
        L8:
            return (SubscriptionCallback) ListProtector.get(this.mCallbacks, r101);
        L10:
            return null;
        }

        public void putCallback(Bundle r100, SubscriptionCallback r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions((Bundle) ListProtector.get(this.mOptionsList, r102), r100) == true) goto L7;
            r102 = r102 + 1;
            goto L4
        L7:
            ListProtector.set(this.mCallbacks, r102, r101);
            return;
        L10:
            this.mCallbacks.add(r101);
            this.mOptionsList.add(r100);
        }
    }

    public static abstract class SubscriptionCallback {
        final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken;

        public class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi21(SubscriptionCallback r100) {
                this.this$0 = r100;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(String r100) {
                this.this$0.onError(r100);
            }

            public List<MediaItem> applyOptions(List<MediaItem> r100, Bundle r101) {
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

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(String r100, List<?> r101) {
                WeakReference<Subscription> r102 = this.this$0.mSubscriptionRef;
                if (r102 != null) goto L5;
                Subscription r103 = null;
            L6:
                if (r103 != null) goto L8;
                this.this$0.onChildrenLoaded(r100, MediaItem.fromMediaItemList(r101));
                return;
            L8:
                List<MediaItem> r104 = MediaItem.fromMediaItemList(r101);
                List<SubscriptionCallback> r105 = r103.getCallbacks();
                List<Bundle> r106 = r103.getOptionsList();
                int r107 = 0;
            L10:
                if (r107 >= r105.size()) goto L20;
                Bundle r108 = (Bundle) ListProtector.get(r106, r107);
                if (r108 != null) goto L14;
                this.this$0.onChildrenLoaded(r100, r104);
            L15:
                r107 = r107 + 1;
                goto L10
            L14:
                this.this$0.onChildrenLoaded(r100, applyOptions(r104, r108), r108);
                goto L15
            L20:
                return;
            L5:
                r103 = r102.get();
                goto L6
            }
        }

        public class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi26(SubscriptionCallback r100) {
                this.this$0 = r100;
                super(r100);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(String r100, Bundle r101) {
                this.this$0.onError(r100, r101);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(String r100, List<?> r101, Bundle r102) {
                this.this$0.onChildrenLoaded(r100, MediaItem.fromMediaItemList(r101), r102);
            }
        }

        public void onChildrenLoaded(String r100, List<MediaItem> r101) {
        }

        public void onChildrenLoaded(String r100, List<MediaItem> r101, Bundle r102) {
        }

        public void onError(String r100) {
        }

        public void onError(String r100, Bundle r101) {
        }

        public SubscriptionCallback() {
            this.mToken = new Binder();
            if (Build.VERSION.SDK_INT < 26) goto L5;
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
            return;
        L5:
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21(this));
        }

        public void setSubscription(Subscription r100) {
            this.mSubscriptionRef = new WeakReference(r100);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void unsubscribe(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.mImpl.unsubscribe(r100, null);
        return;
    L7:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void getItem(String r100, ItemCallback r101) {
        this.mImpl.getItem(r100, r101);
    }

    public void subscribe(String r100, SubscriptionCallback r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L8;
        this.mImpl.subscribe(r100, null, r101);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(String r100, SubscriptionCallback r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L8;
        this.mImpl.unsubscribe(r100, r101);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void search(String r100, Bundle r101, SearchCallback r102) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r102 == null) goto L8;
        this.mImpl.search(r100, r101, r102);
        return;
    L8:
        throw new IllegalArgumentException("callback cannot be null");
    L10:
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(String r100, Bundle r101, CustomActionCallback r102) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.mImpl.sendCustomAction(r100, r101, r102);
        return;
    L7:
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(String r100, Bundle r101, SubscriptionCallback r102) {
        if (TextUtils.isEmpty(r100) == true) goto L13;
        if (r102 == null) goto L11;
        if (r101 == null) goto L9;
        this.mImpl.subscribe(r100, r101, r102);
        return;
    L9:
        throw new IllegalArgumentException("options are null");
    L11:
        throw new IllegalArgumentException("callback is null");
    L13:
        throw new IllegalArgumentException("parentId is empty");
    }

    public MediaBrowserCompat(Context r100, ComponentName r101, ConnectionCallback r102, Bundle r103) {
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 26) goto L6;
        this.mImpl = new MediaBrowserImplApi26(r100, r101, r102, r103);
        return;
    L6:
        if (r104 < 23) goto L8;
        this.mImpl = new MediaBrowserImplApi23(r100, r101, r102, r103);
        return;
    L8:
        this.mImpl = new MediaBrowserImplApi21(r100, r101, r102, r103);
    }
}
