package com.baidu.platform.comapi.store;

import com.baidu.mapapi.map.MapLanguage;

/* JADX INFO: loaded from: classes39.dex */
public class MapLanguageRecord extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile MapLanguageRecord f33383a;

    private MapLanguageRecord() {
        super("map_language");
    }

    public static MapLanguageRecord newInstance() {
        if (f33383a == null) goto L7;
        return f33383a;
    L7:
        monitor-enter(MapLanguageRecord.class);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (f33383a == null) goto L13;
        MapLanguageRecord r100 = f33383a;     // Catch: Throwable -> L16
        monitor-exit(MapLanguageRecord.class);     // Catch: Throwable -> L16
        return r100;
    L13:
        f33383a = new MapLanguageRecord();     // Catch: Throwable -> L16
        MapLanguageRecord r101 = f33383a;     // Catch: Throwable -> L16
        monitor-exit(MapLanguageRecord.class);     // Catch: Throwable -> L16
        return r101;
    }

    public MapLanguage getMapLanguage() {
        MapLanguage r100 = MapLanguage.CHINESE;
        int r101 = readInt(r100.ordinal());
        if (r100.ordinal() != r101) goto L5;
        return r100;
    L5:
        MapLanguage r102 = MapLanguage.ENGLISH;
        if (r102.ordinal() != r101) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException();
    }

    public void clearMapLanguage() {
        remove();
    }

    public void setMapLanguage(MapLanguage r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        writeInt(r100.ordinal());
    }
}
