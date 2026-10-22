package com.stepos.ailauncher.agent.skill.opera;

import Ua.M;
import Y8.t;
import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$startPoll$1", f = "SkillOperaManager.kt", l = {657, 658, MinusOneTransitionSpec.TOTAL_DURATION_MS, 670, 672}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillOperaManager$startPoll$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public SkillOperaManager$startPoll$1(InterfaceC4014c<? super SkillOperaManager$startPoll$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SkillOperaManager$startPoll$1 skillOperaManager$startPoll$1 = new SkillOperaManager$startPoll$1(interfaceC4014c);
        skillOperaManager$startPoll$1.L$0 = obj;
        return skillOperaManager$startPoll$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillOperaManager$startPoll$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e6, code lost:
    
        if (r0.j0("query failed", r18) == r3) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x010c -> B:23:0x005d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$startPoll$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
