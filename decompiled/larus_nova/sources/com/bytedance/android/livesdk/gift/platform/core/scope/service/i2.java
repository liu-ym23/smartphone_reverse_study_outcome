package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i2 implements com.bytedance.android.scope.o, w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f131592a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d() {
        return ((Boolean) ay1.b.T.getValue(null, ay1.b.f16675a[57])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        if (gb2.a.a(this.f131592a, false) == false) goto L6;
        return ((Boolean) ay1.b.V.getValue(null, ay1.b.f16675a[59])).booleanValue();
    L6:
        return ((Boolean) ay1.b.U.getValue(null, ay1.b.f16675a[58])).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.w2
    public final k getCurrentSoundVibrationStatus() {
        k r100 = new k();
        r100.a(c());
        return r100;
    }

    public i2(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f131592a = r100;
    }

    public final void a(boolean r100) {
        if (gb2.a.a(this.f131592a, false) == false) goto L5;
        ay1.b.B(r100);
        return;
    L5:
        ay1.b.A(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.w2
    public final void setCurrentSoundVibrationStatus(boolean r100) {
        a(r100);
    }
}
