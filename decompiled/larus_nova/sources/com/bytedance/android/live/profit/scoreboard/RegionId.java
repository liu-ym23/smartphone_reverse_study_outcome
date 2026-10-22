package com.bytedance.android.live.profit.scoreboard;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/RegionId;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RegionId extends Enum<RegionId> {
    public static final RegionId A = null;
    public static final RegionId B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RegionId[] f88796a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f88797id;

    static {
        RegionId r100 = new RegionId(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A = r100;
        RegionId r101 = new RegionId("B", 1, "B");
        B = r101;
        f88796a = new RegionId[]{r100, r101};
    }

    public static RegionId valueOf(String r100) {
        return (RegionId) r27.a.a(RegionId.class, r100);
    }

    public static RegionId[] values() {
        return (RegionId[]) f88796a.clone();
    }

    public final String getId() {
        return this.f88797id;
    }

    public RegionId(String r100, int r101, String r102) {
        super(r100, r101);
        this.f88797id = r102;
    }
}
