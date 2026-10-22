package com.google.android.gms.common.api.internal;

import K.C0073e;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.appcompat.widget.RunnableC0209k;
import com.google.android.gms.common.ConnectionResult;
import java.util.HashMap;
import java.util.Map;
import z2.InterfaceC1006a;

/* loaded from: classes.dex */
public final class s implements com.google.android.gms.common.internal.a, z, InterfaceC1006a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9679a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9680b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9681c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9682d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9683e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9684f = new X.v(this, new Handler(Looper.getMainLooper()), 2);

    public s(Context context, String str, C0073e c0073e, boolean z4) {
        this.f9680b = context;
        this.f9681c = Settings.Global.getUriFor(str);
        this.f9682d = str;
        this.f9683e = c0073e;
        ((Context) this.f9680b).getContentResolver().registerContentObserver((Uri) this.f9681c, false, (ContentObserver) this.f9684f);
        ((ContentObserver) this.f9684f).onChange(true, (Uri) this.f9681c);
        this.f9679a = z4;
    }

    @Override // com.google.android.gms.common.internal.a
    public final void a(ConnectionResult connectionResult) {
        ((C0407e) this.f9684f).f9653m.post(new RunnableC0209k(12, this, connectionResult));
    }

    public final void b(HashMap map) {
        this.f9683e = map;
        SharedPreferences.Editor editorEdit = ((S2.a) this.f9684f).f1791a.edit();
        editorEdit.clear();
        for (Map.Entry entry : ((Map) this.f9683e).entrySet()) {
            editorEdit.putString((String) entry.getKey(), ((O2.a) entry.getValue()).toString());
        }
        editorEdit.commit();
    }

    public final void c(ConnectionResult connectionResult) {
        q qVar = (q) ((C0407e) this.f9684f).f9650j.get((C0403a) this.f9681c);
        if (qVar != null) {
            com.stepos.statsrpk.c.k(qVar.f9676l.f9653m);
            com.google.android.gms.common.internal.e eVar = qVar.f9666b;
            eVar.c("onSignInFailed for " + eVar.getClass().getName() + " with " + String.valueOf(connectionResult));
            qVar.l(connectionResult, null);
        }
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        if (((ContentObserver) this.f9684f) != null) {
            ((Context) this.f9680b).getContentResolver().unregisterContentObserver((ContentObserver) this.f9684f);
            this.f9684f = null;
        }
    }
}
