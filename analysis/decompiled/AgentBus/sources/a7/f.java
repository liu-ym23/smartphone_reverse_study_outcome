package a7;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
public final class f extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L91
            if (r5 != 0) goto L6
            goto L91
        L6:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            r1 = 1
            if (r3 != r1) goto L21
            java.lang.String r3 = "openIdPackage"
            java.lang.String r3 = r5.getStringExtra(r3)
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L38
            goto L37
        L21:
            r2 = 2
            if (r3 != r2) goto L35
            java.lang.String r3 = "openIdPackageList"
            java.util.ArrayList r3 = r5.getStringArrayListExtra(r3)
            if (r3 == 0) goto L38
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = r3.contains(r4)
            goto L38
        L35:
            if (r3 != 0) goto L38
        L37:
            r0 = r1
        L38:
            if (r0 != 0) goto L3b
            return
        L3b:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            a7.g r4 = a7.g.d()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L55
            java.lang.Object r4 = r4.f419h
            a7.a r4 = (a7.a) r4
            goto L7d
        L55:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L62
            java.lang.Object r4 = r4.f421j
            a7.a r4 = (a7.a) r4
            goto L7d
        L62:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L6f
            java.lang.Object r4 = r4.f420i
            a7.a r4 = (a7.a) r4
            goto L7d
        L6f:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L7c
            java.lang.Object r4 = r4.f418g
            a7.a r4 = (a7.a) r4
            goto L7d
        L7c:
            r4 = 0
        L7d:
            if (r4 == 0) goto L83
            r0 = 0
            r4.f399a = r0
        L83:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L91
            a7.g r3 = a7.g.d()
            monitor-enter(r3)
            monitor-exit(r3)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.f.onReceive(android.content.Context, android.content.Intent):void");
    }
}
