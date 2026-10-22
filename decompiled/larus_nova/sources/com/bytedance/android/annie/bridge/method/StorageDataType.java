package com.bytedance.android.annie.bridge.method;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageDataType;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Number", "Int", "String", "Map", "List", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum StorageDataType extends Enum<StorageDataType> {
    private static final /* synthetic */ StorageDataType[] $VALUES = null;
    public static final StorageDataType Boolean = null;
    public static final StorageDataType Int = null;
    public static final StorageDataType List = null;
    public static final StorageDataType Map = null;
    public static final StorageDataType Null = null;
    public static final StorageDataType Number = null;
    public static final StorageDataType String = null;

    private static final /* synthetic */ StorageDataType[] $values() {
        return new StorageDataType[]{Null, Boolean, Number, Int, String, Map, List};
    }

    public static StorageDataType valueOf(String r100) {
        return (StorageDataType) r27.a.a(StorageDataType.class, r100);
    }

    public static StorageDataType[] values() {
        return (StorageDataType[]) $VALUES.clone();
    }

    static {
        Null = new StorageDataType("Null", 0);
        Boolean = new StorageDataType("Boolean", 1);
        Number = new StorageDataType("Number", 2);
        Int = new StorageDataType("Int", 3);
        String = new StorageDataType("String", 4);
        Map = new StorageDataType("Map", 5);
        List = new StorageDataType("List", 6);
        $VALUES = $values();
    }

    private StorageDataType(String r100, int r101) {
        super(r100, r101);
    }
}
