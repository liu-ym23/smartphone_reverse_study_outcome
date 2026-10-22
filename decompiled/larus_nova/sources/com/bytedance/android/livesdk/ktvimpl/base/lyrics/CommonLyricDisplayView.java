package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u0002¢\u0006\u0004\be\u0010fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010%\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010>\u001a\u0002098\u0004X\u0084\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\"\u0010F\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R$\u0010N\u001a\u0004\u0018\u00010G8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010P\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bO\u0010\r\u001a\u0004\bP\u0010\u000f\"\u0004\bQ\u0010\u0011R\"\u0010S\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R\"\u0010X\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bU\u0010\r\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R\u001a\u0010[\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bY\u0010\r\u001a\u0004\bZ\u0010\u000fR\"\u0010_\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010 \u001a\u0004\b]\u0010\"\"\u0004\b^\u0010$¨\u0006g"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/BaseLyricView;", "", "getlyricsLineCount", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "getCurrentLyrics", "Landroid/graphics/Paint$Align;", "getTextAlign", "getCurrentIndex", "", "c", "Z", "getInScroll", "()Z", "setInScroll", "(Z)V", "inScroll", "", "d", "J", "getCurrMusicProcess", "()J", "setCurrMusicProcess", "(J)V", "currMusicProcess", "e", "getLastMusicProcess", "setLastMusicProcess", "lastMusicProcess", "f", "I", "getCurToAddLineIndex", "()I", "setCurToAddLineIndex", "(I)V", "curToAddLineIndex", "", ce.f26391f, FaceService.girlLabel, "getCurLinePorgress", "()F", "setCurLinePorgress", "(F)V", "curLinePorgress", "h", "Ljava/util/ArrayList;", "getLyricsLineInfos", "()Ljava/util/ArrayList;", "lyricsLineInfos", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "Landroid/graphics/RectF;", "getDynamicRectF", "()Landroid/graphics/RectF;", "dynamicRectF", "Landroid/graphics/Rect;", ce.f26396k, "Landroid/graphics/Rect;", "getLyricsRect", "()Landroid/graphics/Rect;", "lyricsRect", "m", "getCurShowIndex", "setCurShowIndex", "curShowIndex", OfficeSDKRequestTag.KEY_NEW_USER, "getAnimationY", "setAnimationY", "animationY", "Landroid/animation/ValueAnimator;", "o", "Landroid/animation/ValueAnimator;", "getScrollAnimator", "()Landroid/animation/ValueAnimator;", "setScrollAnimator", "(Landroid/animation/ValueAnimator;)V", "scrollAnimator", "p", "isAnimating", "setAnimating", "q", "isAnimatingHide", "setAnimatingHide", "s", "getDrawOptEnable", "setDrawOptEnable", "drawOptEnable", "y", "getCountDownEnable", "countDownEnable", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getAddedLines", "setAddedLines", "addedLines", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonLyricDisplayView extends BaseLyricView {
    public List<com.bytedance.component.lyric.model.b> A;
    public float B;
    public List<com.bytedance.component.lyric.model.b> C;
    public long D;
    public boolean E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f143064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f143065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f143066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f143067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f143068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<com.bytedance.component.lyric.model.b> f143069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f143070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Float f143071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f143072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f143073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f143074m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f143075n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f143076o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f143077p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f143078q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f143079r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f143080s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f143081t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f143082u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, Float> f143083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, Rect> f143084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, Rect> f143085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f143086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f143087z;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonLyricDisplayView f143088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f143089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f143090c;

        public a(CommonLyricDisplayView r100, Ref.IntRef r101, Ref.IntRef r102) {
            this.f143088a = r100;
            this.f143089b = r101;
            this.f143090c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f143088a.setInScroll(true);
            Ref.IntRef r101 = this.f143089b;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L10;
            r101.element = ((Integer) r102).intValue();
            Ref.IntRef r103 = this.f143090c;
            int r104 = r103.element;
            Ref.IntRef r105 = this.f143089b;
            int r106 = r105.element;
            if (r104 != r106) goto L7;
            return;
        L7:
            r103.element = r106;
            this.f143088a.setAnimationY(r105.element);
            this.f143088a.invalidate();
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonLyricDisplayView f143091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143092b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f143091a.setAnimationY(0);
            this.f143091a.setAnimating(false);
            this.f143091a.setCurShowIndex(this.f143092b);
            this.f143091a.setInScroll(false);
            this.f143091a.getDynamicRectF().left = 0.0f;
            this.f143091a.invalidate();
        }

        public b(CommonLyricDisplayView r100, int r101) {
            this.f143091a = r100;
            this.f143092b = r101;
        }
    }

    public CommonLyricDisplayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonLyricDisplayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final View asView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void release() {
        this.f143067f = 0;
        this.f143065d = 0;
        this.f143074m = 0;
        this.f143069h.clear();
        this.C = null;
        this.f143070i.setEmpty();
        invalidate();
        this.f143071j = null;
        ALogger.i(bb0.b.b().concat("-lyric"), "release, invoke class :CommonLyricDisplayView");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateDynamicPaintColor() {
    }

    public final int getlyricsLineCount() {
        return this.f143069h.size();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final boolean isFinishDrawLastLine() {
        int r100 = this.f143074m;
        if (r100 > 0) goto L5;
        return false;
    L5:
        if (r100 == (this.f143069h.size() - 1)) goto L7;
        return false;
    L7:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m)).f203034g == null) goto L18;
        int[] r101 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m)).f203034g;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r102) goto L12;
        r104 = r104 + r101[r103];
        r103 = r103 + 1;
        goto L9
    L12:
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m)).f203029b + r104) > this.f143065d) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void onConfigComplete() {
        ValueAnimator r100 = this.f143081t;
        if (r100 != null) goto L5;
    L10:
        this.f143081t = ValueAnimator.ofFloat(new float[]{this.f143082u, getConfig().f203008c});
        return;
    L5:
        if (r100.isRunning() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.removeAllUpdateListeners();
        r100.removeAllListeners();
        r100.cancel();
        goto L10
    }

    public final int getAddedLines() {
        return this.f143087z;
    }

    public final int getAnimationY() {
        return this.f143075n;
    }

    public final boolean getCountDownEnable() {
        return this.f143086y;
    }

    public final float getCurLinePorgress() {
        return this.f143068g;
    }

    public final int getCurShowIndex() {
        return this.f143074m;
    }

    public final int getCurToAddLineIndex() {
        return this.f143067f;
    }

    public final long getCurrMusicProcess() {
        return this.f143065d;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public int getCurrentIndex() {
        return this.f143074m;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics() {
        return this.f143069h;
    }

    public final boolean getDrawOptEnable() {
        return this.f143080s;
    }

    public final RectF getDynamicRectF() {
        return this.f143070i;
    }

    public final boolean getInScroll() {
        return this.f143064c;
    }

    public final long getLastMusicProcess() {
        return this.f143066e;
    }

    public final ArrayList<com.bytedance.component.lyric.model.b> getLyricsLineInfos() {
        return this.f143069h;
    }

    public final Rect getLyricsRect() {
        return this.f143072k;
    }

    public final ValueAnimator getScrollAnimator() {
        return this.f143076o;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public Paint.Align getTextAlign() {
        return Paint.Align.CENTER;
    }

    private final float g(String r100) {
        if (r100 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.f143083v).get(r100) == null) goto L6;
        Float r101 = (Float) ((LinkedHashMap) this.f143083v).get(r100);
    L7:
        if (r101 == null) goto L9;
        return r101.floatValue();
    L6:
        float r102 = getConfig().f203016k.measureText(r100);
        this.f143083v.put(r100, Float.valueOf(r102));
        r101 = Float.valueOf(r102);
        goto L7
    }

    public void b(List<com.bytedance.component.lyric.model.b> r100) {
        if (this.E == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.size() > 0) goto L9;
        return;
    L9:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r100, 0)).f203029b <= 3000) goto L16;
        this.f143067f = 1;
        if (this.f143087z >= 1) goto L17;
        com.bytedance.component.lyric.model.b r101 = new com.bytedance.component.lyric.model.b();
        r101.f203035h = true;
        r101.f203029b = ((com.bytedance.component.lyric.model.b) ListProtector.get(r100, 0)).f203029b - 3000;
        r101.f203031d = "...";
        r101.f203033f = new String[]{".", ".", "."};
        r101.f203034g = new int[]{1000, 1000, 1000};
        this.f143069h.add(r101);
        return;
    L17:
        return;
    }

    public void c(long r110) {
        if (this.f143074m < this.f143069h.size()) goto L5;
        return;
    L5:
        com.bytedance.component.lyric.model.b r100 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m);
        float r101 = g(r100.f203031d);
        long r111 = r110 - ((long) r100.f203029b);
        StringBuilder r102 = new StringBuilder();
        Integer r103 = r100.f203041n;
        int r104 = 0;
        if (r103 != null) goto L8;
    L23:
        int[] r105 = r100.f203034g;
        if (r105 == null) goto L38;
        int r106 = r105.length;
        long r107 = 0;
    L26:
        if (r104 >= r106) goto L38;
        long r108 = r105[r104];
        r107 = r107 + r108;
        String[] r109 = r100.f203033f;
        if (r109 == null) goto L31;
        String r112 = r109[r104];
        if (r112 == null) goto L31;
    L33:
        if (r111 < r107) goto L34;
        r102.append(r112);
        r104 = r104 + 1;
        goto L26
    L34:
        if (r104 <= 0) goto L36;
        r111 = r111 - (r107 - r108);
    L36:
        float r113 = (g(r112) / r105[r104]) * r111;
    L39:
        ig4.c.b(getConfig().f203013h, this.f143070i, getMeasuredHeight(), getMeasuredWidth(), r101, r113 + g(r102.toString()));
        return;
    L31:
        r112 = "";
    L38:
        r113 = 0.0f;
        goto L39
    L8:
        if (r103.intValue() <= 0) goto L10;
        boolean r114 = true;
    L11:
        if (r114 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L23;
        float r115 = r111 / r103.intValue();
        this.f143068g = r115;
        if (r115 <= 1.0f) goto L19;
        this.f143068g = 1.0f;
    L19:
        if (Intrinsics.areEqual(this.f143071j, this.f143068g) == false) goto L21;
        return;
    L21:
        this.f143071j = Float.valueOf(this.f143068g);
        ig4.c.b(getConfig().f203013h, this.f143070i, getMeasuredHeight(), getMeasuredWidth(), r101, r101 * this.f143068g);
        return;
    L10:
        r114 = false;
        goto L11
    }

    public final int e(long r100) {
        int r101 = this.f143069h.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L42;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, r102)).f203028a != 1) goto L10;
        if (this.f143086y == false) goto L10;
    L32:
        r102 = r102 + 1;
    L10:
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, 0)).f203029b) goto L43;
        if (r100 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, r102)).f203029b) goto L25;
        if (r102 <= 0) goto L25;
        if (getConfig().f203019n != 3) goto L18;
        c(r100);
    L18:
        int r103 = r102 - 1;
        if (this.f143086y == false) goto L33;
        int r104 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, r103)) == false) goto L33;
        r103 = r103 - 1;
    L33:
        return r103;
    L25:
        if (r102 != (this.f143069h.size() - 1)) goto L32;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, r102)).f203029b) goto L32;
        if (getConfig().f203019n != 3) goto L41;
        c(r100);
    L41:
        return this.f143069h.size() - 1;
    L43:
        return 0;
    L42:
        return 0;
    }

    public final Rect f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (((LinkedHashMap) this.f143084w).get(r100) == null) goto L5;
        Rect r101 = (Rect) ((LinkedHashMap) this.f143084w).get(r100);
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new Rect();
    L5:
        Rect r102 = new Rect();
        getConfig().f203016k.getTextBounds(r100, 0, r100.length(), r102);
        this.f143084w.put(r100, r102);
        r101 = r102;
        goto L6
    }

    public void h(int r100) {
        String r101 = "currMusicProcess:" + this.f143065d + ",nextShowIndex:" + r100 + ',' + ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, r100));
        ALogger.i(bb0.b.b().concat("-lyric"), r101 + ", invoke class :CommonLyricDisplayView");
        ValueAnimator r102 = this.f143076o;
        if (r102 != null) goto L5;
    L16:
        this.f143077p = true;
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = -1;
        Ref.IntRef r104 = new Ref.IntRef();
        r104.element = 0;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, this.f143072k.height()});
        this.f143076o = r105;
        if (r105 == null) goto L19;
        r105.setDuration(230);
    L19:
        ValueAnimator r106 = this.f143076o;
        if (r106 == null) goto L22;
        r106.addUpdateListener(new a(this, r104, r103));
    L22:
        ValueAnimator r107 = this.f143076o;
        if (r107 == null) goto L25;
        r107.addListener(new b(this, r100));
    L25:
        ValueAnimator r108 = this.f143076o;
        if (r108 == null) goto L29;
        r108.start();
        return;
    L29:
        return;
    L5:
        if (r102.isRunning() != true) goto L16;
        ValueAnimator r109 = this.f143076o;
        if (r109 == null) goto L9;
        r109.cancel();
    L9:
        ValueAnimator r110 = this.f143076o;
        if (r110 == null) goto L12;
        r110.removeAllUpdateListeners();
    L12:
        ValueAnimator r111 = this.f143076o;
        if (r111 == null) goto L15;
        r111.removeAllListeners();
    L15:
        this.f143075n = 0;
        goto L16
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = r110.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.f143074m < this.f143069h.size()) goto L5;
        com.bytedance.component.lyric.model.b r101 = null;
    L6:
        com.bytedance.component.lyric.model.b r102 = r101;
        if (r102 == null) goto L34;
        String r103 = r102.f203031d;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String r111 = r103;
        this.f143072k.set(f(r111));
        ig4.c r104 = getConfig().f203013h;
        int r105 = getMeasuredWidth();
        getMeasuredHeight();
        float r112 = r104.c(r105);
        ig4.c r106 = getConfig().f203013h;
        getMeasuredWidth();
        float r113 = r106.d(getMeasuredHeight(), this.f143075n, this.f143072k);
        int r107 = 0;
        if (r102.f203035h == false) goto L22;
        ArrayList<Float> r108 = getConfig().f203013h.e(r112);
        if (r108 != null) goto L17;
        r108 = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r112), Float.valueOf(r112), Float.valueOf(r112)});
    L17:
        if (this.f143069h.size() < 2) goto L21;
        int r109 = RangesKt.coerceAtMost(((int) (((long) ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, 1)).f203029b) - this.f143065d)) / 1000, 3);
    L19:
        if (r107 >= r109) goto L21;
        r110.drawCircle(((Number) ListProtector.get(r108, r107)).floatValue(), o.a(getConfig().f203007b) + r113, getConfig().f203013h.f489732d, getConfig().f203018m);
        r107 = r107 + 1;
    L21:
        boolean r114 = true;
    L23:
        int r115 = getConfig().f203012g + 1;
        int r116 = 1;
    L24:
        if (r116 >= r115) goto L26;
        d(r110, r116, r112, r113, r114);
        r116 = r116 + 1;
        goto L24
    L26:
        r110.restoreToCount(r100);
        if (getConfig().f203019n == 3) goto L29;
        return;
    L29:
        if (r102.f203035h == true) goto L36;
        r110.clipRect(this.f143070i);
        r110.drawText(r111, r112, r113, getConfig().f203016k);
        return;
    L36:
        return;
    L22:
        r110.drawText(r111, r112, r113, getConfig().f203017l);
        r114 = false;
        goto L23
    L34:
        return;
    L5:
        r101 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void renderLyricsByPlayTime(long r100) {
        this.f143065d = r100;
        int r101 = e(r100);
        this.f143066e = r100;
        if (this.f143074m != r101) goto L5;
    L7:
        invalidate();
        return;
    L5:
        if (this.f143077p == true) goto L7;
        h(r101);
        goto L7
    }

    public final void setAddedLines(int r100) {
        this.f143087z = r100;
    }

    public final void setAnimating(boolean r100) {
        this.f143077p = r100;
    }

    public final void setAnimatingHide(boolean r100) {
        this.f143078q = r100;
    }

    public final void setAnimationY(int r100) {
        this.f143075n = r100;
    }

    public final void setCurLinePorgress(float r100) {
        this.f143068g = r100;
    }

    public final void setCurShowIndex(int r100) {
        this.f143074m = r100;
    }

    public final void setCurToAddLineIndex(int r100) {
        this.f143067f = r100;
    }

    public final void setCurrMusicProcess(long r100) {
        this.f143065d = r100;
    }

    public final void setDrawOptEnable(boolean r100) {
        this.f143080s = r100;
    }

    public final void setInScroll(boolean r100) {
        this.f143064c = r100;
    }

    public final void setLastMusicProcess(long r100) {
        this.f143066e = r100;
    }

    public final void setScrollAnimator(ValueAnimator r100) {
        this.f143076o = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void addLyrics(List<com.bytedance.component.lyric.model.b> r100, long r101) {
        List<com.bytedance.component.lyric.model.b> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        this.C = r100;
        if (getConfig().f203009d <= 0) goto L14;
    L18:
        this.D = r101;
        ALogger.i("mv_lyric", "addLyrics " + r100.size());
        this.f143069h.clear();
        this.f143087z = 0;
        this.f143072k.setEmpty();
        this.f143070i.setEmpty();
        this.f143073l.setEmpty();
        ((LinkedHashMap) this.f143083v).clear();
        ((LinkedHashMap) this.f143084w).clear();
        ((LinkedHashMap) this.f143085x).clear();
        this.f143074m = 0;
        this.f143077p = false;
        b(r100);
        Iterator<com.bytedance.component.lyric.model.b> r104 = r100.iterator();
    L20:
        if (r104.hasNext() == false) goto L24;
        com.bytedance.component.lyric.model.b r105 = r104.next();
        if (TextUtils.isEmpty(r105.f203031d) == true) goto L20;
        adjustAddLyricsLine(r105, false);
        goto L20
    L24:
        long r106 = this.f143065d;
        if (r106 <= 0) goto L27;
        r101 = r106;
    L27:
        this.f143074m = e(r101);
        return;
    L14:
        if (getWidth() <= 0) goto L16;
        getConfig().f(getWidth());
        goto L18
    L16:
        this.A = r100;
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r110, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "lyricsLineInfo");
        float r100 = getConfig().f203009d;
        String r101 = r110.f203031d;
        Paint r102 = getConfig().f203016k;
        if (r210 == false) goto L5;
        int r103 = this.f143069h.size();
    L6:
        this.f143087z = r103;
        this.B = r100;
        if (r102.measureText(r101) > r100) goto L16;
        int r104 = this.f143067f + 1;
        this.f143067f = r104;
        if (this.f143087z < r104) goto L11;
        return;
    L11:
        if (this.f143080s == false) goto L13;
        kg4.a.a(r110);
    L13:
        this.f143069h.add(r110);
        return;
    L16:
        if (getConfig().f203019n != 2) goto L33;
        com.bytedance.component.lyric.model.b r105 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r106 = new com.bytedance.component.lyric.model.b();
        StringBuilder r107 = new StringBuilder();
        StringBuilder r108 = new StringBuilder();
        StringBuilder r109 = new StringBuilder();
        String r111 = r110.f203031d;
        if (r111 == null) goto L88;
        int r112 = r111.length();
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L26;
        char r114 = r111.charAt(r113);
        r107.append(r114);
        if (r102.measureText(r107.toString()) <= r100) goto L24;
        r109.append(r114);
    L25:
        r113 = r113 + 1;
        goto L20
    L24:
        r108.append(r114);
        goto L25
    L26:
        r105.f203029b = r110.f203029b;
        r105.f203031d = r108.toString();
        int r115 = this.f143067f + 1;
        this.f143067f = r115;
        if (this.f143087z >= r115) goto L29;
        this.f143069h.add(r105);
    L29:
        r106.f203029b = r110.f203029b + 4000;
        r106.f203031d = r109.toString();
        int r116 = this.f143067f + 1;
        this.f143067f = r116;
        if (this.f143087z >= r116) goto L106;
        this.f143069h.add(r106);
        return;
    L106:
        return;
    L88:
        return;
    L33:
        if (getConfig().f203019n != 3) goto L108;
        com.bytedance.component.lyric.model.b r117 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r118 = new com.bytedance.component.lyric.model.b();
        StringBuilder r119 = new StringBuilder();
        String[] r120 = r110.f203033f;
        if (r120 == null) goto L109;
        ArrayList r121 = new ArrayList();
        ArrayList r122 = new ArrayList();
        ArrayList r123 = new ArrayList();
        StringBuilder r124 = new StringBuilder();
        StringBuilder r125 = new StringBuilder();
        ArrayList r126 = new ArrayList();
        int r127 = r110.f203029b;
        int r128 = r120.length;
        int r129 = 0;
    L37:
        if (r129 >= r128) goto L51;
        int r130 = r128;
        String r131 = r120[r129];
        r119.append(r131);
        String[] r132 = r120;
        if (r102.measureText(r119.toString()) <= r100) goto L45;
        r123.add(r131);
        r125.append(r131);
        int[] r133 = r110.f203034g;
        if (r133 == null) goto L50;
        if (r129 >= r133.length) goto L50;
        r126.add(Integer.valueOf(r133[r129]));
    L50:
        r129 = r129 + 1;
        r128 = r130;
        r120 = r132;
        goto L37
    L45:
        r121.add(r131);
        r124.append(r131);
        int[] r134 = r110.f203034g;
        if (r134 == null) goto L50;
        if (r129 >= r134.length) goto L50;
        r122.add(Integer.valueOf(r134[r129]));
        r127 = r127 + r134[r129];
        goto L50
    L51:
        r117.f203029b = r110.f203029b;
        Object[] r135 = r121.toArray(new String[0]);
        if (r135 == null) goto L87;
        r117.f203033f = (String[]) r135;
        r117.f203034g = new int[r122.size()];
        int r136 = r122.size();
        int r137 = 0;
    L54:
        if (r137 >= r136) goto L60;
        int[] r138 = r117.f203034g;
        if (r138 == null) goto L58;
        r138[r137] = ((Number) ListProtector.get(r122, r137)).intValue();
    L58:
        r137 = r137 + 1;
        goto L54
    L60:
        if (this.f143079r == false) goto L66;
        String r139 = r124.toString();
        if (r139 == null) goto L65;
        r117.f203031d = StringsKt.trim(r139).toString();
    L67:
        int r140 = this.f143067f + 1;
        this.f143067f = r140;
        if (this.f143087z >= r140) goto L70;
        this.f143069h.add(r117);
    L70:
        r118.f203029b = r127;
        Object[] r141 = r123.toArray(new String[0]);
        if (r141 == null) goto L85;
        r118.f203033f = (String[]) r141;
        r118.f203034g = new int[r126.size()];
        int r142 = r126.size();
        int r143 = 0;
    L73:
        if (r143 >= r142) goto L78;
        int[] r144 = r118.f203034g;
        if (r144 == null) goto L77;
        r144[r143] = ((Number) ListProtector.get(r126, r143)).intValue();
    L77:
        r143 = r143 + 1;
        goto L73
    L78:
        r118.f203031d = r125.toString();
        int r145 = this.f143067f + 1;
        this.f143067f = r145;
        if (this.f143087z >= r145) goto L82;
        this.f143069h.add(r118);
    L82:
        if (this.f143080s == false) goto L110;
        kg4.a.a(r118);
        kg4.a.a(r117);
        return;
    L110:
        return;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L66:
        r117.f203031d = r124.toString();
        goto L67
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L109:
        return;
    L108:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        p.a r102 = p.f143569g;
        Function1<p, Unit> r103 = new AnonymousClass1(this, r101);
        r102.getClass();
        p.a.a(r103);
    }

    public CommonLyricDisplayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.f143069h = new ArrayList();
        this.f143070i = new RectF();
        this.f143072k = new Rect();
        this.f143073l = new Rect();
        KtvUtilsKt.d(20.0f);
        this.f143079r = h.v();
        this.f143080s = h.a0();
        this.f143082u = 1.0f;
        this.f143083v = new LinkedHashMap();
        this.f143084w = new LinkedHashMap();
        this.f143085x = new LinkedHashMap();
        this.f143086y = h.m();
        this.E = true;
    }

    public /* synthetic */ CommonLyricDisplayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = 0;
        if (r100 != r102) goto L5;
    L7:
        boolean r105 = false;
    L8:
        getConfig().f(r100);
        if (r105 == false) goto L17;
        List<com.bytedance.component.lyric.model.b> r106 = this.C;
        if (r106 == null) goto L18;
        if (r106 == null) goto L14;
        r104 = r106.size();
    L14:
        if (r104 <= 0) goto L19;
        addLyrics(this.C, this.D);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (((int) this.B) == r100) goto L7;
        r105 = true;
        goto L8
    }

    public final void d(Canvas r100, int r101, float r102, float r110, boolean r111) {
        if ((this.f143074m + r101) < this.f143069h.size()) goto L5;
        com.bytedance.component.lyric.model.b r103 = null;
    L6:
        if (r103 == null) goto L23;
        String r104 = r103.f203031d;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        Rect r105 = this.f143073l;
        if (((LinkedHashMap) this.f143085x).get(r104) == null) goto L13;
        Rect r106 = (Rect) ((LinkedHashMap) this.f143085x).get(r104);
    L14:
        if (r106 != null) goto L16;
        r106 = new Rect();
    L16:
        r105.set(r106);
        if (r111 == false) goto L19;
        float r112 = getConfig().f203007b;
    L20:
        if (r100 == null) goto L24;
        r100.drawText(r104, r102, ((r110 + (this.f143073l.height() * r101)) + (o.a(getConfig().f203006a) * r101)) + o.a(r112), getConfig().f203014i);
        return;
    L24:
        return;
    L19:
        r112 = 0.0f;
        goto L20
    L13:
        r106 = new Rect();
        getConfig().f203014i.getTextBounds(r104, 0, r104.length(), r106);
        this.f143085x.put(r104, r106);
        goto L14
    L23:
        return;
    L5:
        r103 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143069h, this.f143074m + r101);
        goto L6
    }
}
