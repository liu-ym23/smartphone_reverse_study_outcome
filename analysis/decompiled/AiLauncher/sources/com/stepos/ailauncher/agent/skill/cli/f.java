package com.stepos.ailauncher.agent.skill.cli;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/f;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/cli/d;", "c", "()Lcom/stepos/ailauncher/agent/skill/cli/d;", "repository$delegate", "LY8/h;", Const.INTENT_KEY_PKGNAME, "repository", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final f INSTANCE = new f();

    /* renamed from: repository$delegate, reason: from kotlin metadata */
    private static final h repository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.cli.e
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return f.d();
        }
    });

    public static final ApiCliRepository d() {
        return new ApiCliRepository();
    }

    public final d b() {
        return (d) repository.getValue();
    }

    public final d c() {
        return b();
    }
}
