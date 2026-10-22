package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroSkinHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f148516a = 0;

    static {
    }

    public static void a(TextView r100, ECLiveSkinTextElement r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$applySkinConfig");
        Intrinsics.checkNotNullParameter(r101, "config");
        int r102 = r101.component1();
        List<String> r103 = r101.component2();
        int r104 = r101.component3();
        if (r102 <= 0) goto L5;
        r100.setTextSize(2, r102);
    L5:
        if (r103 == null) goto L7;
        List r105 = PromotionCardStyleHelper.ButtonHelper.a(r103);
    L9:
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == false) goto L17;
    L22:
        if (r104 <= 0) goto L25;
        c0.b(r100, r104);
        return;
    L25:
        return;
    L17:
        if (r105.size() != 1) goto L22;
        Integer r107 = (Integer) CollectionsKt.firstOrNull(r105);
        if (r107 == null) goto L22;
        r100.setTextColor(r107.intValue());
        goto L22
    L11:
        if (r105.isEmpty() == true) goto L14;
        r106 = false;
        goto L15
    L7:
        r105 = null;
        goto L9
    }

    public static void b(final PriceView r100, ECLiveSkinPriceUIConfig r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        final int r102 = r101.component1();
        final int r103 = r101.component2();
        final int r104 = r101.component3();
        final int r105 = r101.component4();
        final int r106 = r101.component5();
        final List<String> r107 = r101.component6();
        r100.C(new IntroSkinHelper$applySkinConfig$1(r100, r103, r107, r102, r104, r105, r106));
    }
}
