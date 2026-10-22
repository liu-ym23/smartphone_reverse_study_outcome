package com.stepos.ailauncher.task.space.credential;

import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.credential.CredentialApi$revokeCredential$2", f = "CredentialApi.kt", l = {170}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CredentialApi$revokeCredential$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $vendorId;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialApi$revokeCredential$2(String str, InterfaceC4014c<? super CredentialApi$revokeCredential$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$vendorId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CredentialApi$revokeCredential$2(this.$vendorId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((CredentialApi$revokeCredential$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        boolean z10 = false;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC3596h interfaceC3596h = (InterfaceC3596h) HttpManager.INSTANCE.create(InterfaceC3596h.class, CredentialApi.BASE_URL_KEY);
                String strB = CredentialApi.INSTANCE.b();
                String str = this.$vendorId;
                this.L$0 = g9.h.a(interfaceC3596h);
                this.L$1 = g9.h.a(strB);
                this.label = 1;
                obj = interfaceC3596h.d(strB, str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            boolean zD = ((ApiWrapper) obj).d();
            C4148a.d("AILauncher-CredentialApi", "revokeCredential: vendorId=" + this.$vendorId + ", success=" + zD, false, 4, null);
            z10 = zD;
        } catch (Exception e10) {
            C4148a.g("AILauncher-CredentialApi", "revokeCredential failed", e10, false, 8, null);
        }
        return C4109a.a(z10);
    }
}
