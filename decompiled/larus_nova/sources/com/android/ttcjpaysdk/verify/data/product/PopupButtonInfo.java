package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.verify.constants.DyVerifyResultCode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\nB7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "value", "", "label", "url", CommodityText.BOLD, "", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "DyPopupValue", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopupButtonInfo implements CJPayObject {
    public boolean bold;
    public String color;
    public String label;
    public String url;
    public String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo$DyPopupValue;", "", BytedCertConstant.LiveType.LIVE_TYPE_ACTION, "", "callbackType", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getCallbackType", "()I", "getMotion", "()Ljava/lang/String;", "AGREE", "CANCEL", "BLOCK", "LINK", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DyPopupValue extends Enum<DyPopupValue> {
        private static final /* synthetic */ DyPopupValue[] $VALUES = null;
        public static final DyPopupValue AGREE = null;
        public static final DyPopupValue BLOCK = null;
        public static final DyPopupValue CANCEL = null;
        public static final DyPopupValue LINK = null;
        private final int callbackType;
        private final String motion;

        private static final /* synthetic */ DyPopupValue[] $values() {
            return new DyPopupValue[]{AGREE, CANCEL, BLOCK, LINK};
        }

        public static DyPopupValue valueOf(String r100) {
            return (DyPopupValue) a.a(DyPopupValue.class, r100);
        }

        public static DyPopupValue[] values() {
            return (DyPopupValue[]) $VALUES.clone();
        }

        static {
            AGREE = new DyPopupValue("AGREE", 0, "agree", ((Number) DyVerifyResultCode.CJ_PAY_DY_VERIFY_SUCCESS.first).intValue());
            CANCEL = new DyPopupValue("CANCEL", 1, "cancel", ((Number) DyVerifyResultCode.CJ_PAY_DY_VERIFY_CANCEL.first).intValue());
            BLOCK = new DyPopupValue("BLOCK", 2, "block", ((Number) DyVerifyResultCode.CJ_PAY_DY_VERIFY_BLOCK.first).intValue());
            LINK = new DyPopupValue("LINK", 3, "link", ((Number) DyVerifyResultCode.CJ_PAY_DY_VERIFY_NOT_CALLBACK.first).intValue());
            $VALUES = $values();
        }

        public final int getCallbackType() {
            return this.callbackType;
        }

        public final String getMotion() {
            return this.motion;
        }

        private DyPopupValue(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.motion = r102;
            this.callbackType = r103;
        }
    }

    public PopupButtonInfo() {
        this(null, null, null, false, null, 31, null);
    }

    public PopupButtonInfo(String r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r104, "color");
        this.value = r100;
        this.label = r101;
        this.url = r102;
        this.bold = r103;
        this.color = r104;
    }

    public /* synthetic */ PopupButtonInfo(String r100, String r101, String r102, boolean r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
