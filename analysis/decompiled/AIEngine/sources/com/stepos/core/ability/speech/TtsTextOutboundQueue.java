package com.stepos.core.ability.speech;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsTextOutboundQueue {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "TtsTextOutboundQueue";
    private final zb.a<lb.n> onInputClosed;
    private final mb.k<Item> queue;
    private final zb.l<String, lb.n> sendWire;
    private volatile String sessionId;
    private boolean textDoneSent;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Item {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Delta extends Item {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Delta(String text) {
                super(null);
                kotlin.jvm.internal.g.f(text, "text");
                this.text = text;
            }

            public static /* synthetic */ Delta copy$default(Delta delta, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = delta.text;
                }
                return delta.copy(str);
            }

            public final String component1() {
                return this.text;
            }

            public final Delta copy(String text) {
                kotlin.jvm.internal.g.f(text, "text");
                return new Delta(text);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Delta) && kotlin.jvm.internal.g.b(this.text, ((Delta) obj).text);
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return a0.a.k("Delta(text=", this.text, ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class TextDone extends Item {
            public static final TextDone INSTANCE = new TextDone();

            private TextDone() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof TextDone);
            }

            public int hashCode() {
                return -61589401;
            }

            public String toString() {
                return "TextDone";
            }
        }

        public /* synthetic */ Item(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Item() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtsTextOutboundQueue(zb.l<? super String, lb.n> sendWire, zb.a<lb.n> onInputClosed) {
        kotlin.jvm.internal.g.f(sendWire, "sendWire");
        kotlin.jvm.internal.g.f(onInputClosed, "onInputClosed");
        this.sendWire = sendWire;
        this.onInputClosed = onInputClosed;
        this.queue = new mb.k<>();
        this.sessionId = "";
    }

    private final void pumpLocked() {
        while (!this.queue.isEmpty()) {
            mb.k<Item> kVar = this.queue;
            if (kVar.isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            Item item = (Item) kVar.f10557b[kVar.f10556a];
            if (!(item instanceof Item.Delta)) {
                if (!kotlin.jvm.internal.g.b(item, Item.TextDone.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.queue.removeFirst();
                this.textDoneSent = true;
                this.sendWire.invoke(TtsWsModels.INSTANCE.buildTextDone(requireSessionId()));
                this.onInputClosed.invoke();
                return;
            }
            this.queue.removeFirst();
            this.sendWire.invoke(TtsWsModels.INSTANCE.buildTextDelta(((Item.Delta) item).getText(), requireSessionId()));
        }
    }

    private final String requireSessionId() {
        String str = this.sessionId;
        if (gc.q.t0(str)) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("TtsTextOutboundQueue: session_id not bound");
    }

    public final void bindSession(String sessionId) {
        kotlin.jvm.internal.g.f(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    public final void enqueueDelta(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        synchronized (this) {
            if (!this.textDoneSent) {
                this.queue.addLast(new Item.Delta(text));
                pumpLocked();
                lb.n nVar = lb.n.f10413a;
            } else {
                AIEngineLogger.w(LogModule.ABILITY, TAG, "[TTS-Stream] delta dropped (input already closed by text.done), len=" + text.length());
            }
        }
    }

    public final boolean hasPendingWork() {
        boolean z;
        synchronized (this) {
            z = !this.queue.isEmpty();
        }
        return z;
    }

    public final void reset() {
        synchronized (this) {
            this.queue.clear();
            this.textDoneSent = false;
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void scheduleTextDone() {
        synchronized (this) {
            if (this.textDoneSent) {
                return;
            }
            this.queue.addLast(Item.TextDone.INSTANCE);
            pumpLocked();
            lb.n nVar = lb.n.f10413a;
        }
    }
}
