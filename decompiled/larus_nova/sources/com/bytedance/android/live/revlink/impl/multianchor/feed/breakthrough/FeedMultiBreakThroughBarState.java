package com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough;

import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x21.d;
import xy0.a;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedMultiBreakThroughBarState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f94115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f94116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f94117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f94118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f94119e;

    public FeedMultiBreakThroughBarState(b r100) {
        Intrinsics.checkNotNullParameter(r100, "sender");
        this.f94119e = r100;
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
        b r105 = this.f94119e;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        if (r105.f96524b == false) goto L13;
        zy0.b r106 = r105.f96525c;
        if (r106 == null) goto L16;
        a<?> r107 = r106.g();
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
        if (Intrinsics.areEqual(r100, this.f94116b) == true) goto L9;
        this.f94116b = r100;
        a(new FeedMultiBreakThroughBarState$btFinishEvent$1(r100));
        return;
    }

    public final void c(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(new FeedMultiBreakThroughBarState$btRefreshEvent$1(r100));
    }

    public final void d(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f94117c) == true) goto L9;
        this.f94117c = r100;
        a(new FeedMultiBreakThroughBarState$btUpdateScoreEvent$1(r100));
        return;
    }

    public final void e(final Long r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f94118d) == true) goto L9;
        this.f94118d = r100;
        a(new FeedMultiBreakThroughBarState$pkLeftTime$1(r100));
        return;
    }
}
