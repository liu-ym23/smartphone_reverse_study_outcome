package com.android.ttcjpaysdk.facelive.core;

import android.app.Activity;
import com.android.ttcjpaysdk.facelive.data.GetTicketResponse;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bJ&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/IFaceLive;", "", "doFace", "", "activity", "Landroid/app/Activity;", "ticketResponse", "Lcom/android/ttcjpaysdk/facelive/data/GetTicketResponse;", "extra", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$IExtra;", "Companion", "IExtra", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFaceLive {
    public static final String CERT_SDK_RESPONSE_ALIYUN_PLUGIN_NOT_READY = "1001014";
    public static final String CERT_SDK_RESPONSE_TIME_OUT = "-1102";
    public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003004 = "1003004";
    public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003111 = "1003111";
    public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003113 = "1003113";
    public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003114 = "1003114";
    public static final String CERT_SERVER_RESPONSE_MATCH_NOT_3043030 = "3043030";
    public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1002020 = "1002020";
    public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004007 = "1004007";
    public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004013 = "1004013";
    public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004014 = "1004014";
    public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004031 = "1004031";
    public static final Companion Companion = null;
    public static final String ENCRYPT_PUBLIC_KEY_BY_FINTECH = "public_key";
    public static final String ENCRYPT_VERSION_KEY_BY_FINTECH = "encrypt_version";
    public static final String IS_FINTECH_KEY_BY_FINTECH = "is_fintech";
    public static final String MAP_KEY_BACKGROUND_IMAGE_URL = "background_image_url";
    public static final String MAP_KEY_CERT_RESULT_ERROR_CODE = "errorCode";
    public static final String MAP_KEY_CERT_RESULT_ERROR_DETAIL = "errorDetail";
    public static final String MAP_KEY_CERT_RESULT_ERROR_MSG = "errorMsg";
    public static final String MAP_KEY_CERT_RESULT_JSON_DATA = "jsonData";
    public static final String MAP_KEY_CERT_RESULT_SDK_DATA = "sdk_data";
    public static final String MAP_KEY_CERT_RESULT_STATUS_CODE = "status_code";
    public static final String MAP_KEY_CERT_RESULT_SUCCESS = "success";
    public static final String MAP_KEY_CERT_RESULT_VIDEO_PATH = "video_path";
    public static final String MAP_KEY_CERT_SDK_AID = "cert_app_id";
    public static final String MAP_KEY_CERT_SDK_EVENT_PARAMS = "eventParams";
    public static final String MAP_KEY_CERT_SDK_MODE = "mode";
    public static final String MAP_KEY_CERT_SDK_SCENE = "scene";
    public static final String MAP_KEY_CERT_SDK_TICKET = "ticket";
    public static final String MAP_KEY_CERT_USE_NEW_API = "use_new_api";
    public static final String MAP_KEY_FACE_CYCLE_RADIUS = "face_cycle_radius";
    public static final String MAP_KEY_FACE_CYCLE_TRANSLATION_Y = "face_cycle_translation_y";
    public static final String MAP_KEY_FACE_DIALOG_TIMEOUT = "face_dialog_timeout";
    public static final String MAP_KEY_FACE_FULL_PROGRESS_BAR_OPT = "face_full_progress_bar_opt";
    public static final String MAP_KEY_FACE_INIT_PASS_CODE = "face_init_pass_code";
    public static final String MAP_KEY_FACE_PAGE_VIEW_HEIGHT = "face_page_view_height";
    public static final String MAP_KEY_FACE_PROMPT_ANIMATION_ENABLE = "face_prompt_animation_enable";
    public static final String MAP_KEY_FACE_PROMPT_AUDIO_ENABLE = "face_prompt_audio_enable";
    public static final String MAP_KEY_FACE_VIEW_TYPE = "face_view_type";
    public static final String MAP_KEY_NONE_SDK_FACE_COMPARE = "none_sdk_face_compare";
    public static final String MAP_KEY_RETAIN_NEGATIVE_BTN = "retain_negative_btn";
    public static final String MAP_KEY_RETAIN_TEXT = "retain_text";
    public static final String MAP_KEY_TITLE_ICON_URL = "title_icon_url";
    public static final String MAP_KEY_WITHOUT_ANIMATION = "without_animation";
    public static final String MAP_VALUE_CERT_SDK_AID_FOR_CJ = "1792";
    public static final String MAP_VALUE_FACE_VIEW_TYPE_TRANSLUCENT = "dialog_face";
    public static final String PATH_PREFIX_KEY_BY_FINTECH = "path_prefix";
    public static final String SERVER_DOMAIN_KEY_BY_FINTECH = "server_domain";
    public static final String SERVER_RESPONSE_OK = "MP000000";
    public static final String SERVER_RESPONSE_RETRY = "MP060005";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b2\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$Companion;", "", "()V", "CERT_SDK_RESPONSE_ALIYUN_PLUGIN_NOT_READY", "", "CERT_SDK_RESPONSE_TIME_OUT", "CERT_SERVER_RESPONSE_MATCH_NOT_1003004", "CERT_SERVER_RESPONSE_MATCH_NOT_1003111", "CERT_SERVER_RESPONSE_MATCH_NOT_1003113", "CERT_SERVER_RESPONSE_MATCH_NOT_1003114", "CERT_SERVER_RESPONSE_MATCH_NOT_3043030", "CERT_SERVER_RESPONSE_RISK_CONTROL_1002020", "CERT_SERVER_RESPONSE_RISK_CONTROL_1004007", "CERT_SERVER_RESPONSE_RISK_CONTROL_1004013", "CERT_SERVER_RESPONSE_RISK_CONTROL_1004014", "CERT_SERVER_RESPONSE_RISK_CONTROL_1004031", "ENCRYPT_PUBLIC_KEY_BY_FINTECH", "ENCRYPT_VERSION_KEY_BY_FINTECH", "IS_FINTECH_KEY_BY_FINTECH", "MAP_KEY_BACKGROUND_IMAGE_URL", "MAP_KEY_CERT_RESULT_ERROR_CODE", "MAP_KEY_CERT_RESULT_ERROR_DETAIL", "MAP_KEY_CERT_RESULT_ERROR_MSG", "MAP_KEY_CERT_RESULT_JSON_DATA", "MAP_KEY_CERT_RESULT_SDK_DATA", "MAP_KEY_CERT_RESULT_STATUS_CODE", "MAP_KEY_CERT_RESULT_SUCCESS", "MAP_KEY_CERT_RESULT_VIDEO_PATH", "MAP_KEY_CERT_SDK_AID", "MAP_KEY_CERT_SDK_EVENT_PARAMS", "MAP_KEY_CERT_SDK_MODE", "MAP_KEY_CERT_SDK_SCENE", "MAP_KEY_CERT_SDK_TICKET", "MAP_KEY_CERT_USE_NEW_API", "MAP_KEY_FACE_CYCLE_RADIUS", "MAP_KEY_FACE_CYCLE_TRANSLATION_Y", "MAP_KEY_FACE_DIALOG_TIMEOUT", "MAP_KEY_FACE_FULL_PROGRESS_BAR_OPT", "MAP_KEY_FACE_INIT_PASS_CODE", "MAP_KEY_FACE_PAGE_VIEW_HEIGHT", "MAP_KEY_FACE_PROMPT_ANIMATION_ENABLE", "MAP_KEY_FACE_PROMPT_AUDIO_ENABLE", "MAP_KEY_FACE_VIEW_TYPE", "MAP_KEY_NONE_SDK_FACE_COMPARE", "MAP_KEY_RETAIN_NEGATIVE_BTN", "MAP_KEY_RETAIN_TEXT", "MAP_KEY_TITLE_ICON_URL", "MAP_KEY_WITHOUT_ANIMATION", "MAP_VALUE_CERT_SDK_AID_FOR_CJ", "MAP_VALUE_FACE_VIEW_TYPE_TRANSLUCENT", "PATH_PREFIX_KEY_BY_FINTECH", "SERVER_DOMAIN_KEY_BY_FINTECH", "SERVER_RESPONSE_OK", "SERVER_RESPONSE_RETRY", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String CERT_SDK_RESPONSE_ALIYUN_PLUGIN_NOT_READY = "1001014";
        public static final String CERT_SDK_RESPONSE_TIME_OUT = "-1102";
        public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003004 = "1003004";
        public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003111 = "1003111";
        public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003113 = "1003113";
        public static final String CERT_SERVER_RESPONSE_MATCH_NOT_1003114 = "1003114";
        public static final String CERT_SERVER_RESPONSE_MATCH_NOT_3043030 = "3043030";
        public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1002020 = "1002020";
        public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004007 = "1004007";
        public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004013 = "1004013";
        public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004014 = "1004014";
        public static final String CERT_SERVER_RESPONSE_RISK_CONTROL_1004031 = "1004031";
        public static final String ENCRYPT_PUBLIC_KEY_BY_FINTECH = "public_key";
        public static final String ENCRYPT_VERSION_KEY_BY_FINTECH = "encrypt_version";
        public static final String IS_FINTECH_KEY_BY_FINTECH = "is_fintech";
        public static final String MAP_KEY_BACKGROUND_IMAGE_URL = "background_image_url";
        public static final String MAP_KEY_CERT_RESULT_ERROR_CODE = "errorCode";
        public static final String MAP_KEY_CERT_RESULT_ERROR_DETAIL = "errorDetail";
        public static final String MAP_KEY_CERT_RESULT_ERROR_MSG = "errorMsg";
        public static final String MAP_KEY_CERT_RESULT_JSON_DATA = "jsonData";
        public static final String MAP_KEY_CERT_RESULT_SDK_DATA = "sdk_data";
        public static final String MAP_KEY_CERT_RESULT_STATUS_CODE = "status_code";
        public static final String MAP_KEY_CERT_RESULT_SUCCESS = "success";
        public static final String MAP_KEY_CERT_RESULT_VIDEO_PATH = "video_path";
        public static final String MAP_KEY_CERT_SDK_AID = "cert_app_id";
        public static final String MAP_KEY_CERT_SDK_EVENT_PARAMS = "eventParams";
        public static final String MAP_KEY_CERT_SDK_MODE = "mode";
        public static final String MAP_KEY_CERT_SDK_SCENE = "scene";
        public static final String MAP_KEY_CERT_SDK_TICKET = "ticket";
        public static final String MAP_KEY_CERT_USE_NEW_API = "use_new_api";
        public static final String MAP_KEY_FACE_CYCLE_RADIUS = "face_cycle_radius";
        public static final String MAP_KEY_FACE_CYCLE_TRANSLATION_Y = "face_cycle_translation_y";
        public static final String MAP_KEY_FACE_DIALOG_TIMEOUT = "face_dialog_timeout";
        public static final String MAP_KEY_FACE_FULL_PROGRESS_BAR_OPT = "face_full_progress_bar_opt";
        public static final String MAP_KEY_FACE_INIT_PASS_CODE = "face_init_pass_code";
        public static final String MAP_KEY_FACE_PAGE_VIEW_HEIGHT = "face_page_view_height";
        public static final String MAP_KEY_FACE_PROMPT_ANIMATION_ENABLE = "face_prompt_animation_enable";
        public static final String MAP_KEY_FACE_PROMPT_AUDIO_ENABLE = "face_prompt_audio_enable";
        public static final String MAP_KEY_FACE_VIEW_TYPE = "face_view_type";
        public static final String MAP_KEY_NONE_SDK_FACE_COMPARE = "none_sdk_face_compare";
        public static final String MAP_KEY_RETAIN_NEGATIVE_BTN = "retain_negative_btn";
        public static final String MAP_KEY_RETAIN_TEXT = "retain_text";
        public static final String MAP_KEY_TITLE_ICON_URL = "title_icon_url";
        public static final String MAP_KEY_WITHOUT_ANIMATION = "without_animation";
        public static final String MAP_VALUE_CERT_SDK_AID_FOR_CJ = "1792";
        public static final String MAP_VALUE_FACE_VIEW_TYPE_TRANSLUCENT = "dialog_face";
        public static final String PATH_PREFIX_KEY_BY_FINTECH = "path_prefix";
        public static final String SERVER_DOMAIN_KEY_BY_FINTECH = "server_domain";
        public static final String SERVER_RESPONSE_OK = "MP000000";
        public static final String SERVER_RESPONSE_RETRY = "MP060005";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void doFace$default(IFaceLive r100, Activity r101, GetTicketResponse r102, IExtra r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.doFace(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doFace");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0005H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$IExtra;", "", "dismissLoading", "", "getCertAppId", "", "getCertConfig", "", "getEncryptVersion", "", "()Ljava/lang/Integer;", "getEnterFrom", "getPathPrefix", "getPublicKey", "getRetainNegativeAction", "getServerDomain", "hitFintech", "", "isToResult", "showDialog", "params", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive$CJPayFaceDialogParams;", DyPayConstant.KEY_SHOW_LOADING, "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IExtra {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static String getCertAppId(IExtra r100) {
                return null;
            }

            public static Integer getEncryptVersion(IExtra r100) {
                return null;
            }

            public static String getPathPrefix(IExtra r100) {
                return null;
            }

            public static String getPublicKey(IExtra r100) {
                return null;
            }

            public static String getServerDomain(IExtra r100) {
                return null;
            }

            public static boolean hitFintech(IExtra r100) {
                return false;
            }
        }

        void dismissLoading();

        String getCertAppId();

        Map<String, String> getCertConfig();

        Integer getEncryptVersion();

        String getEnterFrom();

        String getPathPrefix();

        String getPublicKey();

        String getRetainNegativeAction();

        String getServerDomain();

        boolean hitFintech();

        boolean isToResult();

        boolean showDialog(TTCJPayDoFaceLive.CJPayFaceDialogParams r100);

        void showLoading();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void doFace(Activity r100, GetTicketResponse r101, IExtra r102);
}
