package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdk.utils.f5;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RestartLiveStateRepository f106156a;

    public b(RestartLiveStateRepository r100) {
        this.f106156a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        f5 r100 = this.f106156a.f106150e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imManager");
    L5:
        r100.release();
    }
}
