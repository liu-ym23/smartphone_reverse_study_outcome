package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class i8 {

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f27444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h8 f27445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f27446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<h8> f27447e;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            int r100 = this.f27446d;
            if (r100 == 1) goto L114;
            ByteArrayOutputStream r101 = null;
            if (r100 != 2) goto L79;
            monitor-enter(i8.class);     // Catch: Throwable -> L75
        L72:
            th = move-exception;
            throw th;     // Catch: Throwable -> L75
        L33:
            if (this.f27447e != null) goto L35;
        L70:
            monitor-exit(i8.class);     // Catch: Throwable -> L72
            return;
        L35:
            if (this.f27444b == null) goto L70;
            byte[] r102 = new byte[0];     // Catch: Throwable -> L72
            ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L52
            Iterator<h8> r104 = this.f27447e.iterator();     // Catch: Throwable -> L50
        L41:
            if (r104.hasNext() == false) goto L45;
            h8 r105 = r104.next();     // Catch: Throwable -> L50
            if (r105 == null) goto L41;
            r103.write(r105.a());     // Catch: Throwable -> L50
            goto L41
        L45:
            r102 = r103.toByteArray();     // Catch: Throwable -> L50
            r103.close();     // Catch: Throwable -> L48
        L101:
        L58:
            i8.a(this.f27444b, r102);     // Catch: Throwable -> L72
            monitor-exit(i8.class);     // Catch: Throwable -> L72
            return;
        L50:
            th = th;
            r101 = r103;
        L115:
            t6.a(th, "stm", "aStB");     // Catch: Throwable -> L61
            if (r101 == null) goto L58;
            r101.close();     // Catch: Throwable -> L48
            goto L101
        L61:
            th = move-exception;
            if (r101 == null) goto L124;
            r101.close();     // Catch: Throwable -> L66
        L125:
            throw th;     // Catch: Throwable -> L72
        L66:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L72
            throw th;     // Catch: Throwable -> L72
        L124:
            throw th;     // Catch: Throwable -> L72
        L52:
            th = th;
        L48:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L72
        L75:
            th = move-exception;
            t6.a(th, "stm", "apb");
            return;
        L79:
            if (r100 != 3) goto L126;
        L98:
            th = move-exception;
            t6.a(th, "stm", "usd");
            return;
        L81:
            if (this.f27444b != null) goto L83;
            return;
        L83:
            d8 r106 = e8.a(null);     // Catch: Throwable -> L98
            Context r107 = this.f27444b;     // Catch: Throwable -> L98
            int r108 = q6.f27894c;     // Catch: Throwable -> L98
            e8.a(r107, r106, "e", 1000, 307200, "2");     // Catch: Throwable -> L98
            if (r106.f27187g != null) goto L88;
            r106.f27187g = new j8(new n8(this.f27444b, new k8(new o8(new q8()))));     // Catch: Throwable -> L98
        L88:
            r106.f27188h = BaseConstants.Time.HOUR;     // Catch: Throwable -> L98
            if (TextUtils.isEmpty(r106.f27189i) == false) goto L92;
            r106.f27189i = "cKey";     // Catch: Throwable -> L98
        L92:
            if (r106.f27186f != null) goto L96;
            Context r110 = this.f27444b;     // Catch: Throwable -> L98
            int r111 = r106.f27188h;     // Catch: Throwable -> L98
            String r112 = r106.f27189i;     // Catch: Throwable -> L98
            String r113 = r106.f27181a;     // Catch: Throwable -> L98
            r106.f27186f = new u8(r110, r111, r112, new r8(30, r113, new s8(r110, false, 20480, 20480, "staticUpdate", 0)));     // Catch: Throwable -> L98
        L96:
            e8.a(r106);     // Catch: Throwable -> L98
            return;
        L126:
            return;
        L114:
        L25:
            th = move-exception;
            t6.a(th, "stm", "as");
            return;
        L5:
            if (this.f27444b != null) goto L7;
            return;
        L7:
            if (this.f27445c != null) goto L10;
            return;
        L10:
            monitor-enter(i8.class);     // Catch: Throwable -> L25
            Context r109 = this.f27444b;     // Catch: Throwable -> L21
            if (r109 == null) goto L19;
            h8 r114 = this.f27445c;     // Catch: Throwable -> L21
            if (r114 == null) goto L19;
            i8.a(r109, r114.a());     // Catch: Throwable -> L21
            monitor-exit(i8.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(i8.class);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        }

        public a(Context r100, int r101) {
            this.f27444b = r100;
            this.f27446d = r101;
        }

        public a(Context r100, int r101, h8 r102) {
            this(r100, r101);
            this.f27445c = r102;
        }

        public a(Context r100, int r101, List<h8> r102) {
            this(r100, r101);
            this.f27447e = r102;
        }
    }

    public i8() {
    }

    public static void a(Context r100) {
        z8.f().d(new a(r100, 3));
    }

    public static void a(Context r100, byte[] r101) throws IOException {
        d8 r102 = e8.a(null);
        r102.f27181a = q6.a(r100, "e");
        r102.f27184d = 1000;
        r102.f27182b = 307200;
        r102.f27183c = "2";
        if (r102.f27185e != null) goto L11;
        r102.f27185e = new g7();
    L11:
        e8.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        t6.a(th, "stm", "wts");
    }

    public static synchronized void a(List<h8> r100, Context r101) {
        monitor-enter(i8.class);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(i8.class);
        return;
    L15:
        if (r100.size() == 0) goto L13;
        z8.f().d(new a(r101, 2, r100));     // Catch: Throwable -> L11
        monitor-exit(i8.class);
        return;
    }

    public static synchronized void a(h8 r100, Context r101) {
        monitor-enter(i8.class);
        z8.f().d(new a(r101, 1, r100));     // Catch: Throwable -> L7
        monitor-exit(i8.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
