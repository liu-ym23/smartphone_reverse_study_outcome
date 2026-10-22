package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerControlWidget f119152a;

    public o1(PlayerControlWidget r100) {
        this.f119152a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L10;
        IPlayerProgressService r101 = this.f119152a.f118601c;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L8:
        r101.handleProgressListener(PlayerControlWidget$registerPlayerEvent$3$1.INSTANCE);
        return;
    }
}
