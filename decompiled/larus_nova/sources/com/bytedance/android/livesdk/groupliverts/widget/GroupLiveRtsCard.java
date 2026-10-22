package com.bytedance.android.livesdk.groupliverts.widget;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.salamander.anniex.q4;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v61.a;
import x61.c;
import x61.f;
import x61.h;

/* JADX INFO: loaded from: classes9.dex */
public final class GroupLiveRtsCard extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q4<Map<String, Object>> f132603m;

    @Override // v61.c
    public final h<?, ?> content() {
        h.a r100 = h.f562592a;
        Function1<c.a, View> r101 = new AnonymousClass1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_INFLATE);
        return new f(r101);
    }

    public GroupLiveRtsCard(q4 r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter("", "cardType");
        super(r101, "", 1);
        this.f132603m = r100;
    }
}
