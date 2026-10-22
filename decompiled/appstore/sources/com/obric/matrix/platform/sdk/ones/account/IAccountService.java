package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IAccountService extends IInterface {

    public static abstract class a extends Binder implements IAccountService {

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.IAccountService$a$a, reason: collision with other inner class name */
        public static class C0183a implements IAccountService {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IAccountService f11865b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f11866a;

            public C0183a(IBinder r10) {
                this.f11866a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11866a;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r10, IAccountActionCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11866a.transact(12, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().checkPassword(r10, r11);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L10
                if (this.f11866a.transact(3, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().forceUpdateAccount();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f11866a.transact(1, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().login(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(8, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().loginWithPassword(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                if (this.f11866a.transact(2, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().logout(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(5, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().quickLogin(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r10, String r11, String r12, IAccountActionCallback r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeString(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                if (r13 == null) goto L8;
                IBinder r16 = r13.asBinder();     // Catch: Throwable -> L6
            L9:
                r14.writeStrongBinder(r16);     // Catch: Throwable -> L6
                if (this.f11866a.transact(14, r14, r15, 0) == false) goto L12;
            L16:
                r15.readException();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().resetPassword(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L8:
                r16 = null;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r10, int r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(4, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().sendCode(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r10, IAccountActionCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11866a.transact(11, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().setInitPassword(r10, r11);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(10, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().ticketResetPassword(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(13, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().updatePassword(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L12;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L13:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(6, r13, r14, 0) == false) goto L16;
            L20:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L16:
                if (a.b() == null) goto L20;
                a.b().updateUserInfo(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                r15 = null;
                goto L13
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r10, IAccountActionCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11866a.transact(7, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().uploadAvatar(r10, r11);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(15, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().verifyPassword(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r10, String r11, IAccountActionCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11866a.transact(16, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().verifyPasswordWithoutLogin(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r10, String r11, int r12, IAccountActionCallback r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeString(r11);     // Catch: Throwable -> L6
                r14.writeInt(r12);     // Catch: Throwable -> L6
                if (r13 == null) goto L8;
                IBinder r16 = r13.asBinder();     // Catch: Throwable -> L6
            L9:
                r14.writeStrongBinder(r16);     // Catch: Throwable -> L6
                if (this.f11866a.transact(9, r14, r15, 0) == false) goto L12;
            L16:
                r15.readException();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().verifySmsCode(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L8:
                r16 = null;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }
        }

        public static IAccountService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r11 == null) goto L12;
            if ((r11 instanceof IAccountService) == false) goto L12;
            return (IAccountService) r11;
        L12:
            return new C0183a(r10);
        }

        public static IAccountService b() {
            return C0183a.f11865b;
        }
    }

    void checkPassword(String r10, IAccountActionCallback r11) throws RemoteException;

    void forceUpdateAccount() throws RemoteException;

    void login(PendingIntent r10) throws RemoteException;

    void loginWithPassword(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void logout(IAccountActionCallback r10) throws RemoteException;

    void quickLogin(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void resetPassword(String r10, String r11, String r12, IAccountActionCallback r13) throws RemoteException;

    void sendCode(String r10, int r11, IAccountActionCallback r12) throws RemoteException;

    void setInitPassword(String r10, IAccountActionCallback r11) throws RemoteException;

    void ticketResetPassword(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void updatePassword(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void updateUserInfo(Bundle r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void uploadAvatar(String r10, IAccountActionCallback r11) throws RemoteException;

    void verifyPassword(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void verifyPasswordWithoutLogin(String r10, String r11, IAccountActionCallback r12) throws RemoteException;

    void verifySmsCode(String r10, String r11, int r12, IAccountActionCallback r13) throws RemoteException;
}
