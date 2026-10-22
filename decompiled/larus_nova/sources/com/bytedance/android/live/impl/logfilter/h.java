package com.bytedance.android.live.impl.logfilter;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<Pair<Long, Float>>> f69222a;

    public final synchronized List<Float> a() {
        monitor-enter(this);
        List<List<Pair<Long, Float>>> r100 = this.f69222a;     // Catch: Throwable -> L14
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));     // Catch: Throwable -> L14
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L14
    L4:
        if (r102.hasNext() == false) goto L12;
        List r103 = (List) r102.next();     // Catch: Throwable -> L14
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L14
        Iterator r105 = r103.iterator();     // Catch: Throwable -> L14
    L8:
        if (r105.hasNext() == false) goto L10;
        r104.add(Float.valueOf(((Number) ((Pair) r105.next()).getSecond()).floatValue()));     // Catch: Throwable -> L14
        goto L8
    L10:
        r101.add(Float.valueOf((float) CollectionsKt.averageOfFloat(r104)));     // Catch: Throwable -> L14
        goto L4
    L12:
        monitor-exit(this);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    public h() {
        ArrayList r100 = new ArrayList(7);
        int r101 = 0;
    L3:
        if (r101 >= 7) goto L5;
        r100.add(new ArrayList());
        r101 = r101 + 1;
        goto L3
    L5:
        this.f69222a = r100;
    }

    public final synchronized void b(boolean r110, Float... r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r111, "variableValues");     // Catch: Throwable -> L39
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L39
        int r101 = 0;
        if (r110 == false) goto L11;
        int r112 = r111.length;     // Catch: Throwable -> L39
        int r102 = 0;
    L6:
        if (r101 >= r112) goto L37;
        int r103 = r102 + 1;     // Catch: Throwable -> L39
        if (r111[r101] != null) goto L10;
        ((List) ListProtector.get(this.f69222a, r102)).clear();     // Catch: Throwable -> L39
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L10:
        r101 = r101 + 1;     // Catch: Throwable -> L39
        r102 = r103;
    L37:
        monitor-exit(this);
        return;
    L11:
        int r113 = r111.length;     // Catch: Throwable -> L39
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r113) goto L37;
        Float r107 = r111[r105];     // Catch: Throwable -> L39
        int r108 = r106 + 1;     // Catch: Throwable -> L39
        if (r107 == null) goto L16;
        float r109 = r107.floatValue();     // Catch: Throwable -> L39
        ((List) ListProtector.get(this.f69222a, r106)).add(TuplesKt.to(Long.valueOf(r100), Float.valueOf(r109)));     // Catch: Throwable -> L39
    L16:
        Iterable r114 = (Iterable) ListProtector.get(this.f69222a, r106);     // Catch: Throwable -> L39
        if ((r114 instanceof Collection) == true) goto L19;
    L21:
        Iterator r115 = r114.iterator();     // Catch: Throwable -> L39
        int r116 = 0;
    L23:
        if (r115.hasNext() == false) goto L32;
        if (((Number) ((Pair) r115.next()).getFirst()).longValue() > (r100 - ((long) 60000))) goto L27;
        boolean r117 = true;
    L28:
        if (r117 == false) goto L23;
        r116 = r116 + 1;     // Catch: Throwable -> L39
        if (r116 >= 0) goto L23;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L39
        goto L23
    L27:
        r117 = false;
    L32:
        int r118 = 0;
    L33:
        if (r118 >= r116) goto L36;
        ListProtector.remove((List) ListProtector.get(this.f69222a, r106), 0);     // Catch: Throwable -> L39
        r118 = r118 + 1;
        goto L33
    L36:
        r105 = r105 + 1;
        r106 = r108;
        goto L12
    L19:
        if (((Collection) r114).isEmpty() == false) goto L21;
        r116 = 0;
    L39:
        th = move-exception;
        throw th;
    }
}
