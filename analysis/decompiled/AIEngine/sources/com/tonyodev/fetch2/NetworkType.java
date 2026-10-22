package com.tonyodev.fetch2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetworkType {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8173b;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkType f8174c;

    /* renamed from: d, reason: collision with root package name */
    public static final NetworkType f8175d;

    /* renamed from: e, reason: collision with root package name */
    public static final NetworkType f8176e;
    public static final NetworkType h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f8177j;

    /* renamed from: a, reason: collision with root package name */
    public final int f8178a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static NetworkType a(int i10) {
            return i10 != -1 ? i10 != 0 ? i10 != 1 ? i10 != 2 ? NetworkType.f8175d : NetworkType.h : NetworkType.f8176e : NetworkType.f8175d : NetworkType.f8174c;
        }
    }

    static {
        NetworkType networkType = new NetworkType("GLOBAL_OFF", 0, -1);
        f8174c = networkType;
        NetworkType networkType2 = new NetworkType("ALL", 1, 0);
        f8175d = networkType2;
        NetworkType networkType3 = new NetworkType("WIFI_ONLY", 2, 1);
        f8176e = networkType3;
        NetworkType networkType4 = new NetworkType("UNMETERED", 3, 2);
        h = networkType4;
        NetworkType[] networkTypeArr = {networkType, networkType2, networkType3, networkType4};
        f8177j = networkTypeArr;
        kotlin.enums.a.a(networkTypeArr);
        f8173b = new a();
    }

    public NetworkType(String str, int i10, int i11) {
        this.f8178a = i11;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f8177j.clone();
    }
}
