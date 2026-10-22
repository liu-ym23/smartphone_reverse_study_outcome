package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f80721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<nj0.g> f80722b;

    static {
        f80722b = CollectionsKt.emptyList();
    }

    public static void b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "subtitleItemList");
        f80721a = System.currentTimeMillis();
        f80722b = r100;
    }

    public static boolean a(boolean r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "subtitleItemList");
        if (vm2.c.b().getSameSubtitleContentUpdateFrequencyOpt() == true) goto L5;
        return false;
    L5:
        if (r100 == false) goto L7;
    L9:
        int r102 = g0.f80705a;
        List<nj0.g> r103 = f80722b;
        Intrinsics.checkNotNullParameter(r103, "oldSubtitleList");
        Intrinsics.checkNotNullParameter(r101, "newSubtitleList");
        if (r103.size() != ((ArrayList) r101).size()) goto L23;
        int r104 = r103.size();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L25;
        nj0.g r106 = (nj0.g) ListProtector.get(r103, r105);
        nj0.g r107 = (nj0.g) ListProtector.get(r101, r105);
        if (Intrinsics.areEqual(r106.f519410b, r107.f519410b) == true) goto L17;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L23;
        r105 = r105 + 1;
        goto L13
    L17:
        if (Intrinsics.areEqual(r106.f519411c, r107.f519411c) == false) goto L21;
        if (r106.f519413e != r107.f519413e) goto L21;
        r108 = true;
        goto L22
    L25:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L28;
        return true;
    L28:
        Iterator r110 = r101.iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        Object r111 = r110.next();
        if (((nj0.g) r111).f519413e == false) goto L30;
    L36:
        if (((nj0.g) r111) == null) goto L38;
    L40:
        return false;
    L38:
        if ((System.currentTimeMillis() - f80721a) >= vm2.c.b().getSameSubtitleContentUpdateFrequencyControlTime()) goto L40;
        return true;
    L34:
        r111 = null;
    L23:
        r109 = false;
        goto L26
    L7:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L9;
        return false;
    }
}
