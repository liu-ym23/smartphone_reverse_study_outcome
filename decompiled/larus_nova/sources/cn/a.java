package cn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f24309a;

    /* JADX INFO: renamed from: cn.a$a, reason: collision with other inner class name */
    public static final class C0465a {
    }

    static {
    }

    public final Paint getPaint() {
        return this.f24309a;
    }

    public a(Context r100) {
        super(r100);
        this.f24309a = new Paint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = (getRight() - getLeft()) / 2;
        this.f24309a.setColor(-15329245);
        float r102 = 4;
        r100.drawLine(r101, getTop() + r102, r101, getBottom() - r102, this.f24309a);
    }
}
