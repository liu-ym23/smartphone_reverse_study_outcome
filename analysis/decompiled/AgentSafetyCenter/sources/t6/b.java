package t6;

import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.LinearInterpolator;
import java.util.Iterator;
import java.util.List;
import n3.m1;
import n3.r0;
import n3.t0;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends r0 {

    /* renamed from: f, reason: collision with root package name */
    public View f13203f;

    /* renamed from: g, reason: collision with root package name */
    public int f13204g;

    /* renamed from: h, reason: collision with root package name */
    public int f13205h;
    public int[] i;

    @Override // n3.r0
    public final void e(t0 t0Var) {
        this.f13203f.setTranslationY(0.0f);
    }

    @Override // n3.r0
    public final void g() {
        View view = this.f13203f;
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        this.f13204g = iArr[1];
    }

    @Override // n3.r0
    public final m1 h(m1 m1Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            t0 t0Var = (t0) it.next();
            if ((((WindowInsetsAnimation) t0Var.f8753a.f49f).getTypeMask() & 8) != 0) {
                int i = this.f13205h;
                float interpolatedFraction = ((WindowInsetsAnimation) t0Var.f8753a.f49f).getInterpolatedFraction();
                LinearInterpolator linearInterpolator = q6.a.f10101a;
                this.f13203f.setTranslationY(Math.round(interpolatedFraction * (0 - i)) + i);
                break;
            }
        }
        return m1Var;
    }

    @Override // n3.r0
    public final u i(t0 t0Var, u uVar) {
        View view = this.f13203f;
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        int i = this.f13204g - iArr[1];
        this.f13205h = i;
        view.setTranslationY(i);
        return uVar;
    }
}
