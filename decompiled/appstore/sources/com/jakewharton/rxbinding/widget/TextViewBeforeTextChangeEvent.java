package com.jakewharton.rxbinding.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class TextViewBeforeTextChangeEvent extends ViewEvent<TextView> {
    private final int after;
    private final int count;
    private final int start;
    private final CharSequence text;

    private TextViewBeforeTextChangeEvent(@NonNull TextView r10, @NonNull CharSequence r11, int r12, int r13, int r14) {
        super(r10);
        this.text = r11;
        this.start = r12;
        this.count = r13;
        this.after = r14;
    }

    @NonNull
    @CheckResult
    public static TextViewBeforeTextChangeEvent create(@NonNull TextView r10, @NonNull CharSequence r11, int r12, int r13, int r14) {
        return new TextViewBeforeTextChangeEvent(r10, r11, r12, r13, r14);
    }

    public int after() {
        return this.after;
    }

    public int count() {
        return this.count;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextViewAfterTextChangeEvent) == true) goto L8;
        return false;
    L8:
        TextViewBeforeTextChangeEvent r11 = (TextViewBeforeTextChangeEvent) r10;
        if (r11.view() != view()) goto L20;
        if (this.text.equals(r11.text) == false) goto L20;
        if (this.start != r11.start) goto L20;
        if (this.count != r11.count) goto L20;
        if (this.after != r11.after) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return ((((((((629 + view().hashCode()) * 37) + this.text.hashCode()) * 37) + this.start) * 37) + this.count) * 37) + this.after;
    }

    public int start() {
        return this.start;
    }

    @NonNull
    public CharSequence text() {
        return this.text;
    }

    public String toString() {
        return "TextViewBeforeTextChangeEvent{text=" + this.text + ", start=" + this.start + ", count=" + this.count + ", after=" + this.after + ", view=" + view() + '}';
    }
}
