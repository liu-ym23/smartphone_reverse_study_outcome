package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d1 extends AbsCommonChainEventImpl<fi3.x0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f166621f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166622e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.x0> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.x0.f477345b;
        Object r102 = null;
        if (r100 == null) goto L10;
        Object r103 = r100.get("target_slice_ids");
        if ((r103 instanceof List) == false) goto L9;
        r102 = r103;
    L9:
        r102 = new fi3.x0((List) r102);
    L10:
        if (r102 == null) goto L12;
        int r104 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r102);
    L12:
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("params is null");
    }

    public d1(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PdpTitleToTwoLines", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PdpTitleToTwoLines", r100, r101);
        this.f166622e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.x0 r101, Function1 r102) {
        fi3.x0 r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L5;
        List<String> r104 = r103.f477346a;
    L6:
        fi3.w0 r105 = new fi3.w0(r104);
        j73.d r106 = this.f166622e;
        if (r106 == null) goto L9;
        r106.c0(r105);
    L9:
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
