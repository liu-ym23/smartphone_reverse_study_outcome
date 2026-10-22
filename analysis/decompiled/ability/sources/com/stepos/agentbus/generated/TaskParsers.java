package com.stepos.agentbus.generated;

import D7.w;
import H4.o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0019\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00122\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J \u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0002J\u001c\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentbus/generated/TaskParsers;", "", AppAgent.CONSTRUCT, "()V", "parseTask", "Lcom/stepos/agentbus/generated/Task;", "map", "", "", "toLong", "", "value", "toNullableLong", "(Ljava/lang/Object;)Ljava/lang/Long;", "parseQuestion", "Lcom/stepos/agentbus/generated/Question;", "m", "parsePendingQuestions", "", "parsePendingInquiry", "parsePendingInquiryItem", "inquiry", "parseTaskArtifact", "Lcom/stepos/agentbus/generated/TaskArtifact;", "parseToolCall", "Lcom/stepos/agentbus/generated/TaskToolCall;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskParsers {
    public static final TaskParsers INSTANCE = new TaskParsers();

    private TaskParsers() {
    }

    private final List<Question> parsePendingInquiry(Object value) {
        if (!(value instanceof List)) {
            if (value instanceof Map) {
                k.d(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                Question pendingInquiryItem = parsePendingInquiryItem((Map) value);
                if (pendingInquiryItem != null) {
                    return o.M(pendingInquiryItem);
                }
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) value) {
            Map<String, ? extends Object> map = obj instanceof Map ? (Map) obj : null;
            Question pendingInquiryItem2 = map != null ? INSTANCE.parsePendingInquiryItem(map) : null;
            if (pendingInquiryItem2 != null) {
                arrayList.add(pendingInquiryItem2);
            }
        }
        return arrayList;
    }

    private final Question parsePendingInquiryItem(Map<String, ? extends Object> inquiry) {
        Option option;
        Object obj = inquiry.get("question");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = inquiry.get("choices");
        List list = obj2 instanceof List ? (List) obj2 : null;
        if (str != null && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                String str2 = obj3 instanceof String ? (String) obj3 : null;
                Option option2 = str2 != null ? new Option(str2, "") : null;
                if (option2 != null) {
                    arrayList.add(option2);
                }
            }
            Object obj4 = inquiry.get("allowMultiple");
            Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            return new Question(str, "", arrayList, Boolean.valueOf(bool != null ? bool.booleanValue() : false));
        }
        Object obj5 = inquiry.get(HighlightArgsBundle.KEY_PROMPT);
        String str3 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = inquiry.get("title");
        String str4 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = inquiry.get("choices");
        List list2 = obj7 instanceof List ? (List) obj7 : null;
        if (str3 == null || list2 == null || list2.isEmpty()) {
            return null;
        }
        if (str4 == null) {
            str4 = "";
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj8 : list2) {
            Map map = obj8 instanceof Map ? (Map) obj8 : null;
            if (map != null) {
                Object obj9 = map.get("value");
                String str5 = obj9 instanceof String ? (String) obj9 : null;
                if (str5 == null) {
                    str5 = "";
                }
                Object obj10 = map.get("detail");
                String str6 = obj10 instanceof String ? (String) obj10 : null;
                if (str6 == null) {
                    str6 = "";
                }
                option = new Option(str5, str6);
            } else {
                option = null;
            }
            if (option != null) {
                arrayList2.add(option);
            }
        }
        return new Question(str3, str4, arrayList2, Boolean.FALSE);
    }

    private final List<Question> parsePendingQuestions(Map<String, ? extends Object> map) {
        Object obj = map.get("pendingQuestions");
        List list = obj instanceof List ? (List) obj : null;
        Object obj2 = map.get("pendingInquiry");
        if (obj2 == null) {
            obj2 = null;
        }
        if (obj2 != null) {
            return parsePendingInquiry(obj2);
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            Map<String, ? extends Object> map2 = obj3 instanceof Map ? (Map) obj3 : null;
            Question question = map2 != null ? INSTANCE.parseQuestion(map2) : null;
            if (question != null) {
                arrayList.add(question);
            }
        }
        return arrayList;
    }

    private final long toLong(Object value) {
        Long lG0;
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        if (!(value instanceof String) || (lG0 = t.g0((String) value)) == null) {
            return 0L;
        }
        return lG0.longValue();
    }

    private final Long toNullableLong(Object value) {
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (value instanceof String) {
            return t.g0((String) value);
        }
        return null;
    }

    public final Question parseQuestion(Map<String, ? extends Object> m) {
        k.f(m, "m");
        Object obj = m.get("question");
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = m.get("header");
        k.d(obj2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj2;
        Object obj3 = m.get("options");
        k.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List list = (List) obj3;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (Object obj4 : list) {
            k.d(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            Map map = (Map) obj4;
            Object obj5 = map.get("label");
            k.d(obj5, "null cannot be cast to non-null type kotlin.String");
            Object obj6 = map.get("description");
            k.d(obj6, "null cannot be cast to non-null type kotlin.String");
            arrayList.add(new Option((String) obj5, (String) obj6));
        }
        return new Question(str, str2, arrayList, (Boolean) m.get("multiSelect"));
    }

    public final Task parseTask(Map<String, ? extends Object> map) {
        TaskStatus taskStatusFromWire;
        TaskProgress taskProgress;
        List arrayList;
        List arrayList2;
        ArrayList arrayList3;
        k.f(map, "map");
        Object obj = map.get(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        String str2 = (String) map.get("parentTaskId");
        String str3 = (String) map.get("sessionKey");
        String str4 = (String) map.get("requestSessionKey");
        Object obj2 = map.get("title");
        String str5 = obj2 instanceof String ? (String) obj2 : null;
        String str6 = str5 == null ? "" : str5;
        Object obj3 = map.get("subTitle");
        String str7 = obj3 instanceof String ? (String) obj3 : null;
        String str8 = str7 == null ? "" : str7;
        Object obj4 = map.get("type");
        String str9 = obj4 instanceof String ? (String) obj4 : null;
        String str10 = str9 == null ? "" : str9;
        Object obj5 = map.get("status");
        String str11 = obj5 instanceof String ? (String) obj5 : null;
        if (str11 == null || (taskStatusFromWire = TaskStatus.INSTANCE.fromWire(str11)) == null) {
            taskStatusFromWire = TaskStatus.CREATED;
        }
        TaskStatus taskStatus = taskStatusFromWire;
        Object obj6 = map.get("progress");
        Map map2 = obj6 instanceof Map ? (Map) obj6 : null;
        if (map2 != null) {
            Object obj7 = map2.get("total");
            Number number = obj7 instanceof Number ? (Number) obj7 : null;
            int iIntValue = number != null ? number.intValue() : 0;
            Object obj8 = map2.get(FlowType.COMPLETED);
            Number number2 = obj8 instanceof Number ? (Number) obj8 : null;
            int iIntValue2 = number2 != null ? number2.intValue() : 0;
            Object obj9 = map2.get("inProgress");
            Number number3 = obj9 instanceof Number ? (Number) obj9 : null;
            int iIntValue3 = number3 != null ? number3.intValue() : 0;
            Object obj10 = map2.get("pending");
            Number number4 = obj10 instanceof Number ? (Number) obj10 : null;
            int iIntValue4 = number4 != null ? number4.intValue() : 0;
            Object obj11 = map2.get(FlowType.FAILED);
            Number number5 = obj11 instanceof Number ? (Number) obj11 : null;
            taskProgress = new TaskProgress(iIntValue2, iIntValue, number5 != null ? number5.intValue() : 0, iIntValue3, iIntValue4);
        } else {
            taskProgress = null;
        }
        Object obj12 = map.get("artifacts");
        List list = obj12 instanceof List ? (List) obj12 : null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj13 : list) {
                Map<String, ? extends Object> map3 = obj13 instanceof Map ? (Map) obj13 : null;
                TaskArtifact taskArtifact = map3 != null ? INSTANCE.parseTaskArtifact(map3) : null;
                if (taskArtifact != null) {
                    arrayList.add(taskArtifact);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        String str12 = (String) map.get("summary");
        List<Question> pendingQuestions = parsePendingQuestions(map);
        String str13 = (String) map.get("intention");
        Object obj14 = map.get("subTaskIds");
        List list2 = obj14 instanceof List ? (List) obj14 : null;
        if (list2 != null) {
            arrayList2 = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = it;
                String str14 = next instanceof String ? (String) next : null;
                if (str14 != null) {
                    arrayList2.add(str14);
                }
                it = it2;
            }
        } else {
            arrayList2 = EmptyList.f4893a;
        }
        Object obj15 = map.get("subTasks");
        List list3 = obj15 instanceof List ? (List) obj15 : null;
        if (list3 != null) {
            arrayList3 = new ArrayList();
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                List list4 = arrayList2;
                Object next2 = it3.next();
                Iterator it4 = it3;
                Map<String, ? extends Object> map4 = next2 instanceof Map ? (Map) next2 : null;
                Task task = map4 != null ? INSTANCE.parseTask(map4) : null;
                if (task != null) {
                    arrayList3.add(task);
                }
                arrayList2 = list4;
                it3 = it4;
            }
        } else {
            arrayList3 = null;
        }
        List list5 = arrayList2;
        long j5 = toLong(map.get("createdAt"));
        long j6 = toLong(map.get("updatedAt"));
        Long nullableLong = toNullableLong(map.get("startedAt"));
        Long nullableLong2 = toNullableLong(map.get("endedAt"));
        Object obj16 = map.get("version");
        Number number6 = obj16 instanceof Number ? (Number) obj16 : null;
        Integer numValueOf = number6 != null ? Integer.valueOf(number6.intValue()) : null;
        Object obj17 = map.get("taskVersion");
        Number number7 = obj17 instanceof Number ? (Number) obj17 : null;
        int iIntValue5 = number7 != null ? number7.intValue() : 0;
        Object obj18 = map.get("activeTaskVersion");
        Number number8 = obj18 instanceof Number ? (Number) obj18 : null;
        int iIntValue6 = number8 != null ? number8.intValue() : 0;
        Object obj19 = map.get("noTaskDetail");
        Boolean bool = obj19 instanceof Boolean ? (Boolean) obj19 : null;
        return new Task(str, str2, str3, str4, str6, str8, str10, taskStatus, taskProgress, arrayList, str12, pendingQuestions, str13, list5, arrayList3, j5, j6, nullableLong, nullableLong2, numValueOf, iIntValue5, iIntValue6, bool != null ? bool.booleanValue() : false, null);
    }

    public final TaskArtifact parseTaskArtifact(Map<String, ? extends Object> m) {
        k.f(m, "m");
        Object obj = m.get("artifactId");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = m.get("status");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = m.get("type");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = m.get("contentType");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = m.get("fileId");
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = m.get("content");
        String str6 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = m.get("fileName");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = m.get("title");
        String str8 = obj8 instanceof String ? (String) obj8 : null;
        Object obj9 = m.get("mimeType");
        String str9 = obj9 instanceof String ? (String) obj9 : null;
        Object obj10 = m.get("size");
        Number number = obj10 instanceof Number ? (Number) obj10 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj11 = m.get("sha256");
        String str10 = obj11 instanceof String ? (String) obj11 : null;
        Object obj12 = m.get("taskVersion");
        Number number2 = obj12 instanceof Number ? (Number) obj12 : null;
        int iIntValue = number2 != null ? number2.intValue() : 0;
        Object obj13 = m.get("errorReason");
        String str11 = obj13 instanceof String ? (String) obj13 : null;
        Object obj14 = m.get("errorDetail");
        return new TaskArtifact(str, str2, str3, str4, str5, str6, str7, str8, str9, lValueOf, str10, iIntValue, str11, obj14 instanceof String ? (String) obj14 : null);
    }

    public final TaskToolCall parseToolCall(Map<String, ? extends Object> m) {
        k.f(m, "m");
        Object obj = m.get("callId");
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        Object obj2 = m.get(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
        k.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = m.get("toolName");
        k.d(obj3, "null cannot be cast to non-null type kotlin.String");
        Object obj4 = m.get(TypedValues.CycleType.S_WAVE_PHASE);
        k.d(obj4, "null cannot be cast to non-null type kotlin.String");
        String upperCase = ((String) obj4).toUpperCase(Locale.ROOT);
        k.e(upperCase, "toUpperCase(...)");
        ToolCallPhase toolCallPhaseValueOf = ToolCallPhase.valueOf(upperCase);
        Object obj5 = m.get("ts");
        k.d(obj5, "null cannot be cast to non-null type kotlin.Number");
        return new TaskToolCall((String) obj, (String) obj2, (String) obj3, toolCallPhaseValueOf, ((Number) obj5).longValue(), (Map) m.get("args"), (Map) m.get("result"), (Map) m.get("extensions"));
    }
}
