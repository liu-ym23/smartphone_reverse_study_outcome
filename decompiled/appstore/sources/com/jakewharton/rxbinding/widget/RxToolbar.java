package com.jakewharton.rxbinding.widget;

import android.widget.Toolbar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class RxToolbar {
    private RxToolbar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable itemClicks(@NonNull Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ToolbarItemClickOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable navigationClicks(@NonNull Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ToolbarNavigationClickOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> subtitle(@NonNull final Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass3(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> subtitleRes(@NonNull final Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass4(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> title(@NonNull final Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> titleRes(@NonNull final Toolbar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }
}
