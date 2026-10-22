package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends b {
    public k(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        return this.f173398c.i();
    }
}
