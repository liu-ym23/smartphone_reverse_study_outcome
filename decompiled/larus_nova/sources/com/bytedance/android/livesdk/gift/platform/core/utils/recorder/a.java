package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseRecorder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f132066f;

    public a() {
        super("BGiftRecorder");
        this.f132066f = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.f130689z.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[24])).intValue() * 1000;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.BaseRecorder
    public final boolean j(h r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "record");
        if (this.f132061b == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f132060a, "flushTimeMs - record.startConsumeTms = " + (r101 - r100.f132081g));
    L6:
        if (super.j(r100, r101) == true) goto L8;
    L10:
        return false;
    L8:
        if ((r101 - r100.f132081g) <= this.f132066f) goto L10;
        return true;
    }
}
