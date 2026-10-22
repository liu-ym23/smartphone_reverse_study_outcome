package com.obric.apptools.sdk.common;

import android.content.Context;
import com.bytedance.apm.constant.CommonKey;
import com.obric.apptools.sdk.base.log.L;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class AppMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppMetrics f11123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f11124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IMetricsReporter f11126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f11127e = null;

    static {
        f11123a = new AppMetrics();
        f11127e = b.b(AppMetrics$eventCache$2.INSTANCE);
    }

    public AppMetrics() {
    }

    public static /* synthetic */ void e(AppMetrics r10, Event r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r12 = "";
    L5:
        r10.d(r11, r12);
    }

    public static /* synthetic */ String j(AppMetrics r10, Event r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r12 = false;
    L6:
        return r10.i(r11, r12);
    }

    public final Event a(Event r10, String r11, long r12) {
        q.g(r10, "<this>");
        q.g(r11, "key");
        if (r11.length() <= 0) goto L7;
        Long r13 = Long.valueOf(r12);
        r10.g().put(r11, r13);
        return r10;
    L7:
        throw new IllegalArgumentException("key is empty");
    }

    public final Event b(Event r10, String r11, Object r12) {
        q.g(r10, "<this>");
        q.g(r11, "key");
        q.g(r12, CommonKey.KEY_VALUE);
        if (r11.length() <= 0) goto L7;
        r10.f().put(r11, r12);
        return r10;
    L7:
        throw new IllegalArgumentException("key is empty");
    }

    public final String c(Event r10, String r11) {
        return "metrics_event_" + r10.b() + '_' + r10.h() + '_' + r10.a() + '_' + r11;
    }

    public final void d(Event r10, String r11) {
        q.g(r10, "<this>");
        q.g(r11, "eventId");
        long r12 = System.currentTimeMillis();
        Event r13 = (Event) g().remove(c(r10, r11));
        if (r13 != null) goto L6;
        L.f("AppMetrics", "end, event not found, action: " + r10.a() + ", scene: " + r10.h() + ", eventId: " + r11);
        return;
    L6:
        r10.k(r13.i());
        r10.j(r12);
        a(r10, "time_cost", r12 - r10.i());
        IMetricsReporter r14 = f11126d;
        if (r14 == null) goto L10;
        r14.report(r10);
        return;
    }

    public final Event f(String r10, String r11) {
        q.g(r10, "action");
        q.g(r11, "scene");
        String r12 = f11125c;
        if (r12 != null) goto L6;
        q.y("appPackageName");
        r12 = null;
    L6:
        return new Event(r10, r11, r12);
    }

    public final Map g() {
        return (Map) f11127e.getValue();
    }

    public final void h(Context r10, IMetricsReporter r11) {
        q.g(r10, "context");
        q.g(r11, "reporter");
        L.a("AppMetrics", "init");
        f11124b = r10;
        String r12 = r10.getPackageName();
        q.f(r12, "context.packageName");
        f11125c = r12;
        f11126d = r11;
        if (r11 == null) goto L6;
        r11.init(r10);
        return;
    }

    public final String i(Event r10, boolean r11) {
        q.g(r10, "<this>");
        long r12 = System.currentTimeMillis();
        if (r11 == false) goto L5;
        String r13 = UUID.randomUUID().toString();
    L6:
        q.f(r13, "if (needEventId) UUID.ra…UUID().toString() else \"\"");
        String r14 = c(r10, r13);
        if (g().get(r14) == null) goto L9;
        L.f("AppMetrics", "start, event already exists, overwrite! action: " + r10.a() + ", scene: " + r10.h() + ", eventId: " + r13);
    L9:
        Map r15 = g();
        r10.k(r12);
        r15.put(r14, r10);
        return r13;
    L5:
        r13 = "";
        goto L6
    }

    public final void report(@NotNull Event r10) {
        q.g(r10, "<this>");
        long r11 = System.currentTimeMillis();
        r10.k(r11);
        r10.j(r11);
        IMetricsReporter r12 = f11126d;
        if (r12 == null) goto L6;
        r12.report(r10);
        return;
    }
}
