package com.bytedance.android.livesdkapi.roomplayer;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import ry.k;
import ty.c;

/* JADX INFO: loaded from: classes12.dex */
public interface ILivePreviewCoverView extends k {
    /* synthetic */ void cancelAutoEnterGuide(boolean r100);

    /* synthetic */ View getView();

    /* synthetic */ void onShow();

    /* synthetic */ void pause();

    /* synthetic */ void release();

    /* synthetic */ void resume();

    /* synthetic */ void setCustomBottomView(View r100);

    /* synthetic */ void setLiveStatusListener(c r100);

    /* synthetic */ void setMute(boolean r100);

    /* synthetic */ void setOnDislikeCallback(sy.c r100);

    void stream(Room r100);

    /* synthetic */ void stream(String r100);
}
