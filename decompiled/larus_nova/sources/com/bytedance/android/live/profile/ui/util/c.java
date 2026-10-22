package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f86937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f86938b;

    public static final class a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f86939a;

        public a(c r100) {
            this.f86939a = r100;
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
            if (r101 <= 0) goto L5;
            a1.p(this.f86939a.f86937a, UtilityKotlinExtentionsKt.i(r101 / 3));
            return;
        }
    }

    public c(HSImageView r100, py.k r101) {
        this.f86937a = r100;
        this.f86938b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageUtil.loadImage(this.f86937a, this.f86938b, new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
