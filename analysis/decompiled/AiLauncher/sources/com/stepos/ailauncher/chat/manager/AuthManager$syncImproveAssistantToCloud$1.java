package com.stepos.ailauncher.chat.manager;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.AuthManager", f = "AuthManager.kt", l = {451}, m = "syncImproveAssistantToCloud", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthManager$syncImproveAssistantToCloud$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthManager$syncImproveAssistantToCloud$1(AuthManager authManager, InterfaceC4014c<? super AuthManager$syncImproveAssistantToCloud$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = authManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.G1(false, this);
    }
}
