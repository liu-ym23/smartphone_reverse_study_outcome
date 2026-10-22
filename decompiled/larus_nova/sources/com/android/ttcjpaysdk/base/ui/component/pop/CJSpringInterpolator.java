package com.android.ttcjpaysdk.base.ui.component.pop;

import android.view.animation.Interpolator;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJSpringInterpolator;", "Landroid/view/animation/Interpolator;", "factor", "", "(F)V", "getInterpolation", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSpringInterpolator implements Interpolator {
    private float factor;

    public CJSpringInterpolator(float r100) {
        this.factor = r100;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r110) {
        boolean r100 = false;
        if (r110 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r110;
    L8:
        if (r110 != 1.0f) goto L10;
        r100 = true;
    L10:
        if (r100 == true) goto L15;
        double r102 = Math.pow(2.0d, (-10) * r110);
        double r103 = r110;
        float r111 = this.factor;
        return (float) ((r102 * Math.sin(((r103 - (((double) r111) / 4.0d)) * 6.283185307179586d) / ((double) r111))) + ((double) 1));
    L15:
        return r110;
    L5:
        r101 = false;
        goto L6
    }
}
