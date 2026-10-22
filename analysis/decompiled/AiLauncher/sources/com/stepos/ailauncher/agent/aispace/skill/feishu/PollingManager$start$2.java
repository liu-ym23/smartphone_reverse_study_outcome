package com.stepos.ailauncher.agent.aispace.skill.feishu;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.PollingManager$start$2", f = "PollingManager.kt", l = {32, 48}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PollingManager$start$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5063a<Y8.t> $onTimeout;
    final /* synthetic */ InterfaceC5074l<T, Y8.t> $onUpdate;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PollingManager<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PollingManager$start$2(InterfaceC5074l<? super T, Y8.t> interfaceC5074l, PollingManager<T> pollingManager, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC4014c<? super PollingManager$start$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$onUpdate = interfaceC5074l;
        this.this$0 = pollingManager;
        this.$onTimeout = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PollingManager$start$2 pollingManager$start$2 = new PollingManager$start$2(this.$onUpdate, this.this$0, this.$onTimeout, interfaceC4014c);
        pollingManager$start$2.L$0 = obj;
        return pollingManager$start$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PollingManager$start$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0111 -> B:15:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.PollingManager$start$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
