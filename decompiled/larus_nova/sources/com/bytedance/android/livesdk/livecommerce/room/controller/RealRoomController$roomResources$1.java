package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class RealRoomController$roomResources$1 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<MutableLiveData<Boolean>> f151439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RealRoomController f151440b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final String a() {
        return this.f151440b.I;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final Context context() {
        return this.f151440b.getContext();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final MutableLiveData<Boolean> d() {
        RealRoomController r100 = this.f151440b;
        com.bytedance.android.livesdk.livecommerce.room.api.f r101 = r100.f151450e;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        return r101.getPlaying();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.h r102 = r100.f151451f;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r102);
        return r102.getPlaying();
    L9:
        return this.f151439a.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.livesdk.livecommerce.room.api.c e() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r100 = this.f151440b.f151449d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("functionHandler");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final MutableLiveData f() {
        return this.f151440b.f151419j;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.livesdk.livecommerce.room.api.e g() {
        com.bytedance.android.livesdk.livecommerce.room.api.e r100 = this.f151440b.f151446a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final LiveRoomParams h() {
        RealRoomController r100 = this.f151440b;
        LiveRoomParams r101 = r100.f151418i;
        if (r101 == null) goto L5;
        return r101;
    L5:
        return r100.f(null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.ec.adapter.api.state.a i() {
        return this.f151440b.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean isPreview() {
        return this.f151440b.l();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean j() {
        if (this.f151440b.f151448c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final ECContext k() {
        ECContext r100 = this.f151440b.D;
        if (r100 != null) goto L6;
        ECContext r101 = new ECContext(isPreview());
        this.f151440b.D = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean l() {
        if (this.f151440b.f151449d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean n() {
        if (this.f151440b.f151447b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean o() {
        return this.f151440b.f151416g;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final RealRoomController m() {
        return this.f151440b;
    }

    public RealRoomController$roomResources$1(RealRoomController r100) {
        this.f151440b = r100;
        this.f151439a = LazyKt.lazy(RealRoomController$roomResources$1$playStatusFallback$1.INSTANCE);
    }
}
