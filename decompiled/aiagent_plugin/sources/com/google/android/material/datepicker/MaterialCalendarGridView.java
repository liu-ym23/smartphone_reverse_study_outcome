package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.internal.r;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AdapterView
    public /* synthetic */ void setAdapter(Adapter r3) {
        setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast((Adapter) ZeusTransformUtils.wrapperContextForParams(r3, Adapter.class, "com.obric.aiagent.plugin"), ListAdapter.class, "com.obric.aiagent.plugin"));
    }

    public MaterialCalendarGridView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialCalendarGridView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public MaterialCalendarGridView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        this.dayCompute = i.c();
        if (MaterialDatePicker.isFullscreen((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
        setNextFocusLeftId(ZeusTransformUtils.mapRes(R.id.cancel_button, DbHelper.COL_ID, "cancel_button"));
        setNextFocusRightId(ZeusTransformUtils.mapRes(R.id.confirm_button, DbHelper.COL_ID, "confirm_button"));
    L5:
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ViewCompat.a(this, new AnonymousClass1(this));
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r2) {
        if (r2 >= getAdapter().firstPositionInMonth()) goto L5;
        super.setSelection(getAdapter().firstPositionInMonth());
        return;
    L5:
        super.setSelection(r2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r4, KeyEvent r5) {
        if (super.onKeyDown(r4, r5) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) goto L15;
        if (19 != r4) goto L14;
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public MonthAdapter getAdapter() {
        return (MonthAdapter) ZeusTransformUtils.preCheckCast(super.getAdapter(), MonthAdapter.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r3) {
        ListAdapter r4 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MonthAdapter.class) == false) goto L7;
        super.setAdapter(r4);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r27) {
        MaterialCalendarGridView r0 = this;
        super.onDraw(r27);
        MonthAdapter r1 = getAdapter();
        DateSelector<?> r2 = r1.dateSelector;
        b r3 = r1.calendarStyle;
        int r4 = Math.max(r1.firstPositionInMonth(), getFirstVisiblePosition());
        int r5 = Math.min(r1.lastPositionInMonth(), getLastVisiblePosition());
        Long r6 = r1.getItem(r4);
        Long r7 = r1.getItem(r5);
        Iterator<androidx.core.util.e<Long, Long>> r8 = r2.getSelectedRanges().iterator();
    L4:
        if (r8.hasNext() == false) goto L53;
        androidx.core.util.e r9 = (androidx.core.util.e) ZeusTransformUtils.preCheckCast(r8.next(), androidx.core.util.e.class, "com.obric.aiagent.plugin");
        if (r9.f1371a != 0) goto L8;
        r0 = this;
        goto L4
    L8:
        if (r9.f1372b == 0) goto L4;
        long r11 = ((Long) ZeusTransformUtils.preCheckCast(r9.f1371a, Long.class, "com.obric.aiagent.plugin")).longValue();
        long r10 = ((Long) ZeusTransformUtils.preCheckCast(r9.f1372b, Long.class, "com.obric.aiagent.plugin")).longValue();
        if (skipMonth(r6, r7, Long.valueOf(r11), Long.valueOf(r10)) == true) goto L4;
        boolean r12 = r.a(this);
        if (r11 < r6.longValue()) goto L16;
        r0.dayCompute.setTimeInMillis(r11);
        int r13 = r1.dayToPosition(r0.dayCompute.get(5));
        int r14 = horizontalMidPoint(r0.getChildAtPosition(r13));
    L24:
        if (r10 > r7.longValue()) goto L26;
        r0.dayCompute.setTimeInMillis(r10);
        int r15 = r1.dayToPosition(r0.dayCompute.get(5));
        int r16 = horizontalMidPoint(r0.getChildAtPosition(r15));
    L33:
        int r17 = (int) r1.getItemId(r13);
        int r18 = r4;
        int r19 = r5;
        int r20 = (int) r1.getItemId(r15);
    L34:
        if (r17 > r20) goto L51;
        int r21 = getNumColumns() * r17;
        int r110 = (r21 + getNumColumns()) - 1;
        View r111 = r0.getChildAtPosition(r21);
        int r22 = r111.getTop() + r3.f13359a.a();
        MonthAdapter r112 = r1;
        int r23 = r111.getBottom() - r3.f13359a.b();
        if (r12 == true) goto L43;
        if (r21 <= r13) goto L39;
        int r24 = 0;
    L40:
        if (r15 <= r110) goto L42;
        int r113 = getWidth();
    L50:
        r27.drawRect(r24, r22, r113, r23, r3.h);
        r17 = r17 + 1;
        r0 = this;
        r8 = r8;
        r1 = r112;
        goto L34
    L42:
        r113 = r16;
        goto L50
    L39:
        r24 = r14;
        goto L40
    L43:
        if (r15 <= r110) goto L45;
        int r114 = 0;
    L46:
        if (r21 <= r13) goto L48;
        int r25 = getWidth();
    L49:
        int r26 = r114;
        r113 = r25;
        r24 = r26;
        goto L50
    L48:
        r25 = r14;
        goto L49
    L45:
        r114 = r16;
        goto L46
    L51:
        r0 = this;
        r4 = r18;
        r5 = r19;
        goto L4
    L26:
        if (r1.isLastInRow(r5) == false) goto L28;
        int r28 = getWidth();
    L31:
        r16 = r28;
        r15 = r5;
        goto L33
    L28:
        if (r12 == true) goto L30;
        r28 = r0.getChildAtPosition(r5).getRight();
        goto L31
    L30:
        r28 = r0.getChildAtPosition(r5).getLeft();
        goto L31
    L16:
        if (r1.isFirstInRow(r4) == false) goto L18;
        int r115 = 0;
    L21:
        r14 = r115;
        r13 = r4;
        goto L24
    L18:
        if (r12 == true) goto L20;
        r115 = r0.getChildAtPosition(r4 - 1).getRight();
        goto L21
    L20:
        r115 = r0.getChildAtPosition(r4 - 1).getLeft();
        goto L21
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.nestedScrollable == false) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        if (r1 == false) goto L4;
        gainFocus(r2, r3);
        return;
    L4:
        super.onFocusChanged(false, r2, r3);
    }

    private void gainFocus(int r2, Rect r3) {
        if (r2 != 33) goto L6;
        setSelection(getAdapter().lastPositionInMonth());
        return;
    L6:
        if (r2 != 130) goto L8;
        setSelection(getAdapter().firstPositionInMonth());
        return;
    L8:
        super.onFocusChanged(true, r2, r3);
    }

    private View getChildAtPosition(int r2) {
        return getChildAt(r2 - getFirstVisiblePosition());
    }

    private static boolean skipMonth(Long r3, Long r4, Long r5, Long r6) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L16;
        if (r5 == null) goto L17;
        if (r6 != null) goto L9;
        return true;
    L9:
        if (r5.longValue() <= r4.longValue()) goto L11;
        return true;
    L11:
        if (r6.longValue() < r3.longValue()) goto L20;
        return false;
    L20:
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }

    private static int horizontalMidPoint(View r1) {
        return r1.getLeft() + (r1.getWidth() / 2);
    }
}
