package com.jakewharton.rxbinding.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class TextViewTextChangeEvent extends ViewEvent<TextView> {
    private final int before;
    private final int count;
    private final int start;
    private final CharSequence text;

    private TextViewTextChangeEvent(@NonNull TextView r10, @NonNull CharSequence r11, int r12, int r13, int r14) {
        super(r10);
        this.text = r11;
        this.start = r12;
        this.before = r13;
        this.count = r14;
    }

    @NonNull
    @CheckResult
    public static TextViewTextChangeEvent create(@NonNull TextView r10, @NonNull CharSequence r11, int r12, int r13, int r14) {
        return new TextViewTextChangeEvent(r10, r11, r12, r13, r14);
    }

    public int before() {
        return this.before;
    }

    public int count() {
        return this.count;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextViewTextChangeEvent) == true) goto L8;
        return false;
    L8:
        TextViewTextChangeEvent r11 = (TextViewTextChangeEvent) r10;
        if (r11.view() != view()) goto L20;
        if (this.text.equals(r11.text) == false) goto L20;
        if (this.start != r11.start) goto L20;
        if (this.before != r11.before) goto L20;
        if (this.count != r11.count) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return ((((((((629 + view().hashCode()) * 37) + this.text.hashCode()) * 37) + this.start) * 37) + this.before) * 37) + this.count;
    }

    public int start() {
        return this.start;
    }

    @NonNull
    public CharSequence text() {
        return this.text;
    }

    public String toString() {
        return "TextViewTextChangeEvent{text=" + this.text + ", start=" + this.start + ", before=" + this.before + ", count=" + this.count + ", view=" + view() + '}';
    }
}
