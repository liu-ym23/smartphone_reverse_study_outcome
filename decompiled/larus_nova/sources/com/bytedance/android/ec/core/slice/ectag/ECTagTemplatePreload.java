package com.bytedance.android.ec.core.slice.ectag;

import android.content.Context;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.forest.Forest;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECTagTemplatePreload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f45328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Map<String, String>> f45329b = null;

    static {
        List r100 = CollectionsKt.listOf(new String[]{"bgc_text", "border_image_text", "border_image_text_splitter_text", "border_image_text_splitter_text_v2", "border_splitter_text", "border_splitter_text_v2", "border_splitter_text_v3", "border_text", "border_text_v2", "image", "image_bgc_text", "image_bgc_text_v2", "image_bgc_text_v3", "image_bgc_text_v4", "image_only_text", "image_only_text_splitter", "image_text_splitter_border", "image_text_splitter_border_v2", "live_border_splitter_text", "live_image_only_text_splitter", "only_text", "only_text_splitter"});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        r101.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("name", r103), TuplesKt.to("url", "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/etag_template/" + r103 + "/main.json")}));
        goto L4
    L6:
        f45329b = r101;
    }

    public static void a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        dm.a.a("ECTagTemplatePreload").i("start preload,hasPreload:" + f45328a);
        if (f45328a == false) goto L5;
        return;
    L5:
        SlcGeckoTemplateMgr r102 = SlcGeckoTemplateMgr.f51232l;
        Forest r103 = wh.a.b(r100);
        if (r101 == false) goto L8;
        ECTagTemplatePreload$preload$1 r104 = null;
    L9:
        SlcGeckoTemplateMgr.f(r102, "native_ectag", "etag_template", r103, r104);
        f45328a = true;
        return;
    L8:
        r104 = ECTagTemplatePreload$preload$1.INSTANCE;
        goto L9
    }
}
