package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<HSImageView> f71075a = null;

    static {
        f71075a = new ArrayList();
    }

    public static HSImageView a() {
        List<HSImageView> r100 = f71075a;
        if (((ArrayList) r100).size() != 0) goto L7;
        return null;
    L7:
        return (HSImageView) ListProtector.remove(r100, 0);
    }

    public static boolean b() {
        if (((ArrayList) f71075a).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ArrayList r101 = (ArrayList) f71075a;
        if (r101.size() >= 8) goto L6;
        r101.add(r100);
        return;
    }
}
