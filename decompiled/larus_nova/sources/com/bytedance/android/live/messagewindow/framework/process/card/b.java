package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardPsId f83183e;

    public b() {
        this.f83183e = CardPsId.CardStart;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.f83183e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        ((com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r100).f485711a).f83134c.n(ICardLifecycle$State.Started);
        e();
    }
}
