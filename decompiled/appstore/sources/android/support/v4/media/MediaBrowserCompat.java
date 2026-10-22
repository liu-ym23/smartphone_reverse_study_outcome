package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.d;
import androidx.media.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        public CallbackHandler(MediaBrowserServiceCallbackImpl r10) {
            this.mCallbackImplRef = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            WeakReference<Messenger> r10 = this.mCallbacksMessengerRef;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.get() != null) goto L7;
            return;
        L7:
            if (this.mCallbackImplRef.get() == null) goto L33;
            Bundle r12 = r11.getData();
            MediaSessionCompat.ensureClassLoader(r12);
            MediaBrowserServiceCallbackImpl r13 = this.mCallbackImplRef.get();
            Messenger r14 = this.mCallbacksMessengerRef.get();
            int r15 = r11.what;     // Catch: BadParcelableException -> L22
            if (r15 != 1) goto L14;
            Bundle r16 = r12.getBundle("data_root_hints");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r16);     // Catch: BadParcelableException -> L22
            r13.onServiceConnected(r14, r12.getString("data_media_item_id"), (MediaSessionCompat.Token) r12.getParcelable("data_media_session_token"), r16);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r15 != 2) goto L16;
            r13.onConnectionFailed(r14);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r15 == 3) goto L18;
            Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + r11 + "\n  Client version: 1\n  Service version: " + r11.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r17 = r12.getBundle("data_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r17);     // Catch: BadParcelableException -> L22
            Bundle r18 = r12.getBundle("data_notify_children_changed_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r18);     // Catch: BadParcelableException -> L22
            r13.onLoadChildren(r14, r12.getString("data_media_item_id"), r12.getParcelableArrayList("data_media_item_list"), r17, r18);     // Catch: BadParcelableException -> L22
        L22:
            Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
            if (r11.what != 1) goto L32;
            r13.onConnectionFailed(r14);
            return;
        L32:
            return;
        }

        public void setCallbacksMessenger(Messenger r10) {
            this.mCallbacksMessengerRef = new WeakReference(r10);
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

            public StubApi21(ConnectionCallback r10) {
                this.this$0 = r10;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal r10 = this.this$0.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.onConnected();
            L5:
                this.this$0.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal r10 = this.this$0.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.onConnectionFailed();
            L5:
                this.this$0.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal r10 = this.this$0.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.onConnectionSuspended();
            L5:
                this.this$0.onConnectionSuspended();
            }
        }

        public ConnectionCallback() {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this));
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal r10) {
            this.mConnectionCallbackInternal = r10;
        }
    }

    public static abstract class CustomActionCallback {
        public CustomActionCallback() {
        }

        public void onError(String r10, Bundle r11, Bundle r12) {
        }

        public void onProgressUpdate(String r10, Bundle r11, Bundle r12) {
        }

        public void onResult(String r10, Bundle r11, Bundle r12) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        public CustomActionResultReceiver(String r10, Bundle r11, CustomActionCallback r12, Handler r13) {
            super(r13);
            this.mAction = r10;
            this.mExtras = r11;
            this.mCallback = r12;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r10, Bundle r11) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.ensureClassLoader(r11);
            if (r10 == (-1)) goto L13;
            if (r10 != 0) goto L9;
            this.mCallback.onResult(this.mAction, this.mExtras, r11);
            return;
        L9:
            if (r10 == 1) goto L11;
            Log.w(MediaBrowserCompat.TAG, "Unknown result code: " + r10 + " (extras=" + this.mExtras + ", resultData=" + r11 + ")");
            return;
        L11:
            this.mCallback.onProgressUpdate(this.mAction, this.mExtras, r11);
            return;
        L13:
            this.mCallback.onError(this.mAction, this.mExtras, r11);
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        public class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            final /* synthetic */ ItemCallback this$0;

            public StubApi23(ItemCallback r10) {
                this.this$0 = r10;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(@NonNull String r10) {
                this.this$0.onError(r10);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(Parcel r10) {
                if (r10 != null) goto L4;
                this.this$0.onItemLoaded(null);
                return;
            L4:
                r10.setDataPosition(0);
                MediaItem r11 = MediaItem.CREATOR.createFromParcel(r10);
                r10.recycle();
                this.this$0.onItemLoaded(r11);
            }
        }

        public ItemCallback() {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(this));
        }

        public void onError(@NonNull String r10) {
        }

        public void onItemLoaded(MediaItem r10) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        public ItemReceiver(String r10, ItemCallback r11, Handler r12) {
            super(r12);
            this.mMediaId = r10;
            this.mCallback = r11;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            if (r10 != 0) goto L16;
            if (r11 == null) goto L16;
            if (r11.containsKey("media_item") == false) goto L16;
            Parcelable r12 = r11.getParcelable("media_item");
            if (r12 != null) goto L11;
        L14:
            this.mCallback.onItemLoaded((MediaItem) r12);
            return;
        L11:
            if ((r12 instanceof MediaItem) == true) goto L14;
            this.mCallback.onError(this.mMediaId);
            return;
        L16:
            this.mCallback.onError(this.mMediaId);
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String r10, @NonNull ItemCallback r11);

        @Nullable
        Bundle getNotifyChildrenChangedOptions();

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String r10, Bundle r11, @NonNull SearchCallback r12);

        void sendCustomAction(@NonNull String r10, Bundle r11, @Nullable CustomActionCallback r12);

        void subscribe(@NonNull String r10, @Nullable Bundle r11, @NonNull SubscriptionCallback r12);

        void unsubscribe(@NonNull String r10, SubscriptionCallback r11);
    }

    @RequiresApi(21)
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
        private final ArrayMap mSubscriptions;

        public MediaBrowserImplApi21(Context r10, ComponentName r11, ConnectionCallback r12, Bundle r13) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = r10;
            if (r13 == null) goto L5;
            Bundle r14 = new Bundle(r13);
        L6:
            this.mRootHints = r14;
            r14.putInt("extra_client_version", 1);
            r12.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(r10, r11, r12.mConnectionCallbackObj, r14);
            return;
        L5:
            r14 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            ServiceBinderWrapper r10 = this.mServiceBinderWrapper;
            if (r10 == null) goto L9;
            Messenger r11 = this.mCallbacksMessenger;
            if (r11 == null) goto L9;
            r10.unregisterCallbackMessenger(r11);     // Catch: RemoteException -> L8
        L8:
            Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
        L9:
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String r10, @NonNull final ItemCallback r11) {
            if (TextUtils.isEmpty(r10) == true) goto L21;
            if (r11 == null) goto L19;
            if (MediaBrowserCompatApi21.isConnected(this.mBrowserObj) == true) goto L10;
            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass1(this, r11, r10));
            return;
        L10:
            if (this.mServiceBinderWrapper != null) goto L22;
            this.mHandler.post(new AnonymousClass2(this, r11, r10));
            return;
        L22:
            this.mServiceBinderWrapper.getMediaItem(r10, new ItemReceiver(r10, r11, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L16
            return;
        L16:
            Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + r10);
            this.mHandler.post(new AnonymousClass3(this, r11, r10));
            return;
        L19:
            throw new IllegalArgumentException("cb is null");
        L21:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
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
            Bundle r10 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (r10 != null) goto L5;
            return;
        L5:
            this.mServiceVersion = r10.getInt("extra_service_version", 0);
            IBinder r11 = d.a(r10, "extra_messenger");
            if (r11 == null) goto L11;
            this.mServiceBinderWrapper = new ServiceBinderWrapper(r11, this.mRootHints);
            Messenger r12 = new Messenger(this.mHandler);
            this.mCallbacksMessenger = r12;
            this.mHandler.setCallbacksMessenger(r12);
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);     // Catch: RemoteException -> L10
        L10:
            Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
        L11:
            IMediaSession r13 = IMediaSession.Stub.asInterface(d.a(r10, "extra_session_binder"));
            if (r13 == null) goto L17;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), r13);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r10, String r11, List r12, Bundle r13, Bundle r14) {
            if (this.mCallbacksMessenger == r10) goto L5;
            return;
        L5:
            Subscription r15 = (Subscription) this.mSubscriptions.get(r11);
            if (r15 == null) goto L8;
            SubscriptionCallback r16 = r15.getCallback(r13);
            if (r16 != null) goto L14;
            return;
        L14:
            if (r13 != null) goto L18;
            if (r12 != null) goto L17;
            r16.onError(r11);
            return;
        L17:
            this.mNotifyChildrenChangedOptions = r14;
            r16.onChildrenLoaded(r11, r12);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L18:
            if (r12 != null) goto L20;
            r16.onError(r11, r13);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r14;
            r16.onChildrenLoaded(r11, r12, r13);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L8:
            if (MediaBrowserCompat.DEBUG == false) goto L22;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + r11);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String r10, final Bundle r11, @NonNull final SearchCallback r12) {
            if (isConnected() == false) goto L15;
            if (this.mServiceBinderWrapper != null) goto L16;
            Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
            this.mHandler.post(new AnonymousClass4(this, r12, r10, r11));
            return;
        L16:
            this.mServiceBinderWrapper.search(r10, r11, new SearchResultReceiver(r10, r11, r12, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + r10, e);
            this.mHandler.post(new AnonymousClass5(this, r12, r10, r11));
            return;
        L15:
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String r10, final Bundle r11, @Nullable final CustomActionCallback r12) {
            if (isConnected() == false) goto L18;
            if (this.mServiceBinderWrapper != null) goto L19;
            Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
            if (r12 == null) goto L19;
            this.mHandler.post(new AnonymousClass6(this, r12, r10, r11));
        L19:
            this.mServiceBinderWrapper.sendCustomAction(r10, r11, new CustomActionResultReceiver(r10, r11, r12, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + r10 + ", extras=" + r11, e);
            if (r12 == null) goto L21;
            this.mHandler.post(new AnonymousClass7(this, r12, r10, r11));
            return;
        L21:
            return;
        L18:
            throw new IllegalStateException("Cannot send a custom action (" + r10 + ") with extras " + r11 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r10, Bundle r11, @NonNull SubscriptionCallback r12) {
            Subscription r13 = (Subscription) this.mSubscriptions.get(r10);
            if (r13 != null) goto L5;
            r13 = new Subscription();
            this.mSubscriptions.put(r10, r13);
        L5:
            r12.setSubscription(r13);
            if (r11 != null) goto L8;
            Bundle r14 = null;
        L9:
            r13.putCallback(r14, r12);
            ServiceBinderWrapper r15 = this.mServiceBinderWrapper;
            if (r15 != null) goto L16;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r10, r12.mSubscriptionCallbackObj);
            return;
        L16:
            r15.addSubscription(r10, r12.mToken, r14, this.mCallbacksMessenger);     // Catch: RemoteException -> L14
            return;
        L14:
            Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + r10);
            return;
        L8:
            r14 = new Bundle(r11);
            goto L9
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r10, SubscriptionCallback r11) {
            Subscription r12 = (Subscription) this.mSubscriptions.get(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            ServiceBinderWrapper r13 = this.mServiceBinderWrapper;
            if (r13 != null) goto L32;
            if (r11 != null) goto L9;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r10);
        L28:
            if (r12.isEmpty() == true) goto L30;
            if (r11 == null) goto L30;
            return;
        L30:
            this.mSubscriptions.remove(r10);
            return;
        L9:
            List<SubscriptionCallback> r14 = r12.getCallbacks();
            List<Bundle> r15 = r12.getOptionsList();
            int r16 = r14.size() - 1;
        L10:
            if (r16 < 0) goto L16;
            if (r14.get(r16) != r11) goto L14;
            r14.remove(r16);
            r15.remove(r16);
        L14:
            r16 = r16 - 1;
            goto L10
        L16:
            if (r14.size() != 0) goto L28;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r10);
            goto L28
        L32:
            if (r11 != null) goto L20;
            r13.removeSubscription(r10, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            goto L28
        L20:
            List<SubscriptionCallback> r17 = r12.getCallbacks();     // Catch: RemoteException -> L26
            List<Bundle> r18 = r12.getOptionsList();     // Catch: RemoteException -> L26
            int r19 = r17.size() - 1;     // Catch: RemoteException -> L26
        L21:
            if (r19 < 0) goto L28;
            if (r17.get(r19) != r11) goto L25;
            this.mServiceBinderWrapper.removeSubscription(r10, r11.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            r17.remove(r19);     // Catch: RemoteException -> L26
            r18.remove(r19);     // Catch: RemoteException -> L26
        L25:
            r19 = r19 - 1;
        L26:
            Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + r10);
            goto L28
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r10) {
        }
    }

    @RequiresApi(23)
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context r10, ComponentName r11, ConnectionCallback r12, Bundle r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String r10, @NonNull ItemCallback r11) {
            if (this.mServiceBinderWrapper != null) goto L5;
            MediaBrowserCompatApi23.getItem(this.mBrowserObj, r10, r11.mItemCallbackObj);
            return;
        L5:
            super.getItem(r10, r11);
        }
    }

    @RequiresApi(26)
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context r10, ComponentName r11, ConnectionCallback r12, Bundle r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r10, @Nullable Bundle r11, @NonNull SubscriptionCallback r12) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r11 != null) goto L10;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r10, r12.mSubscriptionCallbackObj);
            return;
        L10:
            MediaBrowserCompatApi26.subscribe(this.mBrowserObj, r10, r11, r12.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.subscribe(r10, r11, r12);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r10, SubscriptionCallback r11) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r11 != null) goto L10;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r10);
            return;
        L10:
            MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, r10, r11.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.unsubscribe(r10, r11);
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
        private final ArrayMap mSubscriptions;

        public class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            public MediaServiceConnection(MediaBrowserImplBase r10) {
                this.this$0 = r10;
            }

            private void postOrRun(Runnable r10) {
                if (Thread.currentThread() != this.this$0.mHandler.getLooper().getThread()) goto L5;
                r10.run();
                return;
            L5:
                this.this$0.mHandler.post(r10);
            }

            public boolean isCurrent(String r10) {
                MediaBrowserImplBase r11 = this.this$0;
                if (r11.mServiceConnection != this) goto L9;
                int r12 = r11.mState;
                if (r12 == 0) goto L9;
                if (r12 == 1) goto L9;
                return true;
            L9:
                int r13 = r11.mState;
                if (r13 == 0) goto L15;
                if (r13 == 1) goto L16;
                Log.i(MediaBrowserCompat.TAG, r10 + " for " + this.this$0.mServiceComponent + " with mServiceConnection=" + this.this$0.mServiceConnection + " this=" + this);
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r10, final IBinder r11) {
                postOrRun(new AnonymousClass1(this, r10, r11));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r10) {
                postOrRun(new AnonymousClass2(this, r10));
            }
        }

        public MediaBrowserImplBase(Context r10, ComponentName r11, ConnectionCallback r12, Bundle r13) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if (r10 == null) goto L17;
            if (r11 == null) goto L15;
            if (r12 == null) goto L13;
            this.mContext = r10;
            this.mServiceComponent = r11;
            this.mCallback = r12;
            if (r13 != null) goto L9;
            Bundle r14 = null;
        L10:
            this.mRootHints = r14;
            return;
        L9:
            r14 = new Bundle(r13);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        private static String getStateLabel(int r10) {
            if (r10 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r10 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r10 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r10 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r10 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r10;
        }

        private boolean isCurrent(Messenger r10, String r11) {
            if (this.mCallbacksMessenger != r10) goto L9;
            int r12 = this.mState;
            if (r12 == 0) goto L9;
            if (r12 == 1) goto L9;
            return true;
        L9:
            int r13 = this.mState;
            if (r13 == 0) goto L15;
            if (r13 == 1) goto L16;
            Log.i(MediaBrowserCompat.TAG, r11 + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int r10 = this.mState;
            if (r10 != 0) goto L5;
        L9:
            this.mState = 2;
            this.mHandler.post(new AnonymousClass1(this));
            return;
        L5:
            if (r10 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new AnonymousClass2(this));
        }

        public void dump() {
            Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection r10 = this.mServiceConnection;
            if (r10 == null) goto L5;
            this.mContext.unbindService(r10);
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
        @Nullable
        public Bundle getExtras() {
            if (isConnected() == false) goto L7;
            return this.mExtras;
        L7:
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String r10, @NonNull final ItemCallback r11) {
            if (TextUtils.isEmpty(r10) == true) goto L17;
            if (r11 == null) goto L15;
            if (isConnected() == true) goto L18;
            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass3(this, r11, r10));
            return;
        L18:
            this.mServiceBinderWrapper.getMediaItem(r10, new ItemReceiver(r10, r11, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + r10);
            this.mHandler.post(new AnonymousClass4(this, r11, r10));
            return;
        L15:
            throw new IllegalArgumentException("cb is null");
        L17:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            if (isConnected() == false) goto L7;
            return this.mRootId;
        L7:
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected() == false) goto L7;
            return this.mServiceComponent;
        L7:
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected() == false) goto L7;
            return this.mMediaSessionToken;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            if (this.mState != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r10) {
            Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(r10, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r10, String r11, List r12, Bundle r13, Bundle r14) {
            if (isCurrent(r10, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r15 = MediaBrowserCompat.DEBUG;
            if (r15 == false) goto L8;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + r11);
        L8:
            Subscription r16 = (Subscription) this.mSubscriptions.get(r11);
            if (r16 != null) goto L13;
            if (r15 == false) goto L24;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + r11);
            return;
        L24:
            return;
        L13:
            SubscriptionCallback r17 = r16.getCallback(r13);
            if (r17 != null) goto L16;
            return;
        L16:
            if (r13 != null) goto L20;
            if (r12 != null) goto L19;
            r17.onError(r11);
            return;
        L19:
            this.mNotifyChildrenChangedOptions = r14;
            r17.onChildrenLoaded(r11, r12);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L20:
            if (r12 != null) goto L22;
            r17.onError(r11, r13);
            return;
        L22:
            this.mNotifyChildrenChangedOptions = r14;
            r17.onChildrenLoaded(r11, r12, r13);
            this.mNotifyChildrenChangedOptions = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13) {
            if (isCurrent(r10, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            this.mRootId = r11;
            this.mMediaSessionToken = r12;
            this.mExtras = r13;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG == false) goto L12;
            Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
            dump();
        L12:
            this.mCallback.onConnected();
            Iterator<Map.Entry<Object, Object>> r14 = this.mSubscriptions.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r14.hasNext() == false) goto L27;
            Map.Entry<Object, Object> r15 = r14.next();     // Catch: RemoteException -> L21
            String r16 = (String) r15.getKey();     // Catch: RemoteException -> L21
            Subscription r17 = (Subscription) r15.getValue();     // Catch: RemoteException -> L21
            List<SubscriptionCallback> r18 = r17.getCallbacks();     // Catch: RemoteException -> L21
            List<Bundle> r19 = r17.getOptionsList();     // Catch: RemoteException -> L21
            int r20 = 0;
        L18:
            if (r20 >= r18.size()) goto L15;
            this.mServiceBinderWrapper.addSubscription(r16, r18.get(r20).mToken, r19.get(r20), this.mCallbacksMessenger);     // Catch: RemoteException -> L21
            r20 = r20 + 1;
            goto L18
        L27:
            return;
        L21:
            Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String r10, final Bundle r11, @NonNull final SearchCallback r12) {
            if (isConnected() == false) goto L11;
            this.mServiceBinderWrapper.search(r10, r11, new SearchResultReceiver(r10, r11, r12, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + r10, e);
            this.mHandler.post(new AnonymousClass5(this, r12, r10, r11));
            return;
        L11:
            throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String r10, final Bundle r11, @Nullable final CustomActionCallback r12) {
            if (isConnected() == false) goto L13;
            this.mServiceBinderWrapper.sendCustomAction(r10, r11, new CustomActionResultReceiver(r10, r11, r12, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + r10 + ", extras=" + r11, e);
            if (r12 == null) goto L16;
            this.mHandler.post(new AnonymousClass6(this, r12, r10, r11));
            return;
        L16:
            return;
        L13:
            throw new IllegalStateException("Cannot send a custom action (" + r10 + ") with extras " + r11 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r10, Bundle r11, @NonNull SubscriptionCallback r12) {
            Subscription r13 = (Subscription) this.mSubscriptions.get(r10);
            if (r13 != null) goto L5;
            r13 = new Subscription();
            this.mSubscriptions.put(r10, r13);
        L5:
            if (r11 != null) goto L7;
            Bundle r14 = null;
        L8:
            r13.putCallback(r14, r12);
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.addSubscription(r10, r12.mToken, r14, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + r10);
            return;
        L16:
            return;
        L7:
            r14 = new Bundle(r11);
            goto L8
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r10, SubscriptionCallback r11) {
            Subscription r12 = (Subscription) this.mSubscriptions.get(r10);
            if (r12 != null) goto L24;
            return;
        L24:
            if (r11 == null) goto L7;
            List<SubscriptionCallback> r13 = r12.getCallbacks();     // Catch: RemoteException -> L18
            List<Bundle> r14 = r12.getOptionsList();     // Catch: RemoteException -> L18
            int r15 = r13.size() - 1;     // Catch: RemoteException -> L18
        L10:
            if (r15 < 0) goto L20;
            if (r13.get(r15) != r11) goto L17;
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.removeSubscription(r10, r11.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L16:
            r13.remove(r15);     // Catch: RemoteException -> L18
            r14.remove(r15);     // Catch: RemoteException -> L18
        L17:
            r15 = r15 - 1;
        L20:
            if (r12.isEmpty() == true) goto L22;
            if (r11 == null) goto L22;
            return;
        L22:
            this.mSubscriptions.remove(r10);
            return;
        L7:
            if (isConnected() == false) goto L20;
            this.mServiceBinderWrapper.removeSubscription(r10, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L18:
            Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + r10);
            goto L20
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger r10);

        void onLoadChildren(Messenger r10, String r11, List r12, Bundle r13, Bundle r14);

        void onServiceConnected(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13);
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface Flags {
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public MediaItem(@NonNull MediaDescriptionCompat r10, int r11) {
            if (r10 == null) goto L11;
            if (TextUtils.isEmpty(r10.getMediaId()) == true) goto L9;
            this.mFlags = r11;
            this.mDescription = r10;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object r10) {
            if (r10 == null) goto L5;
            int r11 = MediaBrowserCompatApi21.MediaItem.getFlags(r10);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(r10)), r11);
        L5:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r10) {
            if (r10 == null) goto L8;
            ArrayList r11 = new ArrayList(r10.size());
            Iterator<?> r12 = r10.iterator();
        L5:
            if (r12.hasNext() == false) goto L7;
            r11.add(fromMediaItem(r12.next()));
            goto L5
        L7:
            return r11;
        L8:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
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

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r10, r11);
        }

        public MediaItem(Parcel r10) {
            this.mFlags = r10.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
        }
    }

    public static abstract class SearchCallback {
        public SearchCallback() {
        }

        public void onError(@NonNull String r10, Bundle r11) {
        }

        public void onSearchResult(@NonNull String r10, Bundle r11, @NonNull List<MediaItem> r12) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        public SearchResultReceiver(String r10, Bundle r11, SearchCallback r12, Handler r13) {
            super(r13);
            this.mQuery = r10;
            this.mExtras = r11;
            this.mCallback = r12;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            if (r10 != 0) goto L16;
            if (r11 == null) goto L16;
            if (r11.containsKey("search_results") == false) goto L16;
            Parcelable[] r12 = r11.getParcelableArray("search_results");
            if (r12 == null) goto L13;
            ArrayList r13 = new ArrayList();
            int r14 = r12.length;
            int r15 = 0;
        L11:
            if (r15 >= r14) goto L14;
            r13.add((MediaItem) r12[r15]);
            r15 = r15 + 1;
        L14:
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, r13);
            return;
        L13:
            r13 = null;
        L16:
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder r10, Bundle r11) {
            this.mMessenger = new Messenger(r10);
            this.mRootHints = r11;
        }

        private void sendRequest(int r10, Bundle r11, Messenger r12) throws RemoteException {
            Message r13 = Message.obtain();
            r13.what = r10;
            r13.arg1 = 1;
            r13.setData(r11);
            r13.replyTo = r12;
            this.mMessenger.send(r13);
        }

        public void addSubscription(String r10, IBinder r11, Bundle r12, Messenger r13) throws RemoteException {
            Bundle r14 = new Bundle();
            r14.putString("data_media_item_id", r10);
            d.b(r14, "data_callback_token", r11);
            r14.putBundle("data_options", r12);
            sendRequest(3, r14, r13);
        }

        public void connect(Context r10, Messenger r11) throws RemoteException {
            Bundle r12 = new Bundle();
            r12.putString("data_package_name", r10.getPackageName());
            r12.putBundle("data_root_hints", this.mRootHints);
            sendRequest(1, r12, r11);
        }

        public void disconnect(Messenger r10) throws RemoteException {
            sendRequest(2, null, r10);
        }

        public void getMediaItem(String r10, ResultReceiver r11, Messenger r12) throws RemoteException {
            Bundle r13 = new Bundle();
            r13.putString("data_media_item_id", r10);
            r13.putParcelable("data_result_receiver", r11);
            sendRequest(5, r13, r12);
        }

        public void registerCallbackMessenger(Context r10, Messenger r11) throws RemoteException {
            Bundle r12 = new Bundle();
            r12.putString("data_package_name", r10.getPackageName());
            r12.putBundle("data_root_hints", this.mRootHints);
            sendRequest(6, r12, r11);
        }

        public void removeSubscription(String r10, IBinder r11, Messenger r12) throws RemoteException {
            Bundle r13 = new Bundle();
            r13.putString("data_media_item_id", r10);
            d.b(r13, "data_callback_token", r11);
            sendRequest(4, r13, r12);
        }

        public void search(String r10, Bundle r11, ResultReceiver r12, Messenger r13) throws RemoteException {
            Bundle r14 = new Bundle();
            r14.putString("data_search_query", r10);
            r14.putBundle("data_search_extras", r11);
            r14.putParcelable("data_result_receiver", r12);
            sendRequest(8, r14, r13);
        }

        public void sendCustomAction(String r10, Bundle r11, ResultReceiver r12, Messenger r13) throws RemoteException {
            Bundle r14 = new Bundle();
            r14.putString("data_custom_action", r10);
            r14.putBundle("data_custom_action_extras", r11);
            r14.putParcelable("data_result_receiver", r12);
            sendRequest(9, r14, r13);
        }

        public void unregisterCallbackMessenger(Messenger r10) throws RemoteException {
            sendRequest(7, null, r10);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks;
        private final List<Bundle> mOptionsList;

        public Subscription() {
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public SubscriptionCallback getCallback(Bundle r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.mOptionsList.size()) goto L10;
            if (a.a(this.mOptionsList.get(r11), r10) == true) goto L8;
            r11 = r11 + 1;
            goto L4
        L8:
            return this.mCallbacks.get(r11);
        L10:
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle r10, SubscriptionCallback r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.mOptionsList.size()) goto L10;
            if (a.a(this.mOptionsList.get(r12), r10) == true) goto L7;
            r12 = r12 + 1;
            goto L4
        L7:
            this.mCallbacks.set(r12, r11);
            return;
        L10:
            this.mCallbacks.add(r11);
            this.mOptionsList.add(r10);
        }
    }

    public static abstract class SubscriptionCallback {
        final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken;

        public class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi21(SubscriptionCallback r10) {
                this.this$0 = r10;
            }

            public List<MediaItem> applyOptions(List<MediaItem> r10, Bundle r11) {
                if (r10 != null) goto L5;
                return null;
            L5:
                int r12 = r11.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int r13 = r11.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (r12 != (-1)) goto L9;
                if (r13 != (-1)) goto L9;
                return r10;
            L9:
                int r14 = r13 * r12;
                int r15 = r14 + r13;
                if (r12 < 0) goto L22;
                if (r13 < 1) goto L22;
                if (r14 >= r10.size()) goto L22;
                if (r15 <= r10.size()) goto L20;
                r15 = r10.size();
            L20:
                return r10.subList(r14, r15);
            L22:
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String r10, List<?> r11) {
                WeakReference<Subscription> r12 = this.this$0.mSubscriptionRef;
                if (r12 != null) goto L5;
                Subscription r13 = null;
            L6:
                if (r13 != null) goto L8;
                this.this$0.onChildrenLoaded(r10, MediaItem.fromMediaItemList(r11));
                return;
            L8:
                List<MediaItem> r14 = MediaItem.fromMediaItemList(r11);
                List<SubscriptionCallback> r15 = r13.getCallbacks();
                List<Bundle> r16 = r13.getOptionsList();
                int r17 = 0;
            L10:
                if (r17 >= r15.size()) goto L20;
                Bundle r18 = r16.get(r17);
                if (r18 != null) goto L14;
                this.this$0.onChildrenLoaded(r10, r14);
            L15:
                r17 = r17 + 1;
                goto L10
            L14:
                this.this$0.onChildrenLoaded(r10, applyOptions(r14, r18), r18);
                goto L15
            L20:
                return;
            L5:
                r13 = r12.get();
                goto L6
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(@NonNull String r10) {
                this.this$0.onError(r10);
            }
        }

        public class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi26(SubscriptionCallback r10) {
                this.this$0 = r10;
                super(r10);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String r10, List<?> r11, @NonNull Bundle r12) {
                this.this$0.onChildrenLoaded(r10, MediaItem.fromMediaItemList(r11), r12);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(@NonNull String r10, @NonNull Bundle r11) {
                this.this$0.onError(r10, r11);
            }
        }

        public SubscriptionCallback() {
            this.mToken = new Binder();
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
        }

        public void onChildrenLoaded(@NonNull String r10, @NonNull List<MediaItem> r11) {
        }

        public void onError(@NonNull String r10) {
        }

        public void setSubscription(Subscription r10) {
            this.mSubscriptionRef = new WeakReference(r10);
        }

        public void onChildrenLoaded(@NonNull String r10, @NonNull List<MediaItem> r11, @NonNull Bundle r12) {
        }

        public void onError(@NonNull String r10, @NonNull Bundle r11) {
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserCompat(Context r10, ComponentName r11, ConnectionCallback r12, Bundle r13) {
        this.mImpl = new MediaBrowserImplApi26(r10, r11, r12, r13);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String r10, @NonNull ItemCallback r11) {
        this.mImpl.getItem(r10, r11);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull String r10, Bundle r11, @NonNull SearchCallback r12) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        if (r12 == null) goto L8;
        this.mImpl.search(r10, r11, r12);
        return;
    L8:
        throw new IllegalArgumentException("callback cannot be null");
    L10:
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(@NonNull String r10, Bundle r11, @Nullable CustomActionCallback r12) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        this.mImpl.sendCustomAction(r10, r11, r12);
        return;
    L7:
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String r10, @NonNull SubscriptionCallback r11) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        if (r11 == null) goto L8;
        this.mImpl.subscribe(r10, null, r11);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        this.mImpl.unsubscribe(r10, null);
        return;
    L7:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String r10, @NonNull SubscriptionCallback r11) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        if (r11 == null) goto L8;
        this.mImpl.unsubscribe(r10, r11);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void subscribe(@NonNull String r10, @NonNull Bundle r11, @NonNull SubscriptionCallback r12) {
        if (TextUtils.isEmpty(r10) == true) goto L13;
        if (r12 == null) goto L11;
        if (r11 == null) goto L9;
        this.mImpl.subscribe(r10, r11, r12);
        return;
    L9:
        throw new IllegalArgumentException("options are null");
    L11:
        throw new IllegalArgumentException("callback is null");
    L13:
        throw new IllegalArgumentException("parentId is empty");
    }
}
