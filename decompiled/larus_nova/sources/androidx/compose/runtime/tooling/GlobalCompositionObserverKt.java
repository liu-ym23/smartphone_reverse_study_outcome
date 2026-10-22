package androidx.compose.runtime.tooling;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a\b\u0010\t\u001a\u0004\u0018\u00010\u0001\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"_globalCompositionObserver", "Landroidx/compose/runtime/tooling/GlobalCompositionObserver;", "get_globalCompositionObserver", "()Landroidx/compose/runtime/tooling/GlobalCompositionObserver;", "set_globalCompositionObserver", "(Landroidx/compose/runtime/tooling/GlobalCompositionObserver;)V", "setGlobalCompositionObserver", "", "observer", "getGlobalCompositionObserver", "isInvalidationObservingEnabled", "", "()Z", "setInvalidationObservingEnabled", "(Z)V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GlobalCompositionObserverKt {
    private static GlobalCompositionObserver _globalCompositionObserver;
    private static boolean isInvalidationObservingEnabled;

    public static final GlobalCompositionObserver getGlobalCompositionObserver() {
        return _globalCompositionObserver;
    }

    public static final GlobalCompositionObserver get_globalCompositionObserver() {
        return _globalCompositionObserver;
    }

    public static final boolean isInvalidationObservingEnabled() {
        return isInvalidationObservingEnabled;
    }

    public static final void setGlobalCompositionObserver(GlobalCompositionObserver r100) {
        _globalCompositionObserver = r100;
    }

    public static final void setInvalidationObservingEnabled(boolean r100) {
        isInvalidationObservingEnabled = r100;
    }

    public static final void set_globalCompositionObserver(GlobalCompositionObserver r100) {
        _globalCompositionObserver = r100;
    }
}
