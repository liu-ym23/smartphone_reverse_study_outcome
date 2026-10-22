package com.bytedance.android.shopping.api.image;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/image/c;", "", "", "value", "Ljava/lang/Double;", "getValue", "()Ljava/lang/Double;", "", "values", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "", WikiFolderPushPlugin.OPT, "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(WikiFolderPushPlugin.OPT)
    private final String operation;

    @SerializedName("value")
    private final Double value;

    @SerializedName("range_values")
    private final List<Double> values;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.values, r101.values) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.operation, r101.operation) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Double r100 = this.value;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Double> r104 = this.values;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.operation;
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

    public final String toString() {
        return "ECImageUrlDoubleMatcher(value=" + this.value + ", values=" + this.values + ", operation=" + this.operation + ")";
    }

    public c() {
        this.value = null;
        this.values = null;
        this.operation = null;
    }

    public final boolean a(Double r100) {
        if (r100 == null) goto L60;
        String r101 = this.operation;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (this.values == null) goto L19;
        if (Intrinsics.areEqual(r101, FilterData.FilterOptionItem.Type.RANGE) == false) goto L19;
        if (this.values.size() < 2) goto L19;
        double r102 = r100.doubleValue();
        Object r103 = CollectionsKt.getOrNull(this.values, 0);
        Intrinsics.checkNotNull(r103);
        if (r102 < ((Number) r103).doubleValue()) goto L58;
        double r104 = r100.doubleValue();
        Object r105 = CollectionsKt.getOrNull(this.values, 1);
        Intrinsics.checkNotNull(r105);
        if (r104 > ((Number) r105).doubleValue()) goto L59;
        return true;
    L59:
        return false;
    L58:
        return false;
    L19:
        if (this.value == null) goto L62;
        String r106 = this.operation;
        if (r106 == null) goto L73;
        int r107 = r106.hashCode();
        if (r107 == 60) goto L53;
        if (r107 == 62) goto L48;
        if (r107 == 1921) goto L43;
        if (r107 == 1952) goto L40;
        if (r107 == 1983) goto L35;
        return false;
    L35:
        if (r106.equals(">=") == true) goto L37;
        return false;
    L37:
        if (r100.doubleValue() < this.value.doubleValue()) goto L64;
    L56:
        return true;
    L64:
        return false;
    L40:
        if (r106.equals("==") == true) goto L66;
        return false;
    L66:
        return Intrinsics.areEqual(r100, this.value);
    L43:
        if (r106.equals("<=") == true) goto L45;
        return false;
    L45:
        if (r100.doubleValue() <= this.value.doubleValue()) goto L56;
        return false;
    L48:
        if (r106.equals(">") == true) goto L50;
        return false;
    L50:
        if (r100.doubleValue() > this.value.doubleValue()) goto L56;
        return false;
    L53:
        if (r106.equals("<") == true) goto L55;
        return false;
    L55:
        if (r100.doubleValue() < this.value.doubleValue()) goto L56;
        return false;
    L73:
        return false;
    L62:
        return false;
    L60:
        return false;
    }
}
