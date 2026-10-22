package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class r2 implements com.bytedance.android.live.core.utils.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f114611a;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public r2(SkinLoader$loopLoadImg$2 r100) {
        this.f114611a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void b(py.k r100, Exception r101) {
        a4 r102 = this.f114611a;
        if (r102 == null) goto L6;
        r102.b(SkinLoadResultType.ERROR, "remote error");
        return;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        a4 r104 = this.f114611a;
        if (r104 == null) goto L6;
        r104.b(SkinLoadResultType.SUCCESS, "");
        return;
    }
}
