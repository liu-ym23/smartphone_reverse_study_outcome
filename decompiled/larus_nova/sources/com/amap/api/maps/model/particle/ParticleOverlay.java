package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;

    public int getCurrentParticleNum() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getCurrentParticleNum(this.overlayName);
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) == true) goto L7;
        if (r100 == null) goto L8;
        r100.updateOption(this.overlayName, this.options);
        return;
    L8:
        return;
    }

    public void destroy() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setDuration(long r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setDuration(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLoop(boolean r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setLoop(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMaxParticles(int r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setMaxParticles(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setParticleEmission(ParticleEmissionModule r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleEmissionModule(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setParticleLifeTime(long r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleLifeTime(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleOverLifeModule(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setParticleShapeModule(ParticleShapeModule r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleShapeModule(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setParticleStartSpeed(VelocityGenerate r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleStartSpeed(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStartColor(ColorGenerate r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setParticleStartColor(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        ParticleOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setVisible(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStartParticleSize(int r100, int r101) {
        ParticleOverlayOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.setStartParticleSize(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public ParticleOverlay(IGlOverlayLayer r100, ParticleOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
