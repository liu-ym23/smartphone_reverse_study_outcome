package com.bytedance.android.livesdk.reddot;

import java.util.TreeSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f157088a = 0;

    static {
    }

    public static void a(RedDotDelegate r100, RedDotDelegate r101) {
        Intrinsics.checkNotNullParameter(r100, "redDotDelegate");
        Intrinsics.checkNotNullParameter(r101, "childDot");
        if (r100.f157077c != null) goto L5;
        r100.f157077c = new TreeSet();
    L5:
        TreeSet<RedDotDelegate> r102 = r100.f157077c;
        if (r102 == null) goto L9;
        r102.add(r101);
        return;
    }

    @JvmStatic
    public static final RedDotDelegate b(a r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "redDot");
        RedDotDelegate r102 = new RedDotDelegate(r100);
        r102.f157081g = r101;
        return r102;
    }
}
