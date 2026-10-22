package io.ktor.server.application;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1", f = "ApplicationModules.jvm.kt", l = {75}, m = "loadModules")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationModules_jvmKt$LoadSequentially$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1(ApplicationModules_jvmKt$LoadSequentially$1 applicationModules_jvmKt$LoadSequentially$1, InterfaceC4014c<? super ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = applicationModules_jvmKt$LoadSequentially$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadModules(null, null, null, this);
    }
}
