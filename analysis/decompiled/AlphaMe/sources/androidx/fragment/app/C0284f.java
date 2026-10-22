package androidx.fragment.app;

import android.accounts.Account;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import j1.C0633a;
import java.util.UUID;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0284f implements G.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f3744a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3745b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3746c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3747d;

    /* renamed from: e, reason: collision with root package name */
    public Object f3748e;

    public final String a() {
        if (((String) this.f3744a) == null) {
            synchronized (this) {
                this.f3744a = UUID.randomUUID().toString();
                T2.d.a("SessionController", "generate a sessionId: " + ((String) this.f3744a));
            }
        }
        return (String) this.f3744a;
    }

    public final com.google.android.gms.common.internal.d b() {
        return new com.google.android.gms.common.internal.d((Account) this.f3744a, (q.g) this.f3745b, (String) this.f3746c, (String) this.f3747d, (C0633a) this.f3748e);
    }

    @Override // G.b
    public final void onCancel() {
        ((View) this.f3744a).clearAnimation();
        ((ViewGroup) this.f3745b).endViewTransition((View) this.f3744a);
        ((C0288j) this.f3746c).a();
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animation from operation " + ((q0) this.f3747d) + " has been cancelled.");
        }
    }
}
