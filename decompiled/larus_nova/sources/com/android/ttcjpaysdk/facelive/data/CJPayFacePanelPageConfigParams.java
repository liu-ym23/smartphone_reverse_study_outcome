package com.android.ttcjpaysdk.facelive.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.facelive.view.panel.CJPayFaceGuideFullPanel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002Bõ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0002\u0010\u001dR\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/data/CJPayFacePanelPageConfigParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "is_top_brand", "", "top_brand_icon", "top_brand_icon_dark", "main_title_desc", "subhead_desc", "signed_protocol_desc", "unsigned_protocol_desc", "popup_protocol_desc", "agreement_desc", "agreement_url", "signed_button_desc", "unsigned_button_desc", "retention_desc", "skip_live_confirm", "exit_retention_desc", "is_use_default_page_bg", "is_invoke_result", "sex", "agreement_checkbox_noshow_switch", "dialog_negative_btn", "dialog_negative_action", "face_prompt_audio_enable", "screen_height", "", "show_insurance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFacePanelPageConfigParams implements CJPayObject, Serializable {
    public String agreement_checkbox_noshow_switch;
    public String agreement_desc;
    public String agreement_url;
    public String dialog_negative_action;
    public String dialog_negative_btn;
    public String exit_retention_desc;
    public String face_prompt_audio_enable;
    public String is_invoke_result;
    public String is_top_brand;
    public String is_use_default_page_bg;
    public String main_title_desc;
    public String popup_protocol_desc;
    public String retention_desc;
    public int screen_height;
    public String sex;
    public String show_insurance;
    public String signed_button_desc;
    public String signed_protocol_desc;
    public String skip_live_confirm;
    public String subhead_desc;
    public String top_brand_icon;
    public String top_brand_icon_dark;
    public String unsigned_button_desc;
    public String unsigned_protocol_desc;

    public CJPayFacePanelPageConfigParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 16777215, null);
    }

    public CJPayFacePanelPageConfigParams(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, int r319, String r410) {
        Intrinsics.checkNotNullParameter(r110, "is_top_brand");
        Intrinsics.checkNotNullParameter(r111, "top_brand_icon");
        Intrinsics.checkNotNullParameter(r112, "top_brand_icon_dark");
        Intrinsics.checkNotNullParameter(r210, "main_title_desc");
        Intrinsics.checkNotNullParameter(r211, "subhead_desc");
        Intrinsics.checkNotNullParameter(r212, "signed_protocol_desc");
        Intrinsics.checkNotNullParameter(r213, "unsigned_protocol_desc");
        Intrinsics.checkNotNullParameter(r214, "popup_protocol_desc");
        Intrinsics.checkNotNullParameter(r215, "agreement_desc");
        Intrinsics.checkNotNullParameter(r216, "agreement_url");
        Intrinsics.checkNotNullParameter(r217, "signed_button_desc");
        Intrinsics.checkNotNullParameter(r218, "unsigned_button_desc");
        Intrinsics.checkNotNullParameter(r219, "retention_desc");
        Intrinsics.checkNotNullParameter(r310, "skip_live_confirm");
        Intrinsics.checkNotNullParameter(r311, "exit_retention_desc");
        Intrinsics.checkNotNullParameter(r312, "is_use_default_page_bg");
        Intrinsics.checkNotNullParameter(r313, "is_invoke_result");
        Intrinsics.checkNotNullParameter(r314, "sex");
        Intrinsics.checkNotNullParameter(r315, "agreement_checkbox_noshow_switch");
        Intrinsics.checkNotNullParameter(r316, "dialog_negative_btn");
        Intrinsics.checkNotNullParameter(r317, "dialog_negative_action");
        Intrinsics.checkNotNullParameter(r318, "face_prompt_audio_enable");
        Intrinsics.checkNotNullParameter(r410, "show_insurance");
        this.is_top_brand = r110;
        this.top_brand_icon = r111;
        this.top_brand_icon_dark = r112;
        this.main_title_desc = r210;
        this.subhead_desc = r211;
        this.signed_protocol_desc = r212;
        this.unsigned_protocol_desc = r213;
        this.popup_protocol_desc = r214;
        this.agreement_desc = r215;
        this.agreement_url = r216;
        this.signed_button_desc = r217;
        this.unsigned_button_desc = r218;
        this.retention_desc = r219;
        this.skip_live_confirm = r310;
        this.exit_retention_desc = r311;
        this.is_use_default_page_bg = r312;
        this.is_invoke_result = r313;
        this.sex = r314;
        this.agreement_checkbox_noshow_switch = r315;
        this.dialog_negative_btn = r316;
        this.dialog_negative_action = r317;
        this.face_prompt_audio_enable = r318;
        this.screen_height = r319;
        this.show_insurance = r410;
    }

    public /* synthetic */ CJPayFacePanelPageConfigParams(String r210, String r211, String r212, String r213, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, int r418, String r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = CJPayFaceGuideFullPanel.lightTitleIconUrl;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = CJPayFaceGuideFullPanel.darkTitleIconUrl;
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r510 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r510 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r510 & 512) == 0) goto L41;
        String r111 = "";
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r114 = "";
    L55:
        if ((r510 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r510 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r510 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r510 & 131072) == 0) goto L73;
        String r118 = "M";
    L75:
        if ((r510 & 262144) == 0) goto L77;
        String r119 = "1";
    L79:
        if ((r510 & 524288) == 0) goto L81;
        String r214 = "";
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        String r215 = "";
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        String r216 = "0";
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        int r217 = 0;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        String r109 = "";
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r214, r215, r216, r217, r109);
        return;
    L97:
        r109 = r419;
        goto L98
    L93:
        r217 = r418;
        goto L95
    L89:
        r216 = r417;
        goto L91
    L85:
        r215 = r416;
        goto L87
    L81:
        r214 = r415;
        goto L83
    L77:
        r119 = r414;
        goto L79
    L73:
        r118 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L71
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r115 = r319;
        goto L59
    L53:
        r114 = r318;
        goto L55
    L49:
        r113 = r317;
        goto L51
    L45:
        r112 = r316;
        goto L47
    L41:
        r111 = r315;
        goto L43
    L37:
        r110 = r314;
        goto L39
    L33:
        r107 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
