package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.U;
import j2.C0782E;
import org.libpag.BuildConfig;
import w2.AbstractC1223f0;
import w2.InterfaceC1260x0;

/* loaded from: classes.dex */
public class F extends AbstractC1223f0 {

    /* renamed from: d, reason: collision with root package name */
    public C0782E f14904d;

    public F(View view, D2.r<String, Drawable> rVar) {
        super(view, rVar);
        this.f14904d = C0782E.a(view);
    }

    public static /* synthetic */ void c(InterfaceC1260x0 interfaceC1260x0, U.b bVar, int i5, View view) {
        if (interfaceC1260x0 != null) {
            interfaceC1260x0.h(bVar.f14931a, bVar.f14932b, i5);
        }
    }

    @Override // w2.AbstractC1223f0
    public D2.m a() {
        return new D2.m(this.f14904d.f17647c, false);
    }

    public void d() {
        this.f14904d.f17651g.setText(BuildConfig.FLAVOR);
        this.f14904d.f17650f.setText(BuildConfig.FLAVOR);
        this.f14904d.f17648d.setVisibility(8);
        this.f14904d.f17649e.setValue(0L);
        this.f14904d.f17647c.setImageDrawable(null);
        this.f14904d.b().setOnClickListener(null);
    }

    public void e(Context context, final U.b bVar, final InterfaceC1260x0 interfaceC1260x0) {
        this.f14904d.f17651g.setText(bVar.f14932b);
        b(bVar.f14931a);
        this.f14904d.f17649e.setValue(bVar.f14933c);
        this.f14904d.f17649e.setMinLength((int) N1.i.a(4.0f, context));
        this.f14904d.f17650f.setText(bVar.f14933c + context.getString(R.string.us_widget_notification_label));
        try {
            final int i5 = context.getPackageManager().getApplicationInfo(bVar.f14931a, 0).uid;
            this.f14904d.b().setOnClickListener(new View.OnClickListener() { // from class: w2.F0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.stepos.familyguard.ui.usage.F.c(interfaceC1260x0, bVar, i5, view);
                }
            });
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
        }
    }
}
