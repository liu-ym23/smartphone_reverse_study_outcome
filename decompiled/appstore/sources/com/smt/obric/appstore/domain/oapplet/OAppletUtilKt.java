package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OAppletUtilKt {
    public static final Flow a(Context r10, String r11) {
        q.g(r10, "context");
        q.g(r11, "tag");
        return c.d(c.e(new OAppletUtilKt$OAppletChangeFlow$1(r11, r10, null)), 100, null, 2, null);
    }
}
