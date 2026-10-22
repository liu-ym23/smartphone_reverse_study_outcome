package com.stepos.activeview.moveline.item;

import android.view.View;
import com.stepos.activeview.elements.GLImageView;
import com.stepos.activeview.json.ApertureData;
import com.stepos.activeview.json.WaveData;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class GLImageViewTweenItem extends ViewTweenItem {
    public static final String APERTURER = "aperture";
    public static final String BLUR = "blur";
    public static final String WAVE = "wave";

    public GLImageViewTweenItem(View view) {
        super(view);
    }

    @Override // com.stepos.activeview.moveline.item.ViewTweenItem, com.stepos.activeview.moveline.item.TweenItem
    public FrameStyle buildFrameStyle() {
        return new GLImageViewFrameStyle();
    }

    @Override // com.stepos.activeview.moveline.item.ViewTweenItem, com.stepos.activeview.moveline.item.TweenItem
    public Object getPropertyValue(String str) {
        View view = this.mTarget.get();
        if (view == null) {
            return null;
        }
        if (view instanceof GLImageView) {
            str.getClass();
            switch (str) {
                case "blur":
                    return Float.valueOf(((GLImageView) view).getBlur());
                case "wave":
                    return ((GLImageView) view).getWaveData();
                case "aperture":
                    return ((GLImageView) view).getAperture();
            }
        }
        return super.getPropertyValue(str);
    }

    @Override // com.stepos.activeview.moveline.item.ViewTweenItem
    public void setTarget(View view) {
        this.mTarget = new WeakReference<>(view);
    }

    @Override // com.stepos.activeview.moveline.item.ViewTweenItem, com.stepos.activeview.moveline.item.TweenItem
    public void updateProperty(String str, Object obj, float f4) {
        GLImageView gLImageView;
        super.updateProperty(str, obj, f4);
        View view = this.mTarget.get();
        if (view != null && (view instanceof GLImageView)) {
            gLImageView = (GLImageView) view;
            str.getClass();
            switch (str) {
                case "blur":
                    gLImageView.setBlur(((Float) obj).floatValue());
                    break;
                case "wave":
                    if (!(obj instanceof Object[])) {
                        if (obj instanceof WaveData) {
                            WaveData waveData = (WaveData) obj;
                            gLImageView.setStartEndWaveData(waveData, waveData, f4);
                            break;
                        }
                    } else {
                        Object[] objArr = (Object[]) obj;
                        gLImageView.setStartEndWaveData((WaveData) objArr[0], (WaveData) objArr[1], f4);
                        break;
                    }
                    break;
                case "aperture":
                    if (!(obj instanceof Object[])) {
                        if (obj instanceof ApertureData) {
                            ApertureData apertureData = (ApertureData) obj;
                            gLImageView.setStartEndApertureData(apertureData, apertureData, f4);
                            break;
                        }
                    } else {
                        Object[] objArr2 = (Object[]) obj;
                        gLImageView.setStartEndApertureData((ApertureData) objArr2[0], (ApertureData) objArr2[1], f4);
                        break;
                    }
                    break;
            }
        }
    }
}
