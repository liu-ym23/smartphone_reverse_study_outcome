package com.bytedance.android.shopping.deepfeed.slice.action;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f173398c;

    public b(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f173398c = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void c(DeepFeedSlcCardContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if ((r100 instanceof w) == false) goto L8;
        this.f173398c = r100;
        v r101 = this.f173396a;
        if (r101 == null) goto L9;
        r101.c(r100);
        return;
    L9:
        return;
    }
}
