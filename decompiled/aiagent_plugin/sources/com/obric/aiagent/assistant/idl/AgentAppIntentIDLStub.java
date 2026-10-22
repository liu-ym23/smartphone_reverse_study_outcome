package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
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
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AgentAppIntentIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentAppIntentIDLStub extends IAgentAppIntentIDL.Stub implements IAgentAppIntentIDL {
    private final /* synthetic */ IAgentAppIntentIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callPhone(String r1, ContactEntity r2, String r3, String r4) {
        this.$$delegate_0.callPhone(r1, r2, r3, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callShortLink(String r1) {
        this.$$delegate_0.callShortLink(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void clearAllOmniTask(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.clearAllOmniTask(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteEntities(AppEntity[] r3, IEntityDeleteCallbackIDL r4) {
        IEntityDeleteCallbackIDL r5 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.deleteEntities(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteRecordings(RecordingEntity[] r3, boolean r4, IRecordingDeleteCallbackIDL r5) {
        IRecordingDeleteCallbackIDL r6 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.deleteRecordings(r3, r4, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedback(String r1) {
        this.$$delegate_0.drainOmniUploadImagesForFeedback(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithInfo(String r7, String r8, List<String> r9, String r10, boolean r11) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.drainOmniUploadImagesForFeedbackWithInfo(r7, r8, r3, r10, r11);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithType(String r3, String r4, List<String> r5, String r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.drainOmniUploadImagesForFeedbackWithType(r3, r4, r7, r6);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<AppEntity> getAppEntityList(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.getAppEntityList(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getComplexTaskPanelInfoFromPC(int r1) {
        return this.$$delegate_0.getComplexTaskPanelInfoFromPC(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public IntentDebugReport getIntentExecution(String r1) {
        return this.$$delegate_0.getIntentExecution(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public Map getOmniExtraLog(String r1) {
        return this.$$delegate_0.getOmniExtraLog(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getOmniJournalPath(String r1) {
        return this.$$delegate_0.getOmniJournalPath(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isAppIntentActive() {
        return this.$$delegate_0.isAppIntentActive();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isWifiEnabled() {
        return this.$$delegate_0.isWifiEnabled();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void jumpToSystemOtaPage() {
        this.$$delegate_0.jumpToSystemOtaPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyCloseAutoGUISwitch() {
        this.$$delegate_0.notifyCloseAutoGUISwitch();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyLarkSendStausChanged(String r1, int r2) {
        this.$$delegate_0.notifyLarkSendStausChanged(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopAutoAction(String r1, String r2) {
        this.$$delegate_0.notifyStopAutoAction(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopComplexTask(String r1) {
        this.$$delegate_0.notifyStopComplexTask(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyUserAgreePrivacy() {
        this.$$delegate_0.notifyUserAgreePrivacy();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void onLoginStateChange(boolean r1) {
        this.$$delegate_0.onLoginStateChange(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int pauseMusic() {
        return this.$$delegate_0.pauseMusic();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int playMusic(String r1, MusicEntity[] r2, MusicEntity r3) {
        return this.$$delegate_0.playMusic(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void registerMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.registerMusicStateListener(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void replyAskUser(String r3, String r4, String r5, Map r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.replyAskUser(r3, r4, r5, r7);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void screenShot(IScreenshotCallbackIDL r3) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.screenShot(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void sendSms(String r1, ContactEntity r2, String r3, String r4) {
        this.$$delegate_0.sendSms(r1, r2, r3, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void setDebugReferImg(String r1) {
        this.$$delegate_0.setDebugReferImg(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean setWifiEnabled(boolean r1) {
        return this.$$delegate_0.setWifiEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlarm(AlarmEntity r1) {
        this.$$delegate_0.showAlarm(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlbum(AlbumEntity r1) {
        this.$$delegate_0.showAlbum(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAuditoryRecording(AuditoryRecordingEntity r1) {
        this.$$delegate_0.showAuditoryRecording(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCallHistory(CallHistoryEntity r1) {
        this.$$delegate_0.showCallHistory(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showContact(ContactEntity r1) {
        this.$$delegate_0.showContact(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCountdown(CountdownEntity r1) {
        this.$$delegate_0.showCountdown(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showFile(FileEntity r1) {
        this.$$delegate_0.showFile(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showLarkUrl(String r1) {
        this.$$delegate_0.showLarkUrl(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMemory(MemoryEntity r1) {
        this.$$delegate_0.showMemory(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMessage(MessageEntity r1) {
        this.$$delegate_0.showMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMusicPage() {
        this.$$delegate_0.showMusicPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showNote(NoteEntity r1) {
        this.$$delegate_0.showNote(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showPhoto(PhotoEntity[] r1, int r2) {
        this.$$delegate_0.showPhoto(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProactiveMemory(ProactiveMemoryEntity r1) {
        this.$$delegate_0.showProactiveMemory(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProxyCallHistory(String r1) {
        this.$$delegate_0.showProxyCallHistory(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showRecording(RecordingEntity r1) {
        this.$$delegate_0.showRecording(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showSchedule(ScheduleEntity r1) {
        this.$$delegate_0.showSchedule(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showWeather(String r1, String r2) {
        this.$$delegate_0.showWeather(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void takeScreenshot(IScreenshotCallbackIDL r3) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.takeScreenshot(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void terminateService() {
        this.$$delegate_0.terminateService();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void turnOnOffAlarm(AlarmEntity r1, boolean r2) {
        this.$$delegate_0.turnOnOffAlarm(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void unregisterMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.unregisterMusicStateListener(r4);
    }

    public AgentAppIntentIDLStub() {
        Object r0 = (IAgentAppIntentIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAppIntentIDLSPI.class), IAgentAppIntentIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentAppIntentIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentAppIntentIDL) ZeusTransformUtils.preCheckCast(r0, IAgentAppIntentIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
