package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class y extends AbsCommonChainEventImpl<fi3.i> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j73.d f166734e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.i> c(Map<String, ? extends Object> r100) {
        int r101 = fi3.i.f477270a;
        String r102 = null;
        if (r100 != null) goto L5;
        fi3.i r103 = null;
    L9:
        if (r103 == null) goto L11;
        r102 = r103.c();
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        int r105 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("url_path is nil");
    L20:
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r103);
    L13:
        if (r102.length() == 0) goto L16;
        r104 = false;
        goto L17
    L5:
        String r107 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.get("url_path"));
        Boolean r108 = Boolean.valueOf(mq.b.a(r100.get("use_post")));
        Object r109 = r100.get("params");
        if ((r109 instanceof Map) == true) goto L8;
        r109 = null;
    L8:
        r103 = new fi3.i(r107, r108, (Map) r109, Boolean.valueOf(mq.b.a(r100.get("disable_update"))));
        goto L9
    }

    public y(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("Fetch", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super("Fetch", r100, r101);
        this.f166734e = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, fi3.i r101, Function1 r102) {
        fi3.i r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L6;
        Observable.create(new z(r103, this, r102)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a0(this, r102, r103, r100), new b0(r102));
        return;
    }
}
