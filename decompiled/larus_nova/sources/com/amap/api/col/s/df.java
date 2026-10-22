package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f26558a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f26559b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f26560c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference<da> f26561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f26562e;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static int f26563a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static int f26564b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static int f26565c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f26566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private de f26567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f26568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<de> f26569g;

        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_col_s_df$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_col_s_df$a__run$___twin___() {
            int r100 = this.f26568f;
            if (r100 != 1) goto L29;
        L25:
            th = move-exception;
            cg.c(th, "stm", "as");
            return;
        L5:
            if (this.f26566d != null) goto L7;
            return;
        L7:
            if (this.f26567e != null) goto L10;
            return;
        L10:
            monitor-enter(df.class);     // Catch: Throwable -> L25
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L12:
            if (this.f26566d == null) goto L19;
            de r101 = this.f26567e;     // Catch: Throwable -> L21
            if (r101 == null) goto L19;
            df.a(this.f26566d, r101.a());     // Catch: Throwable -> L21
            monitor-exit(df.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(df.class);     // Catch: Throwable -> L21
            return;
        L29:
            if (r100 != 2) goto L83;
            monitor-enter(df.class);     // Catch: Throwable -> L79
        L76:
            th = move-exception;
            throw th;     // Catch: Throwable -> L79
        L33:
            if (this.f26569g != null) goto L35;
        L74:
            monitor-exit(df.class);     // Catch: Throwable -> L76
            return;
        L35:
            if (this.f26566d == null) goto L74;
            byte[] r102 = new byte[0];     // Catch: Throwable -> L76
            ByteArrayOutputStream r103 = null;
            ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Throwable -> L55
            Iterator<de> r105 = this.f26569g.iterator();     // Catch: Throwable -> L53
        L42:
            if (r105.hasNext() == false) goto L46;
            de r106 = r105.next();     // Catch: Throwable -> L53
            if (r106 == null) goto L42;
            r104.write(r106.a());     // Catch: Throwable -> L53
            goto L42
        L46:
            r102 = r104.toByteArray();     // Catch: Throwable -> L53
            r104.close();     // Catch: Throwable -> L49
        L62:
            df.a(this.f26566d, r102);     // Catch: Throwable -> L76
            monitor-exit(df.class);     // Catch: Throwable -> L76
            return;
        L49:
            th = move-exception;
            Throwable r107 = th;
        L51:
            r107.printStackTrace();     // Catch: Throwable -> L76
        L53:
            th = th;
            r103 = r104;
        L103:
            cg.c(th, "stm", "aStB");     // Catch: Throwable -> L65
            if (r103 == null) goto L62;
            r103.close();     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            r107 = th;
            goto L51
        L65:
            th = move-exception;
            if (r103 == null) goto L125;
            r103.close();     // Catch: Throwable -> L70
        L126:
            throw th;     // Catch: Throwable -> L76
        L70:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L76
            throw th;     // Catch: Throwable -> L76
        L125:
            throw th;     // Catch: Throwable -> L76
        L55:
            th = th;
        L79:
            th = move-exception;
            cg.c(th, "stm", "apb");
            return;
        L83:
            if (r100 != 3) goto L127;
        L98:
            th = move-exception;
            cg.c(th, "stm", "usd");
            return;
        L85:
            if (this.f26566d != null) goto L87;
            return;
        L87:
            da r108 = dg.a(df.a());     // Catch: Throwable -> L98
            dg.a(this.f26566d, r108, ce.f26393h, 1000, 307200, "2");     // Catch: Throwable -> L98
            if (r108.f26538g != null) goto L90;
            r108.f26538g = new dh(new dl(this.f26566d, new di(new dm(new Cdo()))));     // Catch: Throwable -> L98
        L90:
            r108.f26539h = BaseConstants.Time.HOUR;     // Catch: Throwable -> L98
            if (TextUtils.isEmpty(r108.f26540i) == false) goto L94;
            r108.f26540i = "cKey";     // Catch: Throwable -> L98
        L94:
            if (r108.f26537f != null) goto L96;
            Context r110 = this.f26566d;     // Catch: Throwable -> L98
            r108.f26537f = new ds(r110, r108.f26539h, r108.f26540i, new dp(r108.f26532a, new dq(r110, df.f26558a, df.b() * 1024, df.f26559b * 1024, "staticUpdate", df.c() * 1024)));     // Catch: Throwable -> L98
        L96:
            db.a(r108);     // Catch: Throwable -> L98
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_col_s_df$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_col_s_df$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, int r101) {
            this.f26566d = r100;
            this.f26568f = r101;
        }

        public a(Context r100, int r101, de r102) {
            this(r100, r101);
            this.f26567e = r102;
        }

        public a(Context r100, int r101, List<de> r102) {
            this(r100, r101);
            this.f26569g = r102;
        }
    }

    public df() {
    }

    public static /* synthetic */ WeakReference a() {
        return f26561d;
    }

    public static /* synthetic */ int b() {
        return f26560c;
    }

    public static /* synthetic */ int c() {
        return f26562e;
    }

    public static void a(Context r100) {
        cg.c().submit(new a(r100, a.f26565c));
    }

    public static /* synthetic */ void a(Context r100, byte[] r101) throws IOException {
        da r102 = dg.a(f26561d);
        dg.a(r100, r102, ce.f26393h, 1000, 307200, "2");
        if (r102.f26536e != null) goto L11;
        r102.f26536e = new cj();
    L11:
        db.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        cg.c(th, "stm", "wts");
    }

    public static synchronized void a(List<de> r100, Context r101) {
        monitor-enter(df.class);
        if (r100 != null) goto L19;
    L14:
        monitor-exit(df.class);
        return;
    L19:
        if (r100.size() == 0) goto L14;
    L17:
        cg.c().submit(new a(r101, a.f26564b, r100));     // Catch: Throwable -> L11
        monitor-exit(df.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(de r100, Context r101) {
        monitor-enter(df.class);
        cg.c().submit(new a(r101, a.f26563a, r100));     // Catch: Throwable -> L7
        monitor-exit(df.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
