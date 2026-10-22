package io.ktor.client.plugins.sse;

import Ua.InterfaceC1083u;
import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpStatement;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", l = {1258, 1261, 1273, 1273}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class BuildersKt$processSession$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC1083u<T> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    final /* synthetic */ HttpClient $this_processSession;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$processSession$2(HttpStatement httpStatement, InterfaceC1083u<T> interfaceC1083u, HttpClient httpClient, InterfaceC4014c<? super BuildersKt$processSession$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$statement = httpStatement;
        this.$sessionDeferred = interfaceC1083u;
        this.$this_processSession = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BuildersKt$processSession$2(this.$statement, this.$sessionDeferred, this.$this_processSession, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BuildersKt$processSession$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(1:61)|(1:(1:(1:(1:(2:8|9)(3:10|11|51))(4:17|18|58|59))(9:20|66|21|22|42|43|(2:45|50)|58|59))(3:25|26|27))(4:28|29|30|(2:32|50)(1:33))|34|62|35|36|64|37|38|(6:41|42|43|(0)|58|59)|50) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0117, code lost:
    
        r4 = r10;
        r8 = r12;
        r10 = r13;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013a, code lost:
    
        if (r12.cleanup(r11, r17) == r2) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt$processSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
