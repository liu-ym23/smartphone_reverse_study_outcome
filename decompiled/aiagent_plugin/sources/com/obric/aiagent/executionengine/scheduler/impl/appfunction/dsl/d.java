package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: AppFunctionSignatureVerifier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "AppFuncSignVerifier";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18186a = null;

    static {
        f18186a = new d();
    }

    public static /* synthetic */ CharSequence lambda$hBFsfdad3NgX9p8F6KAadzj7iSE(byte r0) {
        return a(r0);
    }

    private d() {
    }

    public final boolean a(String r8, List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "packageName");
        boolean r0 = true;
        if (r10 == null) goto L11;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r3 = r12.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L12:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        return true;
    L21:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        r6.add(f18186a.b((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin")));
        goto L23
    L25:
        HashSet r16 = p.n((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        List<String> r7 = a(r8);
        if (r7.isEmpty() == false) goto L29;
        ILogDepend.Companion.w(TAG, "no signatures for pkg=" + r8 + ", deny");
        return false;
    L29:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L32;
    L34:
        Iterator r18 = r17.iterator();
    L36:
        if (r18.hasNext() == false) goto L33;
        if (r16.contains((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L36;
    L39:
        if (r0 == true) goto L41;
        ILogDepend.Companion.w(TAG, "signature not authorized: pkg=" + r8 + ", actual=" + r7);
    L41:
        return r0;
    L33:
        r0 = false;
        goto L39
    L32:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L34;
    L15:
        if (r4.isEmpty() == true) goto L18;
        r5 = false;
        goto L19
    L11:
        r13 = null;
        goto L12
    }

    private final List<String> a(String r18) {
        PackageManager r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();     // Catch: Throwable -> L24
        int r5 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L16;
        SigningInfo r3 = r2.getPackageInfo(r18, 134217728).signingInfo;     // Catch: Throwable -> L24
        boolean r4 = true;
        if (r3 != null) goto L8;
    L10:
        r4 = false;
    L11:
        if (r4 == false) goto L13;
        Signature[] r6 = r3.getApkContentsSigners();     // Catch: Throwable -> L24
    L17:
        if (r6 != null) goto L19;
        r6 = new Signature[0];     // Catch: Throwable -> L24
    L19:
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        int r8 = r6.length;     // Catch: Throwable -> L24
    L20:
        if (r5 >= r8) goto L22;
        byte[] r9 = MessageDigest.getInstance("SHA-256").digest(r6[r5].toByteArray());     // Catch: Throwable -> L24
        o.c(r9, "digest(...)");     // Catch: Throwable -> L24
        r7.add(i.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$hBFsfdad3NgX9p8F6KAadzj7iSE.INSTANCE, 30, null));     // Catch: Throwable -> L24
        r5 = r5 + 1;     // Catch: Throwable -> L24
        goto L20
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L13:
        if (r3 == null) goto L15;
        r6 = r3.getSigningCertificateHistory();     // Catch: Throwable -> L24
        goto L17
    L15:
        r6 = null;
        goto L17
    L8:
        if (r3.hasMultipleSigners() != true) goto L10;
    L16:
        r6 = r2.getPackageInfo(r18, 64).signatures;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "get signatures failed for " + r18, th);
        return p.b();
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String b(String r13) {
        String r12 = d.o.o.a(d.o.o.a(r13, ":", "", false, 4, null), " ", "", false, 4, null).toLowerCase(Locale.ROOT);
        o.c(r12, "toLowerCase(...)");
        return r12;
    }
}
