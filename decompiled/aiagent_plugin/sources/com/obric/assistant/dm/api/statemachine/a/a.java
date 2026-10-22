package com.obric.assistant.dm.api.statemachine.a;

import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IslandCardSession;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DMConvert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22458a = null;

    static {
        f22458a = new a();
    }

    private a() {
    }

    public final DMTaskInfo a(TaskInfo r9) {
        o.e(r9, "taskInfo");
        return new DMTaskInfo(r9.getTaskId().toString(), r9.getTaskType().ordinal(), r9.getMessage(), r9.getCreatedTime(), r9.getProgress(), r9.getExt());
    }

    public final DMTaskState a(TaskState r4) {
        o.e(r4, "taskState");
        String r3 = String.valueOf(r4.getTaskId());
        TaskInfo r0 = r4.getTaskInfo();
        if (r0 == null) goto L5;
        DMTaskInfo r1 = f22458a.a(r0);
    L7:
        return new DMTaskState(r3, r1, r4.getState(), r4.getExtra());
    L5:
        r1 = null;
        goto L7
    }

    public final DMStateInfo a(DMState r6) {
        o.e(r6, "state");
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        State r2 = (State) ZeusTransformUtils.preCheckCast(r0.next(), State.class, "com.obric.aiagent.plugin");
        a r3 = f22458a;
        o.a(r2, "null cannot be cast to non-null type com.obric.assistant.dm.api.statemachine.core.TaskState");
        r5.add(r3.a((TaskState) ZeusTransformUtils.preCheckCast(r2, TaskState.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        IslandSession r1 = r6.getTopIslandCard();
        IslandCardSession r4 = null;
        if (r1 == null) goto L12;
        LiveCardType r7 = r1.getType();
        if (r7 == null) goto L12;
        r4 = new IslandCardSession(r7.ordinal(), r1.getFlags());
    L12:
        return new DMStateInfo(r6.isIdle(), r6.isQuerying(), r5, r4);
    }
}
