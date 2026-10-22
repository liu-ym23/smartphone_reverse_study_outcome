package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001b\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003J\u001d\u0010\u0006\u001a\u00020\u00002\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/PDPPopoverParam;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/slice/action/entity/MenuItem;", "component1", "menuItems", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getMenuItems", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPPopoverParam implements Serializable {
    public static final a Companion = null;

    @SerializedName("menu_items")
    private final List<MenuItem> menuItems;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PDPPopoverParam() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PDPPopoverParam copy$default(PDPPopoverParam r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.menuItems;
    L6:
        return r100.copy(r101);
    }

    public final List<MenuItem> component1() {
        return this.menuItems;
    }

    public final PDPPopoverParam copy(List<MenuItem> r100) {
        return new PDPPopoverParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PDPPopoverParam) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.menuItems, ((PDPPopoverParam) r100).menuItems) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<MenuItem> r100 = this.menuItems;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "PDPPopoverParam(menuItems=" + this.menuItems + ")";
    }

    public final List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public PDPPopoverParam(List<MenuItem> r100) {
        this.menuItems = r100;
    }

    public /* synthetic */ PDPPopoverParam(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
