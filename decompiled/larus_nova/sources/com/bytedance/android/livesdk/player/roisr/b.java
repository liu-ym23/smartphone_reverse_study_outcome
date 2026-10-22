package com.bytedance.android.livesdk.player.roisr;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.config.l8;
import com.bytedance.android.livesdk.config.y1;
import com.bytedance.android.livesdk.j2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RectF f156042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f156043b = null;

    static {
        f156042a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        f156043b = new ArrayList();
    }

    public static RectF a(int r110, JSONObject r111) {
        if (r110 == 2) goto L14;
        if (r110 == 6) goto L14;
        l8 r112 = j2.f142015a.getValue().get(Integer.valueOf(r110));
        if (r112 == null) goto L32;
        y1 r113 = r112.c();
        if (r113 == null) goto L32;
        return new RectF(r113.c(), r113.d(), r113.c() + r113.b(), r113.d() + r113.a());
    L32:
        return f156042a;
    L14:
        if (r111.has("grids") == false) goto L32;
        JSONArray r114 = r111.optJSONArray("grids");
        int r115 = 0;
        if (r114 == null) goto L18;
        int r100 = r114.length();
    L19:
        double r101 = 1.0d;
        double r102 = 0.0d;
    L20:
        if (r115 >= r100) goto L30;
        JSONObject r103 = r114.optJSONObject(r115);
        if (r103 == null) goto L24;
        double r104 = r103.optDouble("y", AudioStats.AUDIO_AMPLITUDE_NONE);
    L25:
        if (r103 == null) goto L27;
        double r105 = r103.optDouble("h", AudioStats.AUDIO_AMPLITUDE_NONE);
    L28:
        r101 = Math.min(r101, r104);
        r102 = Math.max(r101, r104 + r105);
        r115 = r115 + 1;
        goto L20
    L27:
        r105 = 0.0d;
        goto L28
    L24:
        r104 = 0.0d;
        goto L25
    L30:
        return new RectF(0.0f, (float) r101, 1.0f, (float) r102);
    L18:
        r100 = 0;
        goto L19
    }
}
