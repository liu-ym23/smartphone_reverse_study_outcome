package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m1 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventChain f166675a;

    public m1(EventChain r100) {
        this.f166675a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.g
    public final void a(AbsCommonChainEventImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "eventImpl");
        EventChain r101 = this.f166675a;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }
}
