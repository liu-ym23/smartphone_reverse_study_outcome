package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public interface DateSelector<S> extends Parcelable {
    static boolean isTouchExplorationEnabled(@NonNull Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] editTextArr, View view, boolean z10) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void lambda$showKeyboardWithAutoHideBehavior$1(View view) {
        view.requestFocus();
        view.post(new RunnableC0908k(1, view));
    }

    static void showKeyboardWithAutoHideBehavior(@NonNull EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        ViewOnFocusChangeListenerC0907j viewOnFocusChangeListenerC0907j = new ViewOnFocusChangeListenerC0907j(editTextArr, 0);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(viewOnFocusChangeListenerC0907j);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new RunnableC0908k(0, editText2), 100L);
    }

    @StyleRes
    int getDefaultThemeResId(Context context);

    @StringRes
    int getDefaultTitleResId();

    @Nullable
    String getError();

    @NonNull
    Collection<Long> getSelectedDays();

    @NonNull
    Collection<Pair<Long, Long>> getSelectedRanges();

    @Nullable
    S getSelection();

    @NonNull
    String getSelectionContentDescription(@NonNull Context context);

    @NonNull
    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    @NonNull
    View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull H h);

    void select(long j5);

    void setSelection(@NonNull S s5);

    void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat);
}
