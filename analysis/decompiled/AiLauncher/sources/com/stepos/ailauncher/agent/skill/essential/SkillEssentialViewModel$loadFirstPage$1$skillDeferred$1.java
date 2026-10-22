package com.stepos.ailauncher.agent.skill.essential;

import Ua.M;
import Y8.t;
import b5.PagedSkillResponse;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lb5/d;", "<anonymous>", "(LUa/M;)Lb5/d;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1", f = "SkillEssentialViewModel.kt", l = {CustomCameraView.BUTTON_STATE_ONLY_CAPTURE, CustomCameraView.BUTTON_STATE_BOTH}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super PagedSkillResponse>, Object> {
    final /* synthetic */ SkillEssentialUiState $state;
    int label;
    final /* synthetic */ SkillEssentialViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1(SkillEssentialUiState skillEssentialUiState, SkillEssentialViewModel skillEssentialViewModel, InterfaceC4014c<? super SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$state = skillEssentialUiState;
        this.this$0 = skillEssentialViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1(this.$state, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super PagedSkillResponse> interfaceC4014c) {
        return ((SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (r5 == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r5 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r5)
            goto L4e
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.C4849c.b(r5)
            goto L40
        L1e:
            kotlin.C4849c.b(r5)
            com.stepos.ailauncher.agent.skill.essential.k r5 = r4.$state
            boolean r5 = r5.getIsSearching()
            r1 = 20
            if (r5 == 0) goto L43
            com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel r5 = r4.this$0
            com.stepos.ailauncher.agent.skill.repository.e r5 = com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.m(r5)
            com.stepos.ailauncher.agent.skill.essential.k r2 = r4.$state
            java.lang.String r2 = r2.getSearchQuery()
            r4.label = r3
            java.lang.Object r5 = r5.c(r2, r3, r1, r4)
            if (r5 != r0) goto L40
            goto L4d
        L40:
            b5.d r5 = (b5.PagedSkillResponse) r5
            return r5
        L43:
            com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel r5 = r4.this$0
            r4.label = r2
            java.lang.Object r5 = com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.s(r5, r3, r1, r4)
            if (r5 != r0) goto L4e
        L4d:
            return r0
        L4e:
            b5.d r5 = (b5.PagedSkillResponse) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1$skillDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
