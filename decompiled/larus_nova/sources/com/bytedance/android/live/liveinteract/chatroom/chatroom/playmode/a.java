package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends xh0.d {
    boolean b(int r100);

    void clear();

    void d(DataCenter r100);

    void f(DataCenter r100);

    void g(DataCenter r100, BaseLinkMultiControlWidget.a r101);

    boolean l(DataCenter r100);

    void m(Widget r100, SceneType r101);

    boolean n(int r100);

    void o(DataCenter r100, Widget r101, SceneType r102, ViewGroup r103);

    void p(Widget r100, SceneType r101, ne0.c r102, boolean r103);
}
