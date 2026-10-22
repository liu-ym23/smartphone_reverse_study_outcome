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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.button.MaterialButton;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    static final Object MONTHS_VIEW_GROUP_TAG = null;
    static final Object NAVIGATION_NEXT_TAG = null;
    static final Object NAVIGATION_PREV_TAG = null;
    static final Object SELECTOR_TOGGLE_TAG = null;
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private a calendarSelector;
    private com.google.android.material.datepicker.b calendarStyle;
    private Month current;
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13339a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13340b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f13341c = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f13341c.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DAY", 0);
            f13339a = r0;
            a r1 = new a("YEAR", 1);
            f13340b = r1;
            f13341c = new a[]{r0, r1};
        }
    }

    interface b {
        void a(long r1);
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

    static /* synthetic */ com.google.android.material.datepicker.b access$400(MaterialCalendar r0) {
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

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> r3, int r4, CalendarConstraints r5) {
        DateSelector r6 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r3, DateSelector.class, "com.obric.aiagent.plugin");
        MaterialCalendar<T> r0 = new MaterialCalendar();
        Bundle r1 = new Bundle();
        r1.putInt(THEME_RES_ID_KEY, r4);
        r1.putParcelable(GRID_SELECTOR_KEY, r6);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5);
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
        r3.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L5;
        r4 = getArguments();
    L5:
        this.themeResId = r4.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) ZeusTransformUtils.preCheckCast(r4.getParcelable(GRID_SELECTOR_KEY), DateSelector.class, "com.obric.aiagent.plugin");
        this.calendarConstraints = (CalendarConstraints) ZeusTransformUtils.preCheckCast(r4.getParcelable(CALENDAR_CONSTRAINTS_KEY), CalendarConstraints.class, "com.obric.aiagent.plugin");
        this.current = (Month) ZeusTransformUtils.preCheckCast(r4.getParcelable(CURRENT_MONTH_KEY), Month.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        ContextThemeWrapper r16 = new ContextThemeWrapper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.themeResId);
        this.calendarStyle = new com.google.android.material.datepicker.b(r16);
        LayoutInflater r17 = r13.cloneInContext(r16);
        Month r0 = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(r16) == false) goto L5;
        int r2 = ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_vertical, "layout", "mtrl_calendar_vertical");
        final int r11 = 1;
    L6:
        View r18 = ZeusTransformUtils.inflate(r17, r2, r14, false, "com.obric.aiagent.plugin");
        r18.setMinimumHeight(getDialogPickerHeight((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        GridView r19 = (GridView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_calendar_days_of_week, DbHelper.COL_ID, "mtrl_calendar_days_of_week")), GridView.class, "com.obric.aiagent.plugin");
        ViewCompat.a(r19, new AnonymousClass1(this));
        r19.setAdapter(new DaysOfWeekAdapter());
        r19.setNumColumns(r0.daysInWeek);
        r19.setEnabled(false);
        this.recyclerView = (RecyclerView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_calendar_months, DbHelper.COL_ID, "mtrl_calendar_months")), RecyclerView.class, "com.obric.aiagent.plugin");
        final Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final boolean r10 = false;
        final int r9 = r11;
        this.recyclerView.setLayoutManager(new AnonymousClass3(this, r8, r9, r10, r11));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        e r110 = new e(r16, this.dateSelector, this.calendarConstraints, new AnonymousClass4(this));
        this.recyclerView.setAdapter(r110);
        int r1 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.mtrl_calendar_year_selector_span, WsChannelMultiProcessSharedProvider.INT_TYPE, "mtrl_calendar_year_selector_span"));
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_calendar_year_selector_frame, DbHelper.COL_ID, "mtrl_calendar_year_selector_frame")), RecyclerView.class, "com.obric.aiagent.plugin");
        this.yearSelector = r3;
        if (r3 == null) goto L10;
        r3.setHasFixedSize(true);
        this.yearSelector.setLayoutManager(new GridLayoutManager(r16, r1, 1, false));
        this.yearSelector.setAdapter(new j(this));
        this.yearSelector.addItemDecoration(createItemDecoration());
    L10:
        if (r18.findViewById(ZeusTransformUtils.mapRes(R.id.month_navigation_fragment_toggle, DbHelper.COL_ID, "month_navigation_fragment_toggle")) == null) goto L13;
        addActionsToMonthNavigation(r18, r110);
    L13:
        if (MaterialDatePicker.isFullscreen(r16) == true) goto L15;
        new v().a(this.recyclerView);
    L15:
        this.recyclerView.scrollToPosition(r110.a(this.current));
        return r18;
    L5:
        r2 = ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_horizontal, "layout", "mtrl_calendar_horizontal");
        r11 = 0;
        goto L6
    }

    private RecyclerView.g createItemDecoration() {
        return new AnonymousClass5(this);
    }

    Month getCurrentMonth() {
        return this.current;
    }

    CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    void setCurrentMonth(Month r7) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.recyclerView.getAdapter(), e.class, "com.obric.aiagent.plugin");
        int r1 = r0.a(r7);
        int r2 = r1 - r0.a(this.current);
        boolean r3 = true;
        if (Math.abs(r2) <= 3) goto L5;
        boolean r4 = true;
    L6:
        if (r2 > 0) goto L9;
        r3 = false;
    L9:
        this.current = r7;
        if (r4 == false) goto L13;
        if (r3 == false) goto L13;
        this.recyclerView.scrollToPosition(r1 - 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L13:
        if (r4 == false) goto L15;
        this.recyclerView.scrollToPosition(r1 + 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L15:
        postSmoothRecyclerViewScroll(r1);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    com.google.android.material.datepicker.b getCalendarStyle() {
        return this.calendarStyle;
    }

    static int getDayHeight(Context r3) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_day_height, "dimen", "mtrl_calendar_day_height"));
    }

    void setSelector(a r6) {
        this.calendarSelector = r6;
        if (r6 != a.f13340b) goto L6;
        this.yearSelector.getLayoutManager().e(((j) ZeusTransformUtils.preCheckCast(this.yearSelector.getAdapter(), j.class, "com.obric.aiagent.plugin")).c(this.current.year));
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
        return;
    L6:
        if (r6 != a.f13339a) goto L10;
        this.yearFrame.setVisibility(8);
        this.dayFrame.setVisibility(0);
        setCurrentMonth(this.current);
        return;
    }

    void toggleVisibleSelector() {
        if (this.calendarSelector != a.f13340b) goto L6;
        setSelector(a.f13339a);
        return;
    L6:
        if (this.calendarSelector != a.f13339a) goto L10;
        setSelector(a.f13340b);
        return;
    }

    private void addActionsToMonthNavigation(View r7, final e r8) {
        final MaterialButton r0 = (MaterialButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.month_navigation_fragment_toggle, DbHelper.COL_ID, "month_navigation_fragment_toggle")), MaterialButton.class, "com.obric.aiagent.plugin");
        r0.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.a(r0, new AnonymousClass6(this));
        MaterialButton r2 = (MaterialButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.month_navigation_previous, DbHelper.COL_ID, "month_navigation_previous")), MaterialButton.class, "com.obric.aiagent.plugin");
        r2.setTag(NAVIGATION_PREV_TAG);
        MaterialButton r3 = (MaterialButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.month_navigation_next, DbHelper.COL_ID, "month_navigation_next")), MaterialButton.class, "com.obric.aiagent.plugin");
        r3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = r7.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_calendar_year_selector_frame, DbHelper.COL_ID, "mtrl_calendar_year_selector_frame"));
        this.dayFrame = r7.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_calendar_day_selector_frame, DbHelper.COL_ID, "mtrl_calendar_day_selector_frame"));
        setSelector(a.f13339a);
        r0.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass10(this, r8, r0));
        r0.setOnClickListener(new AnonymousClass7(this));
        r3.setOnClickListener(new AnonymousClass8(this, r8));
        r2.setOnClickListener(new AnonymousClass9(this, r8));
    }

    private void postSmoothRecyclerViewScroll(final int r3) {
        this.recyclerView.post(new AnonymousClass2(this, r3));
    }

    private static int getDialogPickerHeight(Context r7) {
        Resources r8 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        int r0 = (r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_navigation_height, "dimen", "mtrl_calendar_navigation_height")) + r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_navigation_top_padding, "dimen", "mtrl_calendar_navigation_top_padding"))) + r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_navigation_bottom_padding, "dimen", "mtrl_calendar_navigation_bottom_padding"));
        int r2 = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_days_of_week_height, "dimen", "mtrl_calendar_days_of_week_height"));
        return ((r0 + r2) + ((MonthAdapter.MAXIMUM_WEEKS * r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_day_height, "dimen", "mtrl_calendar_day_height"))) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_month_vertical_padding, "dimen", "mtrl_calendar_month_vertical_padding"))))) + r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_bottom_padding, "dimen", "mtrl_calendar_bottom_padding"));
    }

    LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) ZeusTransformUtils.preCheckCast(this.recyclerView.getLayoutManager(), LinearLayoutManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(f<S> r1) {
        return super.addOnSelectionChangedListener(r1);
    }
}
