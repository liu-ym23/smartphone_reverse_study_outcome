package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b:\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B.\b\u0007\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\nJ\u0010\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u000106J\u000e\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0002J\u000e\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002R\"\u0010E\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010K\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010P\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010H\u001a\u0004\bM\u0010N\"\u0004\bO\u0010JR\"\u0010T\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010@\u001a\u0004\bR\u0010B\"\u0004\bS\u0010DR\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010^\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010H\u001a\u0004\b\\\u0010N\"\u0004\b]\u0010JR\"\u0010a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010H\u001a\u0004\b_\u0010N\"\u0004\b`\u0010JR\"\u0010e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010H\u001a\u0004\bc\u0010N\"\u0004\bd\u0010JR\"\u0010i\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010H\u001a\u0004\bg\u0010N\"\u0004\bh\u0010JR\"\u0010m\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010H\u001a\u0004\bk\u0010N\"\u0004\bl\u0010JR*\u0010q\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010V\u001a\u0004\bo\u0010X\"\u0004\bp\u0010ZR*\u0010u\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010V\u001a\u0004\bs\u0010X\"\u0004\bt\u0010ZR6\u0010~\u001a\b\u0012\u0004\u0012\u00020w0v2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020w0v8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010\u0082\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010@\u001a\u0005\b\u0080\u0001\u0010B\"\u0005\b\u0081\u0001\u0010DR&\u0010\u0086\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010@\u001a\u0005\b\u0084\u0001\u0010B\"\u0005\b\u0085\u0001\u0010DR&\u0010\u008a\u0001\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010H\u001a\u0005\b\u0088\u0001\u0010N\"\u0005\b\u0089\u0001\u0010JR&\u0010\u008e\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010H\u001a\u0005\b\u008c\u0001\u0010N\"\u0005\b\u008d\u0001\u0010JR!\u0010\u0094\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/seekbar/ReplaySeekBar;", "Landroid/view/ViewGroup;", "", "touchAble", "", "setTouchAble", "", "height", "setProgressHeight", "getProgressHeight", "", "getThumbRadius", "setProgressSlideHeight", "progressColor", "setProgressColor", "progressEndColor", "setProgressEndColor", "secondaryProgressColor", "setSecondaryProgressColor", "backgroundProgressColor", "setBackgroundProgressColor", "thumbColor", "setThumbColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setThumbBitmap", "setThumbBitmapWithoutResizing", "circleMarkHeightAppend", "setCircleMarkHeightAppend", "thumbRadiusOnDragging", "setThumbRadiusOnDragging", "thumbStrokeColorOnDragging", "setThumbStrokeColorOnDragging", "needDraw", "setNeedDrawMarkPassedStyle", "setNeedDrawProgress", "drawWave", "setNeedDrawWave", "diff", "setSlideStyleDiff", "left", "setSlideLeft", "right", "setSlideRight", "forceLeft", "setCustomLeft", "forceRight", "setCustomRight", "forceCustomCoordinate", "setUseCustomCoordinate", "getProgress", "getSecondaryProgress", "secondaryProgress", "setSecondaryProgress", "Lcom/bytedance/android/livesdk/chatroom/replay/player/seekbar/ReplaySeekBar$b;", "onVSSeekBarChangeListener", "setOnSSSeekBarChangeListener", "thumbShow", "setThumbShow", "", "progressWebpUrl", "setProgressWebpUrl", "setNeedDrawDebugClickAbleMarkScope", "d", "I", "getMProgressHeight", "()I", "setMProgressHeight", "(I)V", "mProgressHeight", "value", ce.f26396k, FaceService.girlLabel, "setMThumbRadius", "(F)V", "mThumbRadius", "B", "getMProgressLength", "()F", "setMProgressLength", "mProgressLength", "D", "getMarkPassJudgeType", "setMarkPassJudgeType", "markPassJudgeType", ExifInterface.LONGITUDE_EAST, "Z", "isDraggingInMarkScope", "()Z", "setDraggingInMarkScope", "(Z)V", FaceService.neutralLabel, "getMLeft", "setMLeft", "mLeft", "getMRight", "setMRight", "mRight", "Q", "getMCurrentLeft", "setMCurrentLeft", "mCurrentLeft", "R", "getMCurrentRight", "setMCurrentRight", "mCurrentRight", ExifInterface.LATITUDE_SOUTH, "getMCurrentProgressLength", "setMCurrentProgressLength", "mCurrentProgressLength", ExifInterface.LONGITUDE_WEST, "getMIsFullScreen", "setMIsFullScreen", "mIsFullScreen", "k0", "getMHideMarks", "setMHideMarks", "mHideMarks", "", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;", DiagnoseResult.DIAGNOSE_LEVEL_P0, "Ljava/util/List;", "getMMarkList", "()Ljava/util/List;", "setMMarkList", "(Ljava/util/List;)V", "mMarkList", "V0", "getMMarkClickBufferDp", "setMMarkClickBufferDp", "mMarkClickBufferDp", "b1", "getMMarkClickBufferInt", "setMMarkClickBufferInt", "mMarkClickBufferInt", "h1", "getMStrokeWidth", "setMStrokeWidth", "mStrokeWidth", "T1", "getMImageMarkSizePx", "setMImageMarkSizePx", "mImageMarkSizePx", "Lio/reactivex/disposables/CompositeDisposable;", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lkotlin/Lazy;", "getMCd", "()Lio/reactivex/disposables/CompositeDisposable;", "mCd", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplaySeekBar extends ViewGroup {
    public float A;
    public float B;
    public boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public com.bytedance.android.livesdk.chatroom.vsplayer.model.e G;
    public boolean G1;
    public float H;
    public float H0;
    public boolean H1;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f109653J;
    public float K;
    public float L;
    public float L0;
    public VelocityTracker L1;
    public float M;
    public String M1;
    public boolean N;
    public float O;
    public float P;
    public List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> P0;
    public HSImageView P1;
    public float Q;
    public final Map<String, HSImageView> Q1;
    public float R;
    public float S;
    public final List<Float> S1;
    public boolean T;
    public float T1;
    public float U;
    public final Paint V;
    public int V0;
    public final Lazy V1;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f109654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f109655b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f109656b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public float f109657b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f109658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f109659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f109660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f109661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f109662g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public b f109663g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f109664h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public float f109665h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f109666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f109667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f109668k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f109669k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f109670k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f109671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f109672m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f109673n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f109674o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f109675p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f109676p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public AnimatorSet f109677p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f109678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f109679r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f109680s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f109681t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f109682u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f109683v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final int f109684v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bitmap f109685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f109686x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f109687x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f109688y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f109689y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f109690z;

    public static final class a {
    }

    public interface b {
        void O3();

        void a(ReplaySeekBar r100);

        void b(ReplaySeekBar r100, boolean r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102);

        void c(ReplaySeekBar r100);

        void d(ReplaySeekBar r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r101);

        void e(ReplaySeekBar r100, float r101, boolean r102, float r103);

        void f(ReplaySeekBar r100);
    }

    public static final class c implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekBar f109691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f109692b;

        public c(ReplaySeekBar r100, float r101) {
            this.f109691a = r100;
            this.f109692b = r101;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "mThumbRadius set from [" + this.f109691a.f109668k + "] to [" + this.f109692b + ']';
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekBar f109693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f109694b;

        public d(ReplaySeekBar r100, List r101) {
            this.f109693a = r100;
            this.f109694b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ReplaySeekBar r101 = this.f109693a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.L0 = ((Float) r102).floatValue();
            this.f109693a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekBar f109695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f109696b;

        public e(ReplaySeekBar r100, List r101) {
            this.f109695a = r100;
            this.f109696b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ReplaySeekBar r101 = this.f109695a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            ReplaySeekBar.a(r101, ((Float) r102).floatValue());
            this.f109695a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekBar f109697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f109698b;

        public f(ReplaySeekBar r100, List r101) {
            this.f109697a = r100;
            this.f109698b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ReplaySeekBar r101 = this.f109697a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f109671l = ((Float) r102).floatValue();
            this.f109697a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekBar f109699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f109700b;

        public g(ReplaySeekBar r100, List r101) {
            this.f109699a = r100;
            this.f109700b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ReplaySeekBar r101 = this.f109699a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setMStrokeWidth(((Float) r102).floatValue());
            this.f109699a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public ReplaySeekBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplaySeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final CompositeDisposable getMCd() {
        return (CompositeDisposable) this.V1.getValue();
    }

    public final void j() {
        this.f109688y = true;
        int r100 = this.f109660e;
        this.f109665h1 = r100;
        p(this.f109676p0, this.H0, this.f109674o, this.f109672m, this.f109675p, this.f109673n, this.f109659d, r100);
    }

    public final void k() {
        this.f109688y = false;
        int r100 = this.f109659d;
        this.f109665h1 = r100;
        p(this.H0, this.f109676p0, this.f109672m, this.f109674o, this.f109673n, this.f109675p, this.f109660e, r100);
    }

    public final void b() {
        if (this.M1 != null) goto L5;
        return;
    L5:
        HSImageView r100 = new HSImageView(getContext());
        r100.setLayoutParams(new ViewGroup.LayoutParams(s1.f(48.0f), s1.f(48.0f)));
        r100.setVisibility(8);
        String r101 = this.M1;
        r100.setController(Fresco.newDraweeControllerBuilder().setUri(r101).setAutoPlayAnimations(true).build());
        Unit r102 = Unit.INSTANCE;
        this.P1 = r100;
        removeView(r100);
        addView(this.P1);
    }

    public final void g() {
        HSImageView r100 = this.P1;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.P1;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
        return;
    L11:
        return;
    L5:
        if (r100.getVisibility() != 8) goto L7;
    }

    public final int getProgress() {
        return MathKt.roundToInt(this.f109654a);
    }

    public final int getSecondaryProgress() {
        return MathKt.roundToInt(this.f109655b);
    }

    public final void o() {
        HSImageView r100 = this.P1;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.P1;
        if (r101 == null) goto L11;
        r101.setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
    }

    public final float getMCurrentLeft() {
        return this.Q;
    }

    public final float getMCurrentProgressLength() {
        return this.S;
    }

    public final float getMCurrentRight() {
        return this.R;
    }

    public final boolean getMHideMarks() {
        return this.f109669k0;
    }

    public final float getMImageMarkSizePx() {
        return this.T1;
    }

    public final boolean getMIsFullScreen() {
        return this.W;
    }

    public final float getMLeft() {
        return this.H;
    }

    public final int getMMarkClickBufferDp() {
        return this.V0;
    }

    public final int getMMarkClickBufferInt() {
        return this.f109656b1;
    }

    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> getMMarkList() {
        return this.P0;
    }

    public final int getMProgressHeight() {
        return this.f109659d;
    }

    public final float getMProgressLength() {
        return this.B;
    }

    public final float getMRight() {
        return this.I;
    }

    public final float getMStrokeWidth() {
        return this.f109665h1;
    }

    public final int getMarkPassJudgeType() {
        return this.D;
    }

    public final int getProgressHeight() {
        return this.f109659d;
    }

    public final float getThumbRadius() {
        return this.f109668k;
    }

    public static void q(ReplaySeekBar r100) {
        boolean r101 = r100.f109688y;
        if (r101 == false) goto L10;
        if (r100.T == false) goto L10;
        if (r100.f109653J == Float.MAX_VALUE) goto L10;
        float r102 = r100.L;
    L13:
        r100.Q = r102;
        if (r101 == false) goto L21;
        if (r100.T == false) goto L21;
        if (r100.K == Float.MAX_VALUE) goto L21;
        float r103 = r100.M;
    L24:
        r100.R = r103;
        r100.S = r103 - r102;
        return;
    L21:
        if (r100.N == false) goto L23;
        r103 = r100.P;
        goto L24
    L23:
        r103 = r100.I;
    L10:
        if (r100.N == false) goto L12;
        r102 = r100.O;
        goto L13
    L12:
        r102 = r100.H;
        goto L13
    }

    private final void setMThumbRadius(float r100) {
        ALogger.v("ReplaySeekBar[" + hashCode() + ']', new c(this, r100));
        this.f109668k = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(r100);
    }

    public final com.bytedance.android.livesdk.chatroom.vsplayer.model.e h(MotionEvent r100) {
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r101 = this.P0;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r104).f118433q == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = CollectionsKt.reversed(r102).iterator();
    L10:
        if (r105.hasNext() == false) goto L30;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r106 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r105.next();
        int r107 = r106.f118429m;
        if (r107 != 2) goto L14;
        float r108 = r106.f118417a;
        float r109 = this.f109656b1 + r108;
        float r110 = r100.getX();
        if (r110 < r108) goto L10;
        if (r110 > r109) goto L10;
        return r106;
    L14:
        if (r107 != 3) goto L15;
        float r111 = r106.f118417a;
        float r112 = this.f109656b1 + r111;
        float r113 = r100.getX();
        if (r113 < r111) goto L10;
        if (r113 > r112) goto L10;
        return r106;
    L15:
        float r114 = r106.f118417a;
        float r115 = r106.f118418b;
        float r116 = r100.getX();
        if (r116 < r114) goto L10;
        if (r116 > r115) goto L10;
        return r106;
    L30:
        return null;
    }

    public final boolean i(MotionEvent r100) {
        float r101 = r100.getX();
        float r102 = r100.getY();
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        if (r101 >= getPaddingLeft()) goto L7;
        return false;
    L7:
        if (r101 <= (getMeasuredWidth() - getPaddingRight())) goto L9;
        return false;
    L9:
        if (r102 >= 0) goto L11;
        return false;
    L11:
        if (r102 > getMeasuredHeight()) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        this.V.setAlpha(255);
        float r100 = 2;
        float r101 = (getPaddingTop() / r100) + (getMeasuredHeight() / r100);
        if (this.f109689y1 == false) goto L7;
        float r102 = this.f109665h1 / r100;
        float r103 = this.f109668k;
        if (r102 <= r103) goto L7;
        float r104 = r102 - r103;
    L8:
        q(this);
        float r105 = this.S;
        float r106 = (r105 / this.f109684v1) * this.f109654a;
        float r107 = this.Q;
        this.A = r106 + r107;
        float r108 = this.f109655b;
        if (r108 == 0.0f) goto L11;
        float r111 = ((r105 / 100) * r108) + r107;
    L12:
        this.V.setStrokeWidth(this.f109665h1);
        this.V.setColor(this.f109666i);
        r110.drawLine(this.Q + r104, r101, this.R - r104, r101, this.V);
        if (this.f109680s == false) goto L15;
        d(r110, this.Q + r104, this.R - r104, r101, this.f109665h1);
    L15:
        this.V.setStrokeWidth(this.f109665h1);
        this.V.setColor(this.f109664h);
        r110.drawLine(this.Q + r104, r101, r111, r101, this.V);
        if (this.f109680s == true) goto L18;
    L20:
        c(r110, true);
        if (this.f109682u == false) goto L51;
        int r109 = this.f109662g;
        if (r109 != 0) goto L25;
    L41:
        this.V.setStrokeWidth(this.f109665h1);
        this.V.setColor(this.f109661f);
        r110.drawLine(this.Q + r104, r101, this.A, r101, this.V);
        if (this.f109680s == false) goto L51;
        if (this.f109654a <= 0) goto L51;
        if (this.f109688y == true) goto L48;
    L50:
        d(r110, this.Q + r104, this.A, r101, this.f109665h1);
        goto L51
    L48:
        if (this.f109687x1 == false) goto L50;
        e(r110, this.Q + r104, r101, this.f109665h1);
        goto L51
    L25:
        if (r109 == this.f109661f) goto L41;
        this.V.setStrokeWidth(this.f109665h1);
        float r112 = this.A;
        float r113 = this.Q;
        float r114 = r112 - r113;
        float r115 = r113 + r104;
    L29:
        if (r115 > this.A) goto L31;
        this.V.setColor(f((r115 - this.Q) / r114, this.f109661f, this.f109662g));
        float r116 = r115 + 5;
        r110.drawLine(r115, r101, r116, r101, this.V);
        r115 = r116;
        goto L29
    L31:
        this.V.setColor(this.f109661f);
        if (this.f109680s == false) goto L51;
        if (this.f109654a <= 0) goto L51;
        if (this.f109688y == true) goto L38;
    L40:
        d(r110, this.Q + r104, this.A, r101, this.f109665h1);
        goto L51
    L38:
        if (this.f109687x1 == false) goto L40;
        e(r110, this.Q + r104, r101, this.f109665h1);
    L51:
        c(r110, false);
        if (this.H1 == false) goto L81;
        this.V.setColor(-16777216);
        Bitmap r117 = this.f109685w;
        if (r117 != null) goto L56;
    L62:
        HSImageView r118 = this.P1;
        if (r118 == null) goto L65;
        int r119 = s1.f(24.0f);
        float r120 = this.A;
        float r121 = r119;
        r118.layout((int) (r120 - r121), (int) (r101 - r121), (int) (r120 + r121), (int) (r121 + r101));
    L65:
        Bitmap r122 = this.f109685w;
        if (r122 != null) goto L68;
    L69:
        HSImageView r123 = this.P1;
        if (r123 != null) goto L72;
    L73:
        this.V.setStrokeWidth(0.0f);
        this.V.setColor(this.f109679r);
        if ((this.f109668k * r100) == this.f109671l) goto L76;
    L78:
        this.V.setColor(this.f109667j);
        float r124 = this.A;
        float r125 = this.f109668k;
        float r126 = this.f109671l / r100;
        RectF r127 = new RectF(new Rect((int) (r124 - r125), (int) (r101 - r126), (int) (r124 + r125), (int) (r101 + r126)));
        float r128 = this.f109668k;
        r110.drawRoundRect(r127, r128, r128, this.V);
        return;
    L76:
        if (this.f109683v == false) goto L78;
        r110.drawCircle(this.A, r101, this.L0, this.V);
        goto L78
    L72:
        if (r123.getVisibility() != 0) goto L73;
        return;
    L68:
        if (r122.isRecycled() == true) goto L69;
        return;
    L56:
        if (r117.isRecycled() == true) goto L62;
        HSImageView r129 = this.P1;
        if (r129 != null) goto L60;
    L61:
        int r130 = s1.f(11.0f);
        Bitmap r131 = this.f109685w;
        Intrinsics.checkNotNull(r131);
        float r132 = r130;
        r110.drawBitmap(r131, this.A - r132, r101 - r132, this.V);
        goto L62
    L60:
        if (r129.getVisibility() == 0) goto L62;
    L81:
        return;
    L18:
        if (this.f109654a <= 0) goto L20;
        d(r110, this.Q + r104, r111, r101, this.f109665h1);
        goto L20
    L11:
        r111 = r107;
    L7:
        r104 = 0.0f;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f109670k1 == false) goto L217;
        b r100 = this.f109663g1;
        if (r100 == null) goto L7;
        r100.O3();
    L7:
        VelocityTracker r101 = this.L1;
        if (r101 != null) goto L10;
        this.L1 = VelocityTracker.obtain();
    L11:
        VelocityTracker r102 = this.L1;
        if (r102 == null) goto L14;
        r102.addMovement(r110);
    L14:
        int r103 = r110.getActionMasked();
        int r104 = 1;
        float r105 = 0.0f;
        if (r103 == 0) goto L163;
        if (r103 == 1) goto L144;
        if (r103 == 2) goto L43;
        if (r103 != 3) goto L209;
        VelocityTracker r106 = this.L1;
        if (r106 == null) goto L25;
        r106.recycle();
    L25:
        this.L1 = null;
        q(this);
        float r107 = r110.getX() + this.f109657b2;
        this.A = r107;
        float r108 = this.Q;
        if (r107 >= r108) goto L28;
        this.A = r108;
    L28:
        float r109 = this.A;
        float r111 = this.R;
        if (r109 <= r111) goto L31;
        this.A = r111;
    L31:
        float r112 = this.S;
        if (r112 == 0.0f) goto L34;
        this.f109654a = ((this.A - r108) * this.f109684v1) / r112;
    L34:
        b r113 = this.f109663g1;
        if (r113 != null) goto L37;
    L39:
        g();
        this.C = false;
        invalidate();
        if (this.G1 == false) goto L209;
        k();
        goto L209
    L37:
        if (this.C == false) goto L39;
        r113.a(this);
    L209:
        if (this.C == false) goto L211;
    L214:
        return true;
    L211:
        if (super.onTouchEvent(r110) == true) goto L214;
        return false;
    L43:
        if (this.C == false) goto L136;
        o();
        q(this);
        float r114 = r110.getX() + this.f109657b2;
        this.A = r114;
        if (this.f109688y == false) goto L47;
        float r115 = this.Q;
        float r116 = this.H;
        this.A = r115 + (((r114 - r116) / (this.I - r116)) * this.S);
    L47:
        float r117 = this.A;
        float r118 = this.Q;
        if (r117 >= r118) goto L50;
        this.A = r118;
    L50:
        float r119 = this.A;
        float r120 = this.R;
        if (r119 <= r120) goto L53;
        this.A = r120;
    L53:
        float r121 = this.S;
        if (r121 == 0.0f) goto L56;
        this.f109654a = ((this.A - r118) * this.f109684v1) / r121;
    L56:
        invalidate();
        if (this.f109663g1 == null) goto L209;
        VelocityTracker r122 = this.L1;
        if (r122 == null) goto L61;
        r122.computeCurrentVelocity(1000);
    L61:
        VelocityTracker r123 = this.L1;
        if (r123 == null) goto L64;
        r105 = r123.getXVelocity();
    L64:
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r124 = this.P0;
        ArrayList r125 = new ArrayList();
        Iterator<T> r126 = r124.iterator();
    L66:
        if (r126.hasNext() == false) goto L75;
        Object r127 = r126.next();
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r128 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r127;
        if (r128.f118430n == true) goto L70;
    L72:
        boolean r129 = false;
    L73:
        if (r129 == false) goto L66;
        r125.add(r127);
        goto L66
    L70:
        if (r128.f118420d == false) goto L72;
        r129 = true;
        goto L73
    L75:
        Iterator r130 = CollectionsKt.reversed(r125).iterator();
    L77:
        if (r130.hasNext() == false) goto L99;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r131 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r130.next();
        int r132 = this.D;
        if (r132 != r104) goto L89;
        long r133 = (long) ((r131.f118422f * this.f109654a) / 100.0f);
        long r134 = r131.f118423g;
        long r135 = r131.f118424h;
        long r136 = 20000;
        if (Math.abs(r134 - r135) >= r136) goto L84;
        r135 = r135 + r136;
    L84:
        if (r134 > r133) goto L98;
        if (r135 < r133) goto L98;
    L100:
        if (r131 != null) goto L102;
    L107:
        if (r131 == null) goto L123;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r137 = this.G;
        if (r137 == null) goto L111;
        int r138 = r137.hashCode();
    L113:
        if (r138 == r131.hashCode()) goto L123;
        if (this.E == false) goto L123;
        b r139 = this.f109663g1;
        if (r139 == null) goto L119;
        r139.b(this, false, this.G);
    L119:
        b r140 = this.f109663g1;
        if (r140 == null) goto L122;
        r140.b(this, true, r131);
    L122:
        this.G = r131;
    L130:
        b r141 = this.f109663g1;
        if (r141 == null) goto L133;
        r141.e(this, this.f109654a, true, r105);
    L133:
        b r142 = this.f109663g1;
        if (r142 == null) goto L209;
        r142.f(this);
        goto L209
    L111:
        r138 = 0;
    L123:
        if (r131 != null) goto L130;
        if (this.E == false) goto L130;
        this.E = false;
        b r143 = this.f109663g1;
        if (r143 == null) goto L129;
        r143.b(this, false, r131);
    L129:
        this.G = null;
        goto L130
    L102:
        if (this.E == true) goto L107;
        this.E = true;
        b r144 = this.f109663g1;
        if (r144 == null) goto L106;
        r144.b(this, true, r131);
    L106:
        this.G = r131;
    L98:
        r104 = 1;
        goto L77
    L89:
        if (r132 != 2) goto L98;
        float r145 = r131.f118417a;
        float r146 = r131.f118418b;
        float r147 = Math.abs(r145 - r146);
        int r148 = this.f109656b1;
        if (r147 >= r148) goto L93;
        float r149 = r148 / 2;
        r145 = r145 - r149;
        r146 = r146 + r149;
    L93:
        float r150 = this.A;
        if (r150 < r145) goto L98;
        if (r150 > r146) goto L98;
    L99:
        r131 = null;
        goto L100
    L136:
        b r151 = this.f109663g1;
        if (r151 == null) goto L139;
        r151.c(this);
    L139:
        b r152 = this.f109663g1;
        if (r152 == null) goto L142;
        r152.f(this);
    L142:
        o();
        goto L209
    L144:
        if (i(r110) == true) goto L146;
    L153:
        VelocityTracker r153 = this.L1;
        if (r153 == null) goto L156;
        r153.recycle();
    L156:
        this.L1 = null;
        this.C = false;
        b r154 = this.f109663g1;
        if (r154 == null) goto L159;
        r154.a(this);
    L159:
        g();
        invalidate();
        if (this.G1 == false) goto L209;
        k();
        goto L209
    L146:
        if (this.F == false) goto L153;
        this.F = false;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r155 = h(r110);
        if (r155 == null) goto L153;
        b r156 = this.f109663g1;
        if (r156 == null) goto L153;
        r156.d(this, r155);
        return true;
    L163:
        if (isEnabled() == true) goto L165;
    L170:
        boolean r157 = false;
    L171:
        this.C = r157;
        if (r157 == false) goto L182;
        b r158 = this.f109663g1;
        if (r158 == null) goto L177;
        r158.c(this);
    L177:
        if (this.G1 == false) goto L180;
        this.f109665h1 = this.f109660e;
        this.f109688y = true;
    L180:
        o();
        invalidate();
    L205:
        this.f109657b2 = this.A - r110.getX();
        if (this.G1 == false) goto L209;
        j();
        goto L209
    L182:
        if (i(r110) == false) goto L205;
        if (h(r110) == null) goto L187;
        this.F = true;
        return true;
    L187:
        b r159 = this.f109663g1;
        if (r159 == null) goto L190;
        r159.c(this);
    L190:
        this.A = r110.getX();
        q(this);
        float r160 = this.A;
        float r161 = this.Q;
        if (r160 >= r161) goto L193;
        this.A = r161;
    L193:
        float r162 = this.A;
        float r163 = this.R;
        if (r162 <= r163) goto L196;
        this.A = r163;
    L196:
        float r164 = this.S;
        if (r164 == 0.0f) goto L199;
        this.f109654a = ((this.A - r161) * this.f109684v1) / r164;
    L199:
        b r165 = this.f109663g1;
        if (r165 == null) goto L202;
        boolean r166 = true;
        r165.e(this, this.f109654a, true, 0.0f);
    L203:
        invalidate();
        this.C = r166;
        goto L205
    L202:
        r166 = true;
        goto L203
    L165:
        if (this.f109654a == 0.0f) goto L170;
        q(this);
        if ((Math.pow(r110.getX() - (((this.S / this.f109684v1) * this.f109654a) + this.Q), 2.0d) + Math.pow(r110.getY() - (getMeasuredHeight() / 2), 2.0d)) > (Math.pow(getMeasuredHeight() / 2, 2.0d) + ((double) UtilityKotlinExtentionsKt.b(3)))) goto L170;
        r157 = true;
        goto L171
    L10:
        r101.clear();
        goto L11
    L217:
        return super.onTouchEvent(r110);
    }

    public final void setBackgroundProgressColor(int r100) {
        this.f109666i = r100;
        invalidate();
    }

    public final void setCircleMarkHeightAppend(float r100) {
        this.f109658c = r100;
    }

    public final void setCustomLeft(float r100) {
        this.O = r100 + this.U;
    }

    public final void setCustomRight(float r100) {
        this.P = r100 - this.U;
    }

    public final void setDraggingInMarkScope(boolean r100) {
        this.E = r100;
    }

    public final void setMCurrentLeft(float r100) {
        this.Q = r100;
    }

    public final void setMCurrentProgressLength(float r100) {
        this.S = r100;
    }

    public final void setMCurrentRight(float r100) {
        this.R = r100;
    }

    public final void setMHideMarks(boolean r100) {
        this.f109669k0 = r100;
        postInvalidate();
    }

    public final void setMImageMarkSizePx(float r100) {
        this.T1 = r100;
    }

    public final void setMIsFullScreen(boolean r100) {
        this.W = r100;
        postInvalidate();
    }

    public final void setMLeft(float r100) {
        this.H = r100;
    }

    public final void setMMarkClickBufferDp(int r100) {
        this.V0 = r100;
    }

    public final void setMMarkClickBufferInt(int r100) {
        this.f109656b1 = r100;
    }

    public final void setMMarkList(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r101 = CollectionsKt.sorted(r100);
        this.P0 = r101;
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r103).f118429m != 3) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        if (r103 == null) goto L14;
        RxUtilKt.c(Observable.create(new j(this, r101)).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(k.f109747a, l.f109748a), getMCd());
    L14:
        invalidate();
        return;
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    public final void setMProgressHeight(int r100) {
        this.f109659d = r100;
    }

    public final void setMProgressLength(float r100) {
        this.B = r100;
    }

    public final void setMRight(float r100) {
        this.I = r100;
    }

    public final void setMStrokeWidth(float r100) {
        this.f109665h1 = r100;
    }

    public final void setMarkPassJudgeType(int r100) {
        this.D = r100;
    }

    public final void setNeedDrawDebugClickAbleMarkScope(boolean r100) {
        this.f109686x = r100;
    }

    public final void setNeedDrawMarkPassedStyle(boolean r100) {
        this.f109681t = r100;
        invalidate();
    }

    public final void setNeedDrawProgress(boolean r100) {
        this.f109682u = r100;
        invalidate();
    }

    public final void setNeedDrawWave(boolean r100) {
        this.f109683v = r100;
    }

    public final void setOnSSSeekBarChangeListener(b r100) {
        this.f109663g1 = r100;
    }

    public final void setProgressColor(int r100) {
        this.f109661f = r100;
        invalidate();
    }

    public final void setProgressEndColor(int r100) {
        this.f109662g = r100;
        invalidate();
    }

    public final void setProgressHeight(int r100) {
        this.f109659d = r100;
        this.f109665h1 = r100;
        invalidate();
    }

    public final void setProgressSlideHeight(int r100) {
        this.f109660e = r100;
    }

    public final void setProgressWebpUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "progressWebpUrl");
        this.M1 = r100;
        if (getChildCount() >= 1) goto L6;
        b();
        return;
    }

    public final void setSecondaryProgress(float r100) {
        this.f109655b = r100;
        invalidate();
    }

    public final void setSecondaryProgressColor(int r100) {
        this.f109664h = r100;
        invalidate();
    }

    public final void setSlideLeft(float r100) {
        this.f109653J = r100;
        if (this.f109690z == false) goto L5;
        float r101 = this.f109678q;
    L6:
        this.U = r101;
        this.L = r100 + r101;
        return;
    L5:
        r101 = this.f109668k;
        goto L6
    }

    public final void setSlideRight(float r100) {
        this.K = r100;
        if (this.f109690z == false) goto L5;
        float r101 = this.f109678q;
    L6:
        this.U = r101;
        this.M = r100 - r101;
        return;
    L5:
        r101 = this.f109668k;
        goto L6
    }

    public final void setSlideStyleDiff(boolean r100) {
        this.T = r100;
    }

    public final void setThumbBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        this.f109685w = null;
    L4:
        if (r100 == null) goto L6;
        int r101 = s1.f(22.0f);
        float r102 = r101 / r100.getWidth();
        Matrix r103 = new Matrix();
        r103.postScale(r102, r102);
        this.f109685w = Bitmap.createBitmap(r101, r101, Bitmap.Config.ARGB_4444);
        Bitmap r104 = this.f109685w;
        Intrinsics.checkNotNull(r104);
        Canvas r105 = new Canvas(r104);
        Paint r106 = new Paint();
        r106.setColor(-16777216);
        r105.drawBitmap(r100, r103, r106);
    L6:
        invalidate();
    }

    public final void setThumbBitmapWithoutResizing(Bitmap r100) {
        this.f109685w = r100;
        invalidate();
    }

    public final void setThumbColor(int r100) {
        this.f109667j = r100;
        invalidate();
    }

    public final void setThumbRadiusOnDragging(float r100) {
        this.f109678q = r100;
        float r101 = this.f109668k;
        this.f109676p0 = r101;
        this.H0 = r100;
        this.L0 = r101;
        requestLayout();
    }

    public final void setThumbShow(boolean r100) {
        this.H1 = r100;
    }

    public final void setThumbStrokeColorOnDragging(int r100) {
        this.f109679r = r100;
        invalidate();
    }

    public final void setTouchAble(boolean r100) {
        this.f109670k1 = r100;
    }

    public final void setUseCustomCoordinate(boolean r100) {
        this.N = r100;
    }

    public static final /* synthetic */ void a(ReplaySeekBar r100, float r101) {
        r100.setMThumbRadius(r101);
    }

    public static void n(ReplaySeekBar r100, float r101) {
        r100.setMThumbRadius(r101);
        r100.f109671l = -1.0f;
        if ((-1.0f) >= 0) goto L5;
        r100.f109671l = r100.f109668k * 2;
    L5:
        r100.f109675p = r100.f109671l;
        float r102 = r100.f109668k;
        r100.f109674o = r102;
        r100.f109676p0 = r102;
        r100.H0 = r100.f109678q;
        r100.L0 = r102;
        r100.invalidate();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.bytedance.android.livesdk.chatroom.replay.player.seekbar.ReplaySeekBar$drawImageCustomMarks$1] */
    public final void c(Canvas r110, boolean r210) {
        boolean r100 = false;
        if (this.P0.isEmpty() == false) goto L5;
    L155:
        Iterator<T> r101 = this.P0.iterator();
    L157:
        if (r101.hasNext() == false) goto L159;
        ((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r101.next()).f118420d = false;
        goto L157
    L159:
        return;
    L5:
        if (this.f109669k0 == true) goto L155;
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r102 = this.P0;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L8:
        int r105 = 1;
        if (r104.hasNext() == false) goto L16;
        Object r106 = r104.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r106).f118431o == r210) goto L14;
        r105 = 0;
    L14:
        if (r105 == 0) goto L8;
        r103.add(r106);
        goto L8
    L16:
        int r107 = 2;
        float r108 = (getPaddingTop() / 2) + (getMeasuredHeight() / 2);
        Iterator r111 = r103.iterator();
        int r109 = 0;
    L18:
        if (r111.hasNext() == false) goto L154;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r112 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r111.next();
        q(this);
        this.V.setColor(r112.f118426j);
        long r113 = r112.f118422f;
        if (r113 == 0) goto L152;
        float r114 = this.S;
        if (r114 == 0.0f) goto L152;
        long r115 = r112.f118423g;
        long r116 = r112.f118425i;
        float r117 = (((r115 - r116) / (r113 - r116)) * r114) + getPaddingLeft();
        float r118 = this.Q;
        float r119 = r117 + r118;
        if (r119 > this.R) goto L144;
        long r120 = r112.f118423g;
        long r121 = r112.f118425i;
        if (r120 < r121) goto L144;
        r112.f118417a = r119 - (this.f109656b1 / r107);
        if (r119 >= r118) goto L31;
        r112.f118417a = r118;
        r119 = r118;
    L31:
        long r122 = r112.f118424h;
        if (r120 == r122) goto L34;
        float r123 = ((((r122 - r121) / (r112.f118422f - r121)) * this.S) + getPaddingLeft()) + this.Q;
    L39:
        r112.f118418b = (this.f109656b1 / r107) + r123;
        float r124 = this.R;
        if (r123 <= r124) goto L42;
        r112.f118418b = r124;
        float r125 = r124;
    L44:
        if (r119 >= this.A) goto L46;
        boolean r126 = true;
    L47:
        r112.f118419c = r126;
        int r127 = r112.f118429m;
        if (r127 != 0) goto L50;
        this.V.setStrokeWidth(this.f109665h1);
        r110.drawLine(r119, r108, r125, r108, this.V);
    L52:
        float r128 = r108;
        int r129 = r109;
    L53:
        r112 = r112;
    L143:
        r112.f118420d = true;
    L153:
        r109 = r129 + 1;
        r108 = r128;
        r100 = false;
        r105 = 1;
        goto L18
    L50:
        if (r127 != r105) goto L55;
        this.V.setStrokeWidth(this.f109665h1);
        d(r110, r119, r125, r108, this.f109659d);
        goto L52
    L55:
        r112 = r112;
        final int r130 = r109;
        float r131 = r108;
        if (r127 == r107) goto L113;
        if (r127 == 3) goto L59;
    L61:
        if (r127 == 3) goto L63;
    L108:
        float r132 = r119;
        r128 = r131;
        r129 = r130;
        r110.drawLine(r119, r131, r125, r128, this.V);
        if (this.f109680s == false) goto L111;
        r112 = r112;
        d(r110, r132, r125, r128, this.f109659d);
        goto L53
    L111:
        r112 = r112;
        goto L53
    L63:
        if (this.f109688y == false) goto L108;
        ?? r133 = new ReplaySeekBar$drawImageCustomMarks$1(this, r130);
        if (r112.f118429m == 3) goto L67;
    L107:
        r128 = r131;
        r129 = r130;
        goto L53
    L67:
        if (r112.f118427k == null) goto L107;
        if (this.Q1.containsKey(r112.f118421e) == false) goto L107;
        HSImageView r134 = (HSImageView) ((LinkedHashMap) this.Q1).get(r112.f118421e);
        if (r134 == null) goto L75;
        ViewParent r135 = r134.getParent();
    L76:
        if (r135 != null) goto L78;
    L84:
        if (r134 == null) goto L107;
        if (r134.getParent() != null) goto L88;
        setClipChildren(r100);
        setClipToPadding(r100);
        addView(r134);
    L88:
        UtilityKotlinExtentionsKt.j(r134);
        Ref.FloatRef r136 = new Ref.FloatRef();
        r136.element = r119;
        IntProgression r137 = RangesKt.step(CollectionsKt.getIndices(this.S1), r107);     // Catch: IndexOutOfBoundsException -> L102
        int r138 = r137.getFirst();     // Catch: IndexOutOfBoundsException -> L102
        int r139 = r137.getLast();     // Catch: IndexOutOfBoundsException -> L102
        int r140 = r137.getStep();     // Catch: IndexOutOfBoundsException -> L102
        if (r140 < 0) goto L93;
        if (r138 <= r139) goto L94;
    L103:
        Ref.FloatRef r141 = new Ref.FloatRef();
        float r142 = r136.element;
        float r143 = this.T1;
        float r144 = r142 + r143;
        r141.element = r144;
        r107 = 2;
        float r145 = 2;
        float r146 = r143 / r145;
        r134.layout((int) r136.element, (int) (r131 - r146), (int) r144, (int) (r146 + r131));
        r133.invoke(r136.element, r141.element);
        float r147 = this.f109656b1;
        float r148 = this.T1;
        if (r147 <= r148) goto L106;
        float r149 = (r147 - r148) / r145;
        r112.f118417a = r136.element - r149;
        r112.f118418b = r141.element + r149;
    L106:
        ALogger.v("ReplaySeekBar", new n(r136, r141, r112));
    L94:
        float r150 = ((Number) ListProtector.get(this.S1, r138)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        int r151 = r138 + 1;     // Catch: IndexOutOfBoundsException -> L102
        float r152 = ((Number) ListProtector.get(this.S1, r151)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        float r153 = r136.element;     // Catch: IndexOutOfBoundsException -> L102
        if (r153 >= r150) goto L97;
    L100:
        if (r138 == r139) goto L103;
        r138 = r138 + r140;
        goto L94
    L97:
        if (r153 > r152) goto L100;
        r136.element = ((Number) ListProtector.get(this.S1, r151)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        ALogger.v("ReplaySeekBar", new m(r136, r119, r112));     // Catch: IndexOutOfBoundsException -> L102
        goto L103
    L93:
        if (r138 < r139) goto L103;
    L102:
        ALogger.e("ReplaySeekBar", "imageMarksRange error,skip left range detect");
        goto L103
    L78:
        if (Intrinsics.areEqual(r134.getParent(), this) == false) goto L84;
        int r154 = r134.getLeft() - 5;
        int r155 = r134.getLeft() + 5;
        int r156 = (int) r119;
        if (r154 > r156) goto L84;
        if (r155 < r156) goto L84;
        r133.invoke(r134.getLeft() * 1.0f, r134.getRight() * 1.0f);
        UtilityKotlinExtentionsKt.j(r134);
        goto L107
    L75:
        r135 = null;
        goto L76
    L59:
        if (this.f109688y == true) goto L61;
    L113:
        float r157 = r119;
        r128 = r131;
        r129 = r130;
        this.V.setStrokeWidth(1.0f);
        this.V.setColor(r112.f118426j);
        if (this.W == false) goto L123;
        float r158 = this.f109658c;
        if (r158 == 0.0f) goto L119;
        int r159 = this.f109659d + s1.f(r158);
    L121:
        float r160 = r159 / 2.0f;
    L126:
        if (this.f109681t == true) goto L128;
    L130:
        r110.drawCircle(r157, r128, r160, this.V);
        if (v.a() == false) goto L137;
        if (this.f109686x == false) goto L137;
        this.V.setStrokeWidth(this.f109665h1);
        this.V.setColor(Color.rgb(RandomKt.Random(r112.hashCode()).nextInt(0, 256), RandomKt.Random(r112.hashCode() + 1).nextInt(0, 256), RandomKt.Random(r112.hashCode() - 1).nextInt(0, 256)));
        r110.drawLine(r112.f118417a, r128, r112.f118418b, r128, this.V);
    L137:
        if (r112.f118429m != 3) goto L143;
        if (this.Q1.containsKey(r112.f118421e) == false) goto L143;
        HSImageView r161 = (HSImageView) ((LinkedHashMap) this.Q1).get(r112.f118421e);
        if (r161 == null) goto L143;
        UtilityKotlinExtentionsKt.h(r161);
        goto L143
    L128:
        if (r112.f118419c == false) goto L130;
        this.V.setColor(f(r112.f118423g / r112.f118422f, this.f109661f, this.f109662g));
        goto L130
    L119:
        if (PadConfigUtils.c() == false) goto L122;
        r159 = this.f109659d;
        goto L121
    L122:
        float r162 = this.f109659d / 2.0f;
        int r163 = s1.f(2.0f);
    L124:
        r160 = r162 + r163;
        goto L126
    L123:
        r162 = this.f109659d / 2.0f;
        r163 = s1.f(1.0f);
        goto L124
    L46:
        r126 = false;
        goto L47
    L42:
        r125 = r123;
        goto L44
    L34:
        if (this.W == false) goto L36;
        int r164 = 4;
    L37:
        r123 = UtilityKotlinExtentionsKt.c(r164) + r119;
        goto L39
    L36:
        r164 = 3;
    L144:
        r129 = r109;
        r128 = r108;
        if (r112.f118429m == 3) goto L147;
    L151:
        r112.f118420d = false;
        goto L153
    L147:
        if (this.Q1.containsKey(r112.f118421e) == false) goto L151;
        HSImageView r165 = (HSImageView) ((LinkedHashMap) this.Q1).get(r112.f118421e);
        if (r165 == null) goto L151;
        UtilityKotlinExtentionsKt.h(r165);
    L152:
        r129 = r109;
        r128 = r108;
        goto L153
    }

    public final void m(float r100, float r101) {
        float r102 = 0;
        if (r100 <= r102) goto L6;
        this.f109672m = r100;
    L6:
        if (r101 <= r102) goto L9;
        this.f109673n = r101;
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f109690z == false) goto L5;
        float r102 = this.f109678q;
    L6:
        this.U = r102;
        int r103 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), r101);
        int r104 = ((((int) this.U) * 2) + getPaddingTop()) + getPaddingBottom();
        if (r103 >= r104) goto L9;
        r103 = r104;
    L9:
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), r100), r103);
        this.H = getPaddingLeft() + this.U;
        float r105 = (getMeasuredWidth() - getPaddingRight()) - this.U;
        this.I = r105;
        this.B = r105 - this.H;
        return;
    L5:
        r102 = this.f109668k;
        goto L6
    }

    public ReplaySeekBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f109682u = true;
        this.f109683v = true;
        this.f109690z = true;
        this.D = 1;
        this.f109653J = Float.MAX_VALUE;
        this.K = Float.MAX_VALUE;
        this.P0 = CollectionsKt.emptyList();
        this.V0 = 10;
        this.f109656b1 = UtilityKotlinExtentionsKt.c(10);
        this.f109670k1 = true;
        this.f109684v1 = 100;
        this.G1 = true;
        this.H1 = true;
        this.Q1 = new LinkedHashMap();
        this.S1 = new ArrayList();
        this.T1 = UtilityKotlinExtentionsKt.b(8.0f);
        this.V1 = LazyKt.lazy(ReplaySeekBar$mCd$2.INSTANCE);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_background_progress_color, R.attr.ttlive_measure_depend_on_dragging_radius, R.attr.ttlive_progress_height, R.attr.ttlive_progress_slide_height, R.attr.ttlive_round_point_style, R.attr.ttlive_secondary_progress_color, R.attr.ttlive_thumb_color, R.attr.ttlive_thumb_height, R.attr.ttlive_thumb_outer_stroke_color, R.attr.ttlive_thumb_radius, R.attr.ttlive_thumb_radius_on_dragging, R.attr.ttlive_track_color, R.attr.ttlive_track_color_end}, r102, 0);
        this.f109667j = r103.getColor(6, s1.h(R.color.commonui_white));
        setMThumbRadius(r103.getDimensionPixelSize(9, 15));
        float r104 = this.f109668k;
        this.f109672m = r104;
        this.f109674o = r104;
        float r105 = r103.getDimensionPixelSize(7, -1);
        this.f109671l = r105;
        if (r105 >= 0) goto L5;
        this.f109671l = this.f109668k * 2;
    L5:
        float r106 = this.f109671l;
        this.f109673n = r106;
        this.f109675p = r106;
        this.f109678q = r103.getDimensionPixelSize(10, 20);
        int r107 = r103.getDimensionPixelSize(2, (int) UIUtils.dip2Px(r100, 1.0f));
        this.f109659d = r107;
        this.f109660e = r103.getDimensionPixelSize(3, r107);
        this.f109661f = r103.getColor(11, s1.h(R.color.ttlive_replay_button_color_red));
        this.f109662g = r103.getColor(12, 0);
        this.f109679r = r103.getColor(8, 0);
        this.f109664h = r103.getColor(5, s1.h(R.color.commonui_white));
        this.f109666i = r103.getColor(0, s1.h(R.color.commonui_white));
        this.f109680s = r103.getBoolean(4, false);
        this.f109690z = r103.getBoolean(1, true);
        r103.recycle();
        Paint r108 = new Paint(1);
        this.V = r108;
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f109665h1 = this.f109659d;
        float r109 = this.f109668k;
        this.f109676p0 = r109;
        this.H0 = this.f109678q;
        this.L0 = r109;
        b();
        setWillNotDraw(false);
    }

    public static int f(float r100, int r101, int r102) {
        if (r100 <= 1) goto L5;
        r100 = 1.0f;
    L5:
        int r103 = Color.alpha(r101);
        int r104 = Color.red(r101);
        int r105 = Color.blue(r101);
        int r106 = Color.green(r101);
        int r107 = Color.alpha(r102);
        int r108 = Color.red(r102);
        int r109 = Color.blue(r102) - r105;
        return Color.argb((int) (r103 + ((r107 - r103) * r100)), (int) (r104 + ((r108 - r104) * r100)), (int) (r106 + (r100 * (Color.green(r102) - r106))), (int) (r105 + (r109 * r100)));
    }

    public /* synthetic */ ReplaySeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void e(Canvas r110, float r111, float r112, float r113) {
        float r100 = r113 / 2;
        this.V.setStrokeWidth(0.0f);
        r110.drawArc(new RectF(r111 - r100, r112 - r100, r111 + r100, r112 + r100), 90.0f, 180.0f, true, this.V);
        this.V.setStrokeWidth(r113);
    }

    public final void d(Canvas r110, float r210, float r211, float r212, float r213) {
        float r100 = r213 / 2;
        this.V.setStrokeWidth(0.0f);
        float r101 = r212 - r100;
        float r111 = r212 + r100;
        r110.drawArc(new RectF(r210 - r100, r101, r210 + r100, r111), 90.0f, 180.0f, true, this.V);
        r110.drawArc(new RectF(r211 - r100, r101, r211 + r100, r111), -90.0f, 180.0f, true, this.V);
        this.V.setStrokeWidth(r213);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        HSImageView r105 = this.P1;
        float r106 = 2;
        float r107 = (getPaddingTop() / r106) + (getMeasuredHeight() / r106);
        int r108 = s1.f(24.0f);
        if (r105 == null) goto L9;
        float r109 = this.A;
        float r110 = r108;
        r105.layout((int) (r109 - r110), (int) (r107 - r110), (int) (r109 + r110), (int) (r107 + r110));
        return;
    }

    public static void l(ReplaySeekBar r110, long r111, long r112, boolean r210, boolean r211, int r212) {
        if ((r212 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 8) == 0) goto L9;
        boolean r101 = true;
    L10:
        int r102 = r110.f109684v1;
        if (r102 == 100) goto L13;
        float r113 = r111;
    L18:
        if (r110.f109654a == r113) goto L80;
        float r103 = r102;
        if (r113 <= r103) goto L24;
        r113 = r103;
    L24:
        if (r113 >= 0) goto L26;
        r113 = 0.0f;
    L26:
        r110.f109654a = r113;
        b r104 = r110.f109663g1;
        if (r104 == null) goto L29;
        r104.e(r110, r113, r100, 0.0f);
    L29:
        if (r100 == true) goto L31;
    L66:
        boolean r213 = r101;
    L67:
        if (r213 == false) goto L79;
        r110.invalidate();
        return;
    L79:
        return;
    L31:
        if (r110.C == true) goto L66;
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r105 = r110.P0;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L34:
        if (r107.hasNext() == false) goto L38;
        Object r108 = r107.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r108).f118430n == false) goto L34;
        r106.add(r108);
        goto L34
    L38:
        List r109 = CollectionsKt.reversed(r106);
        if ((!r109.isEmpty()) == false) goto L66;
        Iterator r114 = r109.iterator();
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r115 = null;
    L42:
        if (r114.hasNext() == false) goto L53;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r116 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r114.next();
        long r117 = r116.f118423g;
        long r118 = r116.f118424h;
        boolean r214 = r101;
        long r119 = 20000;
        if (Math.abs(r117 - r118) >= r119) goto L47;
        r118 = r118 + r119;
    L47:
        if (r117 > r111) goto L52;
        if (r118 < r111) goto L52;
        r115 = r116;
    L52:
        r101 = r214;
        goto L42
    L53:
        r213 = r101;
        if (r115 != null) goto L56;
    L60:
        if (r115 != null) goto L67;
        if (r110.E == false) goto L67;
        r110.E = false;
        b r120 = r110.f109663g1;
        if (r120 == null) goto L67;
        r120.b(r110, false, r115);
        goto L67
    L56:
        if (r110.E == true) goto L60;
        r110.E = true;
        b r121 = r110.f109663g1;
        if (r121 == null) goto L60;
        r121.b(r110, true, r115);
        goto L60
    L80:
        return;
    L13:
        if (r112 <= 0) goto L15;
        r113 = (((r111 - 0) * 1.0f) / (r112 - 0)) * 100;
        goto L18
    L15:
        r113 = 0.0f;
        goto L18
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }

    public final void p(float r100, float r101, float r102, float r110, float r111, float r112, int r113, int r114) {
        AnimatorSet r103 = this.f109677p1;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        this.f109677p1 = new AnimatorSet();
        ArrayList r104 = new ArrayList();
        if (this.f109683v == false) goto L9;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r105.setInterpolator(new DecelerateInterpolator(1.5f));
        r105.addUpdateListener(new d(this, r104));
        r104.add(r105);
        Unit r106 = Unit.INSTANCE;
    L9:
        if (this.T == true) goto L11;
    L17:
        AnimatorSet r107 = this.f109677p1;
        if (r107 == null) goto L22;
        AnimatorSet r108 = r107.setDuration(200);
        if (r108 == null) goto L22;
        r108.playTogether(r104);
    L22:
        AnimatorSet r109 = this.f109677p1;
        if (r109 == null) goto L26;
        r109.start();
        return;
    L26:
        return;
    L11:
        if (r102 == r110) goto L14;
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r102, r110});
        r115.setInterpolator(new DecelerateInterpolator(1.5f));
        r115.addUpdateListener(new e(this, r104));
        r104.add(r115);
    L14:
        if (r111 == r112) goto L16;
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{r111, r112});
        r116.setInterpolator(new DecelerateInterpolator(1.5f));
        r116.addUpdateListener(new f(this, r104));
        r104.add(r116);
    L16:
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{r113, r114});
        r117.setInterpolator(new DecelerateInterpolator(1.5f));
        r117.addUpdateListener(new g(this, r104));
        r104.add(r117);
        Unit r118 = Unit.INSTANCE;
        goto L17
    }
}
