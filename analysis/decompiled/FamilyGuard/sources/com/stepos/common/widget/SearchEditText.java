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

/* loaded from: classes.dex */
public class SearchEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f14168a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f14169b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14170c;

    /* renamed from: d, reason: collision with root package name */
    private final int f14171d;

    /* renamed from: e, reason: collision with root package name */
    private final int f14172e;

    /* renamed from: f, reason: collision with root package name */
    private final ContentObserver f14173f;

    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            SearchEditText.this.g();
        }
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        Pair<Integer, Integer> pairD = d();
        float f5 = context.getResources().getConfiguration().fontScale;
        if (pairD == null || f5 <= 1.0f) {
            return;
        }
        setPadding(context.getResources().getDimensionPixelSize(H1.f.f2119O) + ((Integer) pairD.second).intValue() + ((Integer) pairD.first).intValue(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
    }

    private Pair<Integer, Integer> d() {
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int[] iArr = new int[2];
        getLocationInSurface(iArr);
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
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

    private boolean e(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        h(false);
    }

    private void h(boolean z5) {
        int i5 = f() ? this.f14172e : this.f14171d;
        if (z5) {
            setBackground(androidx.core.content.a.e(getContext(), i5));
        } else {
            setBackgroundResource(i5);
        }
    }

    protected boolean f() {
        if (this.f14170c) {
            return "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), "stepos_dark_mode_preference_color"));
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14170c = e(getContext().getResources().getConfiguration());
        getContext().getContentResolver().registerContentObserver(this.f14168a, false, this.f14173f);
        getContext().getContentResolver().registerContentObserver(this.f14169b, false, this.f14173f);
        g();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean zE = e(configuration);
        if (zE != this.f14170c) {
            this.f14170c = zE;
            h(true);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f14173f);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }

    public SearchEditText(final Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14168a = Settings.Global.getUriFor("stepos_dark_mode_preference_color");
        this.f14169b = Settings.Global.getUriFor("steposlab_stepos_night_mode");
        this.f14173f = new a(getHandler());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2574e4);
        this.f14171d = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2581f4, H1.g.f2183S);
        this.f14172e = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2587g4, H1.g.f2184T);
        typedArrayObtainStyledAttributes.recycle();
        float f5 = context.getResources().getConfiguration().fontScale;
        Log.i("SearchEditText", "fontScale:" + f5);
        if (f5 > 1.0f) {
            post(new Runnable() { // from class: com.stepos.common.widget.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14429a.c(context);
                }
            });
        }
    }
}
