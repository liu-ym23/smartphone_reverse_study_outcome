package com.obric.matrix.platform.sdk.ones.safecushion.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.io.File;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FlagHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "SafeModeFlagHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33721a = null;

    /* JADX INFO: compiled from: FlagHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f33721a = new a(null);
    }

    public b() {
    }

    public final void a() {
        c.f33722a.a("startSafeModeFlag", "startSafeModeFlag-" + System.currentTimeMillis());
    }

    public final m<Boolean, Long> b() {
        File r1 = c.f33722a.a("startSafeModeFlag");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        a(TAG, "lastStartSafeMode: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        o.c(r2, "startSafeModeFlagFile.name");     // Catch: Exception -> L10
        List r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 2) goto L13;
        long r4 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "lastStartSafeModeTime: " + r4, null, 4, null);     // Catch: Exception -> L10
        return s.a(true, Long.valueOf(r4));
    L13:
        return s.a(false, -1L);
    }

    public final void a(String r3) {
        o.e(r3, "mode");
        c.f33722a.a("startSafeModeProcess", "startSafeModeProcess-" + r3 + '-' + System.currentTimeMillis());
    }

    public final void b(String r4) {
        o.e(r4, "mode");
        File r3 = c.f33722a.a("safeModeFlag");
        if (r3 != null) goto L5;
    L8:
        c.f33722a.a("safeModeFlag", "safeModeFlag-" + r4 + "-init-" + System.currentTimeMillis());
        return;
    L5:
        if (r3.exists() == false) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "markOpenSafeModePage: already marked, skip", null, 4, null);
    }

    public final m<String, Long> c() {
        File r1 = c.f33722a.a("startSafeModeProcess");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        a(TAG, "lastStartSafeModeProcessInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        o.c(r2, "startSafeModeProcessFile.name");     // Catch: Exception -> L10
        List r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 3) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        long r0 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(2), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "lastStartSafeModeProcessInfo mode:" + r4 + ",startTime:" + r0, null, 4, null);     // Catch: Exception -> L10
        return s.a(r4, Long.valueOf(r0));
    L13:
        return s.a(null, -1L);
    }

    public final m<String, Long> d() {
        File r1 = c.f33722a.a("safeModeFlag");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        a(TAG, "lastStartSafeModeFlagInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        o.c(r2, "safeModeFlogFile.name");     // Catch: Exception -> L10
        List r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 4) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        long r0 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(3), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "lastStartSafeModeFlagInfo mode:" + r4 + ",startTime:" + r0, null, 4, null);     // Catch: Exception -> L10
        return s.a(r4, Long.valueOf(r0));
    L13:
        return s.a(null, -1L);
    }

    public final String e() {
        return c.f33722a.a("safeModeFlag", 4, 1);
    }

    public final void b(String r11, String r12) {
        o.e(r11, "mode");
        o.e(r12, "state");
        List r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "updateSafeModeState mode:" + r11 + ",state:" + r12, null, 4, null);     // Catch: Exception -> L19
        File r1 = c.f33722a.a("safeModeFlag");     // Catch: Exception -> L19
        if (r1 == null) goto L8;
        String r4 = r1.getName();     // Catch: Exception -> L19
        if (r4 == null) goto L8;
        r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L19
    L8:
        boolean r5 = false;
        if (r3 == null) goto L14;
        if (r3.size() != 4) goto L14;
        r5 = true;
    L14:
        if (r5 == true) goto L16;
        new File(c.f33722a.a(), "safeModeFlag-" + r11 + '-' + r12 + '-' + System.currentTimeMillis()).createNewFile();     // Catch: Exception -> L19
        return;
    L16:
        c.f33722a.a(r1, new File(c.f33722a.a(), "safeModeFlag-" + r11 + '-' + r12 + '-' + ((String) ZeusTransformUtils.preCheckCast(r3.get(3), String.class, "com.obric.aiagent.plugin"))));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "updateSafeModeState error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final boolean c(String r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (o.a("repair", r1) == true) goto L9;
        if (o.a("upgrade", r1) == true) goto L9;
        return false;
    }

    public final boolean f() {
        File r1 = c.f33722a.a("safeModeFlag");
        if (r1 != null) goto L5;
    L17:
        return false;
    L5:
        if (r1.exists() == false) goto L17;
        String r2 = r1.getName();     // Catch: Exception -> L15
        o.c(r2, "safeModeFlogFile.name");     // Catch: Exception -> L15
        List r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L15
        if (r3.size() != 4) goto L17;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(2), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "lastStartSafeModeFlagInfo mode:" + r5 + ",state:" + r4, null, 4, null);     // Catch: Exception -> L15
        if (o.a("upgrade", r5) == false) goto L20;
        if (o.a("finish", r4) == true) goto L14;
        return false;
    L14:
        return true;
    L20:
        return false;
    L15:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "lastStartSafeModeFlagInfo error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L17
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
