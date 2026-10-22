package com.google.android.material.datepicker;

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
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class MaterialCalendar<S> extends I {
    public int b;
    public DateSelector c;
    public CalendarConstraints d;
    public DayViewDecorator e;
    public Month f;
    public CalendarSelector g;
    public C5.f h;
    public RecyclerView i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f2417j;
    public View k;
    public View l;
    public View m;
    public View n;
    public MaterialButton o;
    public AccessibilityManager p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CalendarSelector {

        /* renamed from: a, reason: collision with root package name */
        public static final CalendarSelector f2418a;
        public static final CalendarSelector b;
        public static final /* synthetic */ CalendarSelector[] c;

        static {
            CalendarSelector calendarSelector = new CalendarSelector("DAY", 0);
            f2418a = calendarSelector;
            CalendarSelector calendarSelector2 = new CalendarSelector("YEAR", 1);
            b = calendarSelector2;
            c = new CalendarSelector[]{calendarSelector, calendarSelector2};
        }

        public static CalendarSelector valueOf(String str) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, str);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) c.clone();
        }
    }

    @Override // com.google.android.material.datepicker.I
    public final void b(z zVar) {
        this.f2414a.add(zVar);
    }

    public final void c(Month month) {
        G g = (G) this.f2417j.getAdapter();
        int iMonthsUntil = g.f2413a.getStart().monthsUntil(month);
        AccessibilityManager accessibilityManager = this.p;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iMonthsUntil2 = iMonthsUntil - g.f2413a.getStart().monthsUntil(this.f);
            boolean z10 = Math.abs(iMonthsUntil2) > 3;
            boolean z11 = iMonthsUntil2 > 0;
            this.f = month;
            if (z10 && z11) {
                this.f2417j.scrollToPosition(iMonthsUntil - 3);
                this.f2417j.post(new RunnableC0913p(this, iMonthsUntil, 0));
            } else if (z10) {
                this.f2417j.scrollToPosition(iMonthsUntil + 3);
                this.f2417j.post(new RunnableC0913p(this, iMonthsUntil, 0));
            } else {
                this.f2417j.post(new RunnableC0913p(this, iMonthsUntil, 0));
            }
        } else {
            this.f = month;
            this.f2417j.scrollToPosition(iMonthsUntil);
        }
        e(iMonthsUntil);
    }

    public final void d(CalendarSelector calendarSelector) {
        this.g = calendarSelector;
        if (calendarSelector == CalendarSelector.b) {
            this.i.getLayoutManager().scrollToPosition(this.f.year - ((S) this.i.getAdapter()).f2423a.d.getStart().year);
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.f2418a) {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            c(this.f);
        }
    }

    public final void e(int i) {
        this.l.setEnabled(i + 1 < this.f2417j.getAdapter().getItemCount());
        this.k.setEnabled(i - 1 >= 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        int i;
        int i6;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.h = new C5.f(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.p = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month start = this.d.getStart();
        if (A.d(R.attr.windowFullscreen, contextThemeWrapper)) {
            i = com.stepos.ability.R.layout.mtrl_calendar_vertical;
            i6 = 1;
        } else {
            i = com.stepos.ability.R.layout.mtrl_calendar_horizontal;
            i6 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.stepos.ability.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.mtrl_calendar_days_of_week_height);
        int i10 = D.g;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_calendar_month_vertical_padding) * (i10 - 1)) + (resources.getDimensionPixelSize(com.stepos.ability.R.dimen.mtrl_calendar_day_height) * i10) + resources.getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.stepos.ability.R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new C0914q(0));
        int firstDayOfWeek = this.d.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new C0911n(firstDayOfWeek) : new C0911n()));
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.f2417j = (RecyclerView) viewInflate.findViewById(com.stepos.ability.R.id.mtrl_calendar_months);
        this.f2417j.setLayoutManager(new r(this, getContext(), i6, i6));
        this.f2417j.setTag("MONTHS_VIEW_GROUP_TAG");
        G g = new G(contextThemeWrapper, this.c, this.d, this.e, new C0915s(this));
        this.f2417j.setAdapter(g);
        int integer = contextThemeWrapper.getResources().getInteger(com.stepos.ability.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.stepos.ability.R.id.mtrl_calendar_year_selector_frame);
        this.i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i.setAdapter(new S(this));
            this.i.addItemDecoration(new t(this));
        }
        View viewFindViewById = viewInflate.findViewById(com.stepos.ability.R.id.month_navigation_fragment_toggle);
        CalendarConstraints calendarConstraints = g.f2413a;
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.stepos.ability.R.id.month_navigation_fragment_toggle);
            this.o = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(this.o, new u(this));
            View viewFindViewById2 = viewInflate.findViewById(com.stepos.ability.R.id.month_navigation_previous);
            this.k = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById3 = viewInflate.findViewById(com.stepos.ability.R.id.month_navigation_next);
            this.l = viewFindViewById3;
            viewFindViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.m = viewInflate.findViewById(com.stepos.ability.R.id.mtrl_calendar_year_selector_frame);
            this.n = viewInflate.findViewById(com.stepos.ability.R.id.mtrl_calendar_day_selector_frame);
            d(CalendarSelector.f2418a);
            this.o.setText(this.f.getLongName());
            this.f2417j.addOnScrollListener(new v(this, g));
            this.o.setOnClickListener(new w(this));
            this.l.setOnClickListener(new ViewOnClickListenerC0912o(this, g, 1));
            this.k.setOnClickListener(new ViewOnClickListenerC0912o(this, g, 0));
            e(calendarConstraints.getStart().monthsUntil(this.f));
        }
        if (!A.d(R.attr.windowFullscreen, contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f2417j);
        }
        this.f2417j.scrollToPosition(calendarConstraints.getStart().monthsUntil(this.f));
        ViewCompat.setAccessibilityDelegate(this.f2417j, new C0914q(1));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f);
    }
}
