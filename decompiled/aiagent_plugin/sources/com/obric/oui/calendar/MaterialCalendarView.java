package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public class MaterialCalendarView extends ViewGroup {
    private static final int DAY_NAMES_ROW = 1;
    private static final int DEFAULT_DAYS_IN_WEEK = 7;
    private static final int DEFAULT_DAYS_ROW = 6;
    public static final int DEFAULT_TILE_CONTENT_VERTICAL_PADDING_DP = 9;
    public static final int DEFAULT_TILE_SIZE_DP = 40;
    public static final int DEFAULT_WEEKDAYS_HEIGHT_DP = 28;
    public static final int HORIZONTAL = 1;
    public static final int INVALID_TILE_DIMENSION = -10;
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_RANGE = 3;
    public static final int SELECTION_MODE_SINGLE = 1;
    public static final int SHOW_ALL = 7;
    public static final int SHOW_DECORATED_DISABLED = 4;
    public static final int SHOW_DEFAULTS = 4;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OTHER_MONTHS = 1;
    public static final int SHOW_OUT_OF_RANGE = 2;
    public static final int VERTICAL = 0;
    private int accentColor;
    private com.obric.oui.calendar.b<?> adapter;
    private boolean allowClickDaysOutsideCurrentMonth;
    private final ImageView buttonFuture;
    private final ImageView buttonPast;
    CharSequence calendarContentDescription;
    private com.obric.oui.calendar.a calendarMode;
    private CalendarDay currentMonth;
    private final ArrayList<d> dayViewDecorators;
    private DayOfWeek firstDayOfWeek;
    private j listener;
    private i longClickListener;
    private boolean mDynamicHeightEnabled;
    private CalendarDay maxDate;
    private final a measureInfo;
    private CalendarDay minDate;
    private k monthListener;
    private final View.OnClickListener onClickListener;
    private final ViewPager.e pageChangeListener;
    private final CalendarPager pager;
    private l rangeListener;
    private int selectionMode;
    private boolean showWeekDays;
    private b state;
    private int tileHSpacing;
    private int tileHeight;
    private int tileVSpacing;
    private int tileWidth;
    private final TextView title;
    private final n titleChanger;
    private LinearLayout topbar;
    private int weekDaysHeight;

    /* JADX INFO: renamed from: com.obric.oui.calendar.MaterialCalendarView$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34332a = null;

        static {
            int[] r0 = new int[com.obric.oui.calendar.a.values().length];
            f34332a = r0;
            r0[com.obric.oui.calendar.a.f34362a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f34332a[com.obric.oui.calendar.a.f34363b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean allowClickDaysOutsideCurrentMonth;
        boolean cacheCurrentPosition;
        CalendarDay currentMonth;
        boolean dynamicHeightEnabled;
        CalendarDay maxDate;
        CalendarDay minDate;
        List<CalendarDay> selectedDates;
        int selectionMode;
        int showOtherDates;
        boolean topbarVisible;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.showOtherDates);
            r2.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r2.writeParcelable(this.minDate, 0);
            r2.writeParcelable(this.maxDate, 0);
            r2.writeTypedList(this.selectedDates);
            r2.writeInt(this.topbarVisible ? 1 : 0);
            r2.writeInt(this.selectionMode);
            r2.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            r2.writeParcelable(this.currentMonth, 0);
            r2.writeByte(this.cacheCurrentPosition ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        private SavedState(Parcel r7) {
            super(r7);
            this.showOtherDates = 4;
            boolean r0 = true;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
            this.showOtherDates = r7.readInt();
            if (r7.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r1;
            ClassLoader r2 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.aiagent.plugin");
            this.maxDate = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.aiagent.plugin");
            r7.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            if (r7.readInt() != 1) goto L9;
            boolean r3 = true;
        L10:
            this.topbarVisible = r3;
            this.selectionMode = r7.readInt();
            if (r7.readInt() != 1) goto L13;
            boolean r4 = true;
        L14:
            this.dynamicHeightEnabled = r4;
            this.currentMonth = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.aiagent.plugin");
            if (r7.readByte() != 0) goto L18;
            r0 = false;
        L18:
            this.cacheCurrentPosition = r0;
            return;
        L13:
            r4 = false;
            goto L14
        L9:
            r3 = false;
            goto L10
        L5:
            r1 = false;
            goto L6
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f34333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f34334b;

        public a() {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f34335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.calendar.a f34336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DayOfWeek f34337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CalendarDay f34338d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final CalendarDay f34339e;
        private final boolean f;
        private final boolean g;

        /* synthetic */ b(MaterialCalendarView r1, c r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f;
        }

        static /* synthetic */ com.obric.oui.calendar.a b(b r0) {
            return r0.f34336b;
        }

        static /* synthetic */ DayOfWeek c(b r0) {
            return r0.f34337c;
        }

        static /* synthetic */ CalendarDay d(b r0) {
            return r0.f34338d;
        }

        static /* synthetic */ CalendarDay e(b r0) {
            return r0.f34339e;
        }

        static /* synthetic */ boolean f(b r0) {
            return r0.g;
        }

        private b(MaterialCalendarView r1, c r2) {
            this.f34335a = r1;
            this.f34336b = c.a(r2);
            this.f34337c = c.b(r2);
            this.f34338d = c.c(r2);
            this.f34339e = c.d(r2);
            this.f = c.e(r2);
            this.g = c.f(r2);
        }

        public c a() {
            return new c(this.f34335a, this, null);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f34340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.obric.oui.calendar.a f34341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private DayOfWeek f34342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f34343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CalendarDay f34344e;
        private CalendarDay f;
        private boolean g;

        /* synthetic */ c(MaterialCalendarView r1, b r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ com.obric.oui.calendar.a a(c r0) {
            return r0.f34341b;
        }

        static /* synthetic */ DayOfWeek b(c r0) {
            return r0.f34342c;
        }

        static /* synthetic */ CalendarDay c(c r0) {
            return r0.f34344e;
        }

        static /* synthetic */ CalendarDay d(c r0) {
            return r0.f;
        }

        static /* synthetic */ boolean e(c r0) {
            return r0.f34343d;
        }

        static /* synthetic */ boolean f(c r0) {
            return r0.g;
        }

        public c(MaterialCalendarView r4) {
            this.f34340a = r4;
            this.f34343d = false;
            this.f34344e = null;
            this.f = null;
            this.f34341b = com.obric.oui.calendar.a.f34362a;
            this.f34342c = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        private c(MaterialCalendarView r1, b r2) {
            this.f34340a = r1;
            this.f34343d = false;
            this.f34344e = null;
            this.f = null;
            this.f34341b = b.b(r2);
            this.f34342c = b.c(r2);
            this.f34344e = b.d(r2);
            this.f = b.e(r2);
            this.f34343d = b.a(r2);
            this.g = b.f(r2);
        }

        public c a(DayOfWeek r1) {
            this.f34342c = r1;
            return this;
        }

        public c a(com.obric.oui.calendar.a r1) {
            this.f34341b = r1;
            return this;
        }

        public c a(CalendarDay r1) {
            this.f34344e = r1;
            return this;
        }

        public c b(CalendarDay r1) {
            this.f = r1;
            return this;
        }

        public c a(boolean r1) {
            this.g = r1;
            return this;
        }

        public c b(boolean r1) {
            this.f34343d = r1;
            return this;
        }

        public void a() {
            MaterialCalendarView.access$2200(this.f34340a, new b(this.f34340a, this, null));
        }
    }

    public static boolean showDecoratedDisabled(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean showOtherMonths(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean showOutOfRange(int r0) {
        if ((r0 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    static /* synthetic */ ImageView access$000(MaterialCalendarView r0) {
        return r0.buttonFuture;
    }

    static /* synthetic */ CalendarPager access$100(MaterialCalendarView r0) {
        return r0.pager;
    }

    static /* synthetic */ ImageView access$200(MaterialCalendarView r0) {
        return r0.buttonPast;
    }

    static /* synthetic */ void access$2200(MaterialCalendarView r0, b r1) {
        r0.commit(r1);
    }

    static /* synthetic */ CalendarDay access$300(MaterialCalendarView r0) {
        return r0.currentMonth;
    }

    static /* synthetic */ CalendarDay access$302(MaterialCalendarView r0, CalendarDay r1) {
        r0.currentMonth = r1;
        return r1;
    }

    static /* synthetic */ n access$400(MaterialCalendarView r0) {
        return r0.titleChanger;
    }

    static /* synthetic */ com.obric.oui.calendar.b access$500(MaterialCalendarView r0) {
        return r0.adapter;
    }

    static /* synthetic */ void access$600(MaterialCalendarView r0) {
        r0.updateUi();
    }

    public MaterialCalendarView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialCalendarView(Context r17, AttributeSet r18) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r4, r6);
        this.dayViewDecorators = new ArrayList();
        View.OnClickListener r7 = new AnonymousClass1(this);
        this.onClickListener = r7;
        ViewPager.e r8 = new AnonymousClass2(this);
        this.pageChangeListener = r8;
        this.minDate = null;
        this.maxDate = null;
        this.accentColor = 0;
        this.tileHeight = -10;
        this.tileWidth = -10;
        this.tileHSpacing = -10;
        this.tileVSpacing = -10;
        this.selectionMode = 1;
        this.allowClickDaysOutsideCurrentMonth = true;
        this.weekDaysHeight = -10;
        this.measureInfo = new a();
        if (Build.VERSION.SDK_INT < 19) goto L5;
        setClipToPadding(false);
        setClipChildren(false);
    L6:
        View r9 = ZeusTransformUtils.inflate((LayoutInflater) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.calendar_view, "layout", "calendar_view"), null, false, "com.obric.aiagent.plugin");
        this.topbar = (LinearLayout) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.header, DbHelper.COL_ID, "header")), LinearLayout.class, "com.obric.aiagent.plugin");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.previous, DbHelper.COL_ID, "previous")), ImageView.class, "com.obric.aiagent.plugin");
        this.buttonPast = r11;
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.month_name, DbHelper.COL_ID, "month_name")), TextView.class, "com.obric.aiagent.plugin");
        this.title = r14;
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.next, DbHelper.COL_ID, "next")), ImageView.class, "com.obric.aiagent.plugin");
        this.buttonFuture = r10;
        CalendarPager r12 = new CalendarPager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.pager = r12;
        r11.setOnClickListener(r7);
        r10.setOnClickListener(r7);
        n r5 = new n(r14);
        this.titleChanger = r5;
        r12.setOnPageChangeListener(r8);
        r12.setPageTransformer(false, new AnonymousClass3(this));
        TypedArray r13 = r4.getTheme().obtainStyledAttributes(r6, R.styleable.O_MaterialCalendarView, 0, 0);
        int r15 = r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_calendarMode, "styleable", "O_MaterialCalendarView_o_mcv_calendarMode"), 0);     // Catch: Throwable -> L36 Exception -> L38
        int r16 = r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_firstDayOfWeek, "styleable", "O_MaterialCalendarView_o_mcv_firstDayOfWeek"), -1);     // Catch: Throwable -> L36 Exception -> L38
        r5.a(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, "styleable", "O_MaterialCalendarView_o_mcv_titleAnimationOrientation"), 0));     // Catch: Throwable -> L36 Exception -> L38
        if (r16 >= 1) goto L10;
    L12:
        this.firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L36 Exception -> L38
    L13:
        this.showWeekDays = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_showWeekDays, "styleable", "O_MaterialCalendarView_o_mcv_showWeekDays"), true);     // Catch: Throwable -> L36 Exception -> L38
        newState().a(this.firstDayOfWeek).a(com.obric.oui.calendar.a.values()[r15]).a(this.showWeekDays).a();     // Catch: Throwable -> L36 Exception -> L38
        setSelectionMode(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_selectionMode, "styleable", "O_MaterialCalendarView_o_mcv_selectionMode"), 1));     // Catch: Throwable -> L36 Exception -> L38
        int r19 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileSize, "styleable", "O_MaterialCalendarView_o_mcv_tileSize"), -10);     // Catch: Throwable -> L36 Exception -> L38
        if (r19 <= (-10)) goto L16;
        setTileSize(r19);     // Catch: Throwable -> L36 Exception -> L38
    L16:
        int r20 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileWidth, "styleable", "O_MaterialCalendarView_o_mcv_tileWidth"), -10);     // Catch: Throwable -> L36 Exception -> L38
        if (r20 <= (-10)) goto L19;
        setTileWidth(r20);     // Catch: Throwable -> L36 Exception -> L38
    L19:
        int r21 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileHeight, "styleable", "O_MaterialCalendarView_o_mcv_tileHeight"), -10);     // Catch: Throwable -> L36 Exception -> L38
        if (r21 <= (-10)) goto L22;
        setTileHeight(r21);     // Catch: Throwable -> L36 Exception -> L38
    L22:
        int r22 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileHSpacing, "styleable", "O_MaterialCalendarView_o_mcv_tileHSpacing"), -10);     // Catch: Throwable -> L36 Exception -> L38
        if (r22 <= (-10)) goto L25;
        setTileHSpacing(r22);     // Catch: Throwable -> L36 Exception -> L38
    L25:
        int r23 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileVSpacing, "styleable", "O_MaterialCalendarView_o_mcv_tileVSpacing"), -10);     // Catch: Throwable -> L36 Exception -> L38
        if (r23 <= (-10)) goto L28;
        setTileVSpacing(r23);     // Catch: Throwable -> L36 Exception -> L38
    L28:
        setLeftArrow(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_leftArrow, "styleable", "O_MaterialCalendarView_o_mcv_leftArrow"), ZeusTransformUtils.mapRes(R.drawable.o_mcv_action_previous, "drawable", "o_mcv_action_previous")));     // Catch: Throwable -> L36 Exception -> L38
        setRightArrow(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_rightArrow, "styleable", "O_MaterialCalendarView_o_mcv_rightArrow"), ZeusTransformUtils.mapRes(R.drawable.o_mcv_action_next, "drawable", "o_mcv_action_next")));     // Catch: Throwable -> L36 Exception -> L38
        setSelectionColor(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_selectionColor, "styleable", "O_MaterialCalendarView_o_mcv_selectionColor"), getThemeAccentColor(r4)));     // Catch: Throwable -> L36 Exception -> L38
        CharSequence[] r0 = r13.getTextArray(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_weekDayLabels, "styleable", "O_MaterialCalendarView_o_mcv_weekDayLabels"));     // Catch: Throwable -> L36 Exception -> L38
        if (r0 == null) goto L31;
        setWeekDayFormatter(new com.obric.oui.calendar.a.a(r0));     // Catch: Throwable -> L36 Exception -> L38
    L31:
        CharSequence[] r1 = r13.getTextArray(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_monthLabels, "styleable", "O_MaterialCalendarView_o_mcv_monthLabels"));     // Catch: Throwable -> L36 Exception -> L38
        if (r1 == null) goto L34;
        setTitleFormatter(new com.obric.oui.calendar.a.f(r1));     // Catch: Throwable -> L36 Exception -> L38
    L34:
        setHeaderTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_headerTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_headerTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_Header, "style", "TextAppearance_MaterialCalendarWidget_Header")));     // Catch: Throwable -> L36 Exception -> L38
        setWeekDayTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_weekDayTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_WeekDay, "style", "TextAppearance_MaterialCalendarWidget_WeekDay")));     // Catch: Throwable -> L36 Exception -> L38
        setDateTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_dateTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_dateTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_Date, "style", "TextAppearance_MaterialCalendarWidget_Date")));     // Catch: Throwable -> L36 Exception -> L38
        setShowOtherDates(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_showOtherDates, "styleable", "O_MaterialCalendarView_o_mcv_showOtherDates"), 4));     // Catch: Throwable -> L36 Exception -> L38
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, "styleable", "O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth"), true));     // Catch: Throwable -> L36 Exception -> L38
    L40:
        r13.recycle();
        setupChildren();
        CalendarDay r2 = CalendarDay.today();
        this.currentMonth = r2;
        setCurrentDate(r2);
        if (isInEditMode() == false) goto L49;
        removeView(this.pager);
        MonthView r3 = new MonthView(this, this.currentMonth, getFirstDayOfWeek(), true);
        r3.setSelectionColor(getSelectionColor());
        r3.setDateTextAppearance(this.adapter.i());
        r3.setWeekDayTextAppearance(this.adapter.j());
        r3.setShowOtherDates(getShowOtherDates());
        addView(r3);
        return;
    L49:
        return;
    L10:
        if (r16 > 7) goto L12;
        this.firstDayOfWeek = DayOfWeek.of(r16);     // Catch: Throwable -> L36 Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r13.recycle();
        throw th;
    L5:
        setClipChildren(true);
        setClipToPadding(true);
        goto L6
    }

    private void setupChildren() {
        addView(this.topbar);
        this.pager.setId(ZeusTransformUtils.mapRes(R.id.mcv_pager, DbHelper.COL_ID, "mcv_pager"));
        this.pager.setOffscreenPageLimit(1);
        addView(this.pager);
    }

    private void updateUi() {
        this.titleChanger.a(this.currentMonth);
        enableView(this.buttonPast, canGoBack());
        enableView(this.buttonFuture, canGoForward());
    }

    public void setSelectionMode(int r6) {
        int r0 = this.selectionMode;
        this.selectionMode = r6;
        boolean r1 = false;
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L9;
        this.selectionMode = 0;
        if (r0 == 0) goto L15;
        clearSelection();
        goto L15
    L9:
        clearSelection();
    L15:
        com.obric.oui.calendar.b<?> r7 = this.adapter;
        if (this.selectionMode == 0) goto L18;
        r1 = true;
    L18:
        r7.b(r1);
        return;
    L10:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void goToPrevious() {
        if (canGoBack() == false) goto L6;
        CalendarPager r2 = this.pager;
        r2.setCurrentItem(r2.getCurrentItem() - 1, true);
        return;
    }

    public void goToNext() {
        if (canGoForward() == false) goto L6;
        CalendarPager r2 = this.pager;
        r2.setCurrentItem(r2.getCurrentItem() + 1, true);
        return;
    }

    public int getSelectionMode() {
        return this.selectionMode;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.tileHeight, this.tileWidth);
    }

    public void setTileSize(int r1) {
        this.tileWidth = r1;
        this.tileHeight = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(dpToPx(r1));
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public void setTileHeight(int r1) {
        this.tileHeight = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(dpToPx(r1));
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public void setTileWidth(int r1) {
        this.tileWidth = r1;
        requestLayout();
    }

    public void setTileHSpacing(int r1) {
        this.tileHSpacing = r1;
        requestLayout();
    }

    public void setTileVSpacing(int r1) {
        this.tileVSpacing = r1;
        requestLayout();
    }

    public int getTileHSpacing() {
        return this.tileHSpacing;
    }

    public int getTileVSpacing() {
        return this.tileVSpacing;
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(dpToPx(r1));
    }

    public void setWeekDaysHeight(int r1) {
        this.weekDaysHeight = r1;
        requestLayout();
    }

    public int getWeekDaysHeight() {
        return this.weekDaysHeight;
    }

    public void setWeekDaysHeightDp(int r1) {
        setWeekDaysHeight(dpToPx(r1));
    }

    private int dpToPx(int r2) {
        return (int) TypedValue.applyDimension(1, r2, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    public boolean canGoForward() {
        if (this.pager.getCurrentItem() < (this.adapter.a() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean canGoBack() {
        if (this.pager.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return this.pager.dispatchTouchEvent(r1);
    }

    public int getSelectionColor() {
        return this.accentColor;
    }

    public void setSelectionColor(int r2) {
        if (r2 == 0) goto L4;
    L7:
        this.accentColor = r2;
        this.adapter.d(r2);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r2 = -7829368;
        goto L7
    }

    public void setContentDescriptionArrowPast(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.buttonPast.setContentDescription(r4);
    }

    public void setContentDescriptionArrowFuture(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.buttonFuture.setContentDescription(r4);
    }

    public void setContentDescriptionCalendar(CharSequence r3) {
        this.calendarContentDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.calendarContentDescription;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_calendar, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_calendar"));
    }

    public void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        this.adapter.b(r4);
    }

    public Drawable getLeftArrow() {
        return this.buttonPast.getDrawable();
    }

    public void setLeftArrow(int r1) {
        this.buttonPast.setImageResource(r1);
    }

    public Drawable getRightArrow() {
        return this.buttonFuture.getDrawable();
    }

    public void setRightArrow(int r1) {
        this.buttonFuture.setImageResource(r1);
    }

    public void setHeaderTextAppearance(int r4) {
        this.title.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public void setDateTextAppearance(int r1) {
        this.adapter.e(r1);
    }

    public void setWeekDayTextAppearance(int r1) {
        this.adapter.g(r1);
    }

    public CalendarDay getSelectedDate() {
        List<CalendarDay> r2 = this.adapter.h();
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), CalendarDay.class, "com.obric.aiagent.plugin");
    }

    public List<CalendarDay> getSelectedDates() {
        return this.adapter.h();
    }

    public void clearSelection() {
        List<CalendarDay> r0 = getSelectedDates();
        this.adapter.g();
        Iterator<CalendarDay> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        dispatchOnDateSelected((CalendarDay) ZeusTransformUtils.preCheckCast(r1.next(), CalendarDay.class, "com.obric.aiagent.plugin"), false);
        goto L4
    }

    public void setSelectedDate(LocalDate r1) {
        setSelectedDate(CalendarDay.from(r1));
    }

    public void setSelectedDate(CalendarDay r2) {
        clearSelection();
        if (r2 == null) goto L6;
        setDateSelected(r2, true);
        return;
    }

    public void setDateSelected(CalendarDay r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.adapter.a(r1, r2);
    }

    public CalendarDay getCurrentDate() {
        return this.adapter.h(this.pager.getCurrentItem());
    }

    public void setCurrentDate(LocalDate r1) {
        setCurrentDate(CalendarDay.from(r1));
    }

    public void setCurrentDate(CalendarDay r2) {
        setCurrentDate(r2, true);
    }

    public void setCurrentDate(CalendarDay r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r4 = this.adapter.a(r2);
        this.pager.setCurrentItem(r4, r3);
        updateUi();
    }

    public CalendarDay getMinimumDate() {
        return this.minDate;
    }

    public CalendarDay getMaximumDate() {
        return this.maxDate;
    }

    public void setShowOtherDates(int r1) {
        this.adapter.f(r1);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.allowClickDaysOutsideCurrentMonth = r1;
    }

    public void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        com.obric.oui.calendar.a.h r4 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.aiagent.plugin");
        com.obric.oui.calendar.b<?> r2 = this.adapter;
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.h.f34372a;
    L5:
        r2.a(r4);
    }

    public void setDayFormatter(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        com.obric.oui.calendar.b<?> r2 = this.adapter;
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.e.f34369a;
    L5:
        r2.a(r4);
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new com.obric.oui.calendar.a.a(r2));
    }

    public void setWeekDayLabels(int r2) {
        setWeekDayLabels(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getTextArray(r2));
    }

    public int getShowOtherDates() {
        return this.adapter.e();
    }

    public boolean allowClickDaysOutsideCurrentMonth() {
        return this.allowClickDaysOutsideCurrentMonth;
    }

    public boolean isShowWeekDays() {
        return this.showWeekDays;
    }

    public void setTitleFormatter(com.obric.oui.calendar.a.g r3) {
        com.obric.oui.calendar.a.g r4 = (com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.aiagent.plugin");
        this.titleChanger.a(r4);
        this.adapter.a(r4);
        updateUi();
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new com.obric.oui.calendar.a.f(r2));
    }

    public void setTitleMonths(int r2) {
        setTitleMonths(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getTextArray(r2));
    }

    public void setTitleAnimationOrientation(int r1) {
        this.titleChanger.a(r1);
    }

    public int getTitleAnimationOrientation() {
        return this.titleChanger.a();
    }

    public void setTopbarVisible(boolean r2) {
        LinearLayout r0 = this.topbar;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public boolean getTopbarVisible() {
        if (this.topbar.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public com.obric.oui.calendar.a getCalendarMode() {
        return this.calendarMode;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.showOtherDates = getShowOtherDates();
        r0.allowClickDaysOutsideCurrentMonth = allowClickDaysOutsideCurrentMonth();
        r0.minDate = getMinimumDate();
        r0.maxDate = getMaximumDate();
        r0.selectedDates = getSelectedDates();
        r0.selectionMode = getSelectionMode();
        r0.topbarVisible = getTopbarVisible();
        r0.dynamicHeightEnabled = this.mDynamicHeightEnabled;
        r0.currentMonth = this.currentMonth;
        r0.cacheCurrentPosition = b.a(this.state);
        return r0;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin"), SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r6.getSuperState());
        state().a().a(r6.minDate).b(r6.maxDate).b(r6.cacheCurrentPosition).a();
        setShowOtherDates(r6.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r6.allowClickDaysOutsideCurrentMonth);
        clearSelection();
        Iterator<CalendarDay> r0 = r6.selectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        setDateSelected((CalendarDay) ZeusTransformUtils.preCheckCast(r0.next(), CalendarDay.class, "com.obric.aiagent.plugin"), true);
        goto L4
    L6:
        setTopbarVisible(r6.topbarVisible);
        setSelectionMode(r6.selectionMode);
        setDynamicHeightEnabled(r6.dynamicHeightEnabled);
        setCurrentDate(r6.currentMonth);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    private void setRangeDates(CalendarDay r3, CalendarDay r4) {
        CalendarDay r0 = this.currentMonth;
        this.adapter.b(r3, r4);
        this.currentMonth = r0;
        if (r3 != null) goto L5;
    L9:
        int r5 = this.adapter.a(r0);
        this.pager.setCurrentItem(r5, false);
        updateUi();
        return;
    L5:
        if (r3.isAfter(r0) == true) goto L8;
        r3 = this.currentMonth;
    L8:
        this.currentMonth = r3;
        goto L9
    }

    private static int getThemeAccentColor(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r0 = android.R.attr.colorAccent;
    L6:
        TypedValue r1 = new TypedValue();
        r6.getTheme().resolveAttribute(r0, r1, true);
        return r1.data;
    L5:
        r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "colorAccent", "attr", r6.getPackageName(), "com.obric.aiagent.plugin");
        goto L6
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.mDynamicHeightEnabled = r1;
    }

    public boolean isDynamicHeightEnabled() {
        return this.mDynamicHeightEnabled;
    }

    public void addDecorators(Collection<? extends d> r3) {
        Collection<? extends d> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.dayViewDecorators.addAll(r4);
        this.adapter.a(this.dayViewDecorators);
    }

    public void addDecorators(d... r1) {
        addDecorators(Arrays.asList(r1));
    }

    public void addDecorator(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.dayViewDecorators.add(r4);
        this.adapter.a(this.dayViewDecorators);
    }

    public void removeDecorators() {
        this.dayViewDecorators.clear();
        this.adapter.a(this.dayViewDecorators);
    }

    public void removeDecorator(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        this.dayViewDecorators.remove(r4);
        this.adapter.a(this.dayViewDecorators);
    }

    public void invalidateDecorators() {
        this.adapter.d();
    }

    public void setOnDateChangedListener(j r3) {
        this.listener = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
    }

    public void setOnDateLongClickListener(i r3) {
        this.longClickListener = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
    }

    public void setOnMonthChangedListener(k r3) {
        this.monthListener = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
    }

    public void setOnRangeSelectedListener(l r3) {
        this.rangeListener = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.aiagent.plugin");
    }

    public void setOnTitleClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.title.setOnClickListener(r4);
    }

    public void dispatchOnDateSelected(CalendarDay r2, boolean r3) {
        j r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onDateSelected(this, r2, r3);
        return;
    }

    public void dispatchOnRangeSelected(List<CalendarDay> r3) {
        List<CalendarDay> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        l r0 = this.rangeListener;
        if (r0 == null) goto L6;
        r0.onRangeSelected(this, r4);
        return;
    }

    public void dispatchOnMonthChanged(CalendarDay r2) {
        k r0 = this.monthListener;
        if (r0 == null) goto L6;
        r0.onMonthChanged(this, r2);
        return;
    }

    public void onDateClicked(CalendarDay r4, boolean r5) {
        int r0 = this.selectionMode;
        if (r0 != 2) goto L5;
        this.adapter.a(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L5:
        if (r0 == 3) goto L7;
        this.adapter.g();
        this.adapter.a(r4, true);
        dispatchOnDateSelected(r4, true);
        return;
    L7:
        List<CalendarDay> r1 = this.adapter.h();
        if (r1.size() != 0) goto L11;
        this.adapter.a(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L11:
        if (r1.size() != 1) goto L19;
        CalendarDay r2 = (CalendarDay) ZeusTransformUtils.preCheckCast(r1.get(0), CalendarDay.class, "com.obric.aiagent.plugin");
        if (r2.equals(r4) == false) goto L16;
        this.adapter.a(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L16:
        if (r2.isAfter(r4) == false) goto L18;
        this.adapter.c(r4, r2);
        dispatchOnRangeSelected(this.adapter.h());
        return;
    L18:
        this.adapter.c(r2, r4);
        dispatchOnRangeSelected(this.adapter.h());
        return;
    L19:
        this.adapter.g();
        this.adapter.a(r4, r5);
        dispatchOnDateSelected(r4, r5);
    }

    public void selectRange(CalendarDay r2, CalendarDay r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r2.isAfter(r3) == false) goto L8;
        this.adapter.c(r3, r2);
        dispatchOnRangeSelected(this.adapter.h());
        return;
    L8:
        this.adapter.c(r2, r3);
        dispatchOnRangeSelected(this.adapter.h());
        return;
    }

    public void onDateClicked(DayView r7) {
        CalendarDay r0 = getCurrentDate();
        CalendarDay r1 = r7.getDate();
        int r2 = r0.getMonth();
        int r3 = r1.getMonth();
        if (this.calendarMode == com.obric.oui.calendar.a.f34362a) goto L5;
    L13:
        onDateClicked(r7.getDate(), !r7.isChecked());
        return;
    L5:
        if (this.allowClickDaysOutsideCurrentMonth == false) goto L13;
        if (r2 == r3) goto L13;
        if (r0.isAfter(r1) == false) goto L11;
        goToPrevious();
        goto L13
    L11:
        if (r0.isBefore(r1) == false) goto L13;
        goToNext();
        goto L13
    }

    public void onDateLongClicked(DayView r2) {
        i r0 = this.longClickListener;
        if (r0 == null) goto L6;
        r0.onDateLongClick(this, r2.getDate());
        return;
    }

    public void onDateUnselected(CalendarDay r2) {
        dispatchOnDateSelected(r2, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public void onMeasure(int r14, int r15) {
        int r0 = View.MeasureSpec.getSize(r14);
        int r16 = View.MeasureSpec.getMode(r14);
        int r1 = View.MeasureSpec.getSize(r15);
        int r17 = View.MeasureSpec.getMode(r15);
        if (this.weekDaysHeight != (-10)) goto L5;
        this.weekDaysHeight = dpToPx(28);
    L5:
        int r2 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = (r1 - getPaddingTop()) - getPaddingBottom();
        int r4 = this.tileWidth;
        if (r4 <= 0) goto L8;
        this.measureInfo.f34333a = r4;
    L9:
        int r5 = this.tileHeight;
        if (r5 <= 0) goto L12;
        this.measureInfo.f34334b = r5;
    L13:
        int r6 = 0;
        int r7 = Math.max(getTileHSpacing(), 0);
        int r8 = Math.max(getTileVSpacing(), 0);
        int r9 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L14:
        if (r6 >= r9) goto L32;
        View r12 = getChildAt(r6);
        if (r12.getVisibility() == 8) goto L31;
        if (r16 != 1073741824) goto L21;
        int r13 = r2;
    L22:
        int r18 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
        if (r17 != 1073741824) goto L25;
        int r19 = r3;
    L30:
        r12.measure(r18, View.MeasureSpec.makeMeasureSpec(r19, 1073741824));
        r10 = Math.max(r10, (r12.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        r11 = Math.max(r11, (r12.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
        goto L31
    L25:
        int r110 = (this.measureInfo.f34334b + r8) * 6;
        if (this.showWeekDays == false) goto L28;
        int r111 = this.weekDaysHeight;
    L29:
        r19 = r110 + r111;
        goto L30
    L28:
        r111 = -r8;
        goto L29
    L21:
        r13 = (this.measureInfo.f34333a * 7) + (r7 * 6);
    L31:
        r6 = r6 + 1;
        goto L14
    L32:
        setMeasuredDimension(r10, r11);
        return;
    L12:
        this.measureInfo.f34334b = dpToPx(40);
        goto L13
    L8:
        this.measureInfo.f34333a = dpToPx(40);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = ((r8 - r6) - r11) - getPaddingRight();
        int r13 = getPaddingTop();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L9;
        View r0 = getChildAt(r14);
        if (r0.getVisibility() == 8) goto L8;
        int r1 = r0.getMeasuredWidth();
        int r3 = ((r12 - r1) / 2) + r11;
        int r2 = r0.getMeasuredHeight() + r13;
        r0.layout(r3, r13, r1 + r3, r2);
        r13 = r2;
    L8:
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.LayoutParams.class);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    public void setPagingEnabled(boolean r2) {
        this.pager.setPagingEnabled(r2);
        updateUi();
    }

    public boolean isPagingEnabled() {
        return this.pager.isPagingEnabled();
    }

    public b state() {
        return this.state;
    }

    public c newState() {
        return new c(this);
    }

    private void commit(b r6) {
        if (this.adapter != null) goto L5;
    L32:
        CalendarDay r0 = null;
    L33:
        this.state = r6;
        this.calendarMode = b.b(r6);
        this.firstDayOfWeek = b.c(r6);
        this.minDate = b.d(r6);
        this.maxDate = b.e(r6);
        this.showWeekDays = b.f(r6);
        int r7 = AnonymousClass4.f34332a[this.calendarMode.ordinal()];
        if (r7 != 1) goto L36;
        com.obric.oui.calendar.b<?> r8 = new h(this);
    L41:
        com.obric.oui.calendar.b<?> r2 = this.adapter;
        if (r2 != null) goto L44;
        this.adapter = r8;
    L45:
        this.adapter.a(this.showWeekDays);
        this.pager.setAdapter(this.adapter);
        setRangeDates(this.minDate, this.maxDate);
        if (this.selectionMode == 1) goto L48;
    L50:
        CalendarDay r9 = CalendarDay.today();
    L51:
        setCurrentDate(r9);
        if (r0 == null) goto L54;
        this.pager.setCurrentItem(this.adapter.a(r0));
    L54:
        invalidateDecorators();
        updateUi();
        return;
    L48:
        if (this.adapter.h().isEmpty() == true) goto L50;
        r9 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.adapter.h().get(0), CalendarDay.class, "com.obric.aiagent.plugin");
        goto L51
    L44:
        this.adapter = r2.a(r8);
        goto L45
    L36:
        if (r7 != 2) goto L39;
        r8 = new o(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (b.a(r6) == false) goto L32;
        r0 = this.adapter.h(this.pager.getCurrentItem());
        if (this.calendarMode == b.b(r6)) goto L33;
        CalendarDay r1 = getSelectedDate();
        if (this.calendarMode != com.obric.oui.calendar.a.f34362a) goto L19;
        if (r1 == null) goto L19;
        CalendarDay r3 = CalendarDay.from(r0.getDate().plusDays(1));
        if (r1.equals(r0) == false) goto L14;
    L30:
        r0 = r1;
        goto L33
    L14:
        if (r1.isAfter(r0) == false) goto L33;
        if (r1.isBefore(r3) == false) goto L33;
    L19:
        if (this.calendarMode != com.obric.oui.calendar.a.f34363b) goto L33;
        CalendarDay r4 = CalendarDay.from(r0.getDate().plusDays(6));
        if (r1 != null) goto L23;
    L31:
        r0 = r4;
        goto L33
    L23:
        if (r1.equals(r0) == true) goto L30;
        if (r1.equals(r4) == true) goto L30;
        if (r1.isAfter(r0) == false) goto L31;
        if (r1.isBefore(r4) == false) goto L31;
        goto L30
    }

    private static void enableView(View r0, boolean r1) {
        r0.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r0.setAlpha(r2);
        return;
    L5:
        r2 = 0.1f;
        goto L6
    }

    public a getMeasureInfo() {
        return this.measureInfo;
    }
}
