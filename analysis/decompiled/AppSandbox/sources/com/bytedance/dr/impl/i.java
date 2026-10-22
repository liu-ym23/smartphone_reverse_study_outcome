package com.bytedance.dr.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.bdtracker.w5;
import com.bytedance.dr.OaidApi;

/* loaded from: classes.dex */
public final class i implements OaidApi {
    public final w5<Boolean> a = new a(this);

    public class a extends w5<Boolean> {
        public a(i iVar) {
        }

        @Override // com.bytedance.bdtracker.w5
        public Boolean a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Meizu";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // com.bytedance.dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.dr.OaidApi.a getOaid(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r6 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r6)
            android.content.ContentResolver r0 = r7.getContentResolver()
            r6 = 0
            java.lang.String r7 = "oaid"
            java.lang.String[] r4 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L42
            r5 = 0
            r2 = 0
            r3 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L42
            if (r7 != 0) goto L1e
            com.bytedance.bdtracker.r.a(r7)
            return r6
        L1e:
            com.bytedance.dr.OaidApi$a r0 = new com.bytedance.dr.OaidApi$a     // Catch: java.lang.Throwable -> L40
            r0.<init>()     // Catch: java.lang.Throwable -> L40
            boolean r1 = r7.isClosed()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L2b
        L29:
            r1 = r6
            goto L3a
        L2b:
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "value"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 < 0) goto L29
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Throwable -> L40
        L3a:
            r0.a = r1     // Catch: java.lang.Throwable -> L40
            com.bytedance.bdtracker.r.a(r7)
            return r0
        L40:
            r0 = move-exception
            goto L44
        L42:
            r0 = move-exception
            r7 = r6
        L44:
            com.bytedance.applog.log.IAppLogLogger r1 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = "getOaid failed"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L55
            r4 = 1
            r1.error(r4, r2, r0, r3)     // Catch: java.lang.Throwable -> L55
            com.bytedance.bdtracker.r.a(r7)
            return r6
        L55:
            r0 = move-exception
            r6 = r0
            com.bytedance.bdtracker.r.a(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.dr.impl.i.getOaid(android.content.Context):com.bytedance.dr.OaidApi$a");
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }
}
