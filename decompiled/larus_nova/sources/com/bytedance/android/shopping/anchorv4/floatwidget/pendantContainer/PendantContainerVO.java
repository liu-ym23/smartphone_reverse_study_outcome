package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import com.bytedance.android.shopping.anchorv4.dto.ComponentSize;
import com.bytedance.android.shopping.anchorv4.dto.LynxElement;
import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBU\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u0012\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantContainerVO;", "Ljava/io/Serializable;", "leftBottom", "", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "rightBottom", "topRight", "topLeft", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLeftBottom", "()Ljava/util/List;", "getRightBottom", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getComponentCacheKey", "", "hashCode", "", "merge", "data", "toString", "Companion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PendantContainerVO implements Serializable {
    public static final Companion Companion = null;
    private final List<LynxElementVO> leftBottom;
    private final List<LynxElementVO> rightBottom;
    private final List<LynxElementVO> topLeft;
    private final List<LynxElementVO> topRight;

    public static final class Companion {
        public Companion() {
        }

        public static Pair b(PendantContainerVO r110) {
            ArrayList r100 = new ArrayList();
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            PendantContainerVO$Companion$filterPendingModel$1 r104 = PendantContainerVO$Companion$filterPendingModel$1.INSTANCE;
            ArrayList r105 = null;
            if (r110 == null) goto L61;
            List<LynxElementVO> r106 = r110.getLeftBottom();
            if (r106 == null) goto L12;
            ArrayList r107 = new ArrayList();
            Iterator<T> r108 = r106.iterator();
        L8:
            if (r108.hasNext() == false) goto L13;
            Object r109 = r108.next();
            if (PendantContainerVO$Companion$filterPendingModel$1.INSTANCE.invoke2((LynxElementVO) r109, r100) == false) goto L8;
            r107.add(r109);
        L13:
            List<LynxElementVO> r111 = r110.getTopRight();
            if (r111 == null) goto L21;
            ArrayList r112 = new ArrayList();
            Iterator<T> r113 = r111.iterator();
        L17:
            if (r113.hasNext() == false) goto L22;
            Object r114 = r113.next();
            if (PendantContainerVO$Companion$filterPendingModel$1.INSTANCE.invoke2((LynxElementVO) r114, r101) == false) goto L17;
            r112.add(r114);
        L22:
            List<LynxElementVO> r115 = r110.getTopLeft();
            if (r115 == null) goto L30;
            ArrayList r116 = new ArrayList();
            Iterator<T> r117 = r115.iterator();
        L26:
            if (r117.hasNext() == false) goto L31;
            Object r118 = r117.next();
            if (PendantContainerVO$Companion$filterPendingModel$1.INSTANCE.invoke2((LynxElementVO) r118, r102) == false) goto L26;
            r116.add(r118);
        L31:
            List<LynxElementVO> r119 = r110.getRightBottom();
            if (r119 == null) goto L40;
            r105 = new ArrayList();
            Iterator<T> r120 = r119.iterator();
        L35:
            if (r120.hasNext() == false) goto L40;
            Object r121 = r120.next();
            if (PendantContainerVO$Companion$filterPendingModel$1.INSTANCE.invoke2((LynxElementVO) r121, r103) == false) goto L35;
            r105.add(r121);
        L40:
            return TuplesKt.to(new PendantContainerVO(r107, r105, r112, r116), new PendantContainerVO(r100, r103, r101, r102));
        L30:
            r116 = null;
            goto L31
        L21:
            r112 = null;
            goto L22
        L12:
            r107 = null;
            goto L13
        L61:
            return null;
        }

        public static PendantContainerVO c(PendantContainer r100) {
            ArrayList r101 = null;
            if (r100 == null) goto L62;
            List<LynxElement> r102 = r100.getLeftBottom();
            if (r102 == null) goto L14;
            List<LynxElement> r103 = r102;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L8:
            if (r105.hasNext() == false) goto L15;
            LynxElement r106 = (LynxElement) r105.next();
            if (r106 != null) goto L12;
            LynxElementVO r107 = null;
        L13:
            r104.add(r107);
            goto L8
        L12:
            Companion r108 = PendantContainerVO.Companion;
            PendantGravity r109 = PendantGravity.BOTTOM_START;
            r108.getClass();
            r107 = a(r106, r109);
        L15:
            List<LynxElement> r110 = r100.getTopRight();
            if (r110 == null) goto L25;
            List<LynxElement> r111 = r110;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator<T> r113 = r111.iterator();
        L19:
            if (r113.hasNext() == false) goto L26;
            LynxElement r114 = (LynxElement) r113.next();
            if (r114 != null) goto L23;
            LynxElementVO r115 = null;
        L24:
            r112.add(r115);
            goto L19
        L23:
            Companion r116 = PendantContainerVO.Companion;
            PendantGravity r117 = PendantGravity.TOP_RIGHT;
            r116.getClass();
            r115 = a(r114, r117);
        L26:
            List<LynxElement> r118 = r100.getTopLeft();
            if (r118 == null) goto L36;
            List<LynxElement> r119 = r118;
            ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
            Iterator<T> r121 = r119.iterator();
        L30:
            if (r121.hasNext() == false) goto L37;
            LynxElement r122 = (LynxElement) r121.next();
            if (r122 != null) goto L34;
            LynxElementVO r123 = null;
        L35:
            r120.add(r123);
            goto L30
        L34:
            Companion r124 = PendantContainerVO.Companion;
            PendantGravity r125 = PendantGravity.TOP_LEFT;
            r124.getClass();
            r123 = a(r122, r125);
        L37:
            List<LynxElement> r126 = r100.getRightBottom();
            if (r126 == null) goto L49;
            List<LynxElement> r127 = r126;
            ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
            Iterator<T> r129 = r127.iterator();
        L41:
            if (r129.hasNext() == false) goto L47;
            LynxElement r130 = (LynxElement) r129.next();
            if (r130 != null) goto L45;
            LynxElementVO r131 = null;
        L46:
            r128.add(r131);
            goto L41
        L45:
            Companion r132 = PendantContainerVO.Companion;
            PendantGravity r133 = PendantGravity.BOTTOM_END;
            r132.getClass();
            r131 = a(r130, r133);
            goto L46
        L47:
            r101 = r128;
        L49:
            return new PendantContainerVO(r104, r101, r112, r120);
        L36:
            r120 = null;
            goto L37
        L25:
            r112 = null;
            goto L26
        L14:
            r104 = null;
            goto L15
        L62:
            return null;
        }

        public static LynxElementVO a(LynxElement r210, PendantGravity r211) {
            String r100 = r210.getSchema();
            String r101 = r210.getMegaData();
            Map<String, Object> r102 = r210.getQueryData();
            ComponentSize r103 = r210.getWidth();
            Integer r104 = null;
            if (r103 == null) goto L5;
            Integer r105 = r103.getType();
        L6:
            ComponentSize r106 = r210.getWidth();
            if (r106 == null) goto L9;
            Integer r107 = r106.getSize();
        L10:
            a r108 = new a(r105, r107);
            ComponentSize r109 = r210.getHeight();
            if (r109 == null) goto L13;
            Integer r110 = r109.getType();
        L14:
            ComponentSize r111 = r210.getHeight();
            if (r111 == null) goto L18;
            r104 = r111.getSize();
        L18:
            return new LynxElementVO(r100, r101, r102, r108, new a(r110, r104), r210.getLynxId(), r210.getBottomMargin(), r210.getLeftMargin(), r210.getRightMargin(), r210.getTopMargin(), r210.getLocation(), r211, r210.getConfig(), 0, 0, 0, 0, null, 253952, null);
        L13:
            r110 = null;
            goto L14
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }

        public static List d(List r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "removeList");
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r102 = new ArrayList();
            LinkedHashSet r103 = new LinkedHashSet();
            Iterator r104 = r101.iterator();
        L7:
            if (r104.hasNext() == false) goto L14;
            LynxElementVO r105 = (LynxElementVO) r104.next();
            if (r105 == null) goto L11;
            String r106 = r105.getSchema();
        L12:
            if (r106 == null) goto L7;
            r103.add(r106);
            goto L7
        L11:
            r106 = null;
            goto L12
        L14:
            Iterator r107 = r100.iterator();
        L16:
            if (r107.hasNext() == false) goto L26;
            LynxElementVO r108 = (LynxElementVO) r107.next();
            if (r108 == null) goto L20;
            String r109 = r108.getSchema();
        L21:
            if (r109 == null) goto L25;
            if (r103.contains(r108.getSchema()) == true) goto L16;
        L25:
            r102.add(r108);
            goto L16
        L20:
            r109 = null;
            goto L21
        L26:
            return r102;
        }
    }

    static {
        Companion = new Companion();
    }

    public PendantContainerVO() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendantContainerVO copy$default(PendantContainerVO r100, List r101, List r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.leftBottom;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.rightBottom;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.topRight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.topLeft;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<LynxElementVO> component1() {
        return this.leftBottom;
    }

    public final List<LynxElementVO> component2() {
        return this.rightBottom;
    }

    public final List<LynxElementVO> component3() {
        return this.topRight;
    }

    public final List<LynxElementVO> component4() {
        return this.topLeft;
    }

    public final PendantContainerVO copy(List<LynxElementVO> r100, List<LynxElementVO> r101, List<LynxElementVO> r102, List<LynxElementVO> r103) {
        return new PendantContainerVO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PendantContainerVO) == false) goto L14;
        PendantContainerVO r101 = (PendantContainerVO) r100;
        if (Intrinsics.areEqual(this.leftBottom, r101.leftBottom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rightBottom, r101.rightBottom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.topRight, r101.topRight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topLeft, r101.topLeft) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<LynxElementVO> r100 = this.leftBottom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LynxElementVO> r104 = this.rightBottom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<LynxElementVO> r107 = this.topRight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<LynxElementVO> r110 = this.topLeft;
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

    public String toString() {
        return "PendantContainerVO(leftBottom=" + this.leftBottom + ", rightBottom=" + this.rightBottom + ", topRight=" + this.topRight + ", topLeft=" + this.topLeft + ")";
    }

    public final List<String> getComponentCacheKey() {
        ArrayList r100 = new ArrayList();
        List<LynxElementVO> r101 = this.leftBottom;
        if (r101 == null) goto L14;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        LynxElementVO r104 = (LynxElementVO) r103.next();
        if (r104 == null) goto L10;
        String r105 = r104.getSchema();
    L11:
        if (r105 == null) goto L6;
        r102.add(r105);
        goto L6
    L10:
        r105 = null;
        goto L11
    L13:
        r100.addAll(r102);
    L14:
        List<LynxElementVO> r106 = this.rightBottom;
        if (r106 == null) goto L26;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L25;
        LynxElementVO r109 = (LynxElementVO) r108.next();
        if (r109 == null) goto L22;
        String r110 = r109.getSchema();
    L23:
        if (r110 == null) goto L18;
        r107.add(r110);
        goto L18
    L22:
        r110 = null;
        goto L23
    L25:
        r100.addAll(r107);
    L26:
        List<LynxElementVO> r111 = this.topRight;
        if (r111 == null) goto L38;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L30:
        if (r113.hasNext() == false) goto L37;
        LynxElementVO r114 = (LynxElementVO) r113.next();
        if (r114 == null) goto L34;
        String r115 = r114.getSchema();
    L35:
        if (r115 == null) goto L30;
        r112.add(r115);
        goto L30
    L34:
        r115 = null;
        goto L35
    L37:
        r100.addAll(r112);
    L38:
        List<LynxElementVO> r116 = this.topLeft;
        if (r116 == null) goto L50;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L42:
        if (r118.hasNext() == false) goto L49;
        LynxElementVO r119 = (LynxElementVO) r118.next();
        if (r119 == null) goto L46;
        String r120 = r119.getSchema();
    L47:
        if (r120 == null) goto L42;
        r117.add(r120);
        goto L42
    L46:
        r120 = null;
        goto L47
    L49:
        r100.addAll(r117);
    L50:
        return r100;
    }

    public final List<LynxElementVO> getLeftBottom() {
        return this.leftBottom;
    }

    public final List<LynxElementVO> getRightBottom() {
        return this.rightBottom;
    }

    public final List<LynxElementVO> getTopLeft() {
        return this.topLeft;
    }

    public final List<LynxElementVO> getTopRight() {
        return this.topRight;
    }

    public final PendantContainerVO merge(PendantContainerVO r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        List<LynxElementVO> r101 = this.leftBottom;
        if (r101 == null) goto L12;
        List<LynxElementVO> r102 = r101;
        List<LynxElementVO> r103 = r100.leftBottom;
        if (r103 != null) goto L10;
        r103 = CollectionsKt.emptyList();
    L10:
        List<LynxElementVO> r104 = CollectionsKt.plus(r102, r103);
        if (r104 == null) goto L12;
    L13:
        List<LynxElementVO> r105 = this.rightBottom;
        if (r105 == null) goto L21;
        List<LynxElementVO> r106 = r105;
        List<LynxElementVO> r107 = r100.rightBottom;
        if (r107 != null) goto L19;
        r107 = CollectionsKt.emptyList();
    L19:
        List<LynxElementVO> r108 = CollectionsKt.plus(r106, r107);
        if (r108 == null) goto L21;
    L22:
        List<LynxElementVO> r109 = this.topRight;
        if (r109 == null) goto L30;
        List<LynxElementVO> r110 = r109;
        List<LynxElementVO> r111 = r100.topRight;
        if (r111 != null) goto L28;
        r111 = CollectionsKt.emptyList();
    L28:
        List<LynxElementVO> r112 = CollectionsKt.plus(r110, r111);
        if (r112 == null) goto L30;
    L31:
        List<LynxElementVO> r113 = this.topLeft;
        if (r113 == null) goto L39;
        List<LynxElementVO> r114 = r113;
        List<LynxElementVO> r115 = r100.topLeft;
        if (r115 != null) goto L37;
        r115 = CollectionsKt.emptyList();
    L37:
        List<LynxElementVO> r116 = CollectionsKt.plus(r114, r115);
        if (r116 == null) goto L39;
    L41:
        return new PendantContainerVO(r104, r108, r112, r116);
    L39:
        r116 = r100.topLeft;
    L30:
        r112 = r100.topRight;
    L21:
        r108 = r100.rightBottom;
    L12:
        r104 = r100.leftBottom;
        goto L13
    }

    public PendantContainerVO(List<LynxElementVO> r100, List<LynxElementVO> r101, List<LynxElementVO> r102, List<LynxElementVO> r103) {
        this.leftBottom = r100;
        this.rightBottom = r101;
        this.topRight = r102;
        this.topLeft = r103;
    }

    public /* synthetic */ PendantContainerVO(List r100, List r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
