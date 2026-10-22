package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends b implements com.bytedance.android.livesdk.interactivity.api.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f135154f;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final int a() {
        return 7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final String getDesc() {
        return this.f135154f;
    }

    public e(Drawable r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "spanDrawable");
        Intrinsics.checkNotNullParameter(r101, "text");
        super(r100, r102, r103);
        this.f135154f = r101;
    }
}
