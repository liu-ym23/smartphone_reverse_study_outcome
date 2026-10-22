package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceRegisterParameterFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static final String TAG = "DRParameterFactory";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.deviceregister.a.a.a f37431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f37432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Account f37433c;

    public h() {
    }

    public static com.ss.android.deviceregister.a.a.a a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (g.c() == false) goto L34;
        if (f37431a != null) goto L32;
        monitor-enter(h.class);
    L28:
        th = move-exception;
        throw th;
    L9:
        if (f37431a != null) goto L26;
        if (r5 == null) goto L25;
        if (b(r5) == false) goto L20;
        m r1 = (m) ZeusTransformUtils.preCheckCast(com.ss.android.deviceregister.b.b.a(m.class), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18 Throwable -> L28
        if (r1.b() == false) goto L16;
        r1.c();     // Catch: Exception -> L18 Throwable -> L28
    L16:
        f37431a = r1.d();     // Catch: Exception -> L18 Throwable -> L28
        com.ss.android.common.util.e.b("DRParameterFactory create new user device param provider & NewUserModeManager success");     // Catch: Exception -> L18 Throwable -> L28
    L18:
        com.ss.android.common.util.e.d("DRParameterFactoryclass com.ss.android.deviceregister.newuser.NewUserModeManager not fount");     // Catch: Throwable -> L28
    L20:
        if (f37431a != null) goto L26;
        e r2 = new e(r5, g.k());     // Catch: Throwable -> L28
        f37431a = r2;     // Catch: Throwable -> L28
        if (f37433c == null) goto L26;
        ((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a(f37433c);     // Catch: Throwable -> L28
        goto L26
    L25:
        throw new IllegalArgumentException("context == null");     // Catch: Throwable -> L28
    L26:
        monitor-exit(h.class);     // Catch: Throwable -> L28
    L32:
        return f37431a;
    L34:
        throw new IllegalStateException("please init TeaAgent first");
    }

    public static boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L14:
        com.ss.android.common.util.e.b("DRParameterFactory #isNewUserMode false. context=" + r4 + " isDebugChannel()=" + a());
        return false;
    L5:
        if (a() == false) goto L7;
    L9:
        m r5 = (m) ZeusTransformUtils.preCheckCast(com.ss.android.deviceregister.b.b.a(m.class), m.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L12;
        return false;
    L12:
        return r5.a();
    L7:
        if (g.j() == true) goto L9;
        goto L9
    }

    static boolean a() {
        if (TextUtils.isEmpty(f37432b) == false) goto L6;
        f37432b = com.ss.android.deviceregister.base.v.d();
    L6:
        return "local_test".equals(f37432b);
    }
}
