package com.google.android.gms.common.moduleinstall.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.InterfaceC1639e;
import com.google.android.gms.common.api.internal.InterfaceC1646l;
import com.google.android.gms.common.internal.AbstractC1664e;
import com.google.android.gms.common.internal.C1663d;

/* loaded from: classes2.dex */
public final class k extends AbstractC1664e {
    public k(Context context, Looper looper, C1663d c1663d, InterfaceC1639e interfaceC1639e, InterfaceC1646l interfaceC1646l) {
        super(context, looper, 308, c1663d, interfaceC1639e, interfaceC1646l);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String B() {
        return "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String C() {
        return "com.google.android.gms.chimera.container.moduleinstall.ModuleInstallService.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final boolean F() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final boolean O() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c, com.google.android.gms.common.api.a.f
    public final int l() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Feature[] s() {
        return w2.j.f43054b;
    }
}
