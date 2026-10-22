package com.bytedance.android.shopping.sku.common.data;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/h;", "", "", "Lcom/bytedance/android/shopping/sku/common/data/Spec;", "specs", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "", "", "Lcom/bytedance/android/shopping/sku/common/data/SpecState;", "specsState", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/sku/common/data/i;", "specItemsState", "f", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f182681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f182682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f182683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f182684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f182685e;

    @SerializedName("spec_items_state")
    private final Map<String, i> specItemsState;

    @SerializedName("specs")
    private final List<Spec> specs;

    @SerializedName("specs_state")
    private final Map<String, SpecState> specsState;

    public h() {
        List<Spec> r100 = CollectionsKt.emptyList();
        Map<String, SpecState> r101 = MapsKt.emptyMap();
        Map<String, i> r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "specs");
        Intrinsics.checkNotNullParameter(r101, "specsState");
        Intrinsics.checkNotNullParameter(r102, "specItemsState");
        this.specs = r100;
        this.specsState = r101;
        this.specItemsState = r102;
        this.f182681a = LazyKt.lazy(new SkuYataSpecFieldVO$nextSkuId$2(this));
        this.f182682b = LazyKt.lazy(new SkuYataSpecFieldVO$nextSpecsContent$2(this));
        this.f182683c = LazyKt.lazy(new SkuYataSpecFieldVO$nextSpecsContentOpt$2(this));
        this.f182684d = LazyKt.lazy(new SkuYataSpecFieldVO$nextPicSpecItemId$2(this));
        this.f182685e = LazyKt.lazy(new SkuYataSpecFieldVO$nextPossibleHeadImg$2(this));
    }

    public final Map<String, i> f() {
        return this.specItemsState;
    }

    public final List<Spec> g() {
        return this.specs;
    }

    public final Map<String, SpecState> h() {
        return this.specsState;
    }

    public static final String a(h r100) {
        r100.getClass();
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r100.specs.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L25;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        SpecState r106 = r100.specsState.get(((Spec) r104).getSpecIndex());
        if (r106 == null) goto L11;
        String r107 = r106.getSelectedSpecItemId();
    L12:
        if (r103 == 0) goto L14;
        r101.append("_");
    L14:
        if (r107 != null) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        r101.append("null");
    L23:
        r103 = r105;
        goto L4
    L22:
        r101.append(r107.toString());
        goto L23
    L16:
        if (StringsKt.isBlank(r107) == true) goto L19;
        r108 = false;
        goto L20
    L11:
        r107 = null;
        goto L12
    L25:
        return r101.toString();
    }

    public static final String b(h r100) {
        Iterator<T> r101 = r100.specs.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Spec r102 = (Spec) r101.next();
        Boolean r103 = r102.getCanShowBigPic();
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == true) goto L9;
        if (Intrinsics.areEqual(r102.getCanShowSmallPic(), r104) == false) goto L4;
    L9:
        SpecState r105 = r100.specsState.get(r102.getSpecIndex());
        if (r105 == null) goto L13;
        String r106 = r105.getSelectedSpecItemId();
        if (r106 == null) goto L13;
        return r106;
    L13:
        return "";
    }

    public static final String c(h r100) {
        Spec r101 = (Spec) CollectionsKt.firstOrNull(r100.specs);
        if (r101 == null) goto L22;
        List<SpecItem> r102 = r101.getSpecItemList();
        if (r102 == null) goto L22;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        String r105 = ((SpecItem) r104).getSpecItemId();
        Map<String, SpecState> r106 = r100.specsState;
        Spec r107 = (Spec) CollectionsKt.firstOrNull(r100.specs);
        if (r107 == null) goto L12;
        String r108 = r107.getSpecIndex();
    L13:
        SpecState r109 = r106.get(r108);
        if (r109 == null) goto L16;
        String r110 = r109.getSelectedSpecItemId();
    L18:
        if (Intrinsics.areEqual(r105, r110) == false) goto L8;
    L21:
        SpecItem r111 = (SpecItem) r104;
    L23:
        if (r111 == null) goto L25;
        String r112 = r111.getBigPic();
    L26:
        boolean r113 = true;
        if (r112 != null) goto L29;
    L32:
        boolean r114 = true;
    L33:
        if (r114 == true) goto L36;
        if (r111 != null) goto L53;
        return null;
    L53:
        return r111.getBigPic();
    L36:
        if (r111 == null) goto L38;
        String r115 = r111.getSmallPic();
    L39:
        if (r115 != null) goto L41;
    L44:
        if (r113 == true) goto L47;
        if (r111 != null) goto L55;
        return null;
    L55:
        return r111.getSmallPic();
    L47:
        return "";
    L41:
        if (StringsKt.isBlank(r115) == true) goto L44;
        r113 = false;
        goto L44
    L38:
        r115 = null;
        goto L39
    L29:
        if (StringsKt.isBlank(r112) == true) goto L32;
        r114 = false;
        goto L33
    L25:
        r112 = null;
        goto L26
    L16:
        r110 = null;
        goto L18
    L12:
        r108 = null;
        goto L13
    L20:
        r104 = null;
    L22:
        r111 = null;
        goto L23
    }

    public static final String d(h r110) {
        r110.getClass();
        StringBuilder r100 = new StringBuilder();
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r110.specs.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L31;
        Spec r104 = (Spec) r102.next();
        SpecState r105 = r110.specsState.get(r104.getSpecIndex());
        Object r106 = null;
        if (r105 == null) goto L8;
        String r107 = r105.getSelectedSpecItemId();
    L10:
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L17:
        if (r108 == true) goto L30;
        Iterator<T> r109 = r104.getSpecItemList().iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        Object r111 = r109.next();
        if (Intrinsics.areEqual(((SpecItem) r111).getSpecItemId(), r107) == false) goto L20;
        r106 = r111;
    L24:
        SpecItem r112 = (SpecItem) r106;
        if (r112 == null) goto L28;
        String r113 = r112.getName();
        if (r113 == null) goto L28;
    L29:
        r101.append(" ".concat(r113));
        r103 = true;
    L28:
        r113 = "";
    L30:
        r100.append(" " + r104.getName());
        goto L4
    L12:
        if (StringsKt.isBlank(r107) == true) goto L15;
        r108 = false;
        goto L17
    L8:
        r107 = null;
        goto L10
    L31:
        StringBuilder r114 = new StringBuilder();
        if (r103 == false) goto L34;
        String r115 = "已选择";
    L35:
        r114.append(r115);
        if (r103 == false) goto L38;
        r100 = r101;
    L38:
        r114.append(r100);
        return r114.toString();
    L34:
        r115 = "请选择";
        goto L35
    }

    public static final String e(h r110) {
        r110.getClass();
        StringBuilder r100 = new StringBuilder();
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r110.specs.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L31;
        Spec r104 = (Spec) r102.next();
        SpecState r105 = r110.specsState.get(r104.getSpecIndex());
        Object r106 = null;
        if (r105 == null) goto L8;
        String r107 = r105.getSelectedSpecItemId();
    L10:
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L17:
        if (r108 == true) goto L30;
        Iterator<T> r109 = r104.getSpecItemList().iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        Object r111 = r109.next();
        if (Intrinsics.areEqual(((SpecItem) r111).getSpecItemId(), r107) == false) goto L20;
        r106 = r111;
    L24:
        SpecItem r112 = (SpecItem) r106;
        if (r112 == null) goto L28;
        String r113 = r112.getName();
        if (r113 == null) goto L28;
    L29:
        r101.append(" ".concat(r113));
        r103 = true;
    L28:
        r113 = "";
    L30:
        r100.append(" " + r104.getName());
        goto L4
    L12:
        if (StringsKt.isBlank(r107) == true) goto L15;
        r108 = false;
        goto L17
    L8:
        r107 = null;
        goto L10
    L31:
        StringBuilder r114 = new StringBuilder();
        if (r103 == false) goto L34;
        String r115 = "已选";
    L35:
        r114.append(r115);
        if (r103 == false) goto L38;
        r100 = r101;
    L38:
        r114.append(r100);
        return r114.toString();
    L34:
        r115 = "请选";
        goto L35
    }
}
