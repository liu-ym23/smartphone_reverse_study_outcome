package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback$Code;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ce2.a {
    public c() {
    }

    @Override // ce2.a
    public final void release() {
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatus");
        return new JsonObject();
    }

    @Override // ce2.a
    public final void a(hd2.c r100, h.b r101) {
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "bizId is not support", null);
    }
}
