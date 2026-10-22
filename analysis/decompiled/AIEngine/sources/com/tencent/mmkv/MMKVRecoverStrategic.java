package com.tencent.mmkv;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MMKVRecoverStrategic {

    /* renamed from: a, reason: collision with root package name */
    public static final MMKVRecoverStrategic f8144a;

    /* renamed from: b, reason: collision with root package name */
    public static final MMKVRecoverStrategic f8145b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ MMKVRecoverStrategic[] f8146c;

    static {
        MMKVRecoverStrategic mMKVRecoverStrategic = new MMKVRecoverStrategic("OnErrorDiscard", 0);
        f8144a = mMKVRecoverStrategic;
        MMKVRecoverStrategic mMKVRecoverStrategic2 = new MMKVRecoverStrategic("OnErrorRecover", 1);
        f8145b = mMKVRecoverStrategic2;
        f8146c = new MMKVRecoverStrategic[]{mMKVRecoverStrategic, mMKVRecoverStrategic2};
    }

    public MMKVRecoverStrategic() {
        throw null;
    }

    public static MMKVRecoverStrategic valueOf(String str) {
        return (MMKVRecoverStrategic) Enum.valueOf(MMKVRecoverStrategic.class, str);
    }

    public static MMKVRecoverStrategic[] values() {
        return (MMKVRecoverStrategic[]) f8146c.clone();
    }
}
