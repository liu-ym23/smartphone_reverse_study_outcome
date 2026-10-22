package com.obric.oui.calendar;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.p;
import d.x;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: ODatePickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ODatePickerView extends ConstraintLayout {
    public static final a Companion = null;
    public static final int MONTH_ID = 1002;
    private static final long SYNC_CALENDAR_DEBOUNCE_MS = 100;
    public static final String TAG = "DatePickerView";
    public static final int YEAR_FROM = 1900;
    public static final int YEAR_ID = 1001;
    public static final int YEAR_TO = 2100;
    private ObjectAnimator alphaInAnimator;
    private ObjectAnimator alphaOutAnimator;
    private com.obric.common.oea.foundation.animation.manager.d arrowAnimator;
    private MaterialCalendarView calendarView;
    private TextView currentDateTextView;
    private int currentDayOfMonth;
    private int currentMonth;
    private int currentYear;
    private String dateFormat;
    private b datePickerMode;
    private com.obric.common.oea.foundation.animation.manager.d fadeInAnimator;
    private com.obric.common.oea.foundation.animation.manager.d fadeOutAnimator;
    private FrameLayout flCalendarContainer;
    private boolean isSyncingFromCalendar;
    private boolean isSyncingFromPicker;
    private boolean isYearMonthOpen;
    private ImageView ivOpenYearMonth;
    private View llOpenYearMonth;
    private long mSelectTime;
    private int millisecond;
    private ImageView nextBtn;
    private d.h.a.b<? super Long, x> onDateChangedListener;
    private d.h.a.b<? super Long, x> onDateLongClickListener;
    private d.h.a.b<? super Long, x> onMonthChangedListener;
    private d.h.a.b<? super List<Long>, x> onRangeSelectedListener;
    private c outOfMonthVisibility;
    private View pickerView;
    private ImageView previousBtn;
    private int second;
    private boolean selectDateOnMonthChange;
    private Runnable syncCalendarRunnable;

    /* JADX INFO: compiled from: ODatePickerView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34345a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f34346b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f34347c = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f34345a, f34346b};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f34347c.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34345a = new b("BOARD_SHEET", 0);
            f34346b = new b("NARROW_SHEET", 1);
            f34347c = a();
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34348a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f34349b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f34350c = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f34348a, f34349b};
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f34350c.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34348a = new c("GREY", 0);
            f34349b = new c("HIDE", 1);
            f34350c = a();
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34351a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f34352b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f34353c = null;

        static {
            int[] r0 = new int[c.values().length];
            r0[c.f34349b.ordinal()] = 1;
            r0[c.f34348a.ordinal()] = 2;
            f34351a = r0;
            int[] r1 = new int[DayOfWeek.values().length];
            r1[DayOfWeek.SUNDAY.ordinal()] = 1;
            r1[DayOfWeek.MONDAY.ordinal()] = 2;
            r1[DayOfWeek.TUESDAY.ordinal()] = 3;
            r1[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r1[DayOfWeek.THURSDAY.ordinal()] = 5;
            r1[DayOfWeek.FRIDAY.ordinal()] = 6;
            r1[DayOfWeek.SATURDAY.ordinal()] = 7;
            f34352b = r1;
            int[] r2 = new int[b.values().length];
            r2[b.f34345a.ordinal()] = 1;
            r2[b.f34346b.ordinal()] = 2;
            f34353c = r2;
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class e extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34354a;

        e(View r1) {
            this.f34354a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            d.h.b.o.e(r2, "$noName_0");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r4, "$noName_2");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            this.f34354a.setScaleX(r5);
            this.f34354a.setScaleY(r5);
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class f extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34356b;

        f(View r1, float r2) {
            this.f34355a = r1;
            this.f34356b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            this.f34355a.setVisibility(4);
            this.f34355a.setScaleX(this.f34356b);
            this.f34355a.setScaleY(this.f34356b);
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class g extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34357a;

        g(View r1) {
            this.f34357a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            d.h.b.o.e(r2, "$noName_0");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r4, "$noName_2");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            this.f34357a.setScaleX(r5);
            this.f34357a.setScaleY(r5);
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class h extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34359b;

        h(View r1, float r2) {
            this.f34358a = r1;
            this.f34359b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            this.f34358a.setVisibility(0);
            this.f34358a.setScaleX(this.f34359b);
            this.f34358a.setScaleY(this.f34359b);
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class i extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODatePickerView f34360a;

        i(ODatePickerView r1) {
            this.f34360a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            d.h.b.o.e(r2, "$noName_0");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r4, "$noName_2");
            ODatePickerView.access$getIvOpenYearMonth$p(this.f34360a).setRotation(((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    static final class j extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f34361a = null;

        static {
            f34361a = new j();
        }

        j() {
            super(2);
        }

        public final void a(boolean r1, Throwable r2) {
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public ODatePickerView(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, null, false, 30, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, null, false, 28, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r13, null, false, 24, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12, int r13, b r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r14, "datePickerMode");
        this(r3, r4, r13, r14, false, 16, null);
    }

    /* JADX INFO: renamed from: lambda$-Pj-wFp7ztrW-fHVo5hBjL95r48, reason: not valid java name */
    public static /* synthetic */ void m986lambda$PjwFp7ztrWfHVo5hBjL95r48(ODatePickerView r0, View r1) {
        m977initCalendar$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$-fshZPTFAoiUO8u5XABDEjwHNus, reason: not valid java name */
    public static /* synthetic */ void m987lambda$fshZPTFAoiUO8u5XABDEjwHNus(ODatePickerView r0, View r1) {
        m978initCalendar$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$FvnkrZI5-HUuLVyHgyYvwOSki6c, reason: not valid java name */
    public static /* synthetic */ void m988lambda$FvnkrZI5HUuLVyHgyYvwOSki6c(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3) {
        m979initCalendar$lambda2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$G3N90oRQy4n0zhYEij4d2SMVD8M(ODatePickerView r0, com.obric.oui.picker.reels.a.a.b r1) {
        m983initYearAndMonthPickerView$lambda13$lambda12(r0, r1);
    }

    public static /* synthetic */ void lambda$GGLDul4TvEAvNG979BvkKkFcGxk(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3, boolean r4) {
        m980initCalendar$lambda3(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$LOqJ8s4D6PtXdkxcOgLeO0gx-yM, reason: not valid java name */
    public static /* synthetic */ void m989lambda$LOqJ8s4D6PtXdkxcOgLeO0gxyM(ODatePickerView r0, MaterialCalendarView r1, List r2) {
        m982initCalendar$lambda6(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$lWzDrVUB06jCiHrTVrXnF5reZXU(ODatePickerView r0, int r1) {
        m984initYearAndMonthPickerView$lambda13$lambda12$lambda11(r0, r1);
    }

    public static /* synthetic */ void lambda$rX7eTU5wEBxzaBoxLjuCFb7oKTA(ODatePickerView r0, View r1) {
        m985initYearAndMonthPickerView$lambda15(r0, r1);
    }

    public static /* synthetic */ void lambda$zhlqzHHj5T8IgJHhRDEWJMVLFXE(ODatePickerView r0, MaterialCalendarView r1, CalendarDay r2) {
        m981initCalendar$lambda4(r0, r1, r2);
    }

    public static final /* synthetic */ ImageView access$getIvOpenYearMonth$p(ODatePickerView r0) {
        return r0.ivOpenYearMonth;
    }

    public /* synthetic */ ODatePickerView(Context r4, AttributeSet r5, int r6, b r7, boolean r8, int r9, d.h.b.h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        boolean r0 = false;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) == 0) goto L12;
        r7 = b.f34345a;
    L12:
        b r2 = r7;
        if ((r9 & 16) != 0) goto L16;
        r0 = r8;
    L16:
        this(r11, r13, r1, r2, r0);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    public ODatePickerView(Context r3, AttributeSet r4, int r5, b r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        d.h.b.o.e(r6, "datePickerMode");
        super(r8, r9, r5);
        this.datePickerMode = r6;
        this.selectDateOnMonthChange = r7;
        this.currentDayOfMonth = CalendarDay.today().getDay();
        this.currentYear = CalendarDay.today().getYear();
        this.currentMonth = CalendarDay.today().getMonth();
        this.outOfMonthVisibility = c.f34348a;
        ConstraintLayout.inflate(r8, ZeusTransformUtils.mapRes(R.layout.o_date_picker_view_default, "layout", "o_date_picker_view_default"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        String r10 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_date_picker_date_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_date_picker_date_format"));
        d.h.b.o.c(r10, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r10;
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.calendarView, DbHelper.COL_ID, "calendarView"));
        d.h.b.o.c(r11, "findViewById(R.id.calendarView)");
        this.calendarView = (MaterialCalendarView) ZeusTransformUtils.preCheckCast(r11, MaterialCalendarView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.previousBtn, DbHelper.COL_ID, "previousBtn"));
        d.h.b.o.c(r12, "findViewById(R.id.previousBtn)");
        this.previousBtn = (ImageView) ZeusTransformUtils.preCheckCast(r12, ImageView.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.nextBtn, DbHelper.COL_ID, "nextBtn"));
        d.h.b.o.c(r13, "findViewById(R.id.nextBtn)");
        this.nextBtn = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.aiagent.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.currentDateTextView, DbHelper.COL_ID, "currentDateTextView"));
        d.h.b.o.c(r14, "findViewById(R.id.currentDateTextView)");
        this.currentDateTextView = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_open_year_month, DbHelper.COL_ID, "ll_open_year_month"));
        d.h.b.o.c(r15, "findViewById(R.id.ll_open_year_month)");
        this.llOpenYearMonth = r15;
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_open_year_month, DbHelper.COL_ID, "iv_open_year_month"));
        d.h.b.o.c(r16, "findViewById(R.id.iv_open_year_month)");
        this.ivOpenYearMonth = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_calendar_container, DbHelper.COL_ID, "fl_calendar_container"));
        d.h.b.o.c(r17, "findViewById(R.id.fl_calendar_container)");
        this.flCalendarContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.aiagent.plugin");
        initView();
    }

    public final d.h.a.b<Long, x> getOnMonthChangedListener() {
        return this.onMonthChangedListener;
    }

    public final void setOnMonthChangedListener(d.h.a.b<? super Long, x> r3) {
        this.onMonthChangedListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.b<Long, x> getOnDateChangedListener() {
        return this.onDateChangedListener;
    }

    public final void setOnDateChangedListener(d.h.a.b<? super Long, x> r3) {
        this.onDateChangedListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.b<Long, x> getOnDateLongClickListener() {
        return this.onDateLongClickListener;
    }

    public final void setOnDateLongClickListener(d.h.a.b<? super Long, x> r3) {
        this.onDateLongClickListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.b<List<Long>, x> getOnRangeSelectedListener() {
        return this.onRangeSelectedListener;
    }

    public final void setOnRangeSelectedListener(d.h.a.b<? super List<Long>, x> r3) {
        this.onRangeSelectedListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    private final void initView() {
        initCalendar();
        initYearAndMonthPickerView();
    }

    private final void initCalendar() {
        final Calendar r0 = Calendar.getInstance();
        this.calendarView.setTopbarVisible(false);
        this.previousBtn.setOnClickListener(new $$Lambda$ODatePickerView$PjwFp7ztrWfHVo5hBjL95r48(this));
        this.nextBtn.setOnClickListener(new $$Lambda$ODatePickerView$fshZPTFAoiUO8u5XABDEjwHNus(this));
        this.calendarView.setOnMonthChangedListener(new $$Lambda$ODatePickerView$FvnkrZI5HUuLVyHgyYvwOSki6c(r0, this));
        this.calendarView.setOnDateChangedListener(new $$Lambda$ODatePickerView$GGLDul4TvEAvNG979BvkKkFcGxk(r0, this));
        this.calendarView.setOnDateLongClickListener(new $$Lambda$ODatePickerView$zhlqzHHj5T8IgJHhRDEWJMVLFXE(this));
        this.calendarView.setOnRangeSelectedListener(new $$Lambda$ODatePickerView$LOqJ8s4D6PtXdkxcOgLeO0gxyM(this));
        applyOutOfMonthVisibility();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-0, reason: not valid java name */
    private static final void m977initCalendar$lambda0(ODatePickerView r0, View r1) {
        d.h.b.o.e(r0, "this$0");
        r0.calendarView.goToPrevious();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-1, reason: not valid java name */
    private static final void m978initCalendar$lambda1(ODatePickerView r0, View r1) {
        d.h.b.o.e(r0, "this$0");
        r0.calendarView.goToNext();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-2, reason: not valid java name */
    private static final void m979initCalendar$lambda2(Calendar r5, ODatePickerView r6, MaterialCalendarView r7, CalendarDay r8) {
        d.h.b.o.e(r6, "this$0");
        com.obric.oui.common.util.e.f34568a.c(TAG, "setOnMonthChangedListener widget:" + r7 + ",date:" + r8);
        r5.set(r8.getYear(), r8.getMonth() - 1, 1);
        long r2 = r5.getTimeInMillis();
        r6.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.formatDate13(r2, r6.dateFormat), CharSequence.class, "com.obric.aiagent.plugin"));
        r6.currentYear = r8.getYear();
        r6.currentMonth = r8.getMonth();
        if (r6.selectDateOnMonthChange == false) goto L5;
        r6.calendarView.setSelectedDate(CalendarDay.from(r8.getYear(), r8.getMonth(), 1));
    L5:
        d.h.b.o.c(r8, "date");
        r6.syncPicker(r8);
        d.h.a.b<? super Long, x> r9 = r6.onMonthChangedListener;
        if (r9 == null) goto L10;
        r9.invoke(Long.valueOf(r2));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-3, reason: not valid java name */
    private static final void m980initCalendar$lambda3(Calendar r3, ODatePickerView r4, MaterialCalendarView r5, CalendarDay r6, boolean r7) {
        d.h.b.o.e(r4, "this$0");
        d.h.b.o.e(r5, "widget");
        d.h.b.o.e(r6, "date");
        com.obric.oui.common.util.e.f34568a.c(TAG, "setOnDateChangedListener widget:" + r5 + ",date:" + r6 + ",selected:" + r7);
        r3.set(r6.getYear(), r6.getMonth() - 1, r6.getDay());
        long r0 = r3.getTimeInMillis();
        r4.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.formatDate13(r0, r4.dateFormat), CharSequence.class, "com.obric.aiagent.plugin"));
        r4.currentDayOfMonth = r6.getDay();
        r4.currentYear = r6.getYear();
        r4.currentMonth = r6.getMonth();
        d.h.a.b<? super Long, x> r8 = r4.onDateChangedListener;
        if (r8 == null) goto L7;
        r8.invoke(Long.valueOf(r0));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-4, reason: not valid java name */
    private static final void m981initCalendar$lambda4(ODatePickerView r2, MaterialCalendarView r3, CalendarDay r4) {
        d.h.b.o.e(r2, "this$0");
        d.h.b.o.e(r3, "widget");
        d.h.b.o.e(r4, "date");
        d.h.a.b<? super Long, x> r5 = r2.onDateLongClickListener;
        if (r5 == null) goto L7;
        r5.invoke(Long.valueOf(r2.toTimestamp(r4)));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-6, reason: not valid java name */
    private static final void m982initCalendar$lambda6(ODatePickerView r4, MaterialCalendarView r5, List r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "this$0");
        d.h.b.o.e(r5, "widget");
        d.h.b.o.e(r7, "dates");
        d.h.a.b<? super List<Long>, x> r8 = r4.onRangeSelectedListener;
        if (r8 == null) goto L12;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        CalendarDay r2 = (CalendarDay) ZeusTransformUtils.preCheckCast(r10.next(), CalendarDay.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "it");
        r0.add(Long.valueOf(r4.toTimestamp(r2)));
        goto L7
    L9:
        r8.invoke((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void syncPicker(CalendarDay r7) {
        if (this.isSyncingFromPicker == false) goto L6;
        this.isSyncingFromPicker = false;
        return;
    L6:
        View r0 = this.pickerView;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.picker.reels.a.class) == false) goto L9;
        com.obric.oui.picker.reels.a r1 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
    L10:
        if (r1 == null) goto L26;
        int r2 = d.l.n.c(r7.getYear() - 1900, 0);
        int r8 = d.l.n.a(r7.getMonth() - 1, 0, 11);
        this.isSyncingFromCalendar = true;
        WheelView r4 = r1.getReelView(0);
        if (r4 != null) goto L16;
    L18:
        WheelView r3 = r1.getReelView(1);
        if (r3 != null) goto L22;
    L24:
        this.isSyncingFromCalendar = false;
        return;
    L22:
        if (r3.getCurrentIndex() == r8) goto L24;
        r3.setCurrentIndex(r8, false);
        goto L24
    L16:
        if (r4.getCurrentIndex() == r2) goto L18;
        r4.setCurrentIndex(r2, false);
        goto L18
    L26:
        return;
    L9:
        r1 = null;
        goto L10
    }

    private final void initYearAndMonthPickerView() {
        com.obric.oui.picker.reels.a.a.C0970a r0 = new com.obric.oui.picker.reels.a.a.C0970a();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "context");
        com.obric.oui.picker.reels.a.a.C0970a r2 = r0.a(r1, 1001, YEAR_FROM, YEAR_TO, Integer.valueOf(this.currentYear), Integer.valueOf(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 164)));
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "context");
        com.obric.oui.picker.reels.a.a.C0970a r4 = r2.a(r3, 1002, Integer.valueOf(this.currentMonth), Integer.valueOf(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 164)));
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "context");
        com.obric.oui.picker.reels.a.a.C0970a r6 = r4.a(com.obric.common.oea.foundation.b.a.a(r5)).b(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 258));
        r6.a(new $$Lambda$ODatePickerView$G3N90oRQy4n0zhYEij4d2SMVD8M(this));
        com.obric.oui.picker.reels.a.b r7 = (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin");
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r8, "context");
        View r9 = ((com.obric.oui.picker.reels.a.a) ZeusTransformUtils.preCheckCast(com.obric.oui.picker.reels.a.b.a.a(r7, r8, null, 0, 6, null), com.obric.oui.picker.reels.a.a.class, "com.obric.aiagent.plugin")).a();
        if (r9 != null) goto L5;
        r9 = null;
    L6:
        this.pickerView = r9;
        this.llOpenYearMonth.setOnClickListener(new $$Lambda$ODatePickerView$rX7eTU5wEBxzaBoxLjuCFb7oKTA(this));
        return;
    L5:
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, r9.getLayoutParams().height);
        r10.gravity = 17;
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r9.setAlpha(0.0f);
        r9.setVisibility(4);
        this.flCalendarContainer.addView(r9);
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12, reason: not valid java name */
    private static final void m983initYearAndMonthPickerView$lambda13$lambda12(final ODatePickerView r5, com.obric.oui.picker.reels.a.a.b r6) {
        d.h.b.o.e(r5, "this$0");
        d.h.b.o.e(r6, "it");
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r6.a().get(1001), Integer.class, "com.obric.aiagent.plugin");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6.a().get(1002), Integer.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        int r1 = r5.currentYear;
    L6:
        r5.currentYear = r1;
        if (r7 != null) goto L9;
        int r8 = r5.currentMonth;
    L10:
        r5.currentMonth = r8;
        Calendar r9 = Calendar.getInstance();
        final int r2 = r5.currentYear + YEAR_FROM;
        r9.set(r2, d.l.n.c(r5.currentMonth, 0), 1);
        String r10 = r5.formatDate13(r9.getTimeInMillis(), r5.dateFormat);
        r5.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r5.isSyncingFromCalendar == false) goto L13;
        return;
    L13:
        Runnable r11 = r5.syncCalendarRunnable;
        if (r11 == null) goto L17;
        r5.removeCallbacks(r11);
    L17:
        Runnable r12 = new $$Lambda$ODatePickerView$lWzDrVUB06jCiHrTVrXnF5reZXU(r5, r2);
        r5.syncCalendarRunnable = r12;
        r5.postDelayed(r12, 100);
        return;
    L9:
        r8 = r7.intValue();
        goto L10
    L5:
        r1 = r0.intValue();
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12$lambda-11, reason: not valid java name */
    private static final void m984initYearAndMonthPickerView$lambda13$lambda12$lambda11(ODatePickerView r1, int r2) {
        d.h.b.o.e(r1, "this$0");
        r1.syncCalendar(r2);
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-15, reason: not valid java name */
    private static final void m985initYearAndMonthPickerView$lambda15(ODatePickerView r7, View r8) {
        d.h.b.o.e(r7, "this$0");
        com.obric.common.oea.foundation.animation.manager.d r9 = r7.arrowAnimator;
        if (r9 == null) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a(r9, false, 1, null);
    L6:
        float r10 = r7.ivOpenYearMonth.getRotation();
        float r4 = 0.0f;
        if (r7.isYearMonthOpen == true) goto L9;
        float r3 = 90.0f;
    L10:
        r7.showRotateAnimation(r10, r3);
        if (r7.isYearMonthOpen == true) goto L13;
        View r11 = r7.pickerView;
    L15:
        if (r7.isYearMonthOpen == true) goto L17;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r7.calendarView, View.class, "com.obric.aiagent.plugin");
    L18:
        com.obric.common.oea.foundation.animation.manager.d r6 = r7.fadeOutAnimator;
        if (r6 == null) goto L22;
        com.obric.common.oea.foundation.animation.manager.d.a(r6, false, 1, null);
    L22:
        com.obric.common.oea.foundation.animation.manager.d r12 = r7.fadeInAnimator;
        if (r12 == null) goto L26;
        com.obric.common.oea.foundation.animation.manager.d.a(r12, false, 1, null);
    L26:
        ObjectAnimator r0 = r7.alphaOutAnimator;
        if (r0 == null) goto L30;
        r0.cancel();
    L30:
        ObjectAnimator r1 = r7.alphaInAnimator;
        if (r1 == null) goto L34;
        r1.cancel();
    L34:
        if (r5 != null) goto L36;
        float r2 = 1.0f;
    L37:
        if (r11 == null) goto L40;
        r4 = r11.getAlpha();
    L40:
        if (r11 == null) goto L43;
        r11.setAlpha(r4);
    L43:
        if (r5 == null) goto L46;
        r5.setAlpha(r2);
    L46:
        r7.showAlphaAnimation(r2, r5, r11);
        r7.isYearMonthOpen = !r7.isYearMonthOpen;
        return;
    L36:
        r2 = r5.getAlpha();
        goto L37
    L17:
        r5 = r7.pickerView;
        goto L18
    L13:
        r11 = (View) ZeusTransformUtils.preCheckCast(r7.calendarView, View.class, "com.obric.aiagent.plugin");
        goto L15
    L9:
        r3 = 0.0f;
        goto L10
    }

    private final void syncCalendar(int r5) {
        if (this.isSyncingFromCalendar == false) goto L5;
        return;
    L5:
        int r0 = this.currentMonth + 1;
        CalendarDay r2 = this.calendarView.getCurrentDate();
        if (r2.getYear() == r5) goto L8;
    L9:
        this.isSyncingFromPicker = true;
        this.calendarView.setCurrentDate(CalendarDay.from(r5, r0, 1));
        return;
    L8:
        if (r2.getMonth() != r0) goto L9;
    }

    private final void applyOutOfMonthVisibility() {
        int r0 = d.f34351a[this.outOfMonthVisibility.ordinal()];
        boolean r1 = false;
        if (r0 != 1) goto L5;
        int r2 = 0;
    L10:
        this.calendarView.setShowOtherDates(r2);
        MaterialCalendarView r3 = this.calendarView;
        if (this.outOfMonthVisibility != c.f34348a) goto L13;
        r1 = true;
    L13:
        r3.setAllowClickDaysOutsideCurrentMonth(r1);
        return;
    L5:
        if (r0 != 2) goto L8;
        r2 = 7;
        goto L10
    L8:
        throw new d.k();
    }

    public final MaterialCalendarView getCalendarView() {
        return this.calendarView;
    }

    public final void setOutOfMonthVisibility(c r2) {
        d.h.b.o.e(r2, "visibility");
        this.outOfMonthVisibility = r2;
        applyOutOfMonthVisibility();
    }

    private final void showRotateAnimation(float r9, float r10) {
        this.arrowAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), r9, r10, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32441d, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new i(this), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(j.f34361a, d.h.a.m.class, "com.obric.aiagent.plugin")).a().a();
    }

    private final void showAlphaAnimation(float r26, View r27, View r28) {
        PathInterpolator r3 = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        if (r27 == null) goto L6;
        r27.setVisibility(0);
    L6:
        if (r28 == null) goto L9;
        r28.setVisibility(0);
    L9:
        com.obric.common.oea.foundation.animation.manager.d r13 = null;
        if (r27 == null) goto L16;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r27, "alpha", new float[]{r26, 0.0f});
        r15.setDuration(50);
        r15.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        this.alphaOutAnimator = r15;
        if (r27 != this.pickerView) goto L14;
        float r8 = 1.05f;
    L15:
        com.obric.common.oea.foundation.animation.a.d.a r18 = new com.obric.common.oea.foundation.animation.a.d.a();
        com.obric.common.oea.foundation.animation.g.a.b r9 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null);
        r9.a(0.001f);
        x r10 = x.f38692a;
        com.obric.common.oea.foundation.animation.a.d r1 = com.obric.common.oea.foundation.animation.a.d.a.a(r18, 1.0f, r8, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r9, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new e(r27), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r27, r8), d.h.a.m.class, "com.obric.aiagent.plugin")).a();
    L17:
        if (r28 == null) goto L23;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r28, "alpha", new float[]{r28.getAlpha(), 1.0f});
        r11.setDuration(200);
        r11.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        this.alphaInAnimator = r11;
        if (r28 != this.pickerView) goto L21;
        float r4 = 1.05f;
    L22:
        r28.setScaleX(r4);
        r28.setScaleY(r4);
        com.obric.common.oea.foundation.animation.a.d.a r17 = new com.obric.common.oea.foundation.animation.a.d.a();
        com.obric.common.oea.foundation.animation.g.a.b r5 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null);
        r5.a(0.001f);
        x r6 = x.f38692a;
        com.obric.common.oea.foundation.animation.a.d r2 = com.obric.common.oea.foundation.animation.a.d.a.a(r17, r4, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new g(r28), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r28, 1.0f), d.h.a.m.class, "com.obric.aiagent.plugin")).a();
    L24:
        if (r1 != null) goto L26;
        com.obric.common.oea.foundation.animation.manager.d r7 = null;
    L27:
        this.fadeOutAnimator = r7;
        if (r2 == null) goto L31;
        r13 = r2.a();
    L31:
        this.fadeInAnimator = r13;
        ObjectAnimator r12 = this.alphaOutAnimator;
        if (r12 == null) goto L35;
        r12.start();
    L35:
        ObjectAnimator r0 = this.alphaInAnimator;
        if (r0 == null) goto L40;
        r0.start();
        return;
    L40:
        return;
    L26:
        r7 = r1.a();
        goto L27
    L21:
        r4 = 0.95f;
        goto L22
    L23:
        r2 = null;
        goto L24
    L14:
        r8 = 0.95f;
        goto L15
    L16:
        r1 = null;
        goto L17
    }

    private final void setDefaultDate() {
        Calendar r0 = Calendar.getInstance();
        com.obric.oui.common.util.e.f34568a.c(TAG, "默认选中的时间:" + this.mSelectTime + " , mSelectTime:" + this.mSelectTime);
        r0.setTimeInMillis(this.mSelectTime);
        int r2 = r0.get(1);
        int r4 = r0.get(2) + 1;
        int r1 = r0.get(5);
        int r5 = r0.get(11);
        int r6 = r0.get(12);
        int r7 = r0.get(13);
        int r3 = r0.get(14);
        this.currentDayOfMonth = r1;
        com.obric.oui.common.util.e.f34568a.c(TAG, "转化时间year:" + r2 + ",month:" + r4 + ",day:" + r1 + ",hour:" + r5 + ",minute:" + r6 + ", selectDate:" + CalendarDay.from(r2, r4, r1));
        String r8 = formatDate13(this.mSelectTime, this.dateFormat);
        this.calendarView.setCurrentDate(CalendarDay.from(r2, r4, r1));
        this.calendarView.setSelectedDate(CalendarDay.from(r2, r4, r1));
        this.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        setSecond(r7);
        setMillisecond(r3);
    }

    public final long getSelectTimestamp() {
        Calendar r6 = Calendar.getInstance();
        CalendarDay r0 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.calendarView.getSelectedDates().get(0), CalendarDay.class, "com.obric.aiagent.plugin");
        int r1 = r0.getYear();
        int r2 = r0.getMonth() - 1;
        int r3 = r0.getDay();
        r6.set(13, getSecond());
        r6.set(14, getMillisecond());
        r6.set(r1, r2, r3, 0, 0);
        return r6.getTimeInMillis();
    }

    private final void setSecond(int r1) {
        this.second = r1;
    }

    private final int getSecond() {
        return this.second;
    }

    private final void setMillisecond(int r1) {
        this.millisecond = r1;
    }

    private final int getMillisecond() {
        return this.millisecond;
    }

    private final String formatDate13(long r1, String r3) {
        Date r0 = new Date(r1);
        SimpleDateFormat r2 = new SimpleDateFormat(r3, Locale.getDefault());
        r2.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r4 = r2.format(r0);
        d.h.b.o.c(r4, "format1.format(date)");
        return r4;
    }

    public final void setCurrentTimeMillis(long r1) {
        this.mSelectTime = r1;
        setDefaultDate();
    }

    public final void setSelectionMode(int r1) {
        this.calendarView.setSelectionMode(r1);
    }

    public final int getSelectionMode() {
        return this.calendarView.getSelectionMode();
    }

    public final void setSelectionColor(int r1) {
        this.calendarView.setSelectionColor(r1);
    }

    public final int getSelectionColor() {
        return this.calendarView.getSelectionColor();
    }

    public final void setDateTextAppearance(int r1) {
        this.calendarView.setDateTextAppearance(r1);
    }

    public final void setWeekDayTextAppearance(int r1) {
        this.calendarView.setWeekDayTextAppearance(r1);
    }

    public final void setDayFormatter(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        this.calendarView.setDayFormatter(r4);
    }

    public final void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        this.calendarView.setDayFormatterContentDescription(r4);
    }

    public final void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        com.obric.oui.calendar.a.h r4 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.aiagent.plugin");
        this.calendarView.setWeekDayFormatter(r4);
    }

    public final void setWeekDayLabels(CharSequence[] r2) {
        d.h.b.o.e(r2, "weekDayLabels");
        this.calendarView.setWeekDayLabels(r2);
    }

    public final void setWeekDayLabels(int r1) {
        this.calendarView.setWeekDayLabels(r1);
    }

    public final void setShowWeekDays(boolean r1) {
        this.calendarView.state().a().a(r1).a();
    }

    public final boolean isShowWeekDays() {
        return this.calendarView.isShowWeekDays();
    }

    public static /* synthetic */ void setCalendarDisplayMode$default(ODatePickerView r0, com.obric.oui.calendar.a r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setCalendarDisplayMode(r1, r2);
    }

    public final void setCalendarDisplayMode(com.obric.oui.calendar.a r2, boolean r3) {
        d.h.b.o.e(r2, "mode");
        this.calendarView.state().a().a(r2).b(r3).a();
    }

    public final com.obric.oui.calendar.a getCalendarMode() {
        com.obric.oui.calendar.a r1 = this.calendarView.getCalendarMode();
        d.h.b.o.c(r1, "calendarView.calendarMode");
        return r1;
    }

    public final void setDateRange(CalendarDay r1, CalendarDay r2) {
        this.calendarView.state().a().a(r1).b(r2).a();
    }

    public final void setMinimumDate(CalendarDay r1) {
        this.calendarView.state().a().a(r1).a();
    }

    public final CalendarDay getMinimumDate() {
        return this.calendarView.getMinimumDate();
    }

    public final void setMaximumDate(CalendarDay r1) {
        this.calendarView.state().a().b(r1).a();
    }

    public final CalendarDay getMaximumDate() {
        return this.calendarView.getMaximumDate();
    }

    public final void setShowOtherDates(int r1) {
        this.calendarView.setShowOtherDates(r1);
    }

    public final int getShowOtherDates() {
        return this.calendarView.getShowOtherDates();
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.calendarView.setAllowClickDaysOutsideCurrentMonth(r1);
    }

    public final boolean allowClickDaysOutsideCurrentMonth() {
        return this.calendarView.allowClickDaysOutsideCurrentMonth();
    }

    public final void setPagingEnabled(boolean r1) {
        this.calendarView.setPagingEnabled(r1);
    }

    public final boolean isPagingEnabled() {
        return this.calendarView.isPagingEnabled();
    }

    public final void setDynamicHeightEnabled(boolean r1) {
        this.calendarView.setDynamicHeightEnabled(r1);
    }

    public final boolean isDynamicHeightEnabled() {
        return this.calendarView.isDynamicHeightEnabled();
    }

    public final void setTileSize(int r1) {
        this.calendarView.setTileSize(r1);
    }

    public final void setTileSizeDp(int r1) {
        this.calendarView.setTileSizeDp(r1);
    }

    public final void setTileWidth(int r1) {
        this.calendarView.setTileWidth(r1);
    }

    public final void setTileWidthDp(int r1) {
        this.calendarView.setTileWidthDp(r1);
    }

    public final int getTileWidth() {
        return this.calendarView.getTileWidth();
    }

    public final void setTileHeight(int r1) {
        this.calendarView.setTileHeight(r1);
    }

    public final void setTileHeightDp(int r1) {
        this.calendarView.setTileHeightDp(r1);
    }

    public final int getTileHeight() {
        return this.calendarView.getTileHeight();
    }

    public final void setTileHSpacing(int r1) {
        this.calendarView.setTileHSpacing(r1);
    }

    public final int getTileHSpacing() {
        return this.calendarView.getTileHSpacing();
    }

    public final void setTileVSpacing(int r1) {
        this.calendarView.setTileVSpacing(r1);
    }

    public final int getTileVSpacing() {
        return this.calendarView.getTileVSpacing();
    }

    public final void setWeekDaysHeight(int r1) {
        this.calendarView.setWeekDaysHeight(r1);
    }

    public final void setWeekDaysHeightDp(int r1) {
        this.calendarView.setWeekDaysHeightDp(r1);
    }

    public final int getWeekDaysHeight() {
        return this.calendarView.getWeekDaysHeight();
    }

    public static /* synthetic */ void setCurrentDate$default(ODatePickerView r0, CalendarDay r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setCurrentDate(r1, r2);
    }

    public final void setCurrentDate(CalendarDay r1, boolean r2) {
        this.calendarView.setCurrentDate(r1, r2);
    }

    public final CalendarDay getCurrentDate() {
        CalendarDay r1 = this.calendarView.getCurrentDate();
        d.h.b.o.c(r1, "calendarView.currentDate");
        return r1;
    }

    public final void setSelectedDate(CalendarDay r1) {
        this.calendarView.setSelectedDate(r1);
    }

    public final CalendarDay getSelectedDate() {
        return this.calendarView.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        List<CalendarDay> r1 = this.calendarView.getSelectedDates();
        d.h.b.o.c(r1, "calendarView.selectedDates");
        return r1;
    }

    public final void clearSelection() {
        this.calendarView.clearSelection();
    }

    public final void setDateSelected(CalendarDay r1, boolean r2) {
        this.calendarView.setDateSelected(r1, r2);
    }

    public final void selectRange(CalendarDay r2, CalendarDay r3) {
        d.h.b.o.e(r2, "firstDay");
        d.h.b.o.e(r3, "lastDay");
        this.calendarView.selectRange(r2, r3);
    }

    public final void addDecorator(com.obric.oui.calendar.d r3) {
        com.obric.oui.calendar.d r4 = (com.obric.oui.calendar.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.d.class, "com.obric.aiagent.plugin");
        this.calendarView.addDecorator(r4);
    }

    public final void addDecorators(Collection<? extends com.obric.oui.calendar.d> r3) {
        Collection<? extends com.obric.oui.calendar.d> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        this.calendarView.addDecorators(r4);
    }

    public final void addDecorators(com.obric.oui.calendar.d... r3) {
        d.h.b.o.e(r3, "decorators");
        this.calendarView.addDecorators((com.obric.oui.calendar.d[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), com.obric.oui.calendar.d[].class, "com.obric.aiagent.plugin"));
    }

    public final void removeDecorator(com.obric.oui.calendar.d r3) {
        com.obric.oui.calendar.d r4 = (com.obric.oui.calendar.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.d.class, "com.obric.aiagent.plugin");
        this.calendarView.removeDecorator(r4);
    }

    public final void removeDecorators() {
        this.calendarView.removeDecorators();
    }

    public final void invalidateDecorators() {
        this.calendarView.invalidateDecorators();
    }

    public final void setFirstDayOfWeek(DayOfWeek r2) {
        d.h.b.o.e(r2, "firstDayOfWeek");
        switch(d.f34352b[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        org.threeten.bp.DayOfWeek r3 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        this.calendarView.state().a().a(r3).a();
        return;
    L7:
        r3 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r3 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r3 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r3 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r3 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r3 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new d.k();
    }

    private final long toTimestamp(CalendarDay r8) {
        Calendar r7 = Calendar.getInstance();
        r7.set(r8.getYear(), r8.getMonth() - 1, r8.getDay(), 0, 0, 0);
        r7.set(14, 0);
        return r7.getTimeInMillis();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        ViewParent r1 = getParent();
        if (r1 != null) goto L6;
    L4:
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OSheetContentFrameLayout.class) == true) goto L10;
        return;
    L10:
        if (((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).getId() != ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container")) goto L36;
        int r3 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).getPaddingLeft();
        int r4 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).getPaddingTop();
        int r5 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).getPaddingRight();
        int r6 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).getPaddingBottom();
        int r7 = d.f34353c[this.datePickerMode.ordinal()];
        if (r7 == 1) goto L26;
        if (r7 == 2) goto L17;
        return;
    L17:
        if (r3 == com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0)) goto L19;
    L24:
        com.obric.oui.d.a.b.b(TAG, "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ']');
        ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r4 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0)) goto L24;
        if (r5 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0)) goto L24;
        if (r6 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0)) goto L24;
        return;
    L26:
        if (r3 == com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16)) goto L28;
    L33:
        com.obric.oui.d.a.b.b(TAG, "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ']');
        ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.aiagent.plugin")).setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16));
        return;
    L28:
        if (r4 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6)) goto L33;
        if (r5 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16)) goto L33;
        if (r6 != com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16)) goto L33;
        return;
    L36:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L4;
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.syncCalendarRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.syncCalendarRunnable = null;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        String r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_date_picker_date_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_date_picker_date_format"));
        d.h.b.o.c(r5, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r5;
    }
}
