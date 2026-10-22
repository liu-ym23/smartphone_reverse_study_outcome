package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentTaskAppIDL extends IInterface {

    public static class Default implements IAgentTaskAppIDL {
        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void addTaskManagerShortcut(PendingIntent r1) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public List<ShortcutRecommendItem> getShortcutRecommendItems(int r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public boolean hasShortcutForMessage(String r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void openEventTaskDetailPage(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void runShortcutTaskFromRecommendPanel(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public boolean shouldShowAddTaskManagerIconGuide() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void testRunConditionTask(String r1, String r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentTaskAppIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentTaskAppIDL";
        static final int TRANSACTION_addTaskManagerShortcut = 3;
        static final int TRANSACTION_getShortcutRecommendItems = 6;
        static final int TRANSACTION_hasShortcutForMessage = 5;
        static final int TRANSACTION_openEventTaskDetailPage = 1;
        static final int TRANSACTION_runShortcutTaskFromRecommendPanel = 7;
        static final int TRANSACTION_shouldShowAddTaskManagerIconGuide = 4;
        static final int TRANSACTION_testRunConditionTask = 2;

        private static class Proxy implements IAgentTaskAppIDL {
            public static IAgentTaskAppIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void openEventTaskDetailPage(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().openEventTaskDetailPage(r4, r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void testRunConditionTask(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().testRunConditionTask(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void addTaskManagerShortcut(PendingIntent r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addTaskManagerShortcut(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public boolean shouldShowAddTaskManagerIconGuide() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().shouldShowAddTaskManagerIconGuide();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public boolean hasShortcutForMessage(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().hasShortcutForMessage(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public List<ShortcutRecommendItem> getShortcutRecommendItems(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(ShortcutRecommendItem.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ShortcutRecommendItem> r6 = Stub.getDefaultImpl().getShortcutRecommendItems(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void runShortcutTaskFromRecommendPanel(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runShortcutTaskFromRecommendPanel(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
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

        public static IAgentTaskAppIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentTaskAppIDL.class) == false) goto L13;
            return (IAgentTaskAppIDL) ZeusTransformUtils.preCheckCast(r0, IAgentTaskAppIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L25;
            switch(r4) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            runShortcutTaskFromRecommendPanel(r5.readString(), r5.readString());
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            List<ShortcutRecommendItem> r3 = getShortcutRecommendItems(r5.readInt());
            r6.writeNoException();
            r6.writeTypedList(r3);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = hasShortcutForMessage(r5.readString());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = shouldShowAddTaskManagerIconGuide();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L18;
            PendingIntent r10 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r5), PendingIntent.class, "com.obric.aiagent.plugin");
        L19:
            addTaskManagerShortcut(r10);
            return true;
        L18:
            r10 = null;
            goto L19
        L21:
            r5.enforceInterface(DESCRIPTOR);
            testRunConditionTask(r5.readString(), r5.readString());
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            openEventTaskDetailPage(r5.readString(), r5.readString());
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L25:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAgentTaskAppIDL r2) {
            IAgentTaskAppIDL r3 = (IAgentTaskAppIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentTaskAppIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentTaskAppIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addTaskManagerShortcut(PendingIntent r1);

    List<ShortcutRecommendItem> getShortcutRecommendItems(int r1);

    boolean hasShortcutForMessage(String r1);

    void openEventTaskDetailPage(String r1, String r2);

    void runShortcutTaskFromRecommendPanel(String r1, String r2);

    boolean shouldShowAddTaskManagerIconGuide();

    void testRunConditionTask(String r1, String r2);
}
