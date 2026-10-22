package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/WecomCliHubRepository;", "", "<init>", "()V", "", "name", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/a;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", "f", "()Lcom/google/gson/Gson;", "gson", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/e;", "api$delegate", "e", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/e;", "api", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WecomCliHubRepository {
    private static final String TAG = "AILauncher-WecomCliHub";
    public static final WecomCliHubRepository INSTANCE = new WecomCliHubRepository();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Y8.h gson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.net.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return WecomCliHubRepository.g();
        }
    });

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.net.d
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return WecomCliHubRepository.c();
        }
    });

    public static final com.stepos.ailauncher.agent.aispace.skill.feishu.net.e c() {
        return (com.stepos.ailauncher.agent.aispace.skill.feishu.net.e) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).d(), null, false, false, false, 30, null).c(com.stepos.ailauncher.agent.aispace.skill.feishu.net.e.class);
    }

    public static final Gson g() {
        return new Gson();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dc, code lost:
    
        if (r2 == r5) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r18, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.skill.feishu.net.CliHubInfoDto>> r19) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliHubRepository.d(java.lang.String, e9.c):java.lang.Object");
    }

    public final com.stepos.ailauncher.agent.aispace.skill.feishu.net.e e() {
        Object value = api.getValue();
        p.h(value, "getValue(...)");
        return (com.stepos.ailauncher.agent.aispace.skill.feishu.net.e) value;
    }

    public final Gson f() {
        return (Gson) gson.getValue();
    }
}
