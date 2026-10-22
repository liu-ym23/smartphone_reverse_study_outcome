package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public class e implements QModel {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f189543e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f189544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f189545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f189546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f189547d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public int modelType() {
        return 0;
    }

    public float b() {
        ECUrlModel r100 = this.f189544a;
        if (r100 == null) goto L5;
        float r101 = r100.getWidth();
        float r102 = RangesKt.coerceAtLeast(this.f189544a.getHeight(), 0.01f);
    L7:
        return RangesKt.coerceIn(r101 / r102, 0.01f, 100.0f);
    L5:
        r101 = this.f189545b.getWidth();
        r102 = RangesKt.coerceAtLeast(this.f189545b.getHeight(), 0.01f);
        goto L7
    }

    public e(ECUrlModel r100, ECUrlModel r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "cover");
        this.f189544a = r100;
        this.f189545b = r101;
        this.f189546c = r102;
        this.f189547d = r103;
    }
}
