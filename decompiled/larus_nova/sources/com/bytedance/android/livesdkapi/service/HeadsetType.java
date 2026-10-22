package com.bytedance.android.livesdkapi.service;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "", "typeValue", "", "(Ljava/lang/String;II)V", "getTypeValue", "()I", "Null", "UnKnow", "WiredHeadSet", "WiredHeadPhones", "BluetoothSco", "BluetoothA2DP", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HeadsetType extends Enum<HeadsetType> {
    private static final /* synthetic */ HeadsetType[] $VALUES = null;
    public static final HeadsetType BluetoothA2DP = null;
    public static final HeadsetType BluetoothSco = null;
    public static final HeadsetType Null = null;
    public static final HeadsetType UnKnow = null;
    public static final HeadsetType WiredHeadPhones = null;
    public static final HeadsetType WiredHeadSet = null;
    private final int typeValue;

    static {
        HeadsetType r100 = new HeadsetType("Null", 0, -1);
        Null = r100;
        HeadsetType r101 = new HeadsetType("UnKnow", 1, 0);
        UnKnow = r101;
        HeadsetType r102 = new HeadsetType("WiredHeadSet", 2, 1);
        WiredHeadSet = r102;
        HeadsetType r103 = new HeadsetType("WiredHeadPhones", 3, 2);
        WiredHeadPhones = r103;
        HeadsetType r104 = new HeadsetType("BluetoothSco", 4, 3);
        BluetoothSco = r104;
        HeadsetType r105 = new HeadsetType("BluetoothA2DP", 5, 4);
        BluetoothA2DP = r105;
        $VALUES = new HeadsetType[]{r100, r101, r102, r103, r104, r105};
    }

    public static HeadsetType valueOf(String r100) {
        return (HeadsetType) a.a(HeadsetType.class, r100);
    }

    public static HeadsetType[] values() {
        return (HeadsetType[]) $VALUES.clone();
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    private HeadsetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
