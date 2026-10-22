package b;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0014\u0010\u0013R*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u0005R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lb/G;", "", "", x5.d.EXTRA_ENABLED, "<init>", "(Z)V", "LY8/t;", "remove", "()V", "Lb/c;", "backEvent", "handleOnBackStarted", "(Lb/c;)V", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "Lb/d;", "cancellable", "addCancellable", "(Lb/d;)V", "removeCancellable", UxipConstants.f30680s, "isEnabled", "Z", "()Z", "setEnabled", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cancellables", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "enabledChangedCallback", "Lp9/a;", "getEnabledChangedCallback$activity_release", "()Lp9/a;", "setEnabledChangedCallback$activity_release", "(Lp9/a;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: b.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1417G {
    private final CopyOnWriteArrayList<InterfaceC1424d> cancellables = new CopyOnWriteArrayList<>();
    private InterfaceC5063a<Y8.t> enabledChangedCallback;
    private boolean isEnabled;

    public AbstractC1417G(boolean z10) {
        this.isEnabled = z10;
    }

    public final void addCancellable(InterfaceC1424d cancellable) {
        kotlin.jvm.internal.p.i(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final InterfaceC5063a<Y8.t> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(C1423c backEvent) {
        kotlin.jvm.internal.p.i(backEvent, "backEvent");
    }

    public void handleOnBackStarted(C1423c backEvent) {
        kotlin.jvm.internal.p.i(backEvent, "backEvent");
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((InterfaceC1424d) it.next()).cancel();
        }
    }

    public final void removeCancellable(InterfaceC1424d cancellable) {
        kotlin.jvm.internal.p.i(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    public final void setEnabled(boolean z10) {
        this.isEnabled = z10;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.enabledChangedCallback;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.enabledChangedCallback = interfaceC5063a;
    }
}
