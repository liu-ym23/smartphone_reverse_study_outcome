package com.bytedance.android.livesdkapi.feed;

import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010 \u001a\u00020!H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "left", "getLeft", "setLeft", "top", "getTop", "setTop", LiveDegradeFpsAnimator.TRANSLATION_X, "", "getTranslationX", "()Ljava/lang/Float;", "setTranslationX", "(Ljava/lang/Float;)V", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "setTranslationY", "width", "getWidth", "setWidth", "requestLayout", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewPlayerContainerAbility {
    Integer getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    Integer getLeft();

    Integer getTop();

    Float getTranslationX();

    Float getTranslationY();

    Integer getWidth();

    void requestLayout();

    void setHeight(Integer r100);

    void setLayoutParams(ViewGroup.LayoutParams r100);

    void setLeft(Integer r100);

    void setTop(Integer r100);

    void setTranslationX(Float r100);

    void setTranslationY(Float r100);

    void setWidth(Integer r100);
}
