package com.amap.api.maps.model.particle;

import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    private Random random;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private float f28687x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private float f28688x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private float f28689y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    private float f28690y2;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private float f28691z1;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    private float f28692z2;

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float r100 = this.random.nextFloat();
        float r101 = this.f28688x2;
        float r102 = this.f28687x1;
        return (r100 * (r101 - r102)) + r102;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float r100 = this.random.nextFloat();
        float r101 = this.f28690y2;
        float r102 = this.f28689y1;
        return (r100 * (r101 - r102)) + r102;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float r100 = this.random.nextFloat();
        float r101 = this.f28692z2;
        float r102 = this.f28691z1;
        return (r100 * (r101 - r102)) + r102;
    }

    public RandomVelocityBetweenTwoConstants(float r100, float r101, float r102, float r103, float r104, float r105) {
        this.f28687x1 = r100;
        this.f28689y1 = r101;
        this.f28691z1 = r102;
        this.f28688x2 = r103;
        this.f28690y2 = r104;
        this.f28692z2 = r105;
        this.random = new Random();
        this.type = 0;
    }
}
