package c3;

import Z2.F;
import a3.InterfaceC0164i;
import b3.InterfaceC0379h;
import b3.InterfaceC0380i;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes2.dex */
public final class i extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0164i f4491a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f4492b;

    /* renamed from: c, reason: collision with root package name */
    public int f4493c;

    /* renamed from: d, reason: collision with root package name */
    public int f4494d;

    /* renamed from: e, reason: collision with root package name */
    public int f4495e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4496f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h[] f4497g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function0 f4498h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function3 f4499i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0380i f4500j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Continuation continuation, Function0 function0, Function3 function3, InterfaceC0380i interfaceC0380i, InterfaceC0379h[] interfaceC0379hArr) {
        super(2, continuation);
        this.f4497g = interfaceC0379hArr;
        this.f4498h = function0;
        this.f4499i = function3;
        this.f4500j = interfaceC0380i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        i iVar = new i(continuation, this.f4498h, this.f4499i, this.f4500j, this.f4497g);
        iVar.f4496f = obj;
        return iVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e8, code lost:
    
        if (r9 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        r12 = (java.lang.Object[]) r20.f4498h.invoke();
        r13 = r20.f4500j;
        r14 = r20.f4499i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f6, code lost:
    
        if (r12 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
    
        r20.f4496f = r10;
        r20.f4491a = r11;
        r20.f4492b = r2;
        r20.f4493c = r9;
        r20.f4494d = r7;
        r20.f4495e = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
    
        if (r14.invoke(r13, r10, r20) != r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010b, code lost:
    
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r10, r12, 0, 0, 0, 14, (java.lang.Object) null);
        r20.f4496f = r10;
        r20.f4491a = r11;
        r20.f4492b = r2;
        r20.f4493c = r9;
        r20.f4494d = r7;
        r20.f4495e = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0121, code lost:
    
        if (r14.invoke(r13, r12, r20) != r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0123, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        if (r9 != 0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:42:0x00e8, B:36:0x00d6], limit reached: 54 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[LOOP:0: B:31:0x00c2->B:54:?, LOOP_START, PHI: r9 r13
      0x00c2: PHI (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:28:0x00bd, B:54:?] A[DONT_GENERATE, DONT_INLINE]
      0x00c2: PHI (r13v5 kotlin.collections.IndexedValue) = (r13v4 kotlin.collections.IndexedValue), (r13v11 kotlin.collections.IndexedValue) binds: [B:28:0x00bd, B:54:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0108 -> B:20:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0121 -> B:51:0x0124). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
