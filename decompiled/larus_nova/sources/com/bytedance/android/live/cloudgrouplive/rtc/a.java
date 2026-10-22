package com.bytedance.android.live.cloudgrouplive.rtc;

import aj6.d;
import androidx.camera.video.AudioStats;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;
import ti6.j;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64479a;

    @Override // ti6.j
    public final /* synthetic */ boolean b(d r100, aj6.b r101) {
        ti6.a.a(r100, r101);
        return false;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selfInteractId");
        this.f64479a = r100;
    }

    @Override // ti6.j
    public final String a(int r100, int r101, List<f> r102) {
        Intrinsics.checkNotNullParameter(r102, "mixRegions");
        r102.clear();
        f r103 = new f();
        r103.a(this.f64479a);
        r103.f546162d = AudioStats.AUDIO_AMPLITUDE_NONE;
        r103.f546163e = AudioStats.AUDIO_AMPLITUDE_NONE;
        r103.f546164f = 1.0d;
        r103.f546165g = 1.0d;
        r103.f546173o = 1;
        r103.f546159a = 1;
        r103.f546170l = false;
        r102.add(r103);
        return "cloud group live";
    }
}
