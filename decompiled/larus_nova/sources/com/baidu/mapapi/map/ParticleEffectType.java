package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum ParticleEffectType extends Enum<ParticleEffectType> {
    public static final ParticleEffectType Fireworks = null;
    public static final ParticleEffectType Flower = null;
    public static final ParticleEffectType RainStorm = null;
    public static final ParticleEffectType SandStorm = null;
    public static final ParticleEffectType Smog = null;
    public static final ParticleEffectType Snow = null;
    public static final ParticleEffectType UnKnow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ ParticleEffectType[] f31209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31210b;

    static {
        ParticleEffectType r100 = new ParticleEffectType("UnKnow", 0, -1);
        UnKnow = r100;
        ParticleEffectType r101 = new ParticleEffectType("Snow", 1, 0);
        Snow = r101;
        ParticleEffectType r102 = new ParticleEffectType("RainStorm", 2, 4);
        RainStorm = r102;
        ParticleEffectType r103 = new ParticleEffectType("Smog", 3, 5);
        Smog = r103;
        ParticleEffectType r104 = new ParticleEffectType("SandStorm", 4, 7);
        SandStorm = r104;
        ParticleEffectType r110 = new ParticleEffectType("Fireworks", 5, 8);
        Fireworks = r110;
        ParticleEffectType r111 = new ParticleEffectType("Flower", 6, 14);
        Flower = r111;
        f31209a = new ParticleEffectType[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static ParticleEffectType[] values() {
        return (ParticleEffectType[]) f31209a.clone();
    }

    public int getType() {
        return this.f31210b;
    }

    public static ParticleEffectType valueOf(String r100) {
        return (ParticleEffectType) r27.a.a(ParticleEffectType.class, r100);
    }

    private ParticleEffectType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f31210b = r102;
    }
}
