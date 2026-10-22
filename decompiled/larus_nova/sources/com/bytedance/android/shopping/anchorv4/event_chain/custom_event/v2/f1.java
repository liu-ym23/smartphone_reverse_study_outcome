package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f1 extends AbsCommonChainEventImpl<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t96.b f166634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j73.d f166635f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f166636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f166637b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f166636a == r101.f166636a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f166637b, r101.f166637b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f166636a * 31;
            Map<String, Object> r101 = this.f166637b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Params(type=" + this.f166636a + ", params=" + this.f166637b + ")";
        }

        public final int getType() {
            return this.f166636a;
        }

        public b(int r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f166636a = r100;
            this.f166637b = r101;
        }
    }

    static {
    }

    @Override // t96.a
    public final t96.b a() {
        return this.f166634e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<b> c(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("fields is null");
    L5:
        Object r102 = r100.get("type");
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        if (r103 != 0) goto L13;
    L16:
        Object r104 = r100.get("params");
        if ((r104 instanceof Map) == true) goto L19;
        r104 = null;
    L19:
        Map r105 = (Map) r104;
        if (r105 != null) goto L23;
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("params is null");
    L23:
        int r107 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(new b(r103, r105));
    L13:
        if (r103 == 1) goto L16;
        int r108 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("type is invalid");
    L9:
        if ((r102 instanceof Number) == false) goto L25;
        r103 = ((Number) r102).intValue();
        goto L11
    L25:
        int r109 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.a("type is invalid");
    }

    public f1(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PDPUpdateNativeRefreshParams", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super("PDPUpdateNativeRefreshParams", r100, r101);
        this.f166635f = r102;
        this.f166634e = new t96.b(true, CollectionsKt.listOf("params"), true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, b r101, Function1 r102) {
        b r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 != null) goto L5;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "params is null", null, null, 57));
        return;
    L5:
        j73.d r105 = this.f166635f;
        Map<String, ? extends Object> r106 = r103.f166637b;
        boolean r107 = true;
        if (r103.getType() == 1) goto L9;
        r107 = false;
    L9:
        r105.T(r106, r107);
        int r108 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
