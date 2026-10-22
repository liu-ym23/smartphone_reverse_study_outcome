package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0010\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR6\u0010\u0010\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", UxipConstants.f30680s, "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "LXa/c;", "collector", "Lkotlin/Function2;", "Le9/c;", "", "Lp9/p;", "action", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscribedFlowCollector<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final c<T> collector;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<c<? super T>, InterfaceC4014c<? super t>, Object> action;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r6).b(r0) == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.f36668d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36668d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f36666b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36668d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f36665a
            kotlinx.coroutines.flow.internal.SafeCollector r6 = (kotlinx.coroutines.flow.internal.SafeCollector) r6
            kotlin.C4849c.b(r7)
            goto L77
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r2 = r0.f36665a
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L40
            goto L5d
        L40:
            r6 = move-exception
            goto L7d
        L42:
            kotlin.C4849c.b(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            Xa.c<T> r7 = r6.collector
            kotlin.coroutines.d r5 = r0.getContext()
            r2.<init>(r7, r5)
            p9.p<Xa.c<? super T>, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.action     // Catch: java.lang.Throwable -> L40
            r0.f36665a = r2     // Catch: java.lang.Throwable -> L40
            r0.f36668d = r4     // Catch: java.lang.Throwable -> L40
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L40
            if (r7 != r1) goto L5d
            goto L76
        L5d:
            r2.releaseIntercepted()
            Xa.c<T> r6 = r6.collector
            boolean r7 = r6 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r7 == 0) goto L7a
            kotlinx.coroutines.flow.SubscribedFlowCollector r6 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r6
            java.lang.Object r7 = g9.h.a(r2)
            r0.f36665a = r7
            r0.f36668d = r3
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L77
        L76:
            return r1
        L77:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L7a:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L7d:
            r2.releaseIntercepted()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.b(e9.c):java.lang.Object");
    }

    @Override // Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        return this.collector.emit(t10, interfaceC4014c);
    }
}
