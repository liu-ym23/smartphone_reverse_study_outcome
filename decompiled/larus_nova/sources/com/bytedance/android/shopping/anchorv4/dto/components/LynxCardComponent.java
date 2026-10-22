package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\bHÆ\u0003J<\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "Ljava/io/Serializable;", "data", "", "schema", "height", "", "wrapContent", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getData", "()Ljava/lang/String;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSchema", "getWrapContent", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxCardComponent implements Serializable {

    @SerializedName("data")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String data;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("wrap_content")
    private final boolean wrapContent;

    public LynxCardComponent() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ LynxCardComponent copy$default(LynxCardComponent r100, String r101, String r102, Integer r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.schema;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.wrapContent;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.data;
    }

    public final String component2() {
        return this.schema;
    }

    public final Integer component3() {
        return this.height;
    }

    public final boolean component4() {
        return this.wrapContent;
    }

    public final LynxCardComponent copy(String r100, String r101, Integer r102, boolean r103) {
        return new LynxCardComponent(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxCardComponent) == false) goto L14;
        LynxCardComponent r101 = (LynxCardComponent) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L12;
        return false;
    L12:
        if (this.wrapContent == r101.wrapContent) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.schema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.height;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.wrapContent;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LynxCardComponent(data=" + this.data + ", schema=" + this.schema + ", height=" + this.height + ", wrapContent=" + this.wrapContent + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getWrapContent() {
        return this.wrapContent;
    }

    public LynxCardComponent(String r100, String r101, Integer r102, boolean r103) {
        this.data = r100;
        this.schema = r101;
        this.height = r102;
        this.wrapContent = r103;
    }

    public /* synthetic */ LynxCardComponent(String r100, String r101, Integer r102, boolean r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
