package com.bytedance.android.ec.hybrid.card.event;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.service.IECEventCenterService;
import com.bytedance.common.utility.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/event/ECEventCenterSerivceDefaultImpl;", "Lcom/bytedance/android/ec/hybrid/service/IECEventCenterService;", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEventCenterSerivceDefaultImpl implements IECEventCenterService {
    public ECEventCenterSerivceDefaultImpl() {
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = ECEventCenterImpl.f46474a;
        Intrinsics.checkNotNullParameter(r100, "event");
        long r102 = System.currentTimeMillis();
        HashSet r103 = new HashSet();
        Lazy r104 = ECEventCenterImpl.f46478e;
        if (((Number) r104.getValue()).intValue() > 0) goto L5;
    L6:
        Iterator r105 = ECEventCenterImpl.b().iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        b r106 = (b) r105.next();
        if (ECEventCenterImpl.d(r106, Long.valueOf(r102)) == true) goto L8;
        r103.add(r106);
        goto L8
    L12:
        ECEventCenterImpl.b().removeAll(r103);
        ECEventCenterImpl.f46477d = r102;
    L14:
        if (ECEventCenterImpl.f46474a == false) goto L21;
        List<String> r107 = ECEventCenterImpl.f46476c;
        if (r107 == null) goto L21;
        if (r107.contains(r100.f46482a) == true) goto L22;
        ECEventCenterImpl.b().add(r100);
    L22:
        CopyOnWriteArrayList r108 = (CopyOnWriteArrayList) ECEventCenterImpl.c().get(r100.f46482a);
        if (r108 != null) goto L25;
    L34:
        Lazy r109 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.d.a.f47465b, "there are no subscribers of " + r100.f46482a);
        return;
    L25:
        if ((true ^ r108.isEmpty()) == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L34;
        Iterator r110 = r108.iterator();
    L32:
        if (r110.hasNext() == false) goto L42;
        ECEventCenterImpl.a(r100, (f) r110.next());
        goto L32
    L42:
        return;
    L21:
        ECEventCenterImpl.b().add(r100);
        goto L22
    L5:
        if ((r102 - ECEventCenterImpl.f46477d) <= ((Number) r104.getValue()).intValue()) goto L14;
        goto L6
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void c(Function1<? super f, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        boolean r101 = ECEventCenterImpl.f46474a;
        Intrinsics.checkNotNullParameter(r100, "condition");
        Iterator r102 = ECEventCenterImpl.c().values().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102.next();
        LinkedHashSet r104 = new LinkedHashSet();
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        f r106 = (f) r105.next();
        if (r100.invoke(r106).booleanValue() == false) goto L7;
        r104.add(r106);
        Logger.d("ECEventCenter", "clearSubscriber, subscriber = " + r106);
        goto L7
    L12:
        if ((!r104.isEmpty()) == false) goto L4;
        r103.removeAll(r104);
        goto L4
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void d(boolean r100, List<String> r101) {
        ECEventCenterImpl.f46474a = r100;
        ECEventCenterImpl.f46476c = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void f(f r100, String r101) {
        if (r101 != null) goto L4;
        boolean r102 = ECEventCenterImpl.f46474a;
        return;
    L4:
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) ECEventCenterImpl.c().get(r101);
        if (r103 == null) goto L9;
        r103.remove(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void g(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        boolean r102 = ECEventCenterImpl.f46474a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        int r103 = r101.hashCode();
        Lazy r104 = ECEventCenterImpl.f46481h;
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((ConcurrentHashMap) r104.getValue()).get(Integer.valueOf(r103));
        if (r105 == null) goto L16;
        f r106 = (f) r105.get(r100);
        if (r106 == null) goto L13;
        if (r100 == null) goto L11;
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) ECEventCenterImpl.c().get(r100);
        if (r107 == null) goto L11;
        r107.remove(r106);
    L11:
        f r108 = (f) r105.remove(r100);
    L13:
        if (r105.isEmpty() == false) goto L17;
        ((ConcurrentHashMap) r104.getValue()).remove(Integer.valueOf(r103));
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void e(f r100, String r101, boolean r102) {
        ECEventCenterImpl.e(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void b(String r100, e r110, String r111, long r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, "subscriber");
        Intrinsics.checkNotNullParameter(r111, "sceneID");
        Intrinsics.checkNotNullParameter(r113, "containerId");
        boolean r101 = ECEventCenterImpl.f46474a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, "subscriber");
        Intrinsics.checkNotNullParameter(r111, "sceneID");
        Intrinsics.checkNotNullParameter(r113, "containerId");
        f r102 = new f(r111, r113, r112, new c(r110));
        int r103 = r110.hashCode();
        Lazy r104 = ECEventCenterImpl.f46481h;
        if (((ConcurrentHashMap) r104.getValue()).get(Integer.valueOf(r103)) != null) goto L5;
        ((ConcurrentHashMap) r104.getValue()).put(Integer.valueOf(r103), new ConcurrentHashMap());
    L5:
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((ConcurrentHashMap) r104.getValue()).get(Integer.valueOf(r103));
        if (r105 == null) goto L8;
        f r106 = (f) r105.put(r100, r102);
    L8:
        ECEventCenterImpl.e(r102, r100, false);
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECEventCenterService
    public final void h(String r110, String r111, Boolean r112, Long r113, Long r114) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "sceneId");
        boolean r100 = ECEventCenterImpl.f46474a;
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "sceneId");
        long r101 = System.currentTimeMillis();
        HashSet r102 = new HashSet();
        Iterator r103 = ECEventCenterImpl.b().iterator();
    L4:
        if (r103.hasNext() == false) goto L21;
        b r104 = (b) r103.next();
        if (Intrinsics.areEqual(r104.f46482a, r110) == false) goto L19;
        if (Intrinsics.areEqual(r104.f46484c, r111) == false) goto L19;
        if (r112 != null) goto L11;
    L12:
        if (r113 != null) goto L14;
    L15:
        if (r114 == null) goto L20;
        if (r104.f46483b <= r114.longValue()) goto L19;
    L20:
        r102.add(r104);
        Logger.d("ECEventCenter", "clearEvent, event = " + r104);
        goto L4
    L14:
        if (r104.f46483b >= r113.longValue()) goto L19;
    L11:
        if (Intrinsics.areEqual(Boolean.valueOf(r104.f46487f), r112) == true) goto L12;
    L19:
        if (ECEventCenterImpl.d(r104, Long.valueOf(r101)) == true) goto L4;
    L21:
        ECEventCenterImpl.b().removeAll(r102);
        ECEventCenterImpl.f46477d = r101;
    }
}
