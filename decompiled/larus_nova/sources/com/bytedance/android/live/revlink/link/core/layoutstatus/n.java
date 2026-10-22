package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o51.e f98309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f98310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> f98311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f98312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Integer> f98313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, i> f98314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f98315g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L22;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f98309a, r101.f98309a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98310b, r101.f98310b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98311c, r101.f98311c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98312d, r101.f98312d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98313e, r101.f98313e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98314f, r101.f98314f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f98315g, r101.f98315g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        o51.e r100 = this.f98309a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        f r103 = this.f98310b;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        int r105 = (r102 + r104) * 31;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r106 = this.f98311c;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        int r108 = (r105 + r107) * 31;
        List<Long> r109 = this.f98312d;
        if (r109 == null) goto L17;
        int r110 = r109.hashCode();
    L18:
        int r111 = (r108 + r110) * 31;
        Map<String, Integer> r112 = this.f98313e;
        if (r112 == null) goto L21;
        int r113 = r112.hashCode();
    L22:
        int r114 = (r111 + r113) * 31;
        Map<String, i> r115 = this.f98314f;
        if (r115 == null) goto L25;
        int r116 = r115.hashCode();
    L26:
        int r117 = (r114 + r116) * 31;
        l r118 = this.f98315g;
        if (r118 == null) goto L29;
        int r119 = r118.hashCode();
    L31:
        return ((r117 + r119) * 31) + 0;
    L29:
        r119 = 0;
        goto L31
    L25:
        r116 = 0;
        goto L26
    L21:
        r113 = 0;
        goto L22
    L17:
        r110 = 0;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestLayoutSnapShot(uiLayout=" + this.f98309a + ", layoutConfig=" + this.f98310b + ", validStream=" + this.f98311c + ", forwardControl=" + this.f98312d + ", anchorPosition=" + this.f98313e + ", mainBackupStreamStatus=" + this.f98314f + ", minFrames=" + this.f98315g + ", renderLayerInfo=null)";
    }

    public n(o51.e r100, f r101, Map r102, List r103, Map r104, Map r105, l r106) {
        this.f98309a = r100;
        this.f98310b = r101;
        this.f98311c = r102;
        this.f98312d = r103;
        this.f98313e = r104;
        this.f98314f = r105;
        this.f98315g = r106;
    }
}
