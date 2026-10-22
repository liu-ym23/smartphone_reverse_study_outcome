package com.google.android.material.datepicker;

import K.S;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public final class s<S> extends D {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f10704q = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10705b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector f10706c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f10707d;

    /* renamed from: e, reason: collision with root package name */
    public DayViewDecorator f10708e;

    /* renamed from: f, reason: collision with root package name */
    public Month f10709f;

    /* renamed from: g, reason: collision with root package name */
    public int f10710g;

    /* renamed from: h, reason: collision with root package name */
    public o2.d f10711h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f10712i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f10713j;

    /* renamed from: k, reason: collision with root package name */
    public View f10714k;

    /* renamed from: l, reason: collision with root package name */
    public View f10715l;

    /* renamed from: m, reason: collision with root package name */
    public View f10716m;

    /* renamed from: n, reason: collision with root package name */
    public View f10717n;

    /* renamed from: o, reason: collision with root package name */
    public MaterialButton f10718o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f10719p;

    @Override // com.google.android.material.datepicker.D
    public final void g(v vVar) {
        this.f10610a.add(vVar);
    }

    public final void h(Month month) {
        B b4 = (B) this.f10713j.getAdapter();
        int iH = b4.f10594a.f10599a.h(month);
        AccessibilityManager accessibilityManager = this.f10719p;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iH2 = iH - b4.f10594a.f10599a.h(this.f10709f);
            boolean z4 = Math.abs(iH2) > 3;
            boolean z5 = iH2 > 0;
            this.f10709f = month;
            if (z4 && z5) {
                this.f10713j.scrollToPosition(iH - 3);
                this.f10713j.post(new RunnableC0433l(this, iH));
            } else if (z4) {
                this.f10713j.scrollToPosition(iH + 3);
                this.f10713j.post(new RunnableC0433l(this, iH));
            } else {
                this.f10713j.post(new RunnableC0433l(this, iH));
            }
        } else {
            this.f10709f = month;
            this.f10713j.scrollToPosition(iH);
        }
        j(iH);
    }

    public final void i(int i4) {
        this.f10710g = i4;
        if (i4 == 2) {
            this.f10712i.getLayoutManager().scrollToPosition(this.f10709f.f10659c - ((M) this.f10712i.getAdapter()).f10625a.f10707d.f10599a.f10659c);
            this.f10716m.setVisibility(0);
            this.f10717n.setVisibility(8);
            this.f10714k.setVisibility(8);
            this.f10715l.setVisibility(8);
            return;
        }
        if (i4 == 1) {
            this.f10716m.setVisibility(8);
            this.f10717n.setVisibility(0);
            this.f10714k.setVisibility(0);
            this.f10715l.setVisibility(0);
            h(this.f10709f);
        }
    }

    public final void j(int i4) {
        this.f10715l.setEnabled(i4 + 1 < this.f10713j.getAdapter().getItemCount());
        this.f10714k.setEnabled(i4 - 1 >= 0);
    }

    @Override // androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10705b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10706c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f10707d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f10708e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f10709f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.D
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        int i4;
        int i5;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f10705b);
        this.f10711h = new o2.d(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f10719p = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month month = this.f10707d.f10599a;
        int i6 = 1;
        int i7 = 0;
        if (MaterialDatePicker.k(R.attr.windowFullscreen, contextThemeWrapper)) {
            i4 = com.stepos.alphame.R.layout.mtrl_calendar_vertical;
            i5 = 1;
        } else {
            i4 = com.stepos.alphame.R.layout.mtrl_calendar_horizontal;
            i5 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i4, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.stepos.alphame.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.stepos.alphame.R.dimen.mtrl_calendar_days_of_week_height);
        int i8 = y.f10733g;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_calendar_month_vertical_padding) * (i8 - 1)) + (resources.getDimensionPixelSize(com.stepos.alphame.R.dimen.mtrl_calendar_day_height) * i8) + resources.getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.stepos.alphame.R.id.mtrl_calendar_days_of_week);
        S.h(gridView, new C0434m(i7, this));
        int i9 = this.f10707d.f10603e;
        gridView.setAdapter((ListAdapter) (i9 > 0 ? new C0431j(i9) : new C0431j()));
        gridView.setNumColumns(month.f10660d);
        gridView.setEnabled(false);
        this.f10713j = (RecyclerView) viewInflate.findViewById(com.stepos.alphame.R.id.mtrl_calendar_months);
        this.f10713j.setLayoutManager(new n(this, getContext(), i5, i5));
        this.f10713j.setTag("MONTHS_VIEW_GROUP_TAG");
        B b4 = new B(contextThemeWrapper, this.f10706c, this.f10707d, this.f10708e, new o(this));
        this.f10713j.setAdapter(b4);
        int integer = contextThemeWrapper.getResources().getInteger(com.stepos.alphame.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.stepos.alphame.R.id.mtrl_calendar_year_selector_frame);
        this.f10712i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f10712i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f10712i.setAdapter(new M(this));
            this.f10712i.addItemDecoration(new p(this));
        }
        View viewFindViewById = viewInflate.findViewById(com.stepos.alphame.R.id.month_navigation_fragment_toggle);
        CalendarConstraints calendarConstraints = b4.f10594a;
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.stepos.alphame.R.id.month_navigation_fragment_toggle);
            this.f10718o = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            int i10 = 2;
            S.h(this.f10718o, new C0434m(i10, this));
            View viewFindViewById2 = viewInflate.findViewById(com.stepos.alphame.R.id.month_navigation_previous);
            this.f10714k = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById3 = viewInflate.findViewById(com.stepos.alphame.R.id.month_navigation_next);
            this.f10715l = viewFindViewById3;
            viewFindViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.f10716m = viewInflate.findViewById(com.stepos.alphame.R.id.mtrl_calendar_year_selector_frame);
            this.f10717n = viewInflate.findViewById(com.stepos.alphame.R.id.mtrl_calendar_day_selector_frame);
            i(1);
            this.f10718o.setText(this.f10709f.g());
            this.f10713j.addOnScrollListener(new q(this, b4));
            this.f10718o.setOnClickListener(new ViewOnClickListenerC0177c(i10, this));
            this.f10715l.setOnClickListener(new ViewOnClickListenerC0432k(this, b4, i6));
            this.f10714k.setOnClickListener(new ViewOnClickListenerC0432k(this, b4, i7));
            j(calendarConstraints.f10599a.h(this.f10709f));
        }
        if (!MaterialDatePicker.k(R.attr.windowFullscreen, contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f10713j);
        }
        this.f10713j.scrollToPosition(calendarConstraints.f10599a.h(this.f10709f));
        S.h(this.f10713j, new C0434m(i6, this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f10705b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f10706c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10707d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f10708e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f10709f);
    }
}
