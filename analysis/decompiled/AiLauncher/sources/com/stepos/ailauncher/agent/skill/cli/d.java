package com.stepos.ailauncher.agent.skill.cli;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/d;", "", "", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "statusIn", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "query", "c", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface d {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object a(d dVar, String str, List list, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchCli");
        }
        if ((i10 & 2) != 0) {
            list = C1173v.m();
        }
        return dVar.c(str, list, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object d(d dVar, List list, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadCliList");
        }
        if ((i10 & 1) != 0) {
            list = C1173v.m();
        }
        return dVar.b(list, interfaceC4014c);
    }

    Object b(List<? extends SkillStatus> list, InterfaceC4014c<? super List<SkillItem>> interfaceC4014c);

    Object c(String str, List<? extends SkillStatus> list, InterfaceC4014c<? super List<SkillItem>> interfaceC4014c);
}
