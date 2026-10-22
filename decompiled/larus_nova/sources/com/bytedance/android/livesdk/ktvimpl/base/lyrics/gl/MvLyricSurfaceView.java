package com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.c;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvHwDrawBaseSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import ig4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd2.e;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u001b\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016RT\u0010%\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/gl/MvLyricSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvHwDrawBaseSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/a;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "getCurrentLyrics", "Landroid/graphics/Paint$Align;", "getTextAlign", "", "getCurrentIndex", "visible", "", "setLyricVisible", "", "maxWith", "setLyricOneLineMaxWidth", "align", "setLyricAlignStyle", "", "hide", "setHideFirstLineLyric", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "J", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "K", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvLyricSurfaceView extends KtvHwDrawBaseSurfaceView implements com.bytedance.android.livesdk.ktvimpl.base.lyrics.a, c {
    public static final /* synthetic */ int L = 0;
    public float A;
    public float B;
    public volatile long C;
    public ValueAnimator D;
    public ValueAnimator E;
    public AnimatorSet F;
    public volatile boolean G;
    public final RectF H;
    public final d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f143173J;
    public String K;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint.Align f143174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f143175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public KtvRoomLyricsStateMachineConfig.d f143176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f143177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f143178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f143179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LyricsDisplayConfig f143180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<com.bytedance.component.lyric.model.b> f143181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<com.bytedance.component.lyric.model.b> f143182q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, Float> f143183r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f143184s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<com.bytedance.component.lyric.model.b> f143185t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Paint f143186u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f143187v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f143188w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f143189x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile int f143190y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f143191z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvLyricSurfaceView f143192a;

        public b(MvLyricSurfaceView r100) {
            this.f143192a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Paint r101 = this.f143192a.f143180o.f203014i;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setAlpha(((Integer) r102).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final View asView() {
        return this;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final String name() {
        return "MvLyricSurfaceView";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateDynamicPaintColor() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final boolean isFinishDrawLastLine() {
        int r100 = this.f143190y;
        ArrayList r101 = new ArrayList(this.f143181p);
        if (r100 > 0) goto L5;
        return false;
    L5:
        if (r100 == (r101.size() - 1)) goto L7;
        return false;
    L7:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r101, r100)).f203034g == null) goto L18;
        int[] r102 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r101, r100)).f203034g;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L12;
        r105 = r105 + r102[r104];
        r104 = r104 + 1;
        goto L9
    L12:
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r101, r100)).f203029b + r105) > this.C) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void onConfigComplete() {
        LyricsDisplayConfig r100 = this.f143180o;
        d r101 = this.I;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f203013h = r101;
        Paint.FontMetrics r102 = this.f143180o.f203016k.getFontMetrics();
        float r103 = r102.descent;
        float r104 = 2;
        this.f143191z = ((r103 - r102.ascent) / r104) - r103;
        Paint.FontMetrics r105 = this.f143180o.f203014i.getFontMetrics();
        float r106 = r105.descent;
        this.A = ((r106 - r105.ascent) / r104) - r106;
        Paint.FontMetrics r107 = this.f143180o.f203017l.getFontMetrics();
        float r108 = r107.descent;
        this.B = ((r108 - r107.ascent) / r104) - r108;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void release() {
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), "release, invoke class :MvLyricSurfaceView");
        this.f143189x = 0;
        this.C = 0;
        this.f143190y = 0;
        this.f143181p.clear();
        this.f143176k = null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void resetCurrMusicProcess() {
        this.C = 0;
        this.f143190y = 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public int getCurrentIndex() {
        return this.f143190y;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics() {
        return this.f143181p;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public LyricsDisplayConfig getDisplayConfig() {
        return this.f143180o;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f143173J;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public Paint.Align getTextAlign() {
        return Paint.Align.LEFT;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.K;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvHwDrawBaseSurfaceView
    public final void e(Canvas r110) {
        if (this.f143190y < this.f143181p.size()) goto L5;
        return;
    L5:
        if (this.f143190y >= 0) goto L7;
        return;
    L7:
        if (this.f143175j == true) goto L10;
    L21:
        boolean r100 = false;
    L22:
        if (r100 == false) goto L25;
        return;
    L25:
        if (this.G == false) goto L27;
    L32:
        this.f143180o.f203014i.clearShadowLayer();
    L34:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203036i == true) goto L36;
    L58:
        if (r110 == null) goto L61;
        g(r110, this.f143190y, this.f143181p, true);
    L61:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203036i == true) goto L63;
        if (r110 != null) goto L69;
        return;
    L69:
        if (this.G == false) goto L71;
        int r101 = this.f143190y - 1;
    L72:
        g(r110, r101, this.f143181p, false);
        return;
    L71:
        r101 = this.f143190y + 1;
        goto L72
    L63:
        if (this.C < (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203030c + 1000)) goto L79;
        this.f143180o.f203014i.setAlpha(255);
        if (r110 == null) goto L80;
        g(r110, this.f143190y + 1, this.f143181p, false);
        return;
    L80:
        return;
    L79:
        return;
    L36:
        if (this.f143181p.size() > 0) goto L38;
    L43:
        int r102 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203030c;
    L45:
        if ((this.C - ((long) r102)) <= 1000) goto L58;
        int r103 = this.f143190y + 1;
        if (r103 >= this.f143181p.size()) goto L74;
        com.bytedance.component.lyric.model.b r104 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r103);
        if (this.f143177l == false) goto L54;
        int r105 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a(r104) == false) goto L54;
        r103 = this.f143190y + 2;
        r104 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r103);
    L54:
        if (r104.f203029b >= (this.C + ((long) 3000))) goto L75;
        if (r110 == null) goto L76;
        g(r110, r103, this.f143181p, false);
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L38:
        if (this.f143190y < (this.f143181p.size() - 1)) goto L43;
        Integer r106 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203040m;
        if (r106 == null) goto L42;
        r102 = r106.intValue();
        goto L45
    L42:
        r102 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, this.f143190y)).f203030c;
        goto L45
    L27:
        if (this.f143180o.f203014i.getAlpha() < 10) goto L32;
        LyricsDisplayConfig r107 = this.f143180o;
        Function1<? super Paint, Unit> r108 = r107.f203021p;
        if (r108 == null) goto L34;
        Unit r109 = r108.invoke(r107.f203014i);
        goto L34
    L10:
        if (KtvSettingHelper.w() == false) goto L21;
        if ((this.f143176k instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L15;
        this.C = 1;
    L15:
        if (this.f143190y != 0) goto L21;
        if (this.C != 0) goto L21;
        if ((this.f143176k instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L21;
        r100 = true;
        goto L22
    }

    public final void f(long r110) {
        this.I.f489734g = this.f143190y;
        int r100 = this.f143190y;
        ArrayList r101 = new ArrayList(this.f143181p);
        if (r100 >= r101.size()) goto L26;
        if (r100 < 0) goto L27;
        com.bytedance.component.lyric.model.b r102 = (com.bytedance.component.lyric.model.b) ListProtector.get(r101, r100);
        float r103 = n(r102.f203031d);
        long r111 = r110 - ((long) r102.f203029b);
        StringBuilder r104 = new StringBuilder();
        int[] r105 = r102.f203034g;
        if (r105 == null) goto L21;
        int r106 = r105.length;
        long r107 = 0;
        int r108 = 0;
    L9:
        if (r108 >= r106) goto L21;
        long r109 = r105[r108];
        r107 = r107 + r109;
        String[] r112 = r102.f203033f;
        if (r112 == null) goto L14;
        String r113 = r112[r108];
        if (r113 == null) goto L14;
    L16:
        if (r111 < r107) goto L17;
        r104.append(r113);
        r108 = r108 + 1;
        goto L9
    L17:
        if (r108 <= 0) goto L19;
        r111 = r111 - (r107 - r109);
    L19:
        float r114 = (n(r113) / r105[r108]) * r111;
    L22:
        ig4.c.b(this.f143180o.f203013h, this.H, getMeasuredHeight(), getMeasuredWidth(), r103, r114 + n(r104.toString()));
        return;
    L14:
        r113 = "";
    L21:
        r114 = 0.0f;
        goto L22
    L27:
        return;
    }

    public final int l(long r100) {
        int r101 = this.f143181p.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L42;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r102)).f203028a != 1) goto L10;
        if (this.f143177l == false) goto L10;
    L32:
        r102 = r102 + 1;
    L10:
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, 0)).f203029b) goto L43;
        if (r100 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r102)).f203029b) goto L25;
        if (r102 <= 0) goto L25;
        if (this.f143180o.f203019n != 3) goto L18;
        f(r100);
    L18:
        int r103 = r102 - 1;
        if (this.f143177l == false) goto L33;
        int r104 = com.bytedance.component.lyric.model.b.f203027o;
        if (com.bytedance.component.lyric.model.b.a.a((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r103)) == false) goto L33;
        r103 = r103 - 1;
    L33:
        return r103;
    L25:
        if (r102 != (this.f143181p.size() - 1)) goto L32;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143181p, r102)).f203029b) goto L32;
        if (this.f143180o.f203019n != 3) goto L41;
        f(r100);
    L41:
        return this.f143181p.size() - 1;
    L43:
        return 0;
    L42:
        return 0;
    }

    public final float n(String r100) {
        if (r100 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.f143183r).get(r100) == null) goto L6;
        Float r101 = (Float) ((LinkedHashMap) this.f143183r).get(r100);
    L7:
        if (r101 == null) goto L9;
        return r101.floatValue();
    L6:
        float r102 = this.f143180o.f203016k.measureText(r100);
        this.f143183r.put(r100, Float.valueOf(r102));
        r101 = Float.valueOf(r102);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r100) {
        if (this.f143181p.isEmpty() == false) goto L7;
        String r101 = "renderLyricsByPlayTime  ;; lyricsLineInfos is empty ;; " + this.C + " ;; " + r100;
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), r101 + ", invoke class :MvLyricSurfaceView");
        return;
    L7:
        if (this.C <= r100) goto L10;
        String r102 = "renderLyricsByPlayTime ;;  currMusicProcess > playTime ;; " + this.C + " ;; " + r100;
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), r102 + ", invoke class :MvLyricSurfaceView");
        return;
    L10:
        this.C = r100;
        int r103 = l(r100);
        if (KtvSettingHelper.w() == false) goto L16;
        if (this.f143190y < r103) goto L17;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L56;
        AnimatorSet r105 = this.F;
        if (r105 != null) goto L23;
    L37:
        this.F = new AnimatorSet();
        int r106 = this.f143180o.f203014i.getAlpha();
        AnimatorSet r107 = this.F;
        if (r107 == null) goto L40;
        r107.addListener(new vd2.c(this, r103));
    L40:
        this.D = m(r106, 0);
        this.E = m(0, 255);
        e r108 = new e(this);
        AnimatorSet r109 = this.F;
        if (r109 == null) goto L43;
        r109.addListener(r108);
    L43:
        ValueAnimator r110 = this.D;
        if (r110 == null) goto L46;
        r110.addListener(new vd2.d(this));
    L46:
        AnimatorSet r111 = this.F;
        if (r111 == null) goto L49;
        r111.playSequentially(new Animator[]{this.D, this.E});
    L49:
        AnimatorSet r112 = this.F;
        if (r112 == null) goto L52;
        r112.setDuration(500);
    L52:
        AnimatorSet r113 = this.F;
        if (r113 == null) goto L57;
        r113.start();
        return;
    L57:
        return;
    L23:
        if (r105.isRunning() != true) goto L37;
        AnimatorSet r114 = this.F;
        if (r114 == null) goto L27;
        r114.cancel();
    L27:
        AnimatorSet r115 = this.F;
        if (r115 == null) goto L30;
        r115.removeAllListeners();
    L30:
        ValueAnimator r116 = this.E;
        if (r116 == null) goto L33;
        r116.removeAllUpdateListeners();
    L33:
        ValueAnimator r117 = this.D;
        if (r117 == null) goto L36;
        r117.removeAllUpdateListeners();
    L36:
        this.f143180o.f203014i.setAlpha(255);
        goto L37
    L56:
        return;
    L17:
        r104 = true;
        goto L19
    L16:
        if (this.f143190y == r103) goto L18;
        goto L17
    }

    public void setHideFirstLineLyric(boolean r100) {
        this.f143175j = r100;
    }

    public void setLyricAlignStyle(Paint.Align r100) {
        Intrinsics.checkNotNullParameter(r100, "align");
        this.f143174i = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricOneLineMaxWidth(float r100) {
        if (r100 <= 0) goto L6;
        this.f143180o.f(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricVisible(int r100) {
        setBusinessVisible(r100);
        if (getVisibility() == r100) goto L6;
        setVisibility(r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f143173J = r100;
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.K = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r100) {
        this.f143176k = r100;
    }

    public MvLyricSurfaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f143174i = Paint.Align.LEFT;
        this.f143175j = true;
        this.f143177l = h.m();
        this.f143178m = h.v();
        this.f143179n = h.s();
        LyricsDisplayConfig r102 = new LyricsDisplayConfig();
        this.f143180o = r102;
        this.f143181p = new ArrayList();
        this.f143183r = new LinkedHashMap();
        this.f143186u = r102.f203016k;
        this.f143187v = new Rect();
        this.f143188w = new Rect();
        this.H = new RectF();
        this.I = new d();
        this.K = KtvSubElement.LYRIC;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r100, long r101) {
        this.f143182q = r100;
        int r102 = 0;
        if (this.f143180o.f203009d <= 0) goto L5;
    L9:
        StringBuilder r103 = new StringBuilder("addLyrics ");
        if (r100 == null) goto L12;
        Integer r104 = Integer.valueOf(r100.size());
    L13:
        r103.append(r104);
        String r105 = r103.toString();
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric_glImpl"), r105 + ", invoke class :MvLyricSurfaceView");
        this.f143181p.clear();
        this.f143184s = 0;
        this.f143187v.setEmpty();
        this.H.setEmpty();
        this.f143188w.setEmpty();
        ((LinkedHashMap) this.f143183r).clear();
        this.f143190y = 0;
        if (r100 == null) goto L22;
        Iterator<com.bytedance.component.lyric.model.b> r106 = r100.iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        com.bytedance.component.lyric.model.b r107 = r106.next();
        if (TextUtils.isEmpty(r107.f203031d) == true) goto L17;
        adjustAddLyricsLine(r107, false);
    L22:
        if (this.C <= 0) goto L24;
        r101 = this.C;
    L24:
        this.f143190y = l(r101);
        if (getMeasuredWidth() > 0) goto L27;
    L28:
        measure(0, 0);
    L30:
        if (r100 == null) goto L40;
        Iterator<T> r108 = r100.iterator();
        int r109 = 0;
    L33:
        if (r108.hasNext() == false) goto L40;
        com.bytedance.component.lyric.model.b r110 = (com.bytedance.component.lyric.model.b) r108.next();
        int r111 = r109 - 1;
        if (r111 <= 5) goto L39;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r100, r109)).f203029b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r100, r111)).f203030c) <= this.f143179n) goto L39;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r100, r111)).f203036i = true;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r100, r109)).f203037j = true;
    L39:
        r109 = r109 + 1;
    L40:
        if (r100 == null) goto L62;
        com.bytedance.component.lyric.model.b r112 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(r100);
        if (r112 == null) goto L63;
        r112.f203036i = true;
        int[] r113 = r112.f203034g;
        if (r113 == null) goto L49;
        int r114 = r113.length;
        int r115 = 0;
    L46:
        if (r102 >= r114) goto L48;
        r115 = r115 + r113[r102];
        r102 = r102 + 1;
        goto L46
    L48:
        r102 = r115;
    L49:
        if (r102 <= 0) goto L64;
        r112.f203040m = Integer.valueOf(r102 + r112.f203029b);
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L27:
        if (getMeasuredHeight() > 0) goto L30;
    L12:
        r104 = null;
        goto L13
    L5:
        if (getWidth() <= 0) goto L7;
        this.f143180o.f(getWidth());
        goto L9
    L7:
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric_glImpl"), "addLyrics oneLineMaxWidth <= 0 return, invoke class :MvLyricSurfaceView");
        this.f143185t = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r110, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "lyricsLineInfo");
        float r100 = this.f143180o.f203009d;
        ALogger.i("MvLyricSurfaceView", "adjustAddLyricsLine " + r110.f203031d + " ;; width == " + r100);
        String r101 = r110.f203031d;
        Paint r102 = this.f143180o.f203016k;
        if (r210 == false) goto L5;
        int r103 = this.f143181p.size();
    L6:
        this.f143184s = r103;
        if (r102.measureText(r101) > r100) goto L12;
        int r104 = this.f143189x + 1;
        this.f143189x = r104;
        if (this.f143184s >= r104) goto L99;
        this.f143181p.add(r110);
        return;
    L99:
        return;
    L12:
        int r105 = this.f143180o.f203019n;
        if (r105 != 2) goto L30;
        com.bytedance.component.lyric.model.b r106 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r107 = new com.bytedance.component.lyric.model.b();
        StringBuilder r108 = new StringBuilder();
        StringBuilder r109 = new StringBuilder();
        StringBuilder r111 = new StringBuilder();
        String r112 = r110.f203031d;
        if (r112 == null) goto L82;
        int r113 = r112.length();
        int r114 = 0;
    L17:
        if (r114 >= r113) goto L23;
        char r115 = r112.charAt(r114);
        r108.append(r115);
        if (r102.measureText(r108.toString()) <= r100) goto L21;
        r111.append(r115);
    L22:
        r114 = r114 + 1;
        goto L17
    L21:
        r109.append(r115);
        goto L22
    L23:
        r106.f203029b = r110.f203029b;
        r106.f203031d = r109.toString();
        int r116 = this.f143189x + 1;
        this.f143189x = r116;
        if (this.f143184s >= r116) goto L26;
        this.f143181p.add(r106);
    L26:
        r107.f203029b = r110.f203029b + 4000;
        r107.f203031d = r111.toString();
        int r117 = this.f143189x + 1;
        this.f143189x = r117;
        if (this.f143184s >= r117) goto L100;
        this.f143181p.add(r107);
        return;
    L100:
        return;
    L82:
        return;
    L30:
        if (r105 != 3) goto L102;
        com.bytedance.component.lyric.model.b r118 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r119 = new com.bytedance.component.lyric.model.b();
        StringBuilder r120 = new StringBuilder();
        String[] r121 = r110.f203033f;
        if (r121 == null) goto L103;
        ArrayList r122 = new ArrayList();
        ArrayList r123 = new ArrayList();
        ArrayList r124 = new ArrayList();
        StringBuilder r125 = new StringBuilder();
        StringBuilder r126 = new StringBuilder();
        ArrayList r127 = new ArrayList();
        int r128 = r110.f203029b;
        int r129 = r121.length;
        int r130 = 0;
    L34:
        if (r130 >= r129) goto L48;
        int r131 = r129;
        String r132 = r121[r130];
        r120.append(r132);
        String[] r133 = r121;
        if (r102.measureText(r120.toString()) <= r100) goto L42;
        r124.add(r132);
        r126.append(r132);
        int[] r134 = r110.f203034g;
        if (r134 == null) goto L47;
        if (r130 >= r134.length) goto L47;
        r127.add(Integer.valueOf(r134[r130]));
    L47:
        r130 = r130 + 1;
        r129 = r131;
        r121 = r133;
        goto L34
    L42:
        r122.add(r132);
        r125.append(r132);
        int[] r135 = r110.f203034g;
        if (r135 == null) goto L47;
        if (r130 >= r135.length) goto L47;
        r123.add(Integer.valueOf(r135[r130]));
        r128 = r128 + r135[r130];
        goto L47
    L48:
        r118.f203029b = r110.f203029b;
        Object[] r136 = r122.toArray(new String[0]);
        if (r136 == null) goto L81;
        r118.f203033f = (String[]) r136;
        r118.f203034g = new int[r123.size()];
        int r137 = r123.size();
        int r138 = 0;
    L51:
        if (r138 >= r137) goto L57;
        int[] r139 = r118.f203034g;
        if (r139 == null) goto L55;
        r139[r138] = ((Number) ListProtector.get(r123, r138)).intValue();
    L55:
        r138 = r138 + 1;
        goto L51
    L57:
        if (this.f143178m == false) goto L63;
        String r140 = r125.toString();
        if (r140 == null) goto L62;
        r118.f203031d = StringsKt.trim(r140).toString();
    L64:
        int r141 = this.f143189x + 1;
        this.f143189x = r141;
        if (this.f143184s >= r141) goto L67;
        this.f143181p.add(r118);
    L67:
        r119.f203029b = r128;
        Object[] r142 = r124.toArray(new String[0]);
        if (r142 == null) goto L79;
        r119.f203033f = (String[]) r142;
        r119.f203034g = new int[r127.size()];
        int r143 = r127.size();
        int r144 = 0;
    L70:
        if (r144 >= r143) goto L75;
        int[] r145 = r119.f203034g;
        if (r145 == null) goto L74;
        r145[r144] = ((Number) ListProtector.get(r127, r144)).intValue();
    L74:
        r144 = r144 + 1;
        goto L70
    L75:
        r119.f203031d = r126.toString();
        int r146 = this.f143189x + 1;
        this.f143189x = r146;
        if (this.f143184s >= r146) goto L104;
        this.f143181p.add(r119);
        return;
    L104:
        return;
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L63:
        r118.f203031d = r125.toString();
        goto L64
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L103:
        return;
    L102:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final ValueAnimator m(int r100, int r101) {
        if (KtvSettingHelper.z() == false) goto L5;
        ValueAnimator r102 = LiveDegradeFpsAnimator.ofInt(new int[]{r100, r101}).setFpsConfig(KtvSettingHelper.k());
    L6:
        r102.setDuration(250);
        r102.addUpdateListener(new b(this));
        return r102;
    L5:
        r102 = ValueAnimator.ofInt(new int[]{r100, r101});
        goto L6
    }

    public final void g(Canvas r100, int r101, ArrayList<com.bytedance.component.lyric.model.b> r102, boolean r103) {
        if (r101 >= r102.size()) goto L32;
        if (r101 < 0) goto L35;
        String r104 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r102, r101)).f203031d;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        if (r103 == false) goto L11;
        float r105 = this.f143191z;
        Paint r106 = this.f143180o.f203016k;
    L12:
        this.f143186u = r106;
        h(r100, r101, r104, r105);
        if (r103 == true) goto L15;
        return;
    L15:
        if (this.f143180o.f203019n != 3) goto L34;
        r100.save();
        r100.clipRect(this.H);
        if (this.f143180o.f203020o == false) goto L19;
        this.f143186u.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
    L20:
        h(r100, r101, r104, r105);
        this.f143186u.setStrokeWidth(0.0f);
        Paint.Align r107 = this.f143174i;
        Paint.Align r108 = Paint.Align.RIGHT;
        if (r107 != r108) goto L27;
        if ((r101 % 2) != 0) goto L25;
        Paint r109 = this.f143180o.f203017l;
        float r110 = this.B;
        r109.setTextAlign(r108);
        r100.drawText(r104, r100.getWidth(), (r100.getHeight() / 4.0f) + r110, r109);
    L30:
        r100.restore();
        return;
    L25:
        i(r100, this.f143180o.f203017l, r104, this.B);
        goto L30
    L27:
        if ((r101 % 2) != 0) goto L29;
        Paint r111 = this.f143180o.f203017l;
        float r112 = this.B;
        r111.setTextAlign(Paint.Align.LEFT);
        r100.drawText(r104, 0.0f, (r100.getHeight() / 4.0f) + r112, r111);
        goto L30
    L29:
        i(r100, this.f143180o.f203017l, r104, this.B);
        goto L30
    L19:
        this.f143186u.setStrokeWidth(0.0f);
        goto L20
    L34:
        return;
    L11:
        r105 = this.A;
        r106 = this.f143180o.f203014i;
        goto L12
    L35:
        return;
    }

    public final void h(Canvas r100, int r101, String r102, float r103) {
        Paint.Align r104 = this.f143174i;
        Paint.Align r105 = Paint.Align.RIGHT;
        if (r104 != r105) goto L9;
        if ((r101 % 2) != 0) goto L7;
        Paint r106 = this.f143186u;
        r106.setTextAlign(r105);
        r100.drawText(r102, r100.getWidth(), (r100.getHeight() / 4.0f) + r103, r106);
        return;
    L7:
        i(r100, this.f143186u, r102, r103);
        return;
    L9:
        if ((r101 % 2) != 0) goto L11;
        Paint r107 = this.f143186u;
        r107.setTextAlign(Paint.Align.LEFT);
        r100.drawText(r102, 0.0f, (r100.getHeight() / 4.0f) + r103, r107);
        return;
    L11:
        i(r100, this.f143186u, r102, r103);
    }

    public final void i(Canvas r100, Paint r101, String r102, float r103) {
        r101.setTextAlign(Paint.Align.RIGHT);
        r100.drawText(r102, r100.getWidth(), ((r100.getHeight() / 4) * 3.0f) + r103, r101);
    }

    @Override // com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView, android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r100, "holder");
        Function2<Boolean, Long, Unit> r104 = getOneDrawCallback();
        if (r104 == null) goto L6;
        Unit r105 = r104.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
