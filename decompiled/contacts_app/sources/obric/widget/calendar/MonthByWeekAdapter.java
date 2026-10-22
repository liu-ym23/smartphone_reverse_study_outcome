package obric.widget.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import obric.util.CalendarUtils;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class MonthByWeekAdapter {
    public static final int ANIMATION_DURATION_MOVE = 0;
    protected static int DEFAULT_DAYS_PER_WEEK = 7;
    protected static int DEFAULT_MONTH_FOCUS = 0;
    protected static int DEFAULT_NUM_WEEKS = 6;
    private static final String TAG = "MonthByWeek";
    protected static int WEEK_7_OVERHANG_HEIGHT = 7;
    protected static final int WEEK_COUNT_L = 6;
    protected static final int WEEK_COUNT_S = 5;
    public static final String WEEK_PARAMS_DAYS_PER_WEEK = "days_per_week";
    public static final String WEEK_PARAMS_FOCUS_MONTH = "focus_month";
    public static final String WEEK_PARAMS_JULIAN_DAY = "selected_day";
    public static final String WEEK_PARAMS_NUM_WEEKS = "num_weeks";
    public static final String WEEK_PARAMS_SINGLE_WEEK = "single_week";
    public static final String WEEK_PARAMS_WEEK_START = "week_start";
    public static int mItemHeight;
    public static int mItemSingleHeight;
    protected static float mScale;
    CellEventListener mCellEventListener;
    protected Context mContext;
    protected int mDaysPerWeek;
    protected int mFirstDayOfWeek;
    protected int mFirstJulianDay;
    protected int mFocusMonth;
    protected List<Boolean> mHasEvents;
    private boolean mHasFocus;
    protected String mHomeTimeZone;
    protected boolean mIsSingleWeek;
    private int mMaxJulianDay;
    private int mMinJulianDay;
    protected int mNumWeeks;
    protected int mOrientation;
    private int mPosition;
    protected int mQueryDays;
    protected Time mSelectedDay;
    protected int mSelectedInMonthPosition;
    protected int mSelectedWeek;
    ArrayList<Integer> mSortedIndexList;
    private ArrayList<MonthWeekEventsView> mSortedWeeksViewList;
    private RelativeLayout mWeeksLayout;

    public interface CellEventListener {
        void onCellClicked(Time day);

        void onCellLongClicked(Time day);
    }

    static {
    }

    public MonthByWeekAdapter(Context context, HashMap<String, Integer> params, CellEventListener listener) {
        this.mOrientation = 2;
        this.mHasEvents = null;
        this.mMaxJulianDay = Integer.MAX_VALUE;
        this.mMinJulianDay = 0;
        this.mSelectedInMonthPosition = -1;
        this.mNumWeeks = DEFAULT_NUM_WEEKS;
        this.mDaysPerWeek = DEFAULT_DAYS_PER_WEEK;
        this.mFocusMonth = DEFAULT_MONTH_FOCUS;
        this.mIsSingleWeek = false;
        this.mSortedWeeksViewList = new ArrayList();
        this.mSortedIndexList = new ArrayList();
        this.mPosition = -1;
        this.mContext = context;
        this.mFirstDayOfWeek = Calendar.getInstance(Locale.getDefault()).getFirstDayOfWeek() - 1;
        Resources r4 = context.getResources();
        mItemHeight = (int) r4.getDimension(R.dimen.monthweek_item_height);
        mItemSingleHeight = (int) r4.getDimension(R.dimen.monthweek_item_single_height);
        if (mScale != 0.0f) goto L7;
        float r5 = r4.getDisplayMetrics().density;
        mScale = r5;
        if (r5 == 1.0f) goto L7;
        WEEK_7_OVERHANG_HEIGHT = (int) (WEEK_7_OVERHANG_HEIGHT * r5);
    L7:
        this.mCellEventListener = listener;
        init();
        updateParams(params);
    }

    public void updateParams(HashMap<String, Integer> params) {
        if (params != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "WeekParameters are null! Cannot update adapter.");
        return;
    L6:
        if (params.containsKey("focus_month") == false) goto L9;
        this.mFocusMonth = params.get("focus_month").intValue();
    L9:
        if (params.containsKey("focus_month") == false) goto L12;
        this.mNumWeeks = params.get(WEEK_PARAMS_NUM_WEEKS).intValue();
    L12:
        if (params.containsKey(WEEK_PARAMS_SINGLE_WEEK) == false) goto L19;
        boolean r1 = true;
        if (params.get(WEEK_PARAMS_SINGLE_WEEK).intValue() == 1) goto L17;
        r1 = false;
    L17:
        this.mIsSingleWeek = r1;
    L19:
        if (params.containsKey("week_start") == false) goto L22;
        this.mFirstDayOfWeek = params.get("week_start").intValue();
    L22:
        if (params.containsKey("selected_day") == false) goto L25;
        this.mSelectedWeek = CalendarUtils.getWeeksSinceEpochFromJulianDay(params.get("selected_day").intValue(), this.mFirstDayOfWeek);
    L25:
        if (params.containsKey(WEEK_PARAMS_DAYS_PER_WEEK) == false) goto L27;
        this.mDaysPerWeek = params.get(WEEK_PARAMS_DAYS_PER_WEEK).intValue();
    L27:
        refresh();
    }

    public Time getSelectedDay() {
        return this.mSelectedDay;
    }

    public boolean hasFocus() {
        return this.mHasFocus;
    }

    public void setFocus(boolean hasFocus) {
        this.mHasFocus = hasFocus;
    }

    protected void init() {
        this.mHomeTimeZone = CalendarUtils.getTimeZone(this.mContext, null);
        Time r0 = new Time(this.mHomeTimeZone);
        this.mSelectedDay = r0;
        r0.setToNow();
    }

    public String getHomeTimeZone() {
        return this.mHomeTimeZone;
    }

    private void updateTimeZones() {
        Time r0 = this.mSelectedDay;
        r0.timezone = this.mHomeTimeZone;
        this.mSelectedDay.normalize(true);
    }

    public void setSelectedDay(Time selectedTime) {
        setSelectedDay(selectedTime, true);
    }

    public void setSelectedDay(Time selectedTime, boolean hasFoucus) {
        this.mHasFocus = hasFoucus;
        this.mSelectedDay.set(selectedTime);
        long r3 = this.mSelectedDay.normalize(true);
        this.mFirstDayOfWeek = CalendarUtils.getFirstDayOfWeekInTime(this.mContext);
        this.mSelectedWeek = CalendarUtils.getWeeksSinceEpochFromJulianDay(Time.getJulianDay(r3, this.mSelectedDay.gmtoff), this.mFirstDayOfWeek);
        notifyDataSetChanged();
    }

    public void updateRange(int minJulianDay, int maxJulianDay) {
        this.mMaxJulianDay = maxJulianDay;
        this.mMinJulianDay = minJulianDay;
        refresh();
    }

    public MonthWeekEventsView updateViewAndSorted(MonthWeekEventsView[] children, int i) {
        if (children != null) goto L4;
    L11:
        MonthWeekEventsView r5 = new MonthWeekEventsView(this.mContext, this.mCellEventListener);
    L12:
        int r6 = this.mSortedIndexList.get(i).intValue();
        HashMap<String, Integer> r0 = new HashMap();
        r0.clear();
        int r2 = -1;
        r5.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        if (this.mSelectedWeek != (this.mPosition + r6)) goto L15;
        r2 = this.mSelectedDay.weekDay;
    L15:
        r0.put("focus_month", Integer.valueOf(this.mFocusMonth));
        r0.put("selected_day", Integer.valueOf(r2));
        r0.put("week_start", Integer.valueOf(this.mFirstDayOfWeek));
        r0.put(MonthWeekEventsView.VIEW_PARAMS_NUM_DAYS, Integer.valueOf(this.mDaysPerWeek));
        r0.put(MonthWeekEventsView.VIEW_PARAMS_WEEK, Integer.valueOf(this.mPosition + r6));
        if (r6 == this.mSelectedInMonthPosition) goto L18;
    L20:
        r0.put(MonthWeekEventsView.VIEW_PARAMS_MAX_JULIANDAY, Integer.valueOf(this.mMaxJulianDay));
        r0.put(MonthWeekEventsView.VIEW_PARAMS_MIN_JULIANDAY, Integer.valueOf(this.mMinJulianDay));
        r5.setWeekParams(r0, this.mSelectedDay.timezone);
        if (this.mHasFocus == false) goto L23;
        setHasEvents(r5);
    L23:
        r5.setHasFocus(this.mHasFocus);
        return r5;
    L18:
        if (this.mIsSingleWeek == false) goto L20;
        r0.put(MonthWeekEventsView.VIEW_PARAMS_SINGLE_WEEK, 1);
        goto L20
    L4:
        if (i >= children.length) goto L11;
        r5 = children[i];
        if (r5 == null) goto L11;
        if (r5.hasFocus() == false) goto L12;
        r5.clearFocus();
        goto L12
    }

    public void updateFocusMonth(int month) {
        this.mFocusMonth = month;
    }

    public int getFocusMonth() {
        return this.mFocusMonth;
    }

    public void notifyDataSetChanged() {
        if (this.mWeeksLayout == null) goto L10;
        int r0 = getCount();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (isInitialized() == false) goto L12;
        sortWeeksLayout(this.mIsSingleWeek, r0);
        return;
    L12:
        return;
    }

    public ArrayList<Integer> sortViewIndex(int select, int count) {
        ArrayList<Integer> r3 = new ArrayList();
        if (count != 1) goto L5;
        r3.add(Integer.valueOf(select));
    L12:
        return r3;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= select) goto L8;
        r3.add(Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L6
    L8:
        int r5 = count - 1;
    L9:
        if (r5 <= select) goto L11;
        r3.add(Integer.valueOf(r5));
        r5 = r5 - 1;
        goto L9
    L11:
        r3.add(Integer.valueOf(select));
        goto L12
    }

    public void sortWeeksLayout(boolean isOverlap, int count) {
        MonthWeekEventsView[] r0 = new MonthWeekEventsView[count];
        int r2 = 0;
    L3:
        if (r2 >= count) goto L5;
        r0[r2] = (MonthWeekEventsView) this.mWeeksLayout.getChildAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        this.mWeeksLayout.removeAllViews();
        this.mSortedWeeksViewList.clear();
        int r3 = this.mSelectedWeek - this.mPosition;
        this.mSelectedInMonthPosition = r3;
        this.mSortedIndexList = sortViewIndex(r3, count);
        int r4 = 0;
    L6:
        if (r4 >= count) goto L12;
        int r5 = this.mSortedIndexList.get(r4).intValue();
        MonthWeekEventsView r6 = updateViewAndSorted(r0, r4);
        RelativeLayout.LayoutParams r7 = new RelativeLayout.LayoutParams(-1, -2);
        if (isOverlap == false) goto L10;
        int r8 = 0;
    L11:
        r7.topMargin = r8 * r5;
        this.mWeeksLayout.addView(r6, r7);
        this.mSortedWeeksViewList.add(r6);
        r4 = r4 + 1;
        goto L6
    L10:
        r8 = mItemHeight;
        goto L11
    }

    private void setHasEvents(MonthWeekEventsView v) {
        if (this.mHasEvents != null) goto L6;
        v.setHasEvents(null);
        return;
    L6:
        int r0 = v.getFirstJulianDay() - this.mFirstJulianDay;
        int r2 = v.mNumDays + r0;
        if (r0 >= 0) goto L9;
    L13:
        v.setHasEvents(null);
        return;
    L9:
        if (r2 > this.mHasEvents.size()) goto L13;
        v.setHasEvents(this.mHasEvents.subList(r0, r2));
    }

    protected void refresh() {
        this.mFirstDayOfWeek = CalendarUtils.getFirstDayOfWeekInTime(this.mContext);
        this.mHomeTimeZone = CalendarUtils.getTimeZone(this.mContext, null);
        updateTimeZones();
        notifyDataSetChanged();
    }

    protected void onDayTapped(Time day) {
        if (this.mSelectedDay != day) goto L5;
        return;
    L5:
        setSelectedDay(day);
    }

    public void setPosition(int position) {
        if (isInitialized() == true) goto L5;
    L7:
        this.mPosition = position;
        return;
    L5:
        if (this.mPosition != position) goto L7;
    }

    public boolean isInitialized() {
        if (this.mPosition < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setWeeksLayout(RelativeLayout weeksLayout) {
        this.mWeeksLayout = weeksLayout;
    }

    public int getCount() {
        if (this.mIsSingleWeek == false) goto L7;
        return 1;
    L7:
        return getThisMonthWeekCount();
    }

    public int getThisMonthWeekCount() {
        int r1 = 4;
        int r0 = CalendarUtils.getJulianMondayFromWeeksSinceEpoch(this.mPosition + 4);
        Time r2 = new Time(this.mSelectedDay.timezone);
        r2.setJulianDay(r0 - (1 - CalendarUtils.getFirstDayOfWeekInTime(this.mContext)));
        if (r2.month != this.mFocusMonth) goto L8;
        r1 = 5;
        int r3 = CalendarUtils.getJulianMondayFromWeeksSinceEpoch(this.mPosition + 5);
        Time r4 = new Time(this.mSelectedDay.timezone);
        r4.setJulianDay(r3 - (1 - CalendarUtils.getFirstDayOfWeekInTime(this.mContext)));
        if (r4.month != this.mFocusMonth) goto L8;
        return 6;
    L8:
        return r1;
    }

    public int getSelectedInMonthPosition() {
        return this.mSelectedInMonthPosition;
    }

    public void reAddChildWithMarginTop(int margTop) {
        if (this.mSortedIndexList.size() == this.mSortedWeeksViewList.size()) goto L5;
        return;
    L5:
        if (this.mSortedIndexList.size() <= 0) goto L20;
        this.mWeeksLayout.removeAllViews();
        int r0 = 0;
    L8:
        if (r0 >= this.mSortedIndexList.size()) goto L21;
        MonthWeekEventsView r1 = this.mSortedWeeksViewList.get(r0);
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, -2);
        r2.topMargin = (r1.mWeek - this.mPosition) * margTop;
        if (r1.getParent() == null) goto L14;
        if ((r1.getParent() instanceof ViewGroup) == false) goto L14;
        ((ViewGroup) r1.getParent()).removeView(r1);
    L14:
        this.mWeeksLayout.addView(r1, r2);
        r0 = r0 + 1;
        goto L8
    L21:
        return;
    }

    public MonthWeekEventsView getTouchView(float touchY) {
        if (touchY <= this.mWeeksLayout.getHeight()) goto L5;
        return null;
    L5:
        if (touchY >= 0.0f) goto L8;
        return null;
    L8:
        if (this.mIsSingleWeek == false) goto L12;
        ArrayList<MonthWeekEventsView> r1 = this.mSortedWeeksViewList;
        return r1.get(r1.size() - 1);
    L12:
        return getIndexOfView((int) ((this.mWeeksLayout.getChildCount() * touchY) / this.mWeeksLayout.getHeight()));
    }

    public MonthWeekEventsView getIndexOfView(int index) {
        if (this.mSortedIndexList.isEmpty() == false) goto L5;
        return null;
    L5:
        if (index < this.mSortedIndexList.size()) goto L8;
        return null;
    L8:
        if (this.mIsSingleWeek == false) goto L12;
        ArrayList<MonthWeekEventsView> r1 = this.mSortedWeeksViewList;
        return r1.get(r1.size() - 1);
    L12:
        return this.mSortedWeeksViewList.get(this.mSortedIndexList.get(index).intValue());
    }
}
