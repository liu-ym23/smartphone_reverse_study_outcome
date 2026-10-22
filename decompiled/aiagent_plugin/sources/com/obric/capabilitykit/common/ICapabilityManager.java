package com.obric.capabilitykit.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityManager extends IInterface {

    public static class Default implements ICapabilityManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void finishFloatingActivity(long r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4) {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public int getVersion() {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void hideIntentResultCard(long r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isCardViewVisible(long r1) {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isKeyguardReallyLocked() {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerFunction(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerIntent(String r1, String r2, String r3) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerResultCallback(IErrorCodeCallback r2) {
            IErrorCodeCallback r1 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestCloseFile(String r1, Uri r2) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3) {
            IUriFileReceiver r0 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r1, IUriFileReceiver.class, "com.obric.aiagent.plugin");
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4) {
            ITaskStateChangeCallback r0 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendActionExecuteResult(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendIntentExecutionResult(IntentResult r1, String r2) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterFunction(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterIntent(String r1, String r2) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterResultCallback(IErrorCodeCallback r2) {
            IErrorCodeCallback r1 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void updateIntentResult(IntentResult r1, long r2, boolean r4, Map r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityManager {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityManager";
        public static final int TRANSACTION_finishFloatingActivity = 14;
        public static final int TRANSACTION_getFloatingPendingIntent = 16;
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_hideIntentResultCard = 9;
        public static final int TRANSACTION_isCardViewVisible = 15;
        public static final int TRANSACTION_isKeyguardReallyLocked = 17;
        public static final int TRANSACTION_registerFunction = 2;
        public static final int TRANSACTION_registerIntent = 4;
        public static final int TRANSACTION_registerResultCallback = 10;
        public static final int TRANSACTION_requestCloseFile = 13;
        public static final int TRANSACTION_requestOpenFile = 12;
        public static final int TRANSACTION_requestStateChanged = 18;
        public static final int TRANSACTION_sendActionExecuteResult = 7;
        public static final int TRANSACTION_sendIntentExecutionResult = 6;
        public static final int TRANSACTION_unregisterFunction = 3;
        public static final int TRANSACTION_unregisterIntent = 5;
        public static final int TRANSACTION_unregisterResultCallback = 11;
        public static final int TRANSACTION_updateIntentResult = 8;

        public static class Proxy implements ICapabilityManager {
            public static ICapabilityManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void finishFloatingActivity(long r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().finishFloatingActivity(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public PendingIntent getFloatingPendingIntent(long r5, Intent r7, FloatingIntentParams r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r0.writeLong(r5);     // Catch: Throwable -> L22
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L7:
                if (r8 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L11:
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L22
                if (r1.readInt() == 0) goto L21;
                PendingIntent r4 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r1), PendingIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L21:
                r4 = null;
                goto L15
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                r4 = Stub.getDefaultImpl().getFloatingPendingIntent(r5, r7, r8);     // Catch: Throwable -> L22
                goto L15
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L22
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public int getVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void hideIntentResultCard(long r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().hideIntentResultCard(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isCardViewVisible(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isCardViewVisible(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isKeyguardReallyLocked() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerFunction(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerFunction(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerIntent(String r5, String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerIntent(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerResultCallback(IErrorCodeCallback r5) {
                IErrorCodeCallback r6 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r5, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerResultCallback(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestCloseFile(String r5, Uri r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestCloseFile(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean requestOpenFile(IUriFileReceiver r6, Uri r7, String r8) {
                IUriFileReceiver r9 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r6, IUriFileReceiver.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L24
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L24
                boolean r3 = true;
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L24
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L24
            L11:
                r0.writeString(r8);     // Catch: Throwable -> L24
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L24
                if (r1.readInt() != 0) goto L22;
                r3 = false;
            L22:
                r1.recycle();
                r0.recycle();
                return r3;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                boolean r5 = Stub.getDefaultImpl().requestOpenFile(r9, r7, r8);     // Catch: Throwable -> L24
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L24
                goto L11
            L6:
                r2 = null;
            L24:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestStateChanged(String r7, TaskStateInfo r8, ITaskStateChangeCallback r9, long r10) {
                ITaskStateChangeCallback r3 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r9, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r11.writeString(r7);     // Catch: Throwable -> L20
                if (r8 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r8.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (r3 == null) goto L10;
                IBinder r2 = r3.asBinder();     // Catch: Throwable -> L20
            L11:
                r11.writeStrongBinder(r2);     // Catch: Throwable -> L20
                r11.writeLong(r10);     // Catch: Throwable -> L20
                if (this.mRemote.transact(18, r11, null, 1) == false) goto L14;
            L18:
                r11.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestStateChanged(r7, r8, r3, r10);     // Catch: Throwable -> L20
                r11.recycle();
                return;
            L10:
                r2 = null;
                goto L11
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendActionExecuteResult(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendActionExecuteResult(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendIntentExecutionResult(IntentResult r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendIntentExecutionResult(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterFunction(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterFunction(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterIntent(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterIntent(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterResultCallback(IErrorCodeCallback r5) {
                IErrorCodeCallback r6 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r5, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterResultCallback(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void updateIntentResult(IntentResult r7, long r8, boolean r10, Map r11) {
                Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r12, 0);     // Catch: Throwable -> L16
            L7:
                r12.writeLong(r8);     // Catch: Throwable -> L16
                r12.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L16
                r12.writeMap(r5);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r12, null, 1) == false) goto L10;
            L14:
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateIntentResult(r7, r8, r10, r5);     // Catch: Throwable -> L16
                r12.recycle();
                return;
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICapabilityManager.class) == false) goto L13;
            return (ICapabilityManager) ZeusTransformUtils.preCheckCast(r0, ICapabilityManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICapabilityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityManager r2) {
            ICapabilityManager r3 = (ICapabilityManager) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityManager.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) {
            if (r12 == 1598968902) goto L73;
            IntentResult<?> r4 = null;
            TaskStateInfo r5 = null;
            FloatingIntentParams r6 = null;
            Uri r7 = null;
            Uri r8 = null;
            IntentResult<?> r9 = null;
            switch(r12) {
                case 1: goto L71;
                case 2: goto L69;
                case 3: goto L67;
                case 4: goto L65;
                case 5: goto L63;
                case 6: goto L58;
                case 7: goto L56;
                case 8: goto L47;
                case 9: goto L45;
                case 10: goto L43;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L31;
                case 14: goto L29;
                case 15: goto L27;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r13.enforceInterface(DESCRIPTOR);
            String r10 = r13.readString();
            if (r13.readInt() == 0) goto L11;
            r5 = (TaskStateInfo) ZeusTransformUtils.preCheckCast(TaskStateInfo.CREATOR.createFromParcel(r13), TaskStateInfo.class, "com.obric.aiagent.plugin");
        L11:
            requestStateChanged(r10, r5, ITaskStateChangeCallback.Stub.asInterface(r13.readStrongBinder()), r13.readLong());
            return true;
        L13:
            r13.enforceInterface(DESCRIPTOR);
            boolean r11 = isKeyguardReallyLocked();
            r14.writeNoException();
            r14.writeInt(r11 ? 1 : 0);
            return true;
        L15:
            r13.enforceInterface(DESCRIPTOR);
            long r16 = r13.readLong();
            if (r13.readInt() == 0) goto L18;
            Intent r17 = (Intent) ZeusTransformUtils.preCheckCast(Intent.CREATOR.createFromParcel(r13), Intent.class, "com.obric.aiagent.plugin");
        L20:
            if (r13.readInt() == 0) goto L22;
            r6 = FloatingIntentParams.CREATOR.a(r13);
        L22:
            PendingIntent r18 = getFloatingPendingIntent(r16, r17, r6);
            r14.writeNoException();
            if (r18 == null) goto L25;
            r14.writeInt(1);
            r18.writeToParcel(r14, 1);
        L26:
            return true;
        L25:
            r14.writeInt(0);
            goto L26
        L18:
            r17 = null;
            goto L20
        L27:
            r13.enforceInterface(DESCRIPTOR);
            boolean r19 = isCardViewVisible(r13.readLong());
            r14.writeNoException();
            r14.writeInt(r19 ? 1 : 0);
            return true;
        L29:
            r13.enforceInterface(DESCRIPTOR);
            finishFloatingActivity(r13.readLong());
            return true;
        L31:
            r13.enforceInterface(DESCRIPTOR);
            String r110 = r13.readString();
            if (r13.readInt() == 0) goto L34;
            r7 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r13), Uri.class, "com.obric.aiagent.plugin");
        L34:
            requestCloseFile(r110, r7);
            return true;
        L36:
            r13.enforceInterface(DESCRIPTOR);
            IUriFileReceiver r111 = IUriFileReceiver.Stub.asInterface(r13.readStrongBinder());
            if (r13.readInt() == 0) goto L39;
            r8 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r13), Uri.class, "com.obric.aiagent.plugin");
        L39:
            boolean r112 = requestOpenFile(r111, r8, r13.readString());
            r14.writeNoException();
            r14.writeInt(r112 ? 1 : 0);
            return true;
        L41:
            r13.enforceInterface(DESCRIPTOR);
            unregisterResultCallback(IErrorCodeCallback.Stub.asInterface(r13.readStrongBinder()));
            return true;
        L43:
            r13.enforceInterface(DESCRIPTOR);
            registerResultCallback(IErrorCodeCallback.Stub.asInterface(r13.readStrongBinder()));
            return true;
        L45:
            r13.enforceInterface(DESCRIPTOR);
            hideIntentResultCard(r13.readLong());
            return true;
        L47:
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L50;
            r9 = IntentResult.CREATOR.a(r13);
        L50:
            IntentResult<?> r20 = r9;
            long r21 = r13.readLong();
            if (r13.readInt() == 0) goto L53;
            boolean r22 = true;
        L54:
            updateIntentResult(r20, r21, r22, r13.readHashMap(getClass().getClassLoader()));
            return true;
        L53:
            r22 = false;
            goto L54
        L56:
            r13.enforceInterface(DESCRIPTOR);
            sendActionExecuteResult(r13.readString());
            return true;
        L58:
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L61;
            r4 = IntentResult.CREATOR.a(r13);
        L61:
            sendIntentExecutionResult(r4, r13.readString());
            return true;
        L63:
            r13.enforceInterface(DESCRIPTOR);
            unregisterIntent(r13.readString(), r13.readString());
            r14.writeNoException();
            return true;
        L65:
            r13.enforceInterface(DESCRIPTOR);
            registerIntent(r13.readString(), r13.readString(), r13.readString());
            r14.writeNoException();
            return true;
        L67:
            r13.enforceInterface(DESCRIPTOR);
            unregisterFunction(r13.readString());
            r14.writeNoException();
            return true;
        L69:
            r13.enforceInterface(DESCRIPTOR);
            registerFunction(r13.readString());
            r14.writeNoException();
            return true;
        L71:
            r13.enforceInterface(DESCRIPTOR);
            int r113 = getVersion();
            r14.writeNoException();
            r14.writeInt(r113);
            return true;
        L7:
            return super.onTransact(r12, r13, r14, r15);
        L73:
            r14.writeString(DESCRIPTOR);
            return true;
        }
    }

    void finishFloatingActivity(long r1);

    PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4);

    int getVersion();

    void hideIntentResultCard(long r1);

    boolean isCardViewVisible(long r1);

    boolean isKeyguardReallyLocked();

    void registerFunction(String r1);

    void registerIntent(String r1, String r2, String r3);

    void registerResultCallback(IErrorCodeCallback r1);

    void requestCloseFile(String r1, Uri r2);

    boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3);

    void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4);

    void sendActionExecuteResult(String r1);

    void sendIntentExecutionResult(IntentResult r1, String r2);

    void unregisterFunction(String r1);

    void unregisterIntent(String r1, String r2);

    void unregisterResultCallback(IErrorCodeCallback r1);

    void updateIntentResult(IntentResult r1, long r2, boolean r4, Map r5);
}
