package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class w extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCalendar<?> f20863a;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20864a;

        public a(int i10) {
            this.f20864a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.this.f20863a.L(w.this.f20863a.B().clamp(Month.create(this.f20864a, w.this.f20863a.D().month)));
            w.this.f20863a.M(MaterialCalendar.CalendarSelector.DAY);
            w.this.f20863a.K();
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f20866a;

        public b(TextView textView) {
            super(textView);
            this.f20866a = textView;
        }
    }

    public w(MaterialCalendar<?> materialCalendar) {
        this.f20863a = materialCalendar;
    }

    public final View.OnClickListener d(int i10) {
        return new a(i10);
    }

    public int e(int i10) {
        return i10 - this.f20863a.B().getStart().year;
    }

    public int f(int i10) {
        return this.f20863a.B().getStart().year + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        int iF = f(i10);
        bVar.f20866a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(iF)));
        TextView textView = bVar.f20866a;
        textView.setContentDescription(h.k(textView.getContext(), iF));
        com.google.android.material.datepicker.b bVarC = this.f20863a.C();
        Calendar calendarL = v.l();
        com.google.android.material.datepicker.a aVar = calendarL.get(1) == iF ? bVarC.f20772f : bVarC.f20770d;
        Iterator<Long> it = this.f20863a.E().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarL.setTimeInMillis(it.next().longValue());
            if (calendarL.get(1) == iF) {
                aVar = bVarC.f20771e;
            }
        }
        aVar.d(bVar.f20866a);
        bVar.f20866a.setSelected(aVar == bVarC.f20771e);
        bVar.f20866a.setOnClickListener(d(iF));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20863a.B().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
