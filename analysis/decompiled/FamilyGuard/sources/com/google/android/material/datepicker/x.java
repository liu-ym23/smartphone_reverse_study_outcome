package com.google.android.material.datepicker;

import a1.C0415h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
class x extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    private final i<?> f12797a;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12798a;

        a(int i5) {
            this.f12798a = i5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x.this.f12797a.r2(x.this.f12797a.h2().D(p.G(this.f12798a, x.this.f12797a.j2().f12768b)));
            x.this.f12797a.s2(i.l.DAY);
            x.this.f12797a.q2();
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        final TextView f12800a;

        b(TextView textView) {
            super(textView);
            this.f12800a = textView;
        }
    }

    x(i<?> iVar) {
        this.f12797a = iVar;
    }

    private View.OnClickListener k(int i5) {
        return new a(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12797a.h2().L();
    }

    int l(int i5) {
        return i5 - this.f12797a.h2().K().f12769c;
    }

    int n(int i5) {
        return this.f12797a.h2().K().f12769c + i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i5) {
        int iN = n(i5);
        bVar.f12800a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iN)));
        TextView textView = bVar.f12800a;
        textView.setContentDescription(e.e(textView.getContext(), iN));
        c cVarI2 = this.f12797a.i2();
        Calendar calendarG = w.g();
        com.google.android.material.datepicker.b bVar2 = calendarG.get(1) == iN ? cVarI2.f12672f : cVarI2.f12670d;
        Iterator<Long> it = this.f12797a.k2().u().iterator();
        while (it.hasNext()) {
            calendarG.setTimeInMillis(it.next().longValue());
            if (calendarG.get(1) == iN) {
                bVar2 = cVarI2.f12671e;
            }
        }
        bVar2.d(bVar.f12800a);
        bVar.f12800a.setSelected(bVar2 == cVarI2.f12671e);
        bVar.f12800a.setOnClickListener(k(iN));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C0415h.f6882p, viewGroup, false));
    }
}
