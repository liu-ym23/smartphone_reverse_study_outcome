package com.google.android.gms.common.moduleinstall.internal;

import D2.l;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.AbstractC1651q;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.api.internal.C1644j;
import com.google.android.gms.common.api.internal.C1648n;
import com.google.android.gms.common.api.internal.InterfaceC1649o;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import q2.InterfaceC5144a;

/* loaded from: classes2.dex */
public final class j extends com.google.android.gms.common.api.c implements q2.c {

    /* renamed from: k, reason: collision with root package name */
    public static final a.g f19881k;

    /* renamed from: l, reason: collision with root package name */
    public static final a.AbstractC0224a f19882l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f19883m;

    static {
        a.g gVar = new a.g();
        f19881k = gVar;
        i iVar = new i();
        f19882l = iVar;
        f19883m = new com.google.android.gms.common.api.a("ModuleInstall.API", iVar, gVar);
    }

    public j(Context context) {
        super(context, f19883m, a.d.f19495q0, c.a.f19506c);
    }

    public static final ApiFeatureRequest p(boolean z10, com.google.android.gms.common.api.e... eVarArr) {
        C1669j.l(eVarArr, "Requested APIs must not be null.");
        C1669j.b(eVarArr.length > 0, "Please provide at least one OptionalModuleApi.");
        for (com.google.android.gms.common.api.e eVar : eVarArr) {
            C1669j.l(eVar, "Requested API must not be null.");
        }
        return ApiFeatureRequest.zaa(Arrays.asList(eVarArr), z10);
    }

    @Override // q2.c
    public final D2.i<ModuleInstallResponse> b(q2.d dVar) {
        final ApiFeatureRequest apiFeatureRequestFromModuleInstallRequest = ApiFeatureRequest.fromModuleInstallRequest(dVar);
        final InterfaceC5144a interfaceC5144aB = dVar.b();
        Executor executorC = dVar.c();
        if (apiFeatureRequestFromModuleInstallRequest.getApiFeatures().isEmpty()) {
            return l.d(new ModuleInstallResponse(0));
        }
        if (interfaceC5144aB == null) {
            AbstractC1651q.a aVarA = AbstractC1651q.a();
            aVarA.d(w2.j.f43053a);
            aVarA.c(true);
            aVarA.e(27304);
            aVarA.b(new InterfaceC1649o() { // from class: com.google.android.gms.common.moduleinstall.internal.h
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.InterfaceC1649o
                public final void accept(Object obj, Object obj2) throws RemoteException {
                    ((zaf) ((k) obj).A()).zag(new zat(this.f19879a, (D2.j) obj2), apiFeatureRequestFromModuleInstallRequest, null);
                }
            });
            return f(aVarA.a());
        }
        C1669j.k(interfaceC5144aB);
        C1643i c1643iK = executorC == null ? k(interfaceC5144aB, InterfaceC5144a.class.getSimpleName()) : C1644j.b(interfaceC5144aB, executorC, InterfaceC5144a.class.getSimpleName());
        final zaab zaabVar = new zaab(c1643iK);
        final AtomicReference atomicReference = new AtomicReference();
        InterfaceC1649o interfaceC1649o = new InterfaceC1649o() { // from class: com.google.android.gms.common.moduleinstall.internal.d
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.InterfaceC1649o
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zaf) ((k) obj).A()).zag(new zau(this.f19869a, atomicReference, (D2.j) obj2, interfaceC5144aB), apiFeatureRequestFromModuleInstallRequest, zaabVar);
            }
        };
        InterfaceC1649o interfaceC1649o2 = new InterfaceC1649o() { // from class: com.google.android.gms.common.moduleinstall.internal.e
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.InterfaceC1649o
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zaf) ((k) obj).A()).zai(new zav(this.f19874a, (D2.j) obj2), zaabVar);
            }
        };
        C1648n.a aVarA2 = C1648n.a();
        aVarA2.g(c1643iK);
        aVarA2.d(w2.j.f43053a);
        aVarA2.c(true);
        aVarA2.b(interfaceC1649o);
        aVarA2.f(interfaceC1649o2);
        aVarA2.e(27305);
        return g(aVarA2.a()).m(new D2.h() { // from class: com.google.android.gms.common.moduleinstall.internal.f
            @Override // D2.h
            public final D2.i a(Object obj) {
                a.g gVar = j.f19881k;
                AtomicReference atomicReference2 = atomicReference;
                return atomicReference2.get() != null ? l.d((ModuleInstallResponse) atomicReference2.get()) : l.c(new ApiException(Status.RESULT_INTERNAL_ERROR));
            }
        });
    }

    @Override // q2.c
    public final D2.i<ModuleAvailabilityResponse> c(com.google.android.gms.common.api.e... eVarArr) {
        final ApiFeatureRequest apiFeatureRequestP = p(false, eVarArr);
        if (apiFeatureRequestP.getApiFeatures().isEmpty()) {
            return l.d(new ModuleAvailabilityResponse(true, 0));
        }
        AbstractC1651q.a aVarA = AbstractC1651q.a();
        aVarA.d(w2.j.f43053a);
        aVarA.e(27301);
        aVarA.c(false);
        aVarA.b(new InterfaceC1649o() { // from class: com.google.android.gms.common.moduleinstall.internal.g
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.InterfaceC1649o
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zaf) ((k) obj).A()).zae(new zar(this.f19877a, (D2.j) obj2), apiFeatureRequestP);
            }
        });
        return f(aVarA.a());
    }
}
