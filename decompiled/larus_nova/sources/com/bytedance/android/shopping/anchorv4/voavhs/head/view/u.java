package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4VideoView f168959a;

    public u(AnchorV4VideoView r100) {
        this.f168959a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        return !this.f168959a.f168911n;
    }
}
