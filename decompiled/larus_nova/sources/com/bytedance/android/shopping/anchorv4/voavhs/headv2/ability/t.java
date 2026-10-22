package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t {
    public static final boolean a(s r100, int r101, Number r102, Number r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMatchCellRatio");
        AnchorV4HeadV2VO r104 = r100.K10();
        Float r105 = null;
        if (r104 == null) goto L9;
        List<HeaderContentModel> r106 = r104.getCells();
        if (r106 == null) goto L9;
        HeaderContentModel r107 = (HeaderContentModel) CollectionsKt.getOrNull(r106, r101);
        if (r107 == null) goto L9;
        Float r108 = r107.getWHScale(false);
    L10:
        if (r102 == null) goto L15;
        if (r103 == null) goto L15;
        if (r103.floatValue() <= 0) goto L15;
        r105 = Float.valueOf(r102.floatValue() / r103.floatValue());
    L15:
        if (r108 == null) goto L21;
        if (r105 != null) goto L18;
        return false;
    L18:
        if (Math.abs(r108.floatValue() - r105.floatValue()) >= 0.01f) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L9:
        r108 = null;
        goto L10
    }
}
