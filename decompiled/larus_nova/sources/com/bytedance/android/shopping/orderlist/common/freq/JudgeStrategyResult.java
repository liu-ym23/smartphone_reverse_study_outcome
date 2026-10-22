package com.bytedance.android.shopping.orderlist.common.freq;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/JudgeStrategyResult;", "Ljava/io/Serializable;", "key", "", "value", "Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JudgeStrategyResult implements Serializable {
    private final String key;
    private final SingleFreqCache value;

    public static /* synthetic */ JudgeStrategyResult copy$default(JudgeStrategyResult r100, String r101, SingleFreqCache r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.value;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.key;
    }

    public final SingleFreqCache component2() {
        return this.value;
    }

    public final JudgeStrategyResult copy(String r100, SingleFreqCache r101) {
        return new JudgeStrategyResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JudgeStrategyResult) == false) goto L10;
        JudgeStrategyResult r101 = (JudgeStrategyResult) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SingleFreqCache r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "JudgeStrategyResult(key=" + this.key + ", value=" + this.value + ")";
    }

    public final String getKey() {
        return this.key;
    }

    public final SingleFreqCache getValue() {
        return this.value;
    }

    public JudgeStrategyResult(String r100, SingleFreqCache r101) {
        this.key = r100;
        this.value = r101;
    }
}
