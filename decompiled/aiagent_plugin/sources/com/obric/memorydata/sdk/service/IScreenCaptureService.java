package com.obric.memorydata.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.screencapture.ICaptureCurrentCallback;
import com.obric.memorydata.sdk.screencapture.IEventReactionCallback;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IScreenCaptureService extends IInterface {

    public static class Default implements IScreenCaptureService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void captureCurrent(TaskOptions r1, String r2, ICaptureCurrentCallback r3) {
            ICaptureCurrentCallback r0 = (ICaptureCurrentCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICaptureCurrentCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public int getScreenEventReactionCount() {
            return 0;
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void register(ScreenEventReaction r1, long r2, IEventReactionCallback r4) {
            IEventReactionCallback r0 = (IEventReactionCallback) ZeusTransformUtils.wrapperContextForParams(r4, IEventReactionCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
        public void unregister(String r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IScreenCaptureService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.service.IScreenCaptureService";
        static final int TRANSACTION_captureCurrent = 4;
        static final int TRANSACTION_getScreenEventReactionCount = 3;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_unregister = 2;

        private static class Proxy implements IScreenCaptureService {
            public static IScreenCaptureService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void register(ScreenEventReaction r6, long r7, IEventReactionCallback r9) {
                IEventReactionCallback r10 = (IEventReactionCallback) ZeusTransformUtils.wrapperContextForParams(r9, IEventReactionCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeLong(r7);     // Catch: Throwable -> L21
                if (r10 == null) goto L10;
                IBinder r4 = r10.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L21
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().register(r6, r7, r10);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r4 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void unregister(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregister(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public int getScreenEventReactionCount() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getScreenEventReactionCount();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.service.IScreenCaptureService
            public void captureCurrent(TaskOptions r5, String r6, ICaptureCurrentCallback r7) {
                ICaptureCurrentCallback r8 = (ICaptureCurrentCallback) ZeusTransformUtils.wrapperContextForParams(r7, ICaptureCurrentCallback.class, "com.obric.aiagent.plugin");
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
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().captureCurrent(r5, r6, r8);     // Catch: Throwable -> L21
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IScreenCaptureService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IScreenCaptureService.class) == false) goto L13;
            return (IScreenCaptureService) ZeusTransformUtils.preCheckCast(r0, IScreenCaptureService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            ScreenEventReaction r1 = null;
            TaskOptions r2 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L28;
            r1 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(ScreenEventReaction.CREATOR.createFromParcel(r7), ScreenEventReaction.class, "com.obric.aiagent.plugin");
        L28:
            register(r1, r7.readLong(), IEventReactionCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            unregister(r7.readString());
            r8.writeNoException();
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            int r5 = getScreenEventReactionCount();
            r8.writeNoException();
            r8.writeInt(r5);
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L19;
            r2 = (TaskOptions) ZeusTransformUtils.preCheckCast(TaskOptions.CREATOR.createFromParcel(r7), TaskOptions.class, "com.obric.aiagent.plugin");
        L19:
            captureCurrent(r2, r7.readString(), ICaptureCurrentCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IScreenCaptureService r2) {
            IScreenCaptureService r3 = (IScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r2, IScreenCaptureService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IScreenCaptureService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void captureCurrent(TaskOptions r1, String r2, ICaptureCurrentCallback r3);

    int getScreenEventReactionCount();

    void register(ScreenEventReaction r1, long r2, IEventReactionCallback r4);

    void unregister(String r1);
}
