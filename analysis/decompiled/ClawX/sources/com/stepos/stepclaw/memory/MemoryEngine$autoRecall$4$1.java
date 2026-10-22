package com.stepos.stepclaw.memory;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import com.stepos.stepclaw.memory.search.SearchPipelineResult;
import java.util.List;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$autoRecall$4$1", f = "MemoryEngine.kt", l = {687, 696, 708}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MemoryEngine$autoRecall$4$1 extends h5.i implements p5.p {
    final /* synthetic */ List<MessageItem> $memoryItems;
    final /* synthetic */ String $prompt;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $traceId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryEngine$autoRecall$4$1(String str, String str2, String str3, List<MessageItem> list, f5.c cVar) {
        super(2, cVar);
        this.$sessionId = str;
        this.$prompt = str2;
        this.$traceId = str3;
        this.$memoryItems = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0$0(SearchPipelineResult searchPipelineResult) {
        kotlin.jvm.internal.p.c(searchPipelineResult, "null cannot be cast to non-null type com.stepos.stepclaw.memory.search.SearchPipelineResult.Failed");
        return m0.f.c("autoRecall: pipeline failed: ", ((SearchPipelineResult.Failed) searchPipelineResult).getError().getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$2(String str) {
        return m0.f.c("autoRecall: result=\n", str);
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new MemoryEngine$autoRecall$4$1(this.$sessionId, this.$prompt, this.$traceId, this.$memoryItems, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((MemoryEngine$autoRecall$4$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r0 == r7) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f1, code lost:
    
        if (r0 != r7) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine$autoRecall$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
