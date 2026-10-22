package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000e\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR*\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010/\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "Landroid/view/View;", "Landroid/graphics/Paint$Align;", "align", "", "setLyricTextAlign", "", "getAddedLyricsLineByLine", "c", "I", "getCurToAddLineIndex", "()I", "setCurToAddLineIndex", "(I)V", "curToAddLineIndex", "", "d", "Z", "getHasAddedFullLyrics", "()Z", "setHasAddedFullLyrics", "(Z)V", "hasAddedFullLyrics", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getLyricsLineInfos", "()Ljava/util/ArrayList;", "lyricsLineInfos", OfficeSDKRequestTag.KEY_NEW_USER, "getCurShowIndex", "setCurShowIndex", "curShowIndex", "", "value", "u", FaceService.girlLabel, "getOneLineMaxWidth", "()F", "setOneLineMaxWidth", "(F)V", "oneLineMaxWidth", "x", "getForbidPendingLine", "setForbidPendingLine", "forbidPendingLine", "Lub0/b;", "J", "Lub0/b;", "getConfig", "()Lub0/b;", "config", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvAnchorLyricsDisplayView extends View {
    public float A;
    public final Map<String, Float> B;
    public final Map<String, Rect> C;
    public final Map<String, Rect> D;
    public float E;
    public float F;
    public ig4.c G;
    public final boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ub0.b f143578J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function1<Long, Unit>> f143579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f143580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f143581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f143582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<com.bytedance.component.lyric.model.b> f143583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f143584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f143585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f143586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f143587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f143588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f143589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f143590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f143591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f143592n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f143593o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f143594p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f143595q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f143596r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f143597s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f143598t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f143599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint.Align f143600v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f143601w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f143602x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f143603y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f143604z;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvAnchorLyricsDisplayView f143605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143606b;

        public a(KtvAnchorLyricsDisplayView r100, Function1 r101) {
            this.f143605a = r100;
            this.f143606b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            KtvAnchorLyricsDisplayView r101 = this.f143605a;
            if ((r100.getAnimatedValue() instanceof Float) == false) goto L9;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L8;
            float r103 = ((Float) r102).floatValue();
        L10:
            r101.A = r103;
            KtvAnchorLyricsDisplayView r104 = this.f143605a;
            r104.f143584f.setTextSize(t6.a(r104.getContext(), this.f143605a.getConfig().f549308a * this.f143605a.A));
            KtvAnchorLyricsDisplayView r105 = this.f143605a;
            r105.f143585g.setTextSize(t6.a(r105.getContext(), this.f143605a.getConfig().f549308a * this.f143605a.A));
            this.f143605a.invalidate();
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L9:
            r103 = 1.0f;
            goto L10
        }
    }

    public KtvAnchorLyricsDisplayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvAnchorLyricsDisplayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getAddedLyricsLineByLine() {
        return 0;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ((LinkedHashMap) this.f143579a).clear();
        super.onDetachedFromWindow();
    }

    public final ub0.b getConfig() {
        return this.f143578J;
    }

    public final int getCurShowIndex() {
        return this.f143592n;
    }

    public final int getCurToAddLineIndex() {
        return this.f143581c;
    }

    public final boolean getForbidPendingLine() {
        return this.f143602x;
    }

    public final boolean getHasAddedFullLyrics() {
        return this.f143582d;
    }

    public final ArrayList<com.bytedance.component.lyric.model.b> getLyricsLineInfos() {
        return this.f143583e;
    }

    public final float getOneLineMaxWidth() {
        return this.f143599u;
    }

    public final void a(Function1 r100) {
        Intrinsics.checkNotNullParameter("KtvComponentFeedView", "key");
        Intrinsics.checkNotNullParameter(r100, "onProgress");
        this.f143579a.put("KtvComponentFeedView", r100);
    }

    public final void b(long r110) {
        if (this.f143592n < this.f143583e.size()) goto L5;
        return;
    L5:
        com.bytedance.component.lyric.model.b r100 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, this.f143592n);
        float r101 = d(r100.f203031d);
        long r111 = r110 - ((long) r100.f203029b);
        long r102 = 0;
        if (r111 >= 0) goto L8;
        r111 = 0;
    L8:
        StringBuilder r103 = new StringBuilder();
        int[] r104 = r100.f203034g;
        float r105 = 0.0f;
        if (r104 == null) goto L23;
        int r106 = r104.length;
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L23;
        int r108 = r104[r107];
        r102 = r102 + ((long) r108);
        String[] r112 = r100.f203033f;
        if (r112 == null) goto L16;
        String r113 = r112[r107];
        if (r113 == null) goto L16;
    L18:
        if (r111 < r102) goto L19;
        r103.append(r113);
        r107 = r107 + 1;
        goto L11
    L19:
        if (r107 <= 0) goto L21;
        r111 = r111 - (r102 - ((long) r108));
    L21:
        r105 = (d(r113) / r104[r107]) * r111;
    L16:
        r113 = "";
    L23:
        float r109 = r105 + d(r103.toString());
        ig4.c r114 = this.G;
        if (r114 == null) goto L29;
        r114.a(this.f143587i, getMeasuredHeight(), getMeasuredWidth(), r101, r109, this.f143603y);
        return;
    }

    public final void c(final Function1<? super ub0.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "configFun");
        ub0.b r101 = this.f143578J;
        r100.invoke(r101);
        ((LinkedHashMap) this.B).clear();
        ((LinkedHashMap) this.C).clear();
        ((LinkedHashMap) this.D).clear();
        this.f143584f.setTextSize(KtvUtilsKt.d(r101.f549308a));
        this.f143584f.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f143585g.setTextSize(KtvUtilsKt.d(r101.f549308a));
        this.f143586h.setTextSize(KtvUtilsKt.d(r101.f549308a));
        this.f143588j.setTextSize(KtvUtilsKt.d(r101.f549309b));
        this.f143598t = r101.f549310c;
        this.F = r101.f549311d;
        setOneLineMaxWidth(t6.a(getContext(), r101.f549312e));
        this.f143601w = r101.f549314g;
        setLyricTextAlign(r101.f549313f);
        Integer r102 = r101.f549318k;
        if (r102 == null) goto L5;
        this.f143584f.setColor(r102.intValue());
    L5:
        Integer r103 = r101.f549319l;
        if (r103 == null) goto L8;
        this.f143585g.setColor(r103.intValue());
    L8:
        Integer r104 = r101.f549320m;
        if (r104 == null) goto L12;
        this.f143588j.setColor(r104.intValue());
    L12:
        if (r101.f549315h == false) goto L15;
        this.f143584f.setFakeBoldText(true);
        this.f143585g.setFakeBoldText(true);
        this.f143586h.setFakeBoldText(true);
        this.f143588j.setFakeBoldText(true);
    L15:
        if (r101.f549316i == false) goto L18;
        this.f143584f.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(R.color.ttlive_ktv_lyrics_shadow_color));
        this.f143586h.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(R.color.ttlive_ktv_lyrics_shadow_color));
        this.f143588j.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(R.color.ttlive_ktv_lyrics_shadow_color));
    L18:
        if (r101.f549317j == false) goto L20;
        this.f143584f.setLetterSpacing(0.05f);
        this.f143585g.setLetterSpacing(0.05f);
        this.f143588j.setLetterSpacing(0.05f);
    L20:
        this.f143603y = r101.f549321n;
        int r105 = r101.f549322o;
        if (r105 == (-1)) goto L38;
        if (r105 == 0) goto L34;
        if (r105 == 1) goto L33;
        if (r105 != 2) goto L26;
        this.E = 1.286f;
    L39:
        ValueAnimator r106 = this.f143604z;
        if (r106 != null) goto L42;
    L47:
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{this.A, this.E});
        this.f143604z = r107;
        if (r107 == null) goto L50;
        r107.addUpdateListener(new a(this, r100));
    L50:
        ValueAnimator r108 = this.f143604z;
        if (r108 == null) goto L54;
        r108.setDuration(300);
    L54:
        if (getVisibility() != 0) goto L56;
        UtilityKotlinExtentionsKt.s(0, false, false, new KtvAnchorLyricsDisplayView$config$$inlined$apply$lambda$2(this, r100), 7);
    L56:
        invalidate();
        return;
    L42:
        if (r106.isRunning() == true) goto L45;
        r106 = null;
    L45:
        if (r106 == null) goto L47;
        r106.removeAllUpdateListeners();
        r106.removeAllListeners();
        r106.cancel();
        goto L47
    L26:
        if (r105 != 3) goto L28;
        this.E = 1.33f;
        goto L39
    L28:
        if (r105 != 4) goto L39;
        this.E = 1.0f;
        goto L39
    L33:
        this.E = 1.2f;
        goto L39
    L34:
        Integer r109 = r101.f549318k;
        if (r109 == null) goto L37;
        this.f143585g.setColor(r109.intValue());
    L37:
        this.E = 1.0f;
        goto L39
    L38:
        this.E = 1.2f;
        goto L39
    }

    public final float d(String r100) {
        if (KtvSettingHelper.o() == false) goto L13;
        if (r100 != null) goto L6;
    L11:
        return 0.0f;
    L6:
        if (((LinkedHashMap) this.B).get(r100) == null) goto L8;
        Float r101 = (Float) ((LinkedHashMap) this.B).get(r100);
    L9:
        if (r101 == null) goto L11;
        return r101.floatValue();
    L8:
        float r102 = this.f143584f.measureText(r100);
        this.B.put(r100, Float.valueOf(r102));
        r101 = Float.valueOf(r102);
        goto L9
    L13:
        return this.f143584f.measureText(r100);
    }

    public final void e(long r100) {
        this.f143580b = r100;
        Iterator r101 = ((LinkedHashMap) this.f143579a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) ((Map.Entry) r101.next()).getValue()).invoke(Long.valueOf(this.f143580b));
        goto L4
    L6:
        int r102 = this.f143583e.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L30;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, 0)).f203029b) goto L12;
        if (r100 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, r103)).f203029b) goto L22;
        if (r103 <= 0) goto L22;
        if (this.f143591m != 3) goto L20;
        b(r100);
    L20:
        int r104 = r103 - 1;
    L32:
        if (this.f143592n != r104) goto L34;
    L61:
        invalidate();
        return;
    L34:
        if (this.f143597s == true) goto L61;
        ValueAnimator r105 = this.f143596r;
        if (r105 != null) goto L38;
    L49:
        this.f143597s = true;
        Ref.IntRef r106 = new Ref.IntRef();
        r106.element = -1;
        Ref.IntRef r107 = new Ref.IntRef();
        r107.element = 0;
        ValueAnimator r110 = ValueAnimator.ofInt(new int[]{0, this.f143593o.height()});
        this.f143596r = r110;
        if (r110 == null) goto L52;
        r110.setDuration(300);
    L52:
        ValueAnimator r111 = this.f143596r;
        if (r111 == null) goto L55;
        r111.addUpdateListener(new b((KtvAudienceLyricsDisplayView) this, r107, r106));
    L55:
        ValueAnimator r108 = this.f143596r;
        if (r108 == null) goto L58;
        r108.addListener(new c((KtvAudienceLyricsDisplayView) this, r104));
    L58:
        this.I = false;
        ValueAnimator r109 = this.f143596r;
        if (r109 == null) goto L61;
        r109.start();
        goto L61
    L38:
        if (r105.isRunning() != true) goto L49;
        ValueAnimator r112 = this.f143596r;
        if (r112 == null) goto L42;
        r112.cancel();
    L42:
        ValueAnimator r113 = this.f143596r;
        if (r113 == null) goto L45;
        r113.removeAllUpdateListeners();
    L45:
        ValueAnimator r114 = this.f143596r;
        if (r114 == null) goto L48;
        r114.removeAllListeners();
    L48:
        this.f143595q = 0;
    L22:
        if (r103 != (this.f143583e.size() - 1)) goto L29;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, r103)).f203029b) goto L29;
        if (this.f143591m != 3) goto L28;
        b(r100);
    L28:
        r104 = this.f143583e.size() - 1;
    L29:
        r103 = r103 + 1;
        goto L8
    L12:
        if (this.f143591m != 3) goto L30;
        b(r100);
    L30:
        r104 = 0;
        goto L32
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = r110.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.f143592n < this.f143583e.size()) goto L5;
        com.bytedance.component.lyric.model.b r101 = null;
    L6:
        if (r101 == null) goto L109;
        String r102 = r101.f203031d;
        String r103 = "";
        if (r102 != null) goto L10;
        String r111 = "";
    L12:
        if (KtvSettingHelper.o() == false) goto L20;
        Rect r104 = this.f143593o;
        if (((LinkedHashMap) this.C).get(r111) == null) goto L16;
        Rect r105 = (Rect) ((LinkedHashMap) this.C).get(r111);
    L17:
        if (r105 != null) goto L19;
        r105 = new Rect();
    L19:
        r104.set(r105);
    L21:
        ig4.c r106 = this.G;
        if (r106 == null) goto L24;
        int r107 = getMeasuredWidth();
        getMeasuredHeight();
        float r112 = r106.c(r107);
    L25:
        ig4.c r108 = this.G;
        if (r108 == null) goto L28;
        getMeasuredWidth();
        float r113 = r108.d(getMeasuredHeight(), this.f143595q, this.f143593o);
    L30:
        if (r101.f203035h == false) goto L47;
        ig4.c r109 = this.G;
        if (r109 == null) goto L35;
        ArrayList<Float> r114 = r109.e(r112);
        if (r114 == null) goto L35;
    L37:
        if (this.f143583e.size() < 2) goto L45;
        int r115 = RangesKt.coerceAtMost(((int) (((long) ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, 1)).f203029b) - this.f143580b)) / 1000, 3);
        int r116 = 0;
    L39:
        if (r116 >= r115) goto L45;
        float r117 = ((Number) ListProtector.get(r114, r116)).floatValue();
        float r118 = o.a(this.F) + r113;
        ig4.c r119 = this.G;
        if (r119 == null) goto L43;
        float r120 = r119.f489732d;
    L44:
        r110.drawCircle(r117, r118, r120, this.f143586h);
        r116 = r116 + 1;
        goto L39
    L43:
        r120 = 10.0f;
    L45:
        boolean r121 = true;
    L58:
        if (this.I == false) goto L60;
        int r122 = this.f143601w + 1;
    L62:
        if (this.f143602x == true) goto L90;
        int r123 = 1;
    L64:
        if (r123 >= r122) goto L90;
        if ((this.f143592n + r123) < this.f143583e.size()) goto L68;
        com.bytedance.component.lyric.model.b r124 = null;
    L69:
        if (r124 == null) goto L87;
        String r125 = r124.f203031d;
        if (r125 != null) goto L74;
        r125 = r103;
    L74:
        if (KtvSettingHelper.o() == false) goto L82;
        Rect r126 = this.f143594p;
        if (((LinkedHashMap) this.D).get(r125) == null) goto L78;
        Rect r127 = (Rect) ((LinkedHashMap) this.D).get(r125);
    L79:
        if (r127 != null) goto L81;
        r127 = new Rect();
    L81:
        r126.set(r127);
    L83:
        if (r121 == false) goto L85;
        float r128 = this.F;
    L86:
        r110.drawText(r125, r112, (((this.f143594p.height() * r123) + r113) + (o.a(this.f143598t) * r123)) + o.a(r128), this.f143588j);
    L88:
        r123 = r123 + 1;
        r103 = r103;
        goto L64
    L85:
        r128 = 0.0f;
        goto L86
    L78:
        r127 = new Rect();
        this.f143588j.getTextBounds(r125, 0, r125.length(), r127);
        this.D.put(r125, r127);
        goto L79
    L82:
        r103 = r103;
        this.f143588j.getTextBounds(r125, 0, r125.length(), this.f143594p);
        goto L83
    L87:
        r103 = r103;
        goto L88
    L68:
        r124 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, this.f143592n + r123);
    L90:
        if (this.f143578J.f549323p == false) goto L92;
        r110.drawRect(0.0f, getMeasuredHeight() - this.f143590l, getMeasuredWidth(), getMeasuredHeight(), this.f143589k);
    L92:
        r110.restoreToCount(r100);
        if (this.f143591m == 3) goto L95;
        return;
    L95:
        if (r101.f203035h == false) goto L97;
        return;
    L97:
        if (this.f143578J.f549322o == 0) goto L112;
        r110.clipRect(this.f143587i);
        if (this.f143603y == false) goto L101;
        r110.drawText(r111, r112, r113, this.f143584f);
        return;
    L101:
        this.f143584f.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
        r110.drawText(r111, r112, r113, this.f143584f);
        this.f143584f.setStrokeWidth(0.0f);
        r110.drawText(r111, r112, r113, this.f143585g);
        return;
    L112:
        return;
    L60:
        r122 = this.f143601w;
    L35:
        r114 = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r112), Float.valueOf(r112), Float.valueOf(r112)});
        goto L37
    L47:
        if (this.f143603y == false) goto L52;
        if (this.f143578J.f549322o == 0) goto L52;
        r110.drawText(r111, r112, r113, this.f143585g);
    L56:
        r121 = false;
    L52:
        if (this.f143591m != 3) goto L54;
        Paint r129 = this.f143584f;
    L55:
        r110.drawText(r111, r112, r113, r129);
        goto L56
    L54:
        r129 = this.f143585g;
        goto L55
    L28:
        r113 = 0.0f;
        goto L30
    L24:
        r112 = 0.0f;
        goto L25
    L16:
        r105 = new Rect();
        this.f143584f.getTextBounds(r111, 0, r111.length(), r105);
        this.C.put(r111, r105);
        goto L17
    L20:
        this.f143584f.getTextBounds(r111, 0, r111.length(), this.f143593o);
        goto L21
    L10:
        r111 = r102;
        goto L12
    L109:
        return;
    L5:
        r101 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143583e, this.f143592n);
        goto L6
    }

    public final void setCurShowIndex(int r100) {
        this.f143592n = r100;
    }

    public final void setCurToAddLineIndex(int r100) {
        this.f143581c = r100;
    }

    public final void setForbidPendingLine(boolean r100) {
        invalidate();
        this.f143602x = r100;
    }

    public final void setHasAddedFullLyrics(boolean r100) {
        this.f143582d = r100;
    }

    public final void setLyricTextAlign(Paint.Align r100) {
        Intrinsics.checkNotNullParameter(r100, "align");
        this.f143600v = r100;
        int r101 = ig4.c.f489728f;
        this.G = ig4.c.a.a(r100, this.f143578J.f549314g);
        Paint.Align r102 = this.f143600v;
        this.f143600v = r102;
        this.f143584f.setTextAlign(r102);
        this.f143585g.setTextAlign(this.f143600v);
        this.f143586h.setTextAlign(this.f143600v);
        this.f143588j.setTextAlign(this.f143600v);
    }

    public final void setOneLineMaxWidth(float r100) {
        this.f143599u = r100;
    }

    public KtvAnchorLyricsDisplayView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f143579a = new LinkedHashMap();
        this.f143583e = new ArrayList();
        Paint r113 = new Paint();
        this.f143584f = r113;
        Paint r114 = new Paint();
        this.f143585g = r114;
        Paint r100 = new Paint();
        this.f143586h = r100;
        this.f143587i = new RectF();
        Paint r101 = new Paint();
        this.f143588j = r101;
        Paint r102 = new Paint();
        this.f143589k = r102;
        this.f143590l = KtvUtilsKt.d(20.0f);
        this.f143591m = 2;
        this.f143593o = new Rect();
        this.f143594p = new Rect();
        this.f143598t = 9.0f;
        this.f143600v = Paint.Align.CENTER;
        this.f143601w = 3;
        this.A = 1.0f;
        LinkedHashMap r103 = new LinkedHashMap();
        this.B = r103;
        LinkedHashMap r104 = new LinkedHashMap();
        this.C = r104;
        LinkedHashMap r105 = new LinkedHashMap();
        this.D = r105;
        this.E = 1.0f;
        this.H = h.v();
        this.f143578J = new ub0.b();
        r113.setTextSize(KtvUtilsKt.d(20.0f));
        Resources r106 = r110.getResources();
        int r107 = -1;
        if (r106 == null) goto L5;
        int r108 = r106.getColor(R.color.ttlive_ktv_lyrics_pending_color);
    L6:
        r113.setColor(r108);
        r113.setDither(true);
        r113.setAntiAlias(true);
        r113.setTextAlign(Paint.Align.CENTER);
        r114.setTextSize(KtvUtilsKt.d(20.0f));
        r114.setColor(s1.h(R.color.ttlive_ktv_lyrics_show_color));
        r114.setDither(true);
        r114.setAntiAlias(true);
        r114.setTextAlign(Paint.Align.CENTER);
        r100.setTextSize(KtvUtilsKt.d(20.0f));
        r100.setColor(s1.h(R.color.ttlive_ktv_lyrics_show_color));
        r100.setDither(true);
        r100.setAntiAlias(true);
        r100.setTextAlign(Paint.Align.CENTER);
        r101.setTextSize(KtvUtilsKt.d(16.0f));
        Resources r115 = r110.getResources();
        if (r115 == null) goto L9;
        r107 = r115.getColor(R.color.ttlive_ktv_lyrics_pending_color);
    L9:
        r101.setColor(r107);
        r101.setDither(true);
        r101.setAntiAlias(true);
        r101.setTextAlign(Paint.Align.CENTER);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        r103.clear();
        r104.clear();
        r105.clear();
        return;
    L5:
        r108 = -1;
        goto L6
    }

    public /* synthetic */ KtvAnchorLyricsDisplayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r110, int r111, int r112, int r113) {
        super.onSizeChanged(r110, r111, r112, r113);
        this.f143589k.setShader(new LinearGradient(0.0f, getMeasuredHeight() - this.f143590l, 0.0f, getMeasuredHeight(), 0, -1, Shader.TileMode.CLAMP));
        setOneLineMaxWidth(r110);
        ALogger.i("KtvLyricsView", "onSizeChanged(on size changed):" + r110 + ',' + r111 + ',' + r112 + ',' + r113 + ".properties:" + getWidth() + ',' + getHeight() + ',' + getMeasuredWidth() + ',' + getMeasuredHeight());
    }
}
