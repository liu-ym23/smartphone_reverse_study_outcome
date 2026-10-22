package io.ktor.client.plugins.cache;

import Y8.t;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", l = {174, 178, 184, 193, 198}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpCache$Companion$install$1 extends SuspendLambda implements q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, InterfaceC4014c<? super HttpCache$Companion$install$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, interfaceC4014c);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d3, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCacheLegacyKt.interceptSendLegacy(r2, r11, r1, r3, r10) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0196, code lost:
    
        if (r3.proceedWithMissingCache$ktor_client_core(r2, r4, r10) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01fe, code lost:
    
        if (r5.proceedWithCache$ktor_client_core(r2, r6, r3, r10) == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0239, code lost:
    
        if (r1.proceedWithWarning(r2, r11, r4, r6, r10) == r7) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
