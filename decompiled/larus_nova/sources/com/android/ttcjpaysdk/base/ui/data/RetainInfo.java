package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BÏ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tR\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "title", "", "retain_msg_bonus", "retain_msg_text", "retain_type", "show_retain_window", "", "retain_plan", "choice_pwd_check_way", "choice_pwd_check_way_title", "show_choice_pwd_check_way", "retain_button_text", "forget_pwd_verify_type", "style", "retain_msg_text_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/RetainMessageInfo;", "Lkotlin/collections/ArrayList;", "retain_msg_bonus_list", "need_verify_retain", "recommend_face_verify_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayRecommendFaceVerifyInfo;", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLcom/android/ttcjpaysdk/base/ui/data/CJPayRecommendFaceVerifyInfo;Ljava/lang/String;)V", "isFaceVerifyKeepDialog", "isNewStyle", "isNewStyleWithContent", "isNewVoucherType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RetainInfo implements CJPayObject, Serializable {
    public String choice_pwd_check_way;
    public String choice_pwd_check_way_title;
    public String forget_pwd_verify_type;
    public boolean need_verify_retain;
    public CJPayRecommendFaceVerifyInfo recommend_face_verify_info;
    public String retain_button_text;
    public String retain_msg_bonus;
    public ArrayList<RetainMessageInfo> retain_msg_bonus_list;
    public String retain_msg_text;
    public ArrayList<RetainMessageInfo> retain_msg_text_list;
    public String retain_plan;
    public String retain_type;
    public boolean show_choice_pwd_check_way;
    public boolean show_retain_window;
    public String style;
    public String title;
    public String type;

    public RetainInfo() {
        this(null, null, null, null, false, null, null, null, false, null, null, null, null, null, false, null, null, 131071, null);
    }

    public final boolean isFaceVerifyKeepDialog() {
        return "feature_voucher".equals(this.type);
    }

    public final boolean isNewStyle() {
        if (EventConstant.Value.AUTH_VERSION_2.equals(this.style) == false) goto L5;
    L8:
        return true;
    L5:
        if ("3.0".equals(this.style) == true) goto L8;
        return false;
    }

    public final boolean isNewVoucherType() {
        return "3.0".equals(this.style);
    }

    public final boolean isNewStyleWithContent() {
        if (isNewStyle() == true) goto L5;
    L9:
        return false;
    L5:
        if ((!this.retain_msg_bonus_list.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!this.retain_msg_text_list.isEmpty()) == false) goto L9;
        return true;
    }

    public RetainInfo(String r110, String r111, String r112, String r210, boolean r211, String r212, String r213, String r214, boolean r215, String r216, String r217, String r218, ArrayList<RetainMessageInfo> r219, ArrayList<RetainMessageInfo> r310, boolean r311, CJPayRecommendFaceVerifyInfo r312, String r313) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "retain_msg_bonus");
        Intrinsics.checkNotNullParameter(r112, "retain_msg_text");
        Intrinsics.checkNotNullParameter(r210, "retain_type");
        Intrinsics.checkNotNullParameter(r212, "retain_plan");
        Intrinsics.checkNotNullParameter(r213, "choice_pwd_check_way");
        Intrinsics.checkNotNullParameter(r214, "choice_pwd_check_way_title");
        Intrinsics.checkNotNullParameter(r216, "retain_button_text");
        Intrinsics.checkNotNullParameter(r217, "forget_pwd_verify_type");
        Intrinsics.checkNotNullParameter(r218, "style");
        Intrinsics.checkNotNullParameter(r219, "retain_msg_text_list");
        Intrinsics.checkNotNullParameter(r310, "retain_msg_bonus_list");
        Intrinsics.checkNotNullParameter(r312, "recommend_face_verify_info");
        Intrinsics.checkNotNullParameter(r313, "type");
        this.title = r110;
        this.retain_msg_bonus = r111;
        this.retain_msg_text = r112;
        this.retain_type = r210;
        this.show_retain_window = r211;
        this.retain_plan = r212;
        this.choice_pwd_check_way = r213;
        this.choice_pwd_check_way_title = r214;
        this.show_choice_pwd_check_way = r215;
        this.retain_button_text = r216;
        this.forget_pwd_verify_type = r217;
        this.style = r218;
        this.retain_msg_text_list = r219;
        this.retain_msg_bonus_list = r310;
        this.need_verify_retain = r311;
        this.recommend_face_verify_info = r312;
        this.type = r313;
    }

    public /* synthetic */ RetainInfo(String r210, String r211, String r212, String r213, boolean r214, String r215, String r216, String r310, boolean r311, String r312, String r313, String r314, ArrayList r315, ArrayList r316, boolean r317, CJPayRecommendFaceVerifyInfo r318, String r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = "2";
    L19:
        if ((r410 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r410 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r410 & 4096) == 0) goto L53;
        ArrayList r115 = new ArrayList();
    L55:
        if ((r410 & 8192) == 0) goto L57;
        ArrayList r107 = new ArrayList();
    L59:
        if ((r410 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        CJPayRecommendFaceVerifyInfo r116 = new CJPayRecommendFaceVerifyInfo(null, null, null, 7, null);
    L67:
        if ((r410 & 65536) == 0) goto L69;
        String r109 = "";
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r109);
        return;
    L69:
        r109 = r319;
        goto L70
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L59
    L53:
        r115 = r315;
        goto L55
    L49:
        r114 = r314;
        goto L51
    L45:
        r113 = r313;
        goto L47
    L41:
        r112 = r312;
        goto L43
    L37:
        r111 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
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
