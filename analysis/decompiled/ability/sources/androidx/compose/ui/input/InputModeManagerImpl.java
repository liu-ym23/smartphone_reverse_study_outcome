package androidx.compose.ui.input;

import S7.k;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR+\u0010\t\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00028V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/input/InputModeManager;", "Landroidx/compose/ui/input/InputMode;", "initialInputMode", "Lkotlin/Function1;", "", "onRequestInputModeChange", AppAgent.CONSTRUCT, "(ILS7/k;Lkotlin/jvm/internal/e;)V", "inputMode", "requestInputMode-iuPiT84", "(I)Z", "requestInputMode", "LS7/k;", "<set-?>", "inputMode$delegate", "Landroidx/compose/runtime/MutableState;", "getInputMode-aOaMEAU", "()I", "setInputMode-iuPiT84", "(I)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {
    public static final int $stable = 0;

    /* renamed from: inputMode$delegate, reason: from kotlin metadata */
    private final MutableState inputMode;
    private final k onRequestInputModeChange;

    public /* synthetic */ InputModeManagerImpl(int i, k kVar, e eVar) {
        this(i, kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: getInputMode-aOaMEAU */
    public int mo4946getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode.getValue()).getValue();
    }

    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: requestInputMode-iuPiT84 */
    public boolean mo4947requestInputModeiuPiT84(int inputMode) {
        return ((Boolean) this.onRequestInputModeChange.invoke(InputMode.m4937boximpl(inputMode))).booleanValue();
    }

    /* renamed from: setInputMode-iuPiT84, reason: not valid java name */
    public void m4948setInputModeiuPiT84(int i) {
        this.inputMode.setValue(InputMode.m4937boximpl(i));
    }

    private InputModeManagerImpl(int i, k kVar) {
        this.onRequestInputModeChange = kVar;
        this.inputMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m4937boximpl(i), null, 2, null);
    }
}
