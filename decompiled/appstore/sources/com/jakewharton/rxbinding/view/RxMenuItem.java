package com.jakewharton.rxbinding.view;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Functions;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxMenuItem {
    private RxMenuItem() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable actionViewEvents(@NonNull MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return Observable.b(new MenuItemActionViewEventOnSubscribe(r10, Functions.FUNC1_ALWAYS_TRUE));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> checked(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable clicks(@NonNull MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return Observable.b(new MenuItemClickOnSubscribe(r10, Functions.FUNC1_ALWAYS_TRUE));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> enabled(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Drawable> icon(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass3(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> iconRes(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass4(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> title(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass5(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> titleRes(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass6(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> visible(@NonNull final MenuItem r10) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        return new AnonymousClass7(r10);
    }

    @NonNull
    @CheckResult
    public static Observable actionViewEvents(@NonNull MenuItem r10, @NonNull Func1<? super MenuItemActionViewEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new MenuItemActionViewEventOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable clicks(@NonNull MenuItem r10, @NonNull Func1<? super MenuItem, Boolean> r11) {
        Preconditions.checkNotNull(r10, "menuItem == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new MenuItemClickOnSubscribe(r10, r11));
    }
}
