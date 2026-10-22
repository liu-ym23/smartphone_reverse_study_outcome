package com.obric.oui.d;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import d.h.b.o;

/* JADX INFO: compiled from: TextViewFontWeightUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f35015a = null;

    static {
        f35015a = new f();
    }

    private f() {
    }

    public static final void a(TextView r6, int r7) {
        o.e(r6, "textView");
        Typeface r0 = r6.getTypeface();
        if (r0 != null) goto L5;
        r0 = Typeface.DEFAULT;
    L5:
        int r1 = 0;
        if (r0 != null) goto L9;
    L7:
        boolean r3 = false;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L15;
        Typeface r8 = Typeface.create(r0, r7, r3);
    L23:
        r6.setTypeface(r8);
        return;
    L15:
        if (r7 < 600) goto L18;
        if (r3 == false) goto L18;
        r1 = 3;
    L22:
        r8 = Typeface.create(r0, r1);
    L18:
        if (r7 < 600) goto L20;
        r1 = 1;
        goto L22
    L20:
        if (r3 == false) goto L22;
        r1 = 2;
        goto L22
    L9:
        if (r0.isItalic() != true) goto L7;
        r3 = true;
        goto L12
    }
}
