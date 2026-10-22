package bytedance.util;

/* JADX INFO: loaded from: classes28.dex */
final enum BdMediaType extends Enum<BdMediaType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BdMediaType[] f21733a = null;

    static {
        f21733a = new BdMediaType[0];
    }

    public static BdMediaType[] values() {
        return (BdMediaType[]) f21733a.clone();
    }

    public static BdMediaType valueOf(String r100) {
        return (BdMediaType) r27.a.a(BdMediaType.class, r100);
    }
}
