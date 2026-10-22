package com.google.android.gms.tasks;

import D2.InterfaceC0792d;
import D2.i;

/* loaded from: classes2.dex */
public class NativeOnCompleteListener implements InterfaceC0792d<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final long f20198a;

    @Override // D2.InterfaceC0792d
    public void a(i<Object> iVar) {
        Object objI;
        String message;
        Exception excH;
        if (iVar.l()) {
            objI = iVar.i();
            message = null;
        } else if (iVar.j() || (excH = iVar.h()) == null) {
            objI = null;
            message = null;
        } else {
            message = excH.getMessage();
            objI = null;
        }
        nativeOnComplete(this.f20198a, objI, iVar.l(), iVar.j(), message);
    }

    public native void nativeOnComplete(long j10, Object obj, boolean z10, boolean z11, String str);
}
