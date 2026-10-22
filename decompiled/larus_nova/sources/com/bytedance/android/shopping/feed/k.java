package com.bytedance.android.shopping.feed;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f175103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f175104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f175105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f175106d;

    public k() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f175103a, r101.f175103a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f175104b, r101.f175104b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f175105c, r101.f175105c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f175106d, r101.f175106d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f175103a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f175104b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f175105c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f175106d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "SearchData(word=" + this.f175103a + ", id=" + this.f175104b + ", imprId=" + this.f175105c + ", reason=" + this.f175106d + ")";
    }

    public k(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_SEARCH_WORD);
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f175103a = r100;
        this.f175104b = r101;
        this.f175105c = null;
        this.f175106d = null;
    }
}
