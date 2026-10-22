package ba;

import android.content.BroadcastReceiver;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L89
            if (r5 != 0) goto L6
            goto L89
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
            ba.d r4 = ba.d.b()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L53
            ba.a r4 = r4.f3148b
            goto L75
        L53:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L5e
            ba.a r4 = r4.f3150d
            goto L75
        L5e:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L69
            ba.a r4 = r4.f3149c
            goto L75
        L69:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L74
            ba.a r4 = r4.f3147a
            goto L75
        L74:
            r4 = 0
        L75:
            if (r4 == 0) goto L7b
            r0 = 0
            r4.f3141a = r0
        L7b:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L89
            ba.d r3 = ba.d.b()
            monitor-enter(r3)
            monitor-exit(r3)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.c.onReceive(android.content.Context, android.content.Intent):void");
    }
}
