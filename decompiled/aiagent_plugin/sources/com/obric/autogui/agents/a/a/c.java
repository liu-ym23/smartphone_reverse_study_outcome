package com.obric.autogui.agents.a.a;

import com.obric.autogui.common.api.platform.input.InjectTextResponse;
import com.obric.autogui.common.api.platform.input.InjectTextResponseType;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectAttemptModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: compiled from: ActionEffectAttemptModels.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26241a = null;

        static {
            int[] r0 = new int[InjectTextResponseType.values().length];
            r0[InjectTextResponseType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[InjectTextResponseType.ABNORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[InjectTextResponseType.SECURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[InjectTextResponseType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f26241a = r0;
        }
    }

    public static final e a(InjectTextResponse r3) {
        o.e(r3, "<this>");
        InjectTextResponseType r4 = r3.getType();
        int r5 = a.f26241a[r4.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L15;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L12;
        return null;
    L12:
        throw new d.k();
    L17:
        return new e(com.obric.autogui.agents.a.f.k.f26443b, d.f26242a, "injectText framework reported secure page");
    L15:
        return new e(com.obric.autogui.agents.a.f.k.f26442a, d.f26243b, "injectText framework reported effective result");
    }

    public static final e a(e r2, e r3) {
        o.e(r3, "candidate");
        if (r2 != null) goto L6;
        return r3;
    L6:
        if (r2.a() != com.obric.autogui.agents.a.f.k.f26443b) goto L9;
        return r2;
    L9:
        if (r3.a() == com.obric.autogui.agents.a.f.k.f26443b) goto L29;
        if (r2.b() != d.f26244c) goto L15;
        return r2;
    L15:
        if (r3.b() == d.f26244c) goto L29;
        if (a(r2.a()) == false) goto L21;
        return r2;
    L21:
        if (a(r3.a()) == true) goto L29;
        if (r2.a() != com.obric.autogui.agents.a.f.k.f26442a) goto L27;
        return r2;
    L27:
        if (r3.a() == com.obric.autogui.agents.a.f.k.f26442a) goto L29;
        return r2;
    L29:
        return r3;
    }

    private static final boolean a(com.obric.autogui.agents.a.f.k r1) {
        if (r1 != com.obric.autogui.agents.a.f.k.f26445d) goto L5;
    L8:
        return true;
    L5:
        if (r1 == com.obric.autogui.agents.a.f.k.f26446e) goto L8;
        return false;
    }
}
