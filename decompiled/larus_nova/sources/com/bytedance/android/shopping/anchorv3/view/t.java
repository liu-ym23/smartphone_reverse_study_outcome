package com.bytedance.android.shopping.anchorv3.view;

import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t extends VOIdentifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f165556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h53.a f165557c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (this.f165556b == r101.f165556b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165557c, r101.f165557c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f165556b;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        h53.a r103 = this.f165557c;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "AnchorV3GuessULikeTitleVO(showCategory=" + this.f165556b + ", categoryStyle=" + this.f165557c + ")";
    }

    public t() {
        this(true, h53.a.C6101a.f483874a);
    }

    public t(boolean r100, h53.a r101) {
        Intrinsics.checkNotNullParameter(r101, "categoryStyle");
        this.f165556b = r100;
        this.f165557c = r101;
        int r102 = AnchorV4TabArea.f167088i;
        scrollConfig("id_recommend", AnchorV4TabArea.f167089j);
    }
}
