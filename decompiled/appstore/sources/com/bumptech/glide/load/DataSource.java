package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum DataSource extends Enum<DataSource> {
    private static final /* synthetic */ DataSource[] $VALUES = null;
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;

    static {
        DataSource r10 = new DataSource("LOCAL", 0);
        LOCAL = r10;
        DataSource r11 = new DataSource("REMOTE", 1);
        REMOTE = r11;
        DataSource r12 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r12;
        DataSource r13 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r13;
        DataSource r14 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = r14;
        $VALUES = new DataSource[]{r10, r11, r12, r13, r14};
    }

    private DataSource(String r10, int r11) {
        super(r10, r11);
    }

    public static DataSource valueOf(String r10) {
        return (DataSource) Enum.valueOf(DataSource.class, r10);
    }

    public static DataSource[] values() {
        return (DataSource[]) $VALUES.clone();
    }
}
