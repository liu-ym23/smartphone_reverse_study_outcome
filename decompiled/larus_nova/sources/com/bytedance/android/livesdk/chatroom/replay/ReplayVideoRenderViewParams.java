package com.bytedance.android.livesdk.chatroom.replay;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/ReplayVideoRenderViewParams;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoRenderViewParams implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<VideoViewParams> f108090a;

    /* JADX WARN: Multi-variable type inference failed */
    public ReplayVideoRenderViewParams(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        MutableLiveData<VideoViewParams> r101 = new MutableLiveData();
        this.f108090a = r101;
        if (r100.get("live_render_view_params", null) == null) goto L5;
        r101.setValue(r100.get("live_render_view_params", null));
    L5:
        r100.observe("live_render_view_params", this);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L17;
        MutableLiveData<VideoViewParams> r102 = null;
        VideoViewParams r103 = (VideoViewParams) r101.getData(null);
        if (r103 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.getKey(), "live_render_view_params") == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L19;
        MutableLiveData<VideoViewParams> r104 = this.f108090a;
        if ((!Intrinsics.areEqual(r104.getValue(), r103)) == false) goto L14;
        r102 = r104;
    L14:
        if (r102 == null) goto L20;
        r102.setValue(r103);
        return;
    L20:
        return;
    L19:
        return;
    }
}
