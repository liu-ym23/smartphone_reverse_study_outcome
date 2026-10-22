package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IInAppSearchService extends IInterface {

    public static abstract class a extends Binder implements IInAppSearchService {

        /* JADX INFO: renamed from: com.obric.capabilitykit.entity.search.IInAppSearchService$a$a, reason: collision with other inner class name */
        public static class C0177a implements IInAppSearchService {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IInAppSearchService f11365b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f11366a;

            public C0177a(IBinder r10) {
                this.f11366a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11366a;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void cancel(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.f11366a.transact(2, r11, r12, 0) == false) goto L6;
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

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void prepareSearch() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L10
                if (this.f11366a.transact(3, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().prepareSearch();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void registerEntityObserver(EntityChangeMonitorRequest r10, IEntityChangeCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                if (r11 == null) goto L11;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L12:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11366a.transact(5, r12, r13, 0) == false) goto L15;
            L19:
                r13.readException();     // Catch: Throwable -> L6
            L17:
                r13.recycle();
                r12.recycle();
                return;
            L15:
                if (a.b() == null) goto L19;
                a.b().registerEntityObserver(r10, r11);     // Catch: Throwable -> L6
                goto L17
            L11:
                r14 = null;
                goto L12
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void startAppSearch(String r10, InAppSearchRequest r11, IInAppSearchCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                if (r12 == null) goto L11;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L12:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11366a.transact(1, r13, r14, 0) == false) goto L15;
            L19:
                r14.readException();     // Catch: Throwable -> L6
            L17:
                r14.recycle();
                r13.recycle();
                return;
            L15:
                if (a.b() == null) goto L19;
                a.b().startAppSearch(r10, r11, r12);     // Catch: Throwable -> L6
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

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void stopSearch() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L10
                if (this.f11366a.transact(4, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().stopSearch();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void unregisterEntityObserver() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.capabilitykit.entity.search.IInAppSearchService");     // Catch: Throwable -> L10
                if (this.f11366a.transact(6, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().unregisterEntityObserver();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public static IInAppSearchService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.capabilitykit.entity.search.IInAppSearchService");
            if (r11 == null) goto L12;
            if ((r11 instanceof IInAppSearchService) == false) goto L12;
            return (IInAppSearchService) r11;
        L12:
            return new C0177a(r10);
        }

        public static IInAppSearchService b() {
            return C0177a.f11365b;
        }
    }

    void cancel(String r10) throws RemoteException;

    void prepareSearch() throws RemoteException;

    void registerEntityObserver(EntityChangeMonitorRequest r10, IEntityChangeCallback r11) throws RemoteException;

    void startAppSearch(String r10, InAppSearchRequest r11, IInAppSearchCallback r12) throws RemoteException;

    void stopSearch() throws RemoteException;

    void unregisterEntityObserver() throws RemoteException;
}
