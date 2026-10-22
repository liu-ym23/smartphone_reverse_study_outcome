package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class i0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yz0.g f128355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a f128356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y f128357c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final ReceiverType a() {
        if (this.f128356b.j() == true) goto L20;
        i12.d r100 = i12.m.f487958e2.a();
        if (r100 == null) goto L8;
        com.bytedance.android.scope.m.f163449e.getClass();
        com.bytedance.android.scope.o r101 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r100).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L9:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r102 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r101;
        if (r102 == null) goto L13;
        ReceiverType r103 = r102.f128463b;
        if (r103 == null) goto L13;
    L17:
        if (r103 == null) goto L19;
        return r103;
    L19:
        return ReceiverType.Anchor;
    L13:
        IBaseUser r104 = this.f128357c.i();
        if (r104 == null) goto L16;
        r103 = this.f128357c.h(r104);
        goto L17
    L16:
        r103 = null;
        goto L17
    L8:
        r101 = null;
        goto L9
    L20:
        return ReceiverType.AllMic;
    }

    public i0(yz0.g r100, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r101, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r102) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "allMicService");
        Intrinsics.checkNotNullParameter(r102, "selectReceiverService");
        this.f128355a = r100;
        this.f128356b = r101;
        this.f128357c = r102;
    }
}
