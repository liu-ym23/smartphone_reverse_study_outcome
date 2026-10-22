package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin;

import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class PromotionCardStyleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, AbsECLiveSkinBaseUIConfig>> f150712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f150713b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Map<String, AbsECLiveSkinBaseUIConfig>> f150714c = null;

    public static final class ButtonHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ECLiveSkinBtnUIConfig f150715a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy f150716b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy f150717c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Lazy f150718d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Lazy f150719e = null;

        static {
            List r100 = CollectionsKt.listOf(15);
            f150715a = new ECLiveSkinBtnUIConfig(new ECLiveSkinBaseViewUIConfig(new ECLiveSkinTextElement(13, CollectionsKt.listOf("#FFFFFFFF"), 500), null, new ECLiveSkinBackgroundElement(null, CollectionsKt.listOf(new String[]{"#FFFF005C", "#FFFF005C", "#FFFF3443", "#FFFF9624"}), 1, null), null, null, 26, null), new ECLiveSkinBaseViewUIConfig(new ECLiveSkinTextElement(13, CollectionsKt.listOf("#FFFFFFFF"), 500), null, new ECLiveSkinBackgroundElement(null, CollectionsKt.listOf(new String[]{"#80FF005C", "#80FF005C", "#80FF3443", "#80FF9624"}), 1, null), null, null, 26, null), r100);
            f150716b = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV1Enabled$2.INSTANCE);
            f150717c = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV1Disabled$2.INSTANCE);
            f150718d = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV2Enabled$2.INSTANCE);
            f150719e = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV2Disabled$2.INSTANCE);
        }

        public static List a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$convertToColorIntList");
            ArrayList r101 = new ArrayList();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Integer r103 = s.b((String) r102.next());
            if (r103 == null) goto L4;
            r101.add(r103);
            goto L4
        L8:
            return r101;
        }
    }

    static {
        f150712a = new LinkedHashMap();
        f150713b = LazyKt.lazy(PromotionCardStyleHelper$liveCardStyleConfigSettings$2.INSTANCE);
        f150714c = MapsKt.mapOf(TuplesKt.to("button", MapsKt.mapOf(TuplesKt.to("0", ButtonHelper.f150715a))));
    }
}
