package com.obric.capabilitykit.entity.search.global;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IGlobalSearchService extends IInterface {

    public static abstract class a extends Binder implements IGlobalSearchService {

        /* JADX INFO: renamed from: com.obric.capabilitykit.entity.search.global.IGlobalSearchService$a$a, reason: collision with other inner class name */
        public static class C0178a implements IGlobalSearchService {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IGlobalSearchService f11368b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f11369a;

            public C0178a(IBinder r10) {
                this.f11369a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11369a;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void cancel(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.capabilitykit.entity.search.global.IGlobalSearchService");     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.f11369a.transact(2, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().cancel(r10);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void startGlobalSearch(String r10, GlobalSearchRequest r11, IGlobalSearchCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.capabilitykit.entity.search.global.IGlobalSearchService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                if (r12 == null) goto L11;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L12:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11369a.transact(1, r13, r14, 0) == false) goto L15;
            L19:
                r14.readException();     // Catch: Throwable -> L6
            L17:
                r14.recycle();
                r13.recycle();
                return;
            L15:
                if (a.b() == null) goto L19;
                a.b().startGlobalSearch(r10, r11, r12);     // Catch: Throwable -> L6
                goto L17
            L11:
                r15 = null;
                goto L12
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }
        }

        public static IGlobalSearchService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.capabilitykit.entity.search.global.IGlobalSearchService");
            if (r11 == null) goto L12;
            if ((r11 instanceof IGlobalSearchService) == false) goto L12;
            return (IGlobalSearchService) r11;
        L12:
            return new C0178a(r10);
        }

        public static IGlobalSearchService b() {
            return C0178a.f11368b;
        }
    }

    void cancel(String r10) throws RemoteException;

    void startGlobalSearch(String r10, GlobalSearchRequest r11, IGlobalSearchCallback r12) throws RemoteException;
}
