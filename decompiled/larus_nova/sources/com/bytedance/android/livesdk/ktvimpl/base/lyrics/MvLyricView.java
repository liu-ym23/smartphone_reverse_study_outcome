package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bL\u0010MR\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018RT\u0010(\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010?\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/MvLyricView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/live/ktv/common/util/c;", "", FaceService.girlLabel, "getMiddleBaseShowPaint", "()F", "setMiddleBaseShowPaint", "(F)V", "middleBaseShowPaint", "G", "getMiddleBaseOtherPaint", "setMiddleBaseOtherPaint", "middleBaseOtherPaint", FaceService.neutralLabel, "getMiddleBaseDynamicPaint", "setMiddleBaseDynamicPaint", "middleBaseDynamicPaint", "", "I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "", "J", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "K", "getInterlude_gap", "()I", "interlude_gap", "Lig4/d;", "M", "Lig4/d;", "getAlignController", "()Lig4/d;", "alignController", "Landroid/animation/ValueAnimator;", "N", "Landroid/animation/ValueAnimator;", "getAlphaHide", "()Landroid/animation/ValueAnimator;", "setAlphaHide", "(Landroid/animation/ValueAnimator;)V", "alphaHide", "O", "getAlphaShow", "setAlphaShow", "alphaShow", "Landroid/animation/AnimatorSet;", "P", "Landroid/animation/AnimatorSet;", "getAlphaAnimSet", "()Landroid/animation/AnimatorSet;", "setAlphaAnimSet", "(Landroid/animation/AnimatorSet;)V", "alphaAnimSet", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MvLyricView extends CommonLyricDisplayView implements com.bytedance.android.live.ktv.common.util.c {
    public float F;
    public float G;
    public float H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f143151J;
    public final int K;
    public Paint L;
    public final ig4.d M;
    public ValueAnimator N;
    public ValueAnimator O;
    public AnimatorSet P;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricView f143152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143153b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143152a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143152a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143152a.setAnimating(true);
            if ((this.f143153b % 2) == 0) goto L5;
        L11:
            this.f143152a.setCurShowIndex(this.f143153b);
            if (this.f143152a.getCountDownEnable() == false) goto L14;
            this.f143152a.getDynamicRectF().left = 0.0f;
            this.f143152a.getDynamicRectF().right = 0.0f;
        L14:
            this.f143152a.invalidate();
            return;
        L5:
            if (this.f143152a.getCountDownEnable() == false) goto L11;
            if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143152a.getLyricsLineInfos(), this.f143153b)).f203036i == false) goto L11;
            if (this.f143152a.getLyricsLineInfos().size() <= (this.f143153b + 1)) goto L11;
            ArrayList<com.bytedance.component.lyric.model.b> r101 = this.f143152a.getLyricsLineInfos();
            int r102 = this.f143153b + 1;
            com.bytedance.component.lyric.model.b r103 = new com.bytedance.component.lyric.model.b();
            r103.f203028a = 1;
            Unit r104 = Unit.INSTANCE;
            ListProtector.add(r101, r102, r103);
            goto L11
        }

        public a(MvLyricView r100, int r101) {
            this.f143152a = r100;
            this.f143153b = r101;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricView f143154a;

        public b(MvLyricView r100) {
            this.f143154a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143154a.setAnimatingHide(false);
            this.f143154a.invalidate();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143154a.setAnimatingHide(true);
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricView f143155a;

        public c(MvLyricView r100) {
            this.f143155a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143155a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143155a.setAnimating(false);
            this.f143155a.invalidate();
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void b(List<com.bytedance.component.lyric.model.b> r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void onConfigComplete() {
        LyricsDisplayConfig r100 = getConfig();
        ig4.d r101 = this.M;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f203013h = r101;
        this.F = a(getConfig().f203016k.getFontMetrics());
        this.G = a(getConfig().f203014i.getFontMetrics());
        this.H = a(getConfig().f203017l.getFontMetrics());
    }

    public final ig4.d getAlignController() {
        return this.M;
    }

    public final AnimatorSet getAlphaAnimSet() {
        return this.P;
    }

    public final ValueAnimator getAlphaHide() {
        return this.N;
    }

    public final ValueAnimator getAlphaShow() {
        return this.O;
    }

    public final int getInterlude_gap() {
        return this.K;
    }

    public final float getMiddleBaseDynamicPaint() {
        return this.H;
    }

    public final float getMiddleBaseOtherPaint() {
        return this.G;
    }

    public final float getMiddleBaseShowPaint() {
        return this.F;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f143151J;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.I;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void c(long r100) {
        ig4.d r101 = this.M;
        r101.f489734g = getCurShowIndex();
        super.c(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void h(int r100) {
        AnimatorSet r101 = this.P;
        if (r101 != null) goto L5;
    L19:
        this.P = new AnimatorSet();
        int r102 = getConfig().f203014i.getAlpha();
        AnimatorSet r103 = this.P;
        if (r103 == null) goto L22;
        r103.addListener(new a(this, r100));
    L22:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r102, 0});
        r104.setDuration(250);
        r104.addUpdateListener(new e(this));
        this.N = r104;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, 255});
        r105.setDuration(250);
        r105.addUpdateListener(new e(this));
        this.O = r105;
        c r106 = new c(this);
        AnimatorSet r107 = this.P;
        if (r107 == null) goto L25;
        r107.addListener(r106);
    L25:
        ValueAnimator r108 = this.N;
        if (r108 == null) goto L28;
        r108.addListener(new b(this));
    L28:
        AnimatorSet r109 = this.P;
        if (r109 == null) goto L31;
        r109.playSequentially(new Animator[]{this.N, this.O});
    L31:
        AnimatorSet r110 = this.P;
        if (r110 == null) goto L34;
        r110.setDuration(500);
    L34:
        AnimatorSet r111 = this.P;
        if (r111 == null) goto L38;
        r111.start();
        return;
    L38:
        return;
    L5:
        if (r101.isRunning() != true) goto L19;
        AnimatorSet r112 = this.P;
        if (r112 == null) goto L9;
        r112.cancel();
    L9:
        AnimatorSet r113 = this.P;
        if (r113 == null) goto L12;
        r113.removeAllListeners();
    L12:
        ValueAnimator r114 = this.O;
        if (r114 == null) goto L15;
        r114.removeAllUpdateListeners();
    L15:
        ValueAnimator r115 = this.N;
        if (r115 == null) goto L18;
        r115.removeAllUpdateListeners();
    L18:
        getConfig().f203014i.setAlpha(255);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (getCurShowIndex() < getLyricsLineInfos().size()) goto L5;
        return;
    L5:
        if (getCurShowIndex() < 0) goto L59;
        Function2<Boolean, Long, Unit> r100 = getOneDrawCallback();
        if (r100 == null) goto L11;
        Unit r101 = r100.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L11:
        if (this.f143078q == false) goto L13;
    L18:
        getConfig().f203014i.clearShadowLayer();
    L20:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203036i == true) goto L22;
    L43:
        i(r110, getCurShowIndex(), getLyricsLineInfos(), true);
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203036i == false) goto L49;
        if (getCurrMusicProcess() < (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203030c + 1000)) goto L57;
        getConfig().f203014i.setAlpha(255);
        i(r110, getCurShowIndex() + 1, getLyricsLineInfos(), false);
        return;
    L57:
        return;
    L49:
        if (this.f143078q == false) goto L51;
        int r102 = getCurShowIndex() - 1;
    L52:
        i(r110, r102, getLyricsLineInfos(), false);
        return;
    L51:
        r102 = getCurShowIndex() + 1;
        goto L52
    L22:
        if (getLyricsLineInfos().size() > 0) goto L24;
    L29:
        int r103 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203030c;
    L31:
        if ((getCurrMusicProcess() - ((long) r103)) <= 1000) goto L43;
        int r104 = getCurShowIndex() + 1;
        if (r104 >= getLyricsLineInfos().size()) goto L54;
        com.bytedance.component.lyric.model.b r105 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104);
        if (getCountDownEnable() == false) goto L40;
        int r106 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a(r105) == false) goto L40;
        r104 = getCurShowIndex() + 2;
        r105 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104);
    L40:
        if (r105.f203029b >= (getCurrMusicProcess() + ((long) 3000))) goto L55;
        i(r110, r104, getLyricsLineInfos(), false);
        return;
    L55:
        return;
    L54:
        return;
    L24:
        if (getCurShowIndex() < (getLyricsLineInfos().size() - 1)) goto L29;
        Integer r107 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203040m;
        if (r107 == null) goto L28;
        r103 = r107.intValue();
        goto L31
    L28:
        r103 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).f203030c;
        goto L31
    L13:
        if (getConfig().f203014i.getAlpha() < 10) goto L18;
        Function1<? super Paint, Unit> r108 = getConfig().f203021p;
        if (r108 == null) goto L20;
        Unit r109 = r108.invoke(getConfig().f203014i);
        goto L20
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r100) {
        setCurrMusicProcess(r100);
        int r101 = e(r100);
        setLastMusicProcess(r100);
        if (getCurShowIndex() == r101) goto L6;
        h(r101);
        return;
    L6:
        if (this.f143077p == true) goto L10;
        invalidate();
        return;
    }

    public final void setAlphaAnimSet(AnimatorSet r100) {
        this.P = r100;
    }

    public final void setAlphaHide(ValueAnimator r100) {
        this.N = r100;
    }

    public final void setAlphaShow(ValueAnimator r100) {
        this.O = r100;
    }

    public final void setMiddleBaseDynamicPaint(float r100) {
        this.H = r100;
    }

    public final void setMiddleBaseOtherPaint(float r100) {
        this.G = r100;
    }

    public final void setMiddleBaseShowPaint(float r100) {
        this.F = r100;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f143151J = r100;
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.I = r100;
    }

    public MvLyricView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.I = KtvSubElement.LYRIC;
        this.K = h.s();
        this.L = getConfig().f203016k;
        this.M = new ig4.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r100, long r101) {
        super.addLyrics(r100, r101);
        Iterator<T> r102 = getLyricsLineInfos().iterator();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L11;
        com.bytedance.component.lyric.model.b r105 = (com.bytedance.component.lyric.model.b) r102.next();
        int r106 = r104 - 1;
        if (r106 <= 5) goto L10;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104)).f203029b - ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r106)).f203030c) <= this.K) goto L10;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r106)).f203036i = true;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104)).f203037j = true;
    L10:
        r104 = r104 + 1;
        goto L4
    L11:
        com.bytedance.component.lyric.model.b r107 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(getLyricsLineInfos());
        if (r107 == null) goto L27;
        r107.f203036i = true;
        int[] r108 = r107.f203034g;
        if (r108 == null) goto L19;
        int r109 = r108.length;
        int r110 = 0;
    L16:
        if (r103 >= r109) goto L18;
        r110 = r110 + r108[r103];
        r103 = r103 + 1;
        goto L16
    L18:
        r103 = r110;
    L19:
        if (r103 <= 0) goto L28;
        r107.f203040m = Integer.valueOf(r103 + r107.f203029b);
        return;
    L28:
        return;
    }

    public final void i(Canvas r100, int r101, ArrayList<com.bytedance.component.lyric.model.b> r110, boolean r111) {
        if (r101 >= r110.size()) goto L32;
        if (r101 < 0) goto L35;
        String r112 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r110, r101)).f203031d;
        if (r112 != null) goto L9;
        r112 = "";
    L9:
        if (r111 == false) goto L11;
        float r102 = this.F;
        Paint r103 = getConfig().f203016k;
    L12:
        this.L = r103;
        int r104 = r101 % 2;
        if (r104 != 0) goto L15;
        r103.setTextAlign(Paint.Align.LEFT);
        r100.drawText(r112, 0.0f, (r100.getHeight() / 4.0f) + r102, r103);
    L16:
        if (r111 == true) goto L18;
        return;
    L18:
        if (getConfig().f203019n != 3) goto L34;
        r100.save();
        r100.clipRect(getDynamicRectF());
        if (getConfig().f203020o == false) goto L22;
        this.L.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
    L23:
        if (r104 != 0) goto L25;
        Paint r113 = this.L;
        r113.setTextAlign(Paint.Align.LEFT);
        r100.drawText(r112, 0.0f, (r100.getHeight() / 4.0f) + r102, r113);
    L26:
        this.L.setStrokeWidth(0.0f);
        if (r104 != 0) goto L29;
        Paint r105 = getConfig().f203017l;
        float r114 = this.H;
        r105.setTextAlign(Paint.Align.LEFT);
        r100.drawText(r112, 0.0f, (r100.getHeight() / 4.0f) + r114, r105);
    L30:
        r100.restore();
        return;
    L29:
        Paint r106 = getConfig().f203017l;
        float r115 = this.H;
        r106.setTextAlign(Paint.Align.RIGHT);
        r100.drawText(r112, r100.getWidth(), ((r100.getHeight() / 4) * 3.0f) + r115, r106);
        goto L30
    L25:
        Paint r116 = this.L;
        r116.setTextAlign(Paint.Align.RIGHT);
        r100.drawText(r112, r100.getWidth(), ((r100.getHeight() / 4) * 3.0f) + r102, r116);
        goto L26
    L22:
        this.L.setStrokeWidth(0.0f);
        goto L23
    L34:
        return;
    L15:
        r103.setTextAlign(Paint.Align.RIGHT);
        r100.drawText(r112, r100.getWidth(), ((r100.getHeight() / 4) * 3.0f) + r102, r103);
        goto L16
    L11:
        r102 = this.G;
        r103 = getConfig().f203014i;
        goto L12
    L35:
        return;
    }
}
