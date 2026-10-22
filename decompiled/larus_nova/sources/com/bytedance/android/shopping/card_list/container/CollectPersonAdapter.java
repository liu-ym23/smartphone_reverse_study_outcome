package com.bytedance.android.shopping.card_list.container;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectPersonAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardListObjectContainer f171508c;

    public CollectPersonAdapter(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f171508c = r100;
        this.f171506a = LazyKt.lazy(new CollectPersonAdapter$trackerComponent$2(this));
        this.f171507b = LazyKt.lazy(new CollectPersonAdapter$bodyComponent$2(this));
    }
}
