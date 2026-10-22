package com.obric.oui.indexscrollbar;

import d.h.b.o;
import java.util.Locale;

/* JADX INFO: compiled from: LettersConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f35312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f35313b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f35314c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f35315d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f35316e;

    private c() {
    }

    static {
        f35312a = new c();
        f35313b = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        f35314c = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f35315d = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f35316e = new String[]{"А", ".Б", "Г", ".Д", "З", ".И", "К", ".Л", "Н", ".О", "С", ".Т", "Ф", ".Х", "Ч", ".Ш", "ы", ".ь", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
    }

    public final String[] a(String r1) {
        o.e(r1, "language");
        if (o.a(Locale.KOREA.getLanguage(), r1) == false) goto L6;
        return f35314c;
    L6:
        if (o.a(Locale.JAPAN.getLanguage(), r1) == false) goto L9;
        return f35315d;
    L9:
        if (o.a("ru", r1) == false) goto L12;
        return f35316e;
    L12:
        return f35313b;
    }

    public final boolean a(String r3, int r4) {
        o.e(r3, "language");
        if (o.a(Locale.KOREA.getLanguage(), r3) == false) goto L9;
        if (r4 >= 14) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (o.a(Locale.JAPAN.getLanguage(), r3) == false) goto L14;
        if (r4 >= 10) goto L17;
        return true;
    L14:
        if (o.a("ru", r3) == false) goto L17;
        if (r4 >= 5) goto L17;
        return true;
    }
}
