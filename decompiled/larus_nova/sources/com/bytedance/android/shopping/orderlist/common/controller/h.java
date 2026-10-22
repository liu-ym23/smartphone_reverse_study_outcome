package com.bytedance.android.shopping.orderlist.common.controller;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f179727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f179728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<WeakReference<MessageQueue.IdleHandler>> f179729c;

    public static final class a {
    }

    public interface b {
        void a(List r100);

        void b(String r100);
    }

    static {
    }

    public final void b() {
        Map<String, Object> r100 = this.f179727a;
        if (r100 == null) goto L5;
        Object r101 = r100.get("preload_tasks");
    L7:
        if ((r101 instanceof List) == true) goto L9;
        r101 = null;
    L9:
        List r102 = (List) r101;
        Map<String, Object> r103 = this.f179727a;
        if (r103 == null) goto L12;
        Object r104 = r103.get("preload_biz_scene_priority");
    L14:
        if ((r104 instanceof List) == true) goto L16;
        r104 = null;
    L16:
        final List r105 = (List) r104;
        Map<String, Object> r106 = this.f179727a;
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L74;
        List r108 = r102;
        if (r108 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        if (r109 == true) goto L74;
        List r110 = r105;
        if (r110 != null) goto L35;
    L38:
        boolean r111 = true;
    L39:
        if (r111 == true) goto L74;
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        Iterator r114 = r102.iterator();
    L43:
        if (r114.hasNext() == false) goto L63;
        Object r115 = r114.next();
        if ((r115 instanceof Map) == true) goto L47;
        r115 = null;
    L47:
        Map r116 = (Map) r115;
        if (r116 == null) goto L43;
        v r117 = new v(r116);
        Object r118 = r117.f179755c.get(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (r118 == null) goto L53;
        Integer r119 = com.bytedance.kmp.ec.yata.common.utils.d.d(r118);
    L54:
        if (r119 != null) goto L57;
    L59:
        boolean r120 = false;
    L60:
        if (r120 == true) goto L61;
        r113.add(r117);
        goto L43
    L61:
        r112.add(r117);
        goto L43
    L57:
        if (r119.intValue() != 0) goto L59;
        r120 = true;
        goto L60
    L53:
        r119 = null;
        goto L54
    L63:
        Function1<v, Integer> r121 = new OrderCommonPreloadManager$splitAndSortTasksToQueues$selector$1(r105);
        if (r112.size() <= 1) goto L67;
        CollectionsKt.sortWith(r112, new j(r121));
    L67:
        if (r113.size() <= 1) goto L69;
        CollectionsKt.sortWith(r113, new k(r121));
    L69:
        Pair r122 = TuplesKt.to(r112, r113);
        List<v> r123 = (List) r122.getFirst();
        List r124 = (List) r122.getSecond();
        a(r123);
        if (r124.isEmpty() == true) goto L84;
        i r125 = new i(this, r124);
        this.f179729c.add(new WeakReference(r125));
        Looper.myQueue().addIdleHandler(r125);
        return;
    L84:
        return;
    L35:
        if (r110.isEmpty() == true) goto L38;
        r111 = false;
        goto L39
    L27:
        if (r108.isEmpty() == true) goto L30;
        r109 = false;
    L74:
        this.f179728b.a(r102);
        return;
    L19:
        if (r106.isEmpty() == true) goto L22;
        r107 = false;
        goto L23
    L12:
        r104 = null;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public final void a(List<v> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L22;
        v r102 = (v) r101.next();
        r102.getClass();
        int r103 = com.bytedance.android.shopping.yata.init.a.f187608a;
        Object r104 = ECSettingKeys.f0().get("fix_self_add_preload_task_crash");
        if ((r104 instanceof Boolean) == true) goto L8;
        r104 = null;
    L8:
        Boolean r105 = (Boolean) r104;
        if (r105 == null) goto L11;
        boolean r106 = r105.booleanValue();
    L12:
        if (r106 == false) goto L18;
        Context r107 = ECAppInfoService.f48114e.getApplicationContext();
        if (r107 == null) goto L21;
        com.bytedance.android.anniex.assemble.a.f40251a.c(r107);
    L21:
        this.f179728b.b(r102.f179754b);
    L18:
        if (ECSettingKeys.J() == false) goto L20;
        Observable.create(new r(r102)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s.f179750a, t.f179751a, u.f179752a);
        goto L21
    L20:
        r102.a();
        goto L21
    L11:
        r106 = true;
        goto L12
    }

    public h(Map r100, g r101, List r102) {
        Intrinsics.checkNotNullParameter(r101, "monitor");
        Intrinsics.checkNotNullParameter(r102, "idleHandlerList");
        this.f179727a = r100;
        this.f179728b = r101;
        this.f179729c = r102;
    }
}
