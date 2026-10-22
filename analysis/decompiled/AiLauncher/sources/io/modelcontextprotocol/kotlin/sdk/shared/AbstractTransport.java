package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R<\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\\\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "block", "onClose", "(Lp9/a;)V", "Lkotlin/Function1;", "", "onError", "(Lp9/l;)V", "Lkotlin/Function2;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "Le9/c;", "", "onMessage", "(Lp9/p;)V", UxipConstants.f30680s, "_onClose", "Lp9/a;", "get_onClose", "()Lp9/a;", "_onError", "Lp9/l;", "get_onError", "()Lp9/l;", "LUa/u;", "_onMessageInitialized", "LUa/u;", "_onMessage", "Lp9/p;", "get_onMessage", "()Lp9/p;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractTransport implements Transport {
    private InterfaceC5063a<Y8.t> _onClose = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Y8.t.f7040a;
        }
    };
    private InterfaceC5074l<? super Throwable, Y8.t> _onError = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.b
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return AbstractTransport._onError$lambda$1((Throwable) obj);
        }
    };
    private final InterfaceC1083u<Y8.t> _onMessageInitialized = C1087w.c(null, 1, null);
    private p9.p<? super JSONRPCMessage, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> _onMessage = new AbstractTransport$_onMessage$1(this, null);

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport$onMessage$1", f = "Transport.kt", l = {93, 94}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport$onMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> $block;
        final /* synthetic */ p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> $old;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.p<? super JSONRPCMessage, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, p9.p<? super JSONRPCMessage, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$old = pVar;
            this.$block = pVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$old, this.$block, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(jSONRPCMessage, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        
            if (r6.invoke(r0, r5) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r0 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.C4849c.b(r6)
                goto L43
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                kotlin.C4849c.b(r6)
                goto L32
            L22:
                kotlin.C4849c.b(r6)
                p9.p<io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage, e9.c<? super Y8.t>, java.lang.Object> r6 = r5.$old
                r5.L$0 = r0
                r5.label = r4
                java.lang.Object r6 = r6.invoke(r0, r5)
                if (r6 != r1) goto L32
                goto L42
            L32:
                p9.p<io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage, e9.c<? super Y8.t>, java.lang.Object> r6 = r5.$block
                java.lang.Object r2 = g9.h.a(r0)
                r5.L$0 = r2
                r5.label = r3
                java.lang.Object r5 = r6.invoke(r0, r5)
                if (r5 != r1) goto L43
            L42:
                return r1
            L43:
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _onError$lambda$1(Throwable it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onClose$lambda$2(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        interfaceC5063a.invoke();
        interfaceC5063a2.invoke();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onError$lambda$3(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        interfaceC5074l.invoke(e10);
        interfaceC5074l2.invoke(e10);
        return Y8.t.f7040a;
    }

    public final InterfaceC5063a<Y8.t> get_onClose() {
        return this._onClose;
    }

    public final InterfaceC5074l<Throwable, Y8.t> get_onError() {
        return this._onError;
    }

    public final p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> get_onMessage() {
        return this._onMessage;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public void onClose(final InterfaceC5063a<Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        final InterfaceC5063a<Y8.t> interfaceC5063a = this._onClose;
        this._onClose = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AbstractTransport.onClose$lambda$2(interfaceC5063a, block);
            }
        };
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public void onError(final InterfaceC5074l<? super Throwable, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        final InterfaceC5074l<? super Throwable, Y8.t> interfaceC5074l = this._onError;
        this._onError = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AbstractTransport.onError$lambda$3(interfaceC5074l, block, (Throwable) obj);
            }
        };
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public void onMessage(p9.p<? super JSONRPCMessage, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        p9.p abstractTransport$onMessage$old$1;
        kotlin.jvm.internal.p.i(block, "block");
        boolean zG = this._onMessageInitialized.g();
        if (zG) {
            abstractTransport$onMessage$old$1 = this._onMessage;
        } else {
            if (zG) {
                throw new NoWhenBranchMatchedException();
            }
            abstractTransport$onMessage$old$1 = new AbstractTransport$onMessage$old$1(null);
        }
        this._onMessage = new AnonymousClass1(abstractTransport$onMessage$old$1, block, null);
        this._onMessageInitialized.complete(Y8.t.f7040a);
    }
}
