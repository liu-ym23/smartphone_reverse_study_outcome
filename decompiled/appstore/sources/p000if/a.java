package p000if;

import com.media.cache.listener.IDownloadListener;
import hf.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import p9.c;
import s9.b;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f20583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f20589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f20590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IDownloadListener f20591j;

    /* JADX INFO: renamed from: if.a$a, reason: collision with other inner class name */
    public class C0271a implements IDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20592a;

        public C0271a(a r10) {
            this.f20592a = r10;
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadDefault(b r10) {
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadError(b r10) {
            a.a(this.f20592a, r10);
            o0.a.d("onDownloadError , player=" + this);
            this.f20592a.p(4);
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadPause(b r10) {
            a.a(this.f20592a, r10);
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadPending(b r10) {
            a.a(this.f20592a, r10);
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadPrepare(b r10) {
            a.a(this.f20592a, r10);
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadProgress(b r10) {
            a.a(this.f20592a, r10);
            a.f(this.f20592a, (int) r10.b());
            a.h(this.f20592a, r10.a());
            if (a.d(this.f20592a) != null) goto L5;
            return;
        L5:
            if (a.d(this.f20592a).get() == null) goto L9;
            ((d) a.d(this.f20592a).get()).f(a.e(this.f20592a), a.g(this.f20592a));
            return;
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadProxyForbidden(b r10) {
            a.a(this.f20592a, r10);
            o0.a.d("onCacheForbidden url=" + r10.g() + ", player=" + this);
            a.i(this.f20592a, false);
            if (a.d(this.f20592a) != null) goto L5;
            return;
        L5:
            if (a.d(this.f20592a).get() == null) goto L9;
            ((d) a.d(this.f20592a).get()).e(r10.g());
            return;
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadProxyReady(b r10) {
            a.a(this.f20592a, r10);
            if (a.b(this.f20592a) == false) goto L5;
            return;
        L5:
            if (a.d(this.f20592a) != null) goto L7;
            return;
        L7:
            if (a.d(this.f20592a).get() == null) goto L12;
            ((d) a.d(this.f20592a).get()).g(r10.c());
            a.c(this.f20592a, true);
            return;
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadSpeed(b r10) {
            a.a(this.f20592a, r10);
            if (a.d(this.f20592a) != null) goto L5;
            return;
        L5:
            if (a.d(this.f20592a).get() == null) goto L9;
            ((d) a.d(this.f20592a).get()).h(r10.d());
            return;
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadStart(b r10) {
            a.a(this.f20592a, r10);
        }

        @Override // com.media.cache.listener.IDownloadListener
        public void onDownloadSuccess(b r10) {
            a.a(this.f20592a, r10);
            o0.a.c("onDownloadSuccess url=" + r10.g() + ", player=" + this);
            a.j(this.f20592a, true);
            if (a.d(this.f20592a) != null) goto L5;
            return;
        L5:
            if (a.d(this.f20592a).get() == null) goto L9;
            ((d) a.d(this.f20592a).get()).d();
            return;
        }
    }

    public a(d r10) {
        this.f20582a = 0;
        this.f20584c = true;
        this.f20585d = false;
        this.f20587f = false;
        this.f20588g = 0;
        this.f20589h = 0;
        this.f20591j = new C0271a(this);
        this.f20583b = new WeakReference(r10);
    }

    public static /* synthetic */ b a(a r10, b r11) {
        r10.f20590i = r11;
        return r11;
    }

    public static /* synthetic */ boolean b(a r10) {
        return r10.f20587f;
    }

    public static /* synthetic */ boolean c(a r10, boolean r11) {
        r10.f20587f = r11;
        return r11;
    }

    public static /* synthetic */ WeakReference d(a r10) {
        return r10.f20583b;
    }

    public static /* synthetic */ int e(a r10) {
        return r10.f20588g;
    }

    public static /* synthetic */ int f(a r10, int r11) {
        r10.f20588g = r11;
        return r11;
    }

    public static /* synthetic */ long g(a r10) {
        return r10.f20589h;
    }

    public static /* synthetic */ long h(a r10, long r11) {
        r10.f20589h = r11;
        return r11;
    }

    public static /* synthetic */ boolean i(a r10, boolean r11) {
        r10.f20584c = r11;
        return r11;
    }

    public static /* synthetic */ boolean j(a r10, boolean r11) {
        r10.f20585d = r11;
        return r11;
    }

    public void k() {
        if (this.f20584c == false) goto L6;
        p(2);
        return;
    }

    public void l() {
        if (this.f20584c == false) goto L6;
        o0.a.c("doReleaseAction player=" + this);
        c.f().t(this.f20590i);
        return;
    }

    public void m(long r10) {
        if (this.f20584c == false) goto L13;
        WeakReference r11 = this.f20583b;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.get() == null) goto L16;
        long r12 = ((d) this.f20583b.get()).getDuration();
        if (r12 <= 0) goto L15;
        o0.a.c("doSeekToAction seekPosition=" + r10);
        this.f20582a = 0;
        c.f().o(r10, r12, this.f20586e);
        return;
    L15:
        return;
    L16:
        return;
    }

    public void n() {
        if (this.f20584c == true) goto L5;
        return;
    L5:
        if (o() == false) goto L9;
        q();
        return;
    }

    public final boolean o() {
        if (this.f20582a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void p(int r10) {
        if (this.f20585d == false) goto L7;
        c.f().l(this.f20586e);
        return;
    L7:
        if (o() == true) goto L10;
        this.f20582a = r10;
        c.f().j(this.f20590i);
        return;
    }

    public void q() {
        if (this.f20585d == false) goto L6;
        return;
    L6:
        if (o() == false) goto L9;
        o0.a.c("resumeProxyCacheTask url=" + this.f20586e);
        this.f20582a = 0;
        c.f().n(this.f20590i, this.f20591j);
        return;
    }

    public void r(String r10) {
        this.f20586e = r10;
        o0.a.d("LocalProxyPlayerImpl setCacheListener");
        c.f().e(r10, this.f20591j);
    }

    public void s(String r10, HashMap r11) {
        this.f20586e = r10;
        this.f20590i = new b(r10, 4);
        c.f().s(this.f20590i, r11, this.f20591j);
    }
}
