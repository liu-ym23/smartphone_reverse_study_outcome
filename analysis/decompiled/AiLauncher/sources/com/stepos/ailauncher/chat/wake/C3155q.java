package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/q;", "", "<init>", "()V", "", DidiCardProvider.KEY_TRACE_ID, "", "deferExpansion", "LY8/t;", "c", "(Ljava/lang/String;Z)V", Const.INTENT_KEY_PKGNAME, "()Z", "e", "(Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/wake/q$a;", "current", "Lcom/stepos/ailauncher/chat/wake/q$a;", "lastFinishedTraceId", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3155q {
    private Round current;
    private String lastFinishedTraceId;

    public final void a(String traceId) {
        this.lastFinishedTraceId = traceId;
        this.current = null;
    }

    public final boolean b() {
        Round round = this.current;
        if (round == null) {
            return true;
        }
        round.e(true);
        if (!round.getDeferExpansion()) {
            a(round.getTraceId());
            return true;
        }
        if (!round.getResolved()) {
            return false;
        }
        this.current = null;
        return false;
    }

    public final void c(String traceId, boolean deferExpansion) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        if (traceId.length() == 0) {
            this.current = null;
            return;
        }
        this.current = new Round(traceId, deferExpansion, false, false, 12, null);
    }

    public final void d() {
        this.current = null;
        this.lastFinishedTraceId = null;
    }

    public final boolean e(String traceId) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        if (traceId.length() == 0 || kotlin.jvm.internal.p.d(this.lastFinishedTraceId, traceId)) {
            return false;
        }
        Round round = this.current;
        if (round != null && !kotlin.jvm.internal.p.d(round.getTraceId(), traceId)) {
            return false;
        }
        this.lastFinishedTraceId = traceId;
        if (round == null) {
            return true;
        }
        round.f(true);
        if (round.getMessageSent()) {
            this.current = null;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/q$a;", "", "", DidiCardProvider.KEY_TRACE_ID, "", "deferExpansion", "messageSent", "resolved", "<init>", "(Ljava/lang/String;ZZZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "e", "(Z)V", "c", "f", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.q$a, reason: from toString */
    public static final /* data */ class Round {
        private final boolean deferExpansion;
        private boolean messageSent;
        private boolean resolved;
        private final String traceId;

        public Round(String traceId, boolean z10, boolean z11, boolean z12) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.traceId = traceId;
            this.deferExpansion = z10;
            this.messageSent = z11;
            this.resolved = z12;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDeferExpansion() {
            return this.deferExpansion;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getMessageSent() {
            return this.messageSent;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getResolved() {
            return this.resolved;
        }

        /* renamed from: d, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public final void e(boolean z10) {
            this.messageSent = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Round)) {
                return false;
            }
            Round round = (Round) other;
            return kotlin.jvm.internal.p.d(this.traceId, round.traceId) && this.deferExpansion == round.deferExpansion && this.messageSent == round.messageSent && this.resolved == round.resolved;
        }

        public final void f(boolean z10) {
            this.resolved = z10;
        }

        public int hashCode() {
            return (((((this.traceId.hashCode() * 31) + Boolean.hashCode(this.deferExpansion)) * 31) + Boolean.hashCode(this.messageSent)) * 31) + Boolean.hashCode(this.resolved);
        }

        public String toString() {
            return "Round(traceId=" + this.traceId + ", deferExpansion=" + this.deferExpansion + ", messageSent=" + this.messageSent + ", resolved=" + this.resolved + ")";
        }

        public /* synthetic */ Round(String str, boolean z10, boolean z11, boolean z12, int i10, kotlin.jvm.internal.i iVar) {
            this(str, z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12);
        }
    }
}
