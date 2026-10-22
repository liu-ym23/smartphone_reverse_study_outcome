package android.cypress.mediacontext;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface ICypressMediaContext extends IInterface {

    public static class Default implements ICypressMediaContext {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.cypress.mediacontext.ICypressMediaContext
        public int getCurrentMediaSessionData(MediaSessionData r1) {
            return 0;
        }

        @Override // android.cypress.mediacontext.ICypressMediaContext
        public int getMediaSessionHistory(long r1, MediaSessionHistoryData r3) {
            return 0;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICypressMediaContext {
        private static final String DESCRIPTOR = "android.cypress.mediacontext.ICypressMediaContext";
        static final int TRANSACTION_getCurrentMediaSessionData = 1;
        static final int TRANSACTION_getMediaSessionHistory = 2;

        private static class Proxy implements ICypressMediaContext {
            public static ICypressMediaContext sDefaultImpl;
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

            @Override // android.cypress.mediacontext.ICypressMediaContext
            public int getCurrentMediaSessionData(MediaSessionData r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                int r4 = r1.readInt();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r5.readFromParcel(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getCurrentMediaSessionData(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r6;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.cypress.mediacontext.ICypressMediaContext
            public int getMediaSessionHistory(long r5, MediaSessionHistoryData r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                int r4 = r1.readInt();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r7.readFromParcel(r1);     // Catch: Throwable -> L15
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getMediaSessionHistory(r5, r7);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r6;
            L15:
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

        public static ICypressMediaContext asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICypressMediaContext.class) == false) goto L13;
            return (ICypressMediaContext) ZeusTransformUtils.preCheckCast(r0, ICypressMediaContext.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            MediaSessionData r8 = new MediaSessionData();
            int r3 = getCurrentMediaSessionData(r8);
            r6.writeNoException();
            r6.writeInt(r3);
            r6.writeInt(1);
            r8.writeToParcel(r6, 1);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            long r9 = r5.readLong();
            MediaSessionHistoryData r10 = new MediaSessionHistoryData();
            int r11 = getMediaSessionHistory(r9, r10);
            r6.writeNoException();
            r6.writeInt(r11);
            r6.writeInt(1);
            r10.writeToParcel(r6, 1);
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(ICypressMediaContext r2) {
            ICypressMediaContext r3 = (ICypressMediaContext) ZeusTransformUtils.wrapperContextForParams(r2, ICypressMediaContext.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static ICypressMediaContext getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int getCurrentMediaSessionData(MediaSessionData r1);

    int getMediaSessionHistory(long r1, MediaSessionHistoryData r3);
}
