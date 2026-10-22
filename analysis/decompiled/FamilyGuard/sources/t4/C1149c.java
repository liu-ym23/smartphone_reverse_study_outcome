package t4;

import V3.v;
import Z3.i;
import android.os.Handler;
import android.os.Looper;
import i4.InterfaceC0772l;
import j4.g;
import j4.k;
import j4.l;
import java.util.concurrent.CancellationException;
import s4.InterfaceC1080k;
import s4.Q;
import s4.W;
import s4.r0;

/* renamed from: t4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1149c extends d implements Q {

    /* renamed from: c, reason: collision with root package name */
    private final Handler f22697c;

    /* renamed from: d, reason: collision with root package name */
    private final String f22698d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f22699e;

    /* renamed from: f, reason: collision with root package name */
    private final C1149c f22700f;

    /* renamed from: t4.c$a */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1080k f22701a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C1149c f22702b;

        public a(InterfaceC1080k interfaceC1080k, C1149c c1149c) {
            this.f22701a = interfaceC1080k;
            this.f22702b = c1149c;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f22701a.d(this.f22702b, v.f5542a);
        }
    }

    /* renamed from: t4.c$b */
    static final class b extends l implements InterfaceC0772l<Throwable, v> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f22704b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable) {
            super(1);
            this.f22704b = runnable;
        }

        public final void b(Throwable th) {
            C1149c.this.f22697c.removeCallbacks(this.f22704b);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(Throwable th) {
            b(th);
            return v.f5542a;
        }
    }

    private C1149c(Handler handler, String str, boolean z5) {
        super(null);
        this.f22697c = handler;
        this.f22698d = str;
        this.f22699e = z5;
        this.f22700f = z5 ? this : new C1149c(handler, str, true);
    }

    private final void l0(i iVar, Runnable runnable) {
        r0.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        W.b().Y(iVar, runnable);
    }

    @Override // s4.AbstractC1056E
    public void Y(i iVar, Runnable runnable) {
        if (this.f22697c.post(runnable)) {
            return;
        }
        l0(iVar, runnable);
    }

    @Override // s4.AbstractC1056E
    public boolean c0(i iVar) {
        return (this.f22699e && k.b(Looper.myLooper(), this.f22697c.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1149c)) {
            return false;
        }
        C1149c c1149c = (C1149c) obj;
        return c1149c.f22697c == this.f22697c && c1149c.f22699e == this.f22699e;
    }

    public int hashCode() {
        return (this.f22699e ? 1231 : 1237) ^ System.identityHashCode(this.f22697c);
    }

    @Override // s4.x0
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C1149c h0() {
        return this.f22700f;
    }

    @Override // s4.Q
    public void r(long j5, InterfaceC1080k<? super v> interfaceC1080k) {
        a aVar = new a(interfaceC1080k, this);
        if (this.f22697c.postDelayed(aVar, kotlin.ranges.l.f(j5, 4611686018427387903L))) {
            interfaceC1080k.f(new b(aVar));
        } else {
            l0(interfaceC1080k.getContext(), aVar);
        }
    }

    @Override // s4.x0, s4.AbstractC1056E
    public String toString() {
        String strJ0 = j0();
        if (strJ0 == null) {
            strJ0 = this.f22698d;
            if (strJ0 == null) {
                strJ0 = this.f22697c.toString();
            }
            if (this.f22699e) {
                return strJ0 + ".immediate";
            }
        }
        return strJ0;
    }

    public /* synthetic */ C1149c(Handler handler, String str, int i5, g gVar) {
        this(handler, (i5 & 2) != 0 ? null : str);
    }

    public C1149c(Handler handler, String str) {
        this(handler, str, false);
    }
}
