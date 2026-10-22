package com.stepos.ailauncher.task.space;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.agentframework.chatcore.intent.TaskDispatcher;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.task.space.G;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0006\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/task/space/H;", "", "<init>", "()V", "", "robotTaskId", "", "keys", "LY8/t;", "c", "(Ljava/lang/String;[Ljava/lang/String;)V", "taskId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Z", "", "", "robotIdsByKey", "Ljava/util/Map;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    public static final H INSTANCE = new H();
    private static final Map<String, Set<String>> robotIdsByKey = new LinkedHashMap();

    public final boolean a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return TaskDispatcher.INSTANCE.a().k(taskId) != null;
    }

    public final boolean b(TaskInfoStatus status) {
        return status == TaskInfoStatus.RUNNING || status == TaskInfoStatus.IN_PROGRESS || status == TaskInfoStatus.PENDING || status == TaskInfoStatus.CREATED || status == TaskInfoStatus.PLANNING;
    }

    public final void c(String robotTaskId, String... keys) {
        kotlin.jvm.internal.p.i(robotTaskId, "robotTaskId");
        kotlin.jvm.internal.p.i(keys, "keys");
        if (La.H.x0(robotTaskId)) {
            return;
        }
        synchronized (robotIdsByKey) {
            try {
                List listV = Z8.r.V(keys);
                ArrayList<String> arrayList = new ArrayList();
                for (Object obj : listV) {
                    if (!La.H.x0((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                for (String str : arrayList) {
                    Map<String, Set<String>> map = robotIdsByKey;
                    Set<String> linkedHashSet = map.get(str);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet<>();
                        map.put(str, linkedHashSet);
                    }
                    linkedHashSet.add(robotTaskId);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(TaskInfoCard card) {
        Set setH;
        kotlin.jvm.internal.p.i(card, "card");
        if (card.getStatus().isTerminal()) {
            G.INSTANCE.a(card.getTaskId());
            synchronized (robotIdsByKey) {
                setH = Z8.Y.h(card.getTaskId());
                Iterator it = C1173v.r(card.getTaskId(), card.getSessionKey(), card.getRequestSessionKey()).iterator();
                while (it.hasNext()) {
                    Set<String> setRemove = robotIdsByKey.remove((String) it.next());
                    if (setRemove != null) {
                        setH.addAll(setRemove);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : setH) {
                if (INSTANCE.a((String) obj)) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                RobotManager.INSTANCE.a().D((String) it2.next());
            }
            return;
        }
        String sessionKey = card.getSessionKey();
        if (sessionKey == null && (sessionKey = card.getRequestSessionKey()) == null) {
            sessionKey = "";
        }
        String str = sessionKey;
        if (b(card.getStatus()) && a(card.getTaskId())) {
            G g10 = G.INSTANCE;
            String taskId = card.getTaskId();
            AppUIData appUIDataB = I.b(I.INSTANCE, card.getTaskId(), null, 2, null);
            String taskId2 = card.getTaskId();
            String taskId3 = card.getTaskId();
            String requestSessionKey = card.getRequestSessionKey();
            if (requestSessionKey == null) {
                requestSessionKey = "";
            }
            g10.b(new G.GuiHostPayload(str, taskId, appUIDataB, taskId2, taskId3, null, requestSessionKey, false, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME, null));
        }
    }
}
