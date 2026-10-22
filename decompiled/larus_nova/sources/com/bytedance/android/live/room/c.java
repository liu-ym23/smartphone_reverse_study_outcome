package com.bytedance.android.live.room;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    com.bytedance.live.datacontext.l<Boolean> getAuthorized();

    com.bytedance.live.datacontext.j<Boolean> getEnable();

    void onAnchorClickUnion(Context r100, DataCenter r101);
}
