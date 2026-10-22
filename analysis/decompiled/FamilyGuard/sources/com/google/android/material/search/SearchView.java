package com.google.android.material.search;

import a1.C0411d;
import a1.C0412e;
import a1.C0417j;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.e;
import com.google.android.material.internal.p;
import i.C0755b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import l1.C0831a;
import t1.C1116i;

/* loaded from: classes.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b {

    /* renamed from: w, reason: collision with root package name */
    private static final int f13076w = C0417j.f6920k;

    /* renamed from: a, reason: collision with root package name */
    final ClippableRoundedCornerLayout f13077a;

    /* renamed from: b, reason: collision with root package name */
    final View f13078b;

    /* renamed from: c, reason: collision with root package name */
    final View f13079c;

    /* renamed from: d, reason: collision with root package name */
    final FrameLayout f13080d;

    /* renamed from: e, reason: collision with root package name */
    final MaterialToolbar f13081e;

    /* renamed from: f, reason: collision with root package name */
    final TextView f13082f;

    /* renamed from: g, reason: collision with root package name */
    final EditText f13083g;

    /* renamed from: h, reason: collision with root package name */
    final TouchObserverFrameLayout f13084h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f13085i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f13086j;

    /* renamed from: k, reason: collision with root package name */
    private final C0831a f13087k;

    /* renamed from: l, reason: collision with root package name */
    private final Set<b> f13088l;

    /* renamed from: m, reason: collision with root package name */
    private SearchBar f13089m;

    /* renamed from: n, reason: collision with root package name */
    private int f13090n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f13091o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f13092p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13093q;

    /* renamed from: r, reason: collision with root package name */
    private final int f13094r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13095s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13096t;

    /* renamed from: u, reason: collision with root package name */
    private c f13097u;

    /* renamed from: v, reason: collision with root package name */
    private Map<View, Integer> f13098v;

    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.b() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static class a extends androidx.customview.view.a {
        public static final Parcelable.Creator<a> CREATOR = new C0170a();

        /* renamed from: a, reason: collision with root package name */
        String f13099a;

        /* renamed from: b, reason: collision with root package name */
        int f13100b;

        /* renamed from: com.google.android.material.search.SearchView$a$a, reason: collision with other inner class name */
        class C0170a implements Parcelable.ClassLoaderCreator<a> {
            C0170a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.f13099a);
            parcel.writeInt(this.f13100b);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13099a = parcel.readString();
            this.f13100b = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface b {
        void a(SearchView searchView, c cVar, c cVar2);
    }

    public enum c {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    private void c(c cVar, boolean z5) {
        if (this.f13097u.equals(cVar)) {
            return;
        }
        if (z5) {
            f(cVar);
        }
        c cVar2 = this.f13097u;
        this.f13097u = cVar;
        Iterator it = new LinkedHashSet(this.f13088l).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, cVar2, cVar);
        }
        e(cVar);
        SearchBar searchBar = this.f13089m;
        if (searchBar == null || cVar != c.HIDDEN) {
            return;
        }
        searchBar.sendAccessibilityEvent(8);
    }

    private void d(ViewGroup viewGroup, boolean z5) {
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt != this) {
                if (childAt.findViewById(this.f13077a.getId()) != null) {
                    d((ViewGroup) childAt, z5);
                } else if (z5) {
                    this.f13098v.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                } else {
                    Map<View, Integer> map = this.f13098v;
                    if (map != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.f13098v.get(childAt).intValue());
                    }
                }
            }
        }
    }

    private void e(c cVar) {
        if (this.f13089m == null || !this.f13086j) {
            return;
        }
        if (cVar.equals(c.SHOWN) || cVar.equals(c.HIDDEN)) {
            throw null;
        }
    }

    private void f(c cVar) {
        if (cVar == c.SHOWN) {
            setModalForAccessibility(true);
        } else if (cVar == c.HIDDEN) {
            setModalForAccessibility(false);
        }
    }

    private void g() {
        ImageButton imageButtonD = p.d(this.f13081e);
        if (imageButtonD == null) {
            return;
        }
        int i5 = this.f13077a.getVisibility() == 0 ? 1 : 0;
        Drawable drawableQ = androidx.core.graphics.drawable.a.q(imageButtonD.getDrawable());
        if (drawableQ instanceof C0755b) {
            ((C0755b) drawableQ).b(i5);
        }
        if (drawableQ instanceof e) {
            ((e) drawableQ).a(i5);
        }
    }

    private Window getActivityWindow() {
        Activity activityA = com.google.android.material.internal.b.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f13089m;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(C0411d.f6803w);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z5) {
        this.f13079c.setVisibility(z5 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f5) {
        C0831a c0831a = this.f13087k;
        if (c0831a == null || this.f13078b == null) {
            return;
        }
        this.f13078b.setBackgroundColor(c0831a.c(this.f13094r, f5));
    }

    private void setUpHeaderLayout(int i5) {
        if (i5 != -1) {
            a(LayoutInflater.from(getContext()).inflate(i5, (ViewGroup) this.f13080d, false));
        }
    }

    private void setUpStatusBarSpacer(int i5) {
        if (this.f13079c.getLayoutParams().height != i5) {
            this.f13079c.getLayoutParams().height = i5;
            this.f13079c.requestLayout();
        }
    }

    public void a(View view) {
        this.f13080d.addView(view);
        this.f13080d.setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (this.f13085i) {
            this.f13084h.addView(view, i5, layoutParams);
        } else {
            super.addView(view, i5, layoutParams);
        }
    }

    public boolean b() {
        return this.f13089m != null;
    }

    o1.c getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public c getCurrentTransitionState() {
        return this.f13097u;
    }

    protected int getDefaultNavigationIconResource() {
        return C0412e.f6808b;
    }

    public EditText getEditText() {
        return this.f13083g;
    }

    public CharSequence getHint() {
        return this.f13083g.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f13082f;
    }

    public CharSequence getSearchPrefixText() {
        return this.f13082f.getText();
    }

    public int getSoftInputMode() {
        return this.f13090n;
    }

    public Editable getText() {
        return this.f13083g.getText();
    }

    public Toolbar getToolbar() {
        return this.f13081e;
    }

    public void h() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f13090n = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1116i.e(this);
        c currentTransitionState = getCurrentTransitionState();
        f(currentTransitionState);
        e(currentTransitionState);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        throw null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f13099a);
        setVisible(aVar.f13100b == 0);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        Editable text = getText();
        aVar.f13099a = text == null ? null : text.toString();
        aVar.f13100b = this.f13077a.getVisibility();
        return aVar;
    }

    public void setAnimatedNavigationIcon(boolean z5) {
        this.f13091o = z5;
    }

    public void setAutoShowKeyboard(boolean z5) {
        this.f13093q = z5;
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        setUpBackgroundViewElevationOverlay(f5);
    }

    public void setHint(CharSequence charSequence) {
        this.f13083g.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z5) {
        this.f13092p = z5;
    }

    public void setModalForAccessibility(boolean z5) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z5) {
            this.f13098v = new HashMap(viewGroup.getChildCount());
        }
        d(viewGroup, z5);
        if (z5) {
            return;
        }
        this.f13098v = null;
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.f13081e.setOnMenuItemClickListener(hVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        this.f13082f.setText(charSequence);
        this.f13082f.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z5) {
        this.f13096t = true;
        setStatusBarSpacerEnabledInternal(z5);
    }

    public void setText(CharSequence charSequence) {
        this.f13083g.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z5) {
        this.f13081e.setTouchscreenBlocksFocus(z5);
    }

    void setTransitionState(c cVar) {
        c(cVar, true);
    }

    public void setUseWindowInsetsController(boolean z5) {
        this.f13095s = z5;
    }

    public void setVisible(boolean z5) {
        boolean z6 = this.f13077a.getVisibility() == 0;
        this.f13077a.setVisibility(z5 ? 0 : 8);
        g();
        c(z5 ? c.SHOWN : c.HIDDEN, z6 != z5);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f13089m = searchBar;
        throw null;
    }

    public void setHint(int i5) {
        this.f13083g.setHint(i5);
    }

    public void setText(int i5) {
        this.f13083g.setText(i5);
    }
}
