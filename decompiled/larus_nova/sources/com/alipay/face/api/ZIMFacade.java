package com.alipay.face.api;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtf.face.api.DTFacade;
import com.dtf.face.api.DTFacadeBuilder;
import com.dtf.face.api.DTFacadeExt;
import com.dtf.face.api.IDTCrashCallback;
import com.dtf.face.api.IDTFacade;
import com.dtf.face.api.IDTFragment;
import com.dtf.face.api.IDTLoadingFragment;
import com.dtf.face.network.APICallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ZIMFacade {
    public static final String ZIM_EXT_PARAMS_KEY_FACE_PROGRESS_COLOR = "ext_params_key_face_progress_color";
    public static final String ZIM_EXT_PARAMS_KEY_FULLSCREEN = "ext_params_key_open_fullscreen";
    public static final String ZIM_EXT_PARAMS_KEY_NEED_FACE_NOTICE = "params_key_need_face_notice";
    public static final String ZIM_EXT_PARAMS_KEY_NEED_PERMISSION_TOAST = "params_key_need_permission_toast";
    public static final String ZIM_EXT_PARAMS_KEY_NEED_PERMISSION_TOAST_DURATION = "params_key_need_permission_toast_duration";
    public static final String ZIM_EXT_PARAMS_KEY_OCR_BOTTOM_BUTTON_COLOR = "ext_params_key_ocr_bottom_button_color";
    public static final String ZIM_EXT_PARAMS_KEY_OK_HTTP_OPT = "ext_params_key_ok_http_opt";
    public static final String ZIM_EXT_PARAMS_KEY_OPEN_WEBVIEW_RENDER = "ext_params_key_open_webview_render";
    public static final String ZIM_EXT_PARAMS_KEY_PRELOAD_MODEL_URL = "modelURL";
    public static final String ZIM_EXT_PARAMS_KEY_SCREEN_ORIENTATION = "ext_params_key_screen_orientation";
    public static final String ZIM_EXT_PARAMS_KEY_TIMEOUT_FOR_INIT = "ext_params_key_timeout_for_init";
    public static final String ZIM_EXT_PARAMS_KEY_TIMEOUT_FOR_VERIFY = "ext_params_key_timeout_for_verify";
    public static final String ZIM_EXT_PARAMS_KEY_TIP_INDEX_TT = "ext_params_key_tip_index_tt";
    public static final String ZIM_EXT_PARAMS_KEY_TOP_TIP_INDEX = "ext_params_key_top_tip_index";
    public static final String ZIM_EXT_PARAMS_KEY_USE_VIDEO = "ext_params_key_use_video";
    public static final String ZIM_EXT_PARAMS_VAL_CLOSE_FULLSCREEN = "false";
    public static final String ZIM_EXT_PARAMS_VAL_NEED_FACE_NOTICE_FALSE = "false";
    public static final String ZIM_EXT_PARAMS_VAL_NEED_FACE_NOTICE_TRUE = "true";
    public static final String ZIM_EXT_PARAMS_VAL_NEED_PERMISSION_TOAST_FALSE = "false";
    public static final String ZIM_EXT_PARAMS_VAL_NEED_PERMISSION_TOAST_TRUE = "true";
    public static final String ZIM_EXT_PARAMS_VAL_OK_HTTP_OPT_FALSE = "false";
    public static final String ZIM_EXT_PARAMS_VAL_OK_HTTP_OPT_TRUE = "true";
    public static final String ZIM_EXT_PARAMS_VAL_OPEN_FULLSCREEN = "true";
    public static final String ZIM_EXT_PARAMS_VAL_OPEN_WEBVIEW_RENDER_FALSE = "false";
    public static final String ZIM_EXT_PARAMS_VAL_OPEN_WEBVIEW_RENDER_TRUE = "true";
    public static final String ZIM_EXT_PARAMS_VAL_SCREEN_LAND = "ext_params_val_screen_land";
    public static final String ZIM_EXT_PARAMS_VAL_SCREEN_PORT = "ext_params_val_screen_port";
    public static final String ZIM_EXT_PARAMS_VAL_USE_VIDEO_FALSE = "false";
    public static final String ZIM_EXT_PARAMS_VAL_USE_VIDEO_TRUE = "true";
    public static final int ZIM_EXT_PARAMS_VAL_ZIM_EXT_PARAMS_CONFIG_ASSETS_NAME = 2;
    public static final int ZIM_EXT_PARAMS_VAL_ZIM_EXT_PARAMS_CONFIG_FILE_JSON = 0;
    public static final int ZIM_EXT_PARAMS_VAL_ZIM_EXT_PARAMS_CONFIG_FILE_PATH = 1;
    public String ZIM_EXT_PARAMS_KEY_LANGUAGE;
    public String ZIM_EXT_PARAMS_LAN_VAL_EN;
    public String ZIM_EXT_PARAMS_LAN_VAL_IN;
    public String ZIM_EXT_PARAMS_LAN_VAL_JA;
    public String ZIM_EXT_PARAMS_LAN_VAL_ko;
    public String ZIM_EXT_PARAMS_LAN_VAL_zh;
    public String ZIM_EXT_PARAMS_LAN_VAL_zh_hk;
    public String ZIM_EXT_PARAMS_LAN_VAL_zh_tw;
    private DTFacade facade;

    public static String getSdkVersion() {
        return "2.3.43";
    }

    public void release() {
        DTFacade r100 = this.facade;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public void cleanResource() {
        release();
    }

    public ZIMFacade(Context r100) {
        this.ZIM_EXT_PARAMS_KEY_LANGUAGE = IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE;
        this.ZIM_EXT_PARAMS_LAN_VAL_EN = "en";
        this.ZIM_EXT_PARAMS_LAN_VAL_IN = "in";
        this.ZIM_EXT_PARAMS_LAN_VAL_JA = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA;
        this.ZIM_EXT_PARAMS_LAN_VAL_ko = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO;
        this.ZIM_EXT_PARAMS_LAN_VAL_zh = "zh-CN";
        this.ZIM_EXT_PARAMS_LAN_VAL_zh_hk = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK;
        this.ZIM_EXT_PARAMS_LAN_VAL_zh_tw = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW;
        this.facade = DTFacadeBuilder.create(r100);
    }

    public static String getMetaInfos(Context r100) {
        return getMetaInfos(r100, null);
    }

    public static int install(Context r100) {
        return installCommon(r100, false);
    }

    public static int installIPv6(Context r100) {
        return installCommon(r100, true);
    }

    public void setCustomLoadingFragment(Class<? extends IDTLoadingFragment> r100) {
        DTFacadeExt.setCustomLoadingFragment(r100);
    }

    public void setCustomUIListener(ZIMUICustomListener r100) {
        DTFacadeExt.setCustomUIListener(r100);
    }

    public void setCustomZimFragment(Class<? extends IDTFragment> r100) {
        DTFacadeExt.setCustomFragment(r100);
    }

    public void updateContext(Context r100) {
        this.facade.updateContext(r100);
    }

    public static String getMetaInfos(Context r100, Map<String, Object> r101) {
        String r102 = DTFacade.getMetaInfo(r100, r101);
        JSONObject r103 = JSON.parseObject(r102);     // Catch: Throwable -> L7
        if (r103 == null) goto L10;
        r103.remove("guardToken");     // Catch: Throwable -> L7
        return r103.toJSONString();
    L10:
        return r102;
    L11:
        return r102;
    }

    private static int installCommon(Context r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("isIPv6", Boolean.valueOf(r101));
        return DTFacade.init(r100, r102);
    }

    public static void reportCrash(String r100, final ZIMCrashCallback r101) {
        if (r101 != null) goto L4;
        IDTCrashCallback r102 = null;
    L5:
        DTFacadeExt.reportCrash(r100, r102);
        return;
    L4:
        r102 = new AnonymousClass2(r101);
        goto L5
    }

    public String setCustomTxtConfig(int r100, String r101) {
        return DTFacadeExt.setCustomTxtConfig(r100, r101);
    }

    public String setCustomUIConfig(int r100, String r101) {
        return DTFacadeExt.setCustomUIConfig(r100, r101);
    }

    public static void preload(Context r100, Map<String, Object> r101, APICallback<String> r102) {
        DTFacade.preload(r100, r101, r102);
    }

    public void verify(String r100, boolean r101, ZIMCallback r102) {
        verify(r100, r101, null, r102);
    }

    public void verify(String r100, boolean r101, HashMap<String, String> r102, final ZIMCallback r103) {
        this.facade.verify(r100, r101, r102, new AnonymousClass1(this, r103));
    }
}
