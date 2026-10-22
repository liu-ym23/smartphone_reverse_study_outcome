package com.aiassistant.security.guard;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IAssistantSettingsEventObserver extends IInterface {

    public static class Default implements IAssistantSettingsEventObserver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.aiassistant.security.guard.IAssistantSettingsEventObserver
        public void onEventEnd(int r1, String r2, Bundle r3) {
        }

        @Override // com.aiassistant.security.guard.IAssistantSettingsEventObserver
        public void onEventStart(int r1, String r2, Bundle r3) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantSettingsEventObserver {
        private static final String DESCRIPTOR = "com.aiassistant.security.guard.IAssistantSettingsEventObserver";
        static final int TRANSACTION_onEventEnd = 2;
        static final int TRANSACTION_onEventStart = 1;

        private static class Proxy implements IAssistantSettingsEventObserver {
            public static IAssistantSettingsEventObserver sDefaultImpl;
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

            @Override // com.aiassistant.security.guard.IAssistantSettingsEventObserver
            public void onEventStart(int r4, String r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r4);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventStart(r4, r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.aiassistant.security.guard.IAssistantSettingsEventObserver
            public void onEventEnd(int r5, String r6, Bundle r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventEnd(r5, r6, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
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

        public static IAssistantSettingsEventObserver asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAssistantSettingsEventObserver.class) == false) goto L13;
            return (IAssistantSettingsEventObserver) ZeusTransformUtils.preCheckCast(r0, IAssistantSettingsEventObserver.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            int r10 = r7.readInt();
            String r11 = r7.readString();
            if (r7.readInt() == 0) goto L20;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L20:
            onEventStart(r10, r11, r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            int r12 = r7.readInt();
            String r13 = r7.readString();
            if (r7.readInt() == 0) goto L15;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L15:
            onEventEnd(r12, r13, r1);
            return true;
        L7:
            if (r6 != 1598968902) goto L9;
            r8.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IAssistantSettingsEventObserver r2) {
            IAssistantSettingsEventObserver r3 = (IAssistantSettingsEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSettingsEventObserver.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IAssistantSettingsEventObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onEventEnd(int r1, String r2, Bundle r3);

    void onEventStart(int r1, String r2, Bundle r3);
}
