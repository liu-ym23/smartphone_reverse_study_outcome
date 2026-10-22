package com.bytedance.android.live.room.api.experience.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l61.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class ExpOptLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f98901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<b> f98902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExpOptLog f98903c = null;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((LivePerfBizLevel) r100).getLevel()), Integer.valueOf(((LivePerfBizLevel) r101).getLevel()));
        }
    }

    public ExpOptLog() {
    }

    public static StringBuilder c() {
        return (StringBuilder) f98901a.getValue();
    }

    static {
        f98903c = new ExpOptLog();
        f98901a = LazyKt.lazy(ExpOptLog$traceBuilder$2.INSTANCE);
        f98902b = new LinkedHashSet();
    }

    public static void b(DataCenter r110) {
        if (r110 == null) goto L5;
        IRoom r111 = a0.n(r110);
        if (r111 == null) goto L5;
    L6:
        Set<b> r100 = f98902b;
        if ((!r100.isEmpty()) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L30;
        f98903c.getClass();
        c().append("------以下业务场景响应了性能等级更新------\n");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.iterator();
    L13:
        if (r102.hasNext() == false) goto L18;
        Object r103 = r102.next();
        LivePerfBizLevel r104 = ((b) r103).getLevel();
        Object r105 = r101.get(r104);
        if (r105 != null) goto L17;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L17:
        ((List) r105).add(r103);
        goto L13
    L18:
        SortedMap r106 = MapsKt.toSortedMap(r101, new a());
        if (r106 == null) goto L31;
        Iterator r107 = r106.entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        Map.Entry r108 = (Map.Entry) r107.next();
        f98903c.getClass();
        c().append(((LivePerfBizLevel) r108.getKey()).name() + 65306 + CollectionsKt.joinToString$default((Iterable) r108.getValue(), null, null, null, 0, null, ExpOptLog$endTrace$5$1.INSTANCE, 31, null) + "\n");
        goto L22
    L24:
        Unit r109 = Unit.INSTANCE;
        f98903c.getClass();
        c().append("------ end ------");
        String r112 = c().toString();
        int r113 = e.f64997m;
        e.a r114 = e.b.a("exp_opt_change", "live_exp_opt");
        r114.f65012c = "webcast_client_community";
        r114.f65017h = 0;
        r114.f65018i = "";
        r114.f65014e = r111.getIdStr();
        r114.f65016g = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
        r114.f65015f = r111.getAnchorId();
        e r115 = r114.a();
        JSONObject r116 = new JSONObject();
        r116.put("perf_change_log", r112);
        TraceMonitor.h(r115, r116);
        SimpleAlogArgsBuilder r117 = new SimpleAlogArgsBuilder();
        r117.c(r112);
        d(r117.b());
        f98902b.clear();
        StringsKt.clear(c());
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r111 = a0.f66111a;
        goto L6
    }

    @JvmStatic
    public static final void d(com.bytedance.android.live.room.api.base.alog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Throwable r101 = r100.f98900b;
        if (r101 == null) goto L5;
        ALogger.e("LiveExpOptLog", r100.f98899a, r101);
        return;
    L5:
        ALogger.i("LiveExpOptLog", r100.f98899a);
        Unit r102 = Unit.INSTANCE;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("LiveExpOptLog", r100);
        c().append(r100 + "\n");
    }
}
