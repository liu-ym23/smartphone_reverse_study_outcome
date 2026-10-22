package k;

import m.v2;
import n3.p0;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6850g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6851h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6852j;

    public /* synthetic */ j(int i) {
        this.f6850g = i;
    }

    @Override // ac.a, n3.p0
    public void a() {
        switch (this.f6850g) {
            case 1:
                this.f6851h = true;
                break;
            case 2:
                this.f6851h = true;
                break;
        }
    }

    @Override // ac.a, n3.p0
    public final void c() {
        switch (this.f6850g) {
            case 0:
                if (!this.f6851h) {
                    this.f6851h = true;
                    p0 p0Var = ((k) this.f6852j).f6856d;
                    if (p0Var != null) {
                        p0Var.c();
                        break;
                    }
                }
                break;
            case 1:
                ((v2) this.f6852j).f8097a.setVisibility(0);
                break;
            default:
                ((v1) this.f6852j).f12871a.setVisibility(0);
                break;
        }
    }

    @Override // n3.p0
    public final void d() {
        switch (this.f6850g) {
            case 0:
                int i = this.i + 1;
                this.i = i;
                k kVar = (k) this.f6852j;
                if (i == kVar.f6853a.size()) {
                    p0 p0Var = kVar.f6856d;
                    if (p0Var != null) {
                        p0Var.d();
                    }
                    this.i = 0;
                    this.f6851h = false;
                    kVar.f6857e = false;
                    break;
                }
                break;
            case 1:
                if (!this.f6851h) {
                    ((v2) this.f6852j).f8097a.setVisibility(this.i);
                    break;
                }
                break;
            default:
                int i3 = this.i;
                Toolbar toolbar = ((v1) this.f6852j).f12871a;
                if (!this.f6851h) {
                    toolbar.setVisibility(i3);
                    toolbar.setMenuVisibility(i3);
                    if (i3 == 4) {
                        toolbar.requestLayout();
                        break;
                    }
                }
                break;
        }
    }
}
