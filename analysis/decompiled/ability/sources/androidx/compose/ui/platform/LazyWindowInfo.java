package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\tR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/compose/ui/platform/LazyWindowInfo;", "Landroidx/compose/ui/platform/WindowInfo;", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntSize;", "calculateContainerSize", "LC7/r;", "updateContainerSizeIfObserved", "(LS7/a;)V", "onInitializeContainerSize", "setOnInitializeContainerSize", "LS7/a;", "Landroidx/compose/runtime/MutableState;", "_containerSize", "Landroidx/compose/runtime/MutableState;", "", "<set-?>", "isWindowFocused$delegate", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "value", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "keyboardModifiers", "getContainerSize-YbymL2g", "()J", "containerSize", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyWindowInfo implements WindowInfo {
    public static final int $stable = 0;
    private MutableState<IntSize> _containerSize;

    /* renamed from: isWindowFocused$delegate, reason: from kotlin metadata */
    private final MutableState isWindowFocused = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    private S7.a onInitializeContainerSize;

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getContainerSize-YbymL2g, reason: not valid java name */
    public long mo6024getContainerSizeYbymL2g() {
        if (this._containerSize == null) {
            S7.a aVar = this.onInitializeContainerSize;
            this._containerSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m7007boximpl(aVar != null ? ((IntSize) aVar.invoke()).m7019unboximpl() : IntSize.INSTANCE.m7020getZeroYbymL2g()), null, 2, null);
            this.onInitializeContainerSize = null;
        }
        MutableState<IntSize> mutableState = this._containerSize;
        kotlin.jvm.internal.k.c(mutableState);
        return mutableState.getValue().m7019unboximpl();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    public int mo6025getKeyboardModifiersk7X9c1A() {
        return WindowInfoImpl.INSTANCE.getGlobalKeyboardModifiers$ui_release().getValue().getPackedValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return ((Boolean) this.isWindowFocused.getValue()).booleanValue();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0, reason: not valid java name */
    public void m6026setKeyboardModifiers5xRPYO0(int i) {
        WindowInfoImpl.INSTANCE.getGlobalKeyboardModifiers$ui_release().setValue(PointerKeyboardModifiers.m5482boximpl(i));
    }

    public final void setOnInitializeContainerSize(S7.a onInitializeContainerSize) {
        if (this._containerSize == null) {
            this.onInitializeContainerSize = onInitializeContainerSize;
        }
    }

    public void setWindowFocused(boolean z10) {
        this.isWindowFocused.setValue(Boolean.valueOf(z10));
    }

    public final void updateContainerSizeIfObserved(S7.a calculateContainerSize) {
        MutableState mutableState = this._containerSize;
        if (mutableState != null) {
            mutableState.setValue(calculateContainerSize.invoke());
        }
    }
}
