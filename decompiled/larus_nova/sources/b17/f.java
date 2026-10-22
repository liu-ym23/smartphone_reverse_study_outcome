package b17;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f16935k = 0;

    public f(Context r100) {
        super(r100);
    }

    @Override // b17.g, android.view.View
    public final void onDraw(Canvas r100) {
        TraceEvent.beginSection("UIFilterImageView.onDraw");
        int r101 = r100.getSaveCount();
        Path r102 = this.f16940e;
        if (r102 == null) goto L5;
        r100.clipPath(r102);
    L5:
        Drawable r103 = this.f16937b;
        if (r103 == null) goto L8;
        r103.draw(r100);
    L8:
        r100.restoreToCount(r101);
        TraceEvent.endSection("UIFilterImageView.onDraw");
    }
}
