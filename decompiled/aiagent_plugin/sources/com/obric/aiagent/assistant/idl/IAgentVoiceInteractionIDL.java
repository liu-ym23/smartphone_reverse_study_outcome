package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentVoiceInteractionIDL extends IInterface {

    public static class Default implements IAgentVoiceInteractionIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public PersonalContextInfo getUserRecentData() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onAsrEnd() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onAsrStart(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHandleAssist(AssistStructure r1, AssistContent r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHandleScreenshot(Bitmap r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHide() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onQueryAudioFile(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onShow(Bundle r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onStartChatWindow(int r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentVoiceInteractionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL";
        static final int TRANSACTION_getUserRecentData = 8;
        static final int TRANSACTION_onAsrEnd = 7;
        static final int TRANSACTION_onAsrStart = 6;
        static final int TRANSACTION_onHandleAssist = 3;
        static final int TRANSACTION_onHandleScreenshot = 4;
        static final int TRANSACTION_onHide = 2;
        static final int TRANSACTION_onQueryAudioFile = 9;
        static final int TRANSACTION_onShow = 1;
        static final int TRANSACTION_onStartChatWindow = 5;

        private static class Proxy implements IAgentVoiceInteractionIDL {
            public static IAgentVoiceInteractionIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onShow(Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onShow(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHide() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHide();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHandleAssist(AssistStructure r5, AssistContent r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L11:
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L13;
            L17:
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onHandleAssist(r5, r6);     // Catch: Throwable -> L19
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L19
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHandleScreenshot(Bitmap r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onStartChatWindow(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStartChatWindow(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onAsrStart(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAsrStart(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onAsrEnd() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAsrEnd();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public PersonalContextInfo getUserRecentData() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                PersonalContextInfo r4 = (PersonalContextInfo) ZeusTransformUtils.preCheckCast(PersonalContextInfo.CREATOR.createFromParcel(r1), PersonalContextInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                PersonalContextInfo r5 = Stub.getDefaultImpl().getUserRecentData();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onQueryAudioFile(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onQueryAudioFile(r5, r6);     // Catch: Throwable -> L12
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

        public static IAgentVoiceInteractionIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentVoiceInteractionIDL.class) == false) goto L13;
            return (IAgentVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(r0, IAgentVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L42;
            Bundle r3 = null;
            Bitmap r4 = null;
            AssistContent r9 = null;
            switch(r5) {
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L26;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L10;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            onQueryAudioFile(r6.readString(), r6.readString());
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            PersonalContextInfo r10 = getUserRecentData();
            r7.writeNoException();
            if (r10 == null) goto L13;
            r7.writeInt(1);
            r10.writeToParcel(r7, 1);
        L14:
            return true;
        L13:
            r7.writeInt(0);
            goto L14
        L15:
            r6.enforceInterface(DESCRIPTOR);
            onAsrEnd();
            return true;
        L17:
            r6.enforceInterface(DESCRIPTOR);
            onAsrStart(r6.readString());
            return true;
        L19:
            r6.enforceInterface(DESCRIPTOR);
            onStartChatWindow(r6.readInt());
            return true;
        L21:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L24;
            r4 = (Bitmap) ZeusTransformUtils.preCheckCast(Bitmap.CREATOR.createFromParcel(r6), Bitmap.class, "com.obric.aiagent.plugin");
        L24:
            onHandleScreenshot(r4);
            return true;
        L26:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L29;
            AssistStructure r11 = (AssistStructure) ZeusTransformUtils.preCheckCast(AssistStructure.CREATOR.createFromParcel(r6), AssistStructure.class, "com.obric.aiagent.plugin");
        L31:
            if (r6.readInt() == 0) goto L33;
            r9 = (AssistContent) ZeusTransformUtils.preCheckCast(AssistContent.CREATOR.createFromParcel(r6), AssistContent.class, "com.obric.aiagent.plugin");
        L33:
            onHandleAssist(r11, r9);
            return true;
        L29:
            r11 = null;
            goto L31
        L35:
            r6.enforceInterface(DESCRIPTOR);
            onHide();
            return true;
        L37:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L40;
            r3 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r6), Bundle.class, "com.obric.aiagent.plugin");
        L40:
            onShow(r3);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L42:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAgentVoiceInteractionIDL r2) {
            IAgentVoiceInteractionIDL r3 = (IAgentVoiceInteractionIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentVoiceInteractionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    PersonalContextInfo getUserRecentData();

    void onAsrEnd();

    void onAsrStart(String r1);

    void onHandleAssist(AssistStructure r1, AssistContent r2);

    void onHandleScreenshot(Bitmap r1);

    void onHide();

    void onQueryAudioFile(String r1, String r2);

    void onShow(Bundle r1);

    void onStartChatWindow(int r1);
}
