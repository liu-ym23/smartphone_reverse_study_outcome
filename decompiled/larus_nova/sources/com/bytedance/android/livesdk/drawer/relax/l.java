package com.bytedance.android.livesdk.drawer.relax;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f122684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends LiveDrawerPageName> f122686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> f122687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<? extends ArrayList<Long>> f122688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> f122689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<? extends LiveDrawerManageStatus> f122690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> f122691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f122692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122693j;

    public l(Function0<Boolean> r100, Function1<? super Function1<? super Boolean, Boolean>, Unit> r101, Function0<? extends LiveDrawerPageName> r102, Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> r103, Function0<? extends ArrayList<Long>> r104, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r105, Function0<? extends LiveDrawerManageStatus> r106, Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> r107, Function0<Boolean> r110, Function1<? super Function1<? super Boolean, Boolean>, Unit> r111) {
        Intrinsics.checkNotNullParameter(r104, "deleteList");
        Intrinsics.checkNotNullParameter(r105, "setDeleteList");
        Intrinsics.checkNotNullParameter(r106, "manageStatus");
        Intrinsics.checkNotNullParameter(r107, "setManageStatus");
        Intrinsics.checkNotNullParameter(r110, "allSelected");
        Intrinsics.checkNotNullParameter(r111, "setAllSelected");
        this.f122684a = r100;
        this.f122685b = r101;
        this.f122686c = r102;
        this.f122687d = r103;
        this.f122688e = r104;
        this.f122689f = r105;
        this.f122690g = r106;
        this.f122691h = r107;
        this.f122692i = r110;
        this.f122693j = r111;
    }
}
