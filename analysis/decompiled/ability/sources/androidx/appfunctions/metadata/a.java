package androidx.appfunctions.metadata;

import S7.n;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void A(DrawContext drawContext, long j5) {
        drawContext.getCanvas().restore();
        drawContext.mo4629setSizeuvyYCjk(j5);
    }

    public static void B(StringBuilder sb, String str, float f) {
        sb.append((Object) Dp.m6855toStringimpl(f));
        sb.append(str);
    }

    public static boolean C(n nVar, Composer composer, int i) {
        nVar.invoke(composer, Integer.valueOf(i));
        composer.endNode();
        return ComposerKt.isTraceInProgress();
    }

    public static boolean D(Composer composer) {
        composer.endReplaceGroup();
        composer.endNode();
        return ComposerKt.isTraceInProgress();
    }

    public static float a(float f, float f7, float f9, float f10) {
        return ((f * f7) + f9) * f10;
    }

    public static int b(float f, int i, int i6) {
        return (Float.hashCode(f) + i) * i6;
    }

    public static int c(int i, int i6, long j5) {
        return (Long.hashCode(j5) + i) * i6;
    }

    public static int d(int i, int i6, boolean z10) {
        return (Boolean.hashCode(z10) + i) * i6;
    }

    public static int e(List list, int i, int i6) {
        return (list.hashCode() + i) * i6;
    }

    public static int f(Map map, int i, int i6) {
        return (map.hashCode() + i) * i6;
    }

    public static n g(ComposeUiNode.Companion companion, Composer composer, MeasurePolicy measurePolicy, Composer composer2, CompositionLocalMap compositionLocalMap) {
        Updater.m3481setimpl(composer, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m3481setimpl(composer2, compositionLocalMap, companion.getSetResolvedCompositionLocals());
        return companion.getSetCompositeKeyHash();
    }

    public static String h(char c, String str, StringBuilder sb) {
        sb.append(c);
        String string = sb.toString();
        k.e(string, str);
        return string;
    }

    public static String i(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String j(Object obj, String str) {
        return str + obj;
    }

    public static String k(String str, int i, char c) {
        return str + i + c;
    }

    public static String l(String str, String str2) {
        return str + str2;
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String n(StringBuilder sb, float f, char c) {
        sb.append(f);
        sb.append(c);
        return sb.toString();
    }

    public static String o(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String p(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String q(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    public static String r(StringBuilder sb, boolean z10, char c) {
        sb.append(z10);
        sb.append(c);
        return sb.toString();
    }

    public static StringBuilder s(int i, String str, int i6, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i6);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder t(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder u(CharSequence charSequence, String str, S7.k kVar, String str2, CharSequence charSequence2) {
        k.f(charSequence, str);
        k.f(kVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder v(CharSequence charSequence, String str, n nVar, String str2, CharSequence charSequence2) {
        k.f(charSequence, str);
        k.f(nVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder w(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        k.f(charSequence, str);
        k.f(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    public static StringBuilder x(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static void y(int i, int i6, S7.k kVar) {
        kVar.invoke(Integer.valueOf(i + i6));
    }

    public static void z(n nVar, int i, Composer composer, int i6) {
        composer.updateRememberedValue(Integer.valueOf(i));
        composer.apply(Integer.valueOf(i6), nVar);
    }
}
