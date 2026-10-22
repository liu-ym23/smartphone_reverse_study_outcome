package com.jakewharton.rxbinding.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class RatingBarChangeEvent extends ViewEvent<RatingBar> {
    private final boolean fromUser;
    private final float rating;

    private RatingBarChangeEvent(@NonNull RatingBar r10, float r11, boolean r12) {
        super(r10);
        this.rating = r11;
        this.fromUser = r12;
    }

    @NonNull
    @CheckResult
    public static RatingBarChangeEvent create(@NonNull RatingBar r10, float r11, boolean r12) {
        return new RatingBarChangeEvent(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof RatingBarChangeEvent) == true) goto L8;
        return false;
    L8:
        RatingBarChangeEvent r11 = (RatingBarChangeEvent) r10;
        if (r11.view() != view()) goto L16;
        if (r11.rating != this.rating) goto L16;
        if (r11.fromUser != this.fromUser) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean fromUser() {
        return this.fromUser;
    }

    public int hashCode() {
        return ((((629 + view().hashCode()) * 37) + Float.floatToIntBits(this.rating)) * 37) + (this.fromUser ? 1 : 0);
    }

    public float rating() {
        return this.rating;
    }

    public String toString() {
        return "RatingBarChangeEvent{view=" + view() + ", rating=" + this.rating + ", fromUser=" + this.fromUser + '}';
    }
}
