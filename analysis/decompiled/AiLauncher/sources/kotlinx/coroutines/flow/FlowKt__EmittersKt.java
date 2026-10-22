package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Xa.w;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.q;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001aU\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000120\u0010\b\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\\\u0010\u000e\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000320\u0010\b\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "Lkotlin/Function3;", "LXa/c;", "", "Le9/c;", "LY8/t;", "", "action", Const.INTENT_KEY_UMID, "(LXa/b;Lp9/q;)LXa/b;", Const.INTENT_KEY_PKGNAME, "(LXa/c;)V", "cause", "c", "(LXa/c;Lp9/q;Ljava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(c<?> cVar) {
        if (cVar instanceof w) {
            throw ((w) cVar).e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(Xa.c<? super T> r4, p9.q<? super Xa.c<? super T>, ? super java.lang.Throwable, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r5, java.lang.Throwable r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.f36447e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36447e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f36446d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36447e
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r4 = r0.f36445c
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r4 = r0.f36444b
            p9.q r4 = (p9.q) r4
            java.lang.Object r4 = r0.f36443a
            Xa.c r4 = (Xa.c) r4
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L36
            goto L5a
        L36:
            r4 = move-exception
            goto L5d
        L38:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L40:
            kotlin.C4849c.b(r7)
            java.lang.Object r7 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L36
            r0.f36443a = r7     // Catch: java.lang.Throwable -> L36
            java.lang.Object r7 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L36
            r0.f36444b = r7     // Catch: java.lang.Throwable -> L36
            r0.f36445c = r6     // Catch: java.lang.Throwable -> L36
            r0.f36447e = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L36
            if (r4 != r1) goto L5a
            return r1
        L5a:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L5d:
            if (r6 == 0) goto L64
            if (r6 == r4) goto L64
            Y8.d.a(r4, r6)
        L64:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.c(Xa.c, p9.q, java.lang.Throwable, e9.c):java.lang.Object");
    }

    public static final <T> b<T> d(b<? extends T> bVar, q<? super c<? super T>, ? super Throwable, ? super InterfaceC4014c<? super t>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(bVar, qVar);
    }
}
