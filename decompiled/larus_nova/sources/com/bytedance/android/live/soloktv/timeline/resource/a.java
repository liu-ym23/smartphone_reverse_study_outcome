package com.bytedance.android.live.soloktv.timeline.resource;

import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ojc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ed> f101505a;

    public a(long r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "colorList");
        this.f101505a = r101;
        Paint r102 = new Paint();
        new Rect();
        Paint r103 = new Paint();
        ((Number) h.M.getValue(null, h.f556082a[37])).floatValue();
        r102.setAntiAlias(true);
        r102.setDither(true);
        r101.size();
        r103.setColor(ColorProtector.parseColor("#33000000"));
    }
}
