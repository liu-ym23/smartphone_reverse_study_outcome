package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B¯\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0017\u001a\u00020\u0004J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "icon_urls", "", "color", "pic_title", "pic_msg", "pic_url", "default_checked", "input_affect_window", "jump_url", "is_control_frequency", "dialog_style", "need_save_user_info", "title", "msg", a.KEY_BUTTON_TYPE, "button_msg", "button_left_msg", "button_right_msg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "normalStyle", "getColor", "getIconUrls", "", "isNewsStyleKeepDialog", "", "needCacheUserInput", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogBean implements CJPayObject, Serializable {
    public String button_left_msg;
    public String button_msg;
    public String button_right_msg;
    public String button_type;
    public String color;
    public String default_checked;
    public String dialog_style;
    public String icon_urls;
    public String input_affect_window;
    public String is_control_frequency;
    public String jump_url;
    public String msg;
    public String need_save_user_info;
    private final String normalStyle;
    public String pic_msg;
    public String pic_title;
    public String pic_url;
    public String title;

    public CJPayKeepDialogBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public final String getColor() {
        String r100 = this.color;
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L12;
    L16:
        return "";
    L12:
        if (StringsKt.startsWith$default(this.color, "#", false, 2, null) == false) goto L14;
        String r102 = this.color;
    L15:
        if (r102 == null) goto L16;
        return r102;
    L14:
        r102 = "#" + this.color;
        goto L15
    L5:
        r101 = false;
        goto L7
    }

    public final List<String> getIconUrls() {
        return StringsKt.split$default(this.icon_urls, new String[]{","}, false, 0, 6, null);
    }

    public final boolean isNewsStyleKeepDialog() {
        if (Intrinsics.areEqual(this.dialog_style, this.normalStyle) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.is_control_frequency, "0") == false) goto L7;
        return true;
    }

    public final boolean needCacheUserInput() {
        return Intrinsics.areEqual(this.need_save_user_info, "Y");
    }

    public CJPayKeepDialogBean(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r110, "icon_urls");
        Intrinsics.checkNotNullParameter(r111, "color");
        Intrinsics.checkNotNullParameter(r112, "pic_title");
        Intrinsics.checkNotNullParameter(r210, "pic_msg");
        Intrinsics.checkNotNullParameter(r211, "pic_url");
        Intrinsics.checkNotNullParameter(r212, "default_checked");
        Intrinsics.checkNotNullParameter(r213, "input_affect_window");
        Intrinsics.checkNotNullParameter(r214, "jump_url");
        Intrinsics.checkNotNullParameter(r215, "is_control_frequency");
        Intrinsics.checkNotNullParameter(r216, "dialog_style");
        Intrinsics.checkNotNullParameter(r217, "need_save_user_info");
        Intrinsics.checkNotNullParameter(r218, "title");
        Intrinsics.checkNotNullParameter(r219, "msg");
        Intrinsics.checkNotNullParameter(r310, a.KEY_BUTTON_TYPE);
        Intrinsics.checkNotNullParameter(r311, "button_msg");
        Intrinsics.checkNotNullParameter(r312, "button_left_msg");
        Intrinsics.checkNotNullParameter(r313, "button_right_msg");
        this.icon_urls = r110;
        this.color = r111;
        this.pic_title = r112;
        this.pic_msg = r210;
        this.pic_url = r211;
        this.default_checked = r212;
        this.input_affect_window = r213;
        this.jump_url = r214;
        this.is_control_frequency = r215;
        this.dialog_style = r216;
        this.need_save_user_info = r217;
        this.title = r218;
        this.msg = r219;
        this.button_type = r310;
        this.button_msg = r311;
        this.button_left_msg = r312;
        this.button_right_msg = r313;
        this.normalStyle = "normal";
    }

    public /* synthetic */ CJPayKeepDialogBean(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = "Y";
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r111 = "0";
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r116 = "";
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = "";
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r109 = "";
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
