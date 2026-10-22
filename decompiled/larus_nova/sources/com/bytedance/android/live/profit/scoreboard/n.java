package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/n;", "", "", "index", "I", "getIndex", "()I", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "description", "getDescription", "", "Lcom/bytedance/android/live/profit/scoreboard/g;", "giftChoices", "Ljava/util/List;", "getGiftChoices", "()Ljava/util/List;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n {

    @SerializedName("description")
    private final String description;

    @SerializedName("gift_choices")
    private final List<g> giftChoices;

    @SerializedName("index")
    private final int index;

    @SerializedName("name")
    private final String name;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (this.index == r101.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.giftChoices, r101.giftChoices) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.index * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.description;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<g> r108 = this.giftChoices;
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

    public final String toString() {
        return "Rule(index=" + this.index + ", name=" + this.name + ", description=" + this.description + ", giftChoices=" + this.giftChoices + ")";
    }

    public /* synthetic */ n(int r100) {
        this(0, "", "", CollectionsKt.emptyList());
    }

    public n(int r100, String r101, String r102, List<g> r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r103, "giftChoices");
        this.index = r100;
        this.name = r101;
        this.description = r102;
        this.giftChoices = r103;
    }
}
