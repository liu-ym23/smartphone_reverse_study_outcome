package com.bytedance.android.livesdk.interactivity.like.view;

import android.graphics.Bitmap;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes9.dex */
public interface z {

    public static final class a {
        public static /* synthetic */ void a(z r110, Bitmap r111, PointF r112, PointF r113, boolean r114, float r210, f32.i r211, int r212) {
            if ((r212 & 4) == 0) goto L5;
            PointF r100 = new PointF();
        L7:
            if ((r212 & 32) == 0) goto L9;
            float r101 = 0.0f;
        L11:
            if ((r212 & 64) == 0) goto L13;
            f32.i r102 = new f32.i(0, false, false, false, false, 63);
        L14:
            r110.a(r111, r112, r100, 0, r101, r102);
            return;
        L13:
            r102 = r211;
            goto L14
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    void a(Bitmap r100, PointF r101, PointF r102, int r103, float r104, f32.i r105);

    void clear();

    void load();
}
