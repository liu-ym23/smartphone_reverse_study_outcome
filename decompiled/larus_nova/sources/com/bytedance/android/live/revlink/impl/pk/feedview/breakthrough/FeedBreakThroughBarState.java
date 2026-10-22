package com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough;

import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.b;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedBreakThroughBarState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f96420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f96421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f96422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f96423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f96424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f96425f;

    public FeedBreakThroughBarState(b r100) {
        Intrinsics.checkNotNullParameter(r100, "sender");
        this.f96425f = r100;
    }

    public final void a(Function1<? super Map<String, Object>, Unit> r100) {
        HashMap r101 = new HashMap();
        r100.invoke(r101);
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L4
    L6:
        b r105 = this.f96425f;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        if (r105.f96524b == false) goto L13;
        zy0.b r106 = r105.f96525c;
        if (r106 == null) goto L16;
        xy0.a<?> r107 = r106.g();
        if (r107 == null) goto L17;
        r107.sendJsEvent("H5_webcastNotification", r102);
        return;
    L17:
        return;
    L16:
        return;
    L13:
        r105.f96523a.offer(r102);
    }

    public final void b(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f96422c) == true) goto L9;
        this.f96422c = r100;
        a(new FeedBreakThroughBarState$btFinishEvent$1(r100));
        return;
    }

    public final void c(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f96421b) == true) goto L9;
        this.f96421b = r100;
        a(new FeedBreakThroughBarState$btRefreshEvent$1(r100));
        return;
    }

    public final void d(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f96423d) == true) goto L9;
        this.f96423d = r100;
        a(new FeedBreakThroughBarState$btUpdateScoreEvent$1(r100));
        return;
    }

    public final void e(final Long r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f96424e) == true) goto L9;
        this.f96424e = r100;
        a(new FeedBreakThroughBarState$pkLeftTime$1(r100));
        return;
    }
}
