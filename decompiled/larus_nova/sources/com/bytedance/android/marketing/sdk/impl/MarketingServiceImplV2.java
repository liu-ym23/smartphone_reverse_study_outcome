package com.bytedance.android.marketing.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.marketing.sdk.impl.api.GrowthApi;
import com.bytedance.android.marketing.sdk.impl.api.MarketingResourceRequestBody;
import com.bytedance.android.marketing.sdk.impl.api.MarketingResourceResponse;
import com.bytedance.android.marketing.sdk.impl.data.ECMarketingDataCenter;
import com.bytedance.android.marketing.sdk.impl.data.SourceFrom;
import com.bytedance.android.marketing.sdk.impl.data.TrackData;
import com.bytedance.android.marketing.sdk.impl.data.h;
import com.bytedance.android.marketing.sdk.impl.utils.CommonUtils;
import com.bytedance.android.marketing.sdk.impl.utils.ECMarketingErrorType;
import com.bytedance.android.marketing.sdk.impl.utils.b;
import com.bytedance.android.marketing.sdk.impl.utils.e;
import com.bytedance.android.marketing.sdk.impl.utils.f;
import com.bytedance.android.marketing.sdk.impl.utils.i;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fx2.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/MarketingServiceImplV2;", "Lcom/bytedance/android/marketing/sdk/api/IMarketingServiceV2;", "<init>", "()V", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingServiceImplV2 implements IMarketingServiceV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> f162689a;

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final String a() {
        CommonUtils.f162812a.getClass();
        Activity r100 = CommonUtils.c();
        if (r100 != null) goto L5;
        return "";
    L5:
        if ("marketing_plan_report_records_cart_popup".length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return "";
    L10:
        SharedPreferences r102 = r100.getSharedPreferences("xbridge-storage", 0);
        if (r102 != null) goto L13;
        return "";
    L13:
        String r103 = r102.getString("marketing_plan_report_records_cart_popup", SliceInitService.DEFAULT_SWITCH);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        Gson r105 = f.f162817a;     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl((MarketingStorageValue) f.a(r103, MarketingStorageValue.class));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
        r106 = null;
    L21:
        MarketingStorageValue r107 = (MarketingStorageValue) r106;
        if (r107 == null) goto L31;
        String r108 = r107.getValue();
        if (r108 != null) goto L27;
        return "";
    L27:
        return r108;
    L31:
        return "";
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final String c() {
        int r100 = c.f479103a;
        CommonUtils.f162812a.getClass();
        Activity r101 = CommonUtils.c();
        if (r101 == null) goto L18;
        SharedPreferences r102 = r101.getSharedPreferences("xbridge-storage", 0);
        if (r102 != null) goto L7;
        return SliceInitService.DEFAULT_SWITCH;
    L7:
        LinkedHashMap r103 = new LinkedHashMap();
        List r104 = CollectionsKt.listOf(new String[]{"plan_report_records_v2", "joint_plan_report_records"});
        ArrayList r105 = new ArrayList();
        r105.addAll(r104);
        Iterator r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L17;
        String r107 = (String) r106.next();
        String r108 = r102.getString(r107, SliceInitService.DEFAULT_SWITCH);
        Gson r109 = f.f162817a;
        MarketingStorageValue r110 = (MarketingStorageValue) f.a(r108, MarketingStorageValue.class);
        if (r110 == null) goto L14;
        String r111 = r110.getValue();
        if (r111 == null) goto L14;
    L15:
        r103.put(r107, r111);
    L14:
        r111 = "";
        goto L15
    L17:
        return f.d(r103);
    L18:
        return SliceInitService.DEFAULT_SWITCH;
    }

    public MarketingServiceImplV2() {
        this.f162689a = MarketingServiceImplV2$getCardPosition$1.INSTANCE;
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final Function1<Map<String, ? extends Object>, Map<String, Object>> d() {
        return this.f162689a;
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final void h(Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162689a = r100;
    }

    public static final String i(MarketingServiceImplV2 r100, MarketingResourceResponse r101) {
        r100.getClass();
        JsonObject r102 = new JsonObject();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        MarketingResourceResponse.Data r104 = r101.getData();     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        Map<String, String> r105 = r104.getBizParamsMap();     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Throwable -> L15
        String r108 = r107.getKey();     // Catch: Throwable -> L15
        Gson r109 = f.f162817a;     // Catch: Throwable -> L15
        r102.add(r108, (JsonElement) f.a(r107.getValue(), JsonObject.class));     // Catch: Throwable -> L15
        goto L9
    L11:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L15
    L17:
        String r111 = r102.toString();
        i.a(new String[]{"最后得到PageData： ", r111});
        return r111;
    L12:
        r110 = null;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static String l(String r100, Context r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        return r100;
    L11:
        if ((r101 instanceof Activity) == true) goto L13;
        r101 = null;
    L13:
        Activity r103 = (Activity) r101;
        if (r103 != null) goto L16;
        CommonUtils.f162812a.getClass();
        r103 = CommonUtils.c();
    L16:
        if (r103 == null) goto L19;
        String r104 = String.valueOf(r103.hashCode());
        if (r104 == null) goto L19;
        return r104;
    L19:
        return "";
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final String e(com.bytedance.android.marketing.sdk.api.c r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceBuilder");
        return m(r100, SourceFrom.CLIENT.getValue(), r101);
    }

    public final void j(Context r100, boolean r101, String r102) {
        String r103 = l(r102, r100);     // Catch: Exception -> L6
        Map<String, h> r104 = ECMarketingDataCenter.f162719a;     // Catch: Exception -> L6
        if (ECMarketingDataCenter.d(r103) == false) goto L9;
        ECMarketingDataCenter.b(r103).a(null, null, r101);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public final String m(final com.bytedance.android.marketing.sdk.api.c r110, String r111, final Function2<? super String, ? super String, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "serviceBuilder");
        Intrinsics.checkNotNullParameter(r111, "loadEntryType");
        ji.a r100 = b.f162814a;
        Map<String, Object> r101 = r110.f162681l;
        Intrinsics.checkNotNullParameter(r101, "bizParams");
        b.b("[LIFECYCLE][REGISTER]");
        b.b("bizParams ==>  " + new JSONObject(r101));
        final String r102 = ex2.c.d(r110);
        Map<String, h> r103 = ECMarketingDataCenter.f162719a;
        final h r104 = ECMarketingDataCenter.b(r102);
        r104.f162801g = false;
        r104.f162802h.setEnterFrom(ex2.c.b(r110));
        r104.f162802h.setPageName(ex2.c.e(r110));
        TrackData r105 = r104.f162802h;
        Object r113 = null;
        String r106 = ex2.c.f(r110, null);
        if (Intrinsics.areEqual(r111, SourceFrom.CLIENT.getValue()) == true) goto L7;
        r106 = null;
    L7:
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        r105.setServicePageName(r106);
        r104.f162802h.setLoadEntryType(r111);
        r104.f162802h.setHitCache(1);
        r104.f162802h.setTRegisterTime(System.currentTimeMillis());
        r104.f162802h.setTNetStart(System.currentTimeMillis());
        ECMarketingDataCenter.f162720b.put(r102, r110);
        GrowthApi r114 = (GrowthApi) n.f48128a.create("https://growth.ecombdapi.com", GrowthApi.class);
        Function2<MarketingResourceResponse, String, Unit> r115 = new MarketingServiceImplV2$registerAsyncWithEntryType$1(this, r104, r110, r102, r112);
        Function1<String, Unit> r107 = new MarketingServiceImplV2$registerAsyncWithEntryType$2(r104, r110, r112);
        Intrinsics.checkNotNullParameter(r110, "serviceBuilder");
        Intrinsics.checkNotNullParameter(r115, "onSuccess");
        Intrinsics.checkNotNullParameter(r107, LynxVideoManagerLite.EVENT_ON_ERROR);
        int r108 = c.f479103a;
        Object r109 = r110.f162681l.get("page_name");
        if ((r109 instanceof String) == false) goto L13;
        r113 = r109;
    L13:
        String r116 = (String) r113;
        if (r116 != null) goto L16;
        r116 = "";
    L16:
        ArrayList r117 = new ArrayList();
        List r118 = CollectionsKt.emptyList();
        if (r118.isEmpty() == false) goto L20;
        r118 = CollectionsKt.emptyList();
    L20:
        if (r118.isEmpty() == false) goto L22;
        r117.add(r116.concat("_widget"));
        r117.add(r116.concat("_popup"));
    L26:
        MarketingResourceRequestBody.CommonCtx r119 = new MarketingResourceRequestBody.CommonCtx(new MarketingResourceRequestBody.SceneInfo(0, "", r117, ex2.c.b(r110)));
        CommonUtils.f162812a.getClass();
        String r120 = CommonUtils.b().toString();
        HashMap r121 = new HashMap(r110.f162681l);
        r121.put("ec_marketing_page_id", ex2.c.d(r110));
        MarketingResourceRequestBody.ExtraInfo r122 = new MarketingResourceRequestBody.ExtraInfo(r120, k.b(r121).toString());
        if (r110.getActivity() == null) goto L29;
        Context r123 = r110.getActivity();
    L33:
        if (r123 == null) goto L37;
        int r124 = c.f479103a;
        if (r123.getSharedPreferences("xbridge-storage", 0) == null) goto L37;
        String r125 = f.d(new LinkedHashMap());
    L39:
        r114.getMarketingResource(MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")), new MarketingResourceRequestBody(r119, 1, r122, r125)).enqueue(new com.bytedance.android.marketing.sdk.impl.api.a(r115, r107));
        return r102;
    L37:
        r125 = SliceInitService.DEFAULT_SWITCH;
        goto L39
    L29:
        Fragment r126 = r110.f162685p;
        if (r126 == null) goto L32;
        r123 = r126.getContext();
        goto L33
    L32:
        r123 = CommonUtils.c();
        goto L33
    L22:
        Iterator r127 = r118.iterator();
    L24:
        if (r127.hasNext() == false) goto L26;
        r117.add((String) r127.next());
        goto L24
    }

    public static void k(String r100, String r101, String r102, boolean r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r104, "callBack");
        if (r100 != null) goto L18;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r104.invoke("error: pageId is null or empty");     // Catch: Exception -> L17
        return;
    L12:
        Map<String, h> r106 = ECMarketingDataCenter.f162719a;     // Catch: Exception -> L17
        if (ECMarketingDataCenter.d(r100) == true) goto L15;
        r104.invoke("error: pageData is null or empty");     // Catch: Exception -> L17
    L15:
        ECMarketingDataCenter.b(r100).a(r101, r102, r103);     // Catch: Exception -> L17
        r104.invoke("success");     // Catch: Exception -> L17
        return;
    L18:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static void n(String r100, com.bytedance.android.marketing.sdk.api.c r101, String r102, String r103, FrameLayout r110, Map r111) {
        if (r110 == null) goto L4;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        r101.f162671b = r110;
    L4:
        Map<String, h> r112 = ECMarketingDataCenter.f162719a;
        h r104 = ECMarketingDataCenter.b(r100);
        int r105 = h.f162794l;
        r104.f(r101, r111, r102, r103, null);
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final void b(Context r100, String r101, Object r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        String r106 = l(r105, r100);     // Catch: Exception -> L10
        Map<String, h> r107 = ECMarketingDataCenter.f162719a;     // Catch: Exception -> L10
        if (ECMarketingDataCenter.c(r106, r101) == true) goto L6;
        return;
    L6:
        b.j(r101, r102);     // Catch: Exception -> L10
        if (ECMarketingDataCenter.d(r106) == false) goto L13;
        ECMarketingDataCenter.b(r106).j(r101, r102, r103, r104);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final void f(String r110, FrameLayout r111, com.bytedance.android.marketing.sdk.api.a r112, String r113, String r114, Map<String, ? extends Object> r115) {
        Intrinsics.checkNotNullParameter(r110, "pageId");
        o(r110, r111, r112, r113, r114, r115, SourceFrom.CLIENT.getValue());
    }

    @Override // com.bytedance.android.marketing.sdk.api.IMarketingServiceV2
    public final String g(com.bytedance.android.marketing.sdk.api.c r110, long r111, Map<String, ? extends Object> r210, String r211, String r212, com.bytedance.android.marketing.sdk.api.a r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "serviceBuilder");
        ji.a r100 = b.f162814a;
        Map<String, Object> r101 = r110.f162681l;
        Intrinsics.checkNotNullParameter(r101, "bizParams");
        b.b("[LIFECYCLE][LOAD]");
        b.b("bizParams ==>  " + new JSONObject(r101));
        String r102 = ex2.c.d(r110);
        SourceFrom[] r103 = SourceFrom.values();
        int r104 = r103.length;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L9;
        SourceFrom r112 = r103[r105];
        if (Intrinsics.areEqual(r112.getValue(), r214) == true) goto L10;
        r105 = r105 + 1;
    L10:
        if (r112 == null) goto L13;
        String r106 = r112.getValue();
        if (r106 == null) goto L13;
    L14:
        String r113 = r106;
        String r107 = ex2.c.f(r110, r211);
        if (Intrinsics.areEqual(r113, SourceFrom.CLIENT.getValue()) == false) goto L17;
        String r114 = r107;
    L18:
        Map<String, h> r108 = ECMarketingDataCenter.f162719a;
        h r109 = ECMarketingDataCenter.b(r102);
        TrackData r115 = r109.f162802h;
        String r116 = "";
        if (r211 != null) goto L21;
        String r117 = "";
    L22:
        r115.setEntryRit(r117);
        r109.f162802h.setTOpenTime(r111);
        TrackData r118 = r109.f162802h;
        if (r114 != null) goto L25;
        String r119 = "";
    L26:
        r118.setServicePageName(r119);
        r109.f162802h.setLoadEntryType(r113);
        long r120 = r110.f162682m;
        if (r120 <= 0) goto L29;
        r109.f162802h.setTShowAction(r120);
    L29:
        r109.f162802h.setEnterFrom(ex2.c.b(r110));
        r109.f162802h.setPageName(ex2.c.e(r110));
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L32
        e.f(r111, r211, r114, r113);     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        if (r213 == null) goto L61;
        Map<String, com.bytedance.android.marketing.sdk.api.a> r122 = com.bytedance.android.marketing.sdk.impl.data.e.f162793a;
        Intrinsics.checkNotNullParameter(r102, "pageId");
        Intrinsics.checkNotNullParameter(r213, "callback");
        Map<String, com.bytedance.android.marketing.sdk.api.a> r123 = com.bytedance.android.marketing.sdk.impl.data.e.f162793a;
        if (r123.containsKey(r102) == true) goto L61;
        r123.put(r102, r213);
    L61:
        Map<String, h> r124 = ECMarketingDataCenter.f162719a;     // Catch: Exception -> L41
        ECMarketingDataCenter.f162720b.put(r102, r110);     // Catch: Exception -> L41
        ECMarketingDataCenter.e(r110);     // Catch: Exception -> L41
        r109.f(r110, r210, r211, r212, r214);     // Catch: Exception -> L41
    L59:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L54
        Activity r126 = r110.getActivity();     // Catch: Throwable -> L54
        if (r126 != null) goto L50;
        CommonUtils.f162812a.getClass();     // Catch: Throwable -> L54
        r126 = CommonUtils.c();     // Catch: Throwable -> L54
    L50:
        if (r126 != null) goto L52;
        return r102;
    L52:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        return r102;
    L54:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L41:
        e = move-exception;
        int r128 = e.f162816a;
        String r129 = ECMarketingErrorType.PROTOCOL_PARSE_ERROR.getCode();
        String r130 = e.getMessage();
        if (r130 == null) goto L46;
        r116 = r130;
    L46:
        e.e(r211, null, null, r129, "load PageData failed: ".concat(r116), r114, r113);
    L32:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L25:
        r119 = r114;
        goto L26
    L21:
        r117 = r211;
        goto L22
    L17:
        r114 = null;
    L13:
        r106 = SourceFrom.CLIENT.getValue();
        goto L14
    L9:
        r112 = null;
        goto L10
    }

    public final void o(final String r100, final FrameLayout r101, com.bytedance.android.marketing.sdk.api.a r110, final String r111, final String r112, final Map<String, ? extends Object> r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Intrinsics.checkNotNullParameter(r114, "loadEntryType");
        b.b("[LIFECYCLE][SHOW]");
        if (r110 == null) goto L12;
        Map<String, com.bytedance.android.marketing.sdk.api.a> r102 = com.bytedance.android.marketing.sdk.impl.data.e.f162793a;
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Map<String, com.bytedance.android.marketing.sdk.api.a> r103 = com.bytedance.android.marketing.sdk.impl.data.e.f162793a;
        if (r103.containsKey(r100) == false) goto L8;
        r103.remove(r100);
    L8:
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r103.containsKey(r100) == true) goto L12;
        r103.put(r100, r110);
    L12:
        Map<String, h> r115 = ECMarketingDataCenter.f162719a;
        com.bytedance.android.marketing.sdk.api.c r104 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) ECMarketingDataCenter.f162720b).get(r100);
        h r116 = ECMarketingDataCenter.b(r100);
        if (r104 == null) goto L28;
        if (r101 == null) goto L16;
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        r104.f162671b = r101;
    L16:
        TrackData r105 = r116.f162802h;
        String r106 = "";
        if (r111 != null) goto L19;
        String r107 = "";
    L20:
        r105.setEntryRit(r107);
        TrackData r108 = r116.f162802h;
        String r109 = ex2.c.f(r104, r111);
        if (Intrinsics.areEqual(r114, SourceFrom.CLIENT.getValue()) == true) goto L24;
        r109 = null;
    L24:
        if (r109 == null) goto L27;
        r106 = r109;
    L27:
        r108.setServicePageName(r106);
        r116.f162802h.setLoadEntryType(r114);
        goto L28
    L19:
        r107 = r111;
    L28:
        r116.f162802h.setTOpenTime(System.currentTimeMillis());
        if (r116.f162801g == true) goto L32;
        int r117 = i.f162819a;
        i.a(new String[]{"show 的时候还没有注册好，在register完成的时候触发回调"});
        ECMarketingDataCenter.f162721c.put(r100, new MarketingServiceImplV2$showAsyncWithEntryType$2(this, r100, r111, r112, r101, r113));
        return;
    L32:
        if (r104 == null) goto L35;
        n(r100, r104, r111, r112, r101, r113);
        return;
    }
}
