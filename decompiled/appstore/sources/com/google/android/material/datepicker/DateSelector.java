package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.c;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    @StyleRes
    int getDefaultThemeResId(Context r10);

    @StringRes
    int getDefaultTitleResId();

    @NonNull
    Collection<Long> getSelectedDays();

    @NonNull
    Collection<c> getSelectedRanges();

    @Nullable
    S getSelection();

    @NonNull
    String getSelectionDisplayString(Context r10);

    boolean isSelectionComplete();

    @NonNull
    View onCreateTextInputView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12, @NonNull CalendarConstraints r13, @NonNull OnSelectionChangedListener<S> r14);

    void select(long r10);

    void setSelection(@NonNull S r10);
}
