package kotlinx.coroutines.flow.internal;

import Xa.c;
import Ya.j;
import Ya.o;
import Za.J;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aZ\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH\u0080@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "Lkotlin/coroutines/d;", "emitContext", Const.INTENT_KEY_UMID, "(LXa/c;Lkotlin/coroutines/d;)LXa/c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", UxipConstants.f30680s, "", "countOrElement", "Lkotlin/Function2;", "Le9/c;", "block", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;Ljava/lang/Object;Ljava/lang/Object;Lp9/p;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelFlowKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, V> java.lang.Object b(kotlin.coroutines.d r5, V r6, java.lang.Object r7, p9.p<? super V, ? super e9.InterfaceC4014c<? super T>, ? extends java.lang.Object> r8, e9.InterfaceC4014c<? super T> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1) r0
            int r1 = r0.f36695l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36695l = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f36694k
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36695l
            r3 = 1
            if (r2 == 0) goto L4b
            if (r2 != r3) goto L43
            java.lang.Object r5 = r0.f36691h
            kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1 r5 = (kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1) r5
            java.lang.Object r5 = r0.f36690g
            java.lang.Object r6 = r0.f36688e
            kotlin.coroutines.d r6 = (kotlin.coroutines.d) r6
            java.lang.Object r7 = r0.f36687d
            p9.p r7 = (p9.p) r7
            java.lang.Object r7 = r0.f36684a
            kotlin.coroutines.d r7 = (kotlin.coroutines.d) r7
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3f
            r4 = r9
            r9 = r5
            r5 = r6
            r6 = r4
            goto L98
        L3f:
            r7 = move-exception
            r9 = r5
            r5 = r6
            goto L9c
        L43:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L4b:
            kotlin.C4849c.b(r9)
            java.lang.Object r9 = Za.J.i(r5, r7)
            r0.f36684a = r5     // Catch: java.lang.Throwable -> L7f
            r0.f36685b = r6     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r2 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L7f
            r0.f36686c = r2     // Catch: java.lang.Throwable -> L7f
            r0.f36687d = r8     // Catch: java.lang.Throwable -> L7f
            r0.f36688e = r5     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L7f
            r0.f36689f = r7     // Catch: java.lang.Throwable -> L7f
            r0.f36690g = r9     // Catch: java.lang.Throwable -> L7f
            r0.f36691h = r0     // Catch: java.lang.Throwable -> L7f
            r7 = 0
            r0.f36692i = r7     // Catch: java.lang.Throwable -> L7f
            r0.f36693j = r7     // Catch: java.lang.Throwable -> L7f
            r0.f36695l = r3     // Catch: java.lang.Throwable -> L7f
            Ya.p r7 = new Ya.p     // Catch: java.lang.Throwable -> L7f
            r7.<init>(r0, r5)     // Catch: java.lang.Throwable -> L7f
            boolean r2 = r8 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl     // Catch: java.lang.Throwable -> L7f
            if (r2 != 0) goto L81
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.e(r8, r6, r7)     // Catch: java.lang.Throwable -> L7f
            goto L8c
        L7f:
            r7 = move-exception
            goto L9c
        L81:
            r2 = 2
            java.lang.Object r8 = kotlin.jvm.internal.z.g(r8, r2)     // Catch: java.lang.Throwable -> L7f
            p9.p r8 = (p9.p) r8     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r6 = r8.invoke(r6, r7)     // Catch: java.lang.Throwable -> L7f
        L8c:
            java.lang.Object r7 = f9.C4063a.g()     // Catch: java.lang.Throwable -> L7f
            if (r6 != r7) goto L95
            g9.f.c(r0)     // Catch: java.lang.Throwable -> L7f
        L95:
            if (r6 != r1) goto L98
            return r1
        L98:
            Za.J.f(r5, r9)
            return r6
        L9c:
            Za.J.f(r5, r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowKt.b(kotlin.coroutines.d, java.lang.Object, java.lang.Object, p9.p, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object c(d dVar, Object obj, Object obj2, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = J.g(dVar);
        }
        return b(dVar, obj, obj2, pVar, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> d(c<? super T> cVar, d dVar) {
        return ((cVar instanceof o) || (cVar instanceof j)) ? cVar : new UndispatchedContextCollector(cVar, dVar);
    }
}
