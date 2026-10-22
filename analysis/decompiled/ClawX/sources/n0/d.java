package n0;

import android.view.View;
import k4.v;
import t1.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3947a;

    public /* synthetic */ d(int i8) {
        this.f3947a = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k4.v
    public final float R(x xVar) {
        switch (this.f3947a) {
            case 0:
                return ((View) xVar).getAlpha();
            case 1:
                return ((View) xVar).getScaleX();
            case 2:
                return ((View) xVar).getScaleY();
            case 3:
                return ((View) xVar).getRotation();
            case 4:
                return ((View) xVar).getRotationX();
            default:
                return ((View) xVar).getRotationY();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k4.v
    public final void l0(x xVar, float f3) {
        switch (this.f3947a) {
            case 0:
                ((View) xVar).setAlpha(f3);
                break;
            case 1:
                ((View) xVar).setScaleX(f3);
                break;
            case 2:
                ((View) xVar).setScaleY(f3);
                break;
            case 3:
                ((View) xVar).setRotation(f3);
                break;
            case 4:
                ((View) xVar).setRotationX(f3);
                break;
            default:
                ((View) xVar).setRotationY(f3);
                break;
        }
    }
}
