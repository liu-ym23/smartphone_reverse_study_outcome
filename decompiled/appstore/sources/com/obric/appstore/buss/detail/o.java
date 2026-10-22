package com.obric.appstore.buss.detail;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.core.widget.TextViewCompat;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10687a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10688b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10689c = 0;

    static {
        f10687a = yf.b.b(TypedValue.applyDimension(1, 68, Resources.getSystem().getDisplayMetrics()));
        f10688b = yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        f10689c = yf.b.b(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
    }

    public static final int a() {
        return f10687a;
    }

    public static final int b() {
        return f10689c;
    }

    public static final int c() {
        return f10688b;
    }

    public static final void d(ObricAppItemView r10) {
        q.g(r10, "<this>");
        int r11 = yf.b.b(TypedValue.applyDimension(1, 64, Resources.getSystem().getDisplayMetrics()));
        ViewGroup.LayoutParams r12 = r10.getVIcon().getLayoutParams();
        r12.height = r11;
        r12.width = r11;
        r10.getVIcon().setLayoutParams(r12);
        r10.setAppIconRadius(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        r10.getVName().setTextSize(20.0f);
        r10.getVName().setTypeface(Typeface.create(null, 500, false));
        r10.getVScoreAndSizeContainer().setVisibility(0);
        r10.k(true);
        TextViewCompat.n(r10.getVBrief(), R.style.Subtitle_2_Regular);
    }
}
