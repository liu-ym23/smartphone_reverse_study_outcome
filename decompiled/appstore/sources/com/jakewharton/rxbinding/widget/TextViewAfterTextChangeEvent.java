package com.jakewharton.rxbinding.widget;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class TextViewAfterTextChangeEvent extends ViewEvent<TextView> {
    private final Editable editable;

    private TextViewAfterTextChangeEvent(@NonNull TextView r10, @Nullable Editable r11) {
        super(r10);
        this.editable = r11;
    }

    @NonNull
    @CheckResult
    public static TextViewAfterTextChangeEvent create(@NonNull TextView r10, @Nullable Editable r11) {
        return new TextViewAfterTextChangeEvent(r10, r11);
    }

    @Nullable
    public Editable editable() {
        return this.editable;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextViewAfterTextChangeEvent) == true) goto L8;
        return false;
    L8:
        TextViewAfterTextChangeEvent r11 = (TextViewAfterTextChangeEvent) r10;
        if (r11.view() != view()) goto L14;
        if (this.editable.equals(r11.editable) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return ((629 + view().hashCode()) * 37) + this.editable.hashCode();
    }

    public String toString() {
        return "TextViewAfterTextChangeEvent{editable=" + this.editable + ", view=" + view() + '}';
    }
}
