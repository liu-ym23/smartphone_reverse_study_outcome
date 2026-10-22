package com.bytedance.android.livesdk.vscore_api.paidlive.ability;

import android.graphics.Rect;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f159425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f159426b;

    public r() {
        this(PaidSceneEnum.PAID_ROOM, false, null);
    }

    public r(PaidSceneEnum r100, boolean r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "paidScene");
        this.f159425a = r101;
        this.f159426b = r102;
    }
}
