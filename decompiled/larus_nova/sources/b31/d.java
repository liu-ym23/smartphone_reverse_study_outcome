package b31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.ui.f;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public d() {
    }

    public static a a(s r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "barLayouts");
        int r100 = r110.f94821a;
        if (r100 == (-100)) goto L5;
        Integer r114 = Integer.valueOf(r100);
    L6:
        if (r114 == null) goto L21;
        int r101 = r114.intValue();
        int r102 = r110.f94822b;
        GravityDef r103 = GravityDef.CENTER_HORIZONTAL;
        if (r110.f94823c == false) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.ui.d r115 = r110.f94825e;
        if ((r115 instanceof com.bytedance.android.live.revlink.impl.multianchor.ui.e) == false) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.ui.e r116 = (com.bytedance.android.live.revlink.impl.multianchor.ui.e) r115;
        int r104 = (int) ((r111 + r116.f94800c) - ((r116.f94798a - r116.f94799b) / 2.0f));
    L15:
        int r105 = r104;
    L18:
        return new a(r101, r102, r105, 0, 0, r103);
    L13:
        if ((r115 instanceof f) == false) goto L16;
        r104 = r111 + ((f) r115).f94801a;
        goto L15
    L16:
        r105 = 0;
        goto L18
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.ui.c r117 = r110.f94824d;
        int r106 = r117.f94797b;
        return new a(r101, r102, (int) ((r111 - r106) - ((r117.f94796a - r106) / 2.0f)), 0, 0, r103);
    L21:
        return null;
    L5:
        r114 = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r112 - (r110.f94826f * 2), 0), RangesKt.coerceAtLeast(r113 - (r110.f94827g * 2), 0)));
        goto L6
    }
}
