package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.z;

/* renamed from: com.stepos.familyguard.ui.usage.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0606o extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    j2.y f15149a;

    public C0606o(View view) {
        super(view);
        this.f15149a = j2.y.a(view);
    }

    public void a(Context context, z.a aVar) {
        b(context, aVar, null);
    }

    public void b(Context context, z.a aVar, String str) {
        String string = aVar.f15173a ? context.getString(R.string.us_limited) : context.getString(R.string.us_unlimited);
        this.f15149a.f17803c.setFixedRound(true);
        this.f15149a.f17803c.setBorderEnabled(false);
        this.f15149a.f17804d.setText(string);
        int iA = T1.g.a(context, R.attr.marginSmall);
        this.f15149a.f17803c.setPadding(iA, iA, iA, iA);
        this.f15149a.f17805e.setText(TextUtils.isEmpty(str) ? aVar.f15172c : C2.p.a(aVar.f15172c, T1.h.a(context, R.attr.colorPrimary), str));
        this.f15149a.f17803c.setImageDrawable(androidx.core.content.res.h.f(context.getResources(), W1.c.l(aVar.f15171b), context.getTheme()));
        this.f15149a.f17803c.setBackground(androidx.core.content.res.h.f(context.getResources(), R.drawable.us_category_icon_background, context.getTheme()));
    }
}
