package com.bytedance.android.shopping.card_list.monitor.firstScreen;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListYataFirstScreenDurationMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<CardListFirstScreenPoint, Long> f171693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f171694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f171695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f171696e;

    public static final class a {
    }

    static {
    }

    public CardListYataFirstScreenDurationMonitor(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "baseParams");
        this.f171695d = r100;
        this.f171696e = r101;
        Lazy r102 = LazyKt.lazy(new CardListYataFirstScreenDurationMonitor$monitorKey$2(this));
        this.f171692a = r102;
        this.f171693b = new ConcurrentHashMap();
        this.f171694c = new LinkedHashMap();
        d r103 = i.f47987a.get((String) r102.getValue());
        if (r103 == null) goto L10;
        Iterator<String> r104 = r101.keys();
    L6:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        Object r106 = this.f171696e.opt(r105);
        if (r106 == null) goto L6;
        r103.b(r105, r106);
        goto L6
    L16:
        return;
    }

    public static void b(final CardListYataFirstScreenDurationMonitor r100, final CardListFirstScreenPoint r101) {
        Intrinsics.checkNotNullParameter(r101, "point");
        final Long r102 = null;
        CardListRunCatchExtKt.a(r100.f171695d, CardListErrorMonitorType.ADD_POINT.getValue(), new CardListYataFirstScreenDurationMonitor$addPointSafely$1(r100, r101, r102));
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f171694c.put(r100, r101);
    }
}
