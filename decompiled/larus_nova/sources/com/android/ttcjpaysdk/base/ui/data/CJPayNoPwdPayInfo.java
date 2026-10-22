package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bank_desc", "", "bank_icon", "bank_name", "button_text", "checkbox_select_default", "choice_pwd_check_way", "confirm_type", "no_pwd_confirm_hide_period", "standard_rec_button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "standard_rec_desc_map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "standard_rec_plain_text", "standard_rec_title_bar", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "Lkotlin/collections/ArrayList;", "standard_show_amount_map", "style", BdpAppEventConstant.PARAMS_SUB_TITLE, "tip_desc", "tip_icon", "tips_checkbox", "title", "getInfoByConfirmType", "confirmType", "isBindCardAdditionalDesc", "", "isBindCardConfirmPopupStyle", "isBindCardHalfPageStyle", "isBindCardPopupStyle", "SecondTradeConfirm", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayNoPwdPayInfo implements CJPayObject, Serializable {
    public String bank_desc;
    public String bank_icon;
    public String bank_name;
    public String button_text;
    public String checkbox_select_default;
    public String choice_pwd_check_way;
    public String confirm_type;
    public String no_pwd_confirm_hide_period;
    public CJPayButtonInfo standard_rec_button_info;
    public HashMap<String, String> standard_rec_desc_map;
    public String standard_rec_plain_text;
    public ArrayList<UIComponent> standard_rec_title_bar;
    public HashMap<String, String> standard_show_amount_map;
    public String style;
    public String sub_title;
    public String tip_desc;
    public String tip_icon;
    public String tips_checkbox;
    public String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo$SecondTradeConfirm;", "", "style", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "BINDCARD_HALFPAGE", "BINDCARD_POPUP", "BINDCARD_WITH_ADDITIONAL_DESC", "BINDCARD_CONFIRM_POPUP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SecondTradeConfirm extends Enum<SecondTradeConfirm> {
        private static final /* synthetic */ SecondTradeConfirm[] $VALUES = null;
        public static final SecondTradeConfirm BINDCARD_CONFIRM_POPUP = null;
        public static final SecondTradeConfirm BINDCARD_HALFPAGE = null;
        public static final SecondTradeConfirm BINDCARD_POPUP = null;
        public static final SecondTradeConfirm BINDCARD_WITH_ADDITIONAL_DESC = null;
        private final String style;

        private static final /* synthetic */ SecondTradeConfirm[] $values() {
            return new SecondTradeConfirm[]{BINDCARD_HALFPAGE, BINDCARD_POPUP, BINDCARD_WITH_ADDITIONAL_DESC, BINDCARD_CONFIRM_POPUP};
        }

        public static SecondTradeConfirm valueOf(String r100) {
            return (SecondTradeConfirm) a.a(SecondTradeConfirm.class, r100);
        }

        public static SecondTradeConfirm[] values() {
            return (SecondTradeConfirm[]) $VALUES.clone();
        }

        static {
            BINDCARD_HALFPAGE = new SecondTradeConfirm("BINDCARD_HALFPAGE", 0, "bindcard_halfpage");
            BINDCARD_POPUP = new SecondTradeConfirm("BINDCARD_POPUP", 1, "bindcard_popup");
            BINDCARD_WITH_ADDITIONAL_DESC = new SecondTradeConfirm("BINDCARD_WITH_ADDITIONAL_DESC", 2, "bindcard_with_additional_desc");
            BINDCARD_CONFIRM_POPUP = new SecondTradeConfirm("BINDCARD_CONFIRM_POPUP", 3, "bindcard_confirm_popup");
            $VALUES = $values();
        }

        public final String getStyle() {
            return this.style;
        }

        private SecondTradeConfirm(String r100, int r101, String r102) {
            super(r100, r101);
            this.style = r102;
        }
    }

    public final boolean isBindCardAdditionalDesc() {
        return Intrinsics.areEqual(this.style, SecondTradeConfirm.BINDCARD_WITH_ADDITIONAL_DESC.getStyle());
    }

    public final boolean isBindCardConfirmPopupStyle() {
        return Intrinsics.areEqual(this.style, SecondTradeConfirm.BINDCARD_CONFIRM_POPUP.getStyle());
    }

    public final boolean isBindCardHalfPageStyle() {
        return Intrinsics.areEqual(this.style, SecondTradeConfirm.BINDCARD_HALFPAGE.getStyle());
    }

    public final boolean isBindCardPopupStyle() {
        return Intrinsics.areEqual(this.style, SecondTradeConfirm.BINDCARD_POPUP.getStyle());
    }

    public CJPayNoPwdPayInfo() {
        this.confirm_type = "";
        this.sub_title = "";
        this.tips_checkbox = "";
        this.choice_pwd_check_way = "";
        this.no_pwd_confirm_hide_period = "";
        this.style = "";
        this.button_text = "";
        this.checkbox_select_default = "0";
        this.standard_rec_desc_map = new HashMap();
        this.standard_show_amount_map = new HashMap();
    }

    public final CJPayNoPwdPayInfo getInfoByConfirmType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "confirmType");
        if (Intrinsics.areEqual(r100, this.confirm_type) == true) goto L7;
        return null;
    L7:
        return this;
    }
}
