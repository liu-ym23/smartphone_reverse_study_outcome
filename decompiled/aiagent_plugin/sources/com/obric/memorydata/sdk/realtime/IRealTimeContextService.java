package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IRealTimeContextService extends IInterface {

    public static class Default implements IRealTimeContextService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssist(AssistStructure r1, List<AppEntity> r2) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssistWithCallback(AssistStructure r1, List<AppEntity> r2, IRealTimeContextCallback r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            IRealTimeContextCallback r4 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r3, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleScreenshot(Bitmap r1) {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public RealTimeContextResult queryRealTimeContext(String r1, String r2, String r3) {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeContextService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextService";
        static final int TRANSACTION_onHandleAssist = 1;
        static final int TRANSACTION_onHandleAssistWithCallback = 4;
        static final int TRANSACTION_onHandleScreenshot = 2;
        static final int TRANSACTION_queryRealTimeContext = 3;

        private static class Proxy implements IRealTimeContextService {
            public static IRealTimeContextService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssist(AssistStructure r4, List<AppEntity> r5) {
                List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeTypedList(r6);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleAssist(r4, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleScreenshot(Bitmap r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public RealTimeContextResult queryRealTimeContext(String r5, String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                RealTimeContextResult r4 = (RealTimeContextResult) ZeusTransformUtils.preCheckCast(RealTimeContextResult.CREATOR.createFromParcel(r1), RealTimeContextResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                RealTimeContextResult r8 = Stub.getDefaultImpl().queryRealTimeContext(r5, r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
            public void onHandleAssistWithCallback(AssistStructure r5, List<AppEntity> r6, IRealTimeContextCallback r7) {
                List<AppEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
                IRealTimeContextCallback r9 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r7, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                r0.writeTypedList(r8);     // Catch: Throwable -> L20
                if (r9 == null) goto L10;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onHandleAssistWithCallback(r5, r8, r9);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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

        public static IRealTimeContextService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IRealTimeContextService.class) == false) goto L13;
            return (IRealTimeContextService) ZeusTransformUtils.preCheckCast(r0, IRealTimeContextService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            AssistStructure r1 = null;
            AssistStructure r2 = null;
            Bitmap r3 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L34;
            r1 = (AssistStructure) ZeusTransformUtils.preCheckCast(AssistStructure.CREATOR.createFromParcel(r7), AssistStructure.class, "com.obric.aiagent.plugin");
        L34:
            onHandleAssist(r1, r7.createTypedArrayList(AppEntity.CREATOR));
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L29;
            r3 = (Bitmap) ZeusTransformUtils.preCheckCast(Bitmap.CREATOR.createFromParcel(r7), Bitmap.class, "com.obric.aiagent.plugin");
        L29:
            onHandleScreenshot(r3);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            RealTimeContextResult r5 = queryRealTimeContext(r7.readString(), r7.readString(), r7.readString());
            r8.writeNoException();
            if (r5 == null) goto L24;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L25:
            return true;
        L24:
            r8.writeInt(0);
            goto L25
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L19;
            r2 = (AssistStructure) ZeusTransformUtils.preCheckCast(AssistStructure.CREATOR.createFromParcel(r7), AssistStructure.class, "com.obric.aiagent.plugin");
        L19:
            onHandleAssistWithCallback(r2, r7.createTypedArrayList(AppEntity.CREATOR), IRealTimeContextCallback.Stub.asInterface(r7.readStrongBinder()));
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IRealTimeContextService r2) {
            IRealTimeContextService r3 = (IRealTimeContextService) ZeusTransformUtils.wrapperContextForParams(r2, IRealTimeContextService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IRealTimeContextService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onHandleAssist(AssistStructure r1, List<AppEntity> r2);

    void onHandleAssistWithCallback(AssistStructure r1, List<AppEntity> r2, IRealTimeContextCallback r3);

    void onHandleScreenshot(Bitmap r1);

    RealTimeContextResult queryRealTimeContext(String r1, String r2, String r3);
}
