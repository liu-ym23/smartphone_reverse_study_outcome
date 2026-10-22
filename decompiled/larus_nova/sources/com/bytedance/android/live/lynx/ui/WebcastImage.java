package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.facebook.drawee.controller.ControllerListener;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes46.dex */
public class WebcastImage extends LynxUI<ImageView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f82726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f82728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animatable f82729d;

    public class a implements ControllerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebcastImage f82730a;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, @Nullable Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        public a(WebcastImage r100) {
            this.f82730a = r100;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, @Nullable Object r101, @Nullable Animatable r102) {
            this.f82730a.f82729d = r102;
        }
    }

    public final void M() {
        if (TextUtils.isEmpty(this.f82728c) == false) goto L5;
        return;
    L5:
        if (getView() != null) goto L8;
        return;
    L8:
        if (ImageUtil.isActivityOK(getView().getContext()) == true) goto L10;
        return;
    L10:
        Animatable r100 = this.f82729d;
        if (r100 != null) goto L13;
    L15:
        this.f82729d = null;
        FrescoLoader.with(getView().getContext()).load(this.f82728c).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(this.f82726a).fadeDuration(this.f82727b).controllerListener(new a(this)).into(getView());
        return;
    L13:
        if (r100.isRunning() == false) goto L15;
        this.f82729d.stop();
        goto L15
    }

    @LynxUIMethod
    public void startAnim() {
        Animatable r100 = this.f82729d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() == true) goto L9;
        this.f82729d.start();
        return;
    }

    @LynxUIMethod
    public void stopAnim() {
        Animatable r100 = this.f82729d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() == false) goto L9;
        this.f82729d.stop();
        return;
    }

    public WebcastImage(LynxContext r100) {
        super(r100);
        this.f82726a = false;
        this.f82727b = 300;
        this.f82728c = "";
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        return new ImageView(r100);
    }

    @LynxProp(name = "auto-play")
    public void setAutoPlay(boolean r100) {
        this.f82726a = r100;
        M();
    }

    @LynxProp(name = "fade-duration")
    public void setFadeDuration(int r100) {
        this.f82727b = r100;
        M();
    }

    @LynxProp(name = "src")
    public void setSrc(String r100) {
        this.f82728c = r100;
        if (getView() != null) goto L5;
    L8:
        M();
        return;
    L5:
        if (TextUtils.isEmpty(this.f82728c) == false) goto L7;
        getView().setVisibility(8);
        goto L8
    L7:
        getView().setVisibility(0);
        goto L8
    }
}
