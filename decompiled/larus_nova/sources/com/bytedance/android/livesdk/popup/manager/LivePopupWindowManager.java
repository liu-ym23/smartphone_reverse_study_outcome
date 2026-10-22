package com.bytedance.android.livesdk.popup.manager;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import j40.z1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePopupWindowManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f156292d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f156293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<LivePopupInfo> f156294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f156295c;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((LivePopupInfo) r101).f156281e), Integer.valueOf(((LivePopupInfo) r100).f156281e));
        }
    }

    public static final class b {
    }

    static {
        f156292d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LivePopupWindowManager$Companion$livePopupWindowManager$2.INSTANCE);
    }

    public final void c() {
        this.f156293a.clear();
        Iterator<LivePopupInfo> r100 = this.f156294b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a(LivePopupInfo.State.DISMISSED);
        goto L4
    L6:
        this.f156294b.clear();
        Iterator r101 = ((ArrayList) this.f156295c).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((e) r101.next()).c(this);
        goto L8
    L10:
        ((ArrayList) this.f156295c).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        LivePopupInfo r100 = this.f156294b.peek();
        if (r100 != null) goto L6;
        return;
    L6:
        if (((LivePopupInfo.State) r100.f156278b.f64752a) != LivePopupInfo.State.WAITING) goto L25;
        List<e> r101 = this.f156295c;
        if ((r101 instanceof Collection) == true) goto L10;
    L12:
        Iterator r102 = ((ArrayList) r101).iterator();
    L14:
        if (r102.hasNext() == false) goto L18;
        if (((e) r102.next()).a(r100) == true) goto L14;
        boolean r103 = false;
    L19:
        if (r103 == false) goto L26;
        r100.a(LivePopupInfo.State.SHOWING);
        return;
    L26:
        return;
    L18:
        r103 = true;
        goto L19
    L10:
        if (((ArrayList) r101).isEmpty() == false) goto L12;
    }

    public LivePopupWindowManager() {
        this.f156293a = new CompositeDisposable();
        this.f156294b = new PriorityQueue(11, new a());
        this.f156295c = new ArrayList();
    }

    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f156294b.clear();
        List<e> r101 = this.f156295c;
        if (z1.f497331a.getValue().booleanValue() == false) goto L5;
        BackgroundStrategy r102 = new BackgroundStrategy(r100);
        ((ArrayList) r101).add(r102);
    L5:
        ArrayList r103 = (ArrayList) r101;
        r103.add(com.bytedance.android.livesdk.popup.manager.a.f156297b);
        Iterator<T> r104 = this.f156295c.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((e) r104.next()).b(this);
        goto L7
    }

    public final LivePopupInfo a(LivePopupWindow r100, d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "popup");
        Intrinsics.checkNotNullParameter(r101, "showParams");
        LivePopupInfo r103 = new LivePopupInfo(r100, r101, r102);
        if (r100.f156287b != 10) goto L8;
        LivePopupInfo r104 = this.f156294b.peek();
        if (r104 == null) goto L7;
        r104.a(LivePopupInfo.State.DISMISSED);
    L7:
        RxUtilKt.c(r103.f156278b.subscribe(new k(this, r103)), this.f156293a);
        r103.a(LivePopupInfo.State.SHOWING);
    L9:
        return r103;
    L8:
        this.f156294b.add(r103);
        RxUtilKt.c(r103.f156278b.subscribe(new k(this, r103)), this.f156293a);
        d();
        goto L9
    }
}
