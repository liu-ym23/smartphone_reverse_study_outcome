package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class TabKitAbilityConfig {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Map<String, Object>> f186457d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f186458e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f186459f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f186460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f186461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TabKitRouterParams f186462c;

    public static final class a {
    }

    static {
        f186457d = new HashMap();
        f186458e = LazyKt.lazy(TabKitAbilityConfig$Companion$tabKitAbilityConfigJSON$2.INSTANCE);
        f186459f = LazyKt.lazy(TabKitAbilityConfig$Companion$globalAbilityConfigJSON$2.INSTANCE);
    }

    public TabKitAbilityConfig(TabKitRouterParams r110) {
        Intrinsics.checkNotNullParameter(r110, "tabKitRouterParams");
        this.f186462c = r110;
        this.f186460a = CollectionsKt.arrayListOf(new String[]{"na_prefetch_opt", "web_landing_opt", "web_nested_scroll", "btm_custom_page_v2", "enable_anniex_async_create", "disable_anniex_container", "disable_new_top_bar", "na_prefetch_sync_update", "na_prefetch_thread_opt", "tabkit_lite_page", "tabkit_anniex_force", "preload_anchor_url", "tabkit_fold_adapter", "tabkit_show_now"});
        this.f186461b = LazyKt.lazy(new TabKitAbilityConfig$expValueMap$2(this));
    }

    public final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String r101 = this.f186462c.getParamsMap().get(r100);
        Integer r102 = null;
        if (r101 == null) goto L6;
        Integer r103 = StringsKt.toIntOrNull(r101);
        if (r103 == null) goto L6;
    L14:
        if (r103 != null) goto L25;
        JSONObject r104 = (JSONObject) f186458e.getValue();
        if (r104 == null) goto L24;
        JSONObject r105 = r104.optJSONObject(this.f186462c.getBizTag());
        if (r105 == null) goto L24;
        Object r106 = r105.opt(r100);
        if (r106 == null) goto L24;
        String r107 = r106.toString();
        if (r107 == null) goto L24;
        r103 = StringsKt.toIntOrNull(r107);
    L24:
        r103 = null;
    L25:
        if (r103 != null) goto L33;
        JSONObject r108 = (JSONObject) f186459f.getValue();
        if (r108 == null) goto L34;
        Object r109 = r108.opt(r100);
        if (r109 == null) goto L34;
        String r110 = r109.toString();
        if (r110 == null) goto L34;
        r102 = StringsKt.toIntOrNull(r110);
    L34:
        if (r102 != null) goto L38;
        return 0;
    L38:
        return r102.intValue();
    L33:
        r102 = r103;
    L6:
        Map r111 = (Map) this.f186461b.getValue();
        if (r111 == null) goto L13;
        Object r112 = r111.get(this.f186462c.getBizTag() + '_' + r100);
        if (r112 == null) goto L13;
        String r113 = r112.toString();
        if (r113 == null) goto L13;
        r103 = StringsKt.toIntOrNull(r113);
    L13:
        r103 = null;
        goto L14
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual("tabkit_anniex_force", r100) == false) goto L8;
        cl.d.f24079a.getClass();
        cl.d r101 = cl.d.a.b();
        if (r101 == null) goto L8;
        r101.n();
    L8:
        if (a(r100) <= 0) goto L10;
        return true;
    L10:
        return false;
    }
}
