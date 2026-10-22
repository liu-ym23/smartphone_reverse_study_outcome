package com.bytedance.android.ecom.arch.slice.render.elements.text;

import android.text.SpanWatcher;
import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends SpannableStringBuilder {
    public d() {
        this(0);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return super.length();
    }

    public d(int r100) {
        super("");
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int r100) {
        return super.charAt(r100);
    }

    public d(CharSequence r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final <T> T[] getSpans(int r100, int r101, Class<T> r102) {
        if (r102 != null) goto L7;
        return (T[]) new Object[0];
    L7:
        if (r102.equals(SpanWatcher.class) == false) goto L11;
        return (T[]) new SpanWatcher[0];
    L11:
        return (T[]) super.getSpans(r100, r101, r102);
    }
}
