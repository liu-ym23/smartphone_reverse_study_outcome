package com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant;

import com.bytedance.android.shopping.ligo.container.event.AddCartExtraData;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ll.a f151253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f151254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f151255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AddCartExtraData f151256d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a$a, reason: collision with other inner class name */
    public static final class C2328a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f151253a, r101.f151253a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151254b, r101.f151254b) == true) goto L10;
        return false;
    L10:
        if (this.f151255c == r101.f151255c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f151256d, r101.f151256d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        ll.a r100 = this.f151253a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f151254b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f151255c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        AddCartExtraData r110 = this.f151256d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AddOnFloorCardRegionData(region=" + this.f151253a + ", cardType=" + this.f151254b + ", quitOthers=" + this.f151255c + ", cartExtra=" + this.f151256d + ")";
    }

    public a(ll.a r100, String r101, boolean r102, AddCartExtraData r103) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r101, "cardType");
        this.f151253a = r100;
        this.f151254b = r101;
        this.f151255c = r102;
        this.f151256d = r103;
    }
}
