package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.facelive.view.panel.CJPayFaceGuideFullPanel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002:\b$%&'()*+B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010\"\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010#\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "additional_countdown", "", "callback_delay_in_async", "", "camera_permission_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceCameraPermissionConfig;", "cashier_multi_forbidden", "", "cj_face_verify_full_page_bg", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceVerifyTheme;", "cj_face_verify_full_page_middle_title_icon", "cj_face_verify_full_page_scan_gif", "isDefault", "new_ui_style", "protocol_checked_on_default", "result_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultConfig;", "scan_view_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceScanConfig;", "screen_height_percent_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayScreenHeightPercentConfig;", "Lkotlin/collections/ArrayList;", "translucent_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceTranslucentConfig;", "upload_face_video_delay_millis", "hitFullCameraPermission", "riskSource", "", "hitHeightPercentAdapter", "hitTranslucent", "useSettings", "CJPayFaceCameraPermissionConfig", "CJPayFaceResultConfig", "CJPayFaceResultConfigDetail", "CJPayFaceResultExtraConfig", "CJPayFaceScanConfig", "CJPayFaceTranslucentConfig", "CJPayFaceVerifyTheme", "CJPayScreenHeightPercentConfig", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceVerifyConfig implements CJPayObject, Serializable {
    public int additional_countdown;
    public long callback_delay_in_async;
    public CJPayFaceCameraPermissionConfig camera_permission_config;
    public boolean cashier_multi_forbidden;
    public CJPayFaceVerifyTheme cj_face_verify_full_page_bg;
    public CJPayFaceVerifyTheme cj_face_verify_full_page_middle_title_icon;
    public CJPayFaceVerifyTheme cj_face_verify_full_page_scan_gif;
    public boolean isDefault;
    public boolean new_ui_style;
    public boolean protocol_checked_on_default;
    public CJPayFaceResultConfig result_config;
    public CJPayFaceScanConfig scan_view_config;
    public ArrayList<CJPayScreenHeightPercentConfig> screen_height_percent_list;
    public CJPayFaceTranslucentConfig translucent_config;
    public long upload_face_video_delay_millis;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceCameraPermissionConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "full_scene", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceCameraPermissionConfig implements CJPayObject, Serializable {
        public ArrayList<String> full_scene;

        public CJPayFaceCameraPermissionConfig() {
            this.full_scene = CollectionsKt.arrayListOf(new String[]{"右上角-刷脸支付", "同人卡绑卡"});
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "account_protected_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultConfigDetail;", "extra_config_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultExtraConfig;", "Lkotlin/collections/ArrayList;", "monthly_frequency_control", "not_myself_config", "timeout_config", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceResultConfig implements CJPayObject, Serializable {
        public CJPayFaceResultConfigDetail account_protected_config;
        public ArrayList<CJPayFaceResultExtraConfig> extra_config_list;
        public CJPayFaceResultConfigDetail monthly_frequency_control;
        public CJPayFaceResultConfigDetail not_myself_config;
        public CJPayFaceResultConfigDetail timeout_config;

        public CJPayFaceResultConfig() {
            CJPayFaceResultConfigDetail r100 = new CJPayFaceResultConfigDetail();
            r100.title = "抱歉没有认出你";
            r100.sub_title = "请正对屏幕 保持光线充足";
            r100.scan_light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_not_myself_center_image.png";
            r100.scan_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_not_myself_center_image.png";
            this.not_myself_config = r100;
            CJPayFaceResultConfigDetail r101 = new CJPayFaceResultConfigDetail();
            r101.title = "账户已被保护 请明日再试";
            r101.sub_title = "请明日再试";
            r101.scan_light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_account_protect_center_image.png";
            r101.scan_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_account_protect_center_image.png";
            this.account_protected_config = r101;
            CJPayFaceResultConfigDetail r102 = new CJPayFaceResultConfigDetail();
            r102.title = "没检测到你，请正视手机";
            r102.sub_title = "";
            r102.scan_light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_not_myself_center_image.png";
            r102.scan_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_not_myself_center_image.png";
            this.timeout_config = r102;
            CJPayFaceResultConfigDetail r103 = new CJPayFaceResultConfigDetail();
            r103.title = "账户已被保护";
            r103.sub_title = "尝试次数过多，请确保本人操作";
            r103.scan_light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_account_protect_center_image.png";
            r103.scan_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_result_account_protect_center_image.png";
            this.monthly_frequency_control = r103;
            this.extra_config_list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultConfigDetail;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "scan_dark", "", "scan_light", BdpAppEventConstant.PARAMS_SUB_TITLE, "title", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceResultConfigDetail implements CJPayObject, Serializable {
        public String scan_dark;
        public String scan_light;
        public String sub_title;
        public String title;

        public CJPayFaceResultConfigDetail() {
            this.title = "";
            this.sub_title = "";
            this.scan_light = "";
            this.scan_dark = "";
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultExtraConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "code", "", GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG, "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceResultConfigDetail;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceResultExtraConfig implements CJPayObject, Serializable {
        public String code;
        public CJPayFaceResultConfigDetail extra_config;

        public CJPayFaceResultExtraConfig() {
            this.code = "";
            this.extra_config = new CJPayFaceResultConfigDetail();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceScanConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "radius", "", "transition_y", "transition_y_9", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceScanConfig implements CJPayObject, Serializable {
        public float radius;
        public float transition_y;
        public float transition_y_9;

        public CJPayFaceScanConfig() {
            this.transition_y = -92.0f;
            this.transition_y_9 = -112.0f;
            this.radius = 108.0f;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceTranslucentConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "translucent_dialog_hide_delay", "", "translucent_gif", "", "translucent_scene", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "translucent_timeout", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceTranslucentConfig implements CJPayObject, Serializable {
        public long translucent_dialog_hide_delay;
        public String translucent_gif;
        public ArrayList<String> translucent_scene;
        public long translucent_timeout;

        public CJPayFaceTranslucentConfig() {
            this.translucent_scene = new ArrayList();
            this.translucent_timeout = 10000;
            this.translucent_gif = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_face_translucent_icon.gif";
            this.translucent_dialog_hide_delay = 600;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayFaceVerifyTheme;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "additional_dark", "", "additional_light", "dark", "height", "", "light", "width", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayFaceVerifyTheme implements CJPayObject, Serializable {
        public String additional_dark;
        public String additional_light;
        public String dark;
        public int height;
        public String light;
        public int width;

        public CJPayFaceVerifyTheme() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceVerifyConfig$CJPayScreenHeightPercentConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", ECFindSimilarConfig.HEIGHT_PERCENT, "", "height_percent_scene", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayScreenHeightPercentConfig implements CJPayObject, Serializable {
        public int height_percent;
        public ArrayList<String> height_percent_scene;

        public CJPayScreenHeightPercentConfig() {
            this.height_percent_scene = new ArrayList();
        }
    }

    public CJPayFaceVerifyConfig() {
        CJPayFaceVerifyTheme r100 = new CJPayFaceVerifyTheme();
        r100.dark = CJPayFaceGuideFullPanel.darkBgUrl;
        r100.light = CJPayFaceGuideFullPanel.lightBgUrl;
        r100.height = 0;
        r100.width = 0;
        this.cj_face_verify_full_page_bg = r100;
        CJPayFaceVerifyTheme r101 = new CJPayFaceVerifyTheme();
        r101.dark = CJPayFaceGuideFullPanel.darkTitleIconUrl;
        r101.light = CJPayFaceGuideFullPanel.lightTitleIconUrl;
        r101.height = 20;
        r101.width = 90;
        this.cj_face_verify_full_page_middle_title_icon = r101;
        CJPayFaceVerifyTheme r102 = new CJPayFaceVerifyTheme();
        r102.additional_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_guide_center_image_additional_V2_dark.png";
        r102.additional_light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_guide_center_image_additional_V2_light.png";
        r102.dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_guide_center_image.png";
        r102.light = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/prod/cj_face_guide_center_image.png";
        r102.width = VideoRef.VALUE_VIDEO_REF_CATEGORY;
        r102.height = VideoRef.VALUE_VIDEO_REF_CATEGORY;
        this.cj_face_verify_full_page_scan_gif = r102;
        CJPayFaceScanConfig r103 = new CJPayFaceScanConfig();
        r103.radius = 108.0f;
        r103.transition_y = -92.0f;
        r103.transition_y_9 = -112.0f;
        this.scan_view_config = r103;
        this.protocol_checked_on_default = true;
        this.new_ui_style = true;
        this.additional_countdown = 3;
        this.result_config = new CJPayFaceResultConfig();
        this.upload_face_video_delay_millis = 10000;
        this.translucent_config = new CJPayFaceTranslucentConfig();
        this.camera_permission_config = new CJPayFaceCameraPermissionConfig();
        this.screen_height_percent_list = new ArrayList();
    }

    public final boolean useSettings() {
        return this.isDefault;
    }

    public final boolean hitFullCameraPermission(String r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        CJPayFaceCameraPermissionConfig r102 = this.camera_permission_config;
        if (r102 == null) goto L20;
        ArrayList<String> r103 = r102.full_scene;
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        if (Intrinsics.areEqual((String) r104.next(), r100) == false) goto L16;
        return true;
    L20:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r101 = true;
        goto L8
    }

    public final int hitHeightPercentAdapter(String r100) {
        if (r100 != null) goto L22;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return 0;
    L10:
        Iterator<T> r102 = this.screen_height_percent_list.iterator();     // Catch: Throwable -> L21
    L12:
        if (r102.hasNext() == false) goto L20;
        CJPayScreenHeightPercentConfig r103 = (CJPayScreenHeightPercentConfig) r102.next();     // Catch: Throwable -> L21
        Iterator<T> r104 = r103.height_percent_scene.iterator();     // Catch: Throwable -> L21
    L15:
        if (r104.hasNext() == false) goto L12;
        if (Intrinsics.areEqual((String) r104.next(), r100) == false) goto L15;
        return r103.height_percent;
    L20:
        return 0;
    L22:
        r101 = true;
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        goto L7
    }

    public final boolean hitTranslucent(String r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        CJPayFaceTranslucentConfig r102 = this.translucent_config;
        if (r102 == null) goto L20;
        ArrayList<String> r103 = r102.translucent_scene;
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        if (Intrinsics.areEqual((String) r104.next(), r100) == false) goto L16;
        return true;
    L20:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r101 = true;
        goto L8
    }
}
