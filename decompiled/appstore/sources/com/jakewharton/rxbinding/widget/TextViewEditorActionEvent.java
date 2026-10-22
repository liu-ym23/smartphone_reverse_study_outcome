package com.jakewharton.rxbinding.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class TextViewEditorActionEvent extends ViewEvent<TextView> {
    private final int actionId;

    @Nullable
    private final KeyEvent keyEvent;

    private TextViewEditorActionEvent(@NonNull TextView r10, int r11, @Nullable KeyEvent r12) {
        super(r10);
        this.actionId = r11;
        this.keyEvent = r12;
    }

    @NonNull
    @CheckResult
    public static TextViewEditorActionEvent create(@NonNull TextView r10, int r11, @Nullable KeyEvent r12) {
        return new TextViewEditorActionEvent(r10, r11, r12);
    }

    public int actionId() {
        return this.actionId;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextViewEditorActionEvent) == true) goto L8;
        return false;
    L8:
        TextViewEditorActionEvent r11 = (TextViewEditorActionEvent) r10;
        if (r11.view() != view()) goto L21;
        if (r11.actionId != this.actionId) goto L21;
        KeyEvent r12 = r11.keyEvent;
        if (r12 == null) goto L18;
        if (r12.equals(this.keyEvent) == false) goto L21;
        return true;
    L18:
        if (this.keyEvent != null) goto L21;
        return true;
    L21:
        return false;
    }

    public int hashCode() {
        int r10 = (((629 + view().hashCode()) * 37) + this.actionId) * 37;
        KeyEvent r11 = this.keyEvent;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    @Nullable
    public KeyEvent keyEvent() {
        return this.keyEvent;
    }

    public String toString() {
        return "TextViewEditorActionEvent{view=" + view() + ", actionId=" + this.actionId + ", keyEvent=" + this.keyEvent + '}';
    }
}
