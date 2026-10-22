package g3;

import android.content.BroadcastReceiver;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends BroadcastReceiver {
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
            g3.c r4 = g3.c.b()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L55
            java.lang.Object r4 = r4.f2955b
            g3.a r4 = (g3.a) r4
            goto L7d
        L55:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L62
            java.lang.Object r4 = r4.d
            g3.a r4 = (g3.a) r4
            goto L7d
        L62:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L6f
            java.lang.Object r4 = r4.f2956c
            g3.a r4 = (g3.a) r4
            goto L7d
        L6f:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L7c
            java.lang.Object r4 = r4.f2954a
            g3.a r4 = (g3.a) r4
            goto L7d
        L7c:
            r4 = 0
        L7d:
            if (r4 == 0) goto L83
            r0 = 0
            r4.f2950a = r0
        L83:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L91
            g3.c r3 = g3.c.b()
            monitor-enter(r3)
            monitor-exit(r3)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.b.onReceive(android.content.Context, android.content.Intent):void");
    }
}
