package a7a;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes32.dex */
public abstract class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f2077a;

    public abstract int a();

    public abstract int b();

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public void f() {
    }

    public abstract void g(int r100, int r101);

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public void h(Bitmap.Config r100) {
    }

    public void i(boolean r100) {
    }

    public void j(LynxBaseUI r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public d() {
    }
}
