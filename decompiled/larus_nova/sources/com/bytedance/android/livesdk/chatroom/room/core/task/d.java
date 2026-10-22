package com.bytedance.android.livesdk.chatroom.room.core.task;

import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.bytedance.android.livesdk.chatroom.detail.a.InterfaceC1585a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f111016a;

    public d(c r100) {
        this.f111016a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.detail.a.InterfaceC1585a
    public final void a(BackendGeneratedData r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f111016a.f111012b.setBackendRoomContext(r100);
    }
}
