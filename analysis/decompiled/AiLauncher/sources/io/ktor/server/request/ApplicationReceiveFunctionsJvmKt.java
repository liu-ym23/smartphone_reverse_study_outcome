package io.ktor.server.request;

import La.C;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.plugins.CannotTransformContentToTypeException;
import io.ktor.util.reflect.TypeInfo;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086H¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\t\u001a\u00020\u00048@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "Ljava/io/InputStream;", "receiveStream", "(Lio/ktor/server/application/ApplicationCall;Le9/c;)Ljava/lang/Object;", "", "getDEFAULT_FORM_FIELD_LIMIT", "()J", "getDEFAULT_FORM_FIELD_LIMIT$annotations", "()V", "DEFAULT_FORM_FIELD_LIMIT", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationReceiveFunctionsJvmKt {

    @InterfaceC4112d(c = "io.ktor.server.request.ApplicationReceiveFunctionsJvmKt", f = "ApplicationReceiveFunctionsJvm.kt", l = {25}, m = "receiveStream")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: io.ktor.server.request.ApplicationReceiveFunctionsJvmKt$receiveStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationReceiveFunctionsJvmKt.receiveStream(null, this);
        }
    }

    public static final long getDEFAULT_FORM_FIELD_LIMIT() {
        Long lY;
        String property = System.getProperty("io.ktor.server.request.formFieldLimit");
        if (property == null || (lY = C.y(property)) == null) {
            return 52428800L;
        }
        return lY.longValue();
    }

    public static /* synthetic */ void getDEFAULT_FORM_FIELD_LIMIT$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object receiveStream(io.ktor.server.application.ApplicationCall r7, e9.InterfaceC4014c<? super java.io.InputStream> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.server.request.ApplicationReceiveFunctionsJvmKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.request.ApplicationReceiveFunctionsJvmKt$receiveStream$1 r0 = (io.ktor.server.request.ApplicationReceiveFunctionsJvmKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.request.ApplicationReceiveFunctionsJvmKt$receiveStream$1 r0 = new io.ktor.server.request.ApplicationReceiveFunctionsJvmKt$receiveStream$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.Class<java.io.InputStream> r5 = java.io.InputStream.class
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.C4849c.b(r8)
            goto L4f
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.C4849c.b(r8)
            w9.d r8 = kotlin.jvm.internal.t.b(r5)
            w9.n r2 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
            r2 = r3
        L41:
            io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo
            r6.<init>(r8, r2)
            r0.label = r4
            java.lang.Object r8 = r7.receiveNullable(r6, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            if (r8 == 0) goto L52
            return r8
        L52:
            w9.d r7 = kotlin.jvm.internal.t.b(r5)
            w9.n r3 = kotlin.jvm.internal.t.m(r5)     // Catch: java.lang.Throwable -> L5a
        L5a:
            io.ktor.util.reflect.TypeInfo r8 = new io.ktor.util.reflect.TypeInfo
            r8.<init>(r7, r3)
            w9.n r7 = r8.getKotlinType()
            kotlin.jvm.internal.p.f(r7)
            io.ktor.server.plugins.CannotTransformContentToTypeException r8 = new io.ktor.server.plugins.CannotTransformContentToTypeException
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.request.ApplicationReceiveFunctionsJvmKt.receiveStream(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    private static final Object receiveStream$$forInline(ApplicationCall applicationCall, InterfaceC4014c<? super InputStream> interfaceC4014c) throws CannotTransformContentToTypeException {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(InputStream.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = t.m(InputStream.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
        n.c(0);
        Object objReceiveNullable = applicationCall.receiveNullable(typeInfo, interfaceC4014c);
        n.c(1);
        if (objReceiveNullable != null) {
            return objReceiveNullable;
        }
        InterfaceC5745d interfaceC5745dB2 = t.b(InputStream.class);
        try {
            interfaceC5755nM2 = t.m(InputStream.class);
        } catch (Throwable unused2) {
        }
        InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, interfaceC5755nM2).getKotlinType();
        p.f(kotlinType);
        throw new CannotTransformContentToTypeException(kotlinType);
    }
}
