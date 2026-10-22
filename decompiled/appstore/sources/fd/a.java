package fd;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f19646c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f19647d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f19648e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String[] f19649f;

    static {
        f19644a = new a();
        f19646c = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f19647d = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f19648e = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        f19649f = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
    }

    public a() {
    }

    public final String[] a(String r10) {
        q.g(r10, "language");
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L6;
        return f19647d;
    L6:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L9;
        return f19648e;
    L9:
        if (q.b("ru", r10) == false) goto L12;
        return f19649f;
    L12:
        return f19646c;
    }

    public final boolean b(String r10) {
        q.g(r10, "language");
        if (q.b(Locale.CHINESE.getLanguage(), r10) == false) goto L6;
        return true;
    L6:
        if (q.b(Locale.ENGLISH.getLanguage(), r10) == false) goto L9;
        return true;
    L9:
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L12;
        return true;
    L12:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L15;
        return true;
    L15:
        if (q.b("ru", r10) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean c(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (o.B(r10, "*", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean d(String r10) {
        q.g(r10, "alphabet");
        String[] r11 = (String[]) Arrays.copyOfRange(f19648e, 0, 50);
        return Arrays.asList(Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final boolean e(String r10) {
        String[] r11 = (String[]) Arrays.copyOfRange(f19647d, 0, 14);
        return Arrays.asList(Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final boolean f(String r10) {
        q.g(r10, "alphabet");
        return q.b(".~", r10);
    }

    public final boolean g(String r10) {
        q.g(r10, "alphabet");
        String[] r11 = (String[]) Arrays.copyOfRange(f19649f, 0, 32);
        return Arrays.asList(Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final boolean h(String r10, String r11) {
        q.g(r10, "language");
        q.g(r11, "alphabet");
        if (q.b(Locale.CHINESE.getLanguage(), r10) == false) goto L6;
        return true;
    L6:
        if (q.b(Locale.ENGLISH.getLanguage(), r10) == false) goto L9;
        return true;
    L9:
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L15;
        if (e(r11) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L20;
        if (d(r11) == false) goto L23;
        return true;
    L20:
        if (q.b("ru", r10) == false) goto L23;
        if (g(r11) == false) goto L23;
        return true;
    }

    public final boolean i(String r10) {
        q.g(r10, "alphabet");
        return q.b(".>", r10);
    }

    public final float j(String r10) {
        q.g(r10, "language");
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L6;
        return 9.0f;
    L6:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L9;
    L12:
        return 12.5f;
    L9:
        if (q.b("ru", r10) == true) goto L11;
        return 9.0f;
    L11:
        if (f19645b == false) goto L12;
        return 9.0f;
    }

    public final int k(String r10) {
        q.g(r10, "language");
        if (q.b(Locale.CHINESE.getLanguage(), r10) == false) goto L6;
        return 0;
    L6:
        if (q.b(Locale.ENGLISH.getLanguage(), r10) == false) goto L9;
    L17:
        return 1;
    L9:
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L12;
        return 0;
    L12:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == true) goto L17;
        if (q.b("ru", r10) == true) goto L17;
        return 0;
    }
}
