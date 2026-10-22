package com.obric.agent;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IAgentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentService {

    /* JADX INFO: compiled from: IAgentService.kt */
    public static final class a {
        public static /* synthetic */ void a(IAgentService r6, String r7, String r8, String r9, int r10, String r11, int r12, Object r13) {
            IAgentService r0 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r6, IAgentService.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L13;
            if ((r12 & 8) == 0) goto L7;
            r10 = 800;
        L7:
            int r4 = r10;
            if ((r12 & 16) == 0) goto L10;
            r11 = null;
        L10:
            r0.addMessage(r7, r8, r9, r4, r11);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMessage");
        }

        public static /* synthetic */ Map a(IAgentService r2, Map r3, String r4, boolean r5, int r6, Object r7) {
            IAgentService r8 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r2, IAgentService.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = false;
        L8:
            return r8.getExtraForSendMessage(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getExtraForSendMessage");
        }

        public static /* synthetic */ IMMessage a(IAgentService r2, String r3, String r4, String r5, int r6, int r7, Object r8) {
            IAgentService r9 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r2, IAgentService.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L8;
            r6 = 800;
        L8:
            return r9.addMutableMessageForLark(r3, r4, r5, r6);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMutableMessageForLark");
        }
    }

    void addLarkSendCardListener(p r1);

    void addMessage(String r1, String r2, String r3, int r4, String r5);

    IMMessage addMutableMessageForLark(String r1, String r2, String r3, int r4);

    void callShortLink(String r1);

    <T> JsonObject constructInputParams(T r1);

    void deleteMessage(String r1);

    void deleteRemoteCardMessageByQuestionId(String r1);

    void dispatchIMAction(IntentAppAction r1);

    void execLocalAppIntent(String r1, JsonObject r2, String r3, long r4);

    List<AppEntity> getAppEntityList(Map<String, ? extends List<String>> r1);

    List<AppEntity> getAppEntityListByType(int r1, int r2);

    void getAppVersionFromStore(boolean r1, String r2, g r3);

    List<Uri> getAudioFileForQuery(String r1);

    String getCachedAutoUploadImageUri();

    Map<String, String> getExtraForSendMessage(Map<String, String> r1, String r2, boolean r3);

    IntentDebugReport getIntentExecution(String r1);

    PicInfo getScreenPicInfo(boolean r1, boolean r2);

    int getTtsState();

    z getUploadingImgInfo(boolean r1);

    PersonalContextInfo getUserRecentData();

    void getWebUrl(s r1);

    void handleQAWithSearchIntent(String[] r1, String r2, DispatchContext r3);

    void handleRemoteCard(IntentAppAction r1, IntentResult<?> r2, String r3, long r4);

    boolean handleUpdateIntentResult(long r1, IntentResult<?> r3, boolean r4, Map<?, ?> r5, IntentAppAction r6);

    boolean hasSemantic();

    void init(Context r1);

    boolean isAutoGuiInstall();

    boolean isMemoryRecommendActivityEnable();

    Object isQueryInterrupt(String r1, d.c.d<? super Boolean> r2);

    boolean isQueryTimeout(String r1);

    boolean isScreenshotSecure();

    void jumpToAppStore(String r1, g r2);

    void notifyLarkSendStatusChanged(String r1, int r2);

    void notifyUserAgreePrivacy();

    void onAsrEnd();

    void onAsrStart(String r1);

    void onAssistantShow(Bundle r1);

    void onAssistantStateChanged(String r1, String r2);

    void onFlowUnbind();

    void onHandleAssist(AssistStructure r1, AssistContent r2);

    void onHandleScreenshot(Bitmap r1);

    void onLiveViewModeDeactivate(String r1);

    void onMessageInputtingStateChange(boolean r1);

    void onQueryAudioFile(String r1, String r2);

    void onStartChatWindow(int r1);

    Object onUserConfirm(String[] r1, String r2, DispatchContext r3, d.c.d<? super IntentResult<AppEntity[]>> r4);

    Object onUserSelect(List<String> r1, String r2, String r3, DispatchContext r4, d.c.d<? super IntentResult<AppEntity[]>> r5);

    void removeLarkSendCardListener(p r1);

    void scheduleConditionTask(ConditionTask r1, String r2, IntentParams r3);

    void scheduleShortcutTask(ShortcutTask r1, String r2, IntentParams r3, String r4);

    void scheduleTimerTask(int r1, String r2, String r3, String r4);

    void screenShot(t r1);

    void setDebugReferImg(String r1);

    void setObricStrategy(String r1);

    void setSystemProperty(String r1, String r2);

    void showLarkUrl(String r1);

    void showSearchCard(String r1, List<? extends AppEntity> r2, String r3);

    void takeScreenshotForScreenPerception(t r1);

    void terminateService();

    void tryScheduleConditionTask(ConditionTask r1, String r2, IntentParams r3, TaskKnowledge r4, int r5, String r6);

    void updateMutableMessageForLark(String r1, String r2, String r3, String r4, int r5);

    Object updateShortCutTasks(d.c.d<? super d.x> r1);
}
