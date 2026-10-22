package com.bytedance.android.ec.store.common.bubble;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleShowStrategy f48215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<com.bytedance.android.ec.store.common.bubble.a, d>> f48216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f48218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48219e;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((com.bytedance.android.ec.store.common.bubble.a) ((Pair) r100).getFirst(), (com.bytedance.android.ec.store.common.bubble.a) ((Pair) r101).getFirst());
        }
    }

    public final void d() {
        if (((ArrayList) this.f48216b).isEmpty() == false) goto L5;
        return;
    L5:
        if (this.f48215a == BubbleShowStrategy.ALL_ONCE) goto L14;
        Pair r100 = (Pair) CollectionsKt.firstOrNull(this.f48216b);
        List<Pair<com.bytedance.android.ec.store.common.bubble.a, d>> r101 = this.f48216b;
        if (r101 == null) goto L12;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public c() {
        this.f48215a = BubbleShowStrategy.ONLY_ONE_ONCE;
        this.f48216b = new ArrayList();
        this.f48218d = new Handler(Looper.getMainLooper());
    }

    public static void e(c r100) {
        if (r100.f48217c == false) goto L11;
        Iterator r101 = ((ArrayList) r100.f48216b).iterator();
    L7:
        if (r101.hasNext() == false) goto L17;
        d r102 = (d) ((Pair) r101.next()).getSecond();
        if (r102 == null) goto L7;
        r102.b();
        goto L7
    L17:
        return;
    }

    public final void b(BubbleShowStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "showStrategy");
        if (((ArrayList) this.f48216b).isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r101 = (ArrayList) this.f48216b;
        if (r101.size() <= 1) goto L8;
        CollectionsKt.sortWith(r101, new a());
    L8:
        int r102 = b.f48214a[r100.ordinal()];
        if (r102 != 1) goto L11;
        Pair r103 = (Pair) CollectionsKt.firstOrNull(this.f48216b);
        if (r103 == null) goto L34;
        d r104 = (d) r103.getSecond();
        if (r104 == null) goto L35;
        r104.b();
        return;
    L35:
        return;
    L34:
        return;
    L11:
        if (r102 != 2) goto L13;
        e(this);
        return;
    L13:
        if (r102 != 3) goto L36;
        Iterator r105 = ((ArrayList) this.f48216b).iterator();
    L17:
        if (r105.hasNext() == false) goto L37;
        d r106 = (d) ((Pair) r105.next()).getSecond();
        if (r106 == null) goto L17;
        r106.b();
        goto L17
    L37:
        return;
    }

    public static void c(final c r100, long r101) {
        BubbleShowStrategy r102 = BubbleShowStrategy.ONLY_ONE_ONCE;
        Intrinsics.checkNotNullParameter(r102, "showStrategy");
        if (r102 != BubbleShowStrategy.ONE_BY_ONE) goto L5;
        boolean r103 = true;
    L6:
        r100.f48217c = r103;
        r100.f48215a = r102;
        Lazy r104 = ECTaskManager.f48688b;
        ECTaskManager.a.a().a(r101, TaskPriority.AFTER_FIRST_SCREEN, new ECBubbleController$bubbleTask$1(r100));
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void a(com.bytedance.android.ec.store.common.bubble.a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "bubbleType");
        Intrinsics.checkNotNullParameter(r100, "bubbleType");
        List<Pair<com.bytedance.android.ec.store.common.bubble.a, d>> r102 = this.f48216b;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = ((ArrayList) r102).iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((com.bytedance.android.ec.store.common.bubble.a) ((Pair) r103.next()).getFirst(), r100) == false) goto L9;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return;
    L16:
        List<Pair<com.bytedance.android.ec.store.common.bubble.a, d>> r105 = this.f48216b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new Pair(r100, r101));
        if (this.f48219e == true) goto L19;
        return;
    L19:
        if (((ArrayList) this.f48216b).size() != 1) goto L30;
        Pair r107 = (Pair) CollectionsKt.firstOrNull(this.f48216b);
        if (r107 == null) goto L31;
        d r108 = (d) r107.getSecond();
        if (r108 == null) goto L32;
        r108.b();
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r104 = false;
        goto L14
    L5:
        if (((ArrayList) r102).isEmpty() == false) goto L7;
        goto L7
    }
}
