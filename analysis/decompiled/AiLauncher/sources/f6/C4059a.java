package f6;

import Y8.j;
import Y8.t;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b8\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\tJ\u001d\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\tJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\b\b\u0002\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010&R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010&R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010&R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010&R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010&R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010&R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010&R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010&R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010&R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010&R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010&R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010&R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u0010&R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010&R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010&R\u0014\u0010;\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010&R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010&R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010&R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010&R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010&R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010&R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010&R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010&R\u0014\u0010C\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010&R\u0014\u0010D\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010&R\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010&R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010&R\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010&R\u0014\u0010H\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010&R\u0014\u0010I\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010&R\u0014\u0010J\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010&R\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010&R\u0014\u0010L\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010&R\u0014\u0010M\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010&R\u0014\u0010N\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010&R\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010&R\u0014\u0010P\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010&R\u0014\u0010Q\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010&R\u0014\u0010R\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010&R\u0014\u0010S\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010&R\u0014\u0010T\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010&R\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010&R\u0014\u0010V\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010&R\u0014\u0010W\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010&¨\u0006X"}, d2 = {"Lf6/a;", "", "<init>", "()V", "", "step", C4059a.PARAM_QUESTION, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)V", "buttonType", "inputContent", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "agreementType", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "", "fromHomeLauncher", "c", "(Z)V", "action", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/String;)V", "actionType", "f", "setupType", "status", "l", "k", "(Z)Ljava/lang/String;", "event", "", "attrs", "page", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "EVENT_PAGE_VIEW", "Ljava/lang/String;", "EVENT_BUTTON_CLICK", "EVENT_SETUP_RESULT", "EVENT_AGREEMENT_CLICK", "EVENT_INITQUESTION_ACTION", "EVENT_AIKEY_GUIDE_EXPOSE", "EVENT_AIKEY_GUIDE_ACTION", "PAGE_OOBE", "PAGE_DESKTOP", "PARAM_PAGE_NAME", "PARAM_STEP", "PARAM_QUESTION", "PARAM_BUTTON_TYPE", "PARAM_INPUT_CONTENT", "PARAM_SETUP_TYPE", "PARAM_STATUS", "PARAM_AGREEMENT_TYPE", "PARAM_ACTION_TYPE", "PARAM_SCENE", "PARAM_ACTION", "STEP_AGREEMENT", "STEP_AIKEY_WAKEUP", "STEP_WAKE_ANYWHERE", "STEP_VOICE_WAKEUP", "STEP_PREFERENCE", "STEP_SAVE_CONFIGURATION", "BUTTON_CONTINUE", "BUTTON_NEXT", "BUTTON_LATER", "BUTTON_SKIP", "BUTTON_GOT_IT", "BUTTON_BACK", "SETUP_AIKEY_WAKEUP", "STATUS_SUCCESS", "STATUS_FAIL", "AGREEMENT_USER_AGREEMENT_PRIVACY", "AGREEMENT_VOICEPRINT_AUTH", "AGREEMENT_EXPERIENCE_IMPROVEMENT_PLAN", "QUESTION_NICKNAME", "QUESTION_COMMON_STYLE", "QUESTION_MORE", "ACTION_TAG_SELECT", "ACTION_TAG_UNSELECT", "ACTION_CUSTOM_ADD", "ACTION_TEXT_INPUT", "SCENE_HOME_DESKTOP", "SCENE_THIRD_APP", "AIKEY_GUIDE_KNOW", "AIKEY_GUIDE_REAL_CLICK", "AIKEY_GUIDE_REAL_LONGPRESS", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: f6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4059a {
    public static final String ACTION_CUSTOM_ADD = "custom_add";
    public static final String ACTION_TAG_SELECT = "tag_select";
    public static final String ACTION_TAG_UNSELECT = "tag_unselect";
    public static final String ACTION_TEXT_INPUT = "text_input";
    public static final String AGREEMENT_EXPERIENCE_IMPROVEMENT_PLAN = "experience_improvement_plan";
    public static final String AGREEMENT_USER_AGREEMENT_PRIVACY = "user_agreement_privacy";
    public static final String AGREEMENT_VOICEPRINT_AUTH = "voiceprint_auth";
    public static final String AIKEY_GUIDE_KNOW = "know";
    public static final String AIKEY_GUIDE_REAL_CLICK = "real_click";
    public static final String AIKEY_GUIDE_REAL_LONGPRESS = "real_longpress";
    public static final String BUTTON_BACK = "back";
    public static final String BUTTON_CONTINUE = "continue";
    public static final String BUTTON_GOT_IT = "got_it";
    public static final String BUTTON_LATER = "later";
    public static final String BUTTON_NEXT = "next";
    public static final String BUTTON_SKIP = "skip";
    private static final String EVENT_AGREEMENT_CLICK = "oobe_agreement_click";
    private static final String EVENT_AIKEY_GUIDE_ACTION = "aikey_guide_action";
    private static final String EVENT_AIKEY_GUIDE_EXPOSE = "aikey_guide_expose";
    private static final String EVENT_BUTTON_CLICK = "oobe_button_click";
    private static final String EVENT_INITQUESTION_ACTION = "oobe_initquestion_action";
    private static final String EVENT_PAGE_VIEW = "oobe_page_view";
    private static final String EVENT_SETUP_RESULT = "oobe_setup_result";
    public static final C4059a INSTANCE = new C4059a();
    private static final String PAGE_DESKTOP = "desktop";
    private static final String PAGE_OOBE = "oobe";
    private static final String PARAM_ACTION = "action";
    private static final String PARAM_ACTION_TYPE = "action_type";
    private static final String PARAM_AGREEMENT_TYPE = "agreement_type";
    private static final String PARAM_BUTTON_TYPE = "button_type";
    private static final String PARAM_INPUT_CONTENT = "input_content";
    private static final String PARAM_PAGE_NAME = "page_name";
    private static final String PARAM_QUESTION = "question";
    private static final String PARAM_SCENE = "scene";
    private static final String PARAM_SETUP_TYPE = "setup_type";
    private static final String PARAM_STATUS = "status";
    private static final String PARAM_STEP = "step_form";
    public static final String QUESTION_COMMON_STYLE = "q2_common_style";
    public static final String QUESTION_MORE = "q3_more";
    public static final String QUESTION_NICKNAME = "q1_nickname";
    public static final String SCENE_HOME_DESKTOP = "home_desktop";
    public static final String SCENE_THIRD_APP = "third_app";
    public static final String SETUP_AIKEY_WAKEUP = "aikey_wakeup";
    public static final String STATUS_FAIL = "fail";
    public static final String STATUS_SUCCESS = "success";
    public static final String STEP_AGREEMENT = "ai_agreement_page";
    public static final String STEP_AIKEY_WAKEUP = "aikey_wakeup";
    public static final String STEP_PREFERENCE = "agent_init_question_page";
    public static final String STEP_SAVE_CONFIGURATION = "agent_init_running_page";
    public static final String STEP_VOICE_WAKEUP = "voice_wakeup";
    public static final String STEP_WAKE_ANYWHERE = "wake_anywhere";

    public static /* synthetic */ void e(C4059a c4059a, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        c4059a.d(str, str2, str3);
    }

    public static /* synthetic */ void h(C4059a c4059a, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        c4059a.g(str, str2);
    }

    public static /* synthetic */ void j(C4059a c4059a, String str, Map map, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = PAGE_OOBE;
        }
        c4059a.i(str, map, str2);
    }

    public final void a(String agreementType) {
        p.i(agreementType, "agreementType");
        j(this, EVENT_AGREEMENT_CLICK, kotlin.collections.a.m(j.a(PARAM_PAGE_NAME, PAGE_OOBE), j.a(PARAM_AGREEMENT_TYPE, agreementType)), null, 4, null);
    }

    public final void b(boolean fromHomeLauncher, String action) {
        p.i(action, "action");
        i(EVENT_AIKEY_GUIDE_ACTION, kotlin.collections.a.m(j.a(PARAM_PAGE_NAME, "desktop"), j.a("scene", k(fromHomeLauncher)), j.a("action", action)), "desktop");
    }

    public final void c(boolean fromHomeLauncher) {
        i(EVENT_AIKEY_GUIDE_EXPOSE, kotlin.collections.a.m(j.a(PARAM_PAGE_NAME, "desktop"), j.a("scene", k(fromHomeLauncher))), "desktop");
    }

    public final void d(String step, String buttonType, String inputContent) {
        p.i(step, "step");
        p.i(buttonType, "buttonType");
        Map mapC = Q.c();
        mapC.put(PARAM_PAGE_NAME, PAGE_OOBE);
        mapC.put(PARAM_STEP, step);
        mapC.put(PARAM_BUTTON_TYPE, buttonType);
        if (inputContent != null) {
            mapC.put(PARAM_INPUT_CONTENT, inputContent);
        }
        t tVar = t.f7040a;
        j(this, EVENT_BUTTON_CLICK, Q.b(mapC), null, 4, null);
    }

    public final void f(String question, String actionType) {
        p.i(question, "question");
        p.i(actionType, "actionType");
        j(this, EVENT_INITQUESTION_ACTION, kotlin.collections.a.m(j.a(PARAM_PAGE_NAME, PAGE_OOBE), j.a(PARAM_QUESTION, question), j.a(PARAM_ACTION_TYPE, actionType)), null, 4, null);
    }

    public final void g(String step, String question) {
        p.i(step, "step");
        Map mapC = Q.c();
        mapC.put(PARAM_PAGE_NAME, PAGE_OOBE);
        mapC.put(PARAM_STEP, step);
        if (question != null && question.length() != 0) {
            mapC.put(PARAM_QUESTION, question);
        }
        t tVar = t.f7040a;
        j(this, EVENT_PAGE_VIEW, Q.b(mapC), null, 4, null);
    }

    public final void i(String event, Map<String, String> attrs, String page) {
        C4148a.k("oobeAiTrack", event + " page=" + page + " " + attrs, false, 4, null);
        N.b(event, page, attrs);
    }

    public final String k(boolean fromHomeLauncher) {
        return fromHomeLauncher ? SCENE_HOME_DESKTOP : SCENE_THIRD_APP;
    }

    public final void l(String setupType, String status) {
        p.i(setupType, "setupType");
        p.i(status, "status");
        j(this, EVENT_SETUP_RESULT, kotlin.collections.a.m(j.a(PARAM_PAGE_NAME, PAGE_OOBE), j.a(PARAM_SETUP_TYPE, setupType), j.a("status", status)), null, 4, null);
    }
}
