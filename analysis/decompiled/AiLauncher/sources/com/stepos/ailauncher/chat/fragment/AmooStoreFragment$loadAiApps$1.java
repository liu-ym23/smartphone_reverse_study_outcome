package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.foundation.appstore.AppVersionListRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionPage;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadAiApps$1", f = "AmooStoreFragment.kt", l = {476}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooStoreFragment$loadAiApps$1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<AppVersionItem>>, Object> {
    /* synthetic */ int I$0;
    int label;

    public AmooStoreFragment$loadAiApps$1(InterfaceC4014c<? super AmooStoreFragment$loadAiApps$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmooStoreFragment$loadAiApps$1 amooStoreFragment$loadAiApps$1 = new AmooStoreFragment$loadAiApps$1(interfaceC4014c);
        amooStoreFragment$loadAiApps$1.I$0 = ((Number) obj).intValue();
        return amooStoreFragment$loadAiApps$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super ListPage<AppVersionItem>> interfaceC4014c) {
        return ((AmooStoreFragment$loadAiApps$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<AppVersionItem>> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.I$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 == 0) {
            C4849c.b(obj);
            AppVersionListRepository appVersionListRepository = AppVersionListRepository.INSTANCE;
            this.I$0 = i10;
            this.label = 1;
            obj = appVersionListRepository.e(i10, 15, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AppVersionPage appVersionPage = (AppVersionPage) obj;
        if (appVersionPage != null) {
            return new ListPage(appVersionPage.getItems(), appVersionPage.getMore() ? C4109a.f(i10 + 1) : null, null, 4, null);
        }
        throw new IllegalStateException("App list failed");
    }
}
