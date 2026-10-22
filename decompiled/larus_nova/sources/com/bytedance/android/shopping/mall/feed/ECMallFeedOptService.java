package com.bytedance.android.shopping.mall.feed;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.data.entity.MallLynxSchemaConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.api.mall.common.tools.MallSchemaSetting;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedOptService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.api.mall.idl.b> f176833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f176835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f176836d;

    public static final class a {
    }

    static {
    }

    public ECMallFeedOptService() {
        this.f176833a = new ConcurrentHashMap();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f176834b = LazyKt.lazy(r100, ECMallFeedOptService$mallCardConfig$2.INSTANCE);
        this.f176835c = new LinkedHashMap();
        this.f176836d = LazyKt.lazy(r100, ECMallFeedOptService$mallSaasPreloadCardConfig$2.INSTANCE);
    }

    public final HashMap<String, Object> a() {
        yj.g r100 = com.bytedance.android.ec.hybrid.a.b();
        if (r100 == null) goto L5;
        com.bytedance.android.ec.hybrid.data.i r101 = r100.k();
    L6:
        HashMap<String, Object> r102 = new HashMap();
        boolean r103 = true;
        int r104 = 0;
        if (r101 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        r102.put("image_prefetch_first_screen_enable", Boolean.valueOf(r105));
        int r106 = 4;
        r102.put("image_prefetch_first_screen_count", 4);
        if (r101 != null) goto L16;
    L19:
        r102.put("image_prefetch_load_more_enable", Boolean.valueOf(r103));
        if (r101 == null) goto L22;
        r106 = r101.a();
    L22:
        r102.put("image_prefetch_load_more_count", Integer.valueOf(r106));
        if (r101 == null) goto L27;
        Integer r107 = r101.f46725g;
        if (r107 == null) goto L27;
        r104 = r107.intValue();
    L27:
        r102.put("image_prefetch_load_more_immediate", Integer.valueOf(r104));
        return r102;
    L16:
        if (r101.f46721c == true) goto L19;
        r103 = false;
        goto L19
    L9:
        if (r101.f46720b == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final Map<String, Object> b(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        boolean r102 = false;
        if (r100 == null) goto L20;
        Set<Map.Entry<String, String>> r103 = r100.entrySet();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        Map.Entry r105 = (Map.Entry) r104.next();
        if ((!StringsKt.isBlank((CharSequence) r105.getKey())) == false) goto L8;
        CharSequence r106 = (CharSequence) r105.getValue();
        if (r106 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == true) goto L8;
        Object r108 = r105.getKey();
        Object r109 = r105.getValue();
        Intrinsics.checkNotNull(r109);
        r101.put(r108, r109);
        goto L8
    L14:
        if (StringsKt.isBlank(r106) == true) goto L17;
        r107 = false;
    L20:
        if (r100 == null) goto L22;
        String r110 = r100.get("history_path");
    L23:
        if (r110 != null) goto L25;
    L26:
        r102 = true;
    L28:
        if (r102 == false) goto L33;
        if (r100 == null) goto L32;
        r110 = r100.get("enter_from");
        if (r110 != null) goto L33;
    L32:
        r110 = "";
    L33:
        r101.put("enter_from", r110);
        return r101;
    L25:
        if (StringsKt.isBlank(r110) == false) goto L28;
    L22:
        r110 = null;
        goto L23
    }

    public final List<com.bytedance.android.ec.hybrid.list.entity.p> c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "pageName");
        ArrayList r100 = new ArrayList();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L46
        ArrayList r102 = (ArrayList) ((Map) this.f176836d.getValue()).get(r110);     // Catch: Throwable -> L46
        Unit r103 = null;
        if (r102 == null) goto L44;
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L46
    L7:
        if (r104.hasNext() == false) goto L43;
        LinkedTreeMap r105 = (LinkedTreeMap) r104.next();     // Catch: Throwable -> L46
        Object r106 = r105.get(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE);     // Catch: Throwable -> L46
        if ((r106 instanceof Double) == true) goto L11;
        r106 = null;
    L11:
        Double r107 = (Double) r106;     // Catch: Throwable -> L46
        if (r107 == null) goto L7;
        int r108 = (int) r107.doubleValue();     // Catch: Throwable -> L46
        String r109 = (String) ((LinkedHashMap) this.f176835c).get(r110 + '_' + r108);     // Catch: Throwable -> L46
        if (r109 != null) goto L34;
        List<MallLynxSchemaConfig> r111 = ((MallSchemaSetting) this.f176834b.getValue()).getCardConfig();     // Catch: Throwable -> L46
        if (r111 == null) goto L34;
        Iterator<T> r112 = r111.iterator();     // Catch: Throwable -> L46
    L19:
        if (r112.hasNext() == false) goto L34;
        MallLynxSchemaConfig r113 = (MallLynxSchemaConfig) r112.next();     // Catch: Throwable -> L46
        Integer r114 = r113.getItemType();     // Catch: Throwable -> L46
        if (r114 == null) goto L19;
        if (r114.intValue() != r108) goto L19;
        String r115 = r113.getLynxSchema();     // Catch: Throwable -> L46
        if (r115 == null) goto L19;
        Uri.Builder r116 = UriProtector.parse("hybrid://lynxview").buildUpon();     // Catch: Throwable -> L46
        TreeMap r117 = d(r113.getQueryMap(), r105);     // Catch: Throwable -> L46
        r117.put("surl", r115);     // Catch: Throwable -> L46
        Iterator r118 = r117.keySet().iterator();     // Catch: Throwable -> L46
    L29:
        if (r118.hasNext() == false) goto L33;
        String r119 = (String) r118.next();     // Catch: Throwable -> L46
        Object r120 = r117.get(r119);     // Catch: Throwable -> L46
        if (r120 == null) goto L29;
        r116.appendQueryParameter(r119, r120.toString());     // Catch: Throwable -> L46
        goto L29
    L33:
        r109 = r116.build().toString();     // Catch: Throwable -> L46
        this.f176835c.put(r110 + '_' + r108, r109);     // Catch: Throwable -> L46
    L34:
        if (r109 == null) goto L7;
        Object r121 = r105.get("preload_num");     // Catch: Throwable -> L46
        if ((r121 instanceof Double) == true) goto L38;
        r121 = null;
    L38:
        Double r122 = (Double) r121;     // Catch: Throwable -> L46
        if (r122 == null) goto L41;
        int r123 = (int) r122.doubleValue();     // Catch: Throwable -> L46
    L42:
        r100.add(new com.bytedance.android.ec.hybrid.list.entity.p(r109, r123));     // Catch: Throwable -> L46
        goto L7
    L41:
        r123 = 1;
        goto L42
    L43:
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L46
    L48:
        return r100;
    L46:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    }

    public static TreeMap d(Map r100, LinkedTreeMap r101) {
        TreeMap r102 = new TreeMap();
        if (r100 == null) goto L5;
        r102.putAll(r100);
    L5:
        Iterator r103 = r101.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        String r104 = (String) r103.next();
        if ((!Intrinsics.areEqual(r104, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)) == false) goto L7;
        if ((!Intrinsics.areEqual(r104, "preload_num")) == false) goto L7;
        V r105 = r101.get(r104);
        if (r105 == 0) goto L7;
        r102.put(r104, r105);
        goto L7
    L15:
        return r102;
    }

    public final com.bytedance.android.shopping.api.mall.idl.b e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f176833a.remove(r100 + "_" + r101);
    }
}
