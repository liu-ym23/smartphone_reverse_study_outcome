package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final l.a f750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f751b;

    public a1(b1 b1Var) {
        this.f751b = b1Var;
        Context context = b1Var.f761a.getContext();
        CharSequence charSequence = b1Var.h;
        l.a aVar = new l.a();
        aVar.f10156e = 4096;
        aVar.f10157j = 4096;
        aVar.f10162o = null;
        aVar.f10163p = null;
        aVar.f10164q = false;
        aVar.r = false;
        aVar.f10165s = 16;
        aVar.f10159l = context;
        aVar.f10152a = charSequence;
        this.f750a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b1 b1Var = this.f751b;
        Window.Callback callback = b1Var.f770k;
        if (callback == null || !b1Var.f771l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f750a);
    }
}
