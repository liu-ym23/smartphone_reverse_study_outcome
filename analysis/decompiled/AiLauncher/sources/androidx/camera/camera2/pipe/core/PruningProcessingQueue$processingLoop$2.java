package androidx.camera.camera2.pipe.core;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/Void;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2", f = "PruningProcessingQueue.kt", l = {218}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PruningProcessingQueue$processingLoop$2 extends SuspendLambda implements p<M, InterfaceC4014c, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10723a;

    /* renamed from: b, reason: collision with root package name */
    public int f10724b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10725c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PruningProcessingQueue<T> f10726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningProcessingQueue$processingLoop$2(PruningProcessingQueue<T> pruningProcessingQueue, InterfaceC4014c<? super PruningProcessingQueue$processingLoop$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10726d = pruningProcessingQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PruningProcessingQueue$processingLoop$2 pruningProcessingQueue$processingLoop$2 = new PruningProcessingQueue$processingLoop$2(this.f10726d, interfaceC4014c);
        pruningProcessingQueue$processingLoop$2.f10725c = obj;
        return pruningProcessingQueue$processingLoop$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c interfaceC4014c) {
        return ((PruningProcessingQueue$processingLoop$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Path cross not found for [B:13:0x0033, B:23:0x007f], limit reached: 43 */
    /* JADX WARN: Path cross not found for [B:13:0x0033, B:26:0x0084], limit reached: 43 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x001a, CancellationException -> 0x00e1, TRY_ENTER, TryCatch #2 {CancellationException -> 0x00e1, all -> 0x001a, blocks: (B:6:0x0016, B:15:0x0039, B:17:0x005a, B:18:0x0066), top: B:43:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, Ua.Q, kotlinx.coroutines.g] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
