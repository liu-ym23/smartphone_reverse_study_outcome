package com.stepos.ailauncher.task.space.credential;

import android.widget.Toast;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.credential.ThirdPartyAuthDetailFragment$performRevoke$1", f = "ThirdPartyAuthDetailFragment.kt", l = {386}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ThirdPartyAuthDetailFragment$performRevoke$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ CredentialItem $item;
    int label;
    final /* synthetic */ ThirdPartyAuthDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyAuthDetailFragment$performRevoke$1(CredentialItem credentialItem, ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, InterfaceC4014c<? super ThirdPartyAuthDetailFragment$performRevoke$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = credentialItem;
        this.this$0 = thirdPartyAuthDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThirdPartyAuthDetailFragment$performRevoke$1(this.$item, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThirdPartyAuthDetailFragment$performRevoke$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialApi credentialApi = CredentialApi.INSTANCE;
            String vendorId = this.$item.getVendorId();
            this.label = 1;
            obj = credentialApi.e(vendorId, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R$string.third_party_auth_revoke_success, this.$item.getVendorName()), 0).show();
            C4109a.a(this.this$0.x());
        } else {
            Toast.makeText(this.this$0.requireContext(), R$string.third_party_auth_revoke_failed, 0).show();
        }
        return Y8.t.f7040a;
    }
}
