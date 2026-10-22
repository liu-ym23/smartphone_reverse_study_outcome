package com.bytedance.android.livesdk;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.j20;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f102981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C1564a f102982h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f102983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f102984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f102985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f102986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f102987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.config.y0.a f102988f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.a$a, reason: collision with other inner class name */
    public static final class C1564a {
        public C1564a() {
        }

        @JvmStatic
        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            List<com.bytedance.android.livesdk.config.y0.a> r101 = j20.f120496a.getValue().b();
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r101.isEmpty() == true) goto L27;
            Iterator<T> r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            Object r103 = r102.next();
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.config.y0.a) r103).a(), r100) == false) goto L9;
        L14:
            com.bytedance.android.livesdk.config.y0.a r104 = (com.bytedance.android.livesdk.config.y0.a) r103;
            if (r104 == null) goto L17;
            int r105 = r104.b();
        L19:
            if (r105 > a.f102981g) goto L26;
            return true;
        L26:
            return false;
        L17:
            r105 = 0;
            goto L19
        L13:
            r103 = null;
            goto L14
        L27:
            return false;
        }

        @JvmStatic
        public static a b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            j20 r101 = j20.f120496a;
            if (r101.getValue().a() == 0) goto L23;
            List<com.bytedance.android.livesdk.config.y0.a> r102 = r101.getValue().b();
            if (r102 == null) goto L15;
            Iterator<T> r103 = r102.iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            Object r104 = r103.next();
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.config.y0.a) r104).a(), r100) == false) goto L9;
        L14:
            com.bytedance.android.livesdk.config.y0.a r105 = (com.bytedance.android.livesdk.config.y0.a) r104;
        L16:
            if (r105 != null) goto L18;
            return null;
        L18:
            return new a(r105);
        L13:
            r104 = null;
            goto L14
        L15:
            r105 = null;
            goto L16
        L23:
            return null;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f102989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f102990b;

        public b(a r100, int r101) {
            this.f102989a = r100;
            this.f102990b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function2<? super Integer, ? super Boolean, Unit> r100 = this.f102989a.f102983a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Unit r101 = r100.invoke(Integer.valueOf(this.f102990b), Boolean.valueOf(this.f102989a.f102984b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        f102982h = new C1564a();
    }

    public a(com.bytedance.android.livesdk.config.y0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f102988f = r100;
        if (f102981g < r100.b()) goto L5;
        boolean r101 = true;
    L6:
        this.f102984b = r101;
        this.f102986d = new Handler(Looper.getMainLooper());
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void a(int r100) {
        Integer r101 = this.f102987e;
        if (r101 == null) goto L24;
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L7:
        if (r102 <= 0) goto L24;
        List<Integer> r103 = this.f102988f.c();
        if (r103 == null) goto L11;
        int r104 = r103.size();
    L12:
        if (r104 <= 0) goto L24;
        List<Integer> r105 = this.f102988f.c();
        if (r105 == null) goto L24;
        Integer r106 = this.f102987e;
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
    L20:
        if (r105.contains(Integer.valueOf(r107)) == true) goto L24;
        this.f102984b = false;
        ALogger.w("BusinessDegradeStrategy", "不包含该场景降级:" + this.f102987e);
        return;
    L18:
        r107 = 0;
        goto L20
    L11:
        r104 = 0;
        goto L12
    L6:
        r102 = 0;
    L24:
        if (r100 < this.f102988f.b()) goto L30;
        int r108 = this.f102985c + 1;
        this.f102985c = r108;
        if (this.f102984b == false) goto L28;
        return;
    L28:
        if (r108 < this.f102988f.d()) goto L33;
        this.f102984b = true;
        ALogger.w("BusinessDegradeStrategy", "onDegrade: " + this.f102988f.a());
        this.f102986d.post(new b(this, r100));
        return;
    L33:
        return;
    L30:
        this.f102985c = 0;
        f102981g = r100;
    }
}
