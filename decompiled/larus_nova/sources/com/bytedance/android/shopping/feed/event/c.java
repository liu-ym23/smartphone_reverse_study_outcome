package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InnerFlowAdRawData f174629a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        InnerFlowAdData r100 = this.f174629a.getAdData();
        String r101 = null;
        if (r100 == null) goto L7;
        Long r102 = r100.getCreativeId();
        if (r102 == null) goto L7;
        String r103 = String.valueOf(r102.longValue());
    L8:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r104 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("cid", r103, r104);
        InnerFlowAdData r105 = this.f174629a.getAdData();
        if (r105 == null) goto L13;
        Long r106 = r105.getCreativeId();
        if (r106 == null) goto L13;
        r101 = String.valueOf(r106.longValue());
    L13:
        appendParam("value", r101, r104);
        appendParam("log_extra", this.f174629a.getLogExtra(), r104);
        appendParam("is_ad_event", "1", r104);
        appendParam("tag", EventConstants.Tag.EMBEDED_AD, r104);
        appendParam("category", "umeng", r104);
        appendParam("nt", "4", r104);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public c(InnerFlowAdRawData r100) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
        super("realtime_click");
        this.f174629a = r100;
    }
}
