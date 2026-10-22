package com.stepos.activeview.graphicsanim.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.activeview.graphicsanim.renderable.ParticleSystem;
import com.stepos.activeview.graphicsanim.renderable.Renderable;
import com.stepos.activeview.graphicsanim.utils.FrameRateCounter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BaseGraphicsView extends View {
    private boolean mAnimationPaused;
    private boolean mAnimationStarted;
    FrameRateCounter mFrameRateCounter;
    protected List<Renderable> mRenderables;

    public BaseGraphicsView(Context context) {
        this(context, null);
    }

    private void addRenderable(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString(Renderable.ATTR_CLASS_NAME)) == null) {
            return;
        }
        Renderable renderable = string.equals(Renderable.CLASS_NAME) ? new Renderable(bundle) : string.equals(ParticleSystem.CLASS_NAME) ? new ParticleSystem(bundle) : null;
        if (renderable != null) {
            this.mRenderables.add(renderable);
        }
    }

    public boolean isPaused() {
        return this.mAnimationPaused;
    }

    public boolean isStarted() {
        return this.mAnimationStarted;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mAnimationStarted) {
            float fTimeStep = this.mFrameRateCounter.timeStep();
            for (Renderable renderable : this.mRenderables) {
                if (getAlpha() <= 1.0E-6f) {
                    break;
                }
                renderable.draw(canvas);
                renderable.update(fTimeStep);
            }
            if (this.mAnimationPaused) {
                return;
            }
            invalidate();
        }
    }

    public void pause() {
        if (this.mAnimationStarted) {
            this.mAnimationPaused = true;
        }
    }

    public void resume() {
        this.mAnimationPaused = false;
        if (this.mAnimationStarted) {
            invalidate();
        }
    }

    public void setRenderables(List<Bundle> list) {
        String string;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            Bundle bundle = list.get(i4);
            if (bundle != null && (string = bundle.getString("id")) != null && !string.trim().isEmpty() && !updateRenderable(string, bundle)) {
                addRenderable(bundle);
            }
        }
    }

    public void start() {
        boolean z4 = this.mAnimationStarted;
        if (z4) {
            return;
        }
        this.mAnimationStarted = !z4;
        invalidate();
    }

    public void stop() {
        this.mAnimationStarted = false;
        this.mAnimationPaused = false;
        invalidate();
    }

    public boolean updateRenderable(String str, Bundle bundle) {
        if (bundle != null) {
            for (int i4 = 0; i4 < this.mRenderables.size(); i4++) {
                Renderable renderable = this.mRenderables.get(i4);
                if (str.equals(renderable.getID())) {
                    renderable.updateAttributes(bundle);
                    return true;
                }
            }
        }
        return false;
    }

    public BaseGraphicsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
    }

    public BaseGraphicsView(Context context, AttributeSet attributeSet, List<Bundle> list) {
        super(context, attributeSet);
        this.mRenderables = new ArrayList();
        this.mAnimationStarted = false;
        this.mAnimationPaused = false;
        this.mFrameRateCounter = new FrameRateCounter();
        setRenderables(list);
    }
}
