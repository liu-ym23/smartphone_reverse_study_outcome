package kotlinx.coroutines.flow;

import Ua.M;
import Xa.b;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "LXa/c;", "downstream", "LY8/t;", "<anonymous>", "(LUa/M;LXa/c;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {215, 415}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements q<M, c<? super T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36402a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36403b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36404c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36405d;

    /* renamed from: e, reason: collision with root package name */
    public int f36406e;

    /* renamed from: f, reason: collision with root package name */
    public int f36407f;

    /* renamed from: g, reason: collision with root package name */
    public int f36408g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f36409h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f36410i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<T, Long> f36411j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b<T> f36412k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(InterfaceC5074l<? super T, Long> interfaceC5074l, b<? extends T> bVar, InterfaceC4014c<? super FlowKt__DelayKt$debounceInternal$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f36411j = interfaceC5074l;
        this.f36412k = bVar;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(M m10, c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.f36411j, this.f36412k, interfaceC4014c);
        flowKt__DelayKt$debounceInternal$1.f36409h = m10;
        flowKt__DelayKt$debounceInternal$1.f36410i = cVar;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
    
        if (r1.emit(r6, r17) == r8) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0100, code lost:
    
        if (r6.o(r17) != r8) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac A[PHI: r3 r4 r5
      0x00ac: PHI (r3v4 kotlin.jvm.internal.Ref$LongRef) = (r3v6 kotlin.jvm.internal.Ref$LongRef), (r3v8 kotlin.jvm.internal.Ref$LongRef), (r3v8 kotlin.jvm.internal.Ref$LongRef) binds: [B:29:0x00aa, B:15:0x006d, B:22:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x00ac: PHI (r4v2 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r4v8 kotlin.jvm.internal.Ref$ObjectRef)
      (r4v9 kotlin.jvm.internal.Ref$ObjectRef)
      (r4v9 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:29:0x00aa, B:15:0x006d, B:22:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x00ac: PHI (r5v2 Wa.r) = (r5v3 Wa.r), (r5v4 Wa.r), (r5v4 Wa.r) binds: [B:29:0x00aa, B:15:0x006d, B:22:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0100 -> B:7:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
