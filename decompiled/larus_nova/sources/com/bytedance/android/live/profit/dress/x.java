package com.bytedance.android.live.profit.dress;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.live.profit.dress.config.s> f87206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.live.profit.dress.config.q> f87207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f87209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f87210e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L16;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f87206a, r101.f87206a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87207b, r101.f87207b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87208c, r101.f87208c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87209d, r101.f87209d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87210e, r101.f87210e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Map<Long, com.bytedance.android.live.profit.dress.config.s> r100 = this.f87206a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<Long, com.bytedance.android.live.profit.dress.config.q> r104 = this.f87207b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f87208c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f87209d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f87210e;
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
        return "RevenueDress(propConfigs=" + this.f87206a + ", teamPlayerProps=" + this.f87207b + ", mvpEmojiDecorationId=" + this.f87208c + ", bloodBarStyleWebp=" + this.f87209d + ", mvpEmojiDecorationImg=" + this.f87210e + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Map<Long, ? extends com.bytedance.android.live.profit.dress.config.s> r100, Map<Long, ? extends com.bytedance.android.live.profit.dress.config.q> r101, String r102, String r103, String r104) {
        this.f87206a = r100;
        this.f87207b = r101;
        this.f87208c = r102;
        this.f87209d = r103;
        this.f87210e = r104;
    }
}
