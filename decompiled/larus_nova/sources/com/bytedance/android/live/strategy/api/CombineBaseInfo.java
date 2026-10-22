package com.bytedance.android.live.strategy.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0005HÖ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0014R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "currentStrategyState", "combineInfoId", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/live/strategy/api/CombineBaseInfo;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getCurrentStrategyState", "setCurrentStrategyState", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getCombineInfoId", "()Ljava/lang/String;", "setCombineInfoId", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombineBaseInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("combine_info_id")
    private String combineInfoId;

    @SerializedName("state")
    private Integer currentStrategyState;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineBaseInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CombineBaseInfo copy$default(CombineBaseInfo r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.currentStrategyState;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.combineInfoId;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.currentStrategyState;
    }

    public final String component2() {
        return this.combineInfoId;
    }

    public final CombineBaseInfo copy(Integer r100, String r101) {
        return new CombineBaseInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombineBaseInfo) == false) goto L10;
        CombineBaseInfo r101 = (CombineBaseInfo) r100;
        if (Intrinsics.areEqual(this.currentStrategyState, r101.currentStrategyState) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.combineInfoId, r101.combineInfoId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.currentStrategyState;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.combineInfoId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CombineBaseInfo(currentStrategyState=" + this.currentStrategyState + ", combineInfoId=" + this.combineInfoId + ")";
    }

    public final String getCombineInfoId() {
        return this.combineInfoId;
    }

    public final Integer getCurrentStrategyState() {
        return this.currentStrategyState;
    }

    public final void setCombineInfoId(String r100) {
        this.combineInfoId = r100;
    }

    public final void setCurrentStrategyState(Integer r100) {
        this.currentStrategyState = r100;
    }

    public CombineBaseInfo(Integer r100, String r101) {
        this.currentStrategyState = r100;
        this.combineInfoId = r101;
    }

    public /* synthetic */ CombineBaseInfo(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
