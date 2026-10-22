package io.ktor.client.engine.cio;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.cio.CIOHeaders;
import io.ktor.http.cio.Response;
import io.ktor.network.sockets.Connection;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.engine.cio.ConnectionPipeline$responseHandler$1", f = "ConnectionPipeline.kt", l = {72, 75, 124, 134, 139, 144, 144}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ConnectionPipeline$responseHandler$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Connection $connection;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    final /* synthetic */ ConnectionPipeline this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPipeline$responseHandler$1(ConnectionPipeline connectionPipeline, Connection connection, InterfaceC4014c<? super ConnectionPipeline$responseHandler$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = connectionPipeline;
        this.$connection = connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$0(Response response, HeadersBuilder headersBuilder) {
        headersBuilder.appendAll(new CIOHeaders(response.getHeaders()));
        response.getHeaders().release();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$1(ByteReadChannel byteReadChannel, Throwable th) {
        ByteReadChannelKt.cancel(byteReadChannel);
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ConnectionPipeline$responseHandler$1 connectionPipeline$responseHandler$1 = new ConnectionPipeline$responseHandler$1(this.this$0, this.$connection, interfaceC4014c);
        connectionPipeline$responseHandler$1.L$0 = obj;
        return connectionPipeline$responseHandler$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ConnectionPipeline$responseHandler$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:44|(19:163|46|(1:48)|53|54|176|55|(11:57|(1:59)|64|66|(7:72|(6:74|(0)(1:78)|(4:178|81|82|83)(1:86)|(1:88)(2:90|91)|92|(8:158|94|169|95|96|165|97|(5:100|156|101|102|(6:173|118|119|171|120|(8:123|124|125|131|138|(3:140|(1:142)|143)|144|(1:146)(2:32|(0)(0))))(6:130|131|138|(0)|144|(0)(0))))(2:116|(0)(0)))|79|(0)(0)|(0)(0)|92|(0)(0))(1:70)|71|79|(0)(0)|(0)(0)|92|(0)(0))|62|(1:64)(1:65)|66|(0)|72|(1:71)(0)|79|(0)(0)|(0)(0)|92|(0)(0))|52|53|54|176|55|(0)|62|(0)(0)|66|(0)|72|(0)(0)|79|(0)(0)|(0)(0)|92|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(1:173)|118|119|171|120|(8:123|124|125|131|138|(3:140|(1:142)|143)|144|(1:146)(2:32|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0493, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0494, code lost:
    
        r2 = r10;
        r4 = r11;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x054d, code lost:
    
        if (r0.flushAndClose(r29) == r9) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0594, code lost:
    
        if (r1.flushAndClose(r29) != r9) goto L154;
     */
    /* JADX WARN: Path cross not found for [B:163:0x01fd, B:52:0x020f], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:57:0x0250, B:62:0x025f], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:62:0x025f, B:57:0x0250], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:62:0x025f, B:64:0x0269], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:64:0x0269, B:62:0x025f], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:68:0x0272, B:72:0x027a], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:72:0x027a, B:68:0x0272], limit reached: 171 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04d0 A[Catch: all -> 0x0039, TryCatch #10 {all -> 0x0039, blocks: (B:9:0x0034, B:143:0x050c, B:32:0x0150, B:36:0x0185, B:38:0x018d, B:138:0x04c2, B:140:0x04d0, B:137:0x04b8, B:28:0x013a, B:31:0x0145), top: B:162:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0416 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0150 A[Catch: all -> 0x0039, PHI: r0 r1
      0x0150: PHI (r0v59 Wa.i) = (r0v61 Wa.i), (r0v69 Wa.i) binds: [B:145:0x0513, B:31:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r1v36 int) = (r1v38 int), (r1v42 int) binds: [B:145:0x0513, B:31:0x0145] A[DONT_GENERATE, DONT_INLINE], TryCatch #10 {all -> 0x0039, blocks: (B:9:0x0034, B:143:0x050c, B:32:0x0150, B:36:0x0185, B:38:0x018d, B:138:0x04c2, B:140:0x04d0, B:137:0x04b8, B:28:0x013a, B:31:0x0145), top: B:162:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018d A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #10 {all -> 0x0039, blocks: (B:9:0x0034, B:143:0x050c, B:32:0x0150, B:36:0x0185, B:38:0x018d, B:138:0x04c2, B:140:0x04d0, B:137:0x04b8, B:28:0x013a, B:31:0x0145), top: B:162:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c4 A[Catch: all -> 0x04a4, TRY_LEAVE, TryCatch #2 {all -> 0x04a4, blocks: (B:42:0x01bf, B:44:0x01c4, B:53:0x0211), top: B:160:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0250 A[Catch: all -> 0x025b, TryCatch #11 {all -> 0x025b, blocks: (B:55:0x0229, B:57:0x0250, B:62:0x025f, B:135:0x04ab, B:136:0x04b7), top: B:176:0x0229 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0272 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0277 A[PHI: r21
      0x0277: PHI (r21v9 io.ktor.http.HttpProtocolVersion) = (r21v2 io.ktor.http.HttpProtocolVersion), (r21v10 io.ktor.http.HttpProtocolVersion) binds: [B:73:0x0286, B:70:0x0275] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0288 A[Catch: all -> 0x0208, TRY_ENTER, TryCatch #4 {all -> 0x0208, blocks: (B:46:0x01fd, B:48:0x0203, B:83:0x02ba, B:88:0x02d0, B:74:0x0288, B:76:0x02a4), top: B:163:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d0 A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #4 {all -> 0x0208, blocks: (B:46:0x01fd, B:48:0x0203, B:83:0x02ba, B:88:0x02d0, B:74:0x0288, B:76:0x02a4), top: B:163:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02dc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x04ce -> B:144:0x050e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x0508 -> B:143:0x050c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.ConnectionPipeline$responseHandler$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
