package com.baidu.mshield.x0.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.c.c;
import com.baidu.mshield.x0.d.b;
import com.baidu.mshield.x0.d.d;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: com.baidu.mshield.x0.k.a$a, reason: collision with other inner class name */
    public static class C0659a implements com.baidu.mshield.x0.j.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32534a;

        public C0659a(Context r100) {
            this.f32534a = r100;
        }

        @Override // com.baidu.mshield.x0.j.a.b
        public void a(int r100) {
            b.a(this.f32534a, null);
            com.baidu.mshield.x0.c.a.a(this.f32534a);
        }
    }

    public static void a(Context r100, Intent r101) {
    }

    public static void a(Context r100) {
        com.baidu.mshield.x0.j.a.a(r100).a(new C0659a(r100), true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.a(th);
    }

    public static void a(Context r100, String r101) {
        if (r101 != null) goto L26;
        return;
    L26:
        com.baidu.mshield.b.c.a.b("secac=".concat(r101));     // Catch: Throwable -> L23
        int r102 = r101.hashCode();     // Catch: Throwable -> L23
        if (r102 == 1083937949) goto L14;
        if (r102 == 1278732294) goto L11;
    L16:
        byte r103 = -1;
    L17:
        if (r103 == 0) goto L21;
        if (r103 != 1) goto L27;
        c.a(r100);     // Catch: Throwable -> L23
        b.c(r100);     // Catch: Throwable -> L23
        return;
    L27:
        return;
    L21:
        a(r100);     // Catch: Throwable -> L23
        return;
    L11:
        if (r101.equals("com.baidu.mshield.x0.detect.app.fr") == false) goto L16;
        r103 = 1;
        goto L17
    L14:
        if (r101.equals("com.baidu.mshield.x0.timer.pp.action") == false) goto L16;
        r103 = 0;
    L23:
        th = move-exception;
        d.a(th);
    }
}
