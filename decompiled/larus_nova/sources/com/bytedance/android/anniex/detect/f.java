package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f40677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f40678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f40679c;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f40677a, r101.f40677a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40678b, r101.f40678b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f40679c, r101.f40679c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f40677a.hashCode() * 31) + this.f40678b.hashCode()) * 31) + this.f40679c.hashCode();
    }

    public final String toString() {
        return "DetectionContext(bitmap=" + this.f40677a + ", detectionStatus=" + this.f40678b + ", extras=" + this.f40679c + ')';
    }

    public f(Bitmap r100, g r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "detectionStatus");
        Intrinsics.checkNotNullParameter(r102, "extras");
        this.f40677a = r100;
        this.f40678b = r101;
        this.f40679c = r102;
    }
}
