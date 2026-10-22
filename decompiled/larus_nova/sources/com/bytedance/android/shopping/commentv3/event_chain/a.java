package com.bytedance.android.shopping.commentv3.event_chain;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends t96.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fc3.a f172749c;

    public abstract void c(EventContext r100, fc3.a r101, fc3.c r102, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r103);

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100);
    }

    @Override // t96.a
    public final void b(EventContext r100, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r101, "completion");
        Object r102 = r100.d().get("action_context");
        Object r103 = null;
        if ((r102 instanceof fc3.a) == true) goto L5;
        r102 = null;
    L5:
        fc3.a r104 = (fc3.a) r102;
        if (r104 != null) goto L9;
        int r105 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "actionContext is null", null, null, 57));
        return;
    L9:
        this.f172749c = r104;
        Object r106 = r100.d().get("handle_action_params");
        if ((r106 instanceof fc3.c) == false) goto L13;
        r103 = r106;
    L13:
        fc3.c r107 = (fc3.c) r103;
        if (r107 != null) goto L17;
        int r108 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "handleActionParams is null", null, null, 57));
        return;
    L17:
        c(r100, r104, r107, r101);
    }
}
