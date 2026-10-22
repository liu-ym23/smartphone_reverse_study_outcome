package com.bytedance.android.live.room.api.messagewindow.builder.card;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f98956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f98957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f98958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f98959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MsgWindowPosition f98960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<CardMountingsBuilder.ContainerBuilder, Unit> f98961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<CardMountingsBuilder.b, Unit> f98962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<CardMountingsBuilder.d, Unit> f98963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<CardMountingsBuilder.a, Unit> f98964i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f98956a, r101.f98956a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98957b, r101.f98957b) == true) goto L10;
        return false;
    L10:
        if (this.f98958c == r101.f98958c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98959d, r101.f98959d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98960e, r101.f98960e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98961f, r101.f98961f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f98962g, r101.f98962g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f98963h, r101.f98963h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f98964i, r101.f98964i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        DataCenter r100 = this.f98956a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f98957b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f98958c) * 31;
        Context r107 = this.f98959d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        MsgWindowPosition r110 = this.f98960e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function1<CardMountingsBuilder.ContainerBuilder, Unit> r113 = this.f98961f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Function1<CardMountingsBuilder.b, Unit> r116 = this.f98962g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Function1<CardMountingsBuilder.d, Unit> r119 = this.f98963h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Function1<CardMountingsBuilder.a, Unit> r122 = this.f98964i;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CardMountings(dataCenter=" + this.f98956a + ", identity=" + this.f98957b + ", priority=" + this.f98958c + ", context=" + this.f98959d + ", position=" + this.f98960e + ", containerBuilderInit=" + this.f98961f + ", lifeCycleBuilderInit=" + this.f98962g + ", strategyBuilderInit=" + this.f98963h + ", argsBuilderInit=" + this.f98964i + ")";
    }

    public final Context getContext() {
        return this.f98959d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(DataCenter r100, Object r101, int r102, Context r103, MsgWindowPosition r104, Function1<? super CardMountingsBuilder.ContainerBuilder, Unit> r105, Function1<? super CardMountingsBuilder.b, Unit> r106, Function1<? super CardMountingsBuilder.d, Unit> r107, Function1<? super CardMountingsBuilder.a, Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r104, "position");
        Intrinsics.checkNotNullParameter(r105, "containerBuilderInit");
        Intrinsics.checkNotNullParameter(r106, "lifeCycleBuilderInit");
        Intrinsics.checkNotNullParameter(r107, "strategyBuilderInit");
        Intrinsics.checkNotNullParameter(r110, "argsBuilderInit");
        this.f98956a = r100;
        this.f98957b = r101;
        this.f98958c = r102;
        this.f98959d = r103;
        this.f98960e = r104;
        this.f98961f = r105;
        this.f98962g = r106;
        this.f98963h = r107;
        this.f98964i = r110;
    }
}
