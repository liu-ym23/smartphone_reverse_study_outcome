package N2;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
public final class e extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto La4
            if (r5 != 0) goto L6
            goto La4
        L6:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "shouldUpdateId, notifyFlag : "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            N2.f.f(r1)
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
            N2.f.f(r3)
            return
        L51:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            N2.f r4 = N2.f.b()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L69
            N2.a r4 = r4.f4235b
            goto L8b
        L69:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L74
            N2.a r4 = r4.f4237d
            goto L8b
        L74:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L7f
            N2.a r4 = r4.f4236c
            goto L8b
        L7f:
            java.lang.String r5 = "udid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L8a
            N2.a r4 = r4.f4234a
            goto L8b
        L8a:
            r4 = 0
        L8b:
            if (r4 == 0) goto L90
            r4.b()
        L90:
            java.lang.String r4 = "oaid"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto La3
            java.lang.String r3 = "onOAIDChanged"
            N2.f.f(r3)
            N2.f r3 = N2.f.b()
            monitor-enter(r3)
            monitor-exit(r3)
        La3:
            return
        La4:
            java.lang.String r3 = "context and intent is null"
            N2.f.f(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
