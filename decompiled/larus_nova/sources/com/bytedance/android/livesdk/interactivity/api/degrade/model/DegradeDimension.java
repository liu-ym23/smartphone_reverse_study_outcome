package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeDimension;", "", "ROOM", "GLOBAL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeDimension extends Enum<DegradeDimension> {
    public static final DegradeDimension GLOBAL = null;
    public static final DegradeDimension ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DegradeDimension[] f133098a = null;

    static {
        DegradeDimension r100 = new DegradeDimension("ROOM", 0);
        ROOM = r100;
        DegradeDimension r101 = new DegradeDimension("GLOBAL", 1);
        GLOBAL = r101;
        f133098a = new DegradeDimension[]{r100, r101};
    }

    public static DegradeDimension valueOf(String r100) {
        return (DegradeDimension) a.a(DegradeDimension.class, r100);
    }

    public static DegradeDimension[] values() {
        return (DegradeDimension[]) f133098a.clone();
    }

    public DegradeDimension(String r100, int r101) {
        super(r100, r101);
    }
}
