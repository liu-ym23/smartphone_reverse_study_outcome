package com.bytedance.android.live.multilink.voicechat.api.service;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.Widget;
import gd0.p;
import hh1.w0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.multilink.voicechat.impl.MultiLinkVoiceChatService")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/multilink/voicechat/api/service/IMultiLinkVoiceService;", "Lcom/bytedance/android/live/base/IService;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lhh1/w0;", "callback", "", "startFromScene", "startFromUiLayout", "Lcom/bytedance/ies/sdk/widgets/Widget;", "createVoiceChatRoomAnchorWidget", "Lgd0/p;", "liveCycleCallback", "createVoiceChatRoomGuestWidget", "multilink-voicechat-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMultiLinkVoiceService extends IService {
    Widget createVoiceChatRoomAnchorWidget(FragmentManager r100, d r101, w0 r102, int r103, int r104);

    Widget createVoiceChatRoomGuestWidget(w0 r100, p r101);
}
