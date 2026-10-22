package com.google.android.material.datepicker;

import C0.c;
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
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class MaterialCalendar<S> extends s<S> {

    /* renamed from: q, reason: collision with root package name */
    public static final Object f20710q = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: r, reason: collision with root package name */
    public static final Object f20711r = "NAVIGATION_PREV_TAG";

    /* renamed from: s, reason: collision with root package name */
    public static final Object f20712s = "NAVIGATION_NEXT_TAG";

    /* renamed from: t, reason: collision with root package name */
    public static final Object f20713t = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b, reason: collision with root package name */
    public int f20714b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector<S> f20715c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f20716d;

    /* renamed from: e, reason: collision with root package name */
    public DayViewDecorator f20717e;

    /* renamed from: f, reason: collision with root package name */
    public Month f20718f;

    /* renamed from: g, reason: collision with root package name */
    public CalendarSelector f20719g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.material.datepicker.b f20720h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f20721i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f20722j;

    /* renamed from: k, reason: collision with root package name */
    public View f20723k;

    /* renamed from: l, reason: collision with root package name */
    public View f20724l;

    /* renamed from: m, reason: collision with root package name */
    public View f20725m;

    /* renamed from: n, reason: collision with root package name */
    public View f20726n;

    /* renamed from: o, reason: collision with root package name */
    public MaterialButton f20727o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f20728p;

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f20729a;

        public a(q qVar) {
            this.f20729a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.L(this.f20729a.d(MaterialCalendar.this.H().findLastVisibleItemPosition() - 1));
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20731a;

        public b(int i10) {
            this.f20731a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f20722j.smoothScrollToPosition(this.f20731a);
        }
    }

    public class c extends C1313a {
        public c() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.o0(null);
        }
    }

    public class d extends t {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20734a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f20734a = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.f20734a == 0) {
                iArr[0] = MaterialCalendar.this.f20722j.getWidth();
                iArr[1] = MaterialCalendar.this.f20722j.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f20722j.getHeight();
                iArr[1] = MaterialCalendar.this.f20722j.getHeight();
            }
        }
    }

    public class e implements l {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.l
        public void a(long j10) {
            if (MaterialCalendar.this.f20716d.getDateValidator().isValid(j10)) {
                MaterialCalendar.this.f20715c.select(j10);
                Iterator<r<S>> it = MaterialCalendar.this.f20857a.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.f20715c.getSelection());
                }
                MaterialCalendar.this.f20722j.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f20721i != null) {
                    MaterialCalendar.this.f20721i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    public class f extends C1313a {
        public f() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.I0(false);
        }
    }

    public class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f20738a = v.n();

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f20739b = v.n();

        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof w) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                w wVar = (w) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (B0.d<Long, Long> dVar : MaterialCalendar.this.f20715c.getSelectedRanges()) {
                    Long l10 = dVar.f1411a;
                    if (l10 != null && dVar.f1412b != null) {
                        this.f20738a.setTimeInMillis(l10.longValue());
                        this.f20739b.setTimeInMillis(dVar.f1412b.longValue());
                        int iE = wVar.e(this.f20738a.get(1));
                        int iE2 = wVar.e(this.f20739b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iE);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iE2);
                        int spanCount = iE / gridLayoutManager.getSpanCount();
                        int spanCount2 = iE2 / gridLayoutManager.getSpanCount();
                        int i10 = spanCount;
                        while (i10 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i10) != null) {
                                canvas.drawRect((i10 != spanCount || viewFindViewByPosition == null) ? 0 : viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2), r9.getTop() + MaterialCalendar.this.f20720h.f20770d.c(), (i10 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2), r9.getBottom() - MaterialCalendar.this.f20720h.f20770d.b(), MaterialCalendar.this.f20720h.f20774h);
                            }
                            i10++;
                        }
                    }
                }
            }
        }
    }

    public class h extends C1313a {
        public h() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.b(new c.a(16, MaterialCalendar.this.f20726n.getVisibility() == 0 ? MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection)));
        }
    }

    public class i extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f20742a;

        public i(q qVar) {
            this.f20742a = qVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int iFindFirstVisibleItemPosition = i10 < 0 ? MaterialCalendar.this.H().findFirstVisibleItemPosition() : MaterialCalendar.this.H().findLastVisibleItemPosition();
            Month monthD = this.f20742a.d(iFindFirstVisibleItemPosition);
            MaterialCalendar.this.f20718f = monthD;
            MaterialCalendar.this.f20727o.setText(this.f20742a.e(iFindFirstVisibleItemPosition));
            MaterialCalendar.this.P(this.f20742a.f(monthD));
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.O();
        }
    }

    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f20745a;

        public k(q qVar) {
            this.f20745a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.L(this.f20745a.d(MaterialCalendar.this.H().findFirstVisibleItemPosition() + 1));
        }
    }

    public interface l {
        void a(long j10);
    }

    public static int F(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    public static int G(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i10 = p.f20840g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    public static <T> MaterialCalendar<T> I(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    public final RecyclerView.ItemDecoration A() {
        return new g();
    }

    public CalendarConstraints B() {
        return this.f20716d;
    }

    public com.google.android.material.datepicker.b C() {
        return this.f20720h;
    }

    public Month D() {
        return this.f20718f;
    }

    public DateSelector<S> E() {
        return this.f20715c;
    }

    public LinearLayoutManager H() {
        return (LinearLayoutManager) this.f20722j.getLayoutManager();
    }

    public final void J(int i10) {
        this.f20722j.post(new b(i10));
    }

    public void K() {
        MaterialButton materialButton = this.f20727o;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }

    public void L(Month month) {
        q qVar = (q) this.f20722j.getAdapter();
        int iF = qVar.f(month);
        AccessibilityManager accessibilityManager = this.f20728p;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iF2 = iF - qVar.f(this.f20718f);
            boolean z10 = Math.abs(iF2) > 3;
            boolean z11 = iF2 > 0;
            this.f20718f = month;
            if (z10 && z11) {
                this.f20722j.scrollToPosition(iF - 3);
                J(iF);
            } else if (z10) {
                this.f20722j.scrollToPosition(iF + 3);
                J(iF);
            } else {
                J(iF);
            }
        } else {
            this.f20718f = month;
            this.f20722j.scrollToPosition(iF);
        }
        P(iF);
    }

    public void M(CalendarSelector calendarSelector) {
        this.f20719g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f20721i.getLayoutManager().scrollToPosition(((w) this.f20721i.getAdapter()).e(this.f20718f.year));
            this.f20725m.setVisibility(0);
            this.f20726n.setVisibility(8);
            this.f20723k.setVisibility(8);
            this.f20724l.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f20725m.setVisibility(8);
            this.f20726n.setVisibility(0);
            this.f20723k.setVisibility(0);
            this.f20724l.setVisibility(0);
            L(this.f20718f);
        }
    }

    public final void N() {
        N.i0(this.f20722j, new f());
    }

    public void O() {
        CalendarSelector calendarSelector = this.f20719g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            M(CalendarSelector.DAY);
            this.f20722j.announceForAccessibility(getString(R$string.mtrl_picker_toggled_to_day_selection));
        } else if (calendarSelector == CalendarSelector.DAY) {
            M(calendarSelector2);
            this.f20721i.announceForAccessibility(getString(R$string.mtrl_picker_toggled_to_year_selection));
        }
    }

    public final void P(int i10) {
        this.f20724l.setEnabled(i10 + 1 < this.f20722j.getAdapter().getItemCount());
        this.f20723k.setEnabled(i10 - 1 >= 0);
    }

    @Override // com.google.android.material.datepicker.s
    public boolean o(r<S> rVar) {
        return super.o(rVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f20714b = bundle.getInt("THEME_RES_ID_KEY");
        this.f20715c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f20716d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f20717e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f20718f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f20714b);
        this.f20720h = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f20728p = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month start = this.f20716d.getStart();
        if (m.B(contextThemeWrapper)) {
            i10 = R$layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R$layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        viewInflate.setMinimumHeight(G(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        N.i0(gridView, new c());
        int firstDayOfWeek = this.f20716d.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new com.google.android.material.datepicker.i(firstDayOfWeek) : new com.google.android.material.datepicker.i()));
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.f20722j = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.f20722j.setLayoutManager(new d(getContext(), i11, false, i11));
        this.f20722j.setTag(f20710q);
        q qVar = new q(contextThemeWrapper, this.f20715c, this.f20716d, this.f20717e, new e());
        this.f20722j.setAdapter(qVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f20721i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f20721i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f20721i.setAdapter(new w(this));
            this.f20721i.addItemDecoration(A());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            z(viewInflate, qVar);
        }
        if (!m.B(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f20722j);
        }
        this.f20722j.scrollToPosition(qVar.f(this.f20718f));
        N();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f20714b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f20715c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f20716d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f20717e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f20718f);
    }

    public final void z(View view, q qVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        this.f20727o = materialButton;
        materialButton.setTag(f20713t);
        N.i0(this.f20727o, new h());
        View viewFindViewById = view.findViewById(R$id.month_navigation_previous);
        this.f20723k = viewFindViewById;
        viewFindViewById.setTag(f20711r);
        View viewFindViewById2 = view.findViewById(R$id.month_navigation_next);
        this.f20724l = viewFindViewById2;
        viewFindViewById2.setTag(f20712s);
        this.f20725m = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f20726n = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        M(CalendarSelector.DAY);
        this.f20727o.setText(this.f20718f.getLongName());
        this.f20722j.addOnScrollListener(new i(qVar));
        this.f20727o.setOnClickListener(new j());
        this.f20724l.setOnClickListener(new k(qVar));
        this.f20723k.setOnClickListener(new a(qVar));
        P(qVar.f(this.f20718f));
    }
}
