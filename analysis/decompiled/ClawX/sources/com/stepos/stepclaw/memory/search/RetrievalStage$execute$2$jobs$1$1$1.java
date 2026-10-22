package com.stepos.stepclaw.memory.search;

import a6.f0;
import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import h5.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import p5.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.search.RetrievalStage$execute$2$jobs$1$1$1", f = "RetrievalStage.kt", l = {40}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class RetrievalStage$execute$2$jobs$1$1$1 extends i implements p {
    final /* synthetic */ String $category;
    final /* synthetic */ SearchContext $context;
    final /* synthetic */ QueryItem $queryItem;
    final /* synthetic */ MemoryRetriever $retriever;
    int label;
    final /* synthetic */ RetrievalStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetrievalStage$execute$2$jobs$1$1$1(MemoryRetriever memoryRetriever, QueryItem queryItem, String str, RetrievalStage retrievalStage, SearchContext searchContext, f5.c cVar) {
        super(2, cVar);
        this.$retriever = memoryRetriever;
        this.$queryItem = queryItem;
        this.$category = str;
        this.this$0 = retrievalStage;
        this.$context = searchContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0(MemoryRetriever memoryRetriever, String str, QueryItem queryItem, List list) {
        return z.a(memoryRetriever.getClass()).b() + " [" + str + "] query='" + n.Q1(30, queryItem.getQuery()) + "' returned " + list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$1(MemoryRetriever memoryRetriever, String str, Exception exc) {
        return z.a(memoryRetriever.getClass()).b() + " [" + str + "] failed: " + exc.getMessage();
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new RetrievalStage$execute$2$jobs$1$1$1(this.$retriever, this.$queryItem, this.$category, this.this$0, this.$context, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((RetrievalStage$execute$2$jobs$1$1$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        try {
            if (i8 == 0) {
                a.a.c0(obj);
                MemoryRetriever memoryRetriever = this.$retriever;
                String query = this.$queryItem.getQuery();
                String str = this.$category;
                int i9 = this.this$0.topKPerCategory;
                this.label = 1;
                obj = memoryRetriever.retrieve(query, str, i9, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            final List list = (List) obj;
            MemoryLogger memoryLogger = this.this$0.logger;
            String sessionId = this.$context.getSessionId();
            final MemoryRetriever memoryRetriever2 = this.$retriever;
            final String str2 = this.$category;
            final QueryItem queryItem = this.$queryItem;
            memoryLogger.logD("RetrievalStage", sessionId, new p5.a() { // from class: com.stepos.stepclaw.memory.search.e
                @Override // p5.a
                public final Object invoke() {
                    return RetrievalStage$execute$2$jobs$1$1$1.invokeSuspend$lambda$0(memoryRetriever2, str2, queryItem, list);
                }
            });
            return list;
        } catch (Exception e9) {
            this.this$0.logger.logW("RetrievalStage", this.$context.getSessionId(), new f(this.$retriever, this.$category, e9, 0));
            return s.f1092a;
        }
    }
}
