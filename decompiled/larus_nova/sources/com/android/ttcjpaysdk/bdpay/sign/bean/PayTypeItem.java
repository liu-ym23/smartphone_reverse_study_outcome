package com.android.ttcjpaysdk.bdpay.sign.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014Bi\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "bank_card_id", "", "card_no_mask", a.KEY_CARD_TYPE, "icon_url", "name", IGoogleService.ResponseKey.DISPLAY_NAME, "name_mask", "not_support_msg", "pay_mode", "share_asset_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardTypeName", "getDisplayName", "isSameItem", "", MapController.ITEM_LAYER_TAG, "Companion", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayTypeItem implements CJPayObject, Serializable {
    public static final String ADD_NEW_BANK_CARD_PAY_MODE = "3";
    public static final Companion Companion = null;
    public String bank_card_id;
    public String card_no_mask;
    public String card_type;
    public String display_name;
    public String icon_url;
    public String name;
    public String name_mask;
    public String not_support_msg;
    public String pay_mode;
    public String share_asset_id;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem$Companion;", "", "()V", "ADD_NEW_BANK_CARD_PAY_MODE", "", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PayTypeItem() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final String getCardTypeName() {
        String r100 = this.card_type;
        if (Intrinsics.areEqual(r100, "DEBIT") == false) goto L6;
        return "储蓄卡";
    L6:
        if (Intrinsics.areEqual(r100, "CREDIT") == false) goto L8;
        return "信用卡";
    L8:
        return "";
    }

    public final String getDisplayName() {
        if (TextUtils.isEmpty(this.display_name) == false) goto L10;
        int r100 = this.card_no_mask.length();
        if (r100 <= 4) goto L9;
        return this.name + getCardTypeName() + 65288 + this.card_no_mask.substring(r100 - 4) + 65289;
    L9:
        return this.name + getCardTypeName();
    L10:
        return this.display_name;
    }

    public final boolean isSameItem(PayTypeItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (Intrinsics.areEqual(r100.bank_card_id, this.bank_card_id) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.share_asset_id, this.share_asset_id) == false) goto L9;
        if (Intrinsics.areEqual(r100.pay_mode, this.pay_mode) == false) goto L9;
        return true;
    }

    public PayTypeItem(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "bank_card_id");
        Intrinsics.checkNotNullParameter(r101, "card_no_mask");
        Intrinsics.checkNotNullParameter(r102, a.KEY_CARD_TYPE);
        Intrinsics.checkNotNullParameter(r103, "icon_url");
        Intrinsics.checkNotNullParameter(r104, "name");
        Intrinsics.checkNotNullParameter(r105, IGoogleService.ResponseKey.DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r106, "name_mask");
        Intrinsics.checkNotNullParameter(r107, "not_support_msg");
        Intrinsics.checkNotNullParameter(r110, "pay_mode");
        Intrinsics.checkNotNullParameter(r111, "share_asset_id");
        this.bank_card_id = r100;
        this.card_no_mask = r101;
        this.card_type = r102;
        this.icon_url = r103;
        this.name = r104;
        this.display_name = r105;
        this.name_mask = r106;
        this.not_support_msg = r107;
        this.pay_mode = r110;
        this.share_asset_id = r111;
    }

    public /* synthetic */ PayTypeItem(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = "";
        if ((r212 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = "";
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
}
