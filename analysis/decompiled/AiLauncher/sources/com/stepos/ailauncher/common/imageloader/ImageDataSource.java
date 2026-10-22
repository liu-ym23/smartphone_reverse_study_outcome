package com.stepos.ailauncher.common.imageloader;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/common/imageloader/ImageDataSource;", "", "<init>", "(Ljava/lang/String;I)V", "MEMORY_CACHE", "RESOURCE_DISK_CACHE", "DATA_DISK_CACHE", "REMOTE", "LOCAL", "UNKNOWN", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageDataSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ImageDataSource[] $VALUES;
    public static final ImageDataSource MEMORY_CACHE = new ImageDataSource("MEMORY_CACHE", 0);
    public static final ImageDataSource RESOURCE_DISK_CACHE = new ImageDataSource("RESOURCE_DISK_CACHE", 1);
    public static final ImageDataSource DATA_DISK_CACHE = new ImageDataSource("DATA_DISK_CACHE", 2);
    public static final ImageDataSource REMOTE = new ImageDataSource("REMOTE", 3);
    public static final ImageDataSource LOCAL = new ImageDataSource("LOCAL", 4);
    public static final ImageDataSource UNKNOWN = new ImageDataSource("UNKNOWN", 5);

    private static final /* synthetic */ ImageDataSource[] $values() {
        return new ImageDataSource[]{MEMORY_CACHE, RESOURCE_DISK_CACHE, DATA_DISK_CACHE, REMOTE, LOCAL, UNKNOWN};
    }

    static {
        ImageDataSource[] imageDataSourceArr$values = $values();
        $VALUES = imageDataSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(imageDataSourceArr$values);
    }

    private ImageDataSource(String str, int i10) {
    }

    public static InterfaceC4149a<ImageDataSource> getEntries() {
        return $ENTRIES;
    }

    public static ImageDataSource valueOf(String str) {
        return (ImageDataSource) Enum.valueOf(ImageDataSource.class, str);
    }

    public static ImageDataSource[] values() {
        return (ImageDataSource[]) $VALUES.clone();
    }
}
