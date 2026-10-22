package com.stepos.ailauncher.sla;

import com.stepos.aiengine.algorithm.sla.SlaDecision;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.x;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$Race$listener$1$onSlaOutput$5", f = "SlaGate.kt", l = {925}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$Race$listener$1$onSlaOutput$5 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<SlaDecision> $decisions;
    final /* synthetic */ ArrayList<x.Parsed> $executable;
    final /* synthetic */ long $modelInferMs;
    final /* synthetic */ String $output;
    final /* synthetic */ List<String> $permFunctions;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SlaGate this$0;
    final /* synthetic */ SlaGate.Race this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaGate$Race$listener$1$onSlaOutput$5(SlaGate slaGate, List<String> list, SlaGate.Race race, ArrayList<x.Parsed> arrayList, String str, long j10, List<SlaDecision> list2, InterfaceC4014c<? super SlaGate$Race$listener$1$onSlaOutput$5> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaGate;
        this.$permFunctions = list;
        this.this$1 = race;
        this.$executable = arrayList;
        this.$output = str;
        this.$modelInferMs = j10;
        this.$decisions = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlaGate$Race$listener$1$onSlaOutput$5 slaGate$Race$listener$1$onSlaOutput$5 = new SlaGate$Race$listener$1$onSlaOutput$5(this.this$0, this.$permFunctions, this.this$1, this.$executable, this.$output, this.$modelInferMs, this.$decisions, interfaceC4014c);
        slaGate$Race$listener$1$onSlaOutput$5.L$0 = obj;
        return slaGate$Race$listener$1$onSlaOutput$5;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$Race$listener$1$onSlaOutput$5) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04fd A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0538 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0549 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0551 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0561 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0571 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05e1 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x060c A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0611 A[Catch: all -> 0x053f, TryCatch #8 {all -> 0x053f, blocks: (B:78:0x03d4, B:82:0x03df, B:86:0x0411, B:89:0x0429, B:97:0x04b2, B:112:0x04f6, B:116:0x0528, B:118:0x0538, B:125:0x0549, B:128:0x0551, B:131:0x0561, B:135:0x0571, B:138:0x0582, B:140:0x05e1, B:142:0x05e7, B:146:0x05ee, B:157:0x060c, B:159:0x0617, B:158:0x0611, B:153:0x0602, B:115:0x04fd, B:111:0x04ec), top: B:196:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: all -> 0x0024, TRY_ENTER, TryCatch #3 {all -> 0x0024, blocks: (B:6:0x001e, B:20:0x005e, B:22:0x0066, B:23:0x00cf), top: B:188:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0157 A[Catch: all -> 0x0211, TRY_ENTER, TryCatch #0 {all -> 0x0211, blocks: (B:17:0x004c, B:33:0x0157, B:35:0x015d, B:38:0x016f), top: B:183:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0347 A[Catch: all -> 0x020c, TRY_LEAVE, TryCatch #6 {all -> 0x020c, blocks: (B:57:0x0339, B:59:0x0347, B:40:0x017d, B:45:0x0215, B:56:0x02e4), top: B:193:0x005c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate$Race$listener$1$onSlaOutput$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
