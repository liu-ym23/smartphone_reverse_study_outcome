package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.b0;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationView extends NavigationBarView {
    static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context r10) {
        this(r10, null);
    }

    private void addCompatibilityTopDivider(@NonNull Context r10) {
        View r11 = new View(r10);
        r11.setBackgroundColor(ContextCompat.b(r10, R.color.design_bottom_navigation_shadow_color));
        r11.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r11);
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r10) {
        return new BottomNavigationMenuView(r10);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    public void setItemHorizontalTranslationEnabled(boolean r10) {
        BottomNavigationMenuView r11 = (BottomNavigationMenuView) getMenuView();
        if (r11.isItemHorizontalTranslationEnabled() == r10) goto L6;
        r11.setItemHorizontalTranslationEnabled(r10);
        getPresenter().updateMenuView(false);
        return;
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener r10) {
        setOnItemReselectedListener(r10);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r10) {
        setOnItemSelectedListener(r10);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        Context r14 = getContext();
        b0 r15 = ThemeEnforcement.obtainTintedStyledAttributes(r14, r11, R.styleable.BottomNavigationView, r12, r13, new int[0]);
        setItemHorizontalTranslationEnabled(r15.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        r15.w();
        if (shouldDrawCompatibilityTopDivider() == false) goto L6;
        addCompatibilityTopDivider(r14);
        return;
    }
}
