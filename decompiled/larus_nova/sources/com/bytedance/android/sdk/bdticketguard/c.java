package com.bytedance.android.sdk.bdticketguard;

import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final void a(boolean r100, Function0<Pair<Integer, String>> r101) {
        if (r100 == false) goto L4;
        return;
    L4:
        Pair<Integer, String> r102 = r101.invoke();
        throw new AttestationLocalException(r102.getFirst().intValue(), r102.getSecond(), null, 4, null);
    }
}
