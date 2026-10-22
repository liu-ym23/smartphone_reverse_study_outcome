package com.stepos.activeview.graphicsanim.renderable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class Renderable {
    public static final String ATTR_CLASS_NAME = "className";
    public static final String ATTR_ID = "id";
    public static final String ATTR_SCALE_X = "scaleX";
    public static final String ATTR_SCALE_Y = "scaleY";
    public static final String ATTR_TRANSLATION_X = "translationX";
    public static final String ATTR_TRANSLATION_Y = "translationY";
    public static final String ATTR_X = "x";
    public static final String ATTR_Y = "y";
    public static String CLASS_NAME = "Renderable";
    protected Bitmap mBitmap;
    protected String mID;
    protected float mScaleX = 1.0f;
    protected float mScaleY = 1.0f;
    protected float mTranslationX;
    protected float mTranslationY;
    protected float mX;
    protected float mY;

    public Renderable(Bundle bundle) {
        init();
        updateAttributes(bundle);
    }

    public void destroy() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.mBitmap.recycle();
        this.mBitmap = null;
    }

    public void draw(Canvas canvas) {
    }

    public String getID() {
        return this.mID;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public void init() {
        this.mX = Property.DEFAULT_FLOAT_VALUE;
        this.mY = Property.DEFAULT_FLOAT_VALUE;
    }

    public void pause() {
    }

    public String printArray(String str, float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 10; i4++) {
            sb.append(fArr[i4]);
            sb.append(", ");
        }
        return sb.toString();
    }

    public void resume() {
    }

    public void setID(String str) {
        this.mID = str;
    }

    public void setScale(float f4, float f5) {
        this.mScaleX = f4;
        this.mScaleY = f5;
    }

    public void setTranslationX(float f4) {
        this.mTranslationX = f4;
    }

    public void setTranslationY(Float f4) {
        this.mTranslationY = f4.floatValue();
    }

    public void setX(float f4) {
        this.mX = f4;
    }

    public void setY(float f4) {
        this.mY = f4;
    }

    public void update(float f4) {
    }

    public void updateAttributes(Bundle bundle) {
        if (bundle != null) {
            this.mID = bundle.getString("id", this.mID);
            this.mX = bundle.getFloat("x", this.mX);
            this.mY = bundle.getFloat("y", this.mY);
        }
    }

    public void setTranslationY(float f4) {
        this.mTranslationY = f4;
    }

    @Deprecated
    public void update(float f4, float f5) {
    }

    public Renderable(Bitmap bitmap, float f4, float f5) {
    }
}
