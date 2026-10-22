package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetworkType {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkType f2783a;

    /* renamed from: b, reason: collision with root package name */
    public static final NetworkType f2784b;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkType f2785c;

    /* renamed from: d, reason: collision with root package name */
    public static final NetworkType f2786d;

    /* renamed from: e, reason: collision with root package name */
    public static final NetworkType f2787e;
    public static final NetworkType h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f2788j;

    static {
        NetworkType networkType = new NetworkType("NOT_REQUIRED", 0);
        f2783a = networkType;
        NetworkType networkType2 = new NetworkType("CONNECTED", 1);
        f2784b = networkType2;
        NetworkType networkType3 = new NetworkType("UNMETERED", 2);
        f2785c = networkType3;
        NetworkType networkType4 = new NetworkType("NOT_ROAMING", 3);
        f2786d = networkType4;
        NetworkType networkType5 = new NetworkType("METERED", 4);
        f2787e = networkType5;
        NetworkType networkType6 = new NetworkType("TEMPORARILY_UNMETERED", 5);
        h = networkType6;
        f2788j = new NetworkType[]{networkType, networkType2, networkType3, networkType4, networkType5, networkType6};
    }

    public NetworkType() {
        throw null;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f2788j.clone();
    }
}
