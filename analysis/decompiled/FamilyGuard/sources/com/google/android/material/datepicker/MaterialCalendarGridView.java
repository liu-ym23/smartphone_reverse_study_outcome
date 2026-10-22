package com.google.android.material.datepicker;

import a1.C0413f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import java.util.Calendar;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f12644a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f12645b;

    class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.f0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i5, Rect rect) {
        if (i5 == 33) {
            setSelection(getAdapter().m());
        } else if (i5 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i5, rect);
        }
    }

    private View c(int i5) {
        return getChildAt(i5 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l5, Long l6, Long l7, Long l8) {
        return l5 == null || l6 == null || l7 == null || l8 == null || l7.longValue() > l6.longValue() || l8.longValue() < l5.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q getAdapter() {
        return (q) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iA;
        int iD;
        int iA2;
        int iD2;
        int width;
        int i5;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        q adapter = materialCalendarGridView.getAdapter();
        d<?> dVar = adapter.f12777b;
        c cVar = adapter.f12779d;
        int iMax = Math.max(adapter.b(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(adapter.m(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        for (D.d<Long, Long> dVar2 : dVar.e()) {
            Long l5 = dVar2.f999a;
            if (l5 == null) {
                materialCalendarGridView = this;
            } else if (dVar2.f1000b != null) {
                Long l6 = l5;
                long jLongValue = l6.longValue();
                Long l7 = dVar2.f1000b;
                long jLongValue2 = l7.longValue();
                if (!e(item, item2, l6, l7)) {
                    boolean zG = com.google.android.material.internal.r.g(materialCalendarGridView);
                    if (jLongValue < item.longValue()) {
                        iD = adapter.h(iMax) ? 0 : !zG ? materialCalendarGridView.c(iMax - 1).getRight() : materialCalendarGridView.c(iMax - 1).getLeft();
                        iA = iMax;
                    } else {
                        materialCalendarGridView.f12644a.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f12644a.get(5));
                        iD = d(materialCalendarGridView.c(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iD2 = adapter.i(iMin) ? materialCalendarGridView.getWidth() : !zG ? materialCalendarGridView.c(iMin).getRight() : materialCalendarGridView.c(iMin).getLeft();
                        iA2 = iMin;
                    } else {
                        materialCalendarGridView.f12644a.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f12644a.get(5));
                        iD2 = d(materialCalendarGridView.c(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int i6 = iMax;
                    int i7 = iMin;
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View viewC = materialCalendarGridView.c(numColumns);
                        int top = viewC.getTop() + cVar.f12667a.c();
                        q qVar = adapter;
                        int bottom = viewC.getBottom() - cVar.f12667a.b();
                        if (zG) {
                            int i8 = iA2 > numColumns2 ? 0 : iD2;
                            width = numColumns > iA ? getWidth() : iD;
                            i5 = i8;
                        } else {
                            i5 = numColumns > iA ? 0 : iD;
                            width = iA2 > numColumns2 ? getWidth() : iD2;
                        }
                        canvas.drawRect(i5, top, width, bottom, cVar.f12674h);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = qVar;
                    }
                    materialCalendarGridView = this;
                    iMax = i6;
                    iMin = i7;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z5, int i5, Rect rect) {
        if (z5) {
            a(i5, rect);
        } else {
            super.onFocusChanged(false, i5, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (!super.onKeyDown(i5, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= getAdapter().b() && selectedItemPosition <= getAdapter().m())) {
            return true;
        }
        if (19 != i5) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i5, int i6) {
        if (!this.f12645b) {
            super.onMeasure(i5, i6);
            return;
        }
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i5) {
        if (i5 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i5);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f12644a = w.i();
        if (m.v2(getContext())) {
            setNextFocusLeftId(C0413f.f6838a);
            setNextFocusRightId(C0413f.f6841d);
        }
        this.f12645b = m.x2(getContext());
        H.k0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof q)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), q.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
