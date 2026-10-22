package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/c;", "", "", "ruleIndex", "I", "getRuleIndex", "()I", "setRuleIndex", "(I)V", "", "selectGiftIds", "Ljava/util/List;", "getSelectGiftIds", "()Ljava/util/List;", "setSelectGiftIds", "(Ljava/util/List;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("rule_index")
    private int ruleIndex;

    @SerializedName("select_gift_ids")
    private List<Integer> selectGiftIds;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.ruleIndex == r101.ruleIndex) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.selectGiftIds, r101.selectGiftIds) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.ruleIndex * 31;
        List<Integer> r101 = this.selectGiftIds;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "CounterSetting(ruleIndex=" + this.ruleIndex + ", selectGiftIds=" + this.selectGiftIds + ")";
    }

    public c() {
        List<Integer> r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "selectGiftIds");
        this.ruleIndex = 1;
        this.selectGiftIds = r100;
    }
}
