package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34837a = null;

        static {
            int[] r100 = new int[GrantingAction.values().length];
            r100[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f34837a = r100;
        }
    }

    public static final MoaStepResult a(GrantingAction r100, boolean r101) {
        int r102 = a.f34837a[r100.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L7;
        if (r101 == false) goto L18;
        return MoaStepResult.REFUSED;
    L18:
        return MoaStepResult.CONTINUE;
    L7:
        if (r102 != 3) goto L10;
        return MoaStepResult.WAITING_ACTION;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return MoaStepResult.CONTINUE;
    }
}
