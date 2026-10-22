package io.ktor.server.sse;

import Ua.C1060i;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;
import p9.p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086H¢\u0006\u0004\b\u0006\u0010\u0007\u001a\\\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tH\u0086H¢\u0006\u0004\b\u0006\u0010\u000e\u001a(\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0006\u0010\u000f\u001a'\u0010\u0014\u001a\u00020\u0005*\u00020\u00102\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0004\b\u0014\u0010\u0015\" \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/sse/ServerSSESessionWithSerialization;", "Lio/ktor/sse/TypedServerSentEvent;", "event", "LY8/t;", "send", "(Lio/ktor/server/sse/ServerSSESessionWithSerialization;Lio/ktor/sse/TypedServerSentEvent;Le9/c;)Ljava/lang/Object;", "data", "", "id", "", "retry", "comments", "(Lio/ktor/server/sse/ServerSSESessionWithSerialization;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/server/sse/ServerSSESessionWithSerialization;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/sse/ServerSSESession;", "Lkotlin/Function1;", "Lio/ktor/server/sse/Heartbeat;", "heartbeatConfig", "heartbeat", "(Lio/ktor/server/sse/ServerSSESession;Lp9/l;)V", "Lio/ktor/util/AttributeKey;", "Lkotlinx/coroutines/g;", "heartbeatJobKey", "Lio/ktor/util/AttributeKey;", "getHeartbeatJobKey", "()Lio/ktor/util/AttributeKey;", "ktor-server-sse"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerSSESessionKt {
    private static final AttributeKey<g> heartbeatJobKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.sse.ServerSSESessionKt$heartbeat$2", f = "ServerSSESession.kt", l = {170, 171}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.sse.ServerSSESessionKt$heartbeat$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Heartbeat $heartbeat;
        final /* synthetic */ ServerSSESession $this_heartbeat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ServerSSESession serverSSESession, Heartbeat heartbeat, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_heartbeat = serverSSESession;
            this.$heartbeat = heartbeat;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$this_heartbeat, this.$heartbeat, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003b -> B:11:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1b
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L17:
                kotlin.C4849c.b(r7)
                goto L2f
            L1b:
                kotlin.C4849c.b(r7)
            L1e:
                io.ktor.server.sse.ServerSSESession r7 = r6.$this_heartbeat
                io.ktor.server.sse.Heartbeat r1 = r6.$heartbeat
                io.ktor.sse.ServerSentEvent r1 = r1.getEvent()
                r6.label = r3
                java.lang.Object r7 = r7.send(r1, r6)
                if (r7 != r0) goto L2f
                goto L3d
            L2f:
                io.ktor.server.sse.Heartbeat r7 = r6.$heartbeat
                long r4 = r7.getPeriod()
                r6.label = r2
                java.lang.Object r7 = Ua.U.b(r4, r6)
                if (r7 != r0) goto L1e
            L3d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.sse.ServerSSESessionKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(g.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(g.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        heartbeatJobKey = new AttributeKey<>("HeartbeatJobAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public static final AttributeKey<g> getHeartbeatJobKey() {
        return heartbeatJobKey;
    }

    public static final void heartbeat(ServerSSESession serverSSESession, InterfaceC5074l<? super Heartbeat, t> heartbeatConfig) {
        kotlin.jvm.internal.p.i(serverSSESession, "<this>");
        kotlin.jvm.internal.p.i(heartbeatConfig, "heartbeatConfig");
        Heartbeat heartbeat = new Heartbeat();
        heartbeatConfig.invoke(heartbeat);
        InterfaceC1089x interfaceC1089xA = C1086v0.a((g) serverSSESession.getCall().getCoroutineContext().get(g.INSTANCE));
        C1060i.d(serverSSESession, interfaceC1089xA.plus(new CoroutineName("sse-heartbeat")), null, new AnonymousClass2(serverSSESession, heartbeat, null), 2, null);
        serverSSESession.getCall().getAttributes().put(heartbeatJobKey, interfaceC1089xA);
    }

    public static /* synthetic */ void heartbeat$default(ServerSSESession serverSSESession, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.sse.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ServerSSESessionKt.heartbeat$lambda$1((Heartbeat) obj2);
                }
            };
        }
        heartbeat(serverSSESession, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t heartbeat$lambda$1(Heartbeat heartbeat) {
        kotlin.jvm.internal.p.i(heartbeat, "<this>");
        return t.f7040a;
    }

    public static final /* synthetic */ <T> Object send(ServerSSESessionWithSerialization serverSSESessionWithSerialization, TypedServerSentEvent<T> typedServerSentEvent, InterfaceC4014c<? super t> interfaceC4014c) {
        T data = typedServerSentEvent.getData();
        String strInvoke = null;
        if (data != null) {
            p<TypeInfo, Object, String> serializer = serverSSESessionWithSerialization.getSerializer();
            kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
            } catch (Throwable unused) {
            }
            strInvoke = serializer.invoke(new TypeInfo(interfaceC5745dB, null), data);
        }
        ServerSentEvent serverSentEvent = new ServerSentEvent(strInvoke, typedServerSentEvent.getEvent(), typedServerSentEvent.getId(), typedServerSentEvent.getRetry(), typedServerSentEvent.getComments());
        n.c(0);
        serverSSESessionWithSerialization.send(serverSentEvent, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static /* synthetic */ Object send$default(ServerSSESessionWithSerialization serverSSESessionWithSerialization, Object obj, String str, String str2, Long l10, String str3, InterfaceC4014c interfaceC4014c, int i10, Object obj2) {
        String strInvoke = null;
        TypedServerSentEvent typedServerSentEvent = new TypedServerSentEvent((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : str3);
        Object data = typedServerSentEvent.getData();
        if (data != null) {
            p<TypeInfo, Object, String> serializer = serverSSESessionWithSerialization.getSerializer();
            kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
            } catch (Throwable unused) {
            }
            strInvoke = serializer.invoke(new TypeInfo(interfaceC5745dB, null), data);
        }
        ServerSentEvent serverSentEvent = new ServerSentEvent(strInvoke, typedServerSentEvent.getEvent(), typedServerSentEvent.getId(), typedServerSentEvent.getRetry(), typedServerSentEvent.getComments());
        n.c(0);
        serverSSESessionWithSerialization.send(serverSentEvent, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static final /* synthetic */ <T> Object send(ServerSSESessionWithSerialization serverSSESessionWithSerialization, T t10, String str, String str2, Long l10, String str3, InterfaceC4014c<? super t> interfaceC4014c) {
        TypedServerSentEvent typedServerSentEvent = new TypedServerSentEvent(t10, str, str2, l10, str3);
        Object data = typedServerSentEvent.getData();
        String strInvoke = null;
        if (data != null) {
            p<TypeInfo, Object, String> serializer = serverSSESessionWithSerialization.getSerializer();
            kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
            } catch (Throwable unused) {
            }
            strInvoke = serializer.invoke(new TypeInfo(interfaceC5745dB, null), data);
        }
        ServerSentEvent serverSentEvent = new ServerSentEvent(strInvoke, typedServerSentEvent.getEvent(), typedServerSentEvent.getId(), typedServerSentEvent.getRetry(), typedServerSentEvent.getComments());
        n.c(0);
        serverSSESessionWithSerialization.send(serverSentEvent, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static final /* synthetic */ <T> Object send(ServerSSESessionWithSerialization serverSSESessionWithSerialization, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        p<TypeInfo, Object, String> serializer = serverSSESessionWithSerialization.getSerializer();
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        ServerSentEvent serverSentEvent = new ServerSentEvent(serializer.invoke(new TypeInfo(interfaceC5745dB, null), t10), null, null, null, null, 30, null);
        n.c(0);
        serverSSESessionWithSerialization.send(serverSentEvent, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }
}
