package com.google.i18n.phonenumbers;

import com.android.contacts.list.SamContact;
import com.android.contacts.util.HanziToPinyin;
import com.android.ex.editstyledtext.EditStyledText;
import com.android.vcard.VCardConstants;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.obric.appintents.contacts.ContactsCreateIntent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS = null;
    private static final Map<Character, Character> ALPHA_MAPPINGS = null;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS = null;
    private static final Pattern CAPTURING_DIGIT_PATTERN = null;
    private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
    private static final String CC_STRING = "$CC";
    private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
    private static final String DEFAULT_EXTN_PREFIX = ",";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS = null;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN = null;
    static final String EXTN_PATTERNS_FOR_MATCHING = null;
    private static final String EXTN_PATTERNS_FOR_PARSING = null;
    private static final String FG_STRING = "$FG";
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN = null;
    private static final Pattern FIRST_GROUP_PATTERN = null;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES = null;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = null;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS = null;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN = null;
    private static final String NP_STRING = "$NP";
    static final String PLUS_CHARS = "+＋";
    static final Pattern PLUS_CHARS_PATTERN = null;
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN = null;
    private static final Pattern SEPARATOR_PATTERN = null;
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX = null;
    private static final char STAR_SIGN = '*';
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN = null;
    private static final String VALID_ALPHA = null;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = null;
    private static final String VALID_PHONE_NUMBER = null;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN = null;
    static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～";
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN = null;
    private static PhoneNumberUtil instance;
    private static final Logger logger = null;
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final Set<Integer> countryCodesForNonGeographicalRegion;
    private final MatcherApi matcherApi;
    private final MetadataSource metadataSource;
    private final Set<String> nanpaRegions;
    private final RegexCache regexCache;
    private final Set<String> supportedRegions;

    /* JADX INFO: renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = null;

        static {
            int[] r0 = new int[PhoneNumberType.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType = r0;
            r0[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L67:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L51:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L65:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L69:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L55:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L57:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L81:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L47:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L75:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L79:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L17:
            int[] r4 = new int[PhoneNumberFormat.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = r4;
            r4[PhoneNumberFormat.E164.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L71:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L53:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L63:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L22:
            int[] r5 = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = r5;
            r5[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L49:
            $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L73:
            $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L83:
            $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
            return;
        }
    }

    public static abstract enum Leniency extends Enum<Leniency> {
        private static final /* synthetic */ Leniency[] $VALUES = null;
        public static final Leniency EXACT_GROUPING = null;
        public static final Leniency POSSIBLE = null;
        public static final Leniency STRICT_GROUPING = null;
        public static final Leniency VALID = null;

        abstract boolean verify(Phonenumber.PhoneNumber r1, CharSequence r2, PhoneNumberUtil r3);

        private Leniency(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Leniency(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Leniency valueOf(String r1) {
            return (Leniency) Enum.valueOf(Leniency.class, r1);
        }

        public static Leniency[] values() {
            return (Leniency[]) $VALUES.clone();
        }

        static {
            final String r1 = "POSSIBLE";
            final int r2 = 0;
            Leniency r0 = new AnonymousClass1(r1, r2);
            POSSIBLE = r0;
            final String r3 = "VALID";
            final int r4 = 1;
            Leniency r5 = new AnonymousClass2(r3, r4);
            VALID = r5;
            final String r6 = "STRICT_GROUPING";
            final int r7 = 2;
            Leniency r8 = new AnonymousClass3(r6, r7);
            STRICT_GROUPING = r8;
            final String r9 = "EXACT_GROUPING";
            final int r10 = 3;
            Leniency r11 = new AnonymousClass4(r9, r10);
            EXACT_GROUPING = r11;
            $VALUES = new Leniency[]{r0, r5, r8, r11};
        }
    }

    public static final enum MatchType extends Enum<MatchType> {
        private static final /* synthetic */ MatchType[] $VALUES = null;
        public static final MatchType EXACT_MATCH = null;
        public static final MatchType NOT_A_NUMBER = null;
        public static final MatchType NO_MATCH = null;
        public static final MatchType NSN_MATCH = null;
        public static final MatchType SHORT_NSN_MATCH = null;

        private MatchType(String r1, int r2) {
            super(r1, r2);
        }

        public static MatchType valueOf(String r1) {
            return (MatchType) Enum.valueOf(MatchType.class, r1);
        }

        public static MatchType[] values() {
            return (MatchType[]) $VALUES.clone();
        }

        static {
            MatchType r0 = new MatchType("NOT_A_NUMBER", 0);
            NOT_A_NUMBER = r0;
            MatchType r1 = new MatchType("NO_MATCH", 1);
            NO_MATCH = r1;
            MatchType r3 = new MatchType("SHORT_NSN_MATCH", 2);
            SHORT_NSN_MATCH = r3;
            MatchType r5 = new MatchType("NSN_MATCH", 3);
            NSN_MATCH = r5;
            MatchType r7 = new MatchType("EXACT_MATCH", 4);
            EXACT_MATCH = r7;
            $VALUES = new MatchType[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum PhoneNumberFormat extends Enum<PhoneNumberFormat> {
        private static final /* synthetic */ PhoneNumberFormat[] $VALUES = null;
        public static final PhoneNumberFormat E164 = null;
        public static final PhoneNumberFormat INTERNATIONAL = null;
        public static final PhoneNumberFormat NATIONAL = null;
        public static final PhoneNumberFormat RFC3966 = null;

        private PhoneNumberFormat(String r1, int r2) {
            super(r1, r2);
        }

        public static PhoneNumberFormat valueOf(String r1) {
            return (PhoneNumberFormat) Enum.valueOf(PhoneNumberFormat.class, r1);
        }

        public static PhoneNumberFormat[] values() {
            return (PhoneNumberFormat[]) $VALUES.clone();
        }

        static {
            PhoneNumberFormat r0 = new PhoneNumberFormat("E164", 0);
            E164 = r0;
            PhoneNumberFormat r1 = new PhoneNumberFormat("INTERNATIONAL", 1);
            INTERNATIONAL = r1;
            PhoneNumberFormat r3 = new PhoneNumberFormat("NATIONAL", 2);
            NATIONAL = r3;
            PhoneNumberFormat r5 = new PhoneNumberFormat("RFC3966", 3);
            RFC3966 = r5;
            $VALUES = new PhoneNumberFormat[]{r0, r1, r3, r5};
        }
    }

    public static final enum PhoneNumberType extends Enum<PhoneNumberType> {
        private static final /* synthetic */ PhoneNumberType[] $VALUES = null;
        public static final PhoneNumberType FIXED_LINE = null;
        public static final PhoneNumberType FIXED_LINE_OR_MOBILE = null;
        public static final PhoneNumberType MOBILE = null;
        public static final PhoneNumberType PAGER = null;
        public static final PhoneNumberType PERSONAL_NUMBER = null;
        public static final PhoneNumberType PREMIUM_RATE = null;
        public static final PhoneNumberType SHARED_COST = null;
        public static final PhoneNumberType TOLL_FREE = null;
        public static final PhoneNumberType UAN = null;
        public static final PhoneNumberType UNKNOWN = null;
        public static final PhoneNumberType VOICEMAIL = null;
        public static final PhoneNumberType VOIP = null;

        private PhoneNumberType(String r1, int r2) {
            super(r1, r2);
        }

        public static PhoneNumberType valueOf(String r1) {
            return (PhoneNumberType) Enum.valueOf(PhoneNumberType.class, r1);
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[]) $VALUES.clone();
        }

        static {
            PhoneNumberType r0 = new PhoneNumberType("FIXED_LINE", 0);
            FIXED_LINE = r0;
            PhoneNumberType r1 = new PhoneNumberType(ContactsCreateIntent.CREATE_TEL_TYPE_MOBILE, 1);
            MOBILE = r1;
            PhoneNumberType r3 = new PhoneNumberType("FIXED_LINE_OR_MOBILE", 2);
            FIXED_LINE_OR_MOBILE = r3;
            PhoneNumberType r5 = new PhoneNumberType("TOLL_FREE", 3);
            TOLL_FREE = r5;
            PhoneNumberType r7 = new PhoneNumberType("PREMIUM_RATE", 4);
            PREMIUM_RATE = r7;
            PhoneNumberType r9 = new PhoneNumberType("SHARED_COST", 5);
            SHARED_COST = r9;
            PhoneNumberType r11 = new PhoneNumberType("VOIP", 6);
            VOIP = r11;
            PhoneNumberType r13 = new PhoneNumberType("PERSONAL_NUMBER", 7);
            PERSONAL_NUMBER = r13;
            PhoneNumberType r15 = new PhoneNumberType(VCardConstants.PARAM_TYPE_PAGER, 8);
            PAGER = r15;
            PhoneNumberType r14 = new PhoneNumberType("UAN", 9);
            UAN = r14;
            PhoneNumberType r12 = new PhoneNumberType("VOICEMAIL", 10);
            VOICEMAIL = r12;
            PhoneNumberType r10 = new PhoneNumberType("UNKNOWN", 11);
            UNKNOWN = r10;
            $VALUES = new PhoneNumberType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }
    }

    public static final enum ValidationResult extends Enum<ValidationResult> {
        private static final /* synthetic */ ValidationResult[] $VALUES = null;
        public static final ValidationResult INVALID_COUNTRY_CODE = null;
        public static final ValidationResult INVALID_LENGTH = null;
        public static final ValidationResult IS_POSSIBLE = null;
        public static final ValidationResult IS_POSSIBLE_LOCAL_ONLY = null;
        public static final ValidationResult TOO_LONG = null;
        public static final ValidationResult TOO_SHORT = null;

        private ValidationResult(String r1, int r2) {
            super(r1, r2);
        }

        public static ValidationResult valueOf(String r1) {
            return (ValidationResult) Enum.valueOf(ValidationResult.class, r1);
        }

        public static ValidationResult[] values() {
            return (ValidationResult[]) $VALUES.clone();
        }

        static {
            ValidationResult r0 = new ValidationResult("IS_POSSIBLE", 0);
            IS_POSSIBLE = r0;
            ValidationResult r1 = new ValidationResult("IS_POSSIBLE_LOCAL_ONLY", 1);
            IS_POSSIBLE_LOCAL_ONLY = r1;
            ValidationResult r3 = new ValidationResult("INVALID_COUNTRY_CODE", 2);
            INVALID_COUNTRY_CODE = r3;
            ValidationResult r5 = new ValidationResult("TOO_SHORT", 3);
            TOO_SHORT = r5;
            ValidationResult r7 = new ValidationResult("INVALID_LENGTH", 4);
            INVALID_LENGTH = r7;
            ValidationResult r9 = new ValidationResult("TOO_LONG", 5);
            TOO_LONG = r9;
            $VALUES = new ValidationResult[]{r0, r1, r3, r5, r7, r9};
        }
    }

    static {
        logger = Logger.getLogger(PhoneNumberUtil.class.getName());
        HashMap r0 = new HashMap();
        r0.put(52, "1");
        r0.put(54, "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(r0);
        HashSet r1 = new HashSet();
        r1.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(r1);
        HashSet r6 = new HashSet();
        r6.add(52);
        r6.add(54);
        r6.add(55);
        r6.add(62);
        r6.addAll(r1);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(r6);
        HashMap r2 = new HashMap();
        r2.put('0', '0');
        r2.put('1', '1');
        r2.put('2', '2');
        r2.put('3', '3');
        r2.put('4', '4');
        r2.put('5', '5');
        r2.put('6', '6');
        r2.put('7', '7');
        r2.put('8', '8');
        r2.put('9', '9');
        HashMap r10 = new HashMap(40);
        r10.put('A', '2');
        r10.put('B', '2');
        r10.put('C', '2');
        r10.put('D', '3');
        r10.put('E', '3');
        r10.put('F', '3');
        r10.put('G', '4');
        r10.put('H', '4');
        r10.put('I', '4');
        r10.put('J', '5');
        r10.put('K', '5');
        r10.put('L', '5');
        r10.put('M', '6');
        r10.put('N', '6');
        r10.put('O', '6');
        r10.put('P', '7');
        r10.put('Q', '7');
        r10.put('R', '7');
        r10.put('S', '7');
        r10.put('T', '8');
        r10.put('U', '8');
        r10.put('V', '8');
        r10.put('W', '9');
        r10.put('X', '9');
        r10.put('Y', '9');
        r10.put('Z', '9');
        Map<Character, Character> r3 = Collections.unmodifiableMap(r10);
        ALPHA_MAPPINGS = r3;
        HashMap r4 = new HashMap(100);
        r4.putAll(r3);
        r4.putAll(r2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(r4);
        HashMap r5 = new HashMap();
        r5.putAll(r2);
        Character r7 = Character.valueOf(PLUS_SIGN);
        r5.put(r7, r7);
        Character r8 = Character.valueOf(STAR_SIGN);
        r5.put(r8, r8);
        r5.put('#', '#');
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(r5);
        HashMap r9 = new HashMap();
        Iterator<Character> r11 = r3.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        char r12 = r11.next().charValue();
        r9.put(Character.valueOf(Character.toLowerCase(r12)), Character.valueOf(r12));
        r9.put(Character.valueOf(r12), Character.valueOf(r12));
        goto L4
    L6:
        r9.putAll(r2);
        r9.put('-', '-');
        r9.put((char) 65293, '-');
        r9.put((char) 8208, '-');
        r9.put((char) 8209, '-');
        r9.put((char) 8210, '-');
        r9.put(Character.valueOf(Typography.ndash), '-');
        r9.put(Character.valueOf(Typography.mdash), '-');
        r9.put((char) 8213, '-');
        r9.put((char) 8722, '-');
        r9.put('/', '/');
        r9.put((char) 65295, '/');
        r9.put(' ', ' ');
        r9.put((char) 12288, ' ');
        r9.put(Character.valueOf(EditStyledText.ZEROWIDTHCHAR), ' ');
        r9.put('.', '.');
        r9.put((char) 65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(r9);
        SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder r13 = new StringBuilder();
        Map<Character, Character> r14 = ALPHA_MAPPINGS;
        String r15 = r13.append(Arrays.toString(r14.keySet().toArray()).replaceAll("[, \\[\\]]", "")).append(Arrays.toString(r14.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "")).toString();
        VALID_ALPHA = r15;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
        SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
        UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String r16 = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + r15 + "\\p{Nd}]*";
        VALID_PHONE_NUMBER = r16;
        String r17 = createExtnPattern(",;xｘ#＃~～");
        EXTN_PATTERNS_FOR_PARSING = r17;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
        EXTN_PATTERN = Pattern.compile("(?:" + r17 + ")$", 66);
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(r16 + "(?:" + r17 + ")?", 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
        instance = null;
    }

    private static String createExtnPattern(String r2) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[" + r2 + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    PhoneNumberUtil(MetadataSource r6, Map<Integer, List<String>> r7) {
        this.matcherApi = RegexBasedMatcher.create();
        this.nanpaRegions = new HashSet(35);
        this.regexCache = new RegexCache(100);
        this.supportedRegions = new HashSet(320);
        this.countryCodesForNonGeographicalRegion = new HashSet();
        this.metadataSource = r6;
        this.countryCallingCodeToRegionCodeMap = r7;
        Iterator<Map.Entry<Integer, List<String>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<Integer, List<String>> r0 = r8.next();
        List<String> r3 = r0.getValue();
        if (r3.size() != 1) goto L10;
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals(r3.get(0)) == false) goto L10;
        this.countryCodesForNonGeographicalRegion.add(r0.getKey());
    L10:
        this.supportedRegions.addAll(r3);
        goto L4
    L12:
        if (this.supportedRegions.remove(REGION_CODE_FOR_NON_GEO_ENTITY) == false) goto L14;
        logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
    L14:
        this.nanpaRegions.addAll(r7.get(1));
    }

    static CharSequence extractPossibleNumber(CharSequence r3) {
        Matcher r0 = VALID_START_CHAR_PATTERN.matcher(r3);
        if (r0.find() == false) goto L11;
        CharSequence r4 = r3.subSequence(r0.start(), r3.length());
        Matcher r1 = UNWANTED_END_CHAR_PATTERN.matcher(r4);
        if (r1.find() == false) goto L7;
        r4 = r4.subSequence(0, r1.start());
    L7:
        Matcher r2 = SECOND_NUMBER_START_PATTERN.matcher(r4);
        if (r2.find() == true) goto L10;
        return r4;
    L10:
        return r4.subSequence(0, r2.start());
    L11:
        return "";
    }

    static boolean isViablePhoneNumber(CharSequence r2) {
        if (r2.length() >= 2) goto L7;
        return false;
    L7:
        return VALID_PHONE_NUMBER_PATTERN.matcher(r2).matches();
    }

    static StringBuilder normalize(StringBuilder r4) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(r4).matches() == false) goto L5;
        r4.replace(0, r4.length(), normalizeHelper(r4, ALPHA_PHONE_MAPPINGS, true));
    L6:
        return r4;
    L5:
        r4.replace(0, r4.length(), normalizeDigitsOnly(r4));
        goto L6
    }

    public static String normalizeDigitsOnly(CharSequence r1) {
        return normalizeDigits(r1, false).toString();
    }

    static StringBuilder normalizeDigits(CharSequence r5, boolean r6) {
        StringBuilder r0 = new StringBuilder(r5.length());
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L11;
        char r2 = r5.charAt(r1);
        int r3 = Character.digit(r2, 10);
        if (r3 == (-1)) goto L8;
        r0.append(r3);
    L10:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6 == false) goto L10;
        r0.append(r2);
        goto L10
    L11:
        return r0;
    }

    public static String normalizeDiallableCharsOnly(CharSequence r2) {
        return normalizeHelper(r2, DIALLABLE_CHAR_MAPPINGS, true);
    }

    public static String convertAlphaCharactersInNumber(CharSequence r2) {
        return normalizeHelper(r2, ALPHA_PHONE_MAPPINGS, false);
    }

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber r6) {
        Phonemetadata.PhoneMetadata r0 = getMetadataForRegion(getRegionCodeForNumber(r6));
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.hasNationalPrefix() == false) goto L8;
    L10:
        PhoneNumberType r1 = getNumberType(r6);
        int r2 = r6.getCountryCode();
        if (r1 != PhoneNumberType.MOBILE) goto L16;
        if (GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES.contains(Integer.valueOf(r2)) == false) goto L16;
        return 0;
    L16:
        if (isNumberGeographical(r1, r2) == true) goto L19;
        return 0;
    L19:
        return getLengthOfNationalDestinationCode(r6);
    L8:
        if (r6.isItalianLeadingZero() == true) goto L10;
        return 0;
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber r5) {
        if (r5.hasExtension() == false) goto L5;
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();
        r0.mergeFrom(r5);
        r0.clearExtension();
    L6:
        String r1 = format(r0, PhoneNumberFormat.INTERNATIONAL);
        String[] r2 = NON_DIGITS_PATTERN.split(r1);
        if (r2.length > 3) goto L11;
        return 0;
    L11:
        if (getNumberType(r5) != PhoneNumberType.MOBILE) goto L17;
        if (getCountryMobileToken(r5.getCountryCode()).equals("") == true) goto L17;
        return r2[2].length() + r2[3].length();
    L17:
        return r2[2].length();
    L5:
        r0 = r5;
        goto L6
    }

    public static String getCountryMobileToken(int r2) {
        Map<Integer, String> r0 = MOBILE_TOKEN_MAPPINGS;
        if (r0.containsKey(Integer.valueOf(r2)) == true) goto L5;
        return "";
    L5:
        return r0.get(Integer.valueOf(r2));
    }

    private static String normalizeHelper(CharSequence r4, Map<Character, Character> r5, boolean r6) {
        StringBuilder r0 = new StringBuilder(r4.length());
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L12;
        char r2 = r4.charAt(r1);
        Character r3 = r5.get(Character.valueOf(Character.toUpperCase(r2)));
        if (r3 == null) goto L8;
        r0.append(r3);
    L10:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6 == true) goto L10;
        r0.append(r2);
        goto L10
    L12:
        return r0.toString();
    }

    static synchronized void setInstance(PhoneNumberUtil r1) {
        monitor-enter(PhoneNumberUtil.class);
        instance = r1;     // Catch: Throwable -> L7
        monitor-exit(PhoneNumberUtil.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public Set<Integer> getSupportedCallingCodes() {
        return Collections.unmodifiableSet(this.countryCallingCodeToRegionCodeMap.keySet());
    }

    private static boolean descHasPossibleNumberData(Phonemetadata.PhoneNumberDesc r3) {
        if (r3.getPossibleLengthCount() == 1) goto L5;
        return true;
    L5:
        if (r3.getPossibleLength(0) == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean descHasData(Phonemetadata.PhoneNumberDesc r1) {
        if (r1.hasExampleNumber() == false) goto L5;
    L10:
        return true;
    L5:
        if (descHasPossibleNumberData(r1) == true) goto L10;
        if (r1.hasNationalNumberPattern() == true) goto L10;
        return false;
    }

    private Set<PhoneNumberType> getSupportedTypesForMetadata(Phonemetadata.PhoneMetadata r7) {
        TreeSet r0 = new TreeSet();
        PhoneNumberType[] r1 = PhoneNumberType.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L14;
        PhoneNumberType r4 = r1[r3];
        if (r4 == PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L12;
        if (r4 == PhoneNumberType.UNKNOWN) goto L12;
        if (descHasData(getNumberDescByType(r7, r4)) == false) goto L12;
        r0.add(r4);
    L12:
        r3 = r3 + 1;
        goto L3
    L14:
        return Collections.unmodifiableSet(r0);
    }

    public Set<PhoneNumberType> getSupportedTypesForRegion(String r4) {
        if (isValidRegionCode(r4) == true) goto L7;
        logger.log(Level.WARNING, "Invalid or unknown region code provided: " + r4);
        return Collections.unmodifiableSet(new TreeSet());
    L7:
        return getSupportedTypesForMetadata(getMetadataForRegion(r4));
    }

    public Set<PhoneNumberType> getSupportedTypesForNonGeoEntity(int r4) {
        Phonemetadata.PhoneMetadata r0 = getMetadataForNonGeographicalRegion(r4);
        if (r0 != null) goto L7;
        logger.log(Level.WARNING, "Unknown country calling code for a non-geographical entity provided: " + r4);
        return Collections.unmodifiableSet(new TreeSet());
    L7:
        return getSupportedTypesForMetadata(r0);
    }

    public static synchronized PhoneNumberUtil getInstance() {
        monitor-enter(PhoneNumberUtil.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        setInstance(createInstance(MetadataManager.DEFAULT_METADATA_LOADER));     // Catch: Throwable -> L10
    L7:
        PhoneNumberUtil r1 = instance;     // Catch: Throwable -> L10
        monitor-exit(PhoneNumberUtil.class);
        return r1;
    }

    public static PhoneNumberUtil createInstance(MetadataLoader r1) {
        if (r1 == null) goto L6;
        return createInstance(new MultiFileMetadataSourceImpl(r1));
    L6:
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static PhoneNumberUtil createInstance(MetadataSource r2) {
        if (r2 == null) goto L6;
        return new PhoneNumberUtil(r2, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    L6:
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    static boolean formattingRuleHasFirstGroupOnly(String r1) {
        if (r1.length() != 0) goto L5;
    L8:
        return true;
    L5:
        if (FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(r1).matches() == true) goto L8;
        return false;
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber r2) {
        return isNumberGeographical(getNumberType(r2), r2.getCountryCode());
    }

    public boolean isNumberGeographical(PhoneNumberType r1, int r2) {
        if (r1 != PhoneNumberType.FIXED_LINE) goto L5;
    L12:
        return true;
    L5:
        if (r1 == PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L12;
        if (GEO_MOBILE_COUNTRIES.contains(Integer.valueOf(r2)) == true) goto L9;
    L11:
        return false;
    L9:
        if (r1 != PhoneNumberType.MOBILE) goto L11;
        goto L11
    }

    private boolean isValidRegionCode(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.supportedRegions.contains(r1) == false) goto L6;
        return true;
    }

    private boolean hasValidCountryCallingCode(int r1) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(r1));
    }

    public String format(Phonenumber.PhoneNumber r5, PhoneNumberFormat r6) {
        if (r5.getNationalNumber() == 0) goto L5;
    L9:
        StringBuilder r0 = new StringBuilder(20);
        format(r5, r6, r0);
        return r0.toString();
    L5:
        if (r5.hasRawInput() == false) goto L9;
        String r1 = r5.getRawInput();
        if (r1.length() <= 0) goto L9;
        return r1;
    }

    public void format(Phonenumber.PhoneNumber r4, PhoneNumberFormat r5, StringBuilder r6) {
        r6.setLength(0);
        int r0 = r4.getCountryCode();
        String r1 = getNationalSignificantNumber(r4);
        if (r5 != PhoneNumberFormat.E164) goto L7;
        r6.append(r1);
        prefixNumberWithCountryCallingCode(r0, PhoneNumberFormat.E164, r6);
        return;
    L7:
        if (hasValidCountryCallingCode(r0) == true) goto L10;
        r6.append(r1);
        return;
    L10:
        Phonemetadata.PhoneMetadata r2 = getMetadataForRegionOrCallingCode(r0, getRegionCodeForCountryCode(r0));
        r6.append(formatNsn(r1, r2, r5));
        maybeAppendFormattedExtension(r4, r2, r5, r6);
        prefixNumberWithCountryCallingCode(r0, r5, r6);
    }

    public String formatByPattern(Phonenumber.PhoneNumber r8, PhoneNumberFormat r9, List<Phonemetadata.NumberFormat> r10) {
        int r0 = r8.getCountryCode();
        String r1 = getNationalSignificantNumber(r8);
        if (hasValidCountryCallingCode(r0) == true) goto L5;
        return r1;
    L5:
        Phonemetadata.PhoneMetadata r2 = getMetadataForRegionOrCallingCode(r0, getRegionCodeForCountryCode(r0));
        StringBuilder r3 = new StringBuilder(20);
        Phonemetadata.NumberFormat r11 = chooseFormattingPatternForNumber(r10, r1);
        if (r11 != null) goto L8;
        r3.append(r1);
    L15:
        maybeAppendFormattedExtension(r8, r2, r9, r3);
        prefixNumberWithCountryCallingCode(r0, r9, r3);
        return r3.toString();
    L8:
        Phonemetadata.NumberFormat.Builder r4 = Phonemetadata.NumberFormat.newBuilder();
        r4.mergeFrom(r11);
        String r12 = r11.getNationalPrefixFormattingRule();
        if (r12.length() <= 0) goto L14;
        String r5 = r2.getNationalPrefix();
        if (r5.length() <= 0) goto L13;
        r4.setNationalPrefixFormattingRule(r12.replace(NP_STRING, r5).replace(FG_STRING, "$1"));
        goto L14
    L13:
        r4.clearNationalPrefixFormattingRule();
    L14:
        r3.append(formatNsnUsingPattern(r1, r4, r9));
        goto L15
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber r6, CharSequence r7) {
        int r0 = r6.getCountryCode();
        String r1 = getNationalSignificantNumber(r6);
        if (hasValidCountryCallingCode(r0) == true) goto L5;
        return r1;
    L5:
        Phonemetadata.PhoneMetadata r2 = getMetadataForRegionOrCallingCode(r0, getRegionCodeForCountryCode(r0));
        StringBuilder r3 = new StringBuilder(20);
        r3.append(formatNsn(r1, r2, PhoneNumberFormat.NATIONAL, r7));
        maybeAppendFormattedExtension(r6, r2, PhoneNumberFormat.NATIONAL, r3);
        prefixNumberWithCountryCallingCode(r0, PhoneNumberFormat.NATIONAL, r3);
        return r3.toString();
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int r2, String r3) {
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals(r3) == false) goto L6;
        return getMetadataForNonGeographicalRegion(r2);
    L6:
        return getMetadataForRegion(r3);
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber r2, CharSequence r3) {
        if (r2.getPreferredDomesticCarrierCode().length() <= 0) goto L6;
        r3 = r2.getPreferredDomesticCarrierCode();
    L6:
        return formatNationalNumberWithCarrierCode(r2, r3);
    }

    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber r9, String r10, boolean r11) {
        int r0 = r9.getCountryCode();
        String r2 = "";
        if (hasValidCountryCallingCode(r0) == false) goto L5;
        Phonenumber.PhoneNumber r12 = new Phonenumber.PhoneNumber().mergeFrom(r9).clearExtension();
        String r1 = getRegionCodeForCountryCode(r0);
        PhoneNumberType r3 = getNumberType(r12);
        boolean r5 = false;
        if (r3 == PhoneNumberType.UNKNOWN) goto L11;
        boolean r4 = true;
    L13:
        if (r10.equals(r1) == true) goto L15;
        if (r4 == true) goto L59;
    L64:
        if (r11 == false) goto L67;
        return r2;
    L67:
        return normalizeDiallableCharsOnly(r2);
    L59:
        if (canBeInternationallyDialled(r12) == false) goto L64;
        if (r11 == false) goto L63;
        return format(r12, PhoneNumberFormat.INTERNATIONAL);
    L63:
        return format(r12, PhoneNumberFormat.E164);
    L15:
        if (r3 != PhoneNumberType.FIXED_LINE) goto L17;
    L20:
        r5 = true;
    L22:
        if (r1.equals("CO") == false) goto L28;
        if (r3 != PhoneNumberType.FIXED_LINE) goto L28;
        String r8 = formatNationalNumberWithCarrierCode(r12, "3");
    L26:
        r2 = r8;
    L28:
        if (r1.equals("BR") == false) goto L33;
        if (r5 == false) goto L33;
        if (r12.getPreferredDomesticCarrierCode().length() <= 0) goto L64;
        r2 = formatNationalNumberWithPreferredCarrierCode(r12, "");
    L33:
        if (r4 == true) goto L35;
    L37:
        if (r0 != 1) goto L45;
        Phonemetadata.PhoneMetadata r13 = getMetadataForRegion(r10);
        if (canBeInternationallyDialled(r12) == true) goto L41;
    L43:
        r8 = format(r12, PhoneNumberFormat.NATIONAL);
        goto L26
    L41:
        if (testNumberLength(getNationalSignificantNumber(r12), r13) == ValidationResult.TOO_SHORT) goto L43;
        r8 = format(r12, PhoneNumberFormat.INTERNATIONAL);
        goto L26
    L45:
        if (r1.equals(REGION_CODE_FOR_NON_GEO_ENTITY) == true) goto L54;
        if (r1.equals("MX") == false) goto L49;
    L52:
        if (r5 == true) goto L54;
    L56:
        r8 = format(r12, PhoneNumberFormat.NATIONAL);
        goto L26
    L49:
        if (r1.equals("CL") == true) goto L52;
        if (r1.equals("UZ") == false) goto L56;
    L54:
        if (canBeInternationallyDialled(r12) == false) goto L56;
        r8 = format(r12, PhoneNumberFormat.INTERNATIONAL);
        goto L26
    L35:
        if (r1.equals("HU") == false) goto L37;
        r8 = getNddPrefixForRegion(r1, true) + HanziToPinyin.Token.SEPARATOR + format(r12, PhoneNumberFormat.NATIONAL);
        goto L26
    L17:
        if (r3 == PhoneNumberType.MOBILE) goto L20;
        if (r3 != PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L22;
    L11:
        r4 = false;
        goto L13
    L5:
        if (r9.hasRawInput() == true) goto L7;
        return "";
    L7:
        return r9.getRawInput();
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber r6, String r7) {
        if (isValidRegionCode(r7) == true) goto L6;
        logger.log(Level.WARNING, "Trying to format number from invalid region " + r7 + ". International formatting applied.");
        return format(r6, PhoneNumberFormat.INTERNATIONAL);
    L6:
        int r0 = r6.getCountryCode();
        String r1 = getNationalSignificantNumber(r6);
        if (hasValidCountryCallingCode(r0) == true) goto L10;
        return r1;
    L10:
        if (r0 != 1) goto L16;
        if (isNANPACountry(r7) == true) goto L14;
    L19:
        Phonemetadata.PhoneMetadata r8 = getMetadataForRegion(r7);
        String r2 = r8.getInternationalPrefix();
        if (SINGLE_INTERNATIONAL_PREFIX.matcher(r2).matches() == false) goto L23;
    L26:
        Phonemetadata.PhoneMetadata r9 = getMetadataForRegionOrCallingCode(r0, getRegionCodeForCountryCode(r0));
        StringBuilder r4 = new StringBuilder(formatNsn(r1, r9, PhoneNumberFormat.INTERNATIONAL));
        maybeAppendFormattedExtension(r6, r9, PhoneNumberFormat.INTERNATIONAL, r4);
        if (r2.length() <= 0) goto L29;
        r4.insert(0, HanziToPinyin.Token.SEPARATOR).insert(0, r0).insert(0, HanziToPinyin.Token.SEPARATOR).insert(0, r2);
    L31:
        return r4.toString();
    L29:
        prefixNumberWithCountryCallingCode(r0, PhoneNumberFormat.INTERNATIONAL, r4);
        goto L31
    L23:
        if (r8.hasPreferredInternationalPrefix() == false) goto L25;
        r2 = r8.getPreferredInternationalPrefix();
        goto L26
    L25:
        r2 = "";
        goto L26
    L14:
        return r0 + HanziToPinyin.Token.SEPARATOR + format(r6, PhoneNumberFormat.NATIONAL);
    L16:
        if (r0 != getCountryCodeForValidRegion(r7)) goto L19;
        return format(r6, PhoneNumberFormat.NATIONAL);
    }

    public String formatInOriginalFormat(Phonenumber.PhoneNumber r6, String r7) {
        if (r6.hasRawInput() == false) goto L9;
        if (hasFormattingPatternForNumber(r6) == true) goto L9;
        return r6.getRawInput();
    L9:
        if (r6.hasCountryCodeSource() == false) goto L11;
        int r0 = AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[r6.getCountryCodeSource().ordinal()];
        if (r0 != 1) goto L15;
        String r2 = format(r6, PhoneNumberFormat.INTERNATIONAL);
    L39:
        String r5 = r6.getRawInput();
        if (r2 != null) goto L42;
        return r2;
    L42:
        if (r5.length() > 0) goto L44;
        return r2;
    L44:
        if (normalizeDiallableCharsOnly(r2).equals(normalizeDiallableCharsOnly(r5)) == false) goto L46;
        return r2;
    L46:
        return r5;
    L15:
        if (r0 != 2) goto L17;
        r2 = formatOutOfCountryCallingNumber(r6, r7);
        goto L39
    L17:
        if (r0 == 3) goto L36;
        String r8 = getRegionCodeForCountryCode(r6.getCountryCode());
        String r1 = getNddPrefixForRegion(r8, true);
        r2 = format(r6, PhoneNumberFormat.NATIONAL);
        if (r1 == null) goto L39;
        if (r1.length() == 0) goto L39;
        if (rawInputContainsNationalPrefix(r6.getRawInput(), r1, r8) == true) goto L39;
        Phonemetadata.PhoneMetadata r9 = getMetadataForRegion(r8);
        String r3 = getNationalSignificantNumber(r6);
        Phonemetadata.NumberFormat r10 = chooseFormattingPatternForNumber(r9.numberFormats(), r3);
        if (r10 == null) goto L39;
        String r4 = r10.getNationalPrefixFormattingRule();
        int r11 = r4.indexOf("$1");
        if (r11 <= 0) goto L39;
        if (normalizeDigitsOnly(r4.substring(0, r11)).length() == 0) goto L39;
        Phonemetadata.NumberFormat.Builder r12 = Phonemetadata.NumberFormat.newBuilder();
        r12.mergeFrom(r10);
        r12.clearNationalPrefixFormattingRule();
        List<Phonemetadata.NumberFormat> r13 = new ArrayList(1);
        r13.add(r12);
        r2 = formatByPattern(r6, PhoneNumberFormat.NATIONAL, r13);
        goto L39
    L36:
        r2 = format(r6, PhoneNumberFormat.INTERNATIONAL).substring(1);
        goto L39
    L11:
        return format(r6, PhoneNumberFormat.NATIONAL);
    }

    private boolean rawInputContainsNationalPrefix(String r3, String r4, String r5) {
        String r6 = normalizeDigitsOnly(r3);
        if (r6.startsWith(r4) == true) goto L8;
    L6:
        return false;
    L8:
        return isValidNumber(parse(r6.substring(r4.length()), r5));
    }

    private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber r3) {
        int r0 = r3.getCountryCode();
        Phonemetadata.PhoneMetadata r1 = getMetadataForRegionOrCallingCode(r0, getRegionCodeForCountryCode(r0));
        if (r1 != null) goto L5;
        return false;
    L5:
        String r4 = getNationalSignificantNumber(r3);
        if (chooseFormattingPatternForNumber(r1.numberFormats(), r4) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber r8, String r9) {
        String r0 = r8.getRawInput();
        if (r0.length() == 0) goto L5;
        int r1 = r8.getCountryCode();
        if (hasValidCountryCallingCode(r1) == true) goto L9;
        return r0;
    L9:
        String r2 = normalizeHelper(r0, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String r3 = getNationalSignificantNumber(r8);
        if (r3.length() <= 3) goto L14;
        int r4 = r2.indexOf(r3.substring(0, 3));
        if (r4 == (-1)) goto L14;
        r2 = r2.substring(r4);
    L14:
        Phonemetadata.PhoneMetadata r5 = getMetadataForRegion(r9);
        if (r1 == 1) goto L17;
        if (r5 != null) goto L22;
    L28:
        if (r5 == null) goto L33;
        String r6 = r5.getInternationalPrefix();
        if (SINGLE_INTERNATIONAL_PREFIX.matcher(r6).matches() == true) goto L34;
        r6 = r5.getPreferredInternationalPrefix();
    L34:
        StringBuilder r7 = new StringBuilder(r2);
        maybeAppendFormattedExtension(r8, getMetadataForRegionOrCallingCode(r1, getRegionCodeForCountryCode(r1)), PhoneNumberFormat.INTERNATIONAL, r7);
        if (r6.length() <= 0) goto L38;
        r7.insert(0, HanziToPinyin.Token.SEPARATOR).insert(0, r1).insert(0, HanziToPinyin.Token.SEPARATOR).insert(0, r6);
    L42:
        return r7.toString();
    L38:
        if (isValidRegionCode(r9) == true) goto L40;
        logger.log(Level.WARNING, "Trying to format number from invalid region " + r9 + ". International formatting applied.");
    L40:
        prefixNumberWithCountryCallingCode(r1, PhoneNumberFormat.INTERNATIONAL, r7);
        goto L42
    L33:
        r6 = "";
        goto L34
    L22:
        if (r1 != getCountryCodeForValidRegion(r9)) goto L28;
        Phonemetadata.NumberFormat r10 = chooseFormattingPatternForNumber(r5.numberFormats(), r3);
        if (r10 != null) goto L26;
        return r2;
    L26:
        Phonemetadata.NumberFormat.Builder r11 = Phonemetadata.NumberFormat.newBuilder();
        r11.mergeFrom(r10);
        r11.setPattern("(\\d+)(.*)");
        r11.setFormat("$1$2");
        return formatNsnUsingPattern(r2, r11, PhoneNumberFormat.NATIONAL);
    L17:
        if (isNANPACountry(r9) == false) goto L28;
        return r1 + HanziToPinyin.Token.SEPARATOR + r2;
    L5:
        return formatOutOfCountryCallingNumber(r8, r9);
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber r3) {
        StringBuilder r2 = new StringBuilder();
        if (r3.isItalianLeadingZero() == true) goto L5;
    L7:
        r2.append(r3.getNationalNumber());
        return r2.toString();
    L5:
        if (r3.getNumberOfLeadingZeros() <= 0) goto L7;
        char[] r0 = new char[r3.getNumberOfLeadingZeros()];
        Arrays.fill(r0, '0');
        r2.append(new String(r0));
        goto L7
    }

    private void prefixNumberWithCountryCallingCode(int r3, PhoneNumberFormat r4, StringBuilder r5) {
        int r2 = AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[r4.ordinal()];
        if (r2 != 1) goto L5;
        r5.insert(0, r3).insert(0, PLUS_SIGN);
        return;
    L5:
        if (r2 != 2) goto L7;
        r5.insert(0, HanziToPinyin.Token.SEPARATOR).insert(0, r3).insert(0, PLUS_SIGN);
        return;
    L7:
        if (r2 == 3) goto L9;
        return;
    L9:
        r5.insert(0, "-").insert(0, r3).insert(0, PLUS_SIGN).insert(0, RFC3966_PREFIX);
    }

    private String formatNsn(String r2, Phonemetadata.PhoneMetadata r3, PhoneNumberFormat r4) {
        return formatNsn(r2, r3, r4, null);
    }

    private String formatNsn(String r2, Phonemetadata.PhoneMetadata r3, PhoneNumberFormat r4, CharSequence r5) {
        if (r3.intlNumberFormats().size() != 0) goto L5;
    L8:
        List<Phonemetadata.NumberFormat> r6 = r3.numberFormats();
    L9:
        Phonemetadata.NumberFormat r7 = chooseFormattingPatternForNumber(r6, r2);
        if (r7 != null) goto L13;
        return r2;
    L13:
        return formatNsnUsingPattern(r2, r7, r4, r5);
    L5:
        if (r4 == PhoneNumberFormat.NATIONAL) goto L8;
        r6 = r3.intlNumberFormats();
        goto L9
    }

    Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> r4, String r5) {
        Iterator<Phonemetadata.NumberFormat> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Phonemetadata.NumberFormat r0 = r6.next();
        int r1 = r0.leadingDigitsPatternSize();
        if (r1 == 0) goto L10;
        if (this.regexCache.getPatternForRegex(r0.getLeadingDigitsPattern(r1 - 1)).matcher(r5).lookingAt() == false) goto L4;
    L10:
        if (this.regexCache.getPatternForRegex(r0.getPattern()).matcher(r5).matches() == false) goto L4;
        return r0;
    L12:
        return null;
    }

    String formatNsnUsingPattern(String r2, Phonemetadata.NumberFormat r3, PhoneNumberFormat r4) {
        return formatNsnUsingPattern(r2, r3, r4, null);
    }

    private String formatNsnUsingPattern(String r3, Phonemetadata.NumberFormat r4, PhoneNumberFormat r5, CharSequence r6) {
        String r0 = r4.getFormat();
        Matcher r2 = this.regexCache.getPatternForRegex(r4.getPattern()).matcher(r3);
        if (r5 != PhoneNumberFormat.NATIONAL) goto L10;
        if (r6 == null) goto L10;
        if (r6.length() <= 0) goto L10;
        if (r4.getDomesticCarrierCodeFormattingRule().length() <= 0) goto L10;
        String r7 = r4.getDomesticCarrierCodeFormattingRule().replace(CC_STRING, r6);
        String r8 = r2.replaceAll(FIRST_GROUP_PATTERN.matcher(r0).replaceFirst(r7));
    L18:
        if (r5 != PhoneNumberFormat.RFC3966) goto L24;
        Matcher r9 = SEPARATOR_PATTERN.matcher(r8);
        if (r9.lookingAt() == false) goto L23;
        r8 = r9.replaceFirst("");
    L23:
        return r9.reset(r8).replaceAll("-");
    L24:
        return r8;
    L10:
        String r10 = r4.getNationalPrefixFormattingRule();
        if (r5 != PhoneNumberFormat.NATIONAL) goto L16;
        if (r10 == null) goto L16;
        if (r10.length() <= 0) goto L16;
        r8 = r2.replaceAll(FIRST_GROUP_PATTERN.matcher(r0).replaceFirst(r10));
    L16:
        r8 = r2.replaceAll(r0);
        goto L18
    }

    public Phonenumber.PhoneNumber getExampleNumber(String r2) {
        return getExampleNumberForType(r2, PhoneNumberType.FIXED_LINE);
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "to" is null
        	at jadx.core.dex.visitors.blocks.BlockSplitter.connect(BlockSplitter.java:159)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectSplittersAndHandlers(BlockExceptionHandler.java:501)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:382)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:91)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:62)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:422)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    public com.google.i18n.phonenumbers.Phonenumber.PhoneNumber getInvalidExampleNumber(java.lang.String r6) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPos()" because "block" is null
            	at jadx.core.utils.blocks.BlockSet.addChecked(BlockSet.java:69)
            	at jadx.core.utils.blocks.DFSIteration.next(DFSIteration.java:35)
            	at jadx.core.utils.BlockUtils.visitDFS(BlockUtils.java:627)
            	at jadx.core.utils.BlockUtils.visitDFS(BlockUtils.java:616)
            	at jadx.core.codegen.SimpleModeHelper.getSortedBlocks(SimpleModeHelper.java:148)
            	at jadx.core.codegen.SimpleModeHelper.prepareBlocks(SimpleModeHelper.java:38)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:327)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r5 = this;
            boolean r0 = r5.isValidRegionCode(r6)
            r1 = 0
            if (r0 != 0) goto L1e
            java.util.logging.Logger r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.logger
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid or unknown region code provided: "
            r2.<init>(r3)
            java.lang.StringBuilder r6 = r2.append(r6)
            java.lang.String r6 = r6.toString()
            r5.log(r0, r6)
            return r1
        L1e:
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r0 = r5.getMetadataForRegion(r6)
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r0 = r5.getNumberDescByType(r0, r2)
            boolean r2 = r0.hasExampleNumber()
            if (r2 != 0) goto L2f
            return r1
        L2f:
            java.lang.String r0 = r0.getExampleNumber()
            int r2 = r0.length()
            int r2 = r2 + (-1)
        L39:
            r3 = 2
            if (r2 < r3) goto L4f
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r2)
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r3 = r5.parse(r3, r6)     // Catch: com.google.i18n.phonenumbers.NumberParseException -> L4c
            boolean r4 = r5.isValidNumber(r3)     // Catch: com.google.i18n.phonenumbers.NumberParseException -> L4c
            if (r4 != 0) goto L4c
            return r3
        L4c:
            int r2 = r2 + (-1)
            goto L39
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.getInvalidExampleNumber(java.lang.String):com.google.i18n.phonenumbers.Phonenumber$PhoneNumber");
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String r4, PhoneNumberType r5) {
        if (isValidRegionCode(r4) == true) goto L6;
        logger.log(Level.WARNING, "Invalid or unknown region code provided: " + r4);
        return null;
    L6:
        Phonemetadata.PhoneNumberDesc r6 = getNumberDescByType(getMetadataForRegion(r4), r5);
    L11:
        e = move-exception;
        logger.log(Level.SEVERE, e.toString());
    L13:
        return null;
    L8:
        if (r6.hasExampleNumber() == false) goto L13;
        return parse(r6.getExampleNumber(), r4);
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType r6) {
        Iterator<String> r0 = getSupportedRegions().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Phonenumber.PhoneNumber r1 = getExampleNumberForType(r0.next(), r6);
        if (r1 == null) goto L4;
        return r1;
    L8:
        Iterator<Integer> r2 = getSupportedGlobalNetworkCallingCodes().iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        int r3 = r2.next().intValue();
        Phonemetadata.PhoneNumberDesc r4 = this.getNumberDescByType(this.getMetadataForNonGeographicalRegion(r3), r6);
    L16:
        e = move-exception;
        logger.log(Level.SEVERE, e.toString());
        goto L10
    L13:
        if (r4.hasExampleNumber() == false) goto L10;
        return this.parse("+" + r3 + r4.getExampleNumber(), UNKNOWN_REGION);
    L18:
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int r5) {
        Phonemetadata.PhoneMetadata r0 = getMetadataForNonGeographicalRegion(r5);
        if (r0 == null) goto L15;
        Iterator r1 = Arrays.asList(new Phonemetadata.PhoneNumberDesc[]{r0.getMobile(), r0.getTollFree(), r0.getSharedCost(), r0.getVoip(), r0.getVoicemail(), r0.getUan(), r0.getPremiumRate()}).iterator();
    L6:
        if (r1.hasNext() == false) goto L27;
        Phonemetadata.PhoneNumberDesc r2 = (Phonemetadata.PhoneNumberDesc) r1.next();
        if (r2 == null) goto L6;
    L13:
        e = move-exception;
        logger.log(Level.SEVERE, e.toString());
        goto L6
    L10:
        if (r2.hasExampleNumber() == false) goto L6;
        return this.parse("+" + r5 + r2.getExampleNumber(), UNKNOWN_REGION);
    L27:
        return null;
    L15:
        logger.log(Level.WARNING, "Invalid or unknown country calling code provided: " + r5);
        return null;
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber r1, Phonemetadata.PhoneMetadata r2, PhoneNumberFormat r3, StringBuilder r4) {
        if (r1.hasExtension() == true) goto L5;
        return;
    L5:
        if (r1.getExtension().length() > 0) goto L7;
        return;
    L7:
        if (r3 != PhoneNumberFormat.RFC3966) goto L10;
        r4.append(RFC3966_EXTN_PREFIX).append(r1.getExtension());
        return;
    L10:
        if (r2.hasPreferredExtnPrefix() == false) goto L12;
        r4.append(r2.getPreferredExtnPrefix()).append(r1.getExtension());
        return;
    L12:
        r4.append(",").append(r1.getExtension());
    }

    Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata r1, PhoneNumberType r2) {
        switch(AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[r2.ordinal()]) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L5;
        };
    L5:
        return r1.getGeneralDesc();
    L7:
        return r1.getVoicemail();
    L9:
        return r1.getUan();
    L11:
        return r1.getPager();
    L13:
        return r1.getPersonalNumber();
    L15:
        return r1.getVoip();
    L17:
        return r1.getSharedCost();
    L19:
        return r1.getFixedLine();
    L21:
        return r1.getMobile();
    L23:
        return r1.getTollFree();
    L25:
        return r1.getPremiumRate();
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber r3) {
        String r0 = getRegionCodeForNumber(r3);
        Phonemetadata.PhoneMetadata r1 = getMetadataForRegionOrCallingCode(r3.getCountryCode(), r0);
        if (r1 != null) goto L7;
        return PhoneNumberType.UNKNOWN;
    L7:
        return getNumberTypeHelper(getNationalSignificantNumber(r3), r1);
    }

    private PhoneNumberType getNumberTypeHelper(String r2, Phonemetadata.PhoneMetadata r3) {
        if (isNumberMatchingDesc(r2, r3.getGeneralDesc()) == true) goto L7;
        return PhoneNumberType.UNKNOWN;
    L7:
        if (isNumberMatchingDesc(r2, r3.getPremiumRate()) == false) goto L11;
        return PhoneNumberType.PREMIUM_RATE;
    L11:
        if (isNumberMatchingDesc(r2, r3.getTollFree()) == false) goto L15;
        return PhoneNumberType.TOLL_FREE;
    L15:
        if (isNumberMatchingDesc(r2, r3.getSharedCost()) == false) goto L19;
        return PhoneNumberType.SHARED_COST;
    L19:
        if (isNumberMatchingDesc(r2, r3.getVoip()) == false) goto L23;
        return PhoneNumberType.VOIP;
    L23:
        if (isNumberMatchingDesc(r2, r3.getPersonalNumber()) == false) goto L27;
        return PhoneNumberType.PERSONAL_NUMBER;
    L27:
        if (isNumberMatchingDesc(r2, r3.getPager()) == false) goto L31;
        return PhoneNumberType.PAGER;
    L31:
        if (isNumberMatchingDesc(r2, r3.getUan()) == false) goto L35;
        return PhoneNumberType.UAN;
    L35:
        if (isNumberMatchingDesc(r2, r3.getVoicemail()) == false) goto L39;
        return PhoneNumberType.VOICEMAIL;
    L39:
        if (isNumberMatchingDesc(r2, r3.getFixedLine()) == false) goto L51;
        if (r3.getSameMobileAndFixedLinePattern() == false) goto L45;
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
    L45:
        if (isNumberMatchingDesc(r2, r3.getMobile()) == false) goto L49;
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
    L49:
        return PhoneNumberType.FIXED_LINE;
    L51:
        if (r3.getSameMobileAndFixedLinePattern() == true) goto L57;
        if (isNumberMatchingDesc(r2, r3.getMobile()) == false) goto L57;
        return PhoneNumberType.MOBILE;
    L57:
        return PhoneNumberType.UNKNOWN;
    }

    Phonemetadata.PhoneMetadata getMetadataForRegion(String r2) {
        if (isValidRegionCode(r2) == true) goto L7;
        return null;
    L7:
        return this.metadataSource.getMetadataForRegion(r2);
    }

    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r3) {
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(r3)) == true) goto L7;
        return null;
    L7:
        return this.metadataSource.getMetadataForNonGeographicalRegion(r3);
    }

    boolean isNumberMatchingDesc(String r5, Phonemetadata.PhoneNumberDesc r6) {
        int r0 = r5.length();
        List<Integer> r1 = r6.getPossibleLengthList();
        if (r1.size() <= 0) goto L8;
        if (r1.contains(Integer.valueOf(r0)) == true) goto L8;
        return false;
    L8:
        return this.matcherApi.matchNationalNumber(r5, r6, false);
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber r2) {
        return isValidNumberForRegion(r2, getRegionCodeForNumber(r2));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber r5, String r6) {
        int r0 = r5.getCountryCode();
        Phonemetadata.PhoneMetadata r1 = getMetadataForRegionOrCallingCode(r0, r6);
        if (r1 != null) goto L5;
        return false;
    L5:
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals(r6) == true) goto L10;
        if (r0 == getCountryCodeForValidRegion(r6)) goto L10;
        return false;
    L10:
        if (getNumberTypeHelper(getNationalSignificantNumber(r5), r1) == PhoneNumberType.UNKNOWN) goto L14;
        return true;
    L14:
        return false;
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber r4) {
        int r0 = r4.getCountryCode();
        List<String> r1 = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(r0));
        if (r1 != null) goto L7;
        logger.log(Level.INFO, "Missing/invalid country_code (" + r0 + ")");
        return null;
    L7:
        if (r1.size() != 1) goto L11;
        return r1.get(0);
    L11:
        return getRegionCodeForNumberFromRegionList(r4, r1);
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber r4, List<String> r5) {
        String r6 = getNationalSignificantNumber(r4);
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        String r0 = r7.next();
        Phonemetadata.PhoneMetadata r1 = getMetadataForRegion(r0);
        if (r1.hasLeadingDigits() == true) goto L8;
        if (getNumberTypeHelper(r6, r1) == PhoneNumberType.UNKNOWN) goto L4;
        return r0;
    L8:
        if (this.regexCache.getPatternForRegex(r1.getLeadingDigits()).matcher(r6).lookingAt() == false) goto L4;
        return r0;
    L13:
        return null;
    }

    public String getRegionCodeForCountryCode(int r1) {
        List<String> r0 = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(r1));
        if (r0 != null) goto L6;
        return UNKNOWN_REGION;
    L6:
        return r0.get(0);
    }

    public List<String> getRegionCodesForCountryCode(int r1) {
        List<String> r0 = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(r1));
        if (r0 != null) goto L6;
        r0 = new ArrayList(0);
    L6:
        return Collections.unmodifiableList(r0);
    }

    public int getCountryCodeForRegion(String r4) {
        if (isValidRegionCode(r4) == true) goto L10;
        Logger r3 = logger;
        Level r0 = Level.WARNING;
        StringBuilder r1 = new StringBuilder("Invalid or missing region code (");
        if (r4 != null) goto L7;
        r4 = "null";
    L7:
        r3.log(r0, r1.append(r4).append(") provided.").toString());
        return 0;
    L10:
        return getCountryCodeForValidRegion(r4);
    }

    private int getCountryCodeForValidRegion(String r3) {
        Phonemetadata.PhoneMetadata r2 = getMetadataForRegion(r3);
        if (r2 == null) goto L7;
        return r2.getCountryCode();
    L7:
        throw new IllegalArgumentException("Invalid region code: " + r3);
    }

    public String getNddPrefixForRegion(String r4, boolean r5) {
        Phonemetadata.PhoneMetadata r3 = getMetadataForRegion(r4);
        if (r3 != null) goto L9;
        Logger r6 = logger;
        Level r7 = Level.WARNING;
        StringBuilder r1 = new StringBuilder("Invalid or missing region code (");
        if (r4 != null) goto L7;
        r4 = "null";
    L7:
        r6.log(r7, r1.append(r4).append(") provided.").toString());
        return null;
    L9:
        String r8 = r3.getNationalPrefix();
        if (r8.length() != 0) goto L12;
        return null;
    L12:
        if (r5 == true) goto L14;
        return r8;
    L14:
        return r8.replace(SamContact.HEADER_SPECIAL_SECTION, "");
    }

    public boolean isNANPACountry(String r1) {
        return this.nanpaRegions.contains(r1);
    }

    public boolean isAlphaNumber(CharSequence r2) {
        if (isViablePhoneNumber(r2) == true) goto L6;
        return false;
    L6:
        StringBuilder r0 = new StringBuilder(r2);
        maybeStripExtension(r0);
        return VALID_ALPHA_PHONE_PATTERN.matcher(r0).matches();
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber r1) {
        ValidationResult r0 = isPossibleNumberWithReason(r1);
        if (r0 != ValidationResult.IS_POSSIBLE) goto L5;
    L8:
        return true;
    L5:
        if (r0 == ValidationResult.IS_POSSIBLE_LOCAL_ONLY) goto L8;
        return false;
    }

    public boolean isPossibleNumberForType(Phonenumber.PhoneNumber r1, PhoneNumberType r2) {
        ValidationResult r0 = isPossibleNumberForTypeWithReason(r1, r2);
        if (r0 != ValidationResult.IS_POSSIBLE) goto L5;
    L8:
        return true;
    L5:
        if (r0 == ValidationResult.IS_POSSIBLE_LOCAL_ONLY) goto L8;
        return false;
    }

    private ValidationResult testNumberLength(CharSequence r2, Phonemetadata.PhoneMetadata r3) {
        return testNumberLength(r2, r3, PhoneNumberType.UNKNOWN);
    }

    private ValidationResult testNumberLength(CharSequence r4, Phonemetadata.PhoneMetadata r5, PhoneNumberType r6) {
        Phonemetadata.PhoneNumberDesc r0 = getNumberDescByType(r5, r6);
        if (r0.getPossibleLengthList().isEmpty() == false) goto L5;
        List<Integer> r1 = r5.getGeneralDesc().getPossibleLengthList();
    L6:
        List<Integer> r2 = r0.getPossibleLengthLocalOnlyList();
        if (r6 != PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L24;
        if (descHasPossibleNumberData(getNumberDescByType(r5, PhoneNumberType.FIXED_LINE)) == false) goto L11;
        Phonemetadata.PhoneNumberDesc r3 = getNumberDescByType(r5, PhoneNumberType.MOBILE);
        if (descHasPossibleNumberData(r3) == false) goto L24;
        ArrayList r7 = new ArrayList(r1);
        if (r3.getPossibleLengthList().size() != 0) goto L17;
        List<Integer> r8 = r5.getGeneralDesc().getPossibleLengthList();
    L18:
        r7.addAll(r8);
        Collections.sort(r7);
        if (r2.isEmpty() == false) goto L21;
        r2 = r3.getPossibleLengthLocalOnlyList();
    L22:
        r1 = r7;
        goto L24
    L21:
        ArrayList r9 = new ArrayList(r2);
        r9.addAll(r3.getPossibleLengthLocalOnlyList());
        Collections.sort(r9);
        r2 = r9;
        goto L22
    L17:
        r8 = r3.getPossibleLengthList();
        goto L18
    L11:
        return testNumberLength(r4, r5, PhoneNumberType.MOBILE);
    L24:
        if (r1.get(0).intValue() == (-1)) goto L26;
        int r10 = r4.length();
        if (r2.contains(Integer.valueOf(r10)) == true) goto L30;
        int r11 = r1.get(0).intValue();
        if (r11 == r10) goto L34;
        if (r11 <= r10) goto L39;
        return ValidationResult.TOO_SHORT;
    L39:
        if (r1.get(r1.size() - 1).intValue() >= r10) goto L43;
        return ValidationResult.TOO_LONG;
    L43:
        if (r1.subList(1, r1.size()).contains(Integer.valueOf(r10)) == false) goto L46;
        return ValidationResult.IS_POSSIBLE;
    L46:
        return ValidationResult.INVALID_LENGTH;
    L34:
        return ValidationResult.IS_POSSIBLE;
    L30:
        return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    L26:
        return ValidationResult.INVALID_LENGTH;
    L5:
        r1 = r0.getPossibleLengthList();
        goto L6
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber r2) {
        return isPossibleNumberForTypeWithReason(r2, PhoneNumberType.UNKNOWN);
    }

    public ValidationResult isPossibleNumberForTypeWithReason(Phonenumber.PhoneNumber r3, PhoneNumberType r4) {
        String r0 = getNationalSignificantNumber(r3);
        int r5 = r3.getCountryCode();
        if (hasValidCountryCallingCode(r5) == true) goto L7;
        return ValidationResult.INVALID_COUNTRY_CODE;
    L7:
        return testNumberLength(r0, getMetadataForRegionOrCallingCode(r5, getRegionCodeForCountryCode(r5)), r4);
    }

    public boolean isPossibleNumber(CharSequence r1, String r2) {
        return isPossibleNumber(parse(r1, r2));
    L4:
        return false;
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber r7) {
        if (isValidNumber(r7) == false) goto L5;
        return true;
    L5:
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();
        r0.mergeFrom(r7);
        long r2 = r7.getNationalNumber();
    L6:
        r2 = r2 / 10;
        r0.setNationalNumber(r2);
        if (isPossibleNumberWithReason(r0) == ValidationResult.TOO_SHORT) goto L15;
        if (r2 == 0) goto L21;
        if (isValidNumber(r0) == false) goto L6;
        r7.setNationalNumber(r2);
        return true;
    L21:
        return false;
    L15:
        return false;
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String r1) {
        return new AsYouTypeFormatter(r1);
    }

    int extractCountryCode(StringBuilder r7, StringBuilder r8) {
        if (r7.length() != 0) goto L5;
    L16:
        return 0;
    L5:
        if (r7.charAt(0) == '0') goto L16;
        int r0 = r7.length();
        int r2 = 1;
    L9:
        if (r2 > 3) goto L16;
        if (r2 > r0) goto L16;
        int r3 = Integer.parseInt(r7.substring(0, r2));
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(r3)) == true) goto L13;
        r2 = r2 + 1;
        goto L9
    L13:
        r8.append(r7.substring(r2));
        return r3;
    }

    int maybeExtractCountryCode(CharSequence r6, Phonemetadata.PhoneMetadata r7, StringBuilder r8, boolean r9, Phonenumber.PhoneNumber r10) throws NumberParseException {
        if (r6.length() != 0) goto L5;
        return 0;
    L5:
        StringBuilder r0 = new StringBuilder(r6);
        if (r7 == null) goto L8;
        String r11 = r7.getInternationalPrefix();
    L9:
        Phonenumber.PhoneNumber.CountryCodeSource r12 = maybeStripInternationalPrefixAndNormalize(r0, r11);
        if (r9 == false) goto L13;
        r10.setCountryCodeSource(r12);
    L13:
        if (r12 != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) goto L15;
        if (r7 == null) goto L38;
        int r13 = r7.getCountryCode();
        String r2 = String.valueOf(r13);
        String r3 = r0.toString();
        if (r3.startsWith(r2) == false) goto L38;
        StringBuilder r4 = new StringBuilder(r3.substring(r2.length()));
        Phonemetadata.PhoneNumberDesc r5 = r7.getGeneralDesc();
        maybeStripNationalPrefixAndCarrierCode(r4, r7, null);
        if (this.matcherApi.matchNationalNumber(r0, r5, false) == true) goto L32;
        if (this.matcherApi.matchNationalNumber(r4, r5, false) == false) goto L32;
    L33:
        r8.append(r4);
        if (r9 == false) goto L36;
        r10.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
    L36:
        r10.setCountryCode(r13);
        return r13;
    L32:
        if (testNumberLength(r0, r7) == ValidationResult.TOO_LONG) goto L33;
    L38:
        r10.setCountryCode(0);
        return 0;
    L15:
        if (r0.length() <= 2) goto L23;
        int r14 = extractCountryCode(r0, r8);
        if (r14 == 0) goto L21;
        r10.setCountryCode(r14);
        return r14;
    L21:
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
    L23:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
    L8:
        r11 = "NonMatch";
        goto L9
    }

    private boolean parsePrefixAsIdd(Pattern r4, StringBuilder r5) {
        Matcher r3 = r4.matcher(r5);
        if (r3.lookingAt() == false) goto L11;
        int r6 = r3.end();
        Matcher r7 = CAPTURING_DIGIT_PATTERN.matcher(r5.substring(r6));
        if (r7.find() == true) goto L7;
    L9:
        r5.delete(0, r6);
        return true;
    L7:
        if (normalizeDigitsOnly(r7.group(1)).equals("0") == false) goto L9;
        return false;
    L11:
        return false;
    }

    Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder r3, String r4) {
        if (r3.length() == 0) goto L5;
        Matcher r0 = PLUS_CHARS_PATTERN.matcher(r3);
        if (r0.lookingAt() == false) goto L10;
        r3.delete(0, r0.end());
        normalize(r3);
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    L10:
        Pattern r5 = this.regexCache.getPatternForRegex(r4);
        normalize(r3);
        if (parsePrefixAsIdd(r5, r3) == false) goto L14;
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
    L14:
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    L5:
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder r9, Phonemetadata.PhoneMetadata r10, StringBuilder r11) {
        int r0 = r9.length();
        String r1 = r10.getNationalPrefixForParsing();
        if (r0 != 0) goto L5;
    L37:
        return false;
    L5:
        if (r1.length() == 0) goto L37;
        Matcher r2 = this.regexCache.getPatternForRegex(r1).matcher(r9);
        if (r2.lookingAt() == false) goto L37;
        Phonemetadata.PhoneNumberDesc r3 = r10.getGeneralDesc();
        boolean r4 = this.matcherApi.matchNationalNumber(r9, r3, false);
        int r5 = r2.groupCount();
        String r12 = r10.getNationalPrefixTransformRule();
        if (r12 != null) goto L12;
    L26:
        if (r4 == true) goto L28;
    L30:
        if (r11 == null) goto L35;
        if (r5 <= 0) goto L35;
        if (r2.group(r5) == null) goto L35;
        r11.append(r2.group(1));
    L35:
        r9.delete(0, r2.end());
        return true;
    L28:
        if (this.matcherApi.matchNationalNumber(r9.substring(r2.end()), r3, false) == true) goto L30;
        return false;
    L12:
        if (r12.length() == 0) goto L26;
        if (r2.group(r5) == null) goto L26;
        StringBuilder r7 = new StringBuilder(r9);
        r7.replace(0, r0, r2.replaceFirst(r12));
        if (r4 == true) goto L19;
    L21:
        if (r11 == null) goto L24;
        if (r5 <= 1) goto L24;
        r11.append(r2.group(1));
    L24:
        r9.replace(0, r9.length(), r7.toString());
        return true;
    L19:
        if (this.matcherApi.matchNationalNumber(r7.toString(), r3, false) == true) goto L21;
        return false;
    }

    String maybeStripExtension(StringBuilder r4) {
        Matcher r3 = EXTN_PATTERN.matcher(r4);
        if (r3.find() == true) goto L5;
        return "";
    L5:
        if (isViablePhoneNumber(r4.substring(0, r3.start())) == false) goto L17;
        int r0 = r3.groupCount();
        int r1 = 1;
    L7:
        if (r1 > r0) goto L18;
        if (r3.group(r1) != null) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        String r2 = r3.group(r1);
        r4.delete(r3.start(), r4.length());
        return r2;
    L18:
        return "";
    L17:
        return "";
    }

    private boolean checkRegionForParsing(CharSequence r1, String r2) {
        if (isValidRegionCode(r2) == true) goto L11;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.length() != 0) goto L8;
        return false;
    L8:
        if (PLUS_CHARS_PATTERN.matcher(r1).lookingAt() == true) goto L15;
        return false;
    L15:
        return true;
    L11:
        return true;
    }

    public Phonenumber.PhoneNumber parse(CharSequence r2, String r3) throws NumberParseException {
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();
        parse(r2, r3, r0);
        return r0;
    }

    public void parse(CharSequence r7, String r8, Phonenumber.PhoneNumber r9) throws NumberParseException {
        parseHelper(r7, r8, false, true, r9);
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(CharSequence r2, String r3) throws NumberParseException {
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();
        parseAndKeepRawInput(r2, r3, r0);
        return r0;
    }

    public void parseAndKeepRawInput(CharSequence r7, String r8, Phonenumber.PhoneNumber r9) throws NumberParseException {
        parseHelper(r7, r8, true, true, r9);
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence r7, String r8) {
        return findNumbers(r7, r8, Leniency.VALID, Long.MAX_VALUE);
    }

    public Iterable<PhoneNumberMatch> findNumbers(final CharSequence r9, final String r10, final Leniency r11, final long r12) {
        return new AnonymousClass1(this, r9, r10, r11, r12);
    }

    static void setItalianLeadingZerosForPhoneNumber(CharSequence r4, Phonenumber.PhoneNumber r5) {
        if (r4.length() > 1) goto L5;
        return;
    L5:
        if (r4.charAt(0) != '0') goto L18;
        r5.setItalianLeadingZero(true);
        int r0 = 1;
    L8:
        if (r0 >= (r4.length() - 1)) goto L12;
        if (r4.charAt(r0) != '0') goto L12;
        r0 = r0 + 1;
    L12:
        if (r0 == 1) goto L19;
        r5.setNumberOfLeadingZeros(r0);
        return;
    L19:
        return;
    }

    private void parseHelper(CharSequence r9, String r10, boolean r11, boolean r12, Phonenumber.PhoneNumber r13) throws NumberParseException {
        if (r9 == null) goto L72;
        if (r9.length() > 250) goto L70;
        StringBuilder r0 = new StringBuilder();
        String r14 = r9.toString();
        buildNationalNumberForParsing(r14, r0);
        if (isViablePhoneNumber(r0) == false) goto L68;
        if (r12 == true) goto L9;
    L13:
        if (r11 == false) goto L15;
        r13.setRawInput(r14);
    L15:
        String r15 = maybeStripExtension(r0);
        if (r15.length() <= 0) goto L18;
        r13.setExtension(r15);
    L18:
        Phonemetadata.PhoneMetadata r16 = getMetadataForRegion(r10);
        StringBuilder r17 = new StringBuilder();
        int r1 = maybeExtractCountryCode(r0, r16, r17, r11, r13);     // Catch: NumberParseException -> L21
    L28:
        if (r1 == 0) goto L32;
        String r2 = getRegionCodeForCountryCode(r1);
        if (r2.equals(r10) == true) goto L38;
        r16 = getMetadataForRegionOrCallingCode(r1, r2);
    L38:
        if (r17.length() < 2) goto L62;
        if (r16 == null) goto L51;
        StringBuilder r18 = new StringBuilder();
        StringBuilder r3 = new StringBuilder(r17);
        maybeStripNationalPrefixAndCarrierCode(r3, r16, r18);
        ValidationResult r8 = testNumberLength(r3, r16);
        if (r8 == ValidationResult.TOO_SHORT) goto L51;
        if (r8 == ValidationResult.IS_POSSIBLE_LOCAL_ONLY) goto L51;
        if (r8 == ValidationResult.INVALID_LENGTH) goto L51;
        if (r11 == true) goto L48;
    L50:
        r17 = r3;
        goto L51
    L48:
        if (r18.length() <= 0) goto L50;
        r13.setPreferredDomesticCarrierCode(r18.toString());
    L51:
        int r19 = r17.length();
        if (r19 < 2) goto L60;
        if (r19 > 17) goto L58;
        setItalianLeadingZerosForPhoneNumber(r17, r13);
        r13.setNationalNumber(Long.parseLong(r17.toString()));
        return;
    L58:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
    L60:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
    L62:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
    L32:
        r17.append(normalize(r0));
        if (r10 == null) goto L35;
        r13.setCountryCode(r16.getCountryCode());
        goto L38
    L35:
        if (r11 == false) goto L38;
        r13.clearCountryCodeSource();
    L21:
        e = move-exception;
        Matcher r4 = PLUS_CHARS_PATTERN.matcher(r0);
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L66;
        if (r4.lookingAt() == false) goto L66;
        r1 = maybeExtractCountryCode(r0.substring(r4.end()), r16, r17, r11, r13);
        if (r1 != 0) goto L28;
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
    L66:
        throw new NumberParseException(e.getErrorType(), e.getMessage());
    L9:
        if (checkRegionForParsing(r0, r10) == true) goto L13;
        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
    L68:
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
    L70:
        throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
    L72:
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    private void buildNationalNumberForParsing(String r4, StringBuilder r5) {
        int r3 = r4.indexOf(RFC3966_PHONE_CONTEXT);
        if (r3 < 0) goto L17;
        int r0 = r3 + 15;
        if (r0 < (r4.length() - 1)) goto L7;
    L12:
        int r1 = r4.indexOf(RFC3966_PREFIX);
        if (r1 < 0) goto L15;
        int r2 = r1 + 4;
    L16:
        r5.append(r4.substring(r2, r3));
    L18:
        int r6 = r5.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (r6 <= 0) goto L22;
        r5.delete(r6, r5.length());
        return;
    L22:
        return;
    L15:
        r2 = 0;
        goto L16
    L7:
        if (r4.charAt(r0) != '+') goto L12;
        int r7 = r4.indexOf(59, r0);
        if (r7 <= 0) goto L11;
        r5.append(r4.substring(r0, r7));
        goto L12
    L11:
        r5.append(r4.substring(r0));
        goto L12
    L17:
        r5.append(extractPossibleNumber(r4));
        goto L18
    }

    private static Phonenumber.PhoneNumber copyCoreFieldsOnly(Phonenumber.PhoneNumber r3) {
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();
        r0.setCountryCode(r3.getCountryCode());
        r0.setNationalNumber(r3.getNationalNumber());
        if (r3.getExtension().length() <= 0) goto L6;
        r0.setExtension(r3.getExtension());
    L6:
        if (r3.isItalianLeadingZero() == false) goto L8;
        r0.setItalianLeadingZero(true);
        r0.setNumberOfLeadingZeros(r3.getNumberOfLeadingZeros());
    L8:
        return r0;
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber r4, Phonenumber.PhoneNumber r5) {
        Phonenumber.PhoneNumber r6 = copyCoreFieldsOnly(r4);
        Phonenumber.PhoneNumber r7 = copyCoreFieldsOnly(r5);
        if (r6.hasExtension() == true) goto L5;
    L10:
        int r0 = r6.getCountryCode();
        int r1 = r7.getCountryCode();
        if (r0 == 0) goto L24;
        if (r1 == 0) goto L24;
        if (r6.exactlySameAs(r7) == true) goto L16;
        if (r0 != r1) goto L23;
        if (isNationalNumberSuffixOfTheOther(r6, r7) == false) goto L23;
        return MatchType.SHORT_NSN_MATCH;
    L23:
        return MatchType.NO_MATCH;
    L16:
        return MatchType.EXACT_MATCH;
    L24:
        r6.setCountryCode(r1);
        if (r6.exactlySameAs(r7) == false) goto L29;
        return MatchType.NSN_MATCH;
    L29:
        if (isNationalNumberSuffixOfTheOther(r6, r7) == false) goto L33;
        return MatchType.SHORT_NSN_MATCH;
    L33:
        return MatchType.NO_MATCH;
    L5:
        if (r7.hasExtension() == false) goto L10;
        if (r6.getExtension().equals(r7.getExtension()) == true) goto L10;
        return MatchType.NO_MATCH;
    }

    private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber r1, Phonenumber.PhoneNumber r2) {
        String r0 = String.valueOf(r1.getNationalNumber());
        String r3 = String.valueOf(r2.getNationalNumber());
        if (r0.endsWith(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.endsWith(r0) == true) goto L8;
        return false;
    }

    public MatchType isNumberMatch(CharSequence r10, CharSequence r11) {
        return isNumberMatch(parse(r10, UNKNOWN_REGION), r11);
    L5:
        e = move-exception;
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L16;
        return isNumberMatch(parse(r11, UNKNOWN_REGION), r10);
    L10:
        e = move-exception;
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L16;
        Phonenumber.PhoneNumber r0 = new Phonenumber.PhoneNumber();     // Catch: NumberParseException -> L17
        Phonenumber.PhoneNumber r8 = new Phonenumber.PhoneNumber();     // Catch: NumberParseException -> L17
        parseHelper(r10, null, false, false, r0);     // Catch: NumberParseException -> L17
        parseHelper(r11, null, false, false, r8);     // Catch: NumberParseException -> L17
        return isNumberMatch(r0, r8);
    L16:
        return MatchType.NOT_A_NUMBER;
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber r8, CharSequence r9) {
        return isNumberMatch(r8, parse(r9, UNKNOWN_REGION));
    L5:
        e = move-exception;
        if (e.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) goto L18;
        String r1 = getRegionCodeForCountryCode(r8.getCountryCode());
        if (r1.equals(UNKNOWN_REGION) == true) goto L15;
        MatchType r7 = isNumberMatch(r8, parse(r9, r1));     // Catch: NumberParseException -> L19
        if (r7 == MatchType.EXACT_MATCH) goto L14;
        return r7;
    L14:
        return MatchType.NSN_MATCH;
    L15:
        Phonenumber.PhoneNumber r6 = new Phonenumber.PhoneNumber();     // Catch: NumberParseException -> L19
        parseHelper(r9, null, false, false, r6);     // Catch: NumberParseException -> L19
        return isNumberMatch(r8, r6);
    L18:
        return MatchType.NOT_A_NUMBER;
    }

    public boolean canBeInternationallyDialled(Phonenumber.PhoneNumber r3) {
        Phonemetadata.PhoneMetadata r0 = getMetadataForRegion(getRegionCodeForNumber(r3));
        if (r0 != null) goto L6;
        return true;
    L6:
        return !isNumberMatchingDesc(getNationalSignificantNumber(r3), r0.getNoInternationalDialling());
    }

    public boolean isMobileNumberPortableRegion(String r4) {
        Phonemetadata.PhoneMetadata r3 = getMetadataForRegion(r4);
        if (r3 != null) goto L7;
        logger.log(Level.WARNING, "Invalid or unknown region code provided: " + r4);
        return false;
    L7:
        return r3.isMobileNumberPortableRegion();
    }
}
