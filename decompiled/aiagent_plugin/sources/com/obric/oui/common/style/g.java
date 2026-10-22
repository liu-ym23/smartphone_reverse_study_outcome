package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OUIResHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TypedValue f34528a;

    public static float a(Context r2, int r3) {
        return a(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getTheme(), r3);
    }

    public static float a(Resources.Theme r2, int r3) {
        if (f34528a != null) goto L6;
        f34528a = new TypedValue();
    L6:
        if (r2.resolveAttribute(r3, f34528a, true) == true) goto L10;
        return -1.0f;
    L10:
        return f34528a.getFloat();
    }

    public static int b(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f34528a != null) goto L6;
        f34528a = new TypedValue();
    L6:
        if (r5.getTheme().resolveAttribute(r4, f34528a, true) == true) goto L10;
        return 0;
    L10:
        return TypedValue.complexToDimensionPixelSize(f34528a.data, d.a(r5));
    }

    public static TypedArray a(Resources r2, Resources.Theme r3, AttributeSet r4, int[] r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return r2.obtainAttributes(r6, r5);
    L6:
        return r3.obtainStyledAttributes(r6, r5, 0, 0);
    }
}
