package B7;

import android.net.Uri;
import androidx.appsearch.app.AppSearchSchema;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import f6.AbstractC1436a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.n;
import m9.InterfaceC1733z;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static void A(StringBuilder sb, StringBuilder sb2) {
        sb.append(System.currentTimeMillis());
        sb2.append(sb.toString());
    }

    public static String B(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static double a(double d, double d6, double d10) {
        return (Math.sin(d) * d6) + d10;
    }

    public static float b(float f, float f7, float f9, float f10) {
        return ((f - f7) * f9) + f10;
    }

    public static int c(int i, int i6, String str) {
        return (str.hashCode() + i) * i6;
    }

    public static AppSearchSchema.StringPropertyConfig d(String str, int i, int i6, int i10, int i11) {
        return new AppSearchSchema.StringPropertyConfig.Builder(str).setCardinality(i).setTokenizerType(i6).setIndexingType(i10).setJoinableValueType(i11).build();
    }

    public static CompositionScopedCoroutineScopeCanceller e(InterfaceC1733z interfaceC1733z, Composer composer) {
        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(interfaceC1733z);
        composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
        return compositionScopedCoroutineScopeCanceller;
    }

    public static ClassCastException f(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String g(char c, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static String h(int i, String str) {
        return str + i;
    }

    public static String i(Class cls, String str) {
        return str + cls;
    }

    public static String j(String str, Uri uri) {
        return str + uri;
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, float f) {
        return str + f + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String n(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String o(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String p(StringBuilder sb, long j5, char c) {
        sb.append(j5);
        sb.append(c);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String r(StringBuilder sb, List list, char c) {
        sb.append(list);
        sb.append(c);
        return sb.toString();
    }

    public static String s(StringBuilder sb, boolean z10, String str) {
        sb.append(z10);
        sb.append(str);
        return sb.toString();
    }

    public static String t(n nVar, Class cls, StringBuilder sb) {
        sb.append(nVar.b(cls));
        return sb.toString();
    }

    public static StringBuilder u(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder v(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder w(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static Map x(String str, String str2) {
        return kotlin.collections.a.Q(new Pair(str, str2));
    }

    public static void y(long j5, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(str2);
        sb.append(j5);
    }

    public static void z(String str, String str2, String str3, String str4, boolean z10) {
        AbstractC1436a.e(str4, str + str2 + str3, z10);
    }
}
