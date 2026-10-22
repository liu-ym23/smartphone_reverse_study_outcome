package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserver;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/CompositionObserverHolder;", "", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", RootDescription.ROOT_ELEMENT, "", "parent", "Landroidx/compose/runtime/CompositionContext;", "<init>", "(Landroidx/compose/runtime/tooling/CompositionObserver;ZLandroidx/compose/runtime/CompositionContext;)V", "getObserver", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "setObserver", "(Landroidx/compose/runtime/tooling/CompositionObserver;)V", "getRoot", "()Z", "setRoot", "(Z)V", "current", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CompositionObserverHolder {
    public static final int $stable = 8;
    private CompositionObserver observer;
    private final CompositionContext parent;
    private boolean root;

    public final CompositionObserver current() {
        if (this.root == true) goto L13;
        CompositionObserverHolder r100 = this.parent.getObserverHolder$runtime();
        if (r100 == null) goto L8;
        CompositionObserver r101 = r100.observer;
    L10:
        if (Intrinsics.areEqual(r101, this.observer) == true) goto L14;
        this.observer = r101;
        return r101;
    L14:
        return r101;
    L8:
        r101 = null;
        goto L10
    L13:
        return this.observer;
    }

    public final CompositionObserver getObserver() {
        return this.observer;
    }

    public final boolean getRoot() {
        return this.root;
    }

    public final void setObserver(CompositionObserver r100) {
        this.observer = r100;
    }

    public final void setRoot(boolean r100) {
        this.root = r100;
    }

    public CompositionObserverHolder(CompositionObserver r100, boolean r101, CompositionContext r102) {
        this.observer = r100;
        this.root = r101;
        this.parent = r102;
    }

    public /* synthetic */ CompositionObserverHolder(CompositionObserver r100, boolean r101, CompositionContext r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101, r102);
    }
}
