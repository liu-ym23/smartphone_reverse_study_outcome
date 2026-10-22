package com.stepos.ailauncher.common.privacy;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.common.privacy.PrivacyGuard$isContentSafe$2", f = "PrivacyGuard.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PrivacyGuard$isContentSafe$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $content;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyGuard$isContentSafe$2(String str, InterfaceC4014c<? super PrivacyGuard$isContentSafe$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PrivacyGuard$isContentSafe$2(this.$content, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((PrivacyGuard$isContentSafe$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        boolean z10 = true;
        try {
            if (PrivacyGuard.INSTANCE.c().sanitizeDetail(this.$content).getBlocked()) {
                C4148a.u("AILauncher-PrivacyGuard", "privacy check blocked: L4 sensitive content hit", false, 4, null);
                z10 = false;
            }
        } catch (Throwable th) {
            C4148a.g("AILauncher-PrivacyGuard", "privacy check error, allowing save", th, false, 8, null);
        }
        return C4109a.a(z10);
    }
}
