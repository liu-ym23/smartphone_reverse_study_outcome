package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0012\u001a\u00020\u0004*\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/PasswordInputTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "scheduleHide", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getScheduleHide", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "", "revealCodepointIndex", "getRevealCodepointIndex$foundation_release", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "hide", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PasswordInputTransformation implements InputTransformation {
    public static final int $stable = 0;
    private final MutableIntState revealCodepointIndex$delegate;
    private final Function0<Unit> scheduleHide;

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ void applySemantics(SemanticsPropertyReceiver r100) {
        InputTransformation.CC.$default$applySemantics(this, r100);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ KeyboardOptions getKeyboardOptions() {
        return InputTransformation.CC.$default$getKeyboardOptions(this);
    }

    public final void hide() {
        setRevealCodepointIndex(-1);
    }

    public final int getRevealCodepointIndex$foundation_release() {
        return this.revealCodepointIndex$delegate.getIntValue();
    }

    public final Function0<Unit> getScheduleHide() {
        return this.scheduleHide;
    }

    public PasswordInputTransformation(Function0<Unit> r100) {
        this.scheduleHide = r100;
        this.revealCodepointIndex$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
    }

    private final void setRevealCodepointIndex(int r100) {
        this.revealCodepointIndex$delegate.setIntValue(r100);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer r100) {
        boolean r101 = true;
        if (r100.getChanges().getChangeCount() == 1) goto L5;
    L7:
        r101 = false;
    L8:
        if (r101 == true) goto L10;
    L16:
        setRevealCodepointIndex(-1);
        return;
    L10:
        if (r100.hasSelection() == true) goto L16;
        int r102 = TextRange.m6996getMinimpl(r100.getChanges().mo1194getRangejx7JFs(0));
        if (getRevealCodepointIndex$foundation_release() == r102) goto L18;
        this.scheduleHide.invoke();
        setRevealCodepointIndex(r102);
        return;
    L18:
        return;
    L5:
        if (TextRange.m6994getLengthimpl(r100.getChanges().mo1194getRangejx7JFs(0)) != 1) goto L7;
        goto L7
    }
}
