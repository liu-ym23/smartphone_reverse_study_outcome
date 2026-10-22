package fd;

import java.util.Locale;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f19657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f19658b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f19659c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f19660d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String[] f19661e;

    static {
        f19657a = new e();
        f19658b = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        f19659c = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f19660d = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f19661e = new String[]{"А", ".Б", "Г", ".Д", "З", ".И", "К", ".Л", "Н", ".О", "С", ".Т", "Ф", ".Х", "Ч", ".Ш", "ы", ".ь", "A", ".B", "D", ".E", "G", ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
    }

    public e() {
    }

    public final boolean a(String r10, int r11) {
        q.g(r10, "language");
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L9;
        if (r11 >= 14) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L14;
        if (r11 >= 10) goto L17;
        return true;
    L14:
        if (q.b("ru", r10) == false) goto L17;
        if (r11 >= 5) goto L17;
        return true;
    }

    public final String[] b(String r10) {
        q.g(r10, "language");
        if (q.b(Locale.KOREA.getLanguage(), r10) == false) goto L6;
        return f19659c;
    L6:
        if (q.b(Locale.JAPAN.getLanguage(), r10) == false) goto L9;
        return f19660d;
    L9:
        if (q.b("ru", r10) == false) goto L12;
        return f19661e;
    L12:
        return f19658b;
    }
}
