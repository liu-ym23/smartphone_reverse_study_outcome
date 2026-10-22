package com.bytedance.android.livesdkapi.feed;

import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010*\u001a\u00020%H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR(\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LivePreviewPlayerContainerAbility;", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "value", "", "height", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "left", "getLeft", "setLeft", "top", "getTop", "setTop", "", LiveDegradeFpsAnimator.TRANSLATION_X, "getTranslationX", "()Ljava/lang/Float;", "setTranslationX", "(Ljava/lang/Float;)V", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "setTranslationY", "width", "getWidth", "setWidth", "log", "", "msg", "", "logLayoutParams", "lp", "requestLayout", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewPlayerContainerAbility implements IPreviewPlayerContainerAbility {
    private ViewGroup container;

    private final void log(String r100) {
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Integer getHeight() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getHeight());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLayoutParams();
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Integer getLeft() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getLeft());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Integer getTop() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getTop());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Float getTranslationX() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getTranslationX());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Float getTranslationY() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getTranslationY());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public Integer getWidth() {
        ViewGroup r100 = this.container;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getWidth());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void requestLayout() {
        ViewGroup r100 = this.container;
        if (r100 == null) goto L6;
        r100.requestLayout();
        return;
    }

    public LivePreviewPlayerContainerAbility(ViewGroup r100) {
        this.container = r100;
    }

    private final String logLayoutParams(ViewGroup.LayoutParams r100) {
        StringBuilder r101 = new StringBuilder("width = ");
        Integer r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.width);
    L6:
        r101.append(r103);
        r101.append("、height = ");
        if (r100 == null) goto L9;
        r102 = Integer.valueOf(r100.height);
    L9:
        r101.append(r102);
        return r101.toString();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setHeight(Integer r100) {
        StringBuilder r101 = new StringBuilder("height change: ");
        ViewGroup.LayoutParams r102 = null;
        if (r100 == null) goto L5;
        String r103 = String.valueOf(r100.intValue());
    L6:
        r101.append(r103);
        log(r101.toString());
        if (r100 == null) goto L17;
        int r104 = r100.intValue();
        ViewGroup r105 = this.container;
        if (r105 == null) goto L11;
        r102 = r105.getLayoutParams();
    L11:
        if (r102 == null) goto L13;
        r102.height = r104;
    L13:
        ViewGroup r106 = this.container;
        if (r106 == null) goto L18;
        r106.setLayoutParams(r102);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        log("layoutParams change: " + logLayoutParams(r100));
        if (r100 == null) goto L8;
        ViewGroup r101 = this.container;
        if (r101 == null) goto L9;
        r101.setLayoutParams(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setLeft(Integer r100) {
        StringBuilder r101 = new StringBuilder("left change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        log(r101.toString());
        if (r100 == null) goto L12;
        int r103 = r100.intValue();
        ViewGroup r104 = this.container;
        if (r104 == null) goto L13;
        r104.setLeft(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setTop(Integer r100) {
        StringBuilder r101 = new StringBuilder("top change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        log(r101.toString());
        if (r100 == null) goto L12;
        int r103 = r100.intValue();
        ViewGroup r104 = this.container;
        if (r104 == null) goto L13;
        r104.setTop(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setTranslationX(Float r100) {
        StringBuilder r101 = new StringBuilder("translationX change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.floatValue());
    L6:
        r101.append(r102);
        log(r101.toString());
        if (r100 == null) goto L12;
        float r103 = r100.floatValue();
        ViewGroup r104 = this.container;
        if (r104 == null) goto L13;
        r104.setTranslationX(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setTranslationY(Float r100) {
        StringBuilder r101 = new StringBuilder("translationY change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.floatValue());
    L6:
        r101.append(r102);
        log(r101.toString());
        if (r100 == null) goto L12;
        float r103 = r100.floatValue();
        ViewGroup r104 = this.container;
        if (r104 == null) goto L13;
        r104.setTranslationY(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public void setWidth(Integer r100) {
        StringBuilder r101 = new StringBuilder("width change: ");
        ViewGroup.LayoutParams r102 = null;
        if (r100 == null) goto L5;
        String r103 = String.valueOf(r100.intValue());
    L6:
        r101.append(r103);
        log(r101.toString());
        if (r100 == null) goto L17;
        int r104 = r100.intValue();
        ViewGroup r105 = this.container;
        if (r105 == null) goto L11;
        r102 = r105.getLayoutParams();
    L11:
        if (r102 == null) goto L13;
        r102.width = r104;
    L13:
        ViewGroup r106 = this.container;
        if (r106 == null) goto L18;
        r106.setLayoutParams(r102);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
