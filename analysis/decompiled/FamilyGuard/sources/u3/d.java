package u3;

import V3.v;
import i4.InterfaceC0772l;
import i4.p;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final p<Float, Float, v> f22881a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0772l<Float, v> f22882b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0772l<Exception, v> f22883c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f22884d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22885e;

    /* renamed from: f, reason: collision with root package name */
    private Float f22886f;

    /* renamed from: g, reason: collision with root package name */
    private Float f22887g;

    /* JADX WARN: Multi-variable type inference failed */
    public d(p<? super Float, ? super Float, v> pVar, InterfaceC0772l<? super Float, v> interfaceC0772l, InterfaceC0772l<? super Exception, v> interfaceC0772l2) {
        j4.k.g(pVar, "applyAsymmetric");
        j4.k.g(interfaceC0772l, "applyUniform");
        j4.k.g(interfaceC0772l2, "onFailure");
        this.f22881a = pVar;
        this.f22882b = interfaceC0772l;
        this.f22883c = interfaceC0772l2;
        this.f22884d = true;
        this.f22885e = true;
    }

    public final void a() {
        this.f22884d = true;
        this.f22885e = true;
        this.f22886f = null;
        this.f22887g = null;
    }

    public final void b(float f5, float f6) {
        if (this.f22884d) {
            if (j4.k.a(this.f22886f, f5) && j4.k.a(this.f22887g, f6)) {
                return;
            }
            try {
                this.f22881a.invoke(Float.valueOf(f5), Float.valueOf(f6));
                this.f22886f = Float.valueOf(f5);
                this.f22887g = Float.valueOf(f6);
                return;
            } catch (Exception e6) {
                this.f22884d = false;
                this.f22886f = null;
                this.f22887g = null;
                this.f22883c.invoke(e6);
            }
        }
        if (!this.f22885e || j4.k.a(this.f22886f, f5)) {
            return;
        }
        try {
            this.f22882b.invoke(Float.valueOf(f5));
            this.f22886f = Float.valueOf(f5);
        } catch (Exception e7) {
            this.f22885e = false;
            this.f22883c.invoke(e7);
        }
    }
}
