package j;

import K.f0;
import android.view.View;
import androidx.appcompat.widget.g1;
import stepos.support.v7.widget.w0;

/* loaded from: classes.dex */
public final class l extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f13106e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13107f;

    /* renamed from: g, reason: collision with root package name */
    public int f13108g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f13109h;

    public /* synthetic */ l(int i4, int i5, Object obj) {
        this.f13106e = i5;
        this.f13109h = obj;
        this.f13108g = i4;
        this.f13107f = false;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        int i4 = this.f13106e;
        Object obj = this.f13109h;
        switch (i4) {
            case 0:
                int i5 = this.f13108g + 1;
                this.f13108g = i5;
                m mVar = (m) obj;
                if (i5 == mVar.f13110a.size()) {
                    f0 f0Var = mVar.f13113d;
                    if (f0Var != null) {
                        f0Var.c(null);
                    }
                    this.f13108g = 0;
                    this.f13107f = false;
                    mVar.f13114e = false;
                    break;
                }
                break;
            case 1:
                if (!this.f13107f) {
                    ((g1) obj).f3087a.setVisibility(this.f13108g);
                    break;
                }
                break;
            default:
                if (!this.f13107f) {
                    w0 w0Var = (w0) obj;
                    w0Var.f15201a.setVisibility(this.f13108g);
                    w0Var.f15201a.setMenuVisibility(this.f13108g);
                    if (this.f13108g == 4) {
                        w0Var.f15201a.requestLayout();
                        break;
                    }
                }
                break;
        }
    }

    @Override // C.b, K.f0
    public final void d(View view) {
        int i4 = this.f13106e;
        Object obj = this.f13109h;
        switch (i4) {
            case 0:
                if (!this.f13107f) {
                    this.f13107f = true;
                    f0 f0Var = ((m) obj).f13113d;
                    if (f0Var != null) {
                        f0Var.d(null);
                        break;
                    }
                }
                break;
            case 1:
                ((g1) obj).f3087a.setVisibility(0);
                break;
            default:
                ((w0) obj).f15201a.setVisibility(0);
                break;
        }
    }

    @Override // C.b, K.f0
    public final void onAnimationCancel() {
        switch (this.f13106e) {
            case 1:
                this.f13107f = true;
                break;
            case 2:
                this.f13107f = true;
                break;
        }
    }

    public l(m mVar) {
        this.f13106e = 0;
        this.f13109h = mVar;
        this.f13107f = false;
        this.f13108g = 0;
    }
}
