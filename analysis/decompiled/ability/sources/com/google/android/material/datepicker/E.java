package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class E implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f2411a;
    public final /* synthetic */ G b;

    public E(G g, MaterialCalendarGridView materialCalendarGridView) {
        this.b = g;
        this.f2411a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        MaterialCalendarGridView materialCalendarGridView = this.f2411a;
        D dA = materialCalendarGridView.a();
        if (i < dA.a() || i > dA.c()) {
            return;
        }
        C0915s c0915s = this.b.d;
        long jLongValue = materialCalendarGridView.a().getItem(i).longValue();
        MaterialCalendar materialCalendar = c0915s.f2435a;
        if (materialCalendar.d.getDateValidator().isValid(jLongValue)) {
            materialCalendar.c.select(jLongValue);
            Iterator it = materialCalendar.f2414a.iterator();
            while (it.hasNext()) {
                ((H) it.next()).b(materialCalendar.c.getSelection());
            }
            materialCalendar.f2417j.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = materialCalendar.i;
            if (recyclerView != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
