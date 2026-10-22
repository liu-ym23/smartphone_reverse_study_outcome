package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowVoiceInteractionIDL extends IInterface {

    public static class Default implements IFlowVoiceInteractionIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean closeContinuousTalk() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean isInRealtimeCalling() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean isInteractionSessionStateListening() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void readContent(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void readContentByMessage(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void replayMessageTts(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void requireSyncData(IFlowSyncDataResultIDL r2) {
            IFlowSyncDataResultIDL r1 = (IFlowSyncDataResultIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean tryInterruptAssistant(AppEvent r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void tryOpenClickTalk(int r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean tryOpenMicToRecording(AppEvent r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void updateIntentExt(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void updateScreenshotForAsr(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void wakeupAssistant(String r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowVoiceInteractionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL";
        static final int TRANSACTION_closeContinuousTalk = 13;
        static final int TRANSACTION_isInRealtimeCalling = 5;
        static final int TRANSACTION_isInteractionSessionStateListening = 12;
        static final int TRANSACTION_readContent = 4;
        static final int TRANSACTION_readContentByMessage = 6;
        static final int TRANSACTION_replayMessageTts = 3;
        static final int TRANSACTION_requireSyncData = 2;
        static final int TRANSACTION_tryInterruptAssistant = 8;
        static final int TRANSACTION_tryOpenClickTalk = 7;
        static final int TRANSACTION_tryOpenMicToRecording = 9;
        static final int TRANSACTION_updateIntentExt = 11;
        static final int TRANSACTION_updateScreenshotForAsr = 10;
        static final int TRANSACTION_wakeupAssistant = 1;

        private static class Proxy implements IFlowVoiceInteractionIDL {
            public static IFlowVoiceInteractionIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void wakeupAssistant(String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().wakeupAssistant(r4);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void requireSyncData(IFlowSyncDataResultIDL r5) {
                IFlowSyncDataResultIDL r6 = (IFlowSyncDataResultIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requireSyncData(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void replayMessageTts(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().replayMessageTts(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void readContent(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().readContent(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean isInRealtimeCalling() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isInRealtimeCalling();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void readContentByMessage(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().readContentByMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void tryOpenClickTalk(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().tryOpenClickTalk(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean tryInterruptAssistant(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().tryInterruptAssistant(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean tryOpenMicToRecording(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().tryOpenMicToRecording(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void updateScreenshotForAsr(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateScreenshotForAsr(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void updateIntentExt(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeMap(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateIntentExt(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean isInteractionSessionStateListening() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isInteractionSessionStateListening();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean closeContinuousTalk() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().closeContinuousTalk();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
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

        public static IFlowVoiceInteractionIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowVoiceInteractionIDL.class) == false) goto L13;
            return (IFlowVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(r0, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L43;
            IMMessage r0 = null;
            AppEvent r1 = null;
            AppEvent r2 = null;
            switch(r4) {
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L26;
                case 8: goto L21;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = closeContinuousTalk();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = isInteractionSessionStateListening();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            updateIntentExt(r5.readHashMap(getClass().getClassLoader()));
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            updateScreenshotForAsr(r5.readString());
            return true;
        L16:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L19;
            r1 = AppEvent.CREATOR.createFromParcel(r5);
        L19:
            boolean r9 = tryOpenMicToRecording(r1);
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L24;
            r2 = AppEvent.CREATOR.createFromParcel(r5);
        L24:
            boolean r10 = tryInterruptAssistant(r2);
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            return true;
        L26:
            r5.enforceInterface(DESCRIPTOR);
            tryOpenClickTalk(r5.readInt());
            return true;
        L28:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L31;
            r0 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r5), IMMessage.class, "com.obric.aiagent.plugin");
        L31:
            readContentByMessage(r0);
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            boolean r11 = isInRealtimeCalling();
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            readContent(r5.readString());
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            replayMessageTts(r5.readString());
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            requireSyncData(IFlowSyncDataResultIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            wakeupAssistant(r5.readString());
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L43:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowVoiceInteractionIDL r2) {
            IFlowVoiceInteractionIDL r3 = (IFlowVoiceInteractionIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowVoiceInteractionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean closeContinuousTalk();

    boolean isInRealtimeCalling();

    boolean isInteractionSessionStateListening();

    void readContent(String r1);

    void readContentByMessage(IMMessage r1);

    void replayMessageTts(String r1);

    void requireSyncData(IFlowSyncDataResultIDL r1);

    boolean tryInterruptAssistant(AppEvent r1);

    void tryOpenClickTalk(int r1);

    boolean tryOpenMicToRecording(AppEvent r1);

    void updateIntentExt(Map r1);

    void updateScreenshotForAsr(String r1);

    void wakeupAssistant(String r1);
}
