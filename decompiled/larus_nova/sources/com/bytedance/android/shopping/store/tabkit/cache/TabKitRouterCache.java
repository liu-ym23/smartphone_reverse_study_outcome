package com.bytedance.android.shopping.store.tabkit.cache;

import com.bytedance.android.ec.core.opt.ab.p;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class TabKitRouterCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f186633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f186634b = null;

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) f186634b.getValue();
    }

    static {
        int r100 = hk3.a.f485544a;
        int r101 = p.f45243a;
        Object r102 = CollectionsKt.listOf(new String[]{"lifecycle_listener_id", "native_mall_launch_time", "native_mall_launch_type", "mall_open_page_time", "mall_homepage_open_time", "mall_click_enter_time", PhotoEnterModel.SOURCE_BTM_TOKEN, com.bytedance.android.ec.core.event.a.KEY_FE_FLAG});
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a("tabkit_deeplink_ignore_parameter", List.class, r102, false);     // Catch: Throwable -> L7
        if (r105 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        f186633a = (List) r105;
        f186634b = LazyKt.lazy(TabKitRouterCache$cache$2.INSTANCE);
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L12;
        r102 = r107;
    L12:
        r105 = r102;
        goto L13
    }

    public static a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter("ec_request_id_placeholder", "key");
        int r101 = PrefetchRequestState.NO_STORE.getValue();
        if (b().isEmpty() == true) goto L12;
        String r102 = c.a(r100);
        if (r102 == null) goto L12;
        b r103 = (b) b().get(r102);
        if (r103 == null) goto L12;
        r103.getClass();
    L12:
        return new a(null, r101);
    }

    public static JSONObject c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return null;
    L12:
        if (com.bytedance.android.shopping.store.tabkit.drainageprefetch.b.c(r100) == true) goto L14;
    L40:
        return null;
    L14:
        if (b().isEmpty() == true) goto L22;
        String r102 = c.a(r100);
        if (r102 == null) goto L22;
        b r103 = (b) b().get(r102);
        if (r103 == null) goto L22;
        Map<String, String> r104 = r103.f186637a;
    L23:
        if (r104 == null) goto L40;
        if (Intrinsics.areEqual(r104.get("prefetch_request_state"), String.valueOf(PrefetchRequestState.MATCH_SUCCESS_NORMAL.getValue())) == false) goto L27;
    L30:
        d(r100);
        JSONObject r105 = new JSONObject();
    L41:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L37
        Iterator<Map.Entry<String, String>> r107 = r104.entrySet().iterator();     // Catch: Throwable -> L37
    L33:
        if (r107.hasNext() == false) goto L35;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Throwable -> L37
        r105.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L37
        goto L33
    L35:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        return r105;
    L37:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L27:
        if (Intrinsics.areEqual(r104.get("prefetch_request_state"), String.valueOf(PrefetchRequestState.MATCH_SUCCESS_EXPIRED.getValue())) == true) goto L30;
        r105 = new JSONObject();
    L22:
        r104 = null;
        goto L23
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    public static JSONObject d(String r100) {
        if (b().isEmpty() == false) goto L5;
        return null;
    L5:
        if (r100 == null) goto L10;
        String r101 = c.a(r100);
        if (r101 == null) goto L10;
        b r102 = (b) b().get(r101);
    L10:
        return null;
    }
}
