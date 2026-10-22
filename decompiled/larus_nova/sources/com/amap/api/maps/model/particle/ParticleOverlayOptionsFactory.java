package com.amap.api.maps.model.particle;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class ParticleOverlayOptionsFactory {
    public static final int PARTICLE_TYPE_HAZE = 3;
    public static final int PARTICLE_TYPE_RAIN = 1;
    public static final int PARTICLE_TYPE_SNOWY = 2;
    public static final int PARTICLE_TYPE_SUNNY = 0;

    public ParticleOverlayOptionsFactory() {
    }

    public static List<ParticleOverlayOptions> defaultOptions(int r210) {
        ArrayList r100 = new ArrayList();
        if (r210 != 0) goto L5;
        ArrayList r101 = new ArrayList();
        ParticleOverlayOptions r102 = new ParticleOverlayOptions();
        r102.setMaxParticles(1);
        r102.setDuration(10000);
        int r103 = (int) 2500;
        r102.setParticleEmissionModule(new ParticleEmissionModule(1, r103));
        r102.setLoop(true);
        r102.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        r102.setParticleLifeTime(10000);
        r102.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        r102.setParticleOverLifeModule(new ParticleOverLifeModule());
        r102.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
        r102.setStartParticleSize(1000, 1000);
        r101.add(r102);
        ParticleOverlayOptions r104 = new ParticleOverlayOptions();
        r104.setMaxParticles(1);
        r104.setDuration(10000);
        r104.setParticleEmissionModule(new ParticleEmissionModule(1, r103));
        r104.setLoop(true);
        r104.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        r104.setParticleLifeTime(10000);
        r104.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        ParticleOverLifeModule r105 = new ParticleOverLifeModule();
        r105.setRotateOverLife(new ConstantRotationOverLife(45.0f));
        r104.setParticleOverLifeModule(r105);
        r104.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
        r104.setStartParticleSize(1000, 1000);
        r101.add(r104);
        r100.addAll(r101);
    L26:
        return r100;
    L5:
        if (r210 == 1) goto L21;
        if (r210 != 2) goto L8;
        ParticleOverlayOptions r106 = new ParticleOverlayOptions();
        r106.setMaxParticles(1000);
        r106.setDuration(5000);
        r106.setParticleEmissionModule(new ParticleEmissionModule(20, 1000));
        r106.setLoop(true);
        r106.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        r106.setParticleLifeTime(10000);
        r106.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-50.0f, 100.0f, 0.0f, 50.0f, 200.0f, 0.0f));
        BitmapDescriptor r107 = BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
        if (r107 == null) goto L20;
        r106.icon(r107);
        r106.setStartParticleSize(r107.getWidth(), r107.getHeight());
    L20:
        r100.add(r106);
        goto L26
    L8:
        if (r210 != 3) goto L26;
        ArrayList r108 = new ArrayList();
        ParticleOverlayOptions r109 = new ParticleOverlayOptions();
        r109.setLoop(false);
        r109.setMaxParticles(1);
        r109.setDuration(10000);
        r109.setParticleEmissionModule(new ParticleEmissionModule(1, (int) 10000));
        r109.setParticleShapeModule(new SinglePointParticleShape(0.5f, 0.5f, 0.0f, true));
        r109.setParticleLifeTime(10000);
        r109.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-10.0f, -0.0f, -0.0f, -20.0f, 0.0f, 0.0f));
        BitmapDescriptor r110 = BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
        if (r110 == null) goto L13;
        r109.icon(r110);
        r109.setStartParticleSize(r110.getWidth() * 5, r110.getWidth() * 5);
    L13:
        r108.add(r109);
        ParticleOverlayOptions r111 = new ParticleOverlayOptions();
        r111.setMaxParticles(1000);
        r111.setDuration(10000);
        r111.setParticleEmissionModule(new ParticleEmissionModule(30, (int) 2500));
        r111.setLoop(true);
        r111.setParticleShapeModule(new RectParticleShape(0.5f, 0.5f, 1.0f, 1.0f, true));
        r111.setParticleLifeTime(10000);
        r111.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-100.0f, -100.0f, -1.0f, -200.0f, 100.0f, 1.0f));
        BitmapDescriptor r112 = BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
        if (r112 == null) goto L16;
        r111.icon(r112);
        r111.setStartParticleSize(r112.getWidth(), r112.getHeight());
    L16:
        r111.setParticleStartColor(new RandomColorBetWeenTwoConstants(255.0f, 255.0f, 255.0f, 102.0f, 255.0f, 255.0f, 255.0f, 255.0f));
        r108.add(r111);
        r100.addAll(r108);
        goto L26
    L21:
        ParticleOverlayOptions r113 = new ParticleOverlayOptions();
        r113.setMaxParticles(1000);
        r113.setDuration(5000);
        r113.setParticleEmissionModule(new ParticleEmissionModule(100, 1000));
        r113.setLoop(true);
        r113.setParticleLifeTime(5000);
        r113.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(10.0f, 1000.0f, 0.0f, 100.0f, 1000.0f, 0.0f));
        r113.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        BitmapDescriptor r114 = BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
        if (r114 == null) goto L24;
        r113.icon(r114);
        r113.setStartParticleSize(r114.getWidth() * 2, r114.getHeight() * 2);
    L24:
        r100.add(r113);
        goto L26
    }
}
