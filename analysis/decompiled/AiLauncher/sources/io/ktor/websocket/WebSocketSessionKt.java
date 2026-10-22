package io.ktor.websocket;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\u00028\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\fH\u0086@¢\u0006\u0004\b\n\u0010\r\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0087@¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/WebSocketExtension;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "extension", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/WebSocketExtensionFactory;)Lio/ktor/websocket/WebSocketExtension;", "extensionOrNull", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "send", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "(Lio/ktor/websocket/WebSocketSession;[BLe9/c;)Ljava/lang/Object;", "Lio/ktor/websocket/CloseReason;", "reason", "close", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/CloseReason;Le9/c;)Ljava/lang/Object;", "", "cause", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "closeExceptionally", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketSessionKt {

    @InterfaceC4112d(c = "io.ktor.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", l = {F.GESTURE_HEIGHT_DP, 151}, m = "close")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.WebSocketSessionKt$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketSessionKt.close((WebSocketSession) null, (CloseReason) null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        if (r5.flush(r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object close(io.ktor.websocket.WebSocketSession r5, io.ktor.websocket.CloseReason r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.websocket.WebSocketSessionKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = (io.ktor.websocket.WebSocketSessionKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = new io.ktor.websocket.WebSocketSessionKt$close$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.CloseReason r5 = (io.ktor.websocket.CloseReason) r5
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L77
            goto L77
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.ktor.websocket.CloseReason r6 = (io.ktor.websocket.CloseReason) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L77
            goto L62
        L49:
            kotlin.C4849c.b(r7)
            io.ktor.websocket.Frame$Close r7 = new io.ktor.websocket.Frame$Close     // Catch: java.lang.Throwable -> L77
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L77
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L77
            r0.label = r4     // Catch: java.lang.Throwable -> L77
            java.lang.Object r7 = r5.send(r7, r0)     // Catch: java.lang.Throwable -> L77
            if (r7 != r1) goto L62
            goto L76
        L62:
            java.lang.Object r7 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L77
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L77
            r0.label = r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object r5 = r5.flush(r0)     // Catch: java.lang.Throwable -> L77
            if (r5 != r1) goto L77
        L76:
            return r1
        L77:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketSessionKt.close(io.ktor.websocket.WebSocketSession, io.ktor.websocket.CloseReason, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object close$default(WebSocketSession webSocketSession, CloseReason closeReason, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        return close(webSocketSession, closeReason, (InterfaceC4014c<? super t>) interfaceC4014c);
    }

    public static final Object closeExceptionally(WebSocketSession webSocketSession, Throwable th, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objClose = close(webSocketSession, th instanceof CancellationException ? new CloseReason(CloseReason.Codes.NORMAL, "") : new CloseReason(CloseReason.Codes.INTERNAL_ERROR, th.toString()), interfaceC4014c);
        return objClose == C4063a.g() ? objClose : t.f7040a;
    }

    public static final <T extends WebSocketExtension<?>> T extension(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> extension) {
        p.i(webSocketSession, "<this>");
        p.i(extension, "extension");
        T t10 = (T) extensionOrNull(webSocketSession, extension);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(("Extension " + extension + " not found.").toString());
    }

    public static final <T extends WebSocketExtension<?>> T extensionOrNull(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> extension) {
        Object next;
        p.i(webSocketSession, "<this>");
        p.i(extension, "extension");
        Iterator<T> it = webSocketSession.getExtensions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((WebSocketExtension) next).getFactory().getKey() == extension.getKey()) {
                break;
            }
        }
        if (next instanceof WebSocketExtension) {
            return (T) next;
        }
        return null;
    }

    public static final Object send(WebSocketSession webSocketSession, String str, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSend = webSocketSession.send(new Frame.Text(str), interfaceC4014c);
        return objSend == C4063a.g() ? objSend : t.f7040a;
    }

    public static final Object send(WebSocketSession webSocketSession, byte[] bArr, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSend = webSocketSession.send(new Frame.Binary(true, bArr), interfaceC4014c);
        return objSend == C4063a.g() ? objSend : t.f7040a;
    }

    public static final Object close(WebSocketSession webSocketSession, Throwable th, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        if (th == null) {
            Object objClose$default = close$default(webSocketSession, null, interfaceC4014c, 1, null);
            return objClose$default == C4063a.g() ? objClose$default : t.f7040a;
        }
        Object objCloseExceptionally = closeExceptionally(webSocketSession, th, interfaceC4014c);
        return objCloseExceptionally == C4063a.g() ? objCloseExceptionally : t.f7040a;
    }
}
