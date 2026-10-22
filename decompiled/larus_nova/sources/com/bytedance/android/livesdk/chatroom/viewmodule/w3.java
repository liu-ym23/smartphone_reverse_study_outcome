package com.bytedance.android.livesdk.chatroom.viewmodule;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w3 extends e33.j implements u2, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f117547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.scope.j f117548f;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.viewmodule.__ScopeImpl_StickerScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.u2
    public final y0 n() {
        Object r100 = this.f117547e;
        if (r100 == null) goto L7;
        return (y0) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.IStickerManager");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f117548f;
    }

    public w3(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f117548f = r100;
        this.f117547e = e33.k.f470908a;
    }
}
