package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDefaults;", "", "<init>", "()V", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "getProperties", "()Landroidx/compose/material3/ModalBottomSheetProperties;", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isFocusable", "", "shouldDismissOnBackPress", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetDefaults {
    public static final int $stable = 0;
    public static final ModalBottomSheetDefaults INSTANCE = null;
    private static final ModalBottomSheetProperties properties = null;

    private ModalBottomSheetDefaults() {
    }

    static {
        INSTANCE = new ModalBottomSheetDefaults();
        properties = new ModalBottomSheetProperties();
    }

    public final ModalBottomSheetProperties getProperties() {
        return properties;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'isFocusable' param is no longer used. Use value without this parameter.", replaceWith = @ReplaceWith(expression = "properties", imports = {}))
    public final ModalBottomSheetProperties properties(SecureFlagPolicy r100, boolean r101, boolean r102) {
        return new ModalBottomSheetProperties(r100, r102, false, 4, null);
    }

    public static /* synthetic */ ModalBottomSheetProperties properties$default(ModalBottomSheetDefaults r100, SecureFlagPolicy r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = SecureFlagPolicy.Inherit;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = true;
    L12:
        return r100.properties(r101, r102, r103);
    }
}
