package com.stepos.common.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SearchEditText extends EditText {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f7027j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f7028a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f7029b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7030c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7031d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7032e;
    public final a h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            int i10 = SearchEditText.f7027j;
            SearchEditText.this.a(false);
        }
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7028a = Settings.Global.getUriFor("stepos_dark_mode_preference_color");
        this.f7029b = Settings.Global.getUriFor("steposlab_stepos_night_mode");
        this.h = new a(getHandler());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9084k);
        this.f7031d = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.stepos_titlebar_search_view_edittext_bg);
        this.f7032e = typedArrayObtainStyledAttributes.getResourceId(1, R.drawable.stepos_titlebar_search_view_edittext_soft_night_mode_bg);
        typedArrayObtainStyledAttributes.recycle();
        float f8 = context.getResources().getConfiguration().fontScale;
        Log.i("SearchEditText", "fontScale:" + f8);
        if (f8 > 1.0f) {
            post(new androidx.room.o(6, this, context));
        }
    }

    public final void a(boolean z) {
        int i10 = !this.f7030c ? false : "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), "stepos_dark_mode_preference_color")) ? this.f7032e : this.f7031d;
        if (z) {
            setBackground(getContext().getDrawable(i10));
        } else {
            setBackgroundResource(i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7030c = (getContext().getResources().getConfiguration().uiMode & 48) == 32;
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = this.f7028a;
        a aVar = this.h;
        contentResolver.registerContentObserver(uri, false, aVar);
        getContext().getContentResolver().registerContentObserver(this.f7029b, false, aVar);
        a(false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = (configuration.uiMode & 48) == 32;
        if (z != this.f7030c) {
            this.f7030c = z;
            a(true);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.h);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }
}
