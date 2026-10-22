package r9;

import com.stepos.common.widget.StepSeekBar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public z3.g f10478a;

    /* renamed from: b, reason: collision with root package name */
    public z3.g f10479b;

    /* renamed from: c, reason: collision with root package name */
    public StepSeekBar f10480c;

    /* renamed from: d, reason: collision with root package name */
    public float f10481d;

    /* renamed from: e, reason: collision with root package name */
    public float f10482e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10483f;

    public final void a(boolean z10) {
        StepSeekBar stepSeekBar = this.f10480c;
        z3.g gVar = this.f10478a;
        if (gVar != null && gVar.f16365f) {
            gVar.b();
        }
        z3.g gVar2 = this.f10479b;
        if (gVar2 != null && gVar2.f16365f) {
            gVar2.b();
        }
        z3.g gVar3 = new z3.g(stepSeekBar, z3.g.f16355q);
        z3.h hVar = new z3.h();
        hVar.i = z10 ? this.f10482e : 1.0f;
        hVar.b(250.0f);
        hVar.a(0.89f);
        gVar3.f16369k = hVar;
        this.f10479b = gVar3;
        gVar3.g();
        z3.g gVar4 = new z3.g(stepSeekBar, z3.g.f16354p);
        z3.h hVar2 = new z3.h();
        hVar2.i = z10 ? this.f10481d : 1.0f;
        hVar2.b(250.0f);
        hVar2.a(0.89f);
        gVar4.f16369k = hVar2;
        this.f10478a = gVar4;
        gVar4.g();
    }
}
