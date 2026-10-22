package com.stepos.widget.list;

import B6.a;
import H4.o;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import w6.AbstractC2104a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/stepos/widget/list/StepOSListGroup;", "Landroid/widget/LinearLayout;", "", "mode", "LC7/r;", "setBackgroundMode", "(I)V", "", "px", "setGroupCornerRadius", "(F)V", TypedValues.Custom.S_COLOR, "setGroupColor", "(Ljava/lang/Integer;)V", "", "show", "setShowDividers", "(Z)V", "setDividerColor", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSListGroup extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f4110a;
    public float b;
    public Integer c;
    public final int d;
    public boolean e;
    public final a f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.steposListGroupStyle);
        k.f(context, "context");
        this.e = true;
        a aVar = new a();
        this.f = aVar;
        setOrientation(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2104a.e, R.attr.steposListGroupStyle, R.style.StepOSWidget_ListGroup);
        k.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f4110a = typedArrayObtainStyledAttributes.getInt(0, 0);
        this.b = typedArrayObtainStyledAttributes.getDimension(2, resources.getDimension(R.dimen.stepos_list_group_corner_radius));
        this.c = typedArrayObtainStyledAttributes.hasValue(1) ? Integer.valueOf(typedArrayObtainStyledAttributes.getColor(1, 0)) : null;
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, resources.getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical));
        this.e = typedArrayObtainStyledAttributes.getBoolean(8, true);
        aVar.f195a = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.stepos_divider_height));
        aVar.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start));
        aVar.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end));
        aVar.b = typedArrayObtainStyledAttributes.getColor(3, context.getColor(R.color.stepos_divider));
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        a();
    }

    public static boolean b(View view) {
        if (view == null || !view.isPressed()) {
            return false;
        }
        StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
        return stepOSListItem != null ? stepOSListItem.getI() : true;
    }

    public final void a() throws Resources.NotFoundException {
        if (this.f4110a == 1) {
            setBackground(null);
            setClipToOutline(false);
            int i = this.d;
            setPadding(0, i, 0, i);
            return;
        }
        Integer num = this.c;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.b);
        gradientDrawable.setColor(iIntValue);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        setPadding(0, 0, 0, 0);
        c();
    }

    public final void c() throws Resources.NotFoundException {
        int i;
        float[] fArr;
        if (this.f4110a == 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof StepOSListItem) && ((StepOSListItem) childAt).getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Integer num = this.c;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        float f = this.b;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical);
        int i10 = 0;
        for (Object obj : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.X();
                throw null;
            }
            StepOSListItem stepOSListItem = (StepOSListItem) obj;
            if (size == 1) {
                i = 0;
                fArr = new float[]{f, f, f, f, f, f, f, f};
            } else {
                i = 0;
                fArr = i10 == 0 ? new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f} : i10 == size + (-1) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            stepOSListItem.d(fArr, iIntValue, false, (size == 1 || i10 == 0) ? dimensionPixelSize : i, (size == 1 || i10 == size + (-1)) ? dimensionPixelSize : i);
            i10 = i11;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        View childAt;
        k.f(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.e) {
            a aVar = this.f;
            if (aVar.f195a <= 0) {
                return;
            }
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (-1 < childCount) {
                    if (getChildAt(childCount).getVisibility() != 8) {
                        break;
                    }
                } else {
                    childCount = -1;
                    break;
                }
            }
            int childCount2 = getChildCount();
            for (int i = 0; i < childCount2 && i != childCount; i++) {
                View childAt2 = getChildAt(i);
                if (childAt2.getVisibility() != 8) {
                    int i6 = i + 1;
                    int childCount3 = getChildCount();
                    while (true) {
                        if (i6 >= childCount3) {
                            childAt = null;
                            break;
                        }
                        childAt = getChildAt(i6);
                        if (childAt.getVisibility() != 8) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (!b(childAt2) && !b(childAt)) {
                        int dividerInsetStart = childAt2 instanceof StepOSListItem ? ((StepOSListItem) childAt2).getDividerInsetStart() : aVar.c;
                        int i10 = aVar.c;
                        aVar.c = dividerInsetStart;
                        a.a(aVar, canvas, childAt2.getBottom() - aVar.f195a, getWidth(), getLayoutDirection());
                        aVar.c = i10;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) throws Resources.NotFoundException {
        super.onViewAdded(view);
        c();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) throws Resources.NotFoundException {
        super.onViewRemoved(view);
        c();
    }

    public final void setBackgroundMode(int mode) throws Resources.NotFoundException {
        this.f4110a = mode;
        a();
    }

    public final void setDividerColor(int color) {
        this.f.b = color;
        invalidate();
    }

    public final void setGroupColor(Integer color) throws Resources.NotFoundException {
        this.c = color;
        a();
    }

    public final void setGroupCornerRadius(float px) throws Resources.NotFoundException {
        this.b = px;
        a();
    }

    public final void setShowDividers(boolean show) {
        this.e = show;
        invalidate();
    }
}
