package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Y8.t;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStallWatch$1", f = "AIEngineTtsEngine.kt", l = {PictureConfig.REQUEST_CAMERA, 938}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$startStallWatch$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $generation;
    final /* synthetic */ q $handler;
    final /* synthetic */ InterfaceC5063a<Long> $sinceResumeMs;
    final /* synthetic */ InterfaceC5074l<String, Boolean> $tryResume;
    long J$0;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AIEngineTtsEngine$startStallWatch$1(int i10, AIEngineTtsEngine aIEngineTtsEngine, q qVar, InterfaceC5063a<Long> interfaceC5063a, InterfaceC5074l<? super String, Boolean> interfaceC5074l, InterfaceC4014c<? super AIEngineTtsEngine$startStallWatch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$generation = i10;
        this.this$0 = aIEngineTtsEngine;
        this.$handler = qVar;
        this.$sinceResumeMs = interfaceC5063a;
        this.$tryResume = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineTtsEngine$startStallWatch$1(this.$generation, this.this$0, this.$handler, this.$sinceResumeMs, this.$tryResume, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$startStallWatch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Path cross not found for [B:11:0x0020, B:31:0x00d3], limit reached: 35 */
    /* JADX WARN: Path cross not found for [B:24:0x005f, B:11:0x0020], limit reached: 35 */
    /* JADX WARN: Path cross not found for [B:33:0x013f, B:11:0x0020], limit reached: 35 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:11:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00cf -> B:11:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x013d -> B:11:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0149 -> B:11:0x0020). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStallWatch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
