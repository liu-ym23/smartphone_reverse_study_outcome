package com.bytedance.bdtracker;

import com.bytedance.applog.log.GlobalLoggerImpl;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class o2 {
    @JvmStatic
    public static final void a(l2 l2Var, long j, String str, int i) {
        if (str == null) {
            str = "";
        }
        x2 x2Var = new x2(j, str, 1L);
        x2Var.a = i;
        if (l2Var != null) {
            ((q2) l2Var).a(x2Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(com.bytedance.bdtracker.l2 r4, java.lang.String r5, java.lang.String r6, long r7) {
        /*
            java.lang.String r0 = "metricsName"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            long r0 = android.os.SystemClock.elapsedRealtime()
            int r2 = r5.hashCode()
            r3 = -73212100(0xfffffffffba2df3c, float:-1.6913596E36)
            if (r2 == r3) goto L27
            r6 = 270071285(0x1018f5f5, float:3.0166193E-29)
            if (r2 == r6) goto L18
            goto L36
        L18:
            java.lang.String r6 = "sdk_init"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L36
            com.bytedance.bdtracker.d3 r5 = new com.bytedance.bdtracker.d3
            long r0 = r0 - r7
            r5.<init>(r0)
            goto L37
        L27:
            java.lang.String r2 = "api_usage"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L36
            com.bytedance.bdtracker.r2 r5 = new com.bytedance.bdtracker.r2
            long r0 = r0 - r7
            r5.<init>(r6, r0)
            goto L37
        L36:
            r5 = 0
        L37:
            if (r5 == 0) goto L40
            if (r4 == 0) goto L40
            com.bytedance.bdtracker.q2 r4 = (com.bytedance.bdtracker.q2) r4
            r4.a(r5)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o2.a(com.bytedance.bdtracker.l2, java.lang.String, java.lang.String, long):void");
    }

    @JvmStatic
    public static final void a(l2 l2Var, Throwable e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        if (l2Var != null) {
            ((q2) l2Var).a(new w2(e));
        }
    }

    @JvmStatic
    public static final void b(l2 l2Var, Throwable e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        try {
            StackTraceElement[] stackTrace = e.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "e.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                String string = stackTraceElement.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "ele.toString()");
                if (StringsKt.startsWith$default(string, "com.bytedance.applog", false, 2, (Object) null) || StringsKt.startsWith$default(string, "com.bytedance.bdtracker", false, 2, (Object) null)) {
                    if (l2Var != null) {
                        ((q2) l2Var).a(new c3(e));
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            GlobalLoggerImpl.global().error("TraceSDKError hasAppLog err", th, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(com.bytedance.bdtracker.l2 r4, java.net.URL r5, long r6, int r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "responseMsg"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            if (r4 == 0) goto L75
            r0 = 0
            if (r5 != 0) goto L10
            goto L1a
        L10:
            java.lang.String r1 = r5.getPath()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L1c
        L1a:
            r1 = r0
            goto L26
        L1c:
            java.lang.String r1 = r5.getPath()
            java.lang.String r2 = "/simulator/"
            boolean r1 = r1.startsWith(r2)
        L26:
            if (r1 != 0) goto L75
            long r1 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.bdtracker.b3 r3 = new com.bytedance.bdtracker.b3
            r3.<init>()
            long r1 = r1 - r6
            r3.e = r1
            r6 = 1
            if (r5 != 0) goto L38
            goto L42
        L38:
            java.lang.String r7 = r5.getPath()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L45
        L42:
            java.lang.String r7 = ""
            goto L5e
        L45:
            java.lang.String r1 = "/"
            boolean r2 = r7.contains(r1)
            if (r2 == 0) goto L5e
            java.lang.String r5 = r5.getPath()
            java.lang.String[] r5 = r5.split(r1)
            if (r5 == 0) goto L5e
            int r1 = r5.length
            if (r1 <= 0) goto L5e
            int r7 = r5.length
            int r7 = r7 - r6
            r7 = r5[r7]
        L5e:
            r3.d = r7
            r5 = 200(0xc8, float:2.8E-43)
            if (r8 != r5) goto L66
            r0 = r6
            goto L6e
        L66:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r3.b = r5
            r3.c = r9
        L6e:
            r3.a = r0
            com.bytedance.bdtracker.q2 r4 = (com.bytedance.bdtracker.q2) r4
            r4.a(r3)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o2.a(com.bytedance.bdtracker.l2, java.net.URL, long, int, java.lang.String):void");
    }
}
