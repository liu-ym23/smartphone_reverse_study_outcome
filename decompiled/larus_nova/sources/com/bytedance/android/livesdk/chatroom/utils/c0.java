package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarSlot;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface c0 {
    void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r100, ExtendedToolbarButton r101);

    String b();

    Map<ExtendedToolbarButton, ToolbarSlot> c();

    void d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r100, ExtendedToolbarButton r101);

    ToolbarConstraints e();

    void f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r100, ExtendedToolbarButton r101);

    Map<ExtendedToolbarButton, ToolbarSlot> g();

    ArrayList<ExtendedToolbarButton> h();

    int i(ExtendedToolbarButton r100);
}
