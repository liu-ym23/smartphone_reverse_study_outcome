package com.baidu.platform.comapi.map.c0.f;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f33213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MapController f33214d;

    public c(MapController r100) {
        super(r100);
        this.f33212b = true;
        this.f33214d = r100;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b r110, MotionEvent r111) {
        com.baidu.platform.comapi.map.c0.a.C0664a r100 = r110.f33199b;
        com.baidu.platform.comapi.map.c0.a.C0664a r112 = r110.f33200c;
        MapStatus r101 = this.f33214d.getMapStatus();
        double r102 = r112.f33162a.f33165b - r100.f33162a.f33165b;
        double r103 = r112.f33163b.f33165b - r100.f33163b.f33165b;
        double r104 = r102 * r103;
        if (r104 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        a(r102, r101);
    L16:
        float r105 = r111.getX(1) - r111.getX(0);
        float r113 = r111.getY(1) - r111.getY(0);
        Point r106 = new Point((int) r111.getRawX(), (int) r111.getRawY());
        Point r107 = new Point((int) (r111.getRawX() + r105), (int) (r111.getRawY() + r113));
        List<v> r114 = this.f33214d.getListeners();
        if (r114 == null) goto L27;
        s r115 = this.f33214d.getMapStatusInner();
        int r108 = 0;
    L20:
        if (r108 >= r114.size()) goto L27;
        v r109 = (v) ListProtector.get(r114, r108);
        if (r109 == null) goto L26;
        if (r109.b(r106, r107, r115) == false) goto L26;
        return;
    L26:
        r108 = r108 + 1;
    L27:
        this.f33214d.setMapStatus(r101);
        if (this.f33212b == false) goto L35;
        this.f33212b = false;
        this.f33214d.getGestureMonitor().b();
        return;
    L35:
        return;
    L5:
        if (r104 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        a(r102, r101);
        goto L16
    L10:
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        a(r103, r101);
        goto L16
    L13:
        if (Math.abs(r102) <= Math.abs(r103)) goto L15;
        a(r102, r101);
        goto L16
    L15:
        a(r103, r101);
        goto L16
    }

    private void a(double r100, MapStatus r101) {
        if (this.f33213c != 0) goto L5;
        this.f33213c = System.currentTimeMillis();
    L5:
        long r102 = System.currentTimeMillis();
        this.f33213c = r102;
        if ((r102 - r102) <= 50) goto L8;
        return;
    L8:
        if (Math.abs(r100) >= 4.0d) goto L11;
        return;
    L11:
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        r101.overlooking -= 4.0d;
        return;
    L13:
        r101.overlooking += 2.0d;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b r100, Pair<com.baidu.platform.comapi.map.c0.a.d, com.baidu.platform.comapi.map.c0.a.d> r101) {
        MapStatus r102 = this.f33214d.getMapStatus();
        if (r102.bOverlookSpringback == true) goto L5;
        return;
    L5:
        if (r102.overlooking <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        r102.overlooking = AudioStats.AUDIO_AMPLITUDE_NONE;
    L8:
        this.f33214d.setMapStatusWithAnimation(r102, 200);
        return;
    L7:
        r102.overlooking = r102.minOverlooking;
        goto L8
    }
}
