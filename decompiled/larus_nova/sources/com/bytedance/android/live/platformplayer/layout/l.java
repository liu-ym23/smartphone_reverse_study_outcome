package com.bytedance.android.live.platformplayer.layout;

import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements com.bytedance.android.live.core.utils.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerWidget f85660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f85661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HSImageView f85662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.message.y0 f85663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f85664e;

    public static final class a extends com.bytedance.android.live.core.utils.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f85665a;

        public a(l r100) {
            this.f85665a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void f(py.k r100, Exception r101) {
            this.f85665a.f85662c.setVisibility(0);
            this.f85665a.f85661b.setVisibility(8);
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            LivePlayerWidget r103 = this.f85665a.f85660a;
            r103.Q = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ValueAnimator r104 = this.f85665a.f85660a.Q;
            if (r104 == null) goto L5;
            r104.addUpdateListener(new j(this));
        L5:
            l r105 = this.f85665a;
            ValueAnimator r106 = r105.f85660a.Q;
            if (r106 == null) goto L8;
            r106.setDuration(r105.f85664e);
        L8:
            ValueAnimator r107 = this.f85665a.f85660a.Q;
            if (r107 == null) goto L11;
            r107.addListener(new k(this));
        L11:
            l r108 = this.f85665a;
            LivePlayerWidget r109 = r108.f85660a;
            r109.R = r108.f85663d.getImage();
            ValueAnimator r110 = this.f85665a.f85660a.Q;
            if (r110 == null) goto L15;
            r110.start();
            return;
        }
    }

    public l(LivePlayerWidget r100, HSImageView r101, HSImageView r102, com.bytedance.android.live.base.model.message.y0 r103, long r104) {
        this.f85660a = r100;
        this.f85661b = r101;
        this.f85662c = r102;
        this.f85663d = r103;
        this.f85664e = r104;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void b(py.k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        this.f85661b.setVisibility(0);
        this.f85661b.setAlpha(1.0f);
        this.f85662c.setAlpha(0.0f);
        ImageLoader.bindImage(this.f85662c, this.f85663d.getImage(), new a(this));
    }
}
