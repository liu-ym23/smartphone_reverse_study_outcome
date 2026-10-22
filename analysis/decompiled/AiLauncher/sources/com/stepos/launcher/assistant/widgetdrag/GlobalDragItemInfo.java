package com.stepos.launcher.assistant.widgetdrag;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class GlobalDragItemInfo {
    private int dragType = -1;
    private int dragSource = -1;
    private int viewWidth = 0;
    private int viewHeight = 0;
    private float touchPointX = 0.0f;
    private float touchPointY = 0.0f;
    private int viewScreenX = 0;
    private int viewScreenY = 0;
    private Rect visualBound = null;
    private int spanX = 1;
    private int spanY = 1;
    private int minSpanX = 1;
    private int minSpanY = 1;
    private int id = -1;
    private int screenId = -1;
    private int container = -1;
    private int cellX = -1;
    private int cellY = -1;
    private boolean blur = false;
    private float cornerRadius = 0.0f;
    private float dragScale = 1.0f;
    private float initialScale = 1.0f;
    private float originScale = 1.0f;

    public int getCellX() {
        return this.cellX;
    }

    public int getCellY() {
        return this.cellY;
    }

    public int getContainer() {
        return this.container;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getDragScale() {
        return this.dragScale;
    }

    public int getDragSource() {
        return this.dragSource;
    }

    public int getDragType() {
        return this.dragType;
    }

    public int getId() {
        return this.id;
    }

    public float getInitialScale() {
        return this.initialScale;
    }

    public int getMinSpanX() {
        return this.minSpanX;
    }

    public int getMinSpanY() {
        return this.minSpanY;
    }

    public float getOriginScale() {
        return this.originScale;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public int getSpanX() {
        return this.spanX;
    }

    public int getSpanY() {
        return this.spanY;
    }

    public float getTouchPointX() {
        return this.touchPointX;
    }

    public float getTouchPointY() {
        return this.touchPointY;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public int getViewScreenX() {
        return this.viewScreenX;
    }

    public int getViewScreenY() {
        return this.viewScreenY;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    public Rect getVisualBound() {
        return this.visualBound;
    }

    public boolean isBlur() {
        return this.blur;
    }

    public void setBlur(boolean z10) {
        this.blur = z10;
    }

    public void setCellX(int i10) {
        this.cellX = i10;
    }

    public void setCellY(int i10) {
        this.cellY = i10;
    }

    public void setContainer(int i10) {
        this.container = i10;
    }

    public void setCornerRadius(float f10) {
        this.cornerRadius = f10;
    }

    public void setDragScale(float f10) {
        this.dragScale = f10;
    }

    public void setDragSource(int i10) {
        this.dragSource = i10;
    }

    public void setDragType(int i10) {
        this.dragType = i10;
    }

    public void setId(int i10) {
        this.id = i10;
    }

    public void setInitialScale(float f10) {
        this.initialScale = f10;
    }

    public void setMinSpanX(int i10) {
        this.minSpanX = i10;
    }

    public void setMinSpanY(int i10) {
        this.minSpanY = i10;
    }

    public void setOriginScale(float f10) {
        this.originScale = f10;
    }

    public void setScreenId(int i10) {
        this.screenId = i10;
    }

    public void setSpanX(int i10) {
        this.spanX = i10;
    }

    public void setSpanY(int i10) {
        this.spanY = i10;
    }

    public void setTouchPointX(float f10) {
        this.touchPointX = f10;
    }

    public void setTouchPointY(float f10) {
        this.touchPointY = f10;
    }

    public void setViewHeight(int i10) {
        this.viewHeight = i10;
    }

    public void setViewScreenX(int i10) {
        this.viewScreenX = i10;
    }

    public void setViewScreenY(int i10) {
        this.viewScreenY = i10;
    }

    public void setViewWidth(int i10) {
        this.viewWidth = i10;
    }

    public void setVisualBound(Rect rect) {
        this.visualBound = rect;
    }

    public String toString() {
        return "GlobalDragItemInfo{dragType=" + this.dragType + ", dragSource=" + this.dragSource + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", touchPointX=" + this.touchPointX + ", touchPointY=" + this.touchPointY + ", viewScreenX=" + this.viewScreenX + ", viewScreenY=" + this.viewScreenY + ", visualBound=" + this.visualBound + ", spanX=" + this.spanX + ", spanY=" + this.spanY + ", minSpanX=" + this.minSpanX + ", minSpanY=" + this.minSpanY + ", id=" + this.id + ", screenId=" + this.screenId + ", container=" + this.container + ", cellX=" + this.cellX + ", cellY=" + this.cellY + ", blur=" + this.blur + ", cornerRadius=" + this.cornerRadius + ", dragScale=" + this.dragScale + ", initialScale=" + this.initialScale + ", originScale=" + this.originScale + '}';
    }
}
