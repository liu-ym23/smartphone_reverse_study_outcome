package com.stepos.ailauncher.foundation.credential;

import Y8.t;
import com.stepos.ailauncher.foundation.credential.api.ApiEnvelope;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ailauncher.foundation.credential.api.CredentialApi;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/foundation/credential/api/ApiEnvelope;", "Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$createSession$2", f = "CredentialBrokerClient.kt", l = {159}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CredentialBrokerClient$createSession$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super ApiEnvelope<AuthSessionDto>>, Object> {
    final /* synthetic */ Map<String, Object> $merged;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialBrokerClient$createSession$2(String str, Map<String, ? extends Object> map, InterfaceC4014c<? super CredentialBrokerClient$createSession$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$path = str;
        this.$merged = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CredentialBrokerClient$createSession$2(this.$path, this.$merged, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super ApiEnvelope<AuthSessionDto>> interfaceC4014c) {
        return ((CredentialBrokerClient$createSession$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
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
        CredentialApi credentialApiP = CredentialBrokerClient.INSTANCE.p();
        String str = this.$path;
        Map<String, Object> map = this.$merged;
        this.label = 1;
        Object objSession = credentialApiP.session(str, map, this);
        return objSession == objG ? objG : objSession;
    }
}
