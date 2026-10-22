package com.bytedance.android.livesdk.performance.aapleasure;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<g> f154414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function1<? super Integer, Unit> f154415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f154416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static h f154417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Handler f154418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f154419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static double f154420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static float f154421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static float f154422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f154423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final RunnableC2374a f154424k = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.performance.aapleasure.a$a, reason: collision with other inner class name */
    public static final class RunnableC2374a implements Runnable {
        public RunnableC2374a() {
        }

        public static void a() {
            if (a.f154417d != null) goto L7;
            a.f154416c = 2;
            Function1<? super Integer, Unit> r100 = a.f154415b;
            if (r100 == null) goto L44;
            Unit r101 = r100.invoke(2);
            return;
        L44:
            return;
        L7:
            a.f154419f--;
            h r102 = a.a();
            h r103 = a.f154417d;
            if (r103 == null) goto L46;
            Intrinsics.checkNotNullParameter(r103, "startEffect");
            Intrinsics.checkNotNullParameter(r102, "endEffect");
            float r104 = r103.f154445a - r102.f154445a;
            a.f154421h = r104;
            boolean r105 = false;
            float r106 = 0;
            if (r104 > r106) goto L12;
            a.f154421h = -1.0f;
        L12:
            float r107 = r103.f154446b;
            float r108 = (r107 - r102.f154446b) / r107;
            a.f154422i = r108;
            if (r108 > r106) goto L16;
            a.f154422i = -1.0f;
        L18:
            float r109 = r103.f154447c;
            float r110 = r102.f154447c;
            if (r109 <= r110) goto L21;
            a.f154423j = (r109 - r110) / r109;
        L21:
            float r111 = a.f154423j;
            if (r111 > r106) goto L25;
            a.f154423j = -1.0f;
        L27:
            a.f154416c = 2;
            Function1<? super Integer, Unit> r112 = a.f154415b;
            if (r112 == null) goto L31;
            Unit r113 = r112.invoke(2);
        L31:
            if (a.f154421h > r106) goto L33;
        L37:
            if (r105 == false) goto L39;
            return;
        L39:
            if (a.f154419f <= 0) goto L48;
            Handler r114 = a.f154418e;
            if (r114 == null) goto L49;
            r114.postDelayed(a.f154424k, 20000);
            return;
        L49:
            return;
        L48:
            return;
        L33:
            if (a.f154422i <= r106) goto L37;
            if (a.f154423j <= r106) goto L37;
            r105 = true;
            goto L37
        L25:
            if (r111 <= 0.4d) goto L27;
            a.f154423j = 0.4f;
            goto L27
        L16:
            if (r108 <= 0.4d) goto L18;
            a.f154422i = 0.4f;
            goto L18
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
        f154414a = new CopyOnWriteArrayList();
        f154419f = 6;
        f154421h = -1.0f;
        f154422i = -1.0f;
        f154423j = -1.0f;
        f154424k = new RunnableC2374a();
    }

    public static h a() {
        CopyOnWriteArrayList<g> r100 = f154414a;
        int r101 = r100.size();
        Iterator<g> r102 = r100.iterator();
        float r103 = 0.0f;
        float r104 = 0.0f;
        float r105 = 0.0f;
    L4:
        if (r102.hasNext() == false) goto L6;
        g r106 = r102.next();
        r103 = r103 + r106.f154442b;
        r104 = r104 + ((float) r106.f154443c);
        r105 = r105 + r106.f154444d;
        goto L4
    L6:
        float r107 = r101;
        return new h(r103 / r107, r104 / r107, r105 / r107);
    }

    public static void b() {
        if (f154416c != 0) goto L16;
        f154421h = -1.0f;
        f154422i = -1.0f;
        f154423j = -1.0f;
        if (f154418e != null) goto L9;
        f154416c = 2;
        Function1<? super Integer, Unit> r100 = f154415b;
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke(2);
    L9:
        f154417d = a();
        f154419f = 6;
        Handler r102 = f154418e;
        if (r102 == null) goto L12;
        r102.postDelayed(f154424k, 100000);
    L12:
        f154416c = 1;
        Function1<? super Integer, Unit> r103 = f154415b;
        if (r103 == null) goto L17;
        Unit r104 = r103.invoke(1);
        return;
    L17:
        return;
    }
}
