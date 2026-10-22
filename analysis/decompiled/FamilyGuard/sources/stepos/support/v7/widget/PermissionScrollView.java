package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private a f21605a;

    public interface a {
        void onScrollChange(View view, int i5, int i6, int i7, int i8);
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        a aVar = this.f21605a;
        if (aVar != null) {
            aVar.onScrollChange(this, i5, i6, i7, i8);
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f21605a = aVar;
    }
}
