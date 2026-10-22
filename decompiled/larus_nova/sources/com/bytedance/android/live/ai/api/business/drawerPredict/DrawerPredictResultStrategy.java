package com.bytedance.android.live.ai.api.business.drawerPredict;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJN\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ai/api/business/drawerPredict/DrawerPredictResultStrategy;", "", "type", "", "value", "", "rangeSec", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "predictAction", "(ILjava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/Integer;)V", "getPredictAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRangeSec", "()Ljava/util/ArrayList;", "getType", "()I", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/Integer;)Lcom/bytedance/android/live/ai/api/business/drawerPredict/DrawerPredictResultStrategy;", "equals", "other", "hashCode", "toString", "", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerPredictResultStrategy {

    @SerializedName("predict_action")
    private final Integer predictAction;

    @SerializedName("range_sec")
    private final ArrayList<Float> rangeSec;

    @SerializedName("type")
    private final int type;

    @SerializedName("value")
    private final Boolean value;

    public DrawerPredictResultStrategy() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrawerPredictResultStrategy copy$default(DrawerPredictResultStrategy r100, int r101, Boolean r102, ArrayList r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.value;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rangeSec;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.predictAction;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.type;
    }

    public final Boolean component2() {
        return this.value;
    }

    public final ArrayList<Float> component3() {
        return this.rangeSec;
    }

    public final Integer component4() {
        return this.predictAction;
    }

    public final DrawerPredictResultStrategy copy(int r100, Boolean r101, ArrayList<Float> r102, Integer r103) {
        return new DrawerPredictResultStrategy(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DrawerPredictResultStrategy) == false) goto L14;
        DrawerPredictResultStrategy r101 = (DrawerPredictResultStrategy) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rangeSec, r101.rangeSec) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.predictAction, r101.predictAction) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        Boolean r101 = this.value;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ArrayList<Float> r105 = this.rangeSec;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.predictAction;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "DrawerPredictResultStrategy(type=" + this.type + ", value=" + this.value + ", rangeSec=" + this.rangeSec + ", predictAction=" + this.predictAction + ")";
    }

    public final Integer getPredictAction() {
        return this.predictAction;
    }

    public final ArrayList<Float> getRangeSec() {
        return this.rangeSec;
    }

    public final int getType() {
        return this.type;
    }

    public final Boolean getValue() {
        return this.value;
    }

    public DrawerPredictResultStrategy(int r100, Boolean r101, ArrayList<Float> r102, Integer r103) {
        this.type = r100;
        this.value = r101;
        this.rangeSec = r102;
        this.predictAction = r103;
    }

    public /* synthetic */ DrawerPredictResultStrategy(int r100, Boolean r101, ArrayList r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
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
