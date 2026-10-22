package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i {
    public static final Map<String, Object> a(String r100) {
        if (r100 == null) goto L24;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        int r103 = t0.f45720a;     // Catch: Throwable -> L12
        Object r104 = t0.a.f45721a.fromJson(r100, Map.class);     // Catch: Throwable -> L12
        if ((r104 instanceof Map) == true) goto L7;
        r104 = null;
    L7:
        Map r105 = (Map) r104;     // Catch: Throwable -> L12
        if (r105 != null) goto L10;
        r105 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r101 = r106;
    L18:
        Map r107 = (Map) r101;
        if (r107 != null) goto L21;
        r107 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r108 = MapsKt.mapOf(TuplesKt.to("slice_item_actions", r107));
        if (r108 == null) goto L24;
        return r108;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        return MapsKt.emptyMap();
    }

    public static final Map<String, Object> b(String r100) {
        if (r100 == null) goto L24;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        int r103 = t0.f45720a;     // Catch: Throwable -> L12
        Object r104 = t0.a.f45721a.fromJson(r100, Map.class);     // Catch: Throwable -> L12
        if ((r104 instanceof Map) == true) goto L7;
        r104 = null;
    L7:
        Map r105 = (Map) r104;     // Catch: Throwable -> L12
        if (r105 != null) goto L10;
        r105 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r101 = r106;
    L18:
        Map r107 = (Map) r101;
        if (r107 != null) goto L21;
        r107 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r108 = MapsKt.mapOf(TuplesKt.to("slice_item_extra", r107));
        if (r108 == null) goto L24;
        return r108;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        return MapsKt.emptyMap();
    }

    public static final Map<String, Object> c(String r100) {
        if (r100 == null) goto L24;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        int r103 = t0.f45720a;     // Catch: Throwable -> L12
        Object r104 = t0.a.f45721a.fromJson(r100, Map.class);     // Catch: Throwable -> L12
        if ((r104 instanceof Map) == true) goto L7;
        r104 = null;
    L7:
        Map r105 = (Map) r104;     // Catch: Throwable -> L12
        if (r105 != null) goto L10;
        r105 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r101 = r106;
    L18:
        Map r107 = (Map) r101;
        if (r107 != null) goto L21;
        r107 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r108 = MapsKt.toMutableMap(r107);
        if (r108 == null) goto L24;
        return r108;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        return new LinkedHashMap();
    }

    public static final ECUrlModel d(Map<String, ? extends Object> r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ECUrlModel r102 = new ECUrlModel();
        Object r103 = r100.get("uri");
        if (r103 == null) goto L8;
        String r104 = r103.toString();
    L9:
        r102.setUri(r104);
        Object r105 = r100.get(ScoreTags.STAR_URL_LIST);
        if ((r105 instanceof List) == true) goto L12;
        r105 = null;
    L12:
        r102.setUrlList((List) r105);
        Object r106 = r100.get("width");
        if ((r106 instanceof Number) == true) goto L15;
        r106 = null;
    L15:
        Number r107 = (Number) r106;
        int r108 = 0;
        if (r107 == null) goto L18;
        int r109 = r107.intValue();
    L19:
        r102.setWidth(r109);
        Object r110 = r100.get("height");
        if ((r110 instanceof Number) == true) goto L22;
        r110 = null;
    L22:
        Number r111 = (Number) r110;
        if (r111 == null) goto L25;
        r108 = r111.intValue();
    L25:
        r102.setHeight(r108);
        Object r112 = r100.get("url_key");
        if (r112 == null) goto L28;
        String r113 = r112.toString();
    L29:
        r102.setUrlKey(r113);
        Object r114 = r100.get("data_size");
        if ((r114 instanceof Number) == true) goto L32;
        r114 = null;
    L32:
        Number r115 = (Number) r114;
        if (r115 == null) goto L35;
        long r116 = r115.longValue();
    L36:
        r102.setSize(r116);
        Object r117 = r100.get(BarrageMaskInfo.KEY_MASK_FILE_HASH);
        if (r117 == null) goto L39;
        r101 = r117.toString();
    L39:
        r102.setFileHash(r101);
        return r102;
    L35:
        r116 = 0;
        goto L36
    L28:
        r113 = null;
        goto L29
    L18:
        r109 = 0;
        goto L19
    L8:
        r104 = null;
        goto L9
    }
}
