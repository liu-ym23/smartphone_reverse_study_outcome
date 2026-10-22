package cn.com.chinatelecom.account;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f24404b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f24405c = 1800000;

    public class a extends f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f24406a;

        public a(Context r100) {
            this.f24406a = r100;
        }

        @Override // cn.com.chinatelecom.account.f0
        public void runTask() {
            String r100 = i.b();     // Catch: Throwable -> L18
            String r101 = i.e(this.f24406a);     // Catch: Throwable -> L18
            q.b(r100).c(r101).b(MultiProcessFileUtils.KEY_DNS).e(r.c(this.f24406a));     // Catch: Throwable -> L18
            String r102 = h0.a(e.f24389f);     // Catch: Throwable -> L18
            String r103 = j.a(r102, r100, 0);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r103) == false) goto L6;
            r103 = j.a(r102, r100, 1);     // Catch: Throwable -> L18
        L6:
            monitor-enter(j.class);     // Catch: Throwable -> L18
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L8:
            if (TextUtils.isEmpty(r103) == true) goto L10;
            j.a(r103);     // Catch: Throwable -> L15
            j.a(System.currentTimeMillis() + j.a());     // Catch: Throwable -> L15
            n r104 = q.b(r100).a(0);     // Catch: Throwable -> L15
            String r105 = "success";
        L11:
            r104.d(r105);     // Catch: Throwable -> L15
            monitor-exit(j.class);     // Catch: Throwable -> L15
            q.a(r100);     // Catch: Throwable -> L18
            return;
        L10:
            r104 = q.b(r100).a(80011);     // Catch: Throwable -> L15
            r105 = h0.a(y.f24496q);     // Catch: Throwable -> L15
        L18:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public j() {
    }

    public static /* synthetic */ long a() {
        return f24405c;
    }

    public static /* synthetic */ long a(long r100) {
        f24404b = r100;
        return r100;
    }

    public static /* synthetic */ String a(String r100) {
        f24403a = r100;
        return r100;
    }

    public static /* synthetic */ String a(String r100, String r101, int r102) {
        return b(r100, r101, r102);
    }

    public static void a(Context r100) {
        if (f24403a == null) goto L5;
        return;
    L5:
        if (r.b() != null) goto L10;
        new e0().a(new a(r100));
        return;
    }

    public static synchronized String b() {
        monitor-enter(j.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (System.currentTimeMillis() < f24404b) goto L7;
    L11:
        monitor-exit(j.class);
        return null;
    L7:
        if (i.c(f24403a) == false) goto L11;
        String r100 = f24403a;     // Catch: Throwable -> L14
        monitor-exit(j.class);
        return r100;
    }

    private static String b(String r100, String r101, int r102) {
        q.b(r101).b(r102);     // Catch: Exception -> L4
        return InetAddress.getByName(r100).getHostAddress();
    L4:
        e = move-exception;
        if (r102 != 0) goto L7;
        StringBuilder r103 = new StringBuilder("first exception: ");
    L8:
        r103.append(e.getMessage());
        String r104 = r103.toString();
        q.b(r101).a(r104);
        return null;
    L7:
        r103 = new StringBuilder("retry exception: ");
        goto L8
    }
}
