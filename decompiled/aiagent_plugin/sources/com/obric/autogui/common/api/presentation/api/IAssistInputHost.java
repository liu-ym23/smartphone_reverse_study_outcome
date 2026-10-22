package com.obric.autogui.common.api.presentation.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: IAssistInputHost.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAssistInputHost {

    /* JADX INFO: compiled from: IAssistInputHost.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void openInput$default(IAssistInputHost r2, boolean r3, Map r4, int r5, Object r6) {
            IAssistInputHost r7 = (IAssistInputHost) ZeusTransformUtils.wrapperContextForParams(r2, IAssistInputHost.class, "com.obric.aiagent.plugin");
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r8 = null;
        L7:
            r7.openInput(r3, r8);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openInput");
        }

        public static /* synthetic */ void openInput$default(IAssistInputHost r2, String r3, String r4, Map r5, int r6, Object r7) {
            IAssistInputHost r8 = (IAssistInputHost) ZeusTransformUtils.wrapperContextForParams(r2, IAssistInputHost.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r9 = null;
        L7:
            r8.openInput(r3, r4, r9);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openInput");
        }
    }

    /* JADX INFO: compiled from: IAssistInputHost.kt */
    public static final class RequestType {
        public static final int ADDITION = 2;
        public static final int CLARIFY = 1;
        public static final int CREATE = 0;
        public static final RequestType INSTANCE = null;

        static {
            INSTANCE = new RequestType();
        }

        private RequestType() {
        }
    }

    /* JADX INFO: compiled from: IAssistInputHost.kt */
    public static final class TaskType {
        public static final TaskType INSTANCE = null;
        public static final String TASK_TYPE_AUTO_GUI = "auto_gui";
        public static final String TASK_TYPE_AUTO_TIMER_TASK = "auto_timer_task";
        public static final String TASK_TYPE_COMPLEX_TASK = "complex_task";

        static {
            INSTANCE = new TaskType();
        }

        private TaskType() {
        }
    }

    void cancelInput();

    void closeInput();

    void completedInput(IAssistInputStateManager.AssistInputMode r1, String r2);

    void openInput(String r1, String r2, Map<String, String> r3);

    void openInput(boolean r1, Map<String, String> r2);

    void startInput();
}
