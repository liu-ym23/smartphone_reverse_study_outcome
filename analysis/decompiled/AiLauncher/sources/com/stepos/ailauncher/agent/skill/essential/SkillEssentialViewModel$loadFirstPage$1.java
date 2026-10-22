package com.stepos.ailauncher.agent.skill.essential;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1", f = "SkillEssentialViewModel.kt", l = {271, 272}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel$loadFirstPage$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ boolean $isRefresh;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ SkillEssentialViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillEssentialViewModel$loadFirstPage$1(SkillEssentialViewModel skillEssentialViewModel, boolean z10, InterfaceC4014c<? super SkillEssentialViewModel$loadFirstPage$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillEssentialViewModel;
        this.$isRefresh = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SkillEssentialViewModel$loadFirstPage$1 skillEssentialViewModel$loadFirstPage$1 = new SkillEssentialViewModel$loadFirstPage$1(this.this$0, this.$isRefresh, interfaceC4014c);
        skillEssentialViewModel$loadFirstPage$1.L$0 = obj;
        return skillEssentialViewModel$loadFirstPage$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillEssentialViewModel$loadFirstPage$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0178 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0192 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b9 A[Catch: Exception -> 0x002d, LOOP:1: B:52:0x01b3->B:54:0x01b9, LOOP_END, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e2 A[Catch: Exception -> 0x002d, LOOP:2: B:56:0x01dc->B:58:0x01e2, LOOP_END, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022c A[Catch: Exception -> 0x002d, TRY_LEAVE, TryCatch #0 {Exception -> 0x002d, blocks: (B:7:0x0026, B:28:0x00f0, B:30:0x00f4, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:36:0x0117, B:38:0x011d, B:41:0x0178, B:43:0x017e, B:45:0x0192, B:51:0x01a4, B:52:0x01b3, B:54:0x01b9, B:55:0x01cd, B:56:0x01dc, B:58:0x01e2, B:59:0x01f6, B:60:0x0200, B:62:0x0224, B:64:0x022c, B:47:0x0196, B:49:0x019e, B:50:0x01a1, B:14:0x0045, B:24:0x00ca, B:17:0x0050, B:18:0x0058, B:20:0x0081), top: B:75:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0249 A[LOOP:3: B:60:0x0200->B:66:0x0249, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0224 A[EDGE_INSN: B:80:0x0224->B:62:0x0224 BREAK  A[LOOP:3: B:60:0x0200->B:66:0x0249], SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r52) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
