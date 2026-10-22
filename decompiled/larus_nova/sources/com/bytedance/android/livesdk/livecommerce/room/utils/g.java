package com.bytedance.android.livesdk.livecommerce.room.utils;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import si2.n;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f151937c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f151938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Runnable> f151939b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f151940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f151941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f151942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f151943d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f151941b.invoke();     // Catch: Throwable -> L7
            if (this.f151942c == false) goto L5;
            this.f151940a.f151939b.remove(this.f151943d);     // Catch: Throwable -> L7
        L5:
            ((ArrayList) this.f151940a.f151938a).remove(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(g r100, Function0 r101, boolean r102, String r103) {
            this.f151940a = r100;
            this.f151941b = r101;
            this.f151942c = r102;
            this.f151943d = r103;
        }
    }

    static {
    }

    public final void a() {
        Iterator<T> r100 = this.f151938a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Runnable r101 = (Runnable) r100.next();
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r101);
        goto L4
    L6:
        ((ArrayList) this.f151938a).clear();
        ((LinkedHashMap) this.f151939b).clear();
    }

    public g() {
        this.f151938a = new ArrayList();
        this.f151939b = new LinkedHashMap();
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Runnable r101 = (Runnable) ((LinkedHashMap) this.f151939b).get(r100);
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r101);
        this.f151939b.remove(r100);
        ((ArrayList) this.f151938a).remove(r101);
        return;
    }

    public static long b(long r100, long r101) {
        if (r101 != 0) goto L5;
    L13:
        return 0;
    L5:
        if (r101 < r100) goto L13;
        if (r101 < 0) goto L13;
        if (r100 < 0) goto L13;
        return (long) (r100 + ((r101 - r100) * Math.random()));
    }

    public final void c(String r110, int r111, boolean r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r113, "action");
        n r100 = EComABUtils.getScatterTimeSetting();
        if (r111 != 1) goto L5;
        int r101 = r100.b();
        int r102 = r100.a();
    L6:
        long r103 = 1000;
        e(r110, b(((long) r101) * r103, ((long) r102) * r103), r112, r113);
        return;
    L5:
        r101 = r100.d();
        r102 = r100.c();
        goto L6
    }

    public final void d(String r100, long r101, long r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r111, "action");
        e(r100, b(r101, r110), true, r111);
    }

    public final void e(String r100, long r101, boolean r102, Function0<Unit> r103) {
        if (r102 == false) goto L6;
        Runnable r104 = (Runnable) ((LinkedHashMap) this.f151939b).get(r100);
        if (r104 == null) goto L6;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r104);
        this.f151939b.remove(r100);
        ((ArrayList) this.f151938a).remove(r104);
    L6:
        b r105 = new b(this, r103, r102, r100);
        ((ArrayList) this.f151938a).add(r105);
        if (r102 == false) goto L9;
        this.f151939b.put(r100, r105);
    L9:
        UtilityKotlinExtentionsKt.f153057b.postDelayed(r105, r101);
    }
}
