package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
import com.bytedance.android.livesdk.interactivity.like.utils.LikeAnimUtil;
import com.bytedance.android.livesdk.interactivity.like.w0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\r\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/DiggTapOptimizeView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/z;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTapOptimizeView extends FrameLayout implements z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f137860d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f137861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPool f137862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f137863c;

    public static final class a {
    }

    public final class b implements w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f137864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f137865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f137866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f137867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f137868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ValueAnimator f137869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final q4.b f137870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final f32.i f137871h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ DiggTapOptimizeView f137872i;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            if (this.f137868e.booleanValue() == true) goto L10;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r100 = this.f137869f;
            if (r100 == null) goto L14;
            r100.cancel();
            return;
        L14:
            return;
        L10:
            q4.b r101 = this.f137870g;
            if (r101 == null) goto L16;
            r101.a();
            return;
        }

        public b(DiggTapOptimizeView r110, Bitmap r111, PointF r112, int r210, float r211, f32.i r212) {
            Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
            Intrinsics.checkNotNullParameter(r112, "startPointOnScreen");
            Intrinsics.checkNotNullParameter(r212, "degradeConfigV2");
            this.f137872i = r110;
            this.f137871h = r212;
            RectF r100 = new RectF();
            this.f137864a = 255;
            this.f137866c = 1.0f;
            Boolean r101 = (Boolean) InteractivityOpt.c(eg.f120123a);
            this.f137868e = r101;
            ImageView r102 = r110.f137862b.a();
            this.f137867d = r102;
            if (r102 != null) goto L5;
            ImageView r103 = new ImageView(r110.getContext());
            this.f137867d = r103;
            r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int r113 = DiggTapOptimizeView.f137860d;
            r110.addView(r103, new ViewGroup.LayoutParams(r113, r113));
            r103.layout(0, 0, r113, r113);
        L5:
            ImageView r104 = this.f137867d;
            if (r104 == null) goto L8;
            r104.setTranslationZ(r210);
            r104.setImageBitmap(r111);
            r104.setRotation(r211);
            r104.setAlpha(1.0f);
        L8:
            int r105 = -InteractivityOpt.a(36.0f);
            float r106 = r112.x;
            float r107 = DiggTapOptimizeView.f137860d / 2;
            float r114 = r106 - r107;
            r100.left = r114;
            float r115 = r112.y;
            float r108 = r105;
            r100.top = (r115 - r107) + r108;
            r100.right = r106 + r107;
            r100.bottom = (r115 + r107) + r108;
            ImageView r109 = this.f137867d;
            if (r109 == null) goto L12;
            r109.setTranslationX(r114);
            r109.setTranslationY((r112.y - r107) + r108);
        L12:
            if (r101.booleanValue() == true) goto L17;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L17;
            Ref.IntRef r116 = new Ref.IntRef();
            r116.element = 0;
            Keyframe r117 = Keyframe.ofFloat(0.23076923f, r211 - 8.0f);
            r117.setInterpolator(LikeAnimUtil.b());
            Unit r118 = Unit.INSTANCE;
            Keyframe r119 = Keyframe.ofFloat(0.46153846f, 3.0f + r211);
            r119.setInterpolator(LikeAnimUtil.b());
            Keyframe r120 = Keyframe.ofFloat(0.61538464f, r211);
            r120.setInterpolator(LikeAnimUtil.b());
            ValueAnimator r121 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{(PropertyValuesHolder) LikeAnimUtil.f137716h.getValue(), PropertyValuesHolder.ofKeyframe("rotate", new Keyframe[]{Keyframe.ofFloat(0.0f, r211), r117, r119, r120, Keyframe.ofFloat(1.0f, r211)}), (PropertyValuesHolder) LikeAnimUtil.f137717i.getValue()});
            r121.setDuration(650);
            r121.setInterpolator(new LinearInterpolator());
            r121.addUpdateListener(new t(this, r116));
            r121.addListener(new u(this, r116));
            r121.start();
            this.f137869f = r121;
            return;
        L17:
            q4.b r122 = u4.b(true, new DiggTapOptimizeView$RunningAnimation$createFrameAnimator$1(this, new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, 1.5f, 0.0f, 0.23076923f), new AccelerateDecelerateInterpolator(), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.5f, 1.35f, 0.23076923f, 0.46153846f), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.35f, 1.35f, 0.46153846f, 0.61538464f), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.35f, 2.35f, 0.61538464f, 1.0f), new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, -8.0f, 0.0f, 0.23076923f), new com.bytedance.android.livesdk.interactivity.like.utils.a(-8.0f, 3.0f, 0.23076923f, 0.46153846f), new com.bytedance.android.livesdk.interactivity.like.utils.a(3.0f, 0.0f, 0.46153846f, 0.61538464f), new com.bytedance.android.livesdk.interactivity.like.utils.a(255.0f, 2.0f, 0.61538464f, 1.0f)));
            this.f137870g = r122;
            r122.c();
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    static {
        f137860d = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<b> r100 = this.f137861a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clear();
        r100.remove();
        goto L4
    L6:
        ViewPool r101 = this.f137862b;
        if (r101 == null) goto L12;
        int r102 = r101.f136308b.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        r101.f136308b[r103] = null;
        r103 = r103 + 1;
        goto L9
    L11:
        r101.f136309c = 0;
    L12:
        removeAllViews();
    }

    public DiggTapOptimizeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f137861a = new ConcurrentLinkedQueue();
        this.f137862b = new ViewPool(5);
    }

    public DiggTapOptimizeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
        this.f137861a = new ConcurrentLinkedQueue();
        this.f137862b = new ViewPool(5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
    }

    public DiggTapOptimizeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101, r102);
        this.f137861a = new ConcurrentLinkedQueue();
        this.f137862b = new ViewPool(5);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r100, PointF r110, PointF r111, int r112, float r113, f32.i r114) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r110, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r111, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r114, "degradeConfigV2");
        this.f137861a.add(new b(this, r100, r110, r112, r113, r114));
    }
}
