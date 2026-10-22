package r9;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.stepos.common.drawble.SurroundShaderDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10484a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ d f10485b;

    public /* synthetic */ b(int i) {
        this.f10484a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10484a) {
            case 0:
                b.b bVar = this.f10485b.f10498e.f10492g;
                if (bVar != null) {
                    ((SurroundShaderDrawable) bVar.f1685f).invalidateSelf();
                    break;
                }
                break;
            default:
                long jUptimeMillis = SystemClock.uptimeMillis();
                d dVar = this.f10485b;
                dVar.f10494a.setFloatUniform("time", (jUptimeMillis - dVar.f10495b) / 1000.0f);
                b.b bVar2 = dVar.f10498e.f10492g;
                if (bVar2 != null) {
                    ((SurroundShaderDrawable) bVar2.f1685f).invalidateSelf();
                    break;
                }
                break;
        }
    }
}
