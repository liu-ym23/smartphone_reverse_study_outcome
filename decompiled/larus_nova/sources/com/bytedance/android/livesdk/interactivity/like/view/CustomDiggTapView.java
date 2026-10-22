package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
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
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0011\u0012\u0013B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/CustomDiggTapView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/y;", "", "size", "", "setBitmapSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomDiggTapView extends FrameLayout implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f137796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPool f137797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f137798c;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosedFloatingPointRange<Float> f137799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f137800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f137801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f137802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f137803e;

        public final float a(float r100, TimeInterpolator r101) {
            float r102 = this.f137802d;
            float r103 = (r100 - r102) / (this.f137803e - r102);
            if (r101 == null) goto L5;
            r101.getInterpolation(r103);
        L5:
            float r104 = this.f137800b;
            return r104 + ((this.f137801c - r104) * r103);
        }

        public a(float r100, float r101, float r102, float r103) {
            this.f137800b = r100;
            this.f137801c = r101;
            this.f137802d = r102;
            this.f137803e = r103;
            this.f137799a = RangesKt.rangeTo(r102, r103);
        }
    }

    public static final class b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f137804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f137805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f137806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f137807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f137808e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ValueAnimator f137809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final q4.b f137810g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ CustomDiggTapView f137811h;

        public c(CustomDiggTapView r110, Bitmap r210, PointF r211, int r212, float r213) {
            Intrinsics.checkNotNullParameter(r210, SimplayerImageStrategy.RESULT_BITMAP);
            Intrinsics.checkNotNullParameter(r211, "startPointOnScreen");
            this.f137811h = r110;
            RectF r100 = new RectF();
            this.f137804a = 255;
            this.f137806c = 1.0f;
            Boolean r101 = eg.f120123a.getValue();
            this.f137808e = r101;
            ImageView r102 = r110.f137797b.a();
            this.f137807d = r102;
            if (r102 != null) goto L5;
            ImageView r103 = new ImageView(r110.getContext());
            this.f137807d = r103;
            r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int r111 = r110.f137798c;
            r110.addView(r103, new ViewGroup.LayoutParams(r111, r111));
        L5:
            ImageView r104 = this.f137807d;
            if (r104 == null) goto L8;
            r104.setTranslationZ(r212);
            r104.setImageBitmap(r210);
            r104.setRotation(r213);
            r104.setAlpha(1.0f);
        L8:
            float r105 = r211.x;
            float r106 = r110.f137798c / 2;
            float r112 = r105 - r106;
            r100.left = r112;
            float r113 = r211.y;
            r100.top = r113 - r106;
            r100.right = r105 + r106;
            r100.bottom = r113 + r106;
            ImageView r107 = this.f137807d;
            if (r107 == null) goto L12;
            r107.setTranslationX(r112);
            r107.setTranslationY(r211.y - (r110.f137798c / 2));
        L12:
            if (r101.booleanValue() == true) goto L17;
            q4.f159129j.getClass();
            if (q4.a.a() == true) goto L17;
            Ref.IntRef r108 = new Ref.IntRef();
            r108.element = 0;
            Keyframe r109 = Keyframe.ofFloat(0.23076923f, 1.5f);
            r109.setInterpolator(new AccelerateDecelerateInterpolator());
            Unit r114 = Unit.INSTANCE;
            Keyframe r115 = Keyframe.ofFloat(0.46153846f, 1.35f);
            r115.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe r116 = Keyframe.ofFloat(0.61538464f, 1.35f);
            r116.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe r117 = Keyframe.ofFloat(1.0f, 2.3f);
            r117.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe[] r118 = {Keyframe.ofFloat(0.0f, 0.0f), r109, r115, r116, r117};
            Keyframe r119 = Keyframe.ofFloat(0.23076923f, r213 - 8.0f);
            r119.setInterpolator(new LinearInterpolator());
            Keyframe r120 = Keyframe.ofFloat(0.46153846f, 3.0f + r213);
            r120.setInterpolator(new LinearInterpolator());
            Keyframe r121 = Keyframe.ofFloat(0.61538464f, r213);
            r121.setInterpolator(new LinearInterpolator());
            Keyframe[] r122 = {Keyframe.ofFloat(0.0f, r213), r119, r120, r121, Keyframe.ofFloat(1.0f, r213)};
            Keyframe r123 = Keyframe.ofInt(1.0f, 0);
            r123.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r124 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scale", r118), PropertyValuesHolder.ofKeyframe("rotate", r122), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofInt(0.0f, 255), Keyframe.ofInt(0.61538464f, 255), r123})});
            r124.setDuration(650);
            r124.setInterpolator(new LinearInterpolator());
            r124.addUpdateListener(new i(this, r108));
            r124.addListener(new j(this, r108));
            r124.start();
            this.f137809f = r124;
            return;
        L17:
            q4.b r125 = u4.b(true, new CustomDiggTapView$RunningAnimation$createFrameAnimator$1(this, new a(0.0f, 1.5f, 0.0f, 0.23076923f), new AccelerateDecelerateInterpolator(), new a(1.5f, 1.35f, 0.23076923f, 0.46153846f), new a(1.35f, 1.35f, 0.46153846f, 0.61538464f), new a(1.35f, 2.35f, 0.61538464f, 1.0f), new a(0.0f, -8.0f, 0.0f, 0.23076923f), new a(-8.0f, 3.0f, 0.23076923f, 0.46153846f), new a(3.0f, 0.0f, 0.46153846f, 0.61538464f), new a(255.0f, 2.0f, 0.61538464f, 1.0f)));
            this.f137810g = r125;
            r125.c();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<c> r100 = this.f137796a.iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        c r101 = r100.next();
        if (r101.f137808e.booleanValue() == true) goto L13;
        q4.f159129j.getClass();
        if (q4.a.a() == true) goto L13;
        ValueAnimator r102 = r101.f137809f;
        if (r102 == null) goto L16;
        r102.cancel();
    L16:
        r100.remove();
    L13:
        q4.b r103 = r101.f137810g;
        if (r103 == null) goto L16;
        r103.a();
        goto L16
    L17:
        ViewPool r104 = this.f137797b;
        if (r104 == null) goto L23;
        int r105 = r104.f136308b.length;
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L22;
        r104.f136308b[r106] = null;
        r106 = r106 + 1;
        goto L20
    L22:
        r104.f136309c = 0;
    L23:
        removeAllViews();
    }

    public CustomDiggTapView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f137796a = new ConcurrentLinkedQueue();
        this.f137797b = new ViewPool(5);
        this.f137798c = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.y
    public void setBitmapSize(float r100) {
        this.f137798c = (int) r100;
    }

    public CustomDiggTapView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
        this.f137796a = new ConcurrentLinkedQueue();
        this.f137797b = new ViewPool(5);
        this.f137798c = s1.f(42.0f);
    }

    public CustomDiggTapView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101, r102);
        this.f137796a = new ConcurrentLinkedQueue();
        this.f137797b = new ViewPool(5);
        this.f137798c = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r100, PointF r101, PointF r102, int r110, float r111, f32.i r112) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r102, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r112, "degradeConfigV2");
        this.f137796a.add(new c(this, r100, r101, r110, r111));
    }
}
