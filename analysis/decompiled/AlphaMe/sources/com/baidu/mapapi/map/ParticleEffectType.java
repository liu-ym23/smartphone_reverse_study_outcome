package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public enum ParticleEffectType {
    UnKnow(-1),
    Snow(0),
    RainStorm(4),
    Smog(5),
    SandStorm(7),
    Fireworks(8),
    Flower(14);


    /* renamed from: b, reason: collision with root package name */
    private int f6726b;

    ParticleEffectType(int i4) {
        this.f6726b = i4;
    }

    public int getType() {
        return this.f6726b;
    }
}
