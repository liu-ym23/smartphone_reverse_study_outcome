package com.bytedance.android.livesdk.drawer.relax;

import android.content.Context;
import com.bytedance.salamander.anniex.r3;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends ArrayList<l0>> f122614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<d> f122615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f122616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends r3> f122617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f122618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f122621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<? extends Map<String, Object>> f122622i;

    public final Context getContext() {
        return this.f122618e;
    }

    public e(Function0<? extends ArrayList<l0>> r100, Function0<d> r101, j0 r102, Function0<? extends r3> r103, Context r104, Function1<? super Function1<? super Boolean, Boolean>, Unit> r105, Function1<? super Function1<? super Boolean, Boolean>, Unit> r106, f r107, Function0<? extends Map<String, Object>> r110) {
        Intrinsics.checkNotNullParameter(r100, "tabList");
        Intrinsics.checkNotNullParameter(r101, "businessContext");
        Intrinsics.checkNotNullParameter(r102, "settings");
        Intrinsics.checkNotNullParameter(r103, "userInfo");
        Intrinsics.checkNotNullParameter(r105, "setShowHistoryPage");
        Intrinsics.checkNotNullParameter(r106, "setShowSearchPage");
        Intrinsics.checkNotNullParameter(r110, "trackContext");
        this.f122614a = r100;
        this.f122615b = r101;
        this.f122616c = r102;
        this.f122617d = r103;
        this.f122618e = r104;
        this.f122619f = r105;
        this.f122620g = r106;
        this.f122621h = r107;
        this.f122622i = r110;
    }
}
