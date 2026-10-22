package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\u001c\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006¨\u0006."}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLogisticsStruct;", "Ljava/io/Serializable;", "", "preSellDelaySec", "Ljava/lang/String;", "getPreSellDelaySec", "()Ljava/lang/String;", "deliveryDelaySec", "getDeliveryDelaySec", "", "logisticText", "Ljava/util/List;", "getLogisticText", "()Ljava/util/List;", "", "fastDispatch", "Ljava/lang/Integer;", "getFastDispatch", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReceiveAddrStruct;", "receiveAddrInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReceiveAddrStruct;", "getReceiveAddrInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReceiveAddrStruct;", "arriveTime", "getArriveTime", "Lcom/bytedance/android/ec/model/ECUrlModel;", "arriveIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getArriveIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "prefixIcon", "getPrefixIcon", "middleText", "getMiddleText", "Lcom/bytedance/android/ec/model/response/anchorv3/LogisticLineDTO;", "logisticLines", "getLogisticLines", "postFee", "getPostFee", "extraLog", "getExtraLog", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductLogisticsStruct implements Serializable {
    public static final int ARRIVE_NEXT_DAY = 2;
    public static final int ARRIVE_TODAY = 1;
    public static final a Companion = null;
    public static final int POST_NEXT_DAY = 5;
    public static final int POST_TODAY = 4;

    @SerializedName("arrive_icon")
    private final ECUrlModel arriveIcon;

    @SerializedName("arrive_time")
    private final Integer arriveTime;

    @SerializedName("delivery_delay_desc")
    private final String deliveryDelaySec;

    @SerializedName("extra_log")
    private final String extraLog;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_FAST_DISPATCH)
    private final Integer fastDispatch;

    @SerializedName("logistic_lines")
    private final List<LogisticLineDTO> logisticLines;

    @SerializedName("logistic_text")
    private final List<String> logisticText;

    @SerializedName("middle_text")
    private final String middleText;

    @SerializedName("post_fee")
    private final Integer postFee;

    @SerializedName("presell_delay_desc")
    private final String preSellDelaySec;

    @SerializedName("prefix_icon")
    private final ECUrlModel prefixIcon;

    @SerializedName("receive_addr")
    private final PromotionReceiveAddrStruct receiveAddrInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductLogisticsStruct() {
    }

    public final ECUrlModel getArriveIcon() {
        return this.arriveIcon;
    }

    public final Integer getArriveTime() {
        return this.arriveTime;
    }

    public final String getDeliveryDelaySec() {
        return this.deliveryDelaySec;
    }

    public final String getExtraLog() {
        return this.extraLog;
    }

    public final Integer getFastDispatch() {
        return this.fastDispatch;
    }

    public final List<LogisticLineDTO> getLogisticLines() {
        return this.logisticLines;
    }

    public final List<String> getLogisticText() {
        return this.logisticText;
    }

    public final String getMiddleText() {
        return this.middleText;
    }

    public final Integer getPostFee() {
        return this.postFee;
    }

    public final String getPreSellDelaySec() {
        return this.preSellDelaySec;
    }

    public final ECUrlModel getPrefixIcon() {
        return this.prefixIcon;
    }

    public final PromotionReceiveAddrStruct getReceiveAddrInfo() {
        return this.receiveAddrInfo;
    }
}
