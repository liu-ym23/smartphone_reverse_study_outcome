package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.Canvas;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.e0;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.jvm.internal.Intrinsics;
import tc2.g;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> extends tk6.b<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f141812g;

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void e() {
        super.e();
        this.f141812g = 0.0f;
        RenderEntity r100 = c();
        of6.a r101 = this.f523105c;
        if (r101 == null) goto L9;
        RenderEntity r102 = r101.f254850a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L7:
        com.bytedance.live.artist.render.f r103 = r102.f254828c;
        if (r103 == null) goto L9;
    L10:
        com.bytedance.live.artist.render.f r104 = r100.f254828c;
        r104.f254852a = r103.f254852a;
        r104.f254853b = r103.f254853b;
        return;
    L9:
        r103 = new com.bytedance.live.artist.render.f();
        goto L10
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void f() {
        g r100 = (g) c().e(g.class);
        if (r100 == null) goto L5;
        float r101 = r100.f545387a;
    L6:
        Canvas r102 = this.f546532f;
        if (r102 == null) goto L9;
        r102.save();
    L9:
        Canvas r103 = this.f546532f;
        if (r103 == null) goto L12;
        r103.translate(this.f141812g, 0.0f);
    L12:
        this.f141812g += r101 * 0.2f;
        super.f();
        Canvas r104 = this.f546532f;
        if (r104 == null) goto L16;
        r104.restore();
        return;
    L16:
        return;
    L5:
        r101 = 0.0f;
        goto L6
    }

    public c(Object r100, e0 r101) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        super(r100, r101);
    }
}
