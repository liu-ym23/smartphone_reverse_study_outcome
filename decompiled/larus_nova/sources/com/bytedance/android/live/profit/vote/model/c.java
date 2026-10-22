package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.g;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.revenue.platform.api.core.rx.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.android.live.profit.vote.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<VoteState> f89243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<List<g>> f89244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f89245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f89246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f89247e;

    @Override // com.bytedance.android.live.profit.vote.b
    public final long a() {
        return this.f89245c.a();
    }

    public final String toString() {
        return "Vote(id=" + this.f89246d + ", type=" + this.f89247e + ", state=" + this.f89243a.f267520d + ", clock=" + this.f89245c + ", items=" + VoteUtilsKt.d(this.f89244b.f267520d) + ')';
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final n getItems() {
        return this.f89244b;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final n getState() {
        return this.f89243a;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final long getVoteId() {
        return this.f89246d;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final long getVoteType() {
        return this.f89247e;
    }

    public c(long r100, long r101, VoteState r102, List<g> r103) {
        Intrinsics.checkNotNullParameter(r102, "initialState");
        Intrinsics.checkNotNullParameter(r103, "initialItems");
        this.f89246d = r100;
        this.f89247e = r101;
        this.f89243a = PropertyOwnersKt.b(r102);
        this.f89244b = PropertyOwnersKt.b(r103);
        this.f89245c = new d();
    }
}
