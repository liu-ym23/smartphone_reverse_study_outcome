package com.obric.oui.push;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PushQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/push/PushQueue;", "", "()V", "showingPush", "Lcom/obric/oui/push/OPush;", "getShowingPush", "setShowingPush", "", "newPush", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushQueue {
    public static final Companion Companion = null;
    private static final Lazy<PushQueue> instance$delegate = null;
    private OPush showingPush;

    /* JADX INFO: compiled from: PushQueue.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/push/PushQueue$Companion;", "", "()V", "instance", "Lcom/obric/oui/push/PushQueue;", "getInstance", "()Lcom/obric/oui/push/PushQueue;", "instance$delegate", "Lkotlin/Lazy;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final PushQueue getInstance() {
            return (PushQueue) PushQueue.access$getInstance$delegate$cp().getValue();
        }
    }

    public /* synthetic */ PushQueue(DefaultConstructorMarker r1) {
        this();
    }

    private PushQueue() {
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PushQueue$Companion$instance$2.INSTANCE);
    }

    public final OPush getShowingPush() {
        return this.showingPush;
    }

    public final void setShowingPush(OPush r1) {
        this.showingPush = r1;
    }
}
