package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class M extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final s f10625a;

    public M(s sVar) {
        this.f10625a = sVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f10625a.f10707d.f10604f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        L l4 = (L) viewHolder;
        s sVar = this.f10625a;
        int i5 = sVar.f10707d.f10599a.f10659c + i4;
        l4.f10624a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i5)));
        TextView textView = l4.f10624a;
        Context context = textView.getContext();
        textView.setContentDescription(J.f().get(1) == i5 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i5)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i5)));
        o2.d dVar = sVar.f10711h;
        Calendar calendarF = J.f();
        H.d dVar2 = (H.d) (calendarF.get(1) == i5 ? dVar.f13801f : dVar.f13799d);
        Iterator it = sVar.f10706c.u().iterator();
        while (it.hasNext()) {
            calendarF.setTimeInMillis(((Long) it.next()).longValue());
            if (calendarF.get(1) == i5) {
                dVar2 = (H.d) dVar.f13800e;
            }
        }
        dVar2.b(textView);
        textView.setSelected(dVar2 == ((H.d) dVar.f13800e));
        textView.setOnClickListener(new K(this, i5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new L((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
