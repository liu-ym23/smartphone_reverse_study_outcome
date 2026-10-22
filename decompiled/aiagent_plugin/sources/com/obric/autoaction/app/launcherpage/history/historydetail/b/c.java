package com.obric.autoaction.app.launcherpage.history.historydetail.b;

import com.obric.autoaction.app.launcherpage.history.historydetail.a.j;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GetHistoryStepUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final List<h> a(List<EventTaskExecutionDetailRecord> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "<this>");
        List<h> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L25;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        p.c();
    L8:
        EventTaskExecutionDetailRecord r6 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r4, EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d("GetHistoryStepUseCase", "item: " + r6);
        String r7 = "";
        if (r3 != 0) goto L15;
        String r8 = r6.getPackageName();
        String r9 = r6.getAppName();
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        r0.add(new com.obric.autoaction.app.launcherpage.history.historydetail.a.h(null, r8, r9, 1));
    L20:
        String r10 = r6.getDetailText();
        if (r10 == null) goto L24;
        r7 = r10;
    L24:
        r0.add(new j(r7, r6.getDetailType()));
        r3 = r5;
        goto L4
    L15:
        if (o.a(((EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r12.get(r3 - 1), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin")).getPackageName(), r6.getPackageName()) == true) goto L20;
        String r13 = r6.getPackageName();
        String r14 = r6.getAppName();
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        r0.add(new com.obric.autoaction.app.launcherpage.history.historydetail.a.h(null, r13, r14, 2));
        goto L20
    L25:
        return r0;
    }
}
