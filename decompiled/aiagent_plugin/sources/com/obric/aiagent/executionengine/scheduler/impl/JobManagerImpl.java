package com.obric.aiagent.executionengine.scheduler.impl;

import android.app.PendingIntent;
import android.content.Intent;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.executionengine.scheduler.impl.job.d;
import com.obric.aiagent.executionengine.utils.e;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IGetRunningTaskCallback;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: JobManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JobManagerImpl implements IJobManagerApi {
    public JobManagerImpl() {
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void dispatchActionResultFromClient(String r2) {
        o.e(r2, "payload");
        IMAppAction r1 = (IMAppAction) ZeusTransformUtils.preCheckCast(e.a().fromJson(r2, IMAppAction.class), IMAppAction.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        d.f18489a.a(r1);
        return;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void dispatchIntentExecutionResultFromClient(IntentResult<?> r2, String r3) {
        o.e(r2, "result");
        o.e(r3, "oldResult");
        IMAppAction r1 = (IMAppAction) ZeusTransformUtils.preCheckCast(e.a().fromJson(r3, IMAppAction.class), IMAppAction.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        d.f18489a.a(r2, r1);
        return;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void updateIntentResult(long r7, IntentResult<?> r9, boolean r10, Map<?, ?> r11) {
        Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "result");
        d.f18489a.a(r7, r9, r10, r5);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void hideIntentResultCard(long r1) {
        d.f18489a.a(r1);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void finishFloatingActivity(long r1) {
        d.f18489a.b(r1);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public boolean isCardViewVisible(long r1) {
        return d.f18489a.c(r1);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public Boolean isKeyguardReallyLocked() {
        return d.f18489a.b();
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4) {
        o.e(r3, MemorySourceLinkType.INTENT);
        o.e(r4, "params");
        return d.f18489a.a(r1, r3, r4);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void stopRunningJobs(String r1, String r2) {
        o.e(r1, "messageId");
        o.e(r2, "reason");
        d.f18489a.a(r1, r2);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void findActionByQuestionId(Long r3, IGetRunningTaskCallback r4) {
        IGetRunningTaskCallback r2 = (IGetRunningTaskCallback) ZeusTransformUtils.wrapperContextForParams(r4, IGetRunningTaskCallback.class, "com.obric.aiagent.plugin");
        o.e(r2, "callback");
        if (r3 != null) goto L6;
        r2.onResult(null);
        return;
    L6:
        d.f18489a.a(r3.longValue(), r2);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void stopRunningAction(String r1, String r2, String r3, String r4) {
        o.e(r4, "reason");
        d.f18489a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi
    public void cancelAppFunctionPrivacyWatch() {
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.a.a.f18146a.a();
    }
}
