package com.obric.oui.calendar;

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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public class MaterialCalendarView extends ViewGroup {
    public boolean A;
    public DayOfWeek B;
    public boolean C;
    public int D;
    public f E;
    public final e F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f12546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f12547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f12548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f12549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CalendarPager f12550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.obric.oui.calendar.b f12551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarDay f12552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f12553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarMode f12554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnClickListener f12557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewPager.OnPageChangeListener f12558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CalendarDay f12559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CalendarDay f12560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnDateSelectedListener f12561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OnDateLongClickListener f12562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OnMonthChangedListener f12563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnRangeSelectedListener f12564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f12565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12571z;

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

        public class a implements Parcelable.Creator {
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
            r10.writeInt(this.showOtherDates);
            r10.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r10.writeParcelable(this.minDate, 0);
            r10.writeParcelable(this.maxDate, 0);
            r10.writeTypedList(this.selectedDates);
            r10.writeInt(this.topbarVisible ? 1 : 0);
            r10.writeInt(this.selectionMode);
            r10.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            r10.writeParcelable(this.currentMonth, 0);
            r10.writeByte(this.cacheCurrentPosition ? 1 : 0);
        }

        public SavedState(Parcelable r10) {
            super(r10);
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

        private SavedState(Parcel r10) {
            super(r10);
            this.showOtherDates = 4;
            boolean r11 = true;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
            this.showOtherDates = r10.readInt();
            if (r10.readByte() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r12;
            ClassLoader r13 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) r10.readParcelable(r13);
            this.maxDate = (CalendarDay) r10.readParcelable(r13);
            r10.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            if (r10.readInt() != 1) goto L9;
            boolean r14 = true;
        L10:
            this.topbarVisible = r14;
            this.selectionMode = r10.readInt();
            if (r10.readInt() != 1) goto L13;
            boolean r15 = true;
        L14:
            this.dynamicHeightEnabled = r15;
            this.currentMonth = (CalendarDay) r10.readParcelable(r13);
            if (r10.readByte() != 0) goto L18;
            r11 = false;
        L18:
            this.cacheCurrentPosition = r11;
            return;
        L13:
            r15 = false;
            goto L14
        L9:
            r14 = false;
            goto L10
        L5:
            r12 = false;
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
        public final /* synthetic */ MaterialCalendarView f12572a;

        public a(MaterialCalendarView r10) {
            this.f12572a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (r10 != MaterialCalendarView.a(this.f12572a)) goto L6;
            MaterialCalendarView.b(this.f12572a).setCurrentItem(MaterialCalendarView.b(this.f12572a).getCurrentItem() + 1, true);
            return;
        L6:
            if (r10 != MaterialCalendarView.c(this.f12572a)) goto L10;
            MaterialCalendarView.b(this.f12572a).setCurrentItem(MaterialCalendarView.b(this.f12572a).getCurrentItem() - 1, true);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f12573a;

        public b(MaterialCalendarView r10) {
            this.f12573a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            MaterialCalendarView.g(this.f12573a).k(MaterialCalendarView.e(this.f12573a));
            MaterialCalendarView r11 = this.f12573a;
            MaterialCalendarView.f(r11, MaterialCalendarView.h(r11).f(r10));
            MaterialCalendarView.i(this.f12573a);
            MaterialCalendarView r12 = this.f12573a;
            r12.p(MaterialCalendarView.e(r12));
        }
    }

    public class c implements ViewPager.PageTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f12574a;

        public c(MaterialCalendarView r10) {
            this.f12574a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(View r10, float r11) {
            r10.setAlpha((float) Math.sqrt(1.0f - Math.abs(r11)));
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12575a = null;

        static {
            int[] r10 = new int[CalendarMode.values().length];
            f12575a = r10;
            r10[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f12575a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12577b;

        public e() {
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarMode f12578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DayOfWeek f12579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CalendarDay f12580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CalendarDay f12581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f12582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f12583f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f12584g;

        public /* synthetic */ f(MaterialCalendarView r10, g r11, a r12) {
            this(r10, r11);
        }

        public static /* synthetic */ CalendarMode a(f r10) {
            return r10.f12578a;
        }

        public static /* synthetic */ DayOfWeek b(f r10) {
            return r10.f12579b;
        }

        public static /* synthetic */ CalendarDay c(f r10) {
            return r10.f12580c;
        }

        public static /* synthetic */ CalendarDay d(f r10) {
            return r10.f12581d;
        }

        public static /* synthetic */ boolean e(f r10) {
            return r10.f12583f;
        }

        public static /* synthetic */ boolean f(f r10) {
            return r10.f12582e;
        }

        public g g() {
            return new g(this.f12584g, this, null);
        }

        public f(MaterialCalendarView r10, g r11) {
            this.f12584g = r10;
            this.f12578a = g.f(r11);
            this.f12579b = g.a(r11);
            this.f12580c = g.b(r11);
            this.f12581d = g.c(r11);
            this.f12582e = g.d(r11);
            this.f12583f = g.e(r11);
        }
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CalendarMode f12585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DayOfWeek f12586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CalendarDay f12588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CalendarDay f12589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarView f12591g;

        public /* synthetic */ g(MaterialCalendarView r10, f r11, a r12) {
            this(r10, r11);
        }

        public static /* synthetic */ DayOfWeek a(g r10) {
            return r10.f12586b;
        }

        public static /* synthetic */ CalendarDay b(g r10) {
            return r10.f12588d;
        }

        public static /* synthetic */ CalendarDay c(g r10) {
            return r10.f12589e;
        }

        public static /* synthetic */ boolean d(g r10) {
            return r10.f12587c;
        }

        public static /* synthetic */ boolean e(g r10) {
            return r10.f12590f;
        }

        public static /* synthetic */ CalendarMode f(g r10) {
            return r10.f12585a;
        }

        public void g() {
            MaterialCalendarView r10 = this.f12591g;
            MaterialCalendarView.d(r10, new f(r10, this, null));
        }

        public g h(boolean r10) {
            this.f12587c = r10;
            return this;
        }

        public g i(CalendarMode r10) {
            this.f12585a = r10;
            return this;
        }

        public g j(DayOfWeek r10) {
            this.f12586b = r10;
            return this;
        }

        public g k(CalendarDay r10) {
            this.f12589e = r10;
            return this;
        }

        public g l(CalendarDay r10) {
            this.f12588d = r10;
            return this;
        }

        public g m(boolean r10) {
            this.f12590f = r10;
            return this;
        }

        public g(MaterialCalendarView r10) {
            this.f12591g = r10;
            this.f12587c = false;
            this.f12588d = null;
            this.f12589e = null;
            this.f12585a = CalendarMode.MONTHS;
            this.f12586b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        public g(MaterialCalendarView r10, f r11) {
            this.f12591g = r10;
            this.f12587c = false;
            this.f12588d = null;
            this.f12589e = null;
            this.f12585a = f.a(r11);
            this.f12586b = f.b(r11);
            this.f12588d = f.c(r11);
            this.f12589e = f.d(r11);
            this.f12587c = f.f(r11);
            this.f12590f = f.e(r11);
        }
    }

    public MaterialCalendarView(Context r10) {
        this(r10, null);
    }

    public static boolean G(int r10) {
        if ((r10 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean H(int r10) {
        if ((r10 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean I(int r10) {
        if ((r10 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ ImageView a(MaterialCalendarView r10) {
        return r10.f12549d;
    }

    public static /* synthetic */ CalendarPager b(MaterialCalendarView r10) {
        return r10.f12550e;
    }

    public static /* synthetic */ ImageView c(MaterialCalendarView r10) {
        return r10.f12548c;
    }

    public static /* synthetic */ void d(MaterialCalendarView r10, f r11) {
        r10.n(r11);
    }

    public static /* synthetic */ CalendarDay e(MaterialCalendarView r10) {
        return r10.f12552g;
    }

    public static /* synthetic */ CalendarDay f(MaterialCalendarView r10, CalendarDay r11) {
        r10.f12552g = r11;
        return r11;
    }

    public static /* synthetic */ u g(MaterialCalendarView r10) {
        return r10.f12546a;
    }

    public static /* synthetic */ com.obric.oui.calendar.b h(MaterialCalendarView r10) {
        return r10.f12551f;
    }

    public static /* synthetic */ void i(MaterialCalendarView r10) {
        r10.K();
    }

    public static void s(View r10, boolean r11) {
        r10.setEnabled(r11);
        if (r11 == false) goto L5;
        float r12 = 1.0f;
    L6:
        r10.setAlpha(r12);
        return;
    L5:
        r12 = 0.1f;
        goto L6
    }

    public static int t(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.colorAccent, r11, true);
        return r11.data;
    }

    public void A(com.obric.oui.calendar.d r10) {
        OnDateLongClickListener r11 = this.f12562q;
        if (r11 == null) goto L6;
        r11.onDateLongClick(this, r10.h());
        return;
    }

    public void B(CalendarDay r10) {
        o(r10, false);
    }

    public void C(CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = this.f12551f.e(r10);
        this.f12550e.setCurrentItem(r12, r11);
        K();
    }

    public void D(CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f12551f.q(r10, r11);
    }

    public final void E(CalendarDay r10, CalendarDay r11) {
        CalendarDay r12 = this.f12552g;
        this.f12551f.u(r10, r11);
        this.f12552g = r12;
        if (r10 != null) goto L5;
    L9:
        int r13 = this.f12551f.e(r12);
        this.f12550e.setCurrentItem(r13, false);
        K();
        return;
    L5:
        if (r10.isAfter(r12) == true) goto L8;
        r10 = this.f12552g;
    L8:
        this.f12552g = r10;
        goto L9
    }

    public final void F() {
        addView(this.f12553h);
        this.f12550e.setId(R$id.mcv_pager);
        this.f12550e.setOffscreenPageLimit(1);
        addView(this.f12550e);
    }

    public f J() {
        return this.E;
    }

    public final void K() {
        this.f12546a.f(this.f12552g);
        s(this.f12548c, k());
        s(this.f12549d, l());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return Objects.nonNull(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r10 = this.f12565t;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return getContext().getString(R$string.oui_calendar);
    }

    public CalendarMode getCalendarMode() {
        return this.f12554i;
    }

    public CalendarDay getCurrentDate() {
        return this.f12551f.f(this.f12550e.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.B;
    }

    public Drawable getLeftArrow() {
        return this.f12548c.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.f12560o;
    }

    public e getMeasureInfo() {
        return this.F;
    }

    public CalendarDay getMinimumDate() {
        return this.f12559n;
    }

    public Drawable getRightArrow() {
        return this.f12549d.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List r10 = this.f12551f.h();
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) r10.get(r10.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.f12551f.h();
    }

    public int getSelectionColor() {
        return this.f12566u;
    }

    public int getSelectionMode() {
        return this.f12571z;
    }

    public int getShowOtherDates() {
        return this.f12551f.i();
    }

    public int getTileHSpacing() {
        return this.f12569x;
    }

    public int getTileHeight() {
        return this.f12567v;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.f12567v, this.f12568w);
    }

    public int getTileVSpacing() {
        return this.f12570y;
    }

    public int getTileWidth() {
        return this.f12568w;
    }

    public int getTitleAnimationOrientation() {
        return this.f12546a.i();
    }

    public boolean getTopbarVisible() {
        if (this.f12553h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getWeekDaysHeight() {
        return this.D;
    }

    public boolean j() {
        return this.A;
    }

    public boolean k() {
        if (this.f12550e.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f12550e.getCurrentItem() < (this.f12551f.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public void m() {
        List<CalendarDay> r10 = getSelectedDates();
        this.f12551f.a();
        Iterator<CalendarDay> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        o(r11.next(), false);
        goto L4
    }

    public final void n(f r10) {
        if (this.f12551f != null) goto L5;
    L32:
        CalendarDay r11 = null;
    L33:
        this.E = r10;
        this.f12554i = f.a(r10);
        this.B = f.b(r10);
        this.f12559n = f.c(r10);
        this.f12560o = f.d(r10);
        this.C = f.e(r10);
        int r12 = d.f12575a[this.f12554i.ordinal()];
        if (r12 != 1) goto L36;
        com.obric.oui.calendar.b r13 = new h(this);
    L41:
        com.obric.oui.calendar.b r14 = this.f12551f;
        if (r14 != null) goto L44;
        this.f12551f = r13;
    L45:
        this.f12551f.y(this.C);
        this.f12550e.setAdapter(this.f12551f);
        E(this.f12559n, this.f12560o);
        if (this.f12571z == 1) goto L48;
    L50:
        CalendarDay r15 = CalendarDay.today();
    L51:
        setCurrentDate(r15);
        if (r11 == null) goto L54;
        this.f12550e.setCurrentItem(this.f12551f.e(r11));
    L54:
        w();
        K();
        return;
    L48:
        if (this.f12551f.h().isEmpty() == true) goto L50;
        r15 = (CalendarDay) this.f12551f.h().get(0);
        goto L51
    L44:
        this.f12551f = r14.o(r13);
        goto L45
    L36:
        if (r12 != 2) goto L39;
        r13 = new w(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (f.f(r10) == false) goto L32;
        r11 = this.f12551f.f(this.f12550e.getCurrentItem());
        if (this.f12554i == f.a(r10)) goto L33;
        CalendarDay r16 = getSelectedDate();
        CalendarMode r17 = this.f12554i;
        if (r17 != CalendarMode.MONTHS) goto L19;
        if (r16 == null) goto L19;
        CalendarDay r18 = CalendarDay.from(r11.getDate().plusDays(1));
        if (r16.equals(r11) == false) goto L14;
    L30:
        r11 = r16;
        goto L33
    L14:
        if (r16.isAfter(r11) == false) goto L33;
        if (r16.isBefore(r18) == false) goto L33;
    L19:
        if (r17 != CalendarMode.WEEKS) goto L33;
        CalendarDay r19 = CalendarDay.from(r11.getDate().plusDays(6));
        if (r16 != null) goto L23;
    L31:
        r11 = r19;
        goto L33
    L23:
        if (r16.equals(r11) == true) goto L30;
        if (r16.equals(r19) == true) goto L30;
        if (r16.isAfter(r11) == false) goto L31;
        if (r16.isBefore(r19) == false) goto L31;
        goto L30
    }

    public void o(CalendarDay r10, boolean r11) {
        OnDateSelectedListener r12 = this.f12561p;
        if (r12 == null) goto L6;
        r12.onDateSelected(this, r10, r11);
        return;
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
    public void onMeasure(int r14, int r15) {
        int r10 = View.MeasureSpec.getSize(r14);
        int r16 = View.MeasureSpec.getMode(r14);
        int r11 = View.MeasureSpec.getSize(r15);
        int r17 = View.MeasureSpec.getMode(r15);
        if (this.D != (-10)) goto L5;
        this.D = r(28);
    L5:
        int r12 = (r10 - getPaddingLeft()) - getPaddingRight();
        int r13 = (r11 - getPaddingTop()) - getPaddingBottom();
        int r18 = this.f12568w;
        if (r18 <= 0) goto L8;
        this.F.f12576a = r18;
    L9:
        int r19 = this.f12567v;
        if (r19 <= 0) goto L12;
        this.F.f12577b = r19;
    L13:
        int r20 = 0;
        int r21 = Math.max(getTileHSpacing(), 0);
        int r22 = Math.max(getTileVSpacing(), 0);
        int r23 = getChildCount();
        int r24 = 0;
        int r25 = 0;
    L14:
        if (r20 >= r23) goto L32;
        View r26 = getChildAt(r20);
        if (r26.getVisibility() == 8) goto L31;
        if (r16 != 1073741824) goto L21;
        int r110 = r12;
    L22:
        int r111 = View.MeasureSpec.makeMeasureSpec(r110, Ints.MAX_POWER_OF_TWO);
        if (r17 != 1073741824) goto L25;
        int r112 = r13;
    L30:
        r26.measure(r111, View.MeasureSpec.makeMeasureSpec(r112, Ints.MAX_POWER_OF_TWO));
        r24 = Math.max(r24, (r26.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        r25 = Math.max(r25, (r26.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
        goto L31
    L25:
        int r113 = (this.F.f12577b + r22) * 6;
        if (this.C == false) goto L28;
        int r114 = this.D;
    L29:
        r112 = r113 + r114;
        goto L30
    L28:
        r114 = -r22;
        goto L29
    L21:
        r110 = (this.F.f12576a * 7) + (r21 * 6);
    L31:
        r20 = r20 + 1;
        goto L14
    L32:
        setMeasuredDimension(r24, r25);
        return;
    L12:
        this.F.f12577b = r(40);
        goto L13
    L8:
        this.F.f12576a = r(40);
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        J().g().l(r11.minDate).k(r11.maxDate).h(r11.cacheCurrentPosition).g();
        setShowOtherDates(r11.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r11.allowClickDaysOutsideCurrentMonth);
        m();
        Iterator<CalendarDay> r12 = r11.selectedDates.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        D(r12.next(), true);
        goto L4
    L6:
        setTopbarVisible(r11.topbarVisible);
        setSelectionMode(r11.selectionMode);
        setDynamicHeightEnabled(r11.dynamicHeightEnabled);
        setCurrentDate(r11.currentMonth);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.showOtherDates = getShowOtherDates();
        r10.allowClickDaysOutsideCurrentMonth = j();
        r10.minDate = getMinimumDate();
        r10.maxDate = getMaximumDate();
        r10.selectedDates = getSelectedDates();
        r10.selectionMode = getSelectionMode();
        r10.topbarVisible = getTopbarVisible();
        r10.dynamicHeightEnabled = this.f12555j;
        r10.currentMonth = this.f12552g;
        r10.cacheCurrentPosition = f.f(this.E);
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        return this.f12550e.dispatchTouchEvent(r10);
    }

    public void p(CalendarDay r10) {
        OnMonthChangedListener r11 = this.f12563r;
        if (r11 == null) goto L6;
        r11.onMonthChanged(this, r10);
        return;
    }

    public void q(List r10) {
        OnRangeSelectedListener r11 = this.f12564s;
        if (r11 == null) goto L6;
        r11.onRangeSelected(this, r10);
        return;
    }

    public final int r(int r10) {
        return (int) TypedValue.applyDimension(1, r10, getResources().getDisplayMetrics());
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r10) {
        this.A = r10;
    }

    public void setContentDescriptionArrowFuture(CharSequence r10) {
        this.f12549d.setContentDescription(r10);
    }

    public void setContentDescriptionArrowPast(CharSequence r10) {
        this.f12548c.setContentDescription(r10);
    }

    public void setContentDescriptionCalendar(CharSequence r10) {
        this.f12565t = r10;
    }

    public void setCurrentDate(@Nullable LocalDate r10) {
        setCurrentDate(CalendarDay.from(r10));
    }

    public void setDateTextAppearance(int r10) {
        this.f12551f.r(r10);
    }

    public void setDayFormatter(DayFormatter r10) {
        com.obric.oui.calendar.b r11 = this.f12551f;
        if (r10 != null) goto L5;
        r10 = DayFormatter.DEFAULT;
    L5:
        r11.s(r10);
    }

    public void setDayFormatterContentDescription(DayFormatter r10) {
        this.f12551f.t(r10);
    }

    public void setDynamicHeightEnabled(boolean r10) {
        this.f12555j = r10;
    }

    public void setHeaderTextAppearance(int r10) {
        this.f12547b.setTextAppearance(getContext(), r10);
    }

    public void setLeftArrow(@DrawableRes int r10) {
        this.f12548c.setImageResource(r10);
    }

    public void setOnDateChangedListener(OnDateSelectedListener r10) {
        this.f12561p = r10;
    }

    public void setOnDateLongClickListener(OnDateLongClickListener r10) {
        this.f12562q = r10;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener r10) {
        this.f12563r = r10;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener r10) {
        this.f12564s = r10;
    }

    public void setOnTitleClickListener(View.OnClickListener r10) {
        this.f12547b.setOnClickListener(r10);
    }

    public void setPagingEnabled(boolean r10) {
        this.f12550e.u(r10);
        K();
    }

    public void setRightArrow(@DrawableRes int r10) {
        this.f12549d.setImageResource(r10);
    }

    public void setSelectedDate(@Nullable LocalDate r10) {
        setSelectedDate(CalendarDay.from(r10));
    }

    public void setSelectionColor(int r10) {
        if (r10 == 0) goto L4;
    L7:
        this.f12566u = r10;
        this.f12551f.v(r10);
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
        int r11 = this.f12571z;
        this.f12571z = r10;
        boolean r12 = false;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L9;
        this.f12571z = 0;
        if (r11 == 0) goto L15;
        m();
        goto L15
    L9:
        m();
    L15:
        com.obric.oui.calendar.b r13 = this.f12551f;
        if (this.f12571z == 0) goto L18;
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
        this.f12551f.x(r10);
    }

    public void setTileHSpacing(int r10) {
        this.f12569x = r10;
        requestLayout();
    }

    public void setTileHeight(int r10) {
        this.f12567v = r10;
        requestLayout();
    }

    public void setTileHeightDp(int r10) {
        setTileHeight(r(r10));
    }

    public void setTileSize(int r10) {
        this.f12568w = r10;
        this.f12567v = r10;
        requestLayout();
    }

    public void setTileSizeDp(int r10) {
        setTileSize(r(r10));
    }

    public void setTileVSpacing(int r10) {
        this.f12570y = r10;
        requestLayout();
    }

    public void setTileWidth(int r10) {
        this.f12568w = r10;
        requestLayout();
    }

    public void setTileWidthDp(int r10) {
        setTileWidth(r(r10));
    }

    public void setTitleAnimationOrientation(int r10) {
        this.f12546a.j(r10);
    }

    public void setTitleFormatter(@Nullable TitleFormatter r10) {
        this.f12546a.l(r10);
        this.f12551f.z(r10);
        K();
    }

    public void setTitleMonths(CharSequence[] r10) {
        setTitleFormatter(new qc.e(r10));
    }

    public void setTopbarVisible(boolean r10) {
        LinearLayout r11 = this.f12553h;
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
        com.obric.oui.calendar.b r11 = this.f12551f;
        if (r10 != null) goto L5;
        r10 = WeekDayFormatter.DEFAULT;
    L5:
        r11.A(r10);
    }

    public void setWeekDayLabels(CharSequence[] r10) {
        setWeekDayFormatter(new qc.a(r10));
    }

    public void setWeekDayTextAppearance(int r10) {
        this.f12551f.B(r10);
    }

    public void setWeekDaysHeight(int r10) {
        this.D = r10;
        requestLayout();
    }

    public void setWeekDaysHeightDp(int r10) {
        setWeekDaysHeight(r(r10));
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void u() {
        if (l() == false) goto L6;
        CalendarPager r10 = this.f12550e;
        r10.setCurrentItem(r10.getCurrentItem() + 1, true);
        return;
    }

    public void v() {
        if (k() == false) goto L6;
        CalendarPager r10 = this.f12550e;
        r10.setCurrentItem(r10.getCurrentItem() - 1, true);
        return;
    }

    public void w() {
        this.f12551f.l();
    }

    public g x() {
        return new g(this);
    }

    public void y(CalendarDay r10, boolean r11) {
        int r12 = this.f12571z;
        if (r12 != 2) goto L5;
        this.f12551f.q(r10, r11);
        o(r10, r11);
        return;
    L5:
        if (r12 == 3) goto L7;
        this.f12551f.a();
        this.f12551f.q(r10, true);
        o(r10, true);
        return;
    L7:
        List r13 = this.f12551f.h();
        if (r13.size() != 0) goto L11;
        this.f12551f.q(r10, r11);
        o(r10, r11);
        return;
    L11:
        if (r13.size() != 1) goto L19;
        CalendarDay r14 = (CalendarDay) r13.get(0);
        if (r14.equals(r10) == false) goto L16;
        this.f12551f.q(r10, r11);
        o(r10, r11);
        return;
    L16:
        if (r14.isAfter(r10) == false) goto L18;
        this.f12551f.p(r10, r14);
        q(this.f12551f.h());
        return;
    L18:
        this.f12551f.p(r14, r10);
        q(this.f12551f.h());
        return;
    L19:
        this.f12551f.a();
        this.f12551f.q(r10, r11);
        o(r10, r11);
    }

    public void z(com.obric.oui.calendar.d r10) {
        CalendarDay r11 = getCurrentDate();
        CalendarDay r12 = r10.h();
        int r13 = r11.getMonth();
        int r14 = r12.getMonth();
        if (this.f12554i == CalendarMode.MONTHS) goto L5;
    L13:
        y(r10.h(), !r10.isChecked());
        return;
    L5:
        if (this.A == false) goto L13;
        if (r13 == r14) goto L13;
        if (r11.isAfter(r12) == false) goto L11;
        v();
        goto L13
    L11:
        if (r11.isBefore(r12) == false) goto L13;
        u();
        goto L13
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        this.f12556k = new ArrayList();
        a r10 = new a(this);
        this.f12557l = r10;
        b r13 = new b(this);
        this.f12558m = r13;
        this.f12559n = null;
        this.f12560o = null;
        this.f12566u = 0;
        this.f12567v = -10;
        this.f12568w = -10;
        this.f12569x = -10;
        this.f12570y = -10;
        this.f12571z = 1;
        this.A = true;
        this.D = -10;
        this.F = new e();
        setClipToPadding(false);
        setClipChildren(false);
        View r14 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R$layout.calendar_view, null, false);
        this.f12553h = (LinearLayout) r14.findViewById(R$id.header);
        ImageView r15 = (ImageView) r14.findViewById(R$id.previous);
        this.f12548c = r15;
        TextView r16 = (TextView) r14.findViewById(R$id.month_name);
        this.f12547b = r16;
        ImageView r17 = (ImageView) r14.findViewById(R$id.next);
        this.f12549d = r17;
        CalendarPager r18 = new CalendarPager(getContext());
        this.f12550e = r18;
        r15.setOnClickListener(r10);
        r17.setOnClickListener(r10);
        u r19 = new u(r16);
        this.f12546a = r19;
        r18.setOnPageChangeListener(r13);
        r18.setPageTransformer(false, new c(this));
        TypedArray r110 = r11.getTheme().obtainStyledAttributes(r12, R$styleable.O_MaterialCalendarView, 0, 0);
        int r20 = r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_calendarMode, 0);     // Catch: Throwable -> L8 Exception -> L10
        int r21 = r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_firstDayOfWeek, -1);     // Catch: Throwable -> L8 Exception -> L10
        r19.j(r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, 0));     // Catch: Throwable -> L8 Exception -> L10
        if (r21 >= 1) goto L6;
    L12:
        this.B = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L8 Exception -> L10
    L13:
        this.C = r110.getBoolean(R$styleable.O_MaterialCalendarView_o_mcv_showWeekDays, true);     // Catch: Throwable -> L8 Exception -> L10
        x().j(this.B).i(CalendarMode.values()[r20]).m(this.C).g();     // Catch: Throwable -> L8 Exception -> L10
        setSelectionMode(r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_selectionMode, 1));     // Catch: Throwable -> L8 Exception -> L10
        int r22 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileSize, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r22 <= (-10)) goto L16;
        setTileSize(r22);     // Catch: Throwable -> L8 Exception -> L10
    L16:
        int r23 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileWidth, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r23 <= (-10)) goto L19;
        setTileWidth(r23);     // Catch: Throwable -> L8 Exception -> L10
    L19:
        int r24 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileHeight, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r24 <= (-10)) goto L22;
        setTileHeight(r24);     // Catch: Throwable -> L8 Exception -> L10
    L22:
        int r25 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileHSpacing, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r25 <= (-10)) goto L25;
        setTileHSpacing(r25);     // Catch: Throwable -> L8 Exception -> L10
    L25:
        int r26 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileVSpacing, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r26 <= (-10)) goto L28;
        setTileVSpacing(r26);     // Catch: Throwable -> L8 Exception -> L10
    L28:
        setLeftArrow(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_leftArrow, R$drawable.o_mcv_action_previous));     // Catch: Throwable -> L8 Exception -> L10
        setRightArrow(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_rightArrow, R$drawable.o_mcv_action_next));     // Catch: Throwable -> L8 Exception -> L10
        setSelectionColor(r110.getColor(R$styleable.O_MaterialCalendarView_o_mcv_selectionColor, t(r11)));     // Catch: Throwable -> L8 Exception -> L10
        CharSequence[] r111 = r110.getTextArray(R$styleable.O_MaterialCalendarView_o_mcv_weekDayLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r111 == null) goto L31;
        setWeekDayFormatter(new qc.a(r111));     // Catch: Throwable -> L8 Exception -> L10
    L31:
        CharSequence[] r112 = r110.getTextArray(R$styleable.O_MaterialCalendarView_o_mcv_monthLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r112 == null) goto L34;
        setTitleFormatter(new qc.e(r112));     // Catch: Throwable -> L8 Exception -> L10
    L34:
        setHeaderTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_headerTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L8 Exception -> L10
        setWeekDayTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L8 Exception -> L10
        setDateTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_dateTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L8 Exception -> L10
        setShowOtherDates(r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_showOtherDates, 4));     // Catch: Throwable -> L8 Exception -> L10
        setAllowClickDaysOutsideCurrentMonth(r110.getBoolean(R$styleable.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, true));     // Catch: Throwable -> L8 Exception -> L10
    L35:
        r110.recycle();
        F();
        CalendarDay r113 = CalendarDay.today();
        this.f12552g = r113;
        setCurrentDate(r113);
        if (isInEditMode() == false) goto L47;
        removeView(this.f12550e);
        i r114 = new i(this, this.f12552g, getFirstDayOfWeek(), true);
        r114.v(getSelectionColor());
        r114.o(this.f12551f.d());
        r114.z(this.f12551f.j());
        r114.x(getShowOtherDates());
        addView(r114);
        return;
    L47:
        return;
    L6:
        if (r21 > 7) goto L12;
        this.B = DayOfWeek.of(r21);     // Catch: Throwable -> L8 Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r110.recycle();
        throw th;
    }

    public void setCurrentDate(@Nullable CalendarDay r10) {
        C(r10, true);
    }

    public void setSelectedDate(@Nullable CalendarDay r10) {
        m();
        if (r10 == null) goto L6;
        D(r10, true);
        return;
    }

    public void setTitleMonths(@ArrayRes int r10) {
        setTitleMonths(getResources().getTextArray(r10));
    }

    public void setWeekDayLabels(@ArrayRes int r10) {
        setWeekDayLabels(getResources().getTextArray(r10));
    }
}
