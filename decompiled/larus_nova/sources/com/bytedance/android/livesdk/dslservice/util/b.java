package com.bytedance.android.livesdk.dslservice.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import yt1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T extends yt1.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<yt1.q, ArrayList<WeakReference<T>>> f122965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DSLMonitor f122966b;

    public b(DSLMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        this.f122966b = r100;
        this.f122965a = new ConcurrentHashMap();
    }

    public final void c(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        Iterator<Map.Entry<yt1.q, ArrayList<WeakReference<T>>>> r101 = this.f122965a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Iterator<T> r102 = r101.next().getValue().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        yt1.k r103 = (yt1.k) ((WeakReference) r102.next()).get();
        if (r103 == null) goto L7;
        r100.invoke(r103);
        goto L7
    }

    public final void a(yt1.q r100, com.bytedance.android.livesdk.dslservice.a r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "component");
        WeakReference<T> r102 = new WeakReference(r101);
        if (this.f122965a.get(r100) != null) goto L5;
        this.f122965a.put(r100, new ArrayList());
    L5:
        ArrayList<WeakReference<T>> r103 = this.f122965a.get(r100);
        if (r103 == null) goto L9;
        r103.add(r102);
        return;
    }

    public final void b(yt1.q r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ArrayList<WeakReference<T>> r102 = this.f122965a.get(r100);
        Object r103 = null;
        if (r102 == null) goto L11;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        if (Intrinsics.areEqual((yt1.k) ((WeakReference) r105).get(), r101) == false) goto L6;
        r103 = r105;
    L10:
        r103 = (WeakReference) r103;
    L11:
        ArrayList<WeakReference<T>> r106 = this.f122965a.get(r100);
        if (r106 == null) goto L18;
        TypeIntrinsics.asMutableCollection(r106).remove(r103);
        return;
    }

    public final void d(yt1.q r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "function");
        StringBuilder r102 = new StringBuilder("refreshTemplate ");
        r102.append(r100.f569037a);
        r102.append(' ');
        ArrayList<WeakReference<T>> r103 = this.f122965a.get(r100);
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.size());
    L6:
        r102.append(r104);
        final String r105 = r102.toString();
        this.f122966b.d(new ComponentShowingMapManager$log$1(r105));
        ArrayList<WeakReference<T>> r106 = this.f122965a.get(r100);
        if (r106 == null) goto L14;
        Iterator<T> r107 = r106.iterator();
    L10:
        if (r107.hasNext() == false) goto L20;
        yt1.k r108 = (yt1.k) ((WeakReference) r107.next()).get();
        if (r108 == null) goto L10;
        r101.invoke(r108);
        goto L10
    L20:
        return;
    L14:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
