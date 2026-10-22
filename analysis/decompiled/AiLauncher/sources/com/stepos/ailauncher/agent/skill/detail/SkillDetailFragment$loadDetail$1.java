package com.stepos.ailauncher.agent.skill.detail;

import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillSource;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$loadDetail$1", f = "SkillDetailFragment.kt", l = {548}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailFragment$loadDetail$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $slug;
    final /* synthetic */ int $testing;
    int label;
    final /* synthetic */ SkillDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailFragment$loadDetail$1(String str, int i10, SkillDetailFragment skillDetailFragment, InterfaceC4014c<? super SkillDetailFragment$loadDetail$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$slug = str;
        this.$testing = i10;
        this.this$0 = skillDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillDetailFragment$loadDetail$1(this.$slug, this.$testing, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SkillDetailFragment$loadDetail$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object value;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SkillDetailRepository skillDetailRepository = SkillDetailRepository.INSTANCE;
            String str = this.$slug;
            int i11 = this.$testing;
            this.label = 1;
            Object objD = skillDetailRepository.d(str, i11, this);
            if (objD == objG) {
                return objG;
            }
            value = objD;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            value = ((Result) obj).getValue();
        }
        SkillDetailFragment skillDetailFragment = this.this$0;
        if (Result.h(value)) {
            SkillDetailDto skillDetailDto = (SkillDetailDto) value;
            skillDetailFragment.a1(skillDetailDto);
            skillDetailFragment.fallbackItem = SkillItem.copy$default(H.b(skillDetailDto), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, skillDetailFragment.isTesting ? SkillSource.TESTING : SkillSource.NORMAL, -1, 7, null);
        }
        String str2 = this.$slug;
        Throwable thE = Result.e(value);
        if (thE != null) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("fetch skill detail failed slug=%s", Arrays.copyOf(new Object[]{str2}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.t("SkillDetailFragment", str3, thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }
}
