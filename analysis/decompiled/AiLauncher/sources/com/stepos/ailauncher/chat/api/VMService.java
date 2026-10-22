package com.stepos.ailauncher.chat.api;

import Ac.a;
import Ac.o;
import Ac.t;
import e9.InterfaceC4014c;
import kotlin.CreateVMBody;
import kotlin.Metadata;
import tb.AbstractC5531D;
import yc.v;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\n\u0010\tJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\u0010\u0010\tJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\u0011\u0010\tJ \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\u0015\u0010\t¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "", "LK6/q;", "body", "Lyc/v;", "Ltb/D;", "createVM", "(LK6/q;Le9/c;)Ljava/lang/Object;", "deleteVM", "(Le9/c;)Ljava/lang/Object;", "doctorFixVM", "", "mode", "deleteMemory", "reInstallVM", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "restartVM", "queryVMStatus", "action", "powerVM", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "deleteVMMemory", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface VMService {
    @o("task-engine/api/botway/deploy/create")
    Object createVM(@a CreateVMBody createVMBody, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/delete")
    Object deleteVM(InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/delete-memory")
    Object deleteVMMemory(InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/doctor-fix")
    Object doctorFixVM(InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/power")
    Object powerVM(@t("action") String str, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/status")
    Object queryVMStatus(InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/reinstall")
    Object reInstallVM(@t("mode") String str, @t("deleteMemory") String str2, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("task-engine/api/botway/deploy/restart")
    Object restartVM(InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);
}
