package com.bytedance.android.shopping.slice.action.entity;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/MenuItem;", "Ljava/io/Serializable;", "type", "", SlcCommonAction.KEY_PARAMS, "Lcom/bytedance/android/shopping/slice/action/entity/Fields;", "menuParams", "Lcom/bytedance/android/shopping/slice/action/entity/MenuParams;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/slice/action/entity/Fields;Lcom/bytedance/android/shopping/slice/action/entity/MenuParams;)V", "getFields", "()Lcom/bytedance/android/shopping/slice/action/entity/Fields;", "getMenuParams", "()Lcom/bytedance/android/shopping/slice/action/entity/MenuParams;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MenuItem implements Serializable {

    @SerializedName(SlcCommonAction.KEY_PARAMS)
    private final Fields fields;

    @SerializedName("menu_params")
    private final MenuParams menuParams;

    @SerializedName("type")
    private final String type;

    public MenuItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MenuItem copy$default(MenuItem r100, String r101, Fields r102, MenuParams r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fields;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.menuParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.type;
    }

    public final Fields component2() {
        return this.fields;
    }

    public final MenuParams component3() {
        return this.menuParams;
    }

    public final MenuItem copy(String r100, Fields r101, MenuParams r102) {
        return new MenuItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MenuItem) == false) goto L12;
        MenuItem r101 = (MenuItem) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.menuParams, r101.menuParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Fields r104 = this.fields;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MenuParams r107 = this.menuParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MenuItem(type=" + this.type + ", fields=" + this.fields + ", menuParams=" + this.menuParams + ")";
    }

    public final Fields getFields() {
        return this.fields;
    }

    public final MenuParams getMenuParams() {
        return this.menuParams;
    }

    public final String getType() {
        return this.type;
    }

    public MenuItem(String r100, Fields r101, MenuParams r102) {
        this.type = r100;
        this.fields = r101;
        this.menuParams = r102;
    }

    public /* synthetic */ MenuItem(String r100, Fields r101, MenuParams r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
