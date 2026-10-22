package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface CircularRevealWidget extends b.a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<a> {
        public static final TypeEvaluator<a> CIRCULAR_REVEAL = null;
        private final a revealInfo;

        public CircularRevealEvaluator() {
            this.revealInfo = new a(null);
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ a evaluate(float r3, a r4, a r5) {
            return evaluate2(r3, (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin"));
        }

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public a evaluate2(float r5, a r6, a r7) {
            this.revealInfo.a(com.google.android.material.e.a.a(r6.f13295a, r7.f13295a, r5), com.google.android.material.e.a.a(r6.f13296b, r7.f13296b, r5), com.google.android.material.e.a.a(r6.f13297c, r7.f13297c, r5));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, a> {
        public static final Property<CircularRevealWidget, a> CIRCULAR_REVEAL = null;

        @Override // android.util.Property
        public /* synthetic */ a get(CircularRevealWidget r3) {
            return get2((CircularRevealWidget) ZeusTransformUtils.preCheckCast(r3, CircularRevealWidget.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.util.Property
        public /* synthetic */ void set(CircularRevealWidget r3, a r4) {
            set2((CircularRevealWidget) ZeusTransformUtils.preCheckCast(r3, CircularRevealWidget.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r2) {
            super(a.class, r2);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public a get2(CircularRevealWidget r2) {
            return ((CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r2, CircularRevealWidget.class, "com.obric.aiagent.plugin")).getRevealInfo();
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r2, a r3) {
            ((CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r2, CircularRevealWidget.class, "com.obric.aiagent.plugin")).setRevealInfo(r3);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        @Override // android.util.Property
        public /* synthetic */ Integer get(CircularRevealWidget r3) {
            return get2((CircularRevealWidget) ZeusTransformUtils.preCheckCast(r3, CircularRevealWidget.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.util.Property
        public /* synthetic */ void set(CircularRevealWidget r3, Integer r4) {
            set2((CircularRevealWidget) ZeusTransformUtils.preCheckCast(r3, CircularRevealWidget.class, "com.obric.aiagent.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin"));
        }

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r2) {
            super(Integer.class, r2);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(CircularRevealWidget r2) {
            return Integer.valueOf(((CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r2, CircularRevealWidget.class, "com.obric.aiagent.plugin")).getCircularRevealScrimColor());
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r2, Integer r3) {
            ((CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r2, CircularRevealWidget.class, "com.obric.aiagent.plugin")).setCircularRevealScrimColor(r3.intValue());
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13297c;

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private a() {
        }

        public a(float r1, float r2, float r3) {
            this.f13295a = r1;
            this.f13296b = r2;
            this.f13297c = r3;
        }

        public a(a r3) {
            this(r3.f13295a, r3.f13296b, r3.f13297c);
        }

        public void a(float r1, float r2, float r3) {
            this.f13295a = r1;
            this.f13296b = r2;
            this.f13297c = r3;
        }

        public void a(a r3) {
            a(r3.f13295a, r3.f13296b, r3.f13297c);
        }

        public boolean a() {
            if (this.f13297c != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    a getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable r1);

    void setCircularRevealScrimColor(int r1);

    void setRevealInfo(a r1);
}
