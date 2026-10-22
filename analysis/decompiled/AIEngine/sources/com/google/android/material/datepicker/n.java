package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f4978a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f4979b;

    public n(o oVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f4979b = oVar;
        this.f4978a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        MaterialCalendarGridView materialCalendarGridView = this.f4978a;
        m mVarA = materialCalendarGridView.a();
        if (i10 < mVarA.b() || i10 > mVarA.d()) {
            return;
        }
        MaterialCalendar.e eVar = this.f4979b.f4983d;
        long jLongValue = materialCalendarGridView.a().getItem(i10).longValue();
        MaterialCalendar materialCalendar = MaterialCalendar.this;
        if (materialCalendar.calendarConstraints.getDateValidator().isValid(jLongValue)) {
            materialCalendar.dateSelector.select(jLongValue);
            Iterator it = materialCalendar.onSelectionChangedListeners.iterator();
            while (it.hasNext()) {
                ((p) it.next()).b(materialCalendar.dateSelector.getSelection());
            }
            materialCalendar.recyclerView.getAdapter().notifyDataSetChanged();
            if (materialCalendar.yearSelector != null) {
                materialCalendar.yearSelector.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
