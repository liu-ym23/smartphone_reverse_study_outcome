package com.bytedance.android.live.room;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface u {
    void a(DataCenter r100, List<ToolbarButton> r101);

    void b(DataCenter r100, List<ToolbarButton> r101);

    void c(List<ExtendedToolbarButton> r100, boolean r101);

    List<Runnable> d(DataCenter r100, Context r101);

    void e(DataCenter r100, List<ToolbarButton> r101);

    void f();
}
