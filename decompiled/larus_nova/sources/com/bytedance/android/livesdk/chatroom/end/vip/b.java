package com.bytedance.android.livesdk.chatroom.end.vip;

import io.reactivex.functions.Predicate;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VipLiveEndService f106139a;

    public b(VipLiveEndService r100) {
        this.f106139a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((Pair) r100, "it");
        return Intrinsics.areEqual(this.f106139a.f106131f.getValue(), Boolean.TRUE);
    }
}
