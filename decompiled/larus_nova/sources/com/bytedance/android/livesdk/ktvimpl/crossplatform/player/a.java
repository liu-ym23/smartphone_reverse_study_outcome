package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvMusic f143809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f143810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f143811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f143812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f143813e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f143809a, r101.f143809a) == true) goto L8;
        return false;
    L8:
        if (this.f143810b == r101.f143810b) goto L10;
        return false;
    L10:
        if (this.f143811c == r101.f143811c) goto L12;
        return false;
    L12:
        if (this.f143812d == r101.f143812d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f143813e, r101.f143813e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        KtvMusic r100 = this.f143809a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f143810b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f143811c;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        long r109 = this.f143812d;
        int r110 = (((r107 + r105) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Long r111 = this.f143813e;
        if (r111 == null) goto L17;
        r101 = r111.hashCode();
    L17:
        return r110 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BGMMusicParams(music=" + this.f143809a + ", enableMixer=" + this.f143810b + ", enableKtvAccurateProgress=" + this.f143811c + ", startTimeMs=" + this.f143812d + ", assignedDuration=" + this.f143813e + ")";
    }

    public a(KtvMusic r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "music");
        this.f143809a = r100;
        this.f143810b = r101;
        this.f143811c = r102;
        this.f143812d = 0;
        this.f143813e = null;
    }
}
