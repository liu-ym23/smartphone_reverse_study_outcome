package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f169285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f169286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f169287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f169288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f169289e;

    public final String a(int r100) {
        List<String> r101 = this.f169289e;
        if (r101 == null) goto L15;
        String r102 = (String) CollectionsKt.getOrNull(r101, r100 - this.f169285a);
        if (r102 == null) goto L15;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        return r102;
    L9:
        r103 = false;
    L15:
        return this.f169287c;
    }

    public c0(int r100, int r101, String r102, String r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r102, "label");
        this.f169285a = r100;
        this.f169286b = r101;
        this.f169287c = r102;
        this.f169288d = r103;
        this.f169289e = r104;
    }
}
