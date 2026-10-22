package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/a;", "", "", "", "duration", "Ljava/util/List;", "getDuration", "()Ljava/util/List;", "linkState", "I", "getLinkState", "()I", "", "other_room_id", "J", "getOther_room_id", "()J", "Lcom/bytedance/android/live/profit/scoreboard/n;", "rules", "getRules", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("duration_choices")
    private final List<Integer> duration;

    @SerializedName("link_state")
    private final int linkState;

    @SerializedName("other_room_id")
    private final long other_room_id;

    @SerializedName("rules")
    private final List<n> rules;

    public a() {
        this(null, 0, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L8;
        return false;
    L8:
        if (this.linkState == r101.linkState) goto L10;
        return false;
    L10:
        if (this.other_room_id == r101.other_room_id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.duration;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.linkState) * 31;
        long r104 = this.other_room_id;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        List<n> r106 = this.rules;
        if (r106 == null) goto L10;
        r101 = r106.hashCode();
    L10:
        return r105 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Config(duration=" + this.duration + ", linkState=" + this.linkState + ", other_room_id=" + this.other_room_id + ", rules=" + this.rules + ")";
    }

    public a(List r100, int r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        Intrinsics.checkNotNullParameter(r100, "duration");
        Intrinsics.checkNotNullParameter(r102, "rules");
        this.duration = r100;
        this.linkState = r101;
        this.other_room_id = 0;
        this.rules = r102;
    }
}
