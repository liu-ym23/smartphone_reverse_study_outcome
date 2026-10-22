package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTracingMonitor.EventType f59423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f59425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f59426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f59427f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L18;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f59422a, r101.f59422a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59423b, r101.f59423b) == true) goto L10;
        return false;
    L10:
        if (this.f59424c == r101.f59424c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f59425d, r101.f59425d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f59426e, r101.f59426e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f59427f, r101.f59427f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f59422a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveTracingMonitor.EventType r104 = this.f59423b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f59424c) * 31;
        JSONObject r107 = this.f59425d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f59426e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        JSONObject r113 = this.f59427f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformMonitorEvent(service=" + this.f59422a + ", eventType=" + this.f59423b + ", statusCode=" + this.f59424c + ", category=" + this.f59425d + ", metric=" + this.f59426e + ", extra=" + this.f59427f + ")";
    }

    public final void c() {
        ALogger.d("OpenPlatformMonitorV2", "\n Service: " + this.f59422a + " statusCode: " + this.f59424c + " \n Category: " + this.f59425d + " \n Metric: " + this.f59426e + "  \n Extra: " + this.f59427f);
        LiveTracingMonitor.e(this.f59422a, LiveTracingMonitor.EventModule.OPEN_PLATFORM, this.f59423b, this.f59425d, this.f59426e, this.f59427f);
    }

    public final void a(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        r100.invoke(this.f59425d);
    }

    public final void b(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        r100.invoke(this.f59426e);
    }

    public g(String r100, LiveTracingMonitor.EventType r101, int r102) {
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r103, "category");
        Intrinsics.checkNotNullParameter(r104, "metric");
        Intrinsics.checkNotNullParameter(r105, "extra");
        this.f59422a = r100;
        this.f59423b = r101;
        this.f59424c = r102;
        this.f59425d = r103;
        this.f59426e = r104;
        this.f59427f = r105;
    }
}
