package com.bytedance.android.live.liveinteract.theme;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final String a(int r100, String r101) {
        Intrinsics.checkNotNullParameter("play", "scene");
        return r100 + "13play13" + r101;
    }

    public static boolean c(int r100, String r101) {
        Intrinsics.checkNotNullParameter("play", "scene");
        if (TextUtils.isEmpty(r101) == true) goto L14;
        Map<String, Double> r102 = b6.f65251o0.getValue();
        if (r102 == null) goto L10;
        Double r103 = r102.get(a(r100, r101));
        if (r103 == null) goto L10;
        double r104 = r103.doubleValue();
    L12:
        if (r104 >= 2.0d) goto L14;
        return true;
    L10:
        r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L14:
        return false;
    }

    public static final void b(int r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter("play", "scene");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        e<Map<String, Double>> r103 = b6.f65251o0;
        Map<String, Double> r104 = r103.getValue();
        String r105 = a(r100, r101);
        Double r106 = r104.get(r105);
        if (r106 == null) goto L8;
        double r107 = r106.doubleValue();
    L9:
        r104.put(r105, Double.valueOf(r107 + r102));
        f.d(r103, r104);
        return;
    L8:
        r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    }
}
