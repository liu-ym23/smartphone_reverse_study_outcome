package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes28.dex */
public class d4 extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27168b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27169c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f27170a;

    static {
        f27168b = Color.argb(255, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL);
        f27169c = Color.argb(255, 21, 21, 21);
    }

    public d4(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f27170a = r101;
        r101.setAntiAlias(true);
        this.f27170a.setColor(f27168b);
    }

    public void a(int r100) {
        Paint r101 = this.f27170a;
        if (r101 == null) goto L12;
        r101.setColor(r100);
        postInvalidate();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f27170a);
    }
}
