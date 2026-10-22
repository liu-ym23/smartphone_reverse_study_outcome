package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010+\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFinishH5ActivateEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "code", "", "amount", "successDesc", "activateFailDesc", "activateFailToastDesc", "style", "payToken", "isVoucherExpand", "verifyInfo", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getActivateFailDesc", "()Ljava/lang/String;", "setActivateFailDesc", "(Ljava/lang/String;)V", "getActivateFailToastDesc", "getAmount", "setAmount", "getCode", "setCode", "hasBindCard", "", "getHasBindCard", "()Z", "setHasBindCard", "(Z)V", "setVoucherExpand", "getPayToken", "setPayToken", "showSuccessToast", "getShowSuccessToast", "setShowSuccessToast", "getStyle", "setStyle", "getSuccessDesc", "setSuccessDesc", "getVerifyInfo", "()Lorg/json/JSONObject;", "setVerifyInfo", "(Lorg/json/JSONObject;)V", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFinishH5ActivateEvent extends BaseEvent {
    private String activateFailDesc;
    private final String activateFailToastDesc;
    private String amount;
    private String code;
    private boolean hasBindCard;
    private String isVoucherExpand;
    private String payToken;
    private boolean showSuccessToast;
    private String style;
    private String successDesc;
    private JSONObject verifyInfo;

    public String toString() {
        return "CJPayFinishH5ActivateEvent(code='" + this.code + "', amount='" + this.amount + "', successDesc='" + this.successDesc + "', activateFailDesc='" + this.activateFailDesc + "', activateFailToastDesc='" + this.activateFailToastDesc + "', style='" + this.style + "', payToken='" + this.payToken + "', verifyInfo='" + this.verifyInfo + "', isVoucherExpand='" + this.isVoucherExpand + "', showSuccessToast=" + this.showSuccessToast + ", hasBindCard=" + this.hasBindCard + ')';
    }

    public final String getActivateFailDesc() {
        return this.activateFailDesc;
    }

    public final String getActivateFailToastDesc() {
        return this.activateFailToastDesc;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCode() {
        return this.code;
    }

    public final boolean getHasBindCard() {
        return this.hasBindCard;
    }

    public final String getPayToken() {
        return this.payToken;
    }

    public final boolean getShowSuccessToast() {
        return this.showSuccessToast;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getSuccessDesc() {
        return this.successDesc;
    }

    public final JSONObject getVerifyInfo() {
        return this.verifyInfo;
    }

    public final String isVoucherExpand() {
        return this.isVoucherExpand;
    }

    public final void setActivateFailDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.activateFailDesc = r100;
    }

    public final void setAmount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.amount = r100;
    }

    public final void setCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.code = r100;
    }

    public final void setHasBindCard(boolean r100) {
        this.hasBindCard = r100;
    }

    public final void setPayToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.payToken = r100;
    }

    public final void setShowSuccessToast(boolean r100) {
        this.showSuccessToast = r100;
    }

    public final void setStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.style = r100;
    }

    public final void setSuccessDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.successDesc = r100;
    }

    public final void setVerifyInfo(JSONObject r100) {
        this.verifyInfo = r100;
    }

    public final void setVoucherExpand(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isVoucherExpand = r100;
    }

    public CJPayFinishH5ActivateEvent(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "amount");
        Intrinsics.checkNotNullParameter(r102, "successDesc");
        Intrinsics.checkNotNullParameter(r103, "activateFailDesc");
        Intrinsics.checkNotNullParameter(r104, "activateFailToastDesc");
        Intrinsics.checkNotNullParameter(r105, "style");
        Intrinsics.checkNotNullParameter(r106, "payToken");
        Intrinsics.checkNotNullParameter(r107, "isVoucherExpand");
        this.code = r100;
        this.amount = r101;
        this.successDesc = r102;
        this.activateFailDesc = r103;
        this.activateFailToastDesc = r104;
        this.style = r105;
        this.payToken = r106;
        this.isVoucherExpand = r107;
        this.verifyInfo = r110;
        this.showSuccessToast = true;
        this.hasBindCard = true;
    }

    public /* synthetic */ CJPayFinishH5ActivateEvent(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, JSONObject r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 16) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 32) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r213 & 64) == 0) goto L13;
        String r116 = "";
    L15:
        if ((r213 & 128) == 0) goto L17;
        String r117 = "";
    L19:
        if ((r213 & 256) == 0) goto L21;
        JSONObject r118 = null;
    L22:
        this(r110, r111, r112, r113, r100, r101, r116, r117, r118);
        return;
    L21:
        r118 = r212;
        goto L22
    L17:
        r117 = r211;
        goto L19
    L13:
        r116 = r210;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
