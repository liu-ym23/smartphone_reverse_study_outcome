package stepos.support.v7.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p1 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Toolbar f12800a;

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        View view2 = (View) view.getParent();
        int i16 = (int) (this.f12800a.getResources().getDisplayMetrics().density * 56.0f);
        int i17 = i10 - i;
        if (i17 < i16) {
            int i18 = (i16 - i17) / 2;
            view2.setTouchDelegate(new TouchDelegate(new Rect(i - i18, i3, i10 + i18, i11), view));
        }
    }
}
