package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/InputMethodSession;", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "onAllConnectionsClosed", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/jvm/functions/Function0;)V", "lock", "connections", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/WeakReference;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "disposed", "", "isActive", "()Z", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "dispose", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InputMethodSession {
    private MutableVector<WeakReference<NullableInputConnectionWrapper>> connections;
    private boolean disposed;
    private final Object lock;
    private final Function0<Unit> onAllConnectionsClosed;
    private final PlatformTextInputMethodRequest request;

    public final void dispose() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.disposed = true;     // Catch: Throwable -> L14
        MutableVector<WeakReference<NullableInputConnectionWrapper>> r101 = this.connections;     // Catch: Throwable -> L14
        WeakReference<NullableInputConnectionWrapper>[] r102 = r101.content;     // Catch: Throwable -> L14
        int r103 = r101.getSize();     // Catch: Throwable -> L14
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        NullableInputConnectionWrapper r105 = r102[r104].get();     // Catch: Throwable -> L14
        if (r105 == null) goto L10;
        r105.disposeDelegate();     // Catch: Throwable -> L14
    L10:
        r104 = r104 + 1;     // Catch: Throwable -> L14
        goto L6
    L11:
        this.connections.clear();     // Catch: Throwable -> L14
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean isActive() {
        return !this.disposed;
    }

    public static final /* synthetic */ MutableVector access$getConnections$p(InputMethodSession r100) {
        return r100.connections;
    }

    public static final /* synthetic */ Function0 access$getOnAllConnectionsClosed$p(InputMethodSession r100) {
        return r100.onAllConnectionsClosed;
    }

    public final InputConnection createInputConnection(EditorInfo r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.disposed == false) goto L9;
        monitor-exit(r101);
        return null;
    L9:
        NullableInputConnectionWrapper r102 = NullableInputConnectionWrapper_androidKt.NullableInputConnectionWrapper(this.request.createInputConnection(r100), new InputMethodSession$createInputConnection$1$1(this));     // Catch: Throwable -> L12
        this.connections.add(new WeakReference(r102));     // Catch: Throwable -> L12
        monitor-exit(r101);
        return r102;
    }

    public InputMethodSession(PlatformTextInputMethodRequest r100, Function0<Unit> r101) {
        this.request = r100;
        this.onAllConnectionsClosed = r101;
        this.lock = new Object();
        this.connections = new MutableVector(new WeakReference[16], 0);
    }
}
