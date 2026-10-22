package q4;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import com.stepos.ability.permission.init.SlaPermissionInit;
import kotlin.jvm.internal.k;

/* renamed from: q4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1801b implements OnAccountsUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public volatile Boolean f5578a;
    public final /* synthetic */ SlaPermissionInit b;

    public C1801b(SlaPermissionInit slaPermissionInit) {
        this.b = slaPermissionInit;
        this.f5578a = Boolean.valueOf(slaPermissionInit.accountUtil.b());
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public final void onAccountsUpdated(Account[] accountArr) {
        boolean zB = this.b.accountUtil.b();
        Boolean bool = this.f5578a;
        this.f5578a = Boolean.valueOf(zB);
        if (zB && !k.b(bool, Boolean.TRUE)) {
            P3.c.b("SlaPermInit", "account logged in -> force refresh SLA permission cache");
            this.b.slaPermissionMng.onAccountLoginStateChanged(true);
        } else {
            if (zB || !k.b(bool, Boolean.TRUE)) {
                return;
            }
            P3.c.b("SlaPermInit", "account logged out -> notify (refresh masked by config)");
            this.b.slaPermissionMng.onAccountLoginStateChanged(false);
        }
    }
}
