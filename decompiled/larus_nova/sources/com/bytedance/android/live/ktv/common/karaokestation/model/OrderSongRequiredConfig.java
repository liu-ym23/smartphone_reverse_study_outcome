package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OrderSongRequiredConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b f69488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<String, TabLayout, Context, Unit> f69489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f69490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f69491d;

    public OrderSongRequiredConfig() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderSongRequiredConfig) == false) goto L14;
        OrderSongRequiredConfig r101 = (OrderSongRequiredConfig) r100;
        if (Intrinsics.areEqual(this.f69488a, r101.f69488a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f69489b, r101.f69489b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f69490c, r101.f69490c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f69491d, r101.f69491d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = this.f69488a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function3<String, TabLayout, Context, Unit> r104 = this.f69489b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f69490c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r110 = this.f69491d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongRequiredConfig(commonOrderSongViewModel=" + this.f69488a + ", fillCustomTabAction=" + this.f69489b + ", fillFirstLevelTabArrayListAction=" + this.f69490c + ", bindFirstLevelTabFragmentAction=" + this.f69491d + ")";
    }

    public /* synthetic */ OrderSongRequiredConfig(int r100) {
        this(null, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSongRequiredConfig(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100, Function3<? super String, ? super TabLayout, ? super Context, Unit> r101, Function0<Unit> r102, Function1<? super List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "fillCustomTabAction");
        Intrinsics.checkNotNullParameter(r102, "fillFirstLevelTabArrayListAction");
        Intrinsics.checkNotNullParameter(r103, "bindFirstLevelTabFragmentAction");
        this.f69488a = r100;
        this.f69489b = r101;
        this.f69490c = r102;
        this.f69491d = r103;
    }
}
