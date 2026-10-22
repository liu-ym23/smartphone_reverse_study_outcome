package com.bm.vivoid;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f33677a;

    public a(IBinder r100) {
        this.f33677a = r100;
    }

    @Override // com.bm.vivoid.c
    public boolean a(IBinder r100, IBinder r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken("com.bm.vivoid.ITransfer");     // Catch: Throwable -> L11
        r102.writeStrongBinder(r100);     // Catch: Throwable -> L11
        r102.writeStrongBinder(r101);     // Catch: Throwable -> L11
        boolean r104 = false;
        if (INVOKEINTERFACE_com_bm_vivoid_a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f33677a, 1, r102, r103, 0) == true) goto L6;
        int r105 = b.f33678a;     // Catch: Throwable -> L11
    L6:
        r103.readException();     // Catch: Throwable -> L11
        if (r103.readInt() == 0) goto L9;
        r104 = true;
    L9:
        r103.recycle();
        r102.recycle();
        return r104;
    L11:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f33677a;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bm_vivoid_a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }
}
