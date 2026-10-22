package W;

import android.view.View;

/* loaded from: classes.dex */
public final class f extends k {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1949c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, int i4) {
        super(str, 1);
        this.f1949c = i4;
    }

    @Override // I.h
    public final /* bridge */ /* synthetic */ float e(Object obj) {
        switch (this.f1949c) {
        }
        return h((View) obj);
    }

    @Override // I.h
    public final /* bridge */ /* synthetic */ void g(Object obj, float f4) {
        switch (this.f1949c) {
            case 2:
                i((View) obj, f4);
                break;
            case 3:
            case 4:
            case 7:
            default:
                i((View) obj, f4);
                break;
            case 5:
                i((View) obj, f4);
                break;
            case 6:
                i((View) obj, f4);
                break;
            case 8:
                i((View) obj, f4);
                break;
            case 9:
                i((View) obj, f4);
                break;
            case 10:
                i((View) obj, f4);
                break;
            case 11:
                i((View) obj, f4);
                break;
        }
    }

    public final float h(View view) {
        switch (this.f1949c) {
            case 2:
                return view.getAlpha();
            case 3:
            case 4:
            case 7:
            default:
                return view.getRotationY();
            case 5:
                return view.getTranslationX();
            case 6:
                return view.getTranslationY();
            case 8:
                return view.getScaleX();
            case 9:
                return view.getScaleY();
            case 10:
                return view.getRotation();
            case 11:
                return view.getRotationX();
        }
    }

    public final void i(View view, float f4) {
        switch (this.f1949c) {
            case 2:
                view.setAlpha(f4);
                break;
            case 3:
            case 4:
            case 7:
            default:
                view.setRotationY(f4);
                break;
            case 5:
                view.setTranslationX(f4);
                break;
            case 6:
                view.setTranslationY(f4);
                break;
            case 8:
                view.setScaleX(f4);
                break;
            case 9:
                view.setScaleY(f4);
                break;
            case 10:
                view.setRotation(f4);
                break;
            case 11:
                view.setRotationX(f4);
                break;
        }
    }
}
