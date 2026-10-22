package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class k extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f59483a;

    public final Path getMClipPath() {
        return this.f59483a;
    }

    public k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Path r101 = this.f59483a;
        if (r101 == null) goto L5;
        r100.clipPath(r101, Region.Op.DIFFERENCE);
    L5:
        super.draw(r100);
    }

    public final void setMClipPath(Path r100) {
        this.f59483a = r100;
        invalidate();
    }
}
