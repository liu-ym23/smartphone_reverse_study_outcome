package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository$status$1", f = "WecomCliRepository.kt", l = {184, 185}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WecomCliRepository$status$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $effective;
    final /* synthetic */ String $envId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WecomCliRepository$status$1(String str, String str2, InterfaceC4014c<? super WecomCliRepository$status$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$effective = str;
        this.$envId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        WecomCliRepository$status$1 wecomCliRepository$status$1 = new WecomCliRepository$status$1(this.$effective, this.$envId, interfaceC4014c);
        wecomCliRepository$status$1.L$0 = obj;
        return wecomCliRepository$status$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((WecomCliRepository$status$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
    
        if (r15 == r1) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository$status$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
