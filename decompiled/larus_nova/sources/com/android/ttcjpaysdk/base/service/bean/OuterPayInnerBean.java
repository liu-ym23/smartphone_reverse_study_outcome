package com.android.ttcjpaysdk.base.service.bean;

import android.net.Uri;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ContainerWay;
import com.android.ttcjpaysdk.base.OuterSceneSource;
import com.android.ttcjpaysdk.base.OuterSource;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010/\u001a\u00020\u000eJ\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00063"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/OuterPayInnerBean;", "", "payInfoData", "Lorg/json/JSONObject;", "cjPayHostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "outerSource", "Lcom/android/ttcjpaysdk/base/OuterSource;", "outerSceneSource", "Lcom/android/ttcjpaysdk/base/OuterSceneSource;", "extParams", "", "", "containerWay", "Lcom/android/ttcjpaysdk/base/ContainerWay;", "trackInfoParams", "isInvokeForInner", "", "(Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;Lcom/android/ttcjpaysdk/base/OuterSource;Lcom/android/ttcjpaysdk/base/OuterSceneSource;Ljava/util/Map;Lcom/android/ttcjpaysdk/base/ContainerWay;Ljava/util/Map;Z)V", "getCjPayHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getContainerWay", "()Lcom/android/ttcjpaysdk/base/ContainerWay;", "setContainerWay", "(Lcom/android/ttcjpaysdk/base/ContainerWay;)V", "getExtParams", "()Ljava/util/Map;", "()Z", "getOuterSceneSource", "()Lcom/android/ttcjpaysdk/base/OuterSceneSource;", "getOuterSource", "()Lcom/android/ttcjpaysdk/base/OuterSource;", "getPayInfoData", "()Lorg/json/JSONObject;", "getTrackInfoParams", "buildIndustryParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getCurrentContainerWay", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OuterPayInnerBean {
    private final CJPayHostInfo cjPayHostInfo;
    private ContainerWay containerWay;
    private final Map<String, String> extParams;
    private final boolean isInvokeForInner;
    private final OuterSceneSource outerSceneSource;
    private final OuterSource outerSource;
    private final JSONObject payInfoData;
    private final Map<String, String> trackInfoParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuterPayInnerBean copy$default(OuterPayInnerBean r100, JSONObject r110, CJPayHostInfo r111, OuterSource r112, OuterSceneSource r113, Map r114, ContainerWay r115, Map r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        JSONObject r101 = r100.payInfoData;
    L7:
        if ((r118 & 2) == 0) goto L9;
        CJPayHostInfo r102 = r100.cjPayHostInfo;
    L11:
        if ((r118 & 4) == 0) goto L13;
        OuterSource r103 = r100.outerSource;
    L15:
        if ((r118 & 8) == 0) goto L17;
        OuterSceneSource r104 = r100.outerSceneSource;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Map r105 = r100.extParams;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ContainerWay r106 = r100.containerWay;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.trackInfoParams;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isInvokeForInner;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final JSONObject component1() {
        return this.payInfoData;
    }

    public final CJPayHostInfo component2() {
        return this.cjPayHostInfo;
    }

    public final OuterSource component3() {
        return this.outerSource;
    }

    public final OuterSceneSource component4() {
        return this.outerSceneSource;
    }

    public final Map<String, String> component5() {
        return this.extParams;
    }

    public final ContainerWay component6() {
        return this.containerWay;
    }

    public final Map<String, String> component7() {
        return this.trackInfoParams;
    }

    public final boolean component8() {
        return this.isInvokeForInner;
    }

    public final OuterPayInnerBean copy(JSONObject r110, CJPayHostInfo r111, OuterSource r112, OuterSceneSource r113, Map<String, String> r114, ContainerWay r115, Map<String, String> r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "payInfoData");
        Intrinsics.checkNotNullParameter(r111, "cjPayHostInfo");
        Intrinsics.checkNotNullParameter(r112, "outerSource");
        Intrinsics.checkNotNullParameter(r113, "outerSceneSource");
        Intrinsics.checkNotNullParameter(r115, "containerWay");
        return new OuterPayInnerBean(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OuterPayInnerBean) == true) goto L8;
        return false;
    L8:
        OuterPayInnerBean r101 = (OuterPayInnerBean) r100;
        if (Intrinsics.areEqual(this.payInfoData, r101.payInfoData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cjPayHostInfo, r101.cjPayHostInfo) == true) goto L15;
        return false;
    L15:
        if (this.outerSource == r101.outerSource) goto L18;
        return false;
    L18:
        if (this.outerSceneSource == r101.outerSceneSource) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extParams, r101.extParams) == true) goto L24;
        return false;
    L24:
        if (this.containerWay == r101.containerWay) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trackInfoParams, r101.trackInfoParams) == true) goto L30;
        return false;
    L30:
        if (this.isInvokeForInner == r101.isInvokeForInner) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.payInfoData.hashCode() * 31) + this.cjPayHostInfo.hashCode()) * 31) + this.outerSource.hashCode()) * 31) + this.outerSceneSource.hashCode()) * 31;
        Map<String, String> r101 = this.extParams;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.containerWay.hashCode()) * 31;
        Map<String, String> r105 = this.trackInfoParams;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.isInvokeForInner == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OuterPayInnerBean(payInfoData=" + this.payInfoData + ", cjPayHostInfo=" + this.cjPayHostInfo + ", outerSource=" + this.outerSource + ", outerSceneSource=" + this.outerSceneSource + ", extParams=" + this.extParams + ", containerWay=" + this.containerWay + ", trackInfoParams=" + this.trackInfoParams + ", isInvokeForInner=" + this.isInvokeForInner + ')';
    }

    public final Map<String, String> buildIndustryParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = this.payInfoData.optString("mini_scheme");
        if ((!StringsKt.isBlank(r101)) == true) goto L49;
    L48:
        return r100;
    L49:
        String r102 = CJSchemaExtensionKt.getQueryParameter(r101, "__cj_nfc_param__");     // Catch: Exception -> L46
        if (r102 == null) goto L8;
        r100.putAll(KtSafeMethodExtensionKt.toMap(new JSONObject(r102)));     // Catch: Exception -> L46
    L8:
        String r103 = CJSchemaExtensionKt.getQueryParameter(r101, "bdp_log");     // Catch: Exception -> L46
        if (r103 == null) goto L18;
        JSONObject r110 = new JSONObject(r103);     // Catch: Exception -> L46
        if (r110.has("launch_from") == false) goto L16;
        if (Intrinsics.areEqual(r110.optString("launch_from"), "scan") == false) goto L16;
        r100.put("container_way", "SCAN");     // Catch: Exception -> L46
    L16:
        if (r110.has("tid") == false) goto L18;
        r100.put("tid", r110.optString("tid"));     // Catch: Exception -> L46
    L18:
        String r104 = CJSchemaExtensionKt.getQueryParameter(r101, "bind_url");     // Catch: Exception -> L46
        if (r104 == null) goto L21;
        r100.put("bind_url", URLDecoder.decode(r104, "UTF-8"));     // Catch: Exception -> L46
    L21:
        String r105 = this.payInfoData.optString("appId");     // Catch: Exception -> L46
        if ((!StringsKt.isBlank(r105)) == true) goto L25;
        r105 = null;
    L25:
        if (r105 == null) goto L27;
        r100.put(BdpAppEventConstant.PARAMS_MP_ID, r105);     // Catch: Exception -> L46
    L27:
        String r106 = this.payInfoData.optString("mp_uniq_id");     // Catch: Exception -> L46
        if ((!StringsKt.isBlank(r106)) == true) goto L31;
        r106 = null;
    L31:
        if (r106 == null) goto L33;
        r100.put("mp_uniq_id", r106);     // Catch: Exception -> L46
    L33:
        String r107 = this.payInfoData.optString("mp_route_id");     // Catch: Exception -> L46
        if ((!StringsKt.isBlank(r107)) == true) goto L37;
        r107 = null;
    L37:
        if (r107 == null) goto L39;
        r100.put("mp_route_id", r107);     // Catch: Exception -> L46
    L39:
        String r108 = this.payInfoData.optString("mp_bdp_log");     // Catch: Exception -> L46
        if ((!StringsKt.isBlank(r108)) == true) goto L43;
        r108 = null;
    L43:
        if (r108 == null) goto L48;
        r100.put("mp_bdp_log", r108);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OuterPayInnerBean#buildIndustryParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OuterPayInnerBean#buildIndustryParams", e);
        CJReporter r109 = CJReporter.f202294a;
        CJReporter.m(null, "get_scheme_illegal", 2, e);
        goto L48
    }

    public final ContainerWay getCurrentContainerWay() {
        ContainerWay r100 = this.containerWay;
        if (r100 == ContainerWay.OTHER) goto L5;
        return r100;
    L5:
        String r101 = this.payInfoData.optString("mini_scheme");
        if ((!StringsKt.isBlank(r101)) == false) goto L36;
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L10
    L12:
        if (r102 == null) goto L36;
        String r103 = UriProtector.getQueryParameter(r102, "__cj_nfc_param__");
        if (r103 != null) goto L39;
    L21:
        String r104 = UriProtector.getQueryParameter(r102, "bdp_log");
        if (r104 == null) goto L24;
        JSONObject r105 = new JSONObject(r104);
    L25:
        String r106 = r105.optString("launch_from");
        if (StringsKt.equals(r106, "scan", false) == false) goto L30;
        return ContainerWay.SCAN;
    L30:
        if (StringsKt.equals(r106, "nfc", false) == false) goto L34;
        return ContainerWay.NFC;
    L34:
        return ContainerWay.OTHER;
    L24:
        r105 = new JSONObject();
        goto L25
    L39:
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OuterPayInnerBean#getCurrentContainerWay", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OuterPayInnerBean#getCurrentContainerWay", e);
        CJReporter r107 = CJReporter.f202294a;
        CJReporter.m(null, "get_scheme_illegal", 2, e);
        goto L21
    L16:
        if (Intrinsics.areEqual(new JSONObject(r103).optString("container_way"), "NFC") == false) goto L21;
        return ContainerWay.NFC;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("OuterPayInnerBean#getCurrentContainerWay", e);
        CJBasicCommonUtils.logCatch("CJCatch", "OuterPayInnerBean#getCurrentContainerWay", e);
        CJReporter r108 = CJReporter.f202294a;
        CJReporter.m(null, "get_scheme_illegal", 2, e);
        r102 = null;
    L36:
        return ContainerWay.OTHER;
    }

    public final CJPayHostInfo getCjPayHostInfo() {
        return this.cjPayHostInfo;
    }

    public final ContainerWay getContainerWay() {
        return this.containerWay;
    }

    public final Map<String, String> getExtParams() {
        return this.extParams;
    }

    public final OuterSceneSource getOuterSceneSource() {
        return this.outerSceneSource;
    }

    public final OuterSource getOuterSource() {
        return this.outerSource;
    }

    public final JSONObject getPayInfoData() {
        return this.payInfoData;
    }

    public final Map<String, String> getTrackInfoParams() {
        return this.trackInfoParams;
    }

    public final boolean isInvokeForInner() {
        return this.isInvokeForInner;
    }

    public final void setContainerWay(ContainerWay r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerWay = r100;
    }

    public OuterPayInnerBean(JSONObject r100, CJPayHostInfo r101, OuterSource r102, OuterSceneSource r103, Map<String, String> r104, ContainerWay r105, Map<String, String> r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "payInfoData");
        Intrinsics.checkNotNullParameter(r101, "cjPayHostInfo");
        Intrinsics.checkNotNullParameter(r102, "outerSource");
        Intrinsics.checkNotNullParameter(r103, "outerSceneSource");
        Intrinsics.checkNotNullParameter(r105, "containerWay");
        this.payInfoData = r100;
        this.cjPayHostInfo = r101;
        this.outerSource = r102;
        this.outerSceneSource = r103;
        this.extParams = r104;
        this.containerWay = r105;
        this.trackInfoParams = r106;
        this.isInvokeForInner = r107;
    }

    public /* synthetic */ OuterPayInnerBean(JSONObject r110, CJPayHostInfo r111, OuterSource r112, OuterSceneSource r113, Map r114, ContainerWay r115, Map r116, boolean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 16) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r211 & 32) == 0) goto L9;
        ContainerWay r101 = ContainerWay.OTHER;
    L11:
        if ((r211 & 64) == 0) goto L13;
        Map r117 = null;
    L15:
        if ((r211 & 128) == 0) goto L17;
        boolean r118 = false;
    L18:
        this(r110, r111, r112, r113, r100, r101, r117, r118);
        return;
    L17:
        r118 = r210;
        goto L18
    L13:
        r117 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
