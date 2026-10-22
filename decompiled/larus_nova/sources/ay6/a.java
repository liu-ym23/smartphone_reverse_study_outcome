package ay6;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f16752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16754c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f16753b, this.f16754c), this.f16752a);
    }

    public a(float r100, int r101, int r102) {
        this.f16752a = r100;
        this.f16753b = r101;
        this.f16754c = r102;
    }
}
