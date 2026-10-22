package com.obric.memorydata.sdk.assistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IAssistantStateService extends IInterface {

    public static class Default implements IAssistantStateService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onActive() {
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onQuery(QueryContext r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantStateService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.assistant.IAssistantStateService";
        static final int TRANSACTION_onActive = 2;
        static final int TRANSACTION_onQuery = 1;

        private static class Proxy implements IAssistantStateService {
            public static IAssistantStateService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
            public void onQuery(QueryContext r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onQuery(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
            public void onActive() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActive();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
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

        public static IAssistantStateService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAssistantStateService.class) == false) goto L13;
            return (IAssistantStateService) ZeusTransformUtils.preCheckCast(r0, IAssistantStateService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L17;
            QueryContext r8 = QueryContext.CREATOR.createFromParcel(r5);
        L18:
            onQuery(r8);
            return true;
        L17:
            r8 = null;
            goto L18
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onActive();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAssistantStateService r2) {
            IAssistantStateService r3 = (IAssistantStateService) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantStateService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAssistantStateService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onActive();

    void onQuery(QueryContext r1);
}
