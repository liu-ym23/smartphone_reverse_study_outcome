package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.InterfaceC1639e;
import com.google.android.gms.common.api.internal.InterfaceC1646l;
import com.google.android.gms.common.internal.AbstractC1664e;
import com.google.android.gms.common.internal.C1663d;
import com.google.android.gms.common.internal.C1673n;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import w2.C5720d;

/* loaded from: classes2.dex */
public final class d extends AbstractC1664e {

    /* renamed from: I, reason: collision with root package name */
    public final C1673n f19846I;

    public d(Context context, Looper looper, C1663d c1663d, C1673n c1673n, InterfaceC1639e interfaceC1639e, InterfaceC1646l interfaceC1646l) {
        super(context, looper, SubsamplingScaleImageView.ORIENTATION_270, c1663d, interfaceC1639e, interfaceC1646l);
        this.f19846I = c1673n;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String B() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String C() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final boolean F() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c, com.google.android.gms.common.api.a.f
    public final int l() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof zai ? (zai) iInterfaceQueryLocalInterface : new zai(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Feature[] s() {
        return C5720d.f43050b;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Bundle x() {
        return this.f19846I.c();
    }
}
