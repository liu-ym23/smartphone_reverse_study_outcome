package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RenderNode;

/* loaded from: classes.dex */
public class TranslateEdgeEffect extends EdgeEffectCompat {
    private final RenderNode mNode;

    public TranslateEdgeEffect(Context context) {
        super(context);
        this.mNode = new RenderNode("TranslateEdgeEffect");
    }

    @Override // o7.C5011b
    public boolean draw(Canvas canvas) {
        return false;
    }

    public boolean getTranslationShift(float[] fArr) {
        boolean zDraw = super.draw(this.mNode.beginRecording(1, 1));
        this.mNode.endRecording();
        fArr[0] = getDistance();
        return zDraw;
    }
}
