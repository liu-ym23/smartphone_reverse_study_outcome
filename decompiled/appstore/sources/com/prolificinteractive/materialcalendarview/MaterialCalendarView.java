package com.prolificinteractive.materialcalendarview;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import com.google.common.primitives.Ints;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public class MaterialCalendarView extends ViewGroup {
    public int A;
    public boolean B;
    public DayOfWeek C;
    public boolean D;
    public f E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f17713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f17714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f17715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f17716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.prolificinteractive.materialcalendarview.b f17717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.prolificinteractive.materialcalendarview.c f17718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarDay f17719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f17720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarMode f17721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f17723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnClickListener f17724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewPager.OnPageChangeListener f17725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CalendarDay f17726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CalendarDay f17727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnDateSelectedListener f17728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OnDateLongClickListener f17729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OnMonthChangedListener f17730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnRangeSelectedListener f17731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f17732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f17734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f17735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f17736x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f17737y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f17738z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean allowClickDaysOutsideCurrentMonth;
        boolean cacheCurrentPosition;
        CalendarMode calendarMode;
        int color;
        CalendarDay currentMonth;
        int dateTextAppearance;
        boolean dynamicHeightEnabled;
        DayOfWeek firstDayOfWeek;
        CalendarDay maxDate;
        CalendarDay minDate;
        int orientation;
        List<CalendarDay> selectedDates;
        int selectionMode;
        int showOtherDates;
        boolean showWeekDays;
        int tileHeightPx;
        int tileWidthPx;
        boolean topbarVisible;
        int weekDayTextAppearance;

        public static class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel r10, a r11) {
            this(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.color);
            r10.writeInt(this.dateTextAppearance);
            r10.writeInt(this.weekDayTextAppearance);
            r10.writeInt(this.showOtherDates);
            r10.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r10.writeParcelable(this.minDate, 0);
            r10.writeParcelable(this.maxDate, 0);
            r10.writeTypedList(this.selectedDates);
            r10.writeInt(this.firstDayOfWeek.getValue());
            r10.writeInt(this.orientation);
            r10.writeInt(this.tileWidthPx);
            r10.writeInt(this.tileHeightPx);
            r10.writeInt(this.topbarVisible ? 1 : 0);
            r10.writeInt(this.selectionMode);
            r10.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            if (this.calendarMode != CalendarMode.WEEKS) goto L5;
            int r12 = 1;
        L6:
            r10.writeInt(r12);
            r10.writeParcelable(this.currentMonth, 0);
            r10.writeByte(this.cacheCurrentPosition ? 1 : 0);
            r10.writeByte(this.showWeekDays ? 1 : 0);
            return;
        L5:
            r12 = 0;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
            this.orientation = 0;
            this.tileWidthPx = -1;
            this.tileHeightPx = -1;
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.calendarMode = CalendarMode.MONTHS;
            this.currentMonth = null;
        }

        private SavedState(Parcel r10) {
            super(r10);
            boolean r11 = false;
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
            this.orientation = 0;
            this.tileWidthPx = -1;
            this.tileHeightPx = -1;
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            CalendarMode r12 = CalendarMode.MONTHS;
            this.calendarMode = r12;
            this.currentMonth = null;
            this.color = r10.readInt();
            this.dateTextAppearance = r10.readInt();
            this.weekDayTextAppearance = r10.readInt();
            this.showOtherDates = r10.readInt();
            if (r10.readByte() == 0) goto L5;
            boolean r13 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r13;
            ClassLoader r14 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) r10.readParcelable(r14);
            this.maxDate = (CalendarDay) r10.readParcelable(r14);
            r10.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            this.firstDayOfWeek = DayOfWeek.of(r10.readInt());
            this.orientation = r10.readInt();
            this.tileWidthPx = r10.readInt();
            this.tileHeightPx = r10.readInt();
            if (r10.readInt() != 1) goto L9;
            boolean r15 = true;
        L10:
            this.topbarVisible = r15;
            this.selectionMode = r10.readInt();
            if (r10.readInt() != 1) goto L13;
            boolean r16 = true;
        L14:
            this.dynamicHeightEnabled = r16;
            if (r10.readInt() != 1) goto L17;
            r12 = CalendarMode.WEEKS;
        L17:
            this.calendarMode = r12;
            this.currentMonth = (CalendarDay) r10.readParcelable(r14);
            if (r10.readByte() == 0) goto L20;
            boolean r17 = true;
        L21:
            this.cacheCurrentPosition = r17;
            if (r10.readByte() == 0) goto L24;
            r11 = true;
        L24:
            this.showWeekDays = r11;
            return;
        L20:
            r17 = false;
            goto L21
        L13:
            r16 = false;
            goto L14
        L9:
            r15 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"UniqueConstants"})
    public @interface ShowOtherDates {
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f17739a;

        public a(MaterialCalendarView r10) {
            this.f17739a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (r10 != MaterialCalendarView.a(this.f17739a)) goto L6;
            MaterialCalendarView.b(this.f17739a).setCurrentItem(MaterialCalendarView.b(this.f17739a).getCurrentItem() + 1, true);
            return;
        L6:
            if (r10 != MaterialCalendarView.c(this.f17739a)) goto L10;
            MaterialCalendarView.b(this.f17739a).setCurrentItem(MaterialCalendarView.b(this.f17739a).getCurrentItem() - 1, true);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f17740a;

        public b(MaterialCalendarView r10) {
            this.f17740a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            MaterialCalendarView.g(this.f17740a).k(MaterialCalendarView.e(this.f17740a));
            MaterialCalendarView r11 = this.f17740a;
            MaterialCalendarView.f(r11, MaterialCalendarView.h(r11).f(r10));
            MaterialCalendarView.i(this.f17740a);
            MaterialCalendarView r12 = this.f17740a;
            r12.q(MaterialCalendarView.e(r12));
        }
    }

    public class c implements ViewPager.PageTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f17741a;

        public c(MaterialCalendarView r10) {
            this.f17741a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(View r10, float r11) {
            r10.setAlpha((float) Math.sqrt(1.0f - Math.abs(r11)));
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17742a = null;

        static {
            int[] r10 = new int[CalendarMode.values().length];
            f17742a = r10;
            r10[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f17742a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int r10) {
            super(-1, r10);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarMode f17743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DayOfWeek f17744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CalendarDay f17745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CalendarDay f17746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f17747e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f17748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f17749g;

        public /* synthetic */ f(MaterialCalendarView r10, g r11, a r12) {
            this(r10, r11);
        }

        public static /* synthetic */ CalendarMode a(f r10) {
            return r10.f17743a;
        }

        public static /* synthetic */ DayOfWeek b(f r10) {
            return r10.f17744b;
        }

        public static /* synthetic */ CalendarDay c(f r10) {
            return r10.f17745c;
        }

        public static /* synthetic */ CalendarDay d(f r10) {
            return r10.f17746d;
        }

        public static /* synthetic */ boolean e(f r10) {
            return r10.f17748f;
        }

        public static /* synthetic */ boolean f(f r10) {
            return r10.f17747e;
        }

        public f(MaterialCalendarView r10, g r11) {
            this.f17749g = r10;
            this.f17743a = g.f(r11);
            this.f17744b = g.a(r11);
            this.f17745c = g.b(r11);
            this.f17746d = g.c(r11);
            this.f17747e = g.d(r11);
            this.f17748f = g.e(r11);
        }
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CalendarMode f17750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DayOfWeek f17751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CalendarDay f17753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CalendarDay f17754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f17756g;

        public g(MaterialCalendarView r10) {
            this.f17756g = r10;
            this.f17752c = false;
            this.f17753d = null;
            this.f17754e = null;
            this.f17750a = CalendarMode.MONTHS;
            this.f17751b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        public static /* synthetic */ DayOfWeek a(g r10) {
            return r10.f17751b;
        }

        public static /* synthetic */ CalendarDay b(g r10) {
            return r10.f17753d;
        }

        public static /* synthetic */ CalendarDay c(g r10) {
            return r10.f17754e;
        }

        public static /* synthetic */ boolean d(g r10) {
            return r10.f17752c;
        }

        public static /* synthetic */ boolean e(g r10) {
            return r10.f17755f;
        }

        public static /* synthetic */ CalendarMode f(g r10) {
            return r10.f17750a;
        }

        public void g() {
            MaterialCalendarView r10 = this.f17756g;
            MaterialCalendarView.d(r10, new f(r10, this, null));
        }

        public g h(boolean r10) {
            this.f17752c = r10;
            return this;
        }

        public g i(CalendarMode r10) {
            this.f17750a = r10;
            return this;
        }

        public g j(DayOfWeek r10) {
            this.f17751b = r10;
            return this;
        }

        public g k(CalendarDay r10) {
            this.f17754e = r10;
            return this;
        }

        public g l(CalendarDay r10) {
            this.f17753d = r10;
            return this;
        }

        public g m(boolean r10) {
            this.f17755f = r10;
            return this;
        }
    }

    public MaterialCalendarView(Context r10) {
        this(r10, null);
    }

    public static boolean I(int r10) {
        if ((r10 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean J(int r10) {
        if ((r10 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean K(int r10) {
        if ((r10 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ h a(MaterialCalendarView r10) {
        return r10.f17716d;
    }

    public static /* synthetic */ com.prolificinteractive.materialcalendarview.b b(MaterialCalendarView r10) {
        return r10.f17717e;
    }

    public static /* synthetic */ h c(MaterialCalendarView r10) {
        return r10.f17715c;
    }

    public static /* synthetic */ void d(MaterialCalendarView r10, f r11) {
        r10.o(r11);
    }

    public static /* synthetic */ CalendarDay e(MaterialCalendarView r10) {
        return r10.f17719g;
    }

    public static /* synthetic */ CalendarDay f(MaterialCalendarView r10, CalendarDay r11) {
        r10.f17719g = r11;
        return r11;
    }

    public static /* synthetic */ l g(MaterialCalendarView r10) {
        return r10.f17713a;
    }

    private int getWeekCountBasedOnMode() {
        CalendarMode r10 = this.f17721i;
        int r11 = r10.visibleWeeksCount;
        if (r10.equals(CalendarMode.MONTHS) == false) goto L12;
        if (this.f17722j == false) goto L12;
        com.prolificinteractive.materialcalendarview.c r12 = this.f17718f;
        if (r12 == null) goto L12;
        com.prolificinteractive.materialcalendarview.b r13 = this.f17717e;
        if (r13 == null) goto L12;
        LocalDate r14 = r12.f(r13.getCurrentItem()).getDate();
        r11 = r14.withDayOfMonth(r14.lengthOfMonth()).get(WeekFields.of(this.C, 1).weekOfMonth());
    L12:
        if (this.D == true) goto L14;
        return r11;
    L14:
        return r11 + 1;
    }

    public static /* synthetic */ com.prolificinteractive.materialcalendarview.c h(MaterialCalendarView r10) {
        return r10.f17718f;
    }

    public static /* synthetic */ void i(MaterialCalendarView r10) {
        r10.L();
    }

    public static int m(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 == 1073741824) goto L7;
        return r10;
    L7:
        return r13;
    L9:
        return Math.min(r10, r13);
    }

    public static int v(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.colorAccent, r11, true);
        return r11.data;
    }

    public void A(CalendarDay r10, boolean r11) {
        int r12 = this.A;
        if (r12 != 2) goto L5;
        this.f17718f.q(r10, r11);
        p(r10, r11);
        return;
    L5:
        if (r12 == 3) goto L7;
        this.f17718f.a();
        this.f17718f.q(r10, true);
        p(r10, true);
        return;
    L7:
        List r13 = this.f17718f.h();
        if (r13.size() != 0) goto L11;
        this.f17718f.q(r10, r11);
        p(r10, r11);
        return;
    L11:
        if (r13.size() != 1) goto L19;
        CalendarDay r14 = (CalendarDay) r13.get(0);
        if (r14.equals(r10) == false) goto L16;
        this.f17718f.q(r10, r11);
        p(r10, r11);
        return;
    L16:
        if (r14.isAfter(r10) == false) goto L18;
        this.f17718f.p(r10, r14);
        r(this.f17718f.h());
        return;
    L18:
        this.f17718f.p(r14, r10);
        r(this.f17718f.h());
        return;
    L19:
        this.f17718f.a();
        this.f17718f.q(r10, r11);
        p(r10, r11);
    }

    public void B(com.prolificinteractive.materialcalendarview.e r10) {
        CalendarDay r11 = getCurrentDate();
        CalendarDay r12 = r10.g();
        int r13 = r11.getMonth();
        int r14 = r12.getMonth();
        if (this.f17721i == CalendarMode.MONTHS) goto L5;
    L13:
        A(r10.g(), !r10.isChecked());
        return;
    L5:
        if (this.B == false) goto L13;
        if (r13 == r14) goto L13;
        if (r11.isAfter(r12) == false) goto L11;
        x();
        goto L13
    L11:
        if (r11.isBefore(r12) == false) goto L13;
        w();
        goto L13
    }

    public void C(com.prolificinteractive.materialcalendarview.e r10) {
        OnDateLongClickListener r11 = this.f17729q;
        if (r11 == null) goto L6;
        r11.onDateLongClick(this, r10.g());
        return;
    }

    public void D(CalendarDay r10) {
        p(r10, false);
    }

    public void E(CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = this.f17718f.e(r10);
        this.f17717e.setCurrentItem(r12, r11);
        L();
    }

    public void F(CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f17718f.q(r10, r11);
    }

    public final void G(CalendarDay r10, CalendarDay r11) {
        CalendarDay r12 = this.f17719g;
        this.f17718f.u(r10, r11);
        this.f17719g = r12;
        if (r10 != null) goto L5;
    L9:
        int r13 = this.f17718f.e(r12);
        this.f17717e.setCurrentItem(r13, false);
        L();
        return;
    L5:
        if (r10.isAfter(r12) == true) goto L8;
        r10 = this.f17719g;
    L8:
        this.f17719g = r10;
        goto L9
    }

    public final void H() {
        LinearLayout r10 = new LinearLayout(getContext());
        this.f17720h = r10;
        r10.setOrientation(0);
        this.f17720h.setClipChildren(false);
        this.f17720h.setClipToPadding(false);
        addView(this.f17720h, new e(1));
        h r11 = this.f17715c;
        ImageView.ScaleType r12 = ImageView.ScaleType.CENTER_INSIDE;
        r11.setScaleType(r12);
        this.f17720h.addView(this.f17715c, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f17714b.setGravity(17);
        this.f17720h.addView(this.f17714b, new LinearLayout.LayoutParams(0, -1, 5.0f));
        this.f17716d.setScaleType(r12);
        this.f17720h.addView(this.f17716d, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f17717e.setId(R$id.mcv_pager);
        this.f17717e.setOffscreenPageLimit(1);
        if (this.D == false) goto L5;
        int r13 = this.f17721i.visibleWeeksCount + 1;
    L6:
        addView(this.f17717e, new e(r13));
        return;
    L5:
        r13 = this.f17721i.visibleWeeksCount;
        goto L6
    }

    public final void L() {
        this.f17713a.f(this.f17719g);
        this.f17715c.setEnabled(k());
        this.f17716d.setEnabled(l());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return t();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return u(r10);
    }

    public int getArrowColor() {
        return this.f17734v;
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r10 = this.f17732t;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return getContext().getString(R$string.calendar);
    }

    public CalendarMode getCalendarMode() {
        return this.f17721i;
    }

    public CalendarDay getCurrentDate() {
        return this.f17718f.f(this.f17717e.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.C;
    }

    public Drawable getLeftArrowMask() {
        return this.f17735w;
    }

    public CalendarDay getMaximumDate() {
        return this.f17727o;
    }

    public CalendarDay getMinimumDate() {
        return this.f17726n;
    }

    public Drawable getRightArrowMask() {
        return this.f17736x;
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List r10 = this.f17718f.h();
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) r10.get(r10.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.f17718f.h();
    }

    public int getSelectionColor() {
        return this.f17733u;
    }

    public int getSelectionMode() {
        return this.A;
    }

    public int getShowOtherDates() {
        return this.f17718f.i();
    }

    public int getTileHeight() {
        return this.f17737y;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.f17737y, this.f17738z);
    }

    public int getTileWidth() {
        return this.f17738z;
    }

    public int getTitleAnimationOrientation() {
        return this.f17713a.i();
    }

    public boolean getTopbarVisible() {
        if (this.f17720h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return this.B;
    }

    public boolean k() {
        if (this.f17717e.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f17717e.getCurrentItem() < (this.f17718f.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public void n() {
        List<CalendarDay> r10 = getSelectedDates();
        this.f17718f.a();
        Iterator<CalendarDay> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        p(r11.next(), false);
        goto L4
    }

    public final void o(f r10) {
        if (this.f17718f != null) goto L5;
    L32:
        CalendarDay r11 = null;
    L33:
        this.E = r10;
        this.f17721i = f.a(r10);
        this.C = f.b(r10);
        this.f17726n = f.c(r10);
        this.f17727o = f.d(r10);
        this.D = f.e(r10);
        int r12 = d.f17742a[this.f17721i.ordinal()];
        if (r12 != 1) goto L36;
        com.prolificinteractive.materialcalendarview.c r13 = new j(this);
    L41:
        com.prolificinteractive.materialcalendarview.c r14 = this.f17718f;
        if (r14 != null) goto L44;
        this.f17718f = r13;
    L45:
        this.f17718f.y(this.D);
        this.f17717e.setAdapter(this.f17718f);
        G(this.f17726n, this.f17727o);
        if (this.D == false) goto L48;
        int r15 = this.f17721i.visibleWeeksCount + 1;
    L49:
        this.f17717e.setLayoutParams(new e(r15));
        if (this.A == 1) goto L52;
    L54:
        CalendarDay r16 = CalendarDay.today();
    L55:
        setCurrentDate(r16);
        if (r11 == null) goto L58;
        this.f17717e.setCurrentItem(this.f17718f.e(r11));
    L58:
        y();
        L();
        return;
    L52:
        if (this.f17718f.h().isEmpty() == true) goto L54;
        r16 = (CalendarDay) this.f17718f.h().get(0);
        goto L55
    L48:
        r15 = this.f17721i.visibleWeeksCount;
        goto L49
    L44:
        this.f17718f = r14.o(r13);
        goto L45
    L36:
        if (r12 != 2) goto L39;
        r13 = new n(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (f.f(r10) == false) goto L32;
        r11 = this.f17718f.f(this.f17717e.getCurrentItem());
        if (this.f17721i == f.a(r10)) goto L33;
        CalendarDay r17 = getSelectedDate();
        CalendarMode r18 = this.f17721i;
        if (r18 != CalendarMode.MONTHS) goto L19;
        if (r17 == null) goto L19;
        CalendarDay r19 = CalendarDay.from(r11.getDate().plusDays(1));
        if (r17.equals(r11) == false) goto L14;
    L30:
        r11 = r17;
        goto L33
    L14:
        if (r17.isAfter(r11) == false) goto L33;
        if (r17.isBefore(r19) == false) goto L33;
    L19:
        if (r18 != CalendarMode.WEEKS) goto L33;
        CalendarDay r20 = CalendarDay.from(r11.getDate().plusDays(6));
        if (r17 != null) goto L23;
    L31:
        r11 = r20;
        goto L33
    L23:
        if (r17.equals(r11) == true) goto L30;
        if (r17.equals(r20) == true) goto L30;
        if (r17.isAfter(r11) == false) goto L31;
        if (r17.isBefore(r20) == false) goto L31;
        goto L30
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = ((r13 - r11) - r16) - getPaddingRight();
        int r18 = getPaddingTop();
        int r19 = 0;
    L3:
        if (r19 >= r15) goto L9;
        View r20 = getChildAt(r19);
        if (r20.getVisibility() == 8) goto L8;
        int r21 = r20.getMeasuredWidth();
        int r22 = ((r17 - r21) / 2) + r16;
        int r23 = r20.getMeasuredHeight() + r18;
        r20.layout(r22, r18, r21 + r22, r23);
        r18 = r23;
    L8:
        r19 = r19 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        int r10 = View.MeasureSpec.getSize(r12);
        int r11 = View.MeasureSpec.getMode(r12);
        int r14 = View.MeasureSpec.getSize(r13);
        int r15 = View.MeasureSpec.getMode(r13);
        int r16 = (r10 - getPaddingLeft()) - getPaddingRight();
        int r17 = (r14 - getPaddingTop()) - getPaddingBottom();
        int r18 = getWeekCountBasedOnMode();
        if (getTopbarVisible() == false) goto L5;
        r18 = r18 + 1;
    L5:
        int r19 = r16 / 7;
        int r20 = r17 / r18;
        int r21 = this.f17738z;
        int r22 = -1;
        if (r21 == (-10)) goto L8;
    L22:
        if (r21 <= 0) goto L24;
        r19 = r21;
    L24:
        int r23 = this.f17737y;
        if (r23 <= 0) goto L27;
        r20 = r23;
    L27:
        r22 = r19;
        r19 = -1;
    L28:
        if (r19 <= 0) goto L30;
        r20 = r19;
    L39:
        int r24 = r19 * 7;
        setMeasuredDimension(m((getPaddingLeft() + getPaddingRight()) + r24, r12), m((r18 * r20) + (getPaddingTop() + getPaddingBottom()), r13));
        int r110 = getChildCount();
        int r111 = 0;
    L40:
        if (r111 >= r110) goto L42;
        View r25 = getChildAt(r111);
        r25.measure(View.MeasureSpec.makeMeasureSpec(r24, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((e) r25.getLayoutParams())).height * r20, Ints.MAX_POWER_OF_TWO));
        r111 = r111 + 1;
        goto L40
    L42:
        return;
    L30:
        if (r19 <= 0) goto L32;
        r19 = r22;
        goto L39
    L32:
        if (r22 > 0) goto L34;
        int r26 = s(44);
    L35:
        if (r20 > 0) goto L37;
        r20 = s(44);
    L37:
        r19 = r26;
        goto L39
    L34:
        r26 = r22;
        goto L35
    L8:
        if (this.f17737y != (-10)) goto L22;
        if (r11 != 1073741824) goto L12;
    L20:
        if (r15 == 1073741824) goto L21;
    L19:
        r20 = -1;
        goto L28
    L21:
        r19 = Math.min(r19, r20);
        goto L19
    L12:
        if (r11 == Integer.MIN_VALUE) goto L20;
        if (r15 == 1073741824) goto L18;
        if (r15 == Integer.MIN_VALUE) goto L18;
        r19 = -1;
        r20 = -1;
    L18:
        r19 = r20;
        goto L19
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        z().j(r11.firstDayOfWeek).i(r11.calendarMode).l(r11.minDate).k(r11.maxDate).h(r11.cacheCurrentPosition).m(r11.showWeekDays).g();
        setSelectionColor(r11.color);
        setDateTextAppearance(r11.dateTextAppearance);
        setWeekDayTextAppearance(r11.weekDayTextAppearance);
        setShowOtherDates(r11.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r11.allowClickDaysOutsideCurrentMonth);
        n();
        Iterator<CalendarDay> r12 = r11.selectedDates.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        F(r12.next(), true);
        goto L4
    L6:
        setTitleAnimationOrientation(r11.orientation);
        setTileWidth(r11.tileWidthPx);
        setTileHeight(r11.tileHeightPx);
        setTopbarVisible(r11.topbarVisible);
        setSelectionMode(r11.selectionMode);
        setDynamicHeightEnabled(r11.dynamicHeightEnabled);
        setCurrentDate(r11.currentMonth);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.color = getSelectionColor();
        r10.dateTextAppearance = this.f17718f.d();
        r10.weekDayTextAppearance = this.f17718f.j();
        r10.showOtherDates = getShowOtherDates();
        r10.allowClickDaysOutsideCurrentMonth = j();
        r10.minDate = getMinimumDate();
        r10.maxDate = getMaximumDate();
        r10.selectedDates = getSelectedDates();
        r10.firstDayOfWeek = getFirstDayOfWeek();
        r10.orientation = getTitleAnimationOrientation();
        r10.selectionMode = getSelectionMode();
        r10.tileWidthPx = getTileWidth();
        r10.tileHeightPx = getTileHeight();
        r10.topbarVisible = getTopbarVisible();
        r10.calendarMode = this.f17721i;
        r10.dynamicHeightEnabled = this.f17722j;
        r10.currentMonth = this.f17719g;
        r10.cacheCurrentPosition = f.f(this.E);
        r10.showWeekDays = this.D;
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        return this.f17717e.dispatchTouchEvent(r10);
    }

    public void p(CalendarDay r10, boolean r11) {
        OnDateSelectedListener r12 = this.f17728p;
        if (r12 == null) goto L6;
        r12.onDateSelected(this, r10, r11);
        return;
    }

    public void q(CalendarDay r10) {
        OnMonthChangedListener r11 = this.f17730r;
        if (r11 == null) goto L6;
        r11.onMonthChanged(this, r10);
        return;
    }

    public void r(List r10) {
        OnRangeSelectedListener r11 = this.f17731s;
        if (r11 == null) goto L6;
        r11.onRangeSelected(this, r10);
        return;
    }

    public final int s(int r10) {
        return (int) TypedValue.applyDimension(1, r10, getResources().getDisplayMetrics());
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r10) {
        this.B = r10;
    }

    public void setArrowColor(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f17734v = r10;
        this.f17715c.b(r10);
        this.f17716d.b(r10);
        invalidate();
    }

    public void setContentDescriptionArrowFuture(CharSequence r10) {
        this.f17716d.setContentDescription(r10);
    }

    public void setContentDescriptionArrowPast(CharSequence r10) {
        this.f17715c.setContentDescription(r10);
    }

    public void setContentDescriptionCalendar(CharSequence r10) {
        this.f17732t = r10;
    }

    public void setCurrentDate(@Nullable LocalDate r10) {
        setCurrentDate(CalendarDay.from(r10));
    }

    public void setDateTextAppearance(int r10) {
        this.f17718f.r(r10);
    }

    public void setDayFormatter(DayFormatter r10) {
        com.prolificinteractive.materialcalendarview.c r11 = this.f17718f;
        if (r10 != null) goto L5;
        r10 = DayFormatter.DEFAULT;
    L5:
        r11.s(r10);
    }

    public void setDayFormatterContentDescription(DayFormatter r10) {
        this.f17718f.t(r10);
    }

    public void setDynamicHeightEnabled(boolean r10) {
        this.f17722j = r10;
    }

    public void setHeaderTextAppearance(int r10) {
        this.f17714b.setTextAppearance(getContext(), r10);
    }

    public void setLeftArrowMask(Drawable r10) {
        this.f17735w = r10;
        this.f17715c.setImageDrawable(r10);
    }

    public void setOnDateChangedListener(OnDateSelectedListener r10) {
        this.f17728p = r10;
    }

    public void setOnDateLongClickListener(OnDateLongClickListener r10) {
        this.f17729q = r10;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener r10) {
        this.f17730r = r10;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener r10) {
        this.f17731s = r10;
    }

    public void setOnTitleClickListener(View.OnClickListener r10) {
        this.f17714b.setOnClickListener(r10);
    }

    public void setPagingEnabled(boolean r10) {
        this.f17717e.u(r10);
        L();
    }

    public void setRightArrowMask(Drawable r10) {
        this.f17736x = r10;
        this.f17716d.setImageDrawable(r10);
    }

    public void setSelectedDate(@Nullable LocalDate r10) {
        setSelectedDate(CalendarDay.from(r10));
    }

    public void setSelectionColor(int r10) {
        if (r10 == 0) goto L4;
    L7:
        this.f17733u = r10;
        this.f17718f.v(r10);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r10 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r10) {
        int r11 = this.A;
        this.A = r10;
        boolean r12 = false;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L9;
        this.A = 0;
        if (r11 == 0) goto L15;
        n();
        goto L15
    L9:
        n();
    L15:
        com.prolificinteractive.materialcalendarview.c r13 = this.f17718f;
        if (this.A == 0) goto L18;
        r12 = true;
    L18:
        r13.w(r12);
        return;
    L10:
        if (r11 == 2) goto L13;
        if (r11 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void setShowOtherDates(int r10) {
        this.f17718f.x(r10);
    }

    public void setTileHeight(int r10) {
        this.f17737y = r10;
        requestLayout();
    }

    public void setTileHeightDp(int r10) {
        setTileHeight(s(r10));
    }

    public void setTileSize(int r10) {
        this.f17738z = r10;
        this.f17737y = r10;
        requestLayout();
    }

    public void setTileSizeDp(int r10) {
        setTileSize(s(r10));
    }

    public void setTileWidth(int r10) {
        this.f17738z = r10;
        requestLayout();
    }

    public void setTileWidthDp(int r10) {
        setTileWidth(s(r10));
    }

    public void setTitleAnimationOrientation(int r10) {
        this.f17713a.j(r10);
    }

    public void setTitleFormatter(@Nullable TitleFormatter r10) {
        this.f17713a.l(r10);
        this.f17718f.z(r10);
        L();
    }

    public void setTitleMonths(CharSequence[] r10) {
        setTitleFormatter(new ce.e(r10));
    }

    public void setTopbarVisible(boolean r10) {
        LinearLayout r11 = this.f17720h;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        requestLayout();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public void setWeekDayFormatter(WeekDayFormatter r10) {
        com.prolificinteractive.materialcalendarview.c r11 = this.f17718f;
        if (r10 != null) goto L5;
        r10 = WeekDayFormatter.DEFAULT;
    L5:
        r11.A(r10);
    }

    public void setWeekDayLabels(CharSequence[] r10) {
        setWeekDayFormatter(new ce.a(r10));
    }

    public void setWeekDayTextAppearance(int r10) {
        this.f17718f.B(r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public e t() {
        return new e(1);
    }

    public e u(AttributeSet r10) {
        return new e(1);
    }

    public void w() {
        if (l() == false) goto L6;
        com.prolificinteractive.materialcalendarview.b r10 = this.f17717e;
        r10.setCurrentItem(r10.getCurrentItem() + 1, true);
        return;
    }

    public void x() {
        if (k() == false) goto L6;
        com.prolificinteractive.materialcalendarview.b r10 = this.f17717e;
        r10.setCurrentItem(r10.getCurrentItem() - 1, true);
        return;
    }

    public void y() {
        this.f17718f.l();
    }

    public g z() {
        return new g(this);
    }

    public MaterialCalendarView(Context r12, AttributeSet r13) {
        super(r12, r13);
        this.f17723k = new ArrayList();
        a r10 = new a(this);
        this.f17724l = r10;
        b r11 = new b(this);
        this.f17725m = r11;
        this.f17726n = null;
        this.f17727o = null;
        this.f17733u = 0;
        this.f17734v = -16777216;
        this.f17737y = -10;
        this.f17738z = -10;
        this.A = 1;
        this.B = true;
        setClipToPadding(false);
        setClipChildren(false);
        h r14 = new h(getContext());
        this.f17715c = r14;
        r14.setContentDescription(getContext().getString(R$string.previous));
        AppCompatTextView r15 = new AppCompatTextView(getContext());
        this.f17714b = r15;
        h r16 = new h(getContext());
        this.f17716d = r16;
        r16.setContentDescription(getContext().getString(R$string.next));
        com.prolificinteractive.materialcalendarview.b r17 = new com.prolificinteractive.materialcalendarview.b(getContext());
        this.f17717e = r17;
        r14.setOnClickListener(r10);
        r16.setOnClickListener(r10);
        l r18 = new l(r15);
        this.f17713a = r18;
        r17.setOnPageChangeListener(r11);
        r17.setPageTransformer(false, new c(this));
        TypedArray r19 = r12.getTheme().obtainStyledAttributes(r13, R$styleable.MaterialCalendarView, 0, 0);
        int r20 = r19.getInteger(R$styleable.MaterialCalendarView_mcv_calendarMode, 0);     // Catch: Throwable -> L8 Exception -> L10
        int r21 = r19.getInteger(R$styleable.MaterialCalendarView_mcv_firstDayOfWeek, -1);     // Catch: Throwable -> L8 Exception -> L10
        r18.j(r19.getInteger(R$styleable.MaterialCalendarView_mcv_titleAnimationOrientation, 0));     // Catch: Throwable -> L8 Exception -> L10
        if (r21 >= 1) goto L6;
    L12:
        this.C = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L8 Exception -> L10
    L13:
        this.D = r19.getBoolean(R$styleable.MaterialCalendarView_mcv_showWeekDays, true);     // Catch: Throwable -> L8 Exception -> L10
        z().j(this.C).i(CalendarMode.values()[r20]).m(this.D).g();     // Catch: Throwable -> L8 Exception -> L10
        setSelectionMode(r19.getInteger(R$styleable.MaterialCalendarView_mcv_selectionMode, 1));     // Catch: Throwable -> L8 Exception -> L10
        int r22 = r19.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileSize, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r22 <= (-10)) goto L16;
        setTileSize(r22);     // Catch: Throwable -> L8 Exception -> L10
    L16:
        int r23 = r19.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileWidth, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r23 <= (-10)) goto L19;
        setTileWidth(r23);     // Catch: Throwable -> L8 Exception -> L10
    L19:
        int r24 = r19.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileHeight, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r24 <= (-10)) goto L22;
        setTileHeight(r24);     // Catch: Throwable -> L8 Exception -> L10
    L22:
        setArrowColor(r19.getColor(R$styleable.MaterialCalendarView_mcv_arrowColor, -16777216));     // Catch: Throwable -> L8 Exception -> L10
        Drawable r25 = r19.getDrawable(R$styleable.MaterialCalendarView_mcv_leftArrowMask);     // Catch: Throwable -> L8 Exception -> L10
        if (r25 != null) goto L25;
        r25 = getResources().getDrawable(R$drawable.mcv_action_previous);     // Catch: Throwable -> L8 Exception -> L10
    L25:
        setLeftArrowMask(r25);     // Catch: Throwable -> L8 Exception -> L10
        Drawable r26 = r19.getDrawable(R$styleable.MaterialCalendarView_mcv_rightArrowMask);     // Catch: Throwable -> L8 Exception -> L10
        if (r26 != null) goto L28;
        r26 = getResources().getDrawable(R$drawable.mcv_action_next);     // Catch: Throwable -> L8 Exception -> L10
    L28:
        setRightArrowMask(r26);     // Catch: Throwable -> L8 Exception -> L10
        setSelectionColor(r19.getColor(R$styleable.MaterialCalendarView_mcv_selectionColor, v(r12)));     // Catch: Throwable -> L8 Exception -> L10
        CharSequence[] r110 = r19.getTextArray(R$styleable.MaterialCalendarView_mcv_weekDayLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r110 == null) goto L31;
        setWeekDayFormatter(new ce.a(r110));     // Catch: Throwable -> L8 Exception -> L10
    L31:
        CharSequence[] r111 = r19.getTextArray(R$styleable.MaterialCalendarView_mcv_monthLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r111 == null) goto L34;
        setTitleFormatter(new ce.e(r111));     // Catch: Throwable -> L8 Exception -> L10
    L34:
        setHeaderTextAppearance(r19.getResourceId(R$styleable.MaterialCalendarView_mcv_headerTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L8 Exception -> L10
        setWeekDayTextAppearance(r19.getResourceId(R$styleable.MaterialCalendarView_mcv_weekDayTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L8 Exception -> L10
        setDateTextAppearance(r19.getResourceId(R$styleable.MaterialCalendarView_mcv_dateTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L8 Exception -> L10
        setShowOtherDates(r19.getInteger(R$styleable.MaterialCalendarView_mcv_showOtherDates, 4));     // Catch: Throwable -> L8 Exception -> L10
        setAllowClickDaysOutsideCurrentMonth(r19.getBoolean(R$styleable.MaterialCalendarView_mcv_allowClickDaysOutsideCurrentMonth, true));     // Catch: Throwable -> L8 Exception -> L10
    L35:
        r19.recycle();
        H();
        CalendarDay r112 = CalendarDay.today();
        this.f17719g = r112;
        setCurrentDate(r112);
        if (isInEditMode() == false) goto L47;
        removeView(this.f17717e);
        k r113 = new k(this, this.f17719g, getFirstDayOfWeek(), true);
        r113.s(getSelectionColor());
        r113.l(this.f17718f.d());
        r113.w(this.f17718f.j());
        r113.u(getShowOtherDates());
        addView(r113, new e(this.f17721i.visibleWeeksCount + 1));
        return;
    L47:
        return;
    L6:
        if (r21 > 7) goto L12;
        this.C = DayOfWeek.of(r21);     // Catch: Throwable -> L8 Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r19.recycle();
        throw th;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new e(1);
    }

    public void setCurrentDate(@Nullable CalendarDay r10) {
        E(r10, true);
    }

    public void setSelectedDate(@Nullable CalendarDay r10) {
        n();
        if (r10 == null) goto L6;
        F(r10, true);
        return;
    }

    public void setTitleMonths(@ArrayRes int r10) {
        setTitleMonths(getResources().getTextArray(r10));
    }

    public void setWeekDayLabels(@ArrayRes int r10) {
        setWeekDayLabels(getResources().getTextArray(r10));
    }
}
