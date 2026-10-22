package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.q;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aS\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012.\u0010\b\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0004\b\t\u0010\n\u001a0\u0010\f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0014\u001a\u00020\u0010*\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "Lkotlin/Function3;", "LXa/c;", "", "Le9/c;", "LY8/t;", "", "action", Const.INTENT_KEY_APIKEY, "(LXa/b;Lp9/q;)LXa/b;", "collector", Const.INTENT_KEY_PKGNAME, "(LXa/b;LXa/c;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/d;", "coroutineContext", "", "c", "(Ljava/lang/Throwable;Lkotlin/coroutines/d;)Z", "other", Const.INTENT_KEY_UMID, "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {
    public static final <T> b<T> a(b<? extends T> bVar, q<? super c<? super T>, ? super Throwable, ? super InterfaceC4014c<? super t>, ? extends Object> qVar) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(bVar, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(Xa.b<? extends T> r5, Xa.c<? super T> r6, e9.InterfaceC4014c<? super java.lang.Throwable> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.f36462e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36462e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f36461d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36462e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f36460c
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
            java.lang.Object r6 = r0.f36459b
            Xa.c r6 = (Xa.c) r6
            java.lang.Object r6 = r0.f36458a
            Xa.b r6 = (Xa.b) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L63
        L35:
            r6 = move-exception
            goto L67
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.C4849c.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L65
            r2.<init>(r6, r7)     // Catch: java.lang.Throwable -> L65
            java.lang.Object r4 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L65
            r0.f36458a = r4     // Catch: java.lang.Throwable -> L65
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L65
            r0.f36459b = r6     // Catch: java.lang.Throwable -> L65
            r0.f36460c = r7     // Catch: java.lang.Throwable -> L65
            r0.f36462e = r3     // Catch: java.lang.Throwable -> L65
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r5 != r1) goto L63
            return r1
        L63:
            r5 = 0
            return r5
        L65:
            r6 = move-exception
            r5 = r7
        L67:
            T r5 = r5.f34820a
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            boolean r7 = d(r6, r5)
            if (r7 != 0) goto L8a
            kotlin.coroutines.d r7 = r0.getContext()
            boolean r7 = c(r6, r7)
            if (r7 != 0) goto L8a
            if (r5 != 0) goto L7e
            return r6
        L7e:
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException
            if (r7 == 0) goto L86
            Y8.d.a(r5, r6)
            throw r5
        L86:
            Y8.d.a(r6, r5)
            throw r6
        L8a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(Xa.b, Xa.c, e9.c):java.lang.Object");
    }

    public static final boolean c(Throwable th, d dVar) {
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar == null || !gVar.isCancelled()) {
            return false;
        }
        return d(th, gVar.G());
    }

    public static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && p.d(th2, th);
    }
}
