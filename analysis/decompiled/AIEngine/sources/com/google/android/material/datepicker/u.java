package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.aiengine.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u extends RecyclerView.Adapter<a> {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCalendar<?> f4990a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4991a;

        public a(TextView textView) {
            super(textView);
            this.f4991a = textView;
        }
    }

    public u(MaterialCalendar<?> materialCalendar) {
        this.f4990a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4990a.getCalendarConstraints().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        MaterialCalendar<?> materialCalendar = this.f4990a;
        int i11 = materialCalendar.getCalendarConstraints().getStart().year + i10;
        aVar.f4991a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11)));
        TextView textView = aVar.f4991a;
        Context context = textView.getContext();
        textView.setContentDescription(s.f().get(1) == i11 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i11)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i11)));
        b calendarStyle = materialCalendar.getCalendarStyle();
        Calendar calendarF = s.f();
        com.google.android.material.datepicker.a aVar2 = calendarF.get(1) == i11 ? calendarStyle.f4950f : calendarStyle.f4948d;
        Iterator<Long> it = materialCalendar.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarF.setTimeInMillis(it.next().longValue());
            if (calendarF.get(1) == i11) {
                aVar2 = calendarStyle.f4949e;
            }
        }
        aVar2.b(textView, null, null);
        textView.setSelected(aVar2 == calendarStyle.f4949e);
        textView.setOnClickListener(new t(this, i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
