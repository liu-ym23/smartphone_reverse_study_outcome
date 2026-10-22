package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001.B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0003¢\u0006\u0004\b,\u0010-R*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR.\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R.\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b8\u0016@WX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010&\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/TiltedTempIconTemplate;", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/BaseTempIconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedTempIconTemplate;", "", "value", "h", "I", "getContentTopMargin", "()I", "setContentTopMargin", "(I)V", "contentTopMargin", RXScreenCaptureService.KEY_INDEX, "getContentRightMargin", "setContentRightMargin", "contentRightMargin", "", ce.f26395j, "Ljava/lang/Boolean;", "isRotated", "()Ljava/lang/Boolean;", "setRotated", "(Ljava/lang/Boolean;)V", ce.f26396k, "getResizeContentView", "setResizeContentView", "resizeContentView", "Landroid/view/View;", "l", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "m", "getTempShortTermView", "setTempShortTermView", "tempShortTermView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TiltedTempIconTemplate extends BaseTempIconTemplate implements ITiltedTempIconTemplate {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator f106544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f106545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f106546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f106547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f106548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f106549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f106550m;

    public static final class a {
    }

    static {
    }

    public TiltedTempIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TiltedTempIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public final void clearAnimators() {
        Animator r100 = this.f106544g;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isRunning() == false) goto L8;
        r100.end();
    L8:
        this.f106544g = null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public final void shake() {
        Animator r100 = this.f106544g;
        if (r100 == null) goto L5;
        r100.end();
        this.f106544g = null;
    L5:
        View r101 = getContentView();
        if (r101 != null) goto L8;
        return;
    L8:
        final ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "rotation", Arrays.copyOf(new float[]{30.0f, 45.0f, 15.0f, 45.0f, 15.0f, 45.0f, 15.0f, 30.0f}, 8)).setDuration(700);
        final ObjectAnimator r103 = r102.clone();
        AnimatorSet r104 = new AnimatorSet();
        r104.play(r102);
        r104.play(r103).after(1000);
        com.bytedance.android.live.core.utils.h.a(r104, new TiltedTempIconTemplate$shake$$inlined$apply$lambda$1(this, r102, r103));
        r104.start();
        Unit r105 = Unit.INSTANCE;
        this.f106544g = r104;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public final void removeTempView() {
        getMContentContainer().removeView(getTempShortTermView());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public int getContentRightMargin() {
        return this.f106546i;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public int getContentTopMargin() {
        return this.f106545h;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public View getContentView() {
        return this.f106549l;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public Boolean getResizeContentView() {
        return this.f106548k;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public View getTempShortTermView() {
        return this.f106550m;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public final Boolean isRotated() {
        return this.f106547j;
    }

    @Override // com.bytedance.android.livesdk.chatroom.indicator.shortterm.BaseTempIconTemplate, com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public final Animator getEntryAnimation(long r110) {
        Animator r100 = super.getEntryAnimation(r110);
        View r101 = getContentView();
        if (r101 != null) goto L5;
        return r100;
    L5:
        r101.setTranslationX(-35.0f);
        r101.setTranslationY(60.0f);
        AnimatorSet r102 = new AnimatorSet();
        r102.setStartDelay(r110 + 200);
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getTranslationX(), 2.0f, 0.0f}), ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), -3.0f, 0.0f})});
        r102.setDuration(300);
        r102.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r111 = new AnimatorSet();
        r111.playTogether(new Animator[]{r100, r102});
        return r111;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public final View inflateContentView(int r100) {
        return LayoutInflater.from(getContext()).inflate(r100, getMContentContainer(), false);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setContentRightMargin(int r100) {
        View r101 = getContentView();
        if (r101 == null) goto L5;
        a1.n(r101, r100);
    L5:
        this.f106546i = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setContentTopMargin(int r100) {
        View r101 = getContentView();
        if (r101 == null) goto L5;
        a1.o(r101, r100);
    L5:
        this.f106545h = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setContentView(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f106549l)) == false) goto L21;
        getIconOnlyFrameLayout().removeView(r100);
        if (r100 == null) goto L16;
        getIconOnlyFrameLayout().addView(r100, 0);
        if (Intrinsics.areEqual(isRotated(), Boolean.TRUE) == false) goto L9;
        float r101 = 30.0f;
    L10:
        r100.setRotation(r101);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L13;
        r102 = null;
    L13:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 == null) goto L16;
        r103.gravity = 53;
        r103.topMargin = getContentTopMargin();
        r103.rightMargin = getContentRightMargin();
        r103.leftMargin = 0;
        r103.bottomMargin = 0;
        goto L16
    L9:
        r101 = 0.0f;
    L16:
        Animator r104 = this.f106544g;
        if (r104 == null) goto L19;
        r104.cancel();
    L19:
        this.f106544g = null;
        this.f106549l = r100;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setResizeContentView(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L9;
        FrameLayout r101 = getIconOnlyFrameLayout();
        if (r101 == null) goto L9;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L9;
        r102.width = -1;
        r102.height = -1;
    L9:
        this.f106548k = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setRotated(Boolean r100) {
        View r101 = getContentView();
        if (r101 != null) goto L5;
    L9:
        this.f106547j = r100;
        return;
    L5:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L7;
        float r102 = 30.0f;
    L8:
        r101.setRotation(r102);
        goto L9
    L7:
        r102 = 0.0f;
        goto L8
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate
    public void setTempShortTermView(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f106550m)) == false) goto L13;
        getMContentContainer().removeView(r100);
        if (r100 == null) goto L11;
        StringBuilder r101 = new StringBuilder("mContentContainer.childCount = ");
        TempIconContent r102 = getMContentContainer();
        if (r102 == null) goto L9;
        Integer r103 = Integer.valueOf(r102.getChildCount());
    L10:
        r101.append(r103.intValue());
        ALogger.i("TempIconTemplateImpls", r101.toString());
        getMContentContainer().addView(r100);
        goto L11
    L9:
        r103 = null;
    L11:
        this.f106550m = r100;
        return;
    }

    public TiltedTempIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f106547j = Boolean.TRUE;
        this.f106548k = Boolean.FALSE;
    }

    public /* synthetic */ TiltedTempIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
