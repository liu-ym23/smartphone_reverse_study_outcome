package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes5.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public a f41225a;

    public interface a {
        void onScrollChange(View view, int i10, int i11, int i12, int i13);
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        a aVar = this.f41225a;
        if (aVar != null) {
            aVar.onScrollChange(this, i10, i11, i12, i13);
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f41225a = aVar;
    }
}
