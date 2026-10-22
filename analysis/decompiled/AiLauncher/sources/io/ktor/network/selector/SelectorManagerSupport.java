package io.ktor.network.selector;

import M5.c;
import Ua.InterfaceC1066l;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001:\u00018B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0004¢\u0006\u0004\b \u0010!J!\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0004¢\u0006\u0004\b \u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R,\u00107\u001a\u0004\u0018\u00010\u0004*\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lio/ktor/network/selector/SelectorManagerSupport;", "Lio/ktor/network/selector/SelectorManager;", "<init>", "()V", "Lio/ktor/network/selector/Selectable;", "selectable", "LY8/t;", "publishInterest", "(Lio/ktor/network/selector/Selectable;)V", "Lio/ktor/network/selector/SelectInterest;", "interest", c.ACTION_SELECT, "(Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectInterest;Le9/c;)Ljava/lang/Object;", "", "Ljava/nio/channels/SelectionKey;", "selectedKeys", "", "keys", "handleSelectedKeys", "(Ljava/util/Set;Ljava/util/Set;)V", "key", "handleSelectedKey", "(Ljava/nio/channels/SelectionKey;)V", "Ljava/nio/channels/Selector;", "selector", "applyInterest", "(Ljava/nio/channels/Selector;Lio/ktor/network/selector/Selectable;)V", "attachment", "notifyClosedImpl", "(Ljava/nio/channels/Selector;Ljava/nio/channels/SelectionKey;Lio/ktor/network/selector/Selectable;)V", "", "cause", "cancelAllSuspensions", "(Lio/ktor/network/selector/Selectable;Ljava/lang/Throwable;)V", "(Ljava/nio/channels/Selector;Ljava/lang/Throwable;)V", "Ljava/nio/channels/spi/SelectorProvider;", Const.JSON_KEY_PROVIDER, "Ljava/nio/channels/spi/SelectorProvider;", "getProvider", "()Ljava/nio/channels/spi/SelectorProvider;", "", AuthSessionDto.STATUS_PENDING, "I", "getPending", "()I", "setPending", "(I)V", "cancelled", "getCancelled", "setCancelled", "newValue", "getSubject", "(Ljava/nio/channels/SelectionKey;)Lio/ktor/network/selector/Selectable;", "setSubject", "(Ljava/nio/channels/SelectionKey;Lio/ktor/network/selector/Selectable;)V", "subject", "ClosedSelectorCancellationException", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SelectorManagerSupport implements SelectorManager {
    private int cancelled;
    private int pending;
    private final SelectorProvider provider;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/network/selector/SelectorManagerSupport$ClosedSelectorCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "<init>", "()V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ClosedSelectorCancellationException extends CancellationException {
        public ClosedSelectorCancellationException() {
            super("Closed selector");
        }
    }

    public SelectorManagerSupport() {
        SelectorProvider selectorProviderProvider = SelectorProvider.provider();
        p.h(selectorProviderProvider, "provider(...)");
        this.provider = selectorProviderProvider;
    }

    private final Selectable getSubject(SelectionKey selectionKey) {
        Object objAttachment = selectionKey.attachment();
        if (objAttachment instanceof Selectable) {
            return (Selectable) objAttachment;
        }
        return null;
    }

    private final void setSubject(SelectionKey selectionKey, Selectable selectable) {
        selectionKey.attach(selectable);
    }

    public final void applyInterest(Selector selector, Selectable selectable) {
        p.i(selector, "selector");
        p.i(selectable, "selectable");
        try {
            SelectableChannel channel = selectable.getChannel();
            SelectionKey selectionKeyKeyFor = channel.keyFor(selector);
            int i10 = selectable.get_interestedOps();
            if (selectionKeyKeyFor == null) {
                if (i10 != 0) {
                    channel.register(selector, i10, selectable);
                }
            } else if (selectionKeyKeyFor.interestOps() != i10) {
                selectionKeyKeyFor.interestOps(i10);
            }
            if (i10 != 0) {
                this.pending++;
            }
        } catch (Throwable th) {
            SelectionKey selectionKeyKeyFor2 = selectable.getChannel().keyFor(selector);
            if (selectionKeyKeyFor2 != null) {
                selectionKeyKeyFor2.cancel();
            }
            cancelAllSuspensions(selectable, th);
        }
    }

    public final void cancelAllSuspensions(Selectable attachment, Throwable cause) {
        p.i(attachment, "attachment");
        p.i(cause, "cause");
        InterestSuspensionsMap suspensions = attachment.getSuspensions();
        for (SelectInterest selectInterest : SelectInterest.INSTANCE.getAllInterests()) {
            InterfaceC1066l<t> interfaceC1066lRemoveSuspension = suspensions.removeSuspension(selectInterest);
            if (interfaceC1066lRemoveSuspension != null) {
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066lRemoveSuspension.resumeWith(Result.b(C4849c.a(cause)));
            }
        }
    }

    public final int getCancelled() {
        return this.cancelled;
    }

    @Override // io.ktor.network.selector.SelectorManager, Ua.M
    public abstract /* synthetic */ d getCoroutineContext();

    public final int getPending() {
        return this.pending;
    }

    @Override // io.ktor.network.selector.SelectorManager
    public final SelectorProvider getProvider() {
        return this.provider;
    }

    public final void handleSelectedKey(SelectionKey key) {
        InterfaceC1066l<t> interfaceC1066lRemoveSuspension;
        p.i(key, "key");
        try {
            int i10 = key.readyOps();
            int iInterestOps = key.interestOps();
            Selectable subject = getSubject(key);
            if (subject == null) {
                key.cancel();
                this.cancelled++;
                return;
            }
            InterestSuspensionsMap suspensions = subject.getSuspensions();
            int[] flags = SelectInterest.INSTANCE.getFlags();
            int length = flags.length;
            for (int i11 = 0; i11 < length; i11++) {
                if ((flags[i11] & i10) != 0 && (interfaceC1066lRemoveSuspension = suspensions.removeSuspension(i11)) != null) {
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066lRemoveSuspension.resumeWith(Result.b(t.f7040a));
                }
            }
            int i12 = (~i10) & iInterestOps;
            if (i12 != iInterestOps) {
                key.interestOps(i12);
            }
            if (i12 != 0) {
                this.pending++;
            }
        } catch (Throwable th) {
            key.cancel();
            this.cancelled++;
            Selectable subject2 = getSubject(key);
            if (subject2 != null) {
                cancelAllSuspensions(subject2, th);
                setSubject(key, null);
            }
        }
    }

    public final void handleSelectedKeys(Set<SelectionKey> selectedKeys, Set<? extends SelectionKey> keys) {
        p.i(selectedKeys, "selectedKeys");
        p.i(keys, "keys");
        int size = selectedKeys.size();
        this.pending = keys.size() - size;
        this.cancelled = 0;
        if (size <= 0) {
            return;
        }
        Iterator<SelectionKey> it = selectedKeys.iterator();
        while (it.hasNext()) {
            handleSelectedKey(it.next());
            it.remove();
        }
    }

    public final void notifyClosedImpl(Selector selector, SelectionKey key, Selectable attachment) {
        p.i(selector, "selector");
        p.i(key, "key");
        p.i(attachment, "attachment");
        cancelAllSuspensions(attachment, new ClosedChannelException());
        setSubject(key, null);
        selector.wakeup();
    }

    public abstract void publishInterest(Selectable selectable);

    @Override // io.ktor.network.selector.SelectorManager
    public final Object select(Selectable selectable, SelectInterest selectInterest, InterfaceC4014c<? super t> interfaceC4014c) throws IOException {
        int i10 = selectable.get_interestedOps();
        int flag = selectInterest.getFlag();
        if (selectable.isClosed()) {
            SelectorManagerSupportKt.selectableIsClosed();
            throw new KotlinNothingValueException();
        }
        if ((i10 & flag) == 0) {
            SelectorManagerSupportKt.selectableIsInvalid(i10, flag);
            throw new KotlinNothingValueException();
        }
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new InterfaceC5074l<Throwable, t>() { // from class: io.ktor.network.selector.SelectorManagerSupport$select$2$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                invoke2(th);
                return t.f7040a;
            }
        });
        selectable.getSuspensions().addSuspension(selectInterest, cVar);
        if (!cVar.isCancelled()) {
            publishInterest(selectable);
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final void setCancelled(int i10) {
        this.cancelled = i10;
    }

    public final void setPending(int i10) {
        this.pending = i10;
    }

    public final void cancelAllSuspensions(Selector selector, Throwable cause) {
        p.i(selector, "selector");
        if (cause == null) {
            cause = new ClosedSelectorCancellationException();
        }
        Set<SelectionKey> setKeys = selector.keys();
        p.h(setKeys, "keys(...)");
        for (SelectionKey selectionKey : setKeys) {
            try {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
            } catch (CancelledKeyException unused) {
            }
            Object objAttachment = selectionKey.attachment();
            Selectable selectable = objAttachment instanceof Selectable ? (Selectable) objAttachment : null;
            if (selectable != null) {
                cancelAllSuspensions(selectable, cause);
            }
            selectionKey.cancel();
        }
    }
}
