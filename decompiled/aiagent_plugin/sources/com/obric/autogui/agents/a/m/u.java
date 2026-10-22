package com.obric.autogui.agents.a.m;

/* JADX INFO: compiled from: ActionEffectTimingRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: compiled from: ActionEffectTimingRecorder.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26720a = null;

        static {
            int[] r0 = new int[s.values().length];
            r0[s.f26710a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[s.f26711b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[s.f26712c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[s.f26713d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f26720a = r0;
        }
    }

    public static final /* synthetic */ s a(s r0) {
        return d(r0);
    }

    public static final /* synthetic */ l b(s r0) {
        return c(r0);
    }

    private static final l c(s r1) {
        int r2 = a.f26720a[r1.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L12;
        return l.g;
    L12:
        throw new d.k();
    L18:
        return l.f;
    L19:
        return l.f26685e;
    L16:
        return l.f26684d;
    }

    private static final s d(s r1) {
        if (r1 == s.f26710a) goto L5;
        return r1;
    L5:
        return s.f26713d;
    }
}
