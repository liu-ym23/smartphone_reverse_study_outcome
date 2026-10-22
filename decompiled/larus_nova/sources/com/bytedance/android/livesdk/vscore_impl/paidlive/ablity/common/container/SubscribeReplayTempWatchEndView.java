package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.container;

import com.bytedance.android.livesdk.vscore_api.paidlive.scope.a;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/paidlive/ablity/common/container/SubscribeReplayTempWatchEndView;", "Lcom/bytedance/android/livesdk/vscore_impl/paidlive/ablity/common/container/PaidReplayRoomWatchEndView;", "", "getLayoutId", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubscribeReplayTempWatchEndView extends PaidReplayRoomWatchEndView {
    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.container.PaidReplayRoomWatchEndView
    public int getLayoutId() {
        return R.layout.ttlive_subscribe_replay_temp_end_view;
    }

    public SubscribeReplayTempWatchEndView(a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100);
    }
}
