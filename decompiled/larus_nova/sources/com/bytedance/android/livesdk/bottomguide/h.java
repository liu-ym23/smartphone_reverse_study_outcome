package com.bytedance.android.livesdk.bottomguide;

import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.z0;
import com.bytedance.android.livesdkapi.service.IGuideManagerService;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public class h implements IGuideManagerService {
    public h() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IGuideManagerService
    public boolean isShowingAuthDialog() {
        int r100 = we1.a.f559383a;
        int r101 = we1.a.f559383a;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.IGuideManagerService
    public boolean isShowingCleanGuide() {
        int r100 = z.f117681a;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.IGuideManagerService
    public boolean isShowingSlideUpGuide() {
        IMiddlewareRoomService r100 = (IMiddlewareRoomService) k.f(IMiddlewareRoomService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSlideUpTipShowing();
    }

    @Override // com.bytedance.android.livesdkapi.service.IGuideManagerService
    public boolean isShowingGuide() {
        if (isShowingCleanGuide() == false) goto L5;
    L14:
        return true;
    L5:
        if (isShowingSlideUpGuide() == true) goto L14;
        if (isShowingBottomGuide() == true) goto L14;
        if (isShowingAuthDialog() == true) goto L14;
        if (z0.f117683b == true) goto L14;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.IGuideManagerService
    public boolean isShowingBottomGuide() {
        return b.f104358b;
    }
}
