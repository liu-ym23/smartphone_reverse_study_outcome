package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: p, reason: collision with root package name */
    private int f21657p;

    /* renamed from: q, reason: collision with root package name */
    private Context f21658q;

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean B(int i5, int i6) throws Resources.NotFoundException {
        int id;
        int childCount = getChildCount();
        View view = null;
        boolean z5 = false;
        int i7 = 0;
        while (true) {
            int i8 = 8;
            if (i7 < childCount) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == g.f.f16931m || id == g.f.f16933o)) {
                    if (view != null) {
                        return false;
                    }
                    view = childAt;
                }
                i7++;
            } else {
                if (view == null) {
                    return false;
                }
                int iMin = Math.min(this.f21657p, View.MeasureSpec.getSize(i6));
                int mode = View.MeasureSpec.getMode(i5);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int dimensionPixelOffset = iMin - paddingTop;
                int childCount2 = getChildCount();
                int i9 = 0;
                int iCombineMeasuredStates = 0;
                while (true) {
                    if (i9 >= childCount2) {
                        boolean z6 = z5;
                        view.measure(i5, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() > dimensionPixelOffset) {
                            return z6;
                        }
                        int measuredHeight = paddingTop + view.getMeasuredHeight();
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        int i10 = z6 ? 1 : 0;
                        int iMax = i10;
                        while (i10 < childCount) {
                            View childAt2 = getChildAt(i10);
                            if (childAt2.getVisibility() != 8) {
                                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
                            }
                            i10++;
                        }
                        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i5, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight, i6, z6 ? 1 : 0));
                        if (mode != 1073741824) {
                            l(childCount, i6);
                        }
                        return true;
                    }
                    boolean z7 = z5;
                    View childAt3 = getChildAt(i9);
                    if (childAt3.getVisibility() != i8 && childAt3 != view) {
                        if (childAt3.getLayoutParams().height == -1) {
                            childAt3.measure(i5, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, 1073741824));
                        } else if (childAt3.getLayoutParams().height == -2) {
                            boolean z8 = this.f21658q.getResources().getConfiguration().orientation != 2 ? z7 : true;
                            if (childAt3.getId() == g.f.f16918F && z8) {
                                dimensionPixelOffset = this.f21658q.getResources().getDimensionPixelOffset(X4.d.f5875L);
                            }
                            if (childAt3.getId() == g.f.f16929k && z8) {
                                dimensionPixelOffset = this.f21658q.getResources().getDimensionPixelOffset(X4.d.f5866C);
                            }
                            childAt3.measure(i5, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        } else {
                            childAt3.measure(i5, View.MeasureSpec.makeMeasureSpec(childAt3.getLayoutParams().height, 1073741824));
                        }
                        paddingTop += childAt3.getMeasuredHeight();
                        int i11 = iMin - paddingTop;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt3.getMeasuredState());
                        if (i11 <= 0) {
                            return z7;
                        }
                        dimensionPixelOffset = i11;
                    }
                    i9++;
                    z5 = z7;
                    i8 = 8;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3d
            android.view.View r3 = r9.getChildAt(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r1 = (androidx.appcompat.widget.LinearLayoutCompat.a) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L36
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L38
        L36:
            r2 = r9
            r6 = r11
        L38:
            int r0 = r0 + 1
            r9 = r2
            r11 = r6
            goto Lb
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSAlertDialogLayout.l(int, int):void");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (B(i5, i6)) {
            return;
        }
        super.onMeasure(i5, i6);
    }

    public void setMaxHeight(int i5) {
        this.f21657p = i5;
        requestLayout();
    }

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21657p = Integer.MAX_VALUE;
        this.f21658q = context;
    }
}
