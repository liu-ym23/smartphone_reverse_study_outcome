package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentAppIntentIDL extends IInterface {

    public static class Default implements IAgentAppIntentIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void callPhone(String r1, ContactEntity r2, String r3, String r4) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void callShortLink(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void clearAllOmniTask(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void deleteEntities(AppEntity[] r1, IEntityDeleteCallbackIDL r2) {
            IEntityDeleteCallbackIDL r0 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void deleteRecordings(RecordingEntity[] r1, boolean r2, IRecordingDeleteCallbackIDL r3) {
            IRecordingDeleteCallbackIDL r0 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedback(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedbackWithInfo(String r1, String r2, List<String> r3, String r4, boolean r5) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedbackWithType(String r1, String r2, List<String> r3, String r4) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<AppEntity> getAppEntityList(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<String> getComplexTaskPanelInfoFromPC(int r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public IntentDebugReport getIntentExecution(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public Map getOmniExtraLog(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<String> getOmniJournalPath(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean isAppIntentActive() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean isWifiEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void jumpToSystemOtaPage() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyCloseAutoGUISwitch() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyLarkSendStausChanged(String r1, int r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyStopAutoAction(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyStopComplexTask(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyUserAgreePrivacy() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void onLoginStateChange(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public int pauseMusic() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public int playMusic(String r1, MusicEntity[] r2, MusicEntity r3) {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void registerMusicStateListener(IMusicStateListenerIDL r2) {
            IMusicStateListenerIDL r1 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void replyAskUser(String r1, String r2, String r3, Map r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void screenShot(IScreenshotCallbackIDL r2) {
            IScreenshotCallbackIDL r1 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void sendSms(String r1, ContactEntity r2, String r3, String r4) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void setDebugReferImg(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean setWifiEnabled(boolean r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAlarm(AlarmEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAlbum(AlbumEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAuditoryRecording(AuditoryRecordingEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showCallHistory(CallHistoryEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showContact(ContactEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showCountdown(CountdownEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showFile(FileEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showLarkUrl(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMemory(MemoryEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMessage(MessageEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMusicPage() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showNote(NoteEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showPhoto(PhotoEntity[] r1, int r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showProactiveMemory(ProactiveMemoryEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showProxyCallHistory(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showRecording(RecordingEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showSchedule(ScheduleEntity r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showWeather(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void takeScreenshot(IScreenshotCallbackIDL r2) {
            IScreenshotCallbackIDL r1 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void terminateService() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void turnOnOffAlarm(AlarmEntity r1, boolean r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void unregisterMusicStateListener(IMusicStateListenerIDL r2) {
            IMusicStateListenerIDL r1 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentAppIntentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentAppIntentIDL";
        static final int TRANSACTION_callPhone = 21;
        static final int TRANSACTION_callShortLink = 33;
        static final int TRANSACTION_clearAllOmniTask = 34;
        static final int TRANSACTION_deleteEntities = 52;
        static final int TRANSACTION_deleteRecordings = 51;
        static final int TRANSACTION_drainOmniUploadImagesForFeedback = 36;
        static final int TRANSACTION_drainOmniUploadImagesForFeedbackWithInfo = 37;
        static final int TRANSACTION_drainOmniUploadImagesForFeedbackWithType = 38;
        static final int TRANSACTION_getAppEntityList = 30;
        static final int TRANSACTION_getComplexTaskPanelInfoFromPC = 24;
        static final int TRANSACTION_getIntentExecution = 16;
        static final int TRANSACTION_getOmniExtraLog = 39;
        static final int TRANSACTION_getOmniJournalPath = 35;
        static final int TRANSACTION_isAppIntentActive = 17;
        static final int TRANSACTION_isWifiEnabled = 48;
        static final int TRANSACTION_jumpToSystemOtaPage = 25;
        static final int TRANSACTION_notifyCloseAutoGUISwitch = 27;
        static final int TRANSACTION_notifyLarkSendStausChanged = 32;
        static final int TRANSACTION_notifyStopAutoAction = 23;
        static final int TRANSACTION_notifyStopComplexTask = 18;
        static final int TRANSACTION_notifyUserAgreePrivacy = 1;
        static final int TRANSACTION_onLoginStateChange = 29;
        static final int TRANSACTION_pauseMusic = 43;
        static final int TRANSACTION_playMusic = 41;
        static final int TRANSACTION_registerMusicStateListener = 44;
        static final int TRANSACTION_replyAskUser = 19;
        static final int TRANSACTION_screenShot = 15;
        static final int TRANSACTION_sendSms = 49;
        static final int TRANSACTION_setDebugReferImg = 26;
        static final int TRANSACTION_setWifiEnabled = 47;
        static final int TRANSACTION_showAlarm = 5;
        static final int TRANSACTION_showAlbum = 8;
        static final int TRANSACTION_showAuditoryRecording = 20;
        static final int TRANSACTION_showCallHistory = 3;
        static final int TRANSACTION_showContact = 4;
        static final int TRANSACTION_showCountdown = 7;
        static final int TRANSACTION_showFile = 10;
        static final int TRANSACTION_showLarkUrl = 31;
        static final int TRANSACTION_showMemory = 14;
        static final int TRANSACTION_showMessage = 12;
        static final int TRANSACTION_showMusicPage = 42;
        static final int TRANSACTION_showNote = 6;
        static final int TRANSACTION_showPhoto = 9;
        static final int TRANSACTION_showProactiveMemory = 22;
        static final int TRANSACTION_showProxyCallHistory = 28;
        static final int TRANSACTION_showRecording = 11;
        static final int TRANSACTION_showSchedule = 13;
        static final int TRANSACTION_showWeather = 50;
        static final int TRANSACTION_takeScreenshot = 46;
        static final int TRANSACTION_terminateService = 2;
        static final int TRANSACTION_turnOnOffAlarm = 40;
        static final int TRANSACTION_unregisterMusicStateListener = 45;

        private static class Proxy implements IAgentAppIntentIDL {
            public static IAgentAppIntentIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyUserAgreePrivacy() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyUserAgreePrivacy();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void terminateService() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().terminateService();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showCallHistory(CallHistoryEntity r5) {
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
                Stub.getDefaultImpl().showCallHistory(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showContact(ContactEntity r5) {
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
                Stub.getDefaultImpl().showContact(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAlarm(AlarmEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAlarm(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showNote(NoteEntity r5) {
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
                Stub.getDefaultImpl().showNote(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showCountdown(CountdownEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showCountdown(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAlbum(AlbumEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAlbum(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showPhoto(PhotoEntity[] r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedArray(r5, 0);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showPhoto(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showFile(FileEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showFile(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showRecording(RecordingEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showRecording(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMessage(MessageEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(12, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showSchedule(ScheduleEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showSchedule(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMemory(MemoryEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showMemory(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void screenShot(IScreenshotCallbackIDL r5) {
                IScreenshotCallbackIDL r6 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().screenShot(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public IntentDebugReport getIntentExecution(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                IntentDebugReport r4 = (IntentDebugReport) ZeusTransformUtils.preCheckCast(IntentDebugReport.CREATOR.createFromParcel(r1), IntentDebugReport.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IntentDebugReport r6 = Stub.getDefaultImpl().getIntentExecution(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean isAppIntentActive() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isAppIntentActive();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyStopComplexTask(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(18, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTask(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void replyAskUser(String r5, String r6, String r7, Map r8) {
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                r0.writeMap(r9);     // Catch: Throwable -> L12
                if (this.mRemote.transact(19, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().replyAskUser(r5, r6, r7, r9);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAuditoryRecording(AuditoryRecordingEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(20, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAuditoryRecording(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void callPhone(String r5, ContactEntity r6, String r7, String r8) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L16
                r0.writeString(r8);     // Catch: Throwable -> L16
                if (this.mRemote.transact(21, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().callPhone(r5, r6, r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showProactiveMemory(ProactiveMemoryEntity r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(22, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showProactiveMemory(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyStopAutoAction(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(23, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopAutoAction(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<String> getComplexTaskPanelInfoFromPC(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(24, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList<String> r4 = r1.createStringArrayList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r6 = Stub.getDefaultImpl().getComplexTaskPanelInfoFromPC(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void jumpToSystemOtaPage() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(25, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().jumpToSystemOtaPage();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void setDebugReferImg(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(26, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setDebugReferImg(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyCloseAutoGUISwitch() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(27, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyCloseAutoGUISwitch();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showProxyCallHistory(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(28, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showProxyCallHistory(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void onLoginStateChange(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(29, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLoginStateChange(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<AppEntity> getAppEntityList(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeMap(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(AppEntity.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AppEntity> r7 = Stub.getDefaultImpl().getAppEntityList(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showLarkUrl(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(31, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showLarkUrl(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyLarkSendStausChanged(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(32, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLarkSendStausChanged(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void callShortLink(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(33, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().callShortLink(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void clearAllOmniTask(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeMap(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(34, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearAllOmniTask(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<String> getOmniJournalPath(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList<String> r4 = r1.createStringArrayList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r6 = Stub.getDefaultImpl().getOmniJournalPath(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedback(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(36, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedback(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedbackWithInfo(String r7, String r8, List<String> r9, String r10, boolean r11) {
                List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r12.writeString(r7);     // Catch: Throwable -> L16
                r12.writeString(r8);     // Catch: Throwable -> L16
                r12.writeStringList(r3);     // Catch: Throwable -> L16
                r12.writeString(r10);     // Catch: Throwable -> L16
                if (r11 == false) goto L6;
                int r1 = 1;
            L7:
                r12.writeInt(r1);     // Catch: Throwable -> L16
                if (this.mRemote.transact(37, r12, null, 1) == false) goto L10;
            L14:
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedbackWithInfo(r7, r8, r3, r10, r11);     // Catch: Throwable -> L16
                r12.recycle();
                return;
            L6:
                r1 = 0;
            L16:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedbackWithType(String r5, String r6, List<String> r7, String r8) {
                List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeStringList(r9);     // Catch: Throwable -> L12
                r0.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(38, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedbackWithType(r5, r6, r9, r8);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public Map getOmniExtraLog(String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(39, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r7 = Stub.getDefaultImpl().getOmniExtraLog(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void turnOnOffAlarm(AlarmEntity r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L18
                int r2 = 0;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L18
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L18
            L7:
                if (r6 == false) goto L9;
                r2 = 1;
            L9:
                r0.writeInt(r2);     // Catch: Throwable -> L18
                if (this.mRemote.transact(40, r0, null, 1) == false) goto L12;
            L16:
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().turnOnOffAlarm(r5, r6);     // Catch: Throwable -> L18
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public int playMusic(String r5, MusicEntity[] r6, MusicEntity r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeTypedArray(r6, 0);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(41, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r4 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r8 = Stub.getDefaultImpl().playMusic(r5, r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMusicPage() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(42, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showMusicPage();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public int pauseMusic() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(43, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().pauseMusic();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void registerMusicStateListener(IMusicStateListenerIDL r5) {
                IMusicStateListenerIDL r6 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(44, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMusicStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void unregisterMusicStateListener(IMusicStateListenerIDL r5) {
                IMusicStateListenerIDL r6 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(45, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterMusicStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void takeScreenshot(IScreenshotCallbackIDL r5) {
                IScreenshotCallbackIDL r6 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(46, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().takeScreenshot(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean setWifiEnabled(boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(47, r0, r1, 0) == false) goto L10;
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
                boolean r5 = Stub.getDefaultImpl().setWifiEnabled(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r4 = 0;
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean isWifiEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(48, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isWifiEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void sendSms(String r5, ContactEntity r6, String r7, String r8) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L16
                r0.writeString(r8);     // Catch: Throwable -> L16
                if (this.mRemote.transact(49, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendSms(r5, r6, r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showWeather(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(50, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showWeather(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void deleteRecordings(RecordingEntity[] r5, boolean r6, IRecordingDeleteCallbackIDL r7) {
                IRecordingDeleteCallbackIDL r8 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                int r1 = 0;
                r0.writeTypedArray(r5, 0);     // Catch: Throwable -> L19
                if (r6 == false) goto L6;
                r1 = 1;
            L6:
                r0.writeInt(r1);     // Catch: Throwable -> L19
                if (r8 == null) goto L9;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L19
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(51, r0, null, 1) == false) goto L13;
            L17:
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().deleteRecordings(r5, r6, r8);     // Catch: Throwable -> L19
                r0.recycle();
                return;
            L9:
                r3 = null;
            L19:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void deleteEntities(AppEntity[] r5, IEntityDeleteCallbackIDL r6) {
                IEntityDeleteCallbackIDL r7 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeTypedArray(r5, 0);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(52, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteEntities(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
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

        public static IAgentAppIntentIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentAppIntentIDL.class) == false) goto L13;
            return (IAgentAppIntentIDL) ZeusTransformUtils.preCheckCast(r0, IAgentAppIntentIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 == 1598968902) goto L182;
            boolean r3 = false;
            CallHistoryEntity r4 = null;
            ContactEntity r5 = null;
            MusicEntity r6 = null;
            AlarmEntity r7 = null;
            ProactiveMemoryEntity r8 = null;
            ContactEntity r13 = null;
            AuditoryRecordingEntity r14 = null;
            MemoryEntity r15 = null;
            ScheduleEntity r16 = null;
            MessageEntity r17 = null;
            RecordingEntity r18 = null;
            FileEntity r19 = null;
            AlbumEntity r20 = null;
            CountdownEntity r21 = null;
            NoteEntity r22 = null;
            AlarmEntity r23 = null;
            ContactEntity r24 = null;
            switch(r9) {
                case 1: goto L180;
                case 2: goto L178;
                case 3: goto L173;
                case 4: goto L168;
                case 5: goto L163;
                case 6: goto L158;
                case 7: goto L153;
                case 8: goto L148;
                case 9: goto L146;
                case 10: goto L141;
                case 11: goto L136;
                case 12: goto L131;
                case 13: goto L126;
                case 14: goto L121;
                case 15: goto L119;
                case 16: goto L114;
                case 17: goto L112;
                case 18: goto L110;
                case 19: goto L108;
                case 20: goto L103;
                case 21: goto L98;
                case 22: goto L93;
                case 23: goto L91;
                case 24: goto L89;
                case 25: goto L87;
                case 26: goto L85;
                case 27: goto L83;
                case 28: goto L81;
                case 29: goto L76;
                case 30: goto L74;
                case 31: goto L72;
                case 32: goto L70;
                case 33: goto L68;
                case 34: goto L66;
                case 35: goto L64;
                case 36: goto L62;
                case 37: goto L56;
                case 38: goto L54;
                case 39: goto L52;
                case 40: goto L44;
                case 41: goto L39;
                case 42: goto L37;
                case 43: goto L35;
                case 44: goto L33;
                case 45: goto L31;
                case 46: goto L29;
                case 47: goto L24;
                case 48: goto L22;
                case 49: goto L17;
                case 50: goto L15;
                case 51: goto L10;
                case 52: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            deleteEntities((AppEntity[]) ZeusTransformUtils.preCheckCast(r10.createTypedArray(AppEntity.CREATOR), AppEntity[].class, "com.obric.aiagent.plugin"), IEntityDeleteCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            RecordingEntity[] r25 = (RecordingEntity[]) ZeusTransformUtils.preCheckCast(r10.createTypedArray(RecordingEntity.CREATOR), RecordingEntity[].class, "com.obric.aiagent.plugin");
            if (r10.readInt() == 0) goto L13;
            r3 = true;
        L13:
            deleteRecordings(r25, r3, IRecordingDeleteCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            showWeather(r10.readString(), r10.readString());
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            String r26 = r10.readString();
            if (r10.readInt() == 0) goto L20;
            r5 = ContactEntity.CREATOR.createFromParcel(r10);
        L20:
            sendSms(r26, r5, r10.readString(), r10.readString());
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            boolean r27 = isWifiEnabled();
            r11.writeNoException();
            r11.writeInt(r27 ? 1 : 0);
            return true;
        L24:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L27;
            r3 = true;
        L27:
            boolean r28 = setWifiEnabled(r3);
            r11.writeNoException();
            r11.writeInt(r28 ? 1 : 0);
            return true;
        L29:
            r10.enforceInterface(DESCRIPTOR);
            takeScreenshot(IScreenshotCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L31:
            r10.enforceInterface(DESCRIPTOR);
            unregisterMusicStateListener(IMusicStateListenerIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L33:
            r10.enforceInterface(DESCRIPTOR);
            registerMusicStateListener(IMusicStateListenerIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L35:
            r10.enforceInterface(DESCRIPTOR);
            int r29 = pauseMusic();
            r11.writeNoException();
            r11.writeInt(r29);
            return true;
        L37:
            r10.enforceInterface(DESCRIPTOR);
            showMusicPage();
            return true;
        L39:
            r10.enforceInterface(DESCRIPTOR);
            String r30 = r10.readString();
            MusicEntity[] r110 = (MusicEntity[]) ZeusTransformUtils.preCheckCast(r10.createTypedArray(MusicEntity.CREATOR), MusicEntity[].class, "com.obric.aiagent.plugin");
            if (r10.readInt() == 0) goto L42;
            r6 = MusicEntity.CREATOR.createFromParcel(r10);
        L42:
            int r31 = playMusic(r30, r110, r6);
            r11.writeNoException();
            r11.writeInt(r31);
            return true;
        L44:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L48;
            r7 = AlarmEntity.CREATOR.createFromParcel(r10);
        L48:
            if (r10.readInt() == 0) goto L50;
            r3 = true;
        L50:
            turnOnOffAlarm(r7, r3);
            return true;
        L52:
            r10.enforceInterface(DESCRIPTOR);
            Map r32 = getOmniExtraLog(r10.readString());
            r11.writeNoException();
            r11.writeMap(r32);
            return true;
        L54:
            r10.enforceInterface(DESCRIPTOR);
            drainOmniUploadImagesForFeedbackWithType(r10.readString(), r10.readString(), r10.createStringArrayList(), r10.readString());
            return true;
        L56:
            r10.enforceInterface(DESCRIPTOR);
            String r33 = r10.readString();
            String r34 = r10.readString();
            ArrayList<String> r35 = r10.createStringArrayList();
            String r36 = r10.readString();
            if (r10.readInt() == 0) goto L59;
            boolean r37 = true;
        L60:
            drainOmniUploadImagesForFeedbackWithInfo(r33, r34, r35, r36, r37);
            return true;
        L59:
            r37 = false;
            goto L60
        L62:
            r10.enforceInterface(DESCRIPTOR);
            drainOmniUploadImagesForFeedback(r10.readString());
            return true;
        L64:
            r10.enforceInterface(DESCRIPTOR);
            List<String> r38 = getOmniJournalPath(r10.readString());
            r11.writeNoException();
            r11.writeStringList(r38);
            return true;
        L66:
            r10.enforceInterface(DESCRIPTOR);
            clearAllOmniTask(r10.readHashMap(getClass().getClassLoader()));
            return true;
        L68:
            r10.enforceInterface(DESCRIPTOR);
            callShortLink(r10.readString());
            return true;
        L70:
            r10.enforceInterface(DESCRIPTOR);
            notifyLarkSendStausChanged(r10.readString(), r10.readInt());
            return true;
        L72:
            r10.enforceInterface(DESCRIPTOR);
            showLarkUrl(r10.readString());
            return true;
        L74:
            r10.enforceInterface(DESCRIPTOR);
            List<AppEntity> r39 = getAppEntityList(r10.readHashMap(getClass().getClassLoader()));
            r11.writeNoException();
            r11.writeTypedList(r39);
            return true;
        L76:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L79;
            r3 = true;
        L79:
            onLoginStateChange(r3);
            return true;
        L81:
            r10.enforceInterface(DESCRIPTOR);
            showProxyCallHistory(r10.readString());
            return true;
        L83:
            r10.enforceInterface(DESCRIPTOR);
            notifyCloseAutoGUISwitch();
            return true;
        L85:
            r10.enforceInterface(DESCRIPTOR);
            setDebugReferImg(r10.readString());
            return true;
        L87:
            r10.enforceInterface(DESCRIPTOR);
            jumpToSystemOtaPage();
            return true;
        L89:
            r10.enforceInterface(DESCRIPTOR);
            List<String> r40 = getComplexTaskPanelInfoFromPC(r10.readInt());
            r11.writeNoException();
            r11.writeStringList(r40);
            return true;
        L91:
            r10.enforceInterface(DESCRIPTOR);
            notifyStopAutoAction(r10.readString(), r10.readString());
            return true;
        L93:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L96;
            r8 = ProactiveMemoryEntity.CREATOR.createFromParcel(r10);
        L96:
            showProactiveMemory(r8);
            return true;
        L98:
            r10.enforceInterface(DESCRIPTOR);
            String r41 = r10.readString();
            if (r10.readInt() == 0) goto L101;
            r13 = ContactEntity.CREATOR.createFromParcel(r10);
        L101:
            callPhone(r41, r13, r10.readString(), r10.readString());
            return true;
        L103:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L106;
            r14 = AuditoryRecordingEntity.CREATOR.createFromParcel(r10);
        L106:
            showAuditoryRecording(r14);
            return true;
        L108:
            r10.enforceInterface(DESCRIPTOR);
            replyAskUser(r10.readString(), r10.readString(), r10.readString(), r10.readHashMap(getClass().getClassLoader()));
            return true;
        L110:
            r10.enforceInterface(DESCRIPTOR);
            notifyStopComplexTask(r10.readString());
            return true;
        L112:
            r10.enforceInterface(DESCRIPTOR);
            boolean r42 = isAppIntentActive();
            r11.writeNoException();
            r11.writeInt(r42 ? 1 : 0);
            return true;
        L114:
            r10.enforceInterface(DESCRIPTOR);
            IntentDebugReport r43 = getIntentExecution(r10.readString());
            r11.writeNoException();
            if (r43 == null) goto L117;
            r11.writeInt(1);
            r43.writeToParcel(r11, 1);
        L118:
            return true;
        L117:
            r11.writeInt(0);
            goto L118
        L119:
            r10.enforceInterface(DESCRIPTOR);
            screenShot(IScreenshotCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L121:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L124;
            r15 = MemoryEntity.CREATOR.createFromParcel(r10);
        L124:
            showMemory(r15);
            return true;
        L126:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L129;
            r16 = ScheduleEntity.CREATOR.createFromParcel(r10);
        L129:
            showSchedule(r16);
            return true;
        L131:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L134;
            r17 = MessageEntity.CREATOR.createFromParcel(r10);
        L134:
            showMessage(r17);
            return true;
        L136:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L139;
            r18 = RecordingEntity.CREATOR.createFromParcel(r10);
        L139:
            showRecording(r18);
            return true;
        L141:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L144;
            r19 = FileEntity.CREATOR.createFromParcel(r10);
        L144:
            showFile(r19);
            return true;
        L146:
            r10.enforceInterface(DESCRIPTOR);
            showPhoto((PhotoEntity[]) ZeusTransformUtils.preCheckCast(r10.createTypedArray(PhotoEntity.CREATOR), PhotoEntity[].class, "com.obric.aiagent.plugin"), r10.readInt());
            return true;
        L148:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L151;
            r20 = AlbumEntity.CREATOR.createFromParcel(r10);
        L151:
            showAlbum(r20);
            return true;
        L153:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L156;
            r21 = CountdownEntity.CREATOR.createFromParcel(r10);
        L156:
            showCountdown(r21);
            return true;
        L158:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L161;
            r22 = NoteEntity.CREATOR.createFromParcel(r10);
        L161:
            showNote(r22);
            return true;
        L163:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L166;
            r23 = AlarmEntity.CREATOR.createFromParcel(r10);
        L166:
            showAlarm(r23);
            return true;
        L168:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L171;
            r24 = ContactEntity.CREATOR.createFromParcel(r10);
        L171:
            showContact(r24);
            return true;
        L173:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L176;
            r4 = CallHistoryEntity.CREATOR.createFromParcel(r10);
        L176:
            showCallHistory(r4);
            return true;
        L178:
            r10.enforceInterface(DESCRIPTOR);
            terminateService();
            return true;
        L180:
            r10.enforceInterface(DESCRIPTOR);
            notifyUserAgreePrivacy();
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L182:
            r11.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IAgentAppIntentIDL r2) {
            IAgentAppIntentIDL r3 = (IAgentAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentAppIntentIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentAppIntentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void callPhone(String r1, ContactEntity r2, String r3, String r4);

    void callShortLink(String r1);

    void clearAllOmniTask(Map r1);

    void deleteEntities(AppEntity[] r1, IEntityDeleteCallbackIDL r2);

    void deleteRecordings(RecordingEntity[] r1, boolean r2, IRecordingDeleteCallbackIDL r3);

    void drainOmniUploadImagesForFeedback(String r1);

    void drainOmniUploadImagesForFeedbackWithInfo(String r1, String r2, List<String> r3, String r4, boolean r5);

    void drainOmniUploadImagesForFeedbackWithType(String r1, String r2, List<String> r3, String r4);

    List<AppEntity> getAppEntityList(Map r1);

    List<String> getComplexTaskPanelInfoFromPC(int r1);

    IntentDebugReport getIntentExecution(String r1);

    Map getOmniExtraLog(String r1);

    List<String> getOmniJournalPath(String r1);

    boolean isAppIntentActive();

    boolean isWifiEnabled();

    void jumpToSystemOtaPage();

    void notifyCloseAutoGUISwitch();

    void notifyLarkSendStausChanged(String r1, int r2);

    void notifyStopAutoAction(String r1, String r2);

    void notifyStopComplexTask(String r1);

    void notifyUserAgreePrivacy();

    void onLoginStateChange(boolean r1);

    int pauseMusic();

    int playMusic(String r1, MusicEntity[] r2, MusicEntity r3);

    void registerMusicStateListener(IMusicStateListenerIDL r1);

    void replyAskUser(String r1, String r2, String r3, Map r4);

    void screenShot(IScreenshotCallbackIDL r1);

    void sendSms(String r1, ContactEntity r2, String r3, String r4);

    void setDebugReferImg(String r1);

    boolean setWifiEnabled(boolean r1);

    void showAlarm(AlarmEntity r1);

    void showAlbum(AlbumEntity r1);

    void showAuditoryRecording(AuditoryRecordingEntity r1);

    void showCallHistory(CallHistoryEntity r1);

    void showContact(ContactEntity r1);

    void showCountdown(CountdownEntity r1);

    void showFile(FileEntity r1);

    void showLarkUrl(String r1);

    void showMemory(MemoryEntity r1);

    void showMessage(MessageEntity r1);

    void showMusicPage();

    void showNote(NoteEntity r1);

    void showPhoto(PhotoEntity[] r1, int r2);

    void showProactiveMemory(ProactiveMemoryEntity r1);

    void showProxyCallHistory(String r1);

    void showRecording(RecordingEntity r1);

    void showSchedule(ScheduleEntity r1);

    void showWeather(String r1, String r2);

    void takeScreenshot(IScreenshotCallbackIDL r1);

    void terminateService();

    void turnOnOffAlarm(AlarmEntity r1, boolean r2);

    void unregisterMusicStateListener(IMusicStateListenerIDL r1);
}
