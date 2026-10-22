package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes44.dex */
public final class h {
    static {
    }

    public static SpannableStringBuilder a(int r100) {
        SpannableStringBuilder r101 = new SpannableStringBuilder(" ");
        r101.setSpan(new b(Integer.valueOf(r100)), 0, r101.length(), 33);
        return r101;
    }
}
