package com.bytedance.android.live.ktv.common.view.adapter;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f70805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70806b;

    @Override // com.bytedance.android.live.ktv.common.view.adapter.a
    public final void a() {
        this.f70806b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        Bitmap r100 = this.f70805a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f70806b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "UploadImgDataType(bitmap=" + this.f70805a + ", isSelected=" + this.f70806b + ")";
    }

    @Override // com.bytedance.android.live.ktv.common.view.adapter.a
    public final boolean isSelected() {
        return this.f70806b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f70805a, r101.f70805a) == true) goto L8;
        return false;
    L8:
        if (this.f70806b == r101.f70806b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public d(Bitmap r100, boolean r101) {
        this.f70805a = r100;
        this.f70806b = r101;
    }
}
