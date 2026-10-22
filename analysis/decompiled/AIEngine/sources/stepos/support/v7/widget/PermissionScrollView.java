package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public a f12541a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void onScrollChange(View view, int i10, int i11, int i12, int i13);
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        a aVar = this.f12541a;
        if (aVar != null) {
            aVar.onScrollChange(this, i10, i11, i12, i13);
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f12541a = aVar;
    }
}
