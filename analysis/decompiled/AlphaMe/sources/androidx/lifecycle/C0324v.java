package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0324v {
    public static EnumC0326x a(EnumC0327y state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i4 = AbstractC0323u.$EnumSwitchMapping$0[state.ordinal()];
        if (i4 == 1) {
            return EnumC0326x.ON_DESTROY;
        }
        if (i4 == 2) {
            return EnumC0326x.ON_STOP;
        }
        if (i4 != 3) {
            return null;
        }
        return EnumC0326x.ON_PAUSE;
    }

    public static EnumC0326x b(EnumC0327y state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i4 = AbstractC0323u.$EnumSwitchMapping$0[state.ordinal()];
        if (i4 == 1) {
            return EnumC0326x.ON_START;
        }
        if (i4 == 2) {
            return EnumC0326x.ON_RESUME;
        }
        if (i4 != 5) {
            return null;
        }
        return EnumC0326x.ON_CREATE;
    }
}
