package com.obric.autogui.session.b;

import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import d.k;

/* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30768a = null;

        static {
            int[] r0 = new int[AppBlackListState.values().length];
            r0[AppBlackListState.HardBlackList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[AppBlackListState.SoftBlackList.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[AppBlackListState.SAEPBlackList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AppBlackListState.Virus.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AppBlackListState.Usable.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[AppBlackListState.UserDefinedBlackList.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[AppBlackListState.CannotObtain.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f30768a = r0;
        }
    }

    public static final /* synthetic */ boolean a(AppBlackListState r0) {
        return b(r0);
    }

    private static final boolean b(AppBlackListState r1) {
        switch(a.f30768a[r1.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new k();
    }
}
