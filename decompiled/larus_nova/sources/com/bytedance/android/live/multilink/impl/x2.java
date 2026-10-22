package com.bytedance.android.live.multilink.impl;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceAnchorContainerWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceGuestContainerWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class x2 extends a implements com.bytedance.android.scope.o, IService, IMultiLinkExternalService, IMultiLinkInternalService {
    @Override // com.bytedance.android.scope.o
    public void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public void onStop() {
    }

    public x2() {
        jc1.k.l(IMultiLinkInternalService.class, this);
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public BaseMultiLinkWidget createVoiceGuestContainerWidget(hh1.w0 r100, gd0.p r101) {
        Intrinsics.checkNotNullParameter(r101, "liveCycleCallback");
        return new MultiLinkVoiceGuestContainerWidget(r100, r101);
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public cg6.a getMultiLinkComponentService(Object r100, Object r101) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L22:
        jn0.b r102 = getInRoomService();
        if (r102 != null) goto L25;
        return null;
    L25:
        return r102.Pl();
    L5:
        if ((r100 instanceof DataCenter) == false) goto L14;
        com.bytedance.live.datacontext.n<bn0.b> r103 = com.bytedance.android.live.liveinteract.api.utils.m.n((DataCenter) r100, null, 2).getMultiLinkRoomScope();
        if (r103 == null) goto L9;
        bn0.b r104 = r103.getValue();
    L10:
        if (r104 == null) goto L14;
        return (cg6.a) com.bytedance.android.scope.m.f163449e.d(r104, cg6.a.class);
    L9:
        r104 = null;
    L14:
        if ((r101 instanceof com.bytedance.android.livesdk.chatroom.o) == false) goto L22;
        com.bytedance.live.datacontext.n<bn0.b> r105 = ((com.bytedance.android.livesdk.chatroom.o) r101).getMultiLinkRoomScope();
        if (r105 == null) goto L18;
        bn0.b r106 = r105.getValue();
    L19:
        if (r106 == null) goto L22;
        return (cg6.a) com.bytedance.android.scope.m.f163449e.d(r106, cg6.a.class);
    L18:
        r106 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public BaseMultiLinkWidget createVoiceAnchorContainerWidget(FragmentManager r100, com.bytedance.android.live.pushstream.d r101, hh1.w0 r102) {
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        return new MultiLinkVoiceAnchorContainerWidget(r100, r101, r102);
    }
}
