package c08;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.list.iconitem.IconItemView;
import com.larksuite.component.ui.tag.TagsDrawable;
import com.larksuite.component.ui.tag.e;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements b08.b<IconItemView, d> {
    public c() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        IconItemView r101 = (IconItemView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        TextView r102 = r101.f284241d;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        return;
    }

    @Override // b08.b
    public final void bind(View r110, d r111) {
        IconItemView r112 = (IconItemView) r110;
        d r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "view");
        Intrinsics.checkNotNullParameter(r113, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        TextView r100 = r112.f284241d;
        r100.setVisibility(8);
        String r101 = r113.f21960b;
        if (r101 == null) goto L5;
        r100.setText(r101);
        r100.setTextColor(ContextCompat.getColor(r112.getContext(), r113.f21962d));
        r100.setVisibility(0);
    L5:
        Context r114 = r112.getContext();
        Intrinsics.checkNotNull(r114);
        TagsDrawable.a r102 = new TagsDrawable.a(r114);
        if (r113.f21961c == false) goto L15;
        TagsDrawable.d.a r103 = new TagsDrawable.d.a(r114);
        r103.f284418c = 100;
        Drawable r104 = AppCompatResources.getDrawable(r114, R.drawable.icon_right_arrow);
        if (r104 != null) goto L11;
    L14:
        TagsDrawable.d r105 = new TagsDrawable.d(r103);
        Intrinsics.checkNotNullParameter(r105, "tag");
        ((ArrayList) r102.f284407g).add(r105);
        r100.setVisibility(0);
        goto L15
    L11:
        if ((r104 instanceof UDTagsDrawable) == false) goto L13;
        r103.f284420e = r104;
        goto L14
    L13:
        r103.f284420e = new TagsDrawable.c(r104);
    L15:
        Drawable r115 = r113.f21959a;
        if (r115 == null) goto L22;
        TagsDrawable.d.a r106 = new TagsDrawable.d.a(r114);
        r106.f284418c = 0;
        if ((r115 instanceof UDTagsDrawable) == false) goto L20;
        r106.f284420e = r115;
    L21:
        TagsDrawable.d r116 = new TagsDrawable.d(r106);
        Intrinsics.checkNotNullParameter(r116, "tag");
        ((ArrayList) r102.f284407g).add(r116);
        r100.setVisibility(0);
        goto L22
    L20:
        r106.f284420e = new TagsDrawable.c(r115);
    L22:
        ArrayList r117 = (ArrayList) r102.f284407g;
        if (r117.size() <= 1) goto L25;
        CollectionsKt.sortWith(r117, new e());
    L25:
        HashSet r118 = new HashSet();
        int r119 = r102.f284408h.size();
        List<TagsDrawable.d> r107 = r102.f284407g;
        ArrayList r108 = new ArrayList();
        Iterator r109 = ((ArrayList) r107).iterator();
    L27:
        if (r109.hasNext() == false) goto L40;
        Object r120 = r109.next();
        TagsDrawable.d r121 = (TagsDrawable.d) r120;
        boolean r122 = r118.contains(Integer.valueOf(r121.f284412a));
        if (r122 == true) goto L38;
        if (r119 <= 0) goto L38;
        Iterator<HashSet<Integer>> r123 = r102.f284408h.iterator();
    L33:
        if (r123.hasNext() == false) goto L38;
        HashSet<Integer> r124 = r123.next();
        if (r124.contains(Integer.valueOf(r121.f284412a)) == false) goto L33;
        r118.addAll(r124);
        r119 = r119 - 1;
    L38:
        if ((!r122) == false) goto L27;
        r108.add(r120);
        goto L27
    L40:
        ((ArrayList) r102.f284407g).clear();
        ((ArrayList) r102.f284407g).addAll(r108);
        if (((ArrayList) r102.f284407g).isEmpty() == false) goto L43;
        TagsDrawable r125 = null;
    L44:
        r100.setCompoundDrawables(null, null, r125, null);
        return;
    L43:
        r125 = new TagsDrawable(r102);
        goto L44
    }
}
