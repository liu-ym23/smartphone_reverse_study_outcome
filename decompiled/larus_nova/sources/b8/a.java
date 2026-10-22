package b8;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<c> f17993b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<d> f17994c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Runnable f17995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f17996e = null;

    /* JADX INFO: renamed from: b8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17997a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LogLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LogLevel.DEBUG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f17997a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f17998a = null;

        /* JADX INFO: renamed from: b8.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0278a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List<d> f17999a;

            public RunnableC0278a(List<d> r100) {
                this.f17999a = r100;
            }

            public final void a() {
                Iterator<T> r100 = this.f17999a.iterator();
            L4:
                if (r100.hasNext() == false) goto L15;
                d r101 = (d) r100.next();
                a r102 = a.f17992a;
                b8.b r103 = r101.f18004a;
                if (r103 == null) goto L8;
                a.b(a.f17992a, r103);
            L8:
                b8.b r104 = r101.f18005b;
                if (r104 == null) goto L11;
                a.c(a.f17992a, r104);
            L11:
                Iterator r105 = ((ArrayList) a.f17993b).iterator();
            L13:
                if (r105.hasNext() == false) goto L4;
                ((c) r105.next()).a();
                goto L13
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f17998a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList r100 = new ArrayList();     // Catch: Throwable -> L4
            List<d> r101 = a.f17994c;     // Catch: Throwable -> L4
            r100.addAll(r101);     // Catch: Throwable -> L4
            ((ArrayList) r101).clear();     // Catch: Throwable -> L4
            Schedulers.single().scheduleDirect(new RunnableC0278a(r100));     // Catch: Throwable -> L4
            a.f17995d = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        f17992a = new a();
        f17993b = new ArrayList();
        f17994c = new ArrayList();
        f17996e = AnnieConfigSettingKeys.LIVE_HYBRID_ALOG_INTERVAL_TIME.a();
    }

    public static void d(b8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        e(new d(null, r100, false, r100.f18000a, 13));
    }

    public static void e(d r100) {
        if (r100.f18007d == false) goto L11;
        Integer r101 = f17996e;
        if (r101.intValue() <= 0) goto L11;
        if (ThreadUtils.b() == false) goto L11;
        ((ArrayList) f17994c).add(r100);
        if (f17995d != null) goto L21;
        b r102 = b.f17998a;
        f17995d = r102;
        ThreadUtils.a().postDelayed(r102, r101.intValue());
        return;
    L21:
        return;
    L11:
        b8.b r103 = r100.f18004a;
        a r104 = f17992a;
        if (r103 == null) goto L14;
        b(r104, r103);
    L14:
        b8.b r105 = r100.f18005b;
        if (r105 == null) goto L17;
        c(r104, r105);
    L17:
        Iterator<T> r106 = f17993b.iterator();
    L19:
        if (r106.hasNext() == false) goto L24;
        ((c) r106.next()).a();
        goto L19
    }

    public static void a(b8.b r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        if (g.f39675g == true) goto L5;
    L7:
        e(new d(r110, null, r111, r110.f18000a, 6));
        return;
    L5:
        if (g.b().f39657a.f522322a == false) goto L7;
        e(new d(r110, r110, r111, r110.f18000a, 4));
    }

    public static final void b(a r100, b8.b r101) {
        r100.getClass();
        LogLevel r102 = r101.f18001b;
        int r103 = C0277a.f17997a[r102.ordinal()];
        String r104 = null;
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L10;
        if (r103 != 3) goto L29;
        d(r101);
        return;
    L29:
        return;
    L10:
        if (r101.f18002c == null) goto L13;
        ((x8.d) Annie.getService$default(x8.d.class, null, 2, null)).e(r101.f18000a, r101.f18002c);
        return;
    L13:
        if (r101.f18003d == null) goto L27;
        x8.d r105 = (x8.d) Annie.getService$default(x8.d.class, null, 2, null);
        String r106 = r101.f18000a;
        String r107 = r101.f18003d;
        Intrinsics.checkNotNull(r107);
        r105.e(r106, r107);
        return;
    L27:
        return;
    L15:
        x8.d r108 = (x8.d) Annie.getService$default(x8.d.class, null, 2, null);
        String r109 = r101.f18000a;
        String r110 = r101.f18003d;
        if (r110 != null) goto L23;
        Throwable r111 = r101.f18002c;
        if (r111 == null) goto L20;
        r104 = r111.getMessage();
    L20:
        if (r104 != null) goto L22;
        r110 = "";
        goto L23
    L22:
        r110 = r104;
    L23:
        r108.i(r109, r110);
    }

    public static final void c(a r100, b8.b r101) {
        r100.getClass();
        if (g.f39675g == true) goto L5;
        return;
    L5:
        if (g.b().f39657a.f522322a == false) goto L10;
        LogLevel r102 = r101.f18001b;
        int r103 = C0277a.f17997a[r102.ordinal()];
        return;
    }
}
