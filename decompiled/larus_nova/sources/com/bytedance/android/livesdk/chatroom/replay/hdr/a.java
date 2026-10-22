package com.bytedance.android.livesdk.chatroom.replay.hdr;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f108739a = null;

    static {
        f108739a = new a();
    }

    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        y.b("设备不支持当前清晰度播放", 0);
    }
}
