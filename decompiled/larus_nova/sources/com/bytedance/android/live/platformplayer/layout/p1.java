package com.bytedance.android.live.platformplayer.layout;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p1 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f85694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f85695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f85696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f85697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f85698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f85699f;

    public p1(RectF r100, boolean r101, Integer r102, boolean r103, Matrix r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "gridMatrix");
        Intrinsics.checkNotNullParameter(r105, "seiRaw");
        this.f85694a = r100;
        this.f85695b = r101;
        this.f85696c = r102;
        this.f85697d = r103;
        this.f85698e = r104;
        this.f85699f = r105;
    }
}
