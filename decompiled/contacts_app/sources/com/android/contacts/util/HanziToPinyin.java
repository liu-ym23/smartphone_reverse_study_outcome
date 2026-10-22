package com.android.contacts.util;

import android.icu.text.Transliterator;
import android.os.SystemClock;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class HanziToPinyin {
    private static final String TAG = "HanziToPinyin";
    private static HanziToPinyin sInstance;
    private Transliterator mAsciiTransliterator;
    private Transliterator mPinyinTransliterator;

    public static class Token {
        public static final int LATIN = 1;
        public static final int PINYIN = 2;
        public static final String SEPARATOR = " ";
        public static final int UNKNOWN = 3;
        public String source;
        public String target;
        public int type;

        public Token() {
        }

        public Token(int r1, String r2, String r3) {
            this.type = r1;
            this.source = r2;
            this.target = r3;
        }
    }

    private HanziToPinyin() {
        this.mPinyinTransliterator = Transliterator.getInstance("Han-Latin/Names; Latin-Ascii; Any-Upper");     // Catch: RuntimeException -> L5
        this.mAsciiTransliterator = Transliterator.getInstance("Latin-Ascii");     // Catch: RuntimeException -> L5
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Han-Latin/Names transliterator data is missing, HanziToPinyin is disabled");
    }

    public boolean hasChineseTransliterator() {
        if (this.mPinyinTransliterator == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static HanziToPinyin getInstance() {
        monitor-enter(HanziToPinyin.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        sInstance = new HanziToPinyin();     // Catch: Throwable -> L10
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getInstance initialized cost=" + (SystemClock.elapsedRealtime() - r2) + "ms");     // Catch: Throwable -> L10
    L7:
        HanziToPinyin r0 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(HanziToPinyin.class);     // Catch: Throwable -> L10
        return r0;
    }

    private void tokenize(char r3, Token r4) {
        r4.source = Character.toString(r3);
        if (r3 >= 128) goto L7;
        r4.type = 1;
        r4.target = r4.source;
        return;
    L7:
        if (r3 >= 592) goto L9;
    L22:
        r4.type = 1;
        Transliterator r2 = this.mAsciiTransliterator;
        if (r2 != null) goto L25;
        String r5 = r4.source;
    L26:
        r4.target = r5;
        return;
    L25:
        r5 = r2.transliterate(r4.source);
        goto L26
    L9:
        if (7680 <= r3) goto L11;
    L13:
        r4.type = 2;
        r4.target = handleSpecialByBytedance(r4.source);
        if (r4.target != null) goto L17;
        r4.target = this.mPinyinTransliterator.transliterate(r4.source);
    L17:
        if (TextUtils.isEmpty(r4.target) == false) goto L19;
    L20:
        r4.type = 1;
        r4.target = r4.source;
        return;
    L19:
        if (TextUtils.equals(r4.source, r4.target) == true) goto L20;
        return;
    L11:
        if (r3 >= 7935) goto L13;
        goto L13
    }

    public ArrayList<Token> get(String r9) {
        ArrayList<Token> r0 = new ArrayList();
        if (hasChineseTransliterator() == true) goto L5;
    L32:
        return r0;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L32;
        int r1 = r9.length();
        StringBuilder r2 = new StringBuilder();
        Token r3 = new Token();
        int r4 = 1;
        int r5 = 0;
    L8:
        if (r5 >= r1) goto L30;
        char r6 = r9.charAt(r5);
        if (Character.isSpaceChar(r6) == true) goto L12;
        tokenize(r6, r3);
        if (r3.type != 2) goto L22;
        if (r2.length() <= 0) goto L20;
        addToken(r2, r0, r4);
    L20:
        r0.add(r3);
        r3 = new Token();
    L27:
        r4 = r3.type;
    L28:
        r5 = r5 + 1;
        goto L8
    L22:
        if (r4 != r3.type) goto L24;
    L26:
        r2.append(r3.target);
        goto L27
    L24:
        if (r2.length() <= 0) goto L26;
        addToken(r2, r0, r4);
        goto L26
    L12:
        if (r2.length() <= 0) goto L14;
        addToken(r2, r0, r4);
    L14:
        tokenize(' ', r3);
        r0.add(r3);
        r3 = new Token();
        goto L28
    L30:
        if (r2.length() <= 0) goto L32;
        addToken(r2, r0, r4);
        goto L32
    }

    private void addToken(StringBuilder r2, ArrayList<Token> r3, int r4) {
        String r1 = r2.toString();
        r3.add(new Token(r4, r1, r1));
        r2.setLength(0);
    }

    private static String handleSpecialByBytedance(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() == 1) goto L6;
        return null;
    L6:
        switch(r2.charAt(0)) {
            case 13607: goto L18;
            case 14030: goto L18;
            case 14373: goto L18;
            case 15194: goto L18;
            case 15542: goto L18;
            case 15702: goto L16;
            case 16114: goto L18;
            case 16276: goto L18;
            case 17694: goto L18;
            case 17761: goto L18;
            case 17825: goto L16;
            case 17936: goto L16;
            case 18108: goto L16;
            case 18792: goto L18;
            case 19850: goto L16;
            case 20387: goto L18;
            case 20406: goto L18;
            case 20770: goto L18;
            case 21236: goto L18;
            case 21525: goto L18;
            case 21570: goto L18;
            case 21621: goto L14;
            case 22415: goto L18;
            case 22899: goto L16;
            case 23549: goto L18;
            case 23649: goto L18;
            case 23650: goto L18;
            case 23653: goto L18;
            case 23874: goto L18;
            case 24459: goto L18;
            case 24679: goto L16;
            case 24942: goto L18;
            case 25364: goto L18;
            case 25419: goto L18;
            case 25435: goto L18;
            case 26053: goto L18;
            case 26386: goto L16;
            case 26784: goto L18;
            case 27016: goto L18;
            case 27350: goto L18;
            case 27648: goto L18;
            case 27695: goto L18;
            case 27793: goto L16;
            case 28388: goto L18;
            case 28670: goto L18;
            case 28946: goto L18;
            case 29192: goto L18;
            case 29575: goto L18;
            case 31075: goto L18;
            case 31238: goto L18;
            case 31326: goto L18;
            case 31341: goto L18;
            case 31675: goto L18;
            case 31865: goto L16;
            case 32125: goto L18;
            case 32160: goto L18;
            case 32209: goto L18;
            case 32311: goto L18;
            case 32321: goto L12;
            case 32322: goto L18;
            case 32511: goto L18;
            case 32533: goto L18;
            case 33154: goto L18;
            case 33168: goto L18;
            case 33183: goto L18;
            case 33186: goto L18;
            case 33870: goto L18;
            case 34264: goto L18;
            case 34385: goto L18;
            case 34884: goto L16;
            case 35099: goto L18;
            case 35128: goto L18;
            case 37080: goto L18;
            case 37369: goto L16;
            case 37569: goto L18;
            case 37986: goto L18;
            case 38037: goto L16;
            case 38109: goto L18;
            case 38241: goto L10;
            case 38317: goto L18;
            case 38398: goto L18;
            case 38426: goto L8;
            case 39359: goto L18;
            case 39522: goto L18;
            case 39540: goto L18;
            case 40412: goto L18;
            case 55361: goto L18;
            case 55362: goto L18;
            case 55363: goto L18;
            case 55364: goto L18;
            case 55366: goto L18;
            case 55367: goto L18;
            case 55368: goto L18;
            case 55370: goto L18;
            case 55372: goto L18;
            case 55374: goto L18;
            case 55376: goto L18;
            case 55377: goto L18;
            case 55379: goto L18;
            case 55381: goto L18;
            case 55383: goto L18;
            case 55386: goto L18;
            case 55387: goto L18;
            case 55388: goto L18;
            case 55389: goto L18;
            case 55390: goto L18;
            case 55396: goto L18;
            case 55398: goto L18;
            case 55399: goto L18;
            case 55400: goto L18;
            case 56350: goto L18;
            case 56352: goto L18;
            case 56383: goto L18;
            case 56398: goto L18;
            case 56418: goto L18;
            case 56437: goto L18;
            case 56486: goto L18;
            case 56522: goto L18;
            case 56530: goto L18;
            case 56545: goto L18;
            case 56557: goto L18;
            case 56571: goto L18;
            case 56592: goto L18;
            case 56637: goto L18;
            case 56646: goto L18;
            case 56670: goto L18;
            case 56710: goto L18;
            case 56716: goto L18;
            case 56764: goto L18;
            case 56766: goto L18;
            case 56776: goto L18;
            case 56812: goto L18;
            case 56852: goto L18;
            case 56858: goto L18;
            case 56860: goto L18;
            case 56946: goto L18;
            case 57020: goto L18;
            case 57047: goto L18;
            case 57096: goto L18;
            case 57098: goto L18;
            case 57159: goto L18;
            case 57168: goto L18;
            case 57180: goto L18;
            case 57199: goto L18;
            case 57206: goto L18;
            case 57212: goto L18;
            case 57213: goto L18;
            case 57221: goto L18;
            case 57274: goto L18;
            case 57328: goto L18;
            case 57331: goto L18;
            default: goto L23;
        };
    L8:
        return "KAN";
    L10:
        return "TAN";
    L12:
        return "FAN";
    L14:
        return "HE";
    L16:
        return "NV";
    L18:
        return "LV";
    L23:
        return null;
    }
}
