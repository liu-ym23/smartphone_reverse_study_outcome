package g3;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import f3.C0719a;

/* renamed from: g3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0742e {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0740c f17575a;

    /* renamed from: b, reason: collision with root package name */
    private static EnumC0741d f17576b = EnumC0741d.DEBUG;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f17577c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f17578d;

    /* renamed from: g3.e$a */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private EnumC0741d f17579a;

        /* renamed from: b, reason: collision with root package name */
        private String f17580b;

        /* renamed from: c, reason: collision with root package name */
        private String f17581c;

        /* renamed from: d, reason: collision with root package name */
        private String f17582d;

        /* renamed from: e, reason: collision with root package name */
        private long f17583e;

        public a(EnumC0741d enumC0741d, String str, String str2, long j5, String str3) {
            this.f17579a = enumC0741d;
            this.f17580b = str;
            this.f17581c = str2;
            this.f17583e = j5;
            this.f17582d = str3;
        }

        private String a() {
            return this.f17582d + "|" + this.f17581c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17579a.ordinal() < C0742e.f17576b.ordinal() || C0742e.f17575a == null) {
                return;
            }
            C0742e.f17575a.a(this.f17579a, this.f17580b, a(), this.f17583e);
        }
    }

    static {
        f17578d = false;
        f17578d = C0719a.c() | Q2.a.f4907c;
        HandlerThread handlerThread = new HandlerThread("UsageStats_Logger");
        handlerThread.start();
        f17577c = new Handler(handlerThread.getLooper());
    }

    public static void c(String str, String str2) {
        Log.d("[Cloud]Data", e(str, str2));
        f17577c.post(new a(EnumC0741d.DEBUG, f(str), str2, g(), h()));
    }

    public static void d(String str, String str2) {
        Log.e("[Cloud]Data", e(str, str2));
        f17577c.post(new a(EnumC0741d.ERROR, f(str), str2, g(), h()));
    }

    private static String e(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        return "[" + threadCurrentThread.getName() + "-" + threadCurrentThread.getId() + "][" + str + "] " + str2;
    }

    private static String f(String str) {
        return str;
    }

    private static long g() {
        return Thread.currentThread().getId();
    }

    private static String h() {
        return Thread.currentThread().getName();
    }

    public static void i(String str, String str2) {
        Log.i("[Cloud]Data", e(str, str2));
        f17577c.post(new a(EnumC0741d.INFO, f(str), str2, g(), h()));
    }

    public static void j(InterfaceC0740c interfaceC0740c) {
        f17575a = interfaceC0740c;
    }

    public static void k(String str, String str2) {
        Log.v("[Cloud]Data", e(str, str2));
        f17577c.post(new a(EnumC0741d.VERBOSE, f(str), str2, g(), h()));
    }

    public static void l(String str, String str2) {
        Log.w("[Cloud]Data", e(str, str2));
        f17577c.post(new a(EnumC0741d.WARN, f(str), str2, g(), h()));
    }
}
