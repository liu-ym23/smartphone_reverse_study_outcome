package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.android.live.core.utils.j0;

/* JADX INFO: loaded from: classes45.dex */
public class LiveEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j0 f66563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f66564b;

    public LiveEditText(Context r100) {
        this(r100, null);
    }

    public static void setEnableHostTypeface(boolean r100) {
        f66564b = r100;
    }

    public static void setFontManager(j0 r100) {
        f66563a = r100;
    }

    public final void c(AttributeSet r100) {
        if (f66564b == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        int r101 = r100.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0);
        j0 r102 = f66563a;
        if (r102 == null) goto L13;
        Typeface r103 = r102.getHostTypeface(r101);
        if (r103 == null) goto L14;
        setTypeface(r103);
        return;
    L14:
        return;
    }

    public LiveEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        c(r101);
    }

    public LiveEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
