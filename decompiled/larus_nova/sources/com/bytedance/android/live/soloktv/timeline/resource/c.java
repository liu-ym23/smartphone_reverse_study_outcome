package com.bytedance.android.live.soloktv.timeline.resource;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements ojc.b {
    public c() {
        Paint r100 = new Paint();
        new Rect();
        r100.setAntiAlias(true);
        r100.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, qb1.d.f532286a, ColorProtector.parseColor("#00000000"), ColorProtector.parseColor("#80000000"), Shader.TileMode.MIRROR));
    }
}
