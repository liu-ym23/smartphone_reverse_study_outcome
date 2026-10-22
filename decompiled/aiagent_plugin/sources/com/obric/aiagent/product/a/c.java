package com.obric.aiagent.product.a;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.o.i;
import d.o.k;

/* JADX INFO: compiled from: OsVersionUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "OsVersionUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f18772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final k f18773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f18774d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final k f18775e = null;

    public static /* synthetic */ CharSequence lambda$N3LESQZfodPfU7n9llx96QUJkE0(String r0) {
        return g(r0);
    }

    private c() {
    }

    static {
        f18771a = new c();
        f18772b = "9223372036854775807";
        f18773c = new k("(\\d+\\.\\d+\\.\\d+\\.\\d+)");
        f18774d = new k("(\\d+\\.\\d+\\.\\d+)");
        f18775e = new k("(\\d+\\.\\d+)");
    }

    public final String a(String r4) {
        o.e(r4, "versionStr");
        i r5 = k.a(f18773c, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L7
        if (r5 == null) goto L12;
        return r5.b();
    L12:
        return null;
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "extractFourPartVersion crash", th);
        return null;
    }

    public final String b(String r4) {
        o.e(r4, "versionStr");
        i r5 = k.a(f18774d, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L7
        if (r5 == null) goto L12;
        return r5.b();
    L12:
        return null;
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "extractThreePartVersion crash", th);
        return null;
    }

    public final String c(String r4) {
        o.e(r4, "versionStr");
        String r0 = a(r4);     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        return r0;
    L6:
        String r3 = b(r4);     // Catch: Throwable -> L16
        if (r3 != null) goto L9;
        i r5 = k.a(f18775e, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L16
        if (r5 == null) goto L21;
        String r6 = r5.b();     // Catch: Throwable -> L16
        if (r6 != null) goto L15;
        return "0.0.0.0";
    L15:
        return r6 + ".0.0";
    L21:
        return "0.0.0.0";
    L9:
        return r3 + ".0";
    L16:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "extractOsVersion crash", th);
        return "0.0.0.0";
    }

    public final long d(String r13) {
        o.e(r13, "version");
        Long r12 = d.o.o.e(f(p.a((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(c(r13), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$c$N3LESQZfodPfU7n9llx96QUJkE0.INSTANCE, 30, null)));     // Catch: Throwable -> L7
        if (r12 == null) goto L12;
        return r12.longValue();
    L12:
        return 0;
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "convertVersionStringToLong crash", th);
        return 0;
    }

    private static final CharSequence g(String r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(f18771a.e(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String e(String r2) {
        return d.o.o.a(d.o.o.e(r2, 8), 2, '0');
    }

    private final String f(String r7) {
        String r6 = r7;
    L3:
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        int r1 = r6.length();
        String r4 = f18772b;
        if (r1 > r4.length()) goto L14;
        if (r6.length() != r4.length()) goto L15;
        if (r6.compareTo(r4) <= 0) goto L15;
    L14:
        r6 = d.o.o.d(r6, 1);
    L15:
        ILogDepend.Companion.i(TAG, "trimVersionNumberToLongRange: versionNumberString " + r7 + ", trimmedVersion " + r6);
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8.length() != 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L21;
        r8 = "0";
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L6:
        r0 = false;
        goto L7
    }
}
