package com.stepos.agentbus.generated;

import La.C;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import a4.Option;
import a4.Question;
import a4.Task;
import a4.TaskArtifact;
import a4.TaskProgress;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00172\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentbus/generated/d;", "", "<init>", "()V", "", "", C3081a.FOCUS_MAP_NAME, "La4/A;", "e", "(Ljava/util/Map;)La4/A;", "m", "La4/y;", Const.INTENT_KEY_UMID, "(Ljava/util/Map;)La4/y;", "La4/B;", "f", "(Ljava/util/Map;)La4/B;", UxipConstants.f30680s, "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)Ljava/lang/Long;", "", "c", "(Ljava/util/Map;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Ljava/util/List;", "inquiry", Const.INTENT_KEY_PKGNAME, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f22322a = new d();

    public final List<Question> a(Object value) {
        if (!(value instanceof List)) {
            if (value instanceof Map) {
                p.g(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                Question questionB = b((Map) value);
                if (questionB != null) {
                    return C1172u.e(questionB);
                }
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) value) {
            Map<String, ? extends Object> map = obj instanceof Map ? (Map) obj : null;
            Question questionB2 = map != null ? f22322a.b(map) : null;
            if (questionB2 != null) {
                arrayList.add(questionB2);
            }
        }
        return arrayList;
    }

    public final Question b(Map<String, ? extends Object> inquiry) {
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
                Object obj9 = map.get(UxipConstants.f30680s);
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

    public final List<Question> c(Map<String, ? extends Object> map) {
        Object obj = map.get("pendingQuestions");
        List list = obj instanceof List ? (List) obj : null;
        Object obj2 = map.get("pendingInquiry");
        if (obj2 == null) {
            obj2 = null;
        }
        if (obj2 != null) {
            return a(obj2);
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            Map<String, ? extends Object> map2 = obj3 instanceof Map ? (Map) obj3 : null;
            Question questionD = map2 != null ? f22322a.d(map2) : null;
            if (questionD != null) {
                arrayList.add(questionD);
            }
        }
        return arrayList;
    }

    public final Question d(Map<String, ? extends Object> m10) {
        p.i(m10, "m");
        Object obj = m10.get("question");
        p.g(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = m10.get("header");
        p.g(obj2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj2;
        Object obj3 = m10.get("options");
        p.g(obj3, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List list = (List) obj3;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (Object obj4 : list) {
            p.g(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            Map map = (Map) obj4;
            Object obj5 = map.get("label");
            p.g(obj5, "null cannot be cast to non-null type kotlin.String");
            Object obj6 = map.get("description");
            p.g(obj6, "null cannot be cast to non-null type kotlin.String");
            arrayList.add(new Option((String) obj5, (String) obj6));
        }
        return new Question(str, str2, arrayList, (Boolean) m10.get("multiSelect"));
    }

    public final Task e(Map<String, ? extends Object> map) {
        TaskStatus taskStatusA;
        TaskProgress taskProgress;
        List listM;
        List listM2;
        ArrayList arrayList;
        p.i(map, "map");
        Object obj = map.get("taskId");
        p.g(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        String str2 = (String) map.get("parentTaskId");
        String str3 = (String) map.get(SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY);
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
        if (str11 == null || (taskStatusA = TaskStatus.INSTANCE.a(str11)) == null) {
            taskStatusA = TaskStatus.CREATED;
        }
        TaskStatus taskStatus = taskStatusA;
        Object obj6 = map.get("progress");
        Map map2 = obj6 instanceof Map ? (Map) obj6 : null;
        if (map2 != null) {
            Object obj7 = map2.get("total");
            Number number = obj7 instanceof Number ? (Number) obj7 : null;
            int iIntValue = number != null ? number.intValue() : 0;
            Object obj8 = map2.get("completed");
            Number number2 = obj8 instanceof Number ? (Number) obj8 : null;
            int iIntValue2 = number2 != null ? number2.intValue() : 0;
            Object obj9 = map2.get("inProgress");
            Number number3 = obj9 instanceof Number ? (Number) obj9 : null;
            int iIntValue3 = number3 != null ? number3.intValue() : 0;
            Object obj10 = map2.get(AuthSessionDto.STATUS_PENDING);
            Number number4 = obj10 instanceof Number ? (Number) obj10 : null;
            int iIntValue4 = number4 != null ? number4.intValue() : 0;
            Object obj11 = map2.get("failed");
            Number number5 = obj11 instanceof Number ? (Number) obj11 : null;
            taskProgress = new TaskProgress(iIntValue2, iIntValue, number5 != null ? number5.intValue() : 0, iIntValue3, iIntValue4);
        } else {
            taskProgress = null;
        }
        Object obj12 = map.get("artifacts");
        List list = obj12 instanceof List ? (List) obj12 : null;
        if (list != null) {
            listM = new ArrayList();
            for (Object obj13 : list) {
                Map<String, ? extends Object> map3 = obj13 instanceof Map ? (Map) obj13 : null;
                TaskArtifact taskArtifactF = map3 != null ? f22322a.f(map3) : null;
                if (taskArtifactF != null) {
                    listM.add(taskArtifactF);
                }
            }
        } else {
            listM = C1173v.m();
        }
        String str12 = (String) map.get(c.a.COL_SUMMARY);
        List<Question> listC = c(map);
        String str13 = (String) map.get("intention");
        Object obj14 = map.get("subTaskIds");
        List list2 = obj14 instanceof List ? (List) obj14 : null;
        if (list2 != null) {
            listM2 = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = it;
                String str14 = next instanceof String ? (String) next : null;
                if (str14 != null) {
                    listM2.add(str14);
                }
                it = it2;
            }
        } else {
            listM2 = C1173v.m();
        }
        Object obj15 = map.get("subTasks");
        List list3 = obj15 instanceof List ? (List) obj15 : null;
        if (list3 != null) {
            arrayList = new ArrayList();
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                List list4 = listM2;
                Object next2 = it3.next();
                Iterator it4 = it3;
                Map<String, ? extends Object> map4 = next2 instanceof Map ? (Map) next2 : null;
                Task taskE = map4 != null ? f22322a.e(map4) : null;
                if (taskE != null) {
                    arrayList.add(taskE);
                }
                listM2 = list4;
                it3 = it4;
            }
        } else {
            arrayList = null;
        }
        List list5 = listM2;
        long jG = g(map.get("createdAt"));
        long jG2 = g(map.get("updatedAt"));
        Long lH = h(map.get("startedAt"));
        Long lH2 = h(map.get("endedAt"));
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
        return new Task(str, str2, str3, str4, str6, str8, str10, taskStatus, taskProgress, listM, str12, listC, str13, list5, arrayList, jG, jG2, lH, lH2, numValueOf, iIntValue5, iIntValue6, bool != null ? bool.booleanValue() : false, null);
    }

    public final TaskArtifact f(Map<String, ? extends Object> m10) {
        p.i(m10, "m");
        Object obj = m10.get("artifactId");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = m10.get("status");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = m10.get("type");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = m10.get("contentType");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = m10.get("fileId");
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = m10.get(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        String str6 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = m10.get("fileName");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = m10.get("title");
        String str8 = obj8 instanceof String ? (String) obj8 : null;
        Object obj9 = m10.get("mimeType");
        String str9 = obj9 instanceof String ? (String) obj9 : null;
        Object obj10 = m10.get(ContentDisposition.Parameters.Size);
        Number number = obj10 instanceof Number ? (Number) obj10 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj11 = m10.get("sha256");
        String str10 = obj11 instanceof String ? (String) obj11 : null;
        Object obj12 = m10.get("taskVersion");
        Number number2 = obj12 instanceof Number ? (Number) obj12 : null;
        int iIntValue = number2 != null ? number2.intValue() : 0;
        Object obj13 = m10.get("errorReason");
        String str11 = obj13 instanceof String ? (String) obj13 : null;
        Object obj14 = m10.get("errorDetail");
        return new TaskArtifact(str, str2, str3, str4, str5, str6, str7, str8, str9, lValueOf, str10, iIntValue, str11, obj14 instanceof String ? (String) obj14 : null);
    }

    public final long g(Object value) {
        Long lY;
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        if (!(value instanceof String) || (lY = C.y((String) value)) == null) {
            return 0L;
        }
        return lY.longValue();
    }

    public final Long h(Object value) {
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (value instanceof String) {
            return C.y((String) value);
        }
        return null;
    }
}
