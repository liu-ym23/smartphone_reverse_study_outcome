package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\t\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H¦@¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H¦@¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0004\b\u0010\u0010\rJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H¦@¢\u0006\u0004\b\u0012\u0010\rJ\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H¦@¢\u0006\u0004\b\u0013\u0010\rJ\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H¦@¢\u0006\u0004\b\u0016\u0010\r¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/n0;", "LY8/t;", "onProgress", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "e", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/a;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "f", "c", "", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface h0 {
    AbstractC2306b a();

    Object b(InterfaceC4014c<? super AuthorizeLaunch> interfaceC4014c);

    Object c(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c);

    Object d(InterfaceC4014c<? super List<RecommendedTask>> interfaceC4014c);

    Object e(InterfaceC5074l<? super InstallProgress, Y8.t> interfaceC5074l, InterfaceC4014c<? super AbstractC2306b> interfaceC4014c);

    Object f(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c);

    Object g(InterfaceC5074l<? super InstallProgress, Y8.t> interfaceC5074l, InterfaceC4014c<? super AbstractC2306b> interfaceC4014c);

    Object h(InterfaceC4014c<? super CreateBotLaunch> interfaceC4014c);
}
