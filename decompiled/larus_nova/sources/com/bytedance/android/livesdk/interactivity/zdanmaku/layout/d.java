package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Comparator;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Comparator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f141658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f141659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f141660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f141661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f141662e;

    public d(e r100, f r101) {
        this.f141661d = r100;
        this.f141662e = r101;
        this.f141660c = UtilityKotlinExtentionsKt.h(6);
    }

    @Override // java.util.Comparator
    public final int compare(Integer r100, Integer r101) {
        int r102 = r100.intValue();
        int r103 = r101.intValue();
        float r104 = this.f141661d.f141665b.b(r102);
        float r105 = this.f141661d.f141665b.b(r103);
        float r106 = this.f141658a - this.f141660c;
        if (r104 >= r106) goto L6;
        r104 = 0.0f;
    L6:
        if (r105 >= r106) goto L9;
        r105 = 0.0f;
    L9:
        if (r104 != r105) goto L16;
        int r107 = this.f141662e.a(r102, this.f141659b);
        int r108 = this.f141662e.a(r103, this.f141659b);
        if (r107 != r108) goto L15;
        return MathKt.getSign(r102 - r103);
    L15:
        return MathKt.getSign(r108 - r107);
    L16:
        return MathKt.getSign((int) (r104 - r105));
    }
}
