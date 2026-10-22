package r9;

import android.view.animation.PathInterpolator;
import com.stepos.common.animator.StepOSPressAnimationDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10500c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ z3.g f10501f;

    public /* synthetic */ e(int i) {
        this.f10500c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f10500c;
        z3.g gVar = this.f10501f;
        switch (i) {
            case 0:
                PathInterpolator pathInterpolator = StepOSPressAnimationDrawable.G;
                if (gVar != null) {
                    gVar.g();
                    break;
                }
                break;
            default:
                gVar.g();
                break;
        }
    }
}
