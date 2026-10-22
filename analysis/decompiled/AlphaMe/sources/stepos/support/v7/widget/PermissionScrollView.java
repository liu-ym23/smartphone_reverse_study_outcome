package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public L f14854a;

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        L l4 = this.f14854a;
        if (l4 != null) {
            l4.onScrollChange(this, i4, i5, i6, i7);
        }
    }

    public void setOnScrollChangeListener(L l4) {
        this.f14854a = l4;
    }
}
