package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f45645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f45646c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m1) == false) goto L12;
        m1 r101 = (m1) r100;
        if (this.f45644a == r101.f45644a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f45645b, r101.f45645b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f45646c, r101.f45646c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f45644a * 31;
        Bitmap r101 = this.f45645b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f45646c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "SequenceBitmap(index=" + this.f45644a + ", bitmap=" + this.f45645b + ", url=" + this.f45646c + ")";
    }

    public m1(int r100, Bitmap r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        this.f45644a = r100;
        this.f45645b = r101;
        this.f45646c = r102;
    }
}
