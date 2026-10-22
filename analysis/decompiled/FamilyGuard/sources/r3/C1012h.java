package r3;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.View;
import i4.InterfaceC0761a;

/* renamed from: r3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1012h {

    /* renamed from: g, reason: collision with root package name */
    private static final a f20024g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final View f20025a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0761a<V3.v> f20026b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20027c;

    /* renamed from: d, reason: collision with root package name */
    private long f20028d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20029e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f20030f;

    /* renamed from: r3.h$a */
    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1012h(View view, InterfaceC0761a<V3.v> interfaceC0761a) {
        j4.k.g(view, "view");
        j4.k.g(interfaceC0761a, "rebuild");
        this.f20025a = view;
        this.f20026b = interfaceC0761a;
        Context context = view.getContext();
        j4.k.f(context, "getContext(...)");
        this.f20027c = C1013i.a(context);
        this.f20030f = new Runnable() { // from class: r3.g
            @Override // java.lang.Runnable
            public final void run() {
                C1012h.d(this.f20023a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C1012h c1012h) {
        c1012h.f20029e = false;
        c1012h.f20028d = SystemClock.uptimeMillis();
        c1012h.f20026b.invoke();
    }

    public final void b() {
        this.f20025a.removeCallbacks(this.f20030f);
        this.f20029e = false;
    }

    public final void c(Configuration configuration) {
        j4.k.g(configuration, "newConfig");
        boolean z5 = (configuration.uiMode & 48) == 32;
        if (z5 == this.f20027c) {
            return;
        }
        this.f20027c = z5;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j5 = jUptimeMillis - this.f20028d;
        if (j5 >= 300) {
            this.f20028d = jUptimeMillis;
            this.f20026b.invoke();
        } else {
            if (this.f20029e) {
                return;
            }
            this.f20029e = true;
            this.f20025a.postDelayed(this.f20030f, 300 - j5);
        }
    }
}
