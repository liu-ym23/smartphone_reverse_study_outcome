package com.stepos.datacenter.entity;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/entity/DataType;", "", "<init>", "(Ljava/lang/String;I)V", "STRUCTURED", "VECTOR", "FILE", "TEXT", "IMAGE", "AUDIO", "VIDEO", "TIME_SERIES", "GRAPH", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DataType[] $VALUES;
    public static final DataType STRUCTURED = new DataType("STRUCTURED", 0);
    public static final DataType VECTOR = new DataType("VECTOR", 1);
    public static final DataType FILE = new DataType("FILE", 2);
    public static final DataType TEXT = new DataType("TEXT", 3);
    public static final DataType IMAGE = new DataType("IMAGE", 4);
    public static final DataType AUDIO = new DataType("AUDIO", 5);
    public static final DataType VIDEO = new DataType("VIDEO", 6);
    public static final DataType TIME_SERIES = new DataType("TIME_SERIES", 7);
    public static final DataType GRAPH = new DataType("GRAPH", 8);

    private static final /* synthetic */ DataType[] $values() {
        return new DataType[]{STRUCTURED, VECTOR, FILE, TEXT, IMAGE, AUDIO, VIDEO, TIME_SERIES, GRAPH};
    }

    static {
        DataType[] dataTypeArr$values = $values();
        $VALUES = dataTypeArr$values;
        $ENTRIES = a.a(dataTypeArr$values);
    }

    private DataType(String str, int i10) {
    }

    public static InterfaceC4149a<DataType> getEntries() {
        return $ENTRIES;
    }

    public static DataType valueOf(String str) {
        return (DataType) Enum.valueOf(DataType.class, str);
    }

    public static DataType[] values() {
        return (DataType[]) $VALUES.clone();
    }
}
