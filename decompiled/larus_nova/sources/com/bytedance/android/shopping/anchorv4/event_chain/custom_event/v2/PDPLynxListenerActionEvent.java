package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/event_chain/custom_event/v2/PDPLynxListenerActionEvent;", "Lcom/bytedance/android/shopping/anchorv4/event_chain/AbsCommonChainEventImpl;", "Lfi3/l;", "Landroidx/lifecycle/LifecycleObserver;", "", MapMonitorConst.EVENT_DESTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPLynxListenerActionEvent extends AbsCommonChainEventImpl<fi3.l> implements LifecycleObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f166582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f166583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f166584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> f166585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0 f166586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i0 f166587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j73.d f166588k;

    public static final class a {
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        List<String> r100 = this.f166582e;
        if (r100 == null) goto L18;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L18;
        String r102 = (String) r101.next();
        int r103 = r102.hashCode();
        if (r103 != 1045227199) goto L10;
        if (r102.equals("add_cart_fail") == false) goto L6;
        ECLiveHybridUtil.p(r102, this.f166587j);
        goto L6
    L10:
        if (r103 != 1482516106) goto L6;
        if (r102.equals("update_shop_cart_list") == false) goto L6;
        ECLiveHybridUtil.p(r102, this.f166586i);
    L18:
        this.f166585h = null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.l> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.l.f477281c;
        Object r102 = null;
        if (r100 == null) goto L13;
        Object r103 = r100.get("context_result_key");
        if ((r103 instanceof String) == true) goto L8;
        r103 = null;
    L8:
        String r104 = (String) r103;
        Object r105 = r100.get("event_name_list");
        if (TypeIntrinsics.isMutableList(r105) == false) goto L12;
        r102 = r105;
    L12:
        r102 = new fi3.l(r104, (List) r102);
    L13:
        if (r102 != null) goto L15;
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("params is null");
    L15:
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r102);
    }

    public PDPLynxListenerActionEvent(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PDPTakeoutLynxListener", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PDPTakeoutLynxListener", r100, r101);
        this.f166588k = r102;
        LifecycleOwner r103 = r102.getLifecycleOwner();
        this.f166584g = r103;
        if (r103 == null) goto L7;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L7;
        r104.addObserver(this);
    L7:
        this.f166586i = new j0(this);
        this.f166587j = new i0(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.l r101, Function1 r102) {
        fi3.l r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L5;
        List<String> r104 = r103.f477283b;
    L6:
        this.f166582e = r104;
        if (r103 == null) goto L9;
        String r105 = r103.f477282a;
    L10:
        this.f166583f = r105;
        this.f166585h = r102;
        if (r103 == null) goto L28;
        List<String> r106 = r103.f477283b;
        if (r106 == null) goto L41;
        Iterator<T> r107 = r106.iterator();
    L16:
        if (r107.hasNext() == false) goto L42;
        String r108 = (String) r107.next();
        int r109 = r108.hashCode();
        if (r109 != 1045227199) goto L20;
        if (r108.equals("add_cart_fail") == false) goto L16;
        ECLiveHybridUtil.m(r108, this.f166587j);
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        goto L16
    L20:
        if (r109 != 1482516106) goto L16;
        if (r108.equals("update_shop_cart_list") == false) goto L16;
        ECLiveHybridUtil.m(r108, this.f166586i);
        goto L16
    L42:
        return;
    L41:
        return;
    L28:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
