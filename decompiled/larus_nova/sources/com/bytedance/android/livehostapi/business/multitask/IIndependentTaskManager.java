package com.bytedance.android.livehostapi.business.multitask;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/multitask/IIndependentTaskManager;", "", "getCurrentLocalSwitchStatus", "", "isMultiTaskOpen", "isMultiTaskServerConfigOpen", "isNewLiveActivity", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setLocalSwitchStatus", "", "checked", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IIndependentTaskManager {
    public static final Companion Companion = null;
    public static final String EXTRA_LIVE_INDEPENDENT_TASK_CLICK_ENTER_FLAG = "live_independent_task_click_enter_flag";
    public static final String EXTRA_LIVE_INDEPENDENT_TASK_CLICK_MODEL_FLAG = "live_independent_task_click_model_flag";
    public static final String EXTRA_LIVE_INDEPENDENT_TASK_RETURN_FIRST_FLAG = "live_independent_task_return_first_flag";
    public static final String NEED_CHECK_LIVE = "independent_task_need_check_live";
    public static final String SOURCE_PAUSE_INDEPENDENT_PREF = "IndependentTask";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/multitask/IIndependentTaskManager$Companion;", "", "()V", "EXTRA_LIVE_INDEPENDENT_TASK_CLICK_ENTER_FLAG", "", "EXTRA_LIVE_INDEPENDENT_TASK_CLICK_MODEL_FLAG", "EXTRA_LIVE_INDEPENDENT_TASK_RETURN_FIRST_FLAG", "NEED_CHECK_LIVE", "SOURCE_PAUSE_INDEPENDENT_PREF", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String EXTRA_LIVE_INDEPENDENT_TASK_CLICK_ENTER_FLAG = "live_independent_task_click_enter_flag";
        public static final String EXTRA_LIVE_INDEPENDENT_TASK_CLICK_MODEL_FLAG = "live_independent_task_click_model_flag";
        public static final String EXTRA_LIVE_INDEPENDENT_TASK_RETURN_FIRST_FLAG = "live_independent_task_return_first_flag";
        public static final String NEED_CHECK_LIVE = "independent_task_need_check_live";
        public static final String SOURCE_PAUSE_INDEPENDENT_PREF = "IndependentTask";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean getCurrentLocalSwitchStatus();

    boolean isMultiTaskOpen();

    boolean isMultiTaskServerConfigOpen();

    boolean isNewLiveActivity(Context r100);

    void setLocalSwitchStatus(boolean r100);
}
