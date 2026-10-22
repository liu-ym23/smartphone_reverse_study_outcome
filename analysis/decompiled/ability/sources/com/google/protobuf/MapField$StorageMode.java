package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class MapField$StorageMode {

    /* renamed from: a, reason: collision with root package name */
    public static final MapField$StorageMode f2855a;
    public static final MapField$StorageMode b;
    public static final MapField$StorageMode c;
    public static final /* synthetic */ MapField$StorageMode[] d;

    static {
        MapField$StorageMode mapField$StorageMode = new MapField$StorageMode("MAP", 0);
        f2855a = mapField$StorageMode;
        MapField$StorageMode mapField$StorageMode2 = new MapField$StorageMode("LIST", 1);
        b = mapField$StorageMode2;
        MapField$StorageMode mapField$StorageMode3 = new MapField$StorageMode("BOTH", 2);
        c = mapField$StorageMode3;
        d = new MapField$StorageMode[]{mapField$StorageMode, mapField$StorageMode2, mapField$StorageMode3};
    }

    public static MapField$StorageMode valueOf(String str) {
        return (MapField$StorageMode) Enum.valueOf(MapField$StorageMode.class, str);
    }

    public static MapField$StorageMode[] values() {
        return (MapField$StorageMode[]) d.clone();
    }
}
