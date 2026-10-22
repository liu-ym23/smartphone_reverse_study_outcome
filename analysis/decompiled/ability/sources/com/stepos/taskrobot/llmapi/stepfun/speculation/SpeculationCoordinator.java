package com.stepos.taskrobot.llmapi.stepfun.speculation;

import B7.a;
import D7.q;
import D7.v;
import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Action;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SpeculationLabel;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult;
import f6.AbstractC1436a;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J8\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/speculation/SpeculationCoordinator;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "RETRIEVE_TIMEOUT_MS", "", "gson", "Lcom/google/gson/Gson;", "REAL_ACTION_WHITELIST", "", "isRealAction", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Action;", "selectTopVerifiedPair", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "verifiedPairs", "", "filterCandidatePool", "pool", "currentAction", "currentParams", "", "buildPoolFromSearchResult", "searchResult", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "actionToStepAction", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;", "taskKey", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "parseActions", "actionsJson", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpeculationCoordinator {
    private static final long RETRIEVE_TIMEOUT_MS = 5000;
    private static final String TAG = "SpeculationCoordinator";
    public static final SpeculationCoordinator INSTANCE = new SpeculationCoordinator();
    private static final Gson gson = new Gson();
    private static final Set<String> REAL_ACTION_WHITELIST = q.K0(new String[]{RequestInfo.FUNCTION_CLICK, "longclick", RequestInfo.FUNCTION_SWIPE, "input", "openapp", "openApp", "systemnavigation_back", "systemnavigation_home", "systemnavigation_enter", "systemnavigation_recentapps", "pressback", "presshome", "pressenter", "pressrecentapp"});

    private SpeculationCoordinator() {
    }

    private final Step2RetrieveResult.StepAction actionToStepAction(Action action, Step2RetrieveResult.TaskKey taskKey) {
        Step2RetrieveResult.SpeculationLabel speculationLabel;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!action.getPoint().isEmpty()) {
            linkedHashMap.put("point", action.getPoint());
        }
        if (action.getValue().length() > 0) {
            linkedHashMap.put("value", action.getValue());
        }
        SpeculationLabel speculationLabel2 = action.getSpeculationLabel();
        if (speculationLabel2 != null) {
            List<SpeculationLabel.Label> labels = speculationLabel2.getLabels();
            ArrayList arrayList = new ArrayList(w.c0(labels, 10));
            for (SpeculationLabel.Label label : labels) {
                arrayList.add(new Step2RetrieveResult.SpeculationLabel.Label(Integer.valueOf(label.getStep()), label.isSpeculation(), Double.valueOf(label.getSpecConfidence()), label.getSpecReason()));
            }
            speculationLabel = new Step2RetrieveResult.SpeculationLabel(arrayList);
        } else {
            speculationLabel = null;
        }
        Step2RetrieveResult.SpeculationLabel speculationLabel3 = speculationLabel;
        Integer numValueOf = Integer.valueOf(action.getId());
        String explain = action.getExplain();
        String upperCase = action.getAction().toUpperCase(Locale.ROOT);
        k.e(upperCase, "toUpperCase(...)");
        return new Step2RetrieveResult.StepAction(taskKey, numValueOf, explain, upperCase, action.getSummary(), linkedHashMap, speculationLabel3);
    }

    private final boolean isRealAction(Action action) {
        return REAL_ACTION_WHITELIST.contains(action.getAction());
    }

    private final List<Action> parseActions(String actionsJson) {
        Object objA;
        try {
            objA = (List) gson.fromJson(actionsJson, new TypeToken<List<? extends Action>>() { // from class: com.stepos.taskrobot.llmapi.stepfun.speculation.SpeculationCoordinator$parseActions$1$type$1
            }.getType());
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "parseActions failed: " + thA.getMessage(), true);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (List) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.ArrayList] */
    public final List<Step2RetrieveResult.StepCandidatePair> buildPoolFromSearchResult(SearchExperienceResult searchResult) {
        ?? arrayList;
        boolean zIsSpeculation;
        k.f(searchResult, "searchResult");
        ArrayList arrayList2 = new ArrayList();
        for (SearchExperienceResult.Result result : searchResult.getResult()) {
            List<Action> actions = parseActions(result.getActions());
            if (actions == null) {
                AbstractC1436a.e(TAG, "buildPool: failed to parse actions for taskId=" + result.getTaskId(), true);
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : actions) {
                    if (INSTANCE.isRealAction((Action) obj)) {
                        arrayList3.add(obj);
                    }
                }
                String taskId = result.getTaskId();
                String strN0 = m.N0(30, result.getTaskDesc());
                int size = actions.size();
                int size2 = arrayList3.size();
                StringBuilder sbW = a.w("buildPool: taskId=", taskId, " taskDesc=", strN0, " totalActions=");
                sbW.append(size);
                sbW.append(" realActions=");
                sbW.append(size2);
                AbstractC1436a.a(TAG, sbW.toString(), true);
                if (arrayList3.size() >= 2) {
                    Step2RetrieveResult.TaskKey taskKey = new Step2RetrieveResult.TaskKey(result.getTaskId(), null, null, result.getTaskDesc(), null, Double.valueOf(1.0d), 22, null);
                    int size3 = arrayList3.size() - 1;
                    int i = 0;
                    while (i < size3) {
                        Action action = (Action) arrayList3.get(i);
                        i++;
                        Action action2 = (Action) arrayList3.get(i);
                        Step2RetrieveResult.StepAction stepActionActionToStepAction = actionToStepAction(action, taskKey);
                        Step2RetrieveResult.StepAction stepActionActionToStepAction2 = actionToStepAction(action2, taskKey);
                        List<Map<String, Object>> regionXmlInfo = action2.getRegionXmlInfo();
                        if (regionXmlInfo != null) {
                            List<Map<String, Object>> list = regionXmlInfo;
                            arrayList = new ArrayList(w.c0(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                Map map = (Map) it.next();
                                k.d(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                                arrayList.add(map);
                            }
                        } else {
                            arrayList = EmptyList.f4893a;
                        }
                        List list2 = arrayList;
                        SpeculationLabel speculationLabel = action2.getSpeculationLabel();
                        if (speculationLabel != null) {
                            SpeculationLabel.Label label = (SpeculationLabel.Label) v.C0(speculationLabel.getLabels());
                            zIsSpeculation = label != null ? label.isSpeculation() : true;
                        } else {
                            zIsSpeculation = true;
                        }
                        Step2RetrieveResult.TaskKey taskKey2 = taskKey;
                        taskKey = taskKey2;
                        arrayList2.add(new Step2RetrieveResult.StepCandidatePair(taskKey2, stepActionActionToStepAction, stepActionActionToStepAction2, list2, null, null, null, null, zIsSpeculation, 240, null));
                    }
                }
            }
        }
        AbstractC1436a.a(TAG, "buildPool: total pool size=" + arrayList2.size(), true);
        return arrayList2;
    }

    public final List<Step2RetrieveResult.StepCandidatePair> filterCandidatePool(List<Step2RetrieveResult.StepCandidatePair> pool, String currentAction, Map<String, ? extends Object> currentParams) {
        k.f(pool, "pool");
        k.f(currentAction, "currentAction");
        k.f(currentParams, "currentParams");
        if (pool.isEmpty()) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = pool.iterator();
        while (true) {
            boolean zMatchAction$default = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Step2RetrieveResult.StepAction matchedStep = ((Step2RetrieveResult.StepCandidatePair) next).getMatchedStep();
            if (matchedStep != null) {
                ActionNormalizer actionNormalizer = ActionNormalizer.INSTANCE;
                String action = matchedStep.getAction();
                if (action == null) {
                    action = "";
                }
                zMatchAction$default = ActionNormalizer.matchAction$default(actionNormalizer, currentAction, currentParams, action, matchedStep.getActionParams(), 0.0d, 16, null);
            }
            if (zMatchAction$default) {
                arrayList.add(next);
            }
        }
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(pool.size(), "filterCandidatePool: poolSize=", arrayList.size(), " actionMatched=", " action=");
        sbS.append(currentAction);
        AbstractC1436a.a(TAG, sbS.toString(), true);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            Step2RetrieveResult.StepCandidatePair stepCandidatePair = (Step2RetrieveResult.StepCandidatePair) next2;
            if (stepCandidatePair.isSpeculate() && !stepCandidatePair.getNextStepUiXmlInfos().isEmpty()) {
                arrayList2.add(next2);
            }
        }
        AbstractC1436a.a(TAG, "filterCandidatePool: specPending=" + arrayList2.size() + " (isSpeculate=true && hasXml)", true);
        return arrayList2;
    }

    public final Step2RetrieveResult.StepCandidatePair selectTopVerifiedPair(List<Step2RetrieveResult.StepCandidatePair> verifiedPairs) {
        Double taskSim;
        Double taskSim2;
        Object obj;
        k.f(verifiedPairs, "verifiedPairs");
        Iterator<T> it = verifiedPairs.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Step2RetrieveResult.TaskKey taskKey = ((Step2RetrieveResult.StepCandidatePair) next).getTaskKey();
                double dDoubleValue = (taskKey == null || (taskSim2 = taskKey.getTaskSim()) == null) ? 0.0d : taskSim2.doubleValue();
                do {
                    Object next2 = it.next();
                    Step2RetrieveResult.TaskKey taskKey2 = ((Step2RetrieveResult.StepCandidatePair) next2).getTaskKey();
                    double dDoubleValue2 = (taskKey2 == null || (taskSim = taskKey2.getTaskSim()) == null) ? 0.0d : taskSim.doubleValue();
                    if (Double.compare(dDoubleValue, dDoubleValue2) < 0) {
                        next = next2;
                        dDoubleValue = dDoubleValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Step2RetrieveResult.StepCandidatePair) obj;
    }
}
