package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i00.a f105500a;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.c a() {
        com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.c r100 = this.f105500a.getInitData();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.BroadcastShellInitData");
    }

    public final FragmentActivity getActivity() {
        return this.f105500a.getActivity();
    }

    public final Context getContext() {
        return this.f105500a.getActivity();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastEnvInitService start");
    }

    public d(i00.a r100) {
        Intrinsics.checkNotNullParameter(r100, "inLiveInstance");
        this.f105500a = r100;
    }
}
