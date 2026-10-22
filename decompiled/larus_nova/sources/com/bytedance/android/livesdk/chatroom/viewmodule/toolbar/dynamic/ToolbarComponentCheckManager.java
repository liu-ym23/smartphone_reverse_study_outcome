package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarComponentCheckManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f115947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f115948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<Integer> f115949c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SparseArray<ToolbarComponentCheckInterface> f115950d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<NewToolbarButtonConstants, Runnable> f115951e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<DataCenter, y> f115952f = null;

    public ToolbarComponentCheckManager() {
    }

    static {
        f115947a = LazyKt.lazy(ToolbarComponentCheckManager$fixSingleton$2.INSTANCE);
        f115948b = LazyKt.lazy(ToolbarComponentCheckManager$fixMml$2.INSTANCE);
        f115949c = new HashSet();
        f115950d = new SparseArray();
        f115951e = new HashMap();
        f115952f = new LinkedHashMap();
    }

    public static void b(final DataCenter r100) {
        n r101 = d(r100);
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        h(r100, ToolbarComponentCheckManager$clear$1.INSTANCE, new ToolbarComponentCheckManager$clear$2(r100));
        if (r100 == null) goto L9;
        f115952f.remove(r100);
        return;
    }

    public static void c(DataCenter r100) {
        h(r100, ToolbarComponentCheckManager$clearCheckList$1.INSTANCE, ToolbarComponentCheckManager$clearCheckList$2.INSTANCE);
        if (((Boolean) f115948b.getValue()).booleanValue() == false) goto L13;
        Map<DataCenter, y> r101 = f115952f;
        if (r101 == null) goto L12;
        TypeIntrinsics.asMutableMap(r101).remove(r100);
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        y r103 = (y) ((Map.Entry) r102.next()).getValue();
        ALogger.i(r103.f116220d, "CheckManager clear check list");
        r103.f116218b.clear();
        r103.f116219c.clear();
        goto L8
    L10:
        ((LinkedHashMap) f115952f).clear();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public static n d(DataCenter r100) {
        if (r100 != null) goto L5;
        ALogger.e("NewToolbarLog", "dataCenter is null.");
    L5:
        boolean r101 = false;
        if (LiveInfraSettingKeys.LIVE_USE_ROOM_TOOLBAR_CHECK_MANAGER.getValue().booleanValue() == false) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L17;
        if (r100 != null) goto L15;
    L16:
        r101 = true;
        goto L17
    L15:
        if (com.bytedance.android.live.core.utils.a0.d(r100, false) != true) goto L16;
    L17:
        if (r101 == false) goto L22;
        n.f116120a.getClass();
        n r103 = n.a.a(r100);
        if (r103 != null) goto L21;
        ALogger.e("NewToolbarLog", "NewCheckManager is null.");
    L21:
        return r103;
    L22:
        return null;
    L8:
        if (LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue().booleanValue() == true) goto L11;
        r102 = false;
        goto L12
    }

    public static void f(DataCenter r100, final NewToolbarButtonConstants r101) {
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        h(r100, new ToolbarComponentCheckManager$registerPlaceHolder$1(r101), new ToolbarComponentCheckManager$registerPlaceHolder$2(r101));
    }

    public static void g(final DataCenter r100, final NewToolbarButtonConstants r101) {
        Intrinsics.checkNotNullParameter(r101, "toolbarButton");
        n r102 = d(r100);
        if (r102 == null) goto L5;
        r102.d(r101);
    L5:
        h(r100, new ToolbarComponentCheckManager$unregisterFilterService$1(r101), new ToolbarComponentCheckManager$unregisterFilterService$2(r100, r101));
    }

    public static final void a(s r100, Function0 r101, Function1 r102) {
        ToolbarComponentCheckInterface r103 = f115950d.get(r100.f116191a);
        if (r103 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r103.checkThenLoad(r100, r101, r102));
    L6:
        Boolean r105 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r104, r105)) == false) goto L10;
        r101.invoke();
    L10:
        if (Intrinsics.areEqual(r104, r105) == false) goto L13;
        ALogger.i("NewToolbarLog", "component handle! - " + r100);
        return;
    L13:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == false) goto L15;
        ALogger.i("NewToolbarLog", "component don't handle! - " + r100);
        return;
    L15:
        if (r104 != null) goto L20;
        ALogger.i("NewToolbarLog", "no component filter - " + r100);
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void e(final DataCenter r100, final NewToolbarButtonConstants r101, final ToolbarComponentCheckInterface r102) {
        Intrinsics.checkNotNullParameter(r101, "toolbarButton");
        Intrinsics.checkNotNullParameter(r102, "service");
        n r103 = d(r100);
        if (r103 == null) goto L5;
        r103.b(r101, r102);
    L5:
        ALogger.i("NewToolbarLog", "register filter - " + r101);
        h(r100, new ToolbarComponentCheckManager$registerFilterService$1(r101, r102), new ToolbarComponentCheckManager$registerFilterService$2(r100, r101, r102));
    }

    public static void h(DataCenter r100, Function0 r101, Function1 r102) {
        if (((Boolean) f115947a.getValue()).booleanValue() == true) goto L5;
        r101.invoke();
        return;
    L5:
        if (r100 == null) goto L10;
        Map<DataCenter, y> r103 = f115952f;
        y r104 = (y) ((LinkedHashMap) r103).get(r100);
        if (r104 != null) goto L9;
        r104 = new y();
        r103.put(r100, r104);
    L9:
        r102.invoke(r104);
        return;
    L10:
        SafetyGuard.a(null, null, "ToolbarComponentCheckManager with proxy fail, datacenter is null");
        ALogger.e("NewToolbarLog", "dataCenter is null.");
    }
}
