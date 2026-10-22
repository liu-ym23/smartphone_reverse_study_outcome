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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.c;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context r10) {
        this(r10, null);
    }

    private void gainFocus(int r10, Rect r11) {
        if (r10 != 33) goto L6;
        setSelection(getAdapter().lastPositionInMonth());
        return;
    L6:
        if (r10 != 130) goto L8;
        setSelection(getAdapter().firstPositionInMonth());
        return;
    L8:
        super.onFocusChanged(true, r10, r11);
    }

    private static int horizontalMidPoint(@NonNull View r10) {
        return r10.getLeft() + (r10.getWidth() / 2);
    }

    private static boolean skipMonth(@Nullable Long r10, @Nullable Long r11, @Nullable Long r12, @Nullable Long r13) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L16;
        if (r12 == null) goto L17;
        if (r13 != null) goto L9;
        return true;
    L9:
        if (r12.longValue() <= r11.longValue()) goto L11;
        return true;
    L11:
        if (r13.longValue() < r10.longValue()) goto L20;
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

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas r26) {
        MaterialCalendarGridView r10 = this;
        super.onDraw(r26);
        MonthAdapter r11 = getAdapter();
        DateSelector<?> r12 = r11.dateSelector;
        CalendarStyle r13 = r11.calendarStyle;
        Long r14 = r11.getItem(r11.firstPositionInMonth());
        Long r15 = r11.getItem(r11.lastPositionInMonth());
        Iterator<c> r16 = r12.getSelectedRanges().iterator();
    L4:
        if (r16.hasNext() == false) goto L50;
        c r17 = r16.next();
        Object r18 = r17.f2646a;
        if (r18 == null) goto L49;
        if (r17.f2647b == null) goto L4;
        Long r19 = (Long) r18;
        long r20 = r19.longValue();
        Long r21 = (Long) r17.f2647b;
        long r110 = r21.longValue();
        if (skipMonth(r14, r15, r19, r21) == true) goto L4;
        boolean r22 = ViewUtils.isLayoutRtl(this);
        if (r20 >= r14.longValue()) goto L21;
        int r23 = r11.firstPositionInMonth();
        if (r11.isFirstInRow(r23) == false) goto L18;
        int r24 = 0;
    L23:
        if (r110 <= r15.longValue()) goto L30;
        int r25 = Math.min(r11.lastPositionInMonth(), getChildCount() - 1);
        if (r11.isLastInRow(r25) == false) goto L27;
        int r111 = getWidth();
    L31:
        int r112 = (int) r11.getItemId(r23);
        int r113 = (int) r11.getItemId(r25);
    L32:
        if (r112 > r113) goto L49;
        int r114 = getNumColumns() * r112;
        int r115 = (getNumColumns() + r114) - 1;
        View r116 = r10.getChildAt(r114);
        int r117 = r116.getTop() + r13.day.getTopInset();
        int r27 = r116.getBottom() - r13.day.getBottomInset();
        if (r22 == true) goto L41;
        if (r114 <= r23) goto L37;
        int r118 = 0;
    L38:
        if (r25 <= r115) goto L40;
        int r119 = getWidth();
    L48:
        r26.drawRect(r118, r117, r119, r27, r13.rangeFill);
        r112 = r112 + 1;
        r10 = this;
        r11 = r11;
        goto L32
    L40:
        r119 = r111;
        goto L48
    L37:
        r118 = r24;
        goto L38
    L41:
        if (r25 <= r115) goto L43;
        int r120 = 0;
    L44:
        if (r114 <= r23) goto L46;
        int r121 = getWidth();
    L47:
        int r28 = r120;
        r119 = r121;
        r118 = r28;
        goto L48
    L46:
        r121 = r24;
        goto L47
    L43:
        r120 = r111;
        goto L44
    L27:
        if (r22 == true) goto L29;
        r111 = r10.getChildAt(r25).getRight();
        goto L31
    L29:
        r111 = r10.getChildAt(r25).getLeft();
        goto L31
    L30:
        r10.dayCompute.setTimeInMillis(r110);
        r25 = r11.dayToPosition(r10.dayCompute.get(5));
        r111 = horizontalMidPoint(r10.getChildAt(r25));
        goto L31
    L18:
        if (r22 == true) goto L20;
        r24 = r10.getChildAt(r23 - 1).getRight();
        goto L23
    L20:
        r24 = r10.getChildAt(r23 - 1).getLeft();
        goto L23
    L21:
        r10.dayCompute.setTimeInMillis(r20);
        r23 = r11.dayToPosition(r10.dayCompute.get(5));
        r24 = horizontalMidPoint(r10.getChildAt(r23));
    L49:
        r10 = this;
        goto L4
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean r10, int r11, Rect r12) {
        if (r10 == false) goto L4;
        gainFocus(r11, r12);
        return;
    L4:
        super.onFocusChanged(false, r11, r12);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (super.onKeyDown(r10, r11) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) goto L15;
        if (19 != r10) goto L14;
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.nestedScrollable == false) goto L5;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r12 = getLayoutParams();
        r12.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((ListAdapter) r10);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r10) {
        if (r10 >= getAdapter().firstPositionInMonth()) goto L5;
        super.setSelection(getAdapter().firstPositionInMonth());
        return;
    L5:
        super.setSelection(r10);
    }

    public MaterialCalendarGridView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r10) {
        if ((r10 instanceof MonthAdapter) == false) goto L7;
        super.setAdapter(r10);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext()) == false) goto L5;
        setNextFocusLeftId(R.id.cancel_button);
        setNextFocusRightId(R.id.confirm_button);
    L5:
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.p0(this, new AnonymousClass1(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
