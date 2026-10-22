package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, RoomLinkerContent> f82258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f82259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f82260c;

    public g() {
        this(null, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f82258a, r101.f82258a) == true) goto L8;
        return false;
    L8:
        if (this.f82259b == r101.f82259b) goto L10;
        return false;
    L10:
        if (this.f82260c == r101.f82260c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        Map<Long, RoomLinkerContent> r100 = this.f82258a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f82259b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f82260c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PkInteractAudienceParams(linkerContentMap=" + this.f82258a + ", inviterWithAudience=" + this.f82259b + ", inviteeWithAudience=" + this.f82260c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Map<Long, ? extends RoomLinkerContent> r100, boolean r101, boolean r102) {
        this.f82258a = r100;
        this.f82259b = r101;
        this.f82260c = r102;
    }
}
