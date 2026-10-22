package com.obric.aiagent.executionengine.scheduler.api;

import android.app.PendingIntent;
import android.content.Intent;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IGetRunningTaskCallback;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: compiled from: IJobManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IJobManagerApi {
    void cancelAppFunctionPrivacyWatch();

    void dispatchActionResultFromClient(String r1);

    void dispatchIntentExecutionResultFromClient(IntentResult<?> r1, String r2);

    void findActionByQuestionId(Long r1, IGetRunningTaskCallback r2);

    void finishFloatingActivity(long r1);

    PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4);

    void hideIntentResultCard(long r1);

    boolean isCardViewVisible(long r1);

    Boolean isKeyguardReallyLocked();

    void stopRunningAction(String r1, String r2, String r3, String r4);

    void stopRunningJobs(String r1, String r2);

    void updateIntentResult(long r1, IntentResult<?> r3, boolean r4, Map<?, ?> r5);
}
