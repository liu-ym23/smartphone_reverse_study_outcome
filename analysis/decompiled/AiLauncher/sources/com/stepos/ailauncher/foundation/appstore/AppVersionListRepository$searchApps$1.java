package com.stepos.ailauncher.foundation.appstore;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.AppVersionListRepository", f = "AppVersionListRepository.kt", l = {117}, m = "searchApps", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppVersionListRepository$searchApps$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppVersionListRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVersionListRepository$searchApps$1(AppVersionListRepository appVersionListRepository, InterfaceC4014c<? super AppVersionListRepository$searchApps$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = appVersionListRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, 0, this);
    }
}
