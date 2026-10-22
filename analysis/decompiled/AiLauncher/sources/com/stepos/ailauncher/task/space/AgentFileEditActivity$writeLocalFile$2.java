package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity$writeLocalFile$2", f = "AgentFileEditActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$writeLocalFile$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Object>, Object> {
    final /* synthetic */ String $content;
    int label;
    final /* synthetic */ AgentFileEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$writeLocalFile$2(AgentFileEditActivity agentFileEditActivity, String str, InterfaceC4014c<? super AgentFileEditActivity$writeLocalFile$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentFileEditActivity;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileEditActivity$writeLocalFile$2(this.this$0, this.$content, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<Object> interfaceC4014c) {
        return ((AgentFileEditActivity$writeLocalFile$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            l9.i.q(this.this$0.U(), this.$content, null, 2, null);
            return Y8.t.f7040a;
        } catch (Exception e10) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("Failed to write local file for %s", Arrays.copyOf(new Object[]{this.this$0.fileId}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            return C4109a.f(C4148a.t("AILauncher-FileEdit", str, e10, false, 8, null));
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Object> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<Object>) interfaceC4014c);
    }
}
