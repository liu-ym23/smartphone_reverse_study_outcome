package v5;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import b0.a2;
import c7.o;
import ia.d0;
import ia.f1;
import ia.l;
import ia.n0;
import ia.x1;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.g;
import k5.s;
import k5.t;
import m.x;
import n.f;
import na.d;
import pa.e;
import q7.k;

/* loaded from: classes.dex */
public final class c implements l5.b {

    /* renamed from: a, reason: collision with root package name */
    public final t f10511a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10512b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10513c;

    /* renamed from: d, reason: collision with root package name */
    public final l f10514d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f10515e;

    /* renamed from: f, reason: collision with root package name */
    public final o f10516f;

    /* renamed from: g, reason: collision with root package name */
    public final d f10517g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f10518h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f10519i;

    /* renamed from: j, reason: collision with root package name */
    public volatile String f10520j;

    /* renamed from: k, reason: collision with root package name */
    public final b f10521k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.accounts.OnAccountsUpdateListener, v5.b] */
    public c(Context context, g gVar, boolean z4, String str, l lVar) {
        k.e(context, "context");
        k.e(gVar, "logger");
        k.e(str, "debugAccountToken");
        this.f10511a = gVar;
        this.f10512b = z4;
        this.f10513c = str;
        this.f10514d = lVar;
        Context applicationContext = context.getApplicationContext();
        this.f10515e = applicationContext;
        this.f10516f = s7.a.H(new a2(9, this));
        x1 x1VarC = d0.c();
        e eVar = n0.f4982a;
        this.f10517g = d0.b(f1.plus(x1VarC, na.o.f6923a));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f10518h = atomicBoolean;
        this.f10520j = "";
        ?? r11 = new OnAccountsUpdateListener() { // from class: v5.b
            @Override // android.accounts.OnAccountsUpdateListener
            public final void onAccountsUpdated(Account[] accountArr) {
                c cVar = this.f10510a;
                d0.s(cVar.f10517g, null, null, new g3.c(cVar, accountArr, null, 6), 3);
            }
        };
        this.f10521k = r11;
        if (atomicBoolean.compareAndSet(false, true)) {
            b();
            AccountManager.get(applicationContext).addOnAccountsUpdatedListener(r11, null, true);
            Set set = e5.b.f3054a;
            s.info$default(gVar, "MzAccountToken", e5.b.c("Account listener registered. Initial state: isLoggedIn=" + this.f10519i + " userId=" + this.f10520j), null, 4, null);
        }
    }

    public final String a() {
        if (this.f10512b) {
            String str = this.f10513c;
            s.info$default(this.f10511a, "MzAccountToken", f.c(str.length(), "[DEBUG MODE] getTokenBlocking len="), null, 4, null);
            return str;
        }
        String strA = ((a) this.f10516f.getValue()).a();
        if (strA.length() <= 0) {
            strA = null;
        }
        s.info$default(this.f10511a, "MzAccountToken", a1.a.w("[ACCOUNT SDK] getTokenBlocking=", strA == null ? "<empty>" : f.c(strA.length(), "len=")), null, 4, null);
        return strA;
    }

    public final void b() {
        boolean z4 = this.f10519i;
        String str = this.f10520j;
        this.f10519i = ((a) this.f10516f.getValue()).b().length() > 0;
        this.f10520j = ((a) this.f10516f.getValue()).b();
        boolean z10 = this.f10519i;
        String str2 = this.f10520j;
        t tVar = this.f10511a;
        String strE = e5.b.e(str);
        String strE2 = e5.b.e(str2);
        StringBuilder sb2 = new StringBuilder("Account state changed: wasLoggedIn=");
        sb2.append(z4);
        sb2.append(" → isNowLoggedIn=");
        sb2.append(z10);
        sb2.append(", userId: ");
        s.warn$default(tVar, "MzAccountToken", x.n(sb2, strE, " → ", strE2), null, 4, null);
        this.f10514d.j(Boolean.valueOf(z4), Boolean.valueOf(z10), str2);
    }
}
