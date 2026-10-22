package com.obric.structure.omvvm.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.structure.omvvm.core.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: QLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 $2\u00020\u0001:\u0005$%&'(B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linearHBottom", "Landroid/widget/LinearLayout;", "linearHNormal", "linearHTop", "linearVBottom", "linearVNormal", "linearVTop", "normalIndex", "getNormalIndex", "()I", "relativeBottom", "relativeTop", "views", "", "Landroid/view/View;", "addView", "", "child", "params", "Lcom/obric/structure/omvvm/core/widget/QLayout$LayoutParams;", "index", "qParams", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "generateLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "setLayoutParams", "Companion", "LayoutParams", "QLayerMode", "QLayoutMode", "QOrientationMode", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QLayout extends RelativeLayout {
    public static final Companion Companion = null;
    public static final int HORIZONTAL = 0;
    public static final int LAYER_BOTTOM = 2;
    public static final int LAYER_NORMAL = 0;
    public static final int LAYER_TOP = 1;
    public static final int LINEAR = 1;
    public static final int RELATIVE = 0;
    public static final int VERTICAL = 1;
    private LinearLayout linearHBottom;
    private LinearLayout linearHNormal;
    private LinearLayout linearHTop;
    private LinearLayout linearVBottom;
    private LinearLayout linearVNormal;
    private LinearLayout linearVTop;
    private RelativeLayout relativeBottom;
    private RelativeLayout relativeTop;
    private final List<View> views;

    /* JADX INFO: compiled from: QLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout$Companion;", "", "()V", "HORIZONTAL", "", "LAYER_BOTTOM", "LAYER_NORMAL", "LAYER_TOP", "LINEAR", "RELATIVE", "VERTICAL", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: QLayout.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR \u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout$LayoutParams;", "Landroid/widget/RelativeLayout$LayoutParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "(II)V", "layerMode", "getLayerMode$annotations", "()V", "getLayerMode", "()I", "setLayerMode", "(I)V", "layoutMode", "getLayoutMode$annotations", "getLayoutMode", "setLayoutMode", "orientationMode", "getOrientationMode$annotations", "getOrientationMode", "setOrientationMode", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LayoutParams extends RelativeLayout.LayoutParams {
        private int layerMode;
        private int layoutMode;
        private int orientationMode;

        public static /* synthetic */ void getLayerMode$annotations() {
        }

        public static /* synthetic */ void getLayoutMode$annotations() {
        }

        public static /* synthetic */ void getOrientationMode$annotations() {
        }

        public final int getLayoutMode() {
            return this.layoutMode;
        }

        public final void setLayoutMode(int r1) {
            this.layoutMode = r1;
        }

        public final int getOrientationMode() {
            return this.orientationMode;
        }

        public final void setOrientationMode(int r1) {
            this.orientationMode = r1;
        }

        public final int getLayerMode() {
            return this.layerMode;
        }

        public final void setLayerMode(int r1) {
            this.layerMode = r1;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3, r4);
            this.layoutMode = 1;
            this.orientationMode = 1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.QLayout);
            Intrinsics.checkNotNullExpressionValue(r5, "context.obtainStyledAttr…trs, R.styleable.QLayout)");
            this.layoutMode = r5.getInteger(R.styleable.QLayout_q_layout, 1);
            this.orientationMode = r5.getInteger(R.styleable.QLayout_q_orientation, 1);
            this.layerMode = r5.getInteger(R.styleable.QLayout_q_layer, 0);
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.layoutMode = 1;
            this.orientationMode = 1;
        }
    }

    /* JADX INFO: compiled from: QLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout$QLayerMode;", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface QLayerMode {
    }

    /* JADX INFO: compiled from: QLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout$QLayoutMode;", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface QLayoutMode {
    }

    /* JADX INFO: compiled from: QLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/structure/omvvm/core/widget/QLayout$QOrientationMode;", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface QOrientationMode {
    }

    static {
        Companion = new Companion(null);
    }

    public QLayout(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public QLayout(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public QLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.views = new ArrayList();
    }

    public /* synthetic */ QLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams r2 = getLayoutParams();
        if (r2 != null) goto L6;
        r2 = new LayoutParams(-2, -2);
    L6:
        return new LayoutParams(r2.width, r2.height);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r3, "attrs");
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        return new LayoutParams(r2, r3);
    }

    public final void addView(View r2, LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "params");
        super.addView(r2, r3);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof LayoutParams) == false) goto L7;
        LayoutParams r8 = (LayoutParams) r7;
    L8:
        if (r8 != null) goto L11;
        ViewGroup.LayoutParams r9 = generateDefaultLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.structure.omvvm.core.widget.QLayout.LayoutParams");
        r8 = (LayoutParams) r9;
    L11:
        if (r8.getLayoutMode() != 0) goto L25;
        int r10 = r8.getLayerMode();
        if (r10 == 0) goto L23;
        if (r10 == 2) goto L20;
        if (this.relativeTop != null) goto L18;
        RelativeLayout r11 = new RelativeLayout(getContext());
        this.relativeTop = r11;
        super.addView(r11, -1, generateDefaultLayoutParams());
    L18:
        RelativeLayout r4 = this.relativeBottom;
        Intrinsics.checkNotNull(r4);
        r4.addView(r5, r8);
        return;
    L20:
        if (this.relativeBottom != null) goto L22;
        RelativeLayout r12 = new RelativeLayout(getContext());
        this.relativeBottom = r12;
        super.addView(r12, 0, generateDefaultLayoutParams());
    L22:
        RelativeLayout r13 = this.relativeBottom;
        Intrinsics.checkNotNull(r13);
        r13.addView(r5, r8);
        return;
    L23:
        super.addView(r5, getNormalIndex(), r8);
        return;
    L25:
        if (r8.getOrientationMode() != 0) goto L41;
        int r14 = r8.getLayerMode();
        if (r14 == 0) goto L38;
        if (r14 == 2) goto L34;
        if (this.linearHTop != null) goto L32;
        LinearLayout r15 = new LinearLayout(getContext());
        this.linearHTop = r15;
        Intrinsics.checkNotNull(r15);
        r15.setOrientation(0);
        super.addView(this.linearHTop, -1, generateDefaultLayoutParams());
    L32:
        LinearLayout r16 = this.linearHTop;
        Intrinsics.checkNotNull(r16);
        r16.addView(r5, r8);
        return;
    L34:
        if (this.linearHBottom != null) goto L36;
        LinearLayout r17 = new LinearLayout(getContext());
        this.linearHBottom = r17;
        Intrinsics.checkNotNull(r17);
        r17.setOrientation(0);
        super.addView(this.linearHBottom, 0, generateDefaultLayoutParams());
    L36:
        LinearLayout r18 = this.linearHBottom;
        Intrinsics.checkNotNull(r18);
        r18.addView(r5, r8);
        return;
    L38:
        if (this.linearHNormal != null) goto L40;
        LinearLayout r19 = new LinearLayout(getContext());
        this.linearHNormal = r19;
        Intrinsics.checkNotNull(r19);
        r19.setOrientation(0);
        super.addView(this.linearHNormal, getNormalIndex(), generateDefaultLayoutParams());
    L40:
        LinearLayout r20 = this.linearHNormal;
        Intrinsics.checkNotNull(r20);
        r20.addView(r5, r8);
        return;
    L41:
        int r21 = r8.getLayerMode();
        if (r21 == 0) goto L53;
        if (r21 == 2) goto L49;
        if (this.linearVTop != null) goto L47;
        LinearLayout r22 = new LinearLayout(getContext());
        this.linearVTop = r22;
        Intrinsics.checkNotNull(r22);
        r22.setOrientation(1);
        super.addView(this.linearVTop, -1, generateDefaultLayoutParams());
    L47:
        LinearLayout r23 = this.linearVTop;
        Intrinsics.checkNotNull(r23);
        r23.addView(r5, r8);
        return;
    L49:
        if (this.linearVBottom != null) goto L51;
        LinearLayout r24 = new LinearLayout(getContext());
        this.linearVBottom = r24;
        Intrinsics.checkNotNull(r24);
        r24.setOrientation(1);
        super.addView(this.linearVBottom, 0, generateDefaultLayoutParams());
    L51:
        LinearLayout r25 = this.linearVBottom;
        Intrinsics.checkNotNull(r25);
        r25.addView(r5, r8);
        return;
    L53:
        if (this.linearVNormal != null) goto L55;
        LinearLayout r26 = new LinearLayout(getContext());
        this.linearVNormal = r26;
        Intrinsics.checkNotNull(r26);
        r26.setOrientation(1);
        super.addView(this.linearVNormal, getNormalIndex(), generateDefaultLayoutParams());
    L55:
        LinearLayout r27 = this.linearVNormal;
        Intrinsics.checkNotNull(r27);
        r27.addView(r5, r8);
        return;
    L7:
        r8 = null;
        goto L8
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r2) {
        super.setLayoutParams(r2);
        RelativeLayout r3 = this.relativeTop;
        if (r3 == null) goto L6;
        r3.setLayoutParams(generateDefaultLayoutParams());
    L6:
        RelativeLayout r4 = this.relativeBottom;
        if (r4 == null) goto L10;
        r4.setLayoutParams(generateDefaultLayoutParams());
    L10:
        LinearLayout r5 = this.linearHNormal;
        if (r5 == null) goto L14;
        r5.setLayoutParams(generateDefaultLayoutParams());
    L14:
        LinearLayout r6 = this.linearHTop;
        if (r6 == null) goto L18;
        r6.setLayoutParams(generateDefaultLayoutParams());
    L18:
        LinearLayout r7 = this.linearHBottom;
        if (r7 == null) goto L22;
        r7.setLayoutParams(generateDefaultLayoutParams());
    L22:
        LinearLayout r8 = this.linearVNormal;
        if (r8 == null) goto L26;
        r8.setLayoutParams(generateDefaultLayoutParams());
    L26:
        LinearLayout r9 = this.linearVTop;
        if (r9 == null) goto L30;
        r9.setLayoutParams(generateDefaultLayoutParams());
    L30:
        LinearLayout r10 = this.linearVBottom;
        if (r10 == null) goto L35;
        r10.setLayoutParams(generateDefaultLayoutParams());
        return;
    }

    private final int getNormalIndex() {
        int r0 = getChildCount();
        if (this.relativeTop == null) goto L6;
        r0 = r0 - 1;
    L6:
        if (this.linearHTop == null) goto L9;
        r0 = r0 - 1;
    L9:
        if (this.linearVTop != null) goto L11;
        return r0;
    L11:
        return r0 - 1;
    }
}
