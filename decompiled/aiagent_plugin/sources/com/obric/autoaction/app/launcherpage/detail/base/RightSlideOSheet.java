package com.obric.autoaction.app.launcherpage.detail.base;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RightSlideOSheet extends OSheet {
    private static final a Companion = null;
    private static final long ENTER_DURATION_MS = 300;
    private static final DecelerateInterpolator ENTER_INTERPOLATOR = null;
    private static final long EXIT_DURATION_MS = 250;
    private static final AccelerateInterpolator EXIT_INTERPOLATOR = null;
    private ViewPropertyAnimator dimAnimator;
    private boolean ignoreInsetBottom;
    private ViewPropertyAnimator slideAnimator;

    /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ void lambda$UsAGxgblR6fmnznYKfQBHvIfViE(RightSlideOSheet r0) {
        performEnterAnimation$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$u8MlUBOuLIUmFM-jVJFn4hu2f08, reason: not valid java name */
    public static /* synthetic */ void m467lambda$u8MlUBOuLIUmFMjVJFn4hu2f08(RightSlideOSheet r0) {
        performExitAnimation$lambda$4(r0);
    }

    public RightSlideOSheet(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        super(r1, 0, 0, false, false, 30, null);
        this.ignoreInsetBottom = true;
    }

    @Override // com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.a
    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.a
    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }

    private final float getTargetDimAmount() {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r2 = false;
        goto L6
    }

    private final void cancelRunningAnimators() {
        ViewPropertyAnimator r0 = this.slideAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.slideAnimator = null;
        ViewPropertyAnimator r1 = this.dimAnimator;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.dimAnimator = null;
    }

    @Override // com.obric.oui.sheet.v2.OSheet
    public void performEnterAnimation() {
        cancelRunningAnimators();
        RadiusLayout r0 = getRootContainer();
        View r1 = getDimView();
        Integer r2 = Integer.valueOf(r0.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        int r4 = r2.intValue();
    L12:
        r0.setAlpha(1.0f);
        r0.setTranslationY(0.0f);
        r0.setTranslationX(r4);
        if (r1 == null) goto L15;
        r1.setAlpha(0.0f);
    L15:
        onShowAnimStart();
        ViewPropertyAnimator r5 = r0.animate().translationX(0.0f).setDuration(ENTER_DURATION_MS);
        DecelerateInterpolator r6 = ENTER_INTERPOLATOR;
        ViewPropertyAnimator r7 = r5.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r6, TimeInterpolator.class, "com.obric.aiagent.plugin")).withEndAction(new $$Lambda$RightSlideOSheet$UsAGxgblR6fmnznYKfQBHvIfViE(this));
        this.slideAnimator = r7;
        if (r7 == null) goto L18;
        r7.start();
    L18:
        if (r1 == null) goto L23;
        ViewPropertyAnimator r8 = r1.animate().alpha(getTargetDimAmount()).setDuration(ENTER_DURATION_MS).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r6, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        this.dimAnimator = r8;
        if (r8 == null) goto L24;
        r8.start();
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r4 = getFullWindowSize().getWidth();
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    private static final void performEnterAnimation$lambda$1(RightSlideOSheet r1) {
        r1.slideAnimator = null;
        r1.onShowAnimEnd();
    }

    @Override // com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.a
    public void performExitAnimation(float r7) {
        cancelRunningAnimators();
        RadiusLayout r8 = getRootContainer();
        View r0 = getDimView();
        Integer r1 = Integer.valueOf(r8.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.intValue();
    L12:
        onDismissAnimStart();
        ViewPropertyAnimator r9 = r8.animate().translationX(r3).setDuration(EXIT_DURATION_MS);
        AccelerateInterpolator r4 = EXIT_INTERPOLATOR;
        ViewPropertyAnimator r10 = r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r4, TimeInterpolator.class, "com.obric.aiagent.plugin")).withEndAction(new $$Lambda$RightSlideOSheet$u8MlUBOuLIUmFMjVJFn4hu2f08(this));
        this.slideAnimator = r10;
        if (r10 == null) goto L15;
        r10.start();
    L15:
        if (r0 == null) goto L20;
        ViewPropertyAnimator r11 = r0.animate().alpha(0.0f).setDuration(EXIT_DURATION_MS).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r4, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        this.dimAnimator = r11;
        if (r11 == null) goto L21;
        r11.start();
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r3 = getFullWindowSize().getWidth();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private static final void performExitAnimation$lambda$4(RightSlideOSheet r1) {
        r1.slideAnimator = null;
        r1.onDismissAnimEnd();
        r1.onDismissComplete();
    }

    static {
        Companion = new a(null);
        ENTER_INTERPOLATOR = new DecelerateInterpolator();
        EXIT_INTERPOLATOR = new AccelerateInterpolator();
    }
}
