package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.stepos.common.R$dimen;
import com.stepos.common.R$drawable;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class SearchEditText extends EditText {
    private static final String DARK_MODE_CHANGE = "steposlab_stepos_night_mode";
    private static final String SOFT_DARK_MODE_VALUE = "stepos_dark_mode_preference_color";
    private static final String TAG = "SearchEditText";
    private final Uri darkModeChanged;
    private boolean isNightMode;
    private final int mNormalBackground;
    private final int mSoftNightBackground;
    private final ContentObserver nightModeObserver;
    private final Uri softDarkModeChanged;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            SearchEditText.this.g();
        }
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c(Context context) {
        Pair<Integer, Integer> pairD = d();
        float f10 = context.getResources().getConfiguration().fontScale;
        if (pairD == null || f10 <= 1.0f) {
            return;
        }
        setPadding(context.getResources().getDimensionPixelSize(R$dimen.mc_search_edit_margin_start) + ((Integer) pairD.second).intValue() + ((Integer) pairD.first).intValue(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
    }

    public final Pair<Integer, Integer> d() {
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int[] iArr = new int[2];
        getLocationInSurface(iArr);
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ImageFontCompatView) {
                int[] iArr2 = new int[2];
                childAt.getLocationInSurface(iArr2);
                if (iArr2[0] < iArr[0] + (getWidth() / 2)) {
                    return new Pair<>(Integer.valueOf(Math.abs(iArr2[0] - iArr[0])), Integer.valueOf(childAt.getWidth()));
                }
            }
        }
        return null;
    }

    public final boolean e(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public boolean f() {
        if (this.isNightMode) {
            return "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), SOFT_DARK_MODE_VALUE));
        }
        return false;
    }

    public final void g() {
        h(false);
    }

    public final void h(boolean z10) {
        int i10 = f() ? this.mSoftNightBackground : this.mNormalBackground;
        if (z10) {
            setBackground(androidx.core.content.a.e(getContext(), i10));
        } else {
            setBackgroundResource(i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isNightMode = e(getContext().getResources().getConfiguration());
        getContext().getContentResolver().registerContentObserver(this.softDarkModeChanged, false, this.nightModeObserver);
        getContext().getContentResolver().registerContentObserver(this.darkModeChanged, false, this.nightModeObserver);
        g();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean zE = e(configuration);
        if (zE != this.isNightMode) {
            this.isNightMode = zE;
            h(true);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.nightModeObserver);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }

    public SearchEditText(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.softDarkModeChanged = Settings.Global.getUriFor(SOFT_DARK_MODE_VALUE);
        this.darkModeChanged = Settings.Global.getUriFor(DARK_MODE_CHANGE);
        this.nightModeObserver = new a(getHandler());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SearchEditText);
        this.mNormalBackground = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SearchEditText_searchEditNormalBackground, R$drawable.stepos_titlebar_search_view_edittext_bg);
        this.mSoftNightBackground = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SearchEditText_searchEditSoftNightBackground, R$drawable.stepos_titlebar_search_view_edittext_soft_night_mode_bg);
        typedArrayObtainStyledAttributes.recycle();
        float f10 = context.getResources().getConfiguration().fontScale;
        Log.i(TAG, "fontScale:" + f10);
        if (f10 > 1.0f) {
            post(new Runnable() { // from class: com.stepos.common.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29520a.c(context);
                }
            });
        }
    }
}
