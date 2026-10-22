package stepos.support.v7.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* loaded from: classes4.dex */
public final class z0 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Toolbar f6649a;

    public z0(Toolbar toolbar) {
        this.f6649a = toolbar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        View view2 = (View) view.getParent();
        int i16 = (int) (this.f6649a.getResources().getDisplayMetrics().density * 56.0f);
        int i17 = i10 - i;
        if (i17 < i16) {
            int i18 = (i16 - i17) / 2;
            view2.setTouchDelegate(new TouchDelegate(new Rect(i - i18, i6, i10 + i18, i11), view));
        }
    }
}
