package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010!\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u001a¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/ui/LikeEggView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a;", "", "action", "setFinishAction", "", ce.f26391f, "Z", "isRunning", "()Z", "setRunning", "(Z)V", "Landroid/view/animation/Animation;", RXScreenCaptureService.KEY_INDEX, "Lkotlin/Lazy;", "getInAnimation", "()Landroid/view/animation/Animation;", "inAnimation", ce.f26395j, "getOutAnimation", "outAnimation", "Lcom/facebook/drawee/interfaces/DraweeController;", "l", "getPrepareWebpController", "()Lcom/facebook/drawee/interfaces/DraweeController;", "prepareWebpController", "m", "getPrepareToActiveController", "prepareToActiveController", OfficeSDKRequestTag.KEY_NEW_USER, "getActiveWebpController", "activeWebpController", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LikeEggProgressBar f139986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f139987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f139988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f139989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f139990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f139991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f139992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f139993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f139994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f139995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> f139996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f139997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f139998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f139999n;

    public static final class a {
    }

    static {
    }

    public LikeEggView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LikeEggView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final DraweeController getActiveWebpController() {
        return (DraweeController) this.f139999n.getValue();
    }

    private final Animation getInAnimation() {
        return (Animation) this.f139994i.getValue();
    }

    private final Animation getOutAnimation() {
        return (Animation) this.f139995j.getValue();
    }

    private final DraweeController getPrepareToActiveController() {
        return (DraweeController) this.f139998m.getValue();
    }

    private final DraweeController getPrepareWebpController() {
        return (DraweeController) this.f139997l.getValue();
    }

    public final void f() {
        ValueAnimator r100 = this.f139990e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f139991f;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        Animation r102 = getInAnimation();
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        Animation r103 = getOutAnimation();
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        clearAnimation();
        this.f139992g = false;
        setVisibility(8);
    }

    public static final /* synthetic */ DraweeController a(LikeEggView r100) {
        return r100.getActiveWebpController();
    }

    public static final void c(LikeEggView r100) {
        if (r100.f139993h == 0) goto L17;
        r100.f139993h = 0;
        HSImageView r101 = r100.f139987b;
        if (r101 == null) goto L7;
        UtilityKotlinExtentionsKt.z(r101, true);
    L7:
        HSImageView r102 = r100.f139987b;
        if (r102 == null) goto L10;
        r102.setController(null);
    L10:
        HSImageView r103 = r100.f139988c;
        if (r103 == null) goto L13;
        UtilityKotlinExtentionsKt.A(r103, false);
    L13:
        HSImageView r104 = r100.f139988c;
        if (r104 == null) goto L18;
        r104.setController(null);
        return;
    L18:
        return;
    }

    public final void e(final com.bytedance.android.livesdk.chatroom.likeegg.a r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f139992g = true;
        Function0<Unit> r101 = new LikeEggView$enter$1(this, r100);
        LikeEggView$enter$2 r102 = LikeEggView$enter$2.INSTANCE;
        Animation r103 = getInAnimation();
        if (r103 == null) goto L5;
        r103.setAnimationListener(new g(r103, r102, r101));
    L6:
        if (r103 == null) goto L9;
        clearAnimation();
        startAnimation(r103);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setFinishAction(Function1<? super com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> r100) {
        this.f139996k = r100;
    }

    public final void setRunning(boolean r100) {
        this.f139992g = r100;
    }

    public static final Animation b(LikeEggView r100, int r101) {
        r100.getClass();
        Animation r102 = AnimationUtils.loadAnimation(r100.getRootView().getContext(), r101);     // Catch: Exception -> L5
    L7:
        if (r102 == null) goto L9;
        r102.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
    L9:
        return r102;
    L5:
        e = move-exception;
        ALogger.e("LikeEggView", "load anim error-" + e);
        r102 = null;
        goto L7
    }

    public static final void d(final LikeEggView r100, final com.bytedance.android.livesdk.chatroom.likeegg.a r110) {
        int r101 = r100.f139993h;
        boolean r102 = true;
        Animation r103 = null;
        if (r101 == 0) goto L67;
        if (r101 != 1) goto L6;
        ALogger.d("LikeEggView", "change state to active, duration: " + r110.duration);
        r100.f139993h = 2;
        HSImageView r104 = r100.f139987b;
        if (r104 == null) goto L30;
        UtilityKotlinExtentionsKt.A(r104, true);
    L30:
        HSImageView r105 = r100.f139988c;
        if (r105 == null) goto L33;
        UtilityKotlinExtentionsKt.A(r105, false);
    L33:
        HSImageView r106 = r100.f139987b;
        if (r106 == null) goto L36;
        r106.setController(r100.getPrepareToActiveController());
    L36:
        HSImageView r107 = r100.f139988c;
        if (r107 == null) goto L39;
        r107.setController(null);
    L39:
        TextView r108 = r100.f139989d;
        if (r108 == null) goto L52;
        String r109 = r110.content;
        if (r109 != null) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == false) goto L50;
        String r112 = "合力点赞解锁惊喜彩蛋";
    L51:
        r108.setText(r112);
        goto L52
    L50:
        r112 = r110.content;
        goto L51
    L44:
        if (r109.length() == 0) goto L47;
        r111 = false;
    L52:
        TextView r113 = r100.f139989d;
        if (r113 == null) goto L55;
        a1.m(r113, UtilityKotlinExtentionsKt.i(2));
    L55:
        LikeEggProgressBar r114 = r100.f139986a;
        if (r114 == null) goto L58;
        r114.setProgress(0);
    L58:
        LikeEggProgressBar r115 = r100.f139986a;
        if (r115 == null) goto L61;
        r115.setProgressBackgroundColor(ColorProtector.parseColor("#33BA0021"));
    L61:
        ValueAnimator r116 = r100.f139990e;
        if (r116 != null) goto L64;
    L66:
        ValueAnimator r117 = ValueAnimator.ofInt(new int[]{0, 10100});
        r117.setDuration(r110.duration);
        r117.setInterpolator(new DecelerateInterpolator());
        r117.addUpdateListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui.a(r100));
        r117.addListener(new b(r100, r110));
        r117.start();
        Unit r118 = Unit.INSTANCE;
        r100.f139990e = r117;
        r100.postDelayed(new c(r100, r110), r110.duration);
        return;
    L64:
        if (r116.isRunning() != true) goto L66;
        return;
    L6:
        if (r101 == 2) goto L14;
        if (r101 != 3) goto L106;
        Function0<Unit> r119 = new LikeEggView$exit$1(r100, r110);
        Animation r120 = r100.getOutAnimation();
        if (r120 == null) goto L12;
        r120.setAnimationListener(new h(r120, r119, null));
        r103 = r120;
    L12:
        if (r103 == null) goto L102;
        r100.clearAnimation();
        r100.startAnimation(r103);
        return;
    L102:
        return;
    L106:
        return;
    L14:
        ALogger.d("LikeEggView", "change state to end, duration: " + r110.finishDuration);
        r100.f139993h = 3;
        LikeEggProgressBar r121 = r100.f139986a;
        if (r121 == null) goto L17;
        r121.setProgress(10000);
    L17:
        LikeEggProgressBar r122 = r100.f139986a;
        if (r122 == null) goto L20;
        r122.setProgressBackgroundColor(ColorProtector.parseColor("#66FF3055"));
    L20:
        TextView r123 = r100.f139989d;
        if (r123 == null) goto L23;
        r123.postDelayed(new f(r100, r110), 250);
    L23:
        ValueAnimator r124 = r100.f139991f;
        if (r124 == null) goto L26;
        r124.cancel();
    L26:
        ValueAnimator r125 = ValueAnimator.ofInt(new int[]{UtilityKotlinExtentionsKt.i(62), UtilityKotlinExtentionsKt.i(12)});
        r125.setDuration(500);
        r125.setInterpolator(new PathInterpolator(0.84f, 0.0f, 0.16f, 1.0f));
        r125.addUpdateListener(new d(r100));
        r125.addListener(new e(r100));
        r125.start();
        Unit r126 = Unit.INSTANCE;
        r100.f139991f = r125;
        r100.postDelayed(new k(r100, r110), r110.finishDuration);
        return;
    L67:
        ALogger.d("LikeEggView", "change state to prepare, duration: " + r110.prepareDuration);
        r100.f139993h = 1;
        HSImageView r127 = r100.f139987b;
        if (r127 == null) goto L70;
        UtilityKotlinExtentionsKt.A(r127, true);
    L70:
        HSImageView r128 = r100.f139988c;
        if (r128 == null) goto L73;
        UtilityKotlinExtentionsKt.A(r128, false);
    L73:
        HSImageView r129 = r100.f139987b;
        if (r129 == null) goto L76;
        r129.setController(r100.getPrepareWebpController());
    L76:
        HSImageView r130 = r100.f139988c;
        if (r130 == null) goto L79;
        r130.setController(null);
    L79:
        TextView r131 = r100.f139989d;
        if (r131 == null) goto L91;
        String r132 = r110.prepareContent;
        if (r132 != null) goto L84;
    L87:
        if (r102 == false) goto L89;
        String r133 = "即将进入点赞彩蛋时刻";
    L90:
        r131.setText(r133);
        goto L91
    L89:
        r133 = r110.prepareContent;
        goto L90
    L84:
        if (r132.length() == 0) goto L87;
        r102 = false;
    L91:
        TextView r134 = r100.f139989d;
        if (r134 == null) goto L94;
        a1.m(r134, UtilityKotlinExtentionsKt.i(2));
    L94:
        LikeEggProgressBar r135 = r100.f139986a;
        if (r135 == null) goto L97;
        r135.setProgress(0);
    L97:
        LikeEggProgressBar r136 = r100.f139986a;
        if (r136 == null) goto L100;
        r136.setProgressBackgroundColor(ColorProtector.parseColor("#33BA0021"));
    L100:
        r100.postDelayed(new j(r100, r110), r110.prepareDuration);
    }

    public LikeEggView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_digg_easter, this, true);
        this.f139986a = (LikeEggProgressBar) findViewById(R.id.progress_bar);
        this.f139987b = (HSImageView) findViewById(R.id.digg_title_icon);
        this.f139988c = (HSImageView) findViewById(R.id.digg_title_icon_active);
        this.f139989d = (TextView) findViewById(R.id.digg_text);
        setVisibility(8);
        this.f139994i = LazyKt.lazy(new LikeEggView$inAnimation$2(this));
        this.f139995j = LazyKt.lazy(new LikeEggView$outAnimation$2(this));
        this.f139997l = LazyKt.lazy(LikeEggView$prepareWebpController$2.INSTANCE);
        this.f139998m = LazyKt.lazy(new LikeEggView$prepareToActiveController$2(this, r100));
        this.f139999n = LazyKt.lazy(new LikeEggView$activeWebpController$2(this));
    }

    public /* synthetic */ LikeEggView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
