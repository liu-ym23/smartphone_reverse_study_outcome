package com.bytedance.android.livesdk.livecommerce.room.api;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public interface b {
    void a(com.bytedance.android.ec.adapter.api.state.a r100);

    void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101);

    void d(e r100);

    void e(f r100);

    void g(d r100);

    void i(c r100);

    void j(h r100);

    void onActivityCreated();

    void onContextAttached(Context r100);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onEnterRoomPrepared();

    void onExitRoom();

    void onFirstFrame();

    void onP0WidgetLoadFinished();

    void onPause();

    void onResume();

    void onRoomVisible();

    void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103);

    void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102);

    void onSpecificViewAttached(String r100);

    void onSpecificWidgetLoadFinished(String r100);

    void onStart();

    void onStop();

    void onWidgetLoadFinished();
}
