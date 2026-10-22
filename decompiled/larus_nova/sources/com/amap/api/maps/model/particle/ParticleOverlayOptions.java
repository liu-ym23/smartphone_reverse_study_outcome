package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;

/* JADX INFO: loaded from: classes28.dex */
public class ParticleOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ParticleOverlayOptions> CREATOR = null;
    private BitmapDescriptor bitmapDescriptor;
    private long duration;
    private boolean isParticleEmissionModuleUpdate;
    private boolean isParticleOverLifeModuleUpdate;
    private boolean isParticleShapeModuleUpdate;
    private boolean isStartColorUpdate;
    private boolean isStartSpeedUpdate;
    private boolean loop;
    private int maxParticles;
    private ParticleEmissionModule particleEmissionModule;
    private long particleLifeTime;
    private ParticleOverLifeModule particleOverLifeModule;
    private ParticleShapeModule particleShapeModule;
    private Object particleShapeModuleObject;
    private ColorGenerate startColor;
    private Object startColorObject;
    private int startParticleH;
    private int startParticleW;
    private VelocityGenerate startSpeed;
    private Object startSpeedObject;
    private boolean visibile;
    private float zIndex;

    public static class a implements Parcelable.Creator<ParticleOverlayOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public ParticleOverlayOptions createFromParcel(Parcel r100) {
            return new ParticleOverlayOptions(r100);
        }

        @Override // android.os.Parcelable.Creator
        public ParticleOverlayOptions[] newArray(int r100) {
            return new ParticleOverlayOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParticleOverlayOptions() {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = 5000;
        this.particleLifeTime = 5000;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.type = "ParticleOptions";
    }

    public long getDuration() {
        return this.duration;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public int getMaxParticles() {
        return this.maxParticles;
    }

    public ParticleEmissionModule getParticleEmissionModule() {
        return this.particleEmissionModule;
    }

    public long getParticleLifeTime() {
        return this.particleLifeTime;
    }

    public ParticleOverLifeModule getParticleOverLifeModule() {
        return this.particleOverLifeModule;
    }

    public ParticleShapeModule getParticleShapeModule() {
        return this.particleShapeModule;
    }

    public ColorGenerate getParticleStartColor() {
        return this.startColor;
    }

    public VelocityGenerate getParticleStartSpeed() {
        return this.startSpeed;
    }

    public int getStartParticleW() {
        return this.startParticleW;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public int getstartParticleH() {
        return this.startParticleH;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public ParticleOverlayOptions(Parcel r100) {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        boolean r101 = true;
        this.loop = true;
        this.duration = 5000;
        this.particleLifeTime = 5000;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.bitmapDescriptor = (BitmapDescriptor) r100.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.zIndex = r100.readFloat();
        this.maxParticles = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.loop = r102;
        this.duration = r100.readLong();
        this.particleLifeTime = r100.readLong();
        this.startParticleW = r100.readInt();
        this.startParticleH = r100.readInt();
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.visibile = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public ParticleOverlayOptions icon(BitmapDescriptor r100) {
        this.bitmapDescriptor = r100;     // Catch: Throwable -> L4
    L6:
        return this;
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L6
    }

    public ParticleOverlayOptions setDuration(long r100) {
        this.duration = r100;
        return this;
    }

    public ParticleOverlayOptions setLoop(boolean r100) {
        this.loop = r100;
        return this;
    }

    public ParticleOverlayOptions setMaxParticles(int r100) {
        this.maxParticles = r100;
        return this;
    }

    public ParticleOverlayOptions setParticleEmissionModule(ParticleEmissionModule r100) {
        this.particleEmissionModule = r100;
        this.isParticleEmissionModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleLifeTime(long r100) {
        this.particleLifeTime = r100;
        return this;
    }

    public ParticleOverlayOptions setParticleOverLifeModule(ParticleOverLifeModule r100) {
        this.particleOverLifeModule = r100;
        this.isParticleOverLifeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleShapeModule(ParticleShapeModule r100) {
        this.particleShapeModule = r100;
        this.particleShapeModuleObject = r100;
        this.isParticleShapeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartColor(ColorGenerate r100) {
        this.startColor = r100;
        this.startColorObject = r100;
        this.isStartColorUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartSpeed(VelocityGenerate r100) {
        this.startSpeed = r100;
        this.startSpeedObject = r100;
        this.isStartSpeedUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setVisible(boolean r100) {
        this.visibile = r100;
        return this;
    }

    public ParticleOverlayOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }

    public ParticleOverlayOptions setStartParticleSize(int r100, int r101) {
        this.startParticleW = r100;
        this.startParticleH = r101;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.bitmapDescriptor, r101);
        r100.writeFloat(this.zIndex);
        r100.writeInt(this.maxParticles);
        r100.writeByte(this.loop ? 1 : 0);
        r100.writeLong(this.duration);
        r100.writeLong(this.particleLifeTime);
        r100.writeInt(this.startParticleW);
        r100.writeInt(this.startParticleH);
        r100.writeByte(this.visibile ? 1 : 0);
    }
}
