package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.io.File;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity$readLocalFile$2", f = "AgentFileEditActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$readLocalFile$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    int label;
    final /* synthetic */ AgentFileEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$readLocalFile$2(AgentFileEditActivity agentFileEditActivity, InterfaceC4014c<? super AgentFileEditActivity$readLocalFile$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentFileEditActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileEditActivity$readLocalFile$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((AgentFileEditActivity$readLocalFile$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            File fileU = this.this$0.U();
            if (fileU.exists()) {
                return l9.i.o(fileU, null, 1, null);
            }
            return null;
        } catch (Exception e10) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("Failed to read local file for %s", Arrays.copyOf(new Object[]{this.this$0.fileId}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.t("AILauncher-FileEdit", str, e10, false, 8, null);
            return null;
        }
    }
}
