package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends b implements com.bytedance.android.livesdk.interactivity.api.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f135151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f135152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.message.h f135153h;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final int a() {
        return 6;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final String getDesc() {
        String r100 = this.f135153h.c();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public d(Drawable r100, com.bytedance.android.live.base.model.message.h r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "spanDrawable");
        Intrinsics.checkNotNullParameter(r101, "guideChatConf");
        Intrinsics.checkNotNullParameter(r102, "text");
        super(r100, r103, r104);
        this.f135153h = r101;
        this.f135151f = r102.length();
        String r105 = r101.c();
        if (r105 == null) goto L5;
        int r106 = r105.length();
    L6:
        this.f135152g = r106;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
