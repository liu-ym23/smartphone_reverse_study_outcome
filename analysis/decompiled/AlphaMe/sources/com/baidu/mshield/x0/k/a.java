package com.baidu.mshield.x0.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.d.b;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.j.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.mshield.x0.k.a$a, reason: collision with other inner class name */
    public static class C0042a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8435a;

        public C0042a(Context context) {
            this.f8435a = context;
        }

        @Override // com.baidu.mshield.x0.j.a.b
        public void a(int i4) {
            b.a(this.f8435a, (com.baidu.mshield.x0.l.a) null);
            com.baidu.mshield.x0.c.a.a(this.f8435a);
        }
    }

    public static void a(Context context, Intent intent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "secac="
            if (r4 != 0) goto L5
            return
        L5:
            java.lang.String r0 = r0.concat(r4)     // Catch: java.lang.Throwable -> L26
            com.baidu.mshield.b.c.a.b(r0)     // Catch: java.lang.Throwable -> L26
            int r0 = r4.hashCode()     // Catch: java.lang.Throwable -> L26
            r1 = 1083937949(0x409b949d, float:4.8618913)
            r2 = 1
            if (r0 == r1) goto L28
            r1 = 1278732294(0x4c37e806, float:4.8209944E7)
            if (r0 == r1) goto L1c
            goto L32
        L1c:
            java.lang.String r0 = "com.baidu.mshield.x0.detect.app.fr"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L32
            r4 = r2
            goto L33
        L26:
            r3 = move-exception
            goto L43
        L28:
            java.lang.String r0 = "com.baidu.mshield.x0.timer.pp.action"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L32
            r4 = 0
            goto L33
        L32:
            r4 = -1
        L33:
            if (r4 == 0) goto L3f
            if (r4 == r2) goto L38
            goto L46
        L38:
            com.baidu.mshield.x0.c.c.a(r3)     // Catch: java.lang.Throwable -> L26
            com.baidu.mshield.x0.d.b.c(r3)     // Catch: java.lang.Throwable -> L26
            goto L46
        L3f:
            a(r3)     // Catch: java.lang.Throwable -> L26
            goto L46
        L43:
            com.baidu.mshield.x0.d.d.a(r3)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.k.a.a(android.content.Context, java.lang.String):void");
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.j.a.a(context).a((a.b) new C0042a(context), true);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
