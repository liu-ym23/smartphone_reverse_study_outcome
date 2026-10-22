package com.bumptech.glide.load;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum DataSource extends Enum<DataSource> implements Serializable {
    private static final /* synthetic */ DataSource[] $VALUES = null;
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;

    static {
        DataSource r100 = new DataSource(AccountType.LOCAL, 0);
        LOCAL = r100;
        DataSource r101 = new DataSource("REMOTE", 1);
        REMOTE = r101;
        DataSource r102 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r102;
        DataSource r103 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r103;
        DataSource r104 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = r104;
        $VALUES = new DataSource[]{r100, r101, r102, r103, r104};
    }

    public static DataSource[] values() {
        return (DataSource[]) $VALUES.clone();
    }

    public static DataSource valueOf(String r100) {
        return (DataSource) a.a(DataSource.class, r100);
    }

    private DataSource(String r100, int r101) {
        super(r100, r101);
    }
}
