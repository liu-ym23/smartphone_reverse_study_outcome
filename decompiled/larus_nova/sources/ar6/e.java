package ar6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lar6/e;", "", "", "", "commTrackParam", "Ljava/util/Map;", "getCommTrackParam", "()Ljava/util/Map;", "extraTrackParam", "getExtraTrackParam", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("common_track_params")
    private final Map<String, Object> commTrackParam;

    @SerializedName("extra_track_params")
    private final Map<String, Object> extraTrackParam;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.commTrackParam, r101.commTrackParam) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraTrackParam, r101.extraTrackParam) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.commTrackParam;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.extraTrackParam;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "StdTrackInfoVO(commTrackParam=" + this.commTrackParam + ", extraTrackParam=" + this.extraTrackParam + ')';
    }

    public e() {
        this.commTrackParam = null;
        this.extraTrackParam = null;
    }
}
