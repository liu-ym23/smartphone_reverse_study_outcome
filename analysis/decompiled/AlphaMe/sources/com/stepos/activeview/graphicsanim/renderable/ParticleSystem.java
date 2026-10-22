package com.stepos.activeview.graphicsanim.renderable;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import com.stepos.activeview.graphicsanim.utils.MathHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ParticleSystem extends Renderable {
    public static final String ATTR_BITMAP_PATH = "bitmapPath";
    public static final String ATTR_COLOR_LIST = "colorList";
    public static final String ATTR_PARTICLE_HEIGHT = "particleHeight";
    public static final String ATTR_PARTICLE_WIDTH = "particleWidth";
    public static final String ATTR_RANDOM_POS_X = "randomOutsetX";
    public static final String ATTR_RANDOM_POS_Y = "randomOutsetY";
    public static final String ATTR_RANDOM_SPEED_X = "randomSpeedX";
    public static final String ATTR_RANDOM_SPEED_Y = "randomSpeedY";
    public static final String ATTR_REGION_RADIUS = "regionRadius";
    public static final String ATTR_SPEED_X = "speedX";
    public static final String ATTR_SPEED_Y = "speedY";
    public static final String ATTR_TRANSMIT_CYCLE = "transmitCycle";
    public static final String ATTR_TRANSMIT_NUM = "transmitNum";
    public static final String ATTR_TYPE = "particleType";
    public static String CLASS_NAME = "ParticleSystem";
    private static final float DEFAULT_SIZE = 15.0f;
    private static final int DURATION = 2000;
    public static final String TAG = "ParticleSystem";
    public static final String TYPE_BITMAP = "image";
    public static final String TYPE_CIRCLE = "circle";
    public static final String TYPE_RECT = "rect";
    private String mBitmapPath;
    private ValueAnimator mColorAnimator;
    private RectF mDrawRect;
    private float mFloatingRegionRadius;
    private ValueAnimator mHeightAnimator;
    private boolean mIsDebugDraw;
    private long mLastTransmitTime;
    private float mParticleHeight;
    private Paint mParticlePaint;
    private String mParticleType;
    private float mParticleWidth;
    private List<Particle> mParticles;
    private List<Particle> mParticlesPool;
    private int mRandomMovementChangeInterval;
    private float mRandomOffsetX;
    private float mRandomOffsetY;
    private float mRandomSpeedX;
    private float mRandomSpeedY;
    private float mSpeedX;
    private float mSpeedY;
    private int mTransmitCycle;
    private int mTransmitNum;
    private ValueAnimator mWidthAnimator;

    public ParticleSystem(Bundle bundle) {
        super(bundle);
        this.mIsDebugDraw = false;
        this.mRandomMovementChangeInterval = 5000;
        this.mParticles = new ArrayList();
        this.mParticlesPool = new ArrayList();
        this.mDrawRect = new RectF();
    }

    private void addParticle() {
        Particle particle;
        for (int i4 = 0; i4 < this.mTransmitNum; i4++) {
            float f4 = this.mX;
            float f5 = this.mRandomOffsetX;
            float fRandomRange = MathHelper.randomRange(-f5, f5) + f4;
            float f6 = this.mY;
            float f7 = this.mRandomOffsetY;
            float fRandomRange2 = MathHelper.randomRange(-f7, f7) + f6;
            if (this.mParticlesPool.size() > 0) {
                particle = this.mParticlesPool.remove(0);
                particle.f11173x = fRandomRange;
                particle.f11174y = fRandomRange2;
            } else {
                float f8 = this.mRandomSpeedX;
                float fRandomRange3 = MathHelper.randomRange(-f8, f8);
                float f9 = this.mRandomSpeedY;
                particle = new Particle(fRandomRange, fRandomRange2, fRandomRange3, MathHelper.randomRange(-f9, f9));
            }
            this.mParticles.add(particle);
        }
    }

    private void calculateParticlePaintColor(Particle particle) {
        ValueAnimator valueAnimator = this.mColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime((long) ((particle.moveDistance / this.mFloatingRegionRadius) * 2000.0f));
            this.mParticlePaint.setColor(((Integer) this.mColorAnimator.getAnimatedValue()).intValue());
        }
    }

    private void calculateParticleSize(Particle particle) {
        float f4 = particle.moveDistance / this.mFloatingRegionRadius;
        ValueAnimator valueAnimator = this.mWidthAnimator;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime((long) (f4 * 2000.0f));
            particle.width = ((Float) this.mWidthAnimator.getAnimatedValue()).floatValue();
        } else {
            particle.width = this.mParticleWidth;
        }
        ValueAnimator valueAnimator2 = this.mHeightAnimator;
        if (valueAnimator2 == null) {
            particle.height = this.mParticleHeight;
        } else {
            valueAnimator2.setCurrentPlayTime((long) (f4 * 2000.0f));
            particle.height = ((Float) this.mHeightAnimator.getAnimatedValue()).floatValue();
        }
    }

    private float getAbsoluteDistance(float f4, float f5, float f6, float f7) {
        float fAbs = Math.abs(f4 - f6);
        return (float) Math.sqrt(Math.pow(Math.abs(f5 - f7), 2.0d) + Math.pow(fAbs, 2.0d));
    }

    @Override // com.stepos.activeview.graphicsanim.renderable.Renderable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        for (int i4 = 0; i4 < this.mParticles.size(); i4++) {
            Particle particle = this.mParticles.get(i4);
            calculateParticlePaintColor(particle);
            calculateParticleSize(particle);
            RectF rectF = this.mDrawRect;
            float f4 = particle.f11173x;
            float f5 = particle.f11174y;
            rectF.set(f4, f5, particle.width + f4, particle.height + f5);
            if (TYPE_CIRCLE.equals(this.mParticleType)) {
                canvas.drawOval(this.mDrawRect, this.mParticlePaint);
            } else if (TYPE_RECT.equals(this.mParticleType)) {
                canvas.drawRect(this.mDrawRect, this.mParticlePaint);
            } else if (TYPE_BITMAP.equals(this.mParticleType) && (bitmap = this.mBitmap) != null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.mDrawRect, this.mParticlePaint);
            }
        }
    }

    @Override // com.stepos.activeview.graphicsanim.renderable.Renderable
    public void init() {
        super.init();
        this.mTransmitCycle = 100;
        this.mTransmitNum = 1;
        this.mSpeedY = 100.0f;
        this.mSpeedX = 100.0f;
        this.mFloatingRegionRadius = 100.0f;
        this.mParticleType = TYPE_RECT;
        this.mParticleWidth = DEFAULT_SIZE;
        this.mParticleHeight = DEFAULT_SIZE;
        this.mParticlePaint = new Paint();
    }

    public void setBitmapPath(String str) {
        this.mBitmapPath = str;
    }

    public void setColors(int... iArr) {
        if (iArr.length == 1) {
            this.mParticlePaint.setColor(iArr[0]);
        } else if (iArr.length > 1) {
            ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(2000L);
            this.mColorAnimator = duration;
            duration.setEvaluator(new ArgbEvaluator());
        }
    }

    public void setFloatingRegionRadius(float f4) {
        this.mFloatingRegionRadius = f4;
    }

    public void setParticleHeight(float... fArr) {
        if (fArr.length == 1) {
            this.mParticleHeight = fArr[0];
        } else if (fArr.length > 1) {
            this.mHeightAnimator = ValueAnimator.ofFloat(fArr).setDuration(2000L);
        }
    }

    public void setParticleType(String str) {
        this.mParticleType = str;
    }

    public void setParticleWidth(float... fArr) {
        if (fArr.length == 1) {
            this.mParticleWidth = fArr[0];
        } else if (fArr.length > 1) {
            this.mWidthAnimator = ValueAnimator.ofFloat(fArr).setDuration(2000L);
        }
    }

    public void setRandomOffsetX(float f4) {
        this.mRandomOffsetX = f4;
    }

    public void setRandomOffsetY(float f4) {
        this.mRandomOffsetY = f4;
    }

    public void setRandomSpeedX(float f4) {
        this.mRandomSpeedX = f4;
    }

    public void setRandomSpeedY(float f4) {
        this.mRandomSpeedY = f4;
    }

    public void setSpeedX(float f4) {
        this.mSpeedX = f4;
    }

    public void setSpeedY(float f4) {
        this.mSpeedY = f4;
    }

    @Override // com.stepos.activeview.graphicsanim.renderable.Renderable
    public void setTranslationY(Float f4) {
        super.setTranslationY(f4);
    }

    public void setTransmitCycle(int i4) {
        this.mTransmitCycle = i4;
    }

    public void setTransmitNum(int i4) {
        this.mTransmitNum = i4;
    }

    @Override // com.stepos.activeview.graphicsanim.renderable.Renderable
    public void update(float f4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mLastTransmitTime + this.mTransmitCycle < jCurrentTimeMillis) {
            this.mLastTransmitTime = jCurrentTimeMillis;
            addParticle();
        }
        int i4 = 0;
        while (i4 < this.mParticles.size()) {
            Particle particle = this.mParticles.get(i4);
            float f5 = (particle.randomSpeedY * f4) + (this.mSpeedY * f4) + particle.f11174y;
            particle.f11174y = f5;
            float f6 = (this.mSpeedX * f4) + (particle.randomSpeedX * f4) + particle.f11173x;
            particle.f11173x = f6;
            float absoluteDistance = getAbsoluteDistance(particle.startX, particle.startY, f6, f5);
            particle.moveDistance = absoluteDistance;
            if (absoluteDistance > this.mFloatingRegionRadius) {
                this.mParticles.remove(i4);
                i4--;
                this.mParticlesPool.add(particle);
            }
            if (this.mIsDebugDraw && i4 == 0) {
                Log.i(TAG, "\n\n");
                Log.i(TAG, " ------ particle0 move ----- ");
                Log.i(TAG, "update particle0: deltaTime: " + f4);
                Log.i(TAG, "update particle0: mSpeedY: " + this.mSpeedY + "    moveUp: " + (this.mSpeedY * f4));
                Log.i(TAG, "update particle0: randomSpeedY: " + particle.randomSpeedY + "    moveY: " + (particle.randomSpeedY * f4));
                Log.i(TAG, "update particle0: randomSpeedX: " + particle.randomSpeedX + "    moveX: " + (particle.randomSpeedX * f4));
                Log.i(TAG, "update particle0: wind: " + this.mSpeedX + "    windMove: " + (this.mSpeedX * f4));
                Log.i(TAG, "update particle0: mY: " + this.mY + "    particle.y: " + particle.f11174y);
                StringBuilder sb = new StringBuilder("update particle0: mFloatingRegionRadius: ");
                sb.append(this.mFloatingRegionRadius);
                Log.i(TAG, sb.toString());
                Log.i(TAG, " ------ particle0 end ----- ");
                Log.i(TAG, "\n\n");
            }
            i4++;
        }
    }

    @Override // com.stepos.activeview.graphicsanim.renderable.Renderable
    public void updateAttributes(Bundle bundle) {
        super.updateAttributes(bundle);
        if (bundle != null) {
            this.mTransmitCycle = bundle.getInt(ATTR_TRANSMIT_CYCLE, this.mTransmitCycle);
            this.mTransmitNum = bundle.getInt(ATTR_TRANSMIT_NUM, this.mTransmitNum);
            this.mSpeedY = bundle.getFloat(ATTR_SPEED_Y, this.mSpeedY);
            this.mSpeedX = bundle.getFloat(ATTR_SPEED_X, this.mSpeedX);
            this.mRandomOffsetX = bundle.getFloat(ATTR_RANDOM_POS_X, this.mRandomOffsetX);
            this.mRandomOffsetY = bundle.getFloat(ATTR_RANDOM_POS_Y, this.mRandomOffsetY);
            this.mRandomSpeedX = bundle.getFloat(ATTR_RANDOM_SPEED_X, this.mRandomSpeedX);
            this.mRandomSpeedY = bundle.getFloat(ATTR_RANDOM_SPEED_Y, this.mRandomOffsetY);
            this.mFloatingRegionRadius = bundle.getFloat(ATTR_REGION_RADIUS, this.mFloatingRegionRadius);
            String string = bundle.getString(ATTR_TYPE, this.mParticleType);
            this.mParticleType = string;
            if (string.equals(TYPE_BITMAP)) {
                this.mBitmapPath = bundle.getString(ATTR_BITMAP_PATH);
                if (new File(this.mBitmapPath).exists() && new File(this.mBitmapPath).canRead()) {
                    this.mBitmap = BitmapFactory.decodeFile(this.mBitmapPath);
                } else {
                    Log.d(TAG, "can not found bitmap file : " + this.mBitmapPath);
                }
            }
            int[] intArray = bundle.getIntArray(ATTR_COLOR_LIST);
            if (intArray != null) {
                setColors(intArray);
            }
            float[] floatArray = bundle.getFloatArray(ATTR_PARTICLE_WIDTH);
            if (floatArray != null) {
                setParticleWidth(floatArray);
            }
            float[] floatArray2 = bundle.getFloatArray(ATTR_PARTICLE_HEIGHT);
            if (floatArray2 != null) {
                setParticleHeight(floatArray2);
            }
        }
    }
}
