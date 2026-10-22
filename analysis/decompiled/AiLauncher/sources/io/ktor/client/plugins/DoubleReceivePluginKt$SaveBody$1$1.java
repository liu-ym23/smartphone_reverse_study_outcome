package io.ktor.client.plugins;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "LY8/t;", UxipConstants.f30685x, "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.DoubleReceivePluginKt$SaveBody$1$1", f = "SaveBody.kt", l = {45, 52}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DoubleReceivePluginKt$SaveBody$1$1 extends SuspendLambda implements p9.q<PipelineContext<HttpResponse, Y8.t>, HttpResponse, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public DoubleReceivePluginKt$SaveBody$1$1(InterfaceC4014c<? super DoubleReceivePluginKt$SaveBody$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<HttpResponse, Y8.t> pipelineContext, HttpResponse httpResponse, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        DoubleReceivePluginKt$SaveBody$1$1 doubleReceivePluginKt$SaveBody$1$1 = new DoubleReceivePluginKt$SaveBody$1$1(interfaceC4014c);
        doubleReceivePluginKt$SaveBody$1$1.L$0 = pipelineContext;
        doubleReceivePluginKt$SaveBody$1$1.L$1 = httpResponse;
        return doubleReceivePluginKt$SaveBody$1$1.invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:53|(1:(1:(3:6|39|40)(2:7|8))(2:9|10))(2:14|(4:16|(1:18)|19|20)(4:21|(1:23)|24|(2:26|38)(1:27)))|28|49|29|33|(1:35)|36) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d3, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d4, code lost:
    
        r8 = kotlin.Result.INSTANCE;
        r7 = kotlin.Result.b(kotlin.C4849c.a(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0118, code lost:
    
        if (r0.proceedWith(r12, r11) == r2) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DoubleReceivePluginKt$SaveBody$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
