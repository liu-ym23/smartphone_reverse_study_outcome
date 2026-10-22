package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/HorizontalSeekBarMorphFrame;", "Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initForce", "", "d", "(F)V", "force", "a", "b", "()V", "Landroid/view/MotionEvent;", "motionEvent", "c", "(Landroid/view/MotionEvent;)F", "onDetachedFromWindow", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class HorizontalSeekBarMorphFrame extends SeekBarMorphParentLayout {
    @JvmOverloads
    public HorizontalSeekBarMorphFrame(@NotNull Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void a(float r10) {
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void b() {
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public float c(MotionEvent r10) {
        q.g(r10, "motionEvent");
        return r10.getX() - getLastTouchPoint().x;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void d(float r10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @JvmOverloads
    public HorizontalSeekBarMorphFrame(@NotNull Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ HorizontalSeekBarMorphFrame(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public HorizontalSeekBarMorphFrame(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
