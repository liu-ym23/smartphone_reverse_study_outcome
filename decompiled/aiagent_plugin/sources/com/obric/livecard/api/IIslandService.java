package com.obric.livecard.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IIslandService extends IInterface {

    public static class Default implements IIslandService {
        @Override // com.obric.livecard.api.IIslandService
        public void addIIslandStatusCallback(IIslandStatusCallback r2) {
            IIslandStatusCallback r1 = (IIslandStatusCallback) ZeusTransformUtils.wrapperContextForParams(r2, IIslandStatusCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.livecard.api.IIslandService
        public void addOnTopCardChangedListener(ITopSessionChangedCallback r2) {
            ITopSessionChangedCallback r1 = (ITopSessionChangedCallback) ZeusTransformUtils.wrapperContextForParams(r2, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public void createSession(IslandSession r1, String r2, IIslandCardCallback r3) {
            IIslandCardCallback r0 = (IIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r3, IIslandCardCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.livecard.api.IIslandService
        public void destroySession(IslandSession r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void doCollapse() {
        }

        @Override // com.obric.livecard.api.IIslandService
        public Bundle getIslandVersion() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public Bundle getPriority(IslandSession r1) {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onLauncherFocused() {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onNotificationVisible(boolean r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onSysUIFlagsChanged(long r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onVolumeButtonClick() {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void removeIIslandStatusCallback(IIslandStatusCallback r2) {
            IIslandStatusCallback r1 = (IIslandStatusCallback) ZeusTransformUtils.wrapperContextForParams(r2, IIslandStatusCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.livecard.api.IIslandService
        public void removeOnTopCardChangedListener(ITopSessionChangedCallback r2) {
            ITopSessionChangedCallback r1 = (ITopSessionChangedCallback) ZeusTransformUtils.wrapperContextForParams(r2, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.livecard.api.IIslandService
        public void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setKeyguardLocked(boolean r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setPriority(IslandSession r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setVisible(boolean r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void tryExpand(IslandSession r1, boolean r2) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateSessionFlags(IslandSession r1) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateWidget(IslandSession r1, IslandWidget r2) {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateWidgetAnimation(IslandSession r1, IslandWidget r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IIslandService {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandService";
        static final int TRANSACTION_addIIslandStatusCallback = 8;
        static final int TRANSACTION_addOnTopCardChangedListener = 18;
        static final int TRANSACTION_createSession = 1;
        static final int TRANSACTION_destroySession = 2;
        static final int TRANSACTION_doCollapse = 7;
        static final int TRANSACTION_getIslandVersion = 16;
        static final int TRANSACTION_getPriority = 20;
        static final int TRANSACTION_onLauncherFocused = 11;
        static final int TRANSACTION_onNotificationVisible = 13;
        static final int TRANSACTION_onSysUIFlagsChanged = 15;
        static final int TRANSACTION_onVolumeButtonClick = 10;
        static final int TRANSACTION_removeIIslandStatusCallback = 9;
        static final int TRANSACTION_removeOnTopCardChangedListener = 19;
        static final int TRANSACTION_sendEvent = 5;
        static final int TRANSACTION_setKeyguardLocked = 12;
        static final int TRANSACTION_setPriority = 21;
        static final int TRANSACTION_setVisible = 6;
        static final int TRANSACTION_tryExpand = 14;
        static final int TRANSACTION_updateSessionFlags = 17;
        static final int TRANSACTION_updateWidget = 3;
        static final int TRANSACTION_updateWidgetAnimation = 4;

        private static class Proxy implements IIslandService {
            public static IIslandService sDefaultImpl;
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

            @Override // com.obric.livecard.api.IIslandService
            public void createSession(IslandSession r6, String r7, IIslandCardCallback r8) {
                IIslandCardCallback r9 = (IIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r8, IIslandCardCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L23
                if (r9 == null) goto L10;
                IBinder r4 = r9.asBinder();     // Catch: Throwable -> L23
            L11:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L23
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() == 0) goto L21;
                r6.readFromParcel(r1);     // Catch: Throwable -> L23
            L21:
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().createSession(r6, r7, r9);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r4 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void destroySession(IslandSession r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r5.readFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().destroySession(r5);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidget(IslandSession r5, IslandWidget r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidget(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidgetAnimation(IslandSession r5, IslandWidget r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidgetAnimation(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void sendEvent(IslandSession r5, IslandWidget r6, String r7, String r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L10:
                r0.writeString(r7);     // Catch: Throwable -> L20
                r0.writeString(r8);     // Catch: Throwable -> L20
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().sendEvent(r5, r6, r7, r8);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setVisible(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setVisible(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void doCollapse() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().doCollapse();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void addIIslandStatusCallback(IIslandStatusCallback r5) {
                IIslandStatusCallback r6 = (IIslandStatusCallback) ZeusTransformUtils.wrapperContextForParams(r5, IIslandStatusCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addIIslandStatusCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeIIslandStatusCallback(IIslandStatusCallback r5) {
                IIslandStatusCallback r6 = (IIslandStatusCallback) ZeusTransformUtils.wrapperContextForParams(r5, IIslandStatusCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeIIslandStatusCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onVolumeButtonClick() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onVolumeButtonClick();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onLauncherFocused() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onLauncherFocused();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setKeyguardLocked(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setKeyguardLocked(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onNotificationVisible(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onNotificationVisible(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void tryExpand(IslandSession r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                int r2 = 1;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == true) goto L10;
                r2 = 0;
            L10:
                r0.writeInt(r2);     // Catch: Throwable -> L20
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().tryExpand(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onSysUIFlagsChanged(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSysUIFlagsChanged(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getIslandVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r5 = Stub.getDefaultImpl().getIslandVersion();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateSessionFlags(IslandSession r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateSessionFlags(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void addOnTopCardChangedListener(ITopSessionChangedCallback r5) {
                ITopSessionChangedCallback r6 = (ITopSessionChangedCallback) ZeusTransformUtils.wrapperContextForParams(r5, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addOnTopCardChangedListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeOnTopCardChangedListener(ITopSessionChangedCallback r5) {
                ITopSessionChangedCallback r6 = (ITopSessionChangedCallback) ZeusTransformUtils.wrapperContextForParams(r5, ITopSessionChangedCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeOnTopCardChangedListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getPriority(IslandSession r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().getPriority(r5);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setPriority(IslandSession r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setPriority(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
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

        public static IIslandService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IIslandService.class) == false) goto L13;
            return (IIslandService) ZeusTransformUtils.preCheckCast(r0, IIslandService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L113;
            boolean r0 = false;
            IslandSession r3 = null;
            IslandSession r4 = null;
            IslandSession r9 = null;
            IslandSession r10 = null;
            IslandSession r11 = null;
            IslandWidget r12 = null;
            IslandWidget r13 = null;
            IslandWidget r14 = null;
            IslandSession r15 = null;
            switch(r5) {
                case 1: goto L105;
                case 2: goto L97;
                case 3: goto L88;
                case 4: goto L79;
                case 5: goto L70;
                case 6: goto L65;
                case 7: goto L63;
                case 8: goto L61;
                case 9: goto L59;
                case 10: goto L57;
                case 11: goto L55;
                case 12: goto L50;
                case 13: goto L45;
                case 14: goto L37;
                case 15: goto L35;
                case 16: goto L30;
                case 17: goto L25;
                case 18: goto L23;
                case 19: goto L21;
                case 20: goto L13;
                case 21: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L11;
            r4 = IslandSession.CREATOR.createFromParcel(r6);
        L11:
            setPriority(r4);
            r7.writeNoException();
            return true;
        L13:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L16;
            r9 = IslandSession.CREATOR.createFromParcel(r6);
        L16:
            Bundle r16 = getPriority(r9);
            r7.writeNoException();
            if (r16 == null) goto L19;
            r7.writeInt(1);
            r16.writeToParcel(r7, 1);
        L20:
            return true;
        L19:
            r7.writeInt(0);
            goto L20
        L21:
            r6.enforceInterface(DESCRIPTOR);
            removeOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L23:
            r6.enforceInterface(DESCRIPTOR);
            addOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L25:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L28;
            r10 = IslandSession.CREATOR.createFromParcel(r6);
        L28:
            updateSessionFlags(r10);
            r7.writeNoException();
            return true;
        L30:
            r6.enforceInterface(DESCRIPTOR);
            Bundle r17 = getIslandVersion();
            r7.writeNoException();
            if (r17 == null) goto L33;
            r7.writeInt(1);
            r17.writeToParcel(r7, 1);
        L34:
            return true;
        L33:
            r7.writeInt(0);
            goto L34
        L35:
            r6.enforceInterface(DESCRIPTOR);
            onSysUIFlagsChanged(r6.readLong());
            r7.writeNoException();
            return true;
        L37:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L41;
            r11 = IslandSession.CREATOR.createFromParcel(r6);
        L41:
            if (r6.readInt() == 0) goto L43;
            r0 = true;
        L43:
            tryExpand(r11, r0);
            r7.writeNoException();
            return true;
        L45:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L48;
            r0 = true;
        L48:
            onNotificationVisible(r0);
            r7.writeNoException();
            return true;
        L50:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L53;
            r0 = true;
        L53:
            setKeyguardLocked(r0);
            r7.writeNoException();
            return true;
        L55:
            r6.enforceInterface(DESCRIPTOR);
            onLauncherFocused();
            r7.writeNoException();
            return true;
        L57:
            r6.enforceInterface(DESCRIPTOR);
            onVolumeButtonClick();
            r7.writeNoException();
            return true;
        L59:
            r6.enforceInterface(DESCRIPTOR);
            removeIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L61:
            r6.enforceInterface(DESCRIPTOR);
            addIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L63:
            r6.enforceInterface(DESCRIPTOR);
            doCollapse();
            r7.writeNoException();
            return true;
        L65:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L68;
            r0 = true;
        L68:
            setVisible(r0);
            r7.writeNoException();
            return true;
        L70:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L73;
            IslandSession r18 = IslandSession.CREATOR.createFromParcel(r6);
        L75:
            if (r6.readInt() == 0) goto L77;
            r12 = IslandWidget.CREATOR.createFromParcel(r6);
        L77:
            sendEvent(r18, r12, r6.readString(), r6.readString());
            r7.writeNoException();
            return true;
        L73:
            r18 = null;
            goto L75
        L79:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L82;
            IslandSession r19 = IslandSession.CREATOR.createFromParcel(r6);
        L84:
            if (r6.readInt() == 0) goto L86;
            r13 = IslandWidget.CREATOR.createFromParcel(r6);
        L86:
            updateWidgetAnimation(r19, r13);
            r7.writeNoException();
            return true;
        L82:
            r19 = null;
            goto L84
        L88:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L91;
            IslandSession r20 = IslandSession.CREATOR.createFromParcel(r6);
        L93:
            if (r6.readInt() == 0) goto L95;
            r14 = IslandWidget.CREATOR.createFromParcel(r6);
        L95:
            updateWidget(r20, r14);
            r7.writeNoException();
            return true;
        L91:
            r20 = null;
            goto L93
        L97:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L100;
            r15 = IslandSession.CREATOR.createFromParcel(r6);
        L100:
            destroySession(r15);
            r7.writeNoException();
            if (r15 == null) goto L103;
            r7.writeInt(1);
            r15.writeToParcel(r7, 1);
        L104:
            return true;
        L103:
            r7.writeInt(0);
            goto L104
        L105:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L108;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L108:
            createSession(r3, r6.readString(), IIslandCardCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            if (r3 == null) goto L111;
            r7.writeInt(1);
            r3.writeToParcel(r7, 1);
        L112:
            return true;
        L111:
            r7.writeInt(0);
            goto L112
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L113:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IIslandService r2) {
            IIslandService r3 = (IIslandService) ZeusTransformUtils.wrapperContextForParams(r2, IIslandService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IIslandService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addIIslandStatusCallback(IIslandStatusCallback r1);

    void addOnTopCardChangedListener(ITopSessionChangedCallback r1);

    void createSession(IslandSession r1, String r2, IIslandCardCallback r3);

    void destroySession(IslandSession r1);

    void doCollapse();

    Bundle getIslandVersion();

    Bundle getPriority(IslandSession r1);

    void onLauncherFocused();

    void onNotificationVisible(boolean r1);

    void onSysUIFlagsChanged(long r1);

    void onVolumeButtonClick();

    void removeIIslandStatusCallback(IIslandStatusCallback r1);

    void removeOnTopCardChangedListener(ITopSessionChangedCallback r1);

    void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4);

    void setKeyguardLocked(boolean r1);

    void setPriority(IslandSession r1);

    void setVisible(boolean r1);

    void tryExpand(IslandSession r1, boolean r2);

    void updateSessionFlags(IslandSession r1);

    void updateWidget(IslandSession r1, IslandWidget r2);

    void updateWidgetAnimation(IslandSession r1, IslandWidget r2);
}
