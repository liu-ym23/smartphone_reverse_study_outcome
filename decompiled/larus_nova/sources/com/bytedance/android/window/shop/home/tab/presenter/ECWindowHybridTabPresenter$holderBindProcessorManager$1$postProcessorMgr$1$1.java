package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lzq3/w1;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lzq3/w1;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1 extends FunctionReferenceImpl implements Function2<w1, String, Unit> {
    public static final ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1 INSTANCE = null;

    static {
        INSTANCE = new ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1();
    }

    public ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1() {
        super(2, w1.class, "onRenderEnd", "onRenderEnd(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(w1 r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "p1");
        if (r111 != null) goto L5;
        r110.getClass();
        return;
    L5:
        ArrayList r100 = (ArrayList) r110.f573329a;
        ListIterator r101 = r100.listIterator(r100.size());
    L6:
        JSONObject r102 = null;
        if (r101.hasPrevious() == false) goto L11;
        Object r103 = r101.previous();
        if ((((v1) r103) instanceof v1.d) == false) goto L6;
    L13:
        if ((r103 instanceof v1.d) == true) goto L15;
        r103 = null;
    L15:
        v1.d r104 = (v1.d) r103;
        if (r104 != null) goto L19;
        return;
    L19:
        if ((!Intrinsics.areEqual(r104.f573324c, r111)) == true) goto L77;
        ArrayList r105 = (ArrayList) r110.f573329a;
        ListIterator r106 = r105.listIterator(r105.size());
    L22:
        int r107 = 0;
        if (r106.hasPrevious() == false) goto L32;
        v1 r108 = (v1) r106.previous();
        if ((r108 instanceof v1.c) == true) goto L27;
    L29:
        boolean r109 = false;
    L30:
        if (r109 == false) goto L22;
        int r112 = r106.nextIndex();
    L33:
        if (r112 < 0) goto L78;
        Object r113 = ListProtector.get(r110.f573329a, r112);
        if ((r113 instanceof v1.c) == true) goto L38;
        r113 = null;
    L38:
        v1.c r114 = (v1.c) r113;
        if (r114 != null) goto L42;
        return;
    L42:
        if (r114.f573319c != 0) goto L52;
        List<v1> r115 = r110.f573329a;
    L44:
        if (r107 >= r112) goto L49;
        if ((ListProtector.get(r115, r107) instanceof v1.h) == true) goto L47;
        r107 = r107 + 1;
        goto L44
    L47:
        Integer r116 = Integer.valueOf(r107);
    L50:
        if (r116 == null) goto L75;
        r112 = r116.intValue();
        goto L52
    L75:
        return;
    L49:
        r116 = null;
    L52:
        if (r112 != 0) goto L54;
        List<v1> r117 = r110.f573329a;
    L55:
        v1.g r118 = new v1.g(r111);
        r117.add(r118);
        if (r114.f573319c != 0) goto L58;
        ((ArrayList) r110.f573331c).clear();
        ((ArrayList) r110.f573331c).addAll(r117);
    L62:
        ((ArrayList) r110.f573329a).clear();
        return;
    L58:
        r110.d(r117, Long.valueOf(r118.f573318b));
        Map<String, Object> r119 = r110.b(r117, r104.f573323f);
        Map r120 = w1.a(r117);
        int r121 = ECMonitorService.f45110b;
        JSONObject r122 = com.bytedance.android.ec.hybrid.list.util.k.b(r120);
        JSONObject r123 = com.bytedance.android.ec.hybrid.list.util.k.b(r119);
        Map<String, ? extends Object> r124 = r110.f573330b;
        if (r124 == null) goto L61;
        r102 = com.bytedance.android.ec.hybrid.list.util.k.b(r124);
    L61:
        ECMonitorService.a.a("ec_perf_loadmore_window", r122, r123, r102);
        goto L62
    L54:
        ArrayList r125 = (ArrayList) r110.f573329a;
        r117 = r125.subList(r112, r125.size());
        goto L55
    L78:
        return;
    L27:
        if (((v1.c) r108).f573320d != r104.f573322e) goto L29;
        r109 = true;
        goto L30
    L32:
        r112 = -1;
        goto L33
    L77:
        return;
    L11:
        r103 = null;
        goto L13
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(w1 r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
