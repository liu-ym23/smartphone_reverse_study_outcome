package E6;

/* loaded from: classes3.dex */
public abstract class i {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
    
        if (kotlin.jvm.internal.k.b(r1.invoke(null, "ro.stepos.use_qcom_vibrate", r3), r5) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.view.View r6) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            android.content.Context r0 = r6.getContext()
            kotlin.jvm.internal.k.c(r0)
            android.content.ContentResolver r1 = r0.getContentResolver()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = "vibrate_on"
            r3 = 1
            int r2 = android.provider.Settings.System.getInt(r1, r2, r3)     // Catch: java.lang.Exception -> L25
            if (r2 == 0) goto L83
            java.lang.String r2 = "haptic_feedback_enabled"
            int r2 = android.provider.Settings.System.getInt(r1, r2, r3)     // Catch: java.lang.Exception -> L25
            if (r2 == 0) goto L83
            java.lang.String r2 = "haptic_feedback_intensity"
            r3 = 2
            int r1 = android.provider.Settings.System.getInt(r1, r2, r3)     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L83
        L25:
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L64
            java.lang.String r2 = "getBoolean"
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L64
            java.lang.Class[] r3 = new java.lang.Class[]{r3, r4}     // Catch: java.lang.Exception -> L64
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch: java.lang.Exception -> L64
            java.lang.String r2 = "ro.stepos.shell_hapticfeedback_motor"
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L64
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}     // Catch: java.lang.Exception -> L64
            r4 = 0
            java.lang.Object r2 = r1.invoke(r4, r2)     // Catch: java.lang.Exception -> L64
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L64
            boolean r2 = kotlin.jvm.internal.k.b(r2, r5)     // Catch: java.lang.Exception -> L64
            if (r2 != 0) goto L5e
            java.lang.String r2 = "ro.stepos.use_qcom_vibrate"
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}     // Catch: java.lang.Exception -> L64
            java.lang.Object r1 = r1.invoke(r4, r2)     // Catch: java.lang.Exception -> L64
            boolean r1 = kotlin.jvm.internal.k.b(r1, r5)     // Catch: java.lang.Exception -> L64
            if (r1 == 0) goto L64
        L5e:
            r0 = 31022(0x792e, float:4.3471E-41)
            r6.performHapticFeedback(r0)
            goto L83
        L64:
            java.lang.String r6 = "android.permission.VIBRATE"
            int r6 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r6)
            if (r6 == 0) goto L6d
            goto L83
        L6d:
            java.lang.Class<android.os.Vibrator> r6 = android.os.Vibrator.class
            java.lang.Object r6 = r0.getSystemService(r6)
            android.os.Vibrator r6 = (android.os.Vibrator) r6
            if (r6 != 0) goto L78
            goto L83
        L78:
            boolean r0 = r6.hasVibrator()
            if (r0 == 0) goto L83
            r0 = 50
            r6.vibrate(r0)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: E6.i.a(android.view.View):void");
    }
}
