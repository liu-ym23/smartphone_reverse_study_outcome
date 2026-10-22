package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.data.activityemoji.b f135143f;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final int a() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final String getDesc() {
        String r100 = this.f135143f.getName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public a(Drawable r100, com.bytedance.android.live.base.model.data.activityemoji.b r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "spanDrawable");
        Intrinsics.checkNotNullParameter(r101, "activityEmoji");
        super(r100, r102, r103);
        this.f135143f = r101;
    }
}
