package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.a.c.j;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.a.c.a mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        super.setVisibility(8);
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void setType(int r1) {
        this.mIndicatedType = r1;
    }

    private void updateType(androidx.constraintlayout.a.c.e r6, int r7, boolean r8) {
        this.mResolvedType = r7;
        if (Build.VERSION.SDK_INT >= 17) goto L9;
        int r9 = this.mIndicatedType;
        if (r9 != 5) goto L7;
        this.mResolvedType = 0;
    L21:
        if (ZeusTransformUtils.instanceOf(r6, androidx.constraintlayout.a.c.a.class) == false) goto L24;
        ((androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r6, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin")).a(this.mResolvedType);
        return;
    L24:
        return;
    L7:
        if (r9 != 6) goto L21;
        this.mResolvedType = 1;
        goto L21
    L9:
        if (r8 == false) goto L15;
        int r10 = this.mIndicatedType;
        if (r10 != 5) goto L13;
        this.mResolvedType = 1;
        goto L21
    L13:
        if (r10 != 6) goto L21;
        this.mResolvedType = 0;
        goto L21
    L15:
        int r11 = this.mIndicatedType;
        if (r11 != 5) goto L18;
        this.mResolvedType = 0;
        goto L21
    L18:
        if (r11 != 6) goto L21;
        this.mResolvedType = 1;
        goto L21
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(androidx.constraintlayout.a.c.e r2, boolean r3) {
        updateType(r2, this.mIndicatedType, r3);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r9);
        this.mBarrier = new androidx.constraintlayout.a.c.a();
        if (r9 == null) goto L17;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierDirection, "styleable", "ConstraintLayout_Layout_barrierDirection")) goto L10;
        setType(r10.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets, "styleable", "ConstraintLayout_Layout_barrierAllowsGoneWidgets")) goto L13;
        this.mBarrier.a(r10.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierMargin, "styleable", "ConstraintLayout_Layout_barrierMargin")) goto L15;
        this.mBarrier.b(r10.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r10.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mBarrier.a(r1);
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.c();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.c();
    }

    public void setDpMargin(int r2) {
        this.mBarrier.b((int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f));
    }

    public int getMargin() {
        return this.mBarrier.g();
    }

    public void setMargin(int r1) {
        this.mBarrier.b(r1);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(c.a r2, j r3, ConstraintLayout.LayoutParams r4, SparseArray<androidx.constraintlayout.a.c.e> r5) {
        super.loadParameters(r2, r3, r4, r5);
        if (ZeusTransformUtils.instanceOf(r3, androidx.constraintlayout.a.c.a.class) == false) goto L6;
        androidx.constraintlayout.a.c.a r6 = (androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r3, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        boolean r7 = ((androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r3.A(), androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin")).ag();
        updateType(r6, r2.f977e.ah, r7);
        r6.a(r2.f977e.ap);
        r6.b(r2.f977e.ai);
        return;
    }
}
