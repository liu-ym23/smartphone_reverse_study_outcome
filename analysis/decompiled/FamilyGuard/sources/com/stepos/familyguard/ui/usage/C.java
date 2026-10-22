package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.z;
import j2.C0781D;
import w2.AbstractC1223f0;

/* loaded from: classes.dex */
public class C extends AbstractC1223f0 {

    /* renamed from: d, reason: collision with root package name */
    C0781D f14871d;

    public C(View view, D2.r<String, Drawable> rVar) {
        super(view, rVar);
        this.f14871d = C0781D.a(view);
    }

    @Override // w2.AbstractC1223f0
    public D2.m a() {
        return new D2.m(this.f14871d.f17641c, false);
    }

    public void c(Context context, z.c cVar, String str) {
        this.f14871d.f17642d.setText(cVar.f15173a ? context.getString(R.string.us_limited) : context.getString(R.string.us_unlimited));
        this.f14871d.f17641c.setFixedRound(false);
        this.f14871d.f17643e.setText(TextUtils.isEmpty(str) ? cVar.f15175c : C2.p.a(cVar.f15175c, T1.h.a(context, R.attr.colorPrimary), str));
        b(cVar.f15174b);
    }
}
