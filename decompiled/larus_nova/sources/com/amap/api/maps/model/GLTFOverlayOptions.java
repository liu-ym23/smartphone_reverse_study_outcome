package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class GLTFOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final GLTFOverlayOptionsCreator CREATOR = null;
    private int currentAnimationIndex;
    private BitmapDescriptor infoWindowView;
    private boolean isClick;
    private boolean isClickable;
    private boolean isDraggable;
    private boolean isGlbFormat;
    private double mAltitude;
    private LatLng mLatLng;
    private byte[] mModelData;
    private double mScale;
    private List<GLTFResourceIterm> mUriResources;
    private double mXDegree;
    private double mYDegree;
    private double mZDegree;
    private float maxZoom;
    private float minZoom;
    private String title;
    private float zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new GLTFOverlayOptionsCreator();
    }

    public void tapClick() {
        this.isClick = !this.isClick;
    }

    public GLTFOverlayOptions() {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.type = "GLTFOverlayOptions";
    }

    public GLTFOverlayOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        GLTFOverlayOptions r100 = new GLTFOverlayOptions();
        r100.mLatLng = this.mLatLng.clone();
        r100.mZDegree = this.mZDegree;
        r100.mXDegree = this.mXDegree;
        r100.mYDegree = this.mYDegree;
        r100.mAltitude = this.mAltitude;
        r100.mScale = this.mScale;
        r100.mModelData = this.mModelData;
        r100.mUriResources = this.mUriResources;
        r100.isClickable = this.isClickable;
        r100.isDraggable = this.isDraggable;
        BitmapDescriptor r101 = this.infoWindowView;
        if (r101 == null) goto L9;
        r100.infoWindowView = r101.clone();
    L9:
        String r102 = this.title;
        if (r102 == null) goto L12;
        r100.title = r102;
    L12:
        r100.currentAnimationIndex = this.currentAnimationIndex;
        r100.minZoom = this.minZoom;
        r100.maxZoom = this.maxZoom;
        r100.isGlbFormat = this.isGlbFormat;
        r100.zIndex = this.zIndex;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public int getCurrentAnimationIndex() {
        return this.currentAnimationIndex;
    }

    public BitmapDescriptor getInfoWindowView() {
        return this.infoWindowView;
    }

    public LatLng getLatLng() {
        return this.mLatLng;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public byte[] getModelData() {
        return this.mModelData;
    }

    public double getScale() {
        return this.mScale;
    }

    public List<GLTFResourceIterm> getUriResources() {
        return this.mUriResources;
    }

    public double getXDegree() {
        return this.mXDegree;
    }

    public double getYDegree() {
        return this.mYDegree;
    }

    public double getZDegree() {
        return this.mZDegree;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isGlbFormat() {
        return this.isGlbFormat;
    }

    public boolean isInfoWindowShow() {
        return this.isClick;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8024clone() throws CloneNotSupportedException {
        return clone();
    }

    public GLTFOverlayOptions(Parcel r100) {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.mLatLng = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());
        this.mZDegree = r100.readDouble();
        this.mXDegree = r100.readDouble();
        this.mYDegree = r100.readDouble();
        this.mAltitude = r100.readDouble();
        this.mScale = r100.readDouble();
        r100.readByteArray(this.mModelData);
        this.mUriResources = r100.readArrayList(GLTFResourceIterm.class.getClassLoader());
        boolean[] r101 = new boolean[3];
        r100.readBooleanArray(r101);
        this.isClickable = r101[0];
        this.isDraggable = r101[1];
        this.isGlbFormat = r101[2];
        this.infoWindowView = (BitmapDescriptor) r100.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.title = r100.readString();
        this.currentAnimationIndex = r100.readInt();
        this.minZoom = r100.readFloat();
        this.maxZoom = r100.readFloat();
        this.zIndex = r100.readFloat();
    }

    public GLTFOverlayOptions altitude(double r100) {
        this.mAltitude = r100;
        return this;
    }

    public void glbFormat(boolean r100) {
        this.isGlbFormat = r100;
    }

    public void infoWindowView(BitmapDescriptor r100) {
        this.infoWindowView = r100;
    }

    public GLTFOverlayOptions latLng(LatLng r100) {
        this.mLatLng = r100;
        return this;
    }

    public GLTFOverlayOptions modelData(byte[] r100) {
        if (r100 == null) goto L4;
        this.mModelData = r100;
    L4:
        return this;
    }

    public GLTFOverlayOptions scale(double r100) {
        this.mScale = r100;
        return this;
    }

    public void setClickable(boolean r100) {
        this.isClickable = r100;
    }

    public void setCurrentAnimationIndex(int r100) {
        this.currentAnimationIndex = r100;
    }

    public void setDraggable(boolean r100) {
        this.isDraggable = r100;
    }

    public void setZIndex(float r100) {
        this.zIndex = r100;
    }

    public GLTFOverlayOptions uriResources(List<GLTFResourceIterm> r100) {
        this.mUriResources = r100;
        return this;
    }

    public void setZoomRange(float r100, float r101) {
        this.minZoom = r100;
        this.maxZoom = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mLatLng, r101);
        r100.writeDouble(this.mZDegree);
        r100.writeDouble(this.mXDegree);
        r100.writeDouble(this.mYDegree);
        r100.writeDouble(this.mAltitude);
        r100.writeDouble(this.mScale);
        r100.writeByteArray(this.mModelData);
        r100.writeList(this.mUriResources);
        r100.writeBooleanArray(new boolean[]{this.isClickable, this.isDraggable, this.isGlbFormat});
        BitmapDescriptor r102 = this.infoWindowView;
        if (r102 == null) goto L5;
        r100.writeParcelable(r102, r101);
    L5:
        String r103 = this.title;
        if (r103 == null) goto L8;
        r100.writeString(r103);
    L8:
        r100.writeInt(this.currentAnimationIndex);
        r100.writeFloat(this.minZoom);
        r100.writeFloat(this.maxZoom);
        r100.writeFloat(this.zIndex);
    }

    public GLTFOverlayOptions rotationDegree(double r100, double r101, double r102) {
        this.mXDegree = r100;
        this.mYDegree = r101;
        this.mZDegree = r102;
        return this;
    }

    public GLTFOverlayOptions(LatLng r100, double r101, double r102, String r103, List<GLTFResourceIterm> r110) {
        this.mLatLng = new LatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mZDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mXDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mYDegree = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.mLatLng = r100;
        this.mAltitude = r101;
        this.mScale = r102;
        if (r103 == null) goto L5;
        this.mModelData = r103.getBytes();
    L6:
        this.mUriResources = r110;
        return;
    L5:
        this.mModelData = "".getBytes();
        goto L6
    }
}
