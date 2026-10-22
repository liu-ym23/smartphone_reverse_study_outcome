package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.U;
import f2.C0711p;
import j2.C0782E;
import w2.InterfaceC1258w0;

/* loaded from: classes.dex */
public class r extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    C0782E f15150a;

    public r(View view) {
        super(view);
        C0782E c0782eA = C0782E.a(view);
        this.f15150a = c0782eA;
        T1.g.c(1.18f, c0782eA.f17650f);
    }

    public static /* synthetic */ void a(InterfaceC1258w0 interfaceC1258w0, U.a aVar, View view) {
        if (interfaceC1258w0 != null) {
            interfaceC1258w0.e(aVar.f15161a, aVar.f15162b);
        }
    }

    public void b(Context context, final U.a aVar, final InterfaceC1258w0 interfaceC1258w0) {
        this.f15150a.f17651g.setText(aVar.f15162b);
        this.f15150a.f17650f.setText(C0711p.n(context, aVar.f14930e, true));
        if (aVar.f15164d) {
            this.f15150a.f17648d.setVisibility(0);
        } else {
            this.f15150a.f17648d.setVisibility(8);
        }
        long j5 = aVar.f14930e;
        this.f15150a.f17647c.setFixedRound(true);
        this.f15150a.f17647c.setBorderEnabled(false);
        this.f15150a.f17647c.setImageDrawable(androidx.core.content.res.h.f(context.getResources(), aVar.f15163c, context.getTheme()));
        this.f15150a.f17647c.setBackground(androidx.core.content.res.h.f(context.getResources(), R.drawable.us_category_icon_background, context.getTheme()));
        int iA = T1.g.a(context, R.attr.marginSmall);
        this.f15150a.f17647c.setPadding(iA, iA, iA, iA);
        this.f15150a.f17649e.setValue(C0711p.l(j5));
        this.f15150a.f17649e.setMinLength((int) N1.i.a(4.0f, context));
        this.f15150a.f17650f.setText(C0711p.m(context, j5));
        this.f15150a.b().setOnClickListener(new View.OnClickListener() { // from class: w2.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.stepos.familyguard.ui.usage.r.a(interfaceC1258w0, aVar, view);
            }
        });
        this.f15150a.f17648d.setVisibility(aVar.f15164d ? 0 : 8);
    }
}
