package com.obric.autoaction.vdplayer.components.cursor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.plugin.R;
import com.obric.common.oea.foundation.animation.h.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: CursorPressDownEffectView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CursorPressDownEffectView extends AppCompatImageView {
    private static final float ANIMATION_TARGET_FPS = 30.0f;
    private static final float ANIMATION_TARGET_SPEED = 1.0f;
    public static final a Companion = null;
    private com.obric.common.oea.foundation.animation.manager.d currentAnimation;

    /* JADX INFO: compiled from: CursorPressDownEffectView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public CursorPressDownEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public CursorPressDownEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$m-zJBboqxYJ2kaOObX3EUnPEVMQ, reason: not valid java name */
    public static /* synthetic */ x m661lambda$mzJBboqxYJ2kaOObX3EUnPEVMQ(CursorPressDownEffectView r0, boolean r1, Throwable r2) {
        return pressDown$lambda$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$qKWg9TNoS-Qi8fXJ8y7HDpvJeAQ, reason: not valid java name */
    public static /* synthetic */ x m662lambda$qKWg9TNoSQi8fXJ8y7HDpvJeAQ(CursorPressDownEffectView r0, boolean r1, Throwable r2) {
        return pressUp$lambda$1(r0, r1, r2);
    }

    public /* synthetic */ CursorPressDownEffectView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public CursorPressDownEffectView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        setScaleType(ImageView.ScaleType.FIT_XY);
        setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_cursor_press, "drawable", "ic_cursor_press"));
    }

    public final void pressDown() {
        Float r1 = Float.valueOf(0.0f);
        setAlpha(0.0f);
        setVisibility(0);
        com.obric.common.oea.foundation.animation.a.b.a r2 = com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ANIMATION_TARGET_SPEED, ANIMATION_TARGET_FPS);
        e.c r5 = e.c.f32441d;
        com.obric.common.oea.foundation.animation.a.b.a r0 = r2.a(ANIMATION_TARGET_SPEED, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32428a, r5, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), r1);
        e.c r3 = e.c.f32441d;
        e.d r6 = e.d.f32444b;
        this.currentAnimation = r0.b(ANIMATION_TARGET_SPEED, ANIMATION_TARGET_SPEED, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r3, e.b.f32433a, r6), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), r1).a(new $$Lambda$CursorPressDownEffectView$mzJBboqxYJ2kaOObX3EUnPEVMQ(this)).b().a(com.obric.common.oea.foundation.animation.d.b.f32344a, com.obric.common.oea.foundation.animation.d.a.f32340a, true);
    }

    private static final x pressDown$lambda$0(CursorPressDownEffectView r0, boolean r1, Throwable r2) {
        if (r1 == true) goto L5;
        r0.setVisibility(8);
        r0.resetToNormalState();
    L5:
        return x.f38692a;
    }

    public final void pressUp() {
        com.obric.common.oea.foundation.animation.a.b.a r0 = com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ANIMATION_TARGET_SPEED, ANIMATION_TARGET_FPS);
        e.c r3 = e.c.h;
        e.d r4 = e.d.f32444b;
        this.currentAnimation = r0.a(0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r3, e.b.f32433a, r4), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(ANIMATION_TARGET_SPEED)).a(new $$Lambda$CursorPressDownEffectView$qKWg9TNoSQi8fXJ8y7HDpvJeAQ(this)).b().a(com.obric.common.oea.foundation.animation.d.b.f32344a, com.obric.common.oea.foundation.animation.d.a.f32340a, true);
    }

    private static final x pressUp$lambda$1(CursorPressDownEffectView r0, boolean r1, Throwable r2) {
        r0.setVisibility(8);
        return x.f38692a;
    }

    public final void stopAllAnimation() {
        com.obric.common.oea.foundation.animation.manager.d r0 = this.currentAnimation;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.obric.common.oea.foundation.animation.manager.d r1 = this.currentAnimation;
        if (r1 == null) goto L8;
        r1.a(true);
    L8:
        this.currentAnimation = null;
        resetToNormalState();
    }

    private final void resetToNormalState() {
        setAlpha(ANIMATION_TARGET_SPEED);
        setScaleX(ANIMATION_TARGET_SPEED);
        setScaleY(ANIMATION_TARGET_SPEED);
    }
}
