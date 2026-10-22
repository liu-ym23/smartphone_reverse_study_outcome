package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayEventHub$firstFrameWithTime$1", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lkotlin/Pair;", "", "", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayEventHub$firstFrameWithTime$1 extends NextLiveData<Pair<? extends Boolean, ? extends Long>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayEventHub f118073a;

    public ReplayEventHub$firstFrameWithTime$1(ReplayEventHub r100) {
        this.f118073a = r100;
    }

    @Override // com.bytedance.ies.sdk.widgets.NextLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(Object r100) {
        Pair r101 = (Pair) r100;
        super.setValue(r101);
        NextLiveData<Boolean> r102 = this.f118073a.f118048b;
        if (r101 == null) goto L7;
        boolean r103 = true;
        if (((Boolean) r101.getFirst()).booleanValue() != true) goto L7;
    L8:
        r102.setValue(Boolean.valueOf(r103));
        return;
    L7:
        r103 = false;
        goto L8
    }
}
