package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveKtvFirstLevelTabConfigData;", "", "modeType", "", "liveKtvFirstLevelTabList", "", "Lcom/bytedance/android/livesdkapi/model/LiveKtvFirstLevelTab;", "(Ljava/lang/String;Ljava/util/List;)V", "getLiveKtvFirstLevelTabList", "()Ljava/util/List;", "getModeType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveKtvFirstLevelTabConfigData {

    @SerializedName("live_ktv_first_level_tab_list")
    private final List<LiveKtvFirstLevelTab> liveKtvFirstLevelTabList;

    @SerializedName("mode_type")
    private final String modeType;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveKtvFirstLevelTabConfigData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveKtvFirstLevelTabConfigData copy$default(LiveKtvFirstLevelTabConfigData r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.modeType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.liveKtvFirstLevelTabList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.modeType;
    }

    public final List<LiveKtvFirstLevelTab> component2() {
        return this.liveKtvFirstLevelTabList;
    }

    public final LiveKtvFirstLevelTabConfigData copy(String r100, List<LiveKtvFirstLevelTab> r101) {
        Intrinsics.checkNotNullParameter(r100, "modeType");
        Intrinsics.checkNotNullParameter(r101, "liveKtvFirstLevelTabList");
        return new LiveKtvFirstLevelTabConfigData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveKtvFirstLevelTabConfigData) == false) goto L10;
        LiveKtvFirstLevelTabConfigData r101 = (LiveKtvFirstLevelTabConfigData) r100;
        if (Intrinsics.areEqual(this.modeType, r101.modeType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveKtvFirstLevelTabList, r101.liveKtvFirstLevelTabList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.modeType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LiveKtvFirstLevelTab> r104 = this.liveKtvFirstLevelTabList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveKtvFirstLevelTabConfigData(modeType=" + this.modeType + ", liveKtvFirstLevelTabList=" + this.liveKtvFirstLevelTabList + ")";
    }

    public final List<LiveKtvFirstLevelTab> getLiveKtvFirstLevelTabList() {
        return this.liveKtvFirstLevelTabList;
    }

    public final String getModeType() {
        return this.modeType;
    }

    public LiveKtvFirstLevelTabConfigData(String r100, List<LiveKtvFirstLevelTab> r101) {
        Intrinsics.checkNotNullParameter(r100, "modeType");
        Intrinsics.checkNotNullParameter(r101, "liveKtvFirstLevelTabList");
        this.modeType = r100;
        this.liveKtvFirstLevelTabList = r101;
    }

    public /* synthetic */ LiveKtvFirstLevelTabConfigData(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = ModeType.UNKNOWN.getValue();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
