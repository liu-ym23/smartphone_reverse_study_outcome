package com.bytedance.android.livesdk.arch.data;

import android.content.Context;
import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes7.dex */
public final class s extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s f103804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f103805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final tlc.d f103806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l5 f103807h;

    @Override // com.bytedance.android.livesdk.arch.data.c
    public final c b() {
        s r100 = new s(getContext(), this.f103791b, this.f103792c, this.f103793d, this.f103806g, this.f103807h);
        r100.f103804e = this.f103804e;
        r100.f103805f = this.f103805f;
        return r100;
    }

    public s(Context r100, MiddlewareRoomContext r101, IRoom r102, DataCenter r103, tlc.d r104, l5 r105) {
        super(r100, r101, r102, r103);
        this.f103806g = r104;
        this.f103807h = r105;
    }
}
