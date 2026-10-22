package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w2 implements com.bytedance.android.scope.o, y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f117544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2 f117545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y0 f117546c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final com.bytedance.android.livesdk.chatroom.model.e3 Qn() {
        return this.f117546c.Qn();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean Z5(long r100) {
        return this.f117546c.Z5(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean fi(long r100) {
        return this.f117546c.fi(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final void ve() {
        this.f117546c.ve();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final int wm(long r100) {
        return this.f117546c.wm(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.d(this.f117544a, "on sticker service start");
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ALogger.d(this.f117544a, "on sticker service stop");
    }

    public w2(u2 r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f117546c = r100.n();
        this.f117545b = r100;
        this.f117544a = "StickerService";
    }
}
