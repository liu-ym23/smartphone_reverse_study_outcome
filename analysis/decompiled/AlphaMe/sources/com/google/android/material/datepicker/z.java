package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class z implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f10741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B f10742b;

    public z(B b4, MaterialCalendarGridView materialCalendarGridView) {
        this.f10742b = b4;
        this.f10741a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        MaterialCalendarGridView materialCalendarGridView = this.f10741a;
        y yVarA = materialCalendarGridView.a();
        if (i4 < yVarA.a() || i4 > yVarA.c()) {
            return;
        }
        r rVar = this.f10742b.f10597d;
        long jLongValue = materialCalendarGridView.a().getItem(i4).longValue();
        s sVar = ((o) rVar).f10698a;
        if (sVar.f10707d.f10601c.l(jLongValue)) {
            sVar.f10706c.D(jLongValue);
            Iterator it = sVar.f10610a.iterator();
            while (it.hasNext()) {
                ((C) it.next()).b(sVar.f10706c.w());
            }
            sVar.f10713j.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = sVar.f10712i;
            if (recyclerView != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
