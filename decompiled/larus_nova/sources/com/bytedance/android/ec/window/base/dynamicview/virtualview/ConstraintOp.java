package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/window/base/dynamicview/virtualview/ConstraintOp;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lkotlin/reflect/KMutableProperty1;", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "", "targetField", "Lkotlin/reflect/KMutableProperty1;", "getTargetField", "()Lkotlin/reflect/KMutableProperty1;", "LEFT_TO_LEFT", "LEFT_TO_RIGHT", "TOP_TO_TOP", "TOP_TO_BOTTOM", "RIGHT_TO_LEFT", "RIGHT_TO_RIGHT", "BOTTOM_TO_TOP", "BOTTOM_TO_BOTTOM", "START_TO_START", "START_TO_END", "END_TO_START", "END_TO_END", "BASELINE_TO_BASELINE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConstraintOp extends Enum<ConstraintOp> {
    public static final ConstraintOp BASELINE_TO_BASELINE = null;
    public static final ConstraintOp BOTTOM_TO_BOTTOM = null;
    public static final ConstraintOp BOTTOM_TO_TOP = null;
    public static final ConstraintOp END_TO_END = null;
    public static final ConstraintOp END_TO_START = null;
    public static final ConstraintOp LEFT_TO_LEFT = null;
    public static final ConstraintOp LEFT_TO_RIGHT = null;
    public static final ConstraintOp RIGHT_TO_LEFT = null;
    public static final ConstraintOp RIGHT_TO_RIGHT = null;
    public static final ConstraintOp START_TO_END = null;
    public static final ConstraintOp START_TO_START = null;
    public static final ConstraintOp TOP_TO_BOTTOM = null;
    public static final ConstraintOp TOP_TO_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintOp[] f49272a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f49273id;
    private final KMutableProperty1<ConstraintLayout.LayoutParams, Integer> targetField;

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(ConstraintLayout.LayoutParams.class, "leftToLeft", "getLeftToLeft()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).leftToLeft);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).leftToLeft = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$10, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass10 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass10();
        }

        public AnonymousClass10() {
            super(ConstraintLayout.LayoutParams.class, "startToEnd", "getStartToEnd()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).startToEnd);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).startToEnd = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$11, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass11 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass11();
        }

        public AnonymousClass11() {
            super(ConstraintLayout.LayoutParams.class, "endToStart", "getEndToStart()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).endToStart);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).endToStart = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$12, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass12 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass12();
        }

        public AnonymousClass12() {
            super(ConstraintLayout.LayoutParams.class, "endToEnd", "getEndToEnd()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).endToEnd);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).endToEnd = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$13, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass13 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass13();
        }

        public AnonymousClass13() {
            super(ConstraintLayout.LayoutParams.class, "baselineToBaseline", "getBaselineToBaseline()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).baselineToBaseline);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).baselineToBaseline = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(ConstraintLayout.LayoutParams.class, "leftToRight", "getLeftToRight()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).leftToRight);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).leftToRight = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass3 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(ConstraintLayout.LayoutParams.class, "topToTop", "getTopToTop()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).topToTop);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).topToTop = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass4 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(ConstraintLayout.LayoutParams.class, "topToBottom", "getTopToBottom()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).topToBottom);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).topToBottom = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$5, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass5 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
            super(ConstraintLayout.LayoutParams.class, "rightToLeft", "getRightToLeft()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).rightToLeft);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).rightToLeft = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$6, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass6 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(ConstraintLayout.LayoutParams.class, "rightToRight", "getRightToRight()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).rightToRight);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).rightToRight = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$7, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass7 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass7();
        }

        public AnonymousClass7() {
            super(ConstraintLayout.LayoutParams.class, "bottomToTop", "getBottomToTop()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).bottomToTop);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).bottomToTop = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$8, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass8 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(ConstraintLayout.LayoutParams.class, "bottomToBottom", "getBottomToBottom()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).bottomToBottom);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).bottomToBottom = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.ConstraintOp$9, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass9 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass9();
        }

        public AnonymousClass9() {
            super(ConstraintLayout.LayoutParams.class, "startToStart", "getStartToStart()I", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Integer.valueOf(((ConstraintLayout.LayoutParams) r100).startToStart);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object r100, Object r101) {
            int r102 = ((Number) r101).intValue();
            ((ConstraintLayout.LayoutParams) r100).startToStart = r102;
        }
    }

    public static ConstraintOp valueOf(String r100) {
        return (ConstraintOp) r27.a.a(ConstraintOp.class, r100);
    }

    public static ConstraintOp[] values() {
        return (ConstraintOp[]) f49272a.clone();
    }

    static {
        ConstraintOp r100 = new ConstraintOp("LEFT_TO_LEFT", 0, "left_to_left", AnonymousClass1.INSTANCE);
        LEFT_TO_LEFT = r100;
        ConstraintOp r101 = new ConstraintOp("LEFT_TO_RIGHT", 1, "left_to_right", AnonymousClass2.INSTANCE);
        LEFT_TO_RIGHT = r101;
        ConstraintOp r102 = new ConstraintOp("TOP_TO_TOP", 2, "top_to_top", AnonymousClass3.INSTANCE);
        TOP_TO_TOP = r102;
        ConstraintOp r103 = new ConstraintOp("TOP_TO_BOTTOM", 3, "top_to_bottom", AnonymousClass4.INSTANCE);
        TOP_TO_BOTTOM = r103;
        ConstraintOp r104 = new ConstraintOp("RIGHT_TO_LEFT", 4, "right_to_left", AnonymousClass5.INSTANCE);
        RIGHT_TO_LEFT = r104;
        ConstraintOp r105 = new ConstraintOp("RIGHT_TO_RIGHT", 5, "right_to_right", AnonymousClass6.INSTANCE);
        RIGHT_TO_RIGHT = r105;
        ConstraintOp r106 = new ConstraintOp("BOTTOM_TO_TOP", 6, "bottom_to_top", AnonymousClass7.INSTANCE);
        BOTTOM_TO_TOP = r106;
        ConstraintOp r107 = new ConstraintOp("BOTTOM_TO_BOTTOM", 7, "bottom_to_bottom", AnonymousClass8.INSTANCE);
        BOTTOM_TO_BOTTOM = r107;
        ConstraintOp r108 = new ConstraintOp("START_TO_START", 8, "start_to_start", AnonymousClass9.INSTANCE);
        START_TO_START = r108;
        ConstraintOp r109 = new ConstraintOp("START_TO_END", 9, "start_to_end", AnonymousClass10.INSTANCE);
        START_TO_END = r109;
        ConstraintOp r110 = new ConstraintOp("END_TO_START", 10, "end_to_start", AnonymousClass11.INSTANCE);
        END_TO_START = r110;
        ConstraintOp r111 = new ConstraintOp("END_TO_END", 11, "end_to_end", AnonymousClass12.INSTANCE);
        END_TO_END = r111;
        ConstraintOp r112 = new ConstraintOp("BASELINE_TO_BASELINE", 12, "baseline_to_baseline", AnonymousClass13.INSTANCE);
        BASELINE_TO_BASELINE = r112;
        f49272a = new ConstraintOp[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getId() {
        return this.f49273id;
    }

    public final KMutableProperty1<ConstraintLayout.LayoutParams, Integer> getTargetField() {
        return this.targetField;
    }

    public ConstraintOp(String r100, int r101, String r102, KMutableProperty1 r103) {
        super(r100, r101);
        this.f49273id = r102;
        this.targetField = r103;
    }
}
