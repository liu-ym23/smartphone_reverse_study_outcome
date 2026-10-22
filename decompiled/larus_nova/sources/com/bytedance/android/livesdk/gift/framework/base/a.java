package com.bytedance.android.livesdk.gift.framework.base;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b0;
import com.bytedance.android.anya.p;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIComposableViewModel<STATE, ACTION> {
    @Override // com.bytedance.android.anya.BaseMVIComposableViewModel, com.bytedance.android.anya.BaseMVIViewModel
    public final boolean L0(ACTION r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return true;
    }

    public a(Collection<? extends b0<STATE, ?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "childNodes");
        super(r100);
    }
}
