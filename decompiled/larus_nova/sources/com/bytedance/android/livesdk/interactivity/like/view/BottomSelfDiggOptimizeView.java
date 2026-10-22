package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
import com.bytedance.android.livesdk.interactivity.like.utils.LikeAnimUtil;
import com.bytedance.android.livesdk.interactivity.like.w0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\r\u000e\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/BottomSelfDiggOptimizeView;", "Lcom/bytedance/android/livesdk/widget/opt/MeasureOptFrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/z;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSelfDiggOptimizeView extends MeasureOptFrameLayout implements z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f137764h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<w0> f137765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f137766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPool f137767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Path> f137768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f137769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f137770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f137771g;

    public static final class a {
    }

    public final class b implements w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f137772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f137773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ValueAnimator f137774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q4.b f137775d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImageView f137776e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d0 f137777f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f137778g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ BottomSelfDiggOptimizeView f137779h;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            if (this.f137773b.booleanValue() == true) goto L10;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r100 = this.f137774c;
            if (r100 == null) goto L14;
            r100.cancel();
            return;
        L14:
            return;
        L10:
            q4.b r101 = this.f137775d;
            if (r101 == null) goto L16;
            r101.a();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
            if (this.f137773b.booleanValue() == true) goto L10;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r100 = this.f137774c;
            if (r100 == null) goto L14;
            r100.pause();
            return;
        L14:
            return;
        L10:
            q4.b r101 = this.f137775d;
            if (r101 == null) goto L16;
            r101.f159140a.f159132c.pause();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
            if (this.f137773b.booleanValue() == true) goto L10;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r100 = this.f137774c;
            if (r100 == null) goto L14;
            r100.resume();
            return;
        L14:
            return;
        L10:
            q4.b r101 = this.f137775d;
            if (r101 == null) goto L16;
            r101.f159140a.f159132c.resume();
            return;
        }

        public b(BottomSelfDiggOptimizeView r110, Bitmap r210, PointF r211, PointF r212, d0 r213, long r214) {
            Intrinsics.checkNotNullParameter(r210, "iconBitmap");
            Intrinsics.checkNotNullParameter(r211, "startPoint");
            Intrinsics.checkNotNullParameter(r212, "endPoint");
            Intrinsics.checkNotNullParameter(r213, "styleInfo");
            this.f137779h = r110;
            this.f137777f = r213;
            this.f137778g = r214;
            Boolean r100 = (Boolean) InteractivityOpt.c(eg.f120123a);
            this.f137773b = r100;
            long r101 = System.nanoTime();
            int r111 = r213.f137928i;
            int r112 = r213.f137929j;
            float r113 = r213.f137931l;
            float r114 = r213.f137930k;
            float r115 = r213.f137932m;
            float r102 = r213.f137933n;
            ImageView r116 = r110.f137767c.a();
            int r103 = 0;
            if (r116 != null) goto L5;
            r116 = new ImageView(r110.getContext());
            r116.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r110.addView(r116, new ViewGroup.LayoutParams(r111, r112));
            r116.layout(0, 0, r111, r112);
        L5:
            r116.setImageBitmap(r210);
            r116.getLayoutParams().height = r112;
            r116.getLayoutParams().width = r111;
            r116.setRotation(r115);
            r116.setScaleX(r113);
            r116.setScaleY(r113);
            r116.setAlpha(r114);
            r116.setTranslationZ(r102);
            this.f137776e = r116;
            if (r100.booleanValue() == true) goto L19;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L19;
            long r117 = r213.f137935p;
            Ref.IntRef r104 = new Ref.IntRef();
            r104.element = 0;
            this.f137772a = 0.0f;
            ImageView r118 = this.f137776e;
            if (r118 == null) goto L13;
            r118.setAlpha(r110.f137771g / 255.0f);
        L13:
            PropertyValuesHolder[] r105 = new PropertyValuesHolder[3];
            Keyframe r106 = Keyframe.ofObject(1.0f, r212);
            r106.setInterpolator(r213.f137934o);
            Unit r107 = Unit.INSTANCE;
            PropertyValuesHolder r108 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r211), r106});
            r108.setEvaluator(new r82.b());
            r105[0] = r108;
            Keyframe r109 = Keyframe.ofFloat(250.0f / r117, 1.0f);
            r109.setInterpolator((TimeInterpolator) LikeAnimUtil.f137709a.getValue());
            r105[1] = PropertyValuesHolder.ofKeyframe("iconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), r109, Keyframe.ofFloat(1.0f, 1.0f)});
            if (r110.f137770f == false) goto L16;
            PropertyValuesHolder r119 = (PropertyValuesHolder) LikeAnimUtil.f137713e.getValue();
        L17:
            r105[2] = r119;
            ValueAnimator r120 = ValueAnimator.ofPropertyValuesHolder(r105);
            r120.setDuration(r117);
            r120.setInterpolator(new LinearInterpolator());
            r120.addUpdateListener(new com.bytedance.android.livesdk.interactivity.like.view.b(this, r117, r104));
            r120.addListener(new com.bytedance.android.livesdk.interactivity.like.view.c(this, r104));
            r120.setStartDelay(r214);
            r120.start();
            this.f137774c = r120;
            Boolean r121 = com.bytedance.android.livesdk.interactivity.like.utils.k.f137744a;
            com.bytedance.android.livesdk.interactivity.like.utils.k.f137747d += System.nanoTime() - r101;
            com.bytedance.android.livesdk.interactivity.like.utils.k.f137748e++;
            return;
        L16:
            r119 = (PropertyValuesHolder) LikeAnimUtil.f137712d.getValue();
        L19:
            if ((!((ArrayList) r110.f137768d).isEmpty()) == false) goto L22;
        L24:
            long r122 = this.f137778g;
            long r123 = this.f137777f.f137935p;
            com.bytedance.android.livesdk.interactivity.like.utils.a r124 = new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, 1.0f, 0.0f, 250.0f / r123);
            com.bytedance.android.livesdk.interactivity.like.utils.a r125 = new com.bytedance.android.livesdk.interactivity.like.utils.a(this.f137779h.f137771g, 0.0f, 0.75f, 1.0f);
            ImageView r126 = this.f137776e;
            if (r126 == null) goto L27;
            r126.setAlpha(this.f137779h.f137771g / 255.0f);
        L27:
            q4.b r127 = u4.b(true, new BottomSelfDiggOptimizeView$OthersLikeAnimation$createFrameAnimator$1(this, r123, r122, r124, r125));
            this.f137775d = r127;
            r127.c();
            return;
        L22:
            if (r103 >= 5) goto L24;
            int r128 = Random.Default.nextInt(-16, 16);
            int r129 = g.f137940b;
            Path r130 = new Path();
            float r131 = r128;
            r130.moveTo(s1.f(41.0f) + r131, s1.f(200.0f));
            r130.quadTo((s1.f(41.0f) + r131) - (r129 / 2), s1.f(150.0f) / 2, s1.f(41.0f) + r131, s1.f(112.0f));
            ((ArrayList) r110.f137768d).add(r130);
            r103 = r103 + 1;
            goto L22
        }
    }

    public final class c implements w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f137780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f137781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ValueAnimator f137782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f137783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImageView f137784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d0 f137785f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ BottomSelfDiggOptimizeView f137786g;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            this.f137782c.cancel();
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
            this.f137782c.pause();
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
            this.f137782c.resume();
        }

        public final ImageView a(Bitmap r100, int r101, int r102, float r103, float r104, float r105, float r110) {
            ImageView r106 = this.f137786g.f137767c.a();
            if (r106 != null) goto L5;
            r106 = new ImageView(this.f137786g.getContext());
            r106.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f137786g.addView(r106, new ViewGroup.LayoutParams(r101, r102));
            r106.layout(0, 0, r101, r102);
        L5:
            r106.setImageBitmap(r100);
            r106.getLayoutParams().height = r102;
            r106.getLayoutParams().width = r101;
            r106.setRotation(r105);
            r106.setScaleX(r103);
            r106.setScaleY(r103);
            r106.setAlpha(r104);
            r106.setTranslationZ(r110);
            return r106;
        }

        public c(BottomSelfDiggOptimizeView r210, Bitmap r211, PointF r212, PointF r213, d0 r214, boolean r310, Bitmap r311, long r312, int r313) {
            if ((r313 & 16) == 0) goto L5;
            boolean r110 = false;
        L7:
            if ((r313 & 32) == 0) goto L9;
            Bitmap r100 = null;
        L11:
            if ((r313 & 64) == 0) goto L13;
            long r101 = 0;
        L14:
            Intrinsics.checkNotNullParameter(r211, "iconBitmap");
            Intrinsics.checkNotNullParameter(r212, "startPoint");
            Intrinsics.checkNotNullParameter(r213, "endPoint");
            Intrinsics.checkNotNullParameter(r214, "styleInfo");
            this.f137786g = r210;
            this.f137785f = r214;
            this.f137780a = 1.0f;
            if (r100 == null) goto L17;
            long r111 = r101;
            this.f137783d = a(r100, r214.f137920a, r214.f137921b, r214.f137923d, r214.f137922c, r214.f137924e, r214.f137925f);
        L18:
            this.f137784e = a(r211, r214.f137928i, r214.f137929j, r214.f137931l, r214.f137930k, r214.f137932m, r214.f137933n);
            long r102 = r214.f137935p;
            Random.Default r103 = Random.Default;
            long r104 = r103.nextLong(250, 500);
            if (r110 == false) goto L21;
            int r105 = r103.nextInt(100, 200);
            int r112 = BottomSelfDiggOptimizeView.f137764h;
            r210.getClass();
            long r113 = ((long) (r105 / 2)) + r104;
            Keyframe r114 = Keyframe.ofObject(1.0f, r213);
            r114.setInterpolator(r214.f137926g);
            Unit r115 = Unit.INSTANCE;
            PropertyValuesHolder r106 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r212), r114});
            r106.setEvaluator(new r82.b());
            float r107 = r104;
            float r108 = 1000;
            float r116 = r107 / r108;
            float r117 = (50 + r107) / r108;
            Keyframe r109 = Keyframe.ofFloat(r117, 1.3f);
            r109.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r118 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r116, 1.0f), r109, Keyframe.ofFloat(1.0f, 1.3f)};
            float r119 = 255;
            Keyframe r120 = Keyframe.ofInt((75 + r107) / r108, 0);
            r120.setInterpolator(r214.f137927h);
            Keyframe[] r121 = {Keyframe.ofInt(0.0f, (int) (r214.f137922c * r119)), Keyframe.ofInt(r116, (int) (r214.f137922c * r119)), r120, Keyframe.ofInt(1.0f, 0)};
            Keyframe r122 = Keyframe.ofFloat(r117, 1.1f);
            r122.setInterpolator(LikeAnimUtil.a());
            float r123 = 100 + r107;
            float r124 = r123 / r108;
            Keyframe r125 = Keyframe.ofFloat(r124, 0.9f);
            r125.setInterpolator(LikeAnimUtil.a());
            Keyframe r126 = Keyframe.ofFloat((r123 + 1) / r108, 1.1f);
            r126.setInterpolator(LikeAnimUtil.a());
            Keyframe r127 = Keyframe.ofFloat((r107 + 200) / r108, 1.0f);
            r127.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r128 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r116, 1.0f), r122, r125, r126, r127, Keyframe.ofFloat(1.0f, 1.0f)};
            Keyframe r129 = Keyframe.ofInt(r124, r210.f137771g);
            r129.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r130 = {Keyframe.ofInt(0.0f, 0), Keyframe.ofInt(r117, 0), r129, Keyframe.ofInt(1.0f, r210.f137771g)};
            Keyframe r131 = Keyframe.ofInt(r113 / r108, r210.f137771g);
            r131.setInterpolator(new DecelerateInterpolator());
            ValueAnimator r132 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r106, (PropertyValuesHolder) LikeAnimUtil.f137714f.getValue(), (PropertyValuesHolder) LikeAnimUtil.f137715g.getValue(), PropertyValuesHolder.ofKeyframe("selfScale", r118), PropertyValuesHolder.ofKeyframe("selfAlpha", r121), PropertyValuesHolder.ofKeyframe("iconScale", r128), PropertyValuesHolder.ofKeyframe("iconAlpha", r130), PropertyValuesHolder.ofKeyframe("iconAlpha2", new Keyframe[]{Keyframe.ofInt(0.0f, r210.f137771g), r131, Keyframe.ofInt(1.0f, 0)})});
            r132.setDuration(1000);
            r132.addUpdateListener(new d(this, r104, r113));
            ValueAnimator r133 = r132;
            long r134 = r102;
        L28:
            r133.setDuration(r134);
            r133.setInterpolator(new LinearInterpolator());
            r133.addListener(new f(this));
            r133.setStartDelay(r111);
            r133.start();
            this.f137782c = r133;
            return;
        L21:
            this.f137780a = 0.0f;
            ImageView r135 = this.f137783d;
            if (r135 == null) goto L24;
            r135.setAlpha(0.0f);
        L24:
            this.f137781b = 0.0f;
            ImageView r136 = this.f137784e;
            if (r136 == null) goto L27;
            r136.setAlpha(r210.f137771g / 255.0f);
        L27:
            Keyframe r137 = Keyframe.ofObject(1.0f, r213);
            r137.setInterpolator(r214.f137934o);
            Unit r138 = Unit.INSTANCE;
            PropertyValuesHolder r139 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r212), r137});
            r139.setEvaluator(new r82.a());
            r134 = r102;
            float r140 = r134;
            Keyframe r141 = Keyframe.ofFloat(250.0f / r140, 1.0f);
            r141.setInterpolator((TimeInterpolator) LikeAnimUtil.f137709a.getValue());
            Keyframe[] r142 = {Keyframe.ofFloat(0.0f, 0.0f), r141, Keyframe.ofFloat(1.0f, 1.0f)};
            Keyframe r143 = Keyframe.ofInt(1.0f, 0);
            r143.setInterpolator(LikeAnimUtil.a());
            r133 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r139, PropertyValuesHolder.ofKeyframe("iconScale", r142), PropertyValuesHolder.ofKeyframe("iconAlpha", new Keyframe[]{Keyframe.ofInt(0.0f, r210.f137771g), Keyframe.ofInt((r134 - (r134 / ((long) 4))) / r140, r210.f137771g), r143})});
            r133.setDuration(r134);
            r133.addUpdateListener(new e(this, r134));
            goto L28
        L17:
            r111 = r101;
            goto L18
        L13:
            r101 = r312;
            goto L14
        L9:
            r100 = r311;
            goto L11
        L5:
            r110 = r310;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<w0> r100 = this.f137765a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        w0 r101 = r100.next();
        r100.remove();
        r101.clear();
        goto L4
    }

    public BottomSelfDiggOptimizeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f137765a = new LinkedList();
        this.f137766b = q0.f472049a.getValue().diggHWEnable;
        this.f137767c = new ViewPool(DiggABHelper.a().b());
        this.f137768d = new ArrayList(0);
        this.f137771g = 75;
    }

    public BottomSelfDiggOptimizeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
        this.f137765a = new LinkedList();
        this.f137766b = q0.f472049a.getValue().diggHWEnable;
        this.f137767c = new ViewPool(DiggABHelper.a().b());
        this.f137768d = new ArrayList(0);
        this.f137771g = 75;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
    }

    public BottomSelfDiggOptimizeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101, r102);
        this.f137765a = new LinkedList();
        this.f137766b = q0.f472049a.getValue().diggHWEnable;
        this.f137767c = new ViewPool(DiggABHelper.a().b());
        this.f137768d = new ArrayList(0);
        this.f137771g = 75;
    }

    public final void b(Bitmap r110, PointF r111, PointF r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "iconBitmap");
        Intrinsics.checkNotNullParameter(r111, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r112, "endPointOnScreen");
        List<w0> r100 = this.f137765a;
        LinkedList r101 = (LinkedList) r100;
        r101.add(new b(this, r110, r111, r112, g.a(7), r113));
    }

    public final void c(Bitmap r110, Bitmap r111, PointF r112, PointF r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "selfBitmap");
        Intrinsics.checkNotNullParameter(r111, "iconBitmap");
        Intrinsics.checkNotNullParameter(r112, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r113, "endPointOnScreen");
        List<w0> r115 = this.f137765a;
        LinkedList r116 = (LinkedList) r115;
        r116.add(new c(this, r111, r112, r113, g.a(r114), true, r110, 0, 64));
    }

    public final void d(Bitmap r110, PointF r111, PointF r112, int r113, long r114) {
        Intrinsics.checkNotNullParameter(r110, "iconBitmap");
        Intrinsics.checkNotNullParameter(r111, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r112, "endPointOnScreen");
        List<w0> r115 = this.f137765a;
        LinkedList r116 = (LinkedList) r115;
        r116.add(new c(this, r110, r111, r112, g.a(r113), false, null, r114, 48));
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r100, PointF r101, PointF r102, int r103, float r104, f32.i r105) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r102, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r105, "degradeConfigV2");
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r102, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r105, "degradeConfigV2");
    }
}
