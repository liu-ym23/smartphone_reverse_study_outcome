package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.Point;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p63.c;
import p63.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u000bHÆ\u0003JS\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b!\u0010 R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b(\u0010'¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/CombinationVO;", "Ljava/io/Serializable;", "", "component1", "", "Lp63/c;", "component2", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/Point;", "component3", "Lp63/d;", "component4", "", "component5", "component6", "headImageHeight", PromotionProductPrivilegesStruct.TAGS, "positions", "instructBoard", "needGradientBg", "v4Head", "copy", "", "toString", "hashCode", "", "other", "equals", "I", "getHeadImageHeight", "()I", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "getPositions", "Lp63/d;", "getInstructBoard", "()Lp63/d;", "Z", "getNeedGradientBg", "()Z", "getV4Head", "<init>", "(ILjava/util/List;Ljava/util/List;Lp63/d;ZZ)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinationVO implements Serializable {
    private final int headImageHeight;
    private final d instructBoard;
    private final boolean needGradientBg;
    private final List<Point> positions;
    private final List<c> tags;
    private final boolean v4Head;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CombinationVO copy$default(CombinationVO r100, int r101, List r102, List r103, d r104, boolean r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.headImageHeight;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tags;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.positions;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.instructBoard;
    L14:
        d r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.needGradientBg;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.v4Head;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.headImageHeight;
    }

    public final List<c> component2() {
        return this.tags;
    }

    public final List<Point> component3() {
        return this.positions;
    }

    public final d component4() {
        return this.instructBoard;
    }

    public final boolean component5() {
        return this.needGradientBg;
    }

    public final boolean component6() {
        return this.v4Head;
    }

    public final CombinationVO copy(int r100, List<c> r110, List<Point> r111, d r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r111, "positions");
        return new CombinationVO(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombinationVO) == false) goto L18;
        CombinationVO r101 = (CombinationVO) r100;
        if (this.headImageHeight == r101.headImageHeight) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.positions, r101.positions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instructBoard, r101.instructBoard) == true) goto L14;
        return false;
    L14:
        if (this.needGradientBg == r101.needGradientBg) goto L16;
        return false;
    L16:
        if (this.v4Head == r101.v4Head) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r100 = this.headImageHeight * 31;
        List<c> r101 = this.tags;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<Point> r105 = this.positions;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        d r108 = this.instructBoard;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.needGradientBg;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.v4Head;
        if (r114 == true) goto L21;
        r111 = r114;
    L21:
        return r113 + r111;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "CombinationVO(headImageHeight=" + this.headImageHeight + ", tags=" + this.tags + ", positions=" + this.positions + ", instructBoard=" + this.instructBoard + ", needGradientBg=" + this.needGradientBg + ", v4Head=" + this.v4Head + ")";
    }

    public final int getHeadImageHeight() {
        return this.headImageHeight;
    }

    public final d getInstructBoard() {
        return this.instructBoard;
    }

    public final boolean getNeedGradientBg() {
        return this.needGradientBg;
    }

    public final List<Point> getPositions() {
        return this.positions;
    }

    public final List<c> getTags() {
        return this.tags;
    }

    public final boolean getV4Head() {
        return this.v4Head;
    }

    public CombinationVO(int r100, List<c> r101, List<Point> r102, d r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r102, "positions");
        this.headImageHeight = r100;
        this.tags = r101;
        this.positions = r102;
        this.instructBoard = r103;
        this.needGradientBg = r104;
        this.v4Head = r105;
    }

    public /* synthetic */ CombinationVO(int r110, List r111, List r112, d r113, boolean r114, boolean r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r116 & 8) == 0) goto L9;
        d r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r116 & 32) == 0) goto L17;
        boolean r103 = false;
    L18:
        this(r100, r111, r112, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
