package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECExposureDataDTO;", "Ljava/io/Serializable;", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECParamsFromClientDTO;", "paramsFromClient", "Ljava/util/List;", "getParamsFromClient", "()Ljava/util/List;", "setParamsFromClient", "(Ljava/util/List;)V", "extra", "getExtra", "setExtra", "bstRuleKey", "getBstRuleKey", "setBstRuleKey", "paramsSameAs", "getParamsSameAs", "setParamsSameAs", "", "mergeRealCommon", "Ljava/lang/Boolean;", "getMergeRealCommon", "()Ljava/lang/Boolean;", "setMergeRealCommon", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExposureDataDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("bst_rule_key")
    private String bstRuleKey;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String eventName;

    @SerializedName("extra")
    private Map<String, Object> extra;

    @SerializedName("merge_real_common")
    private Boolean mergeRealCommon;

    @SerializedName("params")
    private Map<String, Object> params;

    @SerializedName("params_from_client")
    private List<ECParamsFromClientDTO> paramsFromClient;

    @SerializedName("params_same_as")
    private String paramsSameAs;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECExposureDataDTO() {
    }

    public final String getBstRuleKey() {
        return this.bstRuleKey;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Boolean getMergeRealCommon() {
        return this.mergeRealCommon;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final List<ECParamsFromClientDTO> getParamsFromClient() {
        return this.paramsFromClient;
    }

    public final String getParamsSameAs() {
        return this.paramsSameAs;
    }

    public final void setBstRuleKey(String r100) {
        this.bstRuleKey = r100;
    }

    public final void setEventName(String r100) {
        this.eventName = r100;
    }

    public final void setExtra(Map<String, Object> r100) {
        this.extra = r100;
    }

    public final void setMergeRealCommon(Boolean r100) {
        this.mergeRealCommon = r100;
    }

    public final void setParams(Map<String, Object> r100) {
        this.params = r100;
    }

    public final void setParamsFromClient(List<ECParamsFromClientDTO> r100) {
        this.paramsFromClient = r100;
    }

    public final void setParamsSameAs(String r100) {
        this.paramsSameAs = r100;
    }
}
