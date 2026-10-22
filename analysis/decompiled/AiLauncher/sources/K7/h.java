package K7;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
public final class h extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto Lb2
            if (r5 != 0) goto L6
            goto Lb2
        L6:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "shouldUpdateId, notifyFlag : "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            K7.i.f(r1)
            r1 = 1
            if (r3 != r1) goto L32
            java.lang.String r3 = "openIdPackage"
            java.lang.String r3 = r5.getStringExtra(r3)
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L49
            goto L48
        L32:
            r2 = 2
            if (r3 != r2) goto L46
            java.lang.String r3 = "openIdPackageList"
            java.util.ArrayList r3 = r5.getStringArrayListExtra(r3)
            if (r3 == 0) goto L49
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = r3.contains(r4)
            goto L49
        L46:
            if (r3 != 0) goto L49
        L48:
            r0 = r1
        L49:
            if (r0 != 0) goto L51
            java.lang.String r3 = "shouldUpdateId is false"
            K7.i.f(r3)
            return
        L51:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            K7.i r4 = K7.i.c()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L69
            K7.b r4 = r4.f4121b
            goto L8b
        L69:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L74
            K7.b r4 = r4.f4123d
            goto L8b
        L74:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L7f
            K7.b r4 = r4.f4122c
            goto L8b
        L7f:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L8a
            K7.b r4 = r4.f4120a
            goto L8b
        L8a:
            r4 = 0
        L8b:
            if (r4 == 0) goto L90
            r4.b()
        L90:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto Lb1
            java.lang.String r3 = "onOAIDChanged"
            K7.i.f(r3)
            K7.i r3 = K7.i.c()
            monitor-enter(r3)
            K7.a r4 = r3.f4127h     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto Lad
            r4.a()     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
            return
        Lab:
            r4 = move-exception
            goto Laf
        Lad:
            monitor-exit(r3)
            return
        Laf:
            monitor-exit(r3)
            throw r4
        Lb1:
            return
        Lb2:
            java.lang.String r3 = "context and intent is null"
            K7.i.f(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K7.h.onReceive(android.content.Context, android.content.Intent):void");
    }
}
