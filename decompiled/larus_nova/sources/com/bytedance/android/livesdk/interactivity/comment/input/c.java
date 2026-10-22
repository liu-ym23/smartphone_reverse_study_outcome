package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f135149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.emoji.a f135150g;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final int a() {
        return 5;
    }

    public final String c() {
        List<String> r100 = this.f135150g.e();
        if (r100 == null) goto L7;
        String r101 = CollectionsKt.joinToString$default(r100, "", null, null, 0, null, null, 62, null);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return getDesc();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b, e90.a
    public final String getDesc() {
        String r100 = this.f135150g.d();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public int getType() {
        return this.f135149f;
    }

    public c(Drawable r100, com.bytedance.android.livesdk.interactivity.api.emoji.a r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "spanDrawable");
        Intrinsics.checkNotNullParameter(r101, "fusionEmoji");
        super(r100, r102, r103);
        this.f135150g = r101;
        this.f135149f = 1;
    }
}
