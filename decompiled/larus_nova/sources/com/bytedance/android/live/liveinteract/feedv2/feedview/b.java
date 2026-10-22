package com.bytedance.android.live.liveinteract.feedv2.feedview;

import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public interface b extends a {
    Object getCurrentSeiParseResultData();

    String getCurrentSingUserIdString();

    HashMap<String, Object> getKtvEnterRoomExtraParam();

    Object getKtvSeiModelObject();

    void onKtvVideoStateChange(ld0.a r100);

    void resetKtvSeiModelObject();

    void setRenderViewBitmapToMockView();
}
