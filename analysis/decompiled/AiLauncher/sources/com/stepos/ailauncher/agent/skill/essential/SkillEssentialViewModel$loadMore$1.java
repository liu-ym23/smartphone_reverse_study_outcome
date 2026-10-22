package com.stepos.ailauncher.agent.skill.essential;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadMore$1", f = "SkillEssentialViewModel.kt", l = {329, 331}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel$loadMore$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SkillEssentialUiState $state;
    int I$0;
    int label;
    final /* synthetic */ SkillEssentialViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillEssentialViewModel$loadMore$1(SkillEssentialViewModel skillEssentialViewModel, SkillEssentialUiState skillEssentialUiState, InterfaceC4014c<? super SkillEssentialViewModel$loadMore$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillEssentialViewModel;
        this.$state = skillEssentialUiState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillEssentialViewModel$loadMore$1(this.this$0, this.$state, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillEssentialViewModel$loadMore$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x019a A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0012, B:32:0x0095, B:34:0x009a, B:37:0x00a2, B:38:0x00a6, B:40:0x00b0, B:41:0x00bf, B:43:0x00c5, B:45:0x0122, B:46:0x012a, B:48:0x0138, B:54:0x0149, B:55:0x0159, B:57:0x015f, B:58:0x0177, B:60:0x0183, B:65:0x0195, B:67:0x019e, B:69:0x01d9, B:71:0x01e1, B:66:0x019a, B:50:0x013d, B:52:0x0143, B:53:0x0146, B:14:0x0027, B:26:0x0083, B:17:0x0030, B:18:0x0036, B:20:0x005a, B:22:0x006b, B:28:0x0087), top: B:82:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r56) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadMore$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
