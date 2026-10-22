package com.bytedance.android.shopping.deepfeed.slice.action;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import com.bytedance.android.shopping.deepfeed.slice.action.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class c<T extends x> extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f173399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f173400d;

    public c(T r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f173400d = r100;
        this.f173399c = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void c(DeepFeedSlcCardContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (r100 == null) goto L6;
        this.f173399c = r100;
        return;
    }
}
