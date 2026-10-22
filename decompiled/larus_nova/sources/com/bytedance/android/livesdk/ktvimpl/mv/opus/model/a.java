package com.bytedance.android.livesdk.ktvimpl.mv.opus.model;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MusicPanel f146188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f146189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f146191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f146192e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f146189b == r101.f146189b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f146190c, r101.f146190c) == true) goto L10;
        return false;
    L10:
        if (this.f146191d == r101.f146191d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f146192e, r101.f146192e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r100 = this.f146189b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f146190c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f146191d;
        ?? r107 = r106;
        if (r106 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f146192e;
        if (r109 == null) goto L13;
        r103 = r109.hashCode();
    L13:
        return r108 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenOpusPreviewEvent(mId=" + this.f146189b + ", singerId=" + this.f146190c + ", isFromGuideEntry=" + this.f146191d + ", requestPage=" + this.f146192e + ")";
    }

    public a(long r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "singerId");
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        this.f146189b = r100;
        this.f146190c = r101;
        this.f146191d = r102;
        this.f146192e = r103;
        if (r102 == true) goto L6;
        e<Long> r104 = c.K;
        r104.getClass();
        f.d(r104, -1L);
        return;
    }
}
