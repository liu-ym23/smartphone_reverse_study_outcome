package androidx.compose.ui.window;

import C7.c;
import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rB;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000eB'\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u000fJ\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "usePlatformDefaultWidth", "decorFitsSystemWindows", "windowTitle", "", AppAgent.CONSTRUCT, "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZLjava/lang/String;)V", "(ZZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "getDismissOnBackPress", "()Z", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "getDecorFitsSystemWindows", "getWindowTitle", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DialogProperties {
    public static final int $stable = 0;
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;
    private final String windowTitle;

    public DialogProperties() {
        this(false, false, null, false, false, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogProperties)) {
            return false;
        }
        DialogProperties dialogProperties = (DialogProperties) other;
        return this.dismissOnBackPress == dialogProperties.dismissOnBackPress && this.dismissOnClickOutside == dialogProperties.dismissOnClickOutside && this.securePolicy == dialogProperties.securePolicy && this.usePlatformDefaultWidth == dialogProperties.usePlatformDefaultWidth && this.decorFitsSystemWindows == dialogProperties.decorFitsSystemWindows;
    }

    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        return Boolean.hashCode(this.decorFitsSystemWindows) + androidx.appfunctions.metadata.a.d((this.securePolicy.hashCode() + androidx.appfunctions.metadata.a.d(Boolean.hashCode(this.dismissOnBackPress) * 31, 31, this.dismissOnClickOutside)) * 31, 31, this.usePlatformDefaultWidth);
    }

    public DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13, String str) {
        this.dismissOnBackPress = z10;
        this.dismissOnClickOutside = z11;
        this.securePolicy = secureFlagPolicy;
        this.usePlatformDefaultWidth = z12;
        this.decorFitsSystemWindows = z13;
        this.windowTitle = str;
    }

    public /* synthetic */ DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13, String str, int i, e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? true : z11, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 8) != 0 ? true : z12, (i & 16) != 0 ? true : z13, (i & 32) != 0 ? "" : str);
    }

    public /* synthetic */ DialogProperties(boolean z10, boolean z11, boolean z12, int i, e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? true : z11, (i & 4) != 0 ? true : z12);
    }

    public DialogProperties(boolean z10, boolean z11, boolean z12) {
        this(z10, z11, SecureFlagPolicy.Inherit, z12, true, null, 32, null);
    }

    public /* synthetic */ DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13, int i, e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? true : z11, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 8) != 0 ? true : z12, (i & 16) != 0 ? true : z13);
    }

    @c
    public /* synthetic */ DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13) {
        this(z10, z11, SecureFlagPolicy.Inherit, z12, true, "");
    }

    public /* synthetic */ DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, int i, e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? true : z11, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy);
    }

    @c
    public /* synthetic */ DialogProperties(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy) {
        this(z10, z11, secureFlagPolicy, true, true, null, 32, null);
    }
}
