package androidx.compose.foundation.interaction;

import C7.r;
import H7.c;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;
import p9.e;
import p9.i;

@Stable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/interaction/MutableInteractionSourceImpl;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/foundation/interaction/Interaction;", "interaction", "LC7/r;", "emit", "(Landroidx/compose/foundation/interaction/Interaction;LH7/c;)Ljava/lang/Object;", "", "tryEmit", "(Landroidx/compose/foundation/interaction/Interaction;)Z", "Lp9/i;", "interactions", "Lp9/i;", "getInteractions", "()Lp9/i;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MutableInteractionSourceImpl implements MutableInteractionSource {
    private final i interactions = e.b(0, 16, BufferOverflow.b, 1);

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public Object emit(Interaction interaction, c<? super r> cVar) {
        Object objEmit = getInteractions().emit(interaction, cVar);
        return objEmit == CoroutineSingletons.f4909a ? objEmit : r.f317a;
    }

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public boolean tryEmit(Interaction interaction) {
        return getInteractions().a(interaction);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public i getInteractions() {
        return this.interactions;
    }
}
