package V1;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import f2.C0702g;

/* loaded from: classes.dex */
public abstract class z extends com.stepos.digitalwellbeing.appwidget.b {

    /* renamed from: k, reason: collision with root package name */
    protected View f5514k;

    /* renamed from: l, reason: collision with root package name */
    protected Bitmap f5515l;

    public z(Context context, A a6, ComponentName componentName) {
        super(context, a6, componentName);
    }

    protected abstract View H(Context context);

    public Bitmap I(Context context) {
        if (this.f5514k == null) {
            View viewH = H(context);
            this.f5514k = viewH;
            viewH.setDrawingCacheEnabled(true);
        }
        J();
        int i5 = this.f5514k.getLayoutParams().width;
        int i6 = this.f5514k.getLayoutParams().height;
        C0702g.b("ViewCacheWidget", "mCacheBitmap = " + this.f5515l);
        Bitmap bitmap = this.f5515l;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f5514k.measure(i5, i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        this.f5514k.layout(0, 0, size, size2);
        C0702g.y("ViewCacheWidget", "mCacheView  width = " + size + " height = " + size2);
        this.f5514k.destroyDrawingCache();
        this.f5514k.buildDrawingCache();
        Bitmap drawingCache = this.f5514k.getDrawingCache();
        if (drawingCache == null) {
            R1.a.b("ViewCacheWidget", "bitmap = null");
            return null;
        }
        C0702g.y("ViewCacheWidget", "bitmap " + size + " X " + size2 + " size = " + drawingCache.getAllocationByteCount());
        this.f5515l = C2.h.f(drawingCache, 1300000);
        StringBuilder sb = new StringBuilder();
        sb.append("mCacheBitmap size = ");
        sb.append(this.f5515l.getAllocationByteCount());
        C0702g.b("ViewCacheWidget", sb.toString());
        this.f5514k.setDrawingCacheEnabled(false);
        drawingCache.recycle();
        return this.f5515l;
    }

    protected abstract void J();

    @Override // com.stepos.digitalwellbeing.appwidget.b
    public void s(Configuration configuration) {
        super.s(configuration);
        this.f5514k = null;
    }
}
