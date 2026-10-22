package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.user.h<IBaseUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f110007a;

    public a(b r100) {
        this.f110007a = r100;
    }

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f110007a.f110009b.add(r100);
    }
}
