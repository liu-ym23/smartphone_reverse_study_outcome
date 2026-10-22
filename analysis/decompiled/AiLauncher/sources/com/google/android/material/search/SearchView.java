package com.google.android.material.search;

import T2.b;
import T2.c;
import T2.f;
import Z2.i;
import android.annotation.SuppressLint;
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
import androidx.customview.view.AbsSavedState;
import b.C1423c;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$style;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.e;
import com.google.android.material.internal.s;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import u0.C5566a;

/* loaded from: classes2.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, b {

    /* renamed from: x, reason: collision with root package name */
    public static final int f21232x = R$style.Widget_Material3_SearchView;

    /* renamed from: a, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f21233a;

    /* renamed from: b, reason: collision with root package name */
    public final View f21234b;

    /* renamed from: c, reason: collision with root package name */
    public final View f21235c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f21236d;

    /* renamed from: e, reason: collision with root package name */
    public final MaterialToolbar f21237e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f21238f;

    /* renamed from: g, reason: collision with root package name */
    public final EditText f21239g;

    /* renamed from: h, reason: collision with root package name */
    public final TouchObserverFrameLayout f21240h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f21241i;

    /* renamed from: j, reason: collision with root package name */
    public final c f21242j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f21243k;

    /* renamed from: l, reason: collision with root package name */
    public final P2.a f21244l;

    /* renamed from: m, reason: collision with root package name */
    public final Set<a> f21245m;

    /* renamed from: n, reason: collision with root package name */
    public SearchBar f21246n;

    /* renamed from: o, reason: collision with root package name */
    public int f21247o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21248p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21249q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21250r;

    /* renamed from: s, reason: collision with root package name */
    public final int f21251s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21252t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21253u;

    /* renamed from: v, reason: collision with root package name */
    public TransitionState f21254v;

    /* renamed from: w, reason: collision with root package name */
    public Map<View, Integer> f21255w;

    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.g() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String text;
        int visibility;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.text);
            parcel.writeInt(this.visibility);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
            this.visibility = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    public interface a {
        void a(SearchView searchView, TransitionState transitionState, TransitionState transitionState2);
    }

    private Window getActivityWindow() {
        Activity activityA = com.google.android.material.internal.b.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f21246n;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R$dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        this.f21235c.setVisibility(z10 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
        P2.a aVar = this.f21244l;
        if (aVar == null || this.f21234b == null) {
            return;
        }
        this.f21234b.setBackgroundColor(aVar.c(this.f21251s, f10));
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            a(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f21236d, false));
        }
    }

    private void setUpStatusBarSpacer(int i10) {
        if (this.f21235c.getLayoutParams().height != i10) {
            this.f21235c.getLayoutParams().height = i10;
            this.f21235c.requestLayout();
        }
    }

    public void a(View view) {
        this.f21236d.addView(view);
        this.f21236d.setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f21241i) {
            this.f21240h.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    @Override // T2.b
    public void b(C1423c c1423c) {
        SearchBar searchBar;
        if (c() || (searchBar = this.f21246n) == null) {
            return;
        }
        if (searchBar != null) {
            searchBar.setPlaceholderText(this.f21239g.getText().toString());
        }
        throw null;
    }

    public final boolean c() {
        return this.f21254v.equals(TransitionState.HIDDEN) || this.f21254v.equals(TransitionState.HIDING);
    }

    @Override // T2.b
    public void d() {
        if (!c() && this.f21246n != null) {
            throw null;
        }
    }

    @Override // T2.b
    public void e(C1423c c1423c) {
        if (!c() && this.f21246n != null) {
            throw null;
        }
    }

    @Override // T2.b
    public void f() {
        if (!c()) {
            throw null;
        }
    }

    public boolean g() {
        return this.f21246n != null;
    }

    public f getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.f21254v;
    }

    public int getDefaultNavigationIconResource() {
        return R$drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return this.f21239g;
    }

    public CharSequence getHint() {
        return this.f21239g.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f21238f;
    }

    public CharSequence getSearchPrefixText() {
        return this.f21238f.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f21247o;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f21239g.getText();
    }

    public Toolbar getToolbar() {
        return this.f21237e;
    }

    public final void h(TransitionState transitionState, boolean z10) {
        if (this.f21254v.equals(transitionState)) {
            return;
        }
        if (z10) {
            k(transitionState);
        }
        TransitionState transitionState2 = this.f21254v;
        this.f21254v = transitionState;
        Iterator it = new LinkedHashSet(this.f21245m).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(this, transitionState2, transitionState);
        }
        j(transitionState);
        SearchBar searchBar = this.f21246n;
        if (searchBar == null || transitionState != TransitionState.HIDDEN) {
            return;
        }
        searchBar.sendAccessibilityEvent(8);
    }

    @SuppressLint({"InlinedApi"})
    public final void i(ViewGroup viewGroup, boolean z10) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this) {
                if (childAt.findViewById(this.f21233a.getId()) != null) {
                    i((ViewGroup) childAt, z10);
                } else if (z10) {
                    this.f21255w.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                } else {
                    Map<View, Integer> map = this.f21255w;
                    if (map != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.f21255w.get(childAt).intValue());
                    }
                }
            }
        }
    }

    public final void j(TransitionState transitionState) {
        if (this.f21246n == null || !this.f21243k) {
            return;
        }
        if (transitionState.equals(TransitionState.SHOWN)) {
            this.f21242j.c();
        } else if (transitionState.equals(TransitionState.HIDDEN)) {
            this.f21242j.f();
        }
    }

    public final void k(TransitionState transitionState) {
        if (transitionState == TransitionState.SHOWN) {
            setModalForAccessibility(true);
        } else if (transitionState == TransitionState.HIDDEN) {
            setModalForAccessibility(false);
        }
    }

    public final void l() {
        ImageButton imageButtonD = s.d(this.f21237e);
        if (imageButtonD == null) {
            return;
        }
        int i10 = this.f21233a.getVisibility() == 0 ? 1 : 0;
        Drawable drawableQ = C5566a.q(imageButtonD.getDrawable());
        if (drawableQ instanceof g.b) {
            ((g.b) drawableQ).b(i10);
        }
        if (drawableQ instanceof e) {
            ((e) drawableQ).a(i10);
        }
    }

    public void m() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f21247o = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
        TransitionState currentTransitionState = getCurrentTransitionState();
        k(currentTransitionState);
        j(currentTransitionState);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        this.f21242j.f();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
        setVisible(savedState.visibility == 0);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.text = text == null ? null : text.toString();
        savedState.visibility = this.f21233a.getVisibility();
        return savedState;
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f21248p = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f21250r = z10;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(CharSequence charSequence) {
        this.f21239g.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f21249q = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.f21255w = new HashMap(viewGroup.getChildCount());
        }
        i(viewGroup, z10);
        if (z10) {
            return;
        }
        this.f21255w = null;
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.f21237e.setOnMenuItemClickListener(hVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        this.f21238f.setText(charSequence);
        this.f21238f.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z10) {
        this.f21253u = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.f21239g.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f21237e.setTouchscreenBlocksFocus(z10);
    }

    public void setTransitionState(TransitionState transitionState) {
        h(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z10) {
        this.f21252t = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11 = this.f21233a.getVisibility() == 0;
        this.f21233a.setVisibility(z10 ? 0 : 8);
        l();
        h(z10 ? TransitionState.SHOWN : TransitionState.HIDDEN, z11 != z10);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f21246n = searchBar;
        throw null;
    }

    public void setHint(int i10) {
        this.f21239g.setHint(i10);
    }

    public void setText(int i10) {
        this.f21239g.setText(i10);
    }
}
