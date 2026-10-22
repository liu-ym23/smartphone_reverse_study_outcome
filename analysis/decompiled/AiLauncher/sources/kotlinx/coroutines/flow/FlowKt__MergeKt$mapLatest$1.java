package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "it", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {213, 213}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements q<c<? super R>, T, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36488a;

    /* renamed from: b, reason: collision with root package name */
    public int f36489b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f36490c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36491d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p<T, InterfaceC4014c<? super R>, Object> f36492e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(p<? super T, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super FlowKt__MergeKt$mapLatest$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f36492e = pVar;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(c<? super R> cVar, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.f36492e, interfaceC4014c);
        flowKt__MergeKt$mapLatest$1.f36490c = cVar;
        flowKt__MergeKt$mapLatest$1.f36491d = t10;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        if (r3.emit(r7, r6) == r2) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f36490c
            Xa.c r0 = (Xa.c) r0
            java.lang.Object r1 = r6.f36491d
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r6.f36489b
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L28
            if (r3 == r5) goto L20
            if (r3 != r4) goto L18
            kotlin.C4849c.b(r7)
            goto L5d
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L20:
            java.lang.Object r3 = r6.f36488a
            Xa.c r3 = (Xa.c) r3
            kotlin.C4849c.b(r7)
            goto L45
        L28:
            kotlin.C4849c.b(r7)
            p9.p<T, e9.c<? super R>, java.lang.Object> r7 = r6.f36492e
            java.lang.Object r3 = g9.h.a(r0)
            r6.f36490c = r3
            java.lang.Object r3 = g9.h.a(r1)
            r6.f36491d = r3
            r6.f36488a = r0
            r6.f36489b = r5
            java.lang.Object r7 = r7.invoke(r1, r6)
            if (r7 != r2) goto L44
            goto L5c
        L44:
            r3 = r0
        L45:
            java.lang.Object r0 = g9.h.a(r0)
            r6.f36490c = r0
            java.lang.Object r0 = g9.h.a(r1)
            r6.f36491d = r0
            r0 = 0
            r6.f36488a = r0
            r6.f36489b = r4
            java.lang.Object r6 = r3.emit(r7, r6)
            if (r6 != r2) goto L5d
        L5c:
            return r2
        L5d:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
