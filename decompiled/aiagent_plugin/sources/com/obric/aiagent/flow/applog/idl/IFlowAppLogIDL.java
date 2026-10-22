package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowAppLogIDL extends IInterface {

    public static class Default implements IFlowAppLogIDL {
        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addDataObserver(IFlowAppLogDataObserverIDL r2) {
            IFlowAppLogDataObserverIDL r1 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addEventObserver(IFlowAppLogEventObserverIDL r2) {
            IFlowAppLogEventObserverIDL r1 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addSessionHook(IFlowAppLogSessionObserverIDL r2) {
            IFlowAppLogSessionObserverIDL r1 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void clearLaunchService() {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getDid() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getIid() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getSsid() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getUserID() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getUserUniqueID() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3(String r1) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3Bundle(String r1, Bundle r2) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3Json(String r1, String r2) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onPause() {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onResume(String r1, int r2) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onStop() {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeDataObserver(IFlowAppLogDataObserverIDL r2) {
            IFlowAppLogDataObserverIDL r1 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeEventObserver(IFlowAppLogEventObserverIDL r2) {
            IFlowAppLogEventObserverIDL r1 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeSessionHook(IFlowAppLogSessionObserverIDL r2) {
            IFlowAppLogSessionObserverIDL r1 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void setHeaderInfo(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void setLaunchService(String r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppLogIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL";
        static final int TRANSACTION_addDataObserver = 9;
        static final int TRANSACTION_addEventObserver = 7;
        static final int TRANSACTION_addSessionHook = 5;
        static final int TRANSACTION_clearLaunchService = 15;
        static final int TRANSACTION_getDid = 16;
        static final int TRANSACTION_getIid = 17;
        static final int TRANSACTION_getSsid = 18;
        static final int TRANSACTION_getUserID = 20;
        static final int TRANSACTION_getUserUniqueID = 19;
        static final int TRANSACTION_onEventV3 = 2;
        static final int TRANSACTION_onEventV3Bundle = 4;
        static final int TRANSACTION_onEventV3Json = 3;
        static final int TRANSACTION_onPause = 12;
        static final int TRANSACTION_onResume = 11;
        static final int TRANSACTION_onStop = 13;
        static final int TRANSACTION_removeDataObserver = 10;
        static final int TRANSACTION_removeEventObserver = 8;
        static final int TRANSACTION_removeSessionHook = 6;
        static final int TRANSACTION_setHeaderInfo = 1;
        static final int TRANSACTION_setLaunchService = 14;

        private static class Proxy implements IFlowAppLogIDL {
            public static IFlowAppLogIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void setHeaderInfo(Map r4) {
                Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeMap(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHeaderInfo(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3Json(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3Json(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3Bundle(String r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventV3Bundle(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addSessionHook(IFlowAppLogSessionObserverIDL r5) {
                IFlowAppLogSessionObserverIDL r6 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addSessionHook(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeSessionHook(IFlowAppLogSessionObserverIDL r5) {
                IFlowAppLogSessionObserverIDL r6 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeSessionHook(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addEventObserver(IFlowAppLogEventObserverIDL r5) {
                IFlowAppLogEventObserverIDL r6 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addEventObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeEventObserver(IFlowAppLogEventObserverIDL r5) {
                IFlowAppLogEventObserverIDL r6 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeEventObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addDataObserver(IFlowAppLogDataObserverIDL r5) {
                IFlowAppLogDataObserverIDL r6 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDataObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeDataObserver(IFlowAppLogDataObserverIDL r5) {
                IFlowAppLogDataObserverIDL r6 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
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
                Stub.getDefaultImpl().removeDataObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onResume(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onResume(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onPause() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPause();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onStop() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStop();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void setLaunchService(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLaunchService(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void clearLaunchService() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(15, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearLaunchService();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getDid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getDid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getIid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getIid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getSsid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getSsid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getUserUniqueID() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getUserUniqueID();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getUserID() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getUserID();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowAppLogIDL.class) == false) goto L13;
            return (IFlowAppLogIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L51;
            switch(r4) {
                case 1: goto L49;
                case 2: goto L47;
                case 3: goto L45;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                case 7: goto L33;
                case 8: goto L31;
                case 9: goto L29;
                case 10: goto L27;
                case 11: goto L25;
                case 12: goto L23;
                case 13: goto L21;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L11;
                case 19: goto L9;
                case 20: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            String r3 = getUserID();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            String r8 = getUserUniqueID();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            String r9 = getSsid();
            r6.writeNoException();
            r6.writeString(r9);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            String r10 = getIid();
            r6.writeNoException();
            r6.writeString(r10);
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            String r11 = getDid();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            clearLaunchService();
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            setLaunchService(r5.readString());
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            onStop();
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            onPause();
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            onResume(r5.readString(), r5.readInt());
            return true;
        L27:
            r5.enforceInterface(DESCRIPTOR);
            removeDataObserver(IFlowAppLogDataObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L29:
            r5.enforceInterface(DESCRIPTOR);
            addDataObserver(IFlowAppLogDataObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L31:
            r5.enforceInterface(DESCRIPTOR);
            removeEventObserver(IFlowAppLogEventObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            addEventObserver(IFlowAppLogEventObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            removeSessionHook(IFlowAppLogSessionObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            addSessionHook(IFlowAppLogSessionObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            String r12 = r5.readString();
            if (r5.readInt() == 0) goto L42;
            Bundle r13 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.aiagent.plugin");
        L43:
            onEventV3Bundle(r12, r13);
            return true;
        L42:
            r13 = null;
            goto L43
        L45:
            r5.enforceInterface(DESCRIPTOR);
            onEventV3Json(r5.readString(), r5.readString());
            return true;
        L47:
            r5.enforceInterface(DESCRIPTOR);
            onEventV3(r5.readString());
            return true;
        L49:
            r5.enforceInterface(DESCRIPTOR);
            setHeaderInfo(r5.readHashMap(getClass().getClassLoader()));
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L51:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowAppLogIDL r2) {
            IFlowAppLogIDL r3 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowAppLogIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addDataObserver(IFlowAppLogDataObserverIDL r1);

    void addEventObserver(IFlowAppLogEventObserverIDL r1);

    void addSessionHook(IFlowAppLogSessionObserverIDL r1);

    void clearLaunchService();

    String getDid();

    String getIid();

    String getSsid();

    String getUserID();

    String getUserUniqueID();

    void onEventV3(String r1);

    void onEventV3Bundle(String r1, Bundle r2);

    void onEventV3Json(String r1, String r2);

    void onPause();

    void onResume(String r1, int r2);

    void onStop();

    void removeDataObserver(IFlowAppLogDataObserverIDL r1);

    void removeEventObserver(IFlowAppLogEventObserverIDL r1);

    void removeSessionHook(IFlowAppLogSessionObserverIDL r1);

    void setHeaderInfo(Map r1);

    void setLaunchService(String r1);
}
