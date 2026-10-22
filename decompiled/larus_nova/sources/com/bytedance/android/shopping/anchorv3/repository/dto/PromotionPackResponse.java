package com.bytedance.android.shopping.anchorv3.repository.dto;

import android.os.SystemClock;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00103\u001a\u000204R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPackResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "bdturing", "", "getBdturing", "()Ljava/lang/String;", "setBdturing", "(Ljava/lang/String;)V", "extra", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InflowRespExtra;", "getExtra", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/InflowRespExtra;", "setExtra", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/InflowRespExtra;)V", "fallbackPage", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "getFallbackPage", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "setFallbackPage", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;)V", "innerFlowPageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "getInnerFlowPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "setInnerFlowPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;)V", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "pageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;", "getPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;", "setPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;)V", "promotions", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotions", "()Ljava/util/List;", "setPromotions", "(Ljava/util/List;)V", "isValid", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PromotionPackResponse extends CommerceBaseResponse {

    @SerializedName("bdturing")
    private String bdturing;

    @SerializedName("extra")
    private InflowRespExtra extra;

    @SerializedName("fallback_page")
    private FallbackPage fallbackPage;

    @SerializedName("inner_flow_page_style")
    private InnerFlowPageStyleDTO innerFlowPageStyle;
    private long lastUpdateTime;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    @SerializedName("page_style")
    private PromotionPageStyleDTO pageStyle;

    @SerializedName("promotions")
    private List<? extends PromotionProductStruct> promotions;

    public PromotionPackResponse() {
        this.lastUpdateTime = SystemClock.elapsedRealtime();
    }

    public final boolean isValid() {
        if (getStatusCode() != 0) goto L14;
        List<? extends PromotionProductStruct> r100 = this.promotions;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r100.isEmpty() == true) goto L10;
        r101 = false;
        goto L11
    L14:
        return false;
    }

    public final String getBdturing() {
        return this.bdturing;
    }

    public final InflowRespExtra getExtra() {
        return this.extra;
    }

    public final FallbackPage getFallbackPage() {
        return this.fallbackPage;
    }

    public final InnerFlowPageStyleDTO getInnerFlowPageStyle() {
        return this.innerFlowPageStyle;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final PromotionPageStyleDTO getPageStyle() {
        return this.pageStyle;
    }

    public final List<PromotionProductStruct> getPromotions() {
        return this.promotions;
    }

    public final void setBdturing(String r100) {
        this.bdturing = r100;
    }

    public final void setExtra(InflowRespExtra r100) {
        this.extra = r100;
    }

    public final void setFallbackPage(FallbackPage r100) {
        this.fallbackPage = r100;
    }

    public final void setInnerFlowPageStyle(InnerFlowPageStyleDTO r100) {
        this.innerFlowPageStyle = r100;
    }

    public final void setLastUpdateTime(long r100) {
        this.lastUpdateTime = r100;
    }

    public final void setPageStyle(PromotionPageStyleDTO r100) {
        this.pageStyle = r100;
    }

    public final void setPromotions(List<? extends PromotionProductStruct> r100) {
        this.promotions = r100;
    }
}
