package com.bytedance.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.android.contacts.PinnedHeaderList.ContactsBlurHelper;
import com.android.contacts.R;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TopBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/filemanager/widget/TopBlurListContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blurConfig", "Lcom/bytedance/filemanager/widget/BlurConfig;", "blurHeight", "", "getBlurHeight", "()I", "blurRadius", "", "blurView", "Landroid/view/View;", "extraBlur", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initTypedArray", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopBlurListContainer extends FrameLayout {
    private final BlurConfig blurConfig;
    private float blurRadius;
    private View blurView;
    private int extraBlur;

    /* JADX WARN: Multi-variable type inference failed */
    public TopBlurListContainer(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TopBlurListContainer(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public TopBlurListContainer(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        this.extraBlur = MathKt.roundToInt(TypedValue.applyDimension(1, 36, Resources.getSystem().getDisplayMetrics()));
        BlurUtils.BlurType r2 = BlurUtils.BlurType.PROGRESS_BLUR_DOWN_UP;
        int[] r3 = getResources().getIntArray(R.array.oui_titlebar_blur_colors);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getIntArray(R.…oui_titlebar_blur_colors)");
        int[] r11 = getResources().getIntArray(R.array.oui_titlebar_blur_blend_modes);
        Intrinsics.checkNotNullExpressionValue(r11, "resources.getIntArray(R.…itlebar_blur_blend_modes)");
        ArrayList r0 = new ArrayList(r11.length);
        int r4 = r11.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        r0.add(ContactsBlurHelper.INSTANCE.mapToBlendMode(r11[r5]));
        r5 = r5 + 1;
        goto L3
    L5:
        this.blurConfig = new BlurConfig(0.0f, r2, r3, r0, 1, null);
        initTypedArray(r10);
    }

    public final int getBlurHeight() {
        View r0 = this.blurView;
        if (r0 == null) goto L7;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        return r1.height - this.extraBlur;
    L7:
        return 0;
    }

    private final void initTypedArray(AttributeSet r7) {
        TypedArray r8 = getContext().obtainStyledAttributes(r7, R.styleable.TopBlurListContainer);
        Intrinsics.checkNotNullExpressionValue(r8, "context.obtainStyledAttr…ble.TopBlurListContainer)");
        int r2 = 0;
        this.extraBlur += r8.getDimensionPixelSize(1, 0);
        if (r8.hasValue(0) == false) goto L6;
        this.blurRadius = r8.getFloat(0, 0.0f);
    L6:
        if (r8.hasValue(3) == true) goto L8;
    L18:
        r8.recycle();
        return;
    L8:
        if (r8.hasValue(2) == false) goto L18;
        int r0 = r8.getResourceId(3, R.array.oui_titlebar_blur_colors);
        int r1 = r8.getResourceId(2, R.array.oui_titlebar_blur_blend_modes);
        if (r0 == 0) goto L18;
        if (r1 == 0) goto L18;
        int[] r3 = getResources().getIntArray(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getIntArray(colorsResId)");
        int[] r4 = getResources().getIntArray(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "resources.getIntArray(modesResId)");
        if (r3.length != r4.length) goto L18;
        this.blurConfig.setColors(r3);
        BlurConfig r6 = this.blurConfig;
        ArrayList r5 = new ArrayList(r4.length);
        int r9 = r4.length;
    L15:
        if (r2 >= r9) goto L17;
        r5.add(ContactsBlurHelper.INSTANCE.mapToBlendMode(r4[r2]));
        r2 = r2 + 1;
        goto L15
    L17:
        r6.setBlendModes(r5);
        goto L18
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View r0 = new View(getContext());
        addView(r0, new FrameLayout.LayoutParams(-1, 0));
        this.blurConfig.setBlurRadius(this.blurRadius);
        ContactsBlurHelper.INSTANCE.setBackdropBlurEffect(r0, this.blurConfig);
        this.blurView = r0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        View r0 = this.blurView;
        if (r0 == null) goto L20;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        int r2 = OUnitExtensionKt.getRealScreenHeight(r1) - getHeight();
        boolean r3 = false;
        int r4 = Math.max(0, r2);
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if (r5 != null) goto L7;
    L9:
        if (r3 == true) goto L20;
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r8 == null) goto L14;
        r8.height = this.extraBlur + r4;
    L14:
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L18:
        if (r10 == null) goto L20;
        r10.topMargin = -r4;
        goto L20
    L17:
        r10 = null;
        goto L18
    L7:
        if (r5.height != (this.extraBlur + r4)) goto L9;
        r3 = true;
    L20:
        super.onMeasure(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        Iterator<View> r3 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        View r0 = r3.next();
        if (r0.getVisibility() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
        if ((r0 instanceof TopBlurList) == false) goto L4;
        TopBlurList r2 = (TopBlurList) r0;
        if (r2.getNeedDrawExtra() == false) goto L4;
        r4.save();
        r4.translate(r0.getLeft(), r0.getTop());
        r2.drawExtra(r4);
        r4.restore();
        goto L4
    L8:
        r1 = false;
        goto L9
    }
}
