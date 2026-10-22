package ax2;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f16613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f16614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f16615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f16616d;

    public final Canvas a() {
        Canvas r100 = this.f16613a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("canvas");
        return null;
    }

    public b() {
        Paint r100 = new Paint();
        this.f16614b = r100;
        Paint r101 = new Paint();
        this.f16615c = r101;
        this.f16616d = new c();
        r100.setStrokeWidth(1.0f);
        r100.setStyle(Paint.Style.STROKE);
        r100.setStrokeCap(Paint.Cap.ROUND);
        r101.setColor(-1);
    }
}
