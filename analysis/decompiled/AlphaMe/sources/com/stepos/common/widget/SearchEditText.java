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
import com.stepos.alphame.R;
import i2.AbstractC0620a;

/* loaded from: classes.dex */
public class SearchEditText extends EditText {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f11774g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f11775a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f11776b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11777c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11778d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11779e;

    /* renamed from: f, reason: collision with root package name */
    public final X.v f11780f;

    public SearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11775a = Settings.Global.getUriFor("stepos_dark_mode_preference_color");
        this.f11776b = Settings.Global.getUriFor("steposlab_stepos_night_mode");
        this.f11780f = new X.v(this, getHandler(), 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13029k);
        this.f11778d = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.stepos_titlebar_search_view_edittext_bg);
        this.f11779e = typedArrayObtainStyledAttributes.getResourceId(1, R.drawable.stepos_titlebar_search_view_edittext_soft_night_mode_bg);
        typedArrayObtainStyledAttributes.recycle();
        float f4 = context.getResources().getConfiguration().fontScale;
        Log.i("SearchEditText", "fontScale:" + f4);
        if (f4 > 1.0f) {
            post(new androidx.appcompat.app.o(14, this, context));
        }
    }

    public final void a(boolean z4) {
        int i4 = (this.f11777c && "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), "stepos_dark_mode_preference_color"))) ? this.f11779e : this.f11778d;
        if (z4) {
            setBackground(androidx.core.content.a.b(getContext(), i4));
        } else {
            setBackgroundResource(i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11777c = (getContext().getResources().getConfiguration().uiMode & 48) == 32;
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = this.f11775a;
        X.v vVar = this.f11780f;
        contentResolver.registerContentObserver(uri, false, vVar);
        getContext().getContentResolver().registerContentObserver(this.f11776b, false, vVar);
        a(false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z4 = (configuration.uiMode & 48) == 32;
        if (z4 != this.f11777c) {
            this.f11777c = z4;
            a(true);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f11780f);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }
}
