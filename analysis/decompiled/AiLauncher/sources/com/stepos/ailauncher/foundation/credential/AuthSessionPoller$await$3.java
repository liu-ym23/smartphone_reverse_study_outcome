package com.stepos.ailauncher.foundation.credential;

import Y8.t;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", "<anonymous>", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.credential.AuthSessionPoller$await$3", f = "AuthSessionPoller.kt", l = {119}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AuthSessionPoller$await$3 extends SuspendLambda implements p<String, InterfaceC4014c<? super CredentialBrokerClient.a<? extends AuthSessionDto>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AuthSessionPoller$await$3(InterfaceC4014c<? super AuthSessionPoller$await$3> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AuthSessionPoller$await$3 authSessionPoller$await$3 = new AuthSessionPoller$await$3(interfaceC4014c);
        authSessionPoller$await$3.L$0 = obj;
        return authSessionPoller$await$3;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(String str, InterfaceC4014c<? super CredentialBrokerClient.a<? extends AuthSessionDto>> interfaceC4014c) {
        return invoke2(str, (InterfaceC4014c<? super CredentialBrokerClient.a<AuthSessionDto>>) interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = (String) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
        this.L$0 = h.a(str);
        this.label = 1;
        Object objL = credentialBrokerClient.l(str, this);
        return objL == objG ? objG : objL;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, InterfaceC4014c<? super CredentialBrokerClient.a<AuthSessionDto>> interfaceC4014c) {
        return ((AuthSessionPoller$await$3) create(str, interfaceC4014c)).invokeSuspend(t.f7040a);
    }
}
