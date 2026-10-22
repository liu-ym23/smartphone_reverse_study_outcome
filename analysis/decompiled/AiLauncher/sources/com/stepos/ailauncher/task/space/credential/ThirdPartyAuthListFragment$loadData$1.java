package com.stepos.ailauncher.task.space.credential;

import android.widget.Toast;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.credential.ThirdPartyAuthListFragment$loadData$1", f = "ThirdPartyAuthListFragment.kt", l = {92}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ThirdPartyAuthListFragment$loadData$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ThirdPartyAuthListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyAuthListFragment$loadData$1(ThirdPartyAuthListFragment thirdPartyAuthListFragment, InterfaceC4014c<? super ThirdPartyAuthListFragment$loadData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = thirdPartyAuthListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThirdPartyAuthListFragment$loadData$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThirdPartyAuthListFragment$loadData$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialApi credentialApi = CredentialApi.INSTANCE;
            this.label = 1;
            obj = credentialApi.d(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        CredentialListData credentialListData = (CredentialListData) obj;
        if (credentialListData != null) {
            this.this$0.Z(credentialListData);
        } else {
            Toast.makeText(this.this$0.requireContext(), R$string.third_party_auth_network_error, 0).show();
        }
        return Y8.t.f7040a;
    }
}
