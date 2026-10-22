package com.obric.oui.sheet.v2;

import android.content.Context;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    public static final int a(Context r10, int r11) {
        q.g(r10, "context");
        if (tc.g.f24781a.a(r10) == true) goto L5;
        return r11;
    L5:
        return bg.h.g(r11, tc.f.b(r10, 480));
    }

    public static final float b(Context r10) {
        q.g(r10, "context");
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return 0.5f;
    L5:
        return 0.16f;
    }
}
