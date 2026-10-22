package com.stepos.ailauncher.agent.skill.detail;

import com.stepos.ailauncher.agent.skill.SkillItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$onToggle$1", f = "SkillDetailActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailActivity$onToggle$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $enable;
    final /* synthetic */ SkillItem $item;
    final /* synthetic */ X4.a $svc;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailActivity$onToggle$1(boolean z10, X4.a aVar, SkillItem skillItem, InterfaceC4014c<? super SkillDetailActivity$onToggle$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$enable = z10;
        this.$svc = aVar;
        this.$item = skillItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillDetailActivity$onToggle$1(this.$enable, this.$svc, this.$item, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SkillDetailActivity$onToggle$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (this.$enable) {
            this.$svc.c(this.$item);
        } else {
            this.$svc.b(this.$item);
        }
        return Y8.t.f7040a;
    }
}
