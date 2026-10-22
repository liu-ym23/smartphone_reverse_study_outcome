package com.stepos.statsrpk.service;

import N9.j;
import androidx.compose.ui.graphics.vector.PathBuilder;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.volcengine.tos.model.RequestInfo;
import f6.AbstractC1436a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Operators;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class c {
    public static int a(int i, int i6, String str) {
        return (Objects.hashCode(str) + i) * i6;
    }

    public static int b(List list, int i, int i6) {
        return (Objects.hashCode(list) + i) * i6;
    }

    public static int c(Map map, int i, int i6) {
        return (Objects.hashCode(map) + i) * i6;
    }

    public static PathBuilder d(float f, float f7) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f7);
        return pathBuilder;
    }

    public static PathBuilder e(float f, float f7, float f9, float f10) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f7);
        pathBuilder.lineToRelative(f9, f10);
        return pathBuilder;
    }

    public static Object f(StringBuilder sb, String str, TrackerPayload trackerPayload, String str2) {
        sb.append(str);
        return trackerPayload.getHeaderMap().get(str2);
    }

    public static String g(StringBuilder sb, RequestInfo requestInfo, char c) {
        sb.append(requestInfo);
        sb.append(c);
        return sb.toString();
    }

    public static List h(PathBuilder pathBuilder, float f, float f7, float f9, float f10) {
        pathBuilder.lineToRelative(f, f7);
        pathBuilder.lineToRelative(f9, f10);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }

    public static Mono i(String str) {
        return Mono.error(new IllegalStateException(str));
    }

    public static void j(int i, String str, HashMap map, String str2) {
        map.put(str2, new stepos.support.v7.permission.a(i, str));
    }

    public static void k(PathBuilder pathBuilder, float f, float f7, float f9) {
        pathBuilder.lineTo(f, f7);
        pathBuilder.verticalLineToRelative(f9);
        pathBuilder.close();
    }

    public static void l(PathBuilder pathBuilder, float f, float f7, float f9, float f10) {
        pathBuilder.moveTo(f, f7);
        pathBuilder.horizontalLineToRelative(f9);
        pathBuilder.verticalLineToRelative(f10);
    }

    public static /* synthetic */ void m(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void n(String str, String str2, String str3) {
        j.G(str + str2, str3);
    }

    public static void o(String str, String str2, String str3, String str4, String str5) {
        j.G(str + str2 + str3 + str4, str5);
    }

    public static void p(String str, String str2, String str3, String str4, boolean z10) {
        AbstractC1436a.d(str4, str + str2 + str3, z10);
    }

    public static void q(StringBuilder sb, Class cls, String str) {
        sb.append(cls.getSimpleName());
        sb.append(str);
    }

    public static void r(StringBuilder sb, String str, String str2, boolean z10) {
        sb.append(str);
        AbstractC1436a.d(str2, sb.toString(), z10);
    }

    public static void s(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static void t(CoreSubscriber coreSubscriber, Throwable th, CoreSubscriber coreSubscriber2) {
        Operators.error(coreSubscriber2, Operators.onOperatorError(th, coreSubscriber.currentContext()));
    }

    public static PathBuilder u(float f, float f7, float f9, float f10) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f7);
        pathBuilder.lineTo(f9, f10);
        return pathBuilder;
    }

    public static List v(PathBuilder pathBuilder, float f, float f7, float f9, float f10) {
        pathBuilder.lineTo(f, f7);
        pathBuilder.lineTo(f9, f10);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }

    public static void w(String str, String str2, String str3, String str4, boolean z10) {
        AbstractC1436a.b(str4, str + str2 + str3, z10);
    }

    public static List x(PathBuilder pathBuilder, float f, float f7, float f9, float f10) {
        pathBuilder.reflectiveCurveToRelative(f, f7, f9, f10);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }
}
