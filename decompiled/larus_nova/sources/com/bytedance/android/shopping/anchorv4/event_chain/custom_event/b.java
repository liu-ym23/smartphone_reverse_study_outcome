package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements ej.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f166551a;

    public b(Function1 r100) {
        this.f166551a = r100;
    }

    @Override // ej.b
    public final void onResult(boolean r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        if (r100 == false) goto L5;
        dm.a.a("PdpAddCalendar").i("addCalendar success");
        Function1 r102 = this.f166551a;
        int r103 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        dm.a.a("PdpAddCalendar").i("addCalendar failed,errorCode:" + r101 + ",msg:" + r110);
        Function1 r104 = this.f166551a;
        int r105 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r104.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r101 + ':' + r110, null, null, 57));
    }
}
