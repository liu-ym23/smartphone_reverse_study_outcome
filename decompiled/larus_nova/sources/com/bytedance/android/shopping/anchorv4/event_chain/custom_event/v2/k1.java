package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k1 extends AbsCommonChainEventImpl<fi3.k0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166658e;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.k0> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.k0.f477280a;
        Long r102 = null;
        if (r100 == null) goto L11;
        Object r103 = r100.get("timestamp");
        if ((r103 instanceof Number) == true) goto L8;
        r103 = null;
    L8:
        Number r104 = (Number) r103;
        if (r104 == null) goto L11;
        fi3.k0 r105 = new fi3.k0(Long.valueOf(r104.longValue()));
    L12:
        if (r105 == null) goto L14;
        Long r106 = r105.a();
    L15:
        if (r106 == null) goto L23;
        Long r107 = r105.a();
        if (r107 != null) goto L20;
    L22:
        int r108 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r105);
    L20:
        if (r107.longValue() != 0) goto L22;
    L23:
        int r109 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        StringBuilder r110 = new StringBuilder("PdpCountDownActionEvent timestamp is nil:");
        if (r105 == null) goto L26;
        r102 = r105.a();
    L26:
        r110.append(r102);
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a(r110.toString());
    L14:
        r106 = null;
    L11:
        r105 = null;
        goto L12
    }

    public k1(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PdpCountDown", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PdpCountDown", r100, r101);
        this.f166658e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.k0 r101, Function1 r102) {
        fi3.k0 r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L10;
        Long r104 = r103.a();
        if (r104 == null) goto L10;
        long r105 = r104.longValue();
        long r106 = System.currentTimeMillis() / ((long) 1000);
        if (r105 >= r106) goto L9;
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L9:
        this.f166658e.g0(r106, r105, new j1(r102));
        return;
    L10:
        int r108 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PdpCountDownActionEvent timestamp is nil", null, null, 57));
    }
}
