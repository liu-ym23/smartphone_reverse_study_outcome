package com.stepos.activeview.elements;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.stepos.activeview.graphicsanim.renderable.ParticleSystem;
import com.stepos.activeview.graphicsanim.renderable.Renderable;
import com.stepos.activeview.graphicsanim.widget.BaseGraphicsView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ParticleView extends BaseGraphicsView implements ActiveAnimation {
    public ParticleView(Context context) {
        this(context, null);
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void pauseAnimation() {
        super.pause();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void resumeAnimation() {
        super.resume();
    }

    @Override // com.stepos.activeview.graphicsanim.widget.BaseGraphicsView
    public void setRenderables(List<Bundle> list) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            Bundle bundle = list.get(i4);
            String string = bundle.getString(Renderable.ATTR_CLASS_NAME);
            if (string != null && string.equals(ParticleSystem.CLASS_NAME)) {
                arrayList.add(bundle);
            }
        }
        if (arrayList.size() > 0) {
            super.setRenderables(arrayList);
        }
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void startAnimation() {
        super.start();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void stopAnimation() {
        super.stop();
    }

    public ParticleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
    }

    public ParticleView(Context context, AttributeSet attributeSet, List<Bundle> list) {
        super(context, attributeSet, list);
    }
}
