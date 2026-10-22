package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: c, reason: collision with root package name */
    public k0 f12612c;

    public PermissionScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnScrollChangeListener(new r2.i(12));
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i3, int i10, int i11) {
        super.onScrollChanged(i, i3, i10, i11);
        k0 k0Var = this.f12612c;
        if (k0Var != null) {
            k0Var.onScrollChange(this, i, i3, i10, i11);
        }
    }

    public void setOnScrollChangeListener(k0 k0Var) {
        this.f12612c = k0Var;
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PermissionScrollView(Context context) {
        super(context);
    }
}
