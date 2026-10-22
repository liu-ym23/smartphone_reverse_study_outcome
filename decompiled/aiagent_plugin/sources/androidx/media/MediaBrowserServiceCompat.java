package androidx.media;

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
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends PluginService {
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
    final androidx.b.a<IBinder, ConnectionRecord> mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private b mImpl;
    MediaSessionCompat.Token mSession;

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final androidx.media.b.C0067b browserInfo;
        public final j callbacks;
        public final int pid;
        public final String pkg;
        public a root;
        public final Bundle rootHints;
        public final HashMap<String, List<androidx.core.util.e<IBinder, Bundle>>> subscriptions;
        final /* synthetic */ MediaBrowserServiceCompat this$0;
        public final int uid;

        ConnectionRecord(MediaBrowserServiceCompat r3, String r4, int r5, int r6, Bundle r7, j r8) {
            MediaBrowserServiceCompat r9 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            j r10 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.aiagent.plugin");
            this.this$0 = r9;
            this.subscriptions = new HashMap();
            this.pkg = r4;
            this.pid = r5;
            this.uid = r6;
            this.browserInfo = new androidx.media.b.C0067b(r4, r5, r6);
            this.rootHints = r7;
            this.callbacks = r10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mHandler.post(new AnonymousClass1(this));
        }
    }

    private final class ServiceHandler extends Handler {
        private final i mServiceBinderImpl;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.w(r0, r1);
        }

        ServiceHandler(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            this.this$0 = r4;
            this.mServiceBinderImpl = new i(r4);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            Bundle r0 = r11.getData();
            switch(r11.what) {
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
            INVOKESTATIC_androidx_media_MediaBrowserServiceCompat$ServiceHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + r11 + "\n  Service version: 2\n  Client version: " + r11.arg1);
            return;
        L5:
            Bundle r1 = r0.getBundle("data_custom_action_extras");
            MediaSessionCompat.a(r1);
            this.mServiceBinderImpl.b(r0.getString("data_custom_action"), r1, (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable("data_result_receiver"), ResultReceiver.class, "com.obric.aiagent.plugin"), new k(r11.replyTo));
            return;
        L6:
            Bundle r2 = r0.getBundle("data_search_extras");
            MediaSessionCompat.a(r2);
            this.mServiceBinderImpl.a(r0.getString("data_search_query"), r2, (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable("data_result_receiver"), ResultReceiver.class, "com.obric.aiagent.plugin"), new k(r11.replyTo));
            return;
        L7:
            this.mServiceBinderImpl.b(new k(r11.replyTo));
            return;
        L8:
            Bundle r6 = r0.getBundle("data_root_hints");
            MediaSessionCompat.a(r6);
            this.mServiceBinderImpl.a(new k(r11.replyTo), r0.getString("data_package_name"), r0.getInt("data_calling_pid"), r0.getInt("data_calling_uid"), r6);
            return;
        L9:
            this.mServiceBinderImpl.a(r0.getString("data_media_item_id"), (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable("data_result_receiver"), ResultReceiver.class, "com.obric.aiagent.plugin"), new k(r11.replyTo));
            return;
        L10:
            this.mServiceBinderImpl.a(r0.getString("data_media_item_id"), androidx.core.app.d.a(r0, "data_callback_token"), new k(r11.replyTo));
            return;
        L11:
            Bundle r3 = r0.getBundle("data_options");
            MediaSessionCompat.a(r3);
            this.mServiceBinderImpl.a(r0.getString("data_media_item_id"), androidx.core.app.d.a(r0, "data_callback_token"), r3, new k(r11.replyTo));
            return;
        L12:
            this.mServiceBinderImpl.a(new k(r11.replyTo));
            return;
        L13:
            Bundle r7 = r0.getBundle("data_root_hints");
            MediaSessionCompat.a(r7);
            this.mServiceBinderImpl.a(r0.getString("data_package_name"), r0.getInt("data_calling_pid"), r0.getInt("data_calling_uid"), r7, new k(r11.replyTo));
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r4, long r5) {
            Bundle r0 = r4.getData();
            r0.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            r0.putInt("data_calling_uid", Binder.getCallingUid());
            r0.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(r4, r5);
        }

        public void postOrRun(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            if (Thread.currentThread() != getLooper().getThread()) goto L5;
            r4.run();
            return;
        L5:
            post(r4);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_media_MediaBrowserServiceCompat$ServiceHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f2138b;

        public String a() {
            return this.f2137a;
        }

        public Bundle b() {
            return this.f2138b;
        }
    }

    interface b {
        IBinder a(Intent r1);

        void a();

        void a(MediaSessionCompat.Token r1);

        void a(androidx.media.b.C0067b r1, String r2, Bundle r3);

        void a(String r1, Bundle r2);

        Bundle b();

        androidx.media.b.C0067b c();
    }

    class c implements b, MediaBrowserServiceCompatApi21.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<Bundle> f2139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f2140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Messenger f2141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f2142d;

        c(MediaBrowserServiceCompat r3) {
            this.f2142d = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            this.f2139a = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a() {
            Object r0 = MediaBrowserServiceCompatApi21.a(this.f2142d, this);
            this.f2140b = r0;
            MediaBrowserServiceCompatApi21.a(r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public IBinder a(Intent r1) {
            return MediaBrowserServiceCompatApi21.a(this.f2140b, r1);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(final MediaSessionCompat.Token r3) {
            this.f2142d.mHandler.postOrRun(new AnonymousClass1(this, r3));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(String r1, Bundle r2) {
            b(r1, r2);
            c(r1, r2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(androidx.media.b.C0067b r1, String r2, Bundle r3) {
            b(r1, r2, r3);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.c
        public MediaBrowserServiceCompatApi21.a a(String r12, int r13, Bundle r14) {
            if (r14 != null) goto L5;
        L14:
            Bundle r1 = null;
        L15:
            this.f2142d.mCurConnection = new ConnectionRecord(this.f2142d, r12, -1, r13, r14, null);
            a r15 = this.f2142d.onGetRoot(r12, r13, r14);
            this.f2142d.mCurConnection = null;
            if (r15 != null) goto L18;
            return null;
        L18:
            if (r1 != null) goto L21;
            r1 = r15.b();
        L24:
            return new MediaBrowserServiceCompatApi21.a(r15.a(), r1);
        L21:
            if (r15.b() == null) goto L24;
            r1.putAll(r15.b());
            goto L24
        L5:
            if (r14.getInt("extra_client_version", 0) == 0) goto L14;
            r14.remove("extra_client_version");
            this.f2141c = new Messenger(this.f2142d.mHandler);
            r1 = new Bundle();
            r1.putInt("extra_service_version", 2);
            androidx.core.app.d.a(r1, "extra_messenger", this.f2141c.getBinder());
            if (this.f2142d.mSession == null) goto L13;
            IMediaSession r2 = this.f2142d.mSession.getExtraBinder();
            if (r2 != null) goto L11;
            IBinder r3 = null;
        L12:
            androidx.core.app.d.a(r1, "extra_session_binder", r3);
            goto L15
        L11:
            r3 = r2.asBinder();
            goto L12
        L13:
            this.f2139a.add(r1);
            goto L15
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.c
        public void a(final String r2, final MediaBrowserServiceCompatApi21.b<List<Parcel>> r3) {
            h<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass2(this, r2, r3);
            this.f2142d.onLoadChildren(r2, r0);
        }

        void b(String r1, Bundle r2) {
            MediaBrowserServiceCompatApi21.a(this.f2140b, r1);
        }

        void c(final String r3, final Bundle r4) {
            this.f2142d.mHandler.post(new AnonymousClass3(this, r3, r4));
        }

        void b(final androidx.media.b.C0067b r3, final String r4, final Bundle r5) {
            this.f2142d.mHandler.post(new AnonymousClass4(this, r3, r4, r5));
        }

        void a(ConnectionRecord r6, String r7, Bundle r8) {
            List r0 = (List) ZeusTransformUtils.preCheckCast(r6.subscriptions.get(r7), List.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L10;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L16;
            androidx.core.util.e r2 = (androidx.core.util.e) ZeusTransformUtils.preCheckCast(r1.next(), androidx.core.util.e.class, "com.obric.aiagent.plugin");
            if (androidx.media.a.b(r8, (Bundle) ZeusTransformUtils.preCheckCast(r2.f1372b, Bundle.class, "com.obric.aiagent.plugin")) == false) goto L6;
            this.f2142d.performLoadChildren(r7, r6, (Bundle) ZeusTransformUtils.preCheckCast(r2.f1372b, Bundle.class, "com.obric.aiagent.plugin"), r8);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public Bundle b() {
            if (this.f2141c != null) goto L6;
            return null;
        L6:
            if (this.f2142d.mCurConnection == null) goto L13;
            if (this.f2142d.mCurConnection.rootHints != null) goto L11;
            return null;
        L11:
            return new Bundle(this.f2142d.mCurConnection.rootHints);
        L13:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public androidx.media.b.C0067b c() {
            if (this.f2142d.mCurConnection == null) goto L7;
            return this.f2142d.mCurConnection.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    class d extends c implements MediaBrowserServiceCompatApi23.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f2154e;

        d(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            this.f2154e = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c, androidx.media.MediaBrowserServiceCompat.b
        public void a() {
            this.f2140b = MediaBrowserServiceCompatApi23.a(this.f2154e, this);
            MediaBrowserServiceCompatApi21.a(this.f2140b);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.a
        public void b(final String r2, final MediaBrowserServiceCompatApi21.b<Parcel> r3) {
            h<MediaBrowserCompat.MediaItem> r0 = new AnonymousClass1(this, r2, r3);
            this.f2154e.onLoadItem(r2, r0);
        }
    }

    class e extends d implements MediaBrowserServiceCompatApi26.b {
        final /* synthetic */ MediaBrowserServiceCompat f;

        e(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            this.f = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c, androidx.media.MediaBrowserServiceCompat.b
        public void a() {
            this.f2140b = MediaBrowserServiceCompatApi26.a(this.f, this);
            MediaBrowserServiceCompatApi21.a(this.f2140b);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.b
        public void a(final String r2, final MediaBrowserServiceCompatApi26.a r3, Bundle r4) {
            h<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass1(this, r2, r3);
            this.f.onLoadChildren(r2, r0, r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c, androidx.media.MediaBrowserServiceCompat.b
        public Bundle b() {
            if (this.f.mCurConnection == null) goto L10;
            if (this.f.mCurConnection.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.f.mCurConnection.rootHints);
        L10:
            return MediaBrowserServiceCompatApi26.a(this.f2140b);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        void b(String r1, Bundle r2) {
            if (r2 == null) goto L4;
            MediaBrowserServiceCompatApi26.a(this.f2140b, r1, r2);
            return;
        L4:
            super.b(r1, r2);
        }
    }

    class f extends e {
        final /* synthetic */ MediaBrowserServiceCompat g;

        f(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
            this.g = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c, androidx.media.MediaBrowserServiceCompat.b
        public androidx.media.b.C0067b c() {
            if (this.g.mCurConnection == null) goto L7;
            return this.g.mCurConnection.browserInfo;
        L7:
            return new androidx.media.b.C0067b(((MediaBrowserService) ZeusTransformUtils.preCheckCast(this.f2140b, MediaBrowserService.class, "com.obric.aiagent.plugin")).getCurrentBrowserInfo());
        }
    }

    class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f2159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Messenger f2160b;

        g(MediaBrowserServiceCompat r3) {
            this.f2159a = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a() {
            this.f2160b = new Messenger(this.f2159a.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public IBinder a(Intent r2) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(r2.getAction()) == true) goto L5;
            return null;
        L5:
            return this.f2160b.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(final MediaSessionCompat.Token r3) {
            this.f2159a.mHandler.post(new AnonymousClass1(this, r3));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(final String r3, final Bundle r4) {
            this.f2159a.mHandler.post(new AnonymousClass2(this, r3, r4));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public void a(final androidx.media.b.C0067b r3, final String r4, final Bundle r5) {
            this.f2159a.mHandler.post(new AnonymousClass3(this, r3, r4, r5));
        }

        void a(ConnectionRecord r6, String r7, Bundle r8) {
            List r0 = (List) ZeusTransformUtils.preCheckCast(r6.subscriptions.get(r7), List.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L10;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L16;
            androidx.core.util.e r2 = (androidx.core.util.e) ZeusTransformUtils.preCheckCast(r1.next(), androidx.core.util.e.class, "com.obric.aiagent.plugin");
            if (androidx.media.a.b(r8, (Bundle) ZeusTransformUtils.preCheckCast(r2.f1372b, Bundle.class, "com.obric.aiagent.plugin")) == false) goto L6;
            this.f2159a.performLoadChildren(r7, r6, (Bundle) ZeusTransformUtils.preCheckCast(r2.f1372b, Bundle.class, "com.obric.aiagent.plugin"), r8);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public Bundle b() {
            if (this.f2159a.mCurConnection == null) goto L10;
            if (this.f2159a.mCurConnection.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.f2159a.mCurConnection.rootHints);
        L10:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.b
        public androidx.media.b.C0067b c() {
            if (this.f2159a.mCurConnection == null) goto L7;
            return this.f2159a.mCurConnection.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    public static class h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f2170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2174e;

        void a(T r1) {
        }

        h(Object r1) {
            this.f2170a = r1;
        }

        public void b(T r3) {
            if (this.f2172c == true) goto L9;
            if (this.f2173d == true) goto L9;
            this.f2172c = true;
            a(r3);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f2170a);
        }

        public void c(Bundle r3) {
            if (this.f2172c == true) goto L9;
            if (this.f2173d == true) goto L9;
            this.f2173d = true;
            b(r3);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f2170a);
        }

        boolean a() {
            if (this.f2171b == false) goto L5;
        L10:
            return true;
        L5:
            if (this.f2172c == true) goto L10;
            if (this.f2173d == true) goto L10;
            return false;
        }

        void a(int r1) {
            this.f2174e = r1;
        }

        int b() {
            return this.f2174e;
        }

        void b(Bundle r3) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f2170a);
        }
    }

    private class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f2175a;

        i(MediaBrowserServiceCompat r3) {
            this.f2175a = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.aiagent.plugin");
        }

        public void a(final String r9, final int r10, final int r11, final Bundle r12, j r13) {
            final j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r13, j.class, "com.obric.aiagent.plugin");
            if (this.f2175a.isValidPackage(r9, r11) == false) goto L7;
            this.f2175a.mHandler.postOrRun(new AnonymousClass1(this, r2, r9, r10, r11, r12));
            return;
        L7:
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + r11 + " package=" + r9);
        }

        public void a(j r3) {
            final j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            this.f2175a.mHandler.postOrRun(new AnonymousClass2(this, r4));
        }

        public void a(final String r9, IBinder r10, final Bundle r11, j r12) {
            final IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.aiagent.plugin");
            final j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.aiagent.plugin");
            this.f2175a.mHandler.postOrRun(new AnonymousClass3(this, r4, r9, r6, r11));
        }

        public void a(final String r3, IBinder r4, j r5) {
            final IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            final j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
            this.f2175a.mHandler.postOrRun(new AnonymousClass4(this, r7, r3, r6));
        }

        public void a(final String r3, final ResultReceiver r4, j r5) {
            final j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(r3) == true) goto L8;
            if (r4 == null) goto L9;
            this.f2175a.mHandler.postOrRun(new AnonymousClass5(this, r6, r3, r4));
            return;
        L9:
            return;
        }

        public void a(j r9, final String r10, final int r11, final int r12, final Bundle r13) {
            final j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.aiagent.plugin");
            this.f2175a.mHandler.postOrRun(new AnonymousClass6(this, r2, r10, r11, r12, r13));
        }

        public void b(j r3) {
            final j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            this.f2175a.mHandler.postOrRun(new AnonymousClass7(this, r4));
        }

        public void a(final String r8, final Bundle r9, final ResultReceiver r10, j r11) {
            final j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r11, j.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(r8) == true) goto L8;
            if (r10 == null) goto L9;
            this.f2175a.mHandler.postOrRun(new AnonymousClass8(this, r2, r8, r9, r10));
            return;
        L9:
            return;
        }

        public void b(final String r8, final Bundle r9, final ResultReceiver r10, j r11) {
            final j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r11, j.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(r8) == true) goto L8;
            if (r10 == null) goto L9;
            this.f2175a.mHandler.postOrRun(new AnonymousClass9(this, r2, r8, r9, r10));
            return;
        L9:
            return;
        }
    }

    private interface j {
        IBinder a();

        void a(String r1, MediaSessionCompat.Token r2, Bundle r3);

        void a(String r1, List<MediaBrowserCompat.MediaItem> r2, Bundle r3, Bundle r4);

        void b();
    }

    private static class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Messenger f2213a;

        k(Messenger r1) {
            this.f2213a = r1;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.j
        public IBinder a() {
            return this.f2213a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.j
        public void a(String r3, MediaSessionCompat.Token r4, Bundle r5) {
            if (r5 != null) goto L4;
            r5 = new Bundle();
        L4:
            r5.putInt("extra_service_version", 2);
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            r0.putParcelable("data_media_session_token", r4);
            r0.putBundle("data_root_hints", r5);
            a(1, r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.j
        public void b() {
            a(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.j
        public void a(String r4, List<MediaBrowserCompat.MediaItem> r5, Bundle r6, Bundle r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r4);
            r0.putBundle("data_options", r6);
            r0.putBundle("data_notify_children_changed_options", r7);
            if (r8 != null) goto L5;
        L9:
            a(3, r0);
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r8, ArrayList.class) == false) goto L7;
            ArrayList<? extends Parcelable> r9 = (ArrayList) ZeusTransformUtils.preCheckCast(r8, ArrayList.class, "com.obric.aiagent.plugin");
        L8:
            r0.putParcelableArrayList("data_media_item_list", r9);
            goto L9
        L7:
            r9 = new ArrayList(r8);
            goto L8
        }

        private void a(int r2, Bundle r3) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 2;
            r0.setData(r3);
            this.f2213a.send(r0);
        }
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public void dump(FileDescriptor r1, PrintWriter r2, String[] r3) {
    }

    public abstract a onGetRoot(String r1, int r2, Bundle r3);

    public abstract void onLoadChildren(String r1, h<List<MediaBrowserCompat.MediaItem>> r2);

    public void onSubscribe(String r1, Bundle r2) {
    }

    public void onUnsubscribe(String r1) {
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new androidx.b.a();
        this.mHandler = new ServiceHandler(this);
    }

    static {
        DEBUG = INVOKESTATIC_androidx_media_MediaBrowserServiceCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 3);
    }

    public void attachToBaseContext(Context r3) {
        attachBaseContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mImpl = new f(this);
    L15:
        this.mImpl.a();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        this.mImpl = new e(this);
        goto L15
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        this.mImpl = new d(this);
        goto L15
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L14;
        this.mImpl = new c(this);
        goto L15
    L14:
        this.mImpl = new g(this);
        goto L15
    }

    public IBinder onBind(Intent r1) {
        return this.mImpl.a(r1);
    }

    public void onLoadChildren(String r1, h<List<MediaBrowserCompat.MediaItem>> r2, Bundle r3) {
        r2.a(1);
        onLoadChildren(r1, r2);
    }

    public void onLoadItem(String r1, h<MediaBrowserCompat.MediaItem> r2) {
        r2.a(2);
        r2.b(null);
    }

    public void onSearch(String r1, Bundle r2, h<List<MediaBrowserCompat.MediaItem>> r3) {
        r3.a(4);
        r3.b(null);
    }

    public void onCustomAction(String r1, Bundle r2, h<Bundle> r3) {
        r3.c(null);
    }

    public void setSessionToken(MediaSessionCompat.Token r2) {
        if (r2 == null) goto L10;
        if (this.mSession != null) goto L8;
        this.mSession = r2;
        this.mImpl.a(r2);
        return;
    L8:
        throw new IllegalStateException("The session token has already been set.");
    L10:
        throw new IllegalArgumentException("Session token may not be null.");
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.b();
    }

    public final androidx.media.b.C0067b getCurrentBrowserInfo() {
        return this.mImpl.c();
    }

    public void notifyChildrenChanged(String r2) {
        if (r2 == null) goto L6;
        this.mImpl.a(r2, null);
        return;
    L6:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String r1, Bundle r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        this.mImpl.a(r1, r2);
        return;
    L7:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L9:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(androidx.media.b.C0067b r1, String r2, Bundle r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L10;
        if (r3 == null) goto L8;
        this.mImpl.a(r1, r2, r3);
        return;
    L8:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L10:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    L12:
        throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    }

    boolean isValidPackage(String r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r3 = getPackageManager().getPackagesForUid(r5);
        int r6 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r6) goto L12;
        if (r3[r1].equals(r4) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    void addSubscription(String r6, ConnectionRecord r7, IBinder r8, Bundle r9) {
        IBinder r10 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r8, IBinder.class, "com.obric.aiagent.plugin");
        List<androidx.core.util.e<IBinder, Bundle>> r0 = (List) ZeusTransformUtils.preCheckCast(r7.subscriptions.get(r6), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        Iterator<androidx.core.util.e<IBinder, Bundle>> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        androidx.core.util.e r3 = (androidx.core.util.e) ZeusTransformUtils.preCheckCast(r2.next(), androidx.core.util.e.class, "com.obric.aiagent.plugin");
        if (r10 != r3.f1371a) goto L7;
        if (androidx.media.a.a(r9, (Bundle) ZeusTransformUtils.preCheckCast(r3.f1372b, Bundle.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return;
    L13:
        r0.add(new androidx.core.util.e(r10, r9));
        r7.subscriptions.put(r6, r0);
        performLoadChildren(r6, r7, r9, null);
        this.mCurConnection = r7;
        onSubscribe(r6, r9);
        this.mCurConnection = null;
    }

    boolean removeSubscription(String r9, ConnectionRecord r10, IBinder r11) {
        IBinder r12 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r11, IBinder.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        boolean r2 = false;
        if (r12 == null) goto L5;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r10.subscriptions.get(r9), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r4 == null) goto L21;
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L23
    L14:
        if (r5.hasNext() == false) goto L19;
        if (r12 != ((androidx.core.util.e) ZeusTransformUtils.preCheckCast(r5.next(), androidx.core.util.e.class, "com.obric.aiagent.plugin")).f1371a) goto L14;
        r5.remove();     // Catch: Throwable -> L23
        r2 = true;
        goto L14
    L19:
        if (r4.size() != 0) goto L21;
        r10.subscriptions.remove(r9);     // Catch: Throwable -> L23
    L21:
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        return r2;
    L5:
        if (r10.subscriptions.remove(r9) != null) goto L8;
        r0 = false;
    L8:
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        return r0;
    L23:
        th = move-exception;
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        throw th;
    }

    void performLoadChildren(final String r9, final ConnectionRecord r10, final Bundle r11, final Bundle r12) {
        h<List<MediaBrowserCompat.MediaItem>> r7 = new AnonymousClass1(this, r9, r10, r9, r11, r12);
        this.mCurConnection = r10;
        if (r11 != null) goto L5;
        onLoadChildren(r9, r7);
    L6:
        this.mCurConnection = null;
        if (r7.a() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + r10.pkg + " id=" + r9);
    L5:
        onLoadChildren(r9, r7, r11);
        goto L6
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> r3, Bundle r4) {
        List<MediaBrowserCompat.MediaItem> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        int r5 = r4.getInt("android.media.browse.extra.PAGE", -1);
        int r6 = r4.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (r5 != (-1)) goto L10;
        if (r6 != (-1)) goto L10;
        return r2;
    L10:
        int r0 = r6 * r5;
        int r1 = r0 + r6;
        if (r5 < 0) goto L23;
        if (r6 < 1) goto L23;
        if (r0 >= r2.size()) goto L23;
        if (r1 <= r2.size()) goto L21;
        r1 = r2.size();
    L21:
        return r2.subList(r0, r1);
    L23:
        return Collections.emptyList();
    }

    void performLoadItem(final String r2, ConnectionRecord r3, final ResultReceiver r4) {
        h<MediaBrowserCompat.MediaItem> r0 = new AnonymousClass2(this, r2, r4);
        this.mCurConnection = r3;
        onLoadItem(r2, r0);
        this.mCurConnection = null;
        if (r0.a() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + r2);
    }

    void performSearch(final String r2, Bundle r3, ConnectionRecord r4, final ResultReceiver r5) {
        h<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass3(this, r2, r5);
        this.mCurConnection = r4;
        onSearch(r2, r3, r0);
        this.mCurConnection = null;
        if (r0.a() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + r2);
    }

    void performCustomAction(final String r2, Bundle r3, ConnectionRecord r4, final ResultReceiver r5) {
        h<Bundle> r0 = new AnonymousClass4(this, r2, r5);
        this.mCurConnection = r4;
        onCustomAction(r2, r3, r0);
        this.mCurConnection = null;
        if (r0.a() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r2 + " extras=" + r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_androidx_media_MediaBrowserServiceCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }
}
