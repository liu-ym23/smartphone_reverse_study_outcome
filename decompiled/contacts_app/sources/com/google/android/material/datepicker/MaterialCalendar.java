package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    static final Object MONTHS_VIEW_GROUP_TAG = null;
    static final Object NAVIGATION_NEXT_TAG = null;
    static final Object NAVIGATION_PREV_TAG = null;
    static final Object SELECTOR_TOGGLE_TAG = null;
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private CalendarStyle calendarStyle;
    private Month current;
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private DayViewDecorator dayViewDecorator;
    private View monthNext;
    private View monthPrev;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    static final enum CalendarSelector extends Enum<CalendarSelector> {
        private static final /* synthetic */ CalendarSelector[] $VALUES = null;
        public static final CalendarSelector DAY = null;
        public static final CalendarSelector YEAR = null;

        private CalendarSelector(String r1, int r2) {
            super(r1, r2);
        }

        public static CalendarSelector valueOf(String r1) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, r1);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) $VALUES.clone();
        }

        static {
            CalendarSelector r0 = new CalendarSelector("DAY", 0);
            DAY = r0;
            CalendarSelector r1 = new CalendarSelector("YEAR", 1);
            YEAR = r1;
            $VALUES = new CalendarSelector[]{r0, r1};
        }
    }

    interface OnDayClickListener {
        void onDayClick(long r1);
    }

    public MaterialCalendar() {
    }

    static /* synthetic */ RecyclerView access$000(MaterialCalendar r0) {
        return r0.recyclerView;
    }

    static /* synthetic */ CalendarConstraints access$100(MaterialCalendar r0) {
        return r0.calendarConstraints;
    }

    static /* synthetic */ DateSelector access$200(MaterialCalendar r0) {
        return r0.dateSelector;
    }

    static /* synthetic */ RecyclerView access$300(MaterialCalendar r0) {
        return r0.yearSelector;
    }

    static /* synthetic */ CalendarStyle access$400(MaterialCalendar r0) {
        return r0.calendarStyle;
    }

    static /* synthetic */ View access$500(MaterialCalendar r0) {
        return r0.dayFrame;
    }

    static /* synthetic */ Month access$602(MaterialCalendar r0, Month r1) {
        r0.current = r1;
        return r1;
    }

    static {
        MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> r1, int r2, CalendarConstraints r3) {
        return newInstance(r1, r2, r3, null);
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> r3, int r4, CalendarConstraints r5, DayViewDecorator r6) {
        MaterialCalendar<T> r0 = new MaterialCalendar();
        Bundle r1 = new Bundle();
        r1.putInt(THEME_RES_ID_KEY, r4);
        r1.putParcelable(GRID_SELECTOR_KEY, r3);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5);
        r1.putParcelable(DAY_VIEW_DECORATOR_KEY, r6);
        r1.putParcelable(CURRENT_MONTH_KEY, r5.getOpenAt());
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(THEME_RES_ID_KEY, this.themeResId);
        r3.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        r3.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        r3.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        r3.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        r2 = getArguments();
    L5:
        this.themeResId = r2.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r2.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r2.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) r2.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.current = (Month) r2.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        ContextThemeWrapper r6 = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(r6);
        LayoutInflater r0 = r12.cloneInContext(r6);
        Month r1 = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(r6) == false) goto L5;
        int r2 = R.layout.mtrl_calendar_vertical;
        final int r5 = 1;
    L6:
        View r9 = r0.inflate(r2, r13, false);
        r9.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView r3 = (GridView) r9.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass1(this));
        int r4 = this.calendarConstraints.getFirstDayOfWeek();
        if (r4 <= 0) goto L9;
        DaysOfWeekAdapter r7 = new DaysOfWeekAdapter(r4);
    L10:
        r3.setAdapter(r7);
        r3.setNumColumns(r1.daysInWeek);
        r3.setEnabled(false);
        this.recyclerView = (RecyclerView) r9.findViewById(R.id.mtrl_calendar_months);
        final Context r8 = getContext();
        final boolean r10 = false;
        final int r11 = r5;
        this.recyclerView.setLayoutManager(new AnonymousClass2(this, r8, r11, r10, r5));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter r15 = new MonthsPagerAdapter(r6, this.dateSelector, this.calendarConstraints, this.dayViewDecorator, new AnonymousClass3(this));
        this.recyclerView.setAdapter(r15);
        int r16 = r6.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView r17 = (RecyclerView) r9.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = r17;
        if (r17 == null) goto L14;
        r17.setHasFixedSize(true);
        this.yearSelector.setLayoutManager(new GridLayoutManager(r6, r16, 1, false));
        this.yearSelector.setAdapter(new YearGridAdapter(this));
        this.yearSelector.addItemDecoration(createItemDecoration());
    L14:
        if (r9.findViewById(R.id.month_navigation_fragment_toggle) == null) goto L17;
        addActionsToMonthNavigation(r9, r15);
    L17:
        if (MaterialDatePicker.isFullscreen(r6) == true) goto L19;
        new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
    L19:
        this.recyclerView.scrollToPosition(r15.getPosition(this.current));
        setUpForAccessibility();
        return r9;
    L9:
        r7 = new DaysOfWeekAdapter();
        goto L10
    L5:
        r2 = R.layout.mtrl_calendar_horizontal;
        r5 = 0;
        goto L6
    }

    private void setUpForAccessibility() {
        ViewCompat.setAccessibilityDelegate(this.recyclerView, new AnonymousClass4(this));
    }

    private RecyclerView.ItemDecoration createItemDecoration() {
        return new AnonymousClass5(this);
    }

    Month getCurrentMonth() {
        return this.current;
    }

    CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    void setCurrentMonth(Month r7) {
        MonthsPagerAdapter r0 = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int r1 = r0.getPosition(r7);
        int r2 = r1 - r0.getPosition(this.current);
        boolean r4 = true;
        if (Math.abs(r2) <= 3) goto L5;
        boolean r3 = true;
    L6:
        if (r2 > 0) goto L9;
        r4 = false;
    L9:
        this.current = r7;
        if (r3 == false) goto L13;
        if (r4 == false) goto L13;
        this.recyclerView.scrollToPosition(r1 - 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L13:
        if (r3 == false) goto L15;
        this.recyclerView.scrollToPosition(r1 + 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L15:
        postSmoothRecyclerViewScroll(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    static int getDayHeight(Context r1) {
        return r1.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    void setSelector(CalendarSelector r5) {
        this.calendarSelector = r5;
        if (r5 != CalendarSelector.YEAR) goto L6;
        this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
        this.monthPrev.setVisibility(8);
        this.monthNext.setVisibility(8);
        return;
    L6:
        if (r5 != CalendarSelector.DAY) goto L10;
        this.yearFrame.setVisibility(8);
        this.dayFrame.setVisibility(0);
        this.monthPrev.setVisibility(0);
        this.monthNext.setVisibility(0);
        setCurrentMonth(this.current);
        return;
    }

    void toggleVisibleSelector() {
        if (this.calendarSelector != CalendarSelector.YEAR) goto L6;
        setSelector(CalendarSelector.DAY);
        return;
    L6:
        if (this.calendarSelector != CalendarSelector.DAY) goto L10;
        setSelector(CalendarSelector.YEAR);
        return;
    }

    private void addActionsToMonthNavigation(View r4, final MonthsPagerAdapter r5) {
        final MaterialButton r0 = (MaterialButton) r4.findViewById(R.id.month_navigation_fragment_toggle);
        r0.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(r0, new AnonymousClass6(this));
        View r1 = r4.findViewById(R.id.month_navigation_previous);
        this.monthPrev = r1;
        r1.setTag(NAVIGATION_PREV_TAG);
        View r2 = r4.findViewById(R.id.month_navigation_next);
        this.monthNext = r2;
        r2.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = r4.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = r4.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.DAY);
        r0.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass7(this, r5, r0));
        r0.setOnClickListener(new AnonymousClass8(this));
        this.monthNext.setOnClickListener(new AnonymousClass9(this, r5));
        this.monthPrev.setOnClickListener(new AnonymousClass10(this, r5));
    }

    private void postSmoothRecyclerViewScroll(final int r3) {
        this.recyclerView.post(new AnonymousClass11(this, r3));
    }

    private static int getDialogPickerHeight(Context r5) {
        Resources r6 = r5.getResources();
        int r0 = (r6.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding)) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int r1 = r6.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        return ((r0 + r1) + ((MonthAdapter.MAXIMUM_WEEKS * r6.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)))) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> r1) {
        return super.addOnSelectionChangedListener(r1);
    }
}
