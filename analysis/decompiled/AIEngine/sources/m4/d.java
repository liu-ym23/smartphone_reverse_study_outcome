package m4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends g {
    @Override // m4.g
    public final <V extends View> int a(V v3, ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v3.getMeasuredWidth() + marginLayoutParams.leftMargin;
    }

    @Override // m4.g
    public final int b() {
        return 2;
    }

    @Override // m4.g
    public final ViewPropertyAnimator c(int i10, View view) {
        return view.animate().translationX(-i10);
    }
}
