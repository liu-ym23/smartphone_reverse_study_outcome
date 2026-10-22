package a7a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SweepGradient;
import androidx.camera.video.AudioStats;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f2068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.utils.j f2069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.utils.j f2070j;

    public a(ReadableArray r100) {
        if (r100 != null) goto L7;
        LLog.e("ConicGradient", "native parse error array is null");
        return;
    L7:
        if (r100.size() >= 4) goto L10;
        LLog.e("ConicGradient", "native parse error, array.size must be 4  ");
        return;
    L10:
        this.f2068h = r100.getDouble(0);
        ReadableArray r101 = r100.getArray(1);
        this.f2069i = new com.lynx.tasm.behavior.ui.utils.j(r101.getDynamic(0), r101.getInt(1));
        this.f2070j = new com.lynx.tasm.behavior.ui.utils.j(r101.getDynamic(2), r101.getInt(3));
        k(r100.getArray(2), r100.getArray(3));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r100) {
        this.f2072c = Math.max(r100.width(), 1);
        this.f2073d = Math.max(r100.height(), 1);
        int[] r101 = this.f2075f;
        if (r101 != null) goto L5;
    L15:
        this.f2071b = null;
    L16:
        super.setBounds(r100);
        return;
    L5:
        if (r101.length < 2) goto L15;
        float[] r102 = this.f2076g;
        if (r102 != null) goto L10;
    L12:
        float r103 = this.f2069i.b(this.f2072c);
        float r104 = this.f2070j.b(this.f2073d);
        this.f2071b = new SweepGradient(r103, r104, this.f2075f, this.f2076g);
        double r105 = this.f2068h - 90.0d;
        if (r105 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        Matrix r106 = new Matrix();
        r106.preRotate((float) r105, r103, r104);
        this.f2071b.setLocalMatrix(r106);
        goto L16
    L10:
        if (r102.length == r101.length) goto L12;
        this.f2071b = null;
        goto L16
    }
}
