package com.bytedance.android.shopping.deepfeed.data;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.shopping.deepfeed.slice.action.g;
import com.bytedance.android.shopping.deepfeed.slice.action.t;
import com.bytedance.android.shopping.deepfeed.slice.action.w;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f173118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f173119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f173120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f173122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f173123f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f173118a, r101.f173118a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173119b, r101.f173119b) == true) goto L10;
        return false;
    L10:
        if (this.f173120c == r101.f173120c) goto L12;
        return false;
    L12:
        if (this.f173121d == r101.f173121d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173122e, r101.f173122e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f173123f, r101.f173123f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public final int hashCode() {
        Map<String, Object> r100 = this.f173118a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t r104 = this.f173119b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f173120c) * 31;
        boolean r107 = this.f173121d;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f173122e;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        w r113 = this.f173123f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedTopBarListenerData(data=" + this.f173118a + ", vhFinder=" + this.f173119b + ", index=" + this.f173120c + ", isCache=" + this.f173121d + ", uuid=" + this.f173122e + ", containerProxy=" + this.f173123f + ")";
    }

    public e(Map r100, g r101, int r102, boolean r103, String r104, w r105) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r104, ST.UUID_DEVICE);
        this.f173118a = r100;
        this.f173119b = r101;
        this.f173120c = r102;
        this.f173121d = r103;
        this.f173122e = r104;
        this.f173123f = r105;
    }
}
