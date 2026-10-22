package p9;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.baselib.MediaSDKReceiver;
import com.android.baselib.NetworkListener;
import com.bytedance.common.wschannel.WsConstants;
import com.media.cache.download.VideoDownloadTask;
import com.media.cache.listener.IDownloadListener;
import com.media.cache.listener.IDownloadTaskListener;
import com.media.cache.listener.IVideoInfoCallback;
import com.media.cache.listener.IVideoInfoParseCallback;
import com.media.cache.model.VideoCacheInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static c f23372j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p9.a f23373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p9.d f23374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f23375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IDownloadListener f23376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f23377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f23378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f23379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f23380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NetworkListener f23381i;

    public class a implements IVideoInfoParseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.b f23382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f23383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f23384c;

        public a(c r10, s9.b r11, HashMap r12) {
            this.f23384c = r10;
            this.f23382a = r11;
            this.f23383b = r12;
        }

        @Override // com.media.cache.listener.IVideoInfoParseCallback
        public void onM3U8FileParseFailed(VideoCacheInfo r10, Throwable r11) {
            c.a(this.f23384c, this.f23382a, r10, this.f23383b);
        }

        @Override // com.media.cache.listener.IVideoInfoParseCallback
        public void onM3U8FileParseSuccess(VideoCacheInfo r10, q9.a r11) {
            this.f23384c.r(this.f23382a, r10, r11, this.f23383b);
        }
    }

    public class b implements IVideoInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.b f23385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f23386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f23387c;

        public b(c r10, s9.b r11, HashMap r12) {
            this.f23387c = r10;
            this.f23385a = r11;
            this.f23386b = r12;
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onBaseVideoInfoFailed(Throwable r10) {
            o0.a.d("onInfoFailed error=" + r10);
            this.f23385a.k(u9.a.a(r10));
            this.f23385a.p(6);
            c.b(this.f23387c).obtainMessage(10, this.f23385a).sendToTarget();
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onBaseVideoInfoSuccess(VideoCacheInfo r10) {
            this.f23387c.p(this.f23385a, r10, this.f23386b);
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onFinalUrl(String r10) {
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onLiveM3U8Callback(VideoCacheInfo r10) {
            o0.a.c("onLiveM3U8Callback cannot be cached.");
            this.f23385a.p(6);
            c.b(this.f23387c).obtainMessage(10, this.f23385a).sendToTarget();
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onM3U8InfoFailed(Throwable r10) {
            r10.printStackTrace();
            o0.a.d("onM3U8InfoFailed : " + r10);
            this.f23385a.k(u9.a.a(r10));
            this.f23385a.p(6);
            c.b(this.f23387c).obtainMessage(10, this.f23385a).sendToTarget();
        }

        @Override // com.media.cache.listener.IVideoInfoCallback
        public void onM3U8InfoSuccess(VideoCacheInfo r10, q9.a r11) {
            this.f23387c.r(this.f23385a, r10, r11, this.f23386b);
        }
    }

    /* JADX INFO: renamed from: p9.c$c, reason: collision with other inner class name */
    public class C0341c implements IDownloadTaskListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.b f23388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f23389b;

        public C0341c(c r10, s9.b r11) {
            this.f23389b = r10;
            this.f23388a = r11;
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onLocalProxyReady(String r10) {
            this.f23388a.n(r10);
            this.f23388a.p(4);
            c.b(this.f23389b).obtainMessage(4, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskFailed(Throwable r10) {
            int r11 = u9.a.a(r10);
            this.f23388a.k(r11);
            this.f23388a.p(6);
            c.b(this.f23389b).obtainMessage(9, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskFinished(long r10) {
            this.f23388a.p(5);
            this.f23388a.i(r10);
            this.f23388a.m(100.0f);
            c.b(this.f23389b).obtainMessage(8, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskPaused() {
            this.f23388a.p(7);
            c.b(this.f23389b).obtainMessage(7, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskProgress(float r10, long r11, q9.a r12) {
            if (this.f23388a.f() != 7) goto L5;
        L8:
            o0.a.a("onTaskProgress taskItem state=" + this.f23388a.f());
            return;
        L5:
            if (this.f23388a.f() == 5) goto L8;
            this.f23388a.p(3);
            this.f23388a.m(r10);
            this.f23388a.i(r11);
            this.f23388a.l(r12);
            c.b(this.f23389b).obtainMessage(5, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskSpeedChanged(float r10) {
            this.f23388a.o(r10);
            c.b(this.f23389b).obtainMessage(6, this.f23388a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskStart(String r10) {
            this.f23388a.p(2);
            c.b(this.f23389b).obtainMessage(3, this.f23388a).sendToTarget();
        }
    }

    public class d implements IDownloadTaskListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.b f23390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f23391b;

        public d(c r10, s9.b r11) {
            this.f23391b = r10;
            this.f23390a = r11;
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onLocalProxyReady(String r10) {
            this.f23390a.n(r10);
            this.f23390a.p(4);
            c.b(this.f23391b).obtainMessage(4, this.f23390a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskFailed(Throwable r10) {
            int r11 = u9.a.a(r10);
            this.f23390a.k(r11);
            this.f23390a.p(6);
            c.b(this.f23391b).obtainMessage(9, this.f23390a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskFinished(long r10) {
            this.f23390a.p(5);
            this.f23390a.m(100.0f);
            this.f23390a.i(r10);
            c.b(this.f23391b).obtainMessage(8, this.f23390a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskPaused() {
            this.f23390a.p(7);
            c.b(this.f23391b).obtainMessage(7, this.f23390a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskProgress(float r10, long r11, q9.a r12) {
            if (this.f23390a.f() != 7) goto L5;
            return;
        L5:
            if (this.f23390a.f() == 5) goto L10;
            this.f23390a.p(3);
            this.f23390a.m(r10);
            this.f23390a.i(r11);
            this.f23390a.l(r12);
            c.b(this.f23391b).obtainMessage(5, this.f23390a).sendToTarget();
            return;
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskSpeedChanged(float r10) {
            this.f23390a.o(r10);
            c.b(this.f23391b).obtainMessage(6, this.f23390a).sendToTarget();
        }

        @Override // com.media.cache.listener.IDownloadTaskListener
        public void onTaskStart(String r10) {
            this.f23390a.p(2);
            c.b(this.f23391b).obtainMessage(3, this.f23390a).sendToTarget();
        }
    }

    public class e implements NetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23392a;

        public e(c r10) {
            this.f23392a = r10;
        }

        @Override // com.android.baselib.NetworkListener
        public void onAvailable() {
            o0.a.b("onAvailable");
        }

        @Override // com.android.baselib.NetworkListener
        public void onMobileConnected() {
            o0.a.b("onMobileConnected");
        }

        @Override // com.android.baselib.NetworkListener
        public void onNetworkType() {
            o0.a.b("onNetworkType");
        }

        @Override // com.android.baselib.NetworkListener
        public void onUnConnected() {
            o0.a.b("onUnConnected");
        }

        @Override // com.android.baselib.NetworkListener
        public void onWifiConnected() {
            o0.a.b("onWifiConnected");
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f23393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f23394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f23395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f23396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23398f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f23399g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f23400h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f23401i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f23402j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f23403k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f23404l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f23405m;

        public f(Context r10) {
            this.f23395c = 2147483648L;
            this.f23396d = 30000;
            this.f23397e = 30000;
            this.f23398f = 60000;
            this.f23399g = false;
            this.f23400h = false;
            this.f23401i = 3;
            this.f23403k = false;
            this.f23404l = 20971520;
            this.f23405m = WsConstants.DEFAULT_IO_LIMIT;
            this.f23393a = r10;
        }

        public p9.a a() {
            return new p9.a(this.f23393a, this.f23394b, this.f23395c, this.f23396d, this.f23397e, this.f23398f, this.f23399g, this.f23400h, this.f23402j, this.f23403k, this.f23404l, this.f23405m, this.f23401i);
        }

        public f b(File r10) {
            this.f23394b = r10;
            return this;
        }

        public f c(int r10) {
            this.f23401i = r10;
            return this;
        }

        public f d(boolean r10) {
            this.f23400h = r10;
            return this;
        }

        public f e(int r10, int r11, int r12) {
            this.f23396d = r10;
            this.f23397e = r11;
            this.f23398f = r12;
            return this;
        }

        public f f(boolean r10) {
            this.f23399g = r10;
            return this;
        }
    }

    public class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23406a;

        public g(c r10) {
            this.f23406a = r10;
            super(Looper.getMainLooper());
        }

        public final void a(int r10, Object r11) {
        }

        public final void b(int r10, Object r11) {
            s9.b r12 = (s9.b) r11;
            if (c.c(this.f23406a).containsKey(r12.g()) == false) goto L5;
            IDownloadListener r13 = (IDownloadListener) c.c(this.f23406a).get(r12.g());
        L6:
            c(r10, r12, r13);
            c(r10, r12, c.d(this.f23406a));
            return;
        L5:
            r13 = null;
            goto L6
        }

        public final void c(int r10, s9.b r11, IDownloadListener r12) {
            if (r12 == null) goto L17;
            switch(r10) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L28;
            };
        L5:
            this.f23406a.m(r11);
            r12.onDownloadProxyForbidden(r11);
            return;
        L6:
            this.f23406a.m(r11);
            r12.onDownloadError(r11);
            return;
        L7:
            this.f23406a.m(r11);
            r12.onDownloadSuccess(r11);
            return;
        L8:
            this.f23406a.m(r11);
            r12.onDownloadPause(r11);
            return;
        L9:
            r12.onDownloadSpeed(r11);
            return;
        L10:
            r12.onDownloadProgress(r11);
            return;
        L11:
            r12.onDownloadProxyReady(r11);
            return;
        L12:
            r12.onDownloadStart(r11);
            return;
        L13:
            r12.onDownloadPrepare(r11);
            return;
        L14:
            r12.onDownloadPending(r11);
            return;
        L15:
            r12.onDownloadDefault(r11);
            return;
        L28:
            return;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            int r11 = r10.what;
            if (r11 != 100) goto L5;
            a(r11, r10.obj);
            return;
        L5:
            b(r11, r10.obj);
        }
    }

    static {
    }

    public c() {
        this.f23375c = new g(this);
        this.f23377e = new CopyOnWriteArrayList();
        this.f23378f = new CopyOnWriteArrayList();
        this.f23379g = new ConcurrentHashMap();
        this.f23380h = new ConcurrentHashMap();
        this.f23381i = new e(this);
        this.f23374b = new p9.d();
    }

    public static /* synthetic */ void a(c r10, s9.b r11, VideoCacheInfo r12, HashMap r13) {
        r10.h(r11, r12, r13);
    }

    public static /* synthetic */ Handler b(c r10) {
        return r10.f23375c;
    }

    public static /* synthetic */ Map c(c r10) {
        return r10.f23380h;
    }

    public static /* synthetic */ IDownloadListener d(c r10) {
        return r10.f23376d;
    }

    public static c f() {
        if (f23372j != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23372j != null) goto L11;
        f23372j = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f23372j;
    }

    public void e(String r10, IDownloadListener r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.f23380h.put(r10, r11);
        o0.a.d("VideoDownloadManager addCallback listener=" + r11 + "");
    }

    public void g(p9.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f23373a = r10;
        new t9.a(r10);
        p9.f.c().d(r10);
        k(this.f23373a.e());
    }

    public final void h(s9.b r10, VideoCacheInfo r11, HashMap r12) {
        p9.f.c().i(r11, new b(this, r10, r12), r12);
    }

    public final void i(s9.b r10, HashMap r11) {
        String r12 = r10.g();
        VideoCacheInfo r13 = u9.d.j(new File(this.f23373a.a(), u9.d.c(r12)));
        if (r13 == null) goto L23;
        o0.a.d("parseVideoInfo info = " + r13);
        if (r10.h() == false) goto L11;
        long r14 = r13.getDownloadTime();
        if (r14 != 0) goto L9;
        long r15 = System.currentTimeMillis();
        r13.setDownloadTime(r15);
        r10.j(r15);
        goto L11
    L9:
        r10.j(r14);
    L11:
        if (r13.getVideoType() != 3) goto L13;
    L22:
        p(r10, r13, r11);
        return;
    L13:
        if (r13.getVideoType() == 4) goto L22;
        if (r13.getVideoType() == 5) goto L22;
        if (r13.getVideoType() == 6) goto L22;
        if (r13.getVideoType() != 1) goto L28;
        p9.f.c().g(r13, new a(this, r10, r11));
        return;
    L28:
        return;
    L23:
        VideoCacheInfo r16 = new VideoCacheInfo(r12);
        r16.setTaskMode(r10.e());
        if (r10.h() == false) goto L26;
        long r17 = System.currentTimeMillis();
        r16.setDownloadTime(r17);
        r10.j(r17);
    L26:
        h(r10, r16, r11);
    }

    public void j(s9.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.g()) == true) goto L12;
        String r11 = r10.g();
        VideoDownloadTask r12 = (VideoDownloadTask) this.f23379g.get(r11);
        if (r12 == null) goto L11;
        r12.c();
        return;
    L11:
        return;
    }

    public void k(Context r10) {
        r10.registerReceiver(new MediaSDKReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void l(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.f23380h.remove(r10);
    }

    public void m(s9.b r10) {
        this.f23374b.f(r10);
    L4:
        if (this.f23374b.b() >= this.f23373a.c()) goto L9;
        if (this.f23374b.b() == this.f23374b.g()) goto L12;
        q(this.f23374b.e(), null);
        goto L4
    L12:
        return;
    }

    public void n(s9.b r10, IDownloadListener r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.g()) == true) goto L12;
        String r12 = r10.g();
        VideoDownloadTask r13 = (VideoDownloadTask) this.f23379g.get(r12);
        if (r13 == null) goto L11;
        r13.d();
        e(r12, r11);
        return;
    L11:
        return;
    }

    public void o(long r10, long r11, String r12) {
        VideoDownloadTask r13 = (VideoDownloadTask) this.f23379g.get(r12);
        if (r13 == null) goto L6;
        r13.e(r10, r11);
        return;
    }

    public void p(s9.b r10, VideoCacheInfo r11, HashMap r12) {
        r10.q(r11.getVideoType());
        if (this.f23379g.containsKey(r11.getUrl()) == true) goto L5;
        VideoDownloadTask r13 = new com.media.cache.download.a(this.f23373a, r11, r12);
        this.f23379g.put(r11.getUrl(), r13);
    L6:
        if (r13 == null) goto L9;
        r13.f(new C0341c(this, r10));
        return;
    L9:
        return;
    L5:
        r13 = (VideoDownloadTask) this.f23379g.get(r11.getUrl());
        goto L6
    }

    public void q(s9.b r10, HashMap r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.g()) == false) goto L6;
        return;
    L6:
        if (r10.g().startsWith("http://127.0.0.1") == true) goto L12;
        r10.p(1);
        this.f23375c.obtainMessage(2, r10).sendToTarget();
        i(r10, r11);
        return;
    }

    public void r(s9.b r10, VideoCacheInfo r11, q9.a r12, HashMap r13) {
        r10.q(r11.getVideoType());
        if (this.f23379g.containsKey(r11.getUrl()) == true) goto L5;
        VideoDownloadTask r14 = new com.media.cache.download.b(this.f23373a, r11, r12, r13);
        this.f23379g.put(r11.getUrl(), r14);
    L6:
        if (r14 == null) goto L9;
        r14.f(new d(this, r10));
        return;
    L9:
        return;
    L5:
        r14 = (VideoDownloadTask) this.f23379g.get(r11.getUrl());
        goto L6
    }

    public void s(s9.b r10, HashMap r11, IDownloadListener r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.g()) == false) goto L6;
        return;
    L6:
        if (r10.g().startsWith("http://127.0.0.1") == true) goto L12;
        e(r10.g(), r12);
        r10.p(1);
        this.f23375c.obtainMessage(2, r10).sendToTarget();
        i(r10, r11);
        return;
    }

    public void t(s9.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.g()) == true) goto L12;
        String r11 = r10.g();
        VideoDownloadTask r12 = (VideoDownloadTask) this.f23379g.get(r11);
        if (r12 == null) goto L11;
        r12.h();
        this.f23379g.remove(r11);
        l(r11);
        return;
    L11:
        return;
    }
}
