package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportData;", "", "map", "", "", "dc", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "(Ljava/util/Map;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "getDc", "getMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "getReportMap", "hashCode", "", "toString", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewReportData {
    private DataCenter dataCenter;

    /* JADX INFO: renamed from: dc, reason: collision with root package name */
    private final DataCenter f162652dc;
    private final Map<String, String> map;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewReportData copy$default(PreviewReportData r100, Map r101, DataCenter r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.map;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f162652dc;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.map;
    }

    public final DataCenter component2() {
        return this.f162652dc;
    }

    public final PreviewReportData copy(Map<String, String> r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        return new PreviewReportData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreviewReportData) == false) goto L10;
        PreviewReportData r101 = (PreviewReportData) r100;
        if (Intrinsics.areEqual(this.map, r101.map) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f162652dc, r101.f162652dc) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Map<String, String> r100 = this.map;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DataCenter r104 = this.f162652dc;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PreviewReportData(map=" + this.map + ", dc=" + this.f162652dc + ")";
    }

    public final Map<String, String> getReportMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.map);
        return r100;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final DataCenter getDc() {
        return this.f162652dc;
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public final void setDataCenter(DataCenter r100) {
        this.dataCenter = r100;
    }

    public PreviewReportData(Map<String, String> r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.map = r100;
        this.f162652dc = r101;
    }

    public /* synthetic */ PreviewReportData(Map r100, DataCenter r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
