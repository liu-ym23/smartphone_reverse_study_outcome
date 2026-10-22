package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.j0;

/* JADX INFO: loaded from: classes45.dex */
public class LiveTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j0 f66565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f66566b;

    public LiveTextView(Context r100) {
        this(r100, null);
    }

    public static void setEnableHostTypeface(boolean r100) {
        f66566b = r100;
    }

    public static void setFontManager(j0 r100) {
        f66565a = r100;
    }

    public final void x(AttributeSet r100) {
        if (f66566b == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        int r101 = r100.getAttributeIntValue("https://schemas.android.com/apk/res/android", "textStyle", 0);
        j0 r102 = f66565a;
        if (r102 == null) goto L13;
        Typeface r103 = r102.getHostTypeface(r101);
        if (r103 == null) goto L14;
        setTypeface(r103);
        return;
    L14:
        return;
    }

    public LiveTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        x(r101);
    }

    public LiveTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        x(r101);
    }
}
