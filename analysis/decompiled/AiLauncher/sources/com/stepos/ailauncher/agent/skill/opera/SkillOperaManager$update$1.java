package com.stepos.ailauncher.agent.skill.opera;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.installer.CommandKind;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$update$1", f = "SkillOperaManager.kt", l = {249}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillOperaManager$update$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SkillItem $item;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillOperaManager$update$1(SkillItem skillItem, InterfaceC4014c<? super SkillOperaManager$update$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = skillItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillOperaManager$update$1(this.$item, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillOperaManager$update$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SkillStatus status = this.$item.getStatus();
            if (status == null) {
                status = SkillStatus.INSTALLED_ENABLED;
            }
            SkillStatus skillStatus = status;
            SkillOperaManager skillOperaManager = SkillOperaManager.INSTANCE;
            SkillItem skillItem = this.$item;
            CommandKind commandKind = CommandKind.UPDATE;
            SkillStatus skillStatus2 = SkillStatus.INSTALLED_ENABLED;
            OperaErrorKind operaErrorKind = OperaErrorKind.UPDATE;
            this.L$0 = h.a(skillStatus);
            this.label = 1;
            if (skillOperaManager.l0(skillItem, commandKind, skillStatus2, skillStatus, operaErrorKind, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ((Result) obj).getValue();
        }
        return t.f7040a;
    }
}
