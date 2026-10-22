package androidx.compose.foundation;

import C7.r;
import S7.k;
import androidx.annotation.IntRange;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a5\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "value", "LY7/b;", "valueRange", "", "steps", "progressSemantics", "(Landroidx/compose/ui/Modifier;FLY7/b;I)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressSemanticsKt {
    @Stable
    public static final Modifier progressSemantics(Modifier modifier, final float f, final Y7.b bVar, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) final int i) {
        return SemanticsModifierKt.semantics(modifier, true, new k() { // from class: androidx.compose.foundation.ProgressSemanticsKt.progressSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) AbstractC1451a.w(Float.valueOf(f), bVar)).floatValue(), bVar, i));
            }
        });
    }

    public static Modifier progressSemantics$default(Modifier modifier, float f, Y7.b bVar, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            bVar = new Y7.a(0.0f, 1.0f);
        }
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return progressSemantics(modifier, f, bVar, i);
    }

    @Stable
    public static final Modifier progressSemantics(Modifier modifier) {
        return SemanticsModifierKt.semantics(modifier, true, new k() { // from class: androidx.compose.foundation.ProgressSemanticsKt.progressSemantics.2
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, ProgressBarRangeInfo.INSTANCE.getIndeterminate());
            }
        });
    }
}
