package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"shouldApplySecureFlag", "", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SecureFlagPolicy_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[SecureFlagPolicy.values().length];
            r100[SecureFlagPolicy.SecureOff.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SecureFlagPolicy.SecureOn.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SecureFlagPolicy.Inherit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy r100, boolean r101) {
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r102 != 1) goto L5;
        return false;
    L5:
        if (r102 != 2) goto L7;
        return true;
    L7:
        if (r102 != 3) goto L10;
        return r101;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
