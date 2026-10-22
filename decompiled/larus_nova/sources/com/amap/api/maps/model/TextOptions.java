package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: loaded from: classes28.dex */
public final class TextOptions implements Parcelable, Cloneable {
    public static final TextOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28664a;
    private int alignX;
    private int alignY;
    private int backgroundColor;
    private int fontColor;
    private int fontSize;
    private boolean isVisible;
    private Object object;
    private LatLng position;
    private float rotate;
    private String text;
    private Typeface typeface;
    private float zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new TextOptionsCreator();
    }

    public TextOptions() {
        this.typeface = Typeface.DEFAULT;
        this.alignX = 4;
        this.alignY = 32;
        this.backgroundColor = -1;
        this.fontColor = -16777216;
        this.fontSize = 20;
        this.zIndex = 0.0f;
        this.isVisible = true;
    }

    public TextOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        TextOptions r100 = new TextOptions();
        r100.f28664a = this.f28664a;
        r100.position = this.position;
        r100.text = this.text;
        r100.typeface = this.typeface;
        r100.rotate = this.rotate;
        r100.alignX = this.alignX;
        r100.alignY = this.alignY;
        r100.backgroundColor = this.backgroundColor;
        r100.fontColor = this.fontColor;
        r100.object = this.object;
        r100.fontSize = this.fontSize;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public int getAlignX() {
        return this.alignX;
    }

    public int getAlignY() {
        return this.alignY;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public Object getObject() {
        return this.object;
    }

    public LatLng getPosition() {
        return this.position;
    }

    public float getRotate() {
        return this.rotate;
    }

    public String getText() {
        return this.text;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8031clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextOptions backgroundColor(int r100) {
        this.backgroundColor = r100;
        return this;
    }

    public TextOptions fontColor(int r100) {
        this.fontColor = r100;
        return this;
    }

    public TextOptions fontSize(int r100) {
        this.fontSize = r100;
        return this;
    }

    public TextOptions position(LatLng r100) {
        this.position = r100;
        return this;
    }

    public TextOptions rotate(float r100) {
        this.rotate = r100;
        return this;
    }

    public TextOptions setObject(Object r100) {
        this.object = r100;
        return this;
    }

    public TextOptions text(String r100) {
        this.text = r100;
        return this;
    }

    public TextOptions typeface(Typeface r100) {
        if (r100 == null) goto L4;
        this.typeface = r100;
    L4:
        return this;
    }

    public TextOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public TextOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }

    public TextOptions align(int r100, int r101) {
        this.alignX = r100;
        this.alignY = r101;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28664a);
        Bundle r102 = new Bundle();
        LatLng r103 = this.position;
        if (r103 == null) goto L5;
        r102.putDouble("lat", r103.latitude);
        r102.putDouble("lng", this.position.longitude);
    L5:
        r100.writeBundle(r102);
        r100.writeString(this.text);
        r100.writeInt(this.typeface.getStyle());
        r100.writeFloat(this.rotate);
        r100.writeInt(this.alignX);
        r100.writeInt(this.alignY);
        r100.writeInt(this.backgroundColor);
        r100.writeInt(this.fontColor);
        r100.writeInt(this.fontSize);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        if ((this.object instanceof Parcelable) == false) goto L9;
        Bundle r104 = new Bundle();
        r104.putParcelable(MapBundleKey.MapObjKey.OBJ_SL_OBJ, (Parcelable) this.object);
        r100.writeBundle(r104);
        return;
    }
}
