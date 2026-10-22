package h0;

import android.view.View;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import v0.m0;
import v0.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements r {
    public static float a(float f8, float f9, float f10, float f11) {
        return ((f8 - f9) * f10) + f11;
    }

    public static int b(List list, int i10, int i11) {
        return (list.hashCode() + i10) * i11;
    }

    public static String c(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static StringBuilder d(int i10, String str, int i11, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        sb2.append(i11);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder e(String str, int i10, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        return sb2;
    }

    public static StringBuilder f(String str, String str2, String str3, int i10, String str4) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(i10);
        sb2.append(str4);
        return sb2;
    }

    public static void h(int i10, String str, String str2, String str3, StringBuilder sb2) {
        sb2.append(i10);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
    }

    public static void i(int i10, String str, HashMap map, String str2) {
        map.put(str2, new stepos.support.v7.permission.a(i10, str));
    }

    public static void j(String str, long j10, PrintWriter printWriter) {
        printWriter.println(str + j10);
    }

    public static void k(String str, String str2, LogModule logModule, String str3) {
        AIEngineLogger.i(logModule, str3, str + str2);
    }

    public static void l(StringBuilder sb2, int i10, String str, int i11, String str2) {
        sb2.append(i10);
        sb2.append(str);
        sb2.append(i11);
        sb2.append(str2);
    }

    @Override // v0.r
    public m0 g(View view, m0 m0Var) {
        boolean z = ModelManagerActivity.f5846t;
        n0.b bVarG = m0Var.f13309a.g(519);
        kotlin.jvm.internal.g.c(view);
        view.setPadding(view.getPaddingLeft(), bVarG.f10589b, view.getPaddingRight(), bVarG.f10591d);
        return m0Var;
    }
}
