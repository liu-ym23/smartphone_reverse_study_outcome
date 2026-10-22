package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a \u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001aD\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@¢\u0006\u0004\b\t\u0010\n\u001aF\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", Const.INTENT_KEY_APIKEY, "(LXa/b;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Le9/c;", "", "", "predicate", Const.INTENT_KEY_PKGNAME, "(LXa/b;Lp9/p;Le9/c;)Ljava/lang/Object;", "c", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ReduceKt$a", "LXa/c;", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f36511a;

        public a(Ref$ObjectRef ref$ObjectRef) {
            this.f36511a = ref$ObjectRef;
        }

        @Override // Xa.c
        public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
            this.f36511a.f34820a = t10;
            throw new AbortFlowException(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(Xa.b<? extends T> r5, e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.f36518g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36518g = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f36517f
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36518g
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r5 = r0.f36515d
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r5 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.a) r5
            java.lang.Object r1 = r0.f36514c
            Xa.b r1 = (Xa.b) r1
            java.lang.Object r1 = r0.f36513b
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r2 = r0.f36512a
            Xa.b r2 = (Xa.b) r2
            kotlin.C4849c.b(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L39
            goto L80
        L39:
            r6 = move-exception
            goto L76
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.C4849c.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            Za.C r2 = Ya.k.f7051a
            r6.f34820a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r6)
            java.lang.Object r4 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r0.f36512a = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r0.f36513b = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            java.lang.Object r4 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r0.f36514c = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r0.f36515d = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r4 = 0
            r0.f36516e = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            r0.f36518g = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L72
            if (r5 != r1) goto L70
            return r1
        L70:
            r1 = r6
            goto L80
        L72:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L76:
            Ya.g.a(r6, r5)
            kotlin.coroutines.d r5 = r0.getContext()
            Ua.C1086v0.m(r5)
        L80:
            T r5 = r1.f34820a
            Za.C r6 = Ya.k.f7051a
            if (r5 == r6) goto L87
            return r5
        L87:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(Xa.b, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(Xa.b<? extends T> r5, p9.p<? super T, ? super e9.InterfaceC4014c<? super java.lang.Boolean>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super T> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) r0
            int r1 = r0.f36526h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36526h = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f36525g
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36526h
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r5 = r0.f36523e
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r5 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r5
            java.lang.Object r6 = r0.f36522d
            Xa.b r6 = (Xa.b) r6
            java.lang.Object r6 = r0.f36521c
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            java.lang.Object r1 = r0.f36520b
            p9.p r1 = (p9.p) r1
            java.lang.Object r1 = r0.f36519a
            Xa.b r1 = (Xa.b) r1
            kotlin.C4849c.b(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L8a
        L3d:
            r7 = move-exception
            goto L80
        L3f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L47:
            kotlin.C4849c.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            Za.C r2 = Ya.k.f7051a
            r7.f34820a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r6, r7)
            java.lang.Object r4 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36519a = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            java.lang.Object r6 = g9.h.a(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36520b = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36521c = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            java.lang.Object r6 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36522d = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36523e = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r6 = 0
            r0.f36524f = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            r0.f36526h = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L7c
            if (r5 != r1) goto L7a
            return r1
        L7a:
            r6 = r7
            goto L8a
        L7c:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r2
        L80:
            Ya.g.a(r7, r5)
            kotlin.coroutines.d r5 = r0.getContext()
            Ua.C1086v0.m(r5)
        L8a:
            T r5 = r6.f34820a
            Za.C r6 = Ya.k.f7051a
            if (r5 == r6) goto L91
            return r5
        L91:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element matching the predicate"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(Xa.b, p9.p, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(Xa.b<? extends T> r5, p9.p<? super T, ? super e9.InterfaceC4014c<? super java.lang.Boolean>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super T> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) r0
            int r1 = r0.f36534h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36534h = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f36533g
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36534h
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r5 = r0.f36531e
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r5 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r5
            java.lang.Object r6 = r0.f36530d
            Xa.b r6 = (Xa.b) r6
            java.lang.Object r6 = r0.f36529c
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            java.lang.Object r1 = r0.f36528b
            p9.p r1 = (p9.p) r1
            java.lang.Object r1 = r0.f36527a
            Xa.b r1 = (Xa.b) r1
            kotlin.C4849c.b(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3d
            goto L86
        L3d:
            r7 = move-exception
            goto L7c
        L3f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L47:
            kotlin.C4849c.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r6, r7)
            java.lang.Object r4 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36527a = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            java.lang.Object r6 = g9.h.a(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36528b = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36529c = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            java.lang.Object r6 = g9.h.a(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36530d = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36531e = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r6 = 0
            r0.f36532f = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            r0.f36534h = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L78
            if (r5 != r1) goto L76
            return r1
        L76:
            r6 = r7
            goto L86
        L78:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r2
        L7c:
            Ya.g.a(r7, r5)
            kotlin.coroutines.d r5 = r0.getContext()
            Ua.C1086v0.m(r5)
        L86:
            T r5 = r6.f34820a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(Xa.b, p9.p, e9.c):java.lang.Object");
    }
}
