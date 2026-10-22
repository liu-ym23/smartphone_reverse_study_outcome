package com.obric.agent.trace;

import android.content.Context;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: IIntentTraceService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IIntentTraceService {

    /* JADX INFO: compiled from: IIntentTraceService.kt */
    public static final class a {
        public static /* synthetic */ void a(IIntentTraceService r2, String r3, String r4, Object r5, int r6, int r7, Object r8) {
            IIntentTraceService r9 = (IIntentTraceService) ZeusTransformUtils.wrapperContextForParams(r2, IIntentTraceService.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L7;
            r6 = 0;
        L7:
            r9.addStateParams(r3, r4, r5, r6);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addStateParams");
        }
    }

    void addInterruptedState(String r1, String r2, Map<String, ? extends Object> r3);

    void addStateParams(String r1, String r2, Object r3, int r4);

    void enterAppActionStage(String r1, long r2, String r4, boolean r5);

    View getDebugView(Context r1, d.h.a.a<d.x> r2);

    Long getEngineCost(String r1);

    Object getQuery(String r1, d.c.d<? super String> r2);

    Object getQueryOrReWriteContent(String r1, d.c.d<? super String> r2);

    Object getQueryOrReWriteContentForSummary(String r1, d.c.d<? super String> r2);

    Object getRunningAction(String r1, d.c.d<? super String> r2);

    boolean isAppIntentActive();

    void onAuthBegin(String r1, int r2);

    void onAuthEnd(String r1);

    void onIntentDispatched(String r1);

    void onIntentEnded(String r1);

    void onMessageInterrupt(String r1);

    void onMessageTimeout(String r1);

    void onProcessDead(String r1, Map<String, String> r2);

    void onQueryInput(String r1, String r2);

    void onResponseToServer(String r1);

    void onResultReceived(String r1, f r2);

    void onShowingResult(String r1);

    void onSummarize(String r1);

    void recordASRDuration(String r1, long r2, String r4);

    void recordAudioInfo(String r1, String r2, String r3);

    void reportPermissionGranted(String r1, String r2, boolean r3, String r4);

    void setAppStateEndTime(String r1);
}
