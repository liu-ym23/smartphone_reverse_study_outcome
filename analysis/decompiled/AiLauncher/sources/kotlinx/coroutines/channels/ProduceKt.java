package kotlinx.coroutines.channels;

import Ua.G;
import Ua.InterfaceC1066l;
import Ua.M;
import Wa.j;
import Wa.o;
import Wa.r;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineStart;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2(\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0091\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016j\u0004\u0018\u0001`\u00182(\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0000¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LWa/p;", "Lkotlin/Function0;", "LY8/t;", "block", Const.INTENT_KEY_APIKEY, "(LWa/p;Lp9/a;Le9/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "LUa/M;", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlin/Function2;", "Le9/c;", "", "LWa/r;", "c", "(LUa/M;Lkotlin/coroutines/d;ILp9/p;)LWa/r;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", Const.INTENT_KEY_PKGNAME, "(LUa/M;Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lp9/l;Lp9/p;)LWa/r;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProduceKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<t> f36343a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC1066l<? super t> interfaceC1066l) {
            this.f36343a = interfaceC1066l;
        }

        public final void a(Throwable th) {
            InterfaceC1066l<t> interfaceC1066l = this.f36343a;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(t.f7040a));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(Wa.p<?> r4, p9.InterfaceC5063a<Y8.t> r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.f36348e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36348e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f36347d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36348e
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f36345b
            r5 = r4
            p9.a r5 = (p9.InterfaceC5063a) r5
            java.lang.Object r4 = r0.f36344a
            Wa.p r4 = (Wa.p) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L78
        L32:
            r4 = move-exception
            goto L7e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.C4849c.b(r6)
            kotlin.coroutines.d r6 = r0.getContext()
            kotlinx.coroutines.g$b r2 = kotlinx.coroutines.g.INSTANCE
            kotlin.coroutines.d$b r6 = r6.get(r2)
            if (r6 != r4) goto L82
            r0.f36344a = r4     // Catch: java.lang.Throwable -> L32
            r0.f36345b = r5     // Catch: java.lang.Throwable -> L32
            r6 = 0
            r0.f36346c = r6     // Catch: java.lang.Throwable -> L32
            r0.f36348e = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.c r6 = new kotlinx.coroutines.c     // Catch: java.lang.Throwable -> L32
            e9.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.I()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$a r2 = new kotlinx.coroutines.channels.ProduceKt$a     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.invokeOnClose(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.C()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = f9.C4063a.g()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L75
            g9.f.c(r0)     // Catch: java.lang.Throwable -> L32
        L75:
            if (r4 != r1) goto L78
            return r1
        L78:
            r5.invoke()
            Y8.t r4 = Y8.t.f7040a
            return r4
        L7e:
            r5.invoke()
            throw r4
        L82:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(Wa.p, p9.a, e9.c):java.lang.Object");
    }

    public static final <E> r<E> b(M m10, d dVar, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, InterfaceC5074l<? super Throwable, t> interfaceC5074l, p<? super Wa.p<? super E>, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        o oVar = new o(G.j(m10, dVar), j.b(i10, bufferOverflow, null, 4, null));
        if (interfaceC5074l != null) {
            oVar.J(interfaceC5074l);
        }
        oVar.X0(coroutineStart, oVar, pVar);
        return oVar;
    }

    public static final <E> r<E> c(M m10, d dVar, int i10, p<? super Wa.p<? super E>, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        return b(m10, dVar, i10, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    public static /* synthetic */ r d(M m10, d dVar, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, InterfaceC5074l interfaceC5074l, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i11 & 16) != 0) {
            interfaceC5074l = null;
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return b(m10, dVar, i10, bufferOverflow, coroutineStart, interfaceC5074l2, pVar);
    }

    public static /* synthetic */ r e(M m10, d dVar, int i10, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return c(m10, dVar, i10, pVar);
    }
}
