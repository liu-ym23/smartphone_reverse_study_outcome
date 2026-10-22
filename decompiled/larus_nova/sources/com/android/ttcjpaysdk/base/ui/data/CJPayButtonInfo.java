package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayButtonInfo implements CJPayObject, Serializable {
    public int action;
    public String button_desc;
    public String button_status;
    public String button_type;
    public String error_code;
    public String exts;
    public String find_pwd_url;
    public HeaderImage header_image;
    public Map<String, UIComponent> header_image_pb;
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

    public static final enum ButtonType extends Enum<ButtonType> {
        private static final /* synthetic */ ButtonType[] $VALUES = null;
        public static final ButtonType DOUBLE_BUTTON = null;
        public static final ButtonType SINGLE_BUTTON = null;
        private final String type;

        private static /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{DOUBLE_BUTTON, SINGLE_BUTTON};
        }

        static {
            DOUBLE_BUTTON = new ButtonType("DOUBLE_BUTTON", 0, "2");
            SINGLE_BUTTON = new ButtonType("SINGLE_BUTTON", 1, "3");
            $VALUES = $values();
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }

        public String getType() {
            return this.type;
        }

        public static ButtonType valueOf(String r100) {
            return (ButtonType) a.a(ButtonType.class, r100);
        }

        private ButtonType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static class HeaderImage implements CJPayObject, Serializable {
        public UIComponent dark;
        public UIComponent normal;

        public HeaderImage() {
        }
    }

    public void afterProtoDecode() {
        Map<String, UIComponent> r100 = this.header_image_pb;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L15;
        this.header_image = new HeaderImage();
        if (this.header_image_pb.containsKey("normal") == false) goto L10;
        HeaderImage r101 = this.header_image;
        r101.normal = this.header_image_pb.get("normal");
    L10:
        if (this.header_image_pb.containsKey("dark") == false) goto L12;
        HeaderImage r102 = this.header_image;
        r102.dark = this.header_image_pb.get("dark");
    L12:
        this.header_image_pb = null;
        return;
    }

    public boolean isGoCustomerServiceDialog() {
        return hasAction(13);
    }

    public boolean isShow() {
        return TextUtils.equals("1", this.button_status);
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        HeaderImage r101 = this.header_image;     // Catch: JSONException -> L8
        if (r101 == null) goto L6;
        r100.put("header_image", CJPayJsonParser.toJsonObject(r101));     // Catch: JSONException -> L8
    L6:
        r100.put("page_desc", this.page_desc);     // Catch: JSONException -> L8
        r100.put("button_desc", this.button_desc);     // Catch: JSONException -> L8
        r100.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, this.button_type);     // Catch: JSONException -> L8
        r100.put("action", this.action);     // Catch: JSONException -> L8
        r100.put("left_button_desc", this.left_button_desc);     // Catch: JSONException -> L8
        r100.put("left_button_action", this.left_button_action);     // Catch: JSONException -> L8
        r100.put("left_button_business_action", this.left_button_business_action);     // Catch: JSONException -> L8
        r100.put("right_button_desc", this.right_button_desc);     // Catch: JSONException -> L8
        r100.put("right_button_action", this.right_button_action);     // Catch: JSONException -> L8
        r100.put("right_button_business_action", this.right_button_business_action);     // Catch: JSONException -> L8
        r100.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, this.button_status);     // Catch: JSONException -> L8
        r100.put("find_pwd_url", this.find_pwd_url);     // Catch: JSONException -> L8
        r100.put("error_code", this.error_code);     // Catch: JSONException -> L8
        r100.put("jump_url", this.jump_url);     // Catch: JSONException -> L8
        r100.put(BdpAppEventConstant.PARAMS_MAIN_TITLE, this.main_title);     // Catch: JSONException -> L8
        r100.put("exts", this.exts);     // Catch: JSONException -> L8
        r100.put("super_link", this.super_link);     // Catch: JSONException -> L8
        r100.put("track_exts", this.track_exts);     // Catch: JSONException -> L8
        r100.put("use_lynx_style", this.use_lynx_style);     // Catch: JSONException -> L8
        r100.put(SendClosePdpEventParam.KEY_LYNX_URL, this.lynx_url);     // Catch: JSONException -> L8
        r100.put("lynx_page_info", this.lynx_page_info);     // Catch: JSONException -> L8
        return r100;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayButtonInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayButtonInfo#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayButtonInfo() {
        this.header_image_pb = null;
        this.page_desc = "";
        this.button_desc = "";
        this.button_type = "";
        this.action = 0;
        this.left_button_desc = "";
        this.left_button_action = 0;
        this.left_button_business_action = 0;
        this.right_button_desc = "";
        this.right_button_action = 0;
        this.right_button_business_action = 0;
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

    private boolean hasAction(int r100) {
        if (this.action != r100) goto L5;
    L10:
        return true;
    L5:
        if (this.left_button_action == r100) goto L10;
        if (this.right_button_action == r100) goto L10;
        return false;
    }
}
