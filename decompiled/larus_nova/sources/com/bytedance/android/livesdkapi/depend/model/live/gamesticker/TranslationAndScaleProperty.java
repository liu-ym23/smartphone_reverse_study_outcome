package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/TranslationAndScaleProperty;", "", "()V", LiveDegradeFpsAnimator.SCALE_X, "", "getScaleX", "()F", "setScaleX", "(F)V", LiveDegradeFpsAnimator.SCALE_Y, "getScaleY", "setScaleY", LiveDegradeFpsAnimator.TRANSLATION_X, "getTranslationX", "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "setTranslationY", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TranslationAndScaleProperty {
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;

    public TranslationAndScaleProperty() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void setScaleX(float r100) {
        this.scaleX = r100;
    }

    public final void setScaleY(float r100) {
        this.scaleY = r100;
    }

    public final void setTranslationX(float r100) {
        this.translationX = r100;
    }

    public final void setTranslationY(float r100) {
        this.translationY = r100;
    }
}
