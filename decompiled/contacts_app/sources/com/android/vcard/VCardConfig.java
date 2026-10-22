package com.android.vcard;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class VCardConfig {
    public static final String DEFAULT_EXPORT_CHARSET = "UTF-8";
    public static final String DEFAULT_IMPORT_CHARSET = "UTF-8";
    public static final String DEFAULT_INTERMEDIATE_CHARSET = "ISO-8859-1";
    public static final int FLAG_APPEND_TYPE_PARAM = 67108864;
    public static final int FLAG_CONVERT_PHONETIC_NAME_STRINGS = 134217728;
    private static final int FLAG_DOCOMO = 536870912;
    public static final int FLAG_REFRAIN_IMAGE_EXPORT = 8388608;
    public static final int FLAG_REFRAIN_PHONE_NUMBER_FORMATTING = 33554432;
    public static final int FLAG_REFRAIN_QP_TO_NAME_PROPERTIES = 268435456;
    private static final int FLAG_USE_ANDROID_PROPERTY = Integer.MIN_VALUE;
    private static final int FLAG_USE_DEFACT_PROPERTY = 1073741824;
    static final int LOG_LEVEL = 0;
    static final int LOG_LEVEL_NONE = 0;
    static final int LOG_LEVEL_PERFORMANCE_MEASUREMENT = 1;
    static final int LOG_LEVEL_SHOW_WARNING = 2;
    static final int LOG_LEVEL_VERBOSE = 3;
    private static final String LOG_TAG = "vCard";
    public static final int NAME_ORDER_DEFAULT = 0;
    public static final int NAME_ORDER_EUROPE = 4;
    public static final int NAME_ORDER_JAPANESE = 8;
    private static final int NAME_ORDER_MASK = 12;
    public static int VCARD_TYPE_DEFAULT = -1073741824;
    public static final int VCARD_TYPE_DOCOMO = 939524104;
    static final String VCARD_TYPE_DOCOMO_STR = "docomo";
    public static final int VCARD_TYPE_UNKNOWN = 0;
    public static final int VCARD_TYPE_V21_EUROPE = -1073741820;
    static final String VCARD_TYPE_V21_EUROPE_STR = "v21_europe";
    public static final int VCARD_TYPE_V21_GENERIC = -1073741824;
    static String VCARD_TYPE_V21_GENERIC_STR = "v21_generic";
    public static final int VCARD_TYPE_V21_JAPANESE = -1073741816;
    public static final int VCARD_TYPE_V21_JAPANESE_MOBILE = 402653192;
    static final String VCARD_TYPE_V21_JAPANESE_MOBILE_STR = "v21_japanese_mobile";
    static final String VCARD_TYPE_V21_JAPANESE_STR = "v21_japanese_utf8";
    public static final int VCARD_TYPE_V30_EUROPE = -1073741819;
    static final String VCARD_TYPE_V30_EUROPE_STR = "v30_europe";
    public static final int VCARD_TYPE_V30_GENERIC = -1073741823;
    static final String VCARD_TYPE_V30_GENERIC_STR = "v30_generic";
    public static final int VCARD_TYPE_V30_JAPANESE = -1073741815;
    static final String VCARD_TYPE_V30_JAPANESE_STR = "v30_japanese_utf8";
    public static final int VCARD_TYPE_V40_GENERIC = -1073741822;
    static final String VCARD_TYPE_V40_GENERIC_STR = "v40_generic";
    public static final int VERSION_21 = 0;
    public static final int VERSION_30 = 1;
    public static final int VERSION_40 = 2;
    public static final int VERSION_MASK = 3;
    private static final Set<Integer> sJapaneseMobileTypeSet = null;
    private static final Map<String, Integer> sVCardTypeMap = null;

    public static int getNameOrderType(int r0) {
        return r0 & 12;
    }

    public static boolean isDoCoMo(int r1) {
        if ((r1 & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVersion21(int r0) {
        if ((r0 & 3) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVersion30(int r1) {
        if ((r1 & 3) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isVersion40(int r1) {
        if ((r1 & 3) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean needsToConvertPhoneticString(int r1) {
        if ((r1 & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean onlyOneNoteFieldIsAvailable(int r1) {
        if (r1 != 939524104) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean refrainPhoneNumberFormatting(int r1) {
        if ((r1 & FLAG_REFRAIN_PHONE_NUMBER_FORMATTING) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean showPerformanceLog() {
        return false;
    }

    public static boolean usesAndroidSpecificProperty(int r1) {
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean usesDefactProperty(int r1) {
        if ((r1 & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        HashMap r0 = new HashMap();
        sVCardTypeMap = r0;
        r0.put(VCARD_TYPE_V21_GENERIC_STR, Integer.valueOf(VCARD_TYPE_V21_GENERIC));
        r0.put(VCARD_TYPE_V30_GENERIC_STR, Integer.valueOf(VCARD_TYPE_V30_GENERIC));
        r0.put(VCARD_TYPE_V21_EUROPE_STR, Integer.valueOf(VCARD_TYPE_V21_EUROPE));
        r0.put(VCARD_TYPE_V30_EUROPE_STR, Integer.valueOf(VCARD_TYPE_V30_EUROPE));
        Integer r1 = Integer.valueOf(VCARD_TYPE_V21_JAPANESE);
        r0.put(VCARD_TYPE_V21_JAPANESE_STR, r1);
        Integer r2 = Integer.valueOf(VCARD_TYPE_V30_JAPANESE);
        r0.put(VCARD_TYPE_V30_JAPANESE_STR, r2);
        Integer r3 = Integer.valueOf(VCARD_TYPE_V21_JAPANESE_MOBILE);
        r0.put(VCARD_TYPE_V21_JAPANESE_MOBILE_STR, r3);
        Integer r4 = Integer.valueOf(VCARD_TYPE_DOCOMO);
        r0.put(VCARD_TYPE_DOCOMO_STR, r4);
        HashSet r5 = new HashSet();
        sJapaneseMobileTypeSet = r5;
        r5.add(r1);
        r5.add(r2);
        r5.add(r3);
        r5.add(r4);
    }

    public static int getVCardTypeFromString(String r3) {
        String r0 = r3.toLowerCase();
        Map<String, Integer> r1 = sVCardTypeMap;
        if (r1.containsKey(r0) == false) goto L7;
        return r1.get(r0).intValue();
    L7:
        if ("default".equalsIgnoreCase(r3) == true) goto L9;
        Log.e(LOG_TAG, "Unknown vCard type String: \"" + r3 + "\"");
        return VCARD_TYPE_DEFAULT;
    L9:
        return VCARD_TYPE_DEFAULT;
    }

    public static boolean shouldUseQuotedPrintable(int r0) {
        return !isVersion30(r0);
    }

    public static boolean shouldRefrainQPToNameProperties(int r1) {
        if (shouldUseQuotedPrintable(r1) == true) goto L5;
    L8:
        return true;
    L5:
        if ((r1 & 268435456) != 0) goto L8;
        return false;
    }

    public static boolean appendTypeParamName(int r1) {
        if (isVersion30(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 & 67108864) != 0) goto L8;
        return false;
    }

    public static boolean isJapaneseDevice(int r1) {
        return sJapaneseMobileTypeSet.contains(Integer.valueOf(r1));
    }

    private VCardConfig() {
    }
}
