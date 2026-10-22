package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.json.CJPayIgnore;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayConfirmAfterGetFaceDataEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "ticket", "", "sdkData", "faceAppId", "scene", "source", "", "faceScene", "verifyResponse", "Lorg/json/JSONObject;", "enterFrom", "faceOrderNo", "verifyId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommonFaceCheckParams", "getFaceCheckParamsForCashDesk", "getFaceCheckParamsForMember", "isFromBindCard", "", "isFromBullet", "isFromH5", "isFromPay", "isFromPayAgain", "isFromPaymentMethod", "isFromPwdWrongVerify", "isFromPwdWrongVerifyAgain", "isFromSetPwdFromPayAgain", "isFromSetPwdPay", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayConfirmAfterGetFaceDataEvent extends BaseEvent implements CJPayObject {
    public String enterFrom;
    public String faceAppId;
    public String faceOrderNo;
    public String faceScene;
    public String scene;
    public String sdkData;

    @CJPayIgnore
    public int source;
    public String ticket;
    public String verifyId;
    public JSONObject verifyResponse;

    public CJPayConfirmAfterGetFaceDataEvent() {
        this(null, null, null, null, 0, null, null, null, null, null, 1023, null);
    }

    private final JSONObject getCommonFaceCheckParams() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "face_app_id", this.faceAppId);
        KtSafeMethodExtensionKt.safePut(r100, "face_veri_ticket", this.ticket);
        KtSafeMethodExtensionKt.safePut(r100, "face_sdk_data", this.sdkData);
        KtSafeMethodExtensionKt.safePut(r100, "face_order_no", this.faceOrderNo);
        return r100;
    }

    public final boolean isFromBindCard() {
        if (this.source != 1001) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromBullet() {
        if (this.source != 1003) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromH5() {
        if (this.source != 4000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPay() {
        if (this.source != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPayAgain() {
        if (this.source != 2000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPaymentMethod() {
        if (this.source != 3000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPwdWrongVerify() {
        if (this.source != 1004) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPwdWrongVerifyAgain() {
        if (this.source != 2004) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromSetPwdFromPayAgain() {
        if (this.source != 6000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromSetPwdPay() {
        if (this.source != 5000) goto L5;
        return true;
    L5:
        return false;
    }

    public final JSONObject getFaceCheckParamsForCashDesk() {
        JSONObject r100 = getCommonFaceCheckParams();
        KtSafeMethodExtensionKt.safePut(r100, "face_scene", this.scene);
        return r100;
    }

    public final JSONObject getFaceCheckParamsForMember() {
        JSONObject r100 = getCommonFaceCheckParams();
        KtSafeMethodExtensionKt.safePut(r100, "scene", this.scene);
        KtSafeMethodExtensionKt.safePut(r100, "face_scene", this.faceScene);
        return r100;
    }

    public CJPayConfirmAfterGetFaceDataEvent(String r100, String r101, String r102, String r103, int r104, String r105, JSONObject r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "ticket");
        Intrinsics.checkNotNullParameter(r101, "sdkData");
        Intrinsics.checkNotNullParameter(r102, "faceAppId");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r105, "faceScene");
        Intrinsics.checkNotNullParameter(r107, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "faceOrderNo");
        this.ticket = r100;
        this.sdkData = r101;
        this.faceAppId = r102;
        this.scene = r103;
        this.source = r104;
        this.faceScene = r105;
        this.verifyResponse = r106;
        this.enterFrom = r107;
        this.faceOrderNo = r110;
        this.verifyId = r111;
    }

    public /* synthetic */ CJPayConfirmAfterGetFaceDataEvent(String r110, String r111, String r112, String r113, int r114, String r115, JSONObject r116, String r210, String r211, String r212, int r213, DefaultConstructorMarker r214) {
        String r100 = "";
        if ((r213 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r105 = -1;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r106 = "";
    L26:
        String r107 = null;
        if ((r213 & 64) == 0) goto L29;
        JSONObject r108 = null;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r117 = "";
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r107 = r212;
    L42:
        this(r101, r102, r103, r104, r105, r106, r108, r117, r100, r107);
        return;
    L33:
        r117 = r210;
        goto L35
    L29:
        r108 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L26
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
}
