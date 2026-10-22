package com.bytedance.android.anniex.detect;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f40681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f40682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f40683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f40685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f40686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f40687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f40688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f40689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f40690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f40691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StringBuilder f40692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f40693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f40694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Float> f40695p;

    public g() {
        this(null);
    }

    public final String toString() {
        return "isDetectFinish:" + this.f40680a + ", isPitayaReady:" + this.f40681b + ", isPixelCopySuccess" + this.f40682c + ", isPixelCopyCost" + this.f40683d + ", isPureBlank" + this.f40684e + ", isPureBlankTimeout" + this.f40685f + ", pureBlankCost" + this.f40686g + ", isPartialBlank" + this.f40688i + ", isPartialBlankTimeout" + this.f40689j + ", partialBlankCost" + this.f40690k + ", errorMsg" + this.f40692m + "bboxs" + this.f40693n + ", classLabels" + this.f40694o + ", scores" + this.f40695p;
    }

    public g(Object r100) {
        Boolean r101 = Boolean.FALSE;
        StringBuilder r102 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        this.f40680a = false;
        this.f40681b = false;
        this.f40682c = false;
        this.f40683d = null;
        this.f40684e = false;
        this.f40685f = false;
        this.f40686g = null;
        this.f40687h = r101;
        this.f40688i = false;
        this.f40689j = false;
        this.f40690k = null;
        this.f40691l = r101;
        this.f40692m = r102;
        this.f40693n = null;
        this.f40694o = null;
        this.f40695p = null;
    }
}
