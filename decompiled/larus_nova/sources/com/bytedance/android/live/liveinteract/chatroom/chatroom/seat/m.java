package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DynamicEmojiView f72332b;

    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HSImageView f72333a;

        public a(HSImageView r100) {
            this.f72333a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if ((r102 instanceof AnimatedDrawable2) == false) goto L8;
            AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
            r104.setAnimationListener(new l(this));
            AnimationBackend r105 = r104.getAnimationBackend();
            if (r105 == null) goto L9;
            r104.setAnimationBackend(new k(r105));
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof n) == false) goto L16;
        DynamicEmojiView r101 = this.f72332b;
        if (r101 == null) goto L20;
        HSImageView r102 = r101.getRandomEmojiView();
        if (r102 == null) goto L21;
        String r103 = ((n) r100).f72334a.i();
        if (r103 != null) goto L11;
        return;
    L11:
        if ((!TextUtils.isEmpty(r103)) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L23;
        r102.setVisibility(0);
        r102.setController(Fresco.newDraweeControllerBuilder().setUri(r103).setAutoPlayAnimations(true).setControllerListener(new a(r102)).build());
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L16:
        d r104 = this.f72224a;
        if (r104 == null) goto L25;
        r104.b(r100);
        return;
    }

    public m(f r100, DynamicEmojiView r101) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f72332b = r101;
    }
}
