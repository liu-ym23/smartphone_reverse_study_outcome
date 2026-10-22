package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextRange;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR+\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/PasswordInputTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "Lkotlin/Function0;", "LC7/r;", "scheduleHide", AppAgent.CONSTRUCT, "(LS7/a;)V", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "transformInput", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "hide", "()V", "LS7/a;", "getScheduleHide", "()LS7/a;", "", "<set-?>", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "getRevealCodepointIndex$foundation_release", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PasswordInputTransformation implements InputTransformation {
    public static final int $stable = 0;

    /* renamed from: revealCodepointIndex$delegate, reason: from kotlin metadata */
    private final MutableIntState revealCodepointIndex = SnapshotIntStateKt.mutableIntStateOf(-1);
    private final S7.a scheduleHide;

    public PasswordInputTransformation(S7.a aVar) {
        this.scheduleHide = aVar;
    }

    private final void setRevealCodepointIndex(int i) {
        this.revealCodepointIndex.setIntValue(i);
    }

    public final int getRevealCodepointIndex$foundation_release() {
        return this.revealCodepointIndex.getIntValue();
    }

    public final S7.a getScheduleHide() {
        return this.scheduleHide;
    }

    public final void hide() {
        setRevealCodepointIndex(-1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getChanges().getChangeCount() != 1 || TextRange.m6307getLengthimpl(textFieldBuffer.getChanges().mo1140getRangejx7JFs(0)) != 1 || TextRange.m6307getLengthimpl(textFieldBuffer.getChanges().mo1139getOriginalRangejx7JFs(0)) != 0 || textFieldBuffer.hasSelection()) {
            setRevealCodepointIndex(-1);
            return;
        }
        int iM6309getMinimpl = TextRange.m6309getMinimpl(textFieldBuffer.getChanges().mo1140getRangejx7JFs(0));
        if (getRevealCodepointIndex$foundation_release() != iM6309getMinimpl) {
            this.scheduleHide.invoke();
            setRevealCodepointIndex(iM6309getMinimpl);
        }
    }
}
