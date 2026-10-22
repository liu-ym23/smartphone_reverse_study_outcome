package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.ability.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class S extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCalendar f2423a;

    public S(MaterialCalendar materialCalendar) {
        this.f2423a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f2423a.d.getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Q q5 = (Q) viewHolder;
        MaterialCalendar materialCalendar = this.f2423a;
        int i6 = materialCalendar.d.getStart().year + i;
        q5.f2422a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i6)));
        TextView textView = q5.f2422a;
        Context context = textView.getContext();
        textView.setContentDescription(O.f().get(1) == i6 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i6)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i6)));
        C5.f fVar = materialCalendar.h;
        Calendar calendarF = O.f();
        C0900c c0900c = (C0900c) (calendarF.get(1) == i6 ? fVar.f : fVar.d);
        Iterator<Long> it = materialCalendar.c.getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarF.setTimeInMillis(it.next().longValue());
            if (calendarF.get(1) == i6) {
                c0900c = (C0900c) fVar.e;
            }
        }
        c0900c.e(textView, null, null);
        textView.setSelected(c0900c == ((C0900c) fVar.e));
        textView.setOnClickListener(new P(this, i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new Q((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
