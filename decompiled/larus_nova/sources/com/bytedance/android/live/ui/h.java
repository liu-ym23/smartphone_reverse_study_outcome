package com.bytedance.android.live.ui;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends c.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f102082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IVoiceLiveTheme f102083d;

    @Override // com.bytedance.android.live.core.utils.q0, com.bytedance.android.live.core.utils.p0
    public final void d(ImageInfo r100) {
        this.f102082c.f102068p.setTag(r100);
    }

    @Override // com.bytedance.android.live.ui.c.b, com.bytedance.android.live.core.utils.q0, com.bytedance.android.live.core.utils.p0
    public final void a(ImageInfo r100, Animatable r101) {
        c r102 = this.f102082c;
        r102.f102059g = r101;
        r102.f102068p.post(new g(this));
    }

    public h(c r100, IVoiceLiveTheme r101, IVoiceLiveTheme r102) {
        this.f102082c = r100;
        this.f102083d = r101;
        super(r100, r102);
    }
}
