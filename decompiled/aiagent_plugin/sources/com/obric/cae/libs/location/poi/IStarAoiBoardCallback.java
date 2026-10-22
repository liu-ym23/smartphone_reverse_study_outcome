package com.obric.cae.libs.location.poi;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarAoiBoardCallback extends IInterface {
    public static final int AOI_BOARD_EVENT_ENTER = 1;
    public static final int AOI_BOARD_EVENT_EXIT = 2;
    public static final int AOI_BOARD_EVENT_UNKNOWN = 0;

    public static class Default implements IStarAoiBoardCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
        public void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3) {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardCallback";
        static final int TRANSACTION_onAoiBoardBreachReport = 1;

        public static class Proxy implements IStarAoiBoardCallback {
            public static IStarAoiBoardCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardCallback
            public void onAoiBoardBreachReport(AoiBoard r4, Location r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r5 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L10:
                r0.writeInt(r6);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L13;
            L17:
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onAoiBoardBreachReport(r4, r5, r6);     // Catch: Throwable -> L19
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L19
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarAoiBoardCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IStarAoiBoardCallback.class) == false) goto L13;
            return (IStarAoiBoardCallback) ZeusTransformUtils.preCheckCast(r0, IStarAoiBoardCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IStarAoiBoardCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarAoiBoardCallback r2) {
            IStarAoiBoardCallback r3 = (IStarAoiBoardCallback) ZeusTransformUtils.wrapperContextForParams(r2, IStarAoiBoardCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            Location r8 = null;
            if (r5.readInt() == 0) goto L13;
            AoiBoard r9 = (AoiBoard) ZeusTransformUtils.preCheckCast(AoiBoard.CREATOR.createFromParcel(r5), AoiBoard.class, "com.obric.aiagent.plugin");
        L15:
            if (r5.readInt() == 0) goto L17;
            r8 = (Location) ZeusTransformUtils.preCheckCast(Location.CREATOR.createFromParcel(r5), Location.class, "com.obric.aiagent.plugin");
        L17:
            onAoiBoardBreachReport(r9, r8, r5.readInt());
            return true;
        L13:
            r9 = null;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onAoiBoardBreachReport(AoiBoard r1, Location r2, int r3);
}
