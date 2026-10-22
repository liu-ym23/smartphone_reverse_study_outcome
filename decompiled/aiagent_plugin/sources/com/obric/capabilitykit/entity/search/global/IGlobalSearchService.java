package com.obric.capabilitykit.entity.search.global;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IGlobalSearchService extends IInterface {

    public static class Default implements IGlobalSearchService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void cancel(String r1) {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void startGlobalSearch(String r1, GlobalSearchRequest r2, IGlobalSearchCallback r3) {
            IGlobalSearchCallback r0 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements IGlobalSearchService {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.global.IGlobalSearchService";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_startGlobalSearch = 1;

        public static class Proxy implements IGlobalSearchService {
            public static IGlobalSearchService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void cancel(String r5) {
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
                Stub.getDefaultImpl().cancel(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void startGlobalSearch(String r6, GlobalSearchRequest r7, IGlobalSearchCallback r8) {
                IGlobalSearchCallback r9 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r8, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r9 == null) goto L9;
                IBinder r4 = r9.asBinder();     // Catch: Throwable -> L19
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L19
            L15:
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().startGlobalSearch(r6, r7, r9);     // Catch: Throwable -> L19
                goto L15
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGlobalSearchService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IGlobalSearchService.class) == false) goto L13;
            return (IGlobalSearchService) ZeusTransformUtils.preCheckCast(r0, IGlobalSearchService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IGlobalSearchService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGlobalSearchService r2) {
            IGlobalSearchService r3 = (IGlobalSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchService.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L18;
            GlobalSearchRequest r9 = GlobalSearchRequest.CREATOR.a(r5);
        L19:
            startGlobalSearch(r8, r9, IGlobalSearchCallback.Stub.asInterface(r5.readStrongBinder()));
        L13:
            r6.writeNoException();
            return true;
        L18:
            r9 = null;
            goto L19
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            cancel(r5.readString());
            goto L13
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void cancel(String r1);

    void startGlobalSearch(String r1, GlobalSearchRequest r2, IGlobalSearchCallback r3);
}
