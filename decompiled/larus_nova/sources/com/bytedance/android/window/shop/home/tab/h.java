package com.bytedance.android.window.shop.home.tab;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WindowTabFragmentBase> f188746a = null;

    static {
        f188746a = new CopyOnWriteArrayList();
    }

    public static WindowTabFragmentBase a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryId");
        Intrinsics.checkNotNullParameter(r101, "categoryName");
        CopyOnWriteArrayList<WindowTabFragmentBase> r103 = f188746a;
        if ((!r103.isEmpty()) == false) goto L6;
        dm.a.a("window_first_frame_opt").i("window_tab_fragment_pre_create");
        WindowTabFragmentBase r104 = r103.remove(0);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "categoryId");
        Intrinsics.checkNotNullParameter(r101, "categoryName");
        r104.f188690f.b(r104, new g(r100, r101));
        return r104;
    L6:
        int r105 = WindowTabFragmentBase.f188687g;
        return WindowTabFragmentBase.a.a(r100, r101, r102, false, 100);
    }
}
