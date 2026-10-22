package com.stepos.widget.list;

import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.stepos.widget.R;
import com.stepos.widget.divider.StepOSDividerPainter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001BB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0015¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\"J\u001d\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0014¢\u0006\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00107R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/stepos/widget/list/StepOSListGroup;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "applyBackground", "()V", "refreshRowShapes", "lastVisibleChildIndex", "()I", "from", "Landroid/view/View;", "nextVisibleChild", "(I)Landroid/view/View;", "v", "", "pressHidesDivider", "(Landroid/view/View;)Z", "Lcom/stepos/widget/list/StepOSListItem;", "item", "addItem", "(Lcom/stepos/widget/list/StepOSListItem;)V", "child", "onViewAdded", "(Landroid/view/View;)V", "onViewRemoved", "mode", "setBackgroundMode", "(I)V", "", "px", "setGroupCornerRadius", "(F)V", "color", "setGroupColor", "(Ljava/lang/Integer;)V", "show", "setShowDividers", "(Z)V", "setDividerColor", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "setDividerInsets", "(II)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "backgroundMode", "I", "groupCornerRadius", "F", "overrideColor", "Ljava/lang/Integer;", "paddingVertical", "showDividers", "Z", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "dividerPainter", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSListGroup extends LinearLayout {
    public static final int MODE_CARD = 0;
    public static final int MODE_NONE = 1;
    private int backgroundMode;
    private final StepOSDividerPainter dividerPainter;
    private float groupCornerRadius;
    private Integer overrideColor;
    private int paddingVertical;
    private boolean showDividers;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    private final void applyBackground() throws Resources.NotFoundException {
        if (this.backgroundMode == 1) {
            setBackground(null);
            setClipToOutline(false);
            int i10 = this.paddingVertical;
            setPadding(0, i10, 0, i10);
            return;
        }
        Integer num = this.overrideColor;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.groupCornerRadius);
        gradientDrawable.setColor(iIntValue);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        setPadding(0, 0, 0, 0);
        refreshRowShapes();
    }

    private final int lastVisibleChildIndex() {
        int childCount = getChildCount();
        do {
            childCount--;
            if (-1 >= childCount) {
                return -1;
            }
        } while (getChildAt(childCount).getVisibility() == 8);
        return childCount;
    }

    private final View nextVisibleChild(int from) {
        int childCount = getChildCount();
        for (int i10 = from + 1; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                return childAt;
            }
        }
        return null;
    }

    private final boolean pressHidesDivider(View v10) {
        if (v10 == null || !v10.isPressed()) {
            return false;
        }
        StepOSListItem stepOSListItem = v10 instanceof StepOSListItem ? (StepOSListItem) v10 : null;
        return stepOSListItem != null ? stepOSListItem.getPressFeedbackEnabledField() : true;
    }

    private final void refreshRowShapes() throws Resources.NotFoundException {
        int i10;
        float[] fArr;
        if (this.backgroundMode == 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof StepOSListItem) && ((StepOSListItem) childAt).getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Integer num = this.overrideColor;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        float f10 = this.groupCornerRadius;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical);
        int i12 = 0;
        for (Object obj : arrayList) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                C1173v.w();
            }
            StepOSListItem stepOSListItem = (StepOSListItem) obj;
            if (size == 1) {
                i10 = 0;
                fArr = new float[]{f10, f10, f10, f10, f10, f10, f10, f10};
            } else {
                i10 = 0;
                fArr = i12 == 0 ? new float[]{f10, f10, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f} : i12 == size + (-1) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, f10, f10, f10, f10} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            stepOSListItem.applyCardChrome(fArr, iIntValue, false, (size == 1 || i12 == 0) ? dimensionPixelSize : i10, (size == 1 || i12 == size + (-1)) ? dimensionPixelSize : i10);
            i12 = i13;
        }
    }

    public final void addItem(StepOSListItem item) {
        p.i(item, "item");
        addView(item, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!this.showDividers || this.dividerPainter.getThickness() <= 0) {
            return;
        }
        int iLastVisibleChildIndex = lastVisibleChildIndex();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount && i10 != iLastVisibleChildIndex; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                View viewNextVisibleChild = nextVisibleChild(i10);
                if (!pressHidesDivider(childAt) && !pressHidesDivider(viewNextVisibleChild)) {
                    int dividerInsetStart = childAt instanceof StepOSListItem ? ((StepOSListItem) childAt).getDividerInsetStart() : this.dividerPainter.getInsetStart();
                    int insetStart = this.dividerPainter.getInsetStart();
                    this.dividerPainter.setInsetStart$StepOSWidget_release(dividerInsetStart);
                    StepOSDividerPainter.drawInView$StepOSWidget_release$default(this.dividerPainter, canvas, childAt.getBottom() - this.dividerPainter.getThickness(), getWidth(), getLayoutDirection(), 0.0f, 16, null);
                    this.dividerPainter.setInsetStart$StepOSWidget_release(insetStart);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) throws Resources.NotFoundException {
        super.onViewAdded(child);
        refreshRowShapes();
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) throws Resources.NotFoundException {
        super.onViewRemoved(child);
        refreshRowShapes();
    }

    public final void setBackgroundMode(int mode) {
        this.backgroundMode = mode;
        applyBackground();
    }

    public final void setDividerColor(int color) {
        this.dividerPainter.setColor$StepOSWidget_release(color);
        invalidate();
    }

    public final void setDividerInsets(int start, int end) {
        this.dividerPainter.setInsetStart$StepOSWidget_release(start);
        this.dividerPainter.setInsetEnd$StepOSWidget_release(end);
        invalidate();
    }

    public final void setGroupColor(Integer color) throws Resources.NotFoundException {
        this.overrideColor = color;
        applyBackground();
    }

    public final void setGroupCornerRadius(float px) throws Resources.NotFoundException {
        this.groupCornerRadius = px;
        applyBackground();
    }

    public final void setShowDividers(boolean show) {
        this.showDividers = show;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSListGroup(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.steposListGroupStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.showDividers = true;
        StepOSDividerPainter stepOSDividerPainter = new StepOSDividerPainter();
        this.dividerPainter = stepOSDividerPainter;
        setOrientation(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSListGroup, i10, R.style.StepOSWidget_ListGroup);
        p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.backgroundMode = typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSListGroup_steposListGroupBackgroundMode, 0);
        this.groupCornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSListGroup_steposListGroupCornerRadius, resources.getDimension(R.dimen.stepos_list_group_corner_radius));
        int i11 = R.styleable.StepOSListGroup_steposListGroupColor;
        this.overrideColor = typedArrayObtainStyledAttributes.hasValue(i11) ? Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i11, 0)) : null;
        this.paddingVertical = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSListGroup_steposListGroupPaddingVertical, resources.getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical));
        this.showDividers = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSListGroup_steposListGroupShowDividers, true);
        stepOSDividerPainter.setThickness$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSListGroup_steposListGroupDividerHeight, resources.getDimensionPixelSize(R.dimen.stepos_divider_height)));
        stepOSDividerPainter.setInsetStart$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSListGroup_steposListGroupDividerInsetStart, resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start)));
        stepOSDividerPainter.setInsetEnd$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSListGroup_steposListGroupDividerInsetEnd, resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end)));
        stepOSDividerPainter.setColor$StepOSWidget_release(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSListGroup_steposListGroupDividerColor, context.getColor(R.color.stepos_divider)));
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        applyBackground();
    }
}
