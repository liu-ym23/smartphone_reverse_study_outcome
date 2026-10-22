package com.stepos.openidsdk;

import android.content.BroadcastReceiver;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends BroadcastReceiver {
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
            com.stepos.openidsdk.b.a(r1)
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
            com.stepos.openidsdk.b.a(r3)
            return
        L51:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            com.stepos.openidsdk.b r4 = com.stepos.openidsdk.b.a()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L69
            com.stepos.openidsdk.OpenId r4 = r4.f2766b
            goto L8b
        L69:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L74
            com.stepos.openidsdk.OpenId r4 = r4.f2768d
            goto L8b
        L74:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L7f
            com.stepos.openidsdk.OpenId r4 = r4.f2767c
            goto L8b
        L7f:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L8a
            com.stepos.openidsdk.OpenId r4 = r4.f2765a
            goto L8b
        L8a:
            r4 = 0
        L8b:
            if (r4 == 0) goto L90
            r4.setDataExpired()
        L90:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto Lb1
            java.lang.String r3 = "onOAIDChanged"
            com.stepos.openidsdk.b.a(r3)
            com.stepos.openidsdk.b r3 = com.stepos.openidsdk.b.a()
            monitor-enter(r3)
            com.stepos.openidsdk.IOAIDChangeListener r4 = r3.f2772h     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto Lad
            r4.onChanged()     // Catch: java.lang.Throwable -> Lab
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
            com.stepos.openidsdk.b.a(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.openidsdk.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
