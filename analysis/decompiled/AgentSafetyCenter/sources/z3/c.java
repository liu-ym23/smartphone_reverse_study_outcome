package z3;

import android.view.View;
import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends c1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16350a;

    public /* synthetic */ c(int i) {
        this.f16350a = i;
    }

    @Override // t.c1
    public final float i(Object obj) {
        switch (this.f16350a) {
            case 0:
                return ((View) obj).getAlpha();
            case 1:
                return ((View) obj).getTranslationX();
            case 2:
                return ((View) obj).getTranslationY();
            case 3:
                return ((View) obj).getScaleX();
            case 4:
                return ((View) obj).getScaleY();
            case 5:
                return ((View) obj).getRotation();
            case 6:
                return ((View) obj).getRotationX();
            default:
                return ((View) obj).getRotationY();
        }
    }

    @Override // t.c1
    public final void m(float f5, Object obj) {
        switch (this.f16350a) {
            case 0:
                ((View) obj).setAlpha(f5);
                break;
            case 1:
                ((View) obj).setTranslationX(f5);
                break;
            case 2:
                ((View) obj).setTranslationY(f5);
                break;
            case 3:
                ((View) obj).setScaleX(f5);
                break;
            case 4:
                ((View) obj).setScaleY(f5);
                break;
            case 5:
                ((View) obj).setRotation(f5);
                break;
            case 6:
                ((View) obj).setRotationX(f5);
                break;
            default:
                ((View) obj).setRotationY(f5);
                break;
        }
    }
}
