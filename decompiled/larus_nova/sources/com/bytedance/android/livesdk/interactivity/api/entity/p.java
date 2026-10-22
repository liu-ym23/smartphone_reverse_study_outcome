package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.livesdk.event.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f133180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.event.n> f133181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<r> f133182c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f133180a, r101.f133180a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133181b, r101.f133181b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133182c, r101.f133182c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f133180a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.livesdk.event.n> r104 = this.f133181b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<r> r107 = this.f133182c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SelfRichTextInfo(content=" + this.f133180a + ", selfImageSendInfoList=" + this.f133181b + ", selfMentionSendInfoList=" + this.f133182c + ")";
    }

    @Override // com.bytedance.android.live.base.model.message.j4
    public final boolean a() {
        return !this.f133181b.isEmpty();
    }

    public p(String r100, List<com.bytedance.android.livesdk.event.n> r101, List<r> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "selfImageSendInfoList");
        Intrinsics.checkNotNullParameter(r102, "selfMentionSendInfoList");
        this.f133180a = r100;
        this.f133181b = r101;
        this.f133182c = r102;
    }
}
