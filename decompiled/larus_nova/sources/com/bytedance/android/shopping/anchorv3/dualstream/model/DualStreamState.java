package com.bytedance.android.shopping.anchorv3.dualstream.model;

import com.bytedance.android.ec.model.response.LynxCellData;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.f1;
import com.bytedance.jedi.arch.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/model/DualStreamState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DualStreamState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PromotionProductCommentDTO> f165090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f165091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f165092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f165093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f165094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LoadState f165095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f165096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LynxCellData f165097h;

    public DualStreamState() {
        this(0);
    }

    public static DualStreamState a(List r110, boolean r111, long r112, boolean r113, boolean r114, LoadState r115, f1 r116, LynxCellData r117) {
        Intrinsics.checkNotNullParameter(r110, "dualStreamVO");
        Intrinsics.checkNotNullParameter(r115, "loadState");
        return new DualStreamState(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public static /* synthetic */ DualStreamState b(DualStreamState r100, List r110, boolean r111, boolean r112, boolean r113, LoadState r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r110 = r100.f165090a;
    L5:
        List r101 = r110;
        if ((r115 & 2) == 0) goto L8;
        r111 = r100.f165091b;
    L8:
        boolean r102 = r111;
        if ((r115 & 4) == 0) goto L11;
        long r116 = r100.f165092c;
    L12:
        long r103 = r116;
        if ((r115 & 8) == 0) goto L15;
        r112 = r100.f165093d;
    L15:
        boolean r104 = r112;
        if ((r115 & 16) == 0) goto L18;
        r113 = r100.f165094e;
    L18:
        boolean r105 = r113;
        if ((r115 & 32) == 0) goto L21;
        r114 = r100.f165095f;
    L21:
        LoadState r106 = r114;
        if ((r115 & 64) == 0) goto L24;
        f1 r107 = r100.f165096g;
    L26:
        if ((r115 & 128) == 0) goto L28;
        LynxCellData r108 = r100.f165097h;
    L29:
        r100.getClass();
        return a(r101, r102, r103, r104, r105, r106, r107, r108);
    L28:
        r108 = null;
        goto L29
    L24:
        r107 = null;
        goto L26
    L11:
        r116 = 0;
        goto L12
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DualStreamState) == false) goto L22;
        DualStreamState r101 = (DualStreamState) r100;
        if (Intrinsics.areEqual(this.f165090a, r101.f165090a) == true) goto L8;
        return false;
    L8:
        if (this.f165091b == r101.f165091b) goto L10;
        return false;
    L10:
        if (this.f165092c == r101.f165092c) goto L12;
        return false;
    L12:
        if (this.f165093d == r101.f165093d) goto L14;
        return false;
    L14:
        if (this.f165094e == r101.f165094e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f165095f, r101.f165095f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f165096g, r101.f165096g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f165097h, r101.f165097h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<PromotionProductCommentDTO> r100 = this.f165090a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f165091b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        long r107 = this.f165092c;
        int r108 = (((r103 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.f165093d;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f165094e;
        if (r112 == true) goto L16;
        r105 = r112;
    L16:
        int r113 = (r111 + r105) * 31;
        LoadState r114 = this.f165095f;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        f1 r117 = this.f165096g;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        LynxCellData r120 = this.f165097h;
        if (r120 == null) goto L28;
        r101 = r120.hashCode();
    L28:
        return r119 + r101;
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DualStreamState(dualStreamVO=" + this.f165090a + ", hasMore=" + this.f165091b + ", cursor=" + this.f165092c + ", loadMore=" + this.f165093d + ", refresh=" + this.f165094e + ", loadState=" + this.f165095f + ", surveyV2=" + this.f165096g + ", newNpsInfo=" + this.f165097h + ")";
    }

    public /* synthetic */ DualStreamState(int r110) {
        this(new ArrayList(), true, 0, false, false, LoadState.DEFAULT, null, null);
    }

    public DualStreamState(List<PromotionProductCommentDTO> r100, boolean r101, long r102, boolean r103, boolean r104, LoadState r105, f1 r106, LynxCellData r110) {
        Intrinsics.checkNotNullParameter(r100, "dualStreamVO");
        Intrinsics.checkNotNullParameter(r105, "loadState");
        this.f165090a = r100;
        this.f165091b = r101;
        this.f165092c = r102;
        this.f165093d = r103;
        this.f165094e = r104;
        this.f165095f = r105;
        this.f165096g = r106;
        this.f165097h = r110;
    }
}
