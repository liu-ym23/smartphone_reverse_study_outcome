package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECSalePointDataV2;", "", "", "Lcom/bytedance/android/ec/model/response/x;", "titles", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/y;", "uiConfig", "Lcom/bytedance/android/ec/model/response/y;", "d", "()Lcom/bytedance/android/ec/model/response/y;", "Lcom/bytedance/android/ec/model/response/s1;", "trackEvents", "c", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointDataV2 {

    @SerializedName("titles")
    private final List<x> titles;

    @SerializedName("track_events")
    private final List<s1> trackEvents;

    @SerializedName("ui_config")
    private final y uiConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSalePointDataV2) == false) goto L12;
        ECSalePointDataV2 r101 = (ECSalePointDataV2) r100;
        if (Intrinsics.areEqual(this.titles, r101.titles) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uiConfig, r101.uiConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.trackEvents, r101.trackEvents) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<x> r100 = this.titles;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        y r104 = this.uiConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<s1> r107 = this.trackEvents;
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
        return "ECSalePointDataV2(titles=" + this.titles + ", uiConfig=" + this.uiConfig + ", trackEvents=" + this.trackEvents + ")";
    }

    public final String a() {
        List<x> r100 = this.titles;
        if (r100 == null) goto L5;
        String r101 = CollectionsKt.joinToString$default(r100, null, null, null, 0, null, ECSalePointDataV2$getContentDescription$1.INSTANCE, 31, null);
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public ECSalePointDataV2() {
        this.titles = null;
        this.uiConfig = null;
        this.trackEvents = null;
    }

    public final List<x> b() {
        return this.titles;
    }

    public final List<s1> c() {
        return this.trackEvents;
    }

    public final y d() {
        return this.uiConfig;
    }
}
