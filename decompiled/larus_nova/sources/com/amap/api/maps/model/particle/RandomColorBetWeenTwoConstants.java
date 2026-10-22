package com.amap.api.maps.model.particle;

import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f28679a;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private float f28680a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f28681b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private float f28682b1;
    private float[] color;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f28683g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private float f28684g1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f28685r;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private float f28686r1;
    private Random random;

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] r100 = this.color;
        float r101 = this.random.nextFloat();
        float r102 = this.f28686r1;
        float r103 = this.f28685r;
        r100[0] = (r101 * (r102 - r103)) + r103;
        float[] r104 = this.color;
        float r105 = this.random.nextFloat();
        float r106 = this.f28684g1;
        float r107 = this.f28683g;
        r104[1] = (r105 * (r106 - r107)) + r107;
        float[] r108 = this.color;
        float r109 = this.random.nextFloat();
        float r110 = this.f28682b1;
        float r111 = this.f28681b;
        r108[2] = (r109 * (r110 - r111)) + r111;
        float[] r112 = this.color;
        float r113 = this.random.nextFloat();
        float r114 = this.f28680a1;
        float r115 = this.f28679a;
        r112[3] = (r113 * (r114 - r115)) + r115;
        return this.color;
    }

    public RandomColorBetWeenTwoConstants(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107) {
        this.color = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        this.random = new Random();
        this.f28685r = r100 / 255.0f;
        this.f28683g = r101 / 255.0f;
        this.f28681b = r102 / 255.0f;
        this.f28679a = r103 / 255.0f;
        this.f28686r1 = r104 / 255.0f;
        this.f28684g1 = r105 / 255.0f;
        this.f28682b1 = r106 / 255.0f;
        this.f28680a1 = r107 / 255.0f;
        this.type = 0;
    }
}
