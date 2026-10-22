package com.stepos.agentframework.chatcore.agents;

import Ua.C1060i;
import Ua.M;
import Ua.Y;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C0917m;
import kotlin.C0919o;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 62\u00020\u0001:\u00017B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0016R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104¨\u00068"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentBusStreamBridge;", "Ljava/io/Closeable;", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "", "minEmitIntervalMs", "<init>", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;J)V", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lu4/d;)V", "", "emitTerminal", "Lkotlin/Function0;", "onDrained", "l", "(ZLp9/a;)V", "close", "()V", "immediate", "J", "(Z)V", "G", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lu4/d;)Z", "target", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "", "lock", "Ljava/lang/Object;", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "pendingDeltas", "Ljava/lang/StringBuilder;", "lastTemplate", "Lu4/d;", "lastEmitTime", "Lkotlinx/coroutines/g;", "flushJob", "Lkotlinx/coroutines/g;", "lastResponse", "terminalEmitted", "Z", "firstTextFlushed", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusStreamBridge implements Closeable {
    private static final long MIN_EMIT_INTERVAL_MS = 40;
    private final AtomicBoolean finished;
    private boolean firstTextFlushed;
    private kotlinx.coroutines.g flushJob;
    private long lastEmitTime;
    private AgentResponse lastResponse;
    private AgentResponse lastTemplate;
    private final Object lock;
    private final long minEmitIntervalMs;
    private final StringBuilder pendingDeltas;
    private final M scope;
    private final AgentDispatcher.b target;
    private boolean terminalEmitted;

    public AgentBusStreamBridge(AgentDispatcher.b callback, long j10) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.minEmitIntervalMs = j10;
        this.target = callback instanceof FlowCallback ? ((FlowCallback) callback).getCallback() : callback;
        this.lock = new Object();
        this.scope = kotlinx.coroutines.d.a(Y.a());
        this.finished = new AtomicBoolean(false);
        this.pendingDeltas = new StringBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(AgentBusStreamBridge agentBusStreamBridge, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        agentBusStreamBridge.l(z10, interfaceC5063a);
    }

    public final boolean A(AgentResponse response) {
        return response.getStatus() == EReplyStatus.COMPLETED || response.getStatus() == EReplyStatus.ERROR || response.getStatus() == EReplyStatus.CANCELED;
    }

    public final void G() {
        synchronized (this.lock) {
            this.flushJob = null;
            n();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void J(boolean immediate) {
        if (this.pendingDeltas.length() == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.lastEmitTime;
        if (immediate || jElapsedRealtime >= this.minEmitIntervalMs) {
            n();
            return;
        }
        kotlinx.coroutines.g gVar = this.flushJob;
        if (gVar == null || !gVar.b()) {
            this.flushJob = C1060i.d(this.scope, null, null, new AgentBusStreamBridge$scheduleFlushLocked$1(this, jElapsedRealtime, null), 3, null);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m(this, false, null, 1, null);
    }

    public final void g(AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        synchronized (this.lock) {
            if (this.finished.get()) {
                return;
            }
            this.lastResponse = response;
            boolean z10 = true;
            if (A(response)) {
                this.terminalEmitted = true;
                n();
                this.target.l(response);
                return;
            }
            if (response.getType() != AgentMessageType.TEXT) {
                n();
                this.target.l(response);
                return;
            }
            if (response.getContent().length() == 0) {
                this.lastTemplate = response;
                Object extra = response.getExtra();
                C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
                if ((c0917m != null ? kotlin.r.a(c0917m) : null) != null) {
                    n();
                    this.target.l(response);
                }
                return;
            }
            this.pendingDeltas.append(response.getContent());
            this.lastTemplate = response;
            if (this.lastEmitTime != 0) {
                z10 = false;
            }
            J(z10);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void i() {
        AgentResponse agentResponse;
        if (this.terminalEmitted || (agentResponse = this.lastResponse) == null) {
            return;
        }
        this.terminalEmitted = true;
        this.target.l(AgentResponse.f(agentResponse, null, null, null, null, null, "", "", null, EReplyStatus.COMPLETED, null, null, null, null, null, null, null, null, null, null, null, null, null, 4193943, null));
    }

    public final void l(boolean emitTerminal, InterfaceC5063a<Y8.t> onDrained) {
        if (!this.finished.compareAndSet(false, true)) {
            if (onDrained != null) {
                onDrained.invoke();
                return;
            }
            return;
        }
        synchronized (this.lock) {
            try {
                n();
                if (emitTerminal) {
                    i();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        if (onDrained != null) {
            onDrained.invoke();
        }
    }

    public final void n() {
        AgentResponse agentResponse;
        kotlinx.coroutines.g gVar = this.flushJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.flushJob = null;
        if (this.pendingDeltas.length() == 0 || (agentResponse = this.lastTemplate) == null) {
            return;
        }
        String string = this.pendingDeltas.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        La.z.q(this.pendingDeltas);
        this.lastEmitTime = SystemClock.elapsedRealtime();
        if (!this.firstTextFlushed && string.length() > 0) {
            this.firstTextFlushed = true;
            C0919o.h();
        }
        this.target.l(AgentResponse.f(agentResponse, null, null, null, null, null, string, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194271, null));
    }

    public /* synthetic */ AgentBusStreamBridge(AgentDispatcher.b bVar, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this(bVar, (i10 & 2) != 0 ? MIN_EMIT_INTERVAL_MS : j10);
    }
}
