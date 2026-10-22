package com.stepos.ailauncher.chat.fragment;

import android.os.Bundle;
import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.foundation.appstore.AppVersionListRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooAppDetailFragment$loadDetail$1", f = "AmooAppDetailFragment.kt", l = {210}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooAppDetailFragment$loadDetail$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ long $appId;
    int label;
    final /* synthetic */ AmooAppDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooAppDetailFragment$loadDetail$1(long j10, AmooAppDetailFragment amooAppDetailFragment, InterfaceC4014c<? super AmooAppDetailFragment$loadDetail$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appId = j10;
        this.this$0 = amooAppDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AmooAppDetailFragment$loadDetail$1(this.$appId, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AmooAppDetailFragment$loadDetail$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AppVersionListRepository appVersionListRepository = AppVersionListRepository.INSTANCE;
            long j10 = this.$appId;
            this.label = 1;
            obj = appVersionListRepository.d(j10, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AppVersionDetail appVersionDetail = (AppVersionDetail) obj;
        if (appVersionDetail == null) {
            Toast.makeText(this.this$0.requireContext(), R$string.amoo_app_detail_load_failed, 0).show();
            if (!this.this$0.x()) {
                this.this$0.o();
            }
            return Y8.t.f7040a;
        }
        this.this$0.detail = appVersionDetail;
        String packageName = appVersionDetail.getPackageName();
        Bundle arguments = this.this$0.getArguments();
        String string = arguments != null ? arguments.getString("package_name") : null;
        if (packageName != null && packageName.length() != 0 && !kotlin.jvm.internal.p.d(packageName, string)) {
            if (string != null) {
                com.stepos.ailauncher.foundation.appstore.j.INSTANCE.F(string, this.this$0.installCallback);
            }
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.n(packageName, this.this$0.installCallback);
        }
        this.this$0.S(appVersionDetail);
        return Y8.t.f7040a;
    }
}
