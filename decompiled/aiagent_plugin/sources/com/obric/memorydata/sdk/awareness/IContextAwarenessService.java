package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IContextAwarenessService extends IInterface {

    public static class Default implements IContextAwarenessService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getFeature(String r1) {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getGeoFenceStatus(String r1) {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getLocation(String r1) {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerEvent(String r1, IEventChangeListener r2) {
            IEventChangeListener r0 = (IEventChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventChangeListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerFeature(String r1, IFeatureChangeListener r2) {
            IFeatureChangeListener r0 = (IFeatureChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IFeatureChangeListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) {
            IFeatureDurationListener r0 = (IFeatureDurationListener) ZeusTransformUtils.wrapperContextForParams(r6, IFeatureDurationListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse setLocation(String r1, double r2, double r4, String r6, String r7) {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse unregisterFeature(String r1, IFeatureChangeListener r2) {
            IFeatureChangeListener r0 = (IFeatureChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IFeatureChangeListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse unregisterFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) {
            IFeatureDurationListener r0 = (IFeatureDurationListener) ZeusTransformUtils.wrapperContextForParams(r6, IFeatureDurationListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IContextAwarenessService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IContextAwarenessService";
        static final int TRANSACTION_getFeature = 1;
        static final int TRANSACTION_getGeoFenceStatus = 9;
        static final int TRANSACTION_getLocation = 4;
        static final int TRANSACTION_registerEvent = 5;
        static final int TRANSACTION_registerFeature = 2;
        static final int TRANSACTION_registerFeatureDuration = 6;
        static final int TRANSACTION_setLocation = 8;
        static final int TRANSACTION_unregisterFeature = 3;
        static final int TRANSACTION_unregisterFeatureDuration = 7;

        private static class Proxy implements IContextAwarenessService {
            public static IContextAwarenessService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getFeature(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                MemoryResponse<?> r4 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                MemoryResponse r6 = Stub.getDefaultImpl().getFeature(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeature(String r6, IFeatureChangeListener r7) {
                IFeatureChangeListener r8 = (IFeatureChangeListener) ZeusTransformUtils.wrapperContextForParams(r7, IFeatureChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                MemoryResponse<?> r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r2 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r5 = Stub.getDefaultImpl().registerFeature(r6, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeature(String r6, IFeatureChangeListener r7) {
                IFeatureChangeListener r8 = (IFeatureChangeListener) ZeusTransformUtils.wrapperContextForParams(r7, IFeatureChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                MemoryResponse<?> r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r2 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r5 = Stub.getDefaultImpl().unregisterFeature(r6, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getLocation(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                MemoryResponse<?> r4 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                MemoryResponse r6 = Stub.getDefaultImpl().getLocation(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerEvent(String r6, IEventChangeListener r7) {
                IEventChangeListener r8 = (IEventChangeListener) ZeusTransformUtils.wrapperContextForParams(r7, IEventChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                MemoryResponse<?> r2 = null;
                if (r8 == null) goto L6;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r2 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r5 = Stub.getDefaultImpl().registerEvent(r6, r8);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r3 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeatureDuration(String r9, String r10, long r11, boolean r13, IFeatureDurationListener r14) {
                IFeatureDurationListener r6 = (IFeatureDurationListener) ZeusTransformUtils.wrapperContextForParams(r14, IFeatureDurationListener.class, "com.obric.aiagent.plugin");
                Parcel r15 = Parcel.obtain();
                Parcel r7 = Parcel.obtain();
                r15.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                r15.writeString(r9);     // Catch: Throwable -> L23
                r15.writeString(r10);     // Catch: Throwable -> L23
                r15.writeLong(r11);     // Catch: Throwable -> L23
                if (r13 == false) goto L6;
                int r1 = 1;
            L7:
                r15.writeInt(r1);     // Catch: Throwable -> L23
                MemoryResponse<?> r2 = null;
                if (r6 == null) goto L10;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L23
            L11:
                r15.writeStrongBinder(r3);     // Catch: Throwable -> L23
                if (this.mRemote.transact(6, r15, r7, 0) == false) goto L14;
            L18:
                r7.readException();     // Catch: Throwable -> L23
                if (r7.readInt() == 0) goto L21;
                r2 = MemoryResponse.CREATOR.createFromParcel(r7);     // Catch: Throwable -> L23
            L21:
                r7.recycle();
                r15.recycle();
                return r2;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                MemoryResponse r8 = Stub.getDefaultImpl().registerFeatureDuration(r9, r10, r11, r13, r6);     // Catch: Throwable -> L23
                r7.recycle();
                r15.recycle();
                return r8;
            L10:
                r3 = null;
                goto L11
            L6:
                r1 = 0;
            L23:
                th = move-exception;
                r7.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeatureDuration(String r9, String r10, long r11, boolean r13, IFeatureDurationListener r14) {
                IFeatureDurationListener r6 = (IFeatureDurationListener) ZeusTransformUtils.wrapperContextForParams(r14, IFeatureDurationListener.class, "com.obric.aiagent.plugin");
                Parcel r15 = Parcel.obtain();
                Parcel r7 = Parcel.obtain();
                r15.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                r15.writeString(r9);     // Catch: Throwable -> L23
                r15.writeString(r10);     // Catch: Throwable -> L23
                r15.writeLong(r11);     // Catch: Throwable -> L23
                if (r13 == false) goto L6;
                int r1 = 1;
            L7:
                r15.writeInt(r1);     // Catch: Throwable -> L23
                MemoryResponse<?> r2 = null;
                if (r6 == null) goto L10;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L23
            L11:
                r15.writeStrongBinder(r3);     // Catch: Throwable -> L23
                if (this.mRemote.transact(7, r15, r7, 0) == false) goto L14;
            L18:
                r7.readException();     // Catch: Throwable -> L23
                if (r7.readInt() == 0) goto L21;
                r2 = MemoryResponse.CREATOR.createFromParcel(r7);     // Catch: Throwable -> L23
            L21:
                r7.recycle();
                r15.recycle();
                return r2;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                MemoryResponse r8 = Stub.getDefaultImpl().unregisterFeatureDuration(r9, r10, r11, r13, r6);     // Catch: Throwable -> L23
                r7.recycle();
                r15.recycle();
                return r8;
            L10:
                r3 = null;
                goto L11
            L6:
                r1 = 0;
            L23:
                th = move-exception;
                r7.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse setLocation(String r13, double r14, double r16, String r18, String r19) {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeString(r13);     // Catch: Throwable -> L17
                r1.writeDouble(r14);     // Catch: Throwable -> L17
                r1.writeDouble(r16);     // Catch: Throwable -> L17
                r1.writeString(r18);     // Catch: Throwable -> L17
                r1.writeString(r19);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r1, r2, 0) == false) goto L6;
            L10:
                r2.readException();     // Catch: Throwable -> L17
                if (r2.readInt() == 0) goto L14;
                MemoryResponse<?> r0 = MemoryResponse.CREATOR.createFromParcel(r2);     // Catch: Throwable -> L17
            L15:
                r2.recycle();
                r1.recycle();
                return r0;
            L14:
                r0 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                MemoryResponse r3 = Stub.getDefaultImpl().setLocation(r13, r14, r16, r18, r19);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return r3;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getGeoFenceStatus(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                MemoryResponse<?> r4 = MemoryResponse.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                MemoryResponse r6 = Stub.getDefaultImpl().getGeoFenceStatus(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
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

        public static IContextAwarenessService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IContextAwarenessService.class) == false) goto L13;
            return (IContextAwarenessService) ZeusTransformUtils.preCheckCast(r0, IContextAwarenessService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 != 1598968902) goto L5;
            r13.writeString(DESCRIPTOR);
            return true;
        L5:
            switch(r11) {
                case 1: goto L56;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L36;
                case 6: goto L27;
                case 7: goto L18;
                case 8: goto L13;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r10 = getGeoFenceStatus(r12.readString());
            r13.writeNoException();
            if (r10 == null) goto L11;
            r13.writeInt(1);
            r10.writeToParcel(r13, 1);
        L12:
            return true;
        L11:
            r13.writeInt(0);
            goto L12
        L13:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r15 = setLocation(r12.readString(), r12.readDouble(), r12.readDouble(), r12.readString(), r12.readString());
            r13.writeNoException();
            if (r15 == null) goto L16;
            r13.writeInt(1);
            r15.writeToParcel(r13, 1);
        L17:
            return true;
        L16:
            r13.writeInt(0);
            goto L17
        L18:
            r12.enforceInterface(DESCRIPTOR);
            String r3 = r12.readString();
            String r4 = r12.readString();
            long r5 = r12.readLong();
            if (r12.readInt() == 0) goto L21;
            boolean r7 = true;
        L22:
            MemoryResponse r16 = unregisterFeatureDuration(r3, r4, r5, r7, IFeatureDurationListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r16 == null) goto L25;
            r13.writeInt(1);
            r16.writeToParcel(r13, 1);
        L26:
            return true;
        L25:
            r13.writeInt(0);
            goto L26
        L21:
            r7 = false;
            goto L22
        L27:
            r12.enforceInterface(DESCRIPTOR);
            String r6 = r12.readString();
            String r8 = r12.readString();
            long r9 = r12.readLong();
            if (r12.readInt() == 0) goto L30;
            boolean r17 = true;
        L31:
            MemoryResponse r18 = registerFeatureDuration(r6, r8, r9, r17, IFeatureDurationListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r18 == null) goto L34;
            r13.writeInt(1);
            r18.writeToParcel(r13, 1);
        L35:
            return true;
        L34:
            r13.writeInt(0);
            goto L35
        L30:
            r17 = false;
            goto L31
        L36:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r19 = registerEvent(r12.readString(), IEventChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r19 == null) goto L39;
            r13.writeInt(1);
            r19.writeToParcel(r13, 1);
        L40:
            return true;
        L39:
            r13.writeInt(0);
            goto L40
        L41:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r110 = getLocation(r12.readString());
            r13.writeNoException();
            if (r110 == null) goto L44;
            r13.writeInt(1);
            r110.writeToParcel(r13, 1);
        L45:
            return true;
        L44:
            r13.writeInt(0);
            goto L45
        L46:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r111 = unregisterFeature(r12.readString(), IFeatureChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r111 == null) goto L49;
            r13.writeInt(1);
            r111.writeToParcel(r13, 1);
        L50:
            return true;
        L49:
            r13.writeInt(0);
            goto L50
        L51:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r112 = registerFeature(r12.readString(), IFeatureChangeListener.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            if (r112 == null) goto L54;
            r13.writeInt(1);
            r112.writeToParcel(r13, 1);
        L55:
            return true;
        L54:
            r13.writeInt(0);
            goto L55
        L56:
            r12.enforceInterface(DESCRIPTOR);
            MemoryResponse r113 = getFeature(r12.readString());
            r13.writeNoException();
            if (r113 == null) goto L59;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L60:
            return true;
        L59:
            r13.writeInt(0);
            goto L60
        L7:
            return super.onTransact(r11, r12, r13, r14);
        }

        public static boolean setDefaultImpl(IContextAwarenessService r2) {
            IContextAwarenessService r3 = (IContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, IContextAwarenessService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IContextAwarenessService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    MemoryResponse getFeature(String r1);

    MemoryResponse getGeoFenceStatus(String r1);

    MemoryResponse getLocation(String r1);

    MemoryResponse registerEvent(String r1, IEventChangeListener r2);

    MemoryResponse registerFeature(String r1, IFeatureChangeListener r2);

    MemoryResponse registerFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6);

    MemoryResponse setLocation(String r1, double r2, double r4, String r6, String r7);

    MemoryResponse unregisterFeature(String r1, IFeatureChangeListener r2);

    MemoryResponse unregisterFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6);
}
