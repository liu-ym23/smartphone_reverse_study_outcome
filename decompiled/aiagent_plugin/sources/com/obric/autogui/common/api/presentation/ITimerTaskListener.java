package com.obric.autogui.common.api.presentation;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ITimerTaskListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ITimerTaskListener {

    /* JADX INFO: compiled from: ITimerTaskListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onTimerTaskRemoved$default(ITimerTaskListener r2, List r3, boolean r4, int r5, Object r6) {
            ITimerTaskListener r7 = (ITimerTaskListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskListener.class, "com.obric.aiagent.plugin");
            List<TimerTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = false;
        L7:
            r7.onTimerTaskRemoved(r8, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTimerTaskRemoved");
        }
    }

    /* JADX INFO: compiled from: ITimerTaskListener.kt */
    public static final class TimerTask {
        private final String action;
        private final Map<String, String> ext;
        private final String id;

        public TimerTask(String r3, String r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DbHelper.COL_ID);
            o.e(r4, "action");
            this.id = r3;
            this.action = r4;
            this.ext = r6;
        }

        public final String getId() {
            return this.id;
        }

        public final String getAction() {
            return this.action;
        }

        public final Map<String, String> getExt() {
            return this.ext;
        }
    }

    void onTimerTaskRemoved(List<TimerTask> r1, boolean r2);
}
