package com.bytedance.android.livesdk.chatroom.progressbar.ui;

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
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004¯\u0001°\u0001B.\b\u0007\u0012\b\u0010©\u0001\u001a\u00030¨\u0001\u0012\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001\u0012\t\b\u0002\u0010¬\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\nJ\u0010\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u000106J\u000e\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0002J\u000e\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;J\u000e\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0002J\u000e\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002R\"\u0010I\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010Q\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010W\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\\\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010T\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010VR\"\u0010`\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010D\u001a\u0004\b^\u0010F\"\u0004\b_\u0010HR\"\u0010c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010j\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010T\u001a\u0004\bh\u0010Z\"\u0004\bi\u0010VR\"\u0010n\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010T\u001a\u0004\bl\u0010Z\"\u0004\bm\u0010VR\"\u0010r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010T\u001a\u0004\bp\u0010Z\"\u0004\bq\u0010VR*\u0010v\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010b\u001a\u0004\bt\u0010d\"\u0004\bu\u0010fR*\u0010z\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010b\u001a\u0004\bx\u0010d\"\u0004\by\u0010fR:\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020|0{2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020|0{8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R2\u0010\u008b\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R&\u0010\u008f\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010D\u001a\u0005\b\u008d\u0001\u0010F\"\u0005\b\u008e\u0001\u0010HR&\u0010\u0093\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010D\u001a\u0005\b\u0091\u0001\u0010F\"\u0005\b\u0092\u0001\u0010HR&\u0010\u0097\u0001\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010T\u001a\u0005\b\u0095\u0001\u0010Z\"\u0005\b\u0096\u0001\u0010VR&\u0010\u009b\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010T\u001a\u0005\b\u0099\u0001\u0010Z\"\u0005\b\u009a\u0001\u0010VR.\u0010\u009f\u0001\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010b\u001a\u0005\b\u009d\u0001\u0010d\"\u0005\b\u009e\u0001\u0010fR!\u0010¥\u0001\u001a\u00030 \u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u0013\u0010§\u0001\u001a\u00020\u00068F¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010F¨\u0006±\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/ui/PlayerSeekBar;", "Landroid/view/ViewGroup;", "", "touchAble", "", "setTouchAble", "", "height", "setProgressHeight", "getProgressHeight", "", "getThumbRadius", "setProgressSlideHeight", "progressColor", "setProgressColor", "progressEndColor", "setProgressEndColor", "secondaryProgressColor", "setSecondaryProgressColor", "backgroundProgressColor", "setBackgroundProgressColor", "thumbColor", "setThumbColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setThumbBitmap", "setThumbBitmapWithoutResizing", "circleMarkHeightAppend", "setCircleMarkHeightAppend", "thumbRadiusOnDragging", "setThumbRadiusOnDragging", "thumbStrokeColorOnDragging", "setThumbStrokeColorOnDragging", "needDraw", "setNeedDrawMarkPassedStyle", "setNeedDrawProgress", "drawWave", "setNeedDrawWave", "diff", "setSlideStyleDiff", "left", "setSlideLeft", "right", "setSlideRight", "forceLeft", "setCustomLeft", "forceRight", "setCustomRight", "forceCustomCoordinate", "setUseCustomCoordinate", "getProgress", "getSecondaryProgress", "secondaryProgress", "setSecondaryProgress", "Lcom/bytedance/android/livesdk/chatroom/progressbar/ui/PlayerSeekBar$b;", "onVSSeekBarChangeListener", "setOnSSSeekBarChangeListener", "thumbShow", "setThumbShow", "", "progressWebpUrl", "setProgressWebpUrl", "needExpand", "setCustomMarkNeedExpand", "radius", "setSlidingMarkRadius", "setNeedDrawDebugClickAbleMarkScope", "d", "I", "getMProgressHeight", "()I", "setMProgressHeight", "(I)V", "mProgressHeight", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", ce.f26395j, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "value", OfficeSDKRequestTag.KEY_NEW_USER, FaceService.girlLabel, "setMThumbRadius", "(F)V", "mThumbRadius", ExifInterface.LONGITUDE_EAST, "getMProgressLength", "()F", "setMProgressLength", "mProgressLength", "G", "getMarkPassJudgeType", "setMarkPassJudgeType", "markPassJudgeType", FaceService.neutralLabel, "Z", "isDraggingInMarkScope", "()Z", "setDraggingInMarkScope", "(Z)V", "K", "getMLeft", "setMLeft", "mLeft", "L", "getMRight", "setMRight", "mRight", "V", "getMCurrentProgressLength", "setMCurrentProgressLength", "mCurrentProgressLength", "H0", "getMIsFullScreen", "setMIsFullScreen", "mIsFullScreen", "L0", "getMHideMarks", "setMHideMarks", "mHideMarks", "", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1, "Ljava/util/List;", "getMMarkList", "()Ljava/util/List;", "setMMarkList", "(Ljava/util/List;)V", "mMarkList", "Lkotlin/Function0;", "h1", "Lkotlin/jvm/functions/Function0;", "getOnDrawOver", "()Lkotlin/jvm/functions/Function0;", "setOnDrawOver", "(Lkotlin/jvm/functions/Function0;)V", "onDrawOver", "k1", "getMMarkClickBufferDp", "setMMarkClickBufferDp", "mMarkClickBufferDp", "p1", "getMMarkClickBufferInt", "setMMarkClickBufferInt", "mMarkClickBufferInt", "G1", "getMStrokeWidth", "setMStrokeWidth", "mStrokeWidth", "v2", "getMImageMarkSizePx", "setMImageMarkSizePx", "mImageMarkSizePx", "x2", "getForceStayAtLatest", "setForceStayAtLatest", "forceStayAtLatest", "Lio/reactivex/disposables/CompositeDisposable;", "y2", "Lkotlin/Lazy;", "getMCd", "()Lio/reactivex/disposables/CompositeDisposable;", "mCd", "getMarkCount", "markCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerSeekBar extends ViewGroup {
    public boolean A;
    public boolean B;
    public final boolean C;
    public float D;
    public float E;
    public float E2;
    public boolean F;
    public int G;
    public float G1;
    public boolean H;
    public boolean H0;
    public boolean H1;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.vsplayer.model.e f107822J;
    public float K;
    public float L;
    public boolean L0;
    public AnimatorSet L1;
    public float M;
    public final int M1;
    public float N;
    public float O;
    public float P;
    public float P0;
    public boolean P1;
    public boolean Q;
    public boolean Q1;
    public float R;
    public float S;
    public boolean S1;
    public float T;
    public boolean T1;
    public float U;
    public float V;
    public float V0;
    public VelocityTracker V1;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f107823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f107824b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f107825b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public String f107826b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f107827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f107828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f107829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f107830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f107831g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> f107832g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public HSImageView f107833g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f107834h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public Function0<Unit> f107835h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final Map<String, HSImageView> f107836h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f107837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DataCenter f107838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f107839k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f107840k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f107841k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f107842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f107843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f107844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f107845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f107846p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Paint f107847p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f107848p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final List<Float> f107849p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f107850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f107851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f107852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f107853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f107854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f107855v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f107856v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public float f107857v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f107858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f107859x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f107860x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public boolean f107861x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f107862y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public b f107863y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public final Lazy f107864y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Bitmap f107865z;

    public static final class a {
    }

    public interface b {
        void Jk(PlayerSeekBar r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r101);

        void O3();

        void d7(PlayerSeekBar r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r101);

        void lg(PlayerSeekBar r100, boolean r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102);

        void n8(PlayerSeekBar r100, float r101, boolean r102, float r103);

        void od(PlayerSeekBar r100);

        void tq(PlayerSeekBar r100);
    }

    public static final class c implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerSeekBar f107866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f107867b;

        public c(PlayerSeekBar r100, float r101) {
            this.f107866a = r100;
            this.f107867b = r101;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "mThumbRadius set from [" + this.f107866a.f107844n + "] to [" + this.f107867b + ']';
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerSeekBar f107868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f107869b;

        public d(PlayerSeekBar r100, List r101) {
            this.f107868a = r100;
            this.f107869b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PlayerSeekBar r101 = this.f107868a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f107825b1 = ((Float) r102).floatValue();
            this.f107868a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerSeekBar f107870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f107871b;

        public e(PlayerSeekBar r100, List r101) {
            this.f107870a = r100;
            this.f107871b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PlayerSeekBar r101 = this.f107870a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            PlayerSeekBar.a(r101, ((Float) r102).floatValue());
            this.f107870a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerSeekBar f107872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f107873b;

        public f(PlayerSeekBar r100, List r101) {
            this.f107872a = r100;
            this.f107873b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PlayerSeekBar r101 = this.f107872a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f107845o = ((Float) r102).floatValue();
            this.f107872a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerSeekBar f107874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f107875b;

        public g(PlayerSeekBar r100, List r101) {
            this.f107874a = r100;
            this.f107875b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PlayerSeekBar r101 = this.f107874a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setMStrokeWidth(((Float) r102).floatValue());
            this.f107874a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public PlayerSeekBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlayerSeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final CompositeDisposable getMCd() {
        return (CompositeDisposable) this.f107864y2.getValue();
    }

    public final void k() {
        this.B = false;
        int r100 = this.f107828d;
        this.G1 = r100;
        p(this.V0, this.P0, this.f107846p, this.f107851r, this.f107850q, this.f107852s, this.f107829e, r100);
    }

    public final void b() {
        if (this.f107826b2 != null) goto L5;
        return;
    L5:
        HSImageView r100 = new HSImageView(getContext());
        r100.setLayoutParams(new ViewGroup.LayoutParams(s1.f(48.0f), s1.f(48.0f)));
        r100.setVisibility(8);
        String r101 = this.f107826b2;
        r100.setController(Fresco.newDraweeControllerBuilder().setUri(r101).setAutoPlayAnimations(true).build());
        Unit r102 = Unit.INSTANCE;
        this.f107833g2 = r100;
        removeView(r100);
        addView(this.f107833g2);
    }

    public final void g() {
        HSImageView r100 = this.f107833g2;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.f107833g2;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
        return;
    L11:
        return;
    L5:
        if (r100.getVisibility() != 8) goto L7;
    }

    public final int getMarkCount() {
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r100 = this.f107832g1;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r103).f118420d == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return r101.size();
    }

    public final int getProgress() {
        return MathKt.roundToInt(this.f107823a);
    }

    public final int getSecondaryProgress() {
        return MathKt.roundToInt(this.f107824b);
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.f107837i == true) goto L5;
        super.invalidate();
        return;
    L5:
        if (getVisibility() == 0) goto L7;
        return;
    L7:
        if (getAlpha() == 0.0f) goto L12;
        super.invalidate();
        return;
    }

    public final void j() {
        Bitmap r100 = this.f107865z;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        removeAllViews();
        ((LinkedHashMap) this.f107836h2).clear();
        getMCd().clear();
    }

    public final void o() {
        HSImageView r100 = this.f107833g2;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.f107833g2;
        if (r101 == null) goto L11;
        r101.setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
    }

    public final DataCenter getDataCenter() {
        return this.f107838j;
    }

    public final boolean getForceStayAtLatest() {
        return this.f107861x2;
    }

    public final float getMCurrentProgressLength() {
        return this.V;
    }

    public final boolean getMHideMarks() {
        return this.L0;
    }

    public final float getMImageMarkSizePx() {
        return this.f107857v2;
    }

    public final boolean getMIsFullScreen() {
        return this.H0;
    }

    public final float getMLeft() {
        return this.K;
    }

    public final int getMMarkClickBufferDp() {
        return this.f107841k1;
    }

    public final int getMMarkClickBufferInt() {
        return this.f107848p1;
    }

    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> getMMarkList() {
        return this.f107832g1;
    }

    public final int getMProgressHeight() {
        return this.f107828d;
    }

    public final float getMProgressLength() {
        return this.E;
    }

    public final float getMRight() {
        return this.L;
    }

    public final float getMStrokeWidth() {
        return this.G1;
    }

    public final int getMarkPassJudgeType() {
        return this.G;
    }

    public final Function0<Unit> getOnDrawOver() {
        return this.f107835h1;
    }

    public final int getProgressHeight() {
        return this.f107828d;
    }

    public final float getThumbRadius() {
        return this.f107844n;
    }

    public static void q(PlayerSeekBar r100) {
        boolean r101 = r100.B;
        if (r101 == false) goto L11;
        if (r100.W == false) goto L11;
        if (r100.M == Float.MAX_VALUE) goto L9;
        float r102 = r100.O;
    L14:
        r100.T = r102;
        if (r101 == false) goto L23;
        if (r100.W == false) goto L23;
        if (r100.N == Float.MAX_VALUE) goto L21;
        float r103 = r100.P;
    L26:
        r100.U = r103;
        r100.V = r103 - r102;
        return;
    L21:
        r103 = r100.L - (r100.f107829e / 2);
    L23:
        if (r100.Q == false) goto L25;
        r103 = r100.S;
        goto L26
    L25:
        r103 = r100.L;
        goto L26
    L9:
        r102 = r100.K + (r100.f107829e / 2);
    L11:
        if (r100.Q == false) goto L13;
        r102 = r100.R;
        goto L14
    L13:
        r102 = r100.K;
        goto L14
    }

    private final void setMThumbRadius(float r100) {
        ALogger.v("VSSeekBar[" + hashCode() + ']', new c(this, r100));
        this.f107844n = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(r100);
    }

    public final com.bytedance.android.livesdk.chatroom.vsplayer.model.e h(MotionEvent r100) {
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r101 = this.f107832g1;
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
        float r109 = this.f107848p1 + r108;
        float r110 = r100.getX();
        if (r110 < r108) goto L10;
        if (r110 > r109) goto L10;
        return r106;
    L14:
        if (r107 != 3) goto L15;
        float r111 = r106.f118417a;
        float r112 = this.f107848p1 + r111;
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
        this.f107847p0.setAlpha(255);
        float r100 = 2;
        float r101 = (getPaddingTop() / r100) + (getMeasuredHeight() / r100);
        if (this.Q1 == false) goto L7;
        float r102 = this.G1 / r100;
        float r103 = this.f107844n;
        if (r102 <= r103) goto L7;
        float r104 = r102 - r103;
    L8:
        q(this);
        if (this.f107861x2 == false) goto L11;
        float r105 = this.M1;
    L12:
        float r106 = this.V;
        float r107 = (r106 / this.M1) * r105;
        float r108 = this.T;
        this.D = r107 + r108;
        float r109 = this.f107824b;
        if (r109 == 0.0f) goto L15;
        float r111 = ((r106 / 100) * r109) + r108;
    L16:
        this.f107847p0.setStrokeWidth(this.G1);
        this.f107847p0.setColor(this.f107842l);
        r110.drawLine(this.T + r104, r101, this.U - r104, r101, this.f107847p0);
        if (this.f107855v == false) goto L19;
        d(r110, this.T + r104, this.U - r104, r101, this.G1);
    L19:
        this.f107847p0.setStrokeWidth(this.G1);
        this.f107847p0.setColor(this.f107839k);
        r110.drawLine(this.T + r104, r101, r111, r101, this.f107847p0);
        if (this.f107855v == true) goto L22;
    L24:
        c(r110, true);
        if (this.f107859x == false) goto L59;
        int r112 = this.f107834h;
        if (r112 != 0) goto L29;
    L45:
        this.f107847p0.setStrokeWidth(this.G1);
        if (this.B == false) goto L48;
        this.f107847p0.setColor(this.f107831g);
    L49:
        r110.drawLine(this.T + r104, r101, this.D, r101, this.f107847p0);
        if (this.f107855v == false) goto L59;
        if (this.f107823a <= 0) goto L59;
        if (this.B == true) goto L56;
    L58:
        d(r110, this.T + r104, this.D, r101, this.G1);
        goto L59
    L56:
        if (this.P1 == false) goto L58;
        e(r110, this.T + r104, r101, this.G1);
        goto L59
    L48:
        this.f107847p0.setColor(this.f107830f);
        goto L49
    L29:
        if (r112 == this.f107830f) goto L45;
        this.f107847p0.setStrokeWidth(this.G1);
        float r113 = this.D;
        float r114 = this.T;
        float r115 = r113 - r114;
        float r116 = r114 + r104;
    L33:
        if (r116 > this.D) goto L35;
        this.f107847p0.setColor(f((r116 - this.T) / r115, this.f107830f, this.f107834h));
        float r117 = r116 + 5;
        r110.drawLine(r116, r101, r117, r101, this.f107847p0);
        r116 = r117;
        goto L33
    L35:
        this.f107847p0.setColor(this.f107830f);
        if (this.f107855v == false) goto L59;
        if (this.f107823a <= 0) goto L59;
        if (this.B == true) goto L42;
    L44:
        d(r110, this.T + r104, this.D, r101, this.G1);
        goto L59
    L42:
        if (this.P1 == false) goto L44;
        e(r110, this.T + r104, r101, this.G1);
    L59:
        c(r110, false);
        if (this.T1 == false) goto L87;
        this.f107847p0.setColor(-16777216);
        Bitmap r118 = this.f107865z;
        if (r118 != null) goto L64;
    L70:
        HSImageView r119 = this.f107833g2;
        if (r119 == null) goto L73;
        int r120 = s1.f(24.0f);
        float r121 = this.D;
        float r122 = r120;
        r119.layout((int) (r121 - r122), (int) (r101 - r122), (int) (r121 + r122), (int) (r122 + r101));
    L73:
        Bitmap r123 = this.f107865z;
        if (r123 != null) goto L76;
    L77:
        HSImageView r124 = this.f107833g2;
        if (r124 != null) goto L80;
    L81:
        this.f107847p0.setStrokeWidth(0.0f);
        this.f107847p0.setColor(this.f107854u);
        if ((this.f107844n * r100) == this.f107845o) goto L84;
    L86:
        this.f107847p0.setColor(this.f107843m);
        float r125 = this.D;
        float r126 = this.f107844n;
        float r127 = this.f107845o / r100;
        RectF r128 = new RectF(new Rect((int) (r125 - r126), (int) (r101 - r127), (int) (r125 + r126), (int) (r101 + r127)));
        float r129 = this.f107844n;
        r110.drawRoundRect(r128, r129, r129, this.f107847p0);
        goto L87
    L84:
        if (this.f107862y == false) goto L86;
        r110.drawCircle(this.D, r101, this.f107825b1, this.f107847p0);
        goto L86
    L80:
        if (r124.getVisibility() == 0) goto L87;
    L76:
        if (r123.isRecycled() == false) goto L87;
    L64:
        if (r118.isRecycled() == true) goto L70;
        HSImageView r130 = this.f107833g2;
        if (r130 != null) goto L68;
    L69:
        int r131 = s1.f(11.0f);
        Bitmap r132 = this.f107865z;
        Intrinsics.checkNotNull(r132);
        float r133 = r131;
        r110.drawBitmap(r132, this.D - r133, r101 - r133, this.f107847p0);
        goto L70
    L68:
        if (r130.getVisibility() == 0) goto L70;
    L87:
        Function0<Unit> r134 = this.f107835h1;
        if (r134 == null) goto L92;
        Unit r135 = r134.invoke();
        return;
    L92:
        return;
    L22:
        if (this.f107823a <= 0) goto L24;
        d(r110, this.T + r104, r111, r101, this.G1);
        goto L24
    L15:
        r111 = r108;
        goto L16
    L11:
        r105 = this.f107823a;
    L7:
        r104 = 0.0f;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.H1 == false) goto L213;
        b r100 = this.f107863y1;
        if (r100 == null) goto L7;
        r100.O3();
    L7:
        VelocityTracker r101 = this.V1;
        if (r101 != null) goto L10;
        this.V1 = VelocityTracker.obtain();
    L11:
        VelocityTracker r102 = this.V1;
        if (r102 == null) goto L14;
        r102.addMovement(r110);
    L14:
        int r103 = r110.getActionMasked();
        int r111 = 1;
        float r104 = 0.0f;
        if (r103 == 0) goto L161;
        if (r103 == 1) goto L142;
        if (r103 == 2) goto L41;
        if (r103 == 3) goto L20;
    L19:
        boolean r112 = true;
    L207:
        if (this.F == false) goto L209;
        return r112;
    L209:
        if (super.onTouchEvent(r110) == true) goto L235;
        return false;
    L235:
        return r112;
    L20:
        VelocityTracker r105 = this.V1;
        if (r105 == null) goto L23;
        r105.recycle();
    L23:
        this.V1 = null;
        q(this);
        float r106 = r110.getX() + this.E2;
        this.D = r106;
        float r107 = this.T;
        if (r106 >= r107) goto L26;
        this.D = r107;
    L26:
        float r108 = this.D;
        float r109 = this.U;
        if (r108 <= r109) goto L29;
        this.D = r109;
    L29:
        float r113 = this.V;
        if (r113 == 0.0f) goto L32;
        this.f107823a = ((this.D - r107) * this.M1) / r113;
    L32:
        b r114 = this.f107863y1;
        if (r114 != null) goto L35;
    L37:
        g();
        this.F = false;
        invalidate();
        if (this.S1 == false) goto L19;
        k();
        goto L19
    L35:
        if (this.F == false) goto L37;
        r114.d7(this, this.f107822J);
        goto L37
    L41:
        if (this.F == false) goto L134;
        o();
        q(this);
        float r115 = r110.getX() + this.E2;
        this.D = r115;
        if (this.B == false) goto L45;
        float r116 = this.T;
        float r117 = this.K;
        this.D = r116 + (((r115 - r117) / (this.L - r117)) * this.V);
    L45:
        float r118 = this.D;
        float r119 = this.T;
        if (r118 >= r119) goto L48;
        this.D = r119;
    L48:
        float r120 = this.D;
        float r121 = this.U;
        if (r120 <= r121) goto L51;
        this.D = r121;
    L51:
        float r122 = this.V;
        if (r122 == 0.0f) goto L54;
        this.f107823a = ((this.D - r119) * this.M1) / r122;
    L54:
        invalidate();
        if (this.f107863y1 == null) goto L19;
        VelocityTracker r123 = this.V1;
        if (r123 == null) goto L59;
        r123.computeCurrentVelocity(1000);
    L59:
        VelocityTracker r124 = this.V1;
        if (r124 == null) goto L62;
        r104 = r124.getXVelocity();
    L62:
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r125 = this.f107832g1;
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r125.iterator();
    L64:
        if (r127.hasNext() == false) goto L73;
        Object r128 = r127.next();
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r129 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r128;
        if (r129.f118430n == true) goto L68;
    L70:
        boolean r130 = false;
    L71:
        if (r130 == false) goto L64;
        r126.add(r128);
        goto L64
    L68:
        if (r129.f118420d == false) goto L70;
        r130 = true;
        goto L71
    L73:
        Iterator r131 = CollectionsKt.reversed(r126).iterator();
    L75:
        if (r131.hasNext() == false) goto L97;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r132 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r131.next();
        int r133 = this.G;
        if (r133 != r111) goto L87;
        long r134 = (long) ((r132.f118422f * this.f107823a) / 100.0f);
        long r135 = r132.f118423g;
        long r136 = r132.f118424h;
        long r137 = 20000;
        if (Math.abs(r135 - r136) >= r137) goto L82;
        r136 = r136 + r137;
    L82:
        if (r135 > r134) goto L96;
        if (r136 < r134) goto L96;
    L98:
        if (r132 != null) goto L100;
    L105:
        if (r132 == null) goto L121;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r138 = this.f107822J;
        if (r138 == null) goto L109;
        int r139 = r138.hashCode();
    L111:
        if (r139 == r132.hashCode()) goto L121;
        if (this.H == false) goto L121;
        b r140 = this.f107863y1;
        if (r140 == null) goto L117;
        r140.lg(this, false, this.f107822J);
    L117:
        b r141 = this.f107863y1;
        if (r141 == null) goto L120;
        r141.lg(this, true, r132);
    L120:
        this.f107822J = r132;
    L128:
        b r142 = this.f107863y1;
        if (r142 == null) goto L131;
        r142.n8(this, this.f107823a, true, r104);
    L131:
        b r143 = this.f107863y1;
        if (r143 == null) goto L19;
        r143.od(this);
        goto L19
    L109:
        r139 = 0;
    L121:
        if (r132 != null) goto L128;
        if (this.H == false) goto L128;
        this.H = false;
        b r144 = this.f107863y1;
        if (r144 == null) goto L127;
        r144.lg(this, false, r132);
    L127:
        this.f107822J = null;
        goto L128
    L100:
        if (this.H == true) goto L105;
        this.H = true;
        b r145 = this.f107863y1;
        if (r145 == null) goto L104;
        r145.lg(this, true, r132);
    L104:
        this.f107822J = r132;
    L96:
        r111 = 1;
        goto L75
    L87:
        if (r133 != 2) goto L96;
        float r146 = r132.f118417a;
        float r147 = r132.f118418b;
        float r148 = Math.abs(r146 - r147);
        int r149 = this.f107848p1;
        if (r148 >= r149) goto L91;
        float r150 = r149 / 2;
        r146 = r146 - r150;
        r147 = r147 + r150;
    L91:
        float r151 = this.D;
        if (r151 < r146) goto L96;
        if (r151 > r147) goto L96;
    L97:
        r132 = null;
        goto L98
    L134:
        b r152 = this.f107863y1;
        if (r152 == null) goto L137;
        r152.tq(this);
    L137:
        b r153 = this.f107863y1;
        if (r153 == null) goto L140;
        r153.od(this);
    L140:
        o();
        goto L19
    L142:
        if (i(r110) == true) goto L144;
    L151:
        VelocityTracker r154 = this.V1;
        if (r154 == null) goto L154;
        r154.recycle();
    L154:
        this.V1 = null;
        this.F = false;
        b r155 = this.f107863y1;
        if (r155 == null) goto L157;
        r155.d7(this, this.f107822J);
    L157:
        g();
        invalidate();
        if (this.S1 == false) goto L19;
        k();
        goto L19
    L144:
        if (this.I == false) goto L151;
        this.I = false;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r156 = h(r110);
        if (r156 == null) goto L151;
        b r157 = this.f107863y1;
        if (r157 == null) goto L151;
        r157.Jk(this, r156);
        return true;
    L161:
        if (isEnabled() == true) goto L163;
    L168:
        boolean r158 = false;
    L169:
        this.F = r158;
        if (r158 == false) goto L180;
        b r159 = this.f107863y1;
        if (r159 == null) goto L175;
        r159.tq(this);
    L175:
        if (this.S1 == false) goto L178;
        this.G1 = this.f107829e;
        this.B = true;
    L178:
        o();
        invalidate();
    L202:
        r112 = true;
    L203:
        this.E2 = this.D - r110.getX();
        if (this.S1 == false) goto L207;
        this.B = r112;
        int r160 = this.f107829e;
        this.G1 = r160;
        p(this.P0, this.V0, this.f107851r, this.f107846p, this.f107852s, this.f107850q, this.f107828d, r160);
        goto L207
    L180:
        if (i(r110) == false) goto L202;
        if (h(r110) == null) goto L185;
        this.I = true;
        return true;
    L185:
        b r161 = this.f107863y1;
        if (r161 == null) goto L188;
        r161.tq(this);
    L188:
        this.D = r110.getX();
        q(this);
        float r162 = this.D;
        float r163 = this.T;
        if (r162 >= r163) goto L191;
        this.D = r163;
    L191:
        float r164 = this.D;
        float r165 = this.U;
        if (r164 <= r165) goto L194;
        this.D = r165;
    L194:
        float r166 = this.V;
        if (r166 == 0.0f) goto L197;
        this.f107823a = ((this.D - r163) * this.M1) / r166;
    L197:
        b r167 = this.f107863y1;
        if (r167 == null) goto L200;
        r112 = true;
        r167.n8(this, this.f107823a, true, 0.0f);
    L201:
        invalidate();
        this.F = r112;
        goto L203
    L200:
        r112 = true;
        goto L201
    L163:
        if (this.f107823a == 0.0f) goto L168;
        q(this);
        if ((Math.pow(r110.getX() - (((this.V / this.M1) * this.f107823a) + this.T), 2.0d) + Math.pow(r110.getY() - (getMeasuredHeight() / 2), 2.0d)) > (Math.pow(getMeasuredHeight() / 2, 2.0d) + ((double) UtilityKotlinExtentionsKt.h(3)))) goto L168;
        r158 = true;
        goto L169
    L10:
        r101.clear();
        goto L11
    L213:
        DataCenter r168 = this.f107838j;
        if (r168 == null) goto L216;
        String r169 = (String) r168.get("key_chorus_disable_seek_toast", "");
    L217:
        if (r169 == null) goto L220;
        f2.c(r169, 0);
    L220:
        return super.onTouchEvent(r110);
    L216:
        r169 = null;
        goto L217
    }

    public final void setBackgroundProgressColor(int r100) {
        this.f107842l = r100;
        invalidate();
    }

    public final void setCircleMarkHeightAppend(float r100) {
        this.f107827c = r100;
    }

    public final void setCustomLeft(float r100) {
        this.R = r100 + this.f107840k0;
    }

    public final void setCustomMarkNeedExpand(boolean r100) {
        this.f107856v1 = r100;
    }

    public final void setCustomRight(float r100) {
        this.S = r100 - this.f107840k0;
    }

    public final void setDataCenter(DataCenter r100) {
        this.f107838j = r100;
    }

    public final void setDraggingInMarkScope(boolean r100) {
        this.H = r100;
    }

    public final void setForceStayAtLatest(boolean r100) {
        this.f107861x2 = r100;
        invalidate();
    }

    public final void setMCurrentProgressLength(float r100) {
        this.V = r100;
    }

    public final void setMHideMarks(boolean r100) {
        this.L0 = r100;
        postInvalidate();
    }

    public final void setMImageMarkSizePx(float r100) {
        this.f107857v2 = r100;
    }

    public final void setMIsFullScreen(boolean r100) {
        this.H0 = r100;
        postInvalidate();
    }

    public final void setMLeft(float r100) {
        this.K = r100;
    }

    public final void setMMarkClickBufferDp(int r100) {
        this.f107841k1 = r100;
    }

    public final void setMMarkClickBufferInt(int r100) {
        this.f107848p1 = r100;
    }

    public final void setMMarkList(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r101 = CollectionsKt.sorted(r100);
        this.f107832g1 = r101;
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
        RxUtilKt.c(Observable.create(new com.bytedance.android.livesdk.chatroom.progressbar.ui.b(this, r101)).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(com.bytedance.android.livesdk.chatroom.progressbar.ui.c.f107878a, com.bytedance.android.livesdk.chatroom.progressbar.ui.d.f107879a), getMCd());
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
        this.f107828d = r100;
    }

    public final void setMProgressLength(float r100) {
        this.E = r100;
    }

    public final void setMRight(float r100) {
        this.L = r100;
    }

    public final void setMStrokeWidth(float r100) {
        this.G1 = r100;
    }

    public final void setMarkPassJudgeType(int r100) {
        this.G = r100;
    }

    public final void setNeedDrawDebugClickAbleMarkScope(boolean r100) {
        this.A = r100;
    }

    public final void setNeedDrawMarkPassedStyle(boolean r100) {
        this.f107858w = r100;
        invalidate();
    }

    public final void setNeedDrawProgress(boolean r100) {
        this.f107859x = r100;
        invalidate();
    }

    public final void setNeedDrawWave(boolean r100) {
        this.f107862y = r100;
    }

    public final void setOnDrawOver(Function0<Unit> r100) {
        this.f107835h1 = r100;
    }

    public final void setOnSSSeekBarChangeListener(b r100) {
        this.f107863y1 = r100;
    }

    public final void setProgressColor(int r100) {
        this.f107830f = r100;
        invalidate();
    }

    public final void setProgressEndColor(int r100) {
        this.f107834h = r100;
        invalidate();
    }

    public final void setProgressHeight(int r100) {
        this.f107828d = r100;
        this.G1 = r100;
        invalidate();
    }

    public final void setProgressSlideHeight(int r100) {
        this.f107829e = r100;
    }

    public final void setProgressWebpUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "progressWebpUrl");
        this.f107826b2 = r100;
        if (getChildCount() >= 1) goto L6;
        b();
        return;
    }

    public final void setSecondaryProgress(float r100) {
        this.f107824b = r100;
        invalidate();
    }

    public final void setSecondaryProgressColor(int r100) {
        this.f107839k = r100;
        invalidate();
    }

    public final void setSlideLeft(float r100) {
        this.M = r100;
        if (this.C == false) goto L5;
        float r101 = this.f107853t;
    L6:
        this.f107840k0 = r101;
        this.O = r100 + r101;
        return;
    L5:
        r101 = this.f107844n;
        goto L6
    }

    public final void setSlideRight(float r100) {
        this.N = r100;
        if (this.C == false) goto L5;
        float r101 = this.f107853t;
    L6:
        this.f107840k0 = r101;
        this.P = r100 - r101;
        return;
    L5:
        r101 = this.f107844n;
        goto L6
    }

    public final void setSlideStyleDiff(boolean r100) {
        this.W = r100;
    }

    public final void setSlidingMarkRadius(int r100) {
        this.f107860x1 = r100;
    }

    public final void setThumbBitmap(Bitmap r100) {
        Canvas r101 = null;
        if (r100 != null) goto L5;
        this.f107865z = null;
    L5:
        if (r100 == null) goto L12;
        int r102 = s1.f(22.0f);
        float r103 = r102 / r100.getWidth();
        Matrix r104 = new Matrix();
        r104.postScale(r103, r103);
        Bitmap r105 = Bitmap.createBitmap(r102, r102, Bitmap.Config.ARGB_4444);
        this.f107865z = r105;
        if (r105 == null) goto L9;
        r101 = new Canvas(r105);
    L9:
        Paint r106 = new Paint();
        r106.setColor(-16777216);
        if (r101 == null) goto L12;
        r101.drawBitmap(r100, r104, r106);
    L12:
        invalidate();
    }

    public final void setThumbBitmapWithoutResizing(Bitmap r100) {
        this.f107865z = r100;
        invalidate();
    }

    public final void setThumbColor(int r100) {
        this.f107843m = r100;
        invalidate();
    }

    public final void setThumbRadiusOnDragging(float r100) {
        this.f107853t = r100;
        float r101 = this.f107844n;
        this.P0 = r101;
        this.V0 = r100;
        this.f107825b1 = r101;
        requestLayout();
    }

    public final void setThumbShow(boolean r100) {
        this.T1 = r100;
    }

    public final void setThumbStrokeColorOnDragging(int r100) {
        this.f107854u = r100;
        invalidate();
    }

    public final void setTouchAble(boolean r100) {
        this.H1 = r100;
    }

    public final void setUseCustomCoordinate(boolean r100) {
        this.Q = r100;
    }

    public static final /* synthetic */ void a(PlayerSeekBar r100, float r101) {
        r100.setMThumbRadius(r101);
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar$drawImageCustomMarks$1] */
    public final void c(Canvas r110, boolean r210) {
        boolean r100 = false;
        if (this.f107832g1.isEmpty() == false) goto L5;
    L166:
        Iterator<T> r101 = this.f107832g1.iterator();
    L168:
        if (r101.hasNext() == false) goto L170;
        ((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r101.next()).f118420d = false;
        goto L168
    L170:
        return;
    L5:
        if (this.L0 == true) goto L166;
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r102 = this.f107832g1;
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
        if (r111.hasNext() == false) goto L165;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r112 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r111.next();
        q(this);
        this.f107847p0.setColor(r112.f118426j);
        long r113 = r112.f118422f;
        if (r113 == 0) goto L163;
        float r114 = this.V;
        if (r114 == 0.0f) goto L163;
        long r115 = r112.f118423g;
        long r116 = r112.f118425i;
        float r117 = (((r115 - r116) / (r113 - r116)) * r114) + getPaddingLeft();
        float r118 = this.T;
        float r119 = r117 + r118;
        if (r119 > this.U) goto L155;
        long r120 = r112.f118423g;
        long r121 = r112.f118425i;
        if (r120 < r121) goto L155;
        r112.f118417a = r119 - (this.f107848p1 / r107);
        if (r119 >= r118) goto L31;
        r112.f118417a = r118;
        r119 = r118;
    L31:
        long r122 = r112.f118424h;
        if (r120 == r122) goto L34;
        float r123 = ((((r122 - r121) / (r112.f118422f - r121)) * this.V) + getPaddingLeft()) + this.T;
    L39:
        r112.f118418b = (this.f107848p1 / r107) + r123;
        float r124 = this.U;
        if (r123 <= r124) goto L42;
        r112.f118418b = r124;
        float r125 = r124;
    L44:
        if (r119 >= this.D) goto L46;
        boolean r126 = true;
    L47:
        r112.f118419c = r126;
        int r127 = r112.f118429m;
        if (r127 != 0) goto L50;
        this.f107847p0.setStrokeWidth(this.G1);
        r110.drawLine(r119, r108, r125, r108, this.f107847p0);
    L52:
        float r128 = r108;
        int r129 = r109;
    L53:
        r112 = r112;
    L154:
        r112.f118420d = true;
    L164:
        r109 = r129 + 1;
        r108 = r128;
        r100 = false;
        r105 = 1;
        goto L18
    L50:
        if (r127 != r105) goto L55;
        this.f107847p0.setStrokeWidth(this.G1);
        d(r110, r119, r125, r108, this.f107828d);
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
        r110.drawLine(r119, r131, r125, r128, this.f107847p0);
        if (this.f107855v == false) goto L111;
        r112 = r112;
        d(r110, r132, r125, r128, this.f107828d);
        goto L53
    L111:
        r112 = r112;
        goto L53
    L63:
        if (this.B == false) goto L108;
        ?? r133 = new PlayerSeekBar$drawImageCustomMarks$1(this, r130);
        if (r112.f118429m == 3) goto L67;
    L107:
        r128 = r131;
        r129 = r130;
        goto L53
    L67:
        if (r112.f118427k == null) goto L107;
        if (this.f107836h2.containsKey(r112.f118421e) == false) goto L107;
        HSImageView r134 = (HSImageView) ((LinkedHashMap) this.f107836h2).get(r112.f118421e);
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
        UtilityKotlinExtentionsKt.w(r134);
        Ref.FloatRef r136 = new Ref.FloatRef();
        r136.element = r119;
        IntProgression r137 = RangesKt.step(CollectionsKt.getIndices(this.f107849p2), r107);     // Catch: IndexOutOfBoundsException -> L102
        int r138 = r137.getFirst();     // Catch: IndexOutOfBoundsException -> L102
        int r139 = r137.getLast();     // Catch: IndexOutOfBoundsException -> L102
        int r140 = r137.getStep();     // Catch: IndexOutOfBoundsException -> L102
        if (r140 < 0) goto L93;
        if (r138 <= r139) goto L94;
    L103:
        Ref.FloatRef r141 = new Ref.FloatRef();
        float r142 = r136.element;
        float r143 = this.f107857v2;
        float r144 = r142 + r143;
        r141.element = r144;
        r107 = 2;
        float r145 = 2;
        float r146 = r143 / r145;
        r134.layout((int) r136.element, (int) (r131 - r146), (int) r144, (int) (r146 + r131));
        r133.invoke(r136.element, r141.element);
        float r147 = this.f107848p1;
        float r148 = this.f107857v2;
        if (r147 <= r148) goto L106;
        float r149 = (r147 - r148) / r145;
        r112.f118417a = r136.element - r149;
        r112.f118418b = r141.element + r149;
    L106:
        ALogger.v("VSSeekBar", new com.bytedance.android.livesdk.chatroom.progressbar.ui.f(r136, r141, r112));
    L94:
        float r150 = ((Number) ListProtector.get(this.f107849p2, r138)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        int r151 = r138 + 1;     // Catch: IndexOutOfBoundsException -> L102
        float r152 = ((Number) ListProtector.get(this.f107849p2, r151)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        float r153 = r136.element;     // Catch: IndexOutOfBoundsException -> L102
        if (r153 >= r150) goto L97;
    L100:
        if (r138 == r139) goto L103;
        r138 = r138 + r140;
        goto L94
    L97:
        if (r153 > r152) goto L100;
        r136.element = ((Number) ListProtector.get(this.f107849p2, r151)).floatValue();     // Catch: IndexOutOfBoundsException -> L102
        ALogger.v("VSSeekBar", new com.bytedance.android.livesdk.chatroom.progressbar.ui.e(r136, r119, r112));     // Catch: IndexOutOfBoundsException -> L102
        goto L103
    L93:
        if (r138 < r139) goto L103;
    L102:
        ALogger.e("VSSeekBar", "imageMarksRange error,skip left range detect");
        goto L103
    L78:
        if (Intrinsics.areEqual(r134.getParent(), this) == false) goto L84;
        int r154 = r134.getLeft() - 5;
        int r155 = r134.getLeft() + 5;
        int r156 = (int) r119;
        if (r154 > r156) goto L84;
        if (r155 < r156) goto L84;
        r133.invoke(r134.getLeft() * 1.0f, r134.getRight() * 1.0f);
        UtilityKotlinExtentionsKt.w(r134);
        goto L107
    L75:
        r135 = null;
        goto L76
    L59:
        if (this.B == true) goto L61;
    L113:
        float r157 = r119;
        r128 = r131;
        r129 = r130;
        this.f107847p0.setStrokeWidth(1.0f);
        this.f107847p0.setColor(r112.f118426j);
        if (this.H0 == false) goto L126;
        float r158 = this.f107827c;
        if (r158 == 0.0f) goto L119;
        int r159 = this.f107828d + s1.f(r158);
    L130:
        float r160 = r159 / 2.0f;
    L132:
        if (this.B == false) goto L137;
        int r161 = this.f107860x1;
        if (r161 <= 0) goto L137;
        r160 = r161;
    L137:
        if (this.f107858w == true) goto L139;
    L141:
        r110.drawCircle(r157, r128, r160, this.f107847p0);
        if (v.a() == false) goto L148;
        if (this.A == false) goto L148;
        this.f107847p0.setStrokeWidth(this.G1);
        this.f107847p0.setColor(Color.rgb(RandomKt.Random(r112.hashCode()).nextInt(0, 256), RandomKt.Random(r112.hashCode() + 1).nextInt(0, 256), RandomKt.Random(r112.hashCode() - 1).nextInt(0, 256)));
        r110.drawLine(r112.f118417a, r128, r112.f118418b, r128, this.f107847p0);
    L148:
        if (r112.f118429m != 3) goto L154;
        if (this.f107836h2.containsKey(r112.f118421e) == false) goto L154;
        HSImageView r162 = (HSImageView) ((LinkedHashMap) this.f107836h2).get(r112.f118421e);
        if (r162 == null) goto L154;
        UtilityKotlinExtentionsKt.t(r162);
        goto L154
    L139:
        if (r112.f118419c == false) goto L141;
        this.f107847p0.setColor(f(r112.f118423g / r112.f118422f, this.f107830f, this.f107834h));
        goto L141
    L119:
        if (PadConfigUtils.c() == false) goto L122;
        r159 = this.f107828d;
        goto L130
    L122:
        if (this.f107856v1 == false) goto L124;
        float r163 = this.f107828d / 2.0f;
        int r164 = s1.f(2.0f);
    L128:
        r160 = r163 + r164;
        goto L132
    L124:
        r159 = this.f107828d;
        goto L130
    L126:
        if (this.f107856v1 == false) goto L129;
        r163 = this.f107828d / 2.0f;
        r164 = s1.f(1.0f);
        goto L128
    L129:
        r159 = this.f107828d;
        goto L130
    L46:
        r126 = false;
        goto L47
    L42:
        r125 = r123;
        goto L44
    L34:
        if (this.H0 == false) goto L36;
        int r165 = 4;
    L37:
        r123 = UtilityKotlinExtentionsKt.i(r165) + r119;
        goto L39
    L36:
        r165 = 3;
    L155:
        r129 = r109;
        r128 = r108;
        if (r112.f118429m == 3) goto L158;
    L162:
        r112.f118420d = false;
        goto L164
    L158:
        if (this.f107836h2.containsKey(r112.f118421e) == false) goto L162;
        HSImageView r166 = (HSImageView) ((LinkedHashMap) this.f107836h2).get(r112.f118421e);
        if (r166 == null) goto L162;
        UtilityKotlinExtentionsKt.t(r166);
    L163:
        r129 = r109;
        r128 = r108;
        goto L164
    }

    public final void n(float r100, float r101) {
        setMThumbRadius(r100);
        this.f107845o = r101;
        if (r101 >= 0) goto L5;
        this.f107845o = this.f107844n * 2;
    L5:
        this.f107852s = this.f107845o;
        float r102 = this.f107844n;
        this.f107851r = r102;
        this.P0 = r102;
        this.V0 = this.f107853t;
        this.f107825b1 = r102;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.C == false) goto L5;
        float r102 = this.f107853t;
    L6:
        this.f107840k0 = r102;
        int r103 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), r101);
        int r104 = ((((int) this.f107840k0) * 2) + getPaddingTop()) + getPaddingBottom();
        if (r103 >= r104) goto L9;
        r103 = r104;
    L9:
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), r100), r103);
        this.K = getPaddingLeft() + this.f107840k0;
        float r105 = (getMeasuredWidth() - getPaddingRight()) - this.f107840k0;
        this.L = r105;
        this.E = r105 - this.K;
        return;
    L5:
        r102 = this.f107844n;
        goto L6
    }

    public PlayerSeekBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f107859x = true;
        this.f107862y = true;
        this.C = true;
        this.G = 1;
        this.M = Float.MAX_VALUE;
        this.N = Float.MAX_VALUE;
        this.f107832g1 = CollectionsKt.emptyList();
        this.f107841k1 = 10;
        this.f107848p1 = UtilityKotlinExtentionsKt.i(10);
        this.f107856v1 = true;
        this.H1 = true;
        this.M1 = 100;
        this.S1 = true;
        this.T1 = true;
        this.f107836h2 = new LinkedHashMap();
        this.f107849p2 = new ArrayList();
        this.f107857v2 = UtilityKotlinExtentionsKt.h(8.0f);
        this.f107864y2 = LazyKt.lazy(PlayerSeekBar$mCd$2.INSTANCE);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_background_progress_color, R.attr.ttlive_measure_depend_on_dragging_radius, R.attr.ttlive_progress_height, R.attr.ttlive_progress_slide_height, R.attr.ttlive_round_point_style, R.attr.ttlive_secondary_progress_color, R.attr.ttlive_thumb_color, R.attr.ttlive_thumb_height, R.attr.ttlive_thumb_outer_stroke_color, R.attr.ttlive_thumb_radius, R.attr.ttlive_thumb_radius_on_dragging, R.attr.ttlive_track_color, R.attr.ttlive_track_color_end, R.attr.ttlive_track_color_slide}, r102, 0);
        this.f107843m = r103.getColor(6, s1.h(R.color.commonui_white));
        setMThumbRadius(r103.getDimensionPixelSize(9, 15));
        float r104 = this.f107844n;
        this.f107846p = r104;
        this.f107851r = r104;
        float r105 = r103.getDimensionPixelSize(7, -1);
        this.f107845o = r105;
        if (r105 >= 0) goto L5;
        this.f107845o = this.f107844n * 2;
    L5:
        float r106 = this.f107845o;
        this.f107850q = r106;
        this.f107852s = r106;
        this.f107853t = r103.getDimensionPixelSize(10, 20);
        int r107 = r103.getDimensionPixelSize(2, (int) UIUtils.dip2Px(r100, 1.0f));
        this.f107828d = r107;
        this.f107829e = r103.getDimensionPixelSize(3, r107);
        int r108 = r103.getColor(11, s1.h(R.color.ttlive_button_color_red));
        this.f107830f = r108;
        this.f107831g = r103.getColor(13, r108);
        this.f107834h = r103.getColor(12, 0);
        this.f107854u = r103.getColor(8, 0);
        this.f107839k = r103.getColor(5, s1.h(R.color.commonui_white));
        this.f107842l = r103.getColor(0, s1.h(R.color.commonui_white));
        this.f107855v = r103.getBoolean(4, false);
        this.C = r103.getBoolean(1, true);
        r103.recycle();
        Paint r109 = new Paint(1);
        this.f107847p0 = r109;
        r109.setStyle(Paint.Style.FILL_AND_STROKE);
        this.G1 = this.f107828d;
        float r110 = this.f107844n;
        this.P0 = r110;
        this.V0 = this.f107853t;
        this.f107825b1 = r110;
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

    public /* synthetic */ PlayerSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void e(Canvas r110, float r111, float r112, float r113) {
        float r100 = r113 / 2;
        this.f107847p0.setStrokeWidth(0.0f);
        r110.drawArc(new RectF(r111 - r100, r112 - r100, r111 + r100, r112 + r100), 90.0f, 180.0f, true, this.f107847p0);
        this.f107847p0.setStrokeWidth(r113);
    }

    public final void d(Canvas r110, float r210, float r211, float r212, float r213) {
        float r100 = r213 / 2;
        this.f107847p0.setStrokeWidth(0.0f);
        float r101 = r212 - r100;
        float r111 = r212 + r100;
        r110.drawArc(new RectF(r210 - r100, r101, r210 + r100, r111), 90.0f, 180.0f, true, this.f107847p0);
        r110.drawArc(new RectF(r211 - r100, r101, r211 + r100, r111), -90.0f, 180.0f, true, this.f107847p0);
        this.f107847p0.setStrokeWidth(r213);
    }

    public final void l(long r110, long r210, boolean r211, boolean r212, long r213) {
        int r100 = this.M1;
        if (r100 == 100) goto L5;
        float r101 = r110;
    L10:
        if (this.f107823a != r101) goto L12;
        return;
    L12:
        float r102 = r100;
        if (r101 <= r102) goto L16;
        r101 = r102;
    L16:
        if (r101 >= 0) goto L18;
        r101 = 0.0f;
    L18:
        this.f107823a = r101;
        b r103 = this.f107863y1;
        if (r103 == null) goto L21;
        r103.n8(this, r101, r211, 0.0f);
    L21:
        if (r211 == true) goto L23;
    L56:
        if (r212 == false) goto L71;
        invalidate();
        return;
    L71:
        return;
    L23:
        if (this.F == true) goto L56;
        List<com.bytedance.android.livesdk.chatroom.vsplayer.model.e> r104 = this.f107832g1;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L26:
        if (r106.hasNext() == false) goto L30;
        Object r107 = r106.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r107).f118430n == false) goto L26;
        r105.add(r107);
        goto L26
    L30:
        List r108 = CollectionsKt.reversed(r105);
        if ((!r108.isEmpty()) == false) goto L56;
        Iterator r109 = r108.iterator();
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r111 = null;
    L34:
        if (r109.hasNext() == false) goto L44;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r112 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r109.next();
        long r113 = r112.f118423g;
        long r114 = r112.f118424h;
        long r115 = 20000;
        if (Math.abs(r113 - r114) >= r115) goto L39;
        r114 = r114 + r115;
    L39:
        if (r113 > r110) goto L34;
        if (r114 < r110) goto L34;
        r111 = r112;
        goto L34
    L44:
        if (r111 != null) goto L46;
    L50:
        if (r111 != null) goto L56;
        if (this.H == false) goto L56;
        this.H = false;
        b r116 = this.f107863y1;
        if (r116 == null) goto L56;
        r116.lg(this, false, r111);
        goto L56
    L46:
        if (this.H == true) goto L50;
        this.H = true;
        b r117 = this.f107863y1;
        if (r117 == null) goto L50;
        r117.lg(this, true, r111);
        goto L50
    L5:
        if (r210 <= 0) goto L7;
        r101 = (((r110 - r213) * 1.0f) / (r210 - r213)) * 100;
        goto L10
    L7:
        r101 = 0.0f;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        HSImageView r105 = this.f107833g2;
        float r106 = 2;
        float r107 = (getPaddingTop() / r106) + (getMeasuredHeight() / r106);
        int r108 = s1.f(24.0f);
        if (r105 == null) goto L9;
        float r109 = this.D;
        float r110 = r108;
        r105.layout((int) (r109 - r110), (int) (r107 - r110), (int) (r109 + r110), (int) (r107 + r110));
        return;
    }

    public static /* synthetic */ void m(PlayerSeekBar r110, long r111, long r112, boolean r113, boolean r114, long r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r116 & 8) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r116 & 16) == 0) goto L13;
        long r102 = 0;
    L14:
        r110.l(r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public final void p(float r100, float r101, float r102, float r110, float r111, float r112, int r113, int r114) {
        AnimatorSet r103 = this.L1;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        this.L1 = new AnimatorSet();
        ArrayList r104 = new ArrayList();
        if (this.f107862y == false) goto L9;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r105.setInterpolator(new DecelerateInterpolator(1.5f));
        r105.addUpdateListener(new d(this, r104));
        r104.add(r105);
        Unit r106 = Unit.INSTANCE;
    L9:
        if (this.W == true) goto L11;
    L17:
        AnimatorSet r107 = this.L1;
        if (r107 == null) goto L22;
        AnimatorSet r108 = r107.setDuration(200);
        if (r108 == null) goto L22;
        r108.playTogether(r104);
    L22:
        AnimatorSet r109 = this.L1;
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
