package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AgentTaskAppIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentTaskAppIDLStub extends IAgentTaskAppIDL.Stub implements IAgentTaskAppIDL {
    private final /* synthetic */ IAgentTaskAppIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void addTaskManagerShortcut(PendingIntent r1) {
        this.$$delegate_0.addTaskManagerShortcut(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r1) {
        return this.$$delegate_0.getShortcutRecommendItems(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean hasShortcutForMessage(String r1) {
        return this.$$delegate_0.hasShortcutForMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void openEventTaskDetailPage(String r1, String r2) {
        this.$$delegate_0.openEventTaskDetailPage(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void runShortcutTaskFromRecommendPanel(String r1, String r2) {
        this.$$delegate_0.runShortcutTaskFromRecommendPanel(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean shouldShowAddTaskManagerIconGuide() {
        return this.$$delegate_0.shouldShowAddTaskManagerIconGuide();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void testRunConditionTask(String r1, String r2) {
        this.$$delegate_0.testRunConditionTask(r1, r2);
    }

    public AgentTaskAppIDLStub() {
        Object r0 = (IAgentTaskAppIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentTaskAppIDLSPI.class), IAgentTaskAppIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentTaskAppIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentTaskAppIDL) ZeusTransformUtils.preCheckCast(r0, IAgentTaskAppIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
