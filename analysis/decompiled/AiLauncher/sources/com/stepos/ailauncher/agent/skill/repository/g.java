package com.stepos.ailauncher.agent.skill.repository;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/g;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/repository/e;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/agent/skill/repository/e;", "apiRepository$delegate", "LY8/h;", "c", "apiRepository", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final g INSTANCE = new g();

    /* renamed from: apiRepository$delegate, reason: from kotlin metadata */
    private static final h apiRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.repository.f
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return g.b();
        }
    });

    public static final ApiSkillRepository b() {
        return new ApiSkillRepository();
    }

    public final e c() {
        return (e) apiRepository.getValue();
    }

    public final e d() {
        return c();
    }
}
