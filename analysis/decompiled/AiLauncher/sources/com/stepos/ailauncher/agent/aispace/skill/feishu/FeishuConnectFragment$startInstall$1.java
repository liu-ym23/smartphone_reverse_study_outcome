package com.stepos.ailauncher.agent.aispace.skill.feishu;

import Y4.C1121e;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$startInstall$1", f = "FeishuConnectFragment.kt", l = {453}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectFragment$startInstall$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ FeishuConnectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectFragment$startInstall$1(FeishuConnectFragment feishuConnectFragment, InterfaceC4014c<? super FeishuConnectFragment$startInstall$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t h(FeishuConnectFragment feishuConnectFragment, InstallProgress installProgress) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("install progress=%s", Arrays.copyOf(new Object[]{installProgress}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C1121e c1121e = null;
        C4148a.d("AILauncher-FeishuConn", str, false, 4, null);
        C1121e c1121e2 = feishuConnectFragment.binding;
        if (c1121e2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e2 = null;
        }
        c1121e2.tvInstallTitle.setText(installProgress.getTitle());
        C1121e c1121e3 = feishuConnectFragment.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e = c1121e3;
        }
        c1121e.tvInstallSubtitle.setText(installProgress.getSubtitle());
        feishuConnectFragment.n0(installProgress.getStepIndex(), installProgress.getCompleted());
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FeishuConnectFragment$startInstall$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectFragment$startInstall$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            h0 h0VarV0 = this.this$0.v0();
            final FeishuConnectFragment feishuConnectFragment = this.this$0;
            InterfaceC5074l<? super InstallProgress, Y8.t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.g0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return FeishuConnectFragment$startInstall$1.h(feishuConnectFragment, (InstallProgress) obj2);
                }
            };
            this.label = 1;
            obj = h0VarV0.g(interfaceC5074l, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.Z0((AbstractC2306b) obj);
        return Y8.t.f7040a;
    }
}
