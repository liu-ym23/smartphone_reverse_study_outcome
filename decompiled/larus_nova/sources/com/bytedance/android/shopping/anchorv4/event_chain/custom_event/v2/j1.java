package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class j1 implements com.bytedance.android.ec.core.utils.l1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f166650a;

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        Function1 r100 = this.f166650a;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r100.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }

    public j1(Function1 r100) {
        this.f166650a = r100;
    }
}
