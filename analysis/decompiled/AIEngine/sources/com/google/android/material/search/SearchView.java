package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.stepos.aiengine.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u4.b;
import u4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SearchView extends FrameLayout implements CoordinatorLayout.b, b {

    /* renamed from: a, reason: collision with root package name */
    public SearchBar f5115a;

    /* renamed from: b, reason: collision with root package name */
    public int f5116b;

    /* renamed from: c, reason: collision with root package name */
    public TransitionState f5117c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            SearchView searchView = (SearchView) view;
            if (searchView.f5115a != null || !(view2 instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view2);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String text;
        int visibility;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TransitionState {

        /* renamed from: a, reason: collision with root package name */
        public static final TransitionState f5118a;

        /* renamed from: b, reason: collision with root package name */
        public static final TransitionState f5119b;

        /* renamed from: c, reason: collision with root package name */
        public static final TransitionState f5120c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f5121d;

        static {
            TransitionState transitionState = new TransitionState("HIDING", 0);
            f5118a = transitionState;
            TransitionState transitionState2 = new TransitionState("HIDDEN", 1);
            f5119b = transitionState2;
            TransitionState transitionState3 = new TransitionState("SHOWING", 2);
            TransitionState transitionState4 = new TransitionState("SHOWN", 3);
            f5120c = transitionState4;
            f5121d = new TransitionState[]{transitionState, transitionState2, transitionState3, transitionState4};
        }

        public TransitionState() {
            throw null;
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f5121d.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a();
    }

    private Window getActivityWindow() {
        Activity activity;
        Context context = getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f5115a;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        throw null;
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 == -1) {
            return;
        }
        LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) null, false);
        throw null;
    }

    private void setUpStatusBarSpacer(int i10) {
        throw null;
    }

    @Override // u4.b
    public final void a(b.a aVar) {
        if (!b() && this.f5115a != null) {
            throw null;
        }
    }

    public final boolean b() {
        return this.f5117c.equals(TransitionState.f5119b) || this.f5117c.equals(TransitionState.f5118a);
    }

    @Override // u4.b
    public final void c() {
        if (!b() && this.f5115a != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // u4.b
    public final void e(b.a aVar) {
        if (!b() && this.f5115a != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // u4.b
    public final void f() {
        if (!b()) {
            throw null;
        }
    }

    public g getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.f5117c;
    }

    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return null;
    }

    public CharSequence getHint() {
        throw null;
    }

    public TextView getSearchPrefix() {
        return null;
    }

    public CharSequence getSearchPrefixText() {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f5116b;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        throw null;
    }

    public Toolbar getToolbar() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof y4.g) {
            xb.a.g(this, (y4.g) background);
        }
        TransitionState currentTransitionState = getCurrentTransitionState();
        if (currentTransitionState == TransitionState.f5120c) {
            setModalForAccessibility(true);
        } else if (currentTransitionState == TransitionState.f5119b) {
            setModalForAccessibility(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        throw null;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f5116b = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
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
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.text = text == null ? null : text.toString();
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        setUpBackgroundViewElevationOverlay(f8);
    }

    public void setHint(CharSequence charSequence) {
        throw null;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z) {
            new HashMap(viewGroup.getChildCount());
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            if (viewGroup.getChildAt(i10) != this) {
                throw null;
            }
        }
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        throw null;
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        throw null;
    }

    public void setStatusBarSpacerEnabled(boolean z) {
        setStatusBarSpacerEnabledInternal(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        throw null;
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        throw null;
    }

    public void setTransitionState(TransitionState transitionState) {
        if (this.f5117c.equals(transitionState)) {
            return;
        }
        TransitionState transitionState2 = TransitionState.f5120c;
        TransitionState transitionState3 = TransitionState.f5119b;
        if (transitionState == transitionState2) {
            setModalForAccessibility(true);
        } else if (transitionState == transitionState3) {
            setModalForAccessibility(false);
        }
        this.f5117c = transitionState;
        Iterator it = new LinkedHashSet((Collection) null).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
        SearchBar searchBar = this.f5115a;
        if (searchBar == null || transitionState != transitionState3) {
            return;
        }
        searchBar.sendAccessibilityEvent(8);
    }

    public void setVisible(boolean z) {
        throw null;
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f5115a = searchBar;
        throw null;
    }

    public void setHint(int i10) {
        throw null;
    }

    public void setText(int i10) {
        throw null;
    }

    private void setUpBackgroundViewElevationOverlay(float f8) {
    }

    public void setAnimatedNavigationIcon(boolean z) {
    }

    public void setAutoShowKeyboard(boolean z) {
    }

    public void setMenuItemsAnimated(boolean z) {
    }

    public void setUseWindowInsetsController(boolean z) {
    }
}
