package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/FeishuAuth;", "", "<init>", "()V", "", "c", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeishuAuth {
    public static final FeishuAuth INSTANCE = new FeishuAuth();
    private static final String TAG = "AILauncher-FeishuAuth";

    public final String a() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(e9.InterfaceC4014c<? super java.lang.String> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth$authHeader$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth$authHeader$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth$authHeader$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth$authHeader$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth$authHeader$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.c(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L44
            java.lang.String r4 = ""
            return r4
        L44:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth.b(e9.c):java.lang.Object");
    }

    public final Object c(InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Y.b(), new FeishuAuth$fetchTokenAsync$2(null), interfaceC4014c);
    }
}
