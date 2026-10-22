package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.amap.api.mapcore.util.r2;

/* JADX INFO: loaded from: classes28.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private Marker marker;
    private TextOptions textOptions;

    private void a() {
        this.marker.setIcon(r2.a(this.textOptions));
    }

    public void destroy() {
        this.marker.destroy();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public int getAlignX() {
        return this.textOptions.getAlignX();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getAlignY() {
        return this.textOptions.getAlignY();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getBackgroundColor() {
        return this.textOptions.getBackgroundColor();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getFontColor() {
        return this.textOptions.getFontColor();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getFontSize() {
        return this.textOptions.getFontSize();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public String getId() {
        return this.marker.getId();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Object getObject() {
        return this.marker.getObject();
    }

    public LatLng getPosition() {
        return this.marker.getPosition();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getRotate() {
        return this.marker.getRotateAngle();
    }

    public String getText() {
        return this.textOptions.getText();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Typeface getTypeface() {
        return this.textOptions.getTypeface();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getZIndex() {
        return this.marker.getZIndex();
    }

    public int hashCode() {
        return this.marker.hashCode();
    }

    public boolean isVisible() {
        return this.marker.isVisible();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void remove() {
        this.marker.remove();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public boolean equals(Object r100) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if ((r100 instanceof Text) == true) goto L6;
        return false;
    L6:
        return this.marker.equals(((Text) r100).marker);
    }

    public void setBackgroundColor(int r100) {
        this.textOptions.backgroundColor(r100);     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setFontColor(int r100) {
        this.textOptions.fontColor(r100);     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setFontSize(int r100) {
        this.textOptions.fontSize(r100);     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setObject(Object r100) {
        this.marker.setObject(r100);
    }

    public void setPosition(LatLng r100) {
        this.marker.setPosition(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setRotate(float r100) {
        this.marker.setRotateAngle(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setText(String r100) {
        this.textOptions.text(r100);     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTypeface(Typeface r100) {
        this.textOptions.typeface(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        this.marker.setVisible(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZIndex(float r100) {
        this.marker.setZIndex(r100);
    }

    public Text(Marker r100, TextOptions r101) {
        this.marker = r100;
        this.textOptions = r101;
    }

    public void setAlign(int r100, int r101) {
        this.textOptions.align(r100, r101);     // Catch: Throwable -> L4
        this.marker.setAnchor(r2.a(this.textOptions.getAlignX(), true), r2.a(this.textOptions.getAlignY(), false));     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
