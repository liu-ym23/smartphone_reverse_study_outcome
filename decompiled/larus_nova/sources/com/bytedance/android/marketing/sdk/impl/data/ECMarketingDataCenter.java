package com.bytedance.android.marketing.sdk.impl.data;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.marketing.sdk.impl.MarketingServiceImplV2;
import com.bytedance.android.marketing.sdk.impl.utils.CommonUtils;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ECMarketingDataCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, h> f162719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, com.bytedance.android.marketing.sdk.api.c> f162720b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Function0<Unit>> f162721c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f162722d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f162723e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, JSONObject> f162724f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Set<String>> f162725g = null;

    public ECMarketingDataCenter() {
    }

    static {
        f162719a = new LinkedHashMap();
        f162720b = new LinkedHashMap();
        f162721c = new LinkedHashMap();
        f162722d = SetsKt.setOf("ecom.marketing.event.scrolling");
        f162723e = new LinkedHashMap();
        f162724f = new LinkedHashMap();
        f162725g = new LinkedHashMap();
        int r100 = fx2.a.f479102a;
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r102 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "onForeground");
        Intrinsics.checkNotNullParameter(r102, "onBackground");
    }

    public static final void a(int r100) {
        Iterator r101 = ((LinkedHashMap) f162719a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) ((Map.Entry) r101.next()).getKey();
        MarketingServiceImplV2 r103 = new MarketingServiceImplV2();
        JsonObject r104 = new JsonObject();
        r104.addProperty("visible", Integer.valueOf(r100));
        r104.addProperty("source", "app");
        Unit r105 = Unit.INSTANCE;
        IMarketingServiceV2.a.b(r103, "ecom.marketing.event.pageVisibilityChange", r104, null, null, r102, 25);
        goto L4
    }

    public static h b(String r100) {
        if (ex2.d.a(r100) == true) goto L9;
        CommonUtils.f162812a.getClass();
        Activity r101 = CommonUtils.c();
        if (r101 == null) goto L8;
        r100 = String.valueOf(r101.hashCode());
        goto L9
    L8:
        r100 = null;
    L9:
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        Map<String, h> r102 = f162719a;
        h r103 = (h) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L15;
        h r104 = new h(r100);
        r102.put(r100, r104);
        return r104;
    L15:
        return r103;
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        return f162719a.containsKey(r100);
    }

    public static void e(final com.bytedance.android.marketing.sdk.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceBuilder");
        final String r101 = ex2.c.d(r100);
        final String r102 = r100.f162670a;
        Intrinsics.checkNotNullParameter(r100, "$this$getCompactLifeCycle");
        Fragment r103 = r100.f162685p;
        if (r103 == null) goto L6;
        final Lifecycle r104 = r103.getLifecycle();
    L20:
        if (r104 == null) goto L23;
        r104.addObserver(new ECMarketingDataCenter$setLifeObserver$1(r101, r102, r100, r104));
        return;
    L23:
        return;
    L6:
        if (r100.getActivity() == null) goto L13;
        Activity r105 = r100.getActivity();
        if ((r105 instanceof FragmentActivity) == true) goto L10;
        r105 = null;
    L10:
        FragmentActivity r106 = (FragmentActivity) r105;
        if (r106 == null) goto L19;
        r104 = r106.getLifecycle();
    L19:
        r104 = null;
        goto L20
    L13:
        CommonUtils.f162812a.getClass();
        Activity r107 = CommonUtils.c();
        if ((r107 instanceof FragmentActivity) == true) goto L16;
        r107 = null;
    L16:
        FragmentActivity r108 = (FragmentActivity) r107;
        if (r108 == null) goto L19;
        r104 = r108.getLifecycle();
        goto L20
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        if (f162722d.contains(r101) == true) goto L5;
        return true;
    L5:
        Map<String, Map<String, Long>> r102 = f162723e;
        if (r102.containsKey(r100) == true) goto L8;
        r102.put(r100, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r101, Long.valueOf(System.currentTimeMillis()))}));
    L8:
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L12;
        return true;
    L12:
        if (r103.containsKey(r101) == true) goto L14;
        r103.put(r101, Long.valueOf(System.currentTimeMillis()));
    L14:
        Long r104 = (Long) r103.get(r101);
        if (r104 != null) goto L17;
    L20:
        return true;
    L17:
        if ((System.currentTimeMillis() - r104.longValue()) >= 1000) goto L19;
        return false;
    L19:
        r103.put(r101, Long.valueOf(System.currentTimeMillis()));
        goto L20
    }
}
