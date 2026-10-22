package com.bytedance.applet.aibridge.health;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nv3.c;
import nv3.e;
import nv3.h;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f191159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f191160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C2775a f191161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static h f191162d;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.health.a$a, reason: collision with other inner class name */
    public static final class C2775a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<String, Unit> f191164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function2<f3.a, String, Unit> f191165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f191166d;

        public C2775a(String r100, e r101, c r102) {
            Intrinsics.checkNotNullParameter(r100, "operationId");
            Intrinsics.checkNotNullParameter(r101, "onSuccess");
            Intrinsics.checkNotNullParameter(r102, "onFailure");
            this.f191163a = r100;
            this.f191164b = r101;
            this.f191165c = r102;
            this.f191166d = SystemClock.elapsedRealtime();
        }
    }

    public a() {
    }

    static {
        f191159a = new a();
        f191160b = new Handler(Looper.getMainLooper());
    }

    public static C2775a c(String r100) {
        C2775a r101 = f191161c;
        if (r101 != null) goto L5;
    L15:
        return null;
    L5:
        if (Intrinsics.areEqual(r101.f191163a, r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L15;
        f191161c = null;
        h r102 = f191162d;
        if (r102 == null) goto L13;
        f191160b.removeCallbacks(r102);
    L13:
        f191162d = null;
        return r101;
    }

    public static void a(String r100, String r101) {
        C2775a r102 = c(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r102.f191165c.invoke(f3.a.f475272m, "Honor health authorization returned no code");
        return;
    L13:
        r102.f191164b.invoke(r101);
        return;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r103 = false;
        goto L11
    }

    public static void b(String r100, f3.a r101, String r102) {
        C2775a r103 = c(r100);
        if (r103 == null) goto L8;
        Function2<f3.a, String, Unit> r104 = r103.f191165c;
        if (r104 == null) goto L9;
        r104.invoke(r101, r102);
        return;
    L9:
        return;
    }
}
