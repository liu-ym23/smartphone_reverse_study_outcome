package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, IWTOTask> f69406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<IWTOTask> f69407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>> f69408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.bytedance.android.live.initialize.a, a> f69409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<IWTOTask> f69410e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Integer, IWTOTask> f69411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, Set<Integer>> f69412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<Integer, Set<Integer>> f69413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CopyOnWriteArrayList<IWTOTask> f69414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f69415e;

        public a(CopyOnWriteArrayList r100) {
            Intrinsics.checkNotNullParameter(r100, "tasks");
            this.f69414d = r100;
            this.f69415e = true;
            LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Object r103 = r102.next();
            r101.put(Integer.valueOf(((IWTOTask) r103).taskID()), r103);
            goto L4
        L6:
            this.f69411a = r101;
            CopyOnWriteArrayList<IWTOTask> r104 = this.f69414d;
            LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
            Iterator<T> r106 = r104.iterator();
        L8:
            if (r106.hasNext() == false) goto L10;
            Pair r107 = TuplesKt.to(Integer.valueOf(((IWTOTask) r106.next()).taskID()), new LinkedHashSet());
            r105.put(r107.getFirst(), r107.getSecond());
            goto L8
        L10:
            this.f69412b = r105;
            CopyOnWriteArrayList<IWTOTask> r108 = this.f69414d;
            LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r108, 10)), 16));
            Iterator<T> r110 = r108.iterator();
        L12:
            if (r110.hasNext() == false) goto L14;
            Pair r111 = TuplesKt.to(Integer.valueOf(((IWTOTask) r110.next()).taskID()), new LinkedHashSet());
            r109.put(r111.getFirst(), r111.getSecond());
            goto L12
        L14:
            this.f69413c = r109;
            Iterator<T> r112 = this.f69414d.iterator();
        L16:
            if (r112.hasNext() == false) goto L28;
            IWTOTask r113 = (IWTOTask) r112.next();
            if ((r113 instanceof IWTOSingleTask) == false) goto L16;
            Map<Integer, Set<Integer>> r114 = this.f69412b;
            LinkedHashMap r115 = (LinkedHashMap) r114;
            Set r116 = (Set) r115.get(Integer.valueOf(r113.taskID()));
            if (r116 == null) goto L22;
            r116.addAll(((IWTOSingleTask) r113).taskDependencies());
        L22:
            Iterator<T> r117 = ((IWTOSingleTask) r113).taskDependencies().iterator();
        L24:
            if (r117.hasNext() == false) goto L16;
            int r118 = ((Number) r117.next()).intValue();
            Map<Integer, Set<Integer>> r119 = this.f69413c;
            LinkedHashMap r120 = (LinkedHashMap) r119;
            Set r121 = (Set) r120.get(Integer.valueOf(r118));
            if (r121 == null) goto L24;
            r121.add(Integer.valueOf(r113.taskID()));
            goto L24
        }

        public final boolean a(IWTOTask r100, Set<Integer> r101, List<Integer> r110, List<Integer> r111) {
            r101.add(Integer.valueOf(r100.taskID()));
            ArrayList r102 = (ArrayList) r110;
            r102.add(Integer.valueOf(r100.taskID()));
            ArrayList r103 = (ArrayList) r111;
            r103.add(Integer.valueOf(r100.taskID()));
            Set r104 = (Set) ((LinkedHashMap) this.f69412b).get(Integer.valueOf(r100.taskID()));
            if (r104 == null) goto L6;
            Iterator r105 = r104.iterator();
            if (r105 == null) goto L6;
        L8:
            if (r105.hasNext() == false) goto L22;
            int r106 = ((Number) r105.next()).intValue();
            if (r101.contains(Integer.valueOf(r106)) == false) goto L11;
            if (r102.contains(Integer.valueOf(r106)) == false) goto L8;
            r103.add(Integer.valueOf(r106));
            return true;
        L11:
            IWTOTask r107 = (IWTOTask) ((LinkedHashMap) this.f69411a).get(Integer.valueOf(r106));
            if (r107 == null) goto L17;
            if (a(r107, r101, r110, r111) == false) goto L8;
            return true;
        L17:
            throw new RuntimeException(r100.taskID() + " 依赖的任务(" + r106 + ")不存在");
        L22:
            r102.remove(Integer.valueOf(r100.taskID()));
            if (r103.size() <= 0) goto L25;
            boolean r108 = true;
        L26:
            if (r108 == true) goto L29;
            r111 = null;
        L29:
            if (r111 == null) goto L31;
            ((Number) ListProtector.remove(r111, r111.size() - 1)).intValue();
        L31:
            return false;
        L25:
            r108 = false;
        L6:
            r105 = new ArrayList().listIterator();
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends IWTOTask> r100) {
        Intrinsics.checkNotNullParameter(r100, "mInitTaskList");
        this.f69410e = r100;
        this.f69406a = new ConcurrentHashMap();
        this.f69407b = new CopyOnWriteArrayList();
        this.f69408c = new ConcurrentHashMap();
        this.f69409d = new LinkedHashMap();
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        IWTOTask r102 = (IWTOTask) r101.next();
        if (this.f69408c.get(r102.taskExecutePeriod()) != null) goto L8;
        this.f69408c.put(r102.taskExecutePeriod(), new CopyOnWriteArrayList());
    L8:
        CopyOnWriteArrayList<IWTOTask> r103 = this.f69408c.get(r102.taskExecutePeriod());
        if (r103 == null) goto L11;
        r103.add(r102);
    L11:
        this.f69406a.put(Integer.valueOf(r102.taskID()), r102);
        goto L4
    L12:
        Iterator<Map.Entry<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>>> r104 = this.f69408c.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        Map.Entry<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>> r105 = r104.next();
        this.f69409d.put(r105.getKey(), new a(r105.getValue()));
        goto L14
    }

    public final List<IWTOTask> a(com.bytedance.android.live.initialize.a r110) {
        Intrinsics.checkNotNullParameter(r110, "period");
        ArrayList r100 = new ArrayList();
        CopyOnWriteArrayList<IWTOTask> r111 = this.f69408c.get(r110);
        if (r111 == null) goto L66;
        ArrayList r101 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L5:
        boolean r102 = false;
        if (r112.hasNext() == false) goto L12;
        Object r103 = r112.next();
        if (c.a((IWTOTask) r103).f69393a != WTOTaskStatus.IDLE) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L5;
        r101.add(r103);
        goto L5
    L12:
        Iterator r113 = r101.iterator();
    L14:
        if (r113.hasNext() == false) goto L16;
        IWTOTask r104 = (IWTOTask) r113.next();
        IWTOLogger r105 = ya0.a.f567013a;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("taskBusiness", r104.taskBusinessInfo());
        Unit r107 = Unit.INSTANCE;
        ya0.a.a("getExecutableTask Filter First Time", r106.toString());
        goto L14
    L16:
        ArrayList r114 = new ArrayList();
        Iterator r108 = r101.iterator();
    L18:
        if (r108.hasNext() == false) goto L43;
        Object r109 = r108.next();
        IWTOTask r115 = (IWTOTask) r109;
        if ((r115 instanceof IWTORepeatableTask) == false) goto L22;
    L40:
        boolean r116 = true;
    L41:
        if (r116 == false) goto L18;
        r114.add(r109);
        goto L18
    L22:
        if ((r115 instanceof IWTOSingleTask) == false) goto L39;
        IWTOSingleTask r117 = (IWTOSingleTask) r115;
        List<Integer> r118 = r117.taskDependencies();
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L25:
        if (r120.hasNext() == false) goto L37;
        Object r121 = r120.next();
        int r122 = ((Number) r121).intValue();
        IWTOTask r123 = this.f69406a.get(Integer.valueOf(r122));
        if (r123 == null) goto L29;
        WTOTaskStatus r124 = c.a(r123).f69393a;
    L31:
        if (r124 != WTOTaskStatus.FINISHED) goto L33;
        boolean r125 = true;
    L34:
        if (r125 == false) goto L25;
        r119.add(r121);
        goto L25
    L33:
        r125 = false;
        goto L34
    L29:
        r124 = null;
        goto L31
    L37:
        if (r119.size() == r117.taskDependencies().size()) goto L40;
    L39:
        r116 = false;
        goto L41
    L43:
        Iterator r126 = r114.iterator();
    L45:
        if (r126.hasNext() == false) goto L48;
        IWTOTask r127 = (IWTOTask) r126.next();
        IWTOLogger r128 = ya0.a.f567013a;
        LinkedHashMap r129 = new LinkedHashMap();
        r129.put("taskBusiness", r127.taskBusinessInfo());
        Unit r130 = Unit.INSTANCE;
        ya0.a.a("getExecutableTask Filter Second Time", r129.toString());
        goto L45
    L48:
        return r114;
    L66:
        return r100;
    }
}
