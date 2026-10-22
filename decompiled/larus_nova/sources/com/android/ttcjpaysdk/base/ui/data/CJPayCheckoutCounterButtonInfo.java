package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayCheckoutCounterButtonInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action", "", "button_desc", "", a.KEY_BUTTON_STATUS, a.KEY_BUTTON_TYPE, "error_code", "exts", "find_pwd_url", "header_image", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "jump_url", "left_button_action", "left_button_business_action", "left_button_desc", "lynx_page_info", SendClosePdpEventParam.KEY_LYNX_URL, BdpAppEventConstant.PARAMS_MAIN_TITLE, "page_desc", "right_button_action", "right_button_business_action", "right_button_desc", "super_link", "track_exts", "use_lynx_style", "toCJPayButtonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCheckoutCounterButtonInfo implements CJPayObject, Serializable {
    public int action;
    public String button_desc;
    public String button_status;
    public String button_type;
    public String error_code;
    public String exts;
    public String find_pwd_url;
    public Map<String, CJPayUIComponent> header_image;
    public String jump_url;
    public int left_button_action;
    public int left_button_business_action;
    public String left_button_desc;
    public String lynx_page_info;
    public String lynx_url;
    public String main_title;
    public String page_desc;
    public int right_button_action;
    public int right_button_business_action;
    public String right_button_desc;
    public String super_link;
    public String track_exts;
    public String use_lynx_style;

    public final CJPayButtonInfo toCJPayButtonInfo() {
        CJPayButtonInfo r100 = new CJPayButtonInfo();
        Map<String, CJPayUIComponent> r101 = this.header_image;
        CJPayButtonInfo.HeaderImage r102 = null;
        UIComponent r103 = null;
        if (r101 == null) goto L12;
        CJPayButtonInfo.HeaderImage r104 = new CJPayButtonInfo.HeaderImage();
        CJPayUIComponent r105 = r101.get("normal");
        if (r105 == null) goto L7;
        UIComponent r106 = r105.toUIComponent();
    L8:
        r104.normal = r106;
        CJPayUIComponent r107 = r101.get("dark");
        if (r107 == null) goto L11;
        r103 = r107.toUIComponent();
    L11:
        r104.dark = r103;
        r102 = r104;
        goto L12
    L7:
        r106 = null;
    L12:
        r100.header_image = r102;
        r100.page_desc = this.page_desc;
        r100.button_desc = this.button_desc;
        r100.button_type = this.button_type;
        r100.action = this.action;
        r100.left_button_desc = this.left_button_desc;
        r100.left_button_action = this.left_button_action;
        r100.left_button_business_action = this.left_button_business_action;
        r100.right_button_desc = this.right_button_desc;
        r100.right_button_action = this.right_button_action;
        r100.right_button_business_action = this.right_button_business_action;
        r100.button_status = this.button_status;
        r100.find_pwd_url = this.find_pwd_url;
        r100.error_code = this.error_code;
        r100.jump_url = this.jump_url;
        r100.main_title = this.main_title;
        r100.exts = this.exts;
        r100.super_link = this.super_link;
        r100.track_exts = this.track_exts;
        r100.lynx_url = this.lynx_url;
        r100.use_lynx_style = this.use_lynx_style;
        r100.lynx_page_info = this.lynx_page_info;
        return r100;
    }

    public CJPayCheckoutCounterButtonInfo() {
        this.page_desc = "";
        this.button_desc = "";
        this.button_type = "";
        this.left_button_desc = "";
        this.right_button_desc = "";
        this.button_status = "";
        this.find_pwd_url = "";
        this.error_code = "";
        this.jump_url = "";
        this.main_title = "";
        this.exts = "";
        this.super_link = "";
        this.track_exts = "";
        this.lynx_url = "";
        this.use_lynx_style = "";
        this.lynx_page_info = "";
    }
}
