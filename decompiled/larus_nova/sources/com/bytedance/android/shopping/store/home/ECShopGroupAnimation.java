package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopGroupAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f183534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f183535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f183536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f183537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SortedMap<Integer, a> f183538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Integer, Integer>> f183539f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopGroupAnimation$Direction;", "", "FORWARD", "REVERSE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Direction extends Enum<Direction> {
        public static final Direction FORWARD = null;
        public static final Direction REVERSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f183540a = null;

        static {
            Direction r100 = new Direction("FORWARD", 0);
            FORWARD = r100;
            Direction r101 = new Direction("REVERSE", 1);
            REVERSE = r101;
            f183540a = new Direction[]{r100, r101};
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public static Direction[] values() {
            return (Direction[]) f183540a.clone();
        }

        public Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        int a();

        int b();

        void c(Direction r100);

        void onChange(int r100, float r101);
    }

    public static final class b<T, U> implements BiConsumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f183541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f183542b;

        public b(int r100, Ref.IntRef r101) {
            this.f183541a = r100;
            this.f183542b = r101;
        }

        @Override // java.util.function.BiConsumer
        public final void accept(Object r100, Object r101) {
            a r102 = (a) r101;
            if (Intrinsics.compare(((Integer) r100).intValue(), this.f183541a) >= 0) goto L6;
            this.f183542b.element += r102.a();
            return;
        }
    }

    public final void b() {
        boolean r100 = false;
        this.f183535b = false;
        if (this.f183534a.getValues() != null) goto L5;
        return;
    L5:
        if (this.f183534a.getValues().length != 0) goto L7;
        r100 = true;
    L7:
        if (r100 == true) goto L12;
        this.f183534a.start();
        return;
    }

    public ECShopGroupAnimation() {
        AccelerateDecelerateInterpolator r100 = new AccelerateDecelerateInterpolator();
        Intrinsics.checkNotNullParameter(r100, "interpolator");
        ValueAnimator r101 = new ValueAnimator();
        this.f183534a = r101;
        r101.setDuration(400);
        r101.setInterpolator(r100);
        r101.addUpdateListener(new n(this));
        r101.addListener(new o(this));
        this.f183538e = Collections.synchronizedSortedMap(new TreeMap());
        this.f183539f = new ConcurrentHashMap();
    }

    public final void a(int r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (this.f183538e.containsKey(Integer.valueOf(r100)) == false) goto L13;
        int r102 = this.f183536c;
        a r103 = this.f183538e.get(Integer.valueOf(r100));
        if (r103 == null) goto L7;
        int r104 = r103.a();
    L8:
        this.f183536c = r102 - r104;
        int r105 = this.f183537d;
        a r106 = this.f183538e.get(Integer.valueOf(r100));
        if (r106 == null) goto L11;
        int r107 = r106.b();
    L12:
        this.f183537d = r105 - r107;
        this.f183538e.remove(Integer.valueOf(r100));
        goto L13
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
    L13:
        this.f183538e.put(Integer.valueOf(r100), r101);
        this.f183536c += r101.a();
        this.f183537d += r101.b();
        Ref.IntRef r108 = new Ref.IntRef();
        r108.element = 0;
        this.f183538e.forEach(new b(r100, r108));
        this.f183539f.put(Integer.valueOf(r100), TuplesKt.to(Integer.valueOf(r108.element), Integer.valueOf(r108.element + r101.a())));
        this.f183534a.setIntValues(new int[]{this.f183536c, this.f183537d});
    }
}
