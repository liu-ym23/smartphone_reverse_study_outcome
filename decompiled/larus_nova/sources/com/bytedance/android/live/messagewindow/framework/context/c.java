package com.bytedance.android.live.messagewindow.framework.context;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.live.datacontext.j;
import d71.d;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends y61.b {
    j<y61.a> getCommonCardContext();

    @Override // y61.b
    d<v61.a, d71.b> recordManager(MsgWindowPosition r100);

    @Override // y61.b
    q71.a stateDispatcher();
}
