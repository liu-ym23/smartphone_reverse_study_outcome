package a59;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public a() {
    }

    public static ItemGroup a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ItemGroup r101 = new ItemGroup(r100.getContext());
        r101.setBackgroundResource(R.drawable.larus_bg_bot_setting_group);
        r100.addView(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.width = -1;
        r103.height = -1;
        return r101;
    }

    public static ItemTextArrow b(ItemGroup r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "text");
        ItemTextArrow r102 = new ItemTextArrow(r100.getContext());
        r102.setText(r101);
        r102.setTextFontWeight(500);
        r100.addView(r102);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        r104.width = -1;
        r104.height = -2;
        return r102;
    }
}
