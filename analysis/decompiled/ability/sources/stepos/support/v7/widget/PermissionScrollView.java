package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public Q f6476a;

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i6, int i10, int i11) {
        super.onScrollChanged(i, i6, i10, i11);
        Q q5 = this.f6476a;
        if (q5 != null) {
            q5.onScrollChange(this, i, i6, i10, i11);
        }
    }

    public void setOnScrollChangeListener(Q q5) {
        this.f6476a = q5;
    }
}
