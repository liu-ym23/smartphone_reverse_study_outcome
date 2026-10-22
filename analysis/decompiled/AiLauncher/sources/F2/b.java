package F2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: classes2.dex */
public final class b extends f {
    @Override // F2.f
    public <V extends View> int a(V v10, ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v10.getMeasuredHeight() + marginLayoutParams.bottomMargin;
    }

    @Override // F2.f
    public int b() {
        return 0;
    }

    @Override // F2.f
    public int c() {
        return 1;
    }

    @Override // F2.f
    public <V extends View> ViewPropertyAnimator d(V v10, int i10) {
        return v10.animate().translationY(i10);
    }

    @Override // F2.f
    public <V extends View> void e(V v10, int i10) {
        v10.setTranslationY(i10);
    }
}
