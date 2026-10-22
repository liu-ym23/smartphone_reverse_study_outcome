package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IAccountService extends IInterface {

    public static class Default implements IAccountService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void checkPassword(String r1, IAccountActionCallback r2) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void forceUpdateAccount() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void login(PendingIntent r1) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void loginWithPassword(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void logout(IAccountActionCallback r2) {
            IAccountActionCallback r1 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void quickLogin(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void sendCode(String r1, int r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void setInitPassword(String r1, IAccountActionCallback r2) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updatePassword(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void uploadAvatar(String r1, IAccountActionCallback r2) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPassword(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) {
            IAccountActionCallback r0 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAccountActionCallback.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAccountService {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountService";
        static final int TRANSACTION_checkPassword = 12;
        static final int TRANSACTION_forceUpdateAccount = 3;
        static final int TRANSACTION_login = 1;
        static final int TRANSACTION_loginWithPassword = 8;
        static final int TRANSACTION_logout = 2;
        static final int TRANSACTION_quickLogin = 5;
        static final int TRANSACTION_resetPassword = 14;
        static final int TRANSACTION_sendCode = 4;
        static final int TRANSACTION_setInitPassword = 11;
        static final int TRANSACTION_ticketResetPassword = 10;
        static final int TRANSACTION_updatePassword = 13;
        static final int TRANSACTION_updateUserInfo = 6;
        static final int TRANSACTION_uploadAvatar = 7;
        static final int TRANSACTION_verifyPassword = 15;
        static final int TRANSACTION_verifyPasswordWithoutLogin = 16;
        static final int TRANSACTION_verifySmsCode = 9;

        private static class Proxy implements IAccountService {
            public static IAccountService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().login(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r5) {
                IAccountActionCallback r6 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().logout(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().forceUpdateAccount();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r5, int r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendCode(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().quickLogin(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L21
                if (r8 == null) goto L10;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L21
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().updateUserInfo(r5, r6, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r5, IAccountActionCallback r6) {
                IAccountActionCallback r7 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadAvatar(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().loginWithPassword(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r5, String r6, int r7, IAccountActionCallback r8) {
                IAccountActionCallback r9 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r8, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().verifySmsCode(r5, r6, r7, r9);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().ticketResetPassword(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r5, IAccountActionCallback r6) {
                IAccountActionCallback r7 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setInitPassword(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r5, IAccountActionCallback r6) {
                IAccountActionCallback r7 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().checkPassword(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updatePassword(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r5, String r6, String r7, IAccountActionCallback r8) {
                IAccountActionCallback r9 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r8, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().resetPassword(r5, r6, r7, r9);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().verifyPassword(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r5, String r6, IAccountActionCallback r7) {
                IAccountActionCallback r8 = (IAccountActionCallback) ZeusTransformUtils.wrapperContextForParams(r7, IAccountActionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().verifyPasswordWithoutLogin(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAccountService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAccountService.class) == false) goto L13;
            return (IAccountService) ZeusTransformUtils.preCheckCast(r0, IAccountService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L46;
            PendingIntent r3 = null;
            Bundle r4 = null;
            switch(r5) {
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L26;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L20;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L14;
                case 14: goto L12;
                case 15: goto L10;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            verifyPasswordWithoutLogin(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            verifyPassword(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            resetPassword(r6.readString(), r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L14:
            r6.enforceInterface(DESCRIPTOR);
            updatePassword(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L16:
            r6.enforceInterface(DESCRIPTOR);
            checkPassword(r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L18:
            r6.enforceInterface(DESCRIPTOR);
            setInitPassword(r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            ticketResetPassword(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            verifySmsCode(r6.readString(), r6.readString(), r6.readInt(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L24:
            r6.enforceInterface(DESCRIPTOR);
            loginWithPassword(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L26:
            r6.enforceInterface(DESCRIPTOR);
            uploadAvatar(r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L28:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L31;
            r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r6), Bundle.class, "com.obric.aiagent.plugin");
        L31:
            updateUserInfo(r4, r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L33:
            r6.enforceInterface(DESCRIPTOR);
            quickLogin(r6.readString(), r6.readString(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L35:
            r6.enforceInterface(DESCRIPTOR);
            sendCode(r6.readString(), r6.readInt(), IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L37:
            r6.enforceInterface(DESCRIPTOR);
            forceUpdateAccount();
            r7.writeNoException();
            return true;
        L39:
            r6.enforceInterface(DESCRIPTOR);
            logout(IAccountActionCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L41:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L44;
            r3 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r6), PendingIntent.class, "com.obric.aiagent.plugin");
        L44:
            login(r3);
            r7.writeNoException();
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L46:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAccountService r2) {
            IAccountService r3 = (IAccountService) ZeusTransformUtils.wrapperContextForParams(r2, IAccountService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAccountService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void checkPassword(String r1, IAccountActionCallback r2);

    void forceUpdateAccount();

    void login(PendingIntent r1);

    void loginWithPassword(String r1, String r2, IAccountActionCallback r3);

    void logout(IAccountActionCallback r1);

    void quickLogin(String r1, String r2, IAccountActionCallback r3);

    void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4);

    void sendCode(String r1, int r2, IAccountActionCallback r3);

    void setInitPassword(String r1, IAccountActionCallback r2);

    void ticketResetPassword(String r1, String r2, IAccountActionCallback r3);

    void updatePassword(String r1, String r2, IAccountActionCallback r3);

    void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3);

    void uploadAvatar(String r1, IAccountActionCallback r2);

    void verifyPassword(String r1, String r2, IAccountActionCallback r3);

    void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3);

    void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4);
}
