package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0085\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfoV2;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "icon_url", "", "action", "schema", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, "title", "bottom_retain_button_text", "action_button_list", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayActionButtonInfo;", BindCardPayConfirmConstants.Key.POP_STYLE, "bottom_retain_button_action", "no_close_icon", "", "style", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayForgetPwdBtnInfoV2 implements CJPayObject, Serializable {
    public String action;
    public List<CJPayActionButtonInfo> action_button_list;
    public String bottom_retain_button_action;
    public String bottom_retain_button_text;
    public String icon_url;
    public String lynx_schema;
    public boolean no_close_icon;
    public String pop_style;
    public String schema;
    public String style;
    public String title;

    public CJPayForgetPwdBtnInfoV2() {
        this(null, null, null, null, null, null, null, null, null, false, null, 2047, null);
    }

    public CJPayForgetPwdBtnInfoV2(String r100, String r101, String r102, String r103, String r104, String r105, List<CJPayActionButtonInfo> r106, String r107, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "icon_url");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY);
        this.icon_url = r100;
        this.action = r101;
        this.schema = r102;
        this.lynx_schema = r103;
        this.title = r104;
        this.bottom_retain_button_text = r105;
        this.action_button_list = r106;
        this.pop_style = r107;
        this.bottom_retain_button_action = r110;
        this.no_close_icon = r111;
        this.style = r112;
    }

    public /* synthetic */ CJPayForgetPwdBtnInfoV2(String r110, String r111, String r112, String r113, String r114, String r115, List r116, String r210, String r211, boolean r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = "";
        if ((r214 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r214 & 8) != 0) goto L18;
        r100 = r113;
    L18:
        String r104 = null;
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r118 = false;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r104 = r213;
    L46:
        this(r101, r102, r103, r100, r105, r106, r107, r108, r117, r118, r104);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
