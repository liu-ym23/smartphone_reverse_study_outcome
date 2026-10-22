package com.obric.oui.d.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AndroidLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f35006b;

    public a(String r2, boolean r3) {
        o.e(r2, "baseTag");
        this.f35005a = r2;
        this.f35006b = r3;
    }

    public /* synthetic */ a(String r1, boolean r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    @Override // com.obric.oui.d.a.b.a
    public void a(String r3, int r4, String r5, Throwable r6) {
        o.e(r5, "msg");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        r5 = r3 + "-->" + r5;
    L13:
        if (this.f35006b == false) goto L15;
        r5 = '[' + Thread.currentThread().getName() + "]|" + r5;
    L15:
        if (r4 != 1) goto L17;
        a(this.f35005a, r5);
        return;
    L17:
        if (r4 != 2) goto L19;
        b(this.f35005a, r5);
        return;
    L19:
        if (r4 != 4) goto L21;
        c(this.f35005a, r5);
        return;
    L21:
        if (r4 != 8) goto L23;
        String r2 = this.f35005a;
        if (r6 != null) goto L32;
        d(r2, r5);
        return;
    L32:
        a(r2, r5, r6);
        return;
    L23:
        if (r4 != 16) goto L43;
        String r7 = this.f35005a;
        if (r6 != null) goto L28;
        e(r7, r5);
        return;
    L28:
        b(r7, r5, r6);
        return;
    L43:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
