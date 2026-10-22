package com.bytedance.android.ec.core.utils;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmUtilsKt {
    public static final JSONObject f(kc.a r110) {
        String r100 = null;
        if (r110 != null) goto L6;
        return null;
    L6:
        if (r110.f502353a.size() > 0) goto L8;
        return null;
    L8:
        kc.a.C6534a r101 = (kc.a.C6534a) CollectionsKt.getOrNull(r110.f502353a, 0);
        kc.a.C6534a r102 = (kc.a.C6534a) CollectionsKt.getOrNull(r110.f502353a, 1);
        kc.a.C6534a r103 = (kc.a.C6534a) CollectionsKt.getOrNull(r110.f502353a, 2);
        List r111 = CollectionsKt.reversed(r110.f502353a);
        JSONObject r104 = new JSONObject();
        List r112 = r111;
        r104.put("btm", CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, BtmUtilsKt$getBtmChain$btmChain$1$1.INSTANCE, 30, null));
        r104.put("btm_show_id", CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, BtmUtilsKt$getBtmChain$btmChain$1$2.INSTANCE, 30, null));
        JSONObject r113 = new JSONObject();
        if (r101 == null) goto L11;
        String r105 = r101.f502356c;
    L12:
        String r106 = "";
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r113.put("btm", r105);
        r113.put("btm_chain", r104);
        if (r103 == null) goto L18;
        String r107 = r103.f502356c;
    L19:
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        r113.put("btm_ppre", r107);
        if (r102 == null) goto L24;
        String r108 = r102.f502356c;
    L25:
        if (r108 != null) goto L27;
        r108 = "";
    L27:
        r113.put("btm_pre", r108);
        if (r101 == null) goto L30;
        r100 = r101.f502358e;
    L30:
        if (r100 == null) goto L33;
        r106 = r100;
    L33:
        r113.put("btm_show_id", r106);
        return r113;
    L24:
        r108 = null;
        goto L25
    L18:
        r107 = null;
        goto L19
    L11:
        r105 = null;
        goto L12
    }

    public static final List<String> g(kc.a r100) {
        if (r100 == null) goto L12;
        List<kc.a.C6534a> r101 = r100.f502353a;
        if (r101 == null) goto L12;
        List<kc.a.C6534a> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L17;
        String r105 = ((kc.a.C6534a) r104.next()).f502356c;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r103.add(r105);
        goto L7
    L17:
        return r103;
    L12:
        return null;
    }

    public static final com.bytedance.android.bst.api.d h(com.bytedance.android.bst.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeBuild");
        return r100.a();
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r100.f41913a = "c0.d0";
        return r100.a();
    }

    public static final com.bytedance.android.btm.api.model.d a(com.bytedance.android.btm.api.model.d r100, Map<String, ? extends Object> r101) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r101 != null) goto L7;
        return r100;
    L7:
        if (r100.f42024c != null) goto L9;
        r100.f42024c = new BcmParams();
    L9:
        BcmParams r102 = r100.f42024c;
        if (r102 == null) goto L12;
        BcmParams r103 = r102.merge(r101);
    L13:
        r100.f42024c = r103;
        return r100;
    L12:
        r103 = null;
        goto L13
    }

    public static final String b(String r100, com.bytedance.android.btm.api.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendSourceBtmToken");
        UrlBuilderV2 r102 = new UrlBuilderV2(r100);
        if (r101 == null) goto L8;
        String r103 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101);
        if (r103 == null) goto L9;
        r102.addOrReplaceParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r103);
        return r102.build();
    L9:
        return r100;
    L8:
        return r100;
    }

    public static final void c(UrlBuilderV2 r100, com.bytedance.android.btm.api.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendSourceBtmToken");
        if (r101 == null) goto L8;
        String r102 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101);
        if (r102 == null) goto L9;
        r100.addOrReplaceParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r102);
        return;
    L9:
        return;
    }

    public static final com.bytedance.android.btm.api.model.d e(String r100, PageFinder r101) {
        com.bytedance.android.btm.api.model.d r102 = new com.bytedance.android.btm.api.model.d();
        if (r100 == null) goto L5;
        r102.f42022a = r100;
    L5:
        if (r101 == null) goto L7;
        r102.f42023b = PageFinder.via(BtmSDK.INSTANCE.getPageId(r101));
    L7:
        return r102;
    }

    public static final com.bytedance.android.btm.api.model.d d(String r100, BcmParams r101, PageFinder r102) {
        com.bytedance.android.btm.api.model.d r103 = new com.bytedance.android.btm.api.model.d();
        if (r100 == null) goto L5;
        r103.f42022a = r100;
    L5:
        if (r102 == null) goto L7;
        r103.f42023b = PageFinder.via(BtmSDK.INSTANCE.getPageId(r102));
    L7:
        if (r101 == null) goto L9;
        r103.f42024c = r101;
    L9:
        return r103;
    }
}
