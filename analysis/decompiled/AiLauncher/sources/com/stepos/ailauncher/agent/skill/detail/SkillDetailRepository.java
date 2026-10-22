package com.stepos.ailauncher.agent.skill.detail;

import Ua.C1056g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import e9.InterfaceC4014c;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/SkillDetailRepository;", "", "<init>", "()V", "", "slug", "", "testing", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/detail/F;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "c", "(Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/detail/k0;", "api$delegate", "LY8/h;", "e", "()Lcom/stepos/ailauncher/agent/skill/detail/k0;", "api", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailRepository {
    private static final String TAG = "SkillDetailRepo";
    public static final SkillDetailRepository INSTANCE = new SkillDetailRepository();

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.detail.j0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillDetailRepository.b();
        }
    });

    public static final k0 b() {
        return (k0) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).d(), null, false, false, false, 30, null).c(k0.class);
    }

    public final Object c(InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new SkillDetailRepository$fetchAuthTokenAsync$2(null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0164 A[Catch: all -> 0x017a, TryCatch #3 {all -> 0x017a, blocks: (B:46:0x013c, B:48:0x0164, B:50:0x016c, B:52:0x0172, B:56:0x017c, B:57:0x0183, B:58:0x0184, B:59:0x01ae), top: B:75:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0184 A[Catch: all -> 0x017a, TryCatch #3 {all -> 0x017a, blocks: (B:46:0x013c, B:48:0x0164, B:50:0x016c, B:52:0x0172, B:56:0x017c, B:57:0x0183, B:58:0x0184, B:59:0x01ae), top: B:75:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r28, int r29, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.skill.detail.SkillDetailDto>> r30) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailRepository.d(java.lang.String, int, e9.c):java.lang.Object");
    }

    public final k0 e() {
        Object value = api.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (k0) value;
    }
}
