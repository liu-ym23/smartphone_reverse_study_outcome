package c08;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.component.ui.list.iconitem.IconItemView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements b08.b<IconItemView, b> {
    public a() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        IconItemView r101 = (IconItemView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        ImageView r102 = r101.f284239b;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        TextView r103 = r101.f284240c;
        if (r103 == null) goto L8;
        r103.setVisibility(8);
    L8:
        TextView r104 = r101.f284242e;
        if (r104 == null) goto L12;
        r104.setVisibility(8);
        return;
    }

    @Override // b08.b
    public final void bind(View r100, b r101) {
        IconItemView r102 = (IconItemView) r100;
        b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ImageView r104 = r102.f284239b;
        r104.setVisibility(8);
        TextView r105 = r102.f284240c;
        r105.setVisibility(8);
        TextView r106 = r102.f284242e;
        r106.setVisibility(8);
        Drawable r107 = r103.f21955a;
        if (r107 == null) goto L5;
        r104.setImageDrawable(r107);
        r104.setVisibility(0);
    L5:
        String r108 = r103.f21956b;
        if (r108 == null) goto L8;
        r105.setText(r108);
        r105.setVisibility(0);
    L8:
        String r109 = r103.f21957c;
        if (r109 == null) goto L11;
        r106.setText(r109);
        r106.setVisibility(0);
    L11:
        Integer r110 = r103.f21958d;
        if (r110 == null) goto L15;
        int r111 = r110.intValue();
        ViewGroup.LayoutParams r112 = r102.f284243f.getLayoutParams();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        r113.setMarginStart(r111);
        r102.f284243f.setLayoutParams(r113);
        r102.requestLayout();
        return;
    }
}
