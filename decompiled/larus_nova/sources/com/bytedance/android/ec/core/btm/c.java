package com.bytedance.android.ec.core.btm;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final a h(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$buildBTMFields");
        Object r101 = r100.get("btm_code");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r103 = (String) r101;
        Object r104 = r100.get("bcm_context");
        if ((r104 instanceof Map) == false) goto L10;
        r102 = r104;
    L10:
        return new a(r103, (Map) r102);
    }

    public static final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmToken");
        if (a2.d(r101) != null) goto L5;
        return r100;
    L5:
        return p0.g(r100, PhotoEnterModel.SOURCE_BTM_TOKEN, r101);
    }

    public static void g(IOrderSchema r100, PageFinder r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmTokenWithPageFinder");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        String r102 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b5267.c7323.d7439", r101, null));
        if (r102 == null) goto L6;
        r100.replaceOrAppendParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r102);
        return;
    }

    public static final String i(View r100, Pair... r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r102 = new LinkedHashMap();
        MapsKt.putAll(r102, SequencesKt.filterNotNull(ArraysKt.asSequence(r101)));
        BcmParams.Companion.getClass();
        BcmParams r103 = BcmParams.a.c(r102);
        return a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b8094.c7963.d2435", PageFinder.via(r100), r103));
    }

    public static final Uri a(Uri r100, View r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmToken");
        if (r102 != null) goto L5;
        return r100;
    L5:
        if (r102.b() == null) goto L16;
        BtmSDK r103 = BtmSDK.INSTANCE;
        String r104 = r102.b();
        PageFinder r105 = PageFinder.via(r101);
        BcmParams.a r106 = BcmParams.Companion;
        Map<String, Object> r107 = r102.a();
        r106.getClass();
        String r108 = a2.d(r103.createJumpSourceBtmToken(r104, r105, BcmParams.a.c(r107)));
        if (r108 == null) goto L15;
        Uri r109 = p0.e(r100, PhotoEnterModel.SOURCE_BTM_TOKEN, r108);
        if (r109 != null) goto L13;
        return r100;
    L13:
        return r109;
    L15:
        return r100;
    L16:
        return r100;
    }

    public static final void e(IOrderSchema r100, View r101, Pair... r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r102, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        MapsKt.putAll(r103, SequencesKt.filterNotNull(ArraysKt.asSequence(r102)));
        BcmParams.Companion.getClass();
        BcmParams r104 = BcmParams.a.c(r103);
        String r105 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b5267.c7323.d7439", PageFinder.via(r101), r104));
        if (r105 == null) goto L6;
        r100.replaceOrAppendParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r105);
        return;
    }

    public static String f(String r100, PageFinder r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmTokenWithPageFinder");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        String r103 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r102, r101, null));
        if (r103 == null) goto L9;
        String r104 = d(r100, r103);
        if (r104 != null) goto L8;
        return r100;
    L8:
        return r104;
    L9:
        return r100;
    }

    public static final String b(String r100, View r101, String r102, BcmParams r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r103, "bcmParams");
        if (r102 != null) goto L5;
        return r100;
    L5:
        String r104 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r102, PageFinder.via(r101), r103));
        if (r104 == null) goto L12;
        String r105 = d(r100, r104);
        if (r105 != null) goto L11;
        return r100;
    L11:
        return r105;
    L12:
        return r100;
    }

    public static final String c(String r100, View r101, String r102, Pair<String, ? extends Object>... r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r102 != null) goto L5;
        return r100;
    L5:
        LinkedHashMap r104 = new LinkedHashMap();
        MapsKt.putAll(r104, SequencesKt.filterNotNull(ArraysKt.asSequence(r103)));
        BcmParams.Companion.getClass();
        BcmParams r105 = BcmParams.a.c(r104);
        String r106 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r102, PageFinder.via(r101), r105));
        if (r106 == null) goto L12;
        String r107 = d(r100, r106);
        if (r107 != null) goto L11;
        return r100;
    L11:
        return r107;
    L12:
        return r100;
    }
}
