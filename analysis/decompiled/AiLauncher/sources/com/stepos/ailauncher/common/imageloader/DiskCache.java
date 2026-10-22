package com.stepos.ailauncher.common.imageloader;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/common/imageloader/DiskCache;", "", "<init>", "(Ljava/lang/String;I)V", "AUTOMATIC", "ALL", ModelFlowMeta.PLAN_NONE, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DiskCache {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DiskCache[] $VALUES;
    public static final DiskCache AUTOMATIC = new DiskCache("AUTOMATIC", 0);
    public static final DiskCache ALL = new DiskCache("ALL", 1);
    public static final DiskCache NONE = new DiskCache(ModelFlowMeta.PLAN_NONE, 2);

    private static final /* synthetic */ DiskCache[] $values() {
        return new DiskCache[]{AUTOMATIC, ALL, NONE};
    }

    static {
        DiskCache[] diskCacheArr$values = $values();
        $VALUES = diskCacheArr$values;
        $ENTRIES = kotlin.enums.a.a(diskCacheArr$values);
    }

    private DiskCache(String str, int i10) {
    }

    public static InterfaceC4149a<DiskCache> getEntries() {
        return $ENTRIES;
    }

    public static DiskCache valueOf(String str) {
        return (DiskCache) Enum.valueOf(DiskCache.class, str);
    }

    public static DiskCache[] values() {
        return (DiskCache[]) $VALUES.clone();
    }
}
