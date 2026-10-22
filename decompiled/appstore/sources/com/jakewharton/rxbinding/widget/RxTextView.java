package com.jakewharton.rxbinding.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Functions;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxTextView {
    private RxTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable afterTextChangeEvents(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new TextViewAfterTextChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable beforeTextChangeEvents(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new TextViewBeforeTextChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> color(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass7(r10);
    }

    @NonNull
    @CheckResult
    public static Observable editorActionEvents(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return editorActionEvents(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable editorActions(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return editorActions(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> error(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass3(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> errorRes(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass4(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> hint(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass5(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> hintRes(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass6(r10);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> text(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable textChangeEvents(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new TextViewTextChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable textChanges(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new TextViewTextOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> textRes(@NonNull final TextView r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Observable editorActionEvents(@NonNull TextView r10, @NonNull Func1<? super TextViewEditorActionEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new TextViewEditorActionEventOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable editorActions(@NonNull TextView r10, @NonNull Func1<? super Integer, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new TextViewEditorActionOnSubscribe(r10, r11));
    }
}
