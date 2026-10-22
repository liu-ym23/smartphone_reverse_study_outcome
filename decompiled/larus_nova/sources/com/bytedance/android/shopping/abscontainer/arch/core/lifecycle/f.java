package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164147a = 0;

    static {
    }

    public static a a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "processors");
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        a r102 = (a) ((Function0) r101.next()).invoke();
        if (r102.f164135a == false) goto L4;
        return r102;
    L9:
        return new a(false);
    }

    @JvmStatic
    public static final q33.b b(List<? extends Function0<q33.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "processors");
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        q33.b r102 = (q33.b) ((Function0) r101.next()).invoke();
        if (r102.f164135a == false) goto L4;
        return r102;
    L9:
        return new q33.b(false, null);
    }

    public static void c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "processors");
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function0) r101.next()).invoke();
        goto L4
    }
}
