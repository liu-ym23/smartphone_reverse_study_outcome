package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u00017BW\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010!\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR\u0019\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "Ljava/io/Serializable;", "", "isDynamicTabConfig", "", "", "dictionary", "getApiExtraParamsWith", "getEventExtraParamsWith", "durationReported", "Z", "getDurationReported", "()Z", "setDurationReported", "(Z)V", "enterStoreReported", "getEnterStoreReported", "setEnterStoreReported", "isFetchDynamicTabInitialData", "setFetchDynamicTabInitialData", "monitorId", "Ljava/lang/String;", "getMonitorId", "()Ljava/lang/String;", "setMonitorId", "(Ljava/lang/String;)V", "", "tabId", "I", "getTabId", "()I", "tabType", "getTabType", "tabName", "getTabName", "defaultSelected", "getDefaultSelected", "containerType", "Ljava/lang/Integer;", "getContainerType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "dynamicTabVO", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "getDynamicTabVO", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "externalMetaInfo", "Ljava/util/Map;", "getExternalMetaInfo", "()Ljava/util/Map;", "setExternalMetaInfo", "(Ljava/util/Map;)V", "<init>", "(IILjava/lang/String;ZLjava/lang/Integer;Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreTabConfig implements Serializable {
    public static final int CONTAINER_TYPE_LYNX = 2;
    public static final int CONTAINER_TYPE_WEB = 3;
    public static final a Companion = null;
    private final Integer containerType;
    private final boolean defaultSelected;
    private boolean durationReported;
    private final ECStoreDynamicTabDTO dynamicTabVO;
    private boolean enterStoreReported;
    private Map<String, String> externalMetaInfo;
    private boolean isFetchDynamicTabInitialData;
    private String monitorId;
    private final int tabId;
    private final String tabName;
    private final int tabType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isDynamicTabConfig() {
        uj3.j.a r100 = uj3.j.L;
        Integer r101 = this.containerType;
        ECStoreDynamicTabDTO r102 = this.dynamicTabVO;
        r100.getClass();
        return uj3.j.a.a(r101, r102);
    }

    public final Integer getContainerType() {
        return this.containerType;
    }

    public final boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    public final boolean getDurationReported() {
        return this.durationReported;
    }

    public final ECStoreDynamicTabDTO getDynamicTabVO() {
        return this.dynamicTabVO;
    }

    public final boolean getEnterStoreReported() {
        return this.enterStoreReported;
    }

    public final Map<String, String> getExternalMetaInfo() {
        return this.externalMetaInfo;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final boolean isFetchDynamicTabInitialData() {
        return this.isFetchDynamicTabInitialData;
    }

    public final Map<String, String> getApiExtraParamsWith(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "dictionary");
        ECStoreDynamicTabDTO r101 = this.dynamicTabVO;
        if (r101 == null) goto L7;
        ECStoreDynamicTabConfig r102 = r101.getConfig();
        if (r102 == null) goto L7;
        String r103 = r102.getApiExtraParams();
    L9:
        return a(r103, r100);
    L7:
        r103 = null;
        goto L9
    }

    public final Map<String, String> getEventExtraParamsWith(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "dictionary");
        ECStoreDynamicTabDTO r101 = this.dynamicTabVO;
        if (r101 == null) goto L7;
        ECStoreDynamicTabConfig r102 = r101.getConfig();
        if (r102 == null) goto L7;
        String r103 = r102.getEventExtraParams();
    L9:
        return a(r103, r100);
    L7:
        r103 = null;
        goto L9
    }

    public final void setDurationReported(boolean r100) {
        this.durationReported = r100;
    }

    public final void setEnterStoreReported(boolean r100) {
        this.enterStoreReported = r100;
    }

    public final void setExternalMetaInfo(Map<String, String> r100) {
        this.externalMetaInfo = r100;
    }

    public final void setFetchDynamicTabInitialData(boolean r100) {
        this.isFetchDynamicTabInitialData = r100;
    }

    public final void setMonitorId(String r100) {
        this.monitorId = r100;
    }

    public static Map a(String r100, Map r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Object r103 = null;
        if (r102 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r100, SliceInitService.DEFAULT_SWITCH) == true) goto L34;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        int r105 = w0.f45736a;     // Catch: Throwable -> L23
        JsonObject r106 = (JsonObject) w0.b(r100, JsonObject.class);     // Catch: Throwable -> L23
        if (r106 != null) goto L17;
        return null;
    L17:
        b(r106, r101);     // Catch: Throwable -> L23
        String r107 = u0.d(r106);     // Catch: Throwable -> L23
        if ((!Intrinsics.areEqual(r107, SliceInitService.DEFAULT_SWITCH)) == true) goto L21;
        r107 = null;
    L21:
        Object r108 = Result.m9449constructorimpl(w0.a(r107));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r108) == true) goto L30;
        r103 = r108;
    L30:
        return (Map) r103;
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L34:
        return null;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static void b(JsonObject r100, Map r101) {
        Regex r102 = new Regex("^\\$(\\S)+\\$$");
        Iterator r103 = new HashSet(r100.keySet()).iterator();
    L4:
        if (r103.hasNext() == false) goto L29;
        String r104 = (String) r103.next();
        JsonElement r105 = r100.get(r104);
        if ((r105 instanceof JsonPrimitive) == false) goto L27;
        JsonPrimitive r106 = (JsonPrimitive) r105;
        if (r106.isString() == false) goto L27;
        if (r102.matches(r106.getAsString()) == false) goto L27;
        String r107 = r106.getAsString();
        Object r108 = r101.get(r107.subSequence(1, r107.length() - 1));
        String r109 = (String) r108;
        if (r109 != null) goto L14;
    L17:
        boolean r110 = true;
    L19:
        if ((!r110) == true) goto L22;
        r108 = null;
    L22:
        String r111 = (String) r108;
        if (r111 != null) goto L25;
        r111 = "";
    L25:
        r100.addProperty(r104, r111);
        goto L4
    L14:
        if (StringsKt.isBlank(r109) == true) goto L17;
        r110 = false;
    L27:
        if ((r105 instanceof JsonObject) == false) goto L4;
        b((JsonObject) r105, r101);
        goto L4
    }

    public StoreTabConfig(int r100, int r101, String r102, boolean r103, Integer r104, ECStoreDynamicTabDTO r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r102, "tabName");
        this.tabId = r100;
        this.tabType = r101;
        this.tabName = r102;
        this.defaultSelected = r103;
        this.containerType = r104;
        this.dynamicTabVO = r105;
        this.externalMetaInfo = r106;
    }

    public /* synthetic */ StoreTabConfig(int r110, int r111, String r112, boolean r113, Integer r114, ECStoreDynamicTabDTO r115, Map r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r117 & 32) == 0) goto L9;
        ECStoreDynamicTabDTO r101 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        Map r102 = null;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
