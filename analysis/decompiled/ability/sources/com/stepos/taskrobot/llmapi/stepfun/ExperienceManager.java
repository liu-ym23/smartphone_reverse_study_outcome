package com.stepos.taskrobot.llmapi.stepfun;

import D7.q;
import D7.v;
import D7.w;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Action;
import f6.AbstractC1436a;
import f6.C1437b;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.json.HTTP;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 J?\u0010&\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00172\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J&\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060/2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0086@¢\u0006\u0004\b0\u00101J\u001e\u00108\u001a\b\u0012\u0004\u0012\u0002050/2\u0006\u00104\u001a\u000203H\u0086@¢\u0006\u0004\b6\u00107J\u001e\u0010>\u001a\b\u0012\u0004\u0012\u00020;0/2\u0006\u0010:\u001a\u000209H\u0086@¢\u0006\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001f\u0010E\u001a\n D*\u0004\u0018\u00010C0C8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\b+\u0010MR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ExperienceManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "fileName", "content", "LC7/r;", "writeEvidence", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "guiAction", "", "isRealAction", "(Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;)Z", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Action;", "actions", "fixClickInputExplain", "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "getScreenSize", "(Landroid/content/Context;)Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "message", "parseSummaryFromLlmChat", "(Ljava/lang/String;)Ljava/lang/String;", "allActions", "", "buildSummaryMap", "(Ljava/util/List;)Ljava/util/Map;", "", "index", "screenSize", "summary", "appName", "convertToAction", "(ILcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Action;", "syncFromSp", "(Landroid/content/Context;)V", "enabled", "setExperienceEnable", "(Landroid/content/Context;Z)V", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "guiTaskRecord", "Lkotlin/Result;", "injectExperience-0E7RQCE", "(Landroid/content/Context;Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;LH7/c;)Ljava/lang/Object;", "injectExperience", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceRequest;", "experienceRequest", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "searchExperience-gIAlu-s", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceRequest;LH7/c;)Ljava/lang/Object;", "searchExperience", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceRequest;", "deleteExperienceRequest", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceResponse;", "deleteExperience-gIAlu-s", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceRequest;LH7/c;)Ljava/lang/Object;", "deleteExperience", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "experienceEnable", "Z", "getExperienceEnable", "()Z", "(Z)V", "", "REAL_ACTION_WHITELIST", "Ljava/util/Set;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExperienceManager {
    private static final Set<String> REAL_ACTION_WHITELIST;
    private static volatile boolean experienceEnable;
    public static final ExperienceManager INSTANCE = new ExperienceManager();
    private static final String TAG = "ExperienceManager";
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    static {
        Actions actions = Actions.INSTANCE;
        REAL_ACTION_WHITELIST = q.K0(new String[]{actions.getCLICK_ACTION(), RequestInfo.FUNCTION_LONG_CLICK, actions.getSWIPE(), actions.getINPUT_ACTION(), actions.getOPEN_APP_ACTION(), "openApp", "systemNavigation_back", "systemNavigation_home", "systemNavigation_enter", "systemNavigation_recentApps", actions.getPRESS_BACK_ACTION(), actions.getPRESS_HOME_ACTION(), actions.getPRESS_ENTER_ACTION(), actions.getPRESS_RECENTAPP_ACTION()});
    }

    private ExperienceManager() {
    }

    private final Map<GuiActionRecord, String> buildSummaryMap(List<GuiActionRecord> allActions) {
        GuiActionRecord next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<GuiActionRecord> it = allActions.iterator();
        while (true) {
            String str = null;
            while (it.hasNext()) {
                next = it.next();
                if (kotlin.jvm.internal.k.b(next.getActionType(), "llm_chat")) {
                    String summaryFromLlmChat = parseSummaryFromLlmChat(next.getMessage());
                    if (summaryFromLlmChat != null) {
                        str = summaryFromLlmChat;
                    }
                } else if (!isRealAction(next) || str == null) {
                }
            }
            return linkedHashMap;
            linkedHashMap.put(next, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.taskrobot.taskmanager.experiencelib.model.Action convertToAction(int r23, com.stepos.taskrobot.llmapi.stepfun.GuiActionRecord r24, com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer.ScreenSize r25, java.lang.String r26, java.lang.String r27) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.convertToAction(int, com.stepos.taskrobot.llmapi.stepfun.GuiActionRecord, com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer$ScreenSize, java.lang.String, java.lang.String):com.stepos.taskrobot.taskmanager.experiencelib.model.Action");
    }

    public static /* synthetic */ Action convertToAction$default(ExperienceManager experienceManager, int i, GuiActionRecord guiActionRecord, ActionNormalizer.ScreenSize screenSize, String str, String str2, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            str = null;
        }
        if ((i6 & 16) != 0) {
            str2 = null;
        }
        return experienceManager.convertToAction(i, guiActionRecord, screenSize, str, str2);
    }

    private final List<Action> fixClickInputExplain(List<Action> actions) {
        String explain;
        String explain2;
        if (actions.size() < 2) {
            return actions;
        }
        ArrayList arrayListG1 = v.g1(actions);
        int size = arrayListG1.size() - 1;
        int i = 0;
        while (i < size) {
            Action action = (Action) arrayListG1.get(i);
            int i6 = i + 1;
            Action action2 = (Action) arrayListG1.get(i6);
            if (kotlin.jvm.internal.k.b(action.getAction(), RequestInfo.FUNCTION_CLICK) && kotlin.jvm.internal.k.b(action2.getAction(), "input") && kotlin.jvm.internal.k.b(action.getPoint(), action2.getPoint()) && (explain = action.getExplain()) != null && !j9.m.s0(explain) && ((explain2 = action2.getExplain()) == null || j9.m.s0(explain2))) {
                arrayListG1.set(i6, Action.copy$default(action2, null, action.getExplain(), null, 0, null, false, null, null, null, null, PointerIconCompat.TYPE_GRABBING, null));
                arrayListG1.set(i, Action.copy$default(action, null, null, null, 0, null, false, null, null, null, null, PointerIconCompat.TYPE_GRABBING, null));
                AbstractC1436a.a(TAG, androidx.compose.foundation.b.o(action.getId(), "fixClickInputExplain: transferred explain from action[", action2.getId(), "] to action[", "]"), true);
            }
            i = i6;
        }
        return arrayListG1;
    }

    private final ActionNormalizer.ScreenSize getScreenSize(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        Object systemService2 = context.getSystemService("window");
        kotlin.jvm.internal.k.d(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) systemService2).getDefaultDisplay().getRealMetrics(displayMetrics2);
        return new ActionNormalizer.ScreenSize(i, displayMetrics2.heightPixels);
    }

    private final boolean isRealAction(GuiActionRecord guiAction) {
        String actionResult;
        if (REAL_ACTION_WHITELIST.contains(guiAction.getActionType()) && (actionResult = guiAction.getActionResult()) != null) {
            String lowerCase = actionResult.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            if (j9.m.h0(lowerCase, "success", false)) {
                return true;
            }
        }
        return false;
    }

    private final String parseSummaryFromLlmChat(String message) {
        if (message == null || j9.m.s0(message)) {
            return null;
        }
        if (j9.m.h0(message, "</THINK>", true) || j9.m.h0(message, "</think>", false)) {
            message = j9.m.J0(message, "</THINK>", j9.m.J0(message, "</think>", message));
        }
        List listG = new Regex("[\t\n]+").g(t.c0(t.c0(t.c0(t.c0(message, "\\t", "\t"), HTTP.CRLF, "\n"), "\r", "\n"), "\n", "\t"));
        ArrayList arrayList = new ArrayList(w.c0(listG, 10));
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            arrayList.add(j9.m.R0((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (((String) next).length() > 0) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            if (j9.m.h0(str, ":", false)) {
                String string = j9.m.R0(j9.m.L0(str, ":")).toString();
                String string2 = j9.m.R0(j9.m.H0(str, ":", str)).toString();
                if (kotlin.jvm.internal.k.b(string, "summary") && !j9.m.s0(string2)) {
                    return string2;
                }
            }
        }
        return null;
    }

    private final void writeEvidence(Context context, String taskId, String fileName, String content) {
        TaskEvidenceStore.INSTANCE.writeText(context, taskId, fileName, content);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: deleteExperience-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7347deleteExperiencegIAlus(com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest r7, H7.c<? super kotlin.Result<com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$deleteExperience$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$deleteExperience$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$deleteExperience$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$deleteExperience$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$deleteExperience$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            java.lang.String r2 = "["
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 != r3) goto L31
            java.lang.Object r7 = r0.L$0
            com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest r7 = (com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest) r7
            kotlin.b.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.f4887a
            goto L83
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.b.b(r6)
            java.lang.String r6 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.TAG
            boolean r1 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.experienceEnable
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "experienceEnable "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            f6.AbstractC1436a.a(r6, r1, r3)
            boolean r1 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.experienceEnable
            if (r1 != 0) goto L61
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "experienceEnable is false"
            r6.<init>(r7)
            kotlin.Result$Failure r6 = kotlin.b.a(r6)
            return r6
        L61:
            java.lang.String r1 = r7.getTaskId()
            com.google.gson.Gson r4 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.gson
            java.lang.String r4 = r4.toJson(r7)
            java.lang.String r5 = "] deleteExperience request: "
            java.lang.String r1 = B7.a.n(r2, r1, r5, r4)
            f6.AbstractC1436a.a(r6, r1, r3)
            com.stepos.taskrobot.taskmanager.experiencelib.client.a r6 = F1.a.k()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.a(r7, r0)
            if (r6 != r8) goto L83
            return r8
        L83:
            boolean r8 = r6 instanceof kotlin.Result.Failure
            if (r8 != 0) goto La7
            r8 = r6
            com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse r8 = (com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse) r8
            java.lang.String r0 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.TAG
            java.lang.String r1 = r7.getTaskId()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            r4.append(r1)
            java.lang.String r1 = "] deleteExperience success: "
            r4.append(r1)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            f6.AbstractC1436a.a(r0, r8, r3)
        La7:
            java.lang.Throwable r8 = kotlin.Result.a(r6)
            if (r8 == 0) goto Lc0
            java.lang.String r0 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.TAG
            java.lang.String r7 = r7.getTaskId()
            java.lang.String r8 = r8.getMessage()
            java.lang.String r1 = "] deleteExperience failed: "
            java.lang.String r7 = B7.a.n(r2, r7, r1, r8)
            f6.AbstractC1436a.b(r0, r7, r3)
        Lc0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.m7347deleteExperiencegIAlus(com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest, H7.c):java.lang.Object");
    }

    public final boolean getExperienceEnable() {
        return experienceEnable;
    }

    public final Gson getGson() {
        return gson;
    }

    public final String getTAG() {
        return TAG;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(6:12|69|(1:71)|72|(3:74|(1:76)|77)|78)(2:13|14))(1:15))(2:16|(2:18|19)(5:20|(4:23|(2:25|82)(1:83)|26|21)|81|27|(2:29|30)(8:31|(1:33)(1:34)|35|(3:38|(1:40)(3:85|41|42)|36)|84|43|(1:46)|67)))|47|(12:49|(1:52)|(1:54)|79|56|(1:58)(1:59)|60|62|(1:64)|65|(6:68|69|(0)|72|(0)|78)|67)|55|79|56|(0)(0)|60|62|(0)|65|(0)|67) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x028c, code lost:
    
        r19 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* renamed from: injectExperience-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7348injectExperience0E7RQCE(android.content.Context r29, com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord r30, H7.c<? super kotlin.Result<java.lang.String>> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.m7348injectExperience0E7RQCE(android.content.Context, com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: searchExperience-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7349searchExperiencegIAlus(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest r18, H7.c<? super kotlin.Result<com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult>> r19) {
        /*
            r17 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$searchExperience$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$searchExperience$1 r1 = (com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$searchExperience$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1c
        L15:
            com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$searchExperience$1 r1 = new com.stepos.taskrobot.llmapi.stepfun.ExperienceManager$searchExperience$1
            r2 = r17
            r1.<init>(r2, r0)
        L1c:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L33
            java.lang.Object r1 = r1.L$0
            com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest r1 = (com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest) r1
            kotlin.b.b(r0)
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f4887a
            return r0
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.b.b(r0)
            java.lang.String r0 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.TAG
            java.lang.String r3 = "========== searchExperience start =========="
            f6.AbstractC1436a.a(r0, r3, r4)
            boolean r3 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.experienceEnable
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "experienceEnable: "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            f6.AbstractC1436a.a(r0, r3, r4)
            com.google.gson.Gson r3 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.gson
            r5 = r18
            java.lang.String r3 = r3.toJson(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "searchExperience request: "
            r6.<init>(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            f6.AbstractC1436a.a(r0, r3, r4)
            boolean r3 = com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.experienceEnable
            if (r3 != 0) goto L86
            java.lang.String r1 = "experienceEnable is false, skip searchExperience"
            f6.AbstractC1436a.a(r0, r1, r4)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "experienceEnable is false"
            r0.<init>(r1)
            kotlin.Result$Failure r0 = kotlin.b.a(r0)
            return r0
        L86:
            com.stepos.taskrobot.taskmanager.experiencelib.client.a r0 = F1.a.k()
            com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest r5 = new com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest
            java.lang.String r6 = r18.getUserId()
            java.lang.String r7 = r18.getAppName()
            java.lang.String r8 = r18.getAppVersion()
            java.lang.String r9 = r18.getDeviceType()
            java.lang.String r10 = r18.getFontSize()
            java.lang.String r11 = r18.getResolution()
            java.lang.String r12 = r18.getPixelLevel()
            java.lang.String r13 = r18.getTaskDesc()
            r15 = 256(0x100, float:3.59E-43)
            r16 = 0
            r14 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3 = 0
            r1.L$0 = r3
            r1.label = r4
            java.lang.Object r0 = r0.c(r5, r1)
            if (r0 != r2) goto Lc0
            return r2
        Lc0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ExperienceManager.m7349searchExperiencegIAlus(com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest, H7.c):java.lang.Object");
    }

    public final void setExperienceEnable(boolean z10) {
        experienceEnable = z10;
    }

    public final void syncFromSp(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        experienceEnable = C1437b.b.o(context).f4440a.getBoolean("experience_enable_v1", true);
    }

    public final void setExperienceEnable(Context context, boolean enabled) {
        kotlin.jvm.internal.k.f(context, "context");
        C1437b.b.o(context).f4440a.edit().putBoolean("experience_enable_v1", enabled).apply();
        experienceEnable = enabled;
    }
}
