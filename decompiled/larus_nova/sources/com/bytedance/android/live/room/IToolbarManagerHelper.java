package com.bytedance.android.live.room;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public interface IToolbarManagerHelper extends IService {
    c0 both(DataCenter r100);

    c0 folder(DataCenter r100);

    com.bytedance.android.livesdk.chatroom.utils.c0 toolbarHelper(DataCenter r100);

    c0 unfolder(DataCenter r100);
}
