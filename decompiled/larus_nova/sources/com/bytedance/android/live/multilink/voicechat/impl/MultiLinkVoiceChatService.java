package com.bytedance.android.live.multilink.voicechat.impl;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.multilink.voicechat.api.service.IMultiLinkVoiceService;
import com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatRoomAnchorWidget;
import com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatRoomGuestWidget;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.ies.sdk.widgets.Widget;
import gd0.p;
import hh1.w0;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J6\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/multilink/voicechat/impl/MultiLinkVoiceChatService;", "Lcom/bytedance/android/live/multilink/voicechat/api/service/IMultiLinkVoiceService;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lhh1/w0;", "callback", "", "startFromScene", "startFromUiLayout", "Lcom/bytedance/ies/sdk/widgets/Widget;", "createVoiceChatRoomAnchorWidget", "Lgd0/p;", "liveCycleCallback", "createVoiceChatRoomGuestWidget", "<init>", "()V", "multilink-voicechat-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkVoiceChatService implements IMultiLinkVoiceService {
    public MultiLinkVoiceChatService() {
        k.l(IMultiLinkVoiceService.class, this);
    }

    @Override // com.bytedance.android.live.multilink.voicechat.api.service.IMultiLinkVoiceService
    public Widget createVoiceChatRoomGuestWidget(w0 r100, p r101) {
        Intrinsics.checkNotNullParameter(r101, "liveCycleCallback");
        return new MultiLinkVoiceChatRoomGuestWidget(r100, r101);
    }

    @Override // com.bytedance.android.live.multilink.voicechat.api.service.IMultiLinkVoiceService
    public Widget createVoiceChatRoomAnchorWidget(FragmentManager r100, d r101, w0 r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        return new MultiLinkVoiceChatRoomAnchorWidget(r101, r102, r103, r104);
    }
}
