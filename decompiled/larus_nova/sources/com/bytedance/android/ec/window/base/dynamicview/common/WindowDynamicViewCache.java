package com.bytedance.android.ec.window.base.dynamicview.common;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.UIViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/dynamicview/common/WindowDynamicViewCache;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowDynamicViewCache implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f49233a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, nq3.a> f49234b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k<? extends View, ?>> f49235c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k<? extends View, ?>> f49236d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final JsonObject f49237e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<k<? extends View, ?>, List<View>> f49238f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final WindowDynamicViewCache f49239g = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io.b f49240a;

        public a(io.b r100) {
            this.f49240a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (c.f49250a == true) goto L7;
            Objects.toString(this.f49240a);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f49241a = null;

        static {
            f49241a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.e((Throwable) r100);
        }
    }

    private WindowDynamicViewCache() {
    }

    static {
        f49239g = new WindowDynamicViewCache();
        f49233a = ECAppInfoService.f48114e.i();
        f49234b = new ConcurrentHashMap();
        f49235c = new ConcurrentHashMap();
        f49236d = new ConcurrentHashMap();
        f49237e = new JsonObject();
        f49238f = new ConcurrentHashMap();
    }

    public static UIViewGroup b(String r100) {
        UIViewGroup r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        lo.b r102 = (lo.b) uo.a.b(r100, lo.b.class);
        if (r102 == null) goto L8;
        List r103 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r103, "siblings");
        r101 = d.a(null, r102, r103);
    L8:
        if (r101 == null) goto L10;
        f49236d.put(r100, r101);
    L10:
        return r101;
    }

    public static k c(String r100) {
        UIViewGroup r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f49233a == false) goto L21;
        Context r102 = ECAppInfoService.f48114e.getApplicationContext();
        if (r102 == null) goto L12;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102.getFilesDir(), r100.concat(InvRouter.FLOW_SUFFIX));
        if (r103.exists() == false) goto L12;
        String r104 = FilesKt.readText$default(r103, null, 1, null);
    L14:
        UIViewGroup r105 = b(r104);
        if (r105 == null) goto L21;
        if (c.f49250a == true) goto L20;
    L20:
        return r105;
    L12:
        r104 = null;
    L21:
        ConcurrentHashMap<String, k<? extends View, ?>> r106 = f49235c;
        k<? extends View, ?> r107 = r106.get(r100);
        if (r107 != null) goto L24;
        nq3.a r108 = f49234b.get(r100);
        if (r108 != null) goto L31;
        return null;
    L31:
        lo.b r109 = (lo.b) uo.a.b(r108.a(), lo.b.class);
        if (r109 == null) goto L34;
        List r110 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r110, "siblings");
        r101 = d.a(null, r109, r110);
    L34:
        if (r101 == null) goto L36;
        r106.put(r100, r101);
    L36:
        return r101;
    L24:
        if (c.f49250a == true) goto L27;
        r107.toString();
    L27:
        return r107;
    }

    public final void d(List<nq3.a> r100) {
        if (r100 == null) goto L22;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        String r104 = ((nq3.a) r103).c();
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        if ((!StringsKt.isBlank(r104)) != true) goto L12;
        r105 = true;
        goto L13
    L15:
        Map<? extends String, ? extends nq3.a> r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r107 = r101.iterator();
    L17:
        if (r107.hasNext() == false) goto L23;
        Object r108 = r107.next();
        String r109 = ((nq3.a) r108).c();
        if (r109 != null) goto L21;
        r109 = "";
    L21:
        r106.put(r109, r108);
    L23:
        if (r106 != null) goto L26;
        r106 = MapsKt.emptyMap();
    L26:
        if (r106.isEmpty() == false) goto L28;
        return;
    L28:
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator<Map.Entry<String, nq3.a>> r111 = f49234b.entrySet().iterator();
    L30:
        if (r111.hasNext() == false) goto L37;
        Map.Entry<String, nq3.a> r112 = r111.next();
        String r113 = r112.getKey();
        nq3.a r114 = r112.getValue();
        nq3.a r115 = r106.get(r113);
        if (r115 == null) goto L30;
        if ((!Intrinsics.areEqual(r114.b(), r115.b())) == false) goto L30;
        r110.add(r113);
        goto L30
    L37:
        ConcurrentHashMap<String, nq3.a> r116 = f49234b;
        r116.putAll(r106);
        monitor-enter(this);
        Iterator<Map.Entry<String, nq3.a>> r117 = r116.entrySet().iterator();     // Catch: Throwable -> L53
    L41:
        if (r117.hasNext() == false) goto L47;
        Map.Entry<String, nq3.a> r118 = r117.next();     // Catch: Throwable -> L53
        String r119 = r118.getKey();     // Catch: Throwable -> L53
        String r120 = r118.getValue().b();     // Catch: Throwable -> L53
        if (r120 == null) goto L41;
        f49237e.addProperty(r119, r120);     // Catch: Throwable -> L53
        goto L41
    L47:
        monitor-exit(this);
        Iterator r121 = r110.iterator();
    L50:
        if (r121.hasNext() == false) goto L52;
        f49235c.remove((String) r121.next());
        goto L50
    L52:
        return;
    L53:
        th = move-exception;
        throw th;
    L22:
        r106 = null;
        goto L23
    }

    public static View a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        k r102 = c(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        ConcurrentHashMap<k<? extends View, ?>, List<View>> r103 = f49238f;
        List<View> r104 = r103.get(r102);
        if (r104 != null) goto L8;
    L13:
        View r105 = null;
    L15:
        if (c.f49250a == true) goto L21;
        List<View> r106 = r103.get(r102);
        if (r106 == null) goto L20;
        r106.size();
    L20:
        r102.toString();
    L21:
        if (r105 == null) goto L23;
        return r105;
    L23:
        k r107 = c(r101);
        if (r107 != null) goto L26;
        return null;
    L26:
        return r107.d(r100, true);
    L8:
        if ((!r104.isEmpty()) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        r105 = (View) ListProtector.remove(r104, 0);
        goto L15
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L27;
        f49238f.clear();
        Iterator<Map.Entry<String, nq3.a>> r102 = f49234b.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, nq3.a> r103 = r102.next();
        String r104 = r103.getKey();
        nq3.a r105 = r103.getValue();
        String r106 = r105.b();
        if (r106 == null) goto L6;
        String r107 = r105.a();
        if (r107 == null) goto L6;
        io.b r108 = new io.b(r104, r106, r107);
        ap3.c r109 = ap3.c.f15842a;
        Intrinsics.checkNotNullParameter(r108, MapController.ITEM_LAYER_TAG);
        WindowDatabase r110 = go.a.f481867b.a();
        if (r110 != null) goto L16;
        Observable r111 = Observable.just(-1L);
    L17:
        r111.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new a(r108), b.f49241a);
        goto L6
    L16:
        r111 = Observable.create(new ap3.b(r110, r108));
        goto L17
    L18:
        r100.getLifecycle().removeObserver(this);
        return;
    }
}
