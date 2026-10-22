package com.obric.autogui.common.api.agent;

import android.os.Bundle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.common.e;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.d;
import d.h.b.o;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: IAutoActionAgentApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionAgentApi {
    public static final IMPL IMPL = null;

    /* JADX INFO: compiled from: IAutoActionAgentApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object postUserQuery$default(IAutoActionAgentApi r8, String r9, boolean r10, Bundle r11, int r12, d r13, int r14, Object r15) {
            IAutoActionAgentApi r2 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d<? super e> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L13;
            if ((r14 & 4) == 0) goto L7;
            r11 = null;
        L7:
            Bundle r5 = r11;
            if ((r14 & 8) == 0) goto L11;
            r12 = 1;
        L11:
            return r2.postUserQuery(r9, r10, r5, r12, r7);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postUserQuery");
        }

        public static /* synthetic */ Object userTerminateQuery$default(IAutoActionAgentApi r2, String r3, d r4, int r5, Object r6) {
            IAutoActionAgentApi r7 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d<? super e> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = null;
        L8:
            return r7.userTerminateQuery(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userTerminateQuery");
        }

        public static /* synthetic */ e systemTerminateQuery$default(IAutoActionAgentApi r8, String r9, String r10, int r11, EndStepParams r12, Map r13, int r14, Object r15) {
            IAutoActionAgentApi r2 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            Map<String, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L13;
            if ((r14 & 8) == 0) goto L7;
            r12 = null;
        L7:
            EndStepParams r6 = r12;
            if ((r14 & 16) == 0) goto L11;
            r16 = ao.b();
        L11:
            return r2.systemTerminateQuery(r9, r10, r11, r6, r16);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: systemTerminateQuery");
        }

        public static /* synthetic */ Object exitUserClarify$default(IAutoActionAgentApi r2, String r3, String r4, d r5, int r6, Object r7) {
            IAutoActionAgentApi r8 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d<? super e> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = DownloadSettingKeys.BugFix.DEFAULT;
        L8:
            return r8.exitUserClarify(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitUserClarify");
        }

        public static /* synthetic */ Object fetchSessionShareUrl$default(IAutoActionAgentApi r2, String r3, d r4, int r5, Object r6) {
            IAutoActionAgentApi r7 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d<? super SessionShareInfo> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = null;
        L8:
            return r7.fetchSessionShareUrl(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchSessionShareUrl");
        }

        public static String calcJournalAbsoluteDir(IAutoActionAgentApi r1, String r2, String r3) {
            IAutoActionAgentApi r4 = (IAutoActionAgentApi) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionKey");
            return r4.calcJournalAbsoluteDir(r3);
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentApi.kt */
    public static final class IMPL implements IAutoActionAgentApi {
        static final /* synthetic */ IMPL $$INSTANCE = null;
        private final /* synthetic */ IAutoActionAgentApi $$delegate_0;

        static {
            $$INSTANCE = new IMPL();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public boolean beforeCallUser() {
            return this.$$delegate_0.beforeCallUser();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public String calcJournalAbsoluteDir(String r2) {
            o.e(r2, "sessionKey");
            return this.$$delegate_0.calcJournalAbsoluteDir(r2);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public String calcJournalAbsoluteDir(String r2, String r3) {
            o.e(r3, "sessionKey");
            return this.$$delegate_0.calcJournalAbsoluteDir(r2, r3);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public void cleanDanglingTask() {
            this.$$delegate_0.cleanDanglingTask();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object enterCallUser(d<? super e> r3) {
            d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.enterCallUser(r4);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object enterUserAddition(d<? super e> r3) {
            d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.enterUserAddition(r4);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object exitApplyAddition(String r3, d<? super x> r4) {
            d<? super x> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.exitApplyAddition(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object exitCallUser(d<? super e> r3) {
            d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.exitCallUser(r4);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object exitUserAddition(String r3, d<? super e> r4) {
            d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.exitUserAddition(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object exitUserClarify(String r3, String r4, d<? super e> r5) {
            d<? super e> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.exitUserClarify(r3, r4, r6);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object fetchSessionShareUrl(String r3, d<? super SessionShareInfo> r4) {
            d<? super SessionShareInfo> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.fetchSessionShareUrl(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public com.obric.autogui.common.d<IAutoActionAgentEventListener.AgentStepInfo> getActiveStepInfo() {
            return this.$$delegate_0.getActiveStepInfo();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public String getOnGoingSessionKey() {
            return this.$$delegate_0.getOnGoingSessionKey();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public com.obric.autogui.common.d<IAutoActionAgentEventListener.SessionInfo> getOngoingSessionInfo() {
            return this.$$delegate_0.getOngoingSessionInfo();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public com.obric.autogui.common.d<VDTrackingApp> getTrackingApp() {
            return this.$$delegate_0.getTrackingApp();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public boolean hasOngoingTask() {
            return this.$$delegate_0.hasOngoingTask();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public void initLib() {
            this.$$delegate_0.initLib();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object intentReply(String r3, d<? super x> r4) {
            d<? super x> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.intentReply(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public boolean isOngoingSessionActive() {
            return this.$$delegate_0.isOngoingSessionActive();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public boolean isOngoingSessionPaused() {
            return this.$$delegate_0.isOngoingSessionPaused();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object postUserQuery(String r7, boolean r8, Bundle r9, int r10, d<? super e> r11) {
            d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.postUserQuery(r7, r8, r9, r10, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object startFunction(String r3, d<? super e> r4) {
            d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.startFunction(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object stopFunction(String r3, d<? super e> r4) {
            d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.stopFunction(r3, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public void stopPredicting() {
            this.$$delegate_0.stopPredicting();
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public e systemTerminateQuery(String r7, String r8, int r9, EndStepParams r10, Map<String, String> r11) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            o.e(r8, "message");
            o.e(r5, "ext");
            return this.$$delegate_0.systemTerminateQuery(r7, r8, r9, r10, r5);
        }

        @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
        public Object userTerminateQuery(String r3, d<? super e> r4) {
            d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return this.$$delegate_0.userTerminateQuery(r3, r5);
        }

        private IMPL() {
            Object r0 = ServiceManager.get().getService(IAutoActionAgentApi.class);
            o.a(r0);
            this.$$delegate_0 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(r0, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentApi.kt */
    public static final class SessionShareInfo {
        private final String sessionId;
        private final String shareUrl;

        public static /* synthetic */ SessionShareInfo copy$default(SessionShareInfo r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.sessionId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.shareUrl;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final String component2() {
            return this.shareUrl;
        }

        public final SessionShareInfo copy(String r1, String r2) {
            o.e(r1, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r2, "shareUrl");
            return new SessionShareInfo(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, SessionShareInfo.class) == true) goto L8;
            return false;
        L8:
            SessionShareInfo r6 = (SessionShareInfo) ZeusTransformUtils.preCheckCast(r5, SessionShareInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.sessionId, r6.sessionId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.shareUrl, r6.shareUrl) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.sessionId.hashCode() * 31) + this.shareUrl.hashCode();
        }

        public String toString() {
            return "SessionShareInfo(sessionId=" + this.sessionId + ", shareUrl=" + this.shareUrl + ')';
        }

        public SessionShareInfo(String r2, String r3) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "shareUrl");
            this.sessionId = r2;
            this.shareUrl = r3;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getShareUrl() {
            return this.shareUrl;
        }
    }

    static {
        IMPL = IMPL.$$INSTANCE;
    }

    boolean beforeCallUser();

    String calcJournalAbsoluteDir(String r1);

    String calcJournalAbsoluteDir(String r1, String r2);

    void cleanDanglingTask();

    Object enterCallUser(d<? super e> r1);

    Object enterUserAddition(d<? super e> r1);

    Object exitApplyAddition(String r1, d<? super x> r2);

    Object exitCallUser(d<? super e> r1);

    Object exitUserAddition(String r1, d<? super e> r2);

    Object exitUserClarify(String r1, String r2, d<? super e> r3);

    Object fetchSessionShareUrl(String r1, d<? super SessionShareInfo> r2);

    com.obric.autogui.common.d<IAutoActionAgentEventListener.AgentStepInfo> getActiveStepInfo();

    String getOnGoingSessionKey();

    com.obric.autogui.common.d<IAutoActionAgentEventListener.SessionInfo> getOngoingSessionInfo();

    com.obric.autogui.common.d<VDTrackingApp> getTrackingApp();

    boolean hasOngoingTask();

    void initLib();

    Object intentReply(String r1, d<? super x> r2);

    boolean isOngoingSessionActive();

    boolean isOngoingSessionPaused();

    Object postUserQuery(String r1, boolean r2, Bundle r3, int r4, d<? super e> r5);

    Object startFunction(String r1, d<? super e> r2);

    Object stopFunction(String r1, d<? super e> r2);

    void stopPredicting();

    e systemTerminateQuery(String r1, String r2, int r3, EndStepParams r4, Map<String, String> r5);

    Object userTerminateQuery(String r1, d<? super e> r2);
}
