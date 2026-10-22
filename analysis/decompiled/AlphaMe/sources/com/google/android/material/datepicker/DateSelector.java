package com.google.android.material.datepicker;

import K.RunnableC0090w;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import java.util.ArrayList;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    static void I(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        ViewOnFocusChangeListenerC0430i viewOnFocusChangeListenerC0430i = new ViewOnFocusChangeListenerC0430i(0, editTextArr);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(viewOnFocusChangeListenerC0430i);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new RunnableC0090w(1, editText2), 100L);
    }

    View C(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, v vVar);

    void D(long j4);

    String a(Context context);

    String b(Context context);

    int d(Context context);

    ArrayList e();

    boolean m();

    ArrayList u();

    Object w();
}
