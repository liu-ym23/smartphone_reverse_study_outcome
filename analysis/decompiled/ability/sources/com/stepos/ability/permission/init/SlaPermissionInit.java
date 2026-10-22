package com.stepos.ability.permission.init;

import C7.r;
import H3.b;
import P3.c;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.init.IInit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.k;
import q4.C1800a;
import q4.C1801b;
import q4.C1802c;

@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0006*\u0002\u000f\u0015\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/permission/init/SlaPermissionInit;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "slaPermissionMng", "LH3/b;", "accountUtil", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;LH3/b;)V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "LH3/b;", "q4/b", "accountListener", "Lq4/b;", "", "wasConnected", "Z", "q4/c", "networkCallback", "Lq4/c;", "Companion", "q4/a", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaPermissionInit implements IInit {
    public static final C1800a Companion = new C1800a();
    private static final String TAG = "SlaPermInit";
    private final C1801b accountListener;
    private final b accountUtil;
    private final C1802c networkCallback;
    private final ISlaPermissionManager slaPermissionMng;
    private volatile boolean wasConnected;

    @Inject
    public SlaPermissionInit(ISlaPermissionManager slaPermissionMng, b accountUtil) {
        k.f(slaPermissionMng, "slaPermissionMng");
        k.f(accountUtil, "accountUtil");
        this.slaPermissionMng = slaPermissionMng;
        this.accountUtil = accountUtil;
        this.accountListener = new C1801b(this);
        this.networkCallback = new C1802c(this);
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        String processName;
        Object objA;
        Object objA2;
        P3.b bVar = c.f1086a;
        Object objA3 = r.f317a;
        k.f(context, "context");
        try {
            processName = Application.getProcessName();
        } catch (Throwable unused) {
            processName = null;
        }
        if (processName != null && !processName.equals(context.getPackageName())) {
            c.b(TAG, "init: skip non-main process (" + processName + ")");
            return;
        }
        try {
            ISlaPermissionManager iSlaPermissionManager = this.slaPermissionMng;
            Context applicationContext = context.getApplicationContext();
            k.e(applicationContext, "getApplicationContext(...)");
            iSlaPermissionManager.warmUp(applicationContext);
            objA = objA3;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (objA instanceof Result.Failure) {
            bVar.invoke(5, "Ability_".concat(TAG), "init: SLA permission warmUp failed", Result.a(objA));
        } else {
            c.b(TAG, "init: SLA permission warmUp kicked off on cold start");
        }
        boolean z10 = false;
        try {
            AccountManager.get(context.getApplicationContext()).addOnAccountsUpdatedListener(this.accountListener, null, false);
            objA2 = objA3;
        } catch (Throwable th2) {
            objA2 = kotlin.b.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            bVar.invoke(5, "Ability_".concat(TAG), "init: register account listener FAILED", Result.a(objA2));
        } else {
            c.b(TAG, "init: account login listener registered");
        }
        try {
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                z10 = true;
            }
            this.wasConnected = z10;
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), this.networkCallback);
        } catch (Throwable th3) {
            objA3 = kotlin.b.a(th3);
        }
        if (objA3 instanceof Result.Failure) {
            bVar.invoke(5, "Ability_".concat(TAG), "init: register network callback FAILED", Result.a(objA3));
            return;
        }
        c.b(TAG, "init: network callback registered (baseline connected=" + this.wasConnected + ")");
    }
}
