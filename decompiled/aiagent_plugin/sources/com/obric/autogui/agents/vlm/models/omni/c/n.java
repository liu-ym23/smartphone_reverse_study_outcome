package com.obric.autogui.agents.vlm.models.omni.c;

import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;

/* JADX INFO: compiled from: PrewarmAdmissionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f28309a = null;

    /* JADX INFO: compiled from: PrewarmAdmissionController.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28310a = null;

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
            r0[AppBlackListState.CannotObtain.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[AppBlackListState.Usable.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[AppBlackListState.UserDefinedBlackList.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f28310a = r0;
        }
    }

    static {
        f28309a = new n();
    }

    private n() {
    }

    public final o a(AppBlackListState r2, boolean r3, boolean r4, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e r5) {
        d.h.b.o.e(r2, "blackListState");
        switch(a.f28310a[r2.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L7;
            case 7: goto L7;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L7:
        if (r3 == false) goto L9;
        return null;
    L9:
        if (r4 == true) goto L13;
        return o.h;
    L13:
        if (r5 == com.obric.autogui.agents.vlm.models.impl.applist.black.j.e.f27428a) goto L17;
        return o.g;
    L17:
        if (r2 != AppBlackListState.Usable) goto L19;
        return null;
    L19:
        return o.g;
    L21:
        return o.f;
    L23:
        return o.f28315e;
    L25:
        return o.f28314d;
    L27:
        return o.f28313c;
    L29:
        return o.f28312b;
    }
}
