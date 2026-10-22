package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f81062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f81063b;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f81064a;

        public b(f r100) {
            this.f81064a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r102).setAnimationListener(new g(this));
            return;
        }
    }

    static {
    }

    public final View a(int r100) {
        if (this.f81062a != null) goto L5;
        this.f81062a = new LinkedHashMap();
    L5:
        View r101 = this.f81062a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f81062a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(String r100) {
        PipelineDraweeControllerBuilder r101 = Fresco.newDraweeControllerBuilder();
        HSImageView r102 = (HSImageView) a(R.id.ttlive_animationView);
        if (r102 == null) goto L5;
        DraweeController r103 = r102.getController();
    L6:
        AbstractDraweeController r104 = r101.setOldController(r103).setUri(r100).setControllerListener(new b(this)).setAutoPlayAnimations(true).build();
        HSImageView r105 = (HSImageView) a(R.id.ttlive_animationView);
        if (r105 == null) goto L10;
        r105.setController(r104);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void c(String r100) {
        boolean r101 = true;
        if ((!Intrinsics.areEqual(r100, this.f81063b)) == false) goto L13;
        if (r100 != null) goto L6;
    L9:
        if (r101 == false) goto L11;
        this.f81063b = vm2.d.a0().unkownMediaAnim;
        goto L13
    L11:
        this.f81063b = r100;
        goto L13
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
    L13:
        if (((HSImageView) a(R.id.ttlive_animationView)).getVisibility() != 8) goto L16;
        ((HSImageView) a(R.id.ttlive_animationView)).setVisibility(0);
        b(this.f81063b);
        return;
    }

    public f(Context r100, IBaseUser r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "user");
        super(r100);
        this.f81062a = new LinkedHashMap();
        this.f81063b = vm2.d.a0().unkownMediaAnim;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_guest_link_audio_view, this);
        py.k r102 = r101.getAvatarThumbKt();
        if (r102 == null) goto L7;
        List<String> r103 = r102.getUrls();
        if (r103 == null) goto L7;
        String r104 = (String) ListProtector.get(r103, 0);
    L8:
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        ImageLoader.d r105 = ImageLoader.load(qy.a.a(r104));
        r105.f66059d = new IterativeBoxBlurPostProcessor(4, 20);
        r105.a((HSImageView) a(R.id.ttlive_backgroundView));
        ImageLoader.bindDrawableResource((HSImageView) a(R.id.ttlive_foregroundView), R.drawable.ttlive_bg_cover_common_brick_34);
        ImageLoader.load(qy.a.a(r104)).a((HSImageView) a(R.id.ttlive_avatarView));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
