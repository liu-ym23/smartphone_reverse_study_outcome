package com.jakewharton.rxbinding.widget;

import android.widget.PopupMenu;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class RxPopupMenu {
    private RxPopupMenu() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable dismisses(@NonNull PopupMenu r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new PopupMenuDismissOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable itemClicks(@NonNull PopupMenu r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new PopupMenuItemClickOnSubscribe(r10));
    }
}
