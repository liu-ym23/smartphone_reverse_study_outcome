package io.ktor.events;

import Ua.InterfaceC1045a0;
import Y8.d;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.collections.CopyOnWriteHashMap;
import io.ktor.util.internal.LockFreeLinkedListHead;
import io.ktor.util.internal.LockFreeLinkedListNode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/events/Events;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/events/EventDefinition;", "definition", "Lkotlin/Function1;", "LY8/t;", "Lio/ktor/events/EventHandler;", "handler", "LUa/a0;", "subscribe", "(Lio/ktor/events/EventDefinition;Lp9/l;)LUa/a0;", "unsubscribe", "(Lio/ktor/events/EventDefinition;Lp9/l;)V", UxipConstants.f30680s, "raise", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "Lio/ktor/util/internal/LockFreeLinkedListHead;", "handlers", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "HandlerRegistration", "ktor-events"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Events {
    private final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> handlers = new CopyOnWriteHashMap<>();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR)\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/events/Events$HandlerRegistration;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "LUa/a0;", "Lkotlin/Function1;", "LY8/t;", "Lio/ktor/events/EventHandler;", "handler", "<init>", "(Lp9/l;)V", "dispose", "()V", "Lp9/l;", "getHandler", "()Lp9/l;", "ktor-events"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements InterfaceC1045a0 {
        private final InterfaceC5074l<?, t> handler;

        public HandlerRegistration(InterfaceC5074l<?, t> handler) {
            p.i(handler, "handler");
            this.handler = handler;
        }

        @Override // Ua.InterfaceC1045a0
        public void dispose() {
            remove();
        }

        public final InterfaceC5074l<?, t> getHandler() {
            return this.handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockFreeLinkedListHead subscribe$lambda$0(EventDefinition it) {
        p.i(it, "it");
        return new LockFreeLinkedListHead();
    }

    public final <T> void raise(EventDefinition<T> definition, T value) {
        p.i(definition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(definition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Object next = lockFreeLinkedListHead.getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !p.d(nextNode, lockFreeLinkedListHead); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof HandlerRegistration) {
                    try {
                        InterfaceC5074l<?, t> handler = ((HandlerRegistration) nextNode).getHandler();
                        p.g(handler, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise, kotlin.Unit>");
                        ((InterfaceC5074l) z.g(handler, 1)).invoke(value);
                    } catch (Throwable th2) {
                        if (th != null) {
                            d.a(th, th2);
                        } else {
                            th = th2;
                        }
                    }
                }
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final <T> InterfaceC1045a0 subscribe(EventDefinition<T> definition, InterfaceC5074l<? super T, t> handler) {
        p.i(definition, "definition");
        p.i(handler, "handler");
        HandlerRegistration handlerRegistration = new HandlerRegistration(handler);
        this.handlers.computeIfAbsent(definition, new InterfaceC5074l() { // from class: io.ktor.events.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Events.subscribe$lambda$0((EventDefinition) obj);
            }
        }).addLast(handlerRegistration);
        return handlerRegistration;
    }

    public final <T> void unsubscribe(EventDefinition<T> definition, InterfaceC5074l<? super T, t> handler) {
        p.i(definition, "definition");
        p.i(handler, "handler");
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(definition);
        if (lockFreeLinkedListHead != null) {
            Object next = lockFreeLinkedListHead.getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !p.d(nextNode, lockFreeLinkedListHead); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof HandlerRegistration) {
                    HandlerRegistration handlerRegistration = (HandlerRegistration) nextNode;
                    if (p.d(handlerRegistration.getHandler(), handler)) {
                        handlerRegistration.remove();
                    }
                }
            }
        }
    }
}
