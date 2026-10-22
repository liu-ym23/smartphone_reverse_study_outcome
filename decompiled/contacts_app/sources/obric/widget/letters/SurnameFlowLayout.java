package obric.widget.letters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SurnameFlowLayout extends ViewGroup {
    private static final String TAG = "FlowLayout";
    private List<List<View>> mAllViews;
    private List<Integer> mLineHeight;

    public SurnameFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAllViews = new ArrayList();
        this.mLineHeight = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ViewGroup.MarginLayoutParams(p);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r1 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int r3 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r4 = View.MeasureSpec.getMode(heightMeasureSpec);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r1 + SimContactsConstants.EMAIL_SEP + r2);
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r6 >= r5) goto L12;
        View r11 = getChildAt(r6);
        measureChild(r11, widthMeasureSpec, heightMeasureSpec);
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        int r16 = r2;
        int r15 = (r11.getMeasuredWidth() + r14.leftMargin) + r14.rightMargin;
        int r12 = (r11.getMeasuredHeight() + r14.topMargin) + r14.bottomMargin;
        int r13 = r7 + r15;
        if (r13 <= r1) goto L7;
        r8 = Math.max(r7, r15);
        r10 = r10 + r9;
        r9 = r12;
        r7 = r15;
    L9:
        if (r6 != (r5 - 1)) goto L11;
        r10 = r10 + r9;
        r8 = Math.max(r8, r7);
    L11:
        r6 = r6 + 1;
        r2 = r16;
        goto L3
    L7:
        r9 = Math.max(r9, r12);
        r7 = r13;
        goto L9
    L12:
        int r17 = r2;
        if (r3 == 1073741824) goto L16;
        r1 = r8;
    L16:
        if (r4 != 1073741824) goto L18;
        int r18 = r17;
    L19:
        setMeasuredDimension(r1, r18);
        return;
    L18:
        r18 = r10;
        goto L19
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        SurnameFlowLayout r0 = this;
        r0.mAllViews.clear();
        r0.mLineHeight.clear();
        int r1 = getWidth();
        ArrayList r2 = new ArrayList();
        int r3 = getChildCount();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r5 >= r3) goto L8;
        View r8 = r0.getChildAt(r5);
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r10 = r8.getMeasuredWidth();
        int r11 = r8.getMeasuredHeight();
        if ((((r9.leftMargin + r10) + r9.rightMargin) + r7) <= r1) goto L7;
        r0.mLineHeight.add(Integer.valueOf(r6));
        r0.mAllViews.add(r2);
        r2 = new ArrayList();
        r7 = 0;
    L7:
        r7 = r7 + ((r10 + r9.leftMargin) + r9.rightMargin);
        r6 = Math.max(r6, (r11 + r9.topMargin) + r9.bottomMargin);
        r2.add(r8);
        r5 = r5 + 1;
        goto L3
    L8:
        r0.mLineHeight.add(Integer.valueOf(r6));
        r0.mAllViews.add(r2);
        int r4 = r0.mAllViews.size();
        int r12 = 0;
        int r13 = 0;
    L9:
        if (r12 >= r4) goto L19;
        List<View> r14 = r0.mAllViews.get(r12);
        int r15 = r0.mLineHeight.get(r12).intValue();
        int r16 = 0;
        int r17 = 0;
    L12:
        if (r16 >= r14.size()) goto L18;
        View r18 = r14.get(r16);
        if (r18.getVisibility() == 8) goto L17;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18.getLayoutParams();
        int r110 = r19.leftMargin + r17;
        int r111 = r19.topMargin + r13;
        int r112 = r18.getMeasuredWidth() + r110;
        int r113 = r18.getMeasuredHeight() + r111;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r18 + " , l = " + r110 + " , t = " + t + " , r =" + r112 + " , b = " + r113);
        r18.layout(r110, r111, r112, r113);
        r17 = r17 + ((r18.getMeasuredWidth() + r19.rightMargin) + r19.leftMargin);
    L17:
        r16 = r16 + 1;
        goto L12
    L18:
        r13 = r13 + r15;
        r12 = r12 + 1;
        r0 = this;
        goto L9
    }
}
