package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

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
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR.\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108\u0016@WX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/TiltedIconTemplate;", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/BaseIconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedIconTemplate;", "", "value", ce.f26391f, "I", "getContentTopMargin", "()I", "setContentTopMargin", "(I)V", "contentTopMargin", "h", "getContentRightMargin", "setContentRightMargin", "contentRightMargin", "Landroid/view/View;", RXScreenCaptureService.KEY_INDEX, "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TiltedIconTemplate extends BaseIconTemplate implements ITiltedIconTemplate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f106622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f106623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f106624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f106625i;

    public static final class a {
    }

    static {
    }

    public TiltedIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TiltedIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public final void clearAnimators() {
        Animator r100 = this.f106622f;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isRunning() == false) goto L8;
        r100.end();
    L8:
        this.f106622f = null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public final void shake() {
        Animator r100 = this.f106622f;
        if (r100 == null) goto L5;
        r100.end();
        this.f106622f = null;
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
        com.bytedance.android.live.core.utils.h.a(r104, new TiltedIconTemplate$shake$$inlined$apply$lambda$1(this, r102, r103));
        r104.start();
        Unit r105 = Unit.INSTANCE;
        this.f106622f = r104;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public int getContentRightMargin() {
        return this.f106624h;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public int getContentTopMargin() {
        return this.f106623g;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public View getContentView() {
        return this.f106625i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.BaseIconTemplate, com.bytedance.android.livesdkapi.sti.framework.IconTemplate
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

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public final View inflateContentView(int r100) {
        return LayoutInflater.from(getContext()).inflate(r100, getContentContainer(), false);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public void setContentRightMargin(int r100) {
        View r101 = getContentView();
        if (r101 == null) goto L5;
        a1.n(r101, r100);
    L5:
        this.f106624h = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public void setContentTopMargin(int r100) {
        View r101 = getContentView();
        if (r101 == null) goto L5;
        a1.o(r101, r100);
    L5:
        this.f106623g = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate
    public void setContentView(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f106625i)) == false) goto L17;
        getContentContainer().removeView(r100);
        if (r100 == null) goto L12;
        getContentContainer().addView(r100);
        r100.setRotation(30.0f);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r101 = null;
    L9:
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        if (r102 == null) goto L12;
        r102.gravity = 53;
        r102.topMargin = getContentTopMargin();
        r102.rightMargin = getContentRightMargin();
        r102.leftMargin = 0;
        r102.bottomMargin = 0;
    L12:
        Animator r103 = this.f106622f;
        if (r103 == null) goto L15;
        r103.cancel();
    L15:
        this.f106622f = null;
        this.f106625i = r100;
        return;
    }

    public TiltedIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ TiltedIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
