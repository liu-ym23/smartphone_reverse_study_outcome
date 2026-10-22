package com.obric.oui.indexscrollbar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: AlphabetsConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f35303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f35304c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f35305d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f35306e = null;
    private static String[] f;

    private a() {
    }

    static {
        f35302a = new a();
        f35304c = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f35305d = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f35306e = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        f = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
    }

    public final float a(String r3) {
        o.e(r3, "language");
        if (o.a(Locale.KOREA.getLanguage(), r3) == false) goto L6;
    L13:
        return 9.0f;
    L6:
        if (o.a(Locale.JAPAN.getLanguage(), r3) == false) goto L9;
        return 12.5f;
    L9:
        if (o.a("ru", r3) == false) goto L13;
        if (f35303b == true) goto L13;
        return 12.5f;
    }

    public final String[] b(String r1) {
        o.e(r1, "language");
        if (o.a(Locale.KOREA.getLanguage(), r1) == false) goto L6;
        return f35305d;
    L6:
        if (o.a(Locale.JAPAN.getLanguage(), r1) == false) goto L9;
        return f35306e;
    L9:
        if (o.a("ru", r1) == false) goto L12;
        return f;
    L12:
        return f35304c;
    }

    public final boolean c(String r2) {
        o.e(r2, "language");
        if (o.a(Locale.CHINESE.getLanguage(), r2) == false) goto L6;
        return true;
    L6:
        if (o.a(Locale.ENGLISH.getLanguage(), r2) == false) goto L9;
        return true;
    L9:
        if (o.a(Locale.KOREA.getLanguage(), r2) == false) goto L12;
        return true;
    L12:
        if (o.a(Locale.JAPAN.getLanguage(), r2) == false) goto L15;
        return true;
    L15:
        if (o.a("ru", r2) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean a(String r4, String r5) {
        o.e(r4, "language");
        o.e(r5, "alphabet");
        if (o.a(Locale.CHINESE.getLanguage(), r4) == false) goto L6;
    L23:
        return true;
    L6:
        if (o.a(Locale.ENGLISH.getLanguage(), r4) == true) goto L23;
        if (o.a(Locale.KOREA.getLanguage(), r4) == false) goto L14;
        if (j(r5) == true) goto L23;
        return false;
    L14:
        if (o.a(Locale.JAPAN.getLanguage(), r4) == false) goto L19;
        if (i(r5) == true) goto L23;
        return false;
    L19:
        if (o.a("ru", r4) == true) goto L21;
        return false;
    L21:
        if (h(r5) == true) goto L23;
        return false;
    }

    public final int d(String r3) {
        o.e(r3, "language");
        if (o.a(Locale.CHINESE.getLanguage(), r3) == false) goto L6;
    L16:
        return 0;
    L6:
        if (o.a(Locale.ENGLISH.getLanguage(), r3) == false) goto L9;
        return 1;
    L9:
        if (o.a(Locale.KOREA.getLanguage(), r3) == true) goto L16;
        if (o.a(Locale.JAPAN.getLanguage(), r3) == false) goto L15;
        return 1;
    L15:
        if (o.a("ru", r3) == false) goto L16;
        return 1;
    }

    public final boolean e(String r1) {
        o.e(r1, "alphabet");
        return o.a(".>", r1);
    }

    public final boolean f(String r1) {
        o.e(r1, "alphabet");
        return o.a(".~", r1);
    }

    public final boolean g(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (d.o.o.b(r4, "*", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean h(String r3) {
        o.e(r3, "alphabet");
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(f, 0, 32), String[].class, "com.obric.aiagent.plugin");
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }

    private final boolean j(String r3) {
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(f35305d, 0, 14), String[].class, "com.obric.aiagent.plugin");
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }

    public final boolean i(String r3) {
        o.e(r3, "alphabet");
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(f35306e, 0, 50), String[].class, "com.obric.aiagent.plugin");
        return Arrays.asList(Arrays.copyOf(r2, r2.length)).contains(r3);
    }
}
