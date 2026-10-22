package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements vr1.w, com.bytedance.android.scope.o {
    public n() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.w
    public final void a(HSImageView r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r101, Object r102, com.bytedance.android.livesdk.vscore_impl.behavior.a r103) {
        Intrinsics.checkNotNullParameter(r101, "button");
        Intrinsics.checkNotNullParameter(r103, "callback");
        SkinLoader.f114373c.getClass();
        if (SkinLoader.a.b() == false) goto L10;
        SkinLoader r104 = SkinLoader.a.e(r101);
        if (r100 == null) goto L11;
        ResKeyEnum r105 = ResKeyEnum.MULTI_CAMERA;
        if (r104.b(y2.b(r105)) == null) goto L12;
        r103.b();
        r104.c(y2.a(r105, r102), r100, new m(r103));
        return;
    L12:
        return;
    L11:
        return;
    }
}
