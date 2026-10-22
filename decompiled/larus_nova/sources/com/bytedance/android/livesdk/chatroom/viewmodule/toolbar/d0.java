package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements x {

    public static final class a implements com.bytedance.android.livesdk.service.k.b<x> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [R, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d0] */
        @Override // com.bytedance.android.livesdk.service.k.b
        public final com.bytedance.android.livesdk.service.k.b.a<x> setup(com.bytedance.android.livesdk.service.k.b.a<x> r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            r100.f158001a = new d0();
            r100.f158002b = true;
            return r100;
        }
    }

    public d0() {
    }
}
