package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NR\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010+\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102RT\u0010B\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0013\u0012\u001109¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020;\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0017\u0010H\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/MvLyricViewV2;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/live/ktv/common/util/c;", "", FaceService.girlLabel, "getMiddleBaseShowPaint", "()F", "setMiddleBaseShowPaint", "(F)V", "middleBaseShowPaint", "G", "getMiddleBaseOtherPaint", "setMiddleBaseOtherPaint", "middleBaseOtherPaint", FaceService.neutralLabel, "getMiddleBaseDynamicPaint", "setMiddleBaseDynamicPaint", "middleBaseDynamicPaint", "Landroid/animation/ValueAnimator;", "I", "Landroid/animation/ValueAnimator;", "getAlphaHide", "()Landroid/animation/ValueAnimator;", "setAlphaHide", "(Landroid/animation/ValueAnimator;)V", "alphaHide", "J", "getAlphaShow", "setAlphaShow", "alphaShow", "Landroid/animation/AnimatorSet;", "K", "Landroid/animation/AnimatorSet;", "getAlphaAnimSet", "()Landroid/animation/AnimatorSet;", "setAlphaAnimSet", "(Landroid/animation/AnimatorSet;)V", "alphaAnimSet", "Landroid/graphics/RectF;", "M", "Landroid/graphics/RectF;", "getLastDynamicRectF", "()Landroid/graphics/RectF;", "lastDynamicRectF", "", "N", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "", "O", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "Lig4/d;", "Q", "Lig4/d;", "getAlignController", "()Lig4/d;", "alignController", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MvLyricViewV2 extends CommonLyricDisplayView implements com.bytedance.android.live.ktv.common.util.c {
    public float F;
    public float G;
    public float H;
    public ValueAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ValueAnimator f143156J;
    public AnimatorSet K;
    public Paint L;
    public final RectF M;
    public String N;
    public Function2<? super Boolean, ? super Long, Unit> O;
    public final int P;
    public final ig4.d Q;
    public Boolean R;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricViewV2 f143157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143158b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143157a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143157a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143157a.setAnimating(true);
            if ((this.f143158b % 2) == 0) goto L5;
        L11:
            this.f143157a.setCurShowIndex(this.f143158b);
            if (this.f143157a.getCountDownEnable() == false) goto L14;
            this.f143157a.getDynamicRectF().left = 0.0f;
            this.f143157a.getDynamicRectF().right = 0.0f;
        L14:
            this.f143157a.invalidate();
            return;
        L5:
            if (this.f143157a.getCountDownEnable() == false) goto L11;
            if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143157a.getLyricsLineInfos(), this.f143158b)).f203036i == false) goto L11;
            if (this.f143157a.getLyricsLineInfos().size() <= (this.f143158b + 1)) goto L11;
            ArrayList<com.bytedance.component.lyric.model.b> r101 = this.f143157a.getLyricsLineInfos();
            int r102 = this.f143158b + 1;
            com.bytedance.component.lyric.model.b r103 = new com.bytedance.component.lyric.model.b();
            r103.f203028a = 1;
            Unit r104 = Unit.INSTANCE;
            ListProtector.add(r101, r102, r103);
            goto L11
        }

        public a(MvLyricViewV2 r100, int r101) {
            this.f143157a = r100;
            this.f143158b = r101;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricViewV2 f143159a;

        public b(MvLyricViewV2 r100) {
            this.f143159a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143159a.setAnimatingHide(false);
            MvLyricViewV2 r101 = this.f143159a;
            if (r101.f143080s == true) goto L6;
            r101.invalidate();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143159a.setAnimatingHide(true);
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricViewV2 f143160a;

        public c(MvLyricViewV2 r100) {
            this.f143160a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143160a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143160a.setAnimating(false);
            this.f143160a.invalidate();
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void b(List<com.bytedance.component.lyric.model.b> r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void release() {
        this.R = null;
        super.release();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void onConfigComplete() {
        LyricsDisplayConfig r100 = getConfig();
        ig4.d r101 = this.Q;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f203013h = r101;
        this.F = a(getConfig().f203016k.getFontMetrics());
        this.G = a(getConfig().f203014i.getFontMetrics());
        this.H = a(getConfig().f203017l.getFontMetrics());
    }

    public final ig4.d getAlignController() {
        return this.Q;
    }

    public final AnimatorSet getAlphaAnimSet() {
        return this.K;
    }

    public final ValueAnimator getAlphaHide() {
        return this.I;
    }

    public final ValueAnimator getAlphaShow() {
        return this.f143156J;
    }

    public final RectF getLastDynamicRectF() {
        return this.M;
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
        return this.O;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.N;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void c(long r100) {
        ig4.d r101 = this.Q;
        r101.f489734g = getCurShowIndex();
        super.c(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void h(int r100) {
        AnimatorSet r101 = this.K;
        if (r101 != null) goto L5;
    L19:
        this.K = new AnimatorSet();
        int r102 = getConfig().f203014i.getAlpha();
        AnimatorSet r103 = this.K;
        if (r103 == null) goto L22;
        r103.addListener(new a(this, r100));
    L22:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r102, 0});
        r104.setDuration(250);
        r104.addUpdateListener(new f(this));
        this.I = r104;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, 255});
        r105.setDuration(250);
        r105.addUpdateListener(new f(this));
        this.f143156J = r105;
        c r106 = new c(this);
        AnimatorSet r107 = this.K;
        if (r107 == null) goto L25;
        r107.addListener(r106);
    L25:
        ValueAnimator r108 = this.I;
        if (r108 == null) goto L28;
        r108.addListener(new b(this));
    L28:
        AnimatorSet r109 = this.K;
        if (r109 == null) goto L31;
        r109.playSequentially(new Animator[]{this.I, this.f143156J});
    L31:
        AnimatorSet r110 = this.K;
        if (r110 == null) goto L34;
        r110.setDuration(500);
    L34:
        AnimatorSet r111 = this.K;
        if (r111 == null) goto L38;
        r111.start();
        return;
    L38:
        return;
    L5:
        if (r101.isRunning() != true) goto L19;
        AnimatorSet r112 = this.K;
        if (r112 == null) goto L9;
        r112.cancel();
    L9:
        AnimatorSet r113 = this.K;
        if (r113 == null) goto L12;
        r113.removeAllListeners();
    L12:
        ValueAnimator r114 = this.f143156J;
        if (r114 == null) goto L15;
        r114.removeAllUpdateListeners();
    L15:
        ValueAnimator r115 = this.I;
        if (r115 == null) goto L18;
        r115.removeAllUpdateListeners();
    L18:
        getConfig().f203014i.setAlpha(255);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getCurShowIndex() < getLyricsLineInfos().size()) goto L5;
        return;
    L5:
        if (getCurShowIndex() < 0) goto L47;
        Function2<Boolean, Long, Unit> r101 = getOneDrawCallback();
        if (r101 == null) goto L11;
        Unit r102 = r101.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L11:
        if (this.f143078q == false) goto L13;
    L18:
        getConfig().f203014i.clearShadowLayer();
    L19:
        int r103 = getCurShowIndex();
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r103)).f203036i == true) goto L22;
    L40:
        i(r100, r103, getLyricsLineInfos(), true);
        if (this.f143078q == false) goto L43;
        int r104 = r103 - 1;
    L44:
        i(r100, r104, getLyricsLineInfos(), false);
        return;
    L43:
        r104 = r103 + 1;
        goto L44
    L22:
        if (Intrinsics.areEqual(this.R, Boolean.FALSE) == false) goto L24;
        return;
    L24:
        int r105 = r103 + 1;
        if (r105 >= getLyricsLineInfos().size()) goto L32;
        com.bytedance.component.lyric.model.b r106 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r105);
        if (getCountDownEnable() == false) goto L31;
        int r107 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a(r106) == false) goto L31;
        r105 = r103 + 2;
        com.bytedance.component.lyric.model.b r108 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r105);
    L31:
        Integer r109 = Integer.valueOf(r105);
    L33:
        if (r109 == null) goto L40;
        int r110 = r109.intValue();
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r110)).f203037j == false) goto L40;
        if (Intrinsics.areEqual(this.R, Boolean.TRUE) == false) goto L40;
        i(r100, r110, getLyricsLineInfos(), false);
        return;
    L32:
        r109 = null;
        goto L33
    L13:
        if (getConfig().f203014i.getAlpha() < 10) goto L18;
        Function1<? super Paint, Unit> r111 = getConfig().f203021p;
        if (r111 == null) goto L19;
        Unit r112 = r111.invoke(getConfig().f203014i);
        goto L19
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
        if (this.f143077p == true) goto L11;
        if (getDrawOptEnable() == true) goto L11;
        invalidate();
        return;
    L11:
        if ((!Intrinsics.areEqual(getDynamicRectF(), this.M)) == false) goto L13;
        this.M.set(getDynamicRectF());
        invalidate();
        return;
    L13:
        com.bytedance.component.lyric.model.b r102 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(getLyricsLineInfos(), getCurShowIndex());
        if (r102 == null) goto L66;
        Boolean r103 = this.R;
        Integer r104 = null;
        if (r102.f203036i == false) goto L59;
        Integer r105 = r102.f203039l;
        boolean r106 = false;
        if (r105 != null) goto L21;
    L31:
        int r107 = getCurShowIndex();
        int r108 = r107 + 1;
        if (r108 >= getLyricsLineInfos().size()) goto L39;
        com.bytedance.component.lyric.model.b r109 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r108);
        if (getCountDownEnable() == false) goto L38;
        int r110 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a(r109) == false) goto L38;
        r108 = r107 + 2;
        r109 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r108);
    L38:
        Pair r111 = new Pair(Integer.valueOf(r108), r109);
    L40:
        if (r111 == null) goto L57;
        com.bytedance.component.lyric.model.b r112 = (com.bytedance.component.lyric.model.b) r111.getSecond();
        if (r112 == null) goto L57;
        if (r112.f203037j == false) goto L57;
        Integer r113 = r112.f203038k;
        if (r113 == null) goto L57;
        if (r113.intValue() <= 0) goto L50;
        r106 = true;
    L50:
        if (r106 == false) goto L52;
        r104 = r113;
    L52:
        if (r104 == null) goto L57;
        if (getCurrMusicProcess() <= r104.intValue()) goto L57;
        r103 = Boolean.TRUE;
    L57:
        if ((!Intrinsics.areEqual(this.R, r103)) == false) goto L64;
        this.R = r103;
        invalidate();
        return;
    L64:
        return;
    L39:
        r111 = null;
        goto L40
    L21:
        if (r105.intValue() <= 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L31;
        if (getCurrMusicProcess() <= r105.intValue()) goto L31;
        r103 = Boolean.FALSE;
        goto L31
    L23:
        r114 = false;
        goto L24
    L59:
        this.R = null;
        return;
    }

    public final void setAlphaAnimSet(AnimatorSet r100) {
        this.K = r100;
    }

    public final void setAlphaHide(ValueAnimator r100) {
        this.I = r100;
    }

    public final void setAlphaShow(ValueAnimator r100) {
        this.f143156J = r100;
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
        this.O = r100;
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.N = r100;
    }

    public MvLyricViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.L = getConfig().f203016k;
        this.M = new RectF();
        this.N = KtvSubElement.LYRIC;
        this.P = h.s();
        this.Q = new ig4.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r100, long r101) {
        super.addLyrics(r100, r101);
        Iterator<T> r102 = getLyricsLineInfos().iterator();
        int r103 = 0;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r102.hasNext() == false) goto L28;
        com.bytedance.component.lyric.model.b r106 = (com.bytedance.component.lyric.model.b) r102.next();
        int r107 = r104 - 1;
        if (r107 <= 5) goto L27;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104)).f203029b - ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r107)).f203030c) <= this.P) goto L27;
        com.bytedance.component.lyric.model.b r108 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r107);
        r108.f203036i = true;
        Integer r109 = Integer.valueOf(r108.f203030c);
        if (r109.intValue() <= 0) goto L12;
        boolean r110 = true;
    L13:
        Integer r111 = null;
        if (r110 == true) goto L17;
        r109 = null;
    L17:
        if (r109 == null) goto L19;
        r108.f203039l = Integer.valueOf(r109.intValue() + 1000);
    L19:
        com.bytedance.component.lyric.model.b r112 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r104);
        r112.f203037j = true;
        Integer r113 = Integer.valueOf(r112.f203029b);
        if (r113.intValue() > 0) goto L23;
        r105 = false;
    L23:
        if (r105 == false) goto L25;
        r111 = r113;
    L25:
        if (r111 == null) goto L27;
        r112.f203038k = Integer.valueOf(r111.intValue() - 3000);
        goto L27
    L12:
        r110 = false;
    L27:
        r104 = r104 + 1;
        goto L3
    L28:
        com.bytedance.component.lyric.model.b r114 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(getLyricsLineInfos());
        if (r114 == null) goto L38;
        r114.f203036i = true;
        int[] r115 = r114.f203034g;
        if (r115 == null) goto L36;
        int r116 = r115.length;
        int r117 = 0;
    L33:
        if (r103 >= r116) goto L35;
        r117 = r117 + r115[r103];
        r103 = r103 + 1;
        goto L33
    L35:
        r103 = r117;
    L36:
        if (r103 <= 0) goto L38;
        r114.f203040m = Integer.valueOf(r114.f203029b + r103);
        r114.f203039l = Integer.valueOf((r103 + r114.f203029b) + 1000);
    L38:
        invalidate();
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
