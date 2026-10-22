package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.g;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.lang.reflect.Method;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ObricAppStatusUtility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String TAG = "ObricAppStatusUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f16319b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Uri f16320c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16321d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f16322e = null;
    private static volatile a f;
    private static final am g = null;

    /* JADX INFO: compiled from: ObricAppStatusUtility.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f16323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f16324b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (this.f16323a == r8.f16323a) goto L12;
            return false;
        L12:
            if (this.f16324b == r8.f16324b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16323a.hashCode() * 31) + Long.hashCode(this.f16324b);
        }

        public String toString() {
            return "CachedStatus(status=" + this.f16323a + ", timestamp=" + this.f16324b + ')';
        }

        public a(f r2, long r3) {
            o.e(r2, "status");
            this.f16323a = r2;
            this.f16324b = r3;
        }

        public /* synthetic */ a(f r1, long r2, int r4, h r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = -1;
        L5:
            this(r1, r2);
        }

        public final f a() {
            return this.f16323a;
        }

        public final long b() {
            return this.f16324b;
        }
    }

    private e() {
    }

    static {
        f16318a = new e();
        Uri r0 = Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
        o.c(r0, "parse(...)");
        f16319b = r0;
        Uri r1 = Uri.parse("content://com.larus.nova.privacy.provider/status");
        o.c(r1, "parse(...)");
        f16320c = r1;
        f16321d = "android.permission.MANAGE_ROLE_HOLDERS";
        f16322e = "sys.debug.doubao.obric_fake_default_assist";
        f = new a(f.f16325a, 0, 2, null);
        g = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        e r8 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Bundle r11 = ZeusProviderTransform.call(r10.getContentResolver(), f16319b, "is_login", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        boolean r12 = r11.getBoolean("is_login");     // Catch: Throwable -> L9
    L7:
        Object r13 = n.f(Boolean.valueOf(r12));     // Catch: Throwable -> L9
    L11:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L15;
        a(TAG, "isLogin error: " + r14.getMessage(), r14);
    L15:
        if (n.b(r13) == false) goto L18;
        r13 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        r12 = false;
    L9:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L11
    }

    private final a a() {
        long r0 = System.currentTimeMillis();
        a r4 = f;
        if ((r0 - r4.b()) < 5000) goto L5;
        return null;
    L5:
        if (r4.b() == (-1)) goto L9;
        return r4;
    L9:
        return null;
    }

    public final f a(Context r12, CancellationSignal r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        a r11 = a();
        if (r11 != null) goto L5;
        Cursor r15 = null;
        r15 = ZeusProviderTransform.query(r14.getContentResolver(), f16320c, new String[]{"value"}, null, null, null, r13, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r15 != null) goto L10;
    L15:
        b(TAG, "[Assist-PrivApproval] query failed: cursor is null");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        f r16 = f.f16325a;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L16:
        c(TAG, "[Assist-PrivApproval] query result: " + r16);     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r15 == null) goto L29;
    L18:
        r15.close();
    L29:
        a r17 = new a(r16, System.currentTimeMillis());
        f = r17;
        return r17.a();
    L10:
        if (r15.moveToFirst() == false) goto L15;
        if (r15.getInt(0) != 1) goto L14;
        r16 = f.f16328d;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        goto L16
    L14:
        r16 = f.f16327c;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L19:
        th = move-exception;
        if (r15 == null) goto L33;
        r15.close();
    L33:
        throw th;
    L25:
        e = move-exception;
        a(TAG, "[Assist-PrivApproval] query timeout (" + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r16 = f.f16326b;     // Catch: Throwable -> L19
        if (r15 == null) goto L29;
    L21:
        e = move-exception;
        a(TAG, "[Assist-PrivApproval] query failed (exception, " + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r16 = f.f16325a;     // Catch: Throwable -> L19
        if (r15 == null) goto L29;
    L5:
        return r11.a();
    }

    public final String b(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return "";
    L5:
        RoleManager r2 = (RoleManager) ZeusTransformUtils.preCheckCast(r12.getSystemService("role"), RoleManager.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        return null;
    L9:
        if (o.a("true", d(f16322e, "false")) == false) goto L37;
        return "com.larus.nova";
    L37:
    L34:
        e = move-exception;
        a(TAG, "getSystemDefaultAssistant error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L36:
        return null;
    L13:
        if (r2.isRoleAvailable("android.app.role.ASSISTANT") == false) goto L33;
        String r10 = f16321d;     // Catch: Exception -> L34
        if (r12.checkSelfPermission(r10) == 0) goto L38;
        b(TAG, "fail to get permission: " + r10);     // Catch: Exception -> L34
        return null;
    L38:
        Method r13 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L28 SecurityException -> L30
        r13.setAccessible(true);     // Catch: Exception -> L28 SecurityException -> L30
        Object r14 = r13.invoke(r2, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L28 SecurityException -> L30
        if (ZeusTransformUtils.instanceOf(r14, List.class) == false) goto L21;
        List r15 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28 SecurityException -> L30
    L22:
        if (r15 == null) goto L40;
        String r16 = (String) ZeusTransformUtils.preCheckCast(p.d(r15, 0), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28 SecurityException -> L30
        if (r16 != null) goto L27;
        return "";
    L27:
        return r16;
    L40:
        return "";
    L21:
        r15 = null;
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L34
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L34
        goto L36
    L33:
        return "";
    }

    public final String d(String r8, String r9) {
        o.e(r8, "key");
        o.e(r9, "defaultValue");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        e r7 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Class r10 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r11 = r10.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r10, new Object[]{r8, r9});     // Catch: Throwable -> L5
        o.a(r11, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L5
        Object r12 = n.f((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Object r13 = r9;
        if (n.b(r12) == true) goto L12;
        r13 = r12;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L7
    }

    public final com.obric.aiagent.assistant.utils.a a(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        if (r10 == null) goto L39;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = r11.length() - 1;
        boolean r3 = false;
        int r4 = 0;
        boolean r5 = false;
    L5:
        if (r4 > r1) goto L21;
        if (r5 == true) goto L8;
        int r6 = r4;
    L10:
        if (o.a(r11.charAt(r6), 32) > 0) goto L12;
        boolean r7 = true;
    L13:
        if (r5 == false) goto L14;
        if (r7 == false) goto L21;
        r1 = r1 - 1;
        goto L5
    L14:
        if (r7 == false) goto L15;
        r4 = r4 + 1;
        goto L5
    L15:
        r5 = true;
        goto L5
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = r1;
    L21:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11.subSequence(r4, r1 + 1).toString(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L23;
        r3 = true;
    L23:
        if (r3 == true) goto L39;
        int r12 = r8.getPackageManager().getApplicationEnabledSetting(r10);     // Catch: Exception -> L32 PackageManager.NameNotFoundException -> L35
        a(TAG, "assistState = " + r12);     // Catch: Exception -> L32 PackageManager.NameNotFoundException -> L35
        if (r12 == 0) goto L31;
        if (r12 == 1) goto L31;
        return com.obric.aiagent.assistant.utils.a.f16304b;
    L31:
        return com.obric.aiagent.assistant.utils.a.f16305c;
    L35:
        e = move-exception;
        e.printStackTrace();
        return com.obric.aiagent.assistant.utils.a.f16303a;
    L32:
        e = move-exception;
        e.printStackTrace();
        return com.obric.aiagent.assistant.utils.a.f16303a;
    L39:
        return com.obric.aiagent.assistant.utils.a.f16303a;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
