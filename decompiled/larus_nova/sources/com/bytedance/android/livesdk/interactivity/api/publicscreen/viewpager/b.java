package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    LiveTetris<? extends d90.d> b();

    Context getActivity();

    DataCenter getDataCenter();
}
