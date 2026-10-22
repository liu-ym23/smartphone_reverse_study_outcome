package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import android.graphics.PointF;
import com.bytedance.android.livesdk.gift.model.o0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f79396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f79397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0 f79398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f79399d;

    public o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L14;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f79396a, r101.f79396a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f79397b, r101.f79397b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f79398c, r101.f79398c) == true) goto L12;
        return false;
    L12:
        if (this.f79399d == r101.f79399d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        PointF r100 = this.f79396a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f79397b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o0 r107 = this.f79398c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f79399d;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "from:" + this.f79396a + ",toIDs:" + this.f79397b;
    }

    public o(PointF r100, List r101, o0 r102) {
        Intrinsics.checkNotNullParameter(r101, "toUserIDs");
        this.f79396a = r100;
        this.f79397b = r101;
        this.f79398c = r102;
        this.f79399d = false;
    }
}
