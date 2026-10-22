package kotlinx.coroutines.flow;

import Wa.r;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a6\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "LWa/r;", "channel", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LXa/c;LWa/r;Le9/c;)Ljava/lang/Object;", "", "consume", "c", "(LXa/c;LWa/r;ZLe9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object b(c<? super T> cVar, r<? extends T> rVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objC = c(cVar, rVar, true, interfaceC4014c);
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
    
        if (r11 == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:13:0x0037, B:24:0x0063, B:28:0x007a, B:30:0x0082, B:20:0x0055, B:23:0x005f), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [Xa.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009a -> B:14:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(Xa.c<? super T> r8, Wa.r<? extends T> r9, boolean r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.f36399g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36399g = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f36398f
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36399g
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L59
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            boolean r10 = r0.f36397e
            java.lang.Object r8 = r0.f36395c
            Wa.i r8 = (Wa.i) r8
            java.lang.Object r9 = r0.f36394b
            Wa.r r9 = (Wa.r) r9
            java.lang.Object r2 = r0.f36393a
            Xa.c r2 = (Xa.c) r2
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L3d
        L3a:
            r11 = r8
            r8 = r2
            goto L63
        L3d:
            r8 = move-exception
            goto La5
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            boolean r10 = r0.f36397e
            java.lang.Object r8 = r0.f36395c
            Wa.i r8 = (Wa.i) r8
            java.lang.Object r9 = r0.f36394b
            Wa.r r9 = (Wa.r) r9
            java.lang.Object r2 = r0.f36393a
            Xa.c r2 = (Xa.c) r2
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L3d
            goto L7a
        L59:
            kotlin.C4849c.b(r11)
            Xa.d.w(r8)
            Wa.i r11 = r9.iterator()     // Catch: java.lang.Throwable -> L3d
        L63:
            r0.f36393a = r8     // Catch: java.lang.Throwable -> L3d
            r0.f36394b = r9     // Catch: java.lang.Throwable -> L3d
            r0.f36395c = r11     // Catch: java.lang.Throwable -> L3d
            r0.f36396d = r5     // Catch: java.lang.Throwable -> L3d
            r0.f36397e = r10     // Catch: java.lang.Throwable -> L3d
            r0.f36399g = r4     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r2 = r11.a(r0)     // Catch: java.lang.Throwable -> L3d
            if (r2 != r1) goto L76
            goto L9c
        L76:
            r7 = r2
            r2 = r8
            r8 = r11
            r11 = r7
        L7a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L9d
            java.lang.Object r11 = r8.next()     // Catch: java.lang.Throwable -> L3d
            r0.f36393a = r2     // Catch: java.lang.Throwable -> L3d
            r0.f36394b = r9     // Catch: java.lang.Throwable -> L3d
            r0.f36395c = r8     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r6 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3d
            r0.f36396d = r6     // Catch: java.lang.Throwable -> L3d
            r0.f36397e = r10     // Catch: java.lang.Throwable -> L3d
            r0.f36399g = r3     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r11 = r2.emit(r11, r0)     // Catch: java.lang.Throwable -> L3d
            if (r11 != r1) goto L3a
        L9c:
            return r1
        L9d:
            if (r10 == 0) goto La2
            Wa.l.a(r9, r5)
        La2:
            Y8.t r8 = Y8.t.f7040a
            return r8
        La5:
            throw r8     // Catch: java.lang.Throwable -> La6
        La6:
            r11 = move-exception
            if (r10 == 0) goto Lac
            Wa.l.a(r9, r8)
        Lac:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.c(Xa.c, Wa.r, boolean, e9.c):java.lang.Object");
    }
}
