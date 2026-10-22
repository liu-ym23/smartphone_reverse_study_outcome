package com.jakewharton.rxbinding.view;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding.internal.Functions;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public final class RxView {
    private RxView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> activated(@NonNull final View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass1(r10);
    }

    @NonNull
    @CheckResult
    public static Observable attachEvents(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewAttachEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable attaches(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewAttachesOnSubscribe(r10, true));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> clickable(@NonNull final View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass2(r10);
    }

    @NonNull
    @CheckResult
    public static Observable clicks(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewClickOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable detaches(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewAttachesOnSubscribe(r10, false));
    }

    @NonNull
    @CheckResult
    public static Observable drags(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewDragOnSubscribe(r10, Functions.FUNC1_ALWAYS_TRUE));
    }

    @NonNull
    @CheckResult
    public static Observable draws(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewTreeObserverDrawOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> enabled(@NonNull final View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass3(r10);
    }

    @NonNull
    @CheckResult
    public static Observable focusChanges(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewFocusChangeOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable globalLayouts(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewTreeObserverGlobalLayoutOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable hovers(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return hovers(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable keys(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return keys(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable layoutChangeEvents(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewLayoutChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable layoutChanges(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewLayoutChangeOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable longClicks(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewLongClickOnSubscribe(r10, Functions.FUNC0_ALWAYS_TRUE));
    }

    @NonNull
    @CheckResult
    public static Observable preDraws(@NonNull View r10, @NonNull Func0<Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "proceedDrawingPass == null");
        return Observable.b(new ViewTreeObserverPreDrawOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> pressed(@NonNull final View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass4(r10);
    }

    @NonNull
    @CheckResult
    @RequiresApi(23)
    public static Observable scrollChangeEvents(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewScrollChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> selected(@NonNull final View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return new AnonymousClass5(r10);
    }

    @NonNull
    @CheckResult
    public static Observable systemUiVisibilityChanges(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new ViewSystemUiVisibilityChangeOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable touches(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return touches(r10, Functions.FUNC1_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> visibility(@NonNull View r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return visibility(r10, 8);
    }

    @NonNull
    @CheckResult
    public static Observable drags(@NonNull View r10, @NonNull Func1<? super DragEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new ViewDragOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable hovers(@NonNull View r10, @NonNull Func1<? super MotionEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new ViewHoverOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable keys(@NonNull View r10, @NonNull Func1<? super KeyEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new ViewKeyOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable longClicks(@NonNull View r10, @NonNull Func0<Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new ViewLongClickOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Observable touches(@NonNull View r10, @NonNull Func1<? super MotionEvent, Boolean> r11) {
        Preconditions.checkNotNull(r10, "view == null");
        Preconditions.checkNotNull(r11, "handled == null");
        return Observable.b(new ViewTouchOnSubscribe(r10, r11));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> visibility(@NonNull final View r10, final int r11) {
        Preconditions.checkNotNull(r10, "view == null");
        boolean r12 = false;
        if (r11 == 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "Setting visibility to VISIBLE when false would have no effect.");
        if (r11 != 4) goto L9;
    L10:
        r12 = true;
    L11:
        Preconditions.checkArgument(r12, "Must set visibility to INVISIBLE or GONE when false.");
        return new AnonymousClass6(r10, r11);
    L9:
        if (r11 != 8) goto L11;
    L5:
        r13 = false;
        goto L6
    }
}
