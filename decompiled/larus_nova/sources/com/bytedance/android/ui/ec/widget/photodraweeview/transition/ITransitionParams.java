package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0018\u0010\u0012\u001a\u00020\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/ITransitionParams;", "", "getExitRect", "Lkotlin/Function0;", "Landroid/graphics/Rect;", "getGetExitRect", "()Lkotlin/jvm/functions/Function0;", "setGetExitRect", "(Lkotlin/jvm/functions/Function0;)V", "isDragReturnAnimationEnabled", "", "()Z", "setDragReturnAnimationEnabled", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITransitionParams {
    Function0<Rect> getGetExitRect();

    float getMaxDragTransitionFactor();

    Rect getStartRect();

    long getTransitionAnimationDuration();

    boolean isDragReturnAnimationEnabled();

    boolean isDragTransitionEnabled();

    boolean isSingleTagDismissEnabled();

    void setDragReturnAnimationEnabled(boolean r100);

    void setDragTransitionEnabled(boolean r100);

    void setGetExitRect(Function0<Rect> r100);

    void setMaxDragTransitionFactor(float r100);

    void setSingleTagDismissEnabled(boolean r100);

    void setStartRect(Rect r100);

    void setTransitionAnimationDuration(long r100);
}
