package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b>\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0014\u0010(\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0014\u0010*\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0014\u0010.\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0014\u00100\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0014\u00102\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0014\u00104\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0014\u00106\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0014\u00108\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0014\u0010:\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0014\u0010<\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0014\u0010>\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/Actions;", "", AppAgent.CONSTRUCT, "()V", "START", "", "getSTART", "()Ljava/lang/String;", "SCREEN_SHOT", "getSCREEN_SHOT", "CLICK_ACTION", "getCLICK_ACTION", "LONG_CLICK_ACTION", "getLONG_CLICK_ACTION", "SWIPE", "getSWIPE", "KEY_EVENT", "getKEY_EVENT", "OPEN_APP_ACTION", "getOPEN_APP_ACTION", "PRESS_BACK_ACTION", "getPRESS_BACK_ACTION", "PRESS_HOME_ACTION", "getPRESS_HOME_ACTION", "PRESS_ENTER_ACTION", "getPRESS_ENTER_ACTION", "PRESS_RECENTAPP_ACTION", "getPRESS_RECENTAPP_ACTION", "INPUT_ACTION", "getINPUT_ACTION", "LLM_CHAT", "getLLM_CHAT", "START_END_ACTION", "getSTART_END_ACTION", "FINISH", "getFINISH", "ERROR", "getERROR", "CANCEL", "getCANCEL", "APP_NOT_FOUND", "getAPP_NOT_FOUND", "FOREGROUND_APP_CHANGE", "getFOREGROUND_APP_CHANGE", "TARGET_APP_DIED", "getTARGET_APP_DIED", "EXPLAIN", "getEXPLAIN", "TAKE_OVER", "getTAKE_OVER", "LLM_TAKE_OVER", "getLLM_TAKE_OVER", "RECOVER_FROM_TAKE_OVER", "getRECOVER_FROM_TAKE_OVER", "RECOVER_FROM_PAUSE", "getRECOVER_FROM_PAUSE", "PAUSE", "getPAUSE", "STATUS", "getSTATUS", "INFO", "getINFO", "INFO_DISMISSED", "getINFO_DISMISSED", "REQUEST_CHAT_INPUT", "REQUEST_CHAT_INPUT_FROM_HANDLE", "USER_CANCEL", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Actions {
    public static final String REQUEST_CHAT_INPUT = "request_chat_input";
    public static final String REQUEST_CHAT_INPUT_FROM_HANDLE = "request_chat_input_from_handle";
    public static final String USER_CANCEL = "user_cancel";
    public static final Actions INSTANCE = new Actions();
    private static final String START = "start";
    private static final String SCREEN_SHOT = "screenshot";
    private static final String CLICK_ACTION = RequestInfo.FUNCTION_CLICK;
    private static final String LONG_CLICK_ACTION = "long_click";
    private static final String SWIPE = RequestInfo.FUNCTION_SWIPE;
    private static final String KEY_EVENT = "keyevent";
    private static final String OPEN_APP_ACTION = "openapp";
    private static final String PRESS_BACK_ACTION = "pressback";
    private static final String PRESS_HOME_ACTION = "presshome";
    private static final String PRESS_ENTER_ACTION = "pressenter";
    private static final String PRESS_RECENTAPP_ACTION = "pressrecentapp";
    private static final String INPUT_ACTION = "input";
    private static final String LLM_CHAT = "llm_chat";
    private static final String START_END_ACTION = "startend";
    private static final String FINISH = "finish";
    private static final String ERROR = "error";
    private static final String CANCEL = "cancel";
    private static final String APP_NOT_FOUND = "app_not_found";
    private static final String FOREGROUND_APP_CHANGE = "foreground_app_change";
    private static final String TARGET_APP_DIED = "target_app_died";
    private static final String EXPLAIN = "explain";
    private static final String TAKE_OVER = "takeover";
    private static final String LLM_TAKE_OVER = "llm_takeover";
    private static final String RECOVER_FROM_TAKE_OVER = "recover_from_takeover";
    private static final String RECOVER_FROM_PAUSE = "recover_from_pause";
    private static final String PAUSE = "pause";
    private static final String STATUS = "status";
    private static final String INFO = "info";
    private static final String INFO_DISMISSED = "info_dismissed";

    private Actions() {
    }

    public final String getAPP_NOT_FOUND() {
        return APP_NOT_FOUND;
    }

    public final String getCANCEL() {
        return CANCEL;
    }

    public final String getCLICK_ACTION() {
        return CLICK_ACTION;
    }

    public final String getERROR() {
        return ERROR;
    }

    public final String getEXPLAIN() {
        return EXPLAIN;
    }

    public final String getFINISH() {
        return FINISH;
    }

    public final String getFOREGROUND_APP_CHANGE() {
        return FOREGROUND_APP_CHANGE;
    }

    public final String getINFO() {
        return INFO;
    }

    public final String getINFO_DISMISSED() {
        return INFO_DISMISSED;
    }

    public final String getINPUT_ACTION() {
        return INPUT_ACTION;
    }

    public final String getKEY_EVENT() {
        return KEY_EVENT;
    }

    public final String getLLM_CHAT() {
        return LLM_CHAT;
    }

    public final String getLLM_TAKE_OVER() {
        return LLM_TAKE_OVER;
    }

    public final String getLONG_CLICK_ACTION() {
        return LONG_CLICK_ACTION;
    }

    public final String getOPEN_APP_ACTION() {
        return OPEN_APP_ACTION;
    }

    public final String getPAUSE() {
        return PAUSE;
    }

    public final String getPRESS_BACK_ACTION() {
        return PRESS_BACK_ACTION;
    }

    public final String getPRESS_ENTER_ACTION() {
        return PRESS_ENTER_ACTION;
    }

    public final String getPRESS_HOME_ACTION() {
        return PRESS_HOME_ACTION;
    }

    public final String getPRESS_RECENTAPP_ACTION() {
        return PRESS_RECENTAPP_ACTION;
    }

    public final String getRECOVER_FROM_PAUSE() {
        return RECOVER_FROM_PAUSE;
    }

    public final String getRECOVER_FROM_TAKE_OVER() {
        return RECOVER_FROM_TAKE_OVER;
    }

    public final String getSCREEN_SHOT() {
        return SCREEN_SHOT;
    }

    public final String getSTART() {
        return START;
    }

    public final String getSTART_END_ACTION() {
        return START_END_ACTION;
    }

    public final String getSTATUS() {
        return STATUS;
    }

    public final String getSWIPE() {
        return SWIPE;
    }

    public final String getTAKE_OVER() {
        return TAKE_OVER;
    }

    public final String getTARGET_APP_DIED() {
        return TARGET_APP_DIED;
    }
}
