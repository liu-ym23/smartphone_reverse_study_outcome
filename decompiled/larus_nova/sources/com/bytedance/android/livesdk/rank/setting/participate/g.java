package com.bytedance.android.livesdk.rank.setting.participate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f157026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f157027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f157028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ParticipateStatus f157029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f157030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f157031g;

    public g(String r100, String r101, String r102, int r103, ParticipateStatus r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "rankId");
        Intrinsics.checkNotNullParameter(r101, "rankName");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r104, "status");
        Intrinsics.checkNotNullParameter(r105, "rankLevel1");
        Intrinsics.checkNotNullParameter(r106, "rankLevel2");
        this.f157025a = r100;
        this.f157026b = r101;
        this.f157027c = r102;
        this.f157028d = r103;
        this.f157029e = r104;
        this.f157030f = r105;
        this.f157031g = r106;
    }
}
