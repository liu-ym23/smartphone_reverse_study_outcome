package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/DummyItemView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DummyItemView extends MusicOperateView {
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void e(MusicOperateType r100) {
        Intrinsics.checkNotNullParameter(r100, "musicOperateType");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public final void h(MusicOperateType r100) {
        Intrinsics.checkNotNullParameter(r100, "musicOperateType");
    }

    public DummyItemView(MusicOperateType r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "musicOperateType");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
