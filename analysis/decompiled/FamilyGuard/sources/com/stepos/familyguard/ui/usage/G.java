package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.stepos.familyguard.ui.usage.U;
import f2.C0711p;
import j2.C0782E;
import org.libpag.BuildConfig;
import w2.AbstractC1223f0;
import w2.InterfaceC1262y0;

/* loaded from: classes.dex */
public class G extends AbstractC1223f0 {

    /* renamed from: d, reason: collision with root package name */
    public C0782E f14905d;

    public G(View view, D2.r<String, Drawable> rVar) {
        super(view, rVar);
        C0782E c0782eA = C0782E.a(view);
        this.f14905d = c0782eA;
        T1.g.c(1.18f, c0782eA.f17650f);
    }

    public static /* synthetic */ void c(InterfaceC1262y0 interfaceC1262y0, U.c cVar, View view) {
        if (interfaceC1262y0 != null) {
            interfaceC1262y0.i(cVar.f15165a, cVar.f15166b);
        }
    }

    @Override // w2.AbstractC1223f0
    public D2.m a() {
        return new D2.m(this.f14905d.f17647c, false);
    }

    public void d() {
        this.f14905d.f17651g.setText(BuildConfig.FLAVOR);
        this.f14905d.f17650f.setText(BuildConfig.FLAVOR);
        this.f14905d.f17648d.setVisibility(8);
        this.f14905d.f17649e.setValue(0L);
        this.f14905d.f17647c.setImageDrawable(null);
        this.f14905d.b().setOnClickListener(null);
    }

    public void e(Context context, final U.c cVar, final InterfaceC1262y0 interfaceC1262y0) {
        this.f14905d.f17651g.setText(cVar.f15166b);
        this.f14905d.f17650f.setText(C0711p.n(context, cVar.f14934d, true));
        if (cVar.f15167c) {
            this.f14905d.f17648d.setVisibility(0);
        } else {
            this.f14905d.f17648d.setVisibility(8);
        }
        this.f14905d.f17647c.setBorderEnabled(true);
        this.f14905d.f17647c.setFixedRound(false);
        this.f14905d.f17647c.setPadding(0, 0, 0, 0);
        b(cVar.f15165a);
        long j5 = cVar.f14934d;
        this.f14905d.f17649e.setValue(C0711p.l(j5));
        this.f14905d.f17649e.setMinLength((int) N1.i.a(4.0f, context));
        this.f14905d.f17650f.setText(C0711p.m(context, j5));
        this.f14905d.f17648d.setVisibility(cVar.f15167c ? 0 : 8);
        this.f14905d.b().setOnClickListener(new View.OnClickListener() { // from class: w2.G0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.stepos.familyguard.ui.usage.G.c(interfaceC1262y0, cVar, view);
            }
        });
    }
}
