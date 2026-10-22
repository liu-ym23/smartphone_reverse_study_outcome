package com.obric.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.provider.Settings;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: SettingsProviderHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001xB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002082\u0006\u00105\u001a\u000206J\u0016\u00109\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u0016\u0010;\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u0010\u0010<\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u000e\u0010=\u001a\u0002042\u0006\u00105\u001a\u000206J\u0018\u0010>\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0002\u0010:\u001a\u000204J\u000e\u0010?\u001a\u0002042\u0006\u00105\u001a\u000206J\u0016\u0010@\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u0015\u0010A\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u000206¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u0010\u0010D\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u000e\u0010E\u001a\u00020\b2\u0006\u00105\u001a\u000206J\u0010\u0010F\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u0010\u0010G\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u000e\u0010H\u001a\u00020\u00042\u0006\u00105\u001a\u000206J\u0010\u0010I\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\u0016\u0010J\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00042\u0006\u00105\u001a\u000206J\u0016\u0010L\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u000e\u0010M\u001a\u00020\u00042\u0006\u00105\u001a\u000206J\u0016\u0010N\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000204J\u0016\u0010O\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u00020\u0004J\u0016\u0010P\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000204J\u0016\u0010Q\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000204J\u0016\u0010R\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000204J)\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\u00042\n\b\u0002\u0010W\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010XJ\u0016\u0010Y\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010Z\u001a\u000204J\u0016\u0010[\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010\\\u001a\u000208J\u0016\u0010]\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010Z\u001a\u000204J\u0016\u0010^\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010Z\u001a\u000204J\u0016\u0010_\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010`\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010a\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010b\u001a\u00020\bJ\u0016\u0010c\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010Z\u001a\u000204J\u000e\u0010d\u001a\u00020T2\u0006\u00105\u001a\u000206J\u0016\u0010e\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010f\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010g\u001a\u00020\u0004J\u000e\u0010h\u001a\u00020T2\u0006\u00105\u001a\u000206J\u0018\u0010i\u001a\u00020T2\u0006\u00105\u001a\u0002062\b\u0010j\u001a\u0004\u0018\u00010\bJ\u0018\u0010k\u001a\u00020T2\u0006\u00105\u001a\u0002062\b\u0010j\u001a\u0004\u0018\u00010\bJ\u0018\u0010l\u001a\u00020T2\u0006\u00105\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010\bJ\u0018\u0010m\u001a\u00020T2\u0006\u00105\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010\bJ\u0018\u0010n\u001a\u00020T2\u0006\u00105\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010\bJ\u0016\u0010o\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010p\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010q\u001a\u00020\bJ\u0016\u0010r\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010s\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010t\u001a\u00020\u0004J\u0016\u0010u\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010v\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010Z\u001a\u000204J\u0016\u0010w\u001a\u00020T2\u0006\u00105\u001a\u0002062\u0006\u0010V\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/obric/settings/SettingsProviderHelper;", "", "()V", "AUTO_RECORD_TYPE_ALL", "", "AUTO_RECORD_TYPE_CONTACT", "AUTO_RECORD_TYPE_NON_CONTACT", "CALL_FOR_ME_VOICE_FEMALE", "", "CALL_FOR_ME_VOICE_MALE", "CLIPBOARD_READER_ENABLE_DEFAULT", "DEFAULT_VOICE_ID", "INTELLIGENT_ANSWER_TIME_15", "INTELLIGENT_ANSWER_TIME_30", "INTELLIGENT_ANSWER_TIME_5", "INTELLIGENT_ANSWER_TIME_NO", "INTELLIGENT_TYPE_CONTACT", "INTELLIGENT_TYPE_STRANGER", "RECORD_FILE_FORMAT_TYPE_M4A", "RECORD_FILE_FORMAT_TYPE_MP3", "RECORD_FILE_FORMAT_TYPE_WAV", "SETTINGS_NAME_AUTO_INTELLIGENT_CHARACTER_TYPE", "SETTINGS_NAME_AUTO_RECORD_NUMBER_LIMIT", "SETTINGS_NAME_AUTO_RECORD_TYPE", "SETTINGS_NAME_CALL_FOR_ME_VOICE", "SETTINGS_NAME_CLIPBOARD_READER_ENABLE", "SETTINGS_NAME_CONTACTS_DEBUG_LOG_SHOW_ENABLE", "SETTINGS_NAME_CONTACTS_PRIVACY_DIALOG_AGREE", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_ANSWER_TIME", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_ENABLED", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_ENABLED", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_LIST", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPES_ENABLED", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPE_LIST", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_CHECK_ID", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_CUS", "SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_SYS", "SETTINGS_NAME_IS_AUTO_RECORD_ENABLED", "SETTINGS_NAME_PPE_NAME", "SETTINGS_NAME_RECORD_FILE_FORMAT", "SETTINGS_NAME_SEND_INTELLIGENT_NOTIFICATION_ENABLE", "SETTINGS_NAME_SUMMARY_MODEL_TYP", "SETTINGS_NAME_USE_MOBILE_DATA", "SETTINGS_NAME_USE_PPE", "SETTINGS_NAME_VOICE_MODEL_TYPE", "TAG", "USE_MOBILE_DATA_DEFAULT", "USE_MOBILE_DATA_FAIL", "USE_MOBILE_DATA_SUCCESS", "VOICE_MODEL_TYPE_OFFLINE", "VOICE_MODEL_TYPE_ONLINE", "canSendIntelligentNotification", "", "context", "Landroid/content/Context;", "getAutoIntelligentRole", "Lcom/obric/settings/SettingsProviderHelper$CharacterType;", "getAutoRecordNumberLimit", "defValue", "getAutoRecordType", "getCallForMeVoice", "getClipboardReaderEnable", "getContactsLogEnable", "getContactsPrivacyDialogAgree", "getIntelligentAnswerValue", "getIntelligentCallEnableTypes", "(Landroid/content/Context;)Ljava/lang/Integer;", "getIntelligentSceneList", "getIntelligentTypeList", "getIntelligentVoiceCheckId", "getIntelligentVoiceCusList", "getIntelligentVoiceSysList", "getPhoneInterceptTypes", "getPpeName", "getRecordFieFormat", "getSummaryModelType", "getUseMobileData", "getUseMobileDataInt", "getUsePpe", "getVoiceModelType", "isAutoIntelligentEnabled", "isAutoIntelligentSceneEnabled", "isAutoRecordEnabled", "logPhoneInterceptTypesAccess", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "value", "writeResult", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "setAutoIntelligentEnabled", "enabled", "setAutoIntelligentRole", "character", "setAutoIntelligentSceneEnabled", "setAutoRecordEnabled", "setAutoRecordNumberLimit", "setAutoRecordType", "setCallForMeVoice", "voice", "setContactsLogEnable", "setContactsPrivacyDialogAgree", "setIntelligentAnswerValue", "setIntelligentCallEnableTypes", GloableSearchConfig.KEY_CONFIGS, "setIntelligentNotificationShowed", "setIntelligentSceneList", "list", "setIntelligentTypeList", "setIntelligentVoiceCheckId", "setIntelligentVoiceCusList", "setIntelligentVoiceSysList", "setPhoneInterceptTypes", "setPpeName", "name", "setRecordFieFormat", "setSummaryModelType", "type", "setUseMobileData", "setUsePpe", "setVoiceModelType", "CharacterType", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SettingsProviderHelper {
    public static final int AUTO_RECORD_TYPE_ALL = 0;
    public static final int AUTO_RECORD_TYPE_CONTACT = 1;
    public static final int AUTO_RECORD_TYPE_NON_CONTACT = 2;
    public static final String CALL_FOR_ME_VOICE_FEMALE = "zh_female_wenroutaozi_jupiter_bigtts";
    public static final String CALL_FOR_ME_VOICE_MALE = "junyu";
    public static final int CLIPBOARD_READER_ENABLE_DEFAULT = 0;
    public static final String DEFAULT_VOICE_ID = "defaultSound";
    public static final SettingsProviderHelper INSTANCE = null;
    public static final int INTELLIGENT_ANSWER_TIME_15 = 15;
    public static final int INTELLIGENT_ANSWER_TIME_30 = 30;
    public static final int INTELLIGENT_ANSWER_TIME_5 = 5;
    public static final int INTELLIGENT_ANSWER_TIME_NO = 0;
    public static final int INTELLIGENT_TYPE_CONTACT = -1;
    public static final int INTELLIGENT_TYPE_STRANGER = -2;
    public static final int RECORD_FILE_FORMAT_TYPE_M4A = 0;
    public static final int RECORD_FILE_FORMAT_TYPE_MP3 = 1;
    public static final int RECORD_FILE_FORMAT_TYPE_WAV = 2;
    private static final String SETTINGS_NAME_AUTO_INTELLIGENT_CHARACTER_TYPE = "auto_intelligent_character_type";
    private static final String SETTINGS_NAME_AUTO_RECORD_NUMBER_LIMIT = "auto_record_number_limit";
    private static final String SETTINGS_NAME_AUTO_RECORD_TYPE = "auto_record_type";
    private static final String SETTINGS_NAME_CALL_FOR_ME_VOICE = "call_for_me_voice";
    private static final String SETTINGS_NAME_CLIPBOARD_READER_ENABLE = "phoneCanReadClipboard";
    private static final String SETTINGS_NAME_CONTACTS_DEBUG_LOG_SHOW_ENABLE = "contacts_debug_log_show_enable";
    private static final String SETTINGS_NAME_CONTACTS_PRIVACY_DIALOG_AGREE = "contacts_privacy_dialog_agree";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_ANSWER_TIME = "is_auto_intelligent_answer_time";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_ENABLED = "is_auto_intelligent_enabled";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_ENABLED = "is_auto_intelligent_scene_enabled";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_LIST = "is_auto_intelligent_scene_list";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPES_ENABLED = "is_auto_intelligent_types_enabled";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPE_LIST = "is_auto_intelligent_type_list";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_CHECK_ID = "is_auto_intelligent_voice_check_id";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_CUS = "is_auto_intelligent_voice_list_cus";
    private static final String SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_SYS = "is_auto_intelligent_voice_list_sys";
    private static final String SETTINGS_NAME_IS_AUTO_RECORD_ENABLED = "is_auto_record_enabled";
    private static final String SETTINGS_NAME_PPE_NAME = "ppe_name";
    private static final String SETTINGS_NAME_RECORD_FILE_FORMAT = "record_file_format";
    private static final String SETTINGS_NAME_SEND_INTELLIGENT_NOTIFICATION_ENABLE = "send_intelligent_notification_enable";
    private static final String SETTINGS_NAME_SUMMARY_MODEL_TYP = "contacts_summary_model_typ";
    private static final String SETTINGS_NAME_USE_MOBILE_DATA = "contacts_use_mobile_data";
    private static final String SETTINGS_NAME_USE_PPE = "use_ppe";
    private static final String SETTINGS_NAME_VOICE_MODEL_TYPE = "voice_model_type";
    private static final String TAG = "SettingsProviderHelper";
    public static final int USE_MOBILE_DATA_DEFAULT = -1;
    public static final int USE_MOBILE_DATA_FAIL = 0;
    public static final int USE_MOBILE_DATA_SUCCESS = 1;
    public static final int VOICE_MODEL_TYPE_OFFLINE = 1;
    public static final int VOICE_MODEL_TYPE_ONLINE = 0;

    /* JADX INFO: compiled from: SettingsProviderHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/settings/SettingsProviderHelper$CharacterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "HUMAN", "AI", "AUTO", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum CharacterType extends Enum<CharacterType> {
        private static final /* synthetic */ CharacterType[] $VALUES = null;
        public static final CharacterType AI = null;
        public static final CharacterType AUTO = null;
        public static final CharacterType HUMAN = null;
        private final int type;

        private static final /* synthetic */ CharacterType[] $values() {
            return new CharacterType[]{HUMAN, AI, AUTO};
        }

        public static CharacterType valueOf(String r1) {
            return (CharacterType) Enum.valueOf(CharacterType.class, r1);
        }

        public static CharacterType[] values() {
            return (CharacterType[]) $VALUES.clone();
        }

        private CharacterType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }

        public final int getType() {
            return this.type;
        }

        static {
            HUMAN = new CharacterType("HUMAN", 0, 1);
            AI = new CharacterType("AI", 1, 2);
            AUTO = new CharacterType("AUTO", 2, 3);
            $VALUES = $values();
        }
    }

    static {
        INSTANCE = new SettingsProviderHelper();
    }

    private SettingsProviderHelper() {
    }

    public final boolean isAutoRecordEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_RECORD_ENABLED, r2 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setAutoRecordEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_RECORD_ENABLED, r2 ? 1 : 0);
    }

    public final int getAutoRecordType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_AUTO_RECORD_TYPE, r2);
    }

    public final void setAutoRecordType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_AUTO_RECORD_TYPE, r2);
    }

    public final int getAutoRecordNumberLimit(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_AUTO_RECORD_NUMBER_LIMIT, r2);
    }

    public final void setAutoRecordNumberLimit(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_AUTO_RECORD_NUMBER_LIMIT, r2);
    }

    public final int getVoiceModelType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_VOICE_MODEL_TYPE, r2);
    }

    public final void setVoiceModelType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_VOICE_MODEL_TYPE, r2);
    }

    public final int getRecordFieFormat(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_RECORD_FILE_FORMAT, r2);
    }

    public final void setRecordFieFormat(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_RECORD_FILE_FORMAT, r2);
    }

    public final boolean isAutoIntelligentEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_ENABLED, r2 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setAutoIntelligentEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_ENABLED, r2 ? 1 : 0);
    }

    public final int getIntelligentAnswerValue(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_ANSWER_TIME, r2);
    }

    public final void setIntelligentAnswerValue(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_ANSWER_TIME, r2);
    }

    public final String getIntelligentVoiceCheckId(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r0 = Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_CHECK_ID);
        if (r0 != null) goto L6;
        return "defaultSound";
    L6:
        return r0;
    }

    public final void setIntelligentVoiceCheckId(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_CHECK_ID, r2);
    }

    public final String getIntelligentVoiceSysList(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_SYS);
    }

    public final void setIntelligentVoiceSysList(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_SYS, r2);
    }

    public final String getIntelligentVoiceCusList(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_CUS);
    }

    public final void setIntelligentVoiceCusList(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_VOICE_LIST_CUS, r2);
    }

    public final boolean isAutoIntelligentSceneEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_ENABLED, r2 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setAutoIntelligentSceneEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_ENABLED, r2 ? 1 : 0);
    }

    public final String getIntelligentSceneList(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_LIST);
    }

    public final void setIntelligentSceneList(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_SCENE_LIST, r2);
    }

    public final void setUsePpe(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_USE_PPE, r2 ? 1 : 0);
    }

    public final boolean getUsePpe(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_USE_PPE, r2 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setPpeName(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "name");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_PPE_NAME, r2);
    }

    public final String getPpeName(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_PPE_NAME);
    }

    public final void setIntelligentTypeList(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPE_LIST, r2);
    }

    public final String getIntelligentTypeList(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPE_LIST);
    }

    public final void setIntelligentCallEnableTypes(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "setIntelligentCallEnableTypes: types=" + r3);
        Settings.Global.putInt(r2.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPES_ENABLED, r3);
    }

    public final Integer getIntelligentCallEnableTypes(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        SettingsProviderHelper r1 = this;     // Catch: Throwable -> L5
        Object r3 = Result.m803constructorimpl(Integer.valueOf(Settings.Global.getInt(r2.getContentResolver(), SETTINGS_NAME_IS_AUTO_INTELLIGENT_TYPES_ENABLED)));     // Catch: Throwable -> L5
    L8:
        if (Result.m809isFailureimpl(r3) == false) goto L10;
        r3 = null;
    L10:
        Integer r4 = (Integer) r3;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getIntelligentCallEnableTypes: result=" + r4);
        return r4;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean canSendIntelligentNotification(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Global.getInt(r2.getContentResolver(), SETTINGS_NAME_SEND_INTELLIGENT_NOTIFICATION_ENABLE, 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void setIntelligentNotificationShowed(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Settings.Global.putInt(r2.getContentResolver(), SETTINGS_NAME_SEND_INTELLIGENT_NOTIFICATION_ENABLE, 0);
    }

    public final void setContactsLogEnable(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (ContactsUtils.KSA_VERSION == false) goto L5;
        return;
    L5:
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_CONTACTS_DEBUG_LOG_SHOW_ENABLE, r2 ? 1 : 0);
    }

    public static /* synthetic */ boolean getContactsLogEnable$default(SettingsProviderHelper r0, Context r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.getContactsLogEnable(r1, r2);
    }

    public final boolean getContactsLogEnable(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (ContactsUtils.KSA_VERSION == false) goto L6;
        return false;
    L6:
        if (Settings.Global.getInt(r2.getContentResolver(), SETTINGS_NAME_CONTACTS_DEBUG_LOG_SHOW_ENABLE, r3 ? 1 : 0) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setContactsPrivacyDialogAgree(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Settings.Global.putInt(r2.getContentResolver(), "contacts_privacy_dialog_agree", 1);
    }

    public final boolean getContactsPrivacyDialogAgree(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Global.getInt(r2.getContentResolver(), "contacts_privacy_dialog_agree", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void setSummaryModelType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_SUMMARY_MODEL_TYP, r2);
    }

    public final int getSummaryModelType(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        SharedPreferences r0 = PreferenceManager.getDefaultSharedPreferences(r5);
        int r3 = 0;
        if (r0.contains(AIModelSettings.SP_KEY_SUMMARY_MODEL_TYPE) == false) goto L6;
        r3 = r0.getInt(AIModelSettings.SP_KEY_SUMMARY_MODEL_TYPE, 0);
        r0.edit().remove(AIModelSettings.SP_KEY_SUMMARY_MODEL_TYPE).apply();
        setSummaryModelType(r5, r3);
    L6:
        return Settings.Global.getInt(r5.getContentResolver(), SETTINGS_NAME_SUMMARY_MODEL_TYP, r3);
    }

    public final void setUseMobileData(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_USE_MOBILE_DATA, r2);
    }

    public final int getUseMobileDataInt(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Settings.Global.getInt(r2.getContentResolver(), SETTINGS_NAME_USE_MOBILE_DATA, -1);
    }

    public final boolean getUseMobileData(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Settings.Global.getInt(r1.getContentResolver(), SETTINGS_NAME_USE_MOBILE_DATA, r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setCallForMeVoice(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "voice");
        Settings.Global.putString(r1.getContentResolver(), SETTINGS_NAME_CALL_FOR_ME_VOICE, r2);
    }

    public final String getCallForMeVoice(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r0 = Settings.Global.getString(r1.getContentResolver(), SETTINGS_NAME_CALL_FOR_ME_VOICE);
        if (r0 != null) goto L6;
        return CALL_FOR_ME_VOICE_FEMALE;
    L6:
        return r0;
    }

    public final CharacterType getAutoIntelligentRole(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = Settings.Global.getInt(r4.getContentResolver(), SETTINGS_NAME_AUTO_INTELLIGENT_CHARACTER_TYPE, CharacterType.AUTO.getType());
        if (r0 != CharacterType.AI.getType()) goto L6;
        return CharacterType.AI;
    L6:
        if (r0 == CharacterType.AUTO.getType()) goto L11;
        setAutoIntelligentRole(r4, CharacterType.AUTO);
        return CharacterType.AUTO;
    L11:
        return CharacterType.AUTO;
    }

    public final void setAutoIntelligentRole(Context r1, CharacterType r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "character");
        Settings.Global.putInt(r1.getContentResolver(), SETTINGS_NAME_AUTO_INTELLIGENT_CHARACTER_TYPE, r2.getType());
    }

    public final int getPhoneInterceptTypes(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        int r10 = Settings.Global.getInt(r9.getContentResolver(), "SmartCallInterceptClassify", 0);
        logPhoneInterceptTypesAccess$default(this, "getPhoneInterceptTypes", r10, null, 4, null);
        return r10;
    }

    public final void setPhoneInterceptTypes(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        logPhoneInterceptTypesAccess("setPhoneInterceptTypes", r3, Boolean.valueOf(Settings.Global.putInt(r2.getContentResolver(), "SmartCallInterceptClassify", r3)));
    }

    static /* synthetic */ void logPhoneInterceptTypesAccess$default(SettingsProviderHelper r0, String r1, int r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.logPhoneInterceptTypesAccess(r1, r2, r3);
    }

    private final void logPhoneInterceptTypesAccess(String r10, int r11, Boolean r12) {
        String r9 = null;
        if (r12 == null) goto L5;
        String r13 = " writeResult=" + r12.booleanValue();
    L6:
        String r0 = "";
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        StackTraceElement[] r1 = Thread.currentThread().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r1, "currentThread().stackTrace");
        StackTraceElement[] r2 = r1;
        int r3 = r2.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L22;
        StackTraceElement r5 = r2[r4];
        StackTraceElement r6 = r5;
        if (Intrinsics.areEqual(r6.getClassName(), Thread.class.getName()) == false) goto L14;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == true) goto L23;
        r4 = r4 + 1;
    L23:
        StackTraceElement r8 = r5;
        if (r8 == null) goto L26;
        r9 = r8.getClassName() + '.' + r8.getMethodName() + ':' + r8.getLineNumber();
    L26:
        if (r9 == null) goto L29;
        r0 = r9;
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r10 + " key=SmartCallInterceptClassify value=" + r11 + " process=" + Application.getProcessName() + " pid=" + Process.myPid() + r13 + " caller=" + r0);
        return;
    L14:
        if (Intrinsics.areEqual(r6.getClassName(), SettingsProviderHelper.class.getName()) == true) goto L18;
        if (Intrinsics.areEqual(r6.getClassName(), "com.obric.Intelligentcall.IntelligentUtils") == true) goto L18;
        r7 = true;
        goto L19
    L22:
        r5 = null;
        goto L23
    L5:
        r13 = null;
        goto L6
    }

    public final boolean getClipboardReaderEnable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.System.getInt(r2.getContentResolver(), SETTINGS_NAME_CLIPBOARD_READER_ENABLE, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
