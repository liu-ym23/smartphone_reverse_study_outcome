package com.android.contacts.util;

import android.icu.text.AlphabeticIndex;
import android.icu.text.Transliterator;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.dialpad.T9Search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ContactLocaleUtils {
    public static final String CHINESE_LANGUAGE = null;
    public static final String ENGLISH_LANGUAGE = null;
    public static final String JAPANESE_LANGUAGE = null;
    public static final String KOREAN_LANGUAGE = null;
    public static final Locale LOCALE_ARABIC = null;
    public static final Locale LOCALE_GREEK = null;
    public static final Locale LOCALE_HEBREW = null;
    public static final Locale LOCALE_THAI = null;
    public static final Locale LOCALE_UKRAINIAN = null;
    public static final String TAG = "ContactLocale";
    private static ContactLocaleUtils sSingleton;
    private final String mLanguage;
    private final Locale mLocale;
    private final ContactLocaleUtilsBase mUtils;

    private static class ContactLocaleUtilsBase {
        private static final String EMPTY_STRING = "";
        private static final String NUMBER_STRING = "#";
        protected final AlphabeticIndex.ImmutableIndex mAlphabeticIndex;
        private final int mAlphabeticIndexBucketCount;
        private final int mNumberBucketIndex;

        public Iterator<String> getNameLookupKeys(String r1, int r2) {
            return null;
        }

        public String getSortKey(String r1) {
            return r1;
        }

        public ContactLocaleUtilsBase(Locale r5) {
            AlphabeticIndex.ImmutableIndex r6 = new AlphabeticIndex(r5).setMaxLabelCount(300).addLabels(new Locale[]{Locale.ENGLISH}).addLabels(new Locale[]{Locale.JAPANESE}).addLabels(new Locale[]{Locale.KOREAN}).addLabels(new Locale[]{ContactLocaleUtils.LOCALE_THAI}).addLabels(new Locale[]{ContactLocaleUtils.LOCALE_ARABIC}).addLabels(new Locale[]{ContactLocaleUtils.LOCALE_HEBREW}).addLabels(new Locale[]{ContactLocaleUtils.LOCALE_GREEK}).addLabels(new Locale[]{ContactLocaleUtils.LOCALE_UKRAINIAN}).buildImmutableIndex();
            this.mAlphabeticIndex = r6;
            int r7 = r6.getBucketCount();
            this.mAlphabeticIndexBucketCount = r7;
            this.mNumberBucketIndex = r7 - 1;
        }

        public int getBucketIndex(String r7) {
            int r0 = r7.length();
            boolean r1 = false;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L24;
            int r4 = Character.codePointAt(r7, r2);
            if (Character.isDigit(r4) == true) goto L7;
            if (Character.isSpaceChar(r4) == true) goto L23;
            if (r4 == 43) goto L23;
            if (r4 == 40) goto L23;
            if (r4 == 41) goto L23;
            if (r4 == 46) goto L23;
            if (r4 == 45) goto L23;
            if (r4 != 35) goto L24;
        L23:
            r2 = r2 + Character.charCount(r4);
            goto L4
        L7:
            r1 = true;
        L24:
            if (r1 == true) goto L26;
            int r8 = this.mAlphabeticIndex.getBucketIndex(r7);
            if (r8 >= 0) goto L32;
            return -1;
        L32:
            if (r8 >= this.mNumberBucketIndex) goto L34;
            return r8;
        L34:
            return r8 + 1;
        L26:
            return this.mNumberBucketIndex;
        }

        public int getBucketCount() {
            return this.mAlphabeticIndexBucketCount + 1;
        }

        public String getBucketLabel(int r2) {
            if (r2 >= 0) goto L4;
            return "";
        L4:
            if (r2 >= getBucketCount()) goto L16;
            int r0 = this.mNumberBucketIndex;
            if (r2 != r0) goto L10;
            return "#";
        L10:
            if (r2 <= r0) goto L13;
            r2 = r2 - 1;
        L13:
            return this.mAlphabeticIndex.getBucket(r2).getLabel();
        L16:
            return "";
        }

        public ArrayList<String> getLabels() {
            int r0 = getBucketCount();
            ArrayList<String> r1 = new ArrayList(r0);
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1.add(getBucketLabel(r2));
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }
    }

    private static class JapaneseContactUtils extends ContactLocaleUtilsBase {
        private static final Set<Character.UnicodeBlock> CJ_BLOCKS = null;
        private static final String JAPANESE_MISC_LABEL = "他";
        private static boolean mInitializedTransliterator;
        private static Transliterator mJapaneseTransliterator;
        private final int mMiscBucketIndex;

        public JapaneseContactUtils(Locale r1) {
            super(r1);
            this.mMiscBucketIndex = super.getBucketIndex("日");
        }

        static {
            HashSet r0 = new HashSet();
            r0.add(Character.UnicodeBlock.HIRAGANA);
            r0.add(Character.UnicodeBlock.KATAKANA);
            r0.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
            r0.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
            r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
            r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
            r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
            r0.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
            r0.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
            r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
            r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
            r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
            r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
            CJ_BLOCKS = Collections.unmodifiableSet(r0);
        }

        private static boolean isChineseOrJapanese(int r1) {
            return CJ_BLOCKS.contains(Character.UnicodeBlock.of(r1));
        }

        @Override // com.android.contacts.util.ContactLocaleUtils.ContactLocaleUtilsBase
        public int getBucketIndex(String r3) {
            int r0 = super.getBucketIndex(r3);
            if (r0 != this.mMiscBucketIndex) goto L7;
            if (isChineseOrJapanese(Character.codePointAt(r3, 0)) == true) goto L7;
        L9:
            return r0 + 1;
        L7:
            if (r0 > this.mMiscBucketIndex) goto L9;
            return r0;
        }

        @Override // com.android.contacts.util.ContactLocaleUtils.ContactLocaleUtilsBase
        public int getBucketCount() {
            return super.getBucketCount() + 1;
        }

        @Override // com.android.contacts.util.ContactLocaleUtils.ContactLocaleUtilsBase
        public String getBucketLabel(int r2) {
            int r0 = this.mMiscBucketIndex;
            if (r2 != r0) goto L6;
            return JAPANESE_MISC_LABEL;
        L6:
            if (r2 <= r0) goto L9;
            r2 = r2 - 1;
        L9:
            return super.getBucketLabel(r2);
        }

        @Override // com.android.contacts.util.ContactLocaleUtils.ContactLocaleUtilsBase
        public Iterator<String> getNameLookupKeys(String r1, int r2) {
            if (r2 == 4) goto L5;
            return null;
        L5:
            return getRomajiNameLookupKeys(r1);
        }

        private static Transliterator getJapaneseTransliterator() {
            monitor-enter(JapaneseContactUtils.class);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (mInitializedTransliterator == true) goto L11;
            mInitializedTransliterator = true;     // Catch: Throwable -> L14
            Transliterator r1 = Transliterator.getInstance("Hiragana-Latin; Katakana-Latin; Latin-Ascii");     // Catch: RuntimeException -> L9 Throwable -> L14
        L10:
            mJapaneseTransliterator = r1;     // Catch: Throwable -> L14
            goto L11
        L9:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ContactLocaleUtils.TAG, "Hiragana/Katakana-Latin transliterator data is missing");     // Catch: Throwable -> L14
            r1 = null;
        L11:
            Transliterator r2 = mJapaneseTransliterator;     // Catch: Throwable -> L14
            monitor-exit(JapaneseContactUtils.class);     // Catch: Throwable -> L14
            return r2;
        }

        public static Iterator<String> getRomajiNameLookupKeys(String r3) {
            Transliterator r0 = getJapaneseTransliterator();
            if (r0 != null) goto L5;
            return null;
        L5:
            String r1 = r0.transliterate(r3);
            if (TextUtils.isEmpty(r1) == false) goto L8;
        L12:
            return null;
        L8:
            if (TextUtils.equals(r3, r1) == true) goto L12;
            HashSet r4 = new HashSet();
            r4.add(r1);
            return r4.iterator();
        }
    }

    private static class SimplifiedChineseContactUtils extends ContactLocaleUtilsBase {
        public SimplifiedChineseContactUtils(Locale r1) {
            super(r1);
        }

        @Override // com.android.contacts.util.ContactLocaleUtils.ContactLocaleUtilsBase
        public Iterator<String> getNameLookupKeys(String r1, int r2) {
            if (r2 != 4) goto L5;
            return null;
        L5:
            if (r2 != 5) goto L7;
            return null;
        L7:
            return getPinyinNameLookupKeys(r1);
        }

        public static Iterator<String> getPinyinNameLookupKeys(String r10) {
            HashSet r0 = new HashSet();
            ArrayList<HanziToPinyin.Token> r11 = HanziToPinyin.getInstance().get(r10);
            int r1 = r11.size();
            StringBuilder r2 = new StringBuilder();
            StringBuilder r3 = new StringBuilder();
            StringBuilder r4 = new StringBuilder();
            int r5 = r1 - 1;
        L3:
            if (r5 < 0) goto L22;
            HanziToPinyin.Token r6 = r11.get(r5);
            if (3 == r6.type) goto L20;
            if (2 != r6.type) goto L11;
            r2.insert(0, r6.target);
            r3.insert(0, r6.target.charAt(0));
        L19:
            r4.insert(0, r6.source);
            r0.add(r4.toString());
            r0.add(r2.toString());
            r0.add(r3.toString());
            goto L20
        L11:
            if (1 != r6.type) goto L19;
            if (r2.length() <= 0) goto L16;
            r2.insert(0, ' ');
        L16:
            if (r4.length() <= 0) goto L18;
            r4.insert(0, ' ');
        L18:
            r2.insert(0, r6.source);
            r3.insert(0, r6.source.charAt(0));
        L20:
            r5 = r5 - 1;
            goto L3
        L22:
            return r0.iterator();
        }

        public static Iterator<String> getPinyinNameKeys(String r6) {
            LinkedHashSet r0 = new LinkedHashSet();
            ArrayList<HanziToPinyin.Token> r7 = HanziToPinyin.getInstance().get(r6);
            int r1 = r7.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L20;
            HanziToPinyin.Token r3 = r7.get(r2);
            if (3 == r3.type) goto L18;
            if (2 != r3.type) goto L11;
            String r4 = r3.target.toString();
        L15:
            if (r2 == (r1 - 1)) goto L17;
            r4 = r4 + HanziToPinyin.Token.SEPARATOR;
        L17:
            r0.add(r4);
            goto L18
        L11:
            if (1 != r3.type) goto L13;
            r4 = r3.source;
            goto L15
        L13:
            r4 = "";
        L18:
            r2 = r2 + 1;
            goto L3
        L20:
            return r0.iterator();
        }

        public static Iterator<String> getPinyinChineseNameKeys(String r7) {
            LinkedHashSet r0 = new LinkedHashSet();
            ArrayList<HanziToPinyin.Token> r8 = HanziToPinyin.getInstance().get(r7);
            int r1 = r8.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L23;
            HanziToPinyin.Token r3 = r8.get(r2);
            if (3 == r3.type) goto L21;
            if (2 != r3.type) goto L14;
            String r4 = r3.target.toString();
            if (r4.length() <= 0) goto L12;
            r4 = r4 + HanziToPinyin.Token.SEPARATOR;
        L12:
            String r5 = r4 + r3.source;
        L18:
            if (r2 == (r1 - 1)) goto L20;
            r5 = r5 + HanziToPinyin.Token.SEPARATOR;
        L20:
            r0.add(r5);
            goto L21
        L14:
            if (1 != r3.type) goto L16;
            r5 = r3.source;
            goto L18
        L16:
            r5 = "";
        L21:
            r2 = r2 + 1;
            goto L3
        L23:
            return r0.iterator();
        }

        public static Iterator<String> getPinyinAndTypeKeys(String r8, ArrayList<String> r9, ArrayList<Integer> r10) {
            ArrayList<HanziToPinyin.Token> r11 = HanziToPinyin.getInstance().get(r8);
            ArrayList r0 = new ArrayList();
            int r1 = r11.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L25;
            HanziToPinyin.Token r3 = r11.get(r2);
            if (3 != r3.type) goto L7;
            String r4 = r3.source;
            r10.add(Integer.valueOf(r3.source.length()));
        L9:
            if (2 != r3.type) goto L12;
            r4 = r3.target.toString();
            r10.add(1);
        L14:
            r9.add(T9Search.nameToNumber(r4));
            if (2 != r3.type) goto L21;
            if (r4.length() <= 0) goto L19;
            r4 = r4 + HanziToPinyin.Token.SEPARATOR;
        L19:
            r4 = r4 + r3.source;
        L21:
            if (r2 == (r1 - 1)) goto L23;
            r4 = r4 + HanziToPinyin.Token.SEPARATOR;
        L23:
            r0.add(r4);
            r2 = r2 + 1;
            goto L3
        L12:
            if (1 != r3.type) goto L14;
            r4 = r3.source;
            r10.add(Integer.valueOf(r3.source.length()));
            goto L14
        L7:
            r4 = "";
            goto L9
        L25:
            return r0.iterator();
        }
    }

    static {
        LOCALE_ARABIC = new Locale("ar");
        LOCALE_GREEK = new Locale("el");
        LOCALE_HEBREW = new Locale("he");
        LOCALE_UKRAINIAN = new Locale("uk");
        LOCALE_THAI = new Locale("th");
        CHINESE_LANGUAGE = Locale.CHINESE.getLanguage().toLowerCase();
        JAPANESE_LANGUAGE = Locale.JAPANESE.getLanguage().toLowerCase();
        KOREAN_LANGUAGE = Locale.KOREAN.getLanguage().toLowerCase();
        ENGLISH_LANGUAGE = Locale.ENGLISH.getLanguage().toLowerCase();
    }

    private ContactLocaleUtils(Locale r2) {
        if (r2 != null) goto L5;
        this.mLocale = Locale.getDefault();
    L6:
        String r3 = this.mLocale.getLanguage().toLowerCase();
        this.mLanguage = r3;
        if (r3.equals(JAPANESE_LANGUAGE) == false) goto L10;
        this.mUtils = new JapaneseContactUtils(this.mLocale);
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "AddressBook Labels [" + this.mLocale.toString() + "]: " + getLabels().toString());
        return;
    L10:
        if (this.mLocale.equals(Locale.CHINA) == false) goto L12;
        this.mUtils = new SimplifiedChineseContactUtils(this.mLocale);
        goto L13
    L12:
        this.mUtils = new ContactLocaleUtilsBase(this.mLocale);
        goto L13
    L5:
        this.mLocale = r2;
        goto L6
    }

    public boolean isLocale(Locale r1) {
        return this.mLocale.equals(r1);
    }

    public static synchronized ContactLocaleUtils getInstance() {
        monitor-enter(ContactLocaleUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSingleton != null) goto L7;
        sSingleton = new ContactLocaleUtils(null);     // Catch: Throwable -> L10
    L7:
        ContactLocaleUtils r1 = sSingleton;     // Catch: Throwable -> L10
        monitor-exit(ContactLocaleUtils.class);
        return r1;
    }

    public static synchronized void setLocale(Locale r2) {
        monitor-enter(ContactLocaleUtils.class);
        ContactLocaleUtils r1 = sSingleton;     // Catch: Throwable -> L11
        if (r1 != null) goto L7;
    L8:
        sSingleton = new ContactLocaleUtils(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ContactLocaleUtils.class);
        return;
    L7:
        if (r1.isLocale(r2) == true) goto L9;
    L11:
        th = move-exception;
        throw th;
    }

    public String getSortKey(String r1, int r2) {
        return this.mUtils.getSortKey(r1);
    }

    public int getBucketIndex(String r1) {
        return this.mUtils.getBucketIndex(r1);
    }

    public int getBucketCount() {
        return this.mUtils.getBucketCount();
    }

    public String getBucketLabel(int r1) {
        return this.mUtils.getBucketLabel(r1);
    }

    public String getLabel(String r1) {
        return getBucketLabel(getBucketIndex(r1));
    }

    public ArrayList<String> getLabels() {
        return this.mUtils.getLabels();
    }

    public Iterator<String> getNameLookupKeys(String r3, int r4) {
        if (r4 != 4) goto L11;
        if (CHINESE_LANGUAGE.equals(this.mLanguage) == true) goto L11;
        if (KOREAN_LANGUAGE.equals(this.mLanguage) == true) goto L11;
        return JapaneseContactUtils.getRomajiNameLookupKeys(r3);
    L11:
        return this.mUtils.getNameLookupKeys(r3, r4);
    }

    public Iterator<String> getChineseNameKeys(String r1) {
        return SimplifiedChineseContactUtils.getPinyinNameKeys(r1);
    }

    public Iterator<String> getPinyinChineseNameKeys(String r1) {
        return SimplifiedChineseContactUtils.getPinyinChineseNameKeys(r1);
    }

    public Iterator<String> getChineseNameKeys(String r1, ArrayList<String> r2, ArrayList<Integer> r3) {
        return SimplifiedChineseContactUtils.getPinyinAndTypeKeys(r1, r2, r3);
    }
}
