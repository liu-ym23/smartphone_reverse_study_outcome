package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f172634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f172635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExternalAudioInterruptReason f172636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExternalAudioTargetScope f172637e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L16;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f172633a, r101.f172633a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172634b, r101.f172634b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172635c, r101.f172635c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172636d, r101.f172636d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f172637e, r101.f172637e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f172633a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f172634b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f172635c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ExternalAudioInterruptReason r110 = this.f172636d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ExternalAudioTargetScope r113 = this.f172637e;
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
        return "ExternalAudioRequest(ownerPage=" + this.f172633a + ", sliceId=" + this.f172634b + ", audioInfo=" + this.f172635c + ", reason=" + this.f172636d + ", targetScope=" + this.f172637e + ")";
    }

    public t(String r100, e r101, ExternalAudioInterruptReason r102, ExternalAudioTargetScope r103) {
        Intrinsics.checkNotNullParameter("CommentFragment", "ownerPage");
        Intrinsics.checkNotNullParameter(r100, "sliceId");
        Intrinsics.checkNotNullParameter(r101, "audioInfo");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r103, "targetScope");
        this.f172633a = "CommentFragment";
        this.f172634b = r100;
        this.f172635c = r101;
        this.f172636d = r102;
        this.f172637e = r103;
    }
}
