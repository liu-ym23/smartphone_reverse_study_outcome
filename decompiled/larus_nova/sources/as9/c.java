package as9;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import zr9.g;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zr9.f f16144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f16145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<zr9.c> f16148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<zr9.b> f16149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<zr9.d, d> f16150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public as9.a f16151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public as9.a f16152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0220c f16153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f16154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f16155l;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f16156c;

        public a(c r100) {
            this.f16156c = r100;
            super(r100, 1);
        }

        @Override // as9.c.b, as9.a.InterfaceC0219a
        public final void onStatusGenerate(int r100, float r101) {
            zr9.f r102 = this.f16156c.f16144a;
            if (r102 == null) goto L6;
            r102.f573436c = r100;
            super.onStatusGenerate(r100, r101);
            return;
        }
    }

    public class b implements as9.a.InterfaceC0219a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f16158b;

        public b(c r100, int r101) {
            this.f16158b = r100;
            this.f16157a = r101;
        }

        @Override // as9.a.InterfaceC0219a
        public void onStatusGenerate(int r100, float r101) {
            int r102 = this.f16157a;
            c r103 = this.f16158b;
            if (r102 != r103.f16145b.f573439a) goto L17;
            zr9.f r104 = r103.f16144a;
            if (r104 != null) goto L7;
            return;
        L7:
            if (r104.f573434a != r100) goto L12;
            long r105 = System.currentTimeMillis();
            c r106 = this.f16158b;
            long r107 = r105 - r106.f16147d;
            r106.f16145b.getClass();
            if (r107 < 300000) goto L11;
            boolean r108 = bs9.a.f20322a;
            goto L12
        L11:
            return;
        L12:
            c r109 = this.f16158b;
            r109.f16144a.f573434a = r100;
            if (r109.f16155l.hasMessages(1) == false) goto L15;
            r109.f16155l.removeMessages(1);
        L15:
            r109.f16155l.sendEmptyMessageDelayed(1, 3000);
            return;
        }
    }

    /* JADX INFO: renamed from: as9.c$c, reason: collision with other inner class name */
    public class C0220c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f16159c;

        public C0220c(c r100) {
            this.f16159c = r100;
            super(r100, 0);
        }

        @Override // as9.c.b, as9.a.InterfaceC0219a
        public final void onStatusGenerate(int r110, float r111) {
            zr9.f r100 = this.f16159c.f16144a;
            if (r100 == null) goto L36;
            r100.f573435b = r110;
            r100.f573437d = r111;
            super.onStatusGenerate(r110, r111);
            c r101 = this.f16159c;
            long r102 = SystemClock.elapsedRealtime();
            Map<zr9.d, d> r103 = r101.f16150g;
            monitor-enter(r103);
            Iterator r104 = ((HashMap) r101.f16150g).entrySet().iterator();     // Catch: Throwable -> L33
            boolean r105 = false;
        L8:
            if (r104.hasNext() == false) goto L27;
            d r106 = (d) ((Map.Entry) r104.next()).getValue();     // Catch: Throwable -> L33
            if (r106 == null) goto L8;
            if (r106.f16162c == true) goto L8;
            float r107 = r111 - r106.f16160a;     // Catch: Throwable -> L33
            long r112 = r102 - r106.f16161b;     // Catch: Throwable -> L33
            float r113 = r107 / r112;     // Catch: Throwable -> L33
            if (r107 < 0.0f) goto L21;
            if (r112 <= 0) goto L19;
            if (r113 <= 0.0f) goto L21;
        L19:
            boolean r108 = bs9.a.f20322a;     // Catch: Throwable -> L33
            r105 = true;
            r106.f16162c = true;     // Catch: Throwable -> L33
            r106.f16163d = r111;     // Catch: Throwable -> L33
            r106.f16164e = r102;     // Catch: Throwable -> L33
        L21:
            if (r107 < 0.0f) goto L26;
            if (r113 < (((double) 0.0f) * 0.5d)) goto L26;
            boolean r109 = bs9.a.f20322a;     // Catch: Throwable -> L33
        L26:
            boolean r114 = bs9.a.f20322a;     // Catch: Throwable -> L33
            r106.f16161b = r102;     // Catch: Throwable -> L33
            r106.f16160a = r111;     // Catch: Throwable -> L33
            goto L8
        L27:
            monitor-exit(r103);     // Catch: Throwable -> L33
            if (r105 == true) goto L30;
            return;
        L30:
            if (r101.f16155l.hasMessages(2) == false) goto L32;
            r101.f16155l.removeMessages(2);
        L32:
            r101.f16155l.sendEmptyMessageDelayed(2, 5000);
            return;
        L33:
            th = move-exception;
            throw th;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f16161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f16162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f16163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f16164e;

        public final String toString() {
            return "SurgeConfig{baseTemp=" + this.f16160a + ", baseTime=" + this.f16161b + ", targetDeltaTemp=0.0, targetDuration=0, targetSpeed=0.0, needNotify=" + this.f16162c + ", nowTemp=" + this.f16163d + ", nowTime=" + this.f16164e + '}';
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f16165a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            c r102 = this.f16165a;
            zr9.f r103 = r102.f16144a;
            List<zr9.c> r104 = r102.f16148e;
            monitor-enter(r104);
            ArrayList r105 = new ArrayList(r102.f16148e);     // Catch: Throwable -> L18
            monitor-exit(r104);     // Catch: Throwable -> L18
            Iterator r106 = r105.iterator();
        L14:
            if (r106.hasNext() == false) goto L16;
            zr9.c r107 = (zr9.c) r106.next();
            int r108 = r103.f573434a;
            r107.a();
            goto L14
        L16:
            int r109 = r103.f573434a;
            boolean r110 = bs9.a.f20322a;
            c r111 = this.f16165a;
            c.a(r111, r111.f16144a);
            c r112 = this.f16165a;
            r112.f16147d = System.currentTimeMillis();
            return;
        L18:
            th = move-exception;
            throw th;
        L5:
            if (r101 != 2) goto L25;
            c.b(this.f16165a);
            return;
        }

        public e(c r100, Looper r101) {
            this.f16165a = r100;
            super(r101);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zr9.d f16166a;

        public f(zr9.d r100, float r101, float r102, long r103) {
            this.f16166a = r100;
        }
    }

    public c(Context r100) {
        Object r101 = new Object();
        this.f16146c = r101;
        this.f16147d = -1;
        this.f16148e = new ArrayList();
        this.f16149f = new ArrayList();
        this.f16150g = new HashMap();
        g r102 = g.f573438d;
        this.f16145b = r102;
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("thermal_status");
        ThreadMethodProxy.start(r103);
        e r104 = new e(this, r103.getLooper());
        this.f16155l = r104;
        as9.b.f16143a = r103.getLooper();
        int r105 = -1;
        if (r102.f573440b == true) goto L5;
        as9.a r106 = this.f16151h;
        if (r106 == null) goto L25;
        r106.f();
        this.f16151h = null;
        this.f16153j = null;
    L25:
        if (r102.f573441c == true) goto L27;
        as9.a r107 = this.f16152i;
        if (r107 == null) goto L51;
        r107.f();
        this.f16152i = null;
        this.f16154k = null;
    L51:
        if (r102.f573439a == 2) goto L53;
    L59:
        Objects.toString(r102);
        Objects.toString(this.f16151h);
        Objects.toString(this.f16152i);
        boolean r108 = bs9.a.f20322a;
        zr9.f r109 = new zr9.f();
        monitor-enter(r101);
    L81:
        th = move-exception;
        throw th;
    L62:
        if (r102.f573440b == false) goto L69;
        as9.a r110 = this.f16151h;     // Catch: Throwable -> L81
        if (r110 == null) goto L69;
        r109.f573437d = r110.b();     // Catch: Throwable -> L81
        int r111 = this.f16151h.c();     // Catch: Throwable -> L81
        r109.f573435b = r111;     // Catch: Throwable -> L81
        if (r102.f573439a != 0) goto L69;
        r109.f573434a = r111;     // Catch: Throwable -> L81
    L69:
        if (r102.f573441c == false) goto L75;
        as9.a r112 = this.f16152i;     // Catch: Throwable -> L81
        if (r112 == null) goto L75;
        int r113 = r112.c();     // Catch: Throwable -> L81
        r109.f573436c = r113;     // Catch: Throwable -> L81
        if (r102.f573439a != 1) goto L75;
        r109.f573434a = r113;     // Catch: Throwable -> L81
    L75:
        monitor-exit(r101);     // Catch: Throwable -> L81
        this.f16144a = r109;
        if (r104.hasMessages(1) == false) goto L79;
        r104.removeMessages(1);
    L79:
        r104.sendEmptyMessageDelayed(1, 60000);
        return;
    L53:
        if (this.f16152i == null) goto L56;
        r105 = 1;
    L58:
        r102.f573439a = r105;
        goto L59
    L56:
        if (this.f16151h == null) goto L58;
        r105 = 0;
        goto L58
    L27:
        if (this.f16152i != null) goto L51;
        as9.a r114 = as9.b.a(1, r100);
        this.f16152i = r114;
        if (r114 != null) goto L31;
        boolean r115 = false;
    L35:
        if (r115 == true) goto L51;
        r102.f573441c = false;
        if (r102.f573439a == 1) goto L39;
    L43:
        as9.a r116 = this.f16152i;
        if (r116 == null) goto L46;
        r116.f();
        this.f16152i = null;
        this.f16154k = null;
    L46:
        boolean r117 = bs9.a.f20322a;
        goto L51
    L39:
        if (this.f16151h != null) goto L41;
        int r118 = -1;
    L42:
        r102.f573439a = r118;
        goto L43
    L41:
        r118 = 0;
        goto L42
    L31:
        if (this.f16154k != null) goto L33;
        this.f16154k = new a(this);
    L33:
        r115 = r114.g(this.f16154k);
        goto L35
    L5:
        if (this.f16151h != null) goto L25;
        as9.a r119 = as9.b.a(0, r100);
        this.f16151h = r119;
        if (r119 != null) goto L9;
        boolean r120 = false;
    L13:
        if (r120 == true) goto L25;
        r102.f573440b = false;
        if (r102.f573439a != 0) goto L17;
        r102.f573439a = -1;
    L17:
        as9.a r121 = this.f16151h;
        if (r121 == null) goto L20;
        r121.f();
        this.f16151h = null;
        this.f16153j = null;
    L20:
        boolean r122 = bs9.a.f20322a;
        goto L25
    L9:
        if (this.f16153j != null) goto L11;
        this.f16153j = new C0220c(this);
    L11:
        r120 = r119.g(this.f16153j);
        goto L13
    }

    public static void b(c r110) {
        r110.getClass();
        ArrayList r100 = new ArrayList();
        Map<zr9.d, d> r101 = r110.f16150g;
        monitor-enter(r101);
        Iterator r111 = ((HashMap) r110.f16150g).entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r111.hasNext() == false) goto L13;
        Map.Entry r102 = (Map.Entry) r111.next();     // Catch: Throwable -> L19
        d r103 = (d) r102.getValue();     // Catch: Throwable -> L19
        zr9.d r104 = (zr9.d) r102.getKey();     // Catch: Throwable -> L19
        if (r103 == null) goto L6;
        if (r103.f16162c == false) goto L6;
        if (r104 == null) goto L6;
        r100.add(new f(r104, r103.f16160a, r103.f16163d, r103.f16164e - r103.f16161b));     // Catch: Throwable -> L19
        r103.f16160a = r103.f16163d;     // Catch: Throwable -> L19
        r103.f16161b = r103.f16164e;     // Catch: Throwable -> L19
        r103.f16162c = false;     // Catch: Throwable -> L19
        goto L6
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L19
        Iterator r112 = r100.iterator();
    L16:
        if (r112.hasNext() == false) goto L18;
        ((f) r112.next()).f16166a.a();
        boolean r105 = bs9.a.f20322a;
        goto L16
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void c(zr9.b r100) {
        List<zr9.b> r101 = this.f16149f;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f16149f).contains(r100) == true) goto L7;
        ((ArrayList) this.f16149f).add(r100);     // Catch: Throwable -> L9
        r100.getDescription();     // Catch: Throwable -> L9
        boolean r102 = bs9.a.f20322a;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public static void a(c r100, zr9.f r101) {
        List<zr9.b> r102 = r100.f16149f;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList(r100.f16149f);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        ((zr9.b) r104.next()).a(r101);
        goto L8
    L10:
        Objects.toString(r101);
        boolean r105 = bs9.a.f20322a;
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
