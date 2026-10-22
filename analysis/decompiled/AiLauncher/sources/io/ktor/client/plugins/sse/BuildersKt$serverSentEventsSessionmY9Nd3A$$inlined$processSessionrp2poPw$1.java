package io.ktor.client.plugins.sse;

import Ua.InterfaceC1083u;
import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpStatement;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V", "io/ktor/client/plugins/sse/BuildersKt$processSession$2"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", l = {1258, 1261, 1273, 1273}, m = "invokeSuspend")
/* renamed from: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession-mY9Nd3A$$inlined$processSession-rp2poPw$1, reason: invalid class name */
/* loaded from: classes4.dex */
public final class BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC1083u $sessionDeferred;
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
    public BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(HttpStatement httpStatement, InterfaceC1083u interfaceC1083u, HttpClient httpClient, InterfaceC4014c interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$statement = httpStatement;
        this.$sessionDeferred = interfaceC1083u;
        this.$this_processSession = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(this.$statement, this.$sessionDeferred, this.$this_processSession, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:67)|(1:(1:(1:(1:(2:8|9)(3:10|11|57))(4:17|18|64|65))(6:20|72|21|22|66|(2:44|45)(2:50|51)))(3:25|26|27))(4:28|29|30|(2:32|56)(1:33))|34|70|35|68|36|39|(3:42|66|(0)(0))|56) */
    /* JADX WARN: Can't wrap try/catch for region: R(10:67|(1:(1:(1:(1:(2:8|9)(3:10|11|57))(4:17|18|64|65))(6:20|72|21|22|66|(2:44|45)(2:50|51)))(3:25|26|27))(4:28|29|30|(2:32|56)(1:33))|34|70|35|68|36|39|(3:42|66|(0)(0))|56) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010e, code lost:
    
        if (r13.cleanup(r8, r16) == r2) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011d, code lost:
    
        r8 = r7;
        r6 = r11;
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0140, code lost:
    
        if (r10.cleanup(r8, r16) != r2) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5 A[Catch: all -> 0x0111, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0111, blocks: (B:44:0x00e5, B:50:0x0114, B:51:0x011b), top: B:66:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114 A[Catch: all -> 0x0111, TRY_ENTER, TryCatch #0 {all -> 0x0111, blocks: (B:44:0x00e5, B:50:0x0114, B:51:0x011b), top: B:66:0x00e3 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
