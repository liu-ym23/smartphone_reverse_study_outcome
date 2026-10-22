package com.google.android.material.datepicker;

import a1.C0413f;
import a1.C0415h;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;

/* loaded from: classes.dex */
class r extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.material.datepicker.a f12782a;

    /* renamed from: b, reason: collision with root package name */
    private final d<?> f12783b;

    /* renamed from: c, reason: collision with root package name */
    private final g f12784c;

    /* renamed from: d, reason: collision with root package name */
    private final i.m f12785d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12786e;

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f12787a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f12787a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
            if (this.f12787a.getAdapter().r(i5)) {
                r.this.f12785d.a(this.f12787a.getAdapter().getItem(i5).longValue());
            }
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        final TextView f12789a;

        /* renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f12790b;

        b(LinearLayout linearLayout, boolean z5) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(C0413f.f6858u);
            this.f12789a = textView;
            H.l0(textView, true);
            this.f12790b = (MaterialCalendarGridView) linearLayout.findViewById(C0413f.f6854q);
            if (z5) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    r(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, g gVar, i.m mVar) {
        p pVarK = aVar.K();
        p pVarG = aVar.G();
        p pVarJ = aVar.J();
        if (pVarK.compareTo(pVarJ) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (pVarJ.compareTo(pVarG) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f12786e = (q.f12774g * i.l2(context)) + (m.v2(context) ? i.l2(context) : 0);
        this.f12782a = aVar;
        this.f12783b = dVar;
        this.f12784c = gVar;
        this.f12785d = mVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12782a.I();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i5) {
        return this.f12782a.K().O(i5).N();
    }

    p k(int i5) {
        return this.f12782a.K().O(i5);
    }

    CharSequence l(int i5) {
        return k(i5).M();
    }

    int n(p pVar) {
        return this.f12782a.K().P(pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i5) {
        p pVarO = this.f12782a.K().O(i5);
        bVar.f12789a.setText(pVarO.M());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f12790b.findViewById(C0413f.f6854q);
        if (materialCalendarGridView.getAdapter() == null || !pVarO.equals(materialCalendarGridView.getAdapter().f12776a)) {
            q qVar = new q(pVarO, this.f12783b, this.f12782a, this.f12784c);
            materialCalendarGridView.setNumColumns(pVarO.f12770d);
            materialCalendarGridView.setAdapter((ListAdapter) qVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i5) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C0415h.f6880n, viewGroup, false);
        if (!m.v2(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f12786e));
        return new b(linearLayout, true);
    }
}
