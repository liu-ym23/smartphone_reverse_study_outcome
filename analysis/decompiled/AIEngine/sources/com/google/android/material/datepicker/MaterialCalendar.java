package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.stepos.aiengine.R;
import java.util.Calendar;
import v0.e0;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private AccessibilityManager accessibilityManager;
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private com.google.android.material.datepicker.b calendarStyle;
    private Month current;
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private DayViewDecorator dayViewDecorator;
    private MaterialButton monthDropSelect;
    private View monthNext;
    private View monthPrev;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;
    static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CalendarSelector {

        /* renamed from: a, reason: collision with root package name */
        public static final CalendarSelector f4901a;

        /* renamed from: b, reason: collision with root package name */
        public static final CalendarSelector f4902b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ CalendarSelector[] f4903c;

        static {
            CalendarSelector calendarSelector = new CalendarSelector("DAY", 0);
            f4901a = calendarSelector;
            CalendarSelector calendarSelector2 = new CalendarSelector("YEAR", 1);
            f4902b = calendarSelector2;
            f4903c = new CalendarSelector[]{calendarSelector, calendarSelector2};
        }

        public CalendarSelector() {
            throw null;
        }

        public static CalendarSelector valueOf(String str) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, str);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) f4903c.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f4904a;

        public a(o oVar) {
            this.f4904a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MaterialCalendar.this.setCurrentMonth(this.f4904a.f4980a.getStart().monthsLater(r2.getLayoutManager().findLastVisibleItemPosition() - 1));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4906a;

        public b(int i10) {
            this.f4906a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MaterialCalendar.this.recyclerView.smoothScrollToPosition(this.f4906a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends v0.a {
        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.i(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4908a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, int i10, int i11) {
            super(context, i10, false);
            this.f4908a = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int i10 = this.f4908a;
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            if (i10 == 0) {
                iArr[0] = materialCalendar.recyclerView.getWidth();
                iArr[1] = materialCalendar.recyclerView.getWidth();
            } else {
                iArr[0] = materialCalendar.recyclerView.getHeight();
                iArr[1] = materialCalendar.recyclerView.getHeight();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e {
        public e() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f extends v0.a {
        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.l(false);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f4911a = s.g(null);

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f4912b = s.g(null);

        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof u) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                u uVar = (u) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                for (u0.b<Long, Long> bVar : materialCalendar.dateSelector.getSelectedRanges()) {
                    Long l10 = bVar.f13138a;
                    Long l11 = bVar.f13139b;
                    if (l10 != null && l11 != null) {
                        long jLongValue = l10.longValue();
                        Calendar calendar = this.f4911a;
                        calendar.setTimeInMillis(jLongValue);
                        long jLongValue2 = l11.longValue();
                        Calendar calendar2 = this.f4912b;
                        calendar2.setTimeInMillis(jLongValue2);
                        int i10 = calendar.get(1) - uVar.f4990a.getCalendarConstraints().getStart().year;
                        int i11 = calendar2.get(1) - uVar.f4990a.getCalendarConstraints().getStart().year;
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i11);
                        int spanCount = i10 / gridLayoutManager.getSpanCount();
                        int spanCount2 = i11 / gridLayoutManager.getSpanCount();
                        for (int i12 = spanCount; i12 <= spanCount2; i12++) {
                            View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i12);
                            if (viewFindViewByPosition3 != null) {
                                int top = viewFindViewByPosition3.getTop() + materialCalendar.calendarStyle.f4948d.f4939a.top;
                                int bottom = viewFindViewByPosition3.getBottom() - materialCalendar.calendarStyle.f4948d.f4939a.bottom;
                                canvas.drawRect((i12 != spanCount || viewFindViewByPosition == null) ? 0 : (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft(), top, (i12 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft(), bottom, materialCalendar.calendarStyle.h);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h extends v0.a {
        public h() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            bVar.b(new b.a(16, materialCalendar.dayFrame.getVisibility() == 0 ? materialCalendar.getString(R.string.mtrl_picker_toggle_to_year_selection) : materialCalendar.getString(R.string.mtrl_picker_toggle_to_day_selection)));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f4915a;

        public i(o oVar) {
            this.f4915a = oVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            int iFindFirstVisibleItemPosition = i10 < 0 ? materialCalendar.getLayoutManager().findFirstVisibleItemPosition() : materialCalendar.getLayoutManager().findLastVisibleItemPosition();
            o oVar = this.f4915a;
            CalendarConstraints calendarConstraints = oVar.f4980a;
            CalendarConstraints calendarConstraints2 = oVar.f4980a;
            Month monthMonthsLater = calendarConstraints.getStart().monthsLater(iFindFirstVisibleItemPosition);
            materialCalendar.current = monthMonthsLater;
            materialCalendar.monthDropSelect.setText(calendarConstraints2.getStart().monthsLater(iFindFirstVisibleItemPosition).getLongName());
            materialCalendar.updateNavigationButtonsEnabled(calendarConstraints2.getStart().monthsUntil(monthMonthsLater));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MaterialCalendar.this.toggleVisibleSelector();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f4918a;

        public k(o oVar) {
            this.f4918a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            materialCalendar.setCurrentMonth(this.f4918a.f4980a.getStart().monthsLater(materialCalendar.getLayoutManager().findFirstVisibleItemPosition() + 1));
        }
    }

    private void addActionsToMonthNavigation(View view, o oVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        this.monthDropSelect = materialButton;
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        e0.j(this.monthDropSelect, new h());
        View viewFindViewById = view.findViewById(R.id.month_navigation_previous);
        this.monthPrev = viewFindViewById;
        viewFindViewById.setTag(NAVIGATION_PREV_TAG);
        View viewFindViewById2 = view.findViewById(R.id.month_navigation_next);
        this.monthNext = viewFindViewById2;
        viewFindViewById2.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.f4901a);
        this.monthDropSelect.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new i(oVar));
        this.monthDropSelect.setOnClickListener(new j());
        this.monthNext.setOnClickListener(new k(oVar));
        this.monthPrev.setOnClickListener(new a(oVar));
        updateNavigationButtonsEnabled(oVar.f4980a.getStart().monthsUntil(this.current));
    }

    private RecyclerView.ItemDecoration createItemDecoration() {
        return new g();
    }

    public static int getDayHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i10 = m.f4971j;
        return dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i10 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i10) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        return newInstance(dateSelector, i10, calendarConstraints, null);
    }

    private void postSmoothRecyclerViewScroll(int i10) {
        this.recyclerView.post(new b(i10));
    }

    private void setUpForAccessibility() {
        e0.j(this.recyclerView, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationButtonsEnabled(int i10) {
        this.monthNext.setEnabled(i10 + 1 < this.recyclerView.getAdapter().getItemCount());
        this.monthPrev.setEnabled(i10 - 1 >= 0);
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(p<S> pVar) {
        return super.addOnSelectionChangedListener(pVar);
    }

    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    public com.google.android.material.datepicker.b getCalendarStyle() {
        return this.calendarStyle;
    }

    public Month getCurrentMonth() {
        return this.current;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) bundle.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.current = (Month) bundle.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.accessibilityManager = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month start = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i10 = R.layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R.layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        viewInflate.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        e0.j(gridView, new c());
        int firstDayOfWeek = this.calendarConstraints.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new com.google.android.material.datepicker.h(firstDayOfWeek) : new com.google.android.material.datepicker.h()));
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new d(getContext(), i11, i11));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        o oVar = new o(contextThemeWrapper, this.dateSelector, this.calendarConstraints, this.dayViewDecorator, new e());
        this.recyclerView.setAdapter(oVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new u(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (viewInflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(viewInflate, oVar);
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(oVar.f4980a.getStart().monthsUntil(this.current));
        setUpForAccessibility();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    public void sendAccessibilityFocusEventToMonthDropdown() {
        MaterialButton materialButton = this.monthDropSelect;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }

    public void setCurrentMonth(Month month) {
        o oVar = (o) this.recyclerView.getAdapter();
        int iMonthsUntil = oVar.f4980a.getStart().monthsUntil(month);
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iMonthsUntil2 = iMonthsUntil - oVar.f4980a.getStart().monthsUntil(this.current);
            boolean z = Math.abs(iMonthsUntil2) > 3;
            boolean z3 = iMonthsUntil2 > 0;
            this.current = month;
            if (z && z3) {
                this.recyclerView.scrollToPosition(iMonthsUntil - 3);
                postSmoothRecyclerViewScroll(iMonthsUntil);
            } else if (z) {
                this.recyclerView.scrollToPosition(iMonthsUntil + 3);
                postSmoothRecyclerViewScroll(iMonthsUntil);
            } else {
                postSmoothRecyclerViewScroll(iMonthsUntil);
            }
        } else {
            this.current = month;
            this.recyclerView.scrollToPosition(iMonthsUntil);
        }
        updateNavigationButtonsEnabled(iMonthsUntil);
    }

    public void setSelector(CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector == CalendarSelector.f4902b) {
            this.yearSelector.getLayoutManager().scrollToPosition(this.current.year - ((u) this.yearSelector.getAdapter()).f4990a.getCalendarConstraints().getStart().year);
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
            this.monthPrev.setVisibility(8);
            this.monthNext.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.f4901a) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            this.monthPrev.setVisibility(0);
            this.monthNext.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    public void toggleVisibleSelector() {
        CalendarSelector calendarSelector = this.calendarSelector;
        CalendarSelector calendarSelector2 = CalendarSelector.f4901a;
        CalendarSelector calendarSelector3 = CalendarSelector.f4902b;
        if (calendarSelector == calendarSelector3) {
            setSelector(calendarSelector2);
            this.recyclerView.announceForAccessibility(getString(R.string.mtrl_picker_toggled_to_day_selection));
        } else if (calendarSelector == calendarSelector2) {
            setSelector(calendarSelector3);
            this.yearSelector.announceForAccessibility(getString(R.string.mtrl_picker_toggled_to_year_selection));
        }
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i10);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, dayViewDecorator);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }
}
