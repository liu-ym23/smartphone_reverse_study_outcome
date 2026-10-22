package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.internal.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId(Context r1);

    int getDefaultTitleResId();

    String getError();

    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionContentDescription(Context r1);

    String getSelectionDisplayString(Context r1);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater r1, ViewGroup r2, Bundle r3, CalendarConstraints r4, OnSelectionChangedListener<S> r5);

    void select(long r1);

    void setSelection(S r1);

    void setTextInputFormat(SimpleDateFormat r1);

    static void showKeyboardWithAutoHideBehavior(final EditText... r5) {
        if (r5.length != 0) goto L5;
        return;
    L5:
        View.OnFocusChangeListener r0 = new DateSelector$$ExternalSyntheticLambda0(r5);
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        r5[r3].setOnFocusChangeListener(r0);
        r3 = r3 + 1;
        goto L6
    L8:
        ViewUtils.requestFocusAndShowKeyboard(r5[0]);
    }

    static /* synthetic */ void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] r2, View r3, boolean r4) {
        int r5 = r2.length;
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L8;
        if (r2[r0].hasFocus() == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return;
    L8:
        ViewUtils.hideKeyboard(r3);
    }
}
