package com.bytedance.android.shopping.deepfeed.slice;

import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.action.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f173406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f173407e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f173403a, r101.f173403a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173404b, r101.f173404b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173405c, r101.f173405c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f173406d, r101.f173406d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173407e, r101.f173407e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f173403a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f173404b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f173405c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ViewGroup r110 = this.f173406d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        t r113 = this.f173407e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "DeepFeedSlcCreateParams(url=" + this.f173403a + ", name=" + this.f173404b + ", version=" + this.f173405c + ", container=" + this.f173406d + ", handlerFinder=" + this.f173407e + ")";
    }

    public b(String r100, String r101, String r102, ViewGroup r103, t r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r104, "handlerFinder");
        this.f173403a = r100;
        this.f173404b = r101;
        this.f173405c = r102;
        this.f173406d = r103;
        this.f173407e = r104;
    }
}
