package com.android.ttcjpaysdk.base.service.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.service.ICJPayNormalBindCardService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010c\u001a\u0004\u0018\u00010\u0004J\u0006\u0010d\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR\u001c\u0010.\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001e\u00104\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001c\u00108\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001e\u0010;\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u001c\u0010>\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR.\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010Bj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001c\u0010K\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000eR\u001c\u0010N\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001c\u0010Q\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\f\"\u0004\bS\u0010\u000eR\u001c\u0010T\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001c\u0010W\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR\u001c\u0010Z\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\f\"\u0004\b\\\u0010\u000eR\u001a\u0010]\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/NormalBindCardBean;", "", "()V", "bankItemInfo", "Lorg/json/JSONObject;", "getBankItemInfo", "()Lorg/json/JSONObject;", "setBankItemInfo", "(Lorg/json/JSONObject;)V", "bindCardInfo", "", "getBindCardInfo", "()Ljava/lang/String;", "setBindCardInfo", "(Ljava/lang/String;)V", "bindCardOnlyUsingCardAdd", "", "getBindCardOnlyUsingCardAdd", "()Z", "setBindCardOnlyUsingCardAdd", "(Z)V", "bindSourceType", "", "getBindSourceType", "()Ljava/lang/Integer;", "setBindSourceType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bizOrderType", "getBizOrderType", "setBizOrderType", "bizType", "Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;", "getBizType", "()Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;", "setBizType", "(Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;)V", "cardBinAutoFocus", "getCardBinAutoFocus", "()Ljava/lang/Boolean;", "setCardBinAutoFocus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "combineType", "getCombineType", "setCombineType", "exts", "getExts", "setExts", "hostInfoJSON", "getHostInfoJSON", "setHostInfoJSON", "isBindCardWithPay", "setBindCardWithPay", "isFront", "setFront", "lynxBindCardSchema", "getLynxBindCardSchema", "setLynxBindCardSchema", "needAuthGuide", "getNeedAuthGuide", "setNeedAuthGuide", "nextPage", "getNextPage", "setNextPage", "payAddiTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPayAddiTypeList", "()Ljava/util/ArrayList;", "setPayAddiTypeList", "(Ljava/util/ArrayList;)V", "payNewCardReconfirmInfo", "getPayNewCardReconfirmInfo", "setPayNewCardReconfirmInfo", "payType", "getPayType", "setPayType", "processInfo", "getProcessInfo", "setProcessInfo", "schemaExtStr", "getSchemaExtStr", "setSchemaExtStr", "secondaryConfirmInfo", "getSecondaryConfirmInfo", "setSecondaryConfirmInfo", "source", "getSource", "setSource", "totalAmount", "getTotalAmount", "setTotalAmount", "type", "Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;", "getType", "()Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;", "setType", "(Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;)V", "getExt", "getExtsJsonObj", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NormalBindCardBean {
    private JSONObject bankItemInfo;
    private String bindCardInfo;
    private boolean bindCardOnlyUsingCardAdd;
    private Integer bindSourceType;
    private String bizOrderType;
    private ICJPayNormalBindCardService.BizType bizType;
    private Boolean cardBinAutoFocus;
    private String combineType;
    private String exts;
    private JSONObject hostInfoJSON;
    private Boolean isBindCardWithPay;
    private boolean isFront;
    private String lynxBindCardSchema;
    private Boolean needAuthGuide;
    private String nextPage;
    private ArrayList<String> payAddiTypeList;
    private JSONObject payNewCardReconfirmInfo;
    private String payType;
    private JSONObject processInfo;
    private String schemaExtStr;
    private JSONObject secondaryConfirmInfo;
    private String source;
    private String totalAmount;
    private ICJPayNormalBindCardService.SourceType type;

    public final JSONObject getExt() {
        if (TextUtils.isEmpty(this.bindCardInfo) == false) goto L10;
        return null;
    L10:
        String r100 = this.bindCardInfo;     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L6
        return new JSONObject(r100);
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("NormalBindCardBean#getExt", e);
        CJBasicCommonUtils.logCatch("CJCatch", "NormalBindCardBean#getExt", e);
        return new JSONObject();
    }

    public final JSONObject getExtsJsonObj() {
        return new JSONObject(this.exts);
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("NormalBindCardBean#getExtsJsonObj", e);
        CJBasicCommonUtils.logCatch("CJCatch", "NormalBindCardBean#getExtsJsonObj", e);
        return new JSONObject();
    }

    public NormalBindCardBean() {
        this.type = ICJPayNormalBindCardService.SourceType.Null;
        this.bizType = ICJPayNormalBindCardService.BizType.Null;
    }

    public final JSONObject getBankItemInfo() {
        return this.bankItemInfo;
    }

    public final String getBindCardInfo() {
        return this.bindCardInfo;
    }

    public final boolean getBindCardOnlyUsingCardAdd() {
        return this.bindCardOnlyUsingCardAdd;
    }

    public final Integer getBindSourceType() {
        return this.bindSourceType;
    }

    public final String getBizOrderType() {
        return this.bizOrderType;
    }

    public final ICJPayNormalBindCardService.BizType getBizType() {
        return this.bizType;
    }

    public final Boolean getCardBinAutoFocus() {
        return this.cardBinAutoFocus;
    }

    public final String getCombineType() {
        return this.combineType;
    }

    public final String getExts() {
        return this.exts;
    }

    public final JSONObject getHostInfoJSON() {
        return this.hostInfoJSON;
    }

    public final String getLynxBindCardSchema() {
        return this.lynxBindCardSchema;
    }

    public final Boolean getNeedAuthGuide() {
        return this.needAuthGuide;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final ArrayList<String> getPayAddiTypeList() {
        return this.payAddiTypeList;
    }

    public final JSONObject getPayNewCardReconfirmInfo() {
        return this.payNewCardReconfirmInfo;
    }

    public final String getPayType() {
        return this.payType;
    }

    public final JSONObject getProcessInfo() {
        return this.processInfo;
    }

    public final String getSchemaExtStr() {
        return this.schemaExtStr;
    }

    public final JSONObject getSecondaryConfirmInfo() {
        return this.secondaryConfirmInfo;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final ICJPayNormalBindCardService.SourceType getType() {
        return this.type;
    }

    public final Boolean isBindCardWithPay() {
        return this.isBindCardWithPay;
    }

    public final boolean isFront() {
        return this.isFront;
    }

    public final void setBankItemInfo(JSONObject r100) {
        this.bankItemInfo = r100;
    }

    public final void setBindCardInfo(String r100) {
        this.bindCardInfo = r100;
    }

    public final void setBindCardOnlyUsingCardAdd(boolean r100) {
        this.bindCardOnlyUsingCardAdd = r100;
    }

    public final void setBindCardWithPay(Boolean r100) {
        this.isBindCardWithPay = r100;
    }

    public final void setBindSourceType(Integer r100) {
        this.bindSourceType = r100;
    }

    public final void setBizOrderType(String r100) {
        this.bizOrderType = r100;
    }

    public final void setBizType(ICJPayNormalBindCardService.BizType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizType = r100;
    }

    public final void setCardBinAutoFocus(Boolean r100) {
        this.cardBinAutoFocus = r100;
    }

    public final void setCombineType(String r100) {
        this.combineType = r100;
    }

    public final void setExts(String r100) {
        this.exts = r100;
    }

    public final void setFront(boolean r100) {
        this.isFront = r100;
    }

    public final void setHostInfoJSON(JSONObject r100) {
        this.hostInfoJSON = r100;
    }

    public final void setLynxBindCardSchema(String r100) {
        this.lynxBindCardSchema = r100;
    }

    public final void setNeedAuthGuide(Boolean r100) {
        this.needAuthGuide = r100;
    }

    public final void setNextPage(String r100) {
        this.nextPage = r100;
    }

    public final void setPayAddiTypeList(ArrayList<String> r100) {
        this.payAddiTypeList = r100;
    }

    public final void setPayNewCardReconfirmInfo(JSONObject r100) {
        this.payNewCardReconfirmInfo = r100;
    }

    public final void setPayType(String r100) {
        this.payType = r100;
    }

    public final void setProcessInfo(JSONObject r100) {
        this.processInfo = r100;
    }

    public final void setSchemaExtStr(String r100) {
        this.schemaExtStr = r100;
    }

    public final void setSecondaryConfirmInfo(JSONObject r100) {
        this.secondaryConfirmInfo = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }

    public final void setTotalAmount(String r100) {
        this.totalAmount = r100;
    }

    public final void setType(ICJPayNormalBindCardService.SourceType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }
}
