package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFeedPreview f124291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f124292b;

    public b(LiveFeedPreview r100, LifecycleOwner r101) {
        this.f124291a = r100;
        this.f124292b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getFirst() != null) goto L8;
        return;
    L8:
        if (r101.getSecond() == null) goto L12;
        LiveFeedPreview r102 = this.f124291a;
        Object r103 = r101.getFirst();
        Intrinsics.checkNotNull(r103);
        int r104 = ((Number) r103).intValue();
        Object r105 = r101.getSecond();
        Intrinsics.checkNotNull(r105);
        LiveFeedPreview.d(r102, r104, ((Number) r105).intValue());
        return;
    }
}
