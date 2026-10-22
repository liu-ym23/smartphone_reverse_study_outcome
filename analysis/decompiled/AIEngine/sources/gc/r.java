package gc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class r extends q {
    public static String Q0(int i10, String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(i10);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String R0(int i10, String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(0, i10);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String S0(int i10, String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(length - i10);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
