package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: SeekBarMorphParentLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SeekBarMorphParentLayout extends FrameLayout {
    public static final a Companion = null;
    private static final float FORCE_FACTOR_DEF = 0.2f;
    private static final float FORCE_FACTOR_MAX = 0.3f;
    private static final float FORCE_FACTOR_MIN = 0.1f;
    public static final String TAG = "MorphSeekBarParentLayout";
    private float forceFactor;
    private boolean invertDirection;
    private float lastForce;
    private float lastProgress;
    private PointF lastTouchPoint;
    private int maxProgress;
    private int minProgress;
    protected SeekBar seekBarChild;

    /* JADX INFO: compiled from: SeekBarMorphParentLayout.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public SeekBarMorphParentLayout(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public SeekBarMorphParentLayout(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public abstract void dragContinue(float r1);

    public abstract void dragEnd();

    public abstract float getDeltaMove(MotionEvent r1);

    public abstract void startDrag(float r1);

    public /* synthetic */ SeekBarMorphParentLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public SeekBarMorphParentLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.lastTouchPoint = new PointF(0.0f, 0.0f);
        this.maxProgress = 100;
    }

    public final SeekBar getSeekBarChild() {
        SeekBar r1 = this.seekBarChild;
        if (r1 != null) goto L5;
        o.c("seekBarChild");
    L5:
        return r1;
    }

    public final void setSeekBarChild(SeekBar r2) {
        o.e(r2, "<set-?>");
        this.seekBarChild = r2;
    }

    public final PointF getLastTouchPoint() {
        return this.lastTouchPoint;
    }

    public final void setLastTouchPoint(PointF r2) {
        o.e(r2, "<set-?>");
        this.lastTouchPoint = r2;
    }

    public static /* synthetic */ void init$default(SeekBarMorphParentLayout r6, SeekBar r7, int r8, int r9, float r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L20;
        if ((r12 & 2) == 0) goto L6;
        r8 = 100;
    L6:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r12 & 8) == 0) goto L13;
        r10 = 0.15f;
    L13:
        float r4 = r10;
        if ((r12 & 16) == 0) goto L16;
        boolean r5 = false;
    L17:
        r6.init(r7, r2, r3, r4, r5);
        return;
    L16:
        r5 = r11;
        goto L17
    L9:
        r3 = r9;
        goto L11
    L20:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public final void init(SeekBar r4, int r5, int r6, float r7, boolean r8) {
        o.e(r4, "seekBar");
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "init, maxProgress: " + r5 + ", minProgress: " + r6 + ", morphFactor: " + r7);
        if (o.a(r4.getParent(), (SeekBarMorphParentLayout) ZeusTransformUtils.preCheckCast(this, SeekBarMorphParentLayout.class, "com.obric.aiagent.plugin")) == false) goto L7;
        this.seekBarChild = r4;
        this.invertDirection = r8;
        this.minProgress = r6;
        this.maxProgress = r5;
        return;
    L7:
        throw new IllegalArgumentException("seekBar must be a child of this view".toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r11) {
        SeekBar r0 = this.seekBarChild;
        if (r0 != null) goto L5;
        o.c("seekBarChild");
    L5:
        float r1 = r0.getProgress();
        if (r11 == null) goto L8;
        Integer r2 = Integer.valueOf(r11.getAction());
    L10:
        if (r2 == null) goto L21;
        if (r2.intValue() != 0) goto L21;
        startDrag(r1);
        this.lastTouchPoint = new PointF(r11.getX(), r11.getY());
        this.lastProgress = r1;
        this.lastForce = r1;
        if (this.invertDirection == false) goto L17;
        float r3 = -0.2f;
    L18:
        this.forceFactor = r3;
    L19:
        boolean r6 = false;
    L60:
        if (r6 == false) goto L62;
        return true;
    L62:
        if (super.dispatchTouchEvent(r11) == false) goto L65;
        return true;
    L65:
        return false;
    L17:
        r3 = FORCE_FACTOR_DEF;
    L21:
        if (r2 != null) goto L24;
    L49:
        if (r2 == null) goto L55;
        if (r2.intValue() != 1) goto L55;
    L59:
        dragEnd();
    L55:
        if (r2 == null) goto L19;
        if (r2.intValue() != 3) goto L19;
    L24:
        if (r2.intValue() != 2) goto L49;
        float r4 = getDeltaMove(r11);
        float r5 = (r1 - this.lastProgress) / r4;
        float r7 = 0.0f;
        if (r5 != 0.0f) goto L28;
    L32:
        this.lastTouchPoint = new PointF(r11.getX(), r11.getY());
        this.lastProgress = r1;
        int r8 = this.maxProgress;
        if (r1 < r8) goto L35;
    L39:
        r7 = this.lastForce + (this.forceFactor * r4);
        if (r7 <= r8) goto L42;
    L45:
        this.lastForce = r7;
        r6 = true;
    L46:
        if (r6 == false) goto L48;
        dragContinue(r7);
    L48:
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "needMorph: " + r6 + ", force: " + r7 + ", process: " + r1 + ", deltaMove: " + r4 + ", forceFactor: " + this.forceFactor + ", f: " + r5);
        goto L60
    L42:
        if (r7 < this.minProgress) goto L45;
        this.lastForce = r1;
    L38:
        r6 = false;
        goto L46
    L35:
        if (r1 <= this.minProgress) goto L39;
        this.lastForce = r1;
        goto L38
    L28:
        if (this.invertDirection == false) goto L30;
        float r9 = n.a(r5, -0.3f, -0.1f);
    L31:
        this.forceFactor = r9;
        goto L32
    L30:
        r9 = n.a(r5, 0.1f, FORCE_FACTOR_MAX);
        goto L31
    L8:
        r2 = null;
        goto L10
    }
}
