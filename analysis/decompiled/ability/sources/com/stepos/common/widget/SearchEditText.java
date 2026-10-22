package com.stepos.common.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class SearchEditText extends EditText {
    public static final /* synthetic */ int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f3764a;
    public final Uri b;
    public boolean c;
    public final int d;
    public final int e;
    public final F5.a f;

    public SearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3764a = Settings.Global.getUriFor("stepos_dark_mode_preference_color");
        this.b = Settings.Global.getUriFor("steposlab_stepos_night_mode");
        this.f = new F5.a(this, getHandler(), 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.k);
        this.d = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.stepos_titlebar_search_view_edittext_bg);
        this.e = typedArrayObtainStyledAttributes.getResourceId(1, R.drawable.stepos_titlebar_search_view_edittext_soft_night_mode_bg);
        typedArrayObtainStyledAttributes.recycle();
        float f = context.getResources().getConfiguration().fontScale;
        Log.i("SearchEditText", "fontScale:" + f);
        if (f > 1.0f) {
            post(new I4.l(11, this, context));
        }
    }

    public final void a(boolean z10) {
        int i = !this.c ? false : "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), "stepos_dark_mode_preference_color")) ? this.e : this.d;
        if (z10) {
            setBackground(ContextCompat.getDrawable(getContext(), i));
        } else {
            setBackgroundResource(i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = (getContext().getResources().getConfiguration().uiMode & 48) == 32;
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = this.f3764a;
        F5.a aVar = this.f;
        contentResolver.registerContentObserver(uri, false, aVar);
        getContext().getContentResolver().registerContentObserver(this.b, false, aVar);
        a(false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z10 = (configuration.uiMode & 48) == 32;
        if (z10 != this.c) {
            this.c = z10;
            a(true);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }
}
