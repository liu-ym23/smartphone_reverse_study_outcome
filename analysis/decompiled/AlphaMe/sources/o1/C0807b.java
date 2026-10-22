package o1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import f1.AbstractC0557a;

/* renamed from: o1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0807b extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f13784i;

    public final int g0(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f13784i) {
            case 0:
                return view.getMeasuredHeight() + marginLayoutParams.bottomMargin;
            case 1:
                return view.getMeasuredWidth() + marginLayoutParams.leftMargin;
            default:
                return view.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
    }

    public final int h0() {
        switch (this.f13784i) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    public final ViewPropertyAnimator i0(int i4, View view) {
        switch (this.f13784i) {
            case 0:
                return view.animate().translationY(i4);
            case 1:
                return view.animate().translationX(-i4);
            default:
                return view.animate().translationX(i4);
        }
    }
}
