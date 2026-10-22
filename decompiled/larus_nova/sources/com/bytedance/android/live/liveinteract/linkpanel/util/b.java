package com.bytedance.android.live.liveinteract.linkpanel.util;

import java.util.Comparator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f75019a = 0;

    public static final class a<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f75020a;

        public a(boolean r100) {
            this.f75020a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            com.bytedance.android.live.liveinteract.linkpanel.util.a r102 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r100;
            if (this.f75020a == false) goto L5;
            int r103 = b.f75019a;
            int r104 = b.b(r102.b());
        L6:
            Integer r105 = Integer.valueOf(r104);
            boolean r106 = this.f75020a;
            c r107 = ((com.bytedance.android.live.liveinteract.linkpanel.util.a) r101).b();
            if (r106 == false) goto L9;
            int r108 = b.b(r107);
        L11:
            return ComparisonsKt.compareValues(r105, Integer.valueOf(r108));
        L9:
            r108 = b.a(r107);
            goto L11
        L5:
            int r109 = b.f75019a;
            r104 = b.a(r102.b());
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.util.b$b, reason: collision with other inner class name */
    public static final class C1178b<T> implements Comparator<T> {
        public C1178b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = b.f75019a;
            return ComparisonsKt.compareValues(Integer.valueOf(b.c(((com.bytedance.android.live.liveinteract.linkpanel.util.a) r100).b())), Integer.valueOf(b.c(((com.bytedance.android.live.liveinteract.linkpanel.util.a) r101).b())));
        }
    }

    public b() {
    }

    static {
    }

    public static final int a(c r100) {
        if ((r100 instanceof c.b) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof c.e) == false) goto L9;
        return 1;
    L9:
        if ((r100 instanceof c.a) == false) goto L12;
        return 2;
    L12:
        if ((r100 instanceof c.AbstractC1179c) == false) goto L15;
        return 3;
    L15:
        if ((r100 instanceof c.d) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static final int b(c r100) {
        if ((r100 instanceof c.b) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof c.a) == false) goto L9;
        return 1;
    L9:
        if ((r100 instanceof c.AbstractC1179c) == false) goto L12;
        return 2;
    L12:
        if ((r100 instanceof c.e) == false) goto L15;
        return 3;
    L15:
        if ((r100 instanceof c.d) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static final int c(c r100) {
        if ((r100 instanceof c.d) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof c.AbstractC1179c) == false) goto L9;
        return 1;
    L9:
        if ((r100 instanceof c.b) == false) goto L12;
        return 2;
    L12:
        if ((r100 instanceof c.e) == false) goto L15;
        return 3;
    L15:
        if ((r100 instanceof c.a) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static List d(List r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "providers");
        return CollectionsKt.sortedWith(CollectionsKt.take(CollectionsKt.sortedWith(r100, new a(r101)), 3), new C1178b());
    }
}
