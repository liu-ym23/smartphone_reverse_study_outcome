package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import android.content.Context;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import fi3.y0;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class r extends AbsCommonChainEventImpl<y0> {
    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<y0> c(Map<String, ? extends Object> r100) {
        int r101 = y0.f477352d;
        y0 r102 = y0.a.a(r100);
        if (r102.getType() != null) goto L5;
        int r103 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.c("type is nil", r102);
    L5:
        String r104 = r102.f477355c;
        boolean r105 = true;
        if (r104 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.c("page is nil", r102);
    L14:
        String r108 = r102.f477353a;
        if (r108 != null) goto L17;
    L20:
        if (r105 == false) goto L22;
        int r109 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.c("post_action is nil", r102);
    L22:
        int r110 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(y0.a.a(r100));
    L17:
        if (r108.length() == 0) goto L20;
        r105 = false;
        goto L20
    L8:
        if (r104.length() == 0) goto L11;
        r106 = false;
        goto L12
    }

    public r(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("IESECUserTrackerServiceTrack", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("IESECUserTrackerServiceTrack", r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r110, y0 r111, Function1 r112) {
        y0 r113 = r111;
        Intrinsics.checkNotNullParameter(r110, "eventContext");
        Intrinsics.checkNotNullParameter(r112, "completion");
        if (r113 == null) goto L5;
        String r100 = r113.f477353a;
    L6:
        if (r113 == null) goto L8;
        Integer r101 = r113.getType();
    L9:
        if (r113 == null) goto L11;
        String r114 = r113.f477355c;
    L13:
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        if (r114 == null) goto L31;
        int r102 = r101.intValue();
        int r103 = ECSdk.f48106a;
        IECUserTrackerService r104 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r104 == null) goto L31;
        of.a r105 = r104.getMarketingService();
        if (r105 == null) goto L31;
        PostActionType[] r106 = PostActionType.values();
        int r107 = r106.length;
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L30;
        PostActionType r109 = r106[r108];
        if (r109.getType() != r102) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == true) goto L27;
        r108 = r108 + 1;
        goto L21
    L27:
        r105.a(r100, r109, r114);
        goto L31
    L25:
        r115 = false;
        goto L26
    L30:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L31:
        int r116 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r112.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L11:
        r114 = null;
        goto L13
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = null;
        goto L6
    }
}
