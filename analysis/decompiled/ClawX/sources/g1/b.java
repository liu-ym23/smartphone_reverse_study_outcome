package g1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2909a;

    @Override // a.a
    public final int L(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int measuredHeight;
        int i8;
        switch (this.f2909a) {
            case 0:
                measuredHeight = view.getMeasuredHeight();
                i8 = marginLayoutParams.bottomMargin;
                break;
            case 1:
                measuredHeight = view.getMeasuredWidth();
                i8 = marginLayoutParams.leftMargin;
                break;
            default:
                measuredHeight = view.getMeasuredWidth();
                i8 = marginLayoutParams.rightMargin;
                break;
        }
        return measuredHeight + i8;
    }

    @Override // a.a
    public final int M() {
        switch (this.f2909a) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    @Override // a.a
    public final ViewPropertyAnimator N(View view, int i8) {
        switch (this.f2909a) {
            case 0:
                return view.animate().translationY(i8);
            case 1:
                return view.animate().translationX(-i8);
            default:
                return view.animate().translationX(i8);
        }
    }
}
